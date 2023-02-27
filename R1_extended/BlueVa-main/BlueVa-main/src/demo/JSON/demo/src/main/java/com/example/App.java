package com.example;

/**
 * Hello world!
 */

import java.io.FileWriter;

public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     * @throws IOException
     */
    public static void main(String[] args){
        System.out.println("Hello World!");
        Method obj = new Method("Nishanth", 21, "TamilNadu");
        System.out.println(obj.getJSONAsString());

        try{
            FileWriter fileWriter=  new FileWriter("sample.json");
            fileWriter.write(obj.getJSONAsString());

            fileWriter.close();
        }
        catch ( Exception e) {

        }
    }
}
