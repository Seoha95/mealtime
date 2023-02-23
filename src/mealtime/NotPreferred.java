package mealtime;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import mtVO.Mt_UserInfo;

public class NotPreferred extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotPreferred frame = new NotPreferred();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public NotPreferred() {

		ButtonGroup RNN = new ButtonGroup();
		ButtonGroup HOT = new ButtonGroup();
		ButtonGroup COL = new ButtonGroup();
		ButtonGroup MET = new ButtonGroup();
		Mt_UserInfo userinfo = Mt_UserInfo.getUserInfo();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbltitle = new JLabel("오늘안땡기는음식류");
		lbltitle.setFont(new Font("굴림", Font.BOLD, 20));
		lbltitle.setBounds(168, 31, 205, 47);
		contentPane.add(lbltitle);
		
		JRadioButton ckRNN1 = new JRadioButton("면");
		ckRNN1.setSelected(true);
		ckRNN1.setBounds(149, 137, 115, 23);
		contentPane.add(ckRNN1);
		RNN.add(ckRNN1);
		
		JRadioButton ckRNN2 = new JRadioButton("밥");
		ckRNN2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		ckRNN2.setBounds(268, 137, 115, 23);
		contentPane.add(ckRNN2);
		RNN.add(ckRNN2);
		
		JCheckBox ckHot1 = new JCheckBox("매운거");
		ckHot1.setSelected(true);
		ckHot1.setBounds(149, 162, 115, 23);
		contentPane.add(ckHot1);
		HOT.add(ckHot1);
		JCheckBox ckHot2 = new JCheckBox("안매운거");
		ckHot2.setBounds(268, 162, 115, 23);
		contentPane.add(ckHot2);
		HOT.add(ckHot2);
		
		
		JRadioButton Cool1 = new JRadioButton("차가운거");
		Cool1.setSelected(true);
		Cool1.setBounds(149, 183, 115, 23);
		contentPane.add(Cool1);
		COL.add(Cool1);
		JRadioButton Cool2 = new JRadioButton("뜨거운거");
		Cool2.setBounds(268, 183, 115, 23);
		contentPane.add(Cool2);
		COL.add(Cool2);
		JCheckBox Met1 = new JCheckBox("육류");
		Met1.setSelected(true);
		Met1.setBounds(149, 208, 115, 23);
		contentPane.add(Met1);
		MET.add(Met1);
		JCheckBox Met2 = new JCheckBox("해산물");
		Met2.setBounds(268, 208, 115, 23);
		contentPane.add(Met2);
		MET.add(Met2);
		
		JButton btnNewButton = new JButton("다음");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ckRNN1.isSelected()) {
					userinfo.setMu_rnn("면");
				}else{
					userinfo.setMu_rnn("밥");
				};
				if(ckHot1.isSelected()) {
					userinfo.setMu_meaoon("매운거");
				}else{
					userinfo.setMu_meaoon("안매운거");
				};
				if(Cool1.isSelected()) {
					userinfo.setMu_ondo("차가운거");
				}else{
					userinfo.setMu_ondo("뜨거운거");
				};
				if(Met1.isSelected()) {
					userinfo.setMu_meat("육류");
				}else{
					userinfo.setMu_meat("해산물");
				};
			dispose();
			new Price().setVisible(true);
			setVisible(false);
			}
			});
		btnNewButton.setBounds(223, 333, 107, 36);
		contentPane.add(btnNewButton);
	}
}
