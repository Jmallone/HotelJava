package br.michel.cadastro;

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

import br.michel.dao.ProdutoDao;
import br.michel.modelo.ModelProduto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConProduto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
    final static DefaultTableModel modelo = new DefaultTableModel();
    
    static JTable tabela = new JTable(modelo);
    
    ProdutoDao produtoDao = new ProdutoDao();
    ModelProduto modelProduto = new ModelProduto();
    
	public static void main(String[] args) {
		try {
			ConProduto dialog = new ConProduto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConProduto() {
		setTitle("Consultar Produtos");
		setBounds(100, 100, 640, 375);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		modelo.addColumn("ID");
	    modelo.addColumn("Nome");
	    modelo.addColumn("Valor");
	    modelo.addColumn("Quantidade");
	    modelo.addColumn("ID_grupo");
	   
	   tabela.getColumnModel().getColumn(0).setPreferredWidth(0); 
		tabela.getColumnModel().getColumn(0).setMinWidth(0);
		tabela.getColumnModel().getColumn(0).setMaxWidth(0);
		tabela.getColumnModel().getColumn(0).setWidth(0); 
		
	   tabela.getColumnModel().getColumn(1).setPreferredWidth(450); 
	   tabela.getColumnModel().getColumn(2).setPreferredWidth(260); 
	   tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
	   
	   tabela.getColumnModel().getColumn(4).setPreferredWidth(0); 
		tabela.getColumnModel().getColumn(4).setMinWidth(0);
		tabela.getColumnModel().getColumn(4).setMaxWidth(0);
		tabela.getColumnModel().getColumn(4).setWidth(0); 
	   
	   tabela.setPreferredScrollableViewportSize(new Dimension(350, 50));
	    
	   tabela.setPreferredScrollableViewportSize(new Dimension(350, 50));
	   
	   //refresh table 
		produtoDao.deletaTable(tabela, modelo);
		produtoDao.populaTable(modelo);
	

	   Container c = getContentPane();
	   getContentPane().setLayout(null);
	   getContentPane().setLayout(null);
	   getContentPane().setLayout(null);
	   getContentPane().setLayout(null);
	   getContentPane().setLayout(null);
					
	   final JScrollPane scrollPane = new JScrollPane(tabela);
	   scrollPane.setBounds(10, 11, 597, 219);
	   c.add(scrollPane);
	   
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
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
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int dado = (Integer) tabela.getValueAt(tabela.getSelectedRow(),0);
				
				//int dado2 = (Integer) tabela.getValueAt(tabela.getSelectedRow(),4);
				
				//System.out.println("ID: "+dado);
				
				CadProduto cadProduto = new CadProduto();
				cadProduto.editar(dado);
				cadProduto.setModal(true);
				cadProduto.setVisible(true);
				
				//refresh table 
				produtoDao.deletaTable(tabela, modelo);
				produtoDao.populaTable(modelo);
				
			}
		});
		btnEditar.setBounds(10, 257, 89, 23);
		getContentPane().add(btnEditar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modelProduto.setId((Integer) tabela.getValueAt(tabela.getSelectedRow(),0));
				
				produtoDao.deletarProduto(modelProduto);
				
				produtoDao.deletaTable(tabela, modelo);
				produtoDao.populaTable(modelo);
				
			}
		});
		btnDeletar.setBounds(131, 257, 89, 23);
		getContentPane().add(btnDeletar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(244, 257, 89, 23);
		getContentPane().add(btnCancelar);
	}
}
