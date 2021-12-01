import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class TelaGuildaCad extends JFrame {

	private JPanel contentPane;
	private BDAventureiro bdAV;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtNivel;

	public TelaGuildaCad(BDAventureiro bdAV) {
		setBackground(new Color(160, 82, 45));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.bdAV = bdAV;
		setBounds(200, 200, 300, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Cadastro de Aventureiro");
		lblTitulo.setBackground(new Color(205, 133, 63));
		lblTitulo.setBounds(10, 14, 263, 26);
		lblTitulo.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBackground(new Color(205, 133, 63));
		lblNome.setBounds(10, 51, 50, 14);
		lblNome.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblNome.setOpaque(true);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdade.setBackground(new Color(205, 133, 63));
		lblIdade.setBounds(10, 91, 50, 14);
		lblIdade.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblIdade.setOpaque(true);
		contentPane.add(lblIdade);
		
		JLabel lblClasse = new JLabel("Classe:");
		lblClasse.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasse.setBackground(new Color(205, 133, 63));
		lblClasse.setBounds(10, 131, 50, 14);
		lblClasse.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblClasse.setOpaque(true);
		contentPane.add(lblClasse);
		
		JLabel lblNivel = new JLabel("Level:");
		lblNivel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNivel.setBackground(new Color(205, 133, 63));
		lblNivel.setBounds(10, 171, 50, 14);
		lblNivel.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblNivel.setOpaque(true);
		contentPane.add(lblNivel);
		
		JLabel lblRaca = new JLabel("Ra\u00E7a:");
		lblRaca.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaca.setBackground(new Color(205, 133, 63));
		lblRaca.setBounds(10, 211, 50, 14);
		lblRaca.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblRaca.setOpaque(true);
		contentPane.add(lblRaca);
		
		txtNome = new JTextField();
		txtNome.setBounds(73, 48, 200, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(73, 88, 200, 20);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		JComboBox cbClasse = new JComboBox();
		cbClasse.setBounds(73, 127, 200, 22);
			cbClasse.addItem("Cleric");
			cbClasse.addItem("Fighter");
			cbClasse.addItem("Rogue");
			cbClasse.addItem("Ranger");
			cbClasse.addItem("Wizard");
			cbClasse.setSelectedItem(null);
		contentPane.add(cbClasse);
		
		txtNivel = new JTextField();
		txtNivel.setBounds(73, 168, 200, 20);
		contentPane.add(txtNivel);
		txtNivel.setColumns(10);
		
		JComboBox cbRaca = new JComboBox();
		cbRaca.setBounds(73, 207, 200, 22);
			cbRaca.addItem("Humano");
			cbRaca.addItem("Elfo");
			cbRaca.addItem("Anão");
			cbRaca.addItem("Halfling");
			cbRaca.addItem("Tiefling");
			cbRaca.setSelectedItem(null);
		contentPane.add(cbRaca);
		
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 11));
		btnCadastrar.setBackground(new Color(205, 133, 63));
		btnCadastrar.setBounds(153, 340, 120, 35);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtNome.getText().trim().isEmpty() 
					|| txtIdade.getText().trim().isEmpty()
					|| cbClasse.getSelectedItem() == null
					|| txtNivel.getText().trim().isEmpty()
					|| cbRaca.getSelectedItem() == null) {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				} else {
					Aventureiro aventureiro = new Aventureiro();
					aventureiro.setNome(txtNome.getText());
					aventureiro.setIdade(txtIdade.getText());
					String classeString = (String)cbClasse.getSelectedItem();
					aventureiro.setClasse(classeString);
					aventureiro.setNivel(txtNivel.getText());
					String racaString = (String)cbRaca.getSelectedItem();
					aventureiro.setRaca(racaString);
					bdAV.cadastrar(aventureiro);
					JOptionPane.showMessageDialog(btnCadastrar, "Aventureiro cadastrado com sucesso!");
					dispose();
				}
			}
		});
		contentPane.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 11));
		btnLimpar.setBackground(new Color(205, 133, 63));
		btnLimpar.setBounds(10, 340, 120, 35);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtIdade.setText("");
				cbClasse.setSelectedItem(null);
				txtNivel.setText("");
				cbRaca.setSelectedItem(null);
			}
		});
		contentPane.add(btnLimpar);
		
		JLabel lblBackgroundIMG = new JLabel("");
		lblBackgroundIMG.setIcon(new ImageIcon("C:\\Users\\mikar\\eclipse-workspace\\unime-trabalhoPOO3\\img\\journalbackground.png"));
		lblBackgroundIMG.setBounds(0, 0, 334, 386);
		contentPane.add(lblBackgroundIMG);
		
	}
}
