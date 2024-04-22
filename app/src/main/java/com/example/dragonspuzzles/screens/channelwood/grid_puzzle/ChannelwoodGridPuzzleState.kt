package com.example.dragonspuzzles.screens.channelwood.grid_puzzle

import com.example.dragonspuzzles.screens.channelwood.ChannelwoodSymbol

data class ChannelwoodGridPuzzleState (
    val top: ChannelwoodSymbol = ChannelwoodSymbol.SEMICIRCLE,
    val left: ChannelwoodSymbol = ChannelwoodSymbol.MOONMOUNTAIN,
    val right: ChannelwoodSymbol = ChannelwoodSymbol.CROSS,
    val bottom: ChannelwoodSymbol = ChannelwoodSymbol.DOWNUP,
    val completed: Boolean = false
)

enum class ChannelwoodGridSquares {
    TOP,
    LEFT,
    RIGHT,
    BOTTOM
}