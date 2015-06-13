package br.michel.pacote1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class Con_Quartos extends JDialog {

	private final JPanel contentPanel = new JPanel();
    final static DefaultTableModel modelo = new DefaultTableModel();
    
    static JTable tabela = new JTable(modelo);
	static Connection con = Conn.conectaMySQL();
	private JTextField textField;
	
	
	public Con_Quartos() {
		setBounds(100, 100, 570, 413);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
	    modelo.addColumn("NUMERO");
	    modelo.addColumn("STATUS");
	    modelo.addColumn("VALOR");
	    modelo.addColumn("DESCRIÇÃO");
	   tabela.getColumnModel().getColumn(0).setPreferredWidth(0); //Numero 
	   tabela.getColumnModel().getColumn(1).setPreferredWidth(200); //Status 
	   tabela.getColumnModel().getColumn(2).setPreferredWidth(50); //Valor
	   tabela.getColumnModel().getColumn(3).setPreferredWidth(50); //Descrição
	   
	   
	    tabela.setPreferredScrollableViewportSize(new Dimension(350, 50));
		
	    Container c = getContentPane();
	    getContentPane().setLayout(null);
	    getContentPane().setLayout(null);
	    getContentPane().setLayout(null);
				
	    JScrollPane scrollPane = new JScrollPane(tabela);
	    scrollPane.setBounds(10, 58, 530, 257);
	    c.add(scrollPane);
		
		getContentPane().add(contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 0, 0, 0);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
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
		
		textField = new JTextField();
		textField.setText("00/00/00");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(10, 27, 68, 20);
		getContentPane().add(textField);
		
		JLabel lblConsultarData = new JLabel("CONSULTAR DATA");
		lblConsultarData.setBounds(11, 11, 185, 14);
		getContentPane().add(lblConsultarData);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(157, 27, 107, 20);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("TIPO DE QUARTO");
		lblNewLabel.setBounds(157, 11, 107, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("CONSULTAR");
		btnNewButton.setBounds(292, 26, 112, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(455, 341, 89, 23);
		getContentPane().add(btnCancelar);
	}
}
