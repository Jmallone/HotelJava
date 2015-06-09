package br.michel.pacote1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Cad_TipoQuarto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cad_TipoQuarto dialog = new Cad_TipoQuarto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cad_TipoQuarto() {
		setBounds(100, 100, 154, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 28, 126, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			textField_1 = new JTextField();
			textField_1.setBounds(10, 78, 126, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(10, 127, 60, 20);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			JLabel lblTipo = new JLabel("TIPO");
			lblTipo.setBounds(10, 11, 46, 14);
			contentPanel.add(lblTipo);
		}
		{
			JLabel lblDescrio = new JLabel("DESCRI\u00C7\u00C3O");
			lblDescrio.setBounds(10, 59, 96, 14);
			contentPanel.add(lblDescrio);
		}
		{
			JLabel lblValor = new JLabel("VALOR");
			lblValor.setBounds(10, 109, 46, 14);
			contentPanel.add(lblValor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
