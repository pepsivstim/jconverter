package main.java.bv.jodconvert.test;

import java.awt.*;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

import org.jodconverter.core.office.OfficeException;

import com.sun.star.awt.ActionEvent;


public class GUI extends JFrame{
	JFrame frame;
	//HOME PANEL
	JPanel home_panel;
	JButton tools_button;
	JButton convert_button;
	JButton merge_button;
	JLabel title_label;
	JLabel credit_label;
	//CHOOSE FILE PANEL
	JPanel choose_panel;
	JButton choose_button;
	JButton back_button;
	JLabel choose_label;
	//CONVERSION CHOICE PANEL
	JPanel convert_panel;
	JButton html_button;
	JButton txt_button;
	JButton docx_button;
	JButton pdf_button;
	JButton xls_button;
	JButton ppt_button;
	JButton odt_button;
	JButton choice_back_button;
	JLabel selected_label;
	JLabel done_label;
	//TOOLS PANEL
	JPanel tools_panel;
	JButton tools_back_button;
	JButton word_count_button;
	JButton find_button;
	JButton replace_button;
	JButton edit_button;
	JButton save_button;
	JButton write_button;
	JLabel tools_selected_label;
	JLabel tools_done_label;
	JTextField test;
	JTextArea area;
	JScrollPane scroll_pane;
	JPanel popup_panel;
	//MERGE PANEL
	JPanel merge_panel;
	JLabel merge_label;
	JButton merge_choose_button;
	JButton merge_back_button;
	JLabel error_label;
	JLabel merge_done_label;
	
	
	//miscellaneous variables, constants needed
	FileDialog convert_to;
	Tools tools_file;
    Dimension button_dimension = new Dimension(300, 100);
    int width = 1280;
    int height = 720;
    int popup_width = 600;
    int popup_height = 400;
    Dimension popup_dimension = new Dimension(popup_width, popup_height);
    Dimension label_dimension = new Dimension(width, 200);
    Font big_font = new Font("Times New Roman", Font.BOLD, 72);
    Font standard_font = new Font("Times New Roman", Font.BOLD, 30);
    Font small_font = new Font("Times New Roman", Font.PLAIN, 24);
    String home_panel_text = "Conversion Software";
    String convert_panel_text = "Convert";
    String tools_panel_text = "Tools";
    
    //checks which panel to switch to after choosing a file
    boolean conversion_choice = true;
    
	public GUI() {
		frame = new JFrame("Conversion Tools");
	   	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(width, 900);
	    frame.setVisible(true);
	    frame.getContentPane().setBackground(Color.gray);
	    //HOME PANEL
	    home_panel = new JPanel();
	    home_panel.setLayout(new BorderLayout());
	    frame.setContentPane(home_panel);
	    title_label = create_label(home_panel, "JConversion System", new Dimension(width, 100), big_font, BorderLayout.NORTH, JLabel.CENTER);
	    credit_label = create_label(home_panel, "IB Computer Science | Personal Code: hbk993", new Dimension(250, 50), new Font("Times New Roman", Font.PLAIN, 20), BorderLayout.SOUTH, JLabel.CENTER);
	    convert_button = create_button(home_panel, "CONVERT", new Dimension(250, 100), big_font, BorderLayout.CENTER);
	    tools_button = create_button(home_panel, "TOOLS", new Dimension(300, 100), standard_font, BorderLayout.EAST);
	    merge_button = create_button(home_panel, "MERGE", new Dimension(300, 100), standard_font, BorderLayout.WEST);
	    //CHOOSE PANEL
	    choose_panel = new JPanel();
	   
	    choose_label = create_label(choose_panel, "Please choose a file you would like to convert", new Dimension(width, 100), big_font, BorderLayout.NORTH, JLabel.CENTER);
	    back_button = create_button(choose_panel, "BACK", button_dimension, standard_font);
	    choose_button = create_button(choose_panel, "CHOOSE FILE", button_dimension, standard_font);
	    //CHOOSE PANEL 2
	    choose_panel = new JPanel();
	    choose_panel.setLayout(new FlowLayout());
	    choose_label = create_label(choose_panel, "Please choose a file you would like to convert", new Dimension(width, 100), new Font("Times New Roman", Font.BOLD, 48), BorderLayout.NORTH, JLabel.CENTER);
	    back_button = create_button(choose_panel, "BACK", button_dimension, standard_font);
	    choose_button = create_button(choose_panel, "CHOOSE FILE", button_dimension, standard_font);
	    //CONVERSION PANEL
	    convert_panel = new JPanel();
	    convert_panel.setLayout(new FlowLayout());
	    html_button = create_button(convert_panel, "HTML (.html)", button_dimension, ".html", standard_font);
	    txt_button = create_button(convert_panel, "Text File (.txt)", button_dimension, ".txt", standard_font);
	    docx_button = create_button(convert_panel, "MS Word (.docx)", button_dimension, ".docx", standard_font);
	    pdf_button = create_button(convert_panel, "PDF (.pdf)", button_dimension, ".pdf", standard_font);
	    xls_button = create_button(convert_panel, "MS Excel (.xls)", button_dimension, ".xls", standard_font);
	    ppt_button = create_button(convert_panel, "MS Powerpoint (.ppt)", button_dimension, ".ppt", standard_font);
	    odt_button = create_button(convert_panel, "OpenDocument (.odt)", button_dimension, ".odt", standard_font);
	    choice_back_button = create_button(convert_panel, "BACK", button_dimension, standard_font);
	    selected_label = create_label(convert_panel, "", new Dimension(width, 100), standard_font, BorderLayout.SOUTH, JLabel.CENTER);
	    done_label = create_label(convert_panel, "", new Dimension(width, 100), standard_font, BorderLayout.SOUTH, JLabel.CENTER);
	    //TOOLS PANEL
	    tools_panel = new JPanel();
	    tools_panel.setLayout(new FlowLayout());
	    word_count_button = create_button(tools_panel, "Word Count", button_dimension, standard_font);
	    find_button = create_button(tools_panel, "Find Word", button_dimension, standard_font);
	    replace_button = create_button(tools_panel, "Replace Word", button_dimension, standard_font);
	    edit_button = create_button(tools_panel, "EDIT", new Dimension(200, 110), standard_font);
	    save_button = create_button(tools_panel, "SAVE", new Dimension(200, 110), standard_font);
	    write_button = create_button(tools_panel, "WRITE", new Dimension(200, 110), standard_font);
	    tools_back_button = create_button(tools_panel, "BACK", new Dimension(200, 110), standard_font);
	    tools_selected_label = create_label(tools_panel, "", new Dimension(width, 100), standard_font, BorderLayout.SOUTH, JLabel.CENTER);
	    tools_done_label = create_label(tools_panel, "", new Dimension(width, 100), standard_font, BorderLayout.SOUTH, JLabel.CENTER);
	    area = new JTextArea();
	    area.setFont(area.getFont().deriveFont(18f));
	    scroll_pane = new JScrollPane(area);
	    scroll_pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll_pane.setPreferredSize(new Dimension(width-100, height-350)); 
	    tools_panel.add(scroll_pane);
	    area.setEditable(false);
	    //MERGE PANEL
	    merge_panel = new JPanel();
	    merge_panel.setLayout(new FlowLayout());
	    merge_label = create_label(merge_panel, "Please choose the files you would like to merge", new Dimension(width, 100), new Font("Times New Roman", Font.BOLD, 48), BorderLayout.NORTH, JLabel.CENTER);
	    merge_back_button = create_button(merge_panel, "BACK", button_dimension, standard_font);
	    merge_choose_button = create_button(merge_panel, "CHOOSE FILE", button_dimension, standard_font);
	    error_label = create_label(merge_panel, "", new Dimension(width, 100), standard_font, BorderLayout.SOUTH, JLabel.CENTER);
	    merge_done_label = create_label(merge_panel, "", new Dimension(width, 100), standard_font, BorderLayout.SOUTH, JLabel.CENTER);
	
	    //switch to conversion panel
	    convert_button.addActionListener(new ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				conversion_choice = true;
				choose_label.setText("Choose a file you would like to convert");
				switch_screen(choose_panel, convert_panel_text);
			}
	    }); 
	    
	    //switch to tools panel
	    tools_button.addActionListener(new ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				conversion_choice = false;
				choose_label.setText("Choose a file you would like to analyze");
				switch_screen(choose_panel, tools_panel_text);
				
			}
	    }); 
	    //switch to merge panel
	    merge_button.addActionListener(new ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				conversion_choice = false;
				choose_label.setText("Choose a file you would like to analyze");
				switch_screen(merge_panel, tools_panel_text);
				
			}
	    }); 
	    
	    //go back to home panel from choose panel
	    back_button.addActionListener(new ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				switch_screen(home_panel, home_panel_text);
			}
	    }); 

	    //select file
	    choose_button.addActionListener(new ActionListener() { 
					public void actionPerformed(java.awt.event.ActionEvent e) {
						convert_to = Converter.choose("Select File to Open");
						if(conversion_choice) {
							switch_screen(convert_panel, convert_panel_text);
							if(convert_to.getFile() == null) {
								selected_label.setText("Invalid choice");
								System.out.println("Invalid choice");
							}
							else {
								selected_label.setText(convert_to.getFile() + " selected");
								System.out.println(convert_to.getFile() + " selected (CONVERT)");		
							}			
						}
						else {
							switch_screen(tools_panel, tools_panel_text);
							if(convert_to.getFile() == null) {
								tools_selected_label.setText("Invalid choice");
								System.out.println("Invalid choice");
							}
							else {
								tools_selected_label.setText(convert_to.getFile() + " selected");
								System.out.println(convert_to.getFile() + " selected (TOOLS)");
							}
							try {
								loading(".txt");
								tools_file = new Tools(new File(Converter.converted_file(convert_to, ".txt")));
								area.setText(tools_file.get_text());
								area.setCaretPosition(0);
							} catch (OfficeException e1) {
								System.out.println("Invalid .txt conversion");
								tools_done_label.setText("Invalid .txt conversion");
							} catch (IOException e1) {
								System.out.println("Invalid .txt conversion");
								tools_done_label.setText("Invalid .txt conversion");
							}
						}
					}
			    }); 
	    
	    //leave conversion panel for home screen, clearing away labels
	    choice_back_button.addActionListener(new ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				done_label.setText("");
				selected_label.setText("");
				switch_screen(home_panel, home_panel_text);
				
			}
	    }); 
	    
	    word_count_button.addActionListener(new ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				popup("Word/Character Count", popup_dimension);
				create_label(popup_panel, "Word Count: " + tools_file.get_wordCount(), new Dimension(popup_width, 50), standard_font, null, JLabel.CENTER);
				create_label(popup_panel, "Character Count: " + tools_file.get_characterCount(), new Dimension(popup_width, 50), standard_font, null, JLabel.CENTER);
				create_label(popup_panel, "Line count: " + tools_file.get_lineCount(), new Dimension(popup_width, 50), standard_font, null, JLabel.CENTER);
			}
	    });
	    
	    find_button.addActionListener(new ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				popup("Find a Word", popup_dimension);
				create_label(popup_panel, "Find a word", new Dimension(popup_width, 50), standard_font, null, JLabel.CENTER);
				final JTextField field = new JTextField();
				popup_panel.add(field);
				field.setColumns(25);
				field.setFont(small_font);
				
				JButton enter_button = create_button(popup_panel, "ENTER", new Dimension(200, 50), small_font);
				final JLabel occurence_label = create_label(popup_panel, "", new Dimension(popup_width, 50), standard_font, null, JLabel.CENTER);
				
				enter_button.addActionListener(new ActionListener() { 
					public void actionPerformed(java.awt.event.ActionEvent e) {	    
						String search = field.getText();
						ArrayList<Integer> index_list = tools_file.get_occurence_list(" " + search + " ");
						occurence_label.setText("Occurences of \"" + search + "\": " + index_list.size());
						Highlighter highlighter = area.getHighlighter();
					    HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
						highlighter.removeAllHighlights();
						for(int i = 0; i < index_list.size(); i = i + 2) {
							try {
								//add highlights at the index of the found words
								highlighter.addHighlight(index_list.get(i) + 1, index_list.get(i) + search.length() + 1, painter);
							} catch (BadLocationException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}	
					}
			    }); 
			}
	    }); 
	    
		replace_button.addActionListener(new ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				popup("Replace a Word", popup_dimension);
				create_label(popup_panel, "Replace a Word", new Dimension(popup_width, 50), standard_font, null, JLabel.CENTER);
				create_label(popup_panel, "Old word:", new Dimension(popup_width, 50), standard_font, null, JLabel.CENTER);
				final JTextField old_field = create_field(popup_panel, 25, small_font);
				create_label(popup_panel, "New word:", new Dimension(popup_width, 50), standard_font, null, JLabel.CENTER);
				final JTextField new_field = create_field(popup_panel, 25, small_font);
				JButton replace_button = create_button(popup_panel, "Replace", new Dimension(200, 50), small_font);
				JButton replace_all_button = create_button(popup_panel, "Replace All", new Dimension(200, 50), small_font);
				replace_button.addActionListener(new ActionListener() { 
					public void actionPerformed(java.awt.event.ActionEvent e) {	    
						tools_file.replace(" " + old_field.getText() + " ", " " + new_field.getText() + " ");
						area.setText(tools_file.get_text());
						//sets scroll position
						area.setCaretPosition(0);
						tools_file.get_lineCount();
					}
			    }); 
				replace_all_button.addActionListener(new ActionListener() { 
					public void actionPerformed(java.awt.event.ActionEvent e) {	    
						tools_file.replace_all(" " + old_field.getText()+ " ", " " + new_field.getText()+ " ");
						area.setText(tools_file.get_text());
						area.setCaretPosition(0);
					}
			    }); 
			}
	    }); 
		

		edit_button.addActionListener(new ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				area.setEditable(true);
				tools_done_label.setText("Editing Mode ON");
			}
	    }); 
	
		save_button.addActionListener(new ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				tools_file.set_text(area.getText());
				tools_done_label.setText("Changes Saved");
				area.setEditable(false);
			}
	    }); 
		
		write_button.addActionListener(new ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				tools_file.set_text(area.getText());
				tools_done_label.setText("Written to file");
				try {
					tools_file.write();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					tools_done_label.setText("Unable to write!");
					e1.printStackTrace();
				}
			}
	    }); 
		
		tools_back_button.addActionListener(new ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				tools_done_label.setText("");
				tools_selected_label.setText("");
				switch_screen(home_panel, home_panel_text);
				
			}
	    }); 
		
		merge_choose_button.addActionListener(new ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				FileDialog file1 = Converter.choose("Choose the first file");
				FileDialog file2 = Converter.choose("Choose the second file");
				if(file1.getFile() == null || file2.getFile() == null) {
					error_label.setText("Invalid choice");
					System.out.println("Invalid choice");
				}
				try {
					Converter.convert(file1, ".txt");
					Converter.convert(file2, ".txt");
					
					Merge merge_document = new Merge(new File(Converter.converted_file(file1, ".txt")), new File(Converter.converted_file(file2, ".txt")));
					merge_document.merge(file1);
					//Documents merge = new Documents(file1, file2);
					//merge.merge(file1, file2);
				} catch (OfficeException e1) {
					error_label.setText("Invalid Conversion");
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					error_label.setText("Invalid Conversion");
					e1.printStackTrace();
				}
				merge_done_label.setText("Merging complete");
			}
	    }); 
		
		merge_back_button.addActionListener(new ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				merge_done_label.setText("");
				error_label.setText("");
				switch_screen(home_panel, home_panel_text);
				
			}
	    }); 
	}

	public JLabel create_label(JPanel panel, String text, Dimension dimension, Font font, String layout, int h_alignment) {
		JLabel label = new JLabel(text);
		label.setFont(font);
		label.setPreferredSize(dimension);
		label.setHorizontalAlignment(h_alignment);
	    panel.add(label, layout);
	    return label;
	}
	//default button creation
	public JButton create_button(JPanel panel, String text, Dimension dimension, Font font) {
		JButton button = new JButton(text);
		button.setFont(font);
		button.setPreferredSize(dimension);
	    panel.add(button);
	    return button;
	}
	//button creation with layout
	public JButton create_button(JPanel panel, String text, Dimension dimension, Font font, String layout) {
		JButton button = new JButton(text);
		button.setFont(font);
		button.setPreferredSize(dimension);
	    panel.add(button, layout);
	    return button;
	}
	
	//button creation event creation
	public JButton create_button(JPanel panel, String text, Dimension dimension, final String type, Font font) {
		JButton button = new JButton(text);
		button.setFont(font);
		button.setPreferredSize(dimension);
	    panel.add(button);
	    button.addActionListener(new ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				try {
					loading(type);
				} 
				catch (OfficeException e1) { 
					System.out.println("Invalid conversion");
					done_label.setText("Invalid conversion");
					//e1.printStackTrace();
				} 
				catch (IOException e1) {
					System.out.println("Invalid conversion");
					done_label.setText("Invalid conversion");
					//e1.printStackTrace();
				}
			}
	    });
	    return button;
	}
	
	public void popup(String name, Dimension dimension) {
		JFrame popup = new JFrame(name);
		popup.setSize(dimension);
		popup.setVisible(true);
		popup.getContentPane().setBackground(Color.gray);
		popup_panel = new JPanel();
		popup_panel.setLayout(new FlowLayout());
		popup.setContentPane(popup_panel);
	}
	
	public JTextField create_field(JPanel panel, int dimension, Font font) {
		final JTextField field = new JTextField();
		panel.add(field);
		field.setColumns(dimension);
		field.setFont(font);
		return field;
	}
	
	public void loading(String type) throws OfficeException, IOException {
		Converter.convert(convert_to, type);
		if(conversion_choice) {
			done_label.setText(type + " Conversion Complete");
		}
		else {
			tools_done_label.setText(type + " Conversion Complete");
		}
	}
	
	public void switch_screen(JPanel to, String title) {
		frame.setContentPane(to);
		frame.invalidate();
		frame.validate();
		frame.setTitle(title);
	}
}


