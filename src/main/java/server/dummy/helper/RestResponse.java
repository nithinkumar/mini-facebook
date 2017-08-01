package server.dummy.helper;


public class RestResponse<T> {

	private int status;
	private T dataMap;
	private String message;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public T getDataMap() {
		return dataMap;
	}
	public void setDataMap(T dataMap) {
		this.dataMap = dataMap;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
