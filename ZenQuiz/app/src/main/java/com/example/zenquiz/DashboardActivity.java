package com.example.zenquiz;

import static com.example.zenquiz.MainActivity.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar;


import java.util.Collections;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    CountDownTimer countDownTimer;
    int timerValue = 20;
    RoundedHorizontalProgressBar progressBar;
    List<Modelclass> allQuestionList;
    Modelclass modelclass = new Modelclass();
    int index = 0;
    TextView card_quetion, optiona, optionb, optionc, optiond;
    CardView cardOA, cardOB, cardOC, cardOD;
    int correctCount = 0;
    int wrongCount = 0;
    LinearLayout BtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        AddControl();
        allQuestionList = list;
        Collections.shuffle(allQuestionList);
        modelclass = list.get(index);

        cardOA.setBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setBackgroundColor(getResources().getColor(R.color.white));

        BtnNext.setClickable(false);


        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerValue = timerValue - 1;
                progressBar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(DashboardActivity.this, R.style.Dialoge);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialog);

                dialog.findViewById(R.id.btntryAgain).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();
            }
        }.start();
        setAllData();
    }


    private void setAllData() {
            card_quetion.setText(modelclass.getQuetion());
            optiona.setText(modelclass.getoA());
            optionb.setText(modelclass.getoB());
            optionc.setText(modelclass.getoC());
            optiond.setText(modelclass.getoD());
    }

    private void AddControl() {
            progressBar=findViewById(R.id.quiz_timer);
            card_quetion=findViewById(R.id.card_quetion);
            optiona=findViewById(R.id.card_optiona);
            optionb=findViewById(R.id.card_optionb);
            optionc=findViewById(R.id.card_optionc);
            optiond=findViewById(R.id.card_optiond);

            cardOA=findViewById(R.id.cardA);
            cardOB=findViewById(R.id.cardB);
            cardOC=findViewById(R.id.cardC);
            cardOD=findViewById(R.id.cardD);

            BtnNext=findViewById(R.id.BtnNext);


    }

    public void Correct(CardView cardview){
        cardview.setBackgroundColor(getResources().getColor(R.color.green));
        BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctCount++;
                index++;
                modelclass=list.get(index);
                resetColor();
                setAllData();
                enableBtn();
            }
        });
    }
    public void Wrong(CardView cardview){
        cardview.setBackgroundColor(getResources().getColor(R.color.red));
        BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongCount++;
                if (index<list.size()-1){
                    index++;
                    modelclass=list.get(index);
                    setAllData();
                    resetColor();
                    enableBtn();
                }else {
                    GameWon();
                }
            }
        });
    }

    private void GameWon() {
        Intent intent = new Intent(DashboardActivity.this,WonActivity.class);
        intent.putExtra("correct",correctCount);
        intent.putExtra("wrong",wrongCount);
        startActivity(intent);
    }


    public void enableBtn(){
        cardOA.setClickable(true);
        cardOB.setClickable(true);
        cardOC.setClickable(true);
        cardOD.setClickable(true);
    }
    public void disableBtn(){
        cardOA.setClickable(false);
        cardOB.setClickable(false);
        cardOC.setClickable(false);
        cardOD.setClickable(false);
    }
    public void resetColor(){
        cardOA.setBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void OptionAClick(View view) {
        disableBtn();
        BtnNext.setClickable(true);
        if(modelclass.getoA().equals(modelclass.getAns()))
        {
            cardOA.setBackgroundColor(getResources().getColor(R.color.green));

            if (index<list.size()-1){
                Correct(cardOA);
            }else {
                GameWon();
            }
        }else {
            Wrong(cardOA);
        }
    }

    public void OptionBClick(View view) {
        disableBtn();
        BtnNext.setClickable(true);
        if(modelclass.getoB().equals(modelclass.getAns()))
        {
            cardOB.setBackgroundColor(getResources().getColor(R.color.green));

            if (index<list.size()-1){
                Correct(cardOB);
            }else {
                GameWon();
            }
        }else {
            Wrong(cardOB);
        }
    }

    public void OptionClick(View view) {
        disableBtn();
        BtnNext.setClickable(true);
        if(modelclass.getoC().equals(modelclass.getAns()))
        {
            cardOC.setBackgroundColor(getResources().getColor(R.color.green));

            if (index<list.size()-1){
                Correct(cardOC);
            }else {
                GameWon();
            }
        }else {
            Wrong(cardOC);
        }
    }

    public void OptionDlick(View view) {
        disableBtn();
        BtnNext.setClickable(true);
        if(modelclass.getoD().equals(modelclass.getAns()))
        {
            cardOD.setBackgroundColor(getResources().getColor(R.color.green));

            if (index<list.size()-1){
                Correct(cardOD);
            }else {
                GameWon();
            }
        }else {
            Wrong(cardOD);
        }
    }
}