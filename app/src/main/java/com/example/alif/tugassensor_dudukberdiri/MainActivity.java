package com.example.alif.tugassensor_dudukberdiri;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.IOException;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView kondisi;
    private float X, Y, Z;
    private TextView currentX, currentY, currentZ;
    private SensorManager sensorManager;
    private Sensor accelerometer;
    final Classifier<String, String> bayes =
            new BayesClassifier<String, String>();


    //private String path = Environment.getExternalStorageDirectory().getAbsolutePath();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();

        kondisi = (TextView)findViewById(R.id.konsisi_value);;
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            // success! we have an accelerometer

            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            // fai! we dont have an accelerometer!
        }

        /*
         * Create a new classifier instance. The context features are
         * Strings and the context will be classified with a String according
         * to the featureset of the context.
         */


        String[] negativeText = "-0,79487 -9,79707 -0,31603".split("\\s");
        bayes.learn("Berdiri", Arrays.asList(negativeText));
        negativeText = "-0,82361 -9,89284 -0,32561".split("\\s");
        bayes.learn("Berdiri", Arrays.asList(negativeText));
        negativeText = "-0,77572 -9,87369 -0,32561".split("\\s");
        bayes.learn("Berdiri", Arrays.asList(negativeText));
        negativeText = "-1,13964 -10,15142 -0,651224".split("\\s");
        bayes.learn("Berdiri", Arrays.asList(negativeText));
        negativeText = "-0,63207 -9,87369 -0,63207".split("\\s");
        bayes.learn("Berdiri", Arrays.asList(negativeText));

//        negativeText = "-1.043.872 25.761.611 9.682.152".split("\\s");
//        bayes.learn("Berdiri", Arrays.asList(negativeText));
//        negativeText = "-11.683.705 23.654.714 9.241.618".split("\\s");
//        bayes.learn("Berdiri", Arrays.asList(negativeText));
//        negativeText = "-10.726.024 23.463.178 93.182.335".split("\\s");
//        bayes.learn("Berdiri", Arrays.asList(negativeText));
//        negativeText = "-2.087.744 40.414.124 9.758.766".split("\\s");
//        bayes.learn("Berdiri", Arrays.asList(negativeText));
//        negativeText = "-10.247.183 21.739.352 9.260.772".split("\\s");
//        bayes.learn("Berdiri", Arrays.asList(negativeText));
//
//        negativeText = "-10.247.183 21.739.352 9.260.772".split("\\s");
//        bayes.learn("Berdiri", Arrays.asList(negativeText));
//        negativeText = "-0.6799533 -9.739.613 -0.8810662".split("\\s");
//        bayes.learn("Berdiri", Arrays.asList(negativeText));
//        negativeText = "-1.091.756 -9.911.995 -0.7086837".split("\\s");
//        bayes.learn("Berdiri", Arrays.asList(negativeText));
//        negativeText = "-0.9768343 -1.001.734 -0.38307226".split("\\s");
//        bayes.learn("Berdiri", Arrays.asList(negativeText));
//        negativeText = "-1.091.756 -9.931.149 -0.31603462".split("\\s");
//        bayes.learn("Berdiri", Arrays.asList(negativeText));
//
//        negativeText = "0.0 -9.892.841 -0.6895301".split("\\s");
//        bayes.learn("Berdiri", Arrays.asList(negativeText));
//        negativeText = "0.49799395 -1.004.607 -0.22026655".split("\\s");
//        bayes.learn("Berdiri", Arrays.asList(negativeText));
//        negativeText = "1.292.869 -10.065.224 -0.89064306".split("\\s");
//        bayes.learn("Berdiri", Arrays.asList(negativeText));
//        negativeText = "-0.92895025 1.982.399 9.126.697".split("\\s");
//        bayes.learn("Berdiri", Arrays.asList(negativeText));
//        negativeText = "-0.6799533 24.995.465 9.385.271".split("\\s");
//        bayes.learn("Berdiri", Arrays.asList(negativeText));


        /*
         * The classifier can learn from classifications that are handed over
         * to the learn methods. Imagin a tokenized text as follows. The tokens
         * are the text's features. The category of the text will either be
         * positive or negative.
         */

        String[] positiveText = "3,83072 -2,09732 -9,20331".split("\\s");
        bayes.learn("Duduk", Arrays.asList(positiveText));
        positiveText = "3,77326 -2,07817 -9,24162".split("\\s");
        bayes.learn("Duduk", Arrays.asList(positiveText));
        positiveText = "3,69665 -2,03986 -9,27993".split("\\s");
        bayes.learn("Duduk", Arrays.asList(positiveText));
        positiveText = "3,81157 -2,04944 -9,24162".split("\\s");
        bayes.learn("Duduk", Arrays.asList(positiveText));
        positiveText = "3,75411 -2,03028 -9,25120".split("\\s");
        bayes.learn("Duduk", Arrays.asList(positiveText));
////
//        positiveText = "36.966.474 -20.111.294 -9.251.195".split("\\s");
//        bayes.learn("Duduk", Arrays.asList(positiveText));
//        positiveText = "34.859.576 -20.590.134 -9.212.888".split("\\s");
//        bayes.learn("Duduk", Arrays.asList(positiveText));
//        positiveText = "39.073.372 -21.164.744 -9.260.772".split("\\s");
//        bayes.learn("Duduk", Arrays.asList(positiveText));
//        positiveText = "36.966.474 -20.111.294 -9.251.195".split("\\s");
//        bayes.learn("Duduk", Arrays.asList(positiveText));
//        positiveText = "35.913.026 -29.975.405 -8.801.085".split("\\s");
//        bayes.learn("Duduk", Arrays.asList(positiveText));
//
//        positiveText = "42.521.024 -22.697.031 -8.839.393".split("\\s");
//        bayes.learn("Duduk", Arrays.asList(positiveText));



        //Log.d("StackOverflow", "pathTxt");
//        try {
//            ReadData readDUduk = new ReadData(bayes, "Duduk", "/storage/sdcard0/dataset-duduk.txt");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            ReadData readBerdiri = new ReadData(bayes, "Berdiri", "/sdcard/dataset-berdiri.txt");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /*
         * Now that the classifier has "learned" two classifications, it will
         * be able to classify similar sentences. The classify method returns
         * a Classification Object, that contains the given featureset,
         * classification probability and resulting category.
         */

        final String[] unknownText1 = "0,10534 -9,58638 -1,12049".split("\\s");

        /*
         * The BayesClassifier extends the abstract Classifier and provides
         * detailed classification results that can be retrieved by calling
         * the classifyDetailed Method.
         *
         * The classification with the highest probability is the resulting
         * classification. The returned List will look like this.
         * [
         *   Classification [
         *     category=
         *     negative,
         *     probability=0.0078125,
         *     featureset=[today, is, a, sunny, day]
         *   ],
         *   Classification [
         *     category=positive,
         *     probability=0.0234375,
         *     featureset=[today, is, a, sunny, day]
         *   ]
         * ]
         */
        ((BayesClassifier<String, String>) bayes).classifyDetailed(
                Arrays.asList(unknownText1));

        /*
         * Please note, that this particular classifier implementation will
         * "forget" learned classifications after a few learning sessions. The
         * number of learning sessions it will record can be set as follows:
         */
        bayes.setMemoryCapacity(500); // remember the last 500 learned classifications

        kondisi.setText(bayes.classify(Arrays.asList(unknownText1)).getCategory());
    }

    public void initializeViews() {
        currentX = (TextView) findViewById(R.id.currentX);
        currentY = (TextView) findViewById(R.id.currentY);
        currentZ = (TextView) findViewById(R.id.currentZ);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        displayCurrentValues();

        X = event.values[0];
        Y = event.values[1];
        Z = event.values[2];

        String temp = Float.toString(X) + " " + Float.toString(Y) + " " + Float.toString(Z);
        String text[] = temp.split("\\s");

        ((BayesClassifier<String, String>) bayes).classifyDetailed(
                Arrays.asList(text));

        kondisi.setText(bayes.classify(Arrays.asList(text)).getCategory());
//        //kondisi.setText(temp);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    //onResume() register the accelerometer for listening the events
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    //onPause() unregister the accelerometer for stop listening the events
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    // display the current x,y,z accelerometer values
    public void displayCurrentValues() {
        currentX.setText(Float.toString(X));
        currentY.setText(Float.toString(Y));
        currentZ.setText(Float.toString(Z));
    }
}

