package com.uoc.skeletonglutenfree.profile.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uoc.skeletonglutenfree.R
import com.uoc.skeletonglutenfree.core.utils.TestTag

@Composable
fun ProfileScreen(onEditProfile: () -> Unit, onLogout: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Green) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(R.string.profile_screen_header), fontSize = 24.sp)
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            Image(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(100.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.profile_default),
                contentDescription = stringResource(R.string.profile_image)
            )
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            Button(onClick = { onEditProfile() }, Modifier.testTag(TestTag.TO_EDIT_PROFILE_BTN)) {
                Text(text = stringResource(id = R.string.to_edit_profile_text))
            }
            Button(onClick = { onLogout() }, Modifier.testTag(TestTag.TO_LOGOUT_PROFILE_BTN)) {
                Text(text = stringResource(id = R.string.logout_btn_text))
            }
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(onEditProfile = {}, onLogout = {})
}
