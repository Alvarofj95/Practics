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
import views.Views;

public class Controller {

	private Model myModel;
	private Views[] myViews;
	@SuppressWarnings("unused")
	private SettingsDirector mySettingsDirector = new SettingsDirector();
	private Settings mySettings = new Settings();
	@SuppressWarnings("unused")
	private SignUp mySignUp = new SignUp();
	private TablesDirector myTablesDirector = new TablesDirector();
	private DirectorPanel myDirectorPanel = new DirectorPanel();

	@SuppressWarnings("unused")
	private ManageStudent myManageStudent = new ManageStudent();

	@SuppressWarnings("unused")
	private AddFromDirector myAddFromDirector = new AddFromDirector();

	// BUILDER

	public Controller() {

		this.myViews = new Views[16];
		myModel = new Model();
	}

	// GENERAL METHODS

	public void accessDB() {
		myModel.access();
		myModel.loadPhotoDir();
	}

	// MOVE INTO WINDOWS

	public void setLogin(Login myLogin) {
		this.myViews[0] = myLogin;
	}

	public void setSignUp(SignUp mySignUp) {
		this.myViews[1] = mySignUp;
	}

	public void setResetPassword(ResetPassword myResetPassword) {
		this.myViews[2] = myResetPassword;
	}

	public void setManageStudent(ManageStudent myManageStudent) {
		this.myViews[4] = myManageStudent;
	}

	public void setHelpCenter(HelpCenter myHelpCenter) {
		this.myViews[5] = myHelpCenter;
	}

	public void setSettings(Settings mySettings) {
		this.myViews[6] = mySettings;
	}

	public void setDirectorPanel(DirectorPanel myDirectorPanel) {
		this.myViews[7] = myDirectorPanel;

	}

	public void setCompanies(Companies myCompanies) {
		this.myViews[8] = myCompanies;
	}

	public void setAddCompanyDirector(AddFromDirector myAddCompanyDirector) {
		this.myViews[9] = myAddCompanyDirector;
	}

	public void setTablesDirector(TablesDirector myTablesDirector) {

		this.myViews[10] = myTablesDirector;
	}

	public void setAddStudentTutor(AddStudentTutor myAddStudentTutor) {
		this.myViews[11] = myAddStudentTutor;

	}

	public void setUpdateFromDirector(UpdateFromDirector myUpdateFromDirector) {
		this.myViews[12] = myUpdateFromDirector;

	}

	public void setUpdateFromTutor(UpdateFromTutor myUpdateFromTutor) {
		this.myViews[13] = myUpdateFromTutor;

	}

	public void setSettingsDirector(SettingsDirector mySettingsDirector) {
		this.myViews[14] = (Views) mySettingsDirector;
	}

	public void setDBConexion(DBConnection myDBConnection) {
		this.myViews[15] = myDBConnection;

	}

	public void ChangeWindows(int fromTo, int until) {
		myViews[fromTo].setVisible(false);
		myViews[until].setVisible(true);
	}

	// CHANGE WINDOWS

	public void goSettingsMS() {
		myModel.goSettingsMS();
	}

	public void backLogin() {
		myModel.backLogin();
	}

	public void back() {
		myModel.back();
	}

	public void backLoginFromSignUp() {
		myModel.backLoginFromSignUp();
	}

	// SETTERS

	public void setModel(Model myModel) {
		this.myModel = myModel;

	}

	// METHODS

	public void eyeVisibleNew() {
		myModel.eyeVisibleNew();
	}

	public void eyeVisibleConfirm() {
		myModel.eyeVisibleConfirm();
	}

	public void eyeVisibleOld() {
		myModel.eyeVisibleOld();
	}

	public void sendReset() {
		myModel.sendReset();
	}

	public void sendEmail() {
		myModel.sendEmail();
	}

	public void signedUp() {
		myModel.signedUp();
	}

	public void exportTableDirectorPanel() {
		myModel.exportTableDirectorPanel();
	}

	public void loadManageStudent() {
		myModel.loadManageStudent();
	}

	public void exportTableTutorD() {
		myModel.exportTableTutorD();
	}

	public void ExportTableCompanies() {
		myModel.exportTableCompanies();
	}

	public void exportTableManageStudent() {
		myModel.exportTableManageStudent();
	}

	public void exportTableGroups() {
		myModel.exportTableGroups();
	}

	public void emptyTableManageStudent() {
		myModel.emptyTableStudents();
	}

	public void emptyTableGroups() {
		myModel.emptyTableGroups();
	}

	public void emptyTableTutorDir() {
		myModel.emptyTablesTutorDir();
	}

	public void loadFile() {
		myModel.loadFile();
	}

	public void saveDBConnection() {
		myModel.saveDBConnection();
	}

	public void cleanTableCompanies() {
		myModel.cleanTableCompanies();
	}

	public void loadCompanies() {
		myModel.loadTableCompanies();
	}

	public void emptyTableDirectorPanel() {
		myModel.emptyTablesDirectorPanel();
	}

	public void setNoEnableSettings() {
		myModel.setNoEnableSettings();
	}

	public void updateSettings() {
		myModel.updateSettings(mySettings.getTxtName(), mySettings.getTxtDNI(), mySettings.getTxtUsername(),
				mySettings.getTxtLastName(), mySettings.getTxtEmail());
	}

	public void updateSettingsDirector() {
		myModel.updateSettingsDirector();
	}

	public void setEnableSettingsDirector() {
		myModel.SetEnableSettingsDirector();
	}

	public void setNoEnableSettingsDirector() {
		myModel.setNoEnableSettingsDirector();
	}

	public void setEnableSettings() {
		myModel.SetEnableSettings();
	}

	public void loadPhotoSettings() {
		myModel.loadPhoto();
	}

	public void loadPhotoSettingsDir() {
		myModel.newIcono();
	}

	public void loadTableGroups() {
		myModel.loadTableGroups(myTablesDirector.getModel(), myTablesDirector.getLblTitle());

	}

	public void loadTableTutor() {
		myModel.loadTableTutor(myTablesDirector.getModel(), myTablesDirector.getLblTitle());

	}

	public void loadTableStudent() {

		myModel.loadTableStudent(myTablesDirector.getModel(), myTablesDirector.getLblTitle());
	}

	public void loadTableCompanies() {
		myModel.loadTableCompanies(myTablesDirector.getModel(), myTablesDirector.getLblTitle());

	}

	public void insertCompanyDirector() {
		myModel.insertCompanyDirector();

	}

	public void removeRowDirector() {
		myModel.removeRowDirector(myTablesDirector.getModel(), myTablesDirector.getTable(),
				myDirectorPanel.getTableName());

	}

	public void insertStudentTutor() {
		myModel.insertStudentTutor();

	}

	public void loadFieldsToUpdate() {
		myModel.loadFieldsToUpdate(myTablesDirector.getModel(), myTablesDirector.getTable(),
				myDirectorPanel.getTableName());

	}

	public void showFieldsFromUpdateFromDirector() {
		myModel.showFieldsFromUpdateFromDirector();

	}

	public void updateFieldsDirector() {
		myModel.updateFieldsDirector(myDirectorPanel.getTableName(), myTablesDirector.getModel(),
				myTablesDirector.getTable());

	}

	public void removeRowTutor() {
		myModel.removeRowTutor(myTablesDirector.getModel(), myTablesDirector.getTable());

	}

	public void UpdateStudentsFieldsFromTutor() {
		myModel.UpdateStudentsFieldsFromTutor();

	}

	public void UpdateStudentsFromTutor() {
		myModel.UpdateStudentsFromTutor(myTablesDirector.getTable(), myTablesDirector.getModel());

	}

	public void chooseAddDirector() {
		myModel.chooseAddDirector(myDirectorPanel.getTableName(), myTablesDirector.getTable(),
				myTablesDirector.getModel());

	}

	

	

}