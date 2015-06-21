package br.michel.pacote1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Painel_Reserva extends JDialog {

	private final JPanel contentPanel = new JPanel();

	Cad_Reservas cad_reservas = new Cad_Reservas();
	

	public Painel_Reserva() {
		setTitle("Painel Reservas");
		setBounds(100, 100, 337, 173);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblEscolhaUmaOpo = new JLabel("Escolha uma op\u00E7\u00E3o para fazer a reserva:");
		lblEscolhaUmaOpo.setBounds(10, 11, 259, 14);
		contentPanel.add(lblEscolhaUmaOpo);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cad_reservas.txtReq.setEnabled(false);
				cad_reservas.setModal(true);
				cad_reservas.setVisible(true);
				
			}
		});
		btnCliente.setBounds(10, 48, 109, 23);
		contentPanel.add(btnCliente);
		
		JButton btnReservaAvulsa = new JButton("Reserva Avulsa");
		btnReservaAvulsa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cad_reservas.cHospede.setEnabled(false);
				cad_reservas.setModal(true);
				cad_reservas.setVisible(true);
			}
		});
		btnReservaAvulsa.setBounds(154, 48, 153, 23);
		contentPanel.add(btnReservaAvulsa);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
