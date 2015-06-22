package br.michel.cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import br.michel.dao.TipoQuartoDao;
import br.michel.modelo.ModelTipoQuarto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadTipoQuarto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	private JTextField txtDesc;
	private JTextField txtValor;
	
	//Create Objects 
	ModelTipoQuarto modelTipoQuarto = new ModelTipoQuarto();
	TipoQuartoDao tipoQuartoDao = new TipoQuartoDao();
	
	
	public static void main(String[] args) {
		try {
			CadTipoQuarto dialog = new CadTipoQuarto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadTipoQuarto() {
		setTitle("Tipo Quarto");
		setBounds(100, 100, 207, 302);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			panel.setBounds(10, 11, 171, 209);
			contentPanel.add(panel);
			{
				txtNome = new JTextField();
				txtNome.setColumns(10);
				txtNome.setBounds(10, 28, 126, 20);
				panel.add(txtNome);
			}
			{
				txtDesc = new JTextField();
				txtDesc.setColumns(10);
				txtDesc.setBounds(10, 78, 126, 55);
				panel.add(txtDesc);
			}
			{
				txtValor = new JTextField();
				txtValor.setColumns(10);
				txtValor.setBounds(10, 162, 60, 20);
				panel.add(txtValor);
			}
			{
				JLabel label = new JLabel("TIPO");
				label.setBounds(10, 11, 46, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("DESCRI\u00C7\u00C3O");
				label.setBounds(10, 59, 96, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("VALOR");
				label.setBounds(10, 144, 46, 14);
				panel.add(label);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						modelTipoQuarto.setNome(txtNome.getText());
						modelTipoQuarto.setDesc(txtDesc.getText());
						modelTipoQuarto.setValor( Integer.parseInt( txtValor.getText()));//convert string to int 
						
						//Inserts table
						tipoQuartoDao.adicionaTipoQuarto(modelTipoQuarto);
						
						
						
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
