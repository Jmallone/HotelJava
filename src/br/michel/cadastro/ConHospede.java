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

import br.michel.dao.HospedeDao;
import br.michel.modelo.ModelHospede;
import br.michel.modelo.ModelSaida;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ConHospede extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	HospedeDao hospedeDao = new HospedeDao();
	ModelHospede modelHospede = new ModelHospede();

    final static DefaultTableModel modelo = new DefaultTableModel();
    
    static JTable tabela = new JTable(modelo);
    private JTextField txtBusca;
	
	
	public static void main(String[] args) {
		try {
			ConHospede dialog = new ConHospede();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void populaTable(){
		
		List<ModelHospede> hospede = hospedeDao.getLista();
		
		for (ModelHospede modelHospede : hospede) {

			modelo.addRow( new Object[]{ modelHospede.getNome(), modelHospede.getEmail(), modelHospede.getTelefone()});
			
		}
		
	}
	
	
	
	public ConHospede() {
		setTitle("Consultar Hospedes");
		setBounds(100, 100, 633, 418);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
	    modelo.addColumn("Nome");
	    modelo.addColumn("Email");
	    modelo.addColumn("Telefone");
	       
	   tabela.getColumnModel().getColumn(0).setPreferredWidth(450); 
	   tabela.getColumnModel().getColumn(1).setPreferredWidth(260); 
	   tabela.getColumnModel().getColumn(2).setPreferredWidth(100); 
	   
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
	   scrollPane.setBounds(10, 106, 497, 200);
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
			btnOk.setBounds(418, 317, 89, 23);
			getContentPane().add(btnOk);
		}
		{
			txtBusca = new JTextField();
			txtBusca.setBounds(10, 72, 209, 23);
			getContentPane().add(txtBusca);
			txtBusca.setColumns(10);
		}
		{
			JLabel lblProcurarPorNome = new JLabel("PROCURAR POR NOME:");
			lblProcurarPorNome.setBounds(10, 47, 163, 14);
			getContentPane().add(lblProcurarPorNome);
		}
	}

}
