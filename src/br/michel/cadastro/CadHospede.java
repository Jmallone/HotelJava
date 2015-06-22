package br.michel.cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import br.michel.dao.ComboDao;
import br.michel.dao.EnderecoDao;
import br.michel.dao.HospedeDao;
import br.michel.modelo.ModelEndereco;
import br.michel.modelo.ModelHospede;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadHospede extends JDialog {
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtRG;
	private JTextField txtTel;
	private JTextField txtCel;
	private JTextField txtEmail;
	private JTextField txtBairro;
	private JTextField txtLogradouro;
	private JTextField txtNum;

	//Create Objects 
	ComboDao comboDao = new ComboDao();
	EnderecoDao endDao = new EnderecoDao();
	HospedeDao hospdao = new HospedeDao();
	ModelHospede modelHospede = new ModelHospede();
	ModelEndereco modelEndereco = new ModelEndereco();
	
	private JTextField txtCEP;
	
	public static void main(String[] args) {
		try {
			CadHospede dialog = new CadHospede();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadHospede() {
		setBounds(100, 100, 379, 474);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(10, 11, 349, 338);
		getContentPane().add(panel);
		
		JLabel label = new JLabel("RG");
		label.setBounds(184, 60, 46, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("CELULAR");
		label_1.setBounds(184, 111, 130, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("BAIRRO");
		label_2.setBounds(184, 213, 54, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("NUMERO DA CASA");
		label_3.setBounds(184, 264, 114, 14);
		panel.add(label_3);
		
		JLabel LabelLogradouro = new JLabel("LOGRADOURO");
		LabelLogradouro.setBounds(10, 264, 149, 14);
		panel.add(LabelLogradouro);
		
		JLabel label_5 = new JLabel("CIDADE");
		label_5.setBounds(10, 213, 46, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("E-MAIL");
		label_6.setBounds(10, 162, 46, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("TELEFONE");
		label_7.setBounds(10, 111, 78, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("CPF");
		label_8.setBounds(10, 60, 46, 14);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("NOME");
		label_9.setBounds(10, 11, 46, 14);
		panel.add(label_9);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 29, 325, 20);
		panel.add(txtNome);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(10, 80, 149, 20);
		panel.add(txtCPF);
		
		txtRG = new JTextField();
		txtRG.setColumns(10);
		txtRG.setBounds(184, 80, 151, 20);
		panel.add(txtRG);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(10, 131, 149, 20);
		panel.add(txtTel);
		
		txtCel = new JTextField();
		txtCel.setColumns(10);
		txtCel.setBounds(184, 131, 149, 20);
		panel.add(txtCel);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 182, 325, 20);
		panel.add(txtEmail);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(184, 233, 149, 20);
		panel.add(txtBairro);
		
		final JComboBox cboxCidade = new JComboBox();
		cboxCidade.setBounds(10, 233, 130, 20);
		panel.add(cboxCidade);
		//Refresh ComboBox
		comboDao.AtualizaCombo(cboxCidade, "cidade");
		
		JButton button = new JButton("...");
		button.setBounds(150, 232, 24, 22);
		panel.add(button);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(10, 282, 149, 20);
		panel.add(txtLogradouro);
		
		txtNum = new JTextField();
		txtNum.setColumns(10);
		txtNum.setBounds(184, 282, 46, 20);
		panel.add(txtNum);
		
		txtCEP = new JTextField();
		txtCEP.setText("87538000");
		txtCEP.setBounds(10, 318, 78, 20);
		panel.add(txtCEP);
		txtCEP.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Inserts Address
				modelEndereco.setBairro(txtBairro.getText());
				modelEndereco.setNumero(txtNum.getText());
				modelEndereco.setLogradouro(txtLogradouro.getText());
				modelEndereco.setCEP(txtCEP.getText());
				modelEndereco.setIdCidade(comboDao.FkRadio(cboxCidade)); // get ID ComboBox the city
				
				//Inserts Address on the table 
				endDao.adicionaEndereco(modelEndereco);
				
				//Inserts Guest
				modelHospede.setNome(txtNome.getText());
				modelHospede.setRG(txtRG.getText());
				modelHospede.setCPF(txtCPF.getText());
				modelHospede.setTelefone(txtTel.getText());
				modelHospede.setCelular(txtCel.getText());
				modelHospede.setEmail(txtEmail.getText());
				//Get last ID Address
				modelHospede.setId_end(endDao.ultimoID());
				
				//Inserts Guest on the table 
				hospdao.adicionaHospede(modelHospede);
				

			}
		});
		btnOk.setBounds(264, 355, 89, 23);
		getContentPane().add(btnOk);
	}
}
