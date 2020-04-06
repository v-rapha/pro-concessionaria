package concessionaria;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class CadastroCliente extends JPanel {
	private JLabel lbNome, lbEndereco, lbCidade, lbRG, lbCep, lbEstado;
	private JTextField tfNome, tfEndereco, tfCidade;
	private JFormattedTextField tfRG, tfCep;
	private MaskFormatter msRG, msCep;
	private JComboBox<String> cbEstado;
	private JButton btCadastrar;
	private static List<Cliente> clientes;

	public CadastroCliente() {
		inicializarComponentes();
		definirEventos();
	}

	public void inicializarComponentes() {
		String[] estados = { "AC", "AL", "AM", "AP", "BA", "CE", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE",
				"PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" };
		lbNome = new JLabel("Nome");
		lbEndereco = new JLabel("Endereço");
		lbCidade = new JLabel("Cidade");
		lbRG = new JLabel("RG");
		lbCep = new JLabel("CEP");
		lbEstado = new JLabel("Estado");
		try {
			msRG = new MaskFormatter("##.###.###-#");
			msCep = new MaskFormatter("##.###-###");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		tfRG = new JFormattedTextField(msRG);
		tfCep = new JFormattedTextField(msCep);
		tfNome = new JTextField();
		tfEndereco = new JTextField();
		tfCidade = new JTextField();
		cbEstado = new JComboBox<>(estados);
		btCadastrar = new JButton("Cadastrar");
		clientes = new ArrayList<>();

		// setBounds(0, 0, 250, 220);
		setLayout(null);
		lbNome.setBounds(50, 50, 100, 20);
		tfNome.setBounds(100, 50, 190, 20);
		lbRG.setBounds(50, 105, 100, 20);
		tfRG.setBounds(100, 105, 100, 20);
		lbCidade.setBounds(50, 160, 100, 20);
		tfCidade.setBounds(100, 160, 120, 20);
		lbEndereco.setBounds(520, 50, 100, 20);
		tfEndereco.setBounds(590, 50, 200, 20);
		lbCep.setBounds(520, 105, 100, 20);
		tfCep.setBounds(590, 105, 100, 20);
		lbEstado.setBounds(520, 160, 100, 20);
		cbEstado.setBounds(590, 160, 100, 20);
		cbEstado.setSelectedIndex(24);
		btCadastrar.setBounds(300, 230, 200, 20);

		add(lbNome);
		add(tfNome);
		add(lbEndereco);
		add(tfEndereco);
		add(lbCidade);
		add(tfCidade);
		add(lbRG);
		add(tfRG);
		add(lbCep);
		add(tfCep);
		add(lbEstado);
		add(cbEstado);
		add(btCadastrar);
	}

	public void definirEventos() {
		btCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tfNome.getText().equals("") || tfEndereco.getText().equals("") || tfCidade.getText().equals("")
						|| tfRG.getText().equals("") || tfCep.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
				} else {
					clientes.add(new Cliente(tfNome.getText(), tfEndereco.getText(), tfCidade.getText(), tfRG.getText(),
							tfCep.getText(), cbEstado.getSelectedItem()));
					tfNome.setText("");
					tfEndereco.setText("");
					tfCidade.setText("");
					tfRG.setText("");
					tfCep.setText("");
				}

			}
		});
	}

	public static List<Cliente> getCliente() {
		return clientes;
	}
}
