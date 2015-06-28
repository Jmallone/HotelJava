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

import br.michel.dao.QuartoDao;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JRadioButton;

public class ConQuarto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	
    final static DefaultTableModel modelo = new DefaultTableModel();
    
    static JTable tabela = new JTable(modelo);
    
	final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    QuartoDao quartoDao = new QuartoDao();
    private JDateChooser dtData;
    private JRadioButton rbttDisponivel;
    private JRadioButton rbttOcupado;
    
	public static void main(String[] args) {
		try {
			ConQuarto dialog = new ConQuarto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConQuarto() {
		setTitle("Consultas de Quartos");
		setBounds(100, 100, 641, 429);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		modelo.addColumn("ID");
	    modelo.addColumn("Numero");
	    modelo.addColumn("Tipo");
	   
	   tabela.getColumnModel().getColumn(0).setPreferredWidth(0); 
		tabela.getColumnModel().getColumn(0).setMinWidth(0);
		tabela.getColumnModel().getColumn(0).setMaxWidth(0);
		tabela.getColumnModel().getColumn(0).setWidth(0); 
		
	   tabela.getColumnModel().getColumn(1).setPreferredWidth(150); 
	   tabela.getColumnModel().getColumn(2).setPreferredWidth(460); 
	   
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
	   scrollPane.setBounds(10, 136, 504, 219);
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
		dtData.setBounds(10, 44, 122, 20);
		getContentPane().add(dtData);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Ver os Quartos Disponiveis naquela data
				String sql = "select Numero_Quarto, tipoQuarto.Nome from quarto "
						+ "LEFt JOIN TipoQuarto ON TipoQuarto_idTipo = idtipoquarto "
						+ "where Numero_Quarto not in "
						+ "(SELECT quarto.Numero_Quarto FROM caqui.hospedagem  "
						+ "LEFt JOIN Quarto ON Quarto_idQuarto = idQuarto  "
						+ "LEFt JOIN TipoQuarto ON TipoQuarto_idTipo = idtipoquarto "
						+ "WHERE hospedagem.Data_Entrada like '2015-06-26' "
						+ "and hospedagem.status like 'Hospedado')";
				
				//ver os Quartos Ocupado
				String sql2 = "select Numero_Quarto, tipoQuarto.Nome, tipoquarto.Valor from quarto "
						+ "LEFt JOIN TipoQuarto ON TipoQuarto_idTipo = idtipoquarto "
						+ "where Numero_Quarto not in "
						+ "(SELECT quarto.Numero_Quarto FROM caqui.hospedagem  "
						+ "LEFt JOIN Quarto ON Quarto_idQuarto = idQuarto  "
						+ "LEFt JOIN TipoQuarto ON TipoQuarto_idTipo = idtipoquarto "
						+ "WHERE hospedagem.Data_Entrada like '2015-06-26' "
						+ "and hospedagem.status like 'Finalizado')";
				
				quartoDao.deletaTable(tabela, modelo);
				
				if(rbttDisponivel.isSelected())
				{
					quartoDao.populaTable(modelo, sdf.format( dtData.getDate() ), "ON");
				}
				
				if(rbttOcupado.isSelected())
				{
					quartoDao.populaTable(modelo, sdf.format( dtData.getDate() ), "OFF");
				}

				
			}
		});
		btnOk.setBounds(142, 44, 89, 23);
		getContentPane().add(btnOk);
		
		rbttDisponivel = new JRadioButton("Quartos Disponiveis");
		rbttDisponivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rbttOcupado.setSelected( false );
			}
		});
		rbttDisponivel.setBounds(6, 71, 171, 23);
		getContentPane().add(rbttDisponivel);
		
		rbttOcupado = new JRadioButton("Quartos Ocupados");
		rbttOcupado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbttDisponivel.setSelected( false );
			}
		});
		rbttOcupado.setBounds(6, 97, 142, 23);
		getContentPane().add(rbttOcupado);
	}
}
