package movie;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

public class GUI extends JFrame {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -4620197810581939100L;
	
	private JSlider slider=new JSlider();
	private BufferedImage imageDraw;
	private static String file = "images/aliens.jpg";
	private JPanel imageArea;
	private String [] filmList = new String [7]; 

	
	@SuppressWarnings("serial")
	public GUI() throws IOException {
		
		JFrame f=new JFrame("Movie Database");
		
		getContentPane().setLayout(new BorderLayout());
		
		final JTabbedPane tp=new JTabbedPane();
		
		f.getContentPane().add(tp);
		
		//////////////////////////////////////////////////////////////////////////
		
		filmList[0] = "Aliens";
		filmList[1] = "Commando";
		filmList[2] = "Die Hard";
		filmList[3] = "Lethal Weapon";
		filmList[4] = "Raiders of The Lost Ark";
		filmList[5] = "Robocop";
		filmList[6] = "Terminator";
		
///////////////////////////////////////////////////////////////////////////////////		
		
		JMenuBar menubar=new JMenuBar();
		JMenu edit=new JMenu("Edit");
		JMenu slideshow=new JMenu("Slideshow");
		menubar.add(edit);
		menubar.add(slideshow);
		
		JMenu addMovie = new JMenu ("Add New Movie...");
		JMenu slideShowStart = new JMenu ("Start Slideshow");
		JMenu slideShowStop = new JMenu ("Stop Slideshow");
		slideShowStop.setEnabled(false);
		
		edit.add(addMovie);
		
		slideshow.add(slideShowStart);
		slideshow.add(slideShowStop);
		
		menubar.add(edit);
		menubar.add(slideshow);
		
		f.setJMenuBar(menubar);
				
///////////////////////////////////////////////////////////////////////////////////
						
		JPanel rb=new JPanel(new GridLayout(1,1));
		
		getContentPane().setLayout(new BorderLayout());
				
		JRadioButton year1 = new JRadioButton("1970-1979");
		JRadioButton year2 = new JRadioButton("1980-1989");
		JRadioButton year3 = new JRadioButton("1990-1999");
		JRadioButton year4 = new JRadioButton("2000-2009");
		JRadioButton year5 = new JRadioButton("2010-2019");
		
		JPanel button = new JPanel();
		
		button.add(year1);
		button.add(year2);
		button.add(year3);
		button.add(year4);
		button.add(year5);
		
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(year1);
		bg.add(year2);
		bg.add(year3);
		bg.add(year4);
		bg.add(year5);
		
		
		rb.add(button);
		
		ActionListener blis = new ActionListener () {
						
			@Override
			public void actionPerformed(ActionEvent e) {
								
				tp.removeAll();

				if (((JRadioButton) e.getSource()).getText().equals("1970-1979") == true)
				{
					  
			      	JTabbedPane tp1=new JTabbedPane();
						
			  		imageArea = new JPanel (){
			  		 protected void paintComponent(Graphics g) {
			  	         g.drawImage(imageDraw, 0, 0, getWidth(), getHeight(), this);
			  	     }
			  	    };
			  	    try {
							imageDraw = ImageIO.read (new File (file));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			  					  	    			  	    
			  		tp1.addTab("Poster", imageArea);
			  	    
			  		JPanel plot1 = new JPanel (new GridLayout (1,1));
			  		
			  	    JTextArea plotText1 = new JTextArea(
			  	    "Fifty seven years after Ellen Ripley survived her disastrous ordeal," +
			  	    "her escape vessel is recovered after drifting across the galaxy " +
			  	    "as she slept in cryogenic stasis. Back on earth, nobody believed " +
			  	    "her story about the Aliens on the planet LV-426. After the Company " +
			  	    "orders the colony on LV-426 to investigate, however, all communication " +
			  	    "with the colony is lost. The Company enlists Ripley to aid a team of " +
			  	    "tough, rugged space marines on a rescue mission to the now partially " +
			  	    "terraformed planet to find out if there are aliens or survivors. " +
			  	    "As the mission unfolds, Ripley will be forced to come to grips with " +
			  	    "her worst nightmare, but even as she does, she finds that the worst " +
			  	    "is yet to come.");
			  	    
			  	    plotText1.setFont(new Font("Serif", Font.ITALIC, 16));
			  	    plotText1.setLineWrap(true);
			  	    plotText1.setWrapStyleWord(true);
			  	    
			  	    plot1.add(plotText1);
			  		
			  		JPanel p1=new JPanel(new GridLayout(3,2));
			  		
			  		JLabel year = new JLabel("Year");
			  		JLabel starring = new JLabel("Starring");
			  		JLabel rtime = new JLabel("Running Time (Minutes)");
			  		
			  		JTextField yearDisp = new JTextField("1979");
			  		yearDisp.setBackground(Color.WHITE);
			  		yearDisp.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			  		
			  		JTextField starringDisp = new JTextField(" Tom Skerritt, Veronica Cartwright");
			  		starringDisp.setBackground(Color.WHITE);
			  		starringDisp.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			  		
			  		JTextField rtimeDisp = new JTextField("117");
			  		rtimeDisp.setBackground(Color.WHITE);
			  		rtimeDisp.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			  						
			  		p1.add(year);
			  		p1.add(yearDisp);
			  		p1.add(starring);
			  		p1.add(starringDisp);
			  		p1.add(rtime);
			  		p1.add(rtimeDisp);
			  		
			  		tp1.add("Details",p1);
			  		tp.addTab("Aliens",tp1);
			  		tp1.addTab("Plot",plot1);

				}
				
				else if (((JRadioButton) e.getSource()).getText().equals("1980-1989") == true)
				{
					 final JTabbedPane tp2=new JTabbedPane();

			         imageArea = new JPanel (){
			  		 protected void paintComponent(Graphics g) {
			  	         try {
							g.drawImage(ImageIO.read (new File ("images/commando.jpg")), 0, 0, getWidth(), getHeight(), this);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			  	     }
			  	    };
			  	   			  	   		
			  		tp2.addTab("Poster", imageArea);
			  	    
			  		JPanel plot2 = new JPanel (new GridLayout (1,1));
			  	    JTextArea plotText2 = new JTextArea(
			  	    " A retired elite Black Ops Commando launches a one man war " +
			  	    " against a group of South American criminals who have kidnapped " +
			  	    " his daughter to blackmail him into starting a revolution and " +
			  	    " getting an exiled dictator back into power.");
			  	    
			  	    plotText2.setFont(new Font("Serif", Font.ITALIC, 16));
			  	    plotText2.setLineWrap(true);
			  	    plotText2.setWrapStyleWord(true);
			  	    
			  	    plot2.add(plotText2);
			  		
			          JPanel p2=new JPanel(new GridLayout(3,2));
			  		
			  		JLabel year21 = new JLabel("Year");
			  		JLabel starring2 = new JLabel("Starring");
			  		JLabel rtime2 = new JLabel("Running Time (Minutes)");
			  		
			  		JTextField yearDisp2 = new JTextField("1985");
			  		yearDisp2.setBackground(Color.WHITE);
			  		yearDisp2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			  		
			  		JTextField starringDisp2 = new JTextField("  Arnold Schwarzenegger" ); 
			  				
			  		starringDisp2.setBackground(Color.WHITE);
			  		starringDisp2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			  		
			  		JTextField rtimeDisp2 = new JTextField("92");
			  		rtimeDisp2.setBackground(Color.WHITE);
			  		rtimeDisp2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			  						
			  		p2.add(year21);
			  		p2.add(yearDisp2);
			  		p2.add(starring2);
			  		p2.add(starringDisp2);
			  		p2.add(rtime2);
			  		p2.add(rtimeDisp2);
			  		
			  		tp2.add("Details",p2);
			  		tp.addTab("Commando",tp2);
			  		tp2.addTab("Plot",plot2);
			  		
	//-----------------------------------------------------------------------------------------------------
			  		
			  		final JTabbedPane tp3=new JTabbedPane();

			         imageArea = new JPanel (){
			  		 protected void paintComponent(Graphics g) {
			  	         try {
							g.drawImage(ImageIO.read (new File ("images/die hard.jpg")), 0, 0, getWidth(), getHeight(), this);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			  	     }
			  	    };
			  	        	    
			     		tp3.addTab("Poster", imageArea);
			     	    
			     		JPanel plot3 = new JPanel (new GridLayout (1,1));
			     	    JTextArea plotText3 = new JTextArea(
			     	    " John McClane, officer of the NYPD, tries to save wife " +
			     	    "Holly Gennaro and several others, taken hostage by German " +
			     	    "terrorist Hans Gruber during a Christmas party at the Nakatomi " +
			     	    "Plaza in Los Angeles. ");
			     	    
			     	    plotText3.setFont(new Font("Serif", Font.ITALIC, 16));
			     	    plotText3.setLineWrap(true);
			     	    plotText3.setWrapStyleWord(true);
			     	    
			     	    plot3.add(plotText3);
			     		
			             JPanel p3=new JPanel(new GridLayout(3,2));
			     		
			     		JLabel year31 = new JLabel("Year");
			     		JLabel starring3 = new JLabel("Starring");
			     		JLabel rtime3 = new JLabel("Running Time (Minutes)");
			     		
			     		JTextField yearDisp3 = new JTextField("1988");
			     		yearDisp3.setBackground(Color.WHITE);
			     		yearDisp3.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			     		
			     		JTextField starringDisp3 = new JTextField("Bruce Willis, Alan Rickman" ); 
			     				
			     		starringDisp2.setBackground(Color.WHITE);
			     		starringDisp2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			     		
			     		JTextField rtimeDisp3 = new JTextField("132");
			     		rtimeDisp3.setBackground(Color.WHITE);
			     		rtimeDisp3.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			     						
			     		p3.add(year31);
			     		p3.add(yearDisp3);
			     		p3.add(starring3);
			     		p3.add(starringDisp3);
			     		p3.add(rtime3);
			     		p3.add(rtimeDisp3);
			     		
			     		tp3.add("Details",p3);
			     		tp.addTab("Die Hard",tp3);
			     		tp3.addTab("Plot",plot3);

			  //-----------------------------------------------------------------------------
			  		
			     		final JTabbedPane tp4=new JTabbedPane();

				         imageArea = new JPanel (){
				  		 protected void paintComponent(Graphics g) {
				  	         try {
								g.drawImage(ImageIO.read (new File ("images/lethal weapon.jpg")), 0, 0, getWidth(), getHeight(), this);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				  	     }
				  	    };
				  	    
			        		tp4.addTab("Poster", imageArea);
			        	    
			        		JPanel plot4 = new JPanel (new GridLayout (1,1));
			        	    JTextArea plotText4 = new JTextArea(
			        	    " A veteran cop, Murtaugh, is partnered with a young suicidal cop," +
			        	    "Riggs. Both having one thing in common; hating working in pairs." +
			        	    "Now they must learn to work with one another to stop a gang of drug smugglers. ");
			        	    
			        	    plotText4.setFont(new Font("Serif", Font.ITALIC, 16));
			        	    plotText4.setLineWrap(true);
			        	    plotText4.setWrapStyleWord(true);
			        	    
			        	    plot4.add(plotText4);
			        		
			                JPanel p4=new JPanel(new GridLayout(3,2));
			        		
			        		JLabel year41 = new JLabel("Year");
			        		JLabel starring4 = new JLabel("Starring");
			        		JLabel rtime4 = new JLabel("Running Time (Minutes)");
			        		
			        		JTextField yearDisp4 = new JTextField("1987");
			        		yearDisp4.setBackground(Color.WHITE);
			        		yearDisp4.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			        		
			        		JTextField starringDisp4 = new JTextField("Mel Gibson, Danny Glover" ); 
			        				
			        		starringDisp4.setBackground(Color.WHITE);
			        		starringDisp4.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			        		
			        		JTextField rtimeDisp4 = new JTextField("110");
			        		rtimeDisp4.setBackground(Color.WHITE);
			        		rtimeDisp4.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			        						
			        		p4.add(year41);
			        		p4.add(yearDisp4);
			        		p4.add(starring4);
			        		p4.add(starringDisp4);
			        		p4.add(rtime4);
			        		p4.add(rtimeDisp4);
			        		
			        		tp4.add("Details",p4);
			        		tp.addTab("Lethal Weapon",tp4);
			        		tp4.addTab("Plot",plot4);

			  //-----------------------------------------------------------------------------
			  		
			        		final JTabbedPane tp5=new JTabbedPane();

					         imageArea = new JPanel (){
					  		 protected void paintComponent(Graphics g) {
					  	         try {
									g.drawImage(ImageIO.read (new File ("images/raiders of the lost ark.jpg")), 0, 0, getWidth(), getHeight(), this);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					  	     }
					  	    };
					  	    			       	    
			       		tp5.addTab("Poster", imageArea);
			       	    
			       		JPanel plot5 = new JPanel (new GridLayout (1,1));
			       	    JTextArea plotText5 = new JTextArea(
			       	    " Archeologist and adventurer Indiana Jones is hired by the US " +
			       	    "government to find the Ark of the Covenant before the Nazis. ");
			       	    
			       	    plotText5.setFont(new Font("Serif", Font.ITALIC, 16));
			       	    plotText5.setLineWrap(true);
			       	    plotText5.setWrapStyleWord(true);
			       	    
			       	    plot5.add(plotText5);
			       		
			               JPanel p5=new JPanel(new GridLayout(3,2));
			       		
			       		JLabel year51 = new JLabel("Year");
			       		JLabel starring5 = new JLabel("Starring");
			       		JLabel rtime5 = new JLabel("Running Time (Minutes)");
			       		
			       		JTextField yearDisp5 = new JTextField("1981");
			       		yearDisp5.setBackground(Color.WHITE);
			       		yearDisp5.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			       		
			       		JTextField starringDisp5 = new JTextField("Harrison Ford, Karen Allen" ); 
			       				
			       		starringDisp5.setBackground(Color.WHITE);
			       		starringDisp5.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			       		
			       		JTextField rtimeDisp5 = new JTextField("115");
			       		rtimeDisp5.setBackground(Color.WHITE);
			       		rtimeDisp5.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			       						
			       		p5.add(year51);
			       		p5.add(yearDisp5);
			       		p5.add(starring5);
			       		p5.add(starringDisp5);
			       		p5.add(rtime5);
			       		p5.add(rtimeDisp5);
			       		
			       		tp5.add("Details",p5);
			       		tp.addTab("Riders of the lost Ark",tp5);
			       		tp5.addTab("Plot",plot5);

				       }
				      else if (((JRadioButton) e.getSource()).getText().equals("1990-1999") == true)
				      {
					 final JTabbedPane tp8=new JTabbedPane();

			         imageArea = new JPanel (){
			  		 protected void paintComponent(Graphics g) {
			  	         try {
							g.drawImage(ImageIO.read (new File ("images/beethoven.jpg")), 0, 0, getWidth(), getHeight(), this);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			  	     }
			  	    };
			  	    
			  		tp8.addTab("Poster", imageArea);
			  	    
			  		JPanel plot8 = new JPanel (new GridLayout (1,1));
			  	    JTextArea plotText8 = new JTextArea(
			  	    " A slobbering St. Bernard becomes the center of attention for a loving family," +
			  	    "but its veterinarian secretly wants to kill him.");
			  	    
			  	    plotText8.setFont(new Font("Serif", Font.ITALIC, 16));
			  	    plotText8.setLineWrap(true);
			  	    plotText8.setWrapStyleWord(true);
			  	    
			  	    plot8.add(plotText8);
			  		
			          JPanel p8=new JPanel(new GridLayout(3,2));
			  		
			  		JLabel year81 = new JLabel("Year");
			  		JLabel starring8 = new JLabel("Starring");
			  		JLabel rtime8 = new JLabel("Running Time (Minutes)");
			  		
			  		JTextField yearDisp8 = new JTextField("1992");
			  		yearDisp8.setBackground(Color.WHITE);
			  		yearDisp8.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			  		
			  		JTextField starringDisp8 = new JTextField("Charles Grodin, Bonnie Hunt" ); 
			  				
			  		starringDisp8.setBackground(Color.WHITE);
			  		starringDisp8.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			  		
			  		JTextField rtimeDisp8 = new JTextField("87");
			  		rtimeDisp8.setBackground(Color.WHITE);
			  		rtimeDisp8.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			  						
			  		p8.add(year81);
			  		p8.add(yearDisp8);
			  		p8.add(starring8);
			  		p8.add(starringDisp8);
			  		p8.add(rtime8);
			  		p8.add(rtimeDisp8);
			  		
			  		tp8.add("Details",p8);
			  		tp.addTab("Beethoven",tp8);
			  		tp8.addTab("Plot",plot8);
			  		
			  		
				}
				else if (((JRadioButton) e.getSource()).getText().equals("2000-2009") == true)
				{
					 final JTabbedPane tp9=new JTabbedPane();

			         imageArea = new JPanel (){
			  		 protected void paintComponent(Graphics g) {
			  	         try {
							g.drawImage(ImageIO.read (new File ("images/troy.jpg")), 0, 0, getWidth(), getHeight(), this);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			  	     }
			  	    };
			  	    
			  		tp9.addTab("Poster", imageArea);
			  	    
			  		JPanel plot9 = new JPanel (new GridLayout (1,1));
			  	    JTextArea plotText9 = new JTextArea(
			  	    " An adaptation of Homer's great epic, the film follows the assault on Troy " +
			  	    "by the united Greek forces and chronicles the fates of the men involved.");
			  	    
			  	    plotText9.setFont(new Font("Serif", Font.ITALIC, 16));
			  	    plotText9.setLineWrap(true);
			  	    plotText9.setWrapStyleWord(true);
			  	    
			  	    plot9.add(plotText9);
			  		
			          JPanel p9=new JPanel(new GridLayout(3,2));
			  		
			  		JLabel year91 = new JLabel("Year");
			  		JLabel starring9 = new JLabel("Starring");
			  		JLabel rtime9 = new JLabel("Running Time (Minutes)");
			  		
			  		JTextField yearDisp9 = new JTextField("2004");
			  		yearDisp9.setBackground(Color.WHITE);
			  		yearDisp9.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			  		
			  		JTextField starringDisp9 = new JTextField("Brad Pitt, Eric Bana, Orlando Bloom" ); 
			  				
			  		starringDisp9.setBackground(Color.WHITE);
			  		starringDisp9.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			  		
			  		JTextField rtimeDisp9 = new JTextField("163");
			  		rtimeDisp9.setBackground(Color.WHITE);
			  		rtimeDisp9.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			  						
			  		p9.add(year91);
			  		p9.add(yearDisp9);
			  		p9.add(starring9);
			  		p9.add(starringDisp9);
			  		p9.add(rtime9);
			  		p9.add(rtimeDisp9);
			  		
			  		tp9.add("Details",p9);
			  		tp.addTab("Troy",tp9);
			  		tp9.addTab("Plot",plot9);
			  		
			  		
				}
				 
				else if (((JRadioButton) e.getSource()).getText().equals("2010-2019") == true)
				{
					 final JTabbedPane tp10=new JTabbedPane();

			         imageArea = new JPanel (){
			  		 protected void paintComponent(Graphics g) {
			  	         try {
							g.drawImage(ImageIO.read (new File ("images/side effects.jpg")), 0, 0, getWidth(), getHeight(), this);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			  	     }
			  	    };
			  	    
			  		tp10.addTab("Poster", imageArea);
			  	    
			  		JPanel plot10 = new JPanel (new GridLayout (1,1));
			  	    JTextArea plotText10 = new JTextArea(
			  	    " A young woman's world unravels when a drug prescribed by her psychiatrist " +
			  	    "has unexpected side effects.");
			  	    
			  	    plotText10.setFont(new Font("Serif", Font.ITALIC, 16));
			  	    plotText10.setLineWrap(true);
			  	    plotText10.setWrapStyleWord(true);
			  	    
			  	    plot10.add(plotText10);
			  		
			          JPanel p10=new JPanel(new GridLayout(3,2));
			  		
			  		JLabel year10 = new JLabel("Year");
			  		JLabel starring10 = new JLabel("Starring");
			  		JLabel rtime10 = new JLabel("Running Time (Minutes)");
			  		
			  		JTextField yearDisp10 = new JTextField("2013");
			  		yearDisp10.setBackground(Color.WHITE);
			  		yearDisp10.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			  		
			  		JTextField starringDisp10 = new JTextField("Rooney Mara, Channing Tatum, Jude Law" ); 
			  				
			  		starringDisp10.setBackground(Color.WHITE);
			  		starringDisp10.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			  		
			  		JTextField rtimeDisp10 = new JTextField("106");
			  		rtimeDisp10.setBackground(Color.WHITE);
			  		rtimeDisp10.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			  						
			  		p10.add(year10);
			  		p10.add(yearDisp10);
			  		p10.add(starring10);
			  		p10.add(starringDisp10);
			  		p10.add(rtime10);
			  		p10.add(rtimeDisp10);
			  		
			  		tp10.add("Details",p10);
			  		tp.addTab("Side Effects",tp10);
			  		tp10.addTab("Plot",plot10);
			  		
			  		
	//-------------------------------------------------------------------------------------------------			
					
					 final JTabbedPane tp6=new JTabbedPane();

			         imageArea = new JPanel (){
			  		 protected void paintComponent(Graphics g) {
			  	         try {
							g.drawImage(ImageIO.read (new File ("images/robocop.jpg")), 0, 0, getWidth(), getHeight(), this);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			  	     }
			  	    };
			  	    	    
			      		tp6.addTab("Poster", imageArea);
			      	    
			      		JPanel plot6 = new JPanel (new GridLayout (1,1));
			      	    JTextArea plotText6 = new JTextArea(
			      	    " In 2028 Detroit, when Alex Murphy - a loving husband, father and " +
			      	    "good cop - is critically injured in the line of duty, the " +
			      	    "multinational conglomerate OmniCorp sees their chance for a part-man, " +
			      	    "part-robot police officer. ");
			      	    
			      	    plotText6.setFont(new Font("Serif", Font.ITALIC, 16));
			      	    plotText6.setLineWrap(true);
			      	    plotText6.setWrapStyleWord(true);
			      	    
			      	    plot6.add(plotText6);
			      		
			              JPanel p6=new JPanel(new GridLayout(3,2));
			      		
			      		JLabel year61 = new JLabel("Year");
			      		JLabel starring6 = new JLabel("Starring");
			      		JLabel rtime6 = new JLabel("Running Time (Minutes)");
			      		
			      		JTextField yearDisp6 = new JTextField("2014");
			      		yearDisp6.setBackground(Color.WHITE);
			      		yearDisp6.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			      		
			      		JTextField starringDisp6 = new JTextField("Joel Kinnaman, Gary Oldman" ); 
			      				
			      		starringDisp6.setBackground(Color.WHITE);
			      		starringDisp6.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			      		
			      		JTextField rtimeDisp6 = new JTextField("117");
			      		rtimeDisp6.setBackground(Color.WHITE);
			      		rtimeDisp6.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			      						
			      		p6.add(year61);
			      		p6.add(yearDisp6);
			      		p6.add(starring6);
			      		p6.add(starringDisp6);
			      		p6.add(rtime6);
			      		p6.add(rtimeDisp6);
			      		
			      		tp6.add("Details",p6);
			      		tp.addTab("Robocop",tp6);
			      		tp6.addTab("Plot",plot6);	
					
				}

				revalidate();
				repaint();
			}
		};
		//////////////////////////////////////////////////////////////////////////////////////////////////////
      	JTabbedPane tp1=new JTabbedPane();
			
  		imageArea = new JPanel (){
  		 protected void paintComponent(Graphics g) {
  	         g.drawImage(imageDraw, 0, 0, getWidth(), getHeight(), this);
  	     }
  	    };
  	    
   	    try {
				imageDraw = ImageIO.read (new File (file));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
  		
  	    
  		tp1.addTab("Poster", imageArea);
  	    
  		JPanel plot1 = new JPanel (new GridLayout (1,1));
  		
  	    JTextArea plotText1 = new JTextArea(
  	    "Fifty seven years after Ellen Ripley survived her disastrous ordeal," +
  	    "her escape vessel is recovered after drifting across the galaxy " +
  	    "as she slept in cryogenic stasis. Back on earth, nobody believed " +
  	    "her story about the Aliens on the planet LV-426. After the Company " +
  	    "orders the colony on LV-426 to investigate, however, all communication " +
  	    "with the colony is lost. The Company enlists Ripley to aid a team of " +
  	    "tough, rugged space marines on a rescue mission to the now partially " +
  	    "terraformed planet to find out if there are aliens or survivors. " +
  	    "As the mission unfolds, Ripley will be forced to come to grips with " +
  	    "her worst nightmare, but even as she does, she finds that the worst " +
  	    "is yet to come.");
  	    
  	    plotText1.setFont(new Font("Serif", Font.ITALIC, 16));
  	    plotText1.setLineWrap(true);
  	    plotText1.setWrapStyleWord(true);
  	    
  	    plot1.add(plotText1);
  		
  		JPanel p1=new JPanel(new GridLayout(3,2));
  		
  		JLabel year = new JLabel("Year");
  		JLabel starring = new JLabel("Starring");
  		JLabel rtime = new JLabel("Running Time (Minutes)");
  		
  		JTextField yearDisp = new JTextField("1986");
  		yearDisp.setBackground(Color.WHITE);
  		yearDisp.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
  		
  		JTextField starringDisp = new JTextField(" Tom Skerritt, Veronica Cartwright");
  		starringDisp.setBackground(Color.WHITE);
  		starringDisp.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
  		
  		JTextField rtimeDisp = new JTextField("154");
  		rtimeDisp.setBackground(Color.WHITE);
  		rtimeDisp.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
  						
  		p1.add(year);
  		p1.add(yearDisp);
  		p1.add(starring);
  		p1.add(starringDisp);
  		p1.add(rtime);
  		p1.add(rtimeDisp);
  		
  		tp1.add("Details",p1);
  		tp.addTab("Aliens",tp1);
  		tp1.addTab("Plot",plot1);

  	//-----------------------------------------------------------------
  	
         final JTabbedPane tp2=new JTabbedPane();
  		
         imageArea = new JPanel (){
  		 protected void paintComponent(Graphics g) {
  	         g.drawImage(imageDraw, 0, 0, getWidth(), getHeight(), this);
  	     }
  	    };
  	    	  
  		tp2.addTab("Poster", imageArea);
  	    
  		JPanel plot2 = new JPanel (new GridLayout (1,1));
  	    JTextArea plotText2 = new JTextArea(
  	    " A retired elite Black Ops Commando launches a one man war " +
  	    " against a group of South American criminals who have kidnapped " +
  	    " his daughter to blackmail him into starting a revolution and " +
  	    " getting an exiled dictator back into power.");
  	    
  	    plotText2.setFont(new Font("Serif", Font.ITALIC, 16));
  	    plotText2.setLineWrap(true);
  	    plotText2.setWrapStyleWord(true);
  	    
  	    plot2.add(plotText2);
  		
          JPanel p2=new JPanel(new GridLayout(3,2));
  		
  		JLabel year21 = new JLabel("Year");
  		JLabel starring2 = new JLabel("Starring");
  		JLabel rtime2 = new JLabel("Running Time (Minutes)");
  		
  		JTextField yearDisp2 = new JTextField("1985");
  		yearDisp.setBackground(Color.WHITE);
  		yearDisp.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
  		
  		JTextField starringDisp2 = new JTextField("  Arnold Schwarzenegger" ); 
  				
  		starringDisp2.setBackground(Color.WHITE);
  		starringDisp2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
  		
  		JTextField rtimeDisp2 = new JTextField("92");
  		rtimeDisp2.setBackground(Color.WHITE);
  		rtimeDisp2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
  						
  		p2.add(year21);
  		p2.add(yearDisp2);
  		p2.add(starring2);
  		p2.add(starringDisp2);
  		p2.add(rtime2);
  		p2.add(rtimeDisp2);
  		
  		tp2.add("Details",p2);
  		tp.addTab("Commando",tp2);
  		tp2.addTab("Plot",plot2);

  //-----------------------------------------------------------------------------
  		
          JTabbedPane tp3=new JTabbedPane();
  		
            imageArea = new JPanel (){
     		 protected void paintComponent(Graphics g) {
     	         g.drawImage(imageDraw, 0, 0, getWidth(), getHeight(), this);
     	     }
     	    };
     	 
     		tp3.addTab("Poster", imageArea);
     	    
     		JPanel plot3 = new JPanel (new GridLayout (1,1));
     	    JTextArea plotText3 = new JTextArea(
     	    " John McClane, officer of the NYPD, tries to save wife " +
     	    "Holly Gennaro and several others, taken hostage by German " +
     	    "terrorist Hans Gruber during a Christmas party at the Nakatomi " +
     	    "Plaza in Los Angeles. ");
     	    
     	    plotText3.setFont(new Font("Serif", Font.ITALIC, 16));
     	    plotText3.setLineWrap(true);
     	    plotText3.setWrapStyleWord(true);
     	    
     	    plot3.add(plotText3);
     		
             JPanel p3=new JPanel(new GridLayout(3,2));
     		
     		JLabel year31 = new JLabel("Year");
     		JLabel starring3 = new JLabel("Starring");
     		JLabel rtime3 = new JLabel("Running Time (Minutes)");
     		
     		JTextField yearDisp3 = new JTextField("1988");
     		yearDisp.setBackground(Color.WHITE);
     		yearDisp.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
     		
     		JTextField starringDisp3 = new JTextField("Bruce Willis, Alan Rickman" ); 
     				
     		starringDisp2.setBackground(Color.WHITE);
     		starringDisp2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
     		
     		JTextField rtimeDisp3 = new JTextField("132");
     		rtimeDisp3.setBackground(Color.WHITE);
     		rtimeDisp3.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
     						
     		p3.add(year31);
     		p3.add(yearDisp3);
     		p3.add(starring3);
     		p3.add(starringDisp3);
     		p3.add(rtime3);
     		p3.add(rtimeDisp3);
     		
     		tp3.add("Details",p3);
     		tp.addTab("Die Hard",tp3);
     		tp3.addTab("Plot",plot3);

  //-----------------------------------------------------------------------------
  		
          JTabbedPane tp4=new JTabbedPane();
  		
          imageArea = new JPanel (){
        		 protected void paintComponent(Graphics g) {
        	         g.drawImage(imageDraw, 0, 0, getWidth(), getHeight(), this);
        	     }
        	    };
        	
        		tp4.addTab("Poster", imageArea);
        	    
        		JPanel plot4 = new JPanel (new GridLayout (1,1));
        	    JTextArea plotText4 = new JTextArea(
        	    " A veteran cop, Murtaugh, is partnered with a young suicidal cop," +
        	    "Riggs. Both having one thing in common; hating working in pairs." +
        	    "Now they must learn to work with one another to stop a gang of drug smugglers. ");
        	    
        	    plotText4.setFont(new Font("Serif", Font.ITALIC, 16));
        	    plotText4.setLineWrap(true);
        	    plotText4.setWrapStyleWord(true);
        	    
        	    plot4.add(plotText4);
        		
                JPanel p4=new JPanel(new GridLayout(3,2));
        		
        		JLabel year41 = new JLabel("Year");
        		JLabel starring4 = new JLabel("Starring");
        		JLabel rtime4 = new JLabel("Running Time (Minutes)");
        		
        		JTextField yearDisp4 = new JTextField("1987");
        		yearDisp.setBackground(Color.WHITE);
        		yearDisp.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        		
        		JTextField starringDisp4 = new JTextField("Mel Gibson, Danny Glover" ); 
        				
        		starringDisp4.setBackground(Color.WHITE);
        		starringDisp4.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        		
        		JTextField rtimeDisp4 = new JTextField("110");
        		rtimeDisp4.setBackground(Color.WHITE);
        		rtimeDisp4.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        						
        		p4.add(year41);
        		p4.add(yearDisp4);
        		p4.add(starring4);
        		p4.add(starringDisp4);
        		p4.add(rtime4);
        		p4.add(rtimeDisp4);
        		
        		tp4.add("Details",p4);
        		tp.addTab("Lethal Weapon",tp4);
        		tp4.addTab("Plot",plot4);

  //-----------------------------------------------------------------------------
  		
          JTabbedPane tp5=new JTabbedPane();
  		
          imageArea = new JPanel (){
       		 protected void paintComponent(Graphics g) {
       	         g.drawImage(imageDraw, 0, 0, getWidth(), getHeight(), this);
       	     }
       	    };
       	          	    
       		tp5.addTab("Poster", imageArea);
       	    
       		JPanel plot5 = new JPanel (new GridLayout (1,1));
       	    JTextArea plotText5 = new JTextArea(
       	    " Archeologist and adventurer Indiana Jones is hired by the US " +
       	    "government to find the Ark of the Covenant before the Nazis. ");
       	    
       	    plotText5.setFont(new Font("Serif", Font.ITALIC, 16));
       	    plotText5.setLineWrap(true);
       	    plotText5.setWrapStyleWord(true);
       	    
       	    plot5.add(plotText5);
       		
            JPanel p5=new JPanel(new GridLayout(3,2));
       		
       		JLabel year51 = new JLabel("Year");
       		JLabel starring5 = new JLabel("Starring");
       		JLabel rtime5 = new JLabel("Running Time (Minutes)");
       		
       		JTextField yearDisp5 = new JTextField("1981");
       		yearDisp5.setBackground(Color.WHITE);
       		yearDisp5.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
       		
       		JTextField starringDisp5 = new JTextField("Harrison Ford, Karen Allen" ); 
       				
       		starringDisp5.setBackground(Color.WHITE);
       		starringDisp5.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
       		
       		JTextField rtimeDisp5 = new JTextField("115");
       		rtimeDisp5.setBackground(Color.WHITE);
       		rtimeDisp5.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
       						
       		p5.add(year51);
       		p5.add(yearDisp5);
       		p5.add(starring5);
       		p5.add(starringDisp5);
       		p5.add(rtime5);
       		p5.add(rtimeDisp5);
       		
       		tp5.add("Details",p5);
       		tp.addTab("Riders of the lost Ark",tp5);
       		tp5.addTab("Plot",plot5);

  //-----------------------------------------------------------------------------
  		
          JTabbedPane tp6=new JTabbedPane();
  		
          imageArea = new JPanel (){
      		 protected void paintComponent(Graphics g) {
      	         g.drawImage(imageDraw, 0, 0, getWidth(), getHeight(), this);
      	     }
      	    };
      	          	         
      		tp6.addTab("Poster", imageArea);
      	    
      		JPanel plot6 = new JPanel (new GridLayout (1,1));
      	    JTextArea plotText6 = new JTextArea(
      	    " In 2028 Detroit, when Alex Murphy - a loving husband, father and " +
      	    "good cop - is critically injured in the line of duty, the " +
      	    "multinational conglomerate OmniCorp sees their chance for a part-man, " +
      	    "part-robot police officer. ");
      	    
      	    plotText6.setFont(new Font("Serif", Font.ITALIC, 16));
      	    plotText6.setLineWrap(true);
      	    plotText6.setWrapStyleWord(true);
      	    
      	    plot6.add(plotText6);
      		
              JPanel p6=new JPanel(new GridLayout(3,2));
      		
      		JLabel year61 = new JLabel("Year");
      		JLabel starring6 = new JLabel("Starring");
      		JLabel rtime6 = new JLabel("Running Time (Minutes)");
      		
      		JTextField yearDisp6 = new JTextField("2014");
      		yearDisp6.setBackground(Color.WHITE);
      		yearDisp6.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
      		
      		JTextField starringDisp6 = new JTextField("Joel Kinnaman, Gary Oldman" ); 
      				
      		starringDisp6.setBackground(Color.WHITE);
      		starringDisp6.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
      		
      		JTextField rtimeDisp6 = new JTextField("117");
      		rtimeDisp6.setBackground(Color.WHITE);
      		rtimeDisp6.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
      						
      		p6.add(year61);
      		p6.add(yearDisp6);
      		p6.add(starring6);
      		p6.add(starringDisp6);
      		p6.add(rtime6);
      		p6.add(rtimeDisp6);
      		
      		tp6.add("Details",p6);
      		tp.addTab("Robocop",tp6);
      		tp6.addTab("Plot",plot6);

  //-----------------------------------------------------------------------------
  		
          JTabbedPane tp7=new JTabbedPane();
  		
          imageArea = new JPanel (){
     		 protected void paintComponent(Graphics g) {
     	         g.drawImage(imageDraw, 0, 0, getWidth(), getHeight(), this);
     	     }
     	    };
     	  
     		tp7.addTab("Poster", imageArea);
     	    
     		JPanel plot7 = new JPanel (new GridLayout (1,1));
     	    JTextArea plotText7 = new JTextArea(
     	    " A human-looking indestructible cyborg is sent from 2029 to 1984 " +
     	    "to assassinate a waitress, whose unborn son will lead humanity " +
     	    "in a war against the machines, while a soldier from that war is " +
     	    "sent to protect her at all costs. ");
     	    
     	    plotText7.setFont(new Font("Serif", Font.ITALIC, 16));
     	    plotText7.setLineWrap(true);
     	    plotText7.setWrapStyleWord(true);
     	    
     	    plot7.add(plotText7);
     		
             JPanel p7=new JPanel(new GridLayout(3,2));
     		
     		JLabel year71 = new JLabel("Year");
     		JLabel starring7 = new JLabel("Starring");
     		JLabel rtime7 = new JLabel("Running Time (Minutes)");
     		
     		JTextField yearDisp7 = new JTextField("1984");
     		yearDisp7.setBackground(Color.WHITE);
     		yearDisp7.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
     		
     		JTextField starringDisp7 = new JTextField("Arnold Schwarzenegger" ); 
     				
     		starringDisp7.setBackground(Color.WHITE);
     		starringDisp7.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
     		
     		JTextField rtimeDisp7 = new JTextField("107");
     		rtimeDisp7.setBackground(Color.WHITE);
     		rtimeDisp7.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
     						
     		p7.add(year71);
     		p7.add(yearDisp7);
     		p7.add(starring7);
     		p7.add(starringDisp7);
     		p7.add(rtime7);
     		p7.add(rtimeDisp7);
     		
     		tp7.add("Details",p7);
     		tp.addTab("The Terminator",tp7);
     		tp7.addTab("Plot",plot7);
     		
     		tp.setTabPlacement(JTabbedPane.RIGHT);
     		
/////////////////////////////////////////////////////////////////////////////////////////
     	  		
     	
  	
  		year1.setSelected(true);
		year1.addActionListener(blis);
		year2.addActionListener(blis);
		year3.addActionListener(blis);
		year4.addActionListener(blis);
		year5.addActionListener(blis);	
		
  				
		f.getContentPane().add(rb,BorderLayout.NORTH);
		
	
////////////////////////////////////////////////////////////////////////////////////////////////////	
	
		slider = new JSlider(JSlider.HORIZONTAL, 1, 7, 1);
		slider.setMinimum(1);
		slider.setMaximum(7);
		slider.setFont(new Font(slider.getFont().getFontName(), Font.ROMAN_BASELINE, 10));
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setLabelTable(slider.createStandardLabels(1));
       
        ChangeListener slideL = new ChangeListener () {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				if (slider.getValueIsAdjusting() == false)
					tp.setSelectedIndex(slider.getValue()-1);
			}
        	
        };
        
        slider.addChangeListener(slideL);
        
        f.getContentPane().add(slider,BorderLayout.SOUTH);
        
 ///////////////////////////////////////////////////////////////////////////////////////////       
 
    ChangeListener chg = new ChangeListener () {

		@Override
		public void stateChanged(ChangeEvent e) {
		
			
			for (int i = 0; i < filmList.length; i++)
			{
				if (((JTabbedPane) e.getSource()).getSelectedIndex() == i)
				{
					   try {
						imageDraw = ImageIO.read (new File ("images/"+ filmList[i] +".jpg"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		
			
		}
		
    	
    };
    
    tp.addChangeListener(chg);
	
	f.setSize(600,600);
	f.setVisible(true);
	
	}
	
	public static void main (String [] args) throws IOException {
		GUI gui = new GUI ();
		} 

}
