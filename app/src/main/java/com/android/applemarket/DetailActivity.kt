package com.android.applemarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.applemarket.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            finish()
        }

        val receivedItem = intent.getSerializableExtra("myItem") as? MyItem

        if(receivedItem != null) {
            binding.detailImage.setImageResource(receivedItem.aIcon)
            binding.nickname.text = receivedItem.nickname
            binding.detailPrice.text = receivedItem.aPrice.toString()
            binding.titleText.text = receivedItem.detailText
            binding.detailTitle.text = receivedItem.aTitle
            binding.detailAddress.text = receivedItem.aAddress
        }
    }
}