## :pushpin: mealtime
>음식 메뉴 추천 프로그램 


</br>

### 1.제작기간&참여 인원
* 2022.9.13 ~ 2022.9.19   
* 팀프로젝트

</br>

### 2.사용기술
* JAVA11   
* ORACLE

</br>

### 3.ERD
<img src="./ERD.png" width="500" height="500">

</br>

### 4.핵심기능
이 프로그램의 핵심기능은 음식 메뉴 추천입니다.    
사용자는 음식종류, 면과 국수, 매운 것과 안 매운 것, 뜨거운 것과 차가운 것, 가격대, 지역 선택 후    
랜덤으로 음식을 추천받을 수 있습니다.    
그리고 조회된 음식점을 이용 후에 평점을 매길 수 있습니다.   
   
<details>
<summary>핵심기능설명펼치기</summary>   
   
#### 4-1. 전체흐름     
   
</br>     
   
<img src="./프로그램구조.PNG" width="500" height="500">
   
#### 4-2. 사용자 입력   
[코드보기](https://github.com/Seoha95/mealtime/blob/main/src/mealtime/Login.java#:~:text=Blame-,package%20mealtime%3B,%7D,-Give%20feedback)  
<details>   
<summary>코드보기</summary>  
      
```
//   
setTitle("밀타임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoing = new JButton("로그인");
		btnLoing.setFont(new Font("굴림", Font.BOLD, 12));
		btnLoing.setBounds(89, 182, 104, 34);
		contentPane.add(btnLoing);
		contentPane.setName("");
		
		JButton btnSignUp = new JButton("회원가입");
		btnSignUp.setFont(new Font("굴림", Font.BOLD, 12));
		btnSignUp.setBounds(230, 182, 104, 34);
		contentPane.add(btnSignUp);
```   
</details> 
</details>   

</br>

### 5.핵심 트러블 슈팅 

### 6. 느낀점



