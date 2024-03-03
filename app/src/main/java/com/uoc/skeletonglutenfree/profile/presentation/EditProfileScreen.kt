package com.uoc.skeletonglutenfree.profile.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uoc.skeletonglutenfree.R
import com.uoc.skeletonglutenfree.core.utils.TestTag

@Composable
fun EditProfileScreen(onPressBack: () -> Unit, onSaveProfile: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Yellow) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Back",
                modifier = Modifier
                    .clickable { onPressBack() }
                    .testTag(TestTag.BACK_TO_PROFILE)
            )
            Text(text = stringResource(R.string.edit_profile_header), fontSize = 24.sp)
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                value = "avalldeperasb@uoc.edu",
                onValueChange = {},
                label = { Text(text = "email") },
                enabled = false
            )
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                value = "avalldeperas",
                onValueChange = {},
                label = { Text(text = "username") }
            )
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                value = "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in " +
                        "laying out print, graphic or web designs. The passage is attributed to an " +
                        "unknown typesetter in the 15th century who is thought to have scrambled" +
                        "parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen" +
                        " book. ",
                label = { Text(text = "About") },
                onValueChange = {}
            )
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            Button(onClick = { onSaveProfile() }) {
                Text(text = "Save")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EditProfileScreenPreview() {
    EditProfileScreen({}, {})
}
