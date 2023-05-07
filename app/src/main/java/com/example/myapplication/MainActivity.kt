package com.example.myapplication
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/*
Nama: Mr.Hadafee Mudo
NIM: 2008107010101
 */

class MainActivity : AppCompatActivity() {
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi variabel username, password, dan loginButton
        username = findViewById(R.id.edit1)
        password = findViewById(R.id.edit2)
        loginButton = findViewById(R.id.button)

        // Set onClickListener untuk tombol loginButton
        loginButton.setOnClickListener {
            Toast.makeText(this, "Login berhasil, username: ${username.text.toString()}", Toast.LENGTH_SHORT).show()
        }
    }

    // Ambil data yang tersimpan pada onResume() karena ini akan dipanggil saat aplikasi dibuka kembali
    override fun onResume() {
        super.onResume()

        // Ambil data yang tersimpan pada SharedPreferences
        val sh = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val s1 = sh.getString("username", "")
        val a = sh.getString("password", "")

        // Tampilkan data yang tersimpan pada EditText
        username.setText(s1)
        password.setText(a)
    }

    // Simpan data pada SharedPreferences pada onPause()
    // Ketika pengguna menutup aplikasi onPause() akan dipanggil dan data akan disimpan
    override fun onPause() {
        super.onPause()

        // Buat objek shared preference dengan nama file "MySharedPref" pada mode private
        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()

        // Tulis semua data yang diinput oleh pengguna pada SharedPreferences dan apply
        myEdit.putString("username", username.text.toString())
        myEdit.putString("password", password.text.toString())
        myEdit.apply()
    }
}
