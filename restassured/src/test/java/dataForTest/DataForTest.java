package dataForTest;

import org.testng.annotations.DataProvider;

public class DataForTest {
	
	@DataProvider(name="datafortest")
	public Object[][] dataForPost(){
//		Object[][] data = new Object[2][2];
//		
//		data[0][0] = "sherin";
//		data[0][1] = "eng";
//		
//		data[1][0] = "jeffe";
//		data[1][1] = "clg";
//		
//		return data;
		
		return new Object[][] {
			{"carlin", "hw"},
			{"john", "bs"}
		};
		
	}
	
	@DataProvider(name = "datafordelete")
	public Object[] dataForDelete() {
		
		return new Object[] {
				5,6,7,8
		};
	}
	

}
