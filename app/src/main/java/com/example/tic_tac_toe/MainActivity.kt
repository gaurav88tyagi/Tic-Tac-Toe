package com.example.tic_tac_toe

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var buttons = arrayOf(btn00, btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22)

        fun ck(a: Button, b: Button, c: Button, x: String) {
            if(a.text == x && b.text == x && c.text == x )
            {
                a.getBackground().setColorFilter(0xFFBBAA00.toInt(), PorterDuff.Mode.MULTIPLY)
                b.getBackground().setColorFilter(0xFFBBAA00.toInt(), PorterDuff.Mode.MULTIPLY)
                c.getBackground().setColorFilter(0xFFBBAA00.toInt(), PorterDuff.Mode.MULTIPLY)
                tv.text = "Player $x Wins"
            }
        }

        btnClose.setOnClickListener {
            finish()
        }

        for(i in buttons)
        {
            i.setOnClickListener {

                var c = 0

                if (i.text == "" && (tv.text == "Player 0 Turn" || tv.text == "Player 1 Turn")) {

                    for (j in buttons) {
                        if (j.text != "") {
                            c++;
                        }
                    }

                    if (i.text == "") {
                        i.text = (c%2).toString()
                    }

                    ck(buttons[0], buttons[1], buttons[2], (c%2).toString())
                    ck(buttons[3], buttons[4], buttons[5], (c%2).toString())
                    ck(buttons[6], buttons[7], buttons[8], (c%2).toString())
                    ck(buttons[0], buttons[3], buttons[6], (c%2).toString())
                    ck(buttons[1], buttons[4], buttons[7], (c%2).toString())
                    ck(buttons[2], buttons[5], buttons[8], (c%2).toString())
                    ck(buttons[0], buttons[4], buttons[8], (c%2).toString())
                    ck(buttons[2], buttons[4], buttons[6], (c%2).toString())

                    if(c == 8 && (tv.text == "Player 0 Turn" || tv.text == "Player 1 Turn"))
                    {
                        tv.text = "DRAW"
                    }
                    if(tv.text == "Player 0 Turn" || tv.text == "Player 1 Turn")
                    {
                        c=(c+1)%2
                        tv.text = "Player $c Turn"
                    }
                }
            }
        }

        btnRestart.setOnClickListener {
            for(i in buttons)
            {
                i.getBackground().clearColorFilter()
                i.text = ""
            }
            tv.text = "Player 0 Turn"
        }
    }
}
