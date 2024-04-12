package com.example.dragonspuzzles.screens.channelwood

enum class ChannelwoodSymbol {
    SEMICIRCLE,
    CYANARC,
    CROSS,
    DOWNUP,
    MOONMOUNTAIN
}

fun rotateSymbol(current: ChannelwoodSymbol) : ChannelwoodSymbol {
    return when(current){
        ChannelwoodSymbol.CROSS -> ChannelwoodSymbol.CYANARC
        ChannelwoodSymbol.CYANARC -> ChannelwoodSymbol.MOONMOUNTAIN
        ChannelwoodSymbol.MOONMOUNTAIN -> ChannelwoodSymbol.SEMICIRCLE
        ChannelwoodSymbol.SEMICIRCLE -> ChannelwoodSymbol.DOWNUP
        ChannelwoodSymbol.DOWNUP -> ChannelwoodSymbol.CROSS
    }
}

fun rotateSymbolReverse(current: ChannelwoodSymbol) : ChannelwoodSymbol {
    return when(current){
        ChannelwoodSymbol.CROSS -> ChannelwoodSymbol.DOWNUP
        ChannelwoodSymbol.CYANARC -> ChannelwoodSymbol.CROSS
        ChannelwoodSymbol.MOONMOUNTAIN -> ChannelwoodSymbol.CYANARC
        ChannelwoodSymbol.SEMICIRCLE -> ChannelwoodSymbol.MOONMOUNTAIN
        ChannelwoodSymbol.DOWNUP -> ChannelwoodSymbol.SEMICIRCLE
    }
}