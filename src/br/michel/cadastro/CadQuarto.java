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
import br.michel.dao.QuartoDao;
import br.michel.modelo.ModelCombo;
import br.michel.modelo.ModelQuarto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadQuarto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtStatus;
	private JTextField txtNumero;

	//Create Objects 
	ComboDao comboDao = new ComboDao();
	ModelQuarto modelQuarto = new ModelQuarto();
	QuartoDao quartoDao = new QuartoDao();
	
	private JComboBox<ModelCombo> cboxTipo;
	
	public static void main(String[] args) {
		try {
			CadQuarto dialog = new CadQuarto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadQuarto() {
		setTitle("Quarto");
		setBounds(100, 100, 215, 243);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(10, 11, 188, 151);
		contentPanel.add(panel);
		
		//TODO: Mudar Status para um ComboBox 'Aguardando, Finalizado, Cancelado'
		JLabel label = new JLabel("STATUS");
		label.setBounds(10, 11, 85, 14);
		panel.add(label);
		
		txtStatus = new JTextField();
		txtStatus.setColumns(10);
		txtStatus.setBounds(10, 24, 164, 20);
		panel.add(txtStatus);
		
		JLabel label_1 = new JLabel("TIPO");
		label_1.setBounds(10, 55, 46, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("N\u00BA DO QUARTO");
		label_2.setBounds(10, 101, 126, 14);
		panel.add(label_2);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(10, 115, 39, 20);
		panel.add(txtNumero);
		
		cboxTipo = new JComboBox<ModelCombo>();
		cboxTipo.setBounds(10, 70, 126, 20);
		panel.add(cboxTipo);
		//Refresh ComboBox
		comboDao.AtualizaCombo(cboxTipo, "tipoquarto");
		
		JButton button = new JButton("...");
		button.setBounds(146, 69, 26, 23);
		panel.add(button);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						modelQuarto.setStatus(txtStatus.getText());
						modelQuarto.setNum(txtNumero.getText());
						modelQuarto.setIdTipo(comboDao.FkRadio(cboxTipo));//get fk type room
						
						//Inserts table
						quartoDao.adicionaQuarto(modelQuarto);
						
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
