package concessionaria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class CadastroVendedor extends JPanel {
	private JLabel lbNome, lbID, lbDataAdmissao;
	private JTextField tfNome, tfID;
	private JFormattedTextField tfDataAdmissao;
	private MaskFormatter msDataAdmissao;
	private JButton btCadastrar;
	private static List<Vendedor> vendedor = new ArrayList<>();

	public CadastroVendedor() {
		inicializarComponentes();
		definirEventos();
	}

	public void inicializarComponentes() {
		try {
			msDataAdmissao = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		lbNome = new JLabel("Nome");
		lbID = new JLabel("NºID");
		lbDataAdmissao = new JLabel("Data de Admissão");
		tfNome = new JTextField();
		tfID = new JTextField();
		tfDataAdmissao = new JFormattedTextField(msDataAdmissao);
		btCadastrar = new JButton("Cadastrar");

		setBounds(0, 0, 250, 220);
		setLayout(null);
		lbNome.setBounds(50, 50, 100, 20);
		tfNome.setBounds(100, 50, 190, 20);
		lbID.setBounds(50, 105, 100, 20);
		tfID.setBounds(100, 105, 80, 20);
		lbDataAdmissao.setBounds(500, 105, 150, 20);
		tfDataAdmissao.setBounds(620, 105, 100, 20);
		btCadastrar.setBounds(300, 230, 200, 20);

		add(lbNome);
		add(lbID);
		add(lbDataAdmissao);
		add(tfNome);
		add(tfID);
		add(tfDataAdmissao);
		add(btCadastrar);
	}

	public void definirEventos() {
		btCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tfNome.getText().equals("") || tfID.getText().equals("") || tfDataAdmissao.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
				} else {
					vendedor.add(new Vendedor(tfNome.getText(), tfID.getText(), tfDataAdmissao.getText()));
					tfNome.setText("");
					tfID.setText("");
					tfDataAdmissao.setText("");
				}

			}
		});
	}

	public static List<Vendedor> getVendedor() {
		return vendedor;
	}
}
