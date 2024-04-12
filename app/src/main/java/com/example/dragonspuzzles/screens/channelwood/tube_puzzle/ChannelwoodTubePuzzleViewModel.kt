package com.example.dragonspuzzles.screens.channelwood.tube_puzzle

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.dragonspuzzles.screens.channelwood.rotateSymbol
import com.example.dragonspuzzles.screens.channelwood.rotateSymbolReverse

class ChannelwoodTubePuzzleViewModel : ViewModel() {
    var puzzleState by mutableStateOf(ChannelwoodTubePuzzleState())

    fun onArrowClick(ring: ChannelwoodTubeRings, reverse: Boolean) {
        when(ring) {
            ChannelwoodTubeRings.TOP -> {
                puzzleState = if (reverse) {
                    puzzleState.copy(
                        top = rotateSymbolReverse(puzzleState.top),
                        bottomMid = rotateSymbolReverse(puzzleState.bottomMid)
                    )
                } else {
                    puzzleState.copy(
                        top = rotateSymbol(puzzleState.top),
                        bottomMid = rotateSymbol(puzzleState.bottomMid)
                    )
                }
            }
            ChannelwoodTubeRings.TOPMID -> {
                puzzleState = if (reverse) {
                    puzzleState.copy(
                        top = rotateSymbolReverse(puzzleState.top),
                        topMid = rotateSymbolReverse(puzzleState.topMid),
                        bottom = rotateSymbolReverse(puzzleState.bottom)
                    )
                } else {
                    puzzleState.copy(
                        top = rotateSymbol(puzzleState.top),
                        topMid = rotateSymbol(puzzleState.topMid),
                        bottom = rotateSymbol(puzzleState.bottom)
                    )
                }
            }
            ChannelwoodTubeRings.BOTTOMMID -> {
                puzzleState = if (reverse) {
                    puzzleState.copy(
                        topMid = rotateSymbolReverse(puzzleState.topMid),
                        bottomMid = rotateSymbolReverse(puzzleState.bottomMid),
                        bottom = rotateSymbolReverse(puzzleState.bottom)
                    )
                } else {
                    puzzleState.copy(
                        topMid = rotateSymbol(puzzleState.topMid),
                        bottomMid = rotateSymbol(puzzleState.bottomMid),
                        bottom = rotateSymbol(puzzleState.bottom)
                    )
                }
            }
            ChannelwoodTubeRings.BOTTOM -> {
                puzzleState = if (reverse) {
                    puzzleState.copy(
                        bottom = rotateSymbolReverse(puzzleState.bottom)
                    )
                } else {
                    puzzleState.copy(
                        bottom = rotateSymbol(puzzleState.bottom)
                    )
                }
            }
        }
    }
}
