package io.dimasla4ee.contacts_viewer.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.dimasla4ee.contacts_viewer.R

@Composable
fun RoundInitials(
    initials: String,
    color: Color,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .aspectRatio(1f)
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = painterResource(R.drawable.circle),
            contentDescription = contentDescription,
            colorFilter = ColorFilter.tint(color)
        )
        Text(
            text = initials,
            style = textStyle
        )
    }
}

@Preview
@Composable
private fun RoundInitialsColorPreview() {
    RoundInitials(
        modifier = Modifier.size(48.dp),
        initials = "АК",
        color = Color.LightGray,
        contentDescription = null
    )
}