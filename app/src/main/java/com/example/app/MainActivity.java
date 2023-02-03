package com.example.app;

import static java.lang.Integer.parseInt;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Button bt;
    EditText node;
    EditText round;
    EditText  possibi;
    EditText  emaxi;
    EditText  ecurrent;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=findViewById(R.id.button);
        node=findViewById(R.id.nbnode);
        round=findViewById(R.id.nbround);
        possibi=findViewById(R.id.possi);
        emaxi=findViewById(R.id.maxi);
        ecurrent=findViewById(R.id.e);
        bt.setOnClickListener(view -> {
            String nodes=node.getText().toString();
            int N= parseInt(nodes);
            String rounds=round.getText().toString();
            int R= parseInt(rounds);
            String possi=possibi.getText().toString();
            int p= parseInt(possi);
            String emax=emaxi.getText().toString();
            int E_max= parseInt(emax);
            String E=ecurrent.getText().toString();
            String[] str = E.split(getString(com.example.app.R.string.spliting));
            int size = str.length;
            int [] arr = new int [size];

            for(int i=0; i<size; i++) {
                arr[i] = parseInt(str[i]);}
            int id=size;
            String[] results=new String[R];
            for(int r=1;r<=R ;r++) {
                int[] tns = new int[size];
                for (int n = 0; n < N; n++) {
                    if(n==id){
                        tns[n]=0;
                    }
                    else {
                        int E_currentx=arr[n];
                        int tn = (p / (1 - p * (r * (1 % p)))) * ( E_currentx / E_max);
                        tns[n] = tn;
                    }
                }
                //id du cluster head
                int max = Arrays.stream(arr).max().getAsInt();
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == max) {
                        id=i;
                    }
                }
                arr[id]--;
                String idnode=Integer.toString(id);
                String roundnumber=Integer.toString(r);
                String resultat;
                if(tns==null){
                     resultat= roundnumber+"  :  all nodes are dead ";
                }else{
                     resultat= roundnumber+"  :"+idnode;
                }
                results[r]=resultat;
            }
            Intent intent = new Intent(MainActivity.this, resultActivity.class);
            intent.putExtra("TextView",results);
            startActivity(intent);

        });








}

}