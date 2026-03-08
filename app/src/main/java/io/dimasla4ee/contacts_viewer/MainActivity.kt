package io.dimasla4ee.contacts_viewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.dimasla4ee.contacts_viewer.ui.theme.ContactsViewerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsViewerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ContactDetails(
                        modifier = Modifier.padding(innerPadding),
                        contact = mockContactFilled
                    )
                }
            }
        }
    }
}

val mockContactFilled = Contact(
    "Андрей",
    "Жетпакович",
    "Композин",
    imageRes = null,
    isFavorite = true,
    phone = "+7 (911) 111-11-11",
    address = "США: Маунтин-Вью, Калифорния",
    email = "jetpackcompose@gmail.com"
)

data class Contact(
    val name: String,
    val surname: String? = null,
    val familyName: String,
    @param:DrawableRes val imageRes: Int? = null,
    val isFavorite: Boolean = false,
    val phone: String,
    val address: String,
    val email: String? = null
)

@Composable
fun ContactDetails(
    modifier: Modifier = Modifier,
    contact: Contact
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image( //TODO: Initials
            painter = painterResource(contact.imageRes ?: R.drawable.ic_launcher_background),
            contentDescription = null
        )
        Text(
            text = "${contact.name} ${contact.surname}",
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            text = contact.familyName,
            style = MaterialTheme.typography.titleLarge
        )

        Card(
            modifier = Modifier.padding(8.dp)
        ) {
            LabelValueRow(
                label = stringResource(R.string.mobile),
                value = contact.phone
            )
            LabelValueRow(
                label = stringResource(R.string.address),
                value = contact.address
            )
            contact.email?.let {
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


@Preview(name = "portrait", showSystemUi = true)
@Composable
private fun ContactDetailsFilledPreview() {
    ContactDetails(
        contact = mockContactFilled
    )
}