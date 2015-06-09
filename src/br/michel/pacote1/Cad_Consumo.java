package br.michel.pacote1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cad_Consumo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	Cad_Cliente cliente = new Cad_Cliente();
	Cad_Produto produto = new Cad_Produto();

	/**
	 * Create the dialog.
	 */
	public Cad_Consumo() {
		setTitle("Consumo");
		setBounds(100, 100, 197, 319);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(10, 29, 39, 20);
			contentPanel.add(textField);
		}
		{
			JLabel label = new JLabel("N\u00BA QUARTO");
			label.setBounds(10, 10, 97, 14);
			contentPanel.add(label);
		}
		{
			textField_1 = new JTextField();
			textField_1.setText("00/00/00");
			textField_1.setColumns(10);
			textField_1.setBounds(84, 29, 76, 20);
			contentPanel.add(textField_1);
		}
		{
			JLabel label = new JLabel("DATA ATUAL");
			label.setBounds(84, 10, 90, 14);
			contentPanel.add(label);
		}
		{
			textField_2 = new JTextField();
			textField_2.setText("00:00");
			textField_2.setColumns(10);
			textField_2.setBounds(10, 77, 86, 20);
			contentPanel.add(textField_2);
		}
		{
			JLabel label = new JLabel("HORARIO ATUAL");
			label.setBounds(10, 60, 150, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("NOME");
			label.setBounds(10, 108, 132, 14);
			contentPanel.add(label);
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(10, 126, 114, 22);
			contentPanel.add(comboBox);
		}
		{
			JButton button = new JButton("New button");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cliente.setModal(true);
					cliente.setVisible(true);	
				}
			});
			button.setBounds(133, 126, 27, 22);
			contentPanel.add(button);
		}
		{
			JButton button = new JButton("New button");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					produto.setModal(true);
					produto.setVisible(true);
				}
			});
			button.setBounds(133, 177, 27, 22);
			contentPanel.add(button);
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(10, 177, 114, 22);
			contentPanel.add(comboBox);
		}
		{
			JLabel label = new JLabel("PRODUTO CONSUMIDO");
			label.setBounds(10, 159, 132, 14);
			contentPanel.add(label);
		}
		{
			textField_3 = new JTextField();
			textField_3.setText("R$ 00,00");
			textField_3.setColumns(10);
			textField_3.setBounds(10, 223, 59, 20);
			contentPanel.add(textField_3);
		}
		{
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(85, 223, 39, 20);
			contentPanel.add(textField_4);
		}
		{
			JLabel label = new JLabel("QTD");
			label.setBounds(84, 210, 46, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("VALOR");
			label.setBounds(10, 210, 59, 14);
			contentPanel.add(label);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
