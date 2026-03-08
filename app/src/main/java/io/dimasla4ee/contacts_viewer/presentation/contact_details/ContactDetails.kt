package io.dimasla4ee.contacts_viewer.presentation.contact_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.dimasla4ee.contacts_viewer.R
import io.dimasla4ee.contacts_viewer.domain.model.Contact
import io.dimasla4ee.contacts_viewer.presentation.components.RoundInitials

@Composable
fun ContactDetails(
    contact: Contact,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val avatarSizeModifier = Modifier.fillMaxWidth(0.55f)

        contact.imageRes?.let {
            Image(
                modifier = avatarSizeModifier
                    .aspectRatio(1f)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
                painter = painterResource(contact.imageRes),
                contentDescription = null
            )
        } ?: RoundInitials(
            modifier = avatarSizeModifier,
            initials = "${contact.name.first()}${contact.familyName.first()}",
            textStyle = TextStyle.Default.copy(
                fontSize = 50.sp
            ),
            color = Color.LightGray,
            contentDescription = null
        )

        Text(
            modifier = Modifier.padding(top = 16.dp, bottom = 4.dp),
            text = "${contact.name} ${contact.surname}",
            style = MaterialTheme.typography.titleSmall
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = contact.familyName,
                style = MaterialTheme.typography.titleLarge
            )
            if (contact.isFavorite) {
                Image(
                    painter = painterResource(android.R.drawable.star_big_on),
                    contentDescription = stringResource(R.string.is_in_favorites)
                )
            }
        }

        Card(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)
        ) {
            LabelValueRow(
                label = stringResource(R.string.mobile),
                value = contact.phone
            )
            LabelValueRow(
                label = stringResource(R.string.address),
                value = contact.address
            )
            if (contact.email != null) {
                LabelValueRow(
                    label = stringResource(R.string.email),
                    value = contact.email
                )
            }
        }
    }
}

@Composable
fun LabelValueRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .alpha(0.65f),
            text = "$label:",
            fontStyle = FontStyle.Italic,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.End
        )
        Text(
            modifier = Modifier.weight(1f),
            text = value,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Start
        )
    }
}

private val mockContactFavorite = Contact(
    "Андрей",
    "Жетпакович",
    "Композин",
    imageRes = null,
    isFavorite = true,
    phone = "+7 (911) 111-11-11",
    address = "США: Маунтин-Вью, Калифорния",
    email = "jetpackcompose@gmail.com"
)

private val mockContact = mockContactFavorite.copy(
    imageRes = R.drawable.ic_launcher_foreground,
    isFavorite = false,
    email = null
)

@Preview(name = "portrait", showSystemUi = true)
@Composable
private fun ContactDetailsFavoritePreview() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        ContactDetails(
            modifier = Modifier.padding(innerPadding),
            contact = mockContactFavorite
        )
    }
}

@Preview(name = "portrait", showSystemUi = true)
@Composable
private fun ContactDetailsPreview() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        ContactDetails(
            modifier = Modifier.padding(innerPadding),
            contact = mockContact
        )
    }
}