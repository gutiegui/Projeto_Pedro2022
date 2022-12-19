package VIEW;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.StringWriter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class frmPrincipalVIEW extends JFrame {



	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipalVIEW frame = new frmPrincipalVIEW();
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
	public frmPrincipalVIEW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Pediatra", "Clinico Geral", "Ortopedista", "Geriatra", "Dermatologista", "Ginecologista", "Oftalmologista", "Cardiologista"}));
		comboBox.setBounds(152, 83, 100, 22);
		contentPane.add(comboBox);
		

		


		JLabel lblNewLabel = new JLabel("Escolha uma especialidade:");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 25));
		lblNewLabel.setBounds(67, 11, 293, 44);
		contentPane.add(lblNewLabel);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Sua consulta foi marcada");

			
			}
		});
		btnConfirmar.setBounds(143, 132, 109, 23);
		contentPane.add(btnConfirmar);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\eclipse-workspace\\teste\\Projeto2\\img\\fundo-de-cor-de-luz-verde-e-azul-neon-fundo-gradiente-desfocado-abstrato-modelo-de-banner_335640-3364.jpg"));
		lblNewLabel_1.setBounds(0, 0, 385, 219);
		contentPane.add(lblNewLabel_1);
		
	}
}
