package br.michel.cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CadEntrada extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtAtual;
	private JTextField txtPrevista;
	private JTextField txtValor;
	private JTextField txtDesconto;
	private JTextField txtHora;

	 
	
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
		setBounds(100, 100, 241, 420);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(10, 11, 211, 240);
		contentPanel.add(panel);
		
		JComboBox cboxNome = new JComboBox();
		cboxNome.setBounds(10, 69, 136, 22);
		panel.add(cboxNome);
		
		JButton button = new JButton("New button");
		button.setBounds(156, 70, 27, 22);
		panel.add(button);
		
		JLabel label = new JLabel("NOME");
		label.setBounds(10, 56, 46, 14);
		panel.add(label);
		
		txtAtual = new JTextField();
		txtAtual.setText("00/00/00");
		txtAtual.setHorizontalAlignment(SwingConstants.CENTER);
		txtAtual.setColumns(10);
		txtAtual.setBounds(10, 116, 64, 20);
		panel.add(txtAtual);
		
		JLabel label_1 = new JLabel("DATA ATUAL");
		label_1.setBounds(10, 102, 93, 14);
		panel.add(label_1);
		
		txtPrevista = new JTextField();
		txtPrevista.setText("00/00/00");
		txtPrevista.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrevista.setColumns(10);
		txtPrevista.setBounds(94, 116, 64, 20);
		panel.add(txtPrevista);
		
		JLabel label_2 = new JLabel("SAIDA PREVISTA");
		label_2.setBounds(95, 102, 185, 14);
		panel.add(label_2);
		
		JComboBox cboxFuncionario = new JComboBox();
		cboxFuncionario.setBounds(10, 23, 136, 22);
		panel.add(cboxFuncionario);
		
		JLabel label_7 = new JLabel("FUNCIONARIO");
		label_7.setBounds(10, 6, 159, 14);
		panel.add(label_7);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(156, 24, 27, 22);
		panel.add(button_1);
		
		JComboBox cboxNumero = new JComboBox();
		cboxNumero.setBounds(10, 167, 76, 22);
		panel.add(cboxNumero);
		
		JLabel lblNQuarto = new JLabel("N\u00BA QUARTO");
		lblNQuarto.setBounds(10, 147, 76, 14);
		panel.add(lblNQuarto);
		
		JLabel label_4 = new JLabel("VALOR DIARIA");
		label_4.setBounds(97, 147, 93, 14);
		panel.add(label_4);
		
		txtValor = new JTextField();
		txtValor.setBounds(97, 162, 64, 20);
		panel.add(txtValor);
		txtValor.setText("R$ 00,00");
		txtValor.setColumns(10);
		
		JLabel label_6 = new JLabel("HORARIO ENTRADA");
		label_6.setBounds(95, 193, 113, 14);
		panel.add(label_6);
		
		txtHora = new JTextField();
		txtHora.setBounds(97, 208, 63, 20);
		panel.add(txtHora);
		txtHora.setText("00:00");
		txtHora.setColumns(10);
		
		txtDesconto = new JTextField();
		txtDesconto.setBounds(10, 208, 64, 20);
		panel.add(txtDesconto);
		txtDesconto.setText("R$ 00,00");
		txtDesconto.setColumns(10);
		
		JLabel label_5 = new JLabel("DESCONTO");
		label_5.setBounds(10, 193, 64, 14);
		panel.add(label_5);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
	}
}
