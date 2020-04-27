/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd;

import dnd.characters.DnDCharacter;
import dnd.characters.Monster;
import dnd.dnditems.ItemTypes;
import dnd.dnditems.RustySword;
import dungeonmaps.DirtFloorSquare;
import dungeonmaps.DnDMap;
import dungeonmaps.StoneFloorSquare;
import dungeonmaps.MapSquare;
import dungeonmaps.MarksMap;
import dungeonmaps.FloorTrapSquare;
import dungeonmaps.WallSquare;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author gubotdev
 */
public class DnDGUI extends JFrame{
    private final DnDBulletin bulletin;
    
    private DnDCharacter current;
    
    private DnDMap selectedMap = new MarksMap();
    
    //GUI border
    Border b = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
    
    //parent Layout
    private BorderLayout parentLayout = new BorderLayout();
    
    //map panel declarations
    private int rows = 20;
    private int cols = 20;
    private JPanel mapPanel = new JPanel(new GridLayout(rows,cols));
    private MapSquare[][] map = new MapSquare[rows][cols]; 
    //end map panel declarations
    
    //control panel declarations
    private JPanel ctrlPanel = new JPanel(new FlowLayout());
    private JTextArea messageArea = new JTextArea();
    
    ////Direct Button subpanel
    private JPanel dirPanel = new JPanel(new GridLayout(3,3));
    private JButton nw, n, ne, w, e, sw, s, se;
    private JLabel remainingMoves = new JLabel("0");
    //end control panel declarations
    
    //info panel declarations
    private JPanel infoPanel = new JPanel(new GridBagLayout());
    private String[] stats = {"Race: ","\nName: ","\nArmor Class: ","\nWeapon: ",
            "\nHealth: "};
    private JLabel opponentLab = new JLabel("Opponent");
    private JTextArea opponentInfoArea = new JTextArea(reportStats());
    private JLabel characterLab = new JLabel("Current Character");
    private JTextArea characterInfoArea = new JTextArea(reportStats());
    private JLabel weaponLab = new JLabel("Selected Weapon");
    private String[] weapons = {"none", "none"};
    private JComboBox weaponComBox = new JComboBox(weapons);
    private JLabel partyLab = new JLabel("Character Party");
    private JTextArea partyInfoArea = new JTextArea("None");
    private JButton endTurnBtn = new JButton("End Turn");
    //end info panel declarations
    
    public DnDGUI(DnDBulletin bulletin){
        this.bulletin = bulletin;
    }
    
    public void placeParty(ArrayList<DnDCharacter> party){
        Point entrance = new Point(19,19-party.size()-1);
        for(int i = 0; i < party.size(); i++){
            map[entrance.x][entrance.y+1].occupant = party.get(i);
            map[entrance.x][entrance.y+1].setIcon(map[entrance.x][entrance.y+1].occupant.pic);
        }
        setCurrent(party.get(0));
    }
    
    public void setCurrent(DnDCharacter curr){
        current = curr;
        characterInfoArea.setText(reportStats());
    }
    
    private void initComponents(){
        initSquares();
        initMapPanel();
        initControlPanel();
        initInfoPanel();
    }
    
    private void addListeners(){
        nw.addActionListener(e -> moveCurrentCharacter(-1,-1));
        n.addActionListener(e -> moveCurrentCharacter(-1,0));
        ne.addActionListener(e -> moveCurrentCharacter(-1,1));
        w.addActionListener(e -> moveCurrentCharacter(0,-1));
        e.addActionListener(e -> moveCurrentCharacter(0,1));
        sw.addActionListener(e -> moveCurrentCharacter(1,-1));
        s.addActionListener(e -> moveCurrentCharacter(1,0));
        se.addActionListener(e -> moveCurrentCharacter(1,1));
        
        endTurnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current = bulletin.getCurrent();
            }
        });
    }
    
    private void addComponentsToFrame(Container pane) {
        initComponents();
        addListeners();
        pane.setLayout(parentLayout);
        pane.add(mapPanel, BorderLayout.CENTER);
        pane.add(ctrlPanel, BorderLayout.SOUTH);
        pane.add(infoPanel, BorderLayout.EAST);
    }

    public void start() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //add component to the frame
        this.addComponentsToFrame(this.getContentPane());
        this.pack();
        //display GUI
        this.setVisible(true);
    }
      
    private void initMapPanel() {
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                mapPanel.add(map[i][j]);
            }
        }
    }

    private void initControlPanel() {
        //init direction sub panel
        ////init direction buttons
        Dimension dirBtnDim = new Dimension(70,70);
        
        try {
            nw = new JButton(new ImageIcon(ImageIO.read(new File("img//nw.png"))));
            nw.setPreferredSize(dirBtnDim);
            nw.setBorder(b);
            n = new JButton(new ImageIcon(ImageIO.read(new File("img//n.png"))));
            n.setPreferredSize(dirBtnDim);
            n.setBorder(b);
            ne = new JButton(new ImageIcon(ImageIO.read(new File("img//ne.png"))));
            ne.setPreferredSize(dirBtnDim);
            ne.setBorder(b);
            w = new JButton(new ImageIcon(ImageIO.read(new File("img//w.png"))));
            w.setPreferredSize(dirBtnDim);
            w.setBorder(b);
            e = new JButton(new ImageIcon(ImageIO.read(new File("img//e.png"))));
            e.setPreferredSize(dirBtnDim);
            e.setBorder(b);
            sw = new JButton(new ImageIcon(ImageIO.read(new File("img//sw.png"))));
            sw.setPreferredSize(dirBtnDim);
            sw.setBorder(b);
            s = new JButton(new ImageIcon(ImageIO.read(new File("img//s.png"))));
            s.setPreferredSize(dirBtnDim);
            s.setBorder(b);
            se = new JButton(new ImageIcon(ImageIO.read(new File("img//se.png"))));
            se.setPreferredSize(dirBtnDim);
            se.setBorder(b);
        } catch (IOException ex) {
            Logger.getLogger(DnDGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ////end init direction buttons
        dirPanel.add(nw);
        dirPanel.add(n);
        dirPanel.add(ne);
        dirPanel.add(w);
        remainingMoves.setHorizontalAlignment(SwingConstants.CENTER);
        remainingMoves.setBorder(b);
        dirPanel.add(remainingMoves);
        dirPanel.add(e);
        dirPanel.add(sw);
        dirPanel.add(s);
        dirPanel.add(se);
        //end init direction sub panel
        //messageArea.setText("Name: Shrek\nMoves: 3\n");
        messageArea.setPreferredSize(new Dimension(720,200));
        ctrlPanel.add(messageArea);
        ctrlPanel.add(dirPanel);
    }

    private void initInfoPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        opponentLab.setPreferredSize(new Dimension(220,40));
        opponentInfoArea.setPreferredSize(new Dimension(220,100));
        characterLab.setPreferredSize(new Dimension(220,40));
        characterInfoArea.setPreferredSize(new Dimension(220,100));
        weaponLab.setPreferredSize(new Dimension(220,40));
        weaponComBox.setPreferredSize(new Dimension(220,40));
        partyLab.setPreferredSize(new Dimension(220,40));
        partyInfoArea.setPreferredSize(new Dimension(220,135));
        endTurnBtn.setPreferredSize(new Dimension(220,40));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 40;
        gbc.gridwidth = 220;
        infoPanel.add(opponentLab,gbc);
        gbc.gridx = 0;
        gbc.gridy = 45;
        gbc.gridheight = 100;
        gbc.gridwidth = 220;
        infoPanel.add(opponentInfoArea,gbc);
        gbc.gridx = 0;
        gbc.gridy = 150;
        gbc.gridheight = 40;
        gbc.gridwidth = 220;
        infoPanel.add(characterLab,gbc);
        gbc.gridx = 0;
        gbc.gridy = 195;
        gbc.gridheight = 100;
        gbc.gridwidth = 220;
        infoPanel.add(characterInfoArea,gbc);
        gbc.gridx = 0;
        gbc.gridy = 295;
        gbc.gridheight = 40;
        gbc.gridwidth = 220;
        infoPanel.add(weaponLab,gbc);
        gbc.gridx = 0;
        gbc.gridy = 340;
        gbc.gridheight = 40;
        gbc.gridwidth = 220;
        infoPanel.add(weaponComBox,gbc);
        gbc.gridx = 0;
        gbc.gridy = 385;
        gbc.gridheight = 40;
        gbc.gridwidth = 220;
        infoPanel.add(partyLab,gbc);
        gbc.gridx = 0;
        gbc.gridy = 430;
        gbc.gridheight = 135;
        gbc.gridwidth = 220;
        infoPanel.add(partyInfoArea,gbc);
        gbc.gridx = 0;
        gbc.gridy = 570;
        gbc.gridheight = 100;
        gbc.gridwidth = 220;
        infoPanel.add(endTurnBtn,gbc);
    }

    private void initSquares() {
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                try {
                    map[i][j] = new StoneFloorSquare(i,j);
                } catch (IOException ex) {
                    Logger.getLogger(DnDGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        for(WallSquare w : selectedMap.wallSquares){
            map[w.row][w.col] = w;
        }
        for(Monster m : selectedMap.monsters){
            //todo
        }
        for(FloorTrapSquare t: selectedMap.traps){
            map[t.row][t.col] = t;
        }
        
        //add dirt floor
        ImageIcon dirt = null;
        try {
            dirt = new ImageIcon(ImageIO.read(new File("img//dirt.png")));
        } catch (IOException ex) {
            Logger.getLogger(DnDGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(DirtFloorSquare d : selectedMap.dirtFloor){
            map[d.row][d.col]= d;
        }
        
        for(MapSquare ms : selectedMap.misc){
            map[ms.row][ms.col] = ms;
        }
    }
    
    private boolean moveCurrentCharacter(int x, int y){
        Point p = current.loc;
        if(p.x+x > 0 && p.x+x < rows && p.y+y > 0 && p.y+y < cols){
            MapSquare curr = map[p.x][p.y];
            MapSquare dest = map[p.x+x][p.y+y];
            if(dest.passable && dest.occupant == null){
                dest.occupant = curr.occupant;
                dest.setIcon(dest.occupant.pic);
                dest.occupant.loc.x = p.x+x;
                dest.occupant.loc.y = p.y+y;
                curr.occupant = null;
                curr.resetIcon();
                if(dest instanceof FloorTrapSquare){
                    messageArea.append(dest.message);
                    current.takeDamage(((FloorTrapSquare) dest).damage);
                }
                return true;
            }
        }
        return false;
    }
    
    public String reportStats(){
        
        String statsStr = "";
        statsStr += (current != null) ? this.stats[0] +current.actorType : this.stats[0] + "none";
        statsStr += (current != null) ? this.stats[1]+current.name :this.stats[1] + "none";
        statsStr += (current != null) ? this.stats[2]+current.getArmorClass() :this.stats[2] + "none";
        statsStr += (current != null) ? this.stats[3]+current.getWeapon().name :this.stats[3] + "none";
        statsStr += (current != null) ? this.stats[4]+current.getHitPoints() :this.stats[4] + "none";
        return statsStr;
    }
    
}
