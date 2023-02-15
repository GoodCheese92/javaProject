package classapp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SystemSave {
	
	public void infoSave(Application app){
		
		String path = "C:\\embedded_lse\\Java_project\\"+ app.getId() + ".sav";
		File f = new File("C:\\embedded_lse\\Java_project\\");
		
		if(f.exists()) {
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			
			fos = new FileOutputStream(path);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(app); //저장완료
			System.out.println("저장완료!");
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				oos.close();
				fos.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}

	}

}