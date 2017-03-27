import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class AccessFileClass {
	InputStream in = null;
	DataInputStream dataIn = null;
	private int fileLength = 0;
	
	public int getFileLength() {
		return this.fileLength;
	}
	
	public boolean closeFile() {
		try {
			 this.dataIn.close();
		} catch(Exception e){
			return false;
		}
		return true;
	}
	
	public boolean openFile(String fileName) {
		try {
			 in = new FileInputStream(fileName);
			 dataIn = new DataInputStream(in);
		} catch(Exception e){
			return false;
		}
		return true;
	}
	public String[][] getFileDataToArray(String fileName, int rows, boolean needSkip) {
		String[][] data = new String[100][rows];
		int index = 0;
		try {
			if(this.openFile(fileName)) {
				while (dataIn.available() > 0) {
					String str;
					str = dataIn.readLine();
					if (needSkip) {
						needSkip = false;
						continue;
					}
					data[index] = str.split(",");
					index++;
				} // csv에 있는 것들을 가지고 온다
				fileLength = index;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		this.closeFile();
		return data;
	}
}
