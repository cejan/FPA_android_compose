package com.example.samplejetpack.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.samplejetpack.MyViewModel
import com.example.samplejetpack.R
import com.example.samplejetpack.network.models.NetWorkQuotes


@Composable
fun AllQoutes(viewModel: MyViewModel) {
    val cardsGreeting by viewModel.cardsList.observeAsState(null)

    LaunchedEffect(Unit) {
        viewModel.fetchCardList()
    }

    Column {
        if (cardsGreeting == null) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")
        } else {
            RecyclerView(cardsGreeting!!)
            //Text(text = cardsGreeting!!)
            // Display the list of credit cards
            //CreditCardItem(creditCards!!)
        }
    }
}

@Composable
fun UserCard(userDetail: String, qoutes: String) {
    Card(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp).fillMaxWidth(),
        shape = RoundedCornerShape(CornerSize(10.dp))//,
        //elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(5.dp)) {
         /*   Image(
                painter = painterResource(id = R.drawable.ic_image),
                contentDescription = "image",
                modifier = Modifier
                    .padding(8.dp)
                    .size(60.dp)
                    .clip(RoundedCornerShape(CornerSize(6.dp)))
                    .align(alignment = Alignment.CenterVertically)
            )*/

            Text(text = "${userDetail}:", modifier = Modifier.padding(10.dp, 10.dp))

            Text(text = "'${qoutes}'", modifier = Modifier.padding(10.dp))

        }
    }
}

/**
 * Composable function for displaying a RecyclerView of user cards.
 *
 * @param userDetails The list of user data sources to populate the RecyclerView.
 */
@Composable
fun RecyclerView(userDetails: List<NetWorkQuotes>) {
    LazyColumn {
        items(items = userDetails) {
            UserCard(it.a, it.q)
        }
    }
}
