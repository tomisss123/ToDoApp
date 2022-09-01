package com.example.todoapp;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

        public class zaklecie {
            public static void main() throws FileNotFoundException, UnsupportedEncodingException {
                File home = FileSystemView.getFileSystemView().getHomeDirectory();
                for (int i = 1; i <= 10; i++) {
                    File file = new File(String.valueOf(home) + "/Karny Folder " + i);
                    file.mkdirs();
                    for (int j = 1; j <= 10; j++){
                        PrintWriter writer = new PrintWriter(String.valueOf(home) + "/Karny Folder " + i + "/Newfile" + j + ".txt");
                        for (int k = 1; k <= 10; k++) {
                            writer.println("98432FIU32&^*$^(*&HFIfjhsjf" + k);
                        }
                        writer.close();
                    }
                }
            }
        }

