package model;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

public class Model implements Serializable {

	private static final long serialVersionUID = 1L;

	// Connection attribute

	private String bd = "practics4";
	private String login = "root";
	private String pwd = "";
	private String url = "jdbc:mysql://localhost/" + bd;
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rset;
	private boolean pas = false;

	// Views

	private Model myModel;
	private Login myLogin;
	private HelpCenter myHelpCenter;
	private ManageStudent myManageStudent;
	private ResetPassword myResetPassword;
	private SignUp mySignUp;
	private Settings mySettings;
	private DirectorPanel myDirectorPanel;
	private Companies myCompanies;
	private SettingsDirector mySettingsDirector;
	private DBConnection myDBConnection;
	private TablesDirector myTablesDirector;
	private AddFromDirector myAddCompanyDirector;
	private AddStudentTutor myAddStudentTutor;
	private UpdateFromDirector myUpdateFromDirector;
	private UpdateFromTutor myUpdateFromTutor;

	// Querys

	private String sql = "Select * from users;";
	private String sqlCompany = "select*from empresa;";
	private String sqlManage = "Select * from gestiona";
	private String sqlStudent = "select * from alumno";
	private String sqlPractics = "select * from practica;";
	private String sqlTutorD = "select * from Tutor;";
	private String sqlGroups = "select * from grupo;";
	private String sqlTutor = "select * from alumno inner join practica on alumno.exp = practica.exp_alumno where practica.tutor ='";

	private int count = 0;

	// File`s attribute

	File file1;
	FileOutputStream fos;
	ObjectOutputStream oos;

	// Tables

	private DefaultTableModel modeloT, modeloA, modeloP, modeloTutor, modeloM, modeloG, modeloDir, modeloD,
			modelTablesDirector, modelGroups, modelStudent, modelTutor, modelCompanies, modelStudentTutor;

	// BUILDER

	public Model() {

	}

	/*
	 * CONNECTION TO DB This method makes the connection to the database, it is the
	 * origin of all connections
	 */

	public void saveDBConnection() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(getUrl(), getLogin(), getPwd());

		} catch (ClassNotFoundException cnfe) {
			System.out.println("Driver JDBC not found");
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("Error to connect DB");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("General error");
			e.printStackTrace();
		}
		loadTableManage();
		loadTablePractics();

	}

	// GET LOGIN FROM DB

	private String getLogin() {
		myDBConnection = new DBConnection();
		String pr = " ";
		String aux = "";
		try {
			File file = new File("src/login.ini");
			FileReader fr = new FileReader(file);
			BufferedReader myFile = new BufferedReader(fr);

			String usr = "usr:";
			for (int i = 0; i < 3; i++) {
				pr = myFile.readLine();
				if (pr.contains(usr)) {
					pr = pr.substring(4);
					aux = pr;
				}
			}
			myDBConnection.setTxtUrl(aux);
			myFile.close();
			fr.close();
			myLogin.setLblErrorConnectDB("");
			myLogin.setBtnLogin();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aux;
	}

	// GET PWD FROM DB

	private String getPwd() {
		myDBConnection = new DBConnection();
		String prueba = " ";
		String aux = "";
		try {
			File file = new File("src/login.ini");
			FileReader fr = new FileReader(file);
			BufferedReader miFichero = new BufferedReader(fr);
			String pwd = "pwd:";
			for (int i = 0; i < 3; i++) {
				prueba = miFichero.readLine();
				if (prueba.contains(pwd)) {
					prueba = prueba.substring(4);
					aux = prueba;
				}
			}
			myDBConnection.setTxtPwd(aux);
			miFichero.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aux;
	}

	// GET URL FROM DB

	private String getUrl() {
		myDBConnection = new DBConnection();
		String prueba = " ";
		String aux = "";
		try {
			File file = new File("src/login.ini");
			FileReader fr = new FileReader(file);
			BufferedReader miFichero = new BufferedReader(fr);
			String url = "url:";
			for (int i = 0; i < 3; i++) {
				prueba = miFichero.readLine();
				if (prueba.contains(url)) {
					prueba = prueba.substring(4);
					aux = prueba;

				}
			}
			myDBConnection.setTxtUrl(aux);
			miFichero.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aux;
	}

	/*
	 * ACCESS CONTROL UNTIL LOGIN Method with which it is verified that the username
	 * and password are correct according to the database
	 */
	public void access() {
		String passFinal = "";
		try {
			pstmt = connection.prepareStatement(sql);
			rset = pstmt.executeQuery();
			MessageDigest md = MessageDigest.getInstance("MD5");
			String pass = myLogin.getPassw();

			byte[] passCifrada = pass.getBytes();
			md.update(passCifrada);
			passCifrada = md.digest();
			passFinal = new String(passCifrada);

			while (rset.next() && pas == false) {
				String username = rset.getString(1);
				String password = rset.getString(2);
				String role = rset.getString(3);
				if (username.equals(myLogin.getUser()) && password.equals(passFinal)) {
					myManageStudent = new ManageStudent();
					myTablesDirector.setLblUser(myLogin.getUser());
					myDirectorPanel.setLblUser(myLogin.getUser());
					if (role.equals("Tutor")) {
						pas = true;
						myLogin.grantedAccessTutor();
						loadTableTutor1(myTablesDirector.getModel(), myTablesDirector.getTable(),
								myDirectorPanel.getTableName());
						myTablesDirector.hideBackButton();
						myTablesDirector.setBtnDelete();
						myTablesDirector.setBtnAddCompany();
						myTablesDirector.changeFrameBtnUpdateFromTutor();
						myTablesDirector.goToSettingsTutor();

						SetSettingsValues();

						continue;

					} else if (role.equals("Director")) {
						pas = true;
						myLogin.grantedAccessDirector();
						myTablesDirector.setBtnAddDirector();
						myTablesDirector.changeFrameBtnUpdateFromDirector();
						myTablesDirector.goToSettingsDirector();
						SettingsDir();
						continue;
					}
				} else {
					pas = false;
					myLogin.setLblErrorUsrAndPwd("Username and password are incorrect ");
				}
			}
			if (pas == false) {
				count++;
			}
			if (count == 1) {
				myLogin.setLblSupport("Error. It has failed more than three times. Locking system");
				myLogin.setBtnSupport();
				myLogin.setPanelEyeAndPwd();
				myLogin.setTxtUser();
			}
			if (count == 3) {
				System.exit(0);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * LOAD ALL TABLES Next, all the tables from the database are loaded in the
	 * following methods
	 * 
	 */

	public void loadTableTutor1(DefaultTableModel model, JTable jTable, String string) {
		int columnsNum = getNumColumns(sqlTutor + myLogin.getUser() + "';");
		int rowsNum = getnumRows(sqlTutor + myLogin.getUser() + "';");
		String[] header = new String[columnsNum];

		Object[][] content = new Object[rowsNum][columnsNum];
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sqlTutor + myLogin.getUser() + "';");
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			for (int i = 0; i < columnsNum; i++) {
				header[i] = rsmd.getColumnName(i + 1);
			}
			int row = 0;
			while (rset.next()) {
				for (int col = 1; col <= columnsNum; col++) {
					content[row][col - 1] = rset.getString(col);
				}
				row++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model = new DefaultTableModel(content, header);

		myTablesDirector.setTable(model);
		myTablesDirector.setLblTitle("Student");
		modelStudentTutor = model;

	}

	private void loadTableManage() {
		int columnsNum = getNumColumns(sqlManage);
		int RowsNum = getnumRows(sqlManage);

		String[] Header = new String[columnsNum];

		Object[][] content = new Object[RowsNum][columnsNum];
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sqlManage);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			for (int i = 0; i < columnsNum; i++) {
				Header[i] = rsmd.getColumnName(i + 1);
			}
			int row = 0;
			while (rset.next()) {
				for (int col = 1; col <= columnsNum; col++) {
					content[row][col - 1] = rset.getString(col);
				}
				row++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		modeloM = new DefaultTableModel(content, Header);

	}

	private void loadTablePractics() {
		int columnsNum = getNumColumns(sqlPractics);
		int rowsNum = getnumRows(sqlPractics);

		String[] header = new String[columnsNum];

		Object[][] content = new Object[rowsNum][columnsNum];
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sqlPractics);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			for (int i = 0; i < columnsNum; i++) {
				header[i] = rsmd.getColumnName(i + 1);
			}
			int row = 0;
			while (rset.next()) {
				for (int col = 1; col <= columnsNum; col++) {
					content[row][col - 1] = rset.getString(col);
				}
				row++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		modeloP = new DefaultTableModel(content, header);
	}

	public void loadTableCompanies(DefaultTableModel model, String lblF) {
		int columnNums = getNumColumns(sqlCompany);
		int rowNums = getnumRows(sqlCompany);

		String[] head = new String[columnNums];

		Object[][] content = new Object[rowNums][columnNums];
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sqlCompany);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			for (int i = 0; i < columnNums; i++) {
				head[i] = rsmd.getColumnName(i + 1);
			}
			int row = 0;
			while (rset.next()) {
				for (int col = 1; col <= columnNums; col++) {
					content[row][col - 1] = rset.getString(col);
				}
				row++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model = new DefaultTableModel(content, head);
		myTablesDirector.setTable(model);
		myTablesDirector.setLblTitle("Companies");
		modelCompanies = model;
	}

	public void loadTableGroups(DefaultTableModel model, String lbl) {
		int columnNums = getNumColumns(sqlGroups);
		int rowNums = getnumRows(sqlGroups);

		String[] head = new String[columnNums];

		Object[][] content = new Object[rowNums][columnNums];
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sqlGroups);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			for (int i = 0; i < columnNums; i++) {
				head[i] = rsmd.getColumnName(i + 1);
			}
			int row = 0;
			while (rset.next()) {
				for (int col = 1; col <= columnNums; col++) {
					content[row][col - 1] = rset.getString(col);
				}
				row++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model = new DefaultTableModel(content, head);
		myTablesDirector.setTable(model);
		myTablesDirector.setLblTitle("Groups");
		modelGroups = model;

	}

	public void loadTableStudent(DefaultTableModel model, String lbl) {
		int columnNums = getNumColumns(sqlStudent);
		int rowNums = getnumRows(sqlStudent);

		String[] head = new String[columnNums];

		Object[][] content = new Object[rowNums][columnNums];
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sqlStudent);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			for (int i = 0; i < columnNums; i++) {
				head[i] = rsmd.getColumnName(i + 1);
			}
			int row = 0;
			while (rset.next()) {
				for (int col = 1; col <= columnNums; col++) {
					content[row][col - 1] = rset.getString(col);
				}
				row++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model = new DefaultTableModel(content, head);
		myTablesDirector.setTable(model);
		myTablesDirector.setLblTitle("Students");
		modelStudent = model;

	}

	public void loadTableTutor(DefaultTableModel model, String lbl) {
		int columnNums = getNumColumns(sqlTutorD);
		int rowNums = getnumRows(sqlTutorD);

		String[] head = new String[columnNums];

		Object[][] content = new Object[rowNums][columnNums];
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sqlTutorD);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			for (int i = 0; i < columnNums; i++) {
				head[i] = rsmd.getColumnName(i + 1);
			}
			int row = 0;
			while (rset.next()) {
				for (int col = 1; col <= columnNums; col++) {
					content[row][col - 1] = rset.getString(col);
				}
				row++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model = new DefaultTableModel(content, head);
		myTablesDirector.setTable(model);
		myTablesDirector.setLblTitle("Tutor");
		modelTutor = model;

	}

	private int getNumColumns(String sql) {
		int num = 0;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			num = rsmd.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	private int getnumRows(String sql) {
		int numFilas = 0;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next())
				numFilas++;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numFilas;
	}

	/*
	 * FILE OPERATIONS In the following methods, we load the database through a
	 * file, Views / DBConnection
	 */

	public void loadFile() {
		File file = new File("src/Login.ini");
		myDBConnection.setTxtChooseFile(file.getName());
	}

	public void readFile() {

		try {
			File file = new File("src/" + myDBConnection.getTxtChooseFile().getText());
			FileReader fr = new FileReader(file);
			BufferedReader miFile = new BufferedReader(fr);

			String usr = "usr:";
			String pwd = "pwd:";
			String url = "url:";
			String aux = "";
			for (int i = 0; i < 3; i++) {
				aux = miFile.readLine();
				if (aux.contains(usr)) {
					aux = aux.substring(4);
					myDBConnection.setTxtUsr(aux);
				}
				if (aux.contains(pwd)) {
					aux = aux.substring(4);
					myDBConnection.setTxtPwd(aux);
				}
				if (aux.contains(url)) {
					aux = aux.substring(4);

					myDBConnection.setTxtUrl(aux);
				}
			}

			miFile.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeFIle() {

		try {
			File file = new File("src/" + myDBConnection.getTxtChooseFile().getText());
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(myDBConnection.getTxtUsr().getBytes());
			fos.write(myDBConnection.getTxtPwd().getBytes());
			fos.write(myDBConnection.getTxtUrl().getBytes());
			fos.close();
			myDBConnection.setTxtUsr(null);
			myDBConnection.setTxtPwd(null);
			myDBConnection.setTxtUrl(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * EXPORT TABLES: tables.dat perform an import or export of the following tables
	 * to an auxiliary file
	 */
	public void exportTableDirectorPanel() {

		try {
			file1 = new File("src/Tables.dat");
			fos = new FileOutputStream(file1);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(modeloDir);
			fos.close();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void exportTableCompanies() {
		try {
			file1 = new File("src/Tables.dat");
			fos = new FileOutputStream(file1);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(modeloA);
			fos.close();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void exportTableTutorD() {
		try {
			file1 = new File("src/Tables.dat");
			fos = new FileOutputStream(file1);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(modeloTutor);
			fos.close();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void exportTableGroups() {
		try {
			file1 = new File("src/Tables.dat");
			fos = new FileOutputStream(file1);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(modeloG);

			fos.close();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void exportTableManageStudent() {
		try {
			file1 = new File("src/Tables.dat");
			fos = new FileOutputStream(file1);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(modeloT);
			fos.close();
			oos.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	// LOAD TABLES:tables.dat

	public void loadManageStudent() {

		try {
			File file1 = new File("src/Tables.dat");
			FileInputStream fis = new FileInputStream(file1);
			ObjectInputStream ois = new ObjectInputStream(fis);
			modeloT = (DefaultTableModel) ois.readObject();
			myManageStudent.setTabla(modeloT);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void loadTableCompanies() {
		try {
			File file1 = new File("src/Tables.dat");
			FileInputStream fis = new FileInputStream(file1);
			ObjectInputStream ois = new ObjectInputStream(fis);
			modeloA = (DefaultTableModel) ois.readObject();
			myCompanies.setTable(modeloA);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	// EMPTY TABLES TO EXPORT

	public void emptyTableStudents() {
		int numData = modeloT.getRowCount();
		for (int i = 0; i < numData; i++) {
			modeloT.removeRow(0);
		}

	}

	public void emptyTablesDirectorPanel() {
		int numData = modeloDir.getRowCount();
		for (int i = 0; i < numData; i++) {
			modeloDir.removeRow(0);
		}

	}

	public void emptyTableGroups() {
		int numData = modeloG.getRowCount();
		for (int i = 0; i < numData; i++) {
			modeloG.removeRow(0);
		}

	}

	public void emptyTablesTutorDir() {
		int numData = modeloTutor.getRowCount();
		for (int i = 0; i < numData; i++) {
			modeloTutor.removeRow(0);
		}

	}

	public void cleanTableCompanies() {
		int numData = modeloA.getRowCount();
		for (int i = 0; i < numData; i++) {
			modeloA.removeRow(0);
		}

	}

	// MOVE INTO WINDOWS

	public void goSettingsMS() {
		myManageStudent.goSettingsMS();
	}

	public void backLogin() {
		myHelpCenter.backLogin();
	}

	public void back() {
		mySignUp.back();
	}

	public void backLoginFromSignUp() {
		mySignUp.backLoginFromSignUp();
	}

	// SQL QUERYS
	/*
	 * Very important methods to insert, modify, delete or consult any existing
	 * information in the database.These methods can be found in the two main
	 * branches, Tutor and Director.
	 */
	private void SettingsDir() {

		try {
			// USR
			String usr = "";
			String selectUsername = "select usr from users where usr='" + myLogin.getUser() + "';";
			rset = pstmt.executeQuery(selectUsername);
			while (rset.next()) {
				usr = rset.getString(1);

			}
			mySettingsDirector.setTxtUser2(usr);
			// lblROLE
			String role = "";
			String selectRole = "select role from users where usr='" + myLogin.getUser() + "';";
			rset = pstmt.executeQuery(selectRole);
			while (rset.next()) {
				role = rset.getString(1);
			}
			mySettingsDirector.setLblRol(role);

			// Name
			String name = "";
			String selectName = "select name from director where usr='" + myLogin.getUser() + "';";
			rset = pstmt.executeQuery(selectName);
			while (rset.next()) {
				name = rset.getString(1);
			}
			mySettingsDirector.setTxtName(name);

			// Lastname
			String lastName = "";
			String selectLastName = "select lastname from director where usr='" + myLogin.getUser() + "';";
			rset = pstmt.executeQuery(selectLastName);
			while (rset.next()) {
				lastName = rset.getString(1);
			}
			mySettingsDirector.setTxtLastname(lastName);

			// DNI
			String dni = "";
			String selectDni = "select dni from director where usr='" + myLogin.getUser() + "';";
			rset = pstmt.executeQuery(selectDni);
			while (rset.next()) {
				dni = rset.getString(1);
			}
			mySettingsDirector.setTxtDni(dni);

			// email
			String email = "";
			String selectlEmail = "select email from users where usr='" + myLogin.getUser() + "';";
			rset = pstmt.executeQuery(selectlEmail);
			while (rset.next()) {
				email = rset.getString(1);
			}
			mySettingsDirector.setTxtEmail(email);

			// LBL Titulo superior
			String topLbl = "";
			String selectTopLbl = "select name from director where usr='" + myLogin.getUser() + "';";
			rset = pstmt.executeQuery(selectTopLbl);
			while (rset.next()) {
				topLbl = rset.getString(1);
			}

			// LBL USER
			String lblus = "";
			String selectlblus = "select name,lastname from director where usr='" + myLogin.getUser() + "';";
			rset = pstmt.executeQuery(selectlblus);
			while (rset.next()) {
				lblus = rset.getString(1) + " " + rset.getString(2);
			}
			mySettingsDirector.setLblNameDesc(lblus);

			// LBL DirectorPanel
			String lblDirPanel = "";
			String selectlblDirPanel = "select name from director where usr='" + myLogin.getUser() + "';";
			rset = pstmt.executeQuery(selectlblDirPanel);
			while (rset.next()) {
				lblDirPanel = rset.getString(1);
			}
			myDirectorPanel.setLblUser(lblDirPanel);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int updateSettingsDirector() {

		int result = 0;

		try {

			String pwd = "";
			String selectOldPwd = "Select pwd from users where usr='" + myLogin.getUser() + "';";
			rset = pstmt.executeQuery(selectOldPwd);
			while (rset.next()) {
				pwd = rset.getString(1);
			}

			if ((mySettingsDirector.getTxtOldPass().equals(pwd)
					&& (mySettingsDirector.getTxtNewPass().equals(mySettingsDirector.getTxtConfirmNewPass())))
					|| (mySettingsDirector.getTxtOldPass().equals("") || mySettingsDirector.getTxtNewPass().equals("")
							|| mySettingsDirector.getTxtConfirmNewPass().equals(""))) {

				// usr
				String query = "Update users set usr='" + mySettingsDirector.getTxtUser() + "' where usr='"
						+ myLogin.getUser() + "';";
				pstmt = connection.prepareStatement(query);
				result += pstmt.executeUpdate();
				// name
				String query2 = "Update director set name='" + mySettingsDirector.getTxtName() + "' where usr='"

						+ mySettingsDirector.getTxtUser() + "';";

				pstmt = connection.prepareStatement(query2);
				result += pstmt.executeUpdate();
				// lastname
				String query3 = "Update director set lastname='" + mySettingsDirector.getTxtLastname() + "' where usr='"

						+ mySettingsDirector.getTxtUser() + "';";

				pstmt = connection.prepareStatement(query3);
				result += pstmt.executeUpdate();
				// dni

				String query4 = "Update director set DNI='" + mySettingsDirector.getTxtDni() + "' where usr='"
						+ mySettingsDirector.getTxtUser() + "';";

				pstmt = connection.prepareStatement(query4);
				result += pstmt.executeUpdate();

				String query5 = "Update users set email='" + mySettingsDirector.getTxtEmail() + "' where usr='"
						+ mySettingsDirector.getTxtUser() + "';";

				pstmt = connection.prepareStatement(query5);
				result += pstmt.executeUpdate();

				// contraseña

				if (!pwd.equals(mySettingsDirector.getTxtOldPass())) {

					String query6 = "Update users set pwd='" + pwd + "' where usr='" + mySettingsDirector.getTxtUser()
							+ "';";

					pstmt = connection.prepareStatement(query6);
					result += pstmt.executeUpdate();

				} else if (pwd.equals(mySettingsDirector.getTxtOldPass())) {
					String query6 = "Update users set pwd='" + mySettingsDirector.getTxtConfirmNewPass()
							+ "' where usr='" + mySettingsDirector.getTxtUser() + "';";

					pstmt = connection.prepareStatement(query6);
					result += pstmt.executeUpdate();
				}

			} else if (!mySettingsDirector.getTxtOldPass().equals(pwd)) {

				mySettingsDirector.setLblPasswordError_1("La contrasena no es correcta");
			} else if (!mySettingsDirector.getTxtNewPass().equals(mySettingsDirector.getTxtConfirmNewPass())) {

				mySettingsDirector.setLblPasswordErrorMatch_1("Las contrasenas no coinciden");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public int updateSettings(String txtName, String txtDNI, String txtUsername, String txtLastName, String txtEmail) {
		int result = 0;

		try {

			String pwd = "";
			String selectOldPwd = "Select pwd from users where usr='" + myLogin.getUser() + "';";
			rset = pstmt.executeQuery(selectOldPwd);
			while (rset.next()) {
				pwd = rset.getString(1);
			}

			if ((mySettings.getTextOldPwd().equals(pwd)
					&& (mySettings.getTextNewPwd().equals(mySettings.getTextConfNewPwd())))
					|| (mySettings.getTextOldPwd().equals("") || mySettings.getTextNewPwd().equals("")
							|| mySettings.getTextConfNewPwd().equals(""))) {

				// usr
				String query = "Update users set usr='" + mySettings.getTxtUsername() + "' where usr='"
						+ myLogin.getUser() + "';";
				pstmt = connection.prepareStatement(query);
				result += pstmt.executeUpdate();
				// name
				String query2 = "Update tutor set Nombre='" + mySettings.getTxtName() + "' where usr='"

						+ mySettings.getTxtUsername() + "';";

				pstmt = connection.prepareStatement(query2);
				result += pstmt.executeUpdate();
				// lastname
				String query3 = "Update tutor set Apellido='" + mySettings.getTxtLastName() + "' where usr='"

						+ mySettings.getTxtUsername() + "';";

				pstmt = connection.prepareStatement(query3);
				result += pstmt.executeUpdate();
				// dni

				String query4 = "Update tutor set DNI='" + mySettings.getTxtDNI() + "' where usr='"
						+ mySettings.getTxtUsername() + "';";

				pstmt = connection.prepareStatement(query4);
				result += pstmt.executeUpdate();

				String query5 = "Update users set email='" + mySettings.getTxtEmail() + "' where usr='"
						+ mySettings.getTxtUsername() + "';";

				pstmt = connection.prepareStatement(query5);
				result += pstmt.executeUpdate();

				// contraseña

				if (!pwd.equals(mySettings.getTextConfNewPwd())) {
					String query6 = "Update users set pwd='" + mySettings.getTextConfNewPwd() + "' where usr='"
							+ mySettings.getTxtUsername() + "';";

					pstmt = connection.prepareStatement(query5);
					result += pstmt.executeUpdate();

				} else {
					String query6 = "Update users set pwd='" + pwd + "' where usr='" + mySettings.getTxtUsername()
							+ "';";

					pstmt = connection.prepareStatement(query6);
					result += pstmt.executeUpdate();
				}

			} else if (!mySettings.getTextOldPwd().equals(pwd)) {

				mySettings.setLblPasswordError("La contraseï¿½a no es correcta");
			} else if (!mySettings.getTextNewPwd().equals(mySettings.getTextConfNewPwd())) {
				System.out.println(mySettings.getTextNewPwd());
				System.out.println(mySettings.getTextConfNewPwd());
				mySettings.setLblPasswordErrorMatch("Las contraseï¿½as no coinciden");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	private void SetSettingsValues() {

		try {

			// User
			String usr = "";
			String selectUsername = "select usr from users where usr='" + myLogin.getUser() + "';";
			rset = pstmt.executeQuery(selectUsername);
			while (rset.next()) {
				usr = rset.getString(1);
			}
			mySettings.setTxtUsername(usr);
			// Roll
			String role = "";
			String selectRole = "select role from users where usr='" + myLogin.getUser() + "';";
			rset = pstmt.executeQuery(selectRole);
			while (rset.next()) {
				role = rset.getString(1);
			}
			mySettings.setLblRol(role);
			// DNI
			String dni = "";
			String selectdni = "select DNI from tutor where usr='" + myLogin.getUser() + "';";
			rset = pstmt.executeQuery(selectdni);
			while (rset.next()) {
				dni = rset.getString(1);
			}
			mySettings.setTxtDNI(dni);
			// Name
			String name = "";
			String selectname = "select nombre from tutor where usr='" + myLogin.getUser() + "';";
			rset = pstmt.executeQuery(selectname);
			while (rset.next()) {
				name = rset.getString(1);
			}
			mySettings.setTxtName(name);
			// Last name
			String lastname = "";
			String selectlastname = "select Apellido from tutor  where usr='" + myLogin.getUser() + "';";
			rset = pstmt.executeQuery(selectlastname);
			while (rset.next()) {
				lastname = rset.getString(1);
			}
			mySettings.setTxtLastName(lastname);

			// Last name
			String email = "";
			String selectEmail = "select email from users  where usr='" + myLogin.getUser() + "';";
			rset = pstmt.executeQuery(selectEmail);
			while (rset.next()) {
				email = rset.getString(1);
			}

			// username top
			String usernameTop = "";
			String selectusername = "select usr from tutor where usr='" + myLogin.getUser() + "';";
			rset = pstmt.executeQuery(selectusername);
			while (rset.next()) {
				usernameTop = rset.getString(1);
			}

			// username top 2
			String usernameTop2 = "";
			String selectname_username = "select Nombre, Apellido from tutor  where usr='" + myLogin.getUser() + "';";

			rset = pstmt.executeQuery(selectname_username);
			while (rset.next()) {
				usernameTop2 = rset.getString(1) + " " + rset.getString(2);

			}
			mySettings.setLblUser2(usernameTop2);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void signedUp() {
		int result = 0;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rset = pstmt.executeQuery();

			// usuario
			String usr = "";
			String sqlUser2 = "select usr from users where usr = '" + mySignUp.getTxtUsername() + "';";
			rset = pstmt.executeQuery(sqlUser2);
			while (rset.next()) {
				usr += rset.getString(1);
			}
			
			// email
			
			String emailFinal = encryptAsim();
			
			
			String email = "";
			String sqlEmail = "select email from users where email = '" + mySignUp.getTxtEmail() + "';";
			rset = pstmt.executeQuery(sqlEmail);
			while (rset.next()) {
				email += rset.getString(1);
			}
			// DNI
			String dni = "";
			String sqlDni = "select DNI from tutor where DNI = '" + mySignUp.getTxtDNI() + "';";
			rset = pstmt.executeQuery(sqlDni);
			while (rset.next()) {
				dni += rset.getString(1);
			}

			// Contrase�a
			String passFinal = "";
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				String pass = mySignUp.getTxtPass();
				byte[] passCifrada = pass.getBytes();
				md.update(passCifrada);
				passCifrada = md.digest();
				passFinal = new String(passCifrada);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (!mySignUp.getTxtUsername().equals(usr) && !mySignUp.getTxtEmail().equals(email)
					&& !mySignUp.getTxtDNI().equals(dni)) {

				String user = "";
				String updateDataUser = "insert into users (usr, pwd, role, photo, email) values ('"
						+ mySignUp.getTxtUsername() + "', '" + passFinal + "', 'Tutor', '', '" + emailFinal + "');";

				int rset2 = pstmt.executeUpdate(updateDataUser);

				String tutor = "";
				String updateDataTutor = "insert into tutor (DNI, Nombre, Apellido, Cod_centro, usr) values ('"
						+ mySignUp.getTxtDNI() + "', '" + mySignUp.getTxtName() + "', '" + mySignUp.getTxtLastName()
						+ "', 1, '" + mySignUp.getTxtUsername() + "');";
				int rset3 = pstmt.executeUpdate(updateDataTutor);
				System.out.println("Insert ok!!");
			} else if (mySignUp.getTxtDNI().equals(dni)) {
				mySignUp.setLblDniError("This DNI is already used");

			} else if (mySignUp.getTxtEmail().equals(email)) {
				mySignUp.setLblEmailError("This Email is already used");

			} else if (mySignUp.getTxtUsername().equals(usr)) {
				mySignUp.setLblUserError("This Username is already used");

			} else {

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	private String encryptAsim() {
		String emailFinal = "";
		try {

			KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
			KeyPair keypair = keygen.generateKeyPair();
			Cipher rsaCipher = Cipher.getInstance("RSA");
			rsaCipher.init(Cipher.ENCRYPT_MODE, keypair.getPublic());
			byte[] mensaje = mySignUp.getTxtDNI().getBytes();
			mensaje = rsaCipher.doFinal(mensaje);
			emailFinal = new String(mensaje);
		} catch (Exception e) {
		}
		
		return emailFinal;
	}

//	private String desencryptAsim(String email) {
//        String emailDesen = "";
//        try {
//            KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
//            KeyPair keypair = keygen.generateKeyPair();
//            Cipher rsaCipher = Cipher.getInstance("RSA");
//            rsaCipher.init(Cipher.DECRYPT_MODE, keypair.getPrivate());
//            byte[] mensaje = email.getBytes();
//            emailDesen = new String(rsaCipher.doFinal(mensaje));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return emailDesen;
//    }
	// CHANGE,LOAD PHOTO

	public void loadPhoto() {
		File pathProyect = new File(System.getProperty("user.dir"));
		JFileChooser fc = new JFileChooser(pathProyect);
		int selection = fc.showOpenDialog(myDBConnection.getContentPaneDBConnection());
		if (selection == JFileChooser.APPROVE_OPTION) {
			try {
				File file = fc.getSelectedFile();
				String aux = file.getAbsolutePath();
				Icon icon = new ImageIcon(file.toString());
				Icon icon2 = new ImageIcon(((ImageIcon) icon).getImage().getScaledInstance(
						mySettings.getLblIconUserWidth(), mySettings.getLblIconUserHeight(), Image.SCALE_DEFAULT));
				mySettings.setLblIconUser(icon2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * PHOTOS Method that saves in the database an image selected by the user from
	 * his computer, as well as the possibility of modifying it.
	 */
	public void newIcono() {
		String aux = "";
		File pathProyect = new File(System.getProperty("user.dir"));
		JFileChooser fc = new JFileChooser(pathProyect);
		int selection = fc.showOpenDialog(myDBConnection.getContentPaneDBConnection());
		if (selection == JFileChooser.APPROVE_OPTION) {
			try {
				File file = fc.getSelectedFile();
				aux = file.getAbsolutePath().replace("\\", "/");
				Icon icon = new ImageIcon(file.toString());
				Icon icon2 = new ImageIcon(((ImageIcon) icon).getImage().getScaledInstance(
						mySettings.getLblIconUserWidth(), mySettings.getLblIconUserHeight(), Image.SCALE_DEFAULT));
				mySettingsDirector.setLblIconUser(icon2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		insertPhotoDB(aux);
	}

	private void insertPhotoDB(String photo) {

		String query = "update users set Photo='" + photo + "' where usr='" + myLogin.getUser() + "';";
		try {
			Statement st = connection.createStatement();
			st.executeUpdate(query);
		} catch (SQLException s) {
			s.printStackTrace();
		}

	}

	public void loadPhotoDir() {

		try {
			String photo = "";
			String selectphoto = "select Photo from users  where usr='" + myLogin.getUser() + "';";
			rset = pstmt.executeQuery(selectphoto);
			while (rset.next()) {
				photo = rset.getString(1);
			}
			photo = photo.replace("/", "\\");

			Icon icon = new ImageIcon(photo);
			Icon icon2 = new ImageIcon(((ImageIcon) icon).getImage().getScaledInstance(mySettings.getLblIconUserWidth(),
					mySettings.getLblIconUserHeight(), Image.SCALE_DEFAULT));
			mySettingsDirector.setLblIconUser(icon2);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// TO ADD, UPDATE OR DELETE FROM DIRECTOR
	public void removeRowDirector(DefaultTableModel model, JTable table, String name) {

		if (myDirectorPanel.getTableName().equals("Groups")) {

			try {
				model = modelGroups;
				table = myTablesDirector.getTable();
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, 0).toString();
				System.out.println(value);
				String query = "delete from grupo where Cod_grupo='" + value + "';";
				Statement st = connection.createStatement();
				st.executeUpdate(query);

				model.removeRow(table.getSelectedRow());
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (myDirectorPanel.getTableName().equals("Student")) {
			try {
				model = modelStudent;
				table = myTablesDirector.getTable();
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, 0).toString();
				System.out.println(value);
				String query = "delete from alumno where exp='" + value + "';";
				Statement st = connection.createStatement();
				st.executeUpdate(query);

				model.removeRow(table.getSelectedRow());
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (myDirectorPanel.getTableName().equals("Companies")) {
			try {
				model = modelCompanies;
				table = myTablesDirector.getTable();
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, 0).toString();
				System.out.println(value);
				String query = "delete from empresa where Cif='" + value + "';";
				Statement st = connection.createStatement();
				st.executeUpdate(query);

				model.removeRow(table.getSelectedRow());
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (myDirectorPanel.getTableName().equals("Tutors")) {
			try {
				model = modelTutor;
				table = myTablesDirector.getTable();
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, 0).toString();
				System.out.println(value);
				String query = "delete from tutor where DNI='" + value + "';";
				Statement st = connection.createStatement();
				st.executeUpdate(query);

				model.removeRow(table.getSelectedRow());
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (myDirectorPanel.getTableName().equals("Student")) {
			System.out.println("holaaa");
			try {
				model = modelTutor;
				table = myTablesDirector.getTable();
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, 0).toString();
				int valor = Integer.valueOf(value);
				String query = "delete from alumno inner join practica on alumno.exp=practica.alumno_exp where exp="
						+ valor + ";";

				Statement st = connection.createStatement();
				st.executeUpdate(query);

				model.removeRow(table.getSelectedRow());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(myDirectorPanel.getTableName());

	}

	public void removeRowTutor(DefaultTableModel model, JTable table) {
		try {
			System.out.println("entro");
			model = modelStudentTutor;
			table = myTablesDirector.getTable();
			table.setModel(model);
			System.out.println(table.getColumnCount());
			int row = table.getSelectedRow();
			System.out.println(row);

			String value = model.getValueAt(row, 0).toString();
			String query = "delete from alumno  where exp = '" + value + "';";
			Statement st = connection.createStatement();
			st.executeUpdate(query);
			model.removeRow(table.getSelectedRow());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String encriptar(String mensaje) {
		String clave = "b5dsi329v9snsdls";
		byte[] mensajeCifrado = {};
		try {
			Key keygen = new SecretKeySpec(clave.getBytes(), "AES");
			Cipher aesCipher = Cipher.getInstance("AES");
			aesCipher.init(Cipher.ENCRYPT_MODE, keygen);
			mensajeCifrado = aesCipher.doFinal(mensaje.getBytes());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String(mensajeCifrado);

	}


	public void insertStudentTutor() {

		int exp = myAddStudentTutor.getTxtExp();
		String dni = encriptar(myAddStudentTutor.getTxtDNI());
		String name = myAddStudentTutor.getTxtName();
		String lastname = myAddStudentTutor.getTxtLastname();
		String dateborn = myAddStudentTutor.getTxtBornDate();

		int codepractics = myAddStudentTutor.getTxtCodePractics();
		String cifCompany = myAddStudentTutor.getTxtCIFCompany();
		String dateInit = myAddStudentTutor.getTxtStartDate();
		String dateEnd = myAddStudentTutor.getTxtEndDate();
		String AcademyYear = myAddStudentTutor.getTxtAcademyYear();
		String schedule = myAddStudentTutor.getTxtSchedule();
		String tutor = myLogin.getUser();
		String yearPractics = myAddStudentTutor.getTxtPracticsYear();
		String anex2_1 = myAddStudentTutor.getTxtAnex_2_1();
		String anex3 = myAddStudentTutor.getTxtAnex3();
		String anex7 = myAddStudentTutor.getTxtAnex7();
		String anex8 = myAddStudentTutor.getTxtAnex8();
		try {
			String query1 = "insert into alumno (exp,DNI,Nombre,Apellidos,Fnac) values ('" + exp + "','" + dni + "','"
					+ name + "','" + lastname + "','" + dateborn + "');";
			String query2 = "insert into practica (cod_practica,cif_empresa,exp_alumno,fecha_ini,fecha_fin,acad,horario,tutor,acad_practica,anex2_1,anex3,anex7,anex8) values"
					+ " ('" + codepractics + "','" + cifCompany + "','" + exp + "','" + dateInit + "','" + dateEnd
					+ "','" + AcademyYear + "','" + schedule + "','" + tutor + "','" + yearPractics + "','" + anex2_1
					+ "','" + anex3 + "','" + anex7 + "','" + anex8 + "');";

			Statement st = connection.createStatement();
			st.executeUpdate(query1);
			st.executeUpdate(query2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadFieldsToUpdate(DefaultTableModel model, JTable table, String name) {
		if (myDirectorPanel.getTableName().equals("Groups")) {

			try {

				model = modelGroups;
				table = myTablesDirector.getTable();
				int aux = table.getColumnCount();
				String[] values = new String[aux];
				int row = table.getSelectedRow();

				for (int i = 0; i < aux; i++) {
					values[i] = table.getModel().getValueAt(row, i).toString();
				}

				myUpdateFromDirector.setTxt1(values[0]);
				myUpdateFromDirector.setTxt2(values[1]);
				myUpdateFromDirector.setTxt3(values[2]);
				myUpdateFromDirector.setTxt4(values[3]);

				myUpdateFromDirector.getTxt5_2().setVisible(false);
				myUpdateFromDirector.getTxt6_2().setVisible(false);
				myUpdateFromDirector.getTxt7_2().setVisible(false);
				myUpdateFromDirector.getTxt8_2().setVisible(false);
				myUpdateFromDirector.getTxt9_2().setVisible(false);
				myUpdateFromDirector.getTxt10_2().setVisible(false);

				myUpdateFromDirector.setLbl1("Cod Center");
				myUpdateFromDirector.setLbl2("Name");
				myUpdateFromDirector.setLbl3("Cycle key");
				myUpdateFromDirector.setLbl4("Cycle Name");

				myUpdateFromDirector.setLbl5(null);
				myUpdateFromDirector.setLbl6(null);
				myUpdateFromDirector.setLbl7(null);
				myUpdateFromDirector.setLbl8(null);
				myUpdateFromDirector.setLbl9(null);
				myUpdateFromDirector.setLbl10(null);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (myDirectorPanel.getTableName().equals("Student")) {

			try {

				model = modelStudent;
				table = myTablesDirector.getTable();
				int aux = table.getColumnCount();
				String[] values = new String[aux];
				int row = table.getSelectedRow();

				for (int i = 0; i < aux; i++) {
					values[i] = table.getModel().getValueAt(row, i).toString();
				}

				myUpdateFromDirector.setTxt1(values[0]);
				myUpdateFromDirector.setTxt2(values[1]);
				myUpdateFromDirector.setTxt3(values[2]);
				myUpdateFromDirector.setTxt4(values[3]);
				myUpdateFromDirector.setTxt5(values[4]);

				myUpdateFromDirector.getTxt6_2().setVisible(false);
				myUpdateFromDirector.getTxt7_2().setVisible(false);
				myUpdateFromDirector.getTxt8_2().setVisible(false);
				myUpdateFromDirector.getTxt9_2().setVisible(false);
				myUpdateFromDirector.getTxt10_2().setVisible(false);

				myUpdateFromDirector.setLbl1("Expedient");
				myUpdateFromDirector.setLbl2("DNI");
				myUpdateFromDirector.setLbl3("Name");
				myUpdateFromDirector.setLbl4("Lastname");
				myUpdateFromDirector.setLbl5("Born date");

				myUpdateFromDirector.setLbl6(null);
				myUpdateFromDirector.setLbl7(null);
				myUpdateFromDirector.setLbl8(null);
				myUpdateFromDirector.setLbl9(null);
				myUpdateFromDirector.setLbl10(null);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (myDirectorPanel.getTableName().equals("Companies")) {

			try {

				model = modelCompanies;
				table = myTablesDirector.getTable();
				int aux = table.getColumnCount();
				String[] values = new String[aux];
				int row = table.getSelectedRow();

				for (int i = 0; i < aux; i++) {
					values[i] = table.getModel().getValueAt(row, i).toString();
				}

				myUpdateFromDirector.setTxt1(values[0]);
				myUpdateFromDirector.setTxt2(values[1]);
				myUpdateFromDirector.setTxt3(values[2]);
				myUpdateFromDirector.setTxt4(values[3]);
				myUpdateFromDirector.setTxt5(values[4]);
				myUpdateFromDirector.setTxt6(values[5]);
				myUpdateFromDirector.setTxt7(values[6]);
				myUpdateFromDirector.setTxt8(values[7]);
				myUpdateFromDirector.setTxt9(values[8]);
				myUpdateFromDirector.setTxt10(values[9]);

				myUpdateFromDirector.setLbl1("CIF");
				myUpdateFromDirector.setLbl2("name");
				myUpdateFromDirector.setLbl3("Address");
				myUpdateFromDirector.setLbl4("TLF");
				myUpdateFromDirector.setLbl5("Email");

				myUpdateFromDirector.setLbl6("Cod center");
				myUpdateFromDirector.setLbl7("Convocation");
				myUpdateFromDirector.setLbl8("Anex 1");
				myUpdateFromDirector.setLbl9("City");
				myUpdateFromDirector.setLbl10("Representative");

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (myDirectorPanel.getTableName().equals("Tutors")) {

			try {

				model = modelTutor;
				table = myTablesDirector.getTable();
				int aux = table.getColumnCount();
				String[] values = new String[aux];
				int row = table.getSelectedRow();

				for (int i = 0; i < aux; i++) {
					values[i] = table.getModel().getValueAt(row, i).toString();

				}

				myUpdateFromDirector.setTxt1(values[0]);
				myUpdateFromDirector.setTxt2(values[1]);
				myUpdateFromDirector.setTxt3(values[2]);
				myUpdateFromDirector.setTxt4(values[3]);
				myUpdateFromDirector.setTxt5(values[4]);

				myUpdateFromDirector.getTxt6_2().setVisible(false);
				myUpdateFromDirector.getTxt7_2().setVisible(false);
				myUpdateFromDirector.getTxt8_2().setVisible(false);
				myUpdateFromDirector.getTxt9_2().setVisible(false);
				myUpdateFromDirector.getTxt10_2().setVisible(false);

				myUpdateFromDirector.setLbl1("DNI");
				myUpdateFromDirector.setLbl2("Name");
				myUpdateFromDirector.setLbl3("Lastname");
				myUpdateFromDirector.setLbl4("Cod Center");

				myUpdateFromDirector.setLbl5("Username");
				myUpdateFromDirector.setLbl6(null);
				myUpdateFromDirector.setLbl7(null);
				myUpdateFromDirector.setLbl8(null);
				myUpdateFromDirector.setLbl9(null);
				myUpdateFromDirector.setLbl10(null);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void UpdateStudentsFieldsFromTutor() {

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rset = pstmt.executeQuery();

			int row = myTablesDirector.getTable().getSelectedRow();
			String value = myTablesDirector.getTable().getModel().getValueAt(row, 0).toString();

			System.out.println(row);
			System.out.println(value);
			// Exp
			int exp = 0;
			String dni = "";
			String name = "";
			String lastname = "";
			String bornDate = "";
			String sqlexp = sqlTutor + myLogin.getUser() + "';";
			rset = pstmt.executeQuery("select * from alumno where exp='" + value + "';");
			while (rset.next()) {
				exp = Integer.valueOf(rset.getString(1));
				dni = rset.getString(2);
				name = rset.getString(3);
				lastname = rset.getString(4);
				bornDate = rset.getString(5);

			}
			int codePractics = 0;
			String CifCompany = "";
			String endDate = "";
			String startDate = "";
			String AcademyYear = "";
			String Schedule = "";
			String PracticsYear = "";
			String Anex_2_1 = "";
			String Anex7 = "";
			String Anex8 = "";
			String Anex3 = "";
			rset = pstmt.executeQuery("select * from practica where exp_alumno='" + value + "';");
			while (rset.next()) {
				codePractics = Integer.valueOf(rset.getString(1));
				CifCompany = rset.getString(2);
				endDate = rset.getString(5);
				startDate = rset.getString(4);
				AcademyYear = rset.getString(6);
				Schedule = rset.getString(7);
				PracticsYear = rset.getString(9);
				Anex_2_1 = rset.getString(10);
				Anex7 = rset.getString(12);
				Anex8 = rset.getString(13);
				Anex3 = rset.getString(11);

			}

			myUpdateFromTutor.placeDatabaseValues(exp, name, dni, lastname, bornDate, codePractics, CifCompany, endDate,
					startDate, AcademyYear, Schedule, PracticsYear, Anex_2_1, Anex7, Anex8, Anex3);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateFieldsDirector(String name, DefaultTableModel model, JTable table) {

		name = myDirectorPanel.getTableName();

		if (name.equals("Groups")) {

			model = modelGroups;
			table = myTablesDirector.getTable();
			int row = table.getSelectedRow();
			String value = table.getModel().getValueAt(row, 0).toString();

			int CodGroup = Integer.parseInt(myUpdateFromDirector.getTxt1());
			String nameGroup = myUpdateFromDirector.getTxt2();
			String cycleKey = myUpdateFromDirector.getTxt3();
			String cycleName = myUpdateFromDirector.getTxt4();

			try {

				String query = "Update grupo set Cod_grupo='" + CodGroup + "', Nombre='" + nameGroup
						+ "', clave_ciclo='" + cycleKey + "',Nombre_ciclo='" + cycleName + "' where Cod_grupo='" + value
						+ "';";
				Statement st = connection.createStatement();
				st.executeUpdate(query);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (name.equals("Student")) {
			model = modelStudent;
			table = myTablesDirector.getTable();
			int row = table.getSelectedRow();
			int value = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());

			int exp = Integer.parseInt(myUpdateFromDirector.getTxt1());
			String dni = myUpdateFromDirector.getTxt2();
			String studentName = myUpdateFromDirector.getTxt3();
			String lastname = myUpdateFromDirector.getTxt4();
			String bornDate = String.valueOf(myUpdateFromDirector.getTxt5());

			try {

				String query = "Update alumno set exp='" + exp + "', DNI='" + dni + "', Nombre='" + studentName
						+ "',Apellidos='" + lastname + "', Fnac='" + bornDate + "' where exp='" + value + "';";

				Statement st = connection.createStatement();
				st.executeUpdate(query);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (name.equals("Tutors")) {

			model = modelTutor;
			table = myTablesDirector.getTable();
			int row = table.getSelectedRow();
			String value = table.getModel().getValueAt(row, 0).toString();

			String dni = myUpdateFromDirector.getTxt1();
			String TutorName = myUpdateFromDirector.getTxt2();
			String lastname = myUpdateFromDirector.getTxt3();
			int codCenter = Integer.parseInt(myUpdateFromDirector.getTxt4());
			String usr = myUpdateFromDirector.getTxt5();

			try {

				String query = "Update tutor set DNI='" + dni + "', Nombre='" + TutorName + "', Apellido='" + lastname
						+ "',Cod_centro='" + codCenter + "', usr='" + usr + "' where DNI='" + value + "';";
				Statement st = connection.createStatement();
				st.executeUpdate(query);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (name.endsWith("Companies")) {

			model = modelCompanies;
			table = myTablesDirector.getTable();
			int row = table.getSelectedRow();
			String value = table.getModel().getValueAt(row, 0).toString();

			String cif = myUpdateFromDirector.getTxt1();
			String companyName = myUpdateFromDirector.getTxt2();
			String address = myUpdateFromDirector.getTxt3();
			String tlf = myUpdateFromDirector.getTxt4();
			String email = myUpdateFromDirector.getTxt5();
			int codCenter = Integer.parseInt(myUpdateFromDirector.getTxt6());
			int numConv = Integer.parseInt(myUpdateFromDirector.getTxt7());
			String anex1 = String.valueOf(myUpdateFromDirector.getTxt8());
			String location = myUpdateFromDirector.getTxt9();
			String represent = myUpdateFromDirector.getTxt10();

			try {

				String query = "Update empresa set Cif='" + cif + "', nombre='" + companyName + "', direccion='"
						+ address + "',telefono='" + tlf + "', email='" + email + "',Cod_centro='" + codCenter
						+ "',NumConv='" + numConv + "',anex1='" + anex1 + "',Localidad='" + location
						+ "',representante='" + represent + "'where Cif='" + value + "';";
				Statement st = connection.createStatement();
				st.executeUpdate(query);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void UpdateStudentsFromTutor(JTable table, DefaultTableModel model) {

		model = modelStudentTutor;
		table = myTablesDirector.getTable();
		int row = table.getSelectedRow();
		String value = table.getModel().getValueAt(row, 0).toString();
		String value1 = table.getModel().getValueAt(row, 5).toString();
		String value2 = table.getModel().getValueAt(row, 12).toString();

		int exp = Integer.valueOf(myUpdateFromTutor.getTxtExp());

		String dni = myUpdateFromTutor.getTxtDNI();
		String name = myUpdateFromTutor.getTxtName();
		String lastname = myUpdateFromTutor.getTxtLastname();
		String bornDate = myUpdateFromTutor.getTxtBornDate();

		int codePractics = Integer.valueOf(myUpdateFromTutor.getTxtCodePractics());
		String CifCompany = myUpdateFromTutor.getTxtCIFCompany();
		String endDate = myUpdateFromTutor.getTxtEndDate();
		String startDate = myUpdateFromTutor.getTxtStartDate();
		String AcademyYear = myUpdateFromTutor.getTxtAcademyYear();
		String Schedule = myUpdateFromTutor.getTxtSchedule();
		String PracticsYear = myUpdateFromTutor.getTxtPracticsYear();
		String Anex_2_1 = String.valueOf(myUpdateFromTutor.getTxtAnex_2_1());
		String Anex7 = String.valueOf(myUpdateFromTutor.getTxtAnex7());
		String Anex8 = String.valueOf(myUpdateFromTutor.getTxtAnex8());
		String Anex3 = String.valueOf(myUpdateFromTutor.getTxtAnex3());

		try {

			String query = "Update alumno set exp='" + exp + "', DNI='" + dni + "', Nombre='" + name + "',Apellidos='"
					+ lastname + "', Fnac='" + bornDate + "' where exp='" + value + "';";

			Statement st = connection.createStatement();
			st.executeUpdate(query);

			String query2 = "Update practica set cod_practica='" + codePractics + "', cif_empresa='" + CifCompany
					+ "', exp_alumno='" + exp + "',fecha_ini='" + startDate + "', fecha_fin='" + endDate + "', acad ='"
					+ AcademyYear + "', horario='" + Schedule + "', tutor='" + value2 + "', acad_practica='"
					+ PracticsYear + "', anex2_1='" + Anex_2_1 + "', anex3='" + Anex3 + "', anex7='" + Anex7
					+ "', anex8='" + Anex8 + "' where cod_practica = '" + value1 + "';";
			st = connection.createStatement();
			st.executeUpdate(query2);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insertCompanyDirector() {

		String name = myDirectorPanel.getTableName();

		if (name.equals("Groups")) {

			try {
				int cod_group = Integer.parseInt(myAddCompanyDirector.getTxt1());
				String groupName = myAddCompanyDirector.getTxt2();
				String cycleKey = myAddCompanyDirector.getTxt3();
				String cycleName = myAddCompanyDirector.getTxt4();

				String query = "insert into grupo (Cod_grupo,Nombre,clave_ciclo,Nombre_ciclo) values('" + cod_group
						+ "','" + groupName + "','" + cycleKey + "','" + cycleName + "');";

				Statement st = connection.createStatement();
				st.executeUpdate(query);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (name.equals("Student")) {

			try {
				int exp = Integer.parseInt(myAddCompanyDirector.getTxt1());
				String dni = encriptar(myAddCompanyDirector.getTxt2());
				String nameStudent = myAddCompanyDirector.getTxt3();
				String lastname = myAddCompanyDirector.getTxt4();
				String BornDate = String.valueOf(myAddCompanyDirector.getTxt5());

				String query = "insert into alumno (exp,DNI,Nombre,Apellidos,Fnac) values('" + exp + "','" + dni + "','"
						+ nameStudent + "','" + lastname + "','" + BornDate + "');";

				Statement st = connection.createStatement();
				st.executeUpdate(query);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (name.equals("Companies")) {

			try {
				String cif = myAddCompanyDirector.getTxt1();
				String nameCompany = myAddCompanyDirector.getTxt2();
				String address = myAddCompanyDirector.getTxt3();
				String tlf = myAddCompanyDirector.getTxt4();
				String email = myAddCompanyDirector.getTxt5();
				int codCenter = Integer.parseInt(myAddCompanyDirector.getTxt6());
				int numConv = Integer.parseInt(myAddCompanyDirector.getTxt7());
				String anex1 = String.valueOf(myAddCompanyDirector.getTxt8());
				String city = myAddCompanyDirector.getTxt9();
				String contact = myAddCompanyDirector.getTxt10();

				String query = "insert into empresa(Cif,nombre,direccion,telefono,email,Cod_centro,NumConv,anex1,Localidad,representante) values('"
						+ cif + "','" + nameCompany + "','" + address + "','" + tlf + "','" + email + "','" + codCenter
						+ "','" + numConv + "','" + anex1 + "','" + city + "','" + contact + "');";

				Statement st = connection.createStatement();
				st.executeUpdate(query);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (name.equals("Tutors")) {
			try {

				String dni = myAddCompanyDirector.getTxt1();
				String nameTutor = myAddCompanyDirector.getTxt2();
				String lastname = myAddCompanyDirector.getTxt3();
				int codCenter = Integer.parseInt(myAddCompanyDirector.getTxt4());
				String usr = myAddCompanyDirector.getTxt5();

				String query = "insert into tutor (DNI,Nombre,Apellido,Cod_centro,usr) values('" + dni + "','"
						+ nameTutor + "','" + lastname + "','" + codCenter + "','" + usr + "');";

				Statement st = connection.createStatement();
				st.executeUpdate(query);

			} catch (Exception e) {
				myAddCompanyDirector.setLblInformation("Error, please register this tutor previously as a user");
				e.printStackTrace();
				e.printStackTrace();

			}

		}

	}

	public void chooseAddDirector(String name, JTable table, DefaultTableModel model) {
		name = myDirectorPanel.getTableName();

		if (name.equals("Groups")) {
			try {

				model = modelGroups;
				table = myTablesDirector.getTable();

				myAddCompanyDirector.getTxt5_2().setVisible(false);
				myAddCompanyDirector.getTxt6_2().setVisible(false);
				myAddCompanyDirector.getTxt7_2().setVisible(false);
				myAddCompanyDirector.getTxt8_2().setVisible(false);
				myAddCompanyDirector.getTxt9_2().setVisible(false);
				myAddCompanyDirector.getTxt10_2().setVisible(false);

				myAddCompanyDirector.setLbl1("Cod Center");
				myAddCompanyDirector.setLbl2("Name");
				myAddCompanyDirector.setLbl3("Cycle key");
				myAddCompanyDirector.setLbl4("Cycle Name");

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (name.equals("Student")) {
			model = modelStudent;
			table = myTablesDirector.getTable();

			myAddCompanyDirector.getTxt6_2().setVisible(false);
			myAddCompanyDirector.getTxt7_2().setVisible(false);
			myAddCompanyDirector.getTxt8_2().setVisible(false);
			myAddCompanyDirector.getTxt9_2().setVisible(false);
			myAddCompanyDirector.getTxt10_2().setVisible(false);

			myAddCompanyDirector.setLbl1("Expedient");
			myAddCompanyDirector.setLbl2("DNI");
			myAddCompanyDirector.setLbl3("Name");
			myAddCompanyDirector.setLbl4("Lastname");
			myAddCompanyDirector.setLbl5("Born Date");

		} else if (name.equals("Companies")) {
			model = modelCompanies;
			table = myTablesDirector.getTable();

			myAddCompanyDirector.setLbl1("CIF");
			myAddCompanyDirector.setLbl2("Company Name");
			myAddCompanyDirector.setLbl3("Address");
			myAddCompanyDirector.setLbl4("TLF");
			myAddCompanyDirector.setLbl5("Email");
			myAddCompanyDirector.setLbl6("Cod Center");
			myAddCompanyDirector.setLbl7("Number Convocation");
			myAddCompanyDirector.setLbl8("Anex 1");
			myAddCompanyDirector.setLbl9("City");
			myAddCompanyDirector.setLbl10("Representative");

		} else if (name.equals("Tutors")) {

			model = modelTutor;
			table = myTablesDirector.getTable();

			myAddCompanyDirector.getTxt6_2().setVisible(false);
			myAddCompanyDirector.getTxt7_2().setVisible(false);
			myAddCompanyDirector.getTxt8_2().setVisible(false);
			myAddCompanyDirector.getTxt9_2().setVisible(false);
			myAddCompanyDirector.getTxt10_2().setVisible(false);

			myAddCompanyDirector.setLbl1("DNI");
			myAddCompanyDirector.setLbl2("Name");
			myAddCompanyDirector.setLbl3("Lastname");
			myAddCompanyDirector.setLbl4("Cod Center");
			myAddCompanyDirector.setLbl5("Username");

		}

	}
	// VARIETY METHODS

	public void SetEnableSettings() {
		mySettings.setEnableSettings();

	}

	public void setNoEnableSettings() {
		mySettings.setNoEnableSettings();

	}

	public void SetEnableSettingsDirector() {
		mySettingsDirector.setEnableSettings();

	}

	public void setNoEnableSettingsDirector() {
		mySettingsDirector.setNoEnableSettings();
	}

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
		myResetPassword.disableSend();
	}

	public void sendEmail() {
		myResetPassword.sendEmail();
	}

	public void showFieldsFromUpdateFromDirector() {
		myUpdateFromDirector.getTxt1_2().setVisible(true);
		myUpdateFromDirector.getTxt2_2().setVisible(true);
		myUpdateFromDirector.getTxt3_2().setVisible(true);
		myUpdateFromDirector.getTxt4_2().setVisible(true);
		myUpdateFromDirector.getTxt5_2().setVisible(true);
		myUpdateFromDirector.getTxt6_2().setVisible(true);
		myUpdateFromDirector.getTxt7_2().setVisible(true);
		myUpdateFromDirector.getTxt8_2().setVisible(true);
		myUpdateFromDirector.getTxt9_2().setVisible(true);
		myUpdateFromDirector.getTxt10_2().setVisible(true);
	}

	// SETTERS

	public void setMyHelpCenter(HelpCenter myHelpCenter) {
		this.myHelpCenter = myHelpCenter;

	}

	public void setMyManageStudent(ManageStudent myManageStudent) {
		this.myManageStudent = myManageStudent;

	}

	public void setMyResetPassword(ResetPassword myResetPassword) {
		this.myResetPassword = myResetPassword;
	}

	public void setMySettings(Settings mySettings) {
		this.mySettings = mySettings;

	}

	public void setMyRegistro(SignUp myRegistro) {
		this.mySignUp = myRegistro;

	}

	public void setDirectorPanel(DirectorPanel myDirectorPanel) {
		this.myDirectorPanel = myDirectorPanel;

	}

	public void setCompanies(Companies myCompanies) {
		this.myCompanies = myCompanies;
	}

	public void setAddStudentTutor(AddStudentTutor myAddStudentTutor) {
		this.myAddStudentTutor = myAddStudentTutor;

	}

	public void setVista(Login miLogin) {
		this.myLogin = miLogin;

	}

	public void setTablesDirector(TablesDirector myTablesDirector) {

		this.myTablesDirector = myTablesDirector;

	}

	public void setSettingsDirector(SettingsDirector mySettingsDirector) {
		this.mySettingsDirector = mySettingsDirector;
	}

	public void setDBConexion(DBConnection myDBConnection) {
		this.myDBConnection = myDBConnection;

	}

	public void setAddCompanyDirector(AddFromDirector myAddCompanyDirector) {
		this.myAddCompanyDirector = myAddCompanyDirector;

	}

	public void setUpdateFromDirector(UpdateFromDirector myUpdateFromDirector) {
		this.myUpdateFromDirector = myUpdateFromDirector;

	}

	public void setUpdateFromTutor(UpdateFromTutor myUpdateFromTutor) {
		this.myUpdateFromTutor = myUpdateFromTutor;
	}

	// GETTERS

	public DefaultTableModel getModeloP() {
		return modeloP;
	}

	public DefaultTableModel getModeloTutor() {
		return modeloTutor;
	}

	public DefaultTableModel getModeloT() {
		return modeloT;
	}

	public DefaultTableModel getModeloA() {
		return modeloA;
	}

	public DefaultTableModel getModeloG() {
		return modeloG;
	}

	public DefaultTableModel getModeloM() {
		return modeloM;
	}

	public DefaultTableModel getModeloDir() {
		return modeloDir;
	}

	public DefaultTableModel getModeloD() {
		return modeloD;
	}

	public void lblErrorAdd() {
		myAddCompanyDirector.setLblInformation(
				"" + "If the tutor to add is not registered as a user, it will not be possible to add");
	}

}