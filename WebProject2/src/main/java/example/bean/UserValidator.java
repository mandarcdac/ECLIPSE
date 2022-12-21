package example.bean;

public class UserValidator {
public static boolean isValid(User ongoingUser) {
	boolean valid = false;
	String uName = ongoingUser.getUsername();
	String pd = ongoingUser.getPassword();
	if(uName.equals("micky")&& pd.equals("kingfisher123"))
		valid = true;
	return valid;
}
}
