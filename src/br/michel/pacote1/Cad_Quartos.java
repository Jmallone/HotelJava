package br.michel.pacote1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Cad_Quartos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the dialog.
	 */
	public Cad_Quartos() {
		setTitle("Quartos");
		setBounds(100, 100, 204, 274);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNome = new JLabel("NOME");
			lblNome.setBounds(10, 14, 61, 14);
			contentPanel.add(lblNome);
		}
		{
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(10, 27, 164, 20);
			contentPanel.add(textField);
		}
		{
			JLabel lblDescrio = new JLabel("DESCRI\u00C7\u00C3O");
			lblDescrio.setBounds(10, 58, 85, 14);
			contentPanel.add(lblDescrio);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(10, 71, 164, 20);
			contentPanel.add(textField_1);
		}
		{
			JLabel lblTipo = new JLabel("TIPO");
			lblTipo.setBounds(10, 102, 46, 14);
			contentPanel.add(lblTipo);
		}
		{
			JLabel lblValor = new JLabel("VALOR");
			lblValor.setBounds(10, 145, 61, 14);
			contentPanel.add(lblValor);
		}
		{
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(10, 159, 77, 20);
			contentPanel.add(textField_3);
		}
		{
			JLabel lblNDoQuarto = new JLabel("N\u00BA DO QUARTO");
			lblNDoQuarto.setBounds(97, 145, 77, 14);
			contentPanel.add(lblNDoQuarto);
		}
		{
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(97, 159, 39, 20);
			contentPanel.add(textField_4);
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(10, 117, 126, 20);
			contentPanel.add(comboBox);
		}
		{
			JButton button = new JButton("...");
			button.setBounds(148, 111, 26, 23);
			contentPanel.add(button);
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
