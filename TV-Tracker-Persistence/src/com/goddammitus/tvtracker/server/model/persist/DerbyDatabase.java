package com.goddammitus.tvtracker.server.model.persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.tvtracker.model.Account;
import com.tvtracker.model.Media;
import com.tvtracker.model.MediaList;
import com.tvtracker.model.MediaListProgress;
import com.tvtracker.model.MediaProgress;
import com.tvtracker.model.Progress;

import edu.ycp.cs320.booksdb.persist.DBUtil;
import edu.ycp.cs320.booksdb.persist.DerbyDatabase.Transaction;

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
		Connection conn = DriverManager.getConnection("jdbc:derby:books.db;create=true");

		// Set autocommit to false to allow multiple the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);

		return conn;
	}

	@Override
	public Account login(String username, String password) {

	}

	@Override
	public boolean checkIfAccountExists(String username) {

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
		ArrayList<Account> accountList;
		Account dummyAccount;
		Account otherDummyAccount;
		accountList = new ArrayList<Account>();

		// Dummy show data to test list with
		Media testMedia = new Media("Samurai Flamenco");
		Map<Media, Progress> testMap = new HashMap<Media, Progress>();
		testMap.put(testMedia, new Progress(1, 1, 22));
		MediaList testMediaList = new MediaList();
		testMediaList.addMedia(testMedia);
		MediaProgress testMediaProgress = new MediaProgress(testMap);
		MediaListProgress testMediaListProgress = new MediaListProgress(testMediaList, testMediaProgress);

		dummyAccount =  new Account("Forry", "12345");
		accountList.add(dummyAccount);
		dummyAccount.setMediaListProgress(testMediaListProgress);

		// Dummy show data to test list with
		Media testMedia2 = new Media("Chuck");
		Map<Media, Progress> testMap2 = new HashMap<Media, Progress>();
		testMap2.put(testMedia2, new Progress(5, 8, 13));
		MediaList testMediaList2 = new MediaList();
		testMediaList2.addMedia(testMedia2);
		MediaProgress testMediaProgress2 = new MediaProgress(testMap2);
		MediaListProgress testMediaListProgress2 = new MediaListProgress(testMediaList2, testMediaProgress2);

		otherDummyAccount = new Account("Decker", "password1");
		accountList.add(otherDummyAccount);
		otherDummyAccount.setMediaListProgress(testMediaListProgress2);


	}

	private void createTables() {
		// TODO Auto-generated method stub
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				PreparedStatement stmt4 = null;
				PreparedStatement stmt5 = null;
				PreparedStatement stmt6 = null;

				try {
					stmt1 = conn.prepareStatement(
							"create table account (" +
							"    id integer primary key," +
							"    name varchar(50)," +
							"    password varchar(50)," +
							"    medialistprogress_id integer" +
							")");
					stmt1.executeUpdate();

					stmt2 = conn.prepareStatement(
							"create table medialistprogress (" +
							"    id integer primary key," +
							"    mediaprogress_id integer," +
							"    medialist_id integer" +
							")");
					stmt2.executeUpdate();

					stmt3 = conn.prepareStatement(
							"create table mediaprogress (" +
							"    id integer primary key," +
							"    media_id integer," +
							"    progress_id integer" +
							")");
					stmt3.executeUpdate();

					stmt4 = conn.prepareStatement(
							"create table media (" +
							"    id integer primary key," +
							"    name varchar(50)" +
							")");
					stmt4.executeUpdate();

					stmt5 = conn.prepareStatement(
							"create table media (" +
							"    id integer primary key," +
							"    seen_in_season integer," +
							"    current_season integer," +
							"    episodes_in_season integer" +
							")");
					stmt5.executeUpdate();

					stmt5 = conn.prepareStatement(
							"create table media (" +
							"    id integer primary key," +
							"    seen_in_season integer," +
							"    current_season integer," +
							"    episodes_in_season integer" +
							")");
					stmt5.executeUpdate();

					stmt6 = conn.prepareStatement(
							"create table medialist (" +
							"    id integer primary key," +
							"    media_id integer" +
							")");
					stmt6.executeUpdate();

					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
				}
			}
		});
	}
}
