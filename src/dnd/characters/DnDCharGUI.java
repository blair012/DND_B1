/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.characters;

import dnd.characters.HumanCharacter;
import dnd.characters.DnDCharacter;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author gubotdev
 */
public class DnDCharGUI extends JFrame{
    //Parent Layout
    BorderLayout parentLayout = new BorderLayout();
    //AttributePanelLayout
    GridLayout attributePanelLayout = new GridLayout(10,2);
    //button panel layout
    FlowLayout btnPanelLayout = new FlowLayout();
    
    //AttributePanel
    JPanel attributePanel = new JPanel();
    
    //races
    String[] races = {"Human","Elf"};
    //race selector
    JLabel raceLab = new JLabel("Race:");
    JComboBox raceComBox = new JComboBox(races);
    
    //Attribute labels and fields
    JLabel nameLab = new JLabel("Name:");
    JTextField nameField = new JTextField("Enter Name");
    JLabel strengthLab = new JLabel("Strength:");
    JTextField strengthField = new JTextField();
    JLabel dexterityLab = new JLabel("Dexterity:");
    JTextField dexterityField = new JTextField();
    JLabel constitutionLab = new JLabel("Constitution:");
    JTextField constitutionField = new JTextField();
    JLabel intelligenceLab = new JLabel("Intelligence:");
    JTextField intelligenceField = new JTextField();
    JLabel wisdomLab = new JLabel("Wisdom:");
    JTextField wisdomField = new JTextField();
    JLabel charismaLab = new JLabel("Charisma:");
    JTextField charismaField = new JTextField();
    JLabel speedLab = new JLabel("Speed:");
    JTextField speedField = new JTextField();
    JLabel armorClassLab = new JLabel("Armor Class:");
    JTextField armorClassField = new JTextField();
    
    //List of caharacters in your party
    JTextArea characterList = new JTextArea("Party:\n");
    
    //Button Panel
    JPanel btnPanel = new JPanel();
    //create button
    JButton createBtn = new JButton("Create Character");
    //add character button
    JButton addCharBtn = new JButton("Add Character");
    //done button
    JButton doneBtn = new JButton("Done");
    
    //temporary character
    DnDCharacter tempCharacter = null;
    //party arrayList
    ArrayList<DnDCharacter> party;
    
    private DnDCharGUI(String title){
        super(title);
        super.setResizable(true);
    }
    
    private void initComponents(){
        
        initAttributePanel();
        
        //initCharacterList
        characterList.setPreferredSize(new Dimension(150,50));
        characterList.setEditable(false);
        
        //init btnPanel
        btnPanel.setLayout(btnPanelLayout);
        btnPanel.add(createBtn);
        btnPanel.add(addCharBtn);
        btnPanel.add(doneBtn);
            
    }
    
    private void addListeners(){
        
        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nameField.getText().equals("Enter Name")){
                    nameField.setText(JOptionPane.showInputDialog("Please enter a name:"));
                }
                if(raceComBox.getSelectedItem().equals("Human")){
                    tempCharacter = new HumanCharacter(nameField.getText(),new Fighter());
                    strengthField.setText(tempCharacter.getStrength()+"");
                    dexterityField.setText(tempCharacter.getDexterity()+"");
                    constitutionField.setText(tempCharacter.getConstitution()+"");
                    intelligenceField.setText(tempCharacter.getIntelligence()+"");
                    wisdomField.setText(tempCharacter.getWisdom()+"");
                    charismaField.setText(tempCharacter.getCharisma()+"");
                    speedField.setText(tempCharacter.getSpeed()+"");
                    armorClassField.setText(tempCharacter.getArmorClass()+"");
                    createBtn.setText("Roll Again?");
                }
            }
        });
        
        addCharBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tempCharacter !=null){
                    party.add(tempCharacter);
                    characterList.append(tempCharacter.name + ": Human\n");
                    tempCharacter = null;
                    nameField.setText("Enter Name");
                    createBtn.setText("Create Character");
                    
                    //Clearing attribute fields 
                    strengthField.setText("");
                    dexterityField.setText("");
                    constitutionField.setText("");
                    intelligenceField.setText("");
                    wisdomField.setText("");
                    charismaField.setText("");
                    speedField.setText("");
                    armorClassField.setText("");
                }
            }
        });
        doneBtn.addActionListener(e -> this.dispose());
    }
    
    private void addComponentsToFrame(Container pane){
        
        //instantiate components
        initComponents();
        
        //add action listeners
        addListeners();
        
        pane.setLayout(parentLayout);
        pane.add(attributePanel,BorderLayout.CENTER);
        pane.add(characterList, BorderLayout.EAST);
        pane.add(btnPanel,BorderLayout.SOUTH);
        
    }
    
    public static void createAndShowGUI(String title, ArrayList<DnDCharacter> party){
        //instatniate an object of this class
        DnDCharGUI frame = new DnDCharGUI(title);
        frame.party = party;
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        //add component to the frame
        frame.addComponentsToFrame(frame.getContentPane());
        frame.pack();
        //display GUI
        frame.setVisible(true);
    }

    private void initAttributePanel() {
        attributePanel.setLayout(attributePanelLayout);
        attributePanel.add(raceLab);
        attributePanel.add(raceComBox);
        attributePanel.add(nameLab);
        attributePanel.add(nameField);
        attributePanel.add(strengthLab);
        attributePanel.add(strengthField);
        strengthField.setEditable(false);
        attributePanel.add(dexterityLab);
        attributePanel.add(dexterityField);
        dexterityField.setEditable(false);
        attributePanel.add(constitutionLab);
        attributePanel.add(constitutionField);
        constitutionField.setEditable(false);
        attributePanel.add(intelligenceLab);
        attributePanel.add(intelligenceField);
        intelligenceField.setEditable(false);
        attributePanel.add(wisdomLab);
        attributePanel.add(wisdomField);
        wisdomField.setEditable(false);
        attributePanel.add(charismaLab);
        attributePanel.add(charismaField);
        charismaField.setEditable(false);
        attributePanel.add(speedLab);
        attributePanel.add(speedField);
        speedField.setEditable(false);
        attributePanel.add(armorClassLab);
        attributePanel.add(armorClassField);
        armorClassField.setEditable(false);
    }
}
