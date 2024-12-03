package edu.iesam.dam2024.app.presentation.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import edu.iesam.dam2024.app.presentation.hide
import edu.iesam.dam2024.app.presentation.visible
import edu.iesam.dam2024.databinding.ViewErrorBinding

class ErrorAppView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val binding = ViewErrorBinding
        .inflate(LayoutInflater.from(context), this, true)

    init {
        hide()
    }

    fun render(errorAppUI: ErrorAppUI){
        binding.imgError.setImageResource(errorAppUI.getImageError())
        binding.titleError.text = errorAppUI.getTitleError()
        binding.titleDescription.text = errorAppUI.getDescriptionError()
        //action ..
        visible()
    }


}