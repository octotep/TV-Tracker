package com.goddammitus.tvtracker.client;
import java_cup.internal_error;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.tvtracker.model.Account;
import com.tvtracker.model.Login;
import com.tvtracker.model.Media;
import com.tvtracker.model.MediaListProgress;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.FlexTable;

public class AddMediaView extends Composite implements IsWidget {
	private Account user;
	private TextBox txtName;
	private TextBox txtCurrentSeason;
	private TextBox txtEpisodesWatched;
	private TextBox txtTotalEpisodes;


	public AddMediaView(Account user) {
		this.user = user;
		String headerMessage = "Adding media for " + user.getName();

		LayoutPanel panel = new LayoutPanel();
		initWidget(panel);

		Label lblWelcome = new Label(headerMessage);
		panel.add(lblWelcome);
		panel.setWidgetLeftWidth(lblWelcome, 19.0, Unit.PX, 250.0, Unit.PX);
		panel.setWidgetTopHeight(lblWelcome, 12.0, Unit.PX, 18.0, Unit.PX);

		Label lblName = new Label("Name:");
		panel.add(lblName);
		panel.setWidgetLeftWidth(lblName, 35.0, Unit.PX, 40.0, Unit.PX);
		panel.setWidgetTopHeight(lblName, 55.0, Unit.PX, 15.0, Unit.PX);

		Label lblCurrentSeason = new Label("Current Season:");
		panel.add(lblCurrentSeason);
		panel.setWidgetLeftWidth(lblCurrentSeason, 35.0, Unit.PX, 118.0, Unit.PX);
		panel.setWidgetTopHeight(lblCurrentSeason, 88.0, Unit.PX, 15.0, Unit.PX);

		Label lblCurrentEpisodes = new Label("Current episodes:");
		panel.add(lblCurrentEpisodes);
		panel.setWidgetLeftWidth(lblCurrentEpisodes, 41.0, Unit.PX, 112.0, Unit.PX);
		panel.setWidgetTopHeight(lblCurrentEpisodes, 142.0, Unit.PX, 15.0, Unit.PX);

		Label lblNewLatotalEpisodesbel = new Label("Total Episodes:");
		panel.add(lblNewLatotalEpisodesbel);
		panel.setWidgetLeftWidth(lblNewLatotalEpisodesbel, 39.0, Unit.PX, 114.0, Unit.PX);
		panel.setWidgetTopHeight(lblNewLatotalEpisodesbel, 185.0, Unit.PX, 15.0, Unit.PX);

		txtName = new TextBox();
		panel.add(txtName);
		panel.setWidgetLeftWidth(txtName, 168.0, Unit.PX, 159.0, Unit.PX);
		panel.setWidgetTopHeight(txtName, 39.0, Unit.PX, 31.0, Unit.PX);

		txtCurrentSeason = new TextBox();
		panel.add(txtCurrentSeason);
		panel.setWidgetLeftWidth(txtCurrentSeason, 168.0, Unit.PX, 159.0, Unit.PX);
		panel.setWidgetTopHeight(txtCurrentSeason, 88.0, Unit.PX, 31.0, Unit.PX);

		txtEpisodesWatched = new TextBox();
		panel.add(txtEpisodesWatched);
		panel.setWidgetLeftWidth(txtEpisodesWatched, 168.0, Unit.PX, 159.0, Unit.PX);
		panel.setWidgetTopHeight(txtEpisodesWatched, 126.0, Unit.PX, 31.0, Unit.PX);

		txtTotalEpisodes = new TextBox();
		panel.add(txtTotalEpisodes);
		panel.setWidgetLeftWidth(txtTotalEpisodes, 168.0, Unit.PX, 159.0, Unit.PX);
		panel.setWidgetTopHeight(txtTotalEpisodes, 169.0, Unit.PX, 31.0, Unit.PX);

		Button btnSubmit = new Button("Submit");
		btnSubmit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				handleSubmit();
			}
		});
		panel.add(btnSubmit);
		panel.setWidgetLeftWidth(btnSubmit, 174.0, Unit.PX, 81.0, Unit.PX);
		panel.setWidgetTopHeight(btnSubmit, 231.0, Unit.PX, 27.0, Unit.PX);
	}

	public void addMediaToAccount(int account_id, String name, int currentSeason, int episodesWatched, int totalEpisodes) {
		this.user.getMediaListProgress().addMedia(new Media(name), episodesWatched, totalEpisodes, currentSeason);
	}

	public int getAccountId() {
		return this.user.getId();
	}

	public void handleSubmit() {
		RPC.loginService.addMedia(this.user.getId(), txtName.getValue(), Integer.parseInt(txtCurrentSeason.getValue()), Integer.parseInt(txtEpisodesWatched.getValue()), Integer.parseInt(txtTotalEpisodes.getValue()), new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Error

			}

			@Override
			public void onSuccess(Boolean result) {
				if (result == true) {
					addMediaToAccount(getAccountId(), txtName.getValue(), Integer.parseInt(txtCurrentSeason.getValue()), Integer.parseInt(txtEpisodesWatched.getValue()), Integer.parseInt(txtTotalEpisodes.getValue()));
					TV_Tracker.setView(new HomePageView(user));
				} else {
					// TODO: error
				}
			}

		});
	}
}
