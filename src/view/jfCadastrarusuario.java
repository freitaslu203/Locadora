package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.bin.usuario;
import model.dao.UsuarioDAO;

 class jfCadastrarusuario extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField email;
	private JTextField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfCadastrarusuario frame = new jfCadastrarusuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public jfCadastrarusuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel cadusuario = new JLabel("Cadastrar Usu\u00E1rio");
		cadusuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cadusuario.setBounds(196, 11, 233, 43);
		contentPane.add(cadusuario);
		
		JLabel lbnome = new JLabel("Nome:");
		lbnome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbnome.setHorizontalAlignment(SwingConstants.TRAILING);
		lbnome.setBounds(171, 67, 71, 14);
		contentPane.add(lbnome);
		
		nome = new JTextField();
		nome.setBounds(196, 87, 157, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lbemail = new JLabel("Email:");
		lbemail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbemail.setHorizontalAlignment(SwingConstants.CENTER);
		lbemail.setBounds(156, 118, 117, 14);
		contentPane.add(lbemail);
		
		email = new JTextField();
		email.setBounds(196, 149, 157, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lbsenha = new JLabel("Senha:");
		lbsenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbsenha.setBounds(196, 188, 46, 14);
		contentPane.add(lbsenha);
		
		senha = new JTextField();
		senha.setBounds(196, 213, 157, 20);
		contentPane.add(senha);
		senha.setColumns(10);
		
		JButton btncadastrar = new JButton("Cadastrar");
		
		btncadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				usuario u = new usuario();
				UsuarioDAO dao = new UsuarioDAO();
				u.setNome(nome.getText());
				u.setEmail(email.getText());
				u.setSenha(senha.getText());
				
				
				dao.create(u);
				dispose();
			}
		});
		
		btncadastrar.setBounds(229, 325, 89, 23);
		contentPane.add(btncadastrar);
		
		JButton limpar = new JButton("Limpar");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome.setText(null);
				email.setText(null);
				senha.setText(null);
			}
		});
		limpar.setBounds(340, 325, 89, 23);
		contentPane.add(limpar);
	}
}
