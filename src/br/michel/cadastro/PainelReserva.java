package br.michel.cadastro;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PainelReserva extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PainelReserva frame = new PainelReserva();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PainelReserva() {
		setTitle("Painel de Reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 332, 163);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(10, 11, 329, 113);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Escolha uma op\u00E7\u00E3o para fazer a reserva:");
		label.setBounds(10, 11, 259, 14);
		panel.add(label);
		
		JButton button = new JButton("Cliente");
		button.setBounds(10, 48, 109, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Reserva Avulsa");
		button_1.setBounds(154, 48, 153, 23);
		panel.add(button_1);
		
		JButton btnCacenlar = new JButton("Cancelar");
		btnCacenlar.setBounds(216, 90, 91, 23);
		panel.add(btnCacenlar);
	}
}
