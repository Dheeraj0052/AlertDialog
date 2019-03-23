package app.dheeraj.alertdialog

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_dialog.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnfloating.setOnClickListener(){
        //simpleAlert()
       // multichoicealert()
        customalert()
        }
    }

  private fun  simpleAlert()
  {
      val simpleAlert= AlertDialog.Builder(this)
          .setTitle("HELLO FROM SIMPLE ALERT")
          .setMessage("dheeraj")
          .setPositiveButton("ok") { dialog, which ->
             dialog.cancel()
          }.create()
      simpleAlert.show()

  }
    private val itemsArray = arrayOf("Item 1", "Item 2", "Item 3", "Item 4")

    private val checkedArray = booleanArrayOf(false, false, false, false)
  private fun multichoicealert()//same we can implement single choice alert
  {
     val mutialert =AlertDialog.Builder(this)
         .setTitle("hi from multi alert")
         .setMultiChoiceItems(itemsArray,checkedArray
         ) { dialog, which, isChecked ->
             Toast.makeText(this,itemsArray[which],Toast.LENGTH_LONG).show()
         }.setCancelable(false)
         .setPositiveButton("ok") { dialog, which ->
             dialog.cancel()
         }.create()

      mutialert.show()
  }

    private fun customalert()
    {


        val dialogView = LayoutInflater.from(this).inflate(R.layout.view_dialog, null, false)



        val customAlertDialog = AlertDialog.Builder(this)

            .setTitle("Hello from a custom alert")

            .setView(dialogView)

            .setPositiveButton("Ok") { dialog, which ->

                dialog.cancel()

                Toast.makeText(

                    this,

                    "Title : ${dialogView.etTitile.text}, Subtitle : ${dialogView.etSubtitle.text}",

                    Toast.LENGTH_SHORT

                ).show()

            }

            .setNegativeButton("Close") { dialog, which ->

                dialog.cancel()

            }

            .create()





        customAlertDialog.show()
    }
}
