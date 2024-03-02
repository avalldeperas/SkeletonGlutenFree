package com.uoc.skeletonglutenfree.map.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uoc.skeletonglutenfree.R

@Composable
fun DetailRestaurantScreen(onPressBack: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            Modifier
                .padding(16.dp)
                .verticalScroll(state = ScrollState(0))
        ) {
            IconButton(onClick = { onPressBack() }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "backFromDetail")
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.restaurant_200px),
                    contentScale = ContentScale.Crop,
                    contentDescription = "restaurant_image",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(90.dp)
                )
                Spacer(modifier = Modifier.padding(vertical = 16.dp))
                Text(text = "Racó del plà", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                Text(
                    text = "Av. Dr. Francesc Massana, 12, A, 08760 Martorell, Barcelona",
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.padding(vertical = 16.dp))
                Text(
                    text = stringResource(id = R.string.random_long_text),
                    textAlign = TextAlign.Justify
                )
                Spacer(modifier = Modifier.padding(vertical = 16.dp))
                Text(
                    text = "Reviews 4.5 / 10",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontStyle = FontStyle.Italic
                )
                Spacer(modifier = Modifier.padding(vertical = 16.dp))
                ContactSection()
            }
        }
    }
}

@Composable
fun ContactSection() {
    Text(
        text = "Contact",
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    ContactItem(ContactItem.MailContact)
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    ContactItem(ContactItem.TelephoneContact)
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    ContactItem(ContactItem.MailContact)
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    ContactItem(ContactItem.TelephoneContact)
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    ContactItem(ContactItem.MailContact)
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    ContactItem(ContactItem.TelephoneContact)
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    ContactItem(ContactItem.MailContact)
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    ContactItem(ContactItem.TelephoneContact)
}

@Composable
fun ContactItem(item: ContactItem) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Icon(imageVector = item.imageVector, contentDescription = item.contentDescription)
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = item.text
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DetailRestaurantScreenPreview() {
    DetailRestaurantScreen { }
}

sealed class ContactItem(
    val imageVector: ImageVector,
    val contentDescription: String,
    val text: String
) {
    data object TelephoneContact : ContactItem(
        imageVector = Icons.Filled.Call,
        contentDescription = "restaurant-call",
        text = "+34 6574568844"
    )
    data object MailContact : ContactItem(
        imageVector = Icons.Filled.MailOutline,
        contentDescription = "restaurant-mail",
        text = "www.racodelpla.com"
    )
}
