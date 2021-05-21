package com.example.rivera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.example.rivera.Api.FeedbackService
import com.example.rivera.Api.RetailerFeedbody
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_retailer_feed.*

class RetailerFeedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retailer_feed)

        val feedbackService = FeedbackService();

        submitBt.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.bottom_sheet, null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(view)
            dialog.show()

            val priceId = price_group!!.checkedRadioButtonId
            val qualityId = quality_group!!.checkedRadioButtonId
            val storeId = store_group!!.checkedRadioButtonId
            val accessId = access_group!!.checkedRadioButtonId
            val recommendId = recommend_group!!.checkedRadioButtonId
            val sourceId = source_group!!.checkedRadioButtonId

            val retailerFeedbody = RetailerFeedbody(
                price_rate = isNull(priceId),
                quality_rate = isNull(qualityId),
                store_rate = isNull(storeId),
                access_rate =isNull(accessId),
                recommend_rate = isNull(recommendId),
                org_id = 5,
                areas = areastv.text.toString(),
                stock = suggestiontv.text.toString(),
                source = isNull(sourceId)
            );

            feedbackService.addRetailerFeedback(retailerFeedbody)
            {
                if (it != null) {
                    if (it.status!!) {
                        clearText()
                    } else {
                        clearText()
                    }
                }
                else
                {
                    clearText()
                }
            }
        }
    }

    fun clearText()
    {
        price_group.clearCheck()
        access_group.clearCheck()
        quality_group.clearCheck()
        store_group.clearCheck()
        areastv.text.clear()
        suggestiontv.text.clear()
        recommend_group.clearCheck()
        source_group.clearCheck()
    }

    fun isNull(id:Int): String
    {
        if (id != -1)
        {
            val valString = findViewById<RadioButton>(id)!!
            return valString.text.toString()
        }
        else
        {
            return ""
        }
    }

}