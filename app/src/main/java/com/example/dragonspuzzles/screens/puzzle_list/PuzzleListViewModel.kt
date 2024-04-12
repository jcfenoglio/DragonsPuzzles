package com.example.dragonspuzzles.screens.puzzle_list

import androidx.lifecycle.ViewModel

class PuzzleListViewModel : ViewModel() {
    fun onPuzzleActionClick(openScreen: (String) -> Unit, target: String) {
        openScreen(target)
    }
}