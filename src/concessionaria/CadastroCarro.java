package concessionaria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CadastroCarro extends JPanel {
	private JLabel lbFabricante, lbModelo, lbCor, lbAno, lbMotor;
	private JTextField tfFabricante, tfModelo, tfCor, tfAno;
	private JRadioButton rb1p0, rb2p0;
	private JButton btCadastrar;
	private ButtonGroup buttonGroup;
	private static List<Carro> carros = new ArrayList<>();

	public CadastroCarro() {
		inicializarComponentes();
		definirEventos();
	}

	public void inicializarComponentes() {
		lbFabricante = new JLabel("Fabricante");
		lbModelo = new JLabel("Modelo");
		lbCor = new JLabel("Cor");
		lbAno = new JLabel("Ano");
		lbMotor = new JLabel("Motor");
		tfFabricante = new JTextField();
		tfModelo = new JTextField();
		tfCor = new JTextField();
		tfAno = new JTextField();
		rb1p0 = new JRadioButton("1.0");
		rb2p0 = new JRadioButton("2.0");
		buttonGroup = new ButtonGroup();
		btCadastrar = new JButton("Cadastrar");

		setBounds(0, 0, 250, 220);
		setLayout(null);
		lbFabricante.setBounds(20, 50, 100, 20);
		tfFabricante.setBounds(100, 50, 290, 20);
		lbModelo.setBounds(40, 105, 100, 20);
		tfModelo.setBounds(100, 105, 100, 20);
		lbCor.setBounds(50, 160, 100, 20);
		tfCor.setBounds(100, 160, 120, 20);
		lbAno.setBounds(520, 50, 100, 20);
		tfAno.setBounds(590, 50, 50, 20);
		lbMotor.setBounds(520, 105, 100, 20);
		rb1p0.setBounds(610, 105, 90, 20);
		rb2p0.setBounds(700, 105, 90, 20);
		rb1p0.setSelected(true);
		btCadastrar.setBounds(300, 230, 200, 20);

		buttonGroup.add(rb1p0);
		buttonGroup.add(rb2p0);
		add(lbFabricante);
		add(lbModelo);
		add(lbCor);
		add(lbAno);
		add(lbMotor);
		add(tfFabricante);
		add(tfModelo);
		add(tfCor);
		add(tfAno);
		add(rb1p0);
		add(rb2p0);
		add(btCadastrar);
	}

	public void definirEventos() {
		btCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean rb1;
				boolean rb2;
				String rad = null;
				rb1 = rb1p0.isSelected();
				rb2 = rb2p0.isSelected();
				if (rb1 == true) {
					rad = "1.0";
				} else {
					rad = "2.0";
				}
				if ((tfFabricante.getText().equals("")) || (tfModelo.getText().equals(""))
						|| (tfCor.getText().equals("")) || (tfAno.getText().equals("")) || carros.equals(null)) {
					JOptionPane.showMessageDialog(null, "Preencha os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
				} else {
					carros.add(new Carro(tfFabricante.getText(), tfModelo.getText(), tfCor.getText(), tfAno.getText(),
							rad));
					tfFabricante.setText(" ");
					tfModelo.setText(" ");
					tfCor.setText(" ");
					tfAno.setText(" ");
				}

			}
		});
	}

	public static List<Carro> getCarro() {
		return carros;
	}
}
