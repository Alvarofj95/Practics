package Controller;

import model.Model;
import views.AddFromDirector;
import views.AddStudentTutor;
import views.Companies;
import views.DBConnection;
import views.DirectorPanel;
import views.HelpCenter;
import views.Login;
import views.ManageStudent;
import views.ResetPassword;
import views.Settings;
import views.SettingsDirector;
import views.SignUp;
import views.TablesDirector;
import views.UpdateFromDirector;
import views.UpdateFromTutor;

public class Launcher {
	
	
	public static void main(String[] args) {
		Controller myController = new Controller();
		Model myModel = new Model();

		// Create objects of windows

		Login myLogin = new Login();
		HelpCenter myHelpCenter = new HelpCenter();
		ManageStudent myManageStudent = new ManageStudent();
		ResetPassword myResetPassword = new ResetPassword();
		SignUp mySignUp = new SignUp();
		Settings mySettings = new Settings();
		DirectorPanel myDirectorPanel = new DirectorPanel();
		Companies myCompanies = new Companies();
		SettingsDirector mySettingsDirector = new SettingsDirector();
		DBConnection myDBConnection = new DBConnection();
		TablesDirector myTablesDirector = new TablesDirector();
		AddFromDirector myAddCompanyDirector = new AddFromDirector();
		AddStudentTutor myAddStudentTutor = new AddStudentTutor();
		UpdateFromDirector myUpdateFromDirector = new UpdateFromDirector();
		UpdateFromTutor myUpdateFromTutor = new UpdateFromTutor();

		// Window to controller relationships

		myController.setModel(myModel);
		myController.setLogin(myLogin);
		myController.setHelpCenter(myHelpCenter);
		myController.setManageStudent(myManageStudent);
		myController.setResetPassword(myResetPassword);
		myController.setSettings(mySettings);
		myController.setSignUp(mySignUp);
		myController.setDirectorPanel(myDirectorPanel);
		myController.setCompanies(myCompanies);
		myController.setSettingsDirector(mySettingsDirector);
		myController.setDBConexion(myDBConnection);
		myController.setTablesDirector(myTablesDirector);
		myController.setAddCompanyDirector(myAddCompanyDirector);
		myController.setAddStudentTutor(myAddStudentTutor);
		myController.setUpdateFromDirector(myUpdateFromDirector);
		myController.setUpdateFromTutor(myUpdateFromTutor);

		// We relate Views to Controller and Model

		myLogin.setController(myController);
		myLogin.setModel(myModel);
		myHelpCenter.setModel(myModel);
		myHelpCenter.setController(myController);
		myManageStudent.setModel(myModel);
		myManageStudent.setController(myController);
		myResetPassword.setModel(myModel);
		myResetPassword.setController(myController);
		mySettings.setController(myController);
		mySettings.setModel(myModel);
		mySignUp.setController(myController);
		mySignUp.setModel(myModel);
		myDirectorPanel.setModel(myModel);
		myDirectorPanel.setController(myController);
		myCompanies.setModel(myModel);
		myCompanies.setController(myController);
		mySettingsDirector.setModel(myModel);
		mySettingsDirector.setController(myController);
		myDBConnection.setModel(myModel);
		myDBConnection.setController(myController);
		myTablesDirector.setModel(myModel);
		myTablesDirector.setController(myController);
		myAddCompanyDirector.setController(myController);
		myAddCompanyDirector.setModel(myModel);
		myAddStudentTutor.setController(myController);
		myAddStudentTutor.setModel(myModel);
		myUpdateFromDirector.setModel(myModel);
		myUpdateFromDirector.setController(myController);
		myUpdateFromTutor.setModel(myModel);
		myUpdateFromTutor.setController(myController);

		// We relate Model with all views

		myModel.setVista(myLogin);
		myModel.setMyHelpCenter(myHelpCenter);
		myModel.setMyManageStudent(myManageStudent);
		myModel.setMyResetPassword(myResetPassword);
		myModel.setMySettings(mySettings);
		myModel.setMyRegistro(mySignUp);
		myModel.setDirectorPanel(myDirectorPanel);
		myModel.setCompanies(myCompanies);
		myModel.setSettingsDirector(mySettingsDirector);
		myModel.setDBConexion(myDBConnection);
		myModel.setTablesDirector(myTablesDirector);
		myModel.setAddCompanyDirector(myAddCompanyDirector);
		myModel.setAddStudentTutor(myAddStudentTutor);
		myModel.setUpdateFromDirector(myUpdateFromDirector);
		myModel.setUpdateFromTutor(myUpdateFromTutor);
		myLogin.setVisible(true);
	}
}
