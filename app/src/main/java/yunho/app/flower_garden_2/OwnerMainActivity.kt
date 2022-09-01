package yunho.app.flower_garden_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import yunho.app.flower_garden_2.databinding.ActivityOwnerMainBinding

class OwnerMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOwnerMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOwnerMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}