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

public class Cad_Estado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	String nome;

	public void clickConecta() {
		
		String sql = "INSERT INTO `caqui`.`estado` (`Nome`) VALUES ('"+nome+"')";
		
		Conn.ConectaSql(sql);
	}
	
	/**
	 * Create the dialog.
	 */
	public Cad_Estado() {
		setTitle("Estado");
		setBounds(100, 100, 211, 134);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 27, 174, 20);
		contentPanel.add(txtNome);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setBounds(10, 11, 46, 14);
		contentPanel.add(lblNome);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						nome = txtNome.getText();
						
						 int reply = JOptionPane.showConfirmDialog(null, "Voce quer adicionar mesmo: \n Nome:  "+nome, "Confirmar Cadastro!", JOptionPane.YES_NO_OPTION);
						 if (reply == JOptionPane.YES_OPTION)
						  {
						      clickConecta();
						      txtNome.setText("");
						  }
						
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
