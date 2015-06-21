package br.michel.pacote1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class Principal extends JFrame {
	private JPanel contentPane;

	Cad_Cliente cliente = new Cad_Cliente();
	public Cad_Funcionario funcionario = new Cad_Funcionario();
	Cad_Quartos quarto = new Cad_Quartos();
	Cad_GrupoProd grupoprod = new Cad_GrupoProd();
	Painel_Reserva telareservas = new Painel_Reserva();
	Cad_Reservas reservas = new Cad_Reservas();
	Cad_Saida saida = new Cad_Saida();
	Cad_Entrada entrada = new Cad_Entrada();
	Cad_Produto produto = new Cad_Produto();
	Cad_Cidade cidade = new Cad_Cidade();
	Cad_Estado estado = new Cad_Estado();
	Cad_Consumo consumo = new Cad_Consumo();
	Con_Produto con_Produto = new Con_Produto();
	Con_Cidade Con_Cidade = new Con_Cidade();
	Con_Cliente con_cliente = new Con_Cliente();
	Con_Quartos con_quartos = new Con_Quartos();
	Cad_TipoQuarto tipoQuarto = new Cad_TipoQuarto();

	/**
	 * Create the frame.
	 */
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\IFPR\\workspace\\jubileu\\img\\kaki.png"));
		setTitle("Caqui - Gerenciamento de Quartos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 480);
		setMinimumSize(new Dimension(580, 470));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		JMenuItem mntmFuncionarios = new JMenuItem("Funcionarios");
		mntmFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funcionario.setModal(true);
				funcionario.setVisible(true);
			}
		});
		mntmFuncionarios.setIcon(new ImageIcon("C:\\Users\\IFPR\\Desktop\\organization-24.png"));
		mnCadastros.add(mntmFuncionarios);
		
		JMenuItem mntmQuartos = new JMenuItem("Quartos");
		mntmQuartos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				quarto.setModal(true);
				quarto.setVisible(true);
			}
		});
		mntmQuartos.setIcon(new ImageIcon("C:\\Users\\IFPR\\Desktop\\bed-20.png"));
		mnCadastros.add(mntmQuartos);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cliente.setModal(true);
				cliente.setVisible(true);
			}
		});
		
		JMenuItem mntmTipoDeQuarto = new JMenuItem("Tipo de Quarto");
		mntmTipoDeQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipoQuarto.setModal(true);
				tipoQuarto.setVisible(true);
			}
		});
		mnCadastros.add(mntmTipoDeQuarto);
		mntmCliente.setIcon(new ImageIcon("C:\\Users\\IFPR\\Desktop\\icon-ios7-people-20.png"));
		mnCadastros.add(mntmCliente);
		
		JMenuItem mntmEstados = new JMenuItem("Estados");
		mntmEstados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				estado.setModal(true);
				estado.setVisible(true);
			}
		});
		mntmEstados.setIcon(new ImageIcon("C:\\Users\\IFPR\\Desktop\\road.png"));
		mnCadastros.add(mntmEstados);
		
		JMenuItem mntmCidade = new JMenuItem("Cidade");
		mntmCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cidade.setModal(true);
				cidade.setVisible(true);
			}
		});
		mntmCidade.setIcon(new ImageIcon("C:\\Users\\IFPR\\Desktop\\home-20.png"));
		mnCadastros.add(mntmCidade);
		
		JMenuItem mntmGrupoDeProdutos = new JMenuItem("Grupo de Produtos");
		mntmGrupoDeProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				grupoprod.setModal(true);
				grupoprod.setVisible(true);
			}
		});
		mntmGrupoDeProdutos.setIcon(new ImageIcon("C:\\Users\\IFPR\\Desktop\\Food-Dome-20.png"));
		mnCadastros.add(mntmGrupoDeProdutos);
		
		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mntmProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				produto.setModal(true);
				produto.setVisible(true);
			}
		});
		mntmProdutos.setIcon(new ImageIcon("C:\\Users\\IFPR\\Desktop\\food_pizza_fastfood_-20.png"));
		mnCadastros.add(mntmProdutos);
		
		JMenu mnMovimentao = new JMenu("Movimenta\u00E7\u00E3o");
		menuBar.add(mnMovimentao);
		
		JMenuItem mntmReservas = new JMenuItem("Reservas");
		mnMovimentao.add(mntmReservas);
		mntmReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				telareservas.setModal(true);
				telareservas.setVisible(true);
				reservas.setModal(true);
				reservas.setVisible(true);
			}
		});
		mntmReservas.setHorizontalAlignment(SwingConstants.LEFT);
		mntmReservas.setIcon(new ImageIcon("C:\\Users\\IFPR\\Desktop\\check_book.png"));
		
		JMenuItem mntmEntrada = new JMenuItem("Entrada");
		mnMovimentao.add(mntmEntrada);
		mntmEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				entrada.setModal(true);
				entrada.setVisible(true);
			}
		});
		mntmEntrada.setIcon(new ImageIcon("C:\\Users\\IFPR\\Desktop\\sign-in-20.png"));
		
		JMenuItem mntmSaida = new JMenuItem("Saida");
		mnMovimentao.add(mntmSaida);
		mntmSaida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saida.setModal(true);
				saida.setVisible(true);
			}
		});
		mntmSaida.setIcon(new ImageIcon("C:\\Users\\IFPR\\Desktop\\sign-out-20.png"));
		
		JMenuItem mntmConsumoPorCliente = new JMenuItem("Consumo por Cliente");
		mnMovimentao.add(mntmConsumoPorCliente);
		mntmConsumoPorCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consumo.setModal(true);
				consumo.setVisible(true);
			}
		});
		mntmConsumoPorCliente.setIcon(new ImageIcon("C:\\Users\\IFPR\\Desktop\\food.png"));
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
		
		JMenuItem mntmProdutos_1 = new JMenuItem("Produtos");
		mntmProdutos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				con_Produto.limpa_tabela();
				con_Produto.atualiza();
				con_Produto.setModal(true);
				con_Produto.setVisible(true);
			}
		});
		mnConsultas.add(mntmProdutos_1);
		
		JMenuItem mntmIdade = new JMenuItem("Cidades");
		mntmIdade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Con_Cidade.limpa_tabela();
				Con_Cidade.atualiza();
				Con_Cidade.setModal(true);
				Con_Cidade.setVisible(true);
			}
		});
		mnConsultas.add(mntmIdade);
		
		JMenuItem mntmHospede = new JMenuItem("Hospede");
		mntmHospede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				con_cliente.limpa_tabela();
				con_cliente.atualiza();
				con_cliente.setModal(true);
				con_cliente.setVisible(true);
			}
		});
		mnConsultas.add(mntmHospede);
		
		JMenuItem mntmDisponibilidadesDeQuartos = new JMenuItem("Disponibilidades de Quartos");
		mntmDisponibilidadesDeQuartos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				con_quartos.setModal(true);
				con_quartos.setVisible(true);
			}
		});
		
		JMenuItem mntmQuartos_1 = new JMenuItem("Quartos");
		mnConsultas.add(mntmQuartos_1);
		mnConsultas.add(mntmDisponibilidadesDeQuartos);
		
		JMenu mnRelatorios = new JMenu("Relatorios");
		menuBar.add(mnRelatorios);
		
		JMenuItem mntmGeralDoCliente = new JMenuItem("Geral do Cliente");
		mntmGeralDoCliente.setIcon(new ImageIcon("C:\\Users\\IFPR\\Desktop\\user-id-20.png"));
		mnRelatorios.add(mntmGeralDoCliente);
		
		JMenuItem mntmProdutosDisponiveis = new JMenuItem("Produtos Disponiveis");
		mntmProdutosDisponiveis.setIcon(new ImageIcon("C:\\Users\\IFPR\\Desktop\\Candy.png"));
		mnRelatorios.add(mntmProdutosDisponiveis);
		
		JMenuItem mntmConsumoPorCliente_1 = new JMenuItem("Consumo por Cliente");
		mntmConsumoPorCliente_1.setIcon(new ImageIcon("C:\\Users\\IFPR\\Desktop\\table.png"));
		mnRelatorios.add(mntmConsumoPorCliente_1);
		
		JMenuItem mntmQuartosOcupados = new JMenuItem("Quartos Ocupados");
		mntmQuartosOcupados.setIcon(new ImageIcon("C:\\Users\\IFPR\\Desktop\\close.png"));
		mnRelatorios.add(mntmQuartosOcupados);
		
		JMenuItem mntmQuartosDisponiveis = new JMenuItem("Quartos Disponiveis");
		mntmQuartosDisponiveis.setIcon(new ImageIcon("C:\\Users\\IFPR\\Desktop\\open.png"));
		mnRelatorios.add(mntmQuartosDisponiveis);
		
		JMenuItem mntmHospedagemPorPeriodo = new JMenuItem("Hospedagem por Periodo");
		mntmHospedagemPorPeriodo.setIcon(new ImageIcon("C:\\Users\\IFPR\\Desktop\\calender.png"));
		mnRelatorios.add(mntmHospedagemPorPeriodo);
		
		JMenuItem mntmHistoricoDoCliente = new JMenuItem("Historico do Cliente ");
		mntmHistoricoDoCliente.setIcon(new ImageIcon("C:\\Users\\IFPR\\Desktop\\list.png"));
		mnRelatorios.add(mntmHistoricoDoCliente);
		
		JMenuItem mntmEmitir = new JMenuItem("Emitir Comprovante de Hospedagem");
		mnRelatorios.add(mntmEmitir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
