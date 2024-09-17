package com.example.samplejetpack.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.samplejetpack.MyViewModel

@Composable
fun CardScreen(viewModel: MyViewModel) {
    val cardsGreeting by viewModel.cards.observeAsState(null)

    LaunchedEffect(Unit) {
        viewModel.fetchCards()
    }

    Column {
        if (cardsGreeting == null) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")
        } else {
            Text(text = cardsGreeting!!)
            // Display the list of credit cards
            //CreditCardItem(creditCards!!)
        }
    }
}

