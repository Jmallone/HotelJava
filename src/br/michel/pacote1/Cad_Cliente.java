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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cad_Cliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtRG;
	private JTextField txtTelefone;
	private JTextField txtCelular;
	private JTextField txtEmail;
	private JTextField txtBairro;
	private JTextField txtRua;
	private JTextField txtNumero;
	
	Cad_Cidade cidade = new Cad_Cidade();
	ComboBox cbox = new ComboBox("SELECT * from cidade");
	
	private JComboBox comboBox;
	
	String Nome, Email, Bairro,Logradouro, RG, CPF, Telefone, Celular, Numero, CEP;
	int id, id_end; // ID_END SERÁ O ID DO ENDEREÇO 
	
	
	// VAR FOR EDIT
	boolean edit = false;
	int id_edit = 0;
	
	public void clickEndereco(){
		
		String sql = null;
		
		//if (edit == false){
			sql = "INSERT INTO `caqui`.`endereco` (`Numero`, `Bairro`, `CEP`, `Logradouro`, `Cidade_idCidade`) VALUES"
					+ " ('"+Numero+"', '"+Bairro+"', '"+CEP+"', '"+Logradouro+"', '"+id+"')";
		//}else{
			//sql = "UPDATE `caqui`.`produtos` SET `Nome`='"+nome+"', `Valor`='"+valor+"', `Quantidade`='"+qtd+"', `Descricao`='"+desc+"', `Grupo_Produtos_idGrupo_Produtos`='"+id+"' WHERE `idProdutos`='"+id_edit+"'";
	//}
		
		Conn.ConectaSql(sql);
		
	}
	
	public void clickHospede() {
		
		String sql = null;
		
		if (edit == false){
			sql = "INSERT INTO `caqui`.`hospede` (`Nome`, `RG`, `CPF`, `Telefone`, `Celular`, `Email`, `Endereco_idEndereco`)"
					+ " VALUES ('"+Nome+"', '"+RG+"', '"+CPF+"', '"+Telefone+"', '"+Celular+"', '"+Email+"', '"+id_end+"')";
		}else{
			sql = "UPDATE `caqui`.`hospede` SET `Nome`='"+Nome+"', `RG`='"+RG+"', `CPF`='"+CPF+"', `Telefone`='"+Telefone+"', `Celular`='"+Celular+"', `Email`='"+Email+"' WHERE `idHospede`='1'";
		}
		
		Conn.ConectaSql(sql);
	}

	
	
	


	public void editaEnd(int id_Con){

		String sql = "SELECT * FROM caqui.hospede WHERE `idhospede`='"+id_Con+"'";
		
		//SELECT * FROM endereco WHERE idEndereco = 1;
		
		id_edit = id_Con;
		edit = true;
		comboBox.removeAllItems(); 
		Control.Click(comboBox,"cidade" ); // Ira para função Click, que apagara todos os itens no ComboBox e Atualizara em seguida
		
		try {
			
			ResultSet resposta = Conn.consulta( sql );
	      
	      while(resposta.next()){ 
	    	 // idHospede, Nome, RG, CPF, Telefone, Celular, Email, Endereco_idEndereco, idHospede, id
				//String id2 = Integer.toString(resposta.getInt( "produtos.idProdutos" )) ;
				String umNome = resposta.getString( "hospede.Nome" );
				String umRG = resposta.getString("hospede.RG");
				String umCPF = resposta.getString("hospede.CPF");
				String umTel = resposta.getString("hospede.Telefone");
				String umCel = resposta.getString("hospede.Celular");
				String umEmail = resposta.getString("hospede.Email");
				
				txtNome.setText(umNome);
				txtCPF.setText(umCPF);
				txtRG.setText(umRG);
				txtTelefone.setText(umTel);
				txtCelular.setText(umCel);
				txtEmail.setText(umEmail);
				txtBairro.setText("");
				txtRua.setText("");
				txtNumero.setText("");
				 
				
				
	          }
	      } 
	      catch(SQLException ex){
	           System.out.println("SQLException: " + ex.getMessage());
	           System.out.println("SQLState: " + ex.getSQLState());
	           System.out.println("VendorError: " + ex.getErrorCode());
	      }
		
	}
	
	
	

	public void editaHosp(int id_Con){

		String sql = "SELECT * FROM caqui.hospede WHERE `idhospede`='"+id_Con+"'";
		id_edit = id_Con;
		edit = true;
		
		cbox.atualizeItens();
		
		//comboBox.removeAllItems(); 
		//Control.Click(comboBox,"cidade" ); // Ira para função Click, que apagara todos os itens no ComboBox e Atualizara em seguida
		
		try {
			
			ResultSet resposta = Conn.consulta( sql );
	      
	      while(resposta.next()){ 
	    	 // idHospede, Nome, RG, CPF, Telefone, Celular, Email, Endereco_idEndereco, idHospede, id
				//String id2 = Integer.toString(resposta.getInt( "produtos.idProdutos" )) ;
				String umNome = resposta.getString( "hospede.Nome" );
				String umRG = resposta.getString("hospede.RG");
				String umCPF = resposta.getString("hospede.CPF");
				String umTel = resposta.getString("hospede.Telefone");
				String umCel = resposta.getString("hospede.Celular");
				String umEmail = resposta.getString("hospede.Email");
				
				txtNome.setText(umNome);
				txtCPF.setText(umCPF);
				txtRG.setText(umRG);
				txtTelefone.setText(umTel);
				txtCelular.setText(umCel);
				txtEmail.setText(umEmail);
				txtBairro.setText("");
				txtRua.setText("");
				txtNumero.setText("");
				 
				
				
	          }
	      } 
	      catch(SQLException ex){
	           System.out.println("SQLException: " + ex.getMessage());
	           System.out.println("SQLState: " + ex.getSQLState());
	           System.out.println("VendorError: " + ex.getErrorCode());
	      }
		
		
		
		
		
	}
	
	public void populaEnd(int idEnd){
		
		//Inserir endereco
				String sql2 = "SELECT * FROM caqui.endereco WHERE idEndereco= "+idEnd+"";
				
				try {
					
					ResultSet rs = Conn.consulta( sql2 );
			      
			      while(rs.next()){ 
			    	 // idHospede, Nome, RG, CPF, Telefone, Celular, Email, Endereco_idEndereco, idHospede, id
						//String id2 = Integer.toString(resposta.getInt( "produtos.idProdutos" )) ;
						String umBairro = rs.getString( "Bairro" );
						String umRua = rs.getString("Logradouro");
						String umNumero = rs.getString("Numero");
						
						txtBairro.setText(umBairro);
						txtRua.setText(umRua);
						txtNumero.setText(umNumero);
						 
						
						
			          }
			      } 
			      catch(SQLException ex){
			           System.out.println("SQLException: " + ex.getMessage());
			           System.out.println("SQLState: " + ex.getSQLState());
			           System.out.println("VendorError: " + ex.getErrorCode());
			      }
				
				cbox.selectItemById(2);
				JOptionPane.showMessageDialog(null, "OLA : "+idEnd);
		
	}
	
	public Cad_Cliente() {
		setTitle("Cliente");
		setBounds(100, 100, 365, 388);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblRg = new JLabel("RG");
			lblRg.setBounds(184, 60, 46, 14);
			contentPanel.add(lblRg);
		}
		{
			JLabel lblCelular = new JLabel("CELULAR");
			lblCelular.setBounds(184, 111, 130, 14);
			contentPanel.add(lblCelular);
		}
		{
			JLabel lblBairro = new JLabel("BAIRRO");
			lblBairro.setBounds(184, 213, 54, 14);
			contentPanel.add(lblBairro);
		}
		{
			JLabel lblNumeroDaCasa = new JLabel("NUMERO DA CASA");
			lblNumeroDaCasa.setBounds(184, 264, 114, 14);
			contentPanel.add(lblNumeroDaCasa);
		}
		{
			JLabel lblRua = new JLabel("RUA");
			lblRua.setBounds(10, 264, 46, 14);
			contentPanel.add(lblRua);
		}
		{
			JLabel lblCidade = new JLabel("CIDADE");
			lblCidade.setBounds(10, 213, 46, 14);
			contentPanel.add(lblCidade);
		}
		{
			JLabel lblEmail = new JLabel("E-MAIL");
			lblEmail.setBounds(10, 162, 46, 14);
			contentPanel.add(lblEmail);
		}
		{
			JLabel lblTelefone = new JLabel("TELEFONE");
			lblTelefone.setBounds(10, 111, 78, 14);
			contentPanel.add(lblTelefone);
		}
		{
			JLabel lblCpf = new JLabel("CPF");
			lblCpf.setBounds(10, 60, 46, 14);
			contentPanel.add(lblCpf);
		}
		{
			JLabel lblNome = new JLabel("NOME");
			lblNome.setBounds(10, 11, 46, 14);
			contentPanel.add(lblNome);
		}
		{
			txtNome = new JTextField();
			txtNome.setBounds(10, 29, 325, 20);
			contentPanel.add(txtNome);
			txtNome.setColumns(10);
		}
		{
			txtCPF = new JTextField();
			txtCPF.setColumns(10);
			txtCPF.setBounds(10, 80, 149, 20);
			contentPanel.add(txtCPF);
		}
		{
			txtRG = new JTextField();
			txtRG.setColumns(10);
			txtRG.setBounds(184, 80, 151, 20);
			contentPanel.add(txtRG);
		}
		{
			txtTelefone = new JTextField();
			txtTelefone.setColumns(10);
			txtTelefone.setBounds(10, 131, 149, 20);
			contentPanel.add(txtTelefone);
		}
		{
			txtCelular = new JTextField();
			txtCelular.setColumns(10);
			txtCelular.setBounds(184, 131, 149, 20);
			contentPanel.add(txtCelular);
		}
		{
			txtEmail = new JTextField();
			txtEmail.setColumns(10);
			txtEmail.setBounds(10, 182, 325, 20);
			contentPanel.add(txtEmail);
		}
		{
			txtBairro = new JTextField();
			txtBairro.setColumns(10);
			txtBairro.setBounds(184, 233, 149, 20);
			contentPanel.add(txtBairro);
		}
		{
//			comboBox = new JComboBox();
			cbox.setBounds(10, 233, 130, 20);
			contentPanel.add(cbox);
			//Control.Click(comboBox,"cidade" );// Ira para função Click, que apagara todos os itens no ComboBox e Atualizara em seguida
			cbox.atualizeItens();
		}
		
		{
			JButton button = new JButton("...");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cidade.setModal(true);
					cidade.setVisible(true);
					comboBox.removeAllItems(); 
					Control.Click(comboBox,"cidade" );
				}
			});
			button.setBounds(150, 232, 24, 22);
			contentPanel.add(button);
		}
		{
			txtRua = new JTextField();
			txtRua.setColumns(10);
			txtRua.setBounds(10, 282, 149, 20);
			contentPanel.add(txtRua);
		}
		{
			txtNumero = new JTextField();
			txtNumero.setColumns(10);
			txtNumero.setBounds(184, 282, 46, 20);
			contentPanel.add(txtNumero);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Nome = txtNome.getText();
						CPF = txtCPF.getText();
						RG = txtRG.getText();
						Telefone = txtTelefone.getText();
						Celular = txtCelular.getText();
						Email = txtEmail.getText();
						Bairro = txtBairro.getText();
						Logradouro = txtRua.getText();
						Numero = txtNumero.getText();
						id = id = Control.FkRadio(comboBox);
					
						// Gambiarra da Pior especie,DO NOT MAKE THIS SHIT
						try {
							ResultSet resposta = Conn.consulta( "SELECT MAX(idEndereco) FROM endereco" );
							 while(resposta.next()){ 
								id_end = resposta.getInt( "MAX(idEndereco)" )+1;
								JOptionPane.showMessageDialog(null, "ID: "+id_end+" ID2: "+id);
							 }
						} catch (SQLException e) {
							e.printStackTrace();
						}
						
						clickEndereco();
						clickHospede();
						
						txtNome.setText("");
						txtCPF.setText("");
						txtRG.setText("");
						txtTelefone.setText("");
						txtCelular.setText("");
						txtEmail.setText("");
						txtBairro.setText("");
						txtRua.setText("");
						txtNumero.setText("");
				
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
						Control.Click(comboBox,"cidade");
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
