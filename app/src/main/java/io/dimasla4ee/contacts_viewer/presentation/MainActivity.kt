package io.dimasla4ee.contacts_viewer.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.dimasla4ee.contacts_viewer.R
import io.dimasla4ee.contacts_viewer.domain.model.Contact
import io.dimasla4ee.contacts_viewer.presentation.contact_details.ContactDetails
import io.dimasla4ee.contacts_viewer.ui.theme.ContactsViewerTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsViewerTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    ContactDetails(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(vertical = 8.dp),
                        contact = Contact(
                            "Ella",
                            "",
                            "Purnell",
                            imageRes = R.drawable.ella_purnell,
                            isFavorite = true,
                            phone = "+44 (131) 2345 678",
                            address = "London, England",
                            email = null
                        )
                    )
                }
            }
        }
    }

}