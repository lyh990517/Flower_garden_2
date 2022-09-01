package yunho.app.flower_garden_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import yunho.app.flower_garden_2.Entity.OwnerEntity
import yunho.app.flower_garden_2.databinding.ActivityJoinOwnerBinding

class JoinOwnerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJoinOwnerBinding
    private val auth: FirebaseAuth by lazy {
        Firebase.auth
    }
    private lateinit var ref : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinOwnerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ref = Firebase.database.reference.child("Owner")
        initViews()
    }

    private fun initViews() = with(binding){
        owner.setOnClickListener {
            val email = email.text.toString()
            val pwd = pwd.text.toString()
            val name = name.text.toString()
            val nickname = nickName.text.toString()
            auth.createUserWithEmailAndPassword(email,pwd)
            val owner = OwnerEntity(email,name,nickname)
            ref.push().setValue(owner)
            val intent = Intent(this@JoinOwnerActivity,MainActivity::class.java)
            startActivity(intent)
        }
    }
}