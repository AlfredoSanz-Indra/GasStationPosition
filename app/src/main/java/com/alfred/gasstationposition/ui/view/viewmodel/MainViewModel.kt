package com.alfred.gasstationposition.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alfred.gasstationposition.core.log.Klog
import com.alfred.gasstationposition.domain.usecaseapi.GasService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * @author Alfredo Sanz
 * @time 2024
 */
data class MainUiState(
    var generalError: Boolean = false,
    var generalErrorText: String = "",
    var isSomethingWorking: Boolean = false
)

class MainViewModel(private val gasService: GasService) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    fun reloadPrices() {

        updateIsSomethingWorking(true)
        viewModelScope.launch {
            val resp = gasService.getGasInfoFromGob()
            Klog.line("MainViewModel", "reloadPrices", "resp: $resp")
            if(resp.result) {
                Klog.line("MainViewModel", "reloadPrices", "result true, resp.datList: ${resp.dat}")
                setGeneralError(" ${resp.code}: ${resp.message}")
            }
            else {
                Klog.line("MainViewModel", "reloadPrices", "error")
                setGeneralError(" ${resp.code}: ${resp.message}")
            }
            updateIsSomethingWorking(false)
        }
    }

    private fun updateIsSomethingWorking(action: Boolean) {
        _uiState.update {
            it.copy(isSomethingWorking = action)
        }
    }

    private fun setGeneralError(txt: String) {
        _uiState.update {
            it.copy(generalError = true)
        }
        _uiState.update {
            it.copy(generalErrorText = txt)
        }
    }

    private fun clearErrors() {
        _uiState.update {
            it.copy(generalError = false)
        }
        _uiState.update {
            it.copy(generalErrorText = "")
        }
    }

    fun clearFields() {
    }
}