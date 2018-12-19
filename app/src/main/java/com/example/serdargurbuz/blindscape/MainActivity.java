package com.example.serdargurbuz.blindscape;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    int levelSize;
    Player player1;
    Level levelOne;
    static Vibrator v;
    static String currentText;
    TextView currentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        levelSize = 6;
        levelOne = new Level(levelSize, 1);
        levelOne.setGameObject(0, 2, 0, "Kapı",false,"");
        levelOne.setGameObject(2,0,0,"Masa",false,"");
        levelOne.setGameObject(2,0,1,"Anahtar",true,"");
        player1 = new Player(levelOne);


        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        currentTextView = findViewById(R.id.currentObject);
        currentText = "";

        display();
    }

    public void moveButton(View v){
        if (v.getId() == R.id.upButton){
            player1.move("up");
        }
        else if (v.getId() == R.id.downButton){
            player1.move("down");
        }
        else if (v.getId() == R.id.leftButton){
            player1.move("left");
        }
        else if (v.getId() == R.id.rightButton){
            player1.move("right");
        }
        player1.look();
        display();
    }

    public void display(){
        TextView text = findViewById(R.id.text);
        String str = "";
        int x = player1.getLocationX();
        int y = player1.getLocationY();
        for(int i = 0; i < levelSize; i++){
            for(int j = 0; j < levelSize; j++){
                Cell c = (levelOne.getMap().getCells())[i][j];
                if (c.isEdge()){
                    str += c.count;
                }
                else {
                    if (x == i && y == j){
                        str += "P";
                    }
                    else {
                        str += "h";
                    }
                }
            }
            str += "\n";
        }
        text.setText(str);
        currentTextView.setText(currentText);
    }
}
