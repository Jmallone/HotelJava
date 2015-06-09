package br.michel.pacote1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;

public class Con_Cidade extends JDialog {

	private final JPanel contentPanel = new JPanel();

    final static DefaultTableModel modelo = new DefaultTableModel();
    
    static JTable tabela = new JTable(modelo);
    
	static Connection con = Conn.conectaMySQL();
	
	String ordem = "ORDER BY cidade.idcidade";
	private JRadioButton rbttEstado;
	private JRadioButton rbttCidade;
	private JRadioButton rbttAdicionado;
    
	public void radio(String sql ) // Ordena a tabela
	{

		limpa_tabela(); // Limpa os resultados da tabela
		ordem = sql;
		atualiza();	// Chama a função de mostrar os resultados na tela
		
	}
	
    public void limpa_tabela(){
    	
		int count = tabela.getRowCount();
		
		for(int i=0; i < count; i++){
			
			modelo.removeRow(0);
		}
		
    }
    
    public void atualiza()
    {
		String sql = "SELECT cidade.idcidade, cidade.Nome, estado.Nome FROM cidade LEFt JOIN estado ON idEstado = Estado_idEstado "+ordem+";";
		try {
			
			ResultSet resposta = Conn.consulta( sql );
	     
	      while(resposta.next()){ 
				int id = resposta.getInt( "cidade.idcidade" );
				String id2 = Integer.toString(id) ;
				String umNome = resposta.getString( "cidade.Nome" );
				String umaDesc = resposta.getString( "estado.Nome" );
				//Adiconadno uma nova linha				
				
				modelo.addRow( new Object[]{id2 , umNome, umaDesc});
	      }
	           
	      // fim procedimento para obter os dados
	      } 
	      catch(SQLException ex){
	           System.out.println("SQLException: " + ex.getMessage());
	           System.out.println("SQLState: " + ex.getSQLState());
	           System.out.println("VendorError: " + ex.getErrorCode());
	      }
	      catch(Exception e){
	        System.out.println("Problemas ao tentar conectar com o banco de dados "+ e);	
	    }
    }
	
	public Con_Cidade() {
		setBounds(100, 100, 502, 300);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
	    modelo.addColumn("Id");
	    modelo.addColumn("Nome");
	    modelo.addColumn("Estado");
	   tabela.getColumnModel().getColumn(0).setPreferredWidth(50); //ID 
	   tabela.getColumnModel().getColumn(1).setPreferredWidth(200); //Descrição 
	   tabela.getColumnModel().getColumn(2).setPreferredWidth(200); //Valor
	   limpa_tabela(); // Limpa os resultados da tabela
	   atualiza();	// Chama a função de mostrar os resultados na tela
	   
	    tabela.setPreferredScrollableViewportSize(new Dimension(350, 50));
	    
	    tabela.setPreferredScrollableViewportSize(new Dimension(350, 50));
		
	    Container c = getContentPane();
	    getContentPane().setLayout(null);
	    getContentPane().setLayout(null);
	    getContentPane().setLayout(null);
				
	    JScrollPane scrollPane = new JScrollPane(tabela);
	    scrollPane.setBounds(16, 5, 300, 250);
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
		
		JPanel panel = new JPanel();
		panel.setBounds(326, 6, 148, 140);
		getContentPane().add(panel);
		
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Ordenar por:");
		panel.setBorder(title);
		panel.setLayout(null);
		
		rbttEstado = new JRadioButton("Estado");
		rbttEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbttCidade.setSelected( false );
				rbttAdicionado.setSelected( false );
			}
		});
		rbttEstado.setBounds(6, 22, 86, 23);
		panel.add(rbttEstado);
		
		rbttCidade = new JRadioButton("Id Cidade");
		rbttCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbttEstado.setSelected( false );
				rbttAdicionado.setSelected( false );
			}
		});
		rbttCidade.setBounds(6, 48, 86, 23);
		panel.add(rbttCidade);
		
		rbttAdicionado = new JRadioButton("Ultimo Adicionado");
		rbttAdicionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbttCidade.setSelected( false );
				rbttEstado.setSelected( false );
			}
		});
		rbttAdicionado.setBounds(6, 74, 132, 23);
		panel.add(rbttAdicionado);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rbttEstado.isSelected())
				{
					String sql = "ORDER BY estado.idEstado";
					radio(sql);
				}
				
				if(rbttCidade.isSelected())
				{
					String sql = "ORDER BY cidade.idcidade";
					radio(sql);
				}

				
				if(rbttAdicionado.isSelected())
				{
					String sql = "ORDER BY cidade.idcidade DESC";
					radio(sql);
				}
				
			}
		});
		btnOk.setBounds(36, 104, 89, 23);
		panel.add(btnOk);
		
		JButton button = new JButton("Cancelar ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpa_tabela();
				atualiza();
				setVisible(false);
			}
		});
		button.setBounds(361, 149, 89, 23);
		getContentPane().add(button);
	}
}
