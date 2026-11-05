package com.example.harjoitus5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.material3.Switch
import androidx.compose.ui.res.stringResource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

data class Product(
    val id: Int,
    val name: String,
    var category: String,
    val price: Double,
    val isDiscount: Boolean
)

val products = listOf(
    Product(1, "Maito", "Ruoka", 1.99, false),
    Product(2, "Leipä", "Ruoka", 2.49, true),
    Product(3, "Kanafilee", "Ruoka", 8.99, true),
    Product(4, "Banaanit", "Ruoka", 1.79, false),
    Product(5, "Appelsiinimehu", "Juoma", 3.49, true),
    Product(6, "Kahvi", "Juoma", 6.49, true),
    Product(7, "Astianpesuaine", "Kotitalous", 3.29, false),
    Product(8, "Pyykinpesuaine", "Kotitalous", 8.99, false),
    Product(9, "WC-paperi", "Kotitalous", 7.49, true),
    Product(10, "Shampoo", "Hygienia", 4.89, false),
    Product(11, "Hammastahna", "Hygienia", 2.99, false),
    Product(12, "LED-lamppu", "Elektroniikka", 5.49, true)
)

@Composable
fun Products() {
    var showOnlyDiscount by rememberSaveable {
        mutableStateOf(false)
    }

    val filteredProducts = if(showOnlyDiscount) {
        products.filter { p -> p.isDiscount }
    } else {
        products
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.product_list_title),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
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
                ProductItem(product = filteredProducts[index])
            }
        }
    }
}
@Composable
fun ProductItem(product: Product, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
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
    }
}



