package br.michel.pacote1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class Cad_Cidade extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	
	Cad_Estado estado = new Cad_Estado();
	
	static Connection con = Conn.conectaMySQL();
	String nome;
	String cep;
	int id;
	public void clickConecta() {
		
		String sql = "INSERT INTO `caqui`.`cidade` (`Nome`, `Estado_idEstado`) VALUES ('"+nome+"', '"+id+"')";
		Conn.ConectaSql(sql);
	}
	/**
	 * Create the dialog.
	 */
	public Cad_Cidade() {
		setTitle("Cidade");
		setBounds(100, 100, 172, 179);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

			JLabel lblEstado = new JLabel("ESTADO");
			lblEstado.setBounds(10, 60, 121, 14);

			JLabel lblNome = new JLabel("NOME");
			lblNome.setBounds(10, 10, 46, 14);
			contentPanel.add(lblNome);

			txtNome = new JTextField();
			txtNome.setBounds(10, 29, 121, 20);
			contentPanel.add(txtNome);
			txtNome.setColumns(10);

			final JComboBox cbBoxEstado = new JComboBox();
			cbBoxEstado.setBounds(10, 76, 110, 20);
			contentPanel.add(cbBoxEstado);
			
			Control.Click(cbBoxEstado, "Estado");

			JButton button = new JButton("...");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					estado.setModal(true);
					estado.setVisible(true);
					Control.Click(cbBoxEstado, "Estado"); // Ira para função Click, que apagara todos os itens no ComboBox e Atualizara em seguida
				}
			});
			button.setBounds(125, 75, 26, 23);
			contentPanel.add(button);
			
			JLabel lblEstado_1 = new JLabel("ESTADO");
			lblEstado_1.setBounds(10, 60, 46, 14);
			contentPanel.add(lblEstado_1);
		
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						
						 id = Control.FkRadio(cbBoxEstado);
						
						 nome = txtNome.getText(); // Pega o que esta escrito no Campo txtNome
						 
						 clickConecta(); // Vai inserir as informaçoes para o Banco de Dados 
						 
						 txtNome.setText(""); // Limpa o Campo 
						
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
						Control.Click(cbBoxEstado, "Estado");
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
