package br.michel.cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.michel.dao.ComboDao;
import br.michel.dao.EntradaDao;
import br.michel.modelo.ModelCombo;
import br.michel.modelo.ModelEntrada;
import br.michel.modelo.ModelTipoQuarto;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;

public class CadEntrada extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtValor;
	private JTextField txtDesconto;
	private JTextField txtHora;

	//Create Objects 
	ComboDao comboDao = new ComboDao();
	ModelEntrada modelEntrada = new ModelEntrada();
	EntradaDao entradaDao = new EntradaDao();
	
	
	private JComboBox<ModelCombo> cboxFuncionario;
	private JComboBox<ModelCombo> cboxNumero;
	
	public static void main(String[] args) {
		try {
			CadEntrada dialog = new CadEntrada();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadEntrada() {
		setBounds(100, 100, 241, 433);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(10, 11, 211, 340);
		contentPanel.add(panel);
		
		final JComboBox<ModelCombo> cboxNome = new JComboBox<ModelCombo>();
		cboxNome.setBounds(10, 69, 136, 22);
		panel.add(cboxNome);
		//Refresh ComboBox
		comboDao.AtualizaCombo(cboxNome, "hospede");
		
		JButton button = new JButton("New button");
		button.setBounds(156, 70, 27, 22);
		panel.add(button);
		
		JLabel label = new JLabel("NOME");
		label.setBounds(10, 56, 46, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("DATA ATUAL");
		label_1.setBounds(10, 154, 93, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("SAIDA PREVISTA");
		label_2.setBounds(107, 154, 185, 14);
		panel.add(label_2);
		
		cboxFuncionario = new JComboBox<ModelCombo>();
		cboxFuncionario.setBounds(10, 23, 136, 22);
		panel.add(cboxFuncionario);
		//Refresh ComboBox
		comboDao.AtualizaCombo(cboxFuncionario, "funcionarios");
		
		JLabel label_7 = new JLabel("FUNCIONARIO");
		label_7.setBounds(10, 6, 159, 14);
		panel.add(label_7);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(156, 24, 27, 22);
		panel.add(button_1);
		
		cboxNumero = new JComboBox<ModelCombo>();
		cboxNumero.setBounds(10, 219, 76, 22);
		panel.add(cboxNumero);
		comboDao.AtualizaComboNum(cboxNumero, "quarto");
		
		JLabel lblNQuarto = new JLabel("N\u00BA QUARTO");
		lblNQuarto.setBounds(10, 199, 76, 14);
		panel.add(lblNQuarto);
		
		JLabel label_4 = new JLabel("VALOR DIARIA");
		label_4.setBounds(97, 199, 93, 14);
		panel.add(label_4);
		
		txtValor = new JTextField();
		txtValor.setEditable(false);
		txtValor.setBounds(97, 214, 64, 20);
		panel.add(txtValor);
		txtValor.setText("R$ 00,00");
		txtValor.setColumns(10);
		
		JLabel label_6 = new JLabel("HORARIO ENTRADA");
		label_6.setBounds(95, 245, 113, 14);
		panel.add(label_6);
		
		txtHora = new JTextField();
		txtHora.setBounds(97, 260, 63, 20);
		panel.add(txtHora);
		txtHora.setText("00:00");
		txtHora.setColumns(10);
		
		txtDesconto = new JTextField();
		txtDesconto.setBounds(10, 260, 64, 20);
		panel.add(txtDesconto);
		txtDesconto.setText("R$ 00,00");
		txtDesconto.setColumns(10);
		
		JLabel label_5 = new JLabel("DESCONTO");
		label_5.setBounds(10, 245, 64, 14);
		panel.add(label_5);
		
		final JDateChooser dtAtual = new JDateChooser();
		dtAtual.setBounds(10, 168, 87, 20);
		panel.add(dtAtual);
		
		final JDateChooser dtSaida = new JDateChooser();
		dtSaida.setBounds(105, 168, 87, 20);
		panel.add(dtSaida);
		
		final JComboBox<Object> cboxStatus = new JComboBox<Object>();
		cboxStatus.setModel(new DefaultComboBoxModel(new String[] {"Hospedado", "Finalizado"}));
		cboxStatus.setBounds(10, 123, 136, 20);
		panel.add(cboxStatus);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setBounds(10, 102, 93, 14);
		panel.add(lblStatus);
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						/*modelEntrada.setIdFunc( comboDao.FkRadio(cboxFuncionario) );
						modelEntrada.setIdNome( comboDao.FkRadio(cboxNome) );
						modelEntrada.setStatus( (String) cboxStatus.getSelectedItem() );
						modelEntrada.setDataAtual( sdf.format( dtAtual.getDate() ) );
						modelEntrada.setDataPrev( sdf.format( dtSaida.getDate() ) );
						modelEntrada.setIdNum( comboDao.FkRadio(cboxNumero) );
					    */
						
						
						List<ModelTipoQuarto> valor = entradaDao.getLista(comboDao.nomefk(cboxNumero));
						
						int dado = -1;
						
						for (ModelTipoQuarto modelEntrada : valor) {

							System.out.println("valor: " + modelEntrada.getValor()+"an NUM: ");
							dado = modelEntrada.getValor();
							  
						}
						
						txtValor.setText(""+dado);
						
						//JOptionPane.showMessageDialog(null, "DATA1: "+d+"\n DATA2: "+d2);
						
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
