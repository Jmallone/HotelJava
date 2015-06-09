package br.michel.pacote1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cad_Saida extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	Cad_Cliente cliente = new Cad_Cliente();
	
	public Cad_Saida() {
		setTitle("Saida");
		setBounds(100, 100, 216, 187);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("NOME");
			label.setBounds(10, 10, 46, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("DATA ATUAL");
			label.setBounds(10, 56, 93, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("HORARIO ENTRADA");
			label.setBounds(97, 56, 113, 14);
			contentPanel.add(label);
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(10, 23, 142, 22);
			contentPanel.add(comboBox);
		}
		{
			JButton btnNewButton = new JButton("...");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cliente.setModal(true);
					cliente.setVisible(true);
				}
			});
			btnNewButton.setBounds(162, 23, 28, 23);
			contentPanel.add(btnNewButton);
		}
		{
			textField = new JTextField();
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setText("00/00/00");
			textField.setBounds(10, 76, 65, 22);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setText("00:00");
			textField_1.setBounds(94, 76, 65, 22);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
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
