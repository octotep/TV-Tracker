package com.goddammitus.tvtracker.server.model.persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tvtracker.model.Account;
import com.tvtracker.model.Media;
import com.tvtracker.model.MediaList;
import com.tvtracker.model.MediaListProgress;
import com.tvtracker.model.MediaProgress;
import com.tvtracker.model.Progress;

public class DerbyDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby JDBC driver");
		}
	}

	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;

	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}

	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();

		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;

			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}

			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}

			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:/home/octotep/db/accounts.db;create=true");

		// Set autocommit to false to allow multiple the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);

		return conn;
	}

	@Override
	public Account login(final String username, final String password) {
		return executeTransaction(new Transaction<Account>() {
			@Override
			public Account execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				PreparedStatement stmt1 = null;
				ResultSet resultSet = null;
				ResultSet resultSet1 = null;

				try {
					// Get the account id
					stmt = conn.prepareStatement(
							"select id " +
							"  from accounts " +
							" where accounts.name = ? " +
							"   and accounts.password = ?"
					);
					stmt.setString(1, username);
					stmt.setString(2, password);

					int id;
					resultSet = stmt.executeQuery();
					if (resultSet.next()) {
						id = resultSet.getInt(1);
					} else {
						return null;
					}

					Account result = new Account(username, password);

					// Get the account id
					stmt1 = conn.prepareStatement(
							"select * " +
							"  from progresses " +
							" where progresses.account_id = ? "
					);
					stmt1.setInt(1, id);
					resultSet1 = stmt1.executeQuery();

					int num_rows = 0;
					while (resultSet1.next()) {
						num_rows++;
						loadProgress(result, resultSet1, 1);
					}

					if (num_rows > 0) {
						return result;
					} else {
						return null;
					}
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(resultSet1);
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(stmt1);
				}
			}


		});
	}

	private void loadProgress(Account result, ResultSet resultSet, int i) {
		try {
			System.out.println("Row: " + resultSet.getString(3) + ", " + resultSet.getInt(4) + ", " + resultSet.getInt(5) + ", " + resultSet.getInt(6));
			result.getMediaListProgress().addMedia(new Media(resultSet.getString(3)), resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(4));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkIfAccountExists(String username) {
		return false;
	}

	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();

		System.out.println("Loading initial data...");
		db.loadInitialData();

		System.out.println("Success!");
	}

	private void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement insertAccount = null;
				PreparedStatement insertProgress = null;

				try {
					insertAccount = conn.prepareStatement("insert into accounts values (?, ?, ?)");
					insertAccount.setInt(1, 0);
					insertAccount.setString(2, "forry");
					insertAccount.setString(3, "12345");
					insertAccount.addBatch();
					insertAccount.setInt(1, 1);
					insertAccount.setString(2, "decker");
					insertAccount.setString(3, "password1");
					insertAccount.addBatch();
					insertAccount.executeBatch();

					insertProgress = conn.prepareStatement("insert into progresses values (?, ?, ?, ?, ?, ?)");
					insertProgress.setInt(1, 0);
					insertProgress.setInt(2, 0);
					insertProgress.setString(3, "Samurai Flamenco");
					insertProgress.setInt(4, 1);
					insertProgress.setInt(5, 1);
					insertProgress.setInt(6, 22);
					insertProgress.addBatch();
					insertProgress.setInt(1, 1);
					insertProgress.setInt(2, 1);
					insertProgress.setString(3, "Chuck");
					insertProgress.setInt(4, 5);
					insertProgress.setInt(5, 8);
					insertProgress.setInt(6, 13);
					insertProgress.addBatch();
					insertProgress.executeBatch();

					return true;
				} finally {
					DBUtil.closeQuietly(insertProgress);
					DBUtil.closeQuietly(insertAccount);
				}
			}
		});
	}

	private void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;

				try {
					stmt1 = conn.prepareStatement(
							"create table accounts (" +
							"    id integer primary key," +
							"    name varchar(50)," +
							"    password varchar(50)" +
							")");
					stmt1.executeUpdate();

					stmt2 = conn.prepareStatement(
							"create table progresses (" +
							"    entry_id integer primary key," +
							"    account_id integer," +
							"    title varchar(50)," +
							"    current_season integer," +
							"    episodes_watched integer," +
							"    total_episodes integer" +
							")");
					stmt2.executeUpdate();

					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
				}
			}
		});
	}
}
