package br.michel.pacote1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Editar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTextField txtNome;
	public static JTextField txtQuantidade;

	public static void editaProd(int id_Con){

		String sql = "SELECT * FROM caqui.produtos WHERE `idProdutos`='"+id_Con+"'";		
		try {
			
			ResultSet resposta = Conn.consulta( sql );
	      
	      while(resposta.next()){ 

				String umNome = resposta.getString( "produtos.Nome" );
				String qtd = resposta.getString("Quantidade");
				
				 txtNome.setText(umNome); 
				 txtQuantidade.setText(qtd); 
				 
				 JOptionPane.showMessageDialog(null, "NOME CARAI "+umNome+" "+qtd);
				 
				
				
	          }
	      } 
	      catch(SQLException ex){
	           System.out.println("SQLException: " + ex.getMessage());
	           System.out.println("SQLState: " + ex.getSQLState());
	           System.out.println("VendorError: " + ex.getErrorCode());
	      }
	}
	
	
	public Editar() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 45, 86, 20);
		contentPanel.add(txtNome);
		txtNome.setColumns(10);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(10, 102, 86, 20);
		contentPanel.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
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
