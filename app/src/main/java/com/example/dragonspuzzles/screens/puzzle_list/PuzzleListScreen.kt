package com.example.dragonspuzzles.screens.puzzle_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dragonspuzzles.CHANNELWOOD_GRID_PUZZLE_SCREEN
import com.example.dragonspuzzles.CHANNELWOOD_TUBE_PUZZLE_SCREEN
import com.example.dragonspuzzles.common.BasicToolbar
import com.example.dragonspuzzles.ui.theme.DragonsPuzzlesTheme

@Composable
fun PuzzleListScreen(
    openScreen: (String) -> Unit,
    viewModel: PuzzleListViewModel = PuzzleListViewModel()
) {
    PuzzleListScreenContent(viewModel::onPuzzleActionClick, openScreen)
}

@Composable
fun PuzzleListScreenContent(
    onPuzzleActionClick: ((String) -> Unit, String) -> Unit,
    openScreen: (String) -> Unit
) {
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()) {
        BasicToolbar(title = "A Dragon's Puzzles")

        PuzzleListItem(
            title = "Channelwood Grid Puzzle",
            onActionClick = { onPuzzleActionClick(openScreen, CHANNELWOOD_GRID_PUZZLE_SCREEN) })

        PuzzleListItem(
            title = "Channelwood Tube Puzzle",
            onActionClick = { onPuzzleActionClick(openScreen, CHANNELWOOD_TUBE_PUZZLE_SCREEN) })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PuzzleListItem(
    title: String,
    onActionClick: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        modifier = Modifier.fillMaxWidth(),
        onClick = onActionClick) {
        Text(text = title, modifier = Modifier.padding(16.dp), color = MaterialTheme.colorScheme.onPrimaryContainer)
    }
}

@Preview(showBackground = true)
@Composable
fun PuzzleListScreenPreview() {
    DragonsPuzzlesTheme {
        PuzzleListScreen({})
    }
}



