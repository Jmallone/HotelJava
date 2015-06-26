package br.michel.cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.michel.dao.ComboDao;
import br.michel.dao.SaidaDao;
import br.michel.modelo.ModelSaida;
import br.michel.modelo.ModelTipoQuarto;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadSaida extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtHorario;


	final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
	private JDateChooser dtDataAtual;
	private JDateChooser dtSaida;
	
	//Create Objects 
	ComboDao comboDao = new ComboDao();
	SaidaDao saidaDao = new SaidaDao();
	ModelSaida modelSaida = new ModelSaida();
	private JComboBox cboxHospede;
	
	public static void main(String[] args) {
		try {
			CadSaida dialog = new CadSaida();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadSaida() {
		setTitle("Saida");
		setBounds(100, 100, 365, 199);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		dtDataAtual = new JDateChooser();
		dtDataAtual.setBounds(10, 36, 100, 20);
		contentPanel.add(dtDataAtual);
		
		JLabel lblSelecionarData = new JLabel("SELECIONAR DATA");
		lblSelecionarData.setBounds(10, 11, 137, 14);
		contentPanel.add(lblSelecionarData);
		
		cboxHospede = new JComboBox();
		cboxHospede.setBounds(175, 36, 160, 20);
		contentPanel.add(cboxHospede);
		
		JLabel lblNomeDoHospede = new JLabel("NOME DO HOSPEDE");
		lblNomeDoHospede.setBounds(177, 11, 202, 14);
		contentPanel.add(lblNomeDoHospede);
		
		dtSaida = new JDateChooser();
		dtSaida.setBounds(10, 94, 87, 20);
		contentPanel.add(dtSaida);
		
		JLabel lblDataSaida = new JLabel("DATA SAIDA");
		lblDataSaida.setBounds(10, 69, 100, 14);
		contentPanel.add(lblDataSaida);
		
		txtHorario = new JTextField();
		txtHorario.setText("00:00");
		txtHorario.setBounds(133, 94, 87, 20);
		contentPanel.add(txtHorario);
		txtHorario.setColumns(10);
		
		JLabel lblHorarioSaida = new JLabel("HORARIO SAIDA");
		lblHorarioSaida.setBounds(133, 69, 116, 14);
		contentPanel.add(lblHorarioSaida);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//debug
				List<ModelSaida> valor = saidaDao.getLista( sdf.format( dtDataAtual.getDate() ) );
				
				for (ModelSaida modelSaida : valor) {

					String dado = modelSaida.getNome();
					int num = modelSaida.getIdHospedagem();
					System.out.println("Nome: "+dado+"  NUM:"+num+"\n");
				}
				
				//Adiciona os Hospedes do dia selecionado no ComboBox
				comboDao.AtualizaComboSaida(cboxHospede, sdf.format( dtDataAtual.getDate() ));
				
			}
		});
		btnNewButton.setBounds(117, 33, 47, 23);
		contentPanel.add(btnNewButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						modelSaida.setDataSaida(sdf.format(dtSaida.getDate()));
						modelSaida.setHorarioSaida(txtHorario.getText());
						modelSaida.setIdHospedagem(comboDao.FkRadio(cboxHospede));
						modelSaida.setStatus("Finalizado");
						
						saidaDao.adicionaSaida(modelSaida);
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
