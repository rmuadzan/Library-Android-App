package com.D121211052.libraryapp.ui.activites.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.D121211052.libraryapp.data.models.Book
import com.D121211052.libraryapp.ui.theme.LibraryAppTheme


class DetailActivity : ComponentActivity() {

    private var selectedBook: Book? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedBook = intent.getParcelableExtra("BOOK")
        setContent {
            LibraryAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BookDetail()
                }
            }
        }
    }

    @Composable
    fun DetailInfo(label: String, text: String? = "-" ) {
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "\t\t\t\t${text}",
            fontSize = 14.sp,
        )
        Spacer(modifier = Modifier.height(16.dp))
    }

    @Composable
    fun BookDetail() {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(selectedBook?.imageLinks?.thumbnail)
                        .crossfade(true)
                        .build(), contentDescription = selectedBook?.title,
                    modifier = Modifier
                        .width(160.dp)
                        .height(220.dp)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = selectedBook?.title.toString(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 7,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
            Spacer(modifier = Modifier.height(70.dp))
            DetailInfo(label = "Author", text = selectedBook?.authors?.joinToString(", "))
            DetailInfo(label = "Publisher", text = selectedBook?.publisher)
            DetailInfo(label = "Published Date", text = selectedBook?.publishedDate)
            DetailInfo(label = "Page Count", text = selectedBook?.pageCount.toString())
            DetailInfo(label = "Preview Link", text = selectedBook?.previewLink)
            DetailInfo(label = "Description", text = selectedBook?.description)
        }
    }
}