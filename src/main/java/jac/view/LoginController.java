package jac.view;

import jac.login.Login;
import jac.service.LoginService;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FilenameUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@SessionScoped
@ManagedBean
public class LoginController {

	@Autowired
	private LoginService loginService;

	private String username;
	private String password;
	private Login user;
	private UploadedFile uploadedFile;

	private Login fetchLoginByUsername() {
		if (username != null) {
			return loginService.getLoginByUsername(this.username);
		} 
		// TODO: improve this action
		return null;
	
	}

	public String login() {
		Login login = fetchLoginByUsername();
		if (login != null && username.equals(login.getUsername())
				&& password.equals(login.getPassword())) {
			user = login;

			return "main";
		} else
			return "failure";
	}

	public boolean upload() throws IOException {
		// try {
		// // fileContent = new
		// Scanner(file.getInputStream()).useDelimiter("\\A").next();
		// return true;
		// } catch (IOException e) {
		// // Error handling
		// return false;
		// }
		String fileName = FilenameUtils.getName(uploadedFile.getName());
		String contentType = uploadedFile.getContentType();
		byte[] bytes = uploadedFile.getBytes();

		System.out.println("este es el archivo" + bytes);
		// Now you can save bytes in DB (and also content type?)
		saveCopyFromFile(bytes, "/Volumes/mac/Users/alejohuertas/Desktop/", "pepe");
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(String.format("File '%s' of type '%s' successfully uploaded!",	fileName, contentType)));
		return false;
	}

	private void saveCopyFromFile (byte[] fileBytes, String path, String filename ){
		//convert array of bytes into file
	    try {
	    	FileOutputStream fileOuputStream = new FileOutputStream(path+filename); 
			fileOuputStream.write(fileBytes);
			fileOuputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	}
	
	
	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Login getUser() {
		return user;
	}

	public void setUser(Login user) {
		this.user = user;
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	// public ApplicationFile getFile() {
	// return file;
	// }
	//
	// public void setFile(ApplicationFile file) {
	// this.file = file;
	// }

}
