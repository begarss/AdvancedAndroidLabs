package com.example.calculatormvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.calculatormvp.contract.CalculatorContract
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CalculatorContract.View {
    private val presenter: CalculatorContract.Presenter = Provider().getCalculatorPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setClicks()
    }


    override fun updateDisplay(value: String) {
        if (!value.isNullOrEmpty()) {
            tvWindow.append(value)
        }
    }

    override fun clear() {
        tvWindow.text=""
    }


    private fun setClicks() {
        btn_0.setOnClickListener(numberClicked(btn_0.text.toString()))
        btn_1.setOnClickListener(numberClicked(btn_1.text.toString()))
        btn_2.setOnClickListener(numberClicked(btn_2.text.toString()))
        btn_3.setOnClickListener(numberClicked(btn_3.text.toString()))
        btn_4.setOnClickListener(numberClicked(btn_4.text.toString()))
        btn_5.setOnClickListener(numberClicked(btn_5.text.toString()))
        btn_6.setOnClickListener(numberClicked(btn_6.text.toString()))
        btn7.setOnClickListener(numberClicked(btn7.text.toString()))
        btn_8.setOnClickListener(numberClicked(btn_8.text.toString()))
        btn_9.setOnClickListener(numberClicked(btn_9.text.toString()))

        btn_plus.setOnClickListener(operatorClicked())
        btn_minus.setOnClickListener(operatorClicked())
        btn_divide.setOnClickListener(operatorClicked())
        btn_multiply.setOnClickListener(operatorClicked())
        btn_equals.setOnClickListener {
            presenter.performCalculation()
        }
        btn_clear.setOnClickListener {
            presenter.clearCalculation()
        }
    }

    private fun operatorClicked() = View.OnClickListener {
        presenter.appendOperator((it as Button).text.toString())

    }

    private fun numberClicked(number: String) = View.OnClickListener {
        presenter.appendValue(number)
    }
}