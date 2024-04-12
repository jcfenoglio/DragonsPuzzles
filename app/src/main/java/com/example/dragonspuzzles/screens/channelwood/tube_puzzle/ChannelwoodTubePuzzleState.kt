package com.example.dragonspuzzles.screens.channelwood.tube_puzzle

import com.example.dragonspuzzles.screens.channelwood.ChannelwoodSymbol

data class ChannelwoodTubePuzzleState (
    val top: ChannelwoodSymbol = ChannelwoodSymbol.CYANARC,
    val topMid: ChannelwoodSymbol = ChannelwoodSymbol.DOWNUP,
    val bottomMid: ChannelwoodSymbol = ChannelwoodSymbol.MOONMOUNTAIN,
    val bottom: ChannelwoodSymbol = ChannelwoodSymbol.SEMICIRCLE,
    val completed: Boolean = false
)

enum class ChannelwoodTubeRings {
    TOP,
    TOPMID,
    BOTTOMMID,
    BOTTOM
}