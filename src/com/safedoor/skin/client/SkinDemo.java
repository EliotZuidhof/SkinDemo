package com.safedoor.skin.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.DatePicker;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.Dialog.PredefinedButton;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.ProgressBar;
import com.sencha.gxt.widget.core.client.Slider;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.ButtonGroup;
import com.sencha.gxt.widget.core.client.button.SplitButton;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.button.ToolButton;
import com.sencha.gxt.widget.core.client.container.AbstractHtmlLayoutContainer.HtmlData;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.AccordionLayoutAppearance;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.container.NorthSouthContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.HtmlEditor;
import com.sencha.gxt.widget.core.client.form.Radio;
import com.sencha.gxt.widget.core.client.form.TextArea;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.menu.Menu;
import com.sencha.gxt.widget.core.client.menu.MenuItem;
import com.sencha.gxt.widget.core.client.toolbar.SeparatorToolItem;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

public class SkinDemo implements EntryPoint {

	@Override
	public void onModuleLoad() {		
		VerticalLayoutContainer vlc = new VerticalLayoutContainer();
		VerticalLayoutData vld = new VerticalLayoutData();
		vld.setMargins(new Margins(5,0,5,0));
		vlc.add(createBasicPanels(),vld);
		
		ContentPanel cp = new ContentPanel();
		cp.setHeadingText("Basic Panels");
		cp.add(vlc);
		cp.setHeight(190);
		cp.setWidth(960);
		
		VerticalLayoutContainer vlc2 = new VerticalLayoutContainer();
		vlc2.add(cp);
		vlc2.add(createForm());
		vlc2.add(createTabs());
		
		HorizontalLayoutContainer hlc = new HorizontalLayoutContainer();
		hlc.add(vlc2);
		hlc.add(createAdvancedPanels());
		
		RootPanel.get().add(hlc);
	}
	
	private Widget createAdvancedPanels(){
		//create a vertical layout
		VerticalLayoutContainer vlc = new VerticalLayoutContainer();
		
		//create BorderLayout Panel
		//and the inner panels
		ContentPanel borderPanel = new ContentPanel();
		ContentPanel northPanel = new ContentPanel();
		ContentPanel westPanel = new ContentPanel();
		ContentPanel centerPanel = new ContentPanel();
		ContentPanel eastPanel = new ContentPanel();
		ContentPanel southPanel = new ContentPanel();
		BorderLayoutContainer blp = new BorderLayoutContainer();
		
		borderPanel.setHeadingText("BorderLayout Panel");
		
		BorderLayoutData bld = new BorderLayoutData();
		bld.setCollapsible(true);
		
		northPanel.setCollapsible(true);
		westPanel.setCollapsible(true);
		eastPanel.setCollapsible(true);
		southPanel.setCollapsible(true);
		
		northPanel.setWidget(new Label("North"));
		westPanel.setWidget(new Label("West"));
		centerPanel.setWidget(new Label("Center"));
		eastPanel.setWidget(new Label("East"));
		southPanel.setWidget(new Label("South"));
		
		blp.setNorthWidget(northPanel,bld);
		blp.setWestWidget(westPanel,bld);
		blp.setCenterWidget(centerPanel);
		blp.setEastWidget(eastPanel,bld);
		blp.setSouthWidget(southPanel,bld);
		
		borderPanel.setWidget(blp);
		borderPanel.setHeight(300);
		borderPanel.setWidth(500);
		
		vlc.add(borderPanel);
		
		//create the grid panel
		ContentPanel gridPanel = new ContentPanel();
		gridPanel.setHeadingText("Grid Panel");
		gridPanel.setHeight(200);
		gridPanel.setWidth(500);
		
		LiveDataGrid grid = new LiveDataGrid();
		gridPanel.setWidget(grid.asWidget());
		
		vlc.add(gridPanel);
		
		//create accordion panel
		ContentPanel accordion = new ContentPanel();
		accordion.setHeadingText("Accordion Panel");
		accordion.setHeight(200);
		accordion.setWidth(500);
		
		AccordionLayoutAppearance appearance = GWT.<AccordionLayoutAppearance> create(AccordionLayoutAppearance.class);
		AccordionLayoutContainer alc = new AccordionLayoutContainer();
		accordion.add(alc);
		
		//create the tree
		CustomerTree tree = new CustomerTree();
		for(int i=0;i<100;i++){
			tree.addCustomer("Customer "+i);	
		}
		
		//add panels to the accordion tree
		ContentPanel cp = new ContentPanel(appearance);
		cp.setHeadingText("Tree Panel");
		cp.setWidget(tree.asWidget());
		alc.add(cp);
		alc.setActiveWidget(cp);
		
		cp = new ContentPanel(appearance);
		cp.setHeadingText("Panel 2");
		cp.setWidget(new Label("Some Content"));
		alc.add(cp);
		
		cp = new ContentPanel(appearance);
		cp.setHeadingText("Panel 3");
		cp.setWidget(new Label("Some Content"));
		alc.add(cp);
		
		vlc.add(accordion);
		
		//Create the ProgressBar/Slider Panel
		ContentPanel progress = new ContentPanel();
		progress.setHeadingText("ProgressBar/Slider Panel");
		progress.setHeight(200);
		progress.setWidth(500);
		
		VerticalPanel vp = new VerticalPanel();
		
		final ProgressBar pb = new ProgressBar();
		//Make the progress bar continually run
		Timer timer = new Timer(){
			int count = 0;
			@Override
			public void run() {
				count = (count+5)%100;
				pb.updateProgress(count/100.0, "{0}%");
				this.schedule(1000);
			}
		};
		timer.run();
		
		Slider vSlide = new Slider(true);
		Slider hSlide = new Slider();
		vSlide.setHeight(100);
		vSlide.setIncrement(1);
		hSlide.setIncrement(1);
		
		vp.add(pb);
		vp.add(hSlide);
		vp.add(vSlide);
		
		progress.setWidget(vp);
		vlc.add(progress);
		
		
		return vlc;
	}
	
	
	//create the tab panel
	private Widget createTabs(){
		HorizontalPanel hp = new HorizontalPanel();
		
		FormPanel panel = new FormPanel();
		panel.setWidth(780);
		panel.setHeight(190);
		
		TabPanel tp = new TabPanel();
		panel.setWidget(tp);
		tp.add(new Label("Tab Content 1"),new TabItemConfig("Tab 1",true));
		tp.add(new Label("Tab Content 2"),new TabItemConfig("Tab 2",true));
		tp.add(new Label("Tab Content 3"),new TabItemConfig("Tab 3",true));
		tp.add(new Label("Tab Content 4"),new TabItemConfig("Tab 4",true));
		
		DatePicker dp = new DatePicker();
		
		hp.add(panel);
		hp.add(dp);
		return hp;
	}
	
	
	//Create the form widget
	private Widget createForm(){
		FramedPanel fp = new FramedPanel();
		fp.setHeadingText("Form Widgets");
		fp.setCollapsible(true);
		fp.setWidth(960);
		fp.setHeight(500);
		
		//Add predefined toolbar buttons
		fp.addTool(new ToolButton(ToolButton.CLOSE));
		fp.addTool(new ToolButton(ToolButton.DOUBLEDOWN));
		fp.addTool(new ToolButton(ToolButton.EXPAND));
		fp.addTool(new ToolButton(ToolButton.GEAR));
		fp.addTool(new ToolButton(ToolButton.LEFT));
		fp.addTool(new ToolButton(ToolButton.MAXIMIZE));
		fp.addTool(new ToolButton(ToolButton.MINIMIZE));
		fp.addTool(new ToolButton(ToolButton.MINUS));
		fp.addTool(new ToolButton(ToolButton.PLUS));
		fp.addTool(new ToolButton(ToolButton.PRINT));
		fp.addTool(new ToolButton(ToolButton.QUESTION));
		fp.addTool(new ToolButton(ToolButton.REFRESH));
		fp.addTool(new ToolButton(ToolButton.RESTORE));
		fp.addTool(new ToolButton(ToolButton.SEARCH));
		fp.addTool(new ToolButton(ToolButton.SAVE));
		
		HtmlLayoutContainer con = new HtmlLayoutContainer(getTableMarkup());
		 
	    TextField text = new TextField();
	    text.setWidth(350);
		con.add(new FieldLabel(text, "Text Field"), new HtmlData(".tf"));
		
		ComboBox combo = new ComboBox(null, null);
		combo.setWidth(350);
		con.add(new FieldLabel(combo,"Combo Box"),new HtmlData(".cb"));
		
		DateField dp = new DateField();
		dp.setWidth(350);
		con.add(new FieldLabel(dp,"Date"),new HtmlData(".date"));
		
		TextArea ta = new TextArea();
		ta.setWidth(350);
		ta.setHeight(50);
		con.add(new FieldLabel(ta,"Text Area"),new HtmlData(".ta"));
		
		CheckBox check1 = new CheckBox();
		CheckBox check2 = new CheckBox();
		CheckBox check3 = new CheckBox();
		check1.setBoxLabel("Option 1");
		check2.setBoxLabel("Option 2");
		check3.setBoxLabel("Option 3");
		
		HorizontalPanel hp = new HorizontalPanel();
		hp.add(check1);
		hp.add(check2);
		hp.add(check3);
		con.add(new FieldLabel(hp,"Check Boxes"),new HtmlData(".check"));
		
		Radio radio1 = new Radio();
		Radio radio2 = new Radio();
		Radio radio3 = new Radio();
		radio1.setBoxLabel("Radio 1");
		radio2.setBoxLabel("Radio 2");
		radio3.setBoxLabel("Radio 3");
		radio1.setValue(true);
		
		ToggleGroup toggle = new ToggleGroup();
		toggle.add(radio1);
		toggle.add(radio2);
		toggle.add(radio3);
		
		hp = new HorizontalPanel();
		hp.add(radio1);
		hp.add(radio2);
		hp.add(radio3);
		
		con.add(new FieldLabel(hp,"Radio Buttons"),new HtmlData(".radio"));
		
		HtmlEditor a = new HtmlEditor();
	    a.setWidth(800);
	    a.setHeight(300);
	    con.add(new FieldLabel(a, "Comment"), new HtmlData(".editor"));
		
		fp.add(con);
		return fp;
	}
	
	
	private native String getTableMarkup() /*-{
    return [ '<table width=100% cellpadding=0 cellspacing=0>',
        '<tr><td class=tf width=50%></td><td class=cb width=50%></td></tr>',
        '<tr><td class=date></td></tr>',
        '<tr><td class=ta></td></tr>',
        '<tr><td class=check></td><td class=radio></td></tr>', 
        '<tr><td class=editor colspan=2></td></tr>',
        '</table>'
        ].join("");
        }-*/;
	
	/**
	 * Create the top layer of panels
	 * for the skin demo
	 * @return the panels
	 */
	private Widget createBasicPanels(){
		HorizontalLayoutContainer hlc = new HorizontalLayoutContainer();
		
		//Create layout data
		HorizontalLayoutData hld = new HorizontalLayoutData();
		hld.setMargins(new Margins(0,0,0,5));
		VerticalLayoutData vld = new VerticalLayoutData();
		vld.setMargins(new Margins(0,0,5,0));
		
		//Basic Panel
		ContentPanel panel = new ContentPanel();
		panel.setHeadingText("Basic Panel");
		panel.setWidth(150);
		panel.setHeight(75);
		panel.add(new Label("Some Content"));
		
		//Collapsible panel
		ContentPanel collapsible = new ContentPanel();
		collapsible.setHeadingText("Collapsed Panel");
		collapsible.setWidth(150);
		collapsible.setHeight(75);
		collapsible.add(new Label("Some Content"));
		collapsible.setCollapsible(true);
		
		//Add both panels to a vertical layout
		VerticalLayoutContainer v = new VerticalLayoutContainer();
		v.add(panel,vld);
		v.add(collapsible,vld);
		hlc.add(v,hld);
		
		//masked panel
		ContentPanel mask = new ContentPanel();
		mask.setHeadingText("Masked Panel");
		mask.setWidget(new Label("Some Content"));
		mask.mask("Loading...");
		mask.setWidth(150);
		mask.setHeight(120);
		
		hlc.add(mask,hld);
		
		//framed panel
		FramedPanel frame = new FramedPanel();
		frame.setHeadingText("Framed Panel");
		frame.setWidth(175);
		frame.setHeight(75);
		frame.setWidget(new Label("Some Content"));
		
		//collapsible framed panel
		FramedPanel cFrame = new FramedPanel();
		cFrame.setHeadingText("Copllapsed Frame Panel");
		cFrame.setCollapsible(true);
		cFrame.setWidth(175);
		cFrame.setHeight(75);
		cFrame.setWidget(new Label("Some Content"));
		
		//add the framed panels to a vertical layout
		VerticalLayoutContainer v1 = new VerticalLayoutContainer();
		v1.add(frame,vld);
		v1.add(cFrame,vld);
		hlc.add(v1,hld);
		
		//create a window
		Window window = new Window();
		window.setWidth(150);
		window.setHeight(150);
		window.setHeadingText("Window");
		window.setDraggable(false);
		window.setResizable(false);
		window.setClosable(false);
		window.setCollapsible(true);
		
		//add a layout and dialog functionality
		NorthSouthContainer nsc = new NorthSouthContainer();
		ToolBar toolbar = new ToolBar();
		TextButton toolButton = new TextButton("Toolbar");
		TextButton submit = new TextButton("Submit");
		toolbar.add(toolButton);
		submit.addSelectHandler(new SelectHandler(){
			@Override
			public void onSelect(SelectEvent event) {
				Dialog dialog = new Dialog();
				dialog.setPredefinedButtons(PredefinedButton.YES,PredefinedButton.NO);
				dialog.setHeadingText("Confirm");
				dialog.setWidget(new Label("Are you sure?"));
				dialog.setHideOnButtonClick(true);
				dialog.setModal(true);
				dialog.show();
			}
		});
		Label confirm = new Label("Click Submit for Confirmation Message");
		
		//add all window components
		nsc.setNorthWidget(toolbar);
		nsc.setSouthWidget(confirm);
		window.addButton(submit);
		window.setWidget(nsc);
		hlc.add(window,hld);
		
		//create the toolbars panel
		ContentPanel toolbars = new ContentPanel();
		toolbars.setCollapsible(true);
		toolbars.setHeadingText("Basic Panel With Toolbars");
		toolbars.setWidth(300);
		toolbars.setHeight(150);
		
		ToolBar tbNorth = new ToolBar();
		ToolBar tbWest = new ToolBar();
		ToolBar tbEast = new ToolBar();
		ToolBar tbSouth = new ToolBar();

		SplitButton menu = new SplitButton("Split Button");
		menu.setMenu(createMenu());
		tbNorth.add(menu);
		tbNorth.add(new TextButton("Menu 2"));
		tbWest.add(new TextButton("Left"));
		tbEast.add(new TextButton("Right"));
		tbSouth.add(new Label("Toolbar"));
		tbSouth.add(new SeparatorToolItem());
		tbSouth.add(new TextButton("Button"));
		
		BorderLayoutContainer blc1 = new BorderLayoutContainer();
		BorderLayoutData bld = new BorderLayoutData();
		bld.setSize(30);
		
		toolbars.setWidget(blc1);
		blc1.setNorthWidget(tbNorth,bld);
		blc1.setWestWidget(tbWest);
		blc1.setEastWidget(tbEast);
		blc1.setSouthWidget(tbSouth,bld);
		hlc.add(toolbars,hld);
		
		return hlc;
	}

	private Menu createMenu() {
		Menu menu = new Menu();
		menu.add(new MenuItem("Item 1"));
		menu.add(new MenuItem("Item 2"));
		menu.add(new MenuItem("Item 3"));
		return menu;
	}

}
