package br.michel.pacote1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cad_TipoQuarto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTipo;
	private JTextField txtDesc;
	private JTextField txtValor;
	String Tipo, Desc, Valor;

	public void clickConecta() {
		
		String sql = "INSERT INTO `caqui`.`tipoquarto` (`Nome`, `Descricao`, `Valor`) VALUES ('"+Tipo+"', '"+Desc+"', '"+Valor+"')";
		
		Conn.ConectaSql(sql);
	}
	
	public Cad_TipoQuarto() {
		setBounds(100, 100, 154, 229);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(10, 28, 126, 20);
		contentPanel.add(txtTipo);
		txtTipo.setColumns(10);
		{
			txtDesc = new JTextField();
			txtDesc.setBounds(10, 78, 126, 20);
			contentPanel.add(txtDesc);
			txtDesc.setColumns(10);
		}
		{
			txtValor = new JTextField();
			txtValor.setBounds(10, 127, 60, 20);
			contentPanel.add(txtValor);
			txtValor.setColumns(10);
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
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						Tipo = txtTipo.getText();
						Desc = txtDesc.getText();
						Valor = txtValor.getText();

						clickConecta();
						txtTipo.setText("");
						txtDesc.setText("");
						txtValor.setText("");

					}
				});
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
