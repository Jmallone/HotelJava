package br.michel.cadastro;

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

import br.michel.dao.EnderecoDao;
import br.michel.dao.HospedeDao;
import br.michel.modelo.ModelEndereco;
import br.michel.modelo.ModelHospede;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ConHospede extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	HospedeDao hospedeDao = new HospedeDao();
	ModelHospede modelHospede = new ModelHospede();
	CadHospede cadHospede = new CadHospede();
	ModelEndereco modelEndereco = new ModelEndereco();
	EnderecoDao enderecoDao = new EnderecoDao();
	
    final static DefaultTableModel modelo = new DefaultTableModel();
    
    static JTable tabela = new JTable(modelo);
	
	
	public static void main(String[] args) {
		try {
			ConHospede dialog = new ConHospede();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ConHospede() {
		setTitle("Consultar Hospedes");
		setBounds(100, 100, 633, 322);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		modelo.addColumn("ID");
	    modelo.addColumn("Nome");
	    modelo.addColumn("Email");
	    modelo.addColumn("Telefone");
	    modelo.addColumn("ID_end");
	   
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
		hospedeDao.deletaTable(tabela, modelo);
		hospedeDao.populaTable(modelo);
	   
	   Container c = getContentPane();
	   getContentPane().setLayout(null);
	   getContentPane().setLayout(null);
	   getContentPane().setLayout(null);
	   getContentPane().setLayout(null);
					
	   final JScrollPane scrollPane = new JScrollPane(tabela);
	   scrollPane.setBounds(10, 11, 597, 219);
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
		{
			JButton btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					hospedeDao.deletaTable(tabela, modelo);
					hospedeDao.populaTable(modelo);
					
					
				}
			});
			btnOk.setBounds(238, 241, 89, 23);
			getContentPane().add(btnOk);
		}
		{
			JButton btnEditar = new JButton("Editar");
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//TODO:Pega a ID do Hospede para editar
					int dado = (Integer) tabela.getValueAt(tabela.getSelectedRow(),0);
					
					int dado2 = (Integer) tabela.getValueAt(tabela.getSelectedRow(),4);
					
					//System.out.println("ID: "+dado+"\n END: "+dado2);
					
					modelEndereco.setIdCidade(dado2);
					enderecoDao.deletaEndereco(modelEndereco);
					
					modelHospede.setId(dado);
					hospedeDao.deletaHospede(modelHospede);
					

					
					
				}
			});
			btnEditar.setBounds(10, 241, 89, 23);
			getContentPane().add(btnEditar);
		}
		{
			JButton btnDeletar = new JButton("Deletar");
			btnDeletar.setBounds(125, 241, 89, 23);
			getContentPane().add(btnDeletar);
		}
	}

}
