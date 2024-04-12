package com.example.dragonspuzzles.screens.channelwood.tube_puzzle

import com.example.dragonspuzzles.screens.channelwood.ChannelwoodSymbol

data class ChannelwoodTubePuzzleState (
    val top: ChannelwoodSymbol = ChannelwoodSymbol.MOONMOUNTAIN,
    val topMid: ChannelwoodSymbol = ChannelwoodSymbol.SEMICIRCLE,
    val bottomMid: ChannelwoodSymbol = ChannelwoodSymbol.DOWNUP,
    val bottom: ChannelwoodSymbol = ChannelwoodSymbol.CROSS,
    val completed: Boolean = false
)

enum class ChannelwoodTubeRings {
    TOP,
    TOPMID,
    BOTTOMMID,
    BOTTOM
}