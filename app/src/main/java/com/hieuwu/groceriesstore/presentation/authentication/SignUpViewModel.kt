package com.hieuwu.groceriesstore.presentation.authentication

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hieuwu.groceriesstore.BR
import com.hieuwu.groceriesstore.domain.repository.UserRepository
import com.hieuwu.groceriesstore.presentation.utils.ObservableViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class SignUpViewModel @Inject constructor(private val userRepository: UserRepository) : ObservableViewModel() {

    private var _email: String? = null
    var email: String?
        @Bindable
        get() = _email
        set(value) {
            _email = value
            notifyPropertyChanged(BR.email)
        }

    private var _password: String? = null
    var password: String?
        @Bindable
        get() = _password
        set(value) {
            _password = value
            notifyPropertyChanged(BR.password)
        }

    private var _name: String? = null
    var name: String?
        @Bindable
        get() = _name
        set(value) {
            _name = value
            notifyPropertyChanged(BR.name)
        }

    // Declare check variable as live data, set it when create success fully
    // In fragment observe it
    private val _isSignUpSuccessful = MutableLiveData<Boolean?>()
    val isSignUpSuccessful: LiveData<Boolean?>
        get() = _isSignUpSuccessful

    fun createAccount() {
        viewModelScope.launch {
            _isSignUpSuccessful.value = userRepository!!.createAccount(_email!!, _password!!, _name!!)
        }
    }
}
