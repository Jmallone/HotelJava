package br.michel.pacote1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

public class Cad_Quartos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtStatus;
	private JTextField txtNum;
	private JComboBox comboBox;
	
	String Status, Num;
	int Id;
	
	
	public void clickConecta() {
		
		String sql = "INSERT INTO `caqui`.`quarto` (`Numero_Quarto`, `Status`, `TipoQuarto_idTipo`) VALUES ('"+Num+"', '"+Status+"', '"+Id+"')";
		
		Conn.ConectaSql(sql);
	}
	
	public Cad_Quartos() {
		setTitle("Quartos");
		setBounds(100, 100, 204, 205);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblDescrio = new JLabel("STATUS");
			lblDescrio.setBounds(10, 11, 85, 14);
			contentPanel.add(lblDescrio);
		}
		{
			txtStatus = new JTextField();
			txtStatus.setColumns(10);
			txtStatus.setBounds(10, 24, 164, 20);
			contentPanel.add(txtStatus);
		}
		{
			JLabel lblTipo = new JLabel("TIPO");
			lblTipo.setBounds(10, 55, 46, 14);
			contentPanel.add(lblTipo);
		}
		{
			JLabel lblNDoQuarto = new JLabel("N\u00BA DO QUARTO");
			lblNDoQuarto.setBounds(10, 101, 77, 14);
			contentPanel.add(lblNDoQuarto);
		}
		{
			txtNum = new JTextField();
			txtNum.setColumns(10);
			txtNum.setBounds(10, 115, 39, 20);
			contentPanel.add(txtNum);
		}
		{
			comboBox = new JComboBox();
			comboBox.setBounds(10, 70, 126, 20);
			contentPanel.add(comboBox);
			Control.Click(comboBox,"tipoquarto" );// Ira para função Click, que apagara todos os itens no ComboBox e Atualizara em seguida
		}
		{
			JButton button = new JButton("...");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Cad_TipoQuarto cadTipo = new Cad_TipoQuarto();
					cadTipo.setModal(true);
					cadTipo.setVisible(true);
					Control.Click(comboBox,"tipoquarto" );
					
				}
			});
			button.setBounds(146, 69, 26, 23);
			contentPanel.add(button);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						Status = txtStatus.getText();
						Num = txtNum.getText();
						Id = Control.FkRadio(comboBox);
						
						clickConecta();
						
						txtStatus.setText("");
						txtStatus.setText("");
						
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
	public void setVisible(boolean b){
		Control.Click(comboBox,"tipoquarto" );
		super.setVisible(b);
	}
}
