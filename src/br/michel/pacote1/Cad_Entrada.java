package br.michel.pacote1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cad_Entrada extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	Cad_Funcionario funcionario = new Cad_Funcionario();
	Cad_Cliente cliente = new Cad_Cliente();

	public Cad_Entrada() {
		setBounds(100, 100, 219, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 69, 136, 22);
		contentPanel.add(comboBox);
		
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cliente.setModal(true);
				cliente.setVisible(true);
			}
		});
		button.setBounds(156, 70, 27, 22);
		contentPanel.add(button);
		
		JLabel label = new JLabel("NOME");
		label.setBounds(10, 56, 46, 14);
		contentPanel.add(label);
		
		textField = new JTextField();
		textField.setText("00/00/00");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(10, 116, 64, 20);
		contentPanel.add(textField);
		
		JLabel label_1 = new JLabel("DATA ATUAL");
		label_1.setBounds(10, 102, 93, 14);
		contentPanel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setText("00/00/00");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(94, 116, 64, 20);
		contentPanel.add(textField_1);
		
		JLabel label_2 = new JLabel("SAIDA PREVISTA");
		label_2.setBounds(95, 102, 185, 14);
		contentPanel.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 162, 46, 20);
		contentPanel.add(textField_2);
		
		JLabel label_3 = new JLabel("N\u00BA QUARTO");
		label_3.setBounds(10, 147, 84, 14);
		contentPanel.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setText("R$ 00,00");
		textField_3.setColumns(10);
		textField_3.setBounds(95, 162, 64, 20);
		contentPanel.add(textField_3);
		
		JLabel label_4 = new JLabel("VALOR DIARIA");
		label_4.setBounds(95, 147, 93, 14);
		contentPanel.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setText("R$ 00,00");
		textField_4.setColumns(10);
		textField_4.setBounds(10, 208, 64, 20);
		contentPanel.add(textField_4);
		
		JLabel label_5 = new JLabel("DESCONTO");
		label_5.setBounds(10, 193, 64, 14);
		contentPanel.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setText("00:00");
		textField_5.setColumns(10);
		textField_5.setBounds(97, 208, 63, 20);
		contentPanel.add(textField_5);
		
		JLabel label_6 = new JLabel("HORARIO ENTRADA");
		label_6.setBounds(95, 193, 113, 14);
		contentPanel.add(label_6);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 23, 136, 22);
		contentPanel.add(comboBox_1);
		
		JLabel label_7 = new JLabel("FUNCIONARIO");
		label_7.setBounds(10, 6, 159, 14);
		contentPanel.add(label_7);
		
		JButton button_1 = new JButton("New button");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funcionario.setModal(true);
				funcionario.setVisible(true);
			}
		});
		button_1.setBounds(156, 24, 27, 22);
		contentPanel.add(button_1);
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
				JButton cancelButton = new JButton("Cancelar");
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
