package menu_information;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import menu_frame.CafePayFrame;
import path.ProjectMyPath;

public class SaveUserInfo implements ActionListener {

	private TextField id;
	private TextField pw;
	private TextField pw_check;
	private TextField name;
	private TextField birthday;
	private TextField phoneNum;

	private JFrame frame;

	// 학원
//	File file = new File(ProjectMyPath.path + "\\Ex_0203_Java_Project\\src\\user_information\\userInfo");
	// 집
	File file = new File("C:/embedded_LSJ/work/"  + "\\Ex_0203_Java_Project\\src\\user_information\\userInfo");

	FileOutputStream fos = null;
	ObjectOutputStream oos = null;

	public SaveUserInfo(TextField id, TextField pw, TextField pw_check, TextField name, TextField birthday, TextField phoneNum,
			JFrame frame) {
		this.id = id;
		this.pw = pw;
		this.pw_check = pw_check;
		this.name = name;
		this.birthday = birthday;
		this.phoneNum = phoneNum;
		this.frame = frame;
	} // end of constructor

	UserInfomation userInfo = new UserInfomation();

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!file.exists()) {
			file.mkdirs();
		} else {
			//System.out.println("경로가 존재합니다.");
		}
		boolean idCheck = true;

		// 아이디 숫자인지 확인
		for (int i = 0; i < id.getText().length(); i++) {
			if (id.getText().trim().charAt(i) >= '0' && id.getText().trim().charAt(i) <= '9') {

			} else {
				idCheck = false;
				break;
			}

		} // for

		boolean isInfo = true;	// 입력 정보 하나라도 틀리면 false
		
		if (id.getText().trim().length() == 10 && idCheck) {
			userInfo.setId(id.getText().trim());
		} else {
			isInfo = false;
		}
		
		int majorNum = 0;
		// 과정보 입력
		try {
			majorNum = Integer.parseInt(id.getText().trim().substring(4, 7));	
		} catch (Exception e2) {
			isInfo = false;
		}
		switch (majorNum) {
		case 1:
			userInfo.setMajorName("철학과");
			break;
		case 2:
			userInfo.setMajorName("국문학과");
			break;
		case 3:
			userInfo.setMajorName("사학과");
			break;
		case 11:
			userInfo.setMajorName("물리학과");
			break;
		case 12:
			userInfo.setMajorName("화학과");
			break;
		case 13:
			userInfo.setMajorName("수학과");
			break;
		case 21:
			userInfo.setMajorName("경영학과");
			break;
		case 22:
			userInfo.setMajorName("경제학과");
			break;
		case 23:
			userInfo.setMajorName("법학과");
			break;
		case 31:
			userInfo.setMajorName("전기전자공학과");
			break;
		case 32:
			userInfo.setMajorName("컴퓨터공학과");
			break;
		case 33:
			userInfo.setMajorName("정보통신공학과");
			break;
		default:
			isInfo = false;
			break;
		} // switch
		
		int grade = 0;
		
		try {
			grade = Integer.parseInt(id.getText().trim().substring(0, 4));	
		} catch (Exception e2) {
			isInfo = false;
		}
		switch (grade) {
		case 2023:
			userInfo.setGrade("1학년");
			break;
		case 2022:
			userInfo.setGrade("2학년");
			break;
		case 2021:
			userInfo.setGrade("3학년");
			break;
		case 2020:
			userInfo.setGrade("4학년");
			break;
		case 2019:
			userInfo.setGrade("4학년");
			break;
		case 2018:
			userInfo.setGrade("4학년");
			break;
		case 2017:
			userInfo.setGrade("4학년");
			break;
		case 2016:
			userInfo.setGrade("4학년");
			break;
		case 2015:
			userInfo.setGrade("4학년");
			break;
		case 2014:
			userInfo.setGrade("4학년");
			break;
		case 2013:
			userInfo.setGrade("4학년");
			break;
		case 2012:
			userInfo.setGrade("4학년");
			break;
		case 2011:
			userInfo.setGrade("4학년");
			break;
		default:
			isInfo = false;
			break;
		} // switch
		
		// 비밀번호 재확인 같은지 비교
		boolean isPw = true;
		userInfo.setPw(pw.getText().trim());
		
		if(!pw.getText().trim().equals(pw_check.getText().trim())) {
			isInfo = false;
			isPw = false;
		}
		
		userInfo.setName(name.getText().trim());
		
		// 생일정보 입력 오류 확인
		boolean isBirthday = true;
		for(int i=0; i<birthday.getText().trim().length();i++) {
			if(birthday.getText().trim().charAt(i) >= '0' && birthday.getText().trim().charAt(i) <= '9') {
				
			} else {
				isInfo = false;
				isBirthday = false;
				break;
			}
		} // for
		
		if (birthday.getText().trim().length() == 6 && isBirthday) {
			try {
				userInfo.setBirthday(Integer.parseInt(birthday.getText().trim()));
			} catch (Exception e2) {
				// TODO: handle exception
			}
		} else {
			isInfo = false;
		}
		
		// 핸드폰 번호 정보 오류 확인
		boolean isphoneNum = true;
		for(int i=0; i<phoneNum.getText().trim().length();i++) {
			if(phoneNum.getText().trim().charAt(i) >= '0' && phoneNum.getText().trim().charAt(i) <= '9') {
				
			} else {
				isInfo = false;
				isphoneNum = false;
				break;
			}
		} // for
		
		if (phoneNum.getText().trim().length() == 11 && isphoneNum) {
			try {
				userInfo.setPhoneNum(Integer.parseInt(phoneNum.getText().trim()));
			} catch (Exception e2) {
				// TODO: handle exception
			}
		} else {
			isInfo = false;
		}

		if (isInfo) {
			try {

				fos = new FileOutputStream(file + "/" + userInfo.getId().trim() + ".info");
				oos = new ObjectOutputStream(fos);

				oos.writeObject(userInfo);

				frame.dispose();
			} catch (

			Exception e2) {
				e2.printStackTrace();
			} finally {
				try {
					oos.close();
					fos.close();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		} else {
			JFrame frame = new JFrame();
			frame.setLayout(new BorderLayout());
			frame.setBounds(750, 200, 200, 120);
			
			JLabel lb = new JLabel("<html><center>회원 정보를<br>잘못 입력하셨습니다.</center></html>");
			lb.setHorizontalTextPosition(JLabel.CENTER);
			lb.setHorizontalAlignment(JLabel.CENTER);
			lb.setFont(new Font("hy헤드라인m", Font.BOLD, 15));
			
			frame.add(lb, BorderLayout.CENTER);
			frame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					frame.dispose();
				}
			});
			frame.setResizable(false);
			frame.setVisible(true);
			
		}

	} // end of actionPerformed()

} // end of class
