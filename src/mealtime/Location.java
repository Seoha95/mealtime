package mealtime;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mtVO.Mt_UserInfo;


public class Location extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Location frame = new Location();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Location() {
		Mt_UserInfo userinfo = Mt_UserInfo.getUserInfo();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("노량진1동");
		btnNewButton.setBounds(568, 112, 97, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userinfo.setG_jooso("노량진 1동");
				System.out.println(userinfo.getG_jooso());
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("노량진2동");
		btnNewButton_1.setBounds(568, 210, 97, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userinfo.setG_jooso("노량진 2동");
				System.out.println(userinfo.getG_jooso());
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("확인");
		btnNewButton_1_1.setBounds(734, 414, 97, 23);
		contentPane.add(btnNewButton_1_1);
		
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			dispose();
			try {
				new TodayMenu().setVisible(true);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setVisible(false);
			}
			});
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	      JLabel lblNewLabel = new JLabel("");
	      lblNewLabel.setIcon(new ImageIcon(Location.class.getResource("/mealtime/map.PNG")));
	      lblNewLabel.setBounds(83, 47, 401, 300);
	      contentPane.add(lblNewLabel);

	}
}
