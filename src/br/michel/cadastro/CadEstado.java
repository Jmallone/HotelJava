package br.michel.cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import br.michel.dao.EstadoDao;
import br.michel.modelo.ModelEstado;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadEstado extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;

	//Create Objects 
	ModelEstado modelEstado = new ModelEstado();
	EstadoDao estadoDao = new EstadoDao();
	
	public static void main(String[] args) {
		try {
			CadEstado dialog = new CadEstado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadEstado() {
		setTitle("Estado");
		setBounds(100, 100, 161, 161);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtNome = new JTextField();
			txtNome.setBounds(10, 38, 120, 25);
			contentPanel.add(txtNome);
			txtNome.setColumns(10);
		}
		{
			JLabel lblEstado = new JLabel("ESTADO");
			lblEstado.setBounds(11, 0, 200, 50);
			contentPanel.add(lblEstado);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						modelEstado.setNome(txtNome.getText());
						
						//inserts table 
						estadoDao.adicionaEstado(modelEstado);
						
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
