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

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;

public class Cad_GrupoProd extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDesc;
	private JTextField txtNome;
	String nome;
	String desc;

	public void clickConecta() {
		
		String sql = "INSERT INTO `caqui`.`grupo_produtos` (`Nome`, `Descricao`) VALUES ('"+nome+"', '"+desc+"')";
		
		Conn.ConectaSql(sql);
	}
	
	/**
	 * Create the dialog.
	 */
	public Cad_GrupoProd() {
		setTitle("Grupo de Produtos");
		setBounds(100, 100, 179, 170);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtDesc = new JTextField();
			txtDesc.setColumns(10);
			txtDesc.setBounds(10, 71, 135, 20);
			contentPanel.add(txtDesc);
		}
		{
			JLabel lblDescrio = new JLabel("DESCRI\u00C7\u00C3O");
			lblDescrio.setBounds(10, 58, 71, 14);
			contentPanel.add(lblDescrio);
		}
		{
			JLabel lblNome = new JLabel("NOME");
			lblNome.setBounds(10, 14, 58, 14);
			contentPanel.add(lblNome);
		}
		{
			txtNome = new JTextField();
			txtNome.setColumns(10);
			txtNome.setBounds(10, 27, 132, 20);
			contentPanel.add(txtNome);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						nome = txtNome.getText();
						desc = txtDesc.getText();
						
						 int reply = JOptionPane.showConfirmDialog(null, "Voce quer adicionar mesmo: \n Nome:  "+nome+"\n Descrição: "+desc, "Confirmar Cadastro!", JOptionPane.YES_NO_OPTION);
						 if (reply == JOptionPane.YES_OPTION)
						  {
						      //System.exit(0);
						      clickConecta();
						      txtNome.setText("");
						      txtDesc.setText("");
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
