package br.michel.pacote1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

//import javafx.scene.control.ComboBox;




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
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Cad_Produto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	private JTextField txtDesc;
	private JTextField txtValor;
	
	String nome ; // Variavel na onde ficara o nome do Produto
	String valor; // Variavel na onde ficara o valor do Produto
	String desc ; // Variavel na onde ficara a descrição do Produto
	String qtd;
	int id; //  Variavel na onde ficara a FK de Grupo de Produto
	
	static Connection con = Conn.conectaMySQL();

	Cad_GrupoProd grupoprod = new Cad_GrupoProd();
	private JTextField txtQtd;

	public void clickConecta() {
		
		String sql = "INSERT INTO `caqui`.`produtos` (`Nome`, `Valor`, `Quantidade`,  `Descricao`, `Grupo_Produtos_idGrupo_Produtos`) VALUES ('"+nome+"', '"+valor+"','"+qtd+"', '"+desc+"', '"+id+"')";
		Conn.ConectaSql(sql);
	}

	
	public Cad_Produto() {
		setTitle("Produtos");
		setBounds(100, 100, 169, 264);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setBounds(10, 11, 58, 14);
		contentPanel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 25, 135, 20);
		contentPanel.add(txtNome);
		
		JLabel lblGrupo = new JLabel("GRUPO");
		lblGrupo.setBounds(10, 56, 46, 14);
		contentPanel.add(lblGrupo);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 70, 107, 20);
		contentPanel.add(comboBox);
		
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				grupoprod.setModal(true);
				grupoprod.setVisible(true);
				comboBox.removeAllItems(); 
				Control.Click(comboBox,"grupo_produtos" ); // Ira para função Click, que apagara todos os itens no ComboBox e Atualizara em seguida
			}
		});
		button.setBounds(120, 71, 25, 20);
		contentPanel.add(button);
		
		Control.Click(comboBox,"grupo_produtos" );// Ira para função Click, que apagara todos os itens no ComboBox e Atualizara em seguida
		
		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		txtDesc.setBounds(10, 116, 135, 20);
		contentPanel.add(txtDesc);
		
		JLabel lblDescrio = new JLabel("DESCRI\u00C7\u00C3O");
		lblDescrio.setBounds(10, 101, 71, 14);
		contentPanel.add(lblDescrio);
		
		JLabel lblValor = new JLabel("VALOR");
		lblValor.setBounds(10, 147, 46, 14);
		contentPanel.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(10, 161, 71, 20);
		contentPanel.add(txtValor);
		
		JLabel lblQtd = new JLabel("QTD");
		lblQtd.setBounds(99, 147, 46, 14);
		contentPanel.add(lblQtd);
		
		txtQtd = new JTextField();
		txtQtd.setBounds(96, 161, 47, 20);
		contentPanel.add(txtQtd);
		txtQtd.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						 id = Control.FkRadio(comboBox);
						 
						 nome = txtNome.getText(); // Pega o que esta escrito no Campo txtNome
						 valor = txtValor.getText(); // Pega o que esta escrito no Campo txtValor
						 desc = txtDesc.getText(); // Pega o que esta escrito no Campo txtDesc
						 qtd = txtQtd.getText();
						 
						 clickConecta(); // Vai inserir as informaçoes para o Banco de Dados 
						 
						 txtNome.setText(""); // Limpa o Campo 
						 txtValor.setText(""); // Limpa o Campo
						 txtDesc.setText(""); // Limpa o Campo
						 txtQtd.setText("");
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
						Control.Click(comboBox,"grupo_produtos");
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
