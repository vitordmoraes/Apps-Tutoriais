package com.vitordmoraes.todolistanvil

import android.os.Bundle
import android.widget.CompoundButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import trikita.anvil.BaseDSL.WRAP
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(TodoView(this))
    }

}









/** EXAMPLE  ANVIL IN CODE
*
*/


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(object: RenderableView(this) {
//            override fun view() {
//                metodo()
//            }
//
//        })
//
//
//
//    }
//
//
//     private fun metodo() {
//             var checked1 = false
//             var checked2 = false
//                 linearLayout {
//                     size(FILL, FILL)
//                     orientation(LinearLayout.VERTICAL)
//                     padding(dip(20))
//                     checkBox {
//                         textSize(50f)
//                         text("text1")
//                         size(WRAP, WRAP)
//                         margin(0, dip(20))
//                         checked(checked1)
//                         onCheckedChange { v: CompoundButton?, isChecked: Boolean ->
//                             checked1 = isChecked
//                         }
//                     }
//                     checkBox {
//                         textSize(50f)
//                         text("text2")
//                         size(WRAP, WRAP)
//                         margin(0, dip(20))
//                         checked(checked2)
//                         onCheckedChange { v: CompoundButton?, isChecked: Boolean ->
//                             checked2 = isChecked
//                         }
//                     }
//                 }
//             }
//
//
//
//}