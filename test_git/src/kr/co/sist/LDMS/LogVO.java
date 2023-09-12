package kr.co.sist.LDMS;

public class LogVO {

	private String browser;
	private String type;
	private String time;
	private String key;

	public LogVO() {
	}// constructor

	public LogVO(String data) throws ArrayIndexOutOfBoundsException{
		this();
		String[] dataArr = null;
		String keyData = "";
		dataArr = data.substring(1, data.length() - 1).split("\\]\\[");
		type = dataArr[0];
		keyData = dataArr[1];
		if (data.contains("key")) {
			key = keyData.substring(keyData.indexOf("=") + 1, keyData.indexOf("&"));
		} else {
			key = "null";
		} // else
		browser = dataArr[2];
		time = dataArr[3];
	}// LogVO

	// getter / setter 
	public String getBrowser() {
		return browser;
	}// getBrowser
	public String getType() {
		return type;
	}// getType
	public String getTime() {
		return time;
	}// getTime
	public String getKey() {
		return key;
	}// getKey
}// LogVO
