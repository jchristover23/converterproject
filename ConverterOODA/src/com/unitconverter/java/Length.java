package com.unitconverter.java;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JList;

public class Length extends JFrame {


	private JPanel LengthPane;
	private JTextField LengthField1;
	private JTextField LengthField2;
	History history = new History();

	/**
	 * Launch the application.
	 */
	public static void LengthMain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Length frame = new Length();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Length() {
		
		
		setTitle("Length Converter");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		LengthPane = new JPanel();
		LengthPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(LengthPane);
		LengthPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Length Converter");
		lblNewLabel.setBounds(10, 10, 135, 13);
		LengthPane.add(lblNewLabel);
		
		LengthField1 = new JTextField();
		LengthField1.setBounds(10, 33, 153, 19);
		LengthPane.add(LengthField1);
		LengthField1.setColumns(10);
		
		LengthField2 = new JTextField();
		LengthField2.setEditable(false);
		LengthField2.setBounds(10, 97, 153, 19);
		LengthPane.add(LengthField2);
		LengthField2.setColumns(10);
		
		JComboBox LengthCombo1 = new JComboBox();
		LengthCombo1.setModel(new DefaultComboBoxModel(new String[] {"cm", "m", "km"}));
		LengthCombo1.setBounds(173, 32, 78, 21);
		LengthPane.add(LengthCombo1);
		
		JComboBox LengthCombo2 = new JComboBox();
		LengthCombo2.setModel(new DefaultComboBoxModel(new String[] {"cm", "m", "km"}));
		LengthCombo2.setBounds(173, 96, 78, 21);
		LengthPane.add(LengthCombo2);
		
		JButton convertButton = new JButton("Convert");
	    convertButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	            String LengthUnit1 = (String) LengthCombo1.getSelectedItem().toString();
	            String LengthUnit2 = (String) LengthCombo2.getSelectedItem().toString();
	            double result = Double.parseDouble(LengthField1.getText());
	            int res = (int) result;
	            String resu;

	            if (LengthUnit1 == LengthUnit2) {
	                LengthField2.setText("Unit cannot be the same!");
	            } else {
	                if (LengthUnit1 == "cm") {
	                    result /= 100;
	                } else if (LengthUnit1 == "km") {
	                    result *= 1000;
	                }

	                if (LengthUnit2 == "cm") {
	                    result *= 100;
	                } else if (LengthUnit2 == "km") {
	                    result /= 1000;
	                }

	                LengthField2.setText(String.valueOf(result));
	                String summary = (LengthField1.getText() + " " + LengthUnit1 + " -> " + LengthField2.getText() + " " + LengthUnit2);
	                history.LengthHistory.add(summary);
	                
	                
	            }
	        }
	    });
		convertButton.setBounds(10, 136, 85, 21);
		LengthPane.add(convertButton);
		
		JLabel resultLabel = new JLabel("Result");
		resultLabel.setBounds(10, 74, 45, 13);
		LengthPane.add(resultLabel);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		backButton.setBounds(341, 232, 85, 21);
		LengthPane.add(backButton);
		
		JList historyList = new JList(history.LengthHistory.toArray());
		historyList.setBounds(261, 33, 165, 189);
		LengthPane.add(historyList);
		
		JLabel lblNewLabel_1 = new JLabel("Converted Length History");
		lblNewLabel_1.setBounds(261, 10, 165, 13);
		LengthPane.add(lblNewLabel_1);
	}
}
