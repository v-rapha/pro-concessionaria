package concessionaria;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Sobre extends JPanel {
	private JLabel titulo;
	private JTextArea sobre;

	public Sobre() {
		inicializarComponentes();
		definirEventos();
	}

	public void inicializarComponentes() {
		titulo = new JLabel("Um Pouco Sobre a Empresa :  ");

		sobre = new JTextArea(
				"Com 15 anos de hist�ria, a concession�ria SenaiCars � sin�nimo de Qualidade em Campinas, no interior de S�o Paulo\n "
						+ "Oferecemos a linha completa de carros zero km e uma ampla gama de servi�os,\n "
						+ "tudo com pe�as de qualidade e acess�rios originais.\n"
						+ " Al�m disso, dispomos de um estoque de mais de 500 ve�culos seminovos e as melhores taxas de financiamento\n de carros do mercado,\n"
						+ " com ou sem entrada, em at� 80 meses.\n"
						+ " Conte conosco para a melhor experiencia em compra de carros. ");
		sobre.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		setLayout(null);
		titulo.setBounds(180, 30, 190, 20);
		sobre.setBounds(90, 50, 760, 350);
		sobre.setBorder(new LineBorder(Color.BLACK));
		sobre.setBackground(null);

		add(sobre);
		add(titulo);
	}

	public void definirEventos() {
	}
}
