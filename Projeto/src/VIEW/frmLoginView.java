package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UsuarioDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import DTO.UsuarioDTO;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;

public class frmLoginView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeUsuario;
	private JPasswordField txtSenhaUsuario;
	private final JLabel label = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLoginView frame = new frmLoginView();
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
	public frmLoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome de Usuario");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel.setBounds(116, 211, 112, 14);
		contentPane.add(lblNewLabel);
		
		txtNomeUsuario = new JTextField();
		txtNomeUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					txtSenhaUsuario.requestFocus();
				}
			}
		});
		txtNomeUsuario.setBounds(116, 236, 260, 20);
		contentPane.add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha de Usuário");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(116, 267, 112, 14);
		contentPane.add(lblNewLabel_1);
		
		txtSenhaUsuario = new JPasswordField();
		txtSenhaUsuario.setBounds(117, 292, 259, 20);
		contentPane.add(txtSenhaUsuario);
		
		JButton btnEntrarSistema = new JButton("Entrar");
		btnEntrarSistema.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnEntrarSistema.setBounds(100, 338, 89, 23);
		btnEntrarSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String nome_usuario, senha_usuario;
					
					nome_usuario = txtNomeUsuario.getText();
					senha_usuario = txtSenhaUsuario.getText();
					
					DTO.UsuarioDTO objusuariodto = new UsuarioDTO();
					objusuariodto.setNome_usuario(nome_usuario);
					objusuariodto.setSenha_usuario(senha_usuario);
					
					UsuarioDAO objusuariodao = new UsuarioDAO();
					ResultSet rsusuariodao = objusuariodao.autenticacaoUsuario(objusuariodto);
					
					if (rsusuariodao.next()) {
						//chamar tela que eu quero abrir
						frmPrincipalVIEW objfrmprincipalview = new frmPrincipalVIEW();
						objfrmprincipalview.setVisible(true);
						
						dispose();
						
					}else {
						//Tela dizendo incorreto
						JOptionPane.showMessageDialog(null,"Usuario ou senha invalido");
						
					}
					
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null,"FRMLOGINVIEW" + erro);
					
				}
			}
		});
		contentPane.add(btnEntrarSistema);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnSair.setBounds(298, 338, 89, 23);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame frmLoginView = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLoginView,"Confirm if you want to change login","Register Systems",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
					frmLoginView.setVisible(false);
					
					System.exit(0);
			
				}
			}
		});
		contentPane.add(btnSair);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnLimpar.setBounds(199, 338, 89, 23);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomeUsuario.setText(null);
				txtSenhaUsuario.setText(null);
			}
		});
		contentPane.add(btnLimpar);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(176, 65, 112, 108);
		lblNewLabel_6.setIcon(new ImageIcon("C:\\eclipse-workspace\\teste\\Projeto2\\img\\hospital-logo-design-vector-medical-cross_53876-136743-removebg-preview.png"));
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(86, 147, 46, 36);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\eclipse-workspace\\teste\\Projeto2\\img\\user.png"));
		contentPane.add(lblNewLabel_3);
		label.setBounds(449, 65, 46, 31);
		contentPane.add(label);
		label.setIcon(new ImageIcon("C:\\eclipse-workspace\\teste\\Projeto2\\img\\user.png"));
		
		JLabel lblNewLabel_5 = new JLabel("LOGIN");
		lblNewLabel_5.setForeground(new Color(0, 206, 209));
		lblNewLabel_5.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 40));
		lblNewLabel_5.setBounds(165, 11, 123, 43);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_2 = new JLabel("asdadas");
		lblNewLabel_2.setBounds(0, 11, 479, 373);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\eclipse-workspace\\teste\\Projeto2\\img\\gradiente-azul-claro-fundo.jpg"));
		lblNewLabel_2.setBackground(Color.BLUE);
		lblNewLabel_2.setForeground(Color.BLACK);
		contentPane.add(lblNewLabel_2);
		
		
	}
}
