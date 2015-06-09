package br.michel.pacote1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Con_Cliente extends JDialog {

	private final JPanel contentPanel = new JPanel();

    final static DefaultTableModel modelo = new DefaultTableModel();
    
    static JTable tabela = new JTable(modelo);
    
	static Connection con = Conn.conectaMySQL();
	
	String detalhe = "";
	private JRadioButton rrtt_Basico;
	private JRadioButton rtt_detalhado;
	
    public void limpa_tabela(){
    	
		int count = tabela.getRowCount();
		for(int i=0; i < count; i++){
			
			modelo.removeRow(0);
		}
		
    }
    
    public void atualiza()
    {
		String sql = "SELECT hospede.idHospede, hospede.Nome, endereco.Logradouro, cidade.Nome, estado.Nome , hospede.Email, hospede.Telefone, hospede.Celular "
				+ "FROM hospede "
				+ "LEFt JOIN endereco ON idHospede = idEndereco "
				+ "Left join cidade ON Cidade_idCidade=idCidade "
				+ "Left join estado ON Estado_idEstado=idEstado "
				+ "ORDER BY hospede.idHospede";
		
		try {
			
			ResultSet resposta = Conn.consulta( sql );
	     
	      while(resposta.next()){
				String id2 = Integer.toString( resposta.getInt( "hospede.idHospede") ) ;
				String umNome = resposta.getString( "hospede.Nome" );
				String umaRua = resposta.getString( "endereco.Logradouro" );
				String umaCity = resposta.getString( "cidade.Nome" );
				String umEstado = resposta.getString("estado.Nome");
				

					String umEmail = resposta.getString("hospede.Email");
					String umTelefone = resposta.getString("hospede.Telefone");
					String umCelular = resposta.getString("hospede.Celular");
					modelo.addRow( new Object[]{id2 , umNome, umaRua, umaCity, umEstado, umEmail, umTelefone, umCelular});
					
	      	}   
	      } 
	      catch(SQLException ex){
	           System.out.println("SQLException: " + ex.getMessage());
	           System.out.println("SQLState: " + ex.getSQLState());
	           System.out.println("VendorError: " + ex.getErrorCode());
	      }
    }
    
	public Con_Cliente() {
		setBounds(100, 100, 541, 333);
		
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
	    modelo.addColumn("Id");
	    modelo.addColumn("Nome");
	    modelo.addColumn("Rua");
	    modelo.addColumn("Cidade");
	    modelo.addColumn("Estado");
	    modelo.addColumn("Email");
	    modelo.addColumn("Telefone");
	    modelo.addColumn("Celular");
	       
	   tabela.getColumnModel().getColumn(0).setPreferredWidth(50); //ID 
	   tabela.getColumnModel().getColumn(1).setPreferredWidth(260); //Nome
	   tabela.getColumnModel().getColumn(2).setPreferredWidth(200); //Rua
	   tabela.getColumnModel().getColumn(3).setPreferredWidth(100); //cidade
	   tabela.getColumnModel().getColumn(4).setPreferredWidth(100); //Estado
	   tabela.getColumnModel().getColumn(5).setPreferredWidth(300); //Email
	   tabela.getColumnModel().getColumn(6).setPreferredWidth(100); //Telefone
	   tabela.getColumnModel().getColumn(7).setPreferredWidth(100); //celular
		
	   limpa_tabela(); // Limpa os resultados da tabela
	   atualiza();	// Chama a função de mostrar os resultados na tela
	   
		for(int i = 5; i <= 7; i++)
		{
			tabela.getColumnModel().getColumn(i).setMinWidth(0);
			tabela.getColumnModel().getColumn(i).setMaxWidth(0);
			tabela.getColumnModel().getColumn(i).setWidth(0); 
		}
	    
	   
	   tabela.setPreferredScrollableViewportSize(new Dimension(350, 50));
		    
	   tabela.setPreferredScrollableViewportSize(new Dimension(350, 50));
		
		Container c = getContentPane();
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
					
		final JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(16, 5, 500, 200);
		c.add(scrollPane);
		    
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 211, 310, 39);
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Detalhes:");
		panel.setBorder(title);
		panel.setLayout(null);
		contentPanel.add(panel);
		
		rrtt_Basico = new JRadioButton("Basico");
		rrtt_Basico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rtt_detalhado.setSelected( false );
			}
		});
		rrtt_Basico.setBounds(6, 18, 84, 14);
		panel.add(rrtt_Basico);
		
		rtt_detalhado = new JRadioButton("Detalhado");
		rtt_detalhado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rrtt_Basico.setSelected( false );
			}
		});
		rtt_detalhado.setBounds(112, 18, 93, 14);
		panel.add(rtt_detalhado);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rrtt_Basico.isSelected())
				{ 	
					
					for(int i = 5; i <= 7; i++)
					{
						tabela.getColumnModel().getColumn(i).setMinWidth(0);
						tabela.getColumnModel().getColumn(i).setMaxWidth(0);
						tabela.getColumnModel().getColumn(i).setWidth(0); 
					}	   
					
					tabela.getColumnModel().getColumn(0).setPreferredWidth(50); //ID 
					tabela.getColumnModel().getColumn(1).setPreferredWidth(260); //Nome
					tabela.getColumnModel().getColumn(2).setPreferredWidth(200); //Rua
					tabela.getColumnModel().getColumn(3).setPreferredWidth(150); //cidade
					tabela.getColumnModel().getColumn(4).setPreferredWidth(100); //Estado
					   
				    scrollPane.setBounds(16, 5, 500, 200);
				    setBounds(100, 100, 541, 333);
					
					limpa_tabela();
					atualiza();
				}
				
				if(rtt_detalhado.isSelected())
				{	
					
					for(int i = 5; i <= 7; i++)
					{
						tabela.getColumnModel().getColumn(i).setMinWidth(100);
						tabela.getColumnModel().getColumn(i).setMaxWidth(100);
						tabela.getColumnModel().getColumn(i).setWidth(100); 
					}
					
				    scrollPane.setBounds(16, 5, 800, 200);
				    setBounds(100, 100, 841, 333);
				   
					limpa_tabela();
					atualiza();

					tabela.getColumnModel().getColumn(5).setPreferredWidth(300); //Email
					tabela.getColumnModel().getColumn(6).setPreferredWidth(100); //Telefone
					tabela.getColumnModel().getColumn(7).setPreferredWidth(100); //celular

				}
				
			}
		});
		btnNewButton.setBounds(218, 12, 70, 20);
		panel.add(btnNewButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
						limpa_tabela();
						atualiza();
					}
				});
				
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
