package principal;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import factories.ProjectFactory;

public class Program {

	public static void main(String[] args) throws Exception {

		// PAINEL
		JFrame frame = new JFrame("Criação de Projeto");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Selecione o tipo de projeto");
		JButton btnTD = new JButton("Projeto TD");
		JButton btnOM = new JButton("Projeto OM");

		Dimension size = label.getPreferredSize();
		label.setBounds(150, 30, size.width, size.height);
		label.setFont(new Font("SansSerif", Font.PLAIN, 20));
		panel.add(label);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		frame.getContentPane();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		btnTD.setPreferredSize(new Dimension(250, 40));
		btnOM.setPreferredSize(new Dimension(250, 40));

		// CHAMADA DAS FUNÇÕES DE CRIAÇÃO DE PROJETO TD NO BOTÃO
		btnTD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Object obj = ae.getSource();

				if (obj == btnTD) {
					ProjectFactory.ProjectTdFactory();;
				}
			}
		});

		// CHAMADA DAS FUNÇÕES DE CRIAÇÃO DE PROJETO OM NO BOTÃO
		btnOM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Object obj = ae.getSource();

				if (obj == btnOM) {
					ProjectFactory.ProjectOmFactory();;
				}
			}
		});

		// ADD ELEMENTOS NO PAINEL
		frame.add(panel);
		panel.add(btnTD);
		panel.add(btnOM);
		frame.setSize(400, 200);
		frame.setVisible(true);

	}
}
