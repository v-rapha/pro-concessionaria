package concessionaria;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPrincipal extends JFrame {

	// Atributos
	private Container contentPane;
	private JMenuBar mnBarra;
	private JMenu mnArquivo, mnCadastro, mnSobre;;
	private JMenuItem miSair, miCalculoValor, miRelatorio, miCliente, miCarro, miVendedor, miHistoria;

	// Construtor
	public MenuPrincipal() {
		inicializarComponentes();
		definirEventos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void inicializarComponentes() {
		setTitle("VendaDeCarros");
		setBounds(0, 0, 900, 500);

		// Criando Objetos
		contentPane = getContentPane();
		mnBarra = new JMenuBar();
		mnArquivo = new JMenu("Arquivo");
		mnCadastro = new JMenu("Cadastro");
		mnSobre = new JMenu("Sobre");
		mnArquivo.setMnemonic('A');
		mnCadastro.setMnemonic('C');
		mnSobre.setMnemonic('S');
		miSair = new JMenuItem("Sair");
		miCalculoValor = new JMenuItem("Calulo do Valor");
		miRelatorio = new JMenuItem("Relatório");
		miCliente = new JMenuItem("Cliente");
		miCarro = new JMenuItem("Carro");
		miVendedor = new JMenuItem("Vendedor");
		miHistoria = new JMenuItem("História");

		// Adicionando Objetos
		mnArquivo.add(miCalculoValor);
		mnArquivo.add(miRelatorio);
		mnArquivo.add(miSair);
		mnCadastro.add(miCliente);
		mnCadastro.add(miCarro);
		mnCadastro.add(miVendedor);
		mnSobre.add(miHistoria);
		mnBarra.add(mnArquivo);
		mnBarra.add(mnCadastro);
		mnBarra.add(mnSobre);
		setJMenuBar(mnBarra);
	}

	public void definirEventos() {
		miSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		miCalculoValor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CadastroCalculoDoValor calculo = new CadastroCalculoDoValor();
				contentPane.removeAll();
				contentPane.add(calculo);
				contentPane.validate();
				setTitle("Calculo de Impostos");
			}
		});

		miRelatorio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Relatorio relatorio = new Relatorio();
				contentPane.removeAll();
				contentPane.add(relatorio);
				contentPane.validate();
				setTitle("Relatório");
			}
		});

		miCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroCliente cliente = new CadastroCliente();
				contentPane.removeAll();
				contentPane.add(cliente);
				contentPane.validate();
				setTitle("Cadastro Cliente");
			}
		});

		miCarro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroCarro carro = new CadastroCarro();
				contentPane.removeAll();
				contentPane.add(carro);
				contentPane.validate();
				setTitle("Cadastro Carro");
			}
		});

		miVendedor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroVendedor vendedor = new CadastroVendedor();
				contentPane.removeAll();
				contentPane.add(vendedor);
				contentPane.validate();
				setTitle("Cadastro Vendedor");
			}
		});

		miHistoria.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Sobre historia = new Sobre();
				contentPane.removeAll();
				contentPane.add(historia);
				contentPane.validate();
				setTitle("História");
			}
		});
	}
}
