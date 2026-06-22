package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    private lateinit var tvExpression: TextView
    private lateinit var tvResult: TextView
    private lateinit var btnHistory: ImageView
    private lateinit var dbHelper: DatabaseHelper

    private var currentInput = ""
    private var isResultShown = false   // This will become true when the final result is on the screen after calculation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvExpression = findViewById(R.id.tvExpression)
        tvResult = findViewById(R.id.tvResult)
        btnHistory = findViewById(R.id.btnHistory)
        dbHelper = DatabaseHelper(this)

        btnHistory.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

        setupNumberButtons()
        setupOperatorButtons()
        setupActionButtons()
    }

    // Setting up the number buttons
    private fun setupNumberButtons() {

        // Mapping the buttons to their corresponding values to avoid individual setOnClickListener , we can now iterate the map and use only one setOnClickListener
        val numberButtons = mapOf(
            R.id.btn0 to "0", R.id.btn1 to "1", R.id.btn2 to "2",
            R.id.btn3 to "3", R.id.btn4 to "4", R.id.btn5 to "5",
            R.id.btn6 to "6", R.id.btn7 to "7", R.id.btn8 to "8",
            R.id.btn9 to "9", R.id.btnDot to "."
        )

        // Iterating the button maps and assigning each of them a setOnClickListener
        for ((id, value) in numberButtons) {
            findViewById<AppCompatButton>(id).setOnClickListener {
                onNumberPressed(value)
            }
        }
    }

    // Setting up the operator buttons
    private fun setupOperatorButtons() {

        val operatorButtons = mapOf(
            R.id.btnAdd to "+",    R.id.btnSubtract to "-",
            R.id.btnMultiply to "×", R.id.btnDivide to "÷"
        )

        for ((id, symbol) in operatorButtons) {
            findViewById<AppCompatButton>(id).setOnClickListener {
                onOperatorPressed(symbol)
            }
        }
    }

    // Setting up the action buttons
    private fun setupActionButtons() {
        findViewById<AppCompatButton>(R.id.btnClear).setOnClickListener { clearAll() }
        findViewById<AppCompatButton>(R.id.btnDelete).setOnClickListener { deleteLast() }
        findViewById<AppCompatButton>(R.id.btnPercent).setOnClickListener { applyPercent() }
        findViewById<AppCompatButton>(R.id.btnToggleSign).setOnClickListener { toggleSign() }
        findViewById<AppCompatButton>(R.id.btnEqual).setOnClickListener { calculateResult() }
    }

    // Building up the functionality of all type of buttons
    private fun onNumberPressed(value: String) {

        // if result already shown, start fresh on new number press
        if (isResultShown) {
            currentInput = ""
            isResultShown = false
        }

        // Preventing the user to use multiple dots since it is not a valid expression
        if (value == ".") {
            val lastSegment = currentInput.split("+", "-", "×", "÷").last()
            if (lastSegment.contains(".")) return
        }

        currentInput += value
        tvResult.text = currentInput
        tvExpression.text = ""
    }

    private fun onOperatorPressed(symbol: String) {
        if (currentInput.isEmpty()) return

        isResultShown = false

        // Restricting the user not to use the operators consecutively
        val lastChar = currentInput.lastOrNull()?.toString() ?: ""
        if (lastChar == "+" || lastChar == "-" || lastChar == "×" || lastChar == "÷") {
            currentInput = currentInput.dropLast(1)
        }

        currentInput += symbol
        tvExpression.text = currentInput
        tvResult.text = currentInput
    }

    private fun clearAll() {

        // Save to the database if there is a result to be saved
        if (currentInput.isNotEmpty() && isResultShown) {
            dbHelper.insertHistory(
                expression = tvExpression.text.toString(),
                result = tvResult.text.toString()
            )
        }

        // After operation, reset everything
        currentInput = ""
        isResultShown = false
        tvExpression.text = ""
        tvResult.text = "0"
    }

    private fun deleteLast() {
        if (currentInput.isEmpty()) return
        currentInput = currentInput.dropLast(1)
        tvResult.text = if (currentInput.isEmpty()) "0" else currentInput
    }

    private fun applyPercent() {
        if (currentInput.isEmpty()) return
        val number = currentInput.toDoubleOrNull() ?: return
        currentInput = formatResult(number / 100)
        tvResult.text = currentInput
    }

    private fun toggleSign() {
        if (currentInput.isEmpty()) return
        // Removing the minus if it already exists
        currentInput = if (currentInput.startsWith("-"))
            currentInput.removePrefix("-")
        else "-$currentInput"
        tvResult.text = currentInput
    }

    private fun calculateResult() {
        if (currentInput.isEmpty()) return

        try {
            tvExpression.text = currentInput
            val result = evaluateExpression(currentInput)
            val formattedResult = formatResult(result)
            tvResult.text = formattedResult
            currentInput = formattedResult
            isResultShown = true

        } catch (e: Exception) {
            tvResult.text = "Error"
            currentInput = ""
        }
    }

    private fun evaluateExpression(expression: String): Double {
        // Removing the UI Button symbols with their respective mathematical symbols
        val sanitized = expression.replace("×", "*").replace("÷", "/")
        return calculate(sanitized)
    }

    // Building up the function for evaluation of the expression in BODMAS format
    private fun calculate(expression: String): Double {

        // Splitting expression into number and operator tokens
        val tokens = mutableListOf<String>()
        var currentNumber = ""

        for (i in expression.indices) {
            val char = expression[i]
            if (char == '-' && (i == 0 || expression[i - 1] == '+' || expression[i - 1] == '-'
                        || expression[i - 1] == '*' || expression[i - 1] == '/')) {
                currentNumber += char  // negative sign, part of number
            } else if (char == '+' || char == '-' || char == '*' || char == '/') {
                if (currentNumber.isNotEmpty()) tokens.add(currentNumber)
                currentNumber = ""
                tokens.add(char.toString())
            } else {
                currentNumber += char
            }
        }
        if (currentNumber.isNotEmpty()) tokens.add(currentNumber)

        // Solving for multiplication and division first since these have the highest priority
        var i = 0
        val processedTokens = mutableListOf<String>()

        while (i < tokens.size) {
            if (tokens[i] == "*" || tokens[i] == "/") {
                val left = processedTokens.removeLast().toDouble()
                val right = tokens[i + 1].toDouble()
                val result = if (tokens[i] == "*") left * right
                else {
                    if (right == 0.0) throw ArithmeticException("Division by zero")
                    left / right
                }
                processedTokens.add(result.toString())
                i += 2
            } else {
                processedTokens.add(tokens[i])
                i++
            }
        }

        //  Solving for addition and subtraction since they have lower priority
        var result = processedTokens[0].toDouble()
        var j = 1
        while (j < processedTokens.size) {
            val operator = processedTokens[j]
            val number = processedTokens[j + 1].toDouble()
            result = if (operator == "+") result + number else result - number
            j += 2
        }

        return result
    }

    // Formatting the output result
    private fun formatResult(result: Double): String {
        // show whole numbers without decimal point e.g. "48" not "48.0"
        return if (result == result.toLong().toDouble())
            result.toLong().toString()
        else "%.6g".format(result)
    }
}