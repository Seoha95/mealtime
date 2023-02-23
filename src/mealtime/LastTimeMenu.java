package mealtime;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mtDAO.MtDAO;
import mtVO.Mt_UserInfo;
import mtVO.Mt_VO;



public class LastTimeMenu extends JFrame {
	private String date1;
	private String date2;
	private String date3;
	private JPanel contentPane;
	Mt_UserInfo userinfo = Mt_UserInfo.getUserInfo();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LastTimeMenu frame = new LastTimeMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		
	public LastTimeMenu(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("지난메뉴보기");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 24));
		lblNewLabel.setBounds(172, 10, 212, 44);
		contentPane.add(lblNewLabel);
		ArrayList<Mt_VO> curL= null;
		
		try {
			MtDAO mtdao = new MtDAO();
			
			curL = mtdao.getCurtList(userinfo.getMem_id());
			if(curL.size()!=0) {
				for(Mt_VO vo : curL) {
					System.out.println(vo.getCurt_date() +"\t"+ vo.getG_name() +"\t"+ vo.getMu_name());
				}
			}else {
				System.out.println("비었다");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(curL.size() == 0) {
		}else if(curL.size() == 1) {
			date1 = curL.get(0).getCurt_date();
		}else if(curL.size() == 2) {
			date1 = curL.get(0).getCurt_date();
			date2 = curL.get(1).getCurt_date();
		}else {
			date1 = curL.get(0).getCurt_date();
			date2 = curL.get(1).getCurt_date();
			date3 = curL.get(2).getCurt_date();
		}	
		
		if(curL.size() ==0) {
			JButton btnMenu = new JButton("메뉴추천");
			btnMenu.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					setVisible(false);
					new MenuRecommend().setVisible(true);
				}
				
				
			});
			btnMenu.setBounds(160, 240, 126, 51);
			contentPane.add(btnMenu);
			
			JLabel Label1 = new JLabel(" 없음");
			Label1.setBounds(63, 97, 319, 27);
			contentPane.add(Label1);
			
		}else if(curL.size() == 1) {
			JButton btnMenu = new JButton("메뉴추천");
			btnMenu.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					setVisible(false);
					new MenuRecommend().setVisible(true);
				}
				
				
			});
			btnMenu.setBounds(160, 240, 126, 51);
			contentPane.add(btnMenu);
			
			JLabel Label1 = new JLabel(curL.get(0).getCurt_date()+"    "+curL.get(0).getG_name()+"    "+curL.get(0).getMu_name());
			Label1.setBounds(63, 97, 319, 27);
			contentPane.add(Label1);
			
			JButton btn1 = new JButton("삭제");
			btn1.setBounds(399, 99, 97, 23);
			contentPane.add(btn1);
			
			
			
			
			btn1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						MtDAO dao = new MtDAO();
						dao.delete_curt(userinfo.getMem_id(),date1);
						JOptionPane.showMessageDialog(btn1, "삭제했습니다.");
						dispose();
						setVisible(false);
						new LastTimeMenu().setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			
		
		}else if(curL.size() == 2) {
			JButton btnMenu = new JButton("메뉴추천");
			btnMenu.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					setVisible(false);
					new MenuRecommend().setVisible(true);
				}
				
				
			});
			btnMenu.setBounds(160, 240, 126, 51);
			contentPane.add(btnMenu);
			
			JLabel Label1 = new JLabel(curL.get(0).getCurt_date()+"    "+curL.get(0).getG_name()+"    "+curL.get(0).getMu_name());
			Label1.setBounds(63, 97, 319, 27);
			contentPane.add(Label1);
			
			JLabel Label2 = new JLabel(curL.get(1).getCurt_date()+"    "+curL.get(1).getG_name()+"    "+curL.get(1).getMu_name());
			Label2.setBounds(63, 134, 321, 27);
			contentPane.add(Label2);
			
			JButton btn1 = new JButton("삭제");
			btn1.setBounds(399, 99, 97, 23);
			contentPane.add(btn1);
			
			JButton btn2 = new JButton("삭제");
			btn2.setBounds(396, 132, 97, 23);
			contentPane.add(btn2);
			
			
			btn1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						MtDAO dao = new MtDAO();
						dao.delete_curt(userinfo.getMem_id(),date1);
						JOptionPane.showMessageDialog(btn1, "삭제했습니다.");
						dispose();
						setVisible(false);
						new LastTimeMenu().setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			
			btn2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						MtDAO dao = new MtDAO();
						dao.delete_curt(userinfo.getMem_id(),date2);
						JOptionPane.showMessageDialog(btn1, "삭제했습니다.");
						dispose();
						setVisible(false);
						new LastTimeMenu().setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			
			
		}else {
			JButton btnMenu = new JButton("메뉴추천");
			btnMenu.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					setVisible(false);
					new MenuRecommend().setVisible(true);
				}
				
				
			});
			btnMenu.setBounds(160, 240, 126, 51);
			contentPane.add(btnMenu);
			
			JLabel Label1 = new JLabel(curL.get(0).getCurt_date()+"    "+curL.get(0).getG_name()+"    "+curL.get(0).getMu_name());
			Label1.setBounds(63, 97, 319, 27);
			contentPane.add(Label1);
			
			JLabel Label2 = new JLabel(curL.get(1).getCurt_date()+"    "+curL.get(1).getG_name()+"    "+curL.get(1).getMu_name());
			Label2.setBounds(63, 134, 321, 27);
			contentPane.add(Label2);
			
			JLabel Label3 = new JLabel(curL.get(2).getCurt_date()+"    "+curL.get(2).getG_name()+"    "+curL.get(2).getMu_name());
			Label3.setBounds(69, 171, 315, 27);
			contentPane.add(Label3);
			
			JButton btn1 = new JButton("삭제");
			btn1.setBounds(399, 99, 97, 23);
			contentPane.add(btn1);
			
			JButton btn2 = new JButton("삭제");
			btn2.setBounds(396, 132, 97, 23);
			contentPane.add(btn2);
			
			JButton btn3 = new JButton("삭제");
			btn3.setBounds(399, 173, 97, 23);
			contentPane.add(btn3);
			
			btn1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						MtDAO dao = new MtDAO();
						dao.delete_curt(userinfo.getMem_id(),date1);
						JOptionPane.showMessageDialog(btn1, "삭제했습니다.");
						dispose();
						setVisible(false);
						new LastTimeMenu().setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			
			btn2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						MtDAO dao = new MtDAO();
						dao.delete_curt(userinfo.getMem_id(),date2);
						JOptionPane.showMessageDialog(btn1, "삭제했습니다.");
						dispose();
						setVisible(false);
						new LastTimeMenu().setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			
			
			
			btn3.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							MtDAO dao = new MtDAO();
							dao.delete_curt(userinfo.getMem_id(),date3);
							JOptionPane.showMessageDialog(btn1, "삭제했습니다.");
							dispose();
							setVisible(false);
							new LastTimeMenu().setVisible(true);
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
				
			});
		}
	}
}
