package yunho.app.flower_garden_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase
import yunho.app.flower_garden_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val auth: FirebaseAuth by lazy {
        Firebase.auth
    }
    private lateinit var ref: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() = with(binding) {
        loginButton.setOnClickListener {
            val email = email.text.toString()
            val pwd = pwd.text.toString()
            auth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener {
                val intent = Intent(this@MainActivity,OwnerMainActivity::class.java)
                startActivity(intent)
            }

        }
        owner.setOnClickListener {
            val intent = Intent(this@MainActivity,JoinOwnerActivity::class.java)
            startActivity(intent)
        }
    }
}