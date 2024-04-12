package com.example.dragonspuzzles.screens.channelwood.grid_puzzle

import com.example.dragonspuzzles.screens.channelwood.ChannelwoodSymbol

data class ChannelwoodGridPuzzleState (
    val top: ChannelwoodSymbol = ChannelwoodSymbol.DOWNUP,
    val left: ChannelwoodSymbol = ChannelwoodSymbol.CROSS,
    val right: ChannelwoodSymbol = ChannelwoodSymbol.MOONMOUNTAIN,
    val bottom: ChannelwoodSymbol = ChannelwoodSymbol.CYANARC,
    val completed: Boolean = false
)