    package com.example.passgen

    import android.content.ClipData
    import android.content.ClipboardManager
    import android.content.Context
    import android.os.Bundle
    import android.widget.Button
    import android.widget.CheckBox
    import android.widget.ImageView
    import android.widget.SeekBar
    import android.widget.TextView
    import android.widget.Toast
    import androidx.activity.ComponentActivity

    class MainActivity : ComponentActivity() {
        private lateinit var tvPassword: TextView
        private lateinit var seekbarLength: SeekBar
        private lateinit var tvLength: TextView
        private lateinit var cbUppercase: CheckBox
        private lateinit var cbLowercase: CheckBox
        private lateinit var cbNumbers: CheckBox
        private lateinit var cbExcludeSimilar: CheckBox
        private lateinit var btnGenerate: Button
        private lateinit var btnCopy: Button
        private lateinit var ivToggleVisibility: ImageView

        private var isPasswordVisible = true
        private var generatedPassword = ""

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // Inicialize todos os elementos da interface
            tvPassword = findViewById(R.id.tv_password_generated)
            seekbarLength = findViewById(R.id.seekbar_length)
            seekbarLength.progress = 8
            tvLength = findViewById(R.id.tv_length)
            cbUppercase = findViewById(R.id.cb_uppercase)
            cbLowercase = findViewById(R.id.cb_lowercase)
            cbNumbers = findViewById(R.id.cb_numbers)
            cbExcludeSimilar = findViewById(R.id.cb_exclude_similar)
            btnGenerate = findViewById(R.id.btn_generate)
            btnCopy = findViewById(R.id.btn_copy)
            ivToggleVisibility = findViewById(R.id.iv_toggle_visibility)

            // Listener para atualizar o comprimento da senha no TextView ao mover o SeekBar
            seekbarLength.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    tvLength.text = "Password Length: $progress" // Atualiza o TextView com o valor do SeekBar
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            })

            // Adicione listeners aos elementos
            btnGenerate.setOnClickListener {
                val length = seekbarLength.progress
                val password = generatePassword(
                    length,
                    cbUppercase.isChecked,
                    cbLowercase.isChecked,
                    cbNumbers.isChecked,
                    cbExcludeSimilar.isChecked
                )
                if (password.isNotEmpty()) {
                    generatedPassword = password
                    tvPassword.text = password
                    isPasswordVisible = true
                    ivToggleVisibility.setImageResource(R.drawable.ic_visibility)
                }
            }

            ivToggleVisibility.setOnClickListener {
                togglePasswordVisibility()
            }

            // Adiciona o listener para copiar a senha para a área de transferência
            btnCopy.setOnClickListener {
                if (generatedPassword.isNotEmpty()) {
                    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                    val clip = ClipData.newPlainText("Generated Password", generatedPassword)
                    clipboard.setPrimaryClip(clip)
                    Toast.makeText(this, "Password copied to clipboard", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "No password generated", Toast.LENGTH_SHORT).show()
                }
            }
        }

        private fun togglePasswordVisibility() {
            isPasswordVisible = !isPasswordVisible
            tvPassword.text = if (isPasswordVisible) generatedPassword else "••••••••" // Alterna a exibição da senha
            ivToggleVisibility.setImageResource(
                if (isPasswordVisible) R.drawable.ic_visibility else R.drawable.ic_visibility_off
            )
        }

        private fun generatePassword(
            length: Int,
            uppercase: Boolean,
            lowercase: Boolean,
            numbers: Boolean,
            excludeSimilar: Boolean
        ): String {
            val uppercaseChars = "ABCDEFGHJKLMNPQRSTUVWXYZ"
            val lowercaseChars = "abcdefghijkmnpqrstuvwxyz"
            val numbersChars = "23456789"
            var characterPool = ""

            // Adicionar caracteres ao characterPool com base nas seleções
            if (uppercase) characterPool += uppercaseChars
            if (lowercase) characterPool += lowercaseChars
            if (numbers) characterPool += numbersChars

            // Verificar se o characterPool está vazio
            if (characterPool.isEmpty()) {
                Toast.makeText(this, "Selecione ao menos uma opção de caracteres", Toast.LENGTH_SHORT).show()
                return "" // Retornar uma string vazia se nenhuma opção for selecionada
            }

            // Remover caracteres semelhantes se necessário
            if (excludeSimilar) characterPool = characterPool.replace("[Il1Oo0]".toRegex(), "")

            // Gerar a senha usando o characterPool
            return (1..length)
                .map { characterPool.random() }
                .joinToString("")
        }
    }
