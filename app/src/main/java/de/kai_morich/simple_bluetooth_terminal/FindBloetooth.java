package de.kai_morich.simple_bluetooth_terminal;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FindBloetooth extends AppCompatActivity {



    private BroadcastReceiver broadcastReceiver;

    //String lildata = "L0=253 Dv1=15654 Dv2=15687 Dv3=5264 P0=10 Name=SizeDevice12";
    public int len;
    // переменные на запись
    /*public String L0 = "";
    public String Dv1 = "";
    public String Dv2 = "";
    public String Dv3;
    public String P0;
    public String nozzle;
    public String hardness;
    public String elasticity;
    public String time;
    public String nomderp;

    public String[] UV;*/

    int k = 0;
    boolean stop;
    boolean stop1;
    String var1 = "jojo";
    String var2 = "polpo";

    String finvar;

    String finvar1;
    String finvar2;

    LinearLayout LnearLayout;

    Button register, log_in;

    //Button nextb  = findViewById(R.id.button1);
    String str;
    char[] strToArray;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blat);

        str = getIntent().getStringExtra("text");
        strToArray = str.toCharArray();

        //TextView textView = findViewById(R.id.textView);
        TextView textView1 = findViewById(R.id.textView);

        register = (Button)findViewById(R.id.button);
        //log_in = (Button)findViewById(R.id.Login);
        textView1.setText("f");
        //Adding Click Listener on button.

        //textView1.setText(new String(strToArray));
        finvar = ", \"" + var1 + "\":" + "\"" + var2 + "\"";


        //while (stop != true) {

                for (int i = 0; i < strToArray.length; i++) {
                    if (strToArray[i] != '{') {
                        strToArray[i] = '\0';

                        //stop = true;

                    }
                    if (strToArray[i] == '{') {
                        stop = true;
                        //strToArray1 = strToArray;
                        //textView.setText(strToArray[i] + " ");
                        while (stop1 != true) {
                            for (int c = strToArray.length - 1; c > 0; c = c - 1) {
                                if (strToArray[c] != '}') {
                                    strToArray[c] = '\0';
                                    //stop = true;
                                }
                                if (strToArray[c] == '}') {
                                    strToArray[c] = '\0';
                                    strToArray[c - 1] = '\0';
                                    stop1 = true;
                                    finvar1 = (new String(strToArray) + finvar + "}");
                                    //textView.setText(strToArray[i] + " ");
                                    finvar2 = (new String(strToArray));
                                    textView1.setText(finvar2);
                                    //


                                }
                            }
                        }
                    }


                }

        //}


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FindBloetooth.this, ScanBar.class);
                //intent.putExtra("L0", (new String(strToArray)+ finvar+"}"));
                intent.putExtra("js", finvar2);
                startActivity(intent);

            }
        });

    }
    //public void sendMes(View view) {
        //Intent intent = new Intent(this, ScanBar.class);
        //intent.putExtra("L0", (new String(strToArray)+ finvar+"}"));
        //intent.putExtra("Dv1", Dv1);
        //intent.putExtra("Dv2", Dv2);
        //intent.putExtra("Dv3", Dv3);
        //intent.putExtra("P0", P0);
        //intent.putExtra("nozzle", nozzle);
        //intent.putExtra("hardness", hardness);
        //intent.putExtra("elasticity", elasticity);
        //intent.putExtra("time", time);
        //intent.putExtra("nomderp", nomderp);

        //startActivity(intent);
    //}
    public void onStart(){



        super.onStart();
        //String[] BigArray = getIntent().getStringExtra("text").split("\\n");
        //String[] DataArray = BigArray[2].split(" ");



        //String[] MainArray = new  String[50];

        //len = BigArray.length;

        //TextView tv=(TextView)findViewById(R.id.receive_text);

        //TextView text=(TextView)findViewById(R.id.receive_text1);


        //TextView textL0=(TextView)findViewById(R.id.receive_textL0);
        //TextView textDv1=(TextView)findViewById(R.id.receive_textDv1);
        //TextView textDv2=(TextView)findViewById(R.id.receive_textDv2);
        //TextView textDv3=(TextView)findViewById(R.id.receive_textDv3);
        //TextView textP0=(TextView)findViewById(R.id.receive_textP0);
        //TextView textnozzle=(TextView)findViewById(R.id.receive_textnozzle);
        //TextView texthardness=(TextView)findViewById(R.id.receive_texthardness);
        //TextView textelasticity=(TextView)findViewById(R.id.receive_textelasticity);
        //TextView texttime=(TextView)findViewById(R.id.receive_texttime);
        //TextView textnomderp=(TextView)findViewById(R.id.receive_textnomderp);


        //Button nextb  = findViewById(R.id.button1);
        //nextb.setVisibility(View.INVISIBLE);

        //text.setText("Полученные данные:"+getIntent().getStringExtra("text"));
        //tv.setText("Выбор данных для отправки Выберите значение для переменной LO");


        //       && BigArray[i]!="connected" && BigArray[i]!="connection"
       // String[] MainArray = new String[len];
/*
        for (int i = 0; i < len; i++) {
            if(BigArray[i] != "connecting..."){
                MainArray[i] = BigArray[i];

                Button myButton = new Button(this);
                myButton.setText(MainArray[i]);//


                myButton.setOnClickListener(new View.OnClickListener() {//   +
                    @Override
                    public void onClick(View v) {

                        k = k+1;
                        //tv.setText("Выбор данных для отправки Выберите значение для переменной L0"+k);
                        if(k == 0){

                            tv.setText("Выбор данных для отправки Выберите значение для переменной Dv1");
                            L0 = (String) myButton.getText();
                            textL0.setText("L0 = " + L0);

                        }
                        if(k == 1){
                            Dv1 = (String) myButton.getText();
                            tv.setText("Выбор данных для отправки Выберите значение для переменной Dv2");
                            textDv1.setText("Dv1 = " + Dv1);
                            //i = i+1;
                        }
                        if(k == 2){
                            Dv2 = (String) myButton.getText();
                            tv.setText("Выбор данных для отправки Выберите значение для переменной Dv3");
                            textDv2.setText("Dv2 = " + Dv2);
                            //i = i+1;
                        }
                        if(k == 3){
                            Dv3 = (String) myButton.getText();
                            tv.setText("Выбор данных для отправки Выберите значение для переменной P0");
                            textDv3.setText("Dv3 = " + Dv3);
                            //i = i+1;
                        }
                        if(k == 4){
                            P0 = (String) myButton.getText();
                            tv.setText("Выбор данных для отправки Выберите значение для переменной Упругость");
                            textP0.setText("P0 = " + P0);
                            //i = i+1;
                        }
                        if(k == 5){
                            nozzle = (String) myButton.getText();
                            tv.setText("Выбор данных для отправки Выберите значение для переменной Твердость");
                            textnozzle.setText("nozzle = " + nozzle);
                            //i = i+1;
                        }
                        if(k == 6){
                            hardness = (String) myButton.getText();
                            tv.setText("Выбор данных для отправки Выберите значение для переменной Эластичность");
                            texthardness.setText("hardness = " + hardness);
                            //i = i+1;
                        }
                        if(k == 7){
                            elasticity = (String) myButton.getText();
                            tv.setText("Выбор данных для отправки Выберите значение для переменной Время замера");
                            textelasticity.setText("elasticity = " + elasticity);
                            //i = i+1;
                        }
                        if(k == 8){
                            time = (String) myButton.getText();
                            tv.setText("Выбор данных для отправки Выберите значение для переменной Время замера");
                            texttime.setText("time = " + time);
                            //i = i+1;
                        }
                        if(k == 9){
                            nomderp = (String) myButton.getText();
                            tv.setText("Выбор данных завершен, отсканируйте штрихкод");
                            textnomderp.setText("nomderp = " + nomderp);
                            nextb.setVisibility(View.VISIBLE);
                            //i = i+1;
                        }
                        //tv.setText( myButton.getText());
                    }
                });//

                LnearLayout = findViewById(R.id.rlativeLayout1);
                LnearLayout.addView(myButton);
            }
        }*/
    }
}
