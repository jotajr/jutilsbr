package br.com.jotajr.conversoes;

/**
 * Created by j.freitas.junior on 05/03/2017.
 */
public class Volume {

    private static Volume ourInstance;

    public static Volume getInstance() {
        if(ourInstance == null) {
            ourInstance = new Volume();
        }
        return ourInstance;
    }

    private Volume() {
    }
}
