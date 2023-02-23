package mealtime;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import mtDAO.MtDAO;
import oracle.jdbc.logging.annotations.Visibility;

public class SignUp extends JFrame {

	private JPanel contentPane; 
	private JTextField textID;
	private JTextField textFieldPW;
	private JTextField textFieldPWOK;
	private JTextField textFieldBrith;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JTextField textFieldPHONE;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("아이디");
		lblid.setBounds(26, 41, 57, 15);
		contentPane.add(lblid);
		
		JLabel lblPW = new JLabel("비밀번호");
		lblPW.setBounds(26, 66, 57, 15);
		contentPane.add(lblPW);
		
		JLabel lblPwOk = new JLabel("비밀번호확인");
		lblPwOk.setBounds(26, 91, 93, 15);
		contentPane.add(lblPwOk);
		
		JLabel lblbirth = new JLabel("생일");
		lblbirth.setBounds(26, 120, 57, 15);
		contentPane.add(lblbirth);
		
		JLabel lblname = new JLabel("이름");
		lblname.setBounds(26, 146, 57, 15);
		contentPane.add(lblname);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setBounds(26, 168, 57, 15);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("핸드폰번호");
		lblPhone.setBounds(26, 197, 93, 15);
		contentPane.add(lblPhone);
		
		textID = new JTextField();
		textID.setBounds(118, 38, 116, 21);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textFieldPW = new JTextField();
		textFieldPW.setBounds(118, 63, 116, 21);
		contentPane.add(textFieldPW);
		textFieldPW.setColumns(10);
		
		textFieldPWOK = new JTextField();
		textFieldPWOK.setBounds(118, 88, 116, 21);
		contentPane.add(textFieldPWOK);
		textFieldPWOK.setColumns(10);
		
		textFieldBrith = new JTextField();
		textFieldBrith.setBounds(118, 117, 116, 21);
		contentPane.add(textFieldBrith);
		textFieldBrith.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(118, 143, 116, 21);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(118, 168, 116, 21);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldPHONE = new JTextField();
		textFieldPHONE.setBounds(118, 197, 116, 21);
		contentPane.add(textFieldPHONE);
		textFieldPHONE.setColumns(10);
		
		JButton btnSignUp = new JButton("회원가입");
		btnSignUp.setBounds(203, 254, 97, 23);
		contentPane.add(btnSignUp);
		
		JButton btnID = new JButton("아이디확인");
		btnID.setBounds(257, 37, 97, 23);
		contentPane.add(btnID);
		
		setVisible(true);
		
		
		//회원가입 
		btnSignUp.addMouseListener(new MouseAdapter() {  
			
			@Override
			public void mouseClicked(MouseEvent e) {
			MtDAO mtdao;
			if(textFieldPW.getText().equals(textFieldPWOK.getText())) {
				try {
					mtdao = new MtDAO();
					boolean gaip = mtdao.insert_member(textID.getText(),textFieldPW.getText(),textFieldName.getText(),textFieldBrith.getText(),textFieldEmail.getText(),textFieldPHONE.getText());
					
						if(gaip) {
							JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
							dispose();
							setVisible(false);
							new Login().setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "회원가입이 안되었습니다.");
						}
				
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}	
			}else {
				JOptionPane.showMessageDialog(null, "비밀번호 확인이 다릅니다");
			}
			
			}
			
			
		});

		
		//아이디 중복체크
		btnID.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					MtDAO dao = new MtDAO();
					if(dao.checkId(textID.getText())) {
						JOptionPane.showMessageDialog(SignUp.this, "ID가 중복됩니다.");
						textID.setText("");
					}else{
						JOptionPane.showMessageDialog(SignUp.this, "사용가능한 ID입니다.");
					}
				} catch (ClassNotFoundException e2) {
					System.out.println("ClassNotFoundException error");
					
				} catch (SQLException e2) {
					System.out.println("SQLException error");
					
				}	
			}
		});
		
	}
}
