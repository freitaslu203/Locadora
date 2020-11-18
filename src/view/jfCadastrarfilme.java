package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bin.filme;
import model.dao.FilmeDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class jfCadastrarfilme extends JFrame {

	private JPanel contentPane;
	private JTextField titulo;
	private JLabel lbsinopse;
	private JTextField sinopse;
	private JLabel lbcategoria;
	private JTextField categoria;
	private JLabel lbtempo;
	private JSpinner tempo;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfCadastrarfilme frame = new jfCadastrarfilme();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public jfCadastrarfilme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbcadastrar_filme = new JLabel("Cadastrar Filme");
		lbcadastrar_filme.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbcadastrar_filme.setBounds(0, 0, 136, 25);
		contentPane.add(lbcadastrar_filme);
		
		JLabel lbtitulo = new JLabel("T\u00EDtulo");
		lbtitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbtitulo.setBounds(10, 36, 46, 14);
		contentPane.add(lbtitulo);
		
		titulo = new JTextField();
		titulo.setBounds(20, 55, 554, 20);
		contentPane.add(titulo);
		titulo.setColumns(10);
		
		lbsinopse = new JLabel("Sinopse");
		lbsinopse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbsinopse.setBounds(10, 86, 46, 14);
		contentPane.add(lbsinopse);
		
		sinopse = new JTextField();
		sinopse.setBounds(10, 111, 571, 109);
		contentPane.add(sinopse);
		sinopse.setColumns(10);
		
		lbcategoria = new JLabel("Categoria");
		lbcategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbcategoria.setBounds(10, 233, 91, 14);
		contentPane.add(lbcategoria);
		
		categoria = new JTextField();
		categoria.setBounds(13, 258, 561, 20);
		contentPane.add(categoria);
		categoria.setColumns(10);
		
		lbtempo = new JLabel("Tempo");
		lbtempo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbtempo.setBounds(10, 287, 46, 14);
		contentPane.add(lbtempo);
		
		tempo = new JSpinner();
		tempo.setBounds(10, 302, 78, 20);
		contentPane.add(tempo);
		
		
		JRadioButton rdbtn2d = new JRadioButton("2D");
		rdbtn2d.setBounds(111, 301, 60, 23);
		contentPane.add(rdbtn2d);
		
		
		JRadioButton rdbtn3d = new JRadioButton("3D");
		rdbtn3d.setBounds(175, 301, 65, 23);
		contentPane.add(rdbtn3d);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(rdbtn2d);
		imagem.add(rdbtn3d);
		
		JRadioButton dublado = new JRadioButton("Dublado");
		dublado.setBounds(281, 301, 136, 23);
		contentPane.add(dublado);
		
		JRadioButton legendado = new JRadioButton("Legendado");
		legendado.setBounds(429, 301, 156, 23);
		contentPane.add(legendado);
		
		ButtonGroup audio = new ButtonGroup();
		audio.add(dublado);
		audio.add(legendado);
		
		JButton btncadastrar = new JButton("Cadastrar");
		btncadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filme f = new filme();
				FilmeDAO dao = new FilmeDAO();
				f.setTitulo(titulo.getText());
				f.setSinopse(sinopse.getText());
				f.setCategoria(categoria.getText());
				f.setTempo(Integer.parseInt(tempo.getValue().toString()));
				if(rdbtn2d.isSelected()) {
					f.setImagem3d(false);
				}else if (rdbtn3d.isSelected()) {
					f.setImagem3d(true);
				}
				if(dublado.isSelected()) {
					f.setDublado(true);
				}
				dao.create(f);
			}

	});
		btncadastrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btncadastrar.setBounds(12, 334, 89, 23);
		contentPane.add(btncadastrar);
		

		JButton btnlimpar = new JButton("Limpar");
		btnlimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnlimpar.setBounds(121, 334, 89, 23);
		contentPane.add(btnlimpar);
		
		JButton btncancelar = new JButton("Cancelar");
		btncancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btncancelar.setBounds(225, 334, 89, 23);
		contentPane.add(btncancelar);
		
		JLabel lblNewLabel = new JLabel("Imagem");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(111, 288, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u00C1udio");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(281, 288, 46, 14);
		contentPane.add(lblNewLabel_1);
	}
}
