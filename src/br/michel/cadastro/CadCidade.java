package br.michel.cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import br.michel.dao.CidadeDao;
import br.michel.dao.ComboDao;
import br.michel.modelo.ModelCidade;
import br.michel.modelo.ModelCombo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadCidade extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;


	//Create Objects 
	ComboDao comboDao = new ComboDao();
	ModelCidade modelCidade = new ModelCidade();
	CidadeDao cidadeDao = new CidadeDao();
	
	private JComboBox<ModelCombo> cboxEstado;
	
	public static void main(String[] args) {
		try {
			CadCidade dialog = new CadCidade();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadCidade() {
		setTitle("Cidade");
		setBounds(100, 100, 172, 205);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 29, 121, 20);
		contentPanel.add(txtNome);
		
		JLabel label = new JLabel("NOME");
		label.setBounds(10, 10, 46, 14);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("ESTADO");
		label_1.setBounds(10, 60, 46, 14);
		contentPanel.add(label_1);
		
		cboxEstado = new JComboBox<ModelCombo>();
		cboxEstado.setBounds(10, 76, 110, 20);
		contentPanel.add(cboxEstado);
		//Refresh ComboBox
		comboDao.AtualizaCombo(cboxEstado, "estado");
		
		JButton button = new JButton("...");
		button.setBounds(125, 75, 26, 23);
		contentPanel.add(button);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						modelCidade.setNome(txtNome.getText());
						modelCidade.setIdEstado(comboDao.FkRadio(cboxEstado));//get fk 
						
						//inserts table
						cidadeDao.adicionaCidade(modelCidade);
						
						
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
