package com.sproutlife.panel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.sproutlife.GameController;
import com.sproutlife.Settings;

import javax.swing.JSlider;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;

public class ControlPanel extends JPanel {
	
	PanelController panelController;
	private JSlider zoomSlider;
	private JRadioButton rdbtnFriendly;
	private JRadioButton rdbtnCompetitive;
	private JButton startPauseButton;
	private JButton stepButton;
	private JSlider speedSlider;
	private JButton resetButton;
	private JRadioButton rdbtnCooperative;
	
	public ControlPanel(PanelController panelController) {
		setMinimumSize(new Dimension(220, 0));	
		setPreferredSize(new Dimension(260, 500));
		        
		this.panelController = panelController;
		buildPanel();
	}
	/**
	 * Create the panel.
	 */
	public void buildPanel() {		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {10, 0, 100, 100, 80, 10};
		gridBagLayout.rowHeights = new int[]{20, 0, 15, 0, 0, 15, 0, 15, 20, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();		
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 23};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0};
		panel_1.setLayout(gbl_panel_1);
		
		startPauseButton = new JButton("Start");
		startPauseButton.setMaximumSize(new Dimension(200, 23));
		startPauseButton.setPreferredSize(new Dimension(100, 23));
		GridBagConstraints gbc_startPauseButton = new GridBagConstraints();
		gbc_startPauseButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_startPauseButton.insets = new Insets(0, 0, 5, 5);
		gbc_startPauseButton.gridx = 0;
		gbc_startPauseButton.gridy = 0;
		panel_1.add(startPauseButton, gbc_startPauseButton);
		
		resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    }
		});
		GridBagConstraints gbc_resetButton = new GridBagConstraints();
		gbc_resetButton.insets = new Insets(0, 0, 5, 0);
		gbc_resetButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_resetButton.gridx = 1;
		gbc_resetButton.gridy = 0;
		panel_1.add(resetButton, gbc_resetButton);
		resetButton.setPreferredSize(new Dimension(100, 23));
		
		stepButton = new JButton("Step");
		GridBagConstraints gbc_stepButton = new GridBagConstraints();
		gbc_stepButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_stepButton.insets = new Insets(0, 0, 0, 5);
		gbc_stepButton.gridx = 0;
		gbc_stepButton.gridy = 1;
		panel_1.add(stepButton, gbc_stepButton);
		stepButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    }
		});
		stepButton.setPreferredSize(new Dimension(100, 23));
		
		JLabel lblZoom = new JLabel("Zoom");
		lblZoom.setMinimumSize(new Dimension(100, 14));
		GridBagConstraints gbc_lblZoom = new GridBagConstraints();
		gbc_lblZoom.anchor = GridBagConstraints.WEST;
		gbc_lblZoom.insets = new Insets(0, 0, 5, 5);
		gbc_lblZoom.gridx = 2;
		gbc_lblZoom.gridy = 3;
		add(lblZoom, gbc_lblZoom);
		
		zoomSlider = new JSlider();
		zoomSlider.setMinorTickSpacing(1);
		zoomSlider.setMinimum(-5);
		zoomSlider.setValue(-2);
		zoomSlider.setMaximum(5);
		GridBagConstraints gbc_zoomSlider = new GridBagConstraints();
		gbc_zoomSlider.fill = GridBagConstraints.HORIZONTAL;
		gbc_zoomSlider.gridwidth = 2;
		gbc_zoomSlider.insets = new Insets(0, 0, 5, 5);
		gbc_zoomSlider.gridx = 3;
		gbc_zoomSlider.gridy = 3;
		add(zoomSlider, gbc_zoomSlider);
		
		JSpinner childOneEnergySpinner = new JSpinner();
		childOneEnergySpinner.setPreferredSize(new Dimension(50, 20));
		childOneEnergySpinner.setValue(getInt(Settings.CHILD_ONE_ENERGY));
		childOneEnergySpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				set(Settings.CHILD_ONE_ENERGY,((JSpinner) arg0.getSource()).getValue());
			}
		});
		
		JLabel speedLabel = new JLabel("Speed");
		GridBagConstraints gbc_speedLabel = new GridBagConstraints();
		gbc_speedLabel.anchor = GridBagConstraints.WEST;
		gbc_speedLabel.insets = new Insets(0, 0, 5, 5);
		gbc_speedLabel.gridx = 2;
		gbc_speedLabel.gridy = 4;
		add(speedLabel, gbc_speedLabel);
		
		speedSlider = new JSlider();		
		speedSlider.setMinimum(-5);
		speedSlider.setMaximum(5);
		speedSlider.setValue(-2);
		GridBagConstraints gbc_speedSlider = new GridBagConstraints();
		gbc_speedSlider.fill = GridBagConstraints.HORIZONTAL;
		gbc_speedSlider.gridwidth = 2;
		gbc_speedSlider.insets = new Insets(0, 0, 5, 5);
		gbc_speedSlider.gridx = 3;
		gbc_speedSlider.gridy = 4;
		add(speedSlider, gbc_speedSlider);				
		
		JPanel lifeModePanel = new JPanel();
		GridBagConstraints gbc_lifeModePanel = new GridBagConstraints();
		gbc_lifeModePanel.gridwidth = 3;
		gbc_lifeModePanel.anchor = GridBagConstraints.NORTH;
		gbc_lifeModePanel.insets = new Insets(0, 0, 5, 5);
		gbc_lifeModePanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lifeModePanel.gridx = 2;
		gbc_lifeModePanel.gridy = 6;
		add(lifeModePanel, gbc_lifeModePanel);
		GridBagLayout gbl_lifeModePanel = new GridBagLayout();
		gbl_lifeModePanel.columnWidths = new int[]{66, 40, 40};
		gbl_lifeModePanel.rowHeights = new int[]{23, 0};
		gbl_lifeModePanel.columnWeights = new double[]{1.0, 1.0, 1.0};
		gbl_lifeModePanel.rowWeights = new double[]{0.0, 0.0};
		lifeModePanel.setLayout(gbl_lifeModePanel);
		
		JLabel lblLifeMode = new JLabel("Life Mode");
		GridBagConstraints gbc_lblLifeMode = new GridBagConstraints();
		gbc_lblLifeMode.anchor = GridBagConstraints.WEST;
		gbc_lblLifeMode.insets = new Insets(0, 0, 5, 5);
		gbc_lblLifeMode.gridx = 0;
		gbc_lblLifeMode.gridy = 0;
		lifeModePanel.add(lblLifeMode, gbc_lblLifeMode);
		
		ButtonGroup lifeModeButtonGroup = new ButtonGroup();
		
		rdbtnCooperative = new JRadioButton("Cooperative");
		rdbtnCooperative.setToolTipText("<html>Tends towards order.<br>Cells don't differentiate<br> between their own organism<br> and others</html>");
		GridBagConstraints gbc_rdbtnCooperative = new GridBagConstraints();
		gbc_rdbtnCooperative.anchor = GridBagConstraints.WEST;
		gbc_rdbtnCooperative.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCooperative.gridx = 1;
		gbc_rdbtnCooperative.gridy = 0;
		lifeModePanel.add(rdbtnCooperative, gbc_rdbtnCooperative);
		lifeModeButtonGroup.add(rdbtnCooperative);
		
		rdbtnFriendly = new JRadioButton("Friendly");
		rdbtnFriendly.setToolTipText("<html>A bit more chaotic. Cells know<br> which one is thier organism,<br> but tolerate some contact<br> from other organisms</html>");
		rdbtnFriendly.setAlignmentX(Component.RIGHT_ALIGNMENT);
		GridBagConstraints gbc_rdbtnFriendly = new GridBagConstraints();
		gbc_rdbtnFriendly.anchor = GridBagConstraints.WEST;
		gbc_rdbtnFriendly.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnFriendly.gridx = 2;
		gbc_rdbtnFriendly.gridy = 0;
		lifeModePanel.add(rdbtnFriendly, gbc_rdbtnFriendly);
		lifeModeButtonGroup.add(rdbtnFriendly);
		
		rdbtnCompetitive = new JRadioButton("Competitive");
		rdbtnCompetitive.setToolTipText("<html>Most chaotic. Cells know which<br> cells are in their organism and<br>its family, and they will kill<br> adjacent cells from \"smaller\" <br>organisms with fewer cells<br> at the time</html>");
		rdbtnCompetitive.setAlignmentX(Component.RIGHT_ALIGNMENT);
		GridBagConstraints gbc_rdbtnCompetitive = new GridBagConstraints();
		gbc_rdbtnCompetitive.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnCompetitive.anchor = GridBagConstraints.WEST;
		gbc_rdbtnCompetitive.gridx = 1;
		gbc_rdbtnCompetitive.gridy = 1;
		lifeModePanel.add(rdbtnCompetitive, gbc_rdbtnCompetitive);
		lifeModeButtonGroup.add(rdbtnCompetitive);				
		
		JLabel childOneEnergyLabel = new JLabel("Child 1 energy");
		GridBagConstraints gbc_childOneEnergyLabel = new GridBagConstraints();
		gbc_childOneEnergyLabel.gridwidth = 2;
		gbc_childOneEnergyLabel.anchor = GridBagConstraints.WEST;
		gbc_childOneEnergyLabel.insets = new Insets(0, 0, 5, 5);
		gbc_childOneEnergyLabel.gridx = 2;
		gbc_childOneEnergyLabel.gridy = 8;
		add(childOneEnergyLabel, gbc_childOneEnergyLabel);
		GridBagConstraints gbc_childOneEnergySpinner = new GridBagConstraints();
		gbc_childOneEnergySpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_childOneEnergySpinner.anchor = GridBagConstraints.NORTHEAST;
		gbc_childOneEnergySpinner.insets = new Insets(0, 0, 5, 5);
		gbc_childOneEnergySpinner.gridx = 4;
		gbc_childOneEnergySpinner.gridy = 8;
		add(childOneEnergySpinner, gbc_childOneEnergySpinner);
		
		JSpinner childTwoEnergySpinner = new JSpinner();
		childTwoEnergySpinner.setPreferredSize(new Dimension(50, 20));
		childTwoEnergySpinner.setValue(getInt(Settings.CHILD_TWO_ENERGY));
		childTwoEnergySpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				set(Settings.CHILD_TWO_ENERGY,((JSpinner) arg0.getSource()).getValue());
			}
		});
		
		JLabel childTwoEnergyLabel = new JLabel("Child 2 energy");
		GridBagConstraints gbc_childTwoEnergyLabel = new GridBagConstraints();
		gbc_childTwoEnergyLabel.gridwidth = 2;
		gbc_childTwoEnergyLabel.anchor = GridBagConstraints.WEST;
		gbc_childTwoEnergyLabel.insets = new Insets(0, 0, 5, 5);
		gbc_childTwoEnergyLabel.gridx = 2;
		gbc_childTwoEnergyLabel.gridy = 9;
		add(childTwoEnergyLabel, gbc_childTwoEnergyLabel);
		GridBagConstraints gbc_childTwoEnergySpinner = new GridBagConstraints();
		gbc_childTwoEnergySpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_childTwoEnergySpinner.anchor = GridBagConstraints.NORTHEAST;
		gbc_childTwoEnergySpinner.insets = new Insets(0, 0, 5, 5);
		gbc_childTwoEnergySpinner.gridx = 4;
		gbc_childTwoEnergySpinner.gridy = 9;
		add(childTwoEnergySpinner, gbc_childTwoEnergySpinner);
		
		JSpinner childThreeEnergySpinner = new JSpinner();
		childThreeEnergySpinner.setPreferredSize(new Dimension(50, 20));
		childThreeEnergySpinner.setValue(getInt(Settings.CHILD_THREE_ENERGY));
		childThreeEnergySpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				set(Settings.CHILD_THREE_ENERGY,((JSpinner) arg0.getSource()).getValue());
			}
		});
		
		JLabel childThreeEnergyLabel = new JLabel("Child 3+ energy");		
		GridBagConstraints gbc_childThreeEnergyLabel = new GridBagConstraints();
		gbc_childThreeEnergyLabel.gridwidth = 2;
		gbc_childThreeEnergyLabel.anchor = GridBagConstraints.WEST;
		gbc_childThreeEnergyLabel.insets = new Insets(0, 0, 0, 5);
		gbc_childThreeEnergyLabel.gridx = 2;
		gbc_childThreeEnergyLabel.gridy = 10;
		add(childThreeEnergyLabel, gbc_childThreeEnergyLabel);
		GridBagConstraints gbc_childThreeEnergySpinner = new GridBagConstraints();
		gbc_childThreeEnergySpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_childThreeEnergySpinner.insets = new Insets(0, 0, 0, 5);
		gbc_childThreeEnergySpinner.anchor = GridBagConstraints.NORTHEAST;
		gbc_childThreeEnergySpinner.gridx = 4;
		gbc_childThreeEnergySpinner.gridy = 10;
		add(childThreeEnergySpinner, gbc_childThreeEnergySpinner);

	}

    public void set(String s, Object o) {
        panelController.getGameController().set(s, o);
    }

    public int getInt(String s) {
        return panelController.getGameController().getSettings().getInt(s);
    }

    public JSlider getZoomSlider() {
        return zoomSlider;
    }
    public JRadioButton getRdbtnFriendly() {
        return rdbtnFriendly;
    }
    public JRadioButton getRdbtnCompetitive() {
        return rdbtnCompetitive;
    }
    public JButton getStartPauseButton() {
        return startPauseButton;
    }
    public JButton getStepButton() {
        return stepButton;
    }
    public JSlider getSpeedSlider() {
        return speedSlider;
    }
    public JButton getResetButton() {
        return resetButton;
    }
    public JRadioButton getRdbtnCooperative() {
        return rdbtnCooperative;
    }
}
