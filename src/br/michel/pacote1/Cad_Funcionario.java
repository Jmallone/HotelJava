package br.michel.pacote1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cad_Funcionario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtRG;
	private JTextField txtTelefone;
	private JTextField txtCelular;
	private JTextField txtEmail;
	private JTextField txtBairro;
	private JTextField txtNasc;
	private JTextField txtNumero;
	private JTextField txtFuncao;
	private JTextField txtRua;
	private JTextField txtCart;
	private JTextField txtADM;
	private JTextField txtDEM;
	
	String Nome, Email, Bairro,Logradouro, RG, CPF, Telefone, Celular, Numero, CEP, Funcao, Admissao, Demissao, Motivo;
	int id, id_end, Nasci, Carteira; // ID_END SERÁ O ID DO ENDEREÇO 
	
	public void clickEndereco(){
		
		String sql = "INSERT INTO `caqui`.`endereco` (`Numero`, `Bairro`, `CEP`, `Logradouro`, `Cidade_idCidade`) VALUES"
				+ " ('"+Numero+"', '"+Bairro+"', '"+CEP+"', '"+Logradouro+"', '"+id+"')";
		Conn.ConectaSql(sql);
		
	}
	
	public void clickFunc() {
		
		/*String sql = "INSERT INTO `caqui`.`funcionarios` "
				+ "(`idFuncionarios`, `Nome`, `RG`, `CPF`, `Telefone`, `Data_Nascimento`, `Numero_Carteira_Trabalho`, `Celular`, `Email`, `Data_Admissao`, `Data_Demissao`, `Motivo_Demissao`, `Funcao`, `Endereco_idEndereco`) VALUES "
				+ "('"+Nome+"', '"+RG+"', '"+CPF+"', '"+Telefone+"', '"+Nasci+"', '"+Carteira+"', '"+Celular+"', '"+Email+"', '"+Admissao+"', '"+Demissao+"', '"+Motivo+"', '"+Funcao+"', '"+id_end+"')";
		*/
		
		String sql = "INSERT INTO `caqui`.`funcionarios` (`Nome`, `RG`, `CPF`, `Telefone`, `Data_Nascimento`, `Numero_Carteira_Trabalho`, `Celular`, `Email`, `Data_Admissao`, `Funcao`, `Endereco_idEndereco`) VALUES ('"+Nome+"', '"+RG+"', '"+CPF+"', '"+Telefone+"', '"+Nasci+"', '"+Carteira+"', '"+Celular+"', '"+Email+"', '"+Admissao+"', '"+Funcao+"', '"+id_end+"')";
		
		Conn.ConectaSql(sql);
	}
	
	Cad_Cidade cidade = new Cad_Cidade();

	/**
	 * Create the dialog.
	 */
	public Cad_Funcionario() {
		setTitle("Funcionario");
		setBounds(100, 100, 341, 650);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 28, 284, 20);
		contentPanel.add(txtNome);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setBounds(10, 14, 46, 14);
		contentPanel.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 59, 46, 14);
		contentPanel.add(lblCpf);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(10, 73, 131, 20);
		contentPanel.add(txtCPF);
		
		txtRG = new JTextField();
		txtRG.setColumns(10);
		txtRG.setBounds(151, 73, 143, 20);
		contentPanel.add(txtRG);
		
		JLabel label_2 = new JLabel("RG");
		label_2.setBounds(154, 59, 46, 14);
		contentPanel.add(label_2);
		
		JLabel lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setBounds(10, 104, 78, 14);
		contentPanel.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(10, 120, 116, 20);
		contentPanel.add(txtTelefone);
		
		JLabel lblCelular = new JLabel("CELULAR");
		lblCelular.setBounds(154, 104, 107, 14);
		contentPanel.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(151, 120, 143, 20);
		contentPanel.add(txtCelular);
		
		JLabel lblEmail = new JLabel("E-MAIL");
		lblEmail.setBounds(10, 151, 46, 14);
		contentPanel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 167, 284, 20);
		contentPanel.add(txtEmail);
		
		JLabel lblCidade = new JLabel("CIDADE");
		lblCidade.setBounds(10, 195, 46, 14);
		contentPanel.add(lblCidade);
		
		final JComboBox cbCidade = new JComboBox();
		cbCidade.setBounds(10, 209, 127, 20);
		contentPanel.add(cbCidade);
		Control.Click(cbCidade,"cidade" );
		
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cidade.setModal(true);
				cidade.setVisible(true);
			}
		});
		button.setBounds(142, 210, 25, 20);
		contentPanel.add(button);
		
		JLabel lblBairro = new JLabel("BAIRRO");
		lblBairro.setBounds(10, 238, 54, 14);
		contentPanel.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(9, 252, 173, 20);
		contentPanel.add(txtBairro);
		
		JLabel lblDataNascimento = new JLabel("DATA NASCIMENTO");
		lblDataNascimento.setBounds(9, 328, 158, 14);
		contentPanel.add(lblDataNascimento);
		
		txtNasc = new JTextField();
		txtNasc.setText("1999");
		txtNasc.setColumns(10);
		txtNasc.setBounds(9, 344, 67, 20);
		contentPanel.add(txtNasc);
		
		JLabel lblNumeroDaCasa = new JLabel("N\u00BACASA");
		lblNumeroDaCasa.setBounds(192, 238, 114, 14);
		contentPanel.add(lblNumeroDaCasa);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(193, 252, 46, 20);
		contentPanel.add(txtNumero);
		
		txtFuncao = new JTextField();
		txtFuncao.setColumns(10);
		txtFuncao.setBounds(177, 209, 117, 20);
		contentPanel.add(txtFuncao);
		
		JLabel lblFuno = new JLabel("FUN\u00C7\u00C3O");
		lblFuno.setBounds(184, 195, 55, 14);
		contentPanel.add(lblFuno);
		
		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(10, 297, 229, 20);
		contentPanel.add(txtRua);
		
		JLabel lblRua = new JLabel("RUA");
		lblRua.setBounds(10, 283, 46, 14);
		contentPanel.add(lblRua);
		
		JLabel lblNCarteiraDe = new JLabel("N\u00BA CARTEIRA DE TRABALHO");
		lblNCarteiraDe.setBounds(10, 375, 194, 14);
		contentPanel.add(lblNCarteiraDe);
		
		txtCart = new JTextField();
		txtCart.setColumns(10);
		txtCart.setBounds(10, 390, 181, 20);
		contentPanel.add(txtCart);
		
		JLabel lblDataAdmisso = new JLabel("DATA ADMISS\u00C3O");
		lblDataAdmisso.setBounds(10, 421, 114, 14);
		contentPanel.add(lblDataAdmisso);
		
		txtADM = new JTextField();
		txtADM.setColumns(10);
		txtADM.setBounds(10, 437, 84, 20);
		contentPanel.add(txtADM);
		
		JLabel lblDataDemisso = new JLabel("DATA DEMISS\u00C3O");
		lblDataDemisso.setBounds(109, 421, 114, 14);
		contentPanel.add(lblDataDemisso);
		
		txtDEM = new JTextField();
		txtDEM.setColumns(10);
		txtDEM.setBounds(104, 437, 86, 20);
		contentPanel.add(txtDEM);
		
		JLabel lblMotivoDemisso = new JLabel("MOTIVO DEMISS\u00C3O");
		lblMotivoDemisso.setBounds(10, 468, 158, 14);
		contentPanel.add(lblMotivoDemisso);
		
		final JTextArea txtMOT = new JTextArea();
		txtMOT.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtMOT.setBounds(10, 485, 284, 82);
		contentPanel.add(txtMOT);
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
						Nasci = Integer.parseInt(txtNasc.getText());
						Funcao = txtFuncao.getText();
						Carteira = Integer.parseInt(txtCart.getText());
						Admissao = txtADM.getText();
						Demissao = txtDEM.getText();
						Motivo = txtMOT.getText();
						
						id = id = Control.FkRadio(cbCidade);
					
						// Gambiarra da Pior especie,DO NOT MAKE THIS SHIT
						try {
							ResultSet resposta = Conn.consulta( "SELECT MAX(idEndereco) FROM endereco" );
							 while(resposta.next()){ 
								id_end = resposta.getInt( "MAX(idEndereco)" )+1;
							 }
						} catch (SQLException e) {
							e.printStackTrace();
						}
						
						clickEndereco();
						clickFunc();
						
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
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
