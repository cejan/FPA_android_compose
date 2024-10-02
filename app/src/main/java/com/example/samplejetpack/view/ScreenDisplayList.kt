package com.example.samplejetpack.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.samplejetpack.MyViewModel
import com.example.samplejetpack.R
import com.example.samplejetpack.network.models.NetWorkQuotes
import com.example.samplejetpack.view.bottomnav.BottomNav
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer


@Composable
fun AllQoutes(/*viewModel: MyViewModel,*/ viewModel: MyViewModel = hiltViewModel()) {
    val cardsGreeting by viewModel.cardsList.observeAsState(null)

    LaunchedEffect(Unit) {
        viewModel.fetchCardList()
    }

    Column {
        Text(
            text = "List of Something",

        )
        if (cardsGreeting == null) {
            // Show loading indicator or placeholder
            UserCardPlaceHolder()
            /*val shimmerInstance = rememberShimmer(shimmerBounds = ShimmerBounds.Window)
            Row(
                modifier = Modifier.background(Color.LightGray).shimmer(shimmerInstance).background(MaterialTheme.colorScheme.primaryContainer).fillMaxWidth().padding(top = 6.dp)
            ) {  Text(text = "Loading...") }*/

        } else {
            RecyclerView(cardsGreeting!!)
            //Text(text = cardsGreeting!!)
            // Display the list of credit cards
            //CreditCardItem(creditCards!!)
        }


    }
}

/*
@Composable
fun LoadingImageFromInternetCoil() {
    // [START android_compose_images_load_internet_coil]
    AsyncImage(
        model = "https://example.com/image.jpg",
        contentDescription = "Translated description of what the image contains"
    )
    // [END android_compose_images_load_internet_coil]
}
*/


@Composable
fun RecyclerView(userDetails: List<NetWorkQuotes>) {
    LazyColumn {
        items(items = userDetails) {
            UserCard(it.a, it.q)
        }
    }
}

@Composable
fun UserCardPlaceHolder() {
    val shimmerInstance = rememberShimmer(shimmerBounds = ShimmerBounds.Window)
    Card(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp).fillMaxWidth(),
        shape = RoundedCornerShape(CornerSize(10.dp))//,
        //elevation = 4.dp
    ) {
        Row{
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .size(60.dp)
                    .clip(RoundedCornerShape(CornerSize(6.dp)))
                    .align(Alignment.CenterVertically)
            ){
            }
            Column(modifier = Modifier.padding(5.dp)) {

                Text(text = "", modifier = Modifier.background(Color.LightGray).shimmer(shimmerInstance).background(MaterialTheme.colorScheme.primaryContainer).fillMaxWidth().padding(10.dp, 10.dp))

                Text(text = "", modifier = Modifier.background(Color.LightGray).shimmer(shimmerInstance).background(MaterialTheme.colorScheme.primaryContainer).fillMaxWidth().padding(10.dp, 10.dp))

            }}

    }
}


@Composable
fun UserCard(userDetail: String, qoutes: String) {

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://fastly.picsum.photos/id/250/200/200.jpg?hmac=23TaEG1txY5qYZ70amm2sUf0GYKo4v7yIbN9ooyqWzs")
            .size(Size.ORIGINAL) // Set the target size to load the image at.
            .build()
    )

    Card(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp).fillMaxWidth(),
        shape = RoundedCornerShape(CornerSize(10.dp))//,
        //elevation = 4.dp
    ) {
    Row{

        Image(
        painter = painter,
        contentDescription = "image",
        modifier = Modifier
            .padding(8.dp)
            .size(60.dp)
            .clip(RoundedCornerShape(CornerSize(6.dp)))
            .align(Alignment.CenterVertically)
        )
        Column(modifier = Modifier.padding(5.dp)) {


            Text(text = "${userDetail}:", modifier = Modifier.padding(10.dp, 10.dp))

            Text(text = "'${qoutes}'", modifier = Modifier.padding(10.dp))

        }}

    }
}

