package com.arvin.tictactoe

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception


class MainActivity : AppCompatActivity(),View.OnClickListener {

    enum class PLAYING_PLAYER{
        FIRST_PLAYER,
        SECOND_PLAYER
    }

    enum class WINNER_OF_GAME{
        PLAYER_ONE,
        PLAYER_TWO,
        NO_ONE
    }

    var playingPlayer:PLAYING_PLAYER? = null
    var winnerOfGame:WINNER_OF_GAME? = null
    var player1Options:ArrayList<Int> = ArrayList()
    var player2Options:ArrayList<Int> = ArrayList()
    var allDisabledImages:ArrayList<ImageButton> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playingPlayer = PLAYING_PLAYER.FIRST_PLAYER
        imgB1.setOnClickListener(this)
        imgB2.setOnClickListener(this)
        imgB3.setOnClickListener(this)
        imgB4.setOnClickListener(this)
        imgB5.setOnClickListener(this)
        imgB6.setOnClickListener(this)
        imgB7.setOnClickListener(this)
        imgB8.setOnClickListener(this)
        imgB9.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.imgB1-> action(1,v as ImageButton)
            R.id.imgB2-> action(2,v as ImageButton)
            R.id.imgB3-> action(3,v as ImageButton)
            R.id.imgB4-> action(4,v as ImageButton)
            R.id.imgB5-> action(5,v as ImageButton)
            R.id.imgB6-> action(6,v as ImageButton)
            R.id.imgB7-> action(7,v as ImageButton)
            R.id.imgB8-> action(8,v as ImageButton)
            R.id.imgB9-> action(9,v as ImageButton)
        }
    }

    private fun action(optionNumber:Int, _selectedImageButton: ImageButton){
        var selectedImageButton = _selectedImageButton
        if(playingPlayer == PLAYING_PLAYER.FIRST_PLAYER){
            selectedImageButton.setImageResource(R.drawable.x)
            player1Options.add(optionNumber)
            playingPlayer = PLAYING_PLAYER.SECOND_PLAYER
            allDisabledImages.add(selectedImageButton)
            selectedImageButton.isEnabled = false
        }

        if(playingPlayer == PLAYING_PLAYER.SECOND_PLAYER){
            // for vs 2nd player
//            selectedImageButton.setImageResource(R.drawable.o)
//            player2Options.add(optionNumber)
//            playingPlayer = PLAYING_PLAYER.FIRST_PLAYER

            // for vs bot
            var notSelectedImageNumber:ArrayList<Int> = ArrayList<Int>()

            for(imageNumber in 1..9){
                if(!player1Options.contains(imageNumber)){
                    if(!player2Options.contains(imageNumber)){
                        notSelectedImageNumber.add(imageNumber)
                    }
                }
            }
            try{
                var getIdxRandom = (Math.random()*notSelectedImageNumber.size).toInt()
                when(notSelectedImageNumber[getIdxRandom]){
                    1 -> selectedImageButton = imgB1
                    2 -> selectedImageButton = imgB2
                    3 -> selectedImageButton = imgB3
                    4 -> selectedImageButton = imgB4
                    5 -> selectedImageButton = imgB5
                    6 -> selectedImageButton = imgB6
                    7 -> selectedImageButton = imgB7
                    8 -> selectedImageButton = imgB8
                    9 -> selectedImageButton = imgB9

                }
                selectedImageButton.setImageResource(R.drawable.o)
                player2Options.add(notSelectedImageNumber[getIdxRandom])
                selectedImageButton.isEnabled = false
                allDisabledImages.add(selectedImageButton)
                playingPlayer = PLAYING_PLAYER.FIRST_PLAYER
            }catch (e:Exception){
                e.printStackTrace()
            }

        }

        specifyTheWinner()
    }

    private fun specifyTheWinner(){
        if (player1Options.contains(1)
            && player1Options.contains(2)
            && player1Options.contains(3)) {
            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE
        }
        else if (player2Options.contains(1)
            && player2Options.contains(2)
            && player2Options.contains(3)) {
            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO
        }
        else if (player1Options.contains(4)
            && player1Options.contains(5)
            && player1Options.contains(6)) {
            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE
        }
        else if (player2Options.contains(4)
            && player2Options.contains(5)
            && player2Options.contains(6)) {
            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO
        }
        else if (player1Options.contains(7)
            && player1Options.contains(8)
            && player1Options.contains(9)) {
            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE
        }
        else if (player2Options.contains(7)
            && player2Options.contains(8)
            && player2Options.contains(9)) {
            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO
        }
        else if (player1Options.contains(1)
            && player1Options.contains(4)
            && player1Options.contains(7)) {
            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE
        }
        else if (player2Options.contains(1)
            && player2Options.contains(4)
            && player2Options.contains(7)) {
            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO
        }
        else if (player1Options.contains(2)
            && player1Options.contains(5)
            && player1Options.contains(8)) {
            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE
        }
        else if (player2Options.contains(2)
            && player2Options.contains(5)
            && player2Options.contains(8)) {
            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO
        }
        else if (player1Options.contains(3)
            && player1Options.contains(6)
            && player1Options.contains(9)) {
            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE
        }
        else if (player2Options.contains(3)
            && player2Options.contains(6)
            && player2Options.contains(9)) {
            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO
        }
        else if (player1Options.contains(1)
            && player1Options.contains(5)
            && player1Options.contains(9)) {
            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE
        }
        else if (player2Options.contains(1)
            && player2Options.contains(5)
            && player2Options.contains(9)) {
            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO
        }
        else if (player1Options.contains(3)
            && player1Options.contains(5)
            && player1Options.contains(7)) {
            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE
        }
        else if (player2Options.contains(3)
            && player2Options.contains(5)
            && player2Options.contains(7)) {
            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO
        }
        else if(winnerOfGame == null && allDisabledImages.size == 9){
            winnerOfGame = WINNER_OF_GAME.NO_ONE
        }

        if(winnerOfGame == WINNER_OF_GAME.PLAYER_ONE){
            createAlert("Player One Wins","Congratulations for Player 1",AlertDialog.BUTTON_POSITIVE,"OK",false)
        }
        else if(winnerOfGame == WINNER_OF_GAME.PLAYER_TWO){
            createAlert("Player Two Wins","Congratulations for Player 2",AlertDialog.BUTTON_POSITIVE,"OK",false)
        }
        else if(winnerOfGame == WINNER_OF_GAME.NO_ONE){
            createAlert("Its Draw","Please Play Again",AlertDialog.BUTTON_POSITIVE,"OK",false)
        }
    }

    private fun createAlert(title:String,message:String,whichButton:Int,buttonText:String,cancelable:Boolean){
        val alertDialog:AlertDialog = AlertDialog.Builder(this@MainActivity).create()
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)

        alertDialog.setButton(whichButton,buttonText) {
                _:DialogInterface, _:Int ->
            resetGame()
        }

        alertDialog.setCancelable(cancelable)
        alertDialog.show()
    }

    private fun resetGame(){
        player1Options.clear()
        player2Options.clear()
        allDisabledImages.clear()
        winnerOfGame = null

        imgB1.setImageResource(R.drawable.placeholder)
        imgB2.setImageResource(R.drawable.placeholder)
        imgB3.setImageResource(R.drawable.placeholder)
        imgB4.setImageResource(R.drawable.placeholder)
        imgB5.setImageResource(R.drawable.placeholder)
        imgB6.setImageResource(R.drawable.placeholder)
        imgB7.setImageResource(R.drawable.placeholder)
        imgB8.setImageResource(R.drawable.placeholder)
        imgB9.setImageResource(R.drawable.placeholder)

        imgB1.isEnabled = true
        imgB2.isEnabled = true
        imgB3.isEnabled = true
        imgB4.isEnabled = true
        imgB5.isEnabled = true
        imgB6.isEnabled = true
        imgB7.isEnabled = true
        imgB8.isEnabled = true
        imgB9.isEnabled = true

    }

}