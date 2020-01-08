package com.unitconverter.java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame MainWindow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.MainWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MainWindow = new JFrame();
		MainWindow.setTitle("Unit Converter");
		MainWindow.setBounds(100, 100, 450, 300);
		MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainWindow.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose Type");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(93, 12, 240, 43);
		MainWindow.getContentPane().add(lblNewLabel);
		
		JButton TemperatureButton = new JButton("Temperature");
		TemperatureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Temperature t = new Temperature();
				t.TemperatureMain(null);
			}
		});
		TemperatureButton.setBounds(143, 85, 141, 21);
		MainWindow.getContentPane().add(TemperatureButton);
		
		JButton LengthButton = new JButton("Length");
		LengthButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Length l = new Length();
				l.LengthMain(null);
			}
		});
		LengthButton.setBounds(143, 116, 141, 21);
		MainWindow.getContentPane().add(LengthButton);
		
		JButton DataButton = new JButton("Data");
		DataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Data data = new Data();
				data.DataMain(null);;
			}
		});
		DataButton.setBounds(143, 147, 141, 21);
		MainWindow.getContentPane().add(DataButton);
		
		JButton MeasurementButton = new JButton("Measurement");
		MeasurementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Measurement measurement = new Measurement();
				measurement.MeasurementMain(null);
			}
		});
		MeasurementButton.setBounds(143, 178, 141, 21);
		MainWindow.getContentPane().add(MeasurementButton);
	}
}