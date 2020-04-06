package concessionaria;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CadastroCalculoDoValor extends JPanel {
	private JLabel lbValorVeiculo, lbNumContrato, lbCifraoValorVeiculo, lbCifraoIcms, lbCifraoIpi, lbCifraoConfins,
			lbCifraoComsVendedor, lbCifraoValorTotal, lbIcms, lbIpi, lbConfins, lbComissaoVendedor, lbTaxista,
			lbValorTotal;
	private JTextField tfValorVeiculo, tfNumContrato;
	private JTextArea taIcms, taIpi, taConfins, taComissaoVendedor, taValorTotal;
	private JRadioButton rbSim, rbNao;
	private ButtonGroup buttonGroup;
	private JButton btCalcular, btVenda;
	private static List<CalculoValor> calculoValor = new ArrayList<>();

	public CadastroCalculoDoValor() {
		inicializarComponentes();
		definirEventos();
	}

	public void inicializarComponentes() {
		lbValorVeiculo = new JLabel("Valor do veículo");
		lbNumContrato = new JLabel("NºContrato");
		lbCifraoValorVeiculo = new JLabel("R$");
		lbCifraoIcms = new JLabel("R$");
		lbCifraoIpi = new JLabel("R$");
		lbCifraoConfins = new JLabel("R$");
		lbCifraoComsVendedor = new JLabel("R$");
		lbCifraoValorTotal = new JLabel("R$");
		lbIcms = new JLabel("ICMS");
		lbIpi = new JLabel("IPI");
		lbConfins = new JLabel("Confins");
		lbComissaoVendedor = new JLabel("Comissão do Vendedor");
		lbTaxista = new JLabel("Taxista");
		lbValorTotal = new JLabel("Valor Total");
		tfValorVeiculo = new JTextField();
		tfNumContrato = new JTextField();
		taIcms = new JTextArea();
		taIpi = new JTextArea();
		taConfins = new JTextArea();
		taComissaoVendedor = new JTextArea();
		taValorTotal = new JTextArea();
		rbSim = new JRadioButton("Sim");
		rbNao = new JRadioButton("Não");
		buttonGroup = new ButtonGroup();
		btCalcular = new JButton("Calcular");
		btVenda = new JButton("Venda");

		setBounds(0, 0, 250, 220);
		setLayout(null);
		lbValorVeiculo.setBounds(100, 30, 100, 20);
		tfValorVeiculo.setBounds(100, 50, 190, 20);
		lbCifraoValorVeiculo.setBounds(80, 50, 100, 20);
		lbNumContrato.setBounds(500, 30, 150, 20);
		tfNumContrato.setBounds(500, 50, 100, 20);
		lbIcms.setBounds(60, 90, 100, 20);
		lbCifraoIcms.setBounds(100, 90, 40, 20);
		taIcms.setBounds(120, 90, 90, 20);
		taIcms.setBorder(new LineBorder(Color.LIGHT_GRAY));
		taIcms.setBackground(null);
		lbIpi.setBounds(255, 90, 100, 20);
		lbCifraoIpi.setBounds(277, 90, 40, 20);
		taIpi.setBounds(295, 90, 90, 20);
		taIpi.setBorder(new LineBorder(Color.LIGHT_GRAY));
		taIpi.setBackground(null);
		lbConfins.setBounds(60, 130, 90, 20);
		lbCifraoConfins.setBounds(110, 130, 40, 20);
		taConfins.setBounds(130, 130, 90, 20);
		taConfins.setBorder(new LineBorder(Color.LIGHT_GRAY));
		taConfins.setBackground(null);
		lbComissaoVendedor.setBounds(62, 170, 140, 20);
		lbCifraoComsVendedor.setBounds(200, 170, 40, 20);
		taComissaoVendedor.setBounds(220, 170, 90, 20);
		taComissaoVendedor.setBorder(new LineBorder(Color.LIGHT_GRAY));
		taComissaoVendedor.setBackground(null);
		lbTaxista.setBounds(500, 90, 100, 20);
		rbSim.setBounds(490, 110, 50, 20);
		rbNao.setBounds(550, 110, 50, 20);
		rbNao.setSelected(true);
		lbValorTotal.setBounds(500, 150, 130, 20);
		lbCifraoValorTotal.setBounds(460, 170, 40, 20);
		taValorTotal.setBounds(480, 170, 130, 20);
		taValorTotal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		taValorTotal.setBackground(null);
		btCalcular.setBounds(250, 230, 100, 20);
		btVenda.setBounds(410, 230, 100, 20);

		buttonGroup.add(rbSim);
		buttonGroup.add(rbNao);
		add(lbValorVeiculo);
		add(lbNumContrato);
		add(lbCifraoValorVeiculo);
		add(lbCifraoIcms);
		add(lbCifraoIpi);
		add(lbCifraoConfins);
		add(lbCifraoComsVendedor);
		add(lbCifraoValorTotal);
		add(lbIcms);
		add(lbIpi);
		add(lbConfins);
		add(lbComissaoVendedor);
		add(lbTaxista);
		add(lbValorTotal);
		add(tfValorVeiculo);
		add(tfNumContrato);
		add(taIcms);
		add(taIpi);
		add(taConfins);
		add(taComissaoVendedor);
		add(taValorTotal);
		add(rbSim);
		add(rbNao);
		add(btCalcular);
		add(btVenda);
	}

	public void definirEventos() {
		btCalcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (CadastroCarro.getCarro().size() == 0) {
					JOptionPane.showMessageDialog(null, " ERRO Cadastre o Carro Primeiro ", "ERRO",
							JOptionPane.INFORMATION_MESSAGE);
				} else {

					taIcms.setText(String.valueOf((calcularIcms())));
					taConfins.setText(Integer.toString((int) (calcularConfins())));
					taComissaoVendedor.setText(Integer.toString((int) calcularComissaoEMotor1()));

					for (Carro carro : CadastroCarro.getCarro()) {
						if (carro.getMotor().equals("1.0")) {
							taIpi.setText(String.valueOf(Integer.toString((int) (calcularComissaoEMotor1()))));
						}
						if (carro.getMotor().equals("2.0")) {
							taIpi.setText(String.valueOf((calcularIpiM2())));
						}
					}

					if (rbSim.isSelected()) {
						for (Carro carro : CadastroCarro.getCarro()) {
							taIcms.setText(String.valueOf(0));
							taIpi.setText(String.valueOf(0));
							float valorVeiculo = Float.parseFloat(tfValorVeiculo.getText());
							float valorIcms = Float.parseFloat(taIcms.getText());
							float descontoTaxista = valorVeiculo + valorIcms;
							taValorTotal.setText(String.valueOf((descontoTaxista)));
						}

					}
					if (rbNao.isSelected()) {
						for (Carro carro : CadastroCarro.getCarro()) {
							if (carro.getMotor().equals("1.0") || carro.getMotor().equals("2.0")) {
								float valorVeiculo = Float.parseFloat(tfValorVeiculo.getText());
								float valorIcms = Float.parseFloat(taIcms.getText());
								float valorIpi = Float.parseFloat(taIpi.getText());
								float valorConfins = Float.parseFloat(taConfins.getText());
								float valorTotal = valorVeiculo + valorIcms + valorIpi + valorConfins;
								taValorTotal.setText(String.valueOf((valorTotal)));
							}
						}
					}
				}

			}
		});

		btVenda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean rbsim;
				boolean rbnao;
				String rad = null;
				rbsim = rbSim.isSelected();
				rbnao = rbNao.isSelected();
				if (rbsim == true) {
					rad = "Taxista - Sim";
				} else {
					rad = "Taxista - Não";
				}
				calculoValor.add(new CalculoValor(taIcms.getText(), taIpi.getText(), taConfins.getText(),
						taComissaoVendedor.getText(), tfNumContrato.getText(), rad, taValorTotal.getText()));
				
				tfValorVeiculo.setText(" ");
				taIcms.setText(" ");
				taIpi.setText(" ");
				taConfins.setText(" ");
				taComissaoVendedor.setText(" ");
				tfNumContrato.setText(" ");
				taValorTotal.setText(" ");
				
				JOptionPane.showMessageDialog(null, "Parabéns");
			}
		});
	}

	private float calcularIcms() {
		try {
			float valorVeiculo = Float.parseFloat(tfValorVeiculo.getText());
			float valorIcms = (valorVeiculo * 12) / 100;
			return valorIcms;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite apenas números");
		}
		return 0;
	}

	private float calcularConfins() {
		try {
			float valorVeiculo = Float.parseFloat(tfValorVeiculo.getText());
			float valorConfins = (float) (valorVeiculo * 7.6) / 100;
			return valorConfins;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite apenas números");
		}
		return 0;
	}

	private float calcularComissaoEMotor1() {
		try {
			float valorVeiculo = Float.parseFloat(tfValorVeiculo.getText());
			float valorComissao = (valorVeiculo * 3) / 100;
			return valorComissao;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite apenas números");
		}
		return 0;
	}

	private float calcularIpiM2() {
		try {
			float valorVeiculo = Float.parseFloat(tfValorVeiculo.getText());
			float valorIpi = (valorVeiculo * 10) / 100;
			return valorIpi;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite apenas números");
		}
		return 0;
	}
	
	public static List<CalculoValor> getCalcValor() {
		return calculoValor;
	}
	/**
	 * private float calcularIpiM1() { float valorVeiculo =
	 * Float.parseFloat(tfValorVeiculo.getText()); float valorIpi =
	 * (valorVeiculo * 3)/100; //float valor = valor - valorVeiculo; return
	 * valorIpi; }
	 */

	/**
	 * private float valorTaxista1() { float valorVeiculo =
	 * Float.parseFloat(tfValorVeiculo.getText()); float v1 = calcularIpiM1() -
	 * calcularIcms() - valorVeiculo; return v1; } private float valorTaxista2()
	 * { float valorVeiculo = Float.parseFloat(tfValorVeiculo.getText()); float
	 * v1 = calcularIpiM2() - calcularIcms() - valorVeiculo; return v1; }
	 */
}
