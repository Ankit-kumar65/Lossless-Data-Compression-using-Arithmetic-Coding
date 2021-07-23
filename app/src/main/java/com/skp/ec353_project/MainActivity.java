package com.skp.ec353_project;



import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }








    private TextView txt,txt2;
    private TextView result;
    private Button toEncodeBtn;
    private Button toAlphaBtn;
    private Button toengBtn;

    private  Button b111;

    public static class AriCode {


        static String[] ALPHA = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
                "s", "t", "u", "v", "w", "x", "y", "z","1", "2", "3", "4", "5", "6", "7", "8", "9","0"} ;

        static String[] Fre = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
                "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26","1", "2", "3", "4", "5", "6", "7", "8", "9","0"};

        static String[] ALPHA2 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
                "s", "t", "u", "v", "w", "x", "y", "z"} ;

        static String[] Fre2 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
                "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26"};


        public static HashMap<String, String> ALPHA_TO_Fre = new HashMap<>();
        public static HashMap<String, String> Fre_TO_ALPHA = new HashMap<>();

        static {
            for (int i = 0; i < ALPHA.length  &&  i < Fre.length; i++) {
                ALPHA_TO_Fre.put(ALPHA[i], Fre[i]);
                Fre_TO_ALPHA.put(Fre[i], ALPHA[i]);
            }
        }


        public static HashMap<String, String> ALPHA2_TO_Fre2 = new HashMap<>();
        public static HashMap<String, String> Fre2_TO_ALPHA2 = new HashMap<>();

        static {
            for (int i = 0; i < ALPHA2.length  &&  i < Fre2.length; i++) {
                ALPHA2_TO_Fre2.put(ALPHA2[i], Fre2[i]);
                Fre2_TO_ALPHA2.put(Fre2[i], ALPHA2[i]);
            }
        }



        public static String encode(String englishCode) {


            int k = 0, j;
            int x;
            double T;
            double[] l;
            l = new double[1000];
            double[] u;
            u = new double[1000];

            l[0] = 0;
            u[0] = 1;
            double[] f ={0, 0.04, 0.08, 0.125, 0.165, 0.2, 0.24, 0.28, 0.32, 0.36, 0.4, 0.44, 0.48, 0.52, 0.56, 0.6, 0.64, 0.68, 0.72, 0.76, 0.8, 0.84, 0.88, 0.92, 0.94, 0.97, 1};

            if (k < 0 && k >= 27) {
                f[k] = 0;
            }


            StringBuilder builder = new StringBuilder();

            String[] words = englishCode.trim().split(" ");


            for (String word : words) {

                for (int i = 0; i < word.length(); i++) {

                    String code = ALPHA_TO_Fre.get(word.substring(i, i + 1).toLowerCase());
                    x = Integer.parseInt(code);
                    j = i + 1;


                    l[j] = l[j - 1] + (u[j - 1] - l[j - 1]) * f[x - 1];

                    u[j] = l[j - 1] + (u[j - 1] - l[j - 1]) * f[x];








                }

                T = (l[word.length()] + u[word.length()]) / 2;



                String s = Double.toString(T);
                builder.append(s).append("");


            }


            return builder.toString();


        }



















        public static String decode(String Code,String Dig) {


            int k = 0, j,D;
            int x;
            double T;
            double[] l;
            l = new double[1000];
            double[] u;
            u = new double[1000];

            l[0] = 0;
            u[0] = 1;
            double[] f = {0, 0.04, 0.08, 0.125, 0.165, 0.2, 0.24, 0.28, 0.32, 0.36, 0.4, 0.44, 0.48, 0.52, 0.56, 0.6, 0.64, 0.68, 0.72, 0.76, 0.8, 0.84, 0.88, 0.92, 0.94, 0.97, 1};

            if (k < 0 && k >= 27) {
                f[k] = 0;
            }


            StringBuilder builder = new StringBuilder();

            Double tag = Double.parseDouble(Code);




            D = Integer.parseInt(Dig);




            for (int i = 0; i < D; i++) {
                j = i + 1;

                for (x = 1; x < 31; x++) {

                    l[j] = l[j - 1] + (u[j - 1] - l[j - 1]) * f[x - 1];

                    u[j] = l[j - 1] + (u[j - 1] - l[j - 1]) * f[x];


                    T = (l[j] + u[j]) / 2;

                    if (l[j] <= tag && u[j] >= tag) {
                        break;
                    } else {
                        continue;

                    }

                }

                String s= Integer.toString(x);

                String alp = Fre_TO_ALPHA.get(s);

                builder.append(x).append(" ");

            }
            return builder.toString();

        }





        public static String decode2(String Code,String Dig) {


            int k = 0, j;
            int x;
            double T,D ;
            double[] l;
            l = new double[1000];
            double[] u;
            u = new double[1000];

            l[0] = 0;
            u[0] = 1;
            double[] f ={0, 0.04, 0.08, 0.125, 0.165, 0.2, 0.24, 0.28, 0.32, 0.36, 0.4, 0.44, 0.48, 0.52, 0.56, 0.6, 0.64, 0.68, 0.72, 0.76, 0.8, 0.84, 0.88, 0.92, 0.94, 0.97, 1};

            if (k < 0 && k >= 27) {
                f[k] = 0;
            }


            StringBuilder builder = new StringBuilder();

            Double tag = Double.parseDouble(Code);


            D = Integer.parseInt(Dig);



            for (int i = 0; i < D; i++) {
                j = i + 1;

                for (x = 1; x < 31; x++) {

                    l[j] = l[j - 1] + (u[j - 1] - l[j - 1]) * f[x - 1];

                    u[j] = l[j - 1] + (u[j - 1] - l[j - 1]) * f[x];


                    T = (l[j] + u[j]) / 2;

                    if (l[j] <= tag && u[j] >= tag) {
                        break;
                    } else {
                        continue;

                    }

                }

                String s= Integer.toString(x);

                String alp = Fre2_TO_ALPHA2.get(s);

                builder.append(alp).append("");

            }
            return builder.toString();

        }


    }

















    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txt = (TextView) findViewById(R.id.txt);
        txt2 = (TextView) findViewById(R.id.txt2);
        result = (TextView) findViewById(R.id.result);
        toEncodeBtn = (Button) findViewById(R.id.toEncodeBtn);
        toAlphaBtn = (Button) findViewById(R.id.toAlphaBtn);
        toengBtn = (Button) findViewById(R.id.toengBtn);
        b111 = (Button) findViewById(R.id.b23);

        toEncodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String txtToConvert = txt.getText().toString();
                if(txtToConvert.isEmpty()){
                    Toast.makeText(MainActivity.this , "Please Type Input for Encode", Toast.LENGTH_SHORT).show();
                }
                else {
                    String convertedTxt = AriCode.encode(txtToConvert);
                    result.setText(convertedTxt);
                }
            }
        });


        toAlphaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtToConvert = txt.getText().toString();
                String txtToConvert2 = txt2.getText().toString();

                if (txtToConvert.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Type Input for Decode", Toast.LENGTH_SHORT).show();
                }
                else if (txtToConvert2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Type No of Digit", Toast.LENGTH_SHORT).show();
                }

                else{
                    String convertedTxt = AriCode.decode(txtToConvert, txtToConvert2);

                result.setText(convertedTxt);}

            }
        });

        toengBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtToConvert = txt.getText().toString();
                String txtToConvert2 = txt2.getText().toString();

                if (txtToConvert.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Type Input for Decode", Toast.LENGTH_SHORT).show();
                }
                else if (txtToConvert2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Type No of Digit", Toast.LENGTH_SHORT).show();
                }

                else{
                    String convertedTxt = AriCode.decode2(txtToConvert, txtToConvert2);

                    result.setText(convertedTxt);}

            }
        });


        b111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager cliphboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip= ClipData.newPlainText("text",result.getText().toString());
                cliphboard.setPrimaryClip(clip);
                Toast.makeText(MainActivity.this , "copied", Toast.LENGTH_SHORT).show();



            }
        });



    }
}
