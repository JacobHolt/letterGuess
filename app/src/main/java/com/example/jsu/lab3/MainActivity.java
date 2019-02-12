package com.example.jsu.lab3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.*;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    String word;
    String mixedWord;
    String shuffledWord = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ArrayList<String> secretWords = new ArrayList(Arrays.asList("APPLE", "BANANA", "CHERRY"));
        Random random = new Random();
        int rand = random.nextInt((secretWords.size() - 1) + 1) - 1;
        word = secretWords.get(rand);
        ArrayList<String> splitWord = new ArrayList(Arrays.asList(word.split("")));
        Collections.shuffle(splitWord);
        for (String c : splitWord)
            shuffledWord += c;

        TextView scrambledWord = (TextView) findViewById(R.id.scrambledWord);
        scrambledWord.setText(shuffledWord);
        mixedWord = shuffledWord;
    }

    public void guessButtonClicked(View v) {
        int inGuess = 0;
        int corrGuess = 0;
        TextView incorrectGuesses = (TextView) findViewById(R.id.incorrectGuesses);
        TextView correctLetter = (TextView) findViewById(R.id.correctLetters);
        EditText userinput = (EditText) findViewById(R.id.userInput);

        if(userinput.equals(mixedWord.charAt(corrGuess))) {
            corrGuess++;
            correctLetter.setText(shuffledWord.charAt(corrGuess));
            userinput.setText("");
        }
        else if(!userinput.equals(mixedWord.charAt(corrGuess))) {
            inGuess++;
            incorrectGuesses.setText(inGuess);
            userinput.setText("");
        }
        else {}
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
}