package com.example.harjoitus6

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Euro
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.ui.res.stringResource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.harjoitus6.R

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    var category: String,
    val price: Double,
    val isDiscount: Boolean
)

val products = listOf(
    Product(1, "Maito", "Tuore täysmaito päivittäiseen käyttöön. Sopii juotavaksi sekä ruoanlaittoon.","Ruoka", 1.99, false),
    Product(2, "Leipä", "Pehmeä vehnäleipä aamiaiselle ja välipalaksi. Leivottu Suomessa.","Ruoka", 2.49, true),
    Product(3, "Kanafilee", "Vähärasvainen ja proteiinipitoinen kananfilee monipuoliseen ruoanlaittoon.","Ruoka", 8.99, true),
    Product(4, "Banaanit", "Makeat ja ravitsevat banaanit välipalaksi tai smoothieihin.","Ruoka", 1.79, false),
    Product(5, "Appelsiinimehu","Raikas appelsiinimehu ilman lisättyä sokeria.", "Juoma", 3.49, true),
    Product(6, "Kahvi", "Täyteläinen suodatinkahvi päivän jokaiseen hetkeen.", "Juoma", 6.49, true),
    Product(7, "Astianpesuaine", "Tehokas astianpesuaine, joka poistaa rasvan helposti.","Kotitalous", 3.29, false),
    Product(8, "Pyykinpesuaine", "Pyykinpesuaine värillisille ja valkoisille tekstiileille.", "Kotitalous", 8.99, false),
    Product(9, "WC-paperi", "Pehmeä ja kestävä WC-paperi koko perheen käyttöön.", "Kotitalous", 7.49, true),
    Product(10, "Shampoo", "Hellävarainen shampoo päivittäiseen hiustenpesuun.", "Hygienia", 4.89, false),
    Product(11, "Hammastahna", "Fluoria sisältävä hammastahna raikkaaseen hengitykseen.", "Hygienia", 2.99, false),
    Product(12, "LED-lamppu", "Energiatehokas LED-lamppu, pitkä käyttöikä ja kirkas valo.", "Elektroniikka", 5.49, true),
    Product(13, "Ruis leipä", "Perinteinen suomalainen täysjyväruisleipä. Runsaasti kuitua ja täyteläinen maku.", "Ruoka", 2.79, false),
)

@Composable
fun ProductsListScreen(
    // Funktioparametri eli tälle syötetään funktio, jota tämä voi kutsua kun tapahtuma valitaan
    // (Int) -> Unit - syntaksi tarkoittaa, että tälle voidaan syöttää funktio
    // Joka saa Int- parametrin ja ei palauta mitään (Unit == Void)
    onProductClick: (Int) -> Unit = {}
) {
    var showOnlyDiscount by rememberSaveable {
        mutableStateOf(false)
    }

    var searchProduct by rememberSaveable {
        mutableStateOf("")
    }

    val searchedProducts = products.filter { p -> p.name.contains(searchProduct,
        ignoreCase = true)
    }

    val filteredProducts = if(showOnlyDiscount) {
        searchedProducts
            .filter { p -> p.isDiscount }
    } else {
        searchedProducts
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.product_list_title),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = searchProduct,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            onValueChange = {
                searchProduct = it
            },
            singleLine = true,
            label = { Text(stringResource(R.string.etsi_tuotteita))},
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            when(showOnlyDiscount) {
                true -> {
                    Text(text = stringResource(R.string.show_all_products))
                }
                false -> {
                    Text(text = stringResource(R.string.show_only_discount_products))
                }
            }
            Switch(
                checked = showOnlyDiscount,
                onCheckedChange = { isChecked ->
                    showOnlyDiscount = isChecked
                }
            )
        }
        if(filteredProducts.isEmpty()) {
            Text(
                text = stringResource(R.string.no_products_to_show),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.error
            )
        }
        LazyColumn (
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(filteredProducts.size) { index ->
                val product = filteredProducts[index]
                ProductItem(
                    product = product,
                    onClick = {
                        onProductClick(product.id)
                    }
                )
            }
        }
    }
}


@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                when(product.isDiscount) {
                    true -> {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = product.name,
                                style = MaterialTheme.typography.titleLarge
                            )
                            Text(
                                text = stringResource(R.string.discount_tag),
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.error
                            )

                        }
                    }
                    false -> Text(
                        text = product.name,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
                InfoRow(
                    text = product.category,
                    imageVector = Icons.Default.Category,
                    contentDescription = stringResource(R.string.category_content_description),
                    tint = MaterialTheme.colorScheme.secondary,
                )
                InfoRow(
                    text = "%.2f €".format(product.price),
                    imageVector = Icons.Default.Euro,
                    contentDescription = stringResource(R.string.price_content_description),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            Image(
                painter = painterResource(id = R.drawable.price),
                contentDescription = "Tarjoukset",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(64.dp)
            )
        }
    }
}
