package de.kai_morich.simple_bluetooth_terminal;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class TestSend extends AppCompatActivity {

    public String num,js;
    public String Dv1;
    public String Dv2;
    public String Dv3;
    public String P0;
    public String nozzle;
    public String hardness;
    public String elasticity;
    public String time;
    public String nomderp;
    public String BarCode;
    public String finvar;


    Button register, restart;
    EditText First_Name, Last_Name, Email, Password ;
    String L0_Holder, Dv1_Holder, Dv2_Holder, Dv3_Holder, P0_Holder, Name_Holder, BarCode_Holder, nozzle_Holder, hardness_Holder, elasticity_Holder, time_Holder, nomderp_Holder;
    String finalResult ;
    String HttpURL = "https://karasevv.com/wwwork/testshoe.php";
    Boolean CheckEditText ;
    ProgressDialog progressDialog;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_db);


        TextView textView2 = findViewById(R.id.textView2);



        Bundle arguments = getIntent().getExtras();
        BarCode = arguments.get("BarCode").toString();
        //num =  arguments.get("num").toString();
        num = "1111";
        js =  arguments.get("js").toString();
        finvar = js + ", \"barcode\":\"" + BarCode + "\"," + " \"Device_nomber\":\""+num+ "\"}";
        //Dv1 = arguments.get("Dv1").toString();
        //Dv2 = arguments.get("Dv2").toString();
        //Dv3 = arguments.get("Dv3").toString();
        //P0 = arguments.get("P0").toString();
        //nozzle = arguments.get("nozzle").toString();
        //hardness = arguments.get("hardness").toString();
        //elasticity = arguments.get("elasticity").toString();
        //time = arguments.get("time").toString();
        //nomderp = arguments.get("nomderp").toString();




        textView2.setText(finvar);





        //First_Name = (EditText)findViewById(R.id.editTextF_Name);
        //Last_Name = (EditText)findViewById(R.id.editTextL_Name);
        //Email = (EditText)findViewById(R.id.editTextEmail);
        //Password = (EditText)findViewById(R.id.editTextPassword);

        //First_Name.setText(Name);

        register = (Button)findViewById(R.id.Submit);
        restart = (Button)findViewById(R.id.Submit1);
        //log_in = (Button)findViewById(R.id.Login);

        //Adding Click Listener on button.
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Checking whether EditText is Empty or Not
                CheckEditTextIsEmptyOrNot();

                if(CheckEditText){

                    // If EditText is not empty and CheckEditText = True then this block will execute.

                    UserRegisterFunction(L0_Holder);
                    //UserRegisterFunction(L0_Holder, Dv1_Holder, Dv2_Holder, Dv3_Holder, P0_Holder, BarCode_Holder, nozzle_Holder, hardness_Holder, elasticity_Holder, time_Holder, nomderp_Holder);

                }
                else {

                    // If EditText is empty then this block will execute .
                    Toast.makeText(TestSend.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

                }


            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestSend.this, MainActivity.class);

                //intent.putExtra(UserEmail,email);

                startActivity(intent);

            }
        });

        //log_in.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {

        //       Intent intent = new Intent(TestSend.this, MainActivity.class);
        //      startActivity(intent);

        // }
        //});

    }

    public void CheckEditTextIsEmptyOrNot(){

        L0_Holder = finvar; //
        Dv1_Holder = Dv1;
        Dv2_Holder = Dv2;
        Dv3_Holder = Dv3;
        P0_Holder = P0;
        nozzle_Holder = nozzle;
        BarCode_Holder = BarCode;

        hardness_Holder = hardness;
        elasticity_Holder = elasticity;
        time_Holder = time;
        nomderp_Holder = nomderp;

        CheckEditText = true ;

        /*
        if(TextUtils.isEmpty(F_Name_Holder) || TextUtils.isEmpty(L_Name_Holder) || TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder))
        {

            CheckEditText = false;

        }
        else {

            CheckEditText = true ;
        }*/

    }

    public void UserRegisterFunction(final String l_0){
//public void UserRegisterFunction(final String l_0, final String dv_1, final String dv_2, final String dv_3, final String p_0, final String barcode, final String nozzle, final String hardness, final String elasticity, final String time, final String nomderp){
        class UserRegisterFunctionClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(TestSend.this,"Loading Data",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

                Toast.makeText(TestSend.this,httpResponseMsg.toString(), Toast.LENGTH_LONG).show();

            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("json",params[0]);

                //hashMap.put("dv_1",params[1]);

                //hashMap.put("dv_2",params[2]);

                //hashMap.put("dv_3",params[3]);

                //hashMap.put("p_0",params[4]);


                //hashMap.put("barcode",params[5]);

                //hashMap.put("nozzle",params[6]);

                //hashMap.put("hardness",params[7]);

                //hashMap.put("elasticity",params[8]);

                //hashMap.put("time",params[9]);

                //hashMap.put("nomderp",params[10]);

                finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }
        }

        UserRegisterFunctionClass userRegisterFunctionClass = new UserRegisterFunctionClass();

        userRegisterFunctionClass.execute(l_0,nozzle,hardness,elasticity,time,nomderp);
        //userRegisterFunctionClass.execute(l_0,dv_1,dv_2,dv_3,p_0,barcode,nozzle,hardness,elasticity,time,nomderp);
    }

}
