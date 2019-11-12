package StudentRec;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class StudentForm implements ActionListener, ItemListener, KeyListener {
   
    /* DATABASE RELATED */
    private Connection conn;
    private Statement stmt;
    private ResultSet sResult,Vresult;
   
    
    /* BUTTONS,FORM AND PANELS */
    private JFrame jfForm; 
    private JPanel jpAdd,jpSearch,jpDelete,jpView,jpUpdate;
    private JButton jbClear,jbAdd,jbSearch,jbDelete,jbUpdate,jbNext,jbPrevious,jbFirst,jbLast; 
    
    
    /* MENU BAR */
    private JMenuBar jmbMenu;
    private JMenu jmAction;
    private JMenuItem jmiAdd,jmiDelete,jmiUpdate,jmiSearch,jmiView;
    
    
    /* --ADD FIELD-- */
    private JLabel jlName,jlAge,jlAddress,jlGender,jlCourse,jlCourseIndicator,jlYrlvl,jlSpecialization,jlConcom,jlThesis; //Add Student Field 
    private JTextField jtfName,jtfAddress;
    private JRadioButton jrbMale, jrbFemale;
    private ButtonGroup bgGender; 
    private JPanel jpGender; 
    private JComboBox jmbAgeBS, jmbAgeMS,jmbCourse,jmbyrlvlMS,jmbspecializationBS,jmbyrlvlBS,jmbspecializationMS,jmbconcom,jmbthesis;
           
    
    /* --SEARCH FIELD-- */
    private JLabel jlSname,jlSage,jlSaddress,jlScourse,jlSname2,jlSyrlvl,jlSconcom,jlSthesis,jlSspecialization; 
    private JTextField jtfSname,jtfSname2,jtfSage,jtfSaddress,jtfSyrlvl,jtfSspecialization,jtfSthesis,jtfSconcom;
    private JRadioButton jrbSBSIT, jrbSBSCS,jrbSMSCS,jrbSMSIT;
    private ButtonGroup bgScourse; 
    private JPanel jpScourse; 
    

    /* --DELETE FIELD-- */
    private JLabel jlDname,jlDage,jlDaddress,jlDcourse,jlDname2,jlDyrlvl,jlDconcom,jlDthesis,jlDspecialization; 
    private JTextField jtfDname,jtfDname2,jtfDage,jtfDaddress,jtfDyrlvl,jtfDspecialization,jtfDthesis,jtfDconcom;
    private JRadioButton jrbDBSIT, jrbDBSCS,jrbDMSCS,jrbDMSIT;
    private ButtonGroup bgDcourse;
    private JPanel jpDcourse;
    
    /* --VIEW FIELD-- */
    private JLabel jlVage,jlVaddress,jlVcourse,jlVname2,jlVyrlvl,jlVconcom,jlVthesis,jlVspecialization; 
    private JTextField jtfVname2,jtfVage,jtfVaddress,jtfVyrlvl,jtfVspecialization,jtfVthesis,jtfVconcom;
    private JRadioButton jrbVBSIT, jrbVBSCS,jrbVMSCS,jrbVMSIT;
    private ButtonGroup bgVcourse; 
    private JPanel jpVcourse; 

    /* --UPDATE FIELD-- */
    private JLabel jlUname,jlUaddress,jlUgender,jlUyrlvl,jlUspecialization,jlUconcom,jlUthesis,jlUcourse,jlUname2;
    private JTextField jtfUname,jtfUaddress,jtfUname2;
    private JComboBox jmbUyrlvlMS,jmbUspecializationBS,jmbUyrlvlBS,jmbUspecializationMS,jmbUconcom,jmbUthesis;
    private JRadioButton jrbUBSIT, jrbUBSCS,jrbUMSCS,jrbUMSIT;
    private ButtonGroup bgUcourse;
    private JPanel jpUcourse; 
    
public StudentForm(){
  
    /*--------- MENU BAR RELATED -----------*/
    jmAction = new JMenu("Select Action");
    jmiAdd = new JMenuItem("Add Student");
    jmiView = new JMenuItem("View Students");
    jmiSearch = new JMenuItem("Search Student");
    jmiUpdate = new JMenuItem("Update Student");
    jmiDelete = new JMenuItem("Delete Student");
    jmbMenu = new JMenuBar();
  
    
    /*--------- BUTTONS, FORM AND PANELS ----------*/
    jfForm = new JFrame("Student Record");
    jbAdd = new JButton("Add Student");
    jpAdd = new JPanel();
    jbClear = new JButton("Clear");
    
    jpSearch = new JPanel();
    jbSearch = new JButton("Search");
    
    jbDelete = new JButton("Delete");
    jpDelete = new JPanel();
 
    jbNext = new JButton("Next");
    jbPrevious = new JButton("Previous");
    jbLast = new JButton("Last");
    jbFirst = new JButton("First");
    jpView = new JPanel();
    
    jpUpdate = new JPanel();
    jbUpdate = new JButton("Update");
    
    /*---------- ADD FIELD -----------*/
    //Course Indicator
    jlCourseIndicator = new JLabel("BSIT:");
    
    // Name Related
    jlName = new JLabel("Full Name:");
    jtfName = new JTextField();
    
    //Address Related
    jlAddress = new JLabel("Address:");
    jtfAddress = new JTextField();
       
    //Gender Related
    jlGender = new JLabel("Gender:");
    jrbMale = new JRadioButton("M");
    jrbFemale = new JRadioButton("F");
    bgGender = new ButtonGroup();
    jpGender = new JPanel();
     
    //Age related
    jlAge = new JLabel("Age:");
    String[] ageBS = {"15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30",};
    String[] ageMS = {"25","26","27","28","29","30",};
    jmbAgeBS = new JComboBox(ageBS);
    jmbAgeMS = new JComboBox(ageMS);
   
    // Course Picker Related
    jlCourse = new JLabel("Select Course:");
    String[] courseSelect = {"BSIT", "BSCS", "MSIT", "MSCS"};
    jmbCourse = new JComboBox(courseSelect);
    
    // BSIT Field
    jlYrlvl = new JLabel("Year Level:");
    String[] yrlvlBS = {"1","2","3","4"};
    jmbyrlvlBS = new JComboBox(yrlvlBS);
    
    // BSCS Field
    jlSpecialization = new JLabel("Specialization:");
    String[] specializationBS = {"Software Engineering","Game Development"};
    jmbspecializationBS = new JComboBox(specializationBS);

    // MSCS Field
    jlConcom = new JLabel("Connected Company Type:");
    String[] specializationMS = {"Algorithm Design","Game Algorithm"};
    String[] concom = {"Software","Call Center","Parse"};
    jmbconcom = new JComboBox(concom);
    jmbspecializationMS = new JComboBox(specializationMS);
    
     // MSIT Field
    jlThesis = new JLabel("Thesis Type:");
    String[] thesis = {"Database","Networking","MIS"};
    String[] yrlvlMS = {"1","2"};
    jmbyrlvlMS = new JComboBox(yrlvlMS);
    jmbthesis = new JComboBox(thesis);
    
    
    /*---------- SEARCH FIELD -----------*/
    
    
    //Name Related
    jlSname = new JLabel("Enter Name:");
    jtfSname = new JTextField();
    jtfSname2 = new JTextField();
    jlSname2 = new JLabel("Name:");
    
    //Address Related
    jlSaddress = new JLabel("Address:");
    jtfSaddress = new JTextField();
    
    //AGE Related
    jlSage = new JLabel("Age:");
    jtfSage = new JTextField();
    
    //BSIT & MSIT Related
    jlSyrlvl = new JLabel("Year Level:");
    jlSthesis = new JLabel("Thesis Type:");
    jtfSyrlvl = new JTextField();
    jtfSthesis = new JTextField();
    
    //BSCS & MSCS Related
    jlSspecialization = new JLabel("Specialization:");
    jlSconcom = new JLabel("Connected Company Type:");
    jtfSspecialization = new JTextField();
    jtfSconcom = new JTextField();
    

    //Course Related
    jlScourse = new JLabel("Select Course:");
    jrbSBSIT = new JRadioButton("BSIT");
    jrbSBSCS = new JRadioButton("BSCS");
    jrbSMSCS = new JRadioButton("MSCS");
    jrbSMSIT = new JRadioButton("MSIT");
    bgScourse = new ButtonGroup();
    jpScourse = new JPanel();
   
    
    /*---------- DELETE FIELD -----------*/
    
    
    //Name Related
    jlDname = new JLabel("Enter Name:");
    jtfDname = new JTextField();
    jtfDname2 = new JTextField();
    jlDname2 = new JLabel("Name:");
    
    //Address Related
    jlDaddress = new JLabel("Address:");
    jtfDaddress = new JTextField();
    
    //Age Related
    jlDage = new JLabel("Age:");
    jtfDage = new JTextField();
       
    //BSIT & MSIT Related
    jlDyrlvl = new JLabel("Year Level:");
    jlDthesis = new JLabel("Thesis Type:");
    jtfDyrlvl = new JTextField();
    jtfDthesis = new JTextField();
    
    //BSCS & MSCS Related
    jlDspecialization = new JLabel("Specialization:");
    jlDconcom = new JLabel("Connected Company Type:");
    jtfDspecialization = new JTextField();
    jtfDconcom = new JTextField();
            
    //Course Related
    jlDcourse = new JLabel("Select Course:");
    jrbDBSIT = new JRadioButton("BSIT");
    jrbDBSCS = new JRadioButton("BSCS");
    jrbDMSCS = new JRadioButton("MSCS");
    jrbDMSIT = new JRadioButton("MSIT");
    bgDcourse = new ButtonGroup();
    jpDcourse = new JPanel();
    
    
    /*---------- VIEW FIELD -----------*/
    
    
    //Name Related
    jtfVname2 = new JTextField();
    jlVname2 = new JLabel("Name:");
    
    //Address Related
    jlVaddress = new JLabel("Address:");
    jtfVaddress = new JTextField();
    
    //Age Related
    jlVage = new JLabel("Age:");
    jtfVage = new JTextField();
       
    //BSIT & MSIT Related
    jlVyrlvl = new JLabel("Year Level:");
    jlVthesis = new JLabel("Thesis Type:");
    jtfVyrlvl = new JTextField();
    jtfVthesis = new JTextField();
    
    //BSCS & MSCS Related
    jlVspecialization = new JLabel("Specialization:");
    jlVconcom = new JLabel("Connected Company Type:");
    jtfVspecialization = new JTextField();
    jtfVconcom = new JTextField();
            
    //Course Related
    jlVcourse = new JLabel("Select Course:");
    jrbVBSIT = new JRadioButton("BSIT");
    jrbVBSCS = new JRadioButton("BSCS");
    jrbVMSCS = new JRadioButton("MSCS");
    jrbVMSIT = new JRadioButton("MSIT");
    bgVcourse = new ButtonGroup();
    jpVcourse = new JPanel();
    
     /*---------- UPDATE FIELD -----------*/
    
    // Name Related
    jlUname = new JLabel("Enter Current Name:");
    jtfUname = new JTextField();
    
    jlUname2 = new JLabel("Full Name:");
    jtfUname2 = new JTextField();
    
    //Address Related
    jlUaddress = new JLabel("Address:");
    jtfUaddress = new JTextField();
             
    // BSIT Field
    jlUyrlvl = new JLabel("Year Level:");
    jmbUyrlvlBS = new JComboBox(yrlvlBS);
    
    // BSCS Field
    jlUspecialization = new JLabel("Specialization:");
    jmbUspecializationBS = new JComboBox(specializationBS);

    // MSCS Field
    jlUconcom = new JLabel("Connected Company Type:");
    jmbUconcom = new JComboBox(concom);
    jmbUspecializationMS = new JComboBox(specializationMS);
    
     // MSIT Field
    jlUthesis = new JLabel("Thesis Type:");
    jmbUyrlvlMS = new JComboBox(yrlvlMS);
    jmbUthesis = new JComboBox(thesis);
    
    //Course Related
    jlUcourse = new JLabel("Select Course:");
    jrbUBSIT = new JRadioButton("BSIT");
    jrbUBSCS = new JRadioButton("BSCS");
    jrbUMSCS = new JRadioButton("MSCS");
    jrbUMSIT = new JRadioButton("MSIT");
    bgUcourse = new ButtonGroup();
    jpUcourse = new JPanel();
}

    private void dataBaseConnection(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentrecord", "root", "");
            stmt = conn.createStatement();
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    

public void launch(){
     dataBaseConnection();
    /* ---------------------FORM SETUP---------------------------*/
    
    jfForm.setLayout(null); 
    jfForm.setSize(500,400); // sets how big the form will be
    jfForm.setLocation(200,200); // sets where form will appear on screen
    jfForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminate Program when closed
    jfForm.setLocationRelativeTo(null); // Form will be in center of screen
    jfForm.setVisible(true); // you will be able to see the form
    jfForm.setResizable(false); // will make it unable to resize window
    
    
    
   /* ---------------------MENU BAR FIELD---------------------------*/
    jmAction.add(jmiAdd);
    jmAction.add(jmiView);
    jmAction.add(jmiSearch); 
    jmAction.add(jmiDelete);
    jmAction.add(jmiUpdate); 
    jmbMenu.add(jmAction);
    jfForm.setJMenuBar(jmbMenu);
    
    //Action declaration
    jmiAdd.addActionListener(this);
    jmiDelete.addActionListener(this);
    jmiUpdate.addActionListener(this);
    jmiSearch.addActionListener(this);        
    jmiView.addActionListener(this);
     
    
    /* ---------------------ADD FIELD---------------------------*/
  
    /* SELECT OF COURSE */
    jlCourse.setBounds(4,6,140,20);
    jlCourse.setFont(new Font("Arial",Font.BOLD,15));
    
    //Combo Box
    jmbCourse.setBounds(120,6,60,20);
    jmbCourse.addItemListener(this);
    
    
   
     /* NAME */
    jtfName.setBounds(90,40,200,20); // adds message box for input 
    jlName.setBounds(5,40,100,20);
    jlName.setFont(new Font("Arial",Font.BOLD,15)); //sets text decoration & size
    jtfName.addKeyListener(this);
    
    
     /* AGE */
    jlAge.setBounds(5,75,100,20);
    jlAge.setFont(new Font("Arial",Font.BOLD,15));
    
    //Combo Box
    jmbAgeBS.setBounds(90,75,50,20);
    jmbAgeMS.setBounds(90,75,50,20);
    jmbAgeMS.setVisible(false);
    
    
    
    /* GENDER */
    jlGender.setBounds(5,110,120,20);
    jlGender.setFont(new Font("Arial",Font.BOLD,15));  
    
    // M or F Radio Buttons
    jrbMale.setBounds(0, 0, 40, 20);
    jrbFemale.setBounds(40, 0, 40, 20);
    
    // Sets them as group
    bgGender.add(jrbMale);
    bgGender.add(jrbFemale);
    
    // Adds M and F as same panel
    jpGender.add(jrbMale);
    jpGender.add(jrbFemale);
    jpGender.setLayout(null);
    jpGender.setBounds(90,110,100,30);

    
    
   
     /* ADDRESS */
    jtfAddress.setBounds(90,145,200,20); // adds message box for input 
    jlAddress.setBounds(5,145,90,20);
    jlAddress.setFont(new Font("Arial",Font.BOLD,15)); //sets text decoration & size
    
    
    

     /* COURSE INDICATOR */
    jlCourseIndicator.setBounds(5,180,100,20);
    jlCourseIndicator.setFont(new Font("Arial",Font.BOLD,25));
   
    
    
    
     /* BSIT FIELD */
    jlYrlvl.setBounds(5,225,100,20);
    jlYrlvl.setFont(new Font("Arial",Font.BOLD,15));
    jmbyrlvlBS.setBounds(100,225,40,20);
  
    
    
    
    /* BSCS FIELD */
    jlSpecialization.setBounds(5,224,150,20);
    jlSpecialization.setFont(new Font("Arial",Font.BOLD,15));
    jmbspecializationBS.setBounds(115,225,150,20);
    jmbspecializationBS.setVisible(false);
    jlSpecialization.setVisible(false);
    
    
    
    /* MSCS FIELD */
    jmbspecializationMS.setBounds(115,225,150,20);
    jmbspecializationMS.setVisible(false);
    jlConcom.setBounds(5,260,190,20);
    jlConcom.setFont(new Font("Arial",Font.BOLD,15));
    jmbconcom.setBounds(205,260,100,20);
    jlConcom.setVisible(false);
    jmbconcom.setVisible(false);

    
    
    /* MSIT FIELD */
    jmbyrlvlMS.setBounds(100,225,40,20);
    jlThesis.setBounds(5,260,190,20);
    jmbthesis.setBounds(110,260,100,20);
    jlThesis.setFont(new Font("Arial",Font.BOLD,15));
    jmbyrlvlMS.setVisible(false);
    jlThesis.setVisible(false);
    jmbthesis.setVisible(false);

    
    
    /* ABUTTONS */
    jbAdd.setBounds(340, 190, 140, 50); 
    jbClear.setBounds(340, 250, 140, 50); 
    jbAdd.addActionListener(this);
    jbClear.addActionListener(this);
    
    /*JPANEL GROUP */ 
     jpAdd.add(jlName);
     jpAdd.add(jlGender);
     jpAdd.add(jlAge);
     jpAdd.add(jlAddress);
     jpAdd.add(jlCourse);
     jpAdd.add(jlCourseIndicator);
     jpAdd.add(jlYrlvl);
     jpAdd.add(jlConcom);
     jpAdd.add(jlThesis);
     jpAdd.add(jmbyrlvlBS);
     jpAdd.add(jmbyrlvlMS);
     jpAdd.add(jmbspecializationBS);
     jpAdd.add(jmbspecializationMS);
     jpAdd.add(jmbthesis);
     jpAdd.add(jmbyrlvlBS);
     jpAdd.add(jtfName);
     jpAdd.add(jtfAddress); 
     jpAdd.add(jpGender);
     jpAdd.add(jmbAgeBS);
     jpAdd.add(jmbAgeMS);
     jpAdd.add(jmbCourse);
     jpAdd.add(jmbconcom);
     jpAdd.add(jbAdd); 
     jpAdd.add(jbClear); 
     jpAdd.add(jlSpecialization);        
     jpAdd.setLayout(null);
     jpAdd.setBounds(0,20,501,401);
     jfForm.add(jpAdd);
            
           
    /* ---------------------SEARCH FIELD---------------------------*/
    
    
    /* SEARCH NAME */
    jlSname.setBounds(4,230,140,20);
    jlSname.setFont(new Font("Arial",Font.BOLD,15));
    jtfSname.setBounds(120,230,200,20);
    jtfSname.addKeyListener(this);
    
    /* COURSE SELECT */
    jlScourse.setBounds(3,270,140,20);
    jlScourse.setFont(new Font("Arial",Font.BOLD,15)); 
    
    // Course Buttons
    jrbSBSIT.setBounds(0, 0, 55, 20);
    jrbSBSCS.setBounds(55, 0, 60, 20);
    jrbSMSIT.setBounds(0, 20, 55, 20);
    jrbSMSCS.setBounds(55, 20, 60, 20);
    jrbSBSIT.addItemListener(this);
    jrbSBSCS.addItemListener(this);
    jrbSMSIT.addItemListener(this);
    jrbSMSCS.addItemListener(this);
    
    // Sets them as group
    bgScourse.add(jrbSBSIT);
    bgScourse.add(jrbSBSCS);
    bgScourse.add(jrbSMSIT);
    bgScourse.add(jrbSMSCS);
    
    // Adds All course to a panel
    jpScourse.add(jrbSBSIT);
    jpScourse.add(jrbSBSCS);
    jpScourse.add(jrbSMSIT);
    jpScourse.add(jrbSMSCS);
    jpScourse.setLayout(null);
    jpScourse.setBounds(120,270,150,50);
   
    
    /* BUTTON */
    jbSearch.setBounds(340, 270, 140, 50); 
    jbSearch.addActionListener(this);

    /* DISPLAY */
    
    //Name
    jlSname2.setBounds(40, 0, 140, 50);
    jlSname2.setFont(new Font("Arial",Font.BOLD,15));
    jtfSname2.setBounds(200, 10, 230, 30);
    jtfSname2.setFocusable(false);
    
    //Age
    jlSage.setBounds(40, 40, 140, 50);
    jlSage.setFont(new Font("Arial",Font.BOLD,15));
    jtfSage.setBounds(200, 50, 230, 30);
    jtfSage.setFocusable(false);

    //Address
    jlSaddress.setBounds(40, 80, 140, 50);
    jlSaddress.setFont(new Font("Arial",Font.BOLD,15));
    jtfSaddress.setBounds(200, 90, 230, 30);
    jtfSaddress.setFocusable(false);
    
    //Year Level
    jlSyrlvl.setBounds(40, 120, 140, 50);
    jlSyrlvl.setFont(new Font("Arial",Font.BOLD,15));
    jtfSyrlvl.setBounds(200, 130, 230, 30);
    jtfSyrlvl.setFocusable(false);
    jlSyrlvl.setVisible(false);
    jtfSyrlvl.setVisible(false);
    
    //Specialization
    jlSspecialization.setBounds(40, 120, 140, 50);
    jlSspecialization.setFont(new Font("Arial",Font.BOLD,15));
    jtfSspecialization.setBounds(200, 130, 230, 30);
    jtfSspecialization.setFocusable(false);
    jlSspecialization.setVisible(false);
    jtfSspecialization.setVisible(false);
    
    //Thesis Type
    jlSthesis.setBounds(40, 160, 140, 50);
    jlSthesis.setFont(new Font("Arial",Font.BOLD,15));
    jtfSthesis.setBounds(200, 170, 230, 30);
    jtfSthesis.setFocusable(false);
    jlSthesis.setVisible(false);
    jtfSthesis.setVisible(false);
    
    //Connected Company Type
    jlSconcom.setBounds(40, 160, 140, 50);
    jlSconcom.setFont(new Font("Arial",Font.BOLD,15));
    jtfSconcom.setBounds(200, 170, 230, 30);
    jtfSconcom.setFocusable(false);
    jlSconcom.setVisible(false);
    jtfSconcom.setVisible(false);
       
    /*JPANEL GROUP*/
    jpSearch.add(jlSyrlvl);
    jpSearch.add(jtfSyrlvl);
    jpSearch.add(jlSspecialization);
    jpSearch.add(jtfSspecialization);
    jpSearch.add(jlSthesis);
    jpSearch.add(jtfSthesis);
    jpSearch.add(jlSconcom);
    jpSearch.add(jtfSconcom);
    jpSearch.add(jtfSname);
    jpSearch.add(jlSname);
    jpSearch.add(jlScourse);
    jpSearch.add(jpScourse);
    jpSearch.add(jbSearch);
    jpSearch.add(jlSname2);
    jpSearch.add(jtfSname2);
    jpSearch.add(jlSage);
    jpSearch.add(jtfSage);
    jpSearch.add(jlSaddress);
    jpSearch.add(jtfSaddress);
    jpSearch.setLayout(null);
    jpSearch.setBounds(0,0,501,401);
    jfForm.add(jpSearch);
    jpSearch.setVisible(false);
    
  
    
     /* ---------------------DELETE FIELD---------------------------*/
    
    /* DELETE NAME */
    jlDname.setBounds(4,230,140,20);
    jlDname.setFont(new Font("Arial",Font.BOLD,15));
    jtfDname.setBounds(120,230,200,20);
    jtfDname.addKeyListener(this);
    
    /* COURSE SELECT */
    jlDcourse.setBounds(3,270,140,20);
    jlDcourse.setFont(new Font("Arial",Font.BOLD,15)); 
    
    // Course Buttons
    jrbDBSIT.setBounds(0, 0, 55, 20);
    jrbDBSCS.setBounds(55, 0, 60, 20);
    jrbDMSIT.setBounds(0, 20, 55, 20);
    jrbDMSCS.setBounds(55, 20, 60, 20);
    
    jrbDBSIT.addItemListener(this);
    jrbDBSCS.addItemListener(this);
    jrbDMSIT.addItemListener(this);
    jrbDMSCS.addItemListener(this);
    
    // Sets them as group
    bgDcourse.add(jrbDBSIT);
    bgDcourse.add(jrbDBSCS);
    bgDcourse.add(jrbDMSIT);
    bgDcourse.add(jrbDMSCS);
    
    // Adds All course to a panel
    jpDcourse.add(jrbDBSIT);
    jpDcourse.add(jrbDBSCS);
    jpDcourse.add(jrbDMSIT);
    jpDcourse.add(jrbDMSCS);
    jpDcourse.setLayout(null);
    jpDcourse.setBounds(120,270,150,50);
   
    
    /* BUTTON */
    jbDelete.setBounds(340, 270, 140, 50); 
    jbDelete.addActionListener(this);

    /* Display */
    
    //NAME
    jlDname2.setBounds(40, 0, 140, 50);
    jlDname2.setFont(new Font("Arial",Font.BOLD,15));
    jtfDname2.setBounds(200, 10, 230, 30);
    jtfDname2.setFocusable(false);
    
    //AGE
    jlDage.setBounds(40, 40, 140, 50);
    jlDage.setFont(new Font("Arial",Font.BOLD,15));
    jtfDage.setBounds(200, 50, 230, 30);
    jtfDage.setFocusable(false);

    //ADDRESS
    jlDaddress.setBounds(40, 80, 140, 50);
    jlDaddress.setFont(new Font("Arial",Font.BOLD,15));
    jtfDaddress.setBounds(200, 90, 230, 30);
    jtfDaddress.setFocusable(false);
    
    //Year Level
    jlDyrlvl.setBounds(40, 120, 140, 50);
    jlDyrlvl.setFont(new Font("Arial",Font.BOLD,15));
    jtfDyrlvl.setBounds(200, 130, 230, 30);
    jtfDyrlvl.setFocusable(false);
    jlDyrlvl.setVisible(false);
    jtfDyrlvl.setVisible(false);
    
    //Specialization
    jlDspecialization.setBounds(40, 120, 140, 50);
    jlDspecialization.setFont(new Font("Arial",Font.BOLD,15));
    jtfDspecialization.setBounds(200, 130, 230, 30);
    jtfDspecialization.setFocusable(false);
    jlDspecialization.setVisible(false);
    jtfDspecialization.setVisible(false);
    
    //Thesis Type
    jlDthesis.setBounds(40, 160, 140, 50);
    jlDthesis.setFont(new Font("Arial",Font.BOLD,15));
    jtfDthesis.setBounds(200, 170, 230, 30);
    jtfDthesis.setFocusable(false);
    jlDthesis.setVisible(false);
    jtfDthesis.setVisible(false);
    
    //Connected Company Type
    jlDconcom.setBounds(40, 160, 140, 50);
    jlDconcom.setFont(new Font("Arial",Font.BOLD,15));
    jtfDconcom.setBounds(200, 170, 230, 30);
    jtfDconcom.setFocusable(false);
    jlDconcom.setVisible(false);
    jtfDconcom.setVisible(false);
     
    
        /*JPANEL GROUP*/
    jpDelete.add(jlDyrlvl);
    jpDelete.add(jtfDyrlvl);
    jpDelete.add(jlDspecialization);
    jpDelete.add(jtfDspecialization);
    jpDelete.add(jlDthesis);
    jpDelete.add(jtfDthesis);
    jpDelete.add(jlDconcom);
    jpDelete.add(jtfDconcom);
    jpDelete.add(jtfDname);
    jpDelete.add(jlDname);
    jpDelete.add(jlDcourse);
    jpDelete.add(jpDcourse);
    jpDelete.add(jbDelete);
    jpDelete.add(jlDname2);
    jpDelete.add(jtfDname2);
    jpDelete.add(jlDage);
    jpDelete.add(jtfDage);
    jpDelete.add(jlDaddress);
    jpDelete.add(jtfDaddress);
    jpDelete.setLayout(null);
    jpDelete.setBounds(0,0,501,401);
    jfForm.add(jpDelete);
    jpDelete.setVisible(false);

    
    
     /* ---------------------VIEW FIELD---------------------------*/
    
    /* COURSE SELECT */
    jlVcourse.setBounds(40,220,140,20); //setBounds(40, 160, 140, 50);
    jlVcourse.setFont(new Font("Arial",Font.BOLD,15)); 
    
    // Course Buttons
    jrbVBSIT.setBounds(0, 0, 55, 20);
    jrbVBSCS.setBounds(55, 0, 60, 20);
    jrbVMSIT.setBounds(0, 20, 55, 20);
    jrbVMSCS.setBounds(55, 20, 60, 20);
    
    jrbVBSIT.addItemListener(this);
    jrbVBSCS.addItemListener(this);
    jrbVMSIT.addItemListener(this);
    jrbVMSCS.addItemListener(this);
    
    // Sets them as group
    bgVcourse.add(jrbVBSIT);
    bgVcourse.add(jrbVBSCS);
    bgVcourse.add(jrbVMSIT);
    bgVcourse.add(jrbVMSCS);
    
    // Adds All course to a panel
    jpVcourse.add(jrbVBSIT);
    jpVcourse.add(jrbVBSCS);
    jpVcourse.add(jrbVMSIT);
    jpVcourse.add(jrbVMSCS);
    jpVcourse.setLayout(null);
    jpVcourse.setBounds(200,210,150,50);
   
    
    /* BUTTON */
    jbLast.setBounds(380, 270, 100, 50);
    jbFirst.setBounds(15, 270, 100, 50); 
    jbPrevious.setBounds(140, 270, 100, 50); 
    jbNext.setBounds(260, 270, 100, 50); 
    jbLast.addActionListener(this);
    jbFirst.addActionListener(this);
    jbPrevious.addActionListener(this);
    jbNext.addActionListener(this);

    /* Display */
    
    //NAME
    jlVname2.setBounds(40, 0, 140, 50);
    jlVname2.setFont(new Font("Arial",Font.BOLD,15));
    jtfVname2.setBounds(200, 10, 230, 30);
    jtfVname2.setFocusable(false);
    
    //AGE
    jlVage.setBounds(40, 40, 140, 50);
    jlVage.setFont(new Font("Arial",Font.BOLD,15));
    jtfVage.setBounds(200, 50, 230, 30);
    jtfVage.setFocusable(false);

    //ADDRESS
    jlVaddress.setBounds(40, 80, 140, 50);
    jlVaddress.setFont(new Font("Arial",Font.BOLD,15));
    jtfVaddress.setBounds(200, 90, 230, 30);
    jtfVaddress.setFocusable(false);
    
    //Year Level
    jlVyrlvl.setBounds(40, 120, 140, 50);
    jlVyrlvl.setFont(new Font("Arial",Font.BOLD,15));
    jtfVyrlvl.setBounds(200, 130, 230, 30);
    jtfVyrlvl.setFocusable(false);
    jlVyrlvl.setVisible(false);
    jtfVyrlvl.setVisible(false);
    
    //Specialization
    jlVspecialization.setBounds(40, 120, 140, 50);
    jlVspecialization.setFont(new Font("Arial",Font.BOLD,15));
    jtfVspecialization.setBounds(200, 130, 230, 30);
    jtfVspecialization.setFocusable(false);
    jlVspecialization.setVisible(false);
    jtfVspecialization.setVisible(false);
    
    //Thesis Type
    jlVthesis.setBounds(40, 160, 140, 50);
    jlVthesis.setFont(new Font("Arial",Font.BOLD,15));
    jtfVthesis.setBounds(200, 170, 230, 30);
    jtfVthesis.setFocusable(false);
    jlVthesis.setVisible(false);
    jtfVthesis.setVisible(false);
    
    //Connected Company Type
    jlVconcom.setBounds(40, 160, 140, 50);
    jlVconcom.setFont(new Font("Arial",Font.BOLD,15));
    jtfVconcom.setBounds(200, 170, 230, 30);
    jtfVconcom.setFocusable(false);
    jlVconcom.setVisible(false);
    jtfVconcom.setVisible(false);
       
    
        /*JPANEL GROUP*/
    jpView.add(jlVyrlvl);
    jpView.add(jtfVyrlvl);
    jpView.add(jlVspecialization);
    jpView.add(jtfVspecialization);
    jpView.add(jlVthesis);
    jpView.add(jtfVthesis);
    jpView.add(jlVconcom);
    jpView.add(jtfVconcom);
    jpView.add(jlVcourse);
    jpView.add(jpVcourse);
    jpView.add(jlVname2);
    jpView.add(jtfVname2);
    jpView.add(jlVage);
    jpView.add(jtfVage);
    jpView.add(jlVaddress);
    jpView.add(jtfVaddress);
    jpView.add(jbNext);
    jpView.add(jbPrevious);
    jpView.add(jbFirst);
    jpView.add(jbLast);
    jpView.setLayout(null);
    jpView.setBounds(0,0,501,401);
    jfForm.add(jpView);
    jpView.setVisible(false);

      /* ---------------------UPDATE FIELD---------------------------*/
    
    /* UPDATE NAME */
    jlUname.setBounds(4,230,180,20);
    jlUname.setFont(new Font("Arial",Font.BOLD,15));
    jtfUname.setBounds(200,230,220,20);
    jtfUname.addKeyListener(this);
    
    /* COURSE SELECT */
    jlUcourse.setBounds(3,270,140,20);
    jlUcourse.setFont(new Font("Arial",Font.BOLD,15)); 
    
    // Course Buttons
    jrbUBSIT.setBounds(0, 0, 55, 20);
    jrbUBSCS.setBounds(55, 0, 60, 20);
    jrbUMSIT.setBounds(0, 20, 55, 20);
    jrbUMSCS.setBounds(55, 20, 60, 20);
    
    jrbUBSIT.addItemListener(this);
    jrbUBSCS.addItemListener(this);
    jrbUMSIT.addItemListener(this);
    jrbUMSCS.addItemListener(this);
    
    // Sets them as group
    bgUcourse.add(jrbUBSIT);
    bgUcourse.add(jrbUBSCS);
    bgUcourse.add(jrbUMSIT);
    bgUcourse.add(jrbUMSCS);
    
    // Adds All course to a panel
    jpUcourse.add(jrbUBSIT);
    jpUcourse.add(jrbUBSCS);
    jpUcourse.add(jrbUMSIT);
    jpUcourse.add(jrbUMSCS);
    jpUcourse.setLayout(null);
    jpUcourse.setBounds(120,270,150,50);
   
    
    /* BUTTON */
    jbUpdate.setBounds(340, 270, 140, 50); 
    jbUpdate.addActionListener(this);

    /* Display */
    
    //NAME
    jlUname2.setBounds(40, 0, 140, 50);
    jlUname2.setFont(new Font("Arial",Font.BOLD,15));
    jtfUname2.setBounds(200, 10, 230, 30);    
    jtfUname2.addKeyListener(this);
  

    //ADDRESS
    jlUaddress.setBounds(40, 40, 140, 50);
    jlUaddress.setFont(new Font("Arial",Font.BOLD,15));
    jtfUaddress.setBounds(200, 50, 230, 30);
    
    //Year Level
    jlUyrlvl.setBounds(40, 80, 140, 50);
    jlUyrlvl.setFont(new Font("Arial",Font.BOLD,15));
    jmbUyrlvlBS.setBounds(200, 90, 230, 30);
    jmbUyrlvlMS.setBounds(200, 90, 230, 30);
    jlUyrlvl.setVisible(false);
    jmbUyrlvlBS.setVisible(false);
    jmbUyrlvlMS.setVisible(false);
    
    //Specialization
    jlUspecialization.setBounds(40, 80, 140, 50);
    jlUspecialization.setFont(new Font("Arial",Font.BOLD,15));
    jmbUspecializationBS.setBounds(200, 90, 230, 30);
    jmbUspecializationMS.setBounds(200, 90, 230, 30);
    jlUspecialization.setVisible(false);
    jmbUspecializationBS.setVisible(false);
    jmbUspecializationMS.setVisible(false);
    
    //Thesis Type
    jlUthesis.setBounds(40, 120, 140, 50);
    jlUthesis.setFont(new Font("Arial",Font.BOLD,15));
    jmbUthesis.setBounds(200, 130, 230, 30);
    jlUthesis.setVisible(false);
    jmbUthesis.setVisible(false);
    
    //Connected Company Type
    jlUconcom.setBounds(40, 120, 140, 50);
    jlUconcom.setFont(new Font("Arial",Font.BOLD,15));
    jmbUconcom.setBounds(200, 130, 230, 30);
    jlUconcom.setVisible(false);
    jmbUconcom.setVisible(false);
       
    /* JPANEL GROUP*/
    jpUpdate.add(jlUyrlvl);
    jpUpdate.add(jmbUyrlvlBS);
    jpUpdate.add(jmbUyrlvlMS);
    jpUpdate.add(jlUspecialization);
    jpUpdate.add(jmbUspecializationBS);
    jpUpdate.add(jmbUspecializationMS);
    jpUpdate.add(jlUthesis);
    jpUpdate.add(jmbUthesis);
    jpUpdate.add(jlUconcom);
    jpUpdate.add(jmbUconcom);
    jpUpdate.add(jlUcourse);
    jpUpdate.add(jpUcourse);
    jpUpdate.add(jlUname);
    jpUpdate.add(jtfUname);
    jpUpdate.add(jlUname2);
    jpUpdate.add(jtfUname2);
    jpUpdate.add(jlUaddress);
    jpUpdate.add(jtfUaddress);
    jpUpdate.add(jbUpdate);
    jpUpdate.setLayout(null);
    jpUpdate.setBounds(0,0,501,401);
    jfForm.add(jpUpdate);
    jpUpdate.setVisible(false);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        /*--------------- ADD FIELD BUTTON ---------------*/
         if(jbAdd == e.getSource()){  
            try {
                String Acourse = jmbCourse.getSelectedItem().toString();
                String Aname = jtfName.getText();
                int AageBS = Integer.parseInt(jmbAgeBS.getSelectedItem().toString());
                int AageMS = Integer.parseInt(jmbAgeMS.getSelectedItem().toString()); 
                char Agender = 'M';
                
                if(jrbMale.isSelected()){
                Agender = 'M';
                }
                
                if(jrbFemale.isSelected()){
                Agender = 'F';
                }
                        
                String Aaddress = jtfAddress.getText();
                
                
                /*---------- ADDS IN BSIT TABLE ----------*/
                if(jmbCourse.getSelectedItem().equals("BSIT")){ 
                int AyrlvlBS = Integer.parseInt(jmbyrlvlBS.getSelectedItem().toString()); 
                
                String sqlStatement = "Insert into bsit values ('"+Aname+"','"+Acourse+"','"+AageBS+"','"+Agender+"','"+Aaddress+"','"+AyrlvlBS+"')";
                stmt.executeUpdate(sqlStatement);
                conn.close();
                }
                
                 /*---------- ADDS IN BSCS TABLE ----------*/
                if(jmbCourse.getSelectedItem().equals("BSCS")){ 
                String AspecializationBS = jmbspecializationBS.getSelectedItem().toString();                 
                String sqlStatement = "Insert into bscs values ('"+Aname+"','"+Acourse+"','"+AageBS+"','"+Agender+"','"+Aaddress+"','"+AspecializationBS+"')";
                stmt.executeUpdate(sqlStatement);
                conn.close();
                }
                
                /*---------- ADDS IN MSIT TABLE ----------*/
                if(jmbCourse.getSelectedItem().equals("MSIT")){ 
                int AyrlvlMS = Integer.parseInt(jmbyrlvlMS.getSelectedItem().toString()); 
                String Athesis = jmbthesis.getSelectedItem().toString();
                String sqlStatement = "Insert into msit values ('"+Aname+"','"+Acourse+"','"+AageMS+"','"+Agender+"','"+Aaddress+"','"+AyrlvlMS+"','"+Athesis+"')";
                stmt.executeUpdate(sqlStatement);
                conn.close();
                }
                        
                /*---------- ADDS IN MSCS TABLE ----------*/
                if(jmbCourse.getSelectedItem().equals("MSCS")){ 
                String AspecializationMS = jmbspecializationMS.getSelectedItem().toString();     
                String Aconcom = jmbconcom.getSelectedItem().toString();
                String sqlStatement = "Insert into mscs values ('"+Aname+"','"+Acourse+"','"+AageMS+"','"+Agender+"','"+Aaddress+"','"+AspecializationMS+"','"+Aconcom+"')";
                stmt.executeUpdate(sqlStatement);
                conn.close();
                }
                
                 /*---------- END OF IF BUTTON ADD STATEMENT ----------*/
                dataBaseConnection();
                } catch (SQLException ex) {
                }
                
       
            
            
             /*---------- CLEARS THE INPUTS ----------*/
            jmbyrlvlBS.setSelectedIndex(0);       
            jmbspecializationBS.setSelectedIndex(0);     
            jmbspecializationMS.setSelectedIndex(0);     
            jmbAgeMS.setSelectedIndex(0);     
            jmbAgeBS.setSelectedIndex(0);     
            jmbconcom.setSelectedIndex(0);     
            jmbthesis.setSelectedIndex(0);     
            jmbyrlvlMS.setSelectedIndex(0);                    
            jmbCourse.setSelectedIndex(0);
            jtfName.setText("");
            jtfAddress.setText(""); 
                
        }
         
           if(jbClear == e.getSource()){
            jmbyrlvlBS.setSelectedIndex(0);       
            jmbspecializationBS.setSelectedIndex(0);     
            jmbspecializationMS.setSelectedIndex(0);     
            jmbAgeMS.setSelectedIndex(0);     
            jmbAgeBS.setSelectedIndex(0);     
            jmbconcom.setSelectedIndex(0);     
            jmbthesis.setSelectedIndex(0);     
            jmbyrlvlMS.setSelectedIndex(0);                    
            jmbCourse.setSelectedIndex(0);
            jtfName.setText("");
            jtfAddress.setText("");
        }
           
           
         /*--------------- DELETE FIELD BUTTON ---------------*/
         if(jbDelete == e.getSource()){
            try {
                String Dname = jtfDname.getText();
                
                
                /*--------- BSIT DELETE ---------*/
                if(jrbDBSIT.isSelected()){
                
                //VIEW STATEMENT    
                sResult = stmt.executeQuery("select * from bsit where Name='"+Dname+"'");   
                sResult.next();
                jtfDname2.setText(sResult.getString("Name")); 
                jtfDage.setText(sResult.getInt("Age")+"");
                jtfDaddress.setText(sResult.getString("Address"));
                jtfDyrlvl.setText(sResult.getInt("Year Level")+"");
                    
                    
                //DELETE STATEMENT    
                String sqlStatement = "delete from bsit where Name='"+Dname+"'";   
                stmt.executeUpdate(sqlStatement);
                conn.close();
                }
                
                /*--------- BSCS DELETE ---------*/
                  if(jrbDBSCS.isSelected()){
                 
                //VIEW STATEMENT    
                sResult = stmt.executeQuery("select * from bscs where Name='"+Dname+"'");   
                sResult.next();
                jtfDname2.setText(sResult.getString("Name")); 
                jtfDage.setText(sResult.getInt("Age")+"");
                jtfDaddress.setText(sResult.getString("Address"));
                jtfDspecialization.setText(sResult.getString("Specialization"));

                
                //DELETE STATEMENT       
                String sqlStatement = "delete from bscs where Name='"+Dname+"'";   
                stmt.executeUpdate(sqlStatement);
                conn.close();
                }
                
                /*--------- MSIT DELETE ---------*/
                   if(jrbDMSIT.isSelected()){
                       
                //VIEW STATEMENT    
                sResult = stmt.executeQuery("select * from msit where Name='"+Dname+"'");   
                sResult.next();
                jtfDname2.setText(sResult.getString("Name")); 
                jtfDage.setText(sResult.getInt("Age")+"");
                jtfDaddress.setText(sResult.getString("Address"));
                jtfDyrlvl.setText(sResult.getInt("Year Level")+"");
                jtfDthesis.setText(sResult.getString("Thesis Type"));
                       
                            
                //DELETE STATEMENT     
                String sqlStatement = "delete from msit where Name='"+Dname+"'";   
                stmt.executeUpdate(sqlStatement);
                conn.close();
                }
                
                /*--------- MSCS DELETE ---------*/
                   if(jrbDMSCS.isSelected()){
                
                //VIEW STATEMENT           
                sResult = stmt.executeQuery("select * from mscs where Name='"+Dname+"'");   
                sResult.next();
                jtfDname2.setText(sResult.getString("Name")); 
                jtfDage.setText(sResult.getInt("Age")+"");
                jtfDaddress.setText(sResult.getString("Address"));
                jtfDspecialization.setText(sResult.getString("Specialization"));
                jtfDconcom.setText(sResult.getString("Connected Company Type"));       
                       
            
                //DELETE STATEMENT         
                String sqlStatement = "delete from mscs where Name='"+Dname+"'";   
                stmt.executeUpdate(sqlStatement);
                conn.close();
                }
                
            dataBaseConnection();
            } catch (SQLException ex) {
            }
        }
         
         
         
         
         /*--------------- SEARCH FIELD BUTTON ---------------*/ 
        if(jbSearch == e.getSource()){
            try {
                String Sname = jtfSname.getText();                      
                /*--------- BSIT SEARCH ---------*/
                if(jrbSBSIT.isSelected()){
                sResult = stmt.executeQuery("select * from bsit where Name='"+Sname+"'");   
                sResult.next();
                jtfSname2.setText(sResult.getString("Name")); 
                jtfSage.setText(sResult.getInt("Age")+"");
                jtfSaddress.setText(sResult.getString("Address"));
                jtfSyrlvl.setText(sResult.getInt("Year Level")+"");
                conn.close();
                }
              
                /*--------- MSIT SEARCH ---------*/
                if(jrbSMSIT.isSelected()){
                sResult = stmt.executeQuery("select * from msit where Name='"+Sname+"'");   
                sResult.next();
                jtfSname2.setText(sResult.getString("Name")); 
                jtfSage.setText(sResult.getInt("Age")+"");
                jtfSaddress.setText(sResult.getString("Address"));
                jtfSyrlvl.setText(sResult.getInt("Year Level")+"");
                jtfSthesis.setText(sResult.getString("Thesis Type"));
                conn.close();
                }
                
                /*--------- BSCS SEARCH ---------*/
                if(jrbSBSCS.isSelected()){
                sResult = stmt.executeQuery("select * from bscs where Name='"+Sname+"'");   
                sResult.next();
                jtfSname2.setText(sResult.getString("Name")); 
                jtfSage.setText(sResult.getInt("Age")+"");
                jtfSaddress.setText(sResult.getString("Address"));
                jtfSspecialization.setText(sResult.getString("Specialization"));
                conn.close();
                }
                
                  /*--------- MSCS SEARCH ---------*/
                if(jrbSMSCS.isSelected()){
                sResult = stmt.executeQuery("select * from mscs where Name='"+Sname+"'");   
                sResult.next();
                jtfSname2.setText(sResult.getString("Name")); 
                jtfSage.setText(sResult.getInt("Age")+"");
                jtfSaddress.setText(sResult.getString("Address"));
                jtfSspecialization.setText(sResult.getString("Specialization"));
                jtfSconcom.setText(sResult.getString("Connected Company Type"));
                conn.close();
                }
            
              dataBaseConnection();    
            } catch (SQLException ex) {
            }
        }
             
        
        /*--------------- VIEW FIELD BUTTON ---------------*/   
      
        
    
          try {  
                  /*----- BSIT VIEW -----*/
                if(jrbVBSIT.isSelected()){
                 
                    if(jbNext == e.getSource()){
                        if(Vresult.isLast()){
                            Vresult.first();
                        }else{
                            Vresult.next();
                        }
                    }    
                    
                    if(jbPrevious == e.getSource()){
                        if(Vresult.isFirst()){
                            Vresult.last();
                        }else{
                            Vresult.previous();
                        }
                    } 
                    
                    if(jbLast == e.getSource()){
                        Vresult.last();
                    } 
                    
                    if(jbFirst == e.getSource()){
                        Vresult.first();
                    } 
                    
                    jtfVname2.setText(Vresult.getString("Name")); 
                    jtfVage.setText(Vresult.getInt("Age")+"");
                    jtfVaddress.setText(Vresult.getString("Address"));
                    jtfVyrlvl.setText(Vresult.getInt("Year Level")+"");    
                    
                }
                
                      /*----- BSCS VIEW -----*/
                if(jrbVBSCS.isSelected()){
                 
                    if(jbNext == e.getSource()){
                                           if(jbNext == e.getSource()){
                        if(Vresult.isLast()){
                            Vresult.first();
                        }else{
                            Vresult.next();
                        }
                    }    
                    
                    if(jbPrevious == e.getSource()){
                        if(Vresult.isFirst()){
                            Vresult.last();
                        }else{
                            Vresult.previous();
                        }
                    } 
                    
                    if(jbLast == e.getSource()){
                        Vresult.last();
                    } 
                    
                    if(jbFirst == e.getSource()){
                        Vresult.first();
                    } 
                    }
                    
                    jtfVname2.setText(Vresult.getString("Name")); 
                    jtfVage.setText(Vresult.getInt("Age")+"");
                    jtfVaddress.setText(Vresult.getString("Address"));
                    jtfVspecialization.setText(Vresult.getString("Specialization"));    
                    
                }
                
                         /*----- MSIT VIEW -----*/
                if(jrbVMSIT.isSelected()){
                 
                    if(jbNext == e.getSource()){
                        if(Vresult.isLast()){
                            Vresult.first();
                        }else{
                            Vresult.next();
                        }
                    }    
                    
                    if(jbPrevious == e.getSource()){
                        if(Vresult.isFirst()){
                            Vresult.last();
                        }else{
                            Vresult.previous();
                        }
                    } 
                    
                    if(jbLast == e.getSource()){
                        Vresult.last();
                    } 
                    
                    if(jbFirst == e.getSource()){
                        Vresult.first();
                    } 
                    
                    
                    
                    jtfVname2.setText(Vresult.getString("Name")); 
                    jtfVage.setText(Vresult.getInt("Age")+"");
                    jtfVaddress.setText(Vresult.getString("Address"));
                    jtfVyrlvl.setText(Vresult.getInt("Year Level")+"");
                    jtfVthesis.setText(Vresult.getString("Thesis Type"));
                    
                }
               
                     /*----- MSCS VIEW -----*/
                if(jrbVMSCS.isSelected()){
                 
                    if(jbNext == e.getSource()){
                        if(Vresult.isLast()){
                            Vresult.first();
                        }else{
                            Vresult.next();
                        }
                    }    
                    
                    if(jbPrevious == e.getSource()){
                        if(Vresult.isFirst()){
                            Vresult.last();
                        }else{
                            Vresult.previous();
                        }
                    } 
                    
                    if(jbLast == e.getSource()){
                        Vresult.last();
                    } 
                    
                    if(jbFirst == e.getSource()){
                        Vresult.first();
                    } 
                    jtfVname2.setText(Vresult.getString("Name")); 
                    jtfVage.setText(Vresult.getInt("Age")+"");
                    jtfVaddress.setText(Vresult.getString("Address"));
                    jtfVspecialization.setText(Vresult.getString("Specialization"));
                    jtfVconcom.setText(Vresult.getString("Connected Company Type"));
                    
                }
            } catch (SQLException ex) {
            }
        
        
 
        /*--------------- UPDATE FIELD BUTTON ---------------*/ 
        
        if(jbUpdate == e.getSource()){  
          try { 
                String Uname = jtfUname.getText();
                String Uaddress = jtfUaddress.getText();
                String Uname2 = jtfUname2.getText();
               
                  /*--------- BSIT UPDATE ---------*/ 
                if(jrbUBSIT.isSelected()){
                    int UyrlvlBS = Integer.parseInt(jmbUyrlvlBS.getSelectedItem().toString());
                    String sqlStatement = "UPDATE bsit SET Name = '"+Uname2+"',Address = '"+Uaddress+"',`Year Level` = '"+UyrlvlBS+"' WHERE name = '"+Uname+"'";                  
                    stmt.executeUpdate(sqlStatement);
                    conn.close();                
                    dataBaseConnection();
                }
                
                 /*--------- MSIT UPDATE ---------*/ 
                if(jrbUMSIT.isSelected()){
                    int UyrlvlMS = Integer.parseInt(jmbUyrlvlMS.getSelectedItem().toString()); 
                    String Uthesis = jmbUthesis.getSelectedItem().toString();
                    String sqlStatement = "UPDATE msit SET Name = '"+Uname2+"',Address = '"+Uaddress+"',`Year Level` = '"+UyrlvlMS+"',`Thesis Type` = '"+Uthesis+"' WHERE name = '"+Uname+"'";                  
                    stmt.executeUpdate(sqlStatement);
                    conn.close();                
                    dataBaseConnection();
                }
                
                /*--------- BSCS UPDATE ---------*/ 
                if(jrbUBSCS.isSelected()){
                    String UspecializationBS = jmbUspecializationBS.getSelectedItem().toString();  
                    String sqlStatement = "UPDATE bscs SET Name = '"+Uname2+"',Address = '"+Uaddress+"',Specialization = '"+UspecializationBS+"' WHERE name = '"+Uname+"'";                  
                    stmt.executeUpdate(sqlStatement);
                    conn.close();                
                    dataBaseConnection();
                }
            
                /*--------- MSCS UPDATE ---------*/ 
                if(jrbUMSCS.isSelected()){
                    String UspecializationMS = jmbUspecializationMS.getSelectedItem().toString();  
                    String Uconcom = jmbUconcom.getSelectedItem().toString();
                    String sqlStatement = "UPDATE mscs SET Name = '"+Uname2+"',Address = '"+Uaddress+"',Specialization = '"+UspecializationMS+"',`Connected Company Type` = '"+Uconcom+"' WHERE name = '"+Uname+"'";                  
                    stmt.executeUpdate(sqlStatement);
                    conn.close();                
                    dataBaseConnection();
                }
     
          } catch (SQLException ex) {
          }  
          
      }
        
        
        
    /*--------------- MENU ACTIONS ---------------*/   
        
        if(jmiAdd == e.getSource()){
            jpAdd.setVisible(true);
            jpSearch.setVisible(false);
            jpDelete.setVisible(false);
            jpView.setVisible(false);
            jpUpdate.setVisible(false);
            jmbCourse.setSelectedIndex(0);
        }
         
        if(jmiSearch == e.getSource()){
            jpAdd.setVisible(false);
            jpSearch.setVisible(true);
            jpDelete.setVisible(false);
            jpView.setVisible(false);
            jpUpdate.setVisible(false);
        }

        if(jmiDelete == e.getSource()){
            jpAdd.setVisible(false);
            jpSearch.setVisible(false);
            jpDelete.setVisible(true);
            jpView.setVisible(false);
            jpUpdate.setVisible(false);
        }
         
        if(jmiView == e.getSource()){
            jpAdd.setVisible(false);
            jpSearch.setVisible(false);
            jpDelete.setVisible(false);
            jpView.setVisible(true);
            jpUpdate.setVisible(false);
        }
       
        if(jmiUpdate == e.getSource()){
            jpAdd.setVisible(false);
            jpSearch.setVisible(false);
            jpDelete.setVisible(false);
            jpView.setVisible(false);
            jpUpdate.setVisible(true);
        }
         
      
      
        }
    
    @Override
    public void itemStateChanged(ItemEvent e){
      
          /*--------------- ADD RELATED FIELD ---------------*/ 
       
        // Make BS Age or MS Age appear
        if(jmbCourse.getSelectedItem().equals("BSIT") || jmbCourse.getSelectedItem().equals("BSCS")){ 
             jmbAgeBS.setVisible(true);
        }
        else{
             jmbAgeBS.setVisible(false);
        }
        
        if(jmbCourse.getSelectedItem().equals("MSIT") || jmbCourse.getSelectedItem().equals("MSCS")){ 
             jmbAgeMS.setVisible(true);
        }
        else{
             jmbAgeMS.setVisible(false);
        }
        
        
        // To make BSIT Field appear
        if(jmbCourse.getSelectedItem().equals("BSIT")){ 
             jlYrlvl.setVisible(true);
            jmbyrlvlBS.setVisible(true);
        }
        else{
             jlYrlvl.setVisible(false);
            jmbyrlvlBS.setVisible(false);
        }
        
        // To make BSCS Field appear
        if(jmbCourse.getSelectedItem().equals("BSCS")){ 
            jmbspecializationBS.setVisible(true);
            jlSpecialization.setVisible(true);
        }
        else{
            jmbspecializationBS.setVisible(false);
            jlSpecialization.setVisible(false);
        }
        
        // To make MSCS Field appear
        if(jmbCourse.getSelectedItem().equals("MSCS")){ 
            jmbspecializationMS.setVisible(true);
            jlSpecialization.setVisible(true);
            jlConcom.setVisible(true);
            jmbconcom.setVisible(true);
        }
        else{
            jmbspecializationMS.setVisible(false);
            jlConcom.setVisible(false);
            jmbconcom.setVisible(false);
        } 
        
        // To make MSIT Field appear
        if(jmbCourse.getSelectedItem().equals("MSIT")){ 
            jlYrlvl.setVisible(true);
            jmbyrlvlMS.setVisible(true);
            jlThesis.setVisible(true);
            jmbthesis.setVisible(true);
        }
        else{
             jmbyrlvlMS.setVisible(false);
             jlThesis.setVisible(false);
             jmbthesis.setVisible(false);
        }   
        
        
      
          /*--------------- SEARCH FIELD RELATED ---------------*/ 
        
        //BSIT & MSIT RADIO LISTENER
        if(jrbSBSIT.isSelected() || jrbSMSIT.isSelected()){          
            
            // CLEARS ALL FIELDS
            jtfSname2.setText(""); 
            jtfSage.setText(""); 
            jtfSaddress.setText(""); 
            jtfSyrlvl.setText(""); 
            jtfSthesis.setText(""); 
            jtfSconcom.setText(""); 
            jtfSspecialization.setText(""); 
            
          
            jlSyrlvl.setVisible(true);
            jtfSyrlvl.setVisible(true);
            
            if(jrbSMSIT.isSelected()){
                jlSthesis.setVisible(true);
                jtfSthesis.setVisible(true);
            }
        }else{
            jlSyrlvl.setVisible(false);
            jtfSyrlvl.setVisible(false);
            jlSthesis.setVisible(false);
            jtfSthesis.setVisible(false);
        }
        
        //BSCS & MSCS RADIO LISTENER
        if(jrbSBSCS.isSelected() || jrbSMSCS.isSelected()){
               
            // CLEARS ALL FIELDS
            jtfSname2.setText(""); 
            jtfSage.setText(""); 
            jtfSaddress.setText(""); 
            jtfSyrlvl.setText(""); 
            jtfSthesis.setText(""); 
            jtfSconcom.setText(""); 
            jtfSspecialization.setText(""); 
            
            
            jlSspecialization.setVisible(true);
            jtfSspecialization.setVisible(true);   
            
            if(jrbSMSCS.isSelected()){
                jlSconcom.setVisible(true);
                jtfSconcom.setVisible(true);
            }
        }
        else{
            jlSspecialization.setVisible(false);
            jtfSspecialization.setVisible(false);   
            jlSconcom.setVisible(false);
            jtfSconcom.setVisible(false);   
        }
        
        
        
          /*--------------- DELETE FIELD RELATED ---------------*/ 
        
        //BSIT & MSIT RADIO LISTENER
        if(jrbDBSIT.isSelected() || jrbDMSIT.isSelected()){          
            
            // CLEARS ALL FIELDS
            jtfDname2.setText(""); 
            jtfDage.setText(""); 
            jtfDaddress.setText(""); 
            jtfDyrlvl.setText(""); 
            jtfDthesis.setText(""); 
            jtfDconcom.setText(""); 
            jtfDspecialization.setText(""); 
            
          
            jlDyrlvl.setVisible(true);
            jtfDyrlvl.setVisible(true);
            
            if(jrbDMSIT.isSelected()){
                jlDthesis.setVisible(true);
                jtfDthesis.setVisible(true);
            }
        }else{
            jlDyrlvl.setVisible(false);
            jtfDyrlvl.setVisible(false);
            jlDthesis.setVisible(false);
            jtfDthesis.setVisible(false);
        }
        
        //BSCS & MSCS RADIO LISTENER
        if(jrbDBSCS.isSelected() || jrbDMSCS.isSelected()){
               
            // CLEARS ALL FIELDS
            jtfDname2.setText(""); 
            jtfDage.setText(""); 
            jtfDaddress.setText(""); 
            jtfDyrlvl.setText(""); 
            jtfDthesis.setText(""); 
            jtfDconcom.setText(""); 
            jtfDspecialization.setText(""); 
            
            
            jlDspecialization.setVisible(true);
            jtfDspecialization.setVisible(true);   
            
            if(jrbDMSCS.isSelected()){
                jlDconcom.setVisible(true);
                jtfDconcom.setVisible(true);
            }
        }
        else{
            jlDspecialization.setVisible(false);
            jtfDspecialization.setVisible(false);   
            jlDconcom.setVisible(false);
            jtfDconcom.setVisible(false);   
        }
        
        
         /*--------------- VIEW FIELD RELATED ---------------*/ 
        
        //BSIT & MSIT RADIO LISTENER
        if(jrbVBSIT.isSelected() || jrbVMSIT.isSelected()){          
            try{  
            Vresult = stmt.executeQuery("select * from `bsit` ORDER BY `bsit`.`Name` asc");
             
            }catch(SQLException ex){            
            }
            
            // CLEARS ALL FIELDS
            jtfVname2.setText(""); 
            jtfVage.setText(""); 
            jtfVaddress.setText(""); 
            jtfVyrlvl.setText(""); 
            jtfVthesis.setText(""); 
            jtfVconcom.setText(""); 
            jtfVspecialization.setText(""); 
            
          
            jlVyrlvl.setVisible(true);
            jtfVyrlvl.setVisible(true);
            
        if(jrbVMSIT.isSelected()){
            try{
            Vresult = stmt.executeQuery("select * from `msit` ORDER BY `msit`.`Name` asc");            
            }catch(SQLException ex){            
            }
                
                jlVthesis.setVisible(true);
                jtfVthesis.setVisible(true);
            }
        }else{
            jlVyrlvl.setVisible(false);
            jtfVyrlvl.setVisible(false);
            jlVthesis.setVisible(false);
            jtfVthesis.setVisible(false);
        }
        
        //BSCS & MSCS RADIO LISTENER
        if(jrbVBSCS.isSelected() || jrbVMSCS.isSelected()){
            try{
            Vresult = stmt.executeQuery("select * from `bscs` ORDER BY `bscs`.`Name` asc"); 
            }catch(SQLException ex){            
            }  
            
            
            // CLEARS ALL FIELDS
            jtfVname2.setText(""); 
            jtfVage.setText(""); 
            jtfVaddress.setText(""); 
            jtfVyrlvl.setText(""); 
            jtfVthesis.setText(""); 
            jtfVconcom.setText(""); 
            jtfVspecialization.setText(""); 
            
            
            jlVspecialization.setVisible(true);
            jtfVspecialization.setVisible(true);   
            
            if(jrbVMSCS.isSelected()){
               try{
               Vresult = stmt.executeQuery("select * from `mscs` ORDER BY `mscs`.`Name` asc"); 
               }catch(SQLException ex){            
               }
                
                jlVconcom.setVisible(true);
                jtfVconcom.setVisible(true);
            }
        }
        else{
            jlVspecialization.setVisible(false);
            jtfVspecialization.setVisible(false);   
            jlVconcom.setVisible(false);
            jtfVconcom.setVisible(false);   
        }
        
        
         /*--------------- UPDATE FIELD RELATED ---------------*/ 
        
        //BSIT & MSIT RADIO LISTENER
        if(jrbUBSIT.isSelected() || jrbUMSIT.isSelected()){          
            
            // CLEARS ALL FIELDS
            jtfUname2.setText(""); 
            jtfUaddress.setText(""); 
            jmbUyrlvlMS.setSelectedIndex(0);
            jmbUyrlvlBS.setSelectedIndex(0);
            jmbUthesis.setSelectedIndex(0); 
            jmbUconcom.setSelectedIndex(0); 
            jmbUspecializationBS.setSelectedIndex(0); 
            jmbUspecializationMS.setSelectedIndex(0);
            
          
            jlUyrlvl.setVisible(true);
            jmbUyrlvlBS.setVisible(true);
            
        if(jrbUMSIT.isSelected()){
                jmbUyrlvlBS.setVisible(false);
                jmbUyrlvlMS.setVisible(true);
                jlUthesis.setVisible(true);
                jmbUthesis.setVisible(true);
            }
        }else{
            jlUyrlvl.setVisible(false);
            jmbUyrlvlBS.setVisible(false);
            jmbUyrlvlMS.setVisible(false);
            jlUthesis.setVisible(false);
            jmbUthesis.setVisible(false);
        }
        
        //BSCS & MSCS RADIO LISTENER
        if(jrbUBSCS.isSelected() || jrbUMSCS.isSelected()){ 
            
            // CLEARS ALL FIELDS
            jtfUname2.setText(""); 
            jtfUaddress.setText(""); 
            jmbUyrlvlMS.setSelectedIndex(0);
            jmbUyrlvlBS.setSelectedIndex(0);
            jmbUthesis.setSelectedIndex(0); 
            jmbUconcom.setSelectedIndex(0); 
            jmbUspecializationBS.setSelectedIndex(0); 
            jmbUspecializationMS.setSelectedIndex(0);
            
    
            jlUspecialization.setVisible(true);
            jmbUspecializationBS.setVisible(true);   
            
            if(jrbUMSCS.isSelected()){
                jmbUspecializationBS.setVisible(false);  
                jlUconcom.setVisible(true);
                jmbUconcom.setVisible(true);
                jmbUspecializationMS.setVisible(true);
            }
        }
        else{
            jlUspecialization.setVisible(false);
            jmbUspecializationBS.setVisible(false);   
            jmbUspecializationMS.setVisible(false);  
            jlUconcom.setVisible(false);
            jmbUconcom.setVisible(false);   
        }

        
         jlCourseIndicator.setText(jmbCourse.getSelectedItem().toString()+":"); // COURSE INDICATOR   
    }

    @Override
    public void keyTyped(KeyEvent e) {
              
        if(!Character.isLetter(e.getKeyChar())){    
            if(Character.isWhitespace(e.getKeyChar())){
                e.setKeyChar(' ');

            }else{
                 e.setKeyChar('\u0000');   
            }
        }
        

        
     //  e.setKeyChar('\u0000'); // Test so no text can be typed
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
   
    }
      