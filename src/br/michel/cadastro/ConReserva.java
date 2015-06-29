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

import br.michel.dao.ReservaDao;
import br.michel.modelo.ModelReserva;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ConReserva extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

    final static DefaultTableModel modelo = new DefaultTableModel();
    
    static JTable tabela = new JTable(modelo);
    
    ReservaDao reservaDao = new ReservaDao();
    ModelReserva modelReserva = new ModelReserva();
    
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    
    private JDateChooser dtData;
    
    
    
	public static void main(String[] args) {
		try {
			ConReserva dialog = new ConReserva();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConReserva() {
		setTitle("Consulta Reserva");
		setBounds(100, 100, 639, 442);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		modelo.addColumn("ID");
	    modelo.addColumn("Nome");
	    modelo.addColumn("Tipo");
	    modelo.addColumn("Status");
	    modelo.addColumn("Telefone");
	    modelo.addColumn("ID_grupo");
	   
	   tabela.getColumnModel().getColumn(0).setPreferredWidth(0); 
		tabela.getColumnModel().getColumn(0).setMinWidth(0);
		tabela.getColumnModel().getColumn(0).setMaxWidth(0);
		tabela.getColumnModel().getColumn(0).setWidth(0); 
		
	   tabela.getColumnModel().getColumn(1).setPreferredWidth(450); 
	   tabela.getColumnModel().getColumn(2).setPreferredWidth(260); 
	   tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
	   
	   tabela.getColumnModel().getColumn(4).setPreferredWidth(300);
	   
	   tabela.getColumnModel().getColumn(5).setPreferredWidth(0); 
		tabela.getColumnModel().getColumn(5).setMinWidth(0);
		tabela.getColumnModel().getColumn(5).setMaxWidth(0);
		tabela.getColumnModel().getColumn(5).setWidth(0); 
	   
	   tabela.setPreferredScrollableViewportSize(new Dimension(350, 50));
	    
	   tabela.setPreferredScrollableViewportSize(new Dimension(350, 50));
	   

	

	   Container c = getContentPane();
	   getContentPane().setLayout(null);
	   getContentPane().setLayout(null);
	   getContentPane().setLayout(null);
	   getContentPane().setLayout(null);
	   getContentPane().setLayout(null);
	   getContentPane().setLayout(null);
					
	   final JScrollPane scrollPane = new JScrollPane(tabela);
	   scrollPane.setBounds(10, 94, 597, 219);
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
		
		dtData = new JDateChooser();
		dtData.setBounds(10, 42, 90, 20);
		getContentPane().add(dtData);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//refresh table 
				reservaDao.deletaTable(tabela, modelo);
				reservaDao.populaTable(modelo, sdf.format( dtData.getDate() ));
			}
		});
		btnOk.setBounds(110, 42, 89, 23);
		getContentPane().add(btnOk);
		
		JButton btnCancelarReserva = new JButton("Cancelar Reserva");
		btnCancelarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modelReserva.setIdNome((Integer) tabela.getValueAt(tabela.getSelectedRow(),0));
				
				reservaDao.cancelarReserva(modelReserva, "Cancelado");
				
				reservaDao.deletaTable(tabela, modelo);
				reservaDao.populaTable(modelo, sdf.format( dtData.getDate() ));
				
			}
		});
		btnCancelarReserva.setBounds(10, 324, 178, 23);
		getContentPane().add(btnCancelarReserva);
		
		JButton btnNewButton = new JButton("Hospedar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modelReserva.setIdNome((Integer) tabela.getValueAt(tabela.getSelectedRow(),0));
				
				reservaDao.cancelarReserva(modelReserva, "Hospedado");
				
				reservaDao.deletaTable(tabela, modelo);
				reservaDao.populaTable(modelo, sdf.format( dtData.getDate() ));
				
				CadEntrada cadEntrada = new CadEntrada();
				cadEntrada.setModal(true);
				cadEntrada.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(243, 324, 137, 23);
		getContentPane().add(btnNewButton);
	}
}
