package com.vitordmoraes.todolistanvil

import android.content.Context
import android.widget.LinearLayout
import trikita.anvil.BaseDSL
import trikita.anvil.BaseDSL.*
import trikita.anvil.DSL
import trikita.anvil.DSL.*
import trikita.anvil.RenderableAdapter
import trikita.anvil.RenderableView

class TodoView(c: Context) : RenderableView(c) {
    var message = ""

    var todoAdapter = RenderableAdapter.withItems(Todo.items) { pos, value ->
        linearLayout {
            size(FILL, WRAP)
            minHeight(dip(72))

            textView{
                size(0, WRAP)
                weight(1f)
                layoutGravity(CENTER_VERTICAL)
                padding(dip(5))
                DSL.text(value.message)

            }
            checkBox {
                size(WRAP, WRAP)
                margin(dip(5))
                layoutGravity(CENTER_VERTICAL)
                focusable(false)
                focusableInTouchMode(false)
                clickable(false)
                checked(value.checked)
            }
        }
    }

    override fun view() {
        todoAdapter.notifyDataSetChanged()

        linearLayout {
            size(FILL, WRAP)
            orientation(LinearLayout.VERTICAL)

            linearLayout{
                size(FILL, WRAP)

                editText {
                    size(0, WRAP)
                    weight(1f)
                    DSL.text(message)
                    onTextChanged { s->
                        message = s.toString()
                    }
                }

                button {
                    size(WRAP, WRAP)
                    layoutGravity(CENTER_VERTICAL)
                    DSL.text("Add")
                    enabled(message.trim().isNotEmpty())
                    onClick {
                        Todo.add(message)
                        message = ""
                    }
                }
            }
            button {
                size(FILL, WRAP)
                BaseDSL.padding(dip(5))
                DSL.text("Clear checked tasks")
                enabled(Todo.hasChecked())
                onClick {
                    Todo.clear()
                }
            }
            listView{
                size(FILL, WRAP)
                itemsCanFocus(true)
                onItemClick { parent, view, pos, id ->
                    Todo.toggle(pos)
                }
                adapter(todoAdapter)
            }
        }
    }


}