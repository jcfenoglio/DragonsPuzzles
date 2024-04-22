package com.example.dragonspuzzles.screens.channelwood.grid_puzzle

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.dragonspuzzles.screens.channelwood.ChannelwoodSymbol
import com.example.dragonspuzzles.screens.channelwood.rotateSymbol

class ChannelwoodGridPuzzleViewModel : ViewModel() {
    var puzzleState by mutableStateOf(ChannelwoodGridPuzzleState())


    fun gridButtonClick(square: ChannelwoodGridSquares) {
        if (puzzleState.completed) return
        puzzleState = when(square) {
             ChannelwoodGridSquares.TOP -> puzzleState.copy(
                top = rotateSymbol(puzzleState.top),
                bottom = rotateSymbol(puzzleState.bottom)
            )
            ChannelwoodGridSquares.LEFT -> puzzleState.copy(
                left = rotateSymbol(puzzleState.left),
                bottom = rotateSymbol(puzzleState.bottom)
            )
            ChannelwoodGridSquares.RIGHT -> puzzleState.copy(
                right = rotateSymbol(puzzleState.right),
                top = rotateSymbol(puzzleState.top)
            )
            ChannelwoodGridSquares.BOTTOM -> puzzleState.copy(
                left = rotateSymbol(puzzleState.left),
                right = rotateSymbol(puzzleState.right)
            )
        }

        checkCompleted()
    }

    fun resetPuzzle() {
        puzzleState = puzzleState.copy(
            top = ChannelwoodSymbol.SEMICIRCLE,
            left = ChannelwoodSymbol.MOONMOUNTAIN,
            right = ChannelwoodSymbol.CROSS,
            bottom = ChannelwoodSymbol.DOWNUP,
            completed = false
        )
    }

    fun checkCompleted() {
        if (puzzleState.top == ChannelwoodSymbol.DOWNUP &&
            puzzleState.left == ChannelwoodSymbol.CROSS &&
            puzzleState.right == ChannelwoodSymbol.MOONMOUNTAIN &&
            puzzleState.bottom == ChannelwoodSymbol.CYANARC) {
            puzzleState = puzzleState.copy(completed = true)
        }
    }
}

