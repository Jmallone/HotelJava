package br.michel.pacote1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Cad_Reservas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_1;
	private JTextField textField_2;

	Cad_Funcionario funcionario = new Cad_Funcionario();
	Cad_Cliente cliente = new Cad_Cliente();
	Cad_TipoQuarto tipoQuarto = new Cad_TipoQuarto();
	
	private JComboBox comboF;
	JComboBox cHospede;
	JTextField txtReq;
	private JComboBox tipoquarto;
	
	/**
	 * Create the dialog.
	 */
	public Cad_Reservas() {
		setTitle("Reservas");
		setBounds(100, 100, 204, 404);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTipoQuarto = new JLabel("TIPO QUARTO");
			lblTipoQuarto.setBounds(10, 207, 84, 14);
			contentPanel.add(lblTipoQuarto);
		}
		{
			textField_1 = new JTextField();
			textField_1.setText("00/00/00");
			textField_1.setHorizontalAlignment(SwingConstants.CENTER);
			textField_1.setColumns(10);
			textField_1.setBounds(10, 176, 64, 20);
			contentPanel.add(textField_1);
		}
		{
			JLabel label = new JLabel("DATA ATUAL");
			label.setBounds(10, 162, 93, 14);
			contentPanel.add(label);
		}
		{
			cHospede = new JComboBox();
			
			cHospede.setBounds(10, 129, 136, 22);
			contentPanel.add(cHospede);
		}
		{
			JLabel label = new JLabel("NOME");
			label.setBounds(10, 112, 46, 14);
			contentPanel.add(label);
		}
		{
			textField_2 = new JTextField();
			textField_2.setText("00/00/00");
			textField_2.setHorizontalAlignment(SwingConstants.CENTER);
			textField_2.setColumns(10);
			textField_2.setBounds(94, 176, 64, 20);
			contentPanel.add(textField_2);
		}
		{
			JLabel label = new JLabel("SAIDA PREVISTA");
			label.setBounds(95, 162, 185, 14);
			contentPanel.add(label);
		}
		{
			JButton button = new JButton("New button");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cliente.setModal(true);
					cliente.setVisible(true);
					Control.Click(cHospede,"hospede" );
				}
			});
			button.setBounds(156, 130, 27, 22);
			contentPanel.add(button);
		}
		
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funcionario.setModal(true);
				funcionario.setVisible(true);
				Control.Click(comboF, "funcionarios");
			}
		});
		button.setBounds(156, 29, 27, 22);
		contentPanel.add(button);
		
		comboF = new JComboBox();
		comboF.setBounds(10, 28, 136, 22);
		contentPanel.add(comboF);
		
		JLabel lblFuncionario = new JLabel("FUNCIONARIO");
		lblFuncionario.setBounds(10, 11, 159, 14);
		contentPanel.add(lblFuncionario);
		
		JLabel lblRequisitante = new JLabel("REQUISITANTE");
		lblRequisitante.setBounds(10, 61, 120, 14);
		contentPanel.add(lblRequisitante);
		
		txtReq = new JTextField();
		
		txtReq.setBounds(8, 78, 172, 20);
		contentPanel.add(txtReq);
		txtReq.setColumns(10);
		
		tipoquarto = new JComboBox();
		tipoquarto.setBounds(10, 231, 136, 22);
		contentPanel.add(tipoquarto);
		
		JButton button_1 = new JButton("New button");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipoQuarto.setModal(true);
				tipoQuarto.setVisible(true);
				Control.Click(tipoquarto,"tipoquarto" );
				
			}
		});
		button_1.setBounds(156, 232, 27, 22);
		contentPanel.add(button_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Aguardando", "Finalizada", "Cancelada"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(10, 285, 136, 20);
		contentPanel.add(comboBox);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setBounds(10, 264, 64, 14);
		contentPanel.add(lblStatus);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						cHospede.setEnabled(true);
						txtReq.setEnabled(true);
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	@Override
	public void setVisible(boolean b){
		Control.Click(comboF, "funcionarios");
		Control.Click(tipoquarto,"tipoquarto" );
		Control.Click(cHospede,"hospede" );
		

		super.setVisible(b);
	}
}
