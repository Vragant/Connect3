package com.example.vragant.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Variables para inicializar el juego
    // rojo: 0 amarillo:1 vacio:2

    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int [][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean yellowPlayer = true;

    public void dropIn (View view) {
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if (gameState[tappedCounter] == 2){
            //TODO: Hacer que no se puedan sobreescribir las tiradas
        }
        int player = yellowPlayer? 1:0;
        Log.i("Info","El jugador activo es: " + player);
        gameState[tappedCounter] = player;
        counter.setTranslationY(-1500);

        // Alternar fichas
        if (yellowPlayer) {
            counter.setImageResource(R.drawable.yellow);
            yellowPlayer = false;
        } else {
            counter.setImageResource(R.drawable.red);
            yellowPlayer = true;
        }
        counter.animate().translationYBy(1500).setDuration(300);

        //TODO: Hacer esto de una forma mas elegante

        // Esto es para checar si ya hay un ganador
        for (int[] winningPositions : winningPositions){
            if (gameState[winningPositions[0]] == gameState[winningPositions[1]] && gameState[winningPositions[1]] == gameState[winningPositions[2]] && gameState[winningPositions[2]] != 2){
                String winner = "";
                if (player == 1){
                    winner = "Amarillo";
                } else {
                    winner = "Rojo";
                }
                Toast.makeText(this, "El ganador es el color " + winner + "!!!", Toast.LENGTH_SHORT).show();
            }
        }
    //TODO: Poder Resetear el juego
    }
}
