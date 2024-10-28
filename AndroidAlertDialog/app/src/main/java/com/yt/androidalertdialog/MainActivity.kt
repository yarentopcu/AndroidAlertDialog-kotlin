package com.yt.androidalertdialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yt.androidalertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Toast.makeText(this,"hosgeldin",Toast.LENGTH_LONG).show()

        /*
        binding.button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                println("butona tıklandı")

            }

        })*/




    }

    fun kaydet(view: View){
        val alert=AlertDialog.Builder(this@MainActivity)
        alert.setTitle("kayıt et")
        alert.setMessage("kayıt etmek istediğinize emin misiniz?")
        alert.setPositiveButton("evet"){dialog,which->
            Toast.makeText(this@MainActivity,"kayıt edildi!",Toast.LENGTH_LONG).show()

        }
        alert.setNegativeButton("hayır",object:DialogInterface.OnClickListener{
            override fun onClick(dialog:DialogInterface?,which:Int){
                Toast.makeText(this@MainActivity,"kayıt iptal edildi!",Toast.LENGTH_LONG).show()

            }

        })
        alert.show()

    }
}
