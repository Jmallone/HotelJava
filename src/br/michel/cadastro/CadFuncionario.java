package br.michel.cadastro;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import br.michel.dao.ComboDao;
import br.michel.dao.EnderecoDao;
import br.michel.dao.FuncionarioDao;
import br.michel.modelo.ModelCombo;
import br.michel.modelo.ModelEndereco;
import br.michel.modelo.ModelFuncionario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadFuncionario extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private JTextField txtLogradouro;
	private JTextField txtCarteira;
	private JTextField txtAdm;
	private JTextField textField_13;
	private JTextField txtCEP;
	
	//Create Objects 
	ComboDao comboDao = new ComboDao();
	EnderecoDao endDao = new EnderecoDao();
	FuncionarioDao funcDao = new FuncionarioDao();
	ModelFuncionario modelFuncionario = new ModelFuncionario();
	ModelEndereco modelEndereco = new ModelEndereco();
	
	private JComboBox<ModelCombo> cboxCidade;
	
	public static void main(String[] args) {
		try {
			CadFuncionario dialog = new CadFuncionario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadFuncionario() {
		setBounds(100, 100, 345, 698);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			panel.setBounds(10, 11, 325, 579);
			contentPanel.add(panel);
			{
				txtNome = new JTextField();
				txtNome.setColumns(10);
				txtNome.setBounds(10, 28, 284, 20);
				panel.add(txtNome);
			}
			{
				JLabel label = new JLabel("NOME");
				label.setBounds(10, 14, 46, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("CPF");
				label.setBounds(10, 59, 46, 14);
				panel.add(label);
			}
			{
				txtCPF = new JTextField();
				txtCPF.setColumns(10);
				txtCPF.setBounds(10, 73, 131, 20);
				panel.add(txtCPF);
			}
			{
				txtRG = new JTextField();
				txtRG.setColumns(10);
				txtRG.setBounds(151, 73, 143, 20);
				panel.add(txtRG);
			}
			{
				JLabel label = new JLabel("RG");
				label.setBounds(154, 59, 46, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("TELEFONE");
				label.setBounds(10, 104, 78, 14);
				panel.add(label);
			}
			{
				txtTelefone = new JTextField();
				txtTelefone.setColumns(10);
				txtTelefone.setBounds(10, 120, 116, 20);
				panel.add(txtTelefone);
			}
			{
				JLabel label = new JLabel("CELULAR");
				label.setBounds(154, 104, 107, 14);
				panel.add(label);
			}
			{
				txtCelular = new JTextField();
				txtCelular.setColumns(10);
				txtCelular.setBounds(151, 120, 143, 20);
				panel.add(txtCelular);
			}
			{
				JLabel label = new JLabel("E-MAIL");
				label.setBounds(10, 151, 46, 14);
				panel.add(label);
			}
			{
				txtEmail = new JTextField();
				txtEmail.setColumns(10);
				txtEmail.setBounds(10, 167, 284, 20);
				panel.add(txtEmail);
			}
			{
				JLabel label = new JLabel("CIDADE");
				label.setBounds(10, 195, 46, 14);
				panel.add(label);
			}
			{
				cboxCidade = new JComboBox<ModelCombo>();
				cboxCidade.setBounds(10, 209, 127, 20);
				panel.add(cboxCidade);
				//Refresh ComboBox
				comboDao.AtualizaCombo(cboxCidade, "cidade");
			}
			{
				JButton button = new JButton("New button");
				button.setBounds(142, 210, 25, 20);
				panel.add(button);
			}
			{
				JLabel label = new JLabel("BAIRRO");
				label.setBounds(10, 238, 54, 14);
				panel.add(label);
			}
			{
				txtBairro = new JTextField();
				txtBairro.setColumns(10);
				txtBairro.setBounds(9, 252, 173, 20);
				panel.add(txtBairro);
			}
			{
				JLabel label = new JLabel("DATA NASCIMENTO");
				label.setBounds(9, 328, 158, 14);
				panel.add(label);
			}
			{
				txtNasc = new JTextField();
				txtNasc.setText("1999");
				txtNasc.setColumns(10);
				txtNasc.setBounds(9, 344, 67, 20);
				panel.add(txtNasc);
			}
			{
				JLabel label = new JLabel("N\u00BACASA");
				label.setBounds(192, 238, 114, 14);
				panel.add(label);
			}
			{
				txtNumero = new JTextField();
				txtNumero.setColumns(10);
				txtNumero.setBounds(193, 252, 46, 20);
				panel.add(txtNumero);
			}
			{
				txtFuncao = new JTextField();
				txtFuncao.setColumns(10);
				txtFuncao.setBounds(177, 209, 117, 20);
				panel.add(txtFuncao);
			}
			{
				JLabel label = new JLabel("FUN\u00C7\u00C3O");
				label.setBounds(184, 195, 55, 14);
				panel.add(label);
			}
			{
				txtLogradouro = new JTextField();
				txtLogradouro.setColumns(10);
				txtLogradouro.setBounds(10, 297, 229, 20);
				panel.add(txtLogradouro);
			}
			{
				JLabel lblLogradouro = new JLabel("LOGRADOURO");
				lblLogradouro.setBounds(10, 283, 149, 14);
				panel.add(lblLogradouro);
			}
			{
				JLabel label = new JLabel("N\u00BA CARTEIRA DE TRABALHO");
				label.setBounds(10, 375, 194, 14);
				panel.add(label);
			}
			{
				txtCarteira = new JTextField();
				txtCarteira.setColumns(10);
				txtCarteira.setBounds(10, 390, 181, 20);
				panel.add(txtCarteira);
			}
			{
				JLabel label = new JLabel("DATA ADMISS\u00C3O");
				label.setBounds(10, 421, 114, 14);
				panel.add(label);
			}
			{
				txtAdm = new JTextField();
				txtAdm.setText("2015-12-30");
				txtAdm.setColumns(10);
				txtAdm.setBounds(10, 437, 84, 20);
				panel.add(txtAdm);
			}
			{
				JLabel label = new JLabel("DATA DEMISS\u00C3O");
				label.setBounds(109, 421, 114, 14);
				panel.add(label);
			}
			{
				textField_13 = new JTextField();
				textField_13.setColumns(10);
				textField_13.setBounds(104, 437, 86, 20);
				panel.add(textField_13);
			}
			{
				JLabel label = new JLabel("MOTIVO DEMISS\u00C3O");
				label.setBounds(10, 468, 158, 14);
				panel.add(label);
			}
			{
				JTextArea textArea = new JTextArea();
				textArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				textArea.setBounds(10, 485, 284, 82);
				panel.add(textArea);
			}
			{
				txtCEP = new JTextField();
				txtCEP.setText("87538000");
				txtCEP.setBounds(153, 344, 86, 20);
				panel.add(txtCEP);
				txtCEP.setColumns(10);
			}
		}
		{
			JButton btnOk = new JButton("Ok");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//Inserts Address
					modelEndereco.setBairro(txtBairro.getText());
					modelEndereco.setNumero(txtNumero.getText());
					modelEndereco.setLogradouro(txtLogradouro.getText());
					modelEndereco.setCEP(txtCEP.getText());
					modelEndereco.setIdCidade(comboDao.FkRadio(cboxCidade)); // get ID ComboBox the city
					
					//Inserts Address on the table 
					endDao.adicionaEndereco(modelEndereco);
					
					//Inserts Staff
					modelFuncionario.setNome(txtNome.getText());
					modelFuncionario.setCPF(txtCPF.getText());
					modelFuncionario.setRG(txtRG.getText());
					modelFuncionario.setTelefone(txtTelefone.getText());
					modelFuncionario.setNasci(txtNasc.getText());;
					modelFuncionario.setCarteira(txtCarteira.getText());;
					modelFuncionario.setCelular(txtCelular.getText());;
					modelFuncionario.setEmail(txtEmail.getText());;
					modelFuncionario.setAdmissao(txtAdm.getText());;
					modelFuncionario.setFuncao(txtFuncao.getText());;
					//get last ID Address
					modelFuncionario.setId_end(endDao.ultimoID());
					
					//Inserts Staff on the table 
					funcDao.adicionaFuncionario(modelFuncionario);
					
				}
			});
			btnOk.setBounds(230, 601, 89, 23);
			contentPanel.add(btnOk);
		}
	}

}
