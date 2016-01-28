package com.company;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONUtilities;

import java.io.*;
import java.util.*;


/**
 * Created by hansoljeong on 2015. 10. 12..
 * Serialization is crucial in order to use JSON because serialization is the process of translating data structures or
 * object state into a format tha can be stored and reconstructed later in the same or another computer environment. JSON
 * is more lightweight plain-text alternative to XML.
 */
public class
        ExampleApp {
    public static void main(String args[]){

        Names name = new Names("Assassination", "PG-15", "15-AUG-15");

        try {
    //Happy path - JSON file IO sample. Socket IO would do the same things as JSON.(Push data into application)
            FileOutputStream fout = new FileOutputStream("names.txt");
            JSONOutputStream out = new JSONOutputStream(fout);

            out.writeObject(name);
            out.close();

        /*NASTY PATH-JSON string cannot output values in text file.*/
            try{
                fout = new FileOutputStream("names.txt");
                out = new JSONOutputStream(null);

                out.writeObject(null);
                out.close();
            }catch(Exception e){
                e.printStackTrace();
            }

        //Nasty path - write out the null value
            try{
                fout = new FileOutputStream("names.txt");
                out = new JSONOutputStream(fout);

                out.writeObject(null);
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        /*Nasty Path-no specified file types*/
            try{
                fout = new FileOutputStream("null");
                out = new JSONOutputStream(fout);

                out.writeObject("null");
                out.close();
            }catch(Exception e){
                e.printStackTrace();
            }

        //Nasty-path: Write to replace directory that I don't have permission.
            fout = new FileOutputStream("names.txt");
            out = new JSONOutputStream(fout);

            out.writeObject("..도큐멘트/serialization.txt");
            out.close();
        //Nasty-path: Write object with empty . string or numbers, characters.
            fout = new FileOutputStream(" ");
            out = new JSONOutputStream(fout);

            out.writeObject(" ");
            out.close();


        //Nasty-path: Write object with string
            fout = new FileOutputStream("absc");
            out = new JSONOutputStream(fout);

            out.writeObject("absc");
            out.close();

        //Nasty-path: Write object with numbers
            try {
                fout = new FileOutputStream(String.valueOf(1234));
                out = new JSONOutputStream(fout);

                out.writeObject(1234);
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }

    //Happy-path for OutputStream
            fout = new FileOutputStream("names.txt");
            out = new JSONOutputStream(fout);

            out.writeObject(name);
            out.close();

    //Happy Path for reading values from testMap. Pull data into application. Data must be values of testMap or ArrayList.
            FileInputStream fin = new FileInputStream("names.txt");
            JSONInputStream in = new JSONInputStream(fin);

            HashMap parse = (HashMap)in.readObject();
            Names readNames = new Names(parse);

        /*Nasty Path-reading twice from a file that only has one thing in it. */
            try {
                parse = (HashMap) in.readObject();
            }
            catch (Exception e){
                e.printStackTrace();
            }

        //Nasty-path: Read numbers into application.
            try{
                fin = new FileInputStream(String.valueOf(1234));
                in = new JSONInputStream(fin);

                parse = (HashMap) in.readObject();
            }catch (Exception e){
                e.printStackTrace();
            }

        //Nasty-path: Read from a file or directory that doesn't exist.

            try{
                fin = new FileInputStream("Daemon.java");
                in = new JSONInputStream(fin);

                parse = (HashMap) in.readObject();
            }catch (Exception e){
                e.printStackTrace();
            }

        //Nasty-path: Read from a image file or file that doesn't have JSON.
            try{
                fin = new FileInputStream("names.jpg");
                in = new JSONInputStream(fin);

                parse = (HashMap) in.readObject();
            }catch (Exception e){
                e.printStackTrace();
            }


    //Happy Path for reading object.

            fin = new FileInputStream("names.txt");
            in = new JSONInputStream(fin);

            parse = (HashMap) in.readObject();
            readNames = new Names(parse);
            System.out.println("testMap returned?: " + readNames.equals(name));


    //Happy Path for Stringify. Stringify - converting JavaBean values into JSON strings
            String jsonString = JSONUtilities.stringify(readNames);

        //Nasty-path: Stringify fileoutputstrem
            try{
                jsonString = JSONUtilities.stringify(name);
            }catch(Exception e){
                e.printStackTrace();
            }

        //Nasty-path: image file
            try {
                //jsonString = JSONUtilities.stringify("name.img");
            }catch(Exception e){
                e.printStackTrace();
            }

        //Nasty-path: Stringify numbers
            try {
                jsonString = JSONUtilities.stringify(12345);
            }catch(Exception e){
                e.printStackTrace();
            }

        //Nasty path - Stringifying null
            jsonString = JSONUtilities.stringify(null);
            System.out.println("JSON: " + jsonString);

        //Nasty-path: stringify boolean value.
            try {
                jsonString = JSONUtilities.stringify(true);
            }catch(Exception e){
                e.printStackTrace();
            }

    //Happy Path for Stringify
            jsonString = JSONUtilities.stringify(readNames);
            System.out.println("JSON: " + jsonString);

    //Happy Path for parsing - Converts JSON strings to an instance. The object created will be a testMap or ArrayList.
    // If the string is not proper JSON string, Exception will be thrown.

            parse = (HashMap)JSONUtilities.parse(jsonString);


        //Nasty path - parsing null
            parse = (HashMap)JSONUtilities.parse(null);
            System.out.println(parse);

        //Nasty path - parsing empty string.
            try {
                parse = (HashMap) JSONUtilities.parse("");
                System.out.println(parse);
            }catch(Exception e){
                e.printStackTrace();
            }

        //Nasty path - parsing image file
            try {
                parse = (HashMap) JSONUtilities.parse("hansol.jpg");

            }catch(Exception e) {
                e.printStackTrace();
            }

    //Happy path for parsing

            parse = (HashMap)JSONUtilities.parse(jsonString);
            name = new Names(parse);
            System.out.println("Stringified and parsed? " + name.equals(name));


        }catch(JSONException e){
            e.printStackTrace();
        }
        catch(ClassCastException e){
            System.out.print("Class not found.");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
