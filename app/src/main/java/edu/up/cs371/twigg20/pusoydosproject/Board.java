package edu.up.cs371.twigg20.pusoydosproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;

/**
 * Created by Jason, Josh, Tawny and Cole on 2/1/2018.
 * An example of mid-game prototype for the GUI of our Pusoy Dos app.
 */


public class Board extends SurfaceView{

    //Creating instances of Bitmap objects to be used for each picture on the board

    //Class level Bitmaps for each card

    private Bitmap firstCard = null;
    private Bitmap secondCard = null;
    private Bitmap thirdCard = null;
    private Bitmap fourthCard = null;
    private Bitmap fifthCard = null;
    private Bitmap sixthCard = null;
    //


    //Class level Bitmap for the text “Pusoy Dos”

    private Bitmap title = null;


    //Class level Bitmaps for the Buttons

    private Bitmap button1 = null;
    private Bitmap cardBack = null;
    private Bitmap button3 = null;

    /*
     * Board
     *
     * The constructor constructs the board and calls generalInit()
     */
    public Board(Context context) {
        super(context);
        generalInit();

    }
    /*
     * Board
     *
     * Constructor for board with different parameters and attributes
     * Calls generalInit()
     */
    public Board(Context context, AttributeSet attrs) {
        super(context, attrs);
        generalInit();

    }
    /*
     * Board
     *
     * Last constructor has even more parameters and attributes
     * Calls generalInit()
     */
    public Board(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        generalInit();

    }

    /**
     * generalInit
     *
     * Initialization stuff used by all ctors
     */
    public void generalInit(){

        setWillNotDraw(false);

        /*
         * decodeResource sets each of the card bitmaps to a named png file in
         * drawable folder for us to use
         * createScaledBitmap allows us to change the pixel size of original file
         */
        firstCard = BitmapFactory.decodeResource(getResources(), R.drawable.c01);
        firstCard = Bitmap.createScaledBitmap(firstCard,170,270, false);
        secondCard = BitmapFactory.decodeResource(getResources(), R.drawable.d11);
        secondCard = Bitmap.createScaledBitmap(secondCard, 170,270, false);
        thirdCard = BitmapFactory.decodeResource(getResources(), R.drawable.h07);
        thirdCard = Bitmap.createScaledBitmap(thirdCard, 170,270, false);
        fourthCard = BitmapFactory.decodeResource(getResources(), R.drawable.s12);
        fourthCard = Bitmap.createScaledBitmap(fourthCard, 170,270, false);
        fifthCard = BitmapFactory.decodeResource(getResources(), R.drawable.h01);
        fifthCard = Bitmap.createScaledBitmap(fifthCard, 170,270, false);
        sixthCard = BitmapFactory.decodeResource(getResources(), R.drawable.s07);
        sixthCard = Bitmap.createScaledBitmap(sixthCard, 170,270, false);

        /**

         * creates "buttons" to represent the other players and how many cards
         * they have left
         */
        button1 = BitmapFactory.decodeResource(getResources(), R.drawable.button);
        button1 = Bitmap.createScaledBitmap(button1, 200, 100, false);
        cardBack = BitmapFactory.decodeResource(getResources(), R.drawable.card);
        cardBack = Bitmap.createScaledBitmap(cardBack, 270, 170, false);
        button3 = BitmapFactory.decodeResource(getResources(), R.drawable.button);
        button3 = Bitmap.createScaledBitmap(button3, 230, 90, false);

        //draws "Pusoy Dos" title onto upper center of board
        title = BitmapFactory.decodeResource(getResources(), R.drawable.pusoydostitle);
        title = Bitmap.createScaledBitmap(title, 700, 100, false);


    }




        /**
         * onDraw(Canvas canvas)
         *
         * instantiates paint colors
         * draws imported images onto surface view at appropriate coordinates
         *
         */
    @Override
    public void onDraw(Canvas canvas){


        //instantiates paint colors
        Paint greenPaint = new Paint();
        Paint redPaint = new Paint();
        Paint grayPaint = new Paint();
        Paint blackPaint = new Paint();

        //sets paint colors
        greenPaint.setColor(Color.rgb(0,100,0));
        redPaint.setColor(Color.RED); grayPaint.setColor(Color.GRAY);
        blackPaint.setColor(Color.BLACK);



        canvas.drawColor(Color.BLACK);


        canvas.drawRect(0f,0f, 2048f, 1536f, greenPaint);

        canvas.drawBitmap(title,650,290,null);

        //draw the five cards that represent the example hand
        canvas.drawBitmap(fifthCard, 500, 900, null);
        canvas.drawBitmap(firstCard, 700, 900, null);
        canvas.drawBitmap(fourthCard, 900, 900, null);
        canvas.drawBitmap(secondCard, 1100, 900, null);
        canvas.drawBitmap(thirdCard, 1300, 870, null);

        //draw the card in the middle of the play area
        canvas.drawBitmap(sixthCard,925,450,null);

        //Draws the pass button
        canvas.drawBitmap(button3,750, 750, null);
        //Draws the "Play Hand" button
        canvas.drawBitmap(button3, 1050, 750, null);

        //Draws the Player 2,3,4 where it displays their amount of cards left.
        canvas.drawBitmap(cardBack,200, 450, null);
        canvas.drawBitmap(cardBack,1500, 450, null);
        canvas.drawBitmap(cardBack,870, 60, null);

        //draw the four button templates for the buttons on the bottom left
        //canvas.drawBitmap(button3, 70, 760, null);
        canvas.drawBitmap(button3, 70, 80, null);
        canvas.drawBitmap(button3, 70, 200, null);
        canvas.drawBitmap(button3, 1600, 80, null);

        //set textsize to 50 for the pass button
        blackPaint.setTextSize(50f);

        //create the Pass text on the pass button
        canvas.drawText("PASS", 0, 4, 840, 820, blackPaint);

        //draw the player names for the three opponents
        canvas.drawText("Player 2", 0, 8, 250, 530, blackPaint);
        canvas.drawText("Player 3", 0, 8, 920, 140, blackPaint);
        canvas.drawText("Player 4", 0, 8, 1550, 530, blackPaint);

        //draw the card counts for the three different opponents
        blackPaint.setTextSize(40f);
        canvas.drawText("Cards: 4", 0, 8, 270, 575, blackPaint);
        canvas.drawText("Cards: 5", 0, 8, 1570, 575, blackPaint);
        canvas.drawText("Cards: 5", 0, 8, 940, 185, blackPaint);


        //create the text object for the four buttons on the bottom left
        blackPaint.setTextSize(35f);
        //canvas.drawText("NEW GAME", 0, 8, 90, 820, blackPaint);
        canvas.drawText("LOAD GAME", 0, 9, 90, 100, blackPaint);
        canvas.drawText("SAVE GAME", 0, 9, 90, 220, blackPaint);
        canvas.drawText("EXIT GAME", 0, 9, 1600, 100, blackPaint);
        canvas.drawText("PLAY HAND", 0, 9, 1070, 800, blackPaint);











    }


}
