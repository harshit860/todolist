package com.example.harshitgakhar.todolist;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by harshit gakhar on 24-03-2019.
 */

public class Filehelper
{
    public static final String FILENAME ="listinfo.dat";
    public static void writedata(ArrayList<String> items, Context context)
    {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME,Context.MODE_PRIVATE);
            ObjectOutputStream  oos = new ObjectOutputStream(fos);
            oos.writeObject(items);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<String> readData(Context context){
            ArrayList<String> itemsllist = null;
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            itemsllist = (ArrayList<String>) ois.readObject();
        } catch (FileNotFoundException e) {
            itemsllist = new ArrayList<>();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return itemsllist;
    }
}
