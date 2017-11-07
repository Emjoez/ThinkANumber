package com.example.emjoe.guessinggame;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn_plus, btn_minus, btn_send;
    private TextView number;
    private ImageView img_1,img_2,img_3,img_4,img_5;
    private int tippelt_szam = 0, kitalalando_szam = 0,  eletek = 5;

    private AlertDialog.Builder alert_nyert;
    private AlertDialog.Builder alert_veszt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        alert_nyert.setTitle("Nyertél!")
                .setMessage("Szeretnéd újrakezdeni a játékot?")
                .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        newgame();
                    }
                })
                .setCancelable(false)
                .create();

        alert_veszt.setTitle("Vesztettél!")
                .setMessage("Szeretnéd újrakezdeni a játékot?")
                .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        newgame();
                    }
                })
                .setCancelable(false)
                .create();



        Random rand = new Random();
        kitalalando_szam = rand.nextInt(20)+1;

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tippelt_szam < 20){
                    tippelt_szam++;
                    number.setText("" + tippelt_szam);
                }
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tippelt_szam > 0){
                    tippelt_szam--;
                    number.setText("" + tippelt_szam);
                }
            }
        });

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tippelt_szam == kitalalando_szam) {
                    Toast.makeText(MainActivity.this, "Nyertél!", Toast.LENGTH_SHORT).show();
                    alert_nyert.show();
                    if(eletek > 1) {
                        eletek--;
                    } else if (eletek == 1) {
                        img_5.setImageResource(R.drawable.heart1);

                    }


                }else if (tippelt_szam > kitalalando_szam) {

                    Toast.makeText(MainActivity.this, "Kisebb számra gondoltam!", Toast.LENGTH_SHORT).show();

                    if(eletek > 1) {
                        eletek--;
                    } else if (eletek == 1) {
                        img_5.setImageResource(R.drawable.heart1);
                        alert_veszt.show();

                    }

                    if (eletek == 4) {
                        img_1.setImageResource(R.drawable.heart1);
                    } else if (eletek == 3) {
                        img_2.setImageResource(R.drawable.heart1);
                    } else if (eletek == 2) {
                        img_3.setImageResource(R.drawable.heart1);
                    } else if (eletek == 1) {
                        img_4.setImageResource(R.drawable.heart1);
                    }
                }else if (tippelt_szam < kitalalando_szam) {

                    Toast.makeText(MainActivity.this, "Nagyobb számra gondoltam!", Toast.LENGTH_SHORT).show();

                    if(eletek > 1) {
                        eletek--;
                    } else if (eletek == 1) {
                        img_5.setImageResource(R.drawable.heart1);
                        alert_veszt.show();

                    }

                    if (eletek == 4) {
                        img_1.setImageResource(R.drawable.heart1);
                    } else if (eletek == 3) {
                        img_2.setImageResource(R.drawable.heart1);
                    } else if (eletek == 2) {
                        img_3.setImageResource(R.drawable.heart1);
                    } else if (eletek == 1) {
                        img_4.setImageResource(R.drawable.heart1);
                    }
                }
            }
        });
    }
    public void init(){
        btn_plus = (Button) findViewById(R.id.button_plus);
        btn_minus = (Button) findViewById(R.id.button_minus);
        btn_send = (Button) findViewById(R.id.button_send);

        number = (TextView) findViewById(R.id.textView_number);

        img_1 = (ImageView) findViewById(R.id.imageView_heart1);
        img_2 = (ImageView) findViewById(R.id.imageView_heart2);
        img_3 = (ImageView) findViewById(R.id.imageView_heart3);
        img_4 = (ImageView) findViewById(R.id.imageView_heart4);
        img_5 = (ImageView) findViewById(R.id.imageView_heart5);

        alert_nyert = new AlertDialog.Builder(MainActivity.this);
        alert_veszt = new AlertDialog.Builder(MainActivity.this);
    }

    public void newgame() {
        Random new_rand = new Random();
        kitalalando_szam = new_rand.nextInt(20)+1;
        tippelt_szam = 0;
        eletek = 5;
        img_1.setImageResource(R.drawable.heart2);
        img_2.setImageResource(R.drawable.heart2);
        img_3.setImageResource(R.drawable.heart2);
        img_4.setImageResource(R.drawable.heart2);
        img_5.setImageResource(R.drawable.heart2);
        number.setText("0");
    }

    public void finish() {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }


}
