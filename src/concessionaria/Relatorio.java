package concessionaria;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Relatorio extends JPanel {
	private JLabel lbCodigoID;
	private JTextField tfCodigoID;
	private JButton btPesquisar;
	private JTextArea taMostrarRelatorio;
	private List<TelaRelatorio> rel = new ArrayList<>();
	
	public Relatorio() {
		inicializarComponentes();
		definirEventos();
	}

	public void inicializarComponentes() {

		lbCodigoID = new JLabel("Código de Identificação");
		tfCodigoID = new JTextField();
		btPesquisar = new JButton("Pesquisar");
		taMostrarRelatorio = new JTextArea();

		setBounds(0, 0, 250, 220);
		setLayout(null);
		lbCodigoID.setBounds(50, 50, 150, 20);
		tfCodigoID.setBounds(210, 50, 30, 20);
		btPesquisar.setBounds(270, 50, 100, 20);
		taMostrarRelatorio.setBounds(50, 90, 700, 500);
		taMostrarRelatorio.setBorder(new LineBorder(Color.GRAY));

		add(lbCodigoID);
		add(tfCodigoID);
		add(btPesquisar);
		add(taMostrarRelatorio);
	}

	public void definirEventos() {
		btPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btPesquisar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							for (Cliente cliente : CadastroCliente.getCliente()) {
								taMostrarRelatorio.append("\t\t RELATÓRIO" + "\nCLIENTE" + "\n\nNome :"
										+ cliente.getNome() + "\tRG : " + cliente.getRg() + "\nEndereço :"
										+ cliente.getEndereco() + "\tCep :" + cliente.getCep() + "\nCidade :"
										+ cliente.getCidade() + "\tEstado : " + cliente.getEstado());
							}
						} catch (NullPointerException e2) {
							JOptionPane.showMessageDialog(null, "Preencha Cliente", "ERRO", JOptionPane.ERROR_MESSAGE);
						}
						for (Carro carro : CadastroCarro.getCarro()) {
							taMostrarRelatorio.append("\n\nCARRO" + "\n\nFabricante :" + carro.getFabricante()
									+ "\nModelo :" + carro.getModelo() + "\t\tAno :" + carro.getAno() + "\nCor :"
									+ carro.getCor() + "\nMotor :" + carro.getMotor());
						}
						for (Vendedor vendedor : CadastroVendedor.getVendedor()) {
							taMostrarRelatorio.append("\n\nVENDEDOR" + "\n\nNome :" + vendedor.getNome() + "\nNid :"
									+ vendedor.getId() + "\t\tData de admissão :" + vendedor.getDataAdm());
						}
						for (CalculoValor calculoValor : CadastroCalculoDoValor.getCalcValor()) {
							taMostrarRelatorio.append("\nValor do Carro: " + calculoValor.getValorTotal() + "\nICMS: "
									+ calculoValor.getIcms() + "\nIPI: " + calculoValor.getIpi() + "\nCONFINS: "
									+ calculoValor.getConfins() + "\nComissão do Vendedor: "
									+ calculoValor.getComissaoVendedor() + "\nNºContrato: " + calculoValor.getNumContrato()
									+ "\nTaxista: " + calculoValor.getTaxista());
						}
						/**int indice = Integer.parseInt(tfCodigoID.getText());
						if (CalculoValor.size()!=0 && indice!=0&& indice<=contatos.size()) {// testa se a lista esta vazia ou indice inválido 
							contatos.remove(indice-1);
						}else{
							JOptionPane.showMessageDialog(null, "Lista vazia ou indice inválido", "AGENDA", JOptionPane.ERROR_MESSAGE);
						}
						tfCodigoID.setText("");*/
						rel.add(new TelaRelatorio(CadastroCliente.getCliente()));
						for (TelaRelatorio rela : rel) {
							int posicao = Integer.parseInt(tfCodigoID.getText());
							taMostrarRelatorio.append("\nValor do Carro: " + rela.clientes);
						}
						/**int posicao = Integer.parseInt(tfCodigoID.getText());
						taMostrarRelatorio.append(str);*/
					}
					
				});
			}
		});
	}
}
