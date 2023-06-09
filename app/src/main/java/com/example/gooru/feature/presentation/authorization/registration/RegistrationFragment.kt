package com.example.gooru.feature.presentation.authorization.registration

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.example.gooru.R
import com.example.gooru.core.base.BaseFragment
import com.example.gooru.core.constant.OFFER
import com.example.gooru.core.extensions.showError
import com.example.gooru.core.extensions.startNewApp
import com.example.gooru.core.states.AuthState
import com.example.gooru.databinding.FragmentRegistrationBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class RegistrationFragment : BaseFragment<FragmentRegistrationBinding>() {
    override fun initBinding(inflater: LayoutInflater) =
        FragmentRegistrationBinding.inflate(inflater)

    private val viewModel by viewModel<RegistrationViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataObserver(viewModel.state) { state -> loadObserver(state) }

        enableButtonListener()

        clickRegistrationButton()

        clickOffer()

        val startTextOffer = resources.getString(R.string.offer_start)
        val endTextOffer = resources.getString(R.string.offer_end)

        val spans: Spannable = SpannableString(startTextOffer + endTextOffer)
        spans.setSpan(
            ForegroundColorSpan(Color.BLUE),
            startTextOffer.length,
            startTextOffer.length + endTextOffer.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.offer.text = spans

    }

    private fun enableButtonListener() {
        binding.email.doOnTextChanged { email, _, _, _ ->
            viewModel.emailValidation(email.toString())
        }
        binding.password.doOnTextChanged { email, _, _, _ ->
            viewModel.passwordValidation(email.toString())
        }
        binding.repeatPassword.doOnTextChanged { email, _, _, _ ->
            viewModel.repeatPasswordValidation(email.toString())
        }

    }

    private fun loadObserver(state: AuthState) {
        binding.progressBarr.isVisible = state == AuthState.LOADING
        binding.nextButton.isVisible = state != AuthState.LOADING
        binding.errorMessage.isVisible = state == AuthState.ERROR_400
        binding.nextButton.isEnabled = state == AuthState.ENABLED_BUTTON
        if (state == AuthState.SUCCESS_AUTH) {
            findNavController().navigate(R.id.action_startAuthFragment_to_emailVerificationFragment)
        }
        if (state == AuthState.ERROR_WI_FI) showError { startRegistration() }
    }

    private fun clickRegistrationButton() =
        binding.nextButton.setOnClickListener { startRegistration() }

    private fun clickOffer() {
        binding.offer.setOnClickListener { startNewApp(OFFER) }
    }

    private fun startRegistration() {
        viewModel.registration(
            binding.email.text.toString(),
            binding.password.text.toString(),
            binding.repeatPassword.text.toString(),
        )
    }

}