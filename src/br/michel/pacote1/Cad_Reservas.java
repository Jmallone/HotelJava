package br.michel.pacote1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cad_Reservas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	Cad_Funcionario funcionario = new Cad_Funcionario();
	Cad_Cliente cliente = new Cad_Cliente();
	
	/**
	 * Create the dialog.
	 */
	public Cad_Reservas() {
		setTitle("Reservas");
		setBounds(100, 100, 200, 272);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(10, 172, 46, 20);
			contentPanel.add(textField);
		}
		{
			JLabel label = new JLabel("N\u00BA QUARTO");
			label.setBounds(10, 157, 84, 14);
			contentPanel.add(label);
		}
		{
			textField_1 = new JTextField();
			textField_1.setText("00/00/00");
			textField_1.setHorizontalAlignment(SwingConstants.CENTER);
			textField_1.setColumns(10);
			textField_1.setBounds(10, 126, 64, 20);
			contentPanel.add(textField_1);
		}
		{
			JLabel label = new JLabel("DATA ATUAL");
			label.setBounds(10, 112, 93, 14);
			contentPanel.add(label);
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(10, 79, 136, 22);
			contentPanel.add(comboBox);
		}
		{
			JLabel label = new JLabel("NOME");
			label.setBounds(10, 62, 46, 14);
			contentPanel.add(label);
		}
		{
			textField_2 = new JTextField();
			textField_2.setText("00/00/00");
			textField_2.setHorizontalAlignment(SwingConstants.CENTER);
			textField_2.setColumns(10);
			textField_2.setBounds(94, 126, 64, 20);
			contentPanel.add(textField_2);
		}
		{
			JLabel label = new JLabel("SAIDA PREVISTA");
			label.setBounds(95, 112, 185, 14);
			contentPanel.add(label);
		}
		{
			JButton button = new JButton("New button");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cliente.setModal(true);
					cliente.setVisible(true);
				}
			});
			button.setBounds(156, 80, 27, 22);
			contentPanel.add(button);
		}
		
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funcionario.setModal(true);
				funcionario.setVisible(true);
			}
		});
		button.setBounds(156, 29, 27, 22);
		contentPanel.add(button);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 28, 136, 22);
		contentPanel.add(comboBox);
		
		JLabel lblFuncionario = new JLabel("FUNCIONARIO");
		lblFuncionario.setBounds(10, 11, 159, 14);
		contentPanel.add(lblFuncionario);
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
