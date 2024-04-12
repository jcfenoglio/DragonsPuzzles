package com.example.dragonspuzzles.screens.channelwood.grid_puzzle

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dragonspuzzles.common.BackToolbar
import com.example.dragonspuzzles.screens.channelwood.gridBase
import com.example.dragonspuzzles.ui.theme.DragonsPuzzlesTheme

@Composable
fun ChannelwoodGridPuzzleScreen(
    popUpScreen: () -> Unit,
    viewModel: ChannelwoodGridPuzzleViewModel = ChannelwoodGridPuzzleViewModel()
) {
    ChannelwoodGridPuzzleScreenContent(popUpScreen)
}

@Composable
fun ChannelwoodGridPuzzleScreenContent(popUpScreen: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        BackToolbar(title = "", popUpScreen)

        Box(modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .background(MaterialTheme.colorScheme.primaryContainer)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(20.dp)
            )
            .clip(RoundedCornerShape(20.dp)),
            contentAlignment = Alignment.Center
        ) {
            gridBase()
        }
    }


}

@Preview(showBackground = true)
@Composable
fun ChannelwoodGridPuzzleScreenPreview() {
    DragonsPuzzlesTheme {
        ChannelwoodGridPuzzleScreen({ })
    }
}