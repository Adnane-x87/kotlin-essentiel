package com.adnane.composablehellocounter.ui



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.adnane.composablehellocounter.R

@Composable
fun CompteurSection(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }

    val decrementCd = stringResource(R.string.cd_decrement)
    val incrementCd = stringResource(R.string.cd_increment)
    val counterCd   = stringResource(R.string.cd_counter_value, count)

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = stringResource(R.string.title_counter),
            style = MaterialTheme.typography.titleMedium
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = { if (count > 0) count-- },
                enabled = count > 0,
                modifier = Modifier
                    .size(48.dp)
                    .semantics { contentDescription = decrementCd }
            ) {
                Icon(Icons.Filled.Remove, contentDescription = null)
            }

            Text(
                text = "$count",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .widthIn(min = 40.dp)
                    .semantics { contentDescription = counterCd }
            )

            IconButton(
                onClick = { count++ },
                modifier = Modifier
                    .size(48.dp)
                    .semantics { contentDescription = incrementCd }
            ) {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
        }
    }
}
