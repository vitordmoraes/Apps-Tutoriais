package com.vitordmoraes.tryinganvillittlemore

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import trikita.anvil.DSL.*
import trikita.anvil.RenderableAdapter
import trikita.anvil.RenderableView

class MainActivity : AppCompatActivity() {

    val items = Array(100) { i -> "item #$i" }.asList()

    val demoAdapter = RenderableAdapter.withItems(items) {pos, item ->
        textView{
                text(item)
                textColor(Color.HSVToColor(floatArrayOf(pos*3.6f, 1f, 1f)))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(object: RenderableView(this){
            override fun view() {
                listView{
                    size(FILL, FILL)
                    adapter(demoAdapter)
                    onItemClick { parent, view, position, id ->
                        Toast.makeText(applicationContext, "Clicked on item #" + position, Toast.LENGTH_LONG).show();
                    }
                }
            }
        })
    }
}