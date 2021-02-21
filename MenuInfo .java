package com.Menu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import jdk.nashorn.internal.ir.CatchNode;

    public class MenuInfo implements ActionListener {

        public JFrame frame;

        private JTable table;

        private JPanel panel;
        private JPanel panel2;
        private JPanel panel3;

        private JMenuBar menuBar;
        private JMenu file;
        private JMenuItem help;
        private JMenuItem openFile;
        private JMenuItem exit;
        
        private JTextField txtDishNum;
        private JTextField txtDishName;
        private JTextField txtPrice;
        private JTextField txtSearch;

        private JComboBox categoryList;
        private JComboBox categoryList2;

        private JButton btnClear;
        private JButton btnInsert;
        private JButton btnClearTable;
        private JButton btnViewTable;
        private JButton btnSearch;
        private JButton btnViewDish;

        private ButtonGroup btnGroup;
        private JRadioButton btnLow;
        private JRadioButton btnMid;
        private JRadioButton btnHigh;
        private JScrollPane pane;

        private DefaultTableModel model;
        private Object[] row;

        private ArrayList<mClass> Menu;
        private String DishName, Categories, Calories;
        private int Price, DishNum, count;

        private ArrayList<String>  appetiezers;
        private ArrayList<String> maincourse;
        private ArrayList<String> dessert;
        private ArrayList<String> liquor;
        private ArrayList<String> drinks; 
        
        public MenuInfo() {
            frame = new JFrame("Lama Khaja Ghar");

            panel = new JPanel();
            panel.setBounds(0, 0, 1300, 600);
            //panel.setBackground(Color.Grey);
            panel.setLayout(null);
            panel.setBorder(BorderFactory.createLineBorder(Color.black));
            frame.add(panel);

            panel2 = new JPanel();
            //panel2.setBackground(Color.red);
            panel2.setBounds(125, 330, 300, 45);
            panel2.setLayout(new FlowLayout());
            panel2.setBorder(BorderFactory.createLineBorder(Color.black));
            panel.add(panel2);

            menuBar = new JMenuBar();
            frame.setJMenuBar(menuBar);
            file = new JMenu("File");
            menuBar.add(file);
            help = new JMenuItem("Help");
            help.addActionListener(this);
            menuBar.add(help);
            openFile = new JMenuItem("Open");
            openFile.addActionListener(this);
            exit = new JMenuItem("Exit");
            exit.addActionListener(this);
            file.add(openFile);
            file.add(exit);


            JLabel lblTitle = new JLabel("LAMA KHAJA GHAR");
            lblTitle.setFont(new Font("Ariel", Font.BOLD, 40));
            lblTitle.setBounds(450, 30, 425, 60);
            panel.add(lblTitle);

            JLabel lblDishNum = new JLabel("Dish Number");
            lblDishNum.setFont(new Font("Ariel", Font.PLAIN, 22));
            lblDishNum.setBounds(20, 135, 125, 30);
            panel.add(lblDishNum);

            JLabel lblDishName = new JLabel("Dish Name");
            lblDishName.setFont(new Font("Ariel", Font.PLAIN, 22));
            lblDishName.setBounds(20, 180, 125, 30);
            panel.add(lblDishName);

            JLabel lblCategory = new JLabel("Category");
            lblCategory.setFont(new Font("Ariel", Font.PLAIN, 22));
            lblCategory.setBounds(20, 275, 125, 30);
            panel.add(lblCategory);

            JLabel lblCalories = new JLabel("Calories");
            lblCalories.setFont(new Font("Ariel", Font.PLAIN, 22));
            lblCalories.setBounds(20, 330, 125, 30);
            panel.add(lblCalories);

            JLabel lblPrice = new JLabel("Price");
            lblPrice.setFont(new Font("Ariel", Font.PLAIN, 22));
            lblPrice.setBounds(20, 225, 125, 30);
            panel.add(lblPrice);


            txtSearch = new JTextField();
            txtSearch.setBounds(900, 100, 175, 30);
            txtSearch.setFont(new Font("Ariel", Font.PLAIN, 22));
            panel.add(txtSearch);


            txtDishNum = new JTextField();
            txtDishNum.setBounds(180, 135, 125, 30);
            txtDishNum.setFont(new Font("Ariel", Font.PLAIN, 22));
            panel.add(txtDishNum);


            txtDishName = new JTextField();
            txtDishName.setBounds(180, 180, 125, 30);
            txtDishName.setFont(new Font("Ariel", Font.PLAIN, 22));
            panel.add(txtDishName);

            txtPrice = new JTextField();
            txtPrice.setBounds(180, 225, 125, 30);
            txtPrice.setFont(new Font("Ariel", Font.PLAIN, 22));
            panel.add(txtPrice);


            String[] categoryString = {"Appetiezers", "Main Course", "Dessert", "Drinks", "Liquor"};
            categoryList = new JComboBox(categoryString);
            categoryList.setSelectedIndex(0);
            categoryList.setFont(new Font("Ariel", Font.PLAIN, 17));
            categoryList.setBounds(180, 275, 125, 30);
            panel.add(categoryList);

            categoryList2 = new JComboBox(categoryString);
            categoryList2.setSelectedIndex(0);
            categoryList2.setFont(new Font("Ariel", Font.PLAIN, 17));
            categoryList2.setBounds(900, 475, 125, 30);
            panel.add(categoryList2);


            btnLow = new JRadioButton("Low");
            //btnLow.setMnemonic(KeyEvent.VK_B);
            this.btnLow.setActionCommand("Low");
            btnLow.setSelected(true);
            btnLow.setFont(new Font("Ariel", Font.PLAIN, 18));

            btnMid = new JRadioButton("Moderate");
            //btnMid.setMnemonic(KeyEvent.VK_B);
            this.btnMid.setActionCommand("Moderate");
            btnMid.setSelected(false);
            btnMid.setFont(new Font("Ariel", Font.PLAIN, 18));

            btnHigh = new JRadioButton("High");
            //btnHigh.setMnemonic(KeyEvent.VK_B);
            this.btnHigh.setActionCommand("High");
            btnHigh.setSelected(false);
            btnHigh.setFont(new Font("Ariel", Font.PLAIN, 18));

            //Group the radio buttons.
            btnGroup = new ButtonGroup();
            btnGroup.add(btnLow);
            btnGroup.add(btnMid);
            btnGroup.add(btnHigh);

            panel2.add(btnLow);
            panel2.add(btnMid);
            panel2.add(btnHigh);


            btnSearch = new JButton("Search");
            btnSearch.setBounds(1100, 100, 125, 30);
            btnSearch.setFont(new Font("Ariel", Font.PLAIN, 20));
            panel.add(btnSearch);
            btnSearch.addActionListener(this);

            btnInsert = new JButton("Insert");
            btnInsert.setBounds(35, 450, 100, 30);
            btnInsert.setFont(new Font("Ariel", Font.PLAIN, 20));
            panel.add(btnInsert);
            btnInsert.addActionListener(this);

            btnClear = new JButton("Clear");
            btnClear.setBounds(160, 450, 100, 30);
            btnClear.setFont(new Font("Ariel", Font.PLAIN, 20));
            panel.add(btnClear);
            btnClear.addActionListener(this);

            btnClearTable = new JButton("Clear Table");
            btnClearTable.setBounds(600, 475, 135, 30);
            btnClearTable.setFont(new Font("Ariel", Font.PLAIN, 19));
            panel.add(btnClearTable);
            btnClearTable.addActionListener(this);

            btnViewDish = new JButton("View Available Dish");
            btnViewDish.setBounds(1050, 475, 200, 30);
            btnViewDish.setFont(new Font("Ariel", Font.PLAIN, 19));
            panel.add(btnViewDish);
            btnViewDish.addActionListener(this);


            Object[] columns = {"Dish Number", "Dish Name", "Price", "Category", "Calories"};
            model = new DefaultTableModel();
            model.setColumnIdentifiers(columns);
            table = new JTable();
            table.setModel(model);

            pane = new JScrollPane(table);
            pane.setBounds(550, 200, 700, 210);
            pane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                    "Dish Details",
                    TitledBorder.LEFT,
                    TitledBorder.TOP));
            panel.add(pane);

            frame.setSize(1300, 600);
            frame.setVisible(true);

            Menu = new ArrayList<>();
            DishName = new String();
            Categories = new String();
            Calories = new String();
            DishNum = 0;
            Price = 0;
            count = 0;
            appetiezers= new ArrayList<String>();
            maincourse=  new ArrayList<String>();
            dessert= new ArrayList<String>();
            drinks= new ArrayList<String>();
            liquor= new ArrayList<String>();
        }


        @Override
        public void actionPerformed(ActionEvent e) {


            if (e.getSource().equals(btnInsert)) {
                insert();
                addToList();
                MergeSort.mSort(Menu);

            }
            if (e.getSource().equals(btnSearch)) {
                search();
            }
            if (e.getSource().equals(btnViewDish)) {
                viewDish();
            }
            if (e.getSource().equals(btnClearTable)) {
                clearTable();
            }
            if (e.getSource().equals(btnClear)) {
                clearTextfield();
            }
            if (e.getSource().equals(help)) {
                help();
            }
            if (e.getSource().equals(exit)) {
                exit();
            }
        }
        
        

        public void clearTable(){
            while (model.getRowCount() > 0) {
                for (int j = 0; j < model.getRowCount(); j++) {
                    model.removeRow(j);
                }
            }
            Menu.clear();
            appetiezers.clear();
            maincourse.clear();
            dessert.clear();
            drinks.clear();
            liquor.clear();
        }

        public void clearTextfield(){
            txtDishName.setText("");
            txtDishNum.setText("");
            txtPrice.setText("");
            txtSearch.setText("");

        }
        
        
        public void search(){
            try{
                MergeSort.mSort(Menu);
                int value = Integer.parseInt(txtSearch.getText());
                int index = MergeSort.binSearch(Menu, value,0,Menu.size());
            if(index == -1){
                JOptionPane.showMessageDialog(frame, "Result not Found", "ATTENTION",
                         JOptionPane.INFORMATION_MESSAGE);
            }
            else if (index == 1){
                    JOptionPane.showMessageDialog(frame, "Table is Empty", "ATTENTION",
                         JOptionPane.INFORMATION_MESSAGE);
                }
            else
                {
                    JOptionPane.showMessageDialog(frame, "Name: " + Menu.get(index).getDishName() + "\n" + "Dish Number: " + Menu.get(index).getDishNum() + "\n" + "Price: " + Menu.get(index).getPrice() + "\n" + "Categories: " + Menu.get(index).getCategories() + "\n" + "Calories: " + Menu.get(index).getCalories() + "\n");
            }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "ERROR", "Invalid Input",
                         JOptionPane.ERROR_MESSAGE);
            }
        }


        public String toString() {
            return String.format(DishName + "\t" + DishNum + "\t" + Price + "\t\t" + Categories + "\t" + Calories);
        }


        public int getDNum() {
            
            return Integer.parseInt(txtDishNum.getText());

        }

        public String getDName() {
            return txtDishName.getText();

        }

        public int getPri() {
            return Integer.parseInt(txtPrice.getText());
        }

        public String getCategory() {
            return (String) categoryList.getSelectedItem();
        }
         public String getCategory2() {
            return (String) categoryList2.getSelectedItem();
        }
        public String getCalory() {
            return this.btnGroup.getSelection().getActionCommand();
        }

        public void insert() {
            try {
            int dishNum = getDNum();
            String dishName = getDName();
            int price = getPri();
            String category = getCategory();
            String calories = getCalory();
            row = new Object[5];
            row[0] = dishNum;
            row[1] = dishName;
            row[2] = price;
            row[3] = category;
            row[4] = calories;
            model.addRow(row);
            
            
            switch(category.toLowerCase()){
                case "appetiezers":
                    appetiezers.add(dishName);
                    break;
                case "main course":
                    maincourse.add(dishName);
                    break;
                case "dessert":
                    dessert.add(dishName);
                    break;
                case "drinks":
                    drinks.add(dishName);
                    break;
                case "liquor":
                    liquor.add(dishName); 
                    break;
                    
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "ERROR", "Invalid Input",
                         JOptionPane.ERROR_MESSAGE);
                    }
         
                    
                 
                     
        }
        
        public void viewDish(){
            String category = getCategory2();
            String output = "";
            switch(category.toLowerCase()){
                case "appetiezers":
                    for(int i = 0; i<appetiezers.size(); i++){
                        String all= appetiezers.get(i).toString();
                        output +=all + "\n";   
                        
                    }
                    JOptionPane.showMessageDialog(frame, output , "There are " + appetiezers.size() + " appetiezers",
                         JOptionPane.INFORMATION_MESSAGE);
                    break;
               case "main course":
                    for(int i = 0; i<maincourse.size(); i++){
                        String all= maincourse.get(i).toString();
                        output +=all + "\n";   
                        
                    }
                    JOptionPane.showMessageDialog(frame, output , "There are " + maincourse.size() + " Main Course ",
                         JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "dessert":
                    for(int i = 0; i<dessert.size(); i++){
                        String all= dessert.get(i).toString();
                        output +=all + "\n";   
                        
                    }
                    JOptionPane.showMessageDialog(frame, output , "There are " + dessert.size() + " Dessert",
                         JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "drinks":
                    for(int i = 0; i<drinks.size(); i++){
                        String all= drinks.get(i).toString();
                        output +=all + "\n";   
                        
                    }
                    JOptionPane.showMessageDialog(frame, output , "There are " + drinks.size() + " Drinks ",
                         JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "liquor":
                    for(int i = 0; i<liquor.size(); i++){
                        String all= liquor.get(i).toString();
                        output +=all + "\n";   
                        
                    }
                    JOptionPane.showMessageDialog(frame, output , "There are " + liquor.size() + " Liquor ",
                         JOptionPane.INFORMATION_MESSAGE);
                    break;
        }
        
        }    

        public void addToList() {
            String DName = getDName();
            int DNum = getDNum();
            int prices = getPri();
            String cat = getCategory();
            String cal = getCalory();


            mClass Items = new mClass();
            Items.setDishName(DName);
            Items.setDishNum(DNum);
            Items.setPrice(prices);
            Items.setCategories(cat);
            Items.setCalories(cal);

            Menu.add(Items);
            count++;


        }

        public void help(){
            JOptionPane.showMessageDialog(frame,"Please enter values in the left side and they will be display in the table.","HELP",
                         JOptionPane.INFORMATION_MESSAGE);
        }


//        public void open(){
//            try {
//			Runtime.getRuntime().exec("rundll32 url.dl, FileProtocolHandler” + “C:\\Users\Bista\Peiyuan\\Desktop\\demo.docx");
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "Error");
//		}
//
//        }
        public void exit(){
            frame.dispose();
        }
        
        public static void main(String[] args) {
            new MenuInfo();

        }

    }
