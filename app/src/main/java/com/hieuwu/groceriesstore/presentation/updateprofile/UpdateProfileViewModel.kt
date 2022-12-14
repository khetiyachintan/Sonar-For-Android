package com.hieuwu.groceriesstore.presentation.updateprofile

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hieuwu.groceriesstore.BR
import com.hieuwu.groceriesstore.domain.models.UserModel
import com.hieuwu.groceriesstore.domain.usecases.AuthenticateUserUseCase
import com.hieuwu.groceriesstore.presentation.utils.ObservableViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class UpdateProfileViewModel @Inject constructor(private val authenticateUserUseCase: AuthenticateUserUseCase) :
    ObservableViewModel() {
    private val _user =
        authenticateUserUseCase.getCurrentUser() as MutableLiveData<UserModel?>
    val user: LiveData<UserModel?>
        get() = _user

    private var _name: String? = null
    var name: String?
        @Bindable
        get() {
            return _name
        }
        set(value) {
            _name = value
            notifyPropertyChanged(BR.name)
        }

    private var _email: String? = null
    var email: String?
        @Bindable
        get() {
            return _email
        }
        set(value) {
            _email = value
            notifyPropertyChanged(BR.email)
        }

    private var _phoneNumber: String? = null
    var phoneNumber: String?
        @Bindable
        get() {
            return _phoneNumber
        }
        set(value) {
            _phoneNumber = value
            notifyPropertyChanged(BR.phoneNumber)
        }

    private var _address: String? = null
    var address: String?
        @Bindable
        get() {
            return _address
        }
        set(value) {
            _address = value
            notifyPropertyChanged(BR.address)
        }

    private val _isDoneUpdate = MutableLiveData<Boolean>(null)
    val isDoneUpdate: LiveData<Boolean?>
        get() = _isDoneUpdate

    fun updateUserProfile() {
        val id = _user.value!!.id
        try {
            viewModelScope.launch {
                authenticateUserUseCase.updateUserProfile(id, _name!!, _email!!, _phoneNumber!!, _address!!)
            }
            _isDoneUpdate.value = true
        } catch (e: Exception) {
            _isDoneUpdate.value = false
        }
    }
}
