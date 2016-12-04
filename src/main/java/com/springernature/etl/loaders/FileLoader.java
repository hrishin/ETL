package com.springernature.etl.loaders;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by hrishikeshshinde on 04/12/16.
 */
public class FileLoader implements Loader {

    private final String filePath;

    public FileLoader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean load(Object transformedContent) {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        try {
            fout = new FileOutputStream(filePath);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(transformedContent);
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cleanFileStream(fout);
            cleanObjectStream(oos);
        }

        return false;
    }

    private void cleanFileStream(FileOutputStream fout) {
        if (fout != null) {
            try {
                fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void cleanObjectStream(ObjectOutputStream oos) {
        if (oos != null) {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
