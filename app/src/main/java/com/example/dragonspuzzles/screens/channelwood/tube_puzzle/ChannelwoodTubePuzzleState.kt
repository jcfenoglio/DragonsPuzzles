package com.example.dragonspuzzles.screens.channelwood.tube_puzzle

import com.example.dragonspuzzles.screens.channelwood.ChannelwoodSymbol

data class ChannelwoodTubePuzzleState (
    val top: ChannelwoodSymbol = ChannelwoodSymbol.CROSS,
    val topMid: ChannelwoodSymbol = ChannelwoodSymbol.CROSS,
    val bottomMid: ChannelwoodSymbol = ChannelwoodSymbol.CROSS,
    val bottom: ChannelwoodSymbol = ChannelwoodSymbol.CROSS,
    val completed: Boolean = false
)

enum class ChannelwoodTubeRings {
    TOP,
    TOPMID,
    BOTTOMMID,
    BOTTOM
}