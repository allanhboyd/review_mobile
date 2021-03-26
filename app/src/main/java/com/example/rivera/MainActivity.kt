package com.example.rivera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.rivera.Api.FeedbackService
import com.example.rivera.Api.Feedbody
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val feedbackService = FeedbackService()


        submit_btn.setOnClickListener {
            val phone:Int
            val input = phoneTv?.text.toString().trim()

            if (!input.isNullOrBlank()) {
                //Your code for blank edittext
               phone = phoneTv.text.toString().toInt()
            }
            else
            {
                phone = 0
            }
            val feedbody = Feedbody(
                name = nameTv.text.toString(),
                phone_number = phone,
                service = serviceTv.text.toString(),
                complain = complainTv.text.toString(),
                improve_area = improveTv.text.toString(),
                org_id = 2
            )

            feedbackService.addFeedback(feedbody)
            {
                if (it != null) {
                    if (it.status!!) {
                        clearText()
//                        Toast.makeText(this, "${it.message}",Toast.LENGTH_LONG).show()
                    } else {
                        clearText()
//                        Toast.makeText(this, "${it.message}",Toast.LENGTH_LONG).show()
                    }
                }
                else
                {
                    clearText()
//                    Toast.makeText(this, "Something unexpected went wrong, please check your internet connection",Toast.LENGTH_LONG).show()
                }
            }

            val view = layoutInflater.inflate(R.layout.bottom_sheet, null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(view)
            dialog.show()


        }
    }
    fun clearText()
    {
        nameTv.text.clear()
        phoneTv.text.clear()
        improveTv.text.clear()
        serviceTv.text.clear()
        complainTv.text.clear()
    }
}