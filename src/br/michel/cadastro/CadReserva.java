package br.michel.cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import br.michel.dao.ComboDao;
import br.michel.dao.ReservaDao;
import br.michel.modelo.ModelCombo;
import br.michel.modelo.ModelReserva;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.toedter.calendar.JDateChooser;

public class CadReserva extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtRequisitante;
	private JTextField txtTelefone;


	//Create
	ModelReserva modelReserva = new ModelReserva();
	ReservaDao reservaDao = new ReservaDao();
	ComboDao comboDao = new ComboDao();
	final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
	
	private JComboBox<ModelCombo> cboxFunc;
	private JComboBox<?> cboxStatus;
	private JComboBox<ModelCombo> cboxTipo;
	private JComboBox<ModelCombo> cboxNome;
	private JDateChooser dtAtual;
	private JDateChooser dtPrevista;
	
	public static void main(String[] args) {
		try {
			CadReserva dialog = new CadReserva();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadReserva() {
		setTitle("Reserva");
		setBounds(100, 100, 228, 489);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			panel.setBounds(10, 11, 196, 407);
			contentPanel.add(panel);
			{
				JLabel label = new JLabel("TIPO QUARTO");
				label.setBounds(10, 275, 84, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("DATA ATUAL");
				label.setBounds(10, 230, 93, 14);
				panel.add(label);
			}
			{
				cboxNome = new JComboBox<ModelCombo>();
				cboxNome.setBounds(10, 129, 136, 22);
				panel.add(cboxNome);
				comboDao.AtualizaCombo(cboxNome, "hospede");
			}
			{
				JLabel label = new JLabel("NOME");
				label.setBounds(10, 112, 46, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("SAIDA PREVISTA");
				label.setBounds(95, 230, 185, 14);
				panel.add(label);
			}
			{
				JButton button = new JButton("New button");
				button.setBounds(156, 130, 27, 22);
				panel.add(button);
			}
			{
				JButton button = new JButton("New button");
				button.setBounds(156, 29, 27, 22);
				panel.add(button);
			}
			{
				cboxFunc = new JComboBox<ModelCombo>();
				cboxFunc.setBounds(10, 28, 136, 22);
				panel.add(cboxFunc);
				//Refresh ComboBox
				comboDao.AtualizaCombo(cboxFunc, "funcionarios");
			}
			{
				JLabel label = new JLabel("FUNCIONARIO");
				label.setBounds(10, 11, 159, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("REQUISITANTE");
				label.setBounds(10, 61, 120, 14);
				panel.add(label);
			}
			{
				txtRequisitante = new JTextField();
				txtRequisitante.setColumns(10);
				txtRequisitante.setBounds(8, 78, 172, 20);
				panel.add(txtRequisitante);
			}
			{
				cboxTipo = new JComboBox<ModelCombo>();
				cboxTipo.setBounds(10, 299, 136, 22);
				panel.add(cboxTipo);
				comboDao.AtualizaCombo(cboxTipo, "tipoquarto");
			}
			{
				JButton button = new JButton("New button");
				button.setBounds(156, 300, 27, 22);
				panel.add(button);
			}
			{
				cboxStatus = new JComboBox();
				cboxStatus.setModel(new DefaultComboBoxModel(new String[] {"Aguardando", "Finalizado", "Cancelado"}));
				cboxStatus.setToolTipText("");
				cboxStatus.setBounds(10, 353, 136, 20);
				panel.add(cboxStatus);
			}
			{
				JLabel label = new JLabel("STATUS");
				label.setBounds(10, 332, 64, 14);
				panel.add(label);
			}
			
			txtTelefone = new JTextField();
			txtTelefone.setBounds(8, 199, 175, 20);
			panel.add(txtTelefone);
			txtTelefone.setColumns(10);
			
			JLabel lblTelefone = new JLabel("TELEFONE");
			lblTelefone.setBounds(10, 178, 136, 14);
			panel.add(lblTelefone);
			
			dtAtual = new JDateChooser();
			dtAtual.setBounds(0, 244, 87, 20);
			panel.add(dtAtual);
			
			dtPrevista = new JDateChooser();
			dtPrevista.setBounds(95, 244, 87, 20);
			panel.add(dtPrevista);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						modelReserva.setIdFunc( comboDao.FkRadio(cboxFunc) );
						modelReserva.setRequ(txtRequisitante.getText());
						modelReserva.setIdNome(comboDao.FkRadio(cboxNome));
						
						modelReserva.setTelefone( Integer.parseInt(txtTelefone.getText()) );
						modelReserva.setDataAtual( sdf.format( dtAtual.getDate()) );
						modelReserva.setDataFinal(sdf.format( dtPrevista.getDate()));
						modelReserva.setIdTipo(comboDao.FkRadio(cboxTipo));
						
						modelReserva.setStatus( (String) cboxStatus.getSelectedItem() );
						
						reservaDao.adicionaReserva(modelReserva);
						
						
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
