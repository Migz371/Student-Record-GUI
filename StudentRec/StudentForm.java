package StudentRec;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    private JFrame jfForm,jfTest; // Declaring of jfForm
    private JButton jbOK,jbCancel,jbSave,jbNew; // declares button
    private JLabel jlDisplay; // to be deleted
    
    
    
    /* BUTTONS AND PANELS */
    private JPanel jpAdd,jpSearch;
    private JButton jbAdd,jbSearch; 
    
    
    //Course Picker
    private JMenuBar jmbMenuCommand;
    private JMenu jmAction;
    private JMenuItem jmiAdd,jmiDelete,jmiUpdate,jmiSearch;
    
    
    /* --ADD FIELD-- */
    private JLabel jlName,jlAge,jlAddress,jlGender,jlCourse,jlCourseIndicator,jlYrlvl,jlSpecialization,jlConcom,jlThesis; //Add Student Field 
    private JTextField jtfName,jtfAddress;
    private JRadioButton jrbMale, jrbFemale;
    private ButtonGroup bgGender; // groups radio button
    private JPanel jpGender; // groups every radio button
    private JComboBox jmbAgeBS, jmbAgeMS,jmbCourse,jmbyrlvlMS,jmbspecializationBS,jmbyrlvlBS,jmbspecializationMS,jmbconcom,jmbthesis;
           
    
    
    
    /* --SEARCH FIELD-- */
    private JLabel jlSname,jlSage,jlSaddress,jlScourse,jlSname2; 
    private JTextField jtfSname,jtfSname2,jtfSage,jtfSaddress;
    private JRadioButton jrbSBSIT, jrbSBSCS,jrbSMSCS,jrbSMSIT;
    private ButtonGroup bgScourse; // groups radio button
    private JPanel jpScourse; // groups every radio button
    

    
    
    

    
    
    
    
    private JRadioButton jrbRed, jrbBlue, jrbGreen; // to be deleted
   
    private ButtonGroup bgColor; // to be deleted 
    private JCheckBox jcbBold, jcbItalic;
    private JComboBox jmbFontName; // to be deleted
    private JPanel jpRadio; // groups everything // to be deleted
   
    // to be deleted
    private JMenuBar jmbMenu;
    private JMenu jmMenu;
    private JMenuItem jmiNew,jmiClose;
    
public StudentForm(){
    jfForm = new JFrame("Simple GUID"); // declaration of new GUI
    jbOK = new JButton("OK"); //  declares new button // ("OK") show what is inside button
    jbCancel = new JButton("Cancel");
    jbSave = new JButton("Save");
    jbNew = new JButton("New");
    jlDisplay = new JLabel("Sample");
    
    
    

    //Menu related
    jmbMenuCommand = new JMenuBar();
    jmAction = new JMenu("Select Action");
    jmiAdd = new JMenuItem("Add Student");
    jmiDelete = new JMenuItem("Delete Student");
    jmiUpdate = new JMenuItem("Update Student");
    jmiSearch = new JMenuItem("Search Student");
    
    /*--------- BUTTONS AND PANELS ----------*/
    jbAdd = new JButton("Add Student");
    jpAdd = new JPanel();
    jpSearch = new JPanel();
    jbSearch = new JButton("Search");
    
    
    
    
    
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
    
    //Age Related
    jlSage = new JLabel("Age:");
    jtfSage = new JTextField();
    
    //Course Related
    jlScourse = new JLabel("Select Course:");
    jrbSBSIT = new JRadioButton("BSIT");
    jrbSBSCS = new JRadioButton("BSCS");
    jrbSMSCS = new JRadioButton("MSCS");
    jrbSMSIT = new JRadioButton("MSIT");
    bgScourse = new ButtonGroup();
    jpScourse = new JPanel();
    

    
    
    
    
    jrbRed = new JRadioButton("Red");
    jrbBlue = new JRadioButton("Blue");
    jrbGreen = new JRadioButton("Green");
    bgColor = new ButtonGroup(); 
    jcbBold = new JCheckBox("Bold");
    jcbItalic = new JCheckBox("Italic");
    String[] fName = {"Arial","Algerian","Courier New"}; // to be deleted
    jmbFontName = new JComboBox(fName); //to be delted
    jpRadio = new JPanel();
    jmbMenu = new JMenuBar();
    jmMenu = new JMenu("X23");
    jmiNew = new JMenuItem("New");
    jmiClose = new JMenuItem("Close");
}

public void launch(){
/* //   jfForm.add(jbOK,BorderLayout.NORTH); // puts button on the top
    jfForm.add(jbCancel,BorderLayout.WEST);
    jfForm.add(jbSave,BorderLayout.EAST);
    jfForm.add(jbNew,BorderLayout.NORTH); // tells how your string component will represent your jframe
 //   jfForm.add(jbOK);
    //jfForm.setBounds(100,100,200,200); // setSize and setLocation */
    


   /* jfForm.setLayout(new FlowLayout()); // turns string component to resposive and aligns them
    jfForm.add(jbOK);
    jfForm.add(jbCancel);
    jfForm.add(jbNew);
    jfForm.add(jbSave);
   // jfForm.setLayout(new GridLayout(2,2)); // Puts button to grids */
    
     
   // Positioning of button within the form
   jfForm.setLayout(null); 
 //jfForm.add(jbOK);
   jbOK.setBounds(10, 10, 100, 20); 
   jbCancel.setBounds(120, 10, 100, 20); // Add the X positioning and width
  // jfForm.add(jbCancel);
   jbSave.setBounds(230, 10, 100, 20);
  // jfForm.add(jbSave);
   jbNew.setBounds(340, 10, 100, 20);
  // jfForm.add(jbNew);
   
    jfForm.setSize(500,400); // sets how big the form will be
 //   jfForm.setLocation(200,200); // sets where form will appear on screen
    jfForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminate Program when closed
    jfForm.setLocationRelativeTo(null); // Form will be in center of screen
    jfForm.setVisible(true); // you will be able to see the form
    jfForm.setResizable(false); // will make it unable to resize window
 
 
    jbOK.addActionListener(this); // calls action performed
    jbCancel.addActionListener(this);
    
   
    jlDisplay.setBounds(10,120,200,30);
    //jfForm.add(jlDisplay);
    jlDisplay.setFont(new Font("Algerian",Font.PLAIN,20));
    
     
    
    /* ---------------------ADD FIELD---------------------------*/

    /* Select Course */
    jlCourse.setBounds(4,6,140,20);
    jlCourse.setFont(new Font("Arial",Font.BOLD,15));
    
    //Combo Box
    jmbCourse.setBounds(120,6,60,20);
    jmbCourse.addItemListener(this);
    
    
    
     /* NAME */
    jtfName.setBounds(90,40,200,20); // adds message box for input 
    //jtfName.setForeground(Color.red);
    jlName.setBounds(5,40,100,20);
    jlName.setFont(new Font("Arial",Font.BOLD,15)); //sets text decoration & size
   
    
    
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
    //jtfName.setForeground(Color.red);
    jfForm.add(jtfAddress);
    jlAddress.setBounds(5,145,90,20);
    jlAddress.setFont(new Font("Arial",Font.BOLD,15)); //sets text decoration & size
    
    
    

     /* COURSE INDICATOR */
    jlCourseIndicator.setBounds(5,180,100,20);
    jlCourseIndicator.setFont(new Font("Arial",Font.BOLD,25));
   
    
    
    
     /* BSIT FIELD */
    jlYrlvl.setBounds(5,225,100,20);
    jlYrlvl.setFont(new Font("Arial",Font.BOLD,15));
    jfForm.add(jlYrlvl);
    jmbyrlvlBS.setBounds(100,225,40,20);
  
    
    
    
    /* BSCS FIELD */
    jlSpecialization.setBounds(5,245,150,20);
    jlSpecialization.setFont(new Font("Arial",Font.BOLD,15));
    jfForm.add(jlSpecialization);
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
    jbAdd.setBounds(340, 250, 140, 50); 
    jbAdd.addActionListener(this);

 
    
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
     jpAdd.setLayout(null);
     jpAdd.setBounds(0,20,501,401);
     jfForm.add(jpAdd);
            
            
            
           
    
    
    /* ---------------------SEARCH FIELD---------------------------*/
    
    
    /* SEARCH NAME */
    jlSname.setBounds(4,230,140,20);
    jlSname.setFont(new Font("Arial",Font.BOLD,15));
    jtfSname.setBounds(120,230,200,20);
    
    /* COURSE SELECT */
    jlScourse.setBounds(3,270,140,20);
    jlScourse.setFont(new Font("Arial",Font.BOLD,15)); 
    
    // Course Buttons
    jrbSBSIT.setBounds(0, 0, 55, 20);
    jrbSBSCS.setBounds(55, 0, 60, 20);
    jrbSMSIT.setBounds(0, 20, 55, 20);
    jrbSMSCS.setBounds(55, 20, 60, 20);
    
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

    /* Display */
    jlSname2.setBounds(40, 0, 140, 50);
    jlSname2.setFont(new Font("Arial",Font.BOLD,15));
    jtfSname2.setBounds(200, 10, 230, 30);
    
    jlSage.setBounds(40, 40, 140, 50);
    jlSage.setFont(new Font("Arial",Font.BOLD,15));
    jtfSage.setBounds(200, 50, 230, 30);
    
    jlSaddress.setBounds(40, 80, 140, 50);
    jlSaddress.setFont(new Font("Arial",Font.BOLD,15));
    jtfSaddress.setBounds(200, 90, 230, 30);

    
    
    /*JPANEL GROUP*/
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

    
    
    
    jrbRed.setBounds(0, 0, 100, 20);
    jrbBlue.setBounds(0, 25, 100, 20);
    jrbGreen.setBounds(0, 50, 100, 20);
    
    /*
    jfForm.add(jrbRed);
    jfForm.add(jrbBlue);
    jfForm.add(jrbGreen);
    */
    
    
    // groups radio buttons together 
    bgColor.add(jrbRed);
    bgColor.add(jrbBlue);
    bgColor.add(jrbGreen);
    
    
    // adds shortcut keys combination of alt
    jrbRed.setMnemonic('R');
    jrbGreen.setMnemonic('G');
    jrbBlue.setMnemonic('B');
   
 
    
    
    // for overriding
    jrbRed.addItemListener(this);
    jrbGreen.addItemListener(this);
    jrbBlue.addItemListener(this);
    
    
    
    jpRadio.add(jrbRed);
    jpRadio.add(jrbBlue);
    jpRadio.add(jrbGreen);
    jpRadio.setLayout(null);
    jpRadio.setBounds(220,50,100,70);
    jfForm.add(jpRadio);
 
    
    jcbBold.setBounds(330, 50, 100, 20);
    jcbItalic.setBounds(330, 80, 100, 20);
    jfForm.add(jcbBold);
    jfForm.add(jcbItalic);
    jcbBold.addActionListener(this);
    jcbItalic.addActionListener(this);
   
    
    jmbFontName.setBounds(220, 150, 150, 30);
    jfForm.add(jmbFontName);
    jmbFontName.addItemListener(this);
    

        // Menu bar for picking Action
    jmAction.add(jmiAdd);
    jmAction.add(jmiDelete);
    jmAction.add(jmiUpdate);
    jmAction.add(jmiSearch);
    jmbMenuCommand.add(jmAction);
    jfForm.setJMenuBar(jmbMenuCommand);
    
    jmMenu.add(jmiNew);
    jmMenu.add(jmiClose);
    jmbMenu.add(jmAction);
    jmbMenu.add(jmMenu);
    jfForm.setJMenuBar(jmbMenu);
    
    //Action declaration
    jmiAdd.addActionListener(this);
    jmiDelete.addActionListener(this);
    jmiUpdate.addActionListener(this);
    jmiSearch.addActionListener(this);        
    
    //Temp hidden
     jpRadio.setVisible(false);
     jmbFontName.setVisible(false);
     jcbBold.setVisible(false);
     jcbItalic.setVisible(false);
    
    jmiNew.addActionListener(this);
    jmiClose.addActionListener(this);
    jtfName.addKeyListener(this);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        
         if(jbAdd == e.getSource()){
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
         
        if(jbSearch == e.getSource()){
            
        }
         
        if(jmiAdd == e.getSource()){
            jpSearch.setVisible(false);
            jpAdd.setVisible(true);
            jmbCourse.setSelectedIndex(0);
        }
         
        if(jmiSearch == e.getSource()){
            jpSearch.setVisible(true);
            jpAdd.setVisible(false);
        }

         
         
         
         
       
  
        
        
        if(jbOK == e.getSource()){
            String message = jtfName.getText();
            jlDisplay.setText(message);
            
        }
        
        if(jbCancel == e.getSource()){
            jtfName.setText("");
           // jpRadio.setVisible(false);
            
        }
        
        int fstyle = Font.PLAIN;
        
        if(jcbItalic.isSelected()){
           fstyle += Font.ITALIC;
 
        }
        
        if(jcbBold.isSelected()){
           fstyle += Font.BOLD;

        }
        
         jlDisplay.setFont(new Font(jlDisplay.getFont().getFontName(),fstyle,jlDisplay.getFont().getSize()));
        
         if(jmiNew == e.getSource()){
           jtfName.setText(""); 
           jfForm.setVisible(false);
           jfTest.setVisible(true);
        }
        
         if(jmiClose == e.getSource()){
           System.exit(0); 
        }
        
        
        
        
        }
    
    @Override
    public void itemStateChanged(ItemEvent e){
      
        
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
        
        
        
        
        
        // To make BSIT Field appear // Combo box if example
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
        
        
        
        
        

   
        
        if(jrbRed.isSelected()){
            jlDisplay.setForeground(Color.red);
        }
        
        if(jrbGreen.isSelected()){
            jlDisplay.setForeground(Color.green);
        }
        
        
        if(jrbBlue.isSelected()){
            jlDisplay.setForeground(Color.blue);
            
        }
        
         jlCourseIndicator.setText(jmbCourse.getSelectedItem().toString()+":"); // COURSE INDICATOR



         jlDisplay.setFont(new Font(jmbFontName.getSelectedItem().toString(),jlDisplay.getFont().getStyle(),jlDisplay.getFont().getSize()));
        
        
     
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(!Character.isLetter(e.getKeyChar())){
            e.setKeyChar('\u0000');
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
    
    
    
    }
      
        
        

        
        
        
        
        
        
        
        /*
        String message = jtfMessage.getText();
        if(e.getSource() == jbOK){ //compares address of jbok
            message += "1";
        // System.out.println("FEU");
        }
        
        if(e.getSource() == jbCancel){ //compares address of jbok
            message += "2";
        //      System.out.println("FIT");
        }
        
        jtfMessage.setText(message);
        */
    



