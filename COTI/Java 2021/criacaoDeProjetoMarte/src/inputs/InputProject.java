package inputs;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import entities.Project;
import factories.PermissionFactory;
import repositories.OmProjectRepository;
import repositories.TdProjectRepository;

public class InputProject {

	public static void Panel() {

		Project p = new Project();
		TdProjectRepository tdProject = new TdProjectRepository();
		OmProjectRepository omProject = new OmProjectRepository();

		// PAINEL
		JFrame frame = new JFrame("Cria��o de Projeto");
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

		// CHAMADA DAS FUN��ES DE CRIA��O DE PROJETO TD NO BOT�O
		btnTD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Object obj = ae.getSource();

				if (obj == btnTD) {
					try {
						p.setNome(JOptionPane.showInputDialog("Insira o nome do projeto:"));
						tdProject.createFolder(p);
						tdProject.copyStructure(p);
						PermissionFactory.permissionProject();
						Thread.sleep(15000);
						tdProject.remaneFolder(p);
						JOptionPane.showMessageDialog(null, "Projeto criado com sucesso");

					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}

			}

		});

		// CHAMADA DAS FUN��ES DE CRIA��O DE PROJETO OM NO BOT�O
		btnOM.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent ae) {
				Object obj = ae.getSource();

				if (obj == btnOM) {
					try {
						p.setNome(JOptionPane.showInputDialog("Insira o nome do projeto:"));
						omProject.createFolder(p);
						omProject.copyStructure(p);
						JOptionPane.showMessageDialog(null, "Projeto criado com sucesso");

					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}

			}

		});
		
		frame.add(panel);
		panel.add(btnTD);
		panel.add(btnOM);
		frame.setSize(400, 200);
		frame.setVisible(true);

	}
}
