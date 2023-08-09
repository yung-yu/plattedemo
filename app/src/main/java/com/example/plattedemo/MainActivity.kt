package com.example.plattedemo

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import com.example.plattedemo.ui.theme.PlatteDemoTheme


class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			PlatteDemoTheme {
				// A surface container using the 'background' color from the theme
				Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
					Greeting("Android")
				}
			}
		}
	}
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
	LazyRow() {
		item {
			ImageDemo(R.drawable.wall)
		}
		item {
			ImageDemo(R.drawable.wall1)
		}
		item {
			ImageDemo(R.drawable.wall2)
		}
		item {
			ImageDemo(R.drawable.wall3)
		}
		item {
			ImageDemo(R.drawable.wall4)
		}
		item {
			ImageDemo(R.drawable.wall5)
		}

		item {
			ImageDemo(R.drawable.wall6)
		}

	}


}

@OptIn(ExperimentalTextApi::class)
@Composable
fun ImageDemo(resourceId: Int) {
	val context = LocalContext.current
	val textMeasure = rememberTextMeasurer()
	Box(modifier = Modifier
		.fillMaxSize()
		.width(420.dp)) {
		val imageBitmap = ImageBitmap.imageResource(resourceId)
		Image(
			modifier = Modifier.fillMaxSize(),
			bitmap = imageBitmap,
			contentDescription = "",
			contentScale = ContentScale.FillBounds
		)
		val text = "Hello, world!"
		val rotate = 90f

		val palette = Palette.from(imageBitmap.asAndroidBitmap()).generate()
		LazyColumn(modifier = Modifier.padding(16.dp)) {
			items(count = palette.swatches.size) {
				val item = palette.swatches[it]
				if (it == 0) {
					Row {
						Text(
							modifier = Modifier
								.weight(1f)
								.height(40.dp)
								.border(1.dp, Color.Black)
								.padding(8.dp), textAlign = TextAlign.Center, color = (Color(item.titleTextColor)),
							text = "Title Text"
						)
						Text(
							modifier = Modifier
								.weight(1f)
								.height(40.dp)
								.border(1.dp, Color.Black)
								.padding(8.dp), textAlign = TextAlign.Center, color = (Color(item.rgb)),
							text = "RGB"
						)

						Text(
							modifier = Modifier
								.weight(1f)
								.height(40.dp)
								.border(1.dp, Color.Black)
								.padding(8.dp), textAlign = TextAlign.Center, color = (Color(item.bodyTextColor)),
							text = "Body Text"
						)
					}
				}

				Row(
				) {
					Text(
						modifier = Modifier
							.weight(1f)
							.height(40.dp)
							.border(1.dp, Color.Black)
							.padding(8.dp), textAlign = TextAlign.Center, color = (Color(item.titleTextColor)),
						text = Integer.toHexString(item.titleTextColor)
					)
					Text(
						modifier = Modifier
							.weight(1f)
							.height(40.dp)
							.border(1.dp, Color.Black)
							.padding(8.dp), textAlign = TextAlign.Center, color = (Color(item.rgb)),
						text = Integer.toHexString(item.rgb)
					)

					Text(
						modifier = Modifier
							.weight(1f)
							.height(40.dp)
							.border(1.dp, Color.Black)
							.padding(8.dp), textAlign = TextAlign.Center, color = (Color(item.bodyTextColor)),
						text = Integer.toHexString(item.bodyTextColor)
					)
				}

			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	PlatteDemoTheme {
		Greeting("Android")
	}
}