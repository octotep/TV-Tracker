package com.goddammitus.tvtracker.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.LayoutPanel;

public class ExampleView extends Composite {
	public ExampleView() {
		LayoutPanel panel = new LayoutPanel();
		initWidget(panel);
		
		InlineLabel label = new InlineLabel("Hello, world");
		panel.add(label);
		panel.setWidgetLeftWidth(label, 40.0, Unit.PX, 140.0, Unit.PX);
		panel.setWidgetTopHeight(label, 40.0, Unit.PX, 28.0, Unit.PX);
	}
}
