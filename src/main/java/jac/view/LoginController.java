package jac.view;

import jac.login.Login;
import jac.service.LoginService;
import jac.ws.mtom.client.WebServiceAppClient;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
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

	@Autowired
	private WebServiceAppClient webServiceClient;
	@Autowired
	Logger logger;

	private Login fetchLoginByUsername() {
		if (username != null) {
			return loginService.getLoginByUsername(this.username);
		} 
		// TODO: improve this action
		logger.warn("There is no username entered");
		return null;
	
	}

	public String login() {
		Login login = fetchLoginByUsername();
		if (login != null && username.equals(login.getUsername())
				&& password.equals(login.getPassword())) {
			user = login;
			logger.info("User logged in successfully");
			return "main";
		} else{
			logger.error("Error at login, invalid credentials");	
			return "failure";
		}
	}

	public boolean upload() {
		
		try {
			String fileName = FilenameUtils.getName(uploadedFile.getName());
			String contentType = uploadedFile.getContentType();
			byte[] bytes = uploadedFile.getBytes();
	
			// saveCopyFromFile(bytes, "/Volumes/mac/Users/alejohuertas/Desktop/", "pepe");
			// Send file throug webservice 
			webServiceClient.sendFile(fileName, bytes);
			
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(String.format("File '%s' of type '%s' successfully uploaded!",	
							fileName, contentType)));
			logger.info("User zip file successfully uploaded");
		}
		catch(IOException e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File 'NOT  uploaded!"));
			logger.error("File was not uploaded due error", e);
			return false;
		}
		return true;
	}

	@SuppressWarnings("unused")
	private void saveCopyFromFile (byte[] fileBytes, String path, String filename ){
		//convert array of bytes into file
	    try {
	    	FileOutputStream fileOuputStream = new FileOutputStream(path+filename); 
			fileOuputStream.write(fileBytes);
			fileOuputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	       
	}
	
	public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login.xhtml?faces-redirect=true";
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
}
