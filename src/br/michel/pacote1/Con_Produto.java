package br.michel.pacote1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.*;
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

import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Con_Produto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
    final static DefaultTableModel modelo = new DefaultTableModel();
    
    static JTable tabela = new JTable(modelo);
    //tabela.setSelectionBackground(Color.YELLOW); 
    
	static Connection con = Conn.conectaMySQL();
    
	String ordem = "ORDER BY produtos.idProdutos";
	
	private JRadioButton rbttGrupo;
	private JRadioButton rbttUltimo;
	private JRadioButton rbttProduto;
	
	public void radio(String sql ) // Ordena a tabela
	{
		limpa_tabela(); // Limpa os resultados da tabela
		ordem = sql;
		atualiza();	// Chama a função de mostrar os resultados na tela
		
	}
	
    public void atualiza()
    {
		String sql = "SELECT produtos.idProdutos, produtos.Nome, produtos.Descricao, produtos.Valor, grupo_produtos.Nome, Quantidade FROM produtos LEFT JOIN grupo_produtos ON idGrupo_Produtos=Grupo_Produtos_idGrupo_Produtos "+ordem+";";		
		try {
			
			ResultSet resposta = Conn.consulta( sql );
	      
	      while(resposta.next()){ 
				int id = resposta.getInt( "produtos.idProdutos" );
				String id2 = Integer.toString(id) ;
				String umNome = resposta.getString( "produtos.Nome" );
				String umaDesc = resposta.getString( "produtos.Descricao" );
				String umValor = resposta.getString("produtos.Valor");
				String umGrupo = resposta.getString( "grupo_produtos.Nome" );
				String qtd = resposta.getString("Quantidade");
				//Adiconadno uma nova linha				
				
				modelo.addRow( new Object[]{id2 , umNome, umaDesc, "R$: "+umValor, umGrupo, qtd});
	      }
	           
	      // fim procedimento para obter os dados
	      } 
	      catch(SQLException ex){
	           System.out.println("SQLException: " + ex.getMessage());
	           System.out.println("SQLState: " + ex.getSQLState());
	           System.out.println("VendorError: " + ex.getErrorCode());
	      }
	      catch(Exception e){
	        System.out.println("Problemas ao tentar conectar com o banco de dados");	
	    }
    }
    
    public void limpa_tabela(){
    	
		int count = tabela.getRowCount();
		//JOptionPane.showMessageDialog(null, "Numero "+count );
		for(int i=0; i < count; i++){
			//JOptionPane.showMessageDialog(null, "Del "+i );
			modelo.removeRow(0);
		}
		
    }
	/**
	 * Create the dialog.
	 */
	public Con_Produto() {
		setBounds(100, 100, 570, 388);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
	    modelo.addColumn("Id");
	    modelo.addColumn("Nome");
	    modelo.addColumn("Descrição");
	    modelo.addColumn("Valor");
	    modelo.addColumn("Grupo");
	    modelo.addColumn("QTD");
	   tabela.getColumnModel().getColumn(0).setPreferredWidth(0); //ID 
	   tabela.getColumnModel().getColumn(2).setPreferredWidth(200); //Descrição 
	   tabela.getColumnModel().getColumn(3).setPreferredWidth(50); //Valor
	   tabela.getColumnModel().getColumn(4).setPreferredWidth(50); //Valor
	   limpa_tabela(); // Limpa os resultados da tabela
	   atualiza();	// Chama a função de mostrar os resultados na tela
	   
	    tabela.setPreferredScrollableViewportSize(new Dimension(350, 50));
		
	    Container c = getContentPane();
	    getContentPane().setLayout(null);
	    getContentPane().setLayout(null);
				
	    JScrollPane scrollPane = new JScrollPane(tabela);
	    scrollPane.setBounds(16, 5, 530, 257);
	    c.add(scrollPane);
	
	    
		getContentPane().add(contentPanel);
		
		JButton btnCancelar = new JButton("Cancelar ");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpa_tabela();
				atualiza();
				setVisible(false);
			}
		});
		btnCancelar.setBounds(457, 327, 89, 23);
		getContentPane().add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setBounds(16, 273, 397, 57);
		getContentPane().add(panel);
		
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Ordenar por:");
		panel.setBorder(title);
		panel.setLayout(null);
		
		rbttGrupo = new JRadioButton("Grupo");
		rbttGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				rbttProduto.setSelected( false );
				rbttUltimo.setSelected( false );
				
			}
		});
		rbttGrupo.setBounds(6, 27, 65, 23);
		panel.add(rbttGrupo);
		
		rbttProduto = new JRadioButton("C\u00F3digo Produto");
		rbttProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rbttGrupo.setSelected( false );
				rbttUltimo.setSelected( false );
			}
		});
		 rbttProduto.setBounds(73, 27, 113, 23);
		panel.add(rbttProduto);
		rbttUltimo = new JRadioButton("Ultimo Adicionado");
		rbttUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rbttGrupo.setSelected( false );
				rbttProduto.setSelected( false );
				
			}
		});
		rbttUltimo.setBounds(188, 27, 131, 23);
		panel.add(rbttUltimo);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rbttGrupo.isSelected())
				{
					String sql = "";
					radio(sql);
				}
				
				if(rbttProduto.isSelected())
				{
					String sql = "ORDER BY produtos.idProdutos";
					radio(sql);
				}

				
				if(rbttUltimo.isSelected())
				{
					String sql = "ORDER BY produtos.idProdutos DESC";
					radio(sql);
				}
				
			}
		});
		btnOk.setBounds(325, 25, 62, 23);
		panel.add(btnOk);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int linhaSel = tabela.getSelectedRow();
				int colunaSel = tabela.getSelectedColumn();
				String dado = tabela.getValueAt(linhaSel, 0).toString();
				JOptionPane.showMessageDialog(null, "Dado: "+dado);
				String sql ="DELETE FROM `caqui`.`produtos` WHERE `idProdutos`='"+dado+"'";
				Conn.ConectaSql(sql);
				limpa_tabela();
				atualiza();
			}
		});
		btnDeletar.setBounds(457, 293, 91, 23);
		getContentPane().add(btnDeletar);
		
	}
}
