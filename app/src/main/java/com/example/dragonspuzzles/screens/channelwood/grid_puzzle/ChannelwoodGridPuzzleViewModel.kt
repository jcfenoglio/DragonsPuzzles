package com.example.dragonspuzzles.screens.channelwood.grid_puzzle

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.dragonspuzzles.screens.channelwood.ChannelwoodSymbol
import com.example.dragonspuzzles.screens.channelwood.rotateSymbol

class ChannelwoodGridPuzzleViewModel : ViewModel() {
    var puzzleState by mutableStateOf(ChannelwoodGridPuzzleState())



    private fun topButtonClick() {
        puzzleState = puzzleState.copy(
            top = rotateSymbol(puzzleState.top),
            bottom = rotateSymbol(puzzleState.bottom)
        )
    }

    private fun leftButtonClick() {
        puzzleState = puzzleState.copy(
            left = rotateSymbol(puzzleState.left),
            bottom = rotateSymbol(puzzleState.bottom)
        )
    }

    private fun rightButtonClick() {
        puzzleState = puzzleState.copy(
            right = rotateSymbol(puzzleState.right),
            top = rotateSymbol(puzzleState.top)
        )
    }

    private fun bottomButtonClick() {
        puzzleState = puzzleState.copy(
            left = rotateSymbol(puzzleState.left),
            right = rotateSymbol(puzzleState.right)
        )
    }
}