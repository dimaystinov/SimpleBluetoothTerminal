package de.kai_morich.simple_bluetooth_terminal;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.HashMap;

public class StartActivity extends AppCompatActivity {
    EditText Email, Password;
    Button LogIn, Next;
    String PasswordHolder, EmailHolder;
    String finalResult ;
    String numb, js;
    String HttpURL = "https://karasevv.com/wwwork/testshoe.php";
    Boolean CheckEditText ;
    ProgressDialog progressDialog;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();
    public static final String UserEmail = "";
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Bundle arguments = getIntent().getExtras();
        js = arguments.get("js").toString();


        Email = (EditText)findViewById(R.id.email);
        Password = (EditText)findViewById(R.id.password);
        LogIn = (Button)findViewById(R.id.Login);

        Next = (Button)findViewById(R.id.next);
        Next.setVisibility(View.INVISIBLE);

        text = (TextView)findViewById(R.id.textView);

        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CheckEditTextIsEmptyOrNot();

                if(CheckEditText){

                    UserLoginFunction(EmailHolder, PasswordHolder);

                }
                else {

                    Toast.makeText(StartActivity.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

                }

            }
        });
    }
    public void CheckEditTextIsEmptyOrNot(){

        EmailHolder = Email.getText().toString();
        PasswordHolder = Password.getText().toString();

        if(TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder))
        {
            CheckEditText = false;
        }
        else {

            CheckEditText = true ;
        }
    }

    public void UserLoginFunction(final String email, final String password){

        class UserLoginClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(StartActivity.this,"Loading Data",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

                if(httpResponseMsg.equalsIgnoreCase("Data Matched")){

                    finish();

                    Intent intent = new Intent(StartActivity.this, ScanBar.class);

                    //intent.putExtra(UserEmail,email);
                    intent.putExtra("num", numb);
                    intent.putExtra("js", js);

                    startActivity(intent);

                }
                else{

                    Toast.makeText(StartActivity.this,httpResponseMsg,Toast.LENGTH_LONG).show();
                    numb = httpResponseMsg;
                    text.setText(numb);
                    Next.setVisibility(View.VISIBLE);
                }

            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("email",params[0]);

                hashMap.put("password",params[1]);

                finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }
        }

        UserLoginClass userLoginClass = new UserLoginClass();

        userLoginClass.execute(email,password);
    }
    public void onMyButtonClick(View view)
    {
        Intent intent = new Intent(StartActivity.this, ScanBar.class);

        intent.putExtra("num",numb);
        intent.putExtra("text",js);

        startActivity(intent);
    }

}