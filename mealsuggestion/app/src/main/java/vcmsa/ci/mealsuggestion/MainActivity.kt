package vcmsa.ci.mealsuggestion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val edtTimeofDay = findViewById<EditText>(R.id.edtTimeofDay)
        val btnSuggest = findViewById<Button>(R.id.btnSuggest)
        val txtRecommendation = findViewById<TextView>(R.id.txtMealRecommendation)
        val btnReset = findViewById<Button>(R.id.btnReset)


        btnSuggest.setOnClickListener {
            val TimeofDay = edtTimeofDay.text.toString()
            var mealRecommendation = ""


            if (TimeofDay == "Morning"){
                mealRecommendation = "breakfast: cornflakes"
            } else if (TimeofDay == "mid morning"){
                mealRecommendation = "pancakes"
            } else if (TimeofDay == "Afternoon"){
                mealRecommendation = "lunch: mac and cheese"
            } else if (TimeofDay == "Mid Afternoon"){
                mealRecommendation = "banana and apple"
            } else if (TimeofDay == "Dinner"){
                mealRecommendation = "fish and chips"
            } else if (TimeofDay == "After Dinner"){
                mealRecommendation = "jelly and custard"
            } else {
                mealRecommendation = "Invalid input! Please enter a valid time of day (e.g.Morning, Afternoon, Dinner"
            }

            txtRecommendation.text = mealRecommendation
        }

        btnReset.setOnClickListener {
            edtTimeofDay.text.clear()
            txtRecommendation.text =""
        }


















        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}