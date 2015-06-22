package br.michel.cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import br.michel.dao.ComboDao;
import br.michel.dao.GrupoProdDao;
import br.michel.modelo.ModelGrupoProd;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadGrupoProd extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	private JTextField txtDesc;


	//Create Objects 
	ComboDao comboDao = new ComboDao();
	ModelGrupoProd modelGrupoProd = new ModelGrupoProd();
	GrupoProdDao grupoProdDao = new GrupoProdDao();
	
	public static void main(String[] args) {
		try {
			CadGrupoProd dialog = new CadGrupoProd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadGrupoProd() {
		setTitle("Grupo Produtos");
		setBounds(100, 100, 202, 249);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 36, 126, 20);
		contentPanel.add(txtNome);
		txtNome.setColumns(10);
		
		txtDesc = new JTextField();
		txtDesc.setBounds(10, 102, 126, 20);
		contentPanel.add(txtDesc);
		txtDesc.setColumns(10);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setBounds(10, 19, 148, 20);
		contentPanel.add(lblNome);
		
		JLabel lblDescrio = new JLabel("DESCRI\u00C7\u00C3O");
		lblDescrio.setBounds(10, 67, 200, 50);
		contentPanel.add(lblDescrio);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Inserts product group
				modelGrupoProd.setNome(txtNome.getText());
				modelGrupoProd.setDesc(txtDesc.getText());
				
				//Insets on Table
				grupoProdDao.adicionaGrupoProd(modelGrupoProd);
				
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);


		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
			

	}

}
