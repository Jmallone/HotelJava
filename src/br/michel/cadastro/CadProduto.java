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
import br.michel.dao.ProdutoDao;
import br.michel.modelo.ModelCombo;
import br.michel.modelo.ModelProduto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadProduto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	private JTextField txtDesc;
	private JTextField txtValor;
	private JTextField TxtQuantidade;

	//Create Objects 
	ComboDao comboDao = new ComboDao();
	ModelProduto modelProduto = new ModelProduto();
	ProdutoDao produtoDao = new ProdutoDao();
	
	private JComboBox<ModelCombo> cboxGrupo;
	
	
	public static void main(String[] args) {
		try {
			CadProduto dialog = new CadProduto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadProduto() {
		setTitle("Produto");
		setBounds(100, 100, 194, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(10, 11, 153, 193);
		contentPanel.add(panel);
		
		JLabel label = new JLabel("NOME");
		label.setBounds(10, 11, 58, 14);
		panel.add(label);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 25, 135, 20);
		panel.add(txtNome);
		
		JLabel label_1 = new JLabel("GRUPO");
		label_1.setBounds(10, 56, 46, 14);
		panel.add(label_1);
		
		cboxGrupo = new JComboBox<ModelCombo>();
		cboxGrupo.setEditable(true);
		cboxGrupo.setBounds(10, 70, 107, 20);
		panel.add(cboxGrupo);
		//Refresh ComboBox
		comboDao.AtualizaCombo(cboxGrupo, "grupo_produtos");
		
		
		JButton button = new JButton("New button");
		button.setBounds(120, 71, 25, 20);
		panel.add(button);
		
		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		txtDesc.setBounds(10, 116, 135, 20);
		panel.add(txtDesc);
		
		JLabel label_2 = new JLabel("DESCRI\u00C7\u00C3O");
		label_2.setBounds(10, 101, 71, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("VALOR");
		label_3.setBounds(10, 147, 46, 14);
		panel.add(label_3);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(10, 161, 71, 20);
		panel.add(txtValor);
		
		JLabel label_4 = new JLabel("QTD");
		label_4.setBounds(99, 147, 46, 14);
		panel.add(label_4);
		
		TxtQuantidade = new JTextField();
		TxtQuantidade.setColumns(10);
		TxtQuantidade.setBounds(96, 161, 47, 20);
		panel.add(TxtQuantidade);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						modelProduto.setNome(txtNome.getText());
						modelProduto.setIdGrupo(comboDao.FkRadio(cboxGrupo)); // get fk group prod
						modelProduto.setDesc(txtDesc.getText());
						modelProduto.setValor(txtValor.getText());
						modelProduto.setQtd(TxtQuantidade.getText());
						
						//inserts table 
						produtoDao.adicionaProduto(modelProduto);
						
					}
				});
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
