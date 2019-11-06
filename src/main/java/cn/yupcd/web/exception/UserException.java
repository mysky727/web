package cn.yupcd.web.exception;

public class UserException extends RuntimeException {

	public UserException() {
		super("User not exist!");
	}
	
	public UserException(String msg) {
		super(msg);
	}
}
