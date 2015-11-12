package com.example.alif.tugassensor_dudukberdiri;

import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReadData {

    private TextView text_posisi;

    ReadData(Classifier bayes, String kategori, String pathTxt) throws IOException {
        FileInputStream is = null;
        BufferedReader reader;
        final File file = new File(pathTxt);

        if (file.exists()) {
            try {
                is = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            reader = new BufferedReader(new InputStreamReader(is));
            String line = null;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Log.d("StackOverflow", line);
//            String[] temp = line.split("\\s");
//            bayes.learn(kategori, Arrays.asList(temp));

            while((line = reader.readLine()) != null){
                line = reader.readLine();
                Log.d("StackOverflow", line);
                String[] temp = line.split("\\s");
                bayes.learn(kategori, Arrays.asList(temp));
            }
            //Log.d("StackOverflow",  );
        }
        }
}
