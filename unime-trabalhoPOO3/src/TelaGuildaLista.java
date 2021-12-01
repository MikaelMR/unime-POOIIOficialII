import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TelaGuildaLista extends JFrame {

	/*
	* União Metropolitana de Educação e Cultura
	* Bacharelado em Sistemas de Informação
	* Programação Orientada a Objetos II
	* Prof. Pablo Ricardo Roxo Silva
	* Mikael Magalhães Ramos
	*/
	
	private JPanel contentPane;
	private BDAventureiro bdAV;
	private JTable tblAventureiros;
	private JButton btnExcluir;
	private JButton btnTelaEdicao;
	private JLabel lblTitulo;

	public TelaGuildaLista(BDAventureiro bdAV) {
		setFont(new Font("Georgia", Font.PLAIN, 12));
		setBackground(Color.LIGHT_GRAY);
		this.bdAV = bdAV;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 459);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnTelaCadastro = new JButton("Criar Aventureiro");
		btnTelaCadastro.setIcon(new ImageIcon("C:\\Users\\mikar\\eclipse-workspace\\unime-trabalhoPOO3\\img\\newchar.png"));
		btnTelaCadastro.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 11));
		btnTelaCadastro.setBackground(new Color(205, 133, 63));
		btnTelaCadastro.setForeground(Color.BLACK);
		btnTelaCadastro.setBounds(70, 91, 180, 35);
		btnTelaCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaGuildaCad telaGuildaCad = new TelaGuildaCad(bdAV);
				telaGuildaCad.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						listarAventureiros();
					}
				});
				telaGuildaCad.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnTelaCadastro);
		
		lblTitulo = new JLabel("Guilda dos Aventureiros");
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setBackground(new Color(210, 105, 30));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 20));
		lblTitulo.setBounds(216, 26, 300, 50);
		contentPane.add(lblTitulo);
		
		JScrollPane scrAventureiros = new JScrollPane();
		scrAventureiros.setBounds(70, 152, 586, 246);
		contentPane.add(scrAventureiros);
		
		tblAventureiros = new JTable();
		tblAventureiros.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tblAventureiros.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Idade", "Classe", "Level", "Raça"
			}
		));
		scrAventureiros.setViewportView(tblAventureiros);
		this.listarAventureiros();
		
		btnExcluir = new JButton("Excluir Aventureiro");
		btnExcluir.setIcon(new ImageIcon("C:\\Users\\mikar\\eclipse-workspace\\unime-trabalhoPOO3\\img\\x.png"));
		btnExcluir.setBackground(new Color(205, 133, 63));
		btnExcluir.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 11));
		btnExcluir.setForeground(new Color(0, 0, 0));
		btnExcluir.setBounds(476, 91, 180, 35);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int optExcluir = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja excluir?", "Excluir", JOptionPane.YES_NO_OPTION);
				if (optExcluir == 0 && !tblAventureiros.getSelectionModel().isSelectionEmpty()) {
					int id = (int) tblAventureiros.getModel().getValueAt(tblAventureiros.getSelectedRow(), 0);
					bdAV.excluir(id);
					JOptionPane.showMessageDialog(btnExcluir, "Aventureiro excluído com sucesso!");
					listarAventureiros();
					
				} else if (optExcluir == 0 && tblAventureiros.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(btnExcluir, "Selecione um aventureiro para excluir");
				}
			}
		});
		contentPane.add(btnExcluir);

		btnTelaEdicao = new JButton("Editar Aventureiro");
		btnTelaEdicao.setIcon(new ImageIcon("C:\\Users\\mikar\\eclipse-workspace\\unime-trabalhoPOO3\\img\\edit.png"));
		btnTelaEdicao.setForeground(new Color(0, 0, 0));
		btnTelaEdicao.setBackground(new Color(205, 133, 63));
		btnTelaEdicao.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 11));
		btnTelaEdicao.setBounds(273, 91, 180, 35);
		btnTelaEdicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tblAventureiros.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(btnExcluir, "Selecione um aventureiro para editar");
				} else {
					int id = (int) tblAventureiros.getModel().getValueAt(tblAventureiros.getSelectedRow(), 0);
					TelaGuildaEdit telaGuildaEdit = new TelaGuildaEdit(bdAV, id);
					telaGuildaEdit.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent e) {
							listarAventureiros();
						}
					});
					telaGuildaEdit.setVisible(true);
				}
			}
		});
		contentPane.add(btnTelaEdicao);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mikar\\eclipse-workspace\\unime-trabalhoPOO3\\img\\aginterior.jpg"));
		lblNewLabel.setBounds(0, 0, 730, 420);
		contentPane.add(lblNewLabel);
		
	}
	
	public void listarAventureiros() {
		ArrayList<Aventureiro> aventureiros = this.bdAV.listar();
		DefaultTableModel model = (DefaultTableModel) tblAventureiros.getModel();
		model.setRowCount(0);
		for(Aventureiro aventureiro: aventureiros) {
			model.addRow(new Object[] {
				aventureiro.getId(),
				aventureiro.getNome(),
				aventureiro.getIdade(),
				aventureiro.getClasse(),
				aventureiro.getNivel(),
				aventureiro.getRaca()
			});
		}
	}
}
