package com.hieuwu.groceriesstore.presentation.account

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hieuwu.groceriesstore.R
import com.hieuwu.groceriesstore.databinding.FragmentAccountBinding
import com.hieuwu.groceriesstore.presentation.AuthActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountFragment : Fragment() {

    private lateinit var binding: FragmentAccountBinding
    private val viewModel: AccountViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentAccountBinding>(
            inflater, R.layout.fragment_account, container, false
        )

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setObserver()
        setEventListener()

        return binding.root
    }

    private fun setObserver() {
        viewModel.user.observe(viewLifecycleOwner) {}
    }

    private fun navigateToAuthentication() {
        val intent = Intent(context, AuthActivity::class.java)
        startActivity(intent)
    }

    private fun setEventListener() {
        binding.profileLayout.setOnClickListener {
            findNavController().navigate(R.id.action_accountFragment_to_updateProfileFragment)
        }

        binding.notificationSettingLayout.setOnClickListener {
            findNavController().navigate(R.id.action_accountFragment_to_notificationSettingsFragment)
        }

        binding.signoutButton.setOnClickListener {
            viewModel.signOut()
        }

        binding.signinButton.setOnClickListener {
            navigateToAuthentication()
        }
    }
}
