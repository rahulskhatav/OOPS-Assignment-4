import java.awt.*;
import java.awt.Menu;
import java.awt.MenuBar;

import javax.swing.JFrame;

public class NotepadMenu {
    JFrame jf;
    NotepadMenu(){
        // Components
        jf = new JFrame("Notepad");
        MenuBar mb = new MenuBar();
        Menu File = new Menu("File");
        Menu Edit = new Menu("Edit");
        Menu Settings = new Menu("Settings");
        Menu Lang = new Menu("Languages");
        MenuItem New = new MenuItem("New");
        MenuItem Open = new MenuItem("Open");
        MenuItem Save = new MenuItem("Save");
        MenuItem Delete = new MenuItem("Delete");
        MenuItem Rename = new MenuItem("Rename");
        MenuItem Print = new MenuItem("Print");
        MenuItem Cut = new MenuItem("Cut");
        MenuItem Copy = new MenuItem("Copy");
        MenuItem Paste = new MenuItem("Paste");
        MenuItem Convert = new MenuItem("Convert Case");
        MenuItem Undo = new MenuItem("Undo");
        MenuItem Import = new MenuItem("Import");
        MenuItem Background = new MenuItem("Change Background");
        MenuItem Theme = new MenuItem("Apply Theme");
        MenuItem C = new MenuItem("C");
        MenuItem CPP = new MenuItem("C++");
        MenuItem JAVA = new MenuItem("Java");
        MenuItem PYTHON = new MenuItem("Python");
        MenuItem RUBY = new MenuItem("Ruby");
        MenuItem GO = new MenuItem("Go");
        MenuItem PHP = new MenuItem("PHP");
        MenuItem JS = new MenuItem("JavaScript");

        // Adding
        File.add(New);
        File.add(Open);
        File.add(Save);
        File.add(Delete);
        File.add(Rename);
        File.add(Print);
        Edit.add(Cut);
        Edit.add(Copy);
        Edit.add(Paste);
        Edit.add(Convert);
        Edit.add(Undo);
        Settings.add(Import);
        Settings.add(Background);
        Settings.add(Theme);
        Lang.add(C);
        Lang.add(CPP);
        Lang.add(JAVA);
        Lang.add(PYTHON);
        Lang.add(GO);
        Lang.add(RUBY);
        Lang.add(JS);
        Lang.add(PHP);

        mb.add(File);
        mb.add(Edit);
        mb.add(Settings);
        mb.add(Lang);

        // Layout
        jf.setMenuBar(mb);
        jf.setSize(300,300);
        jf.setLayout(null);
        jf.setVisible(true);        
    }    
    public static void main(String[] args){
        new NotepadMenu();
    }
}
