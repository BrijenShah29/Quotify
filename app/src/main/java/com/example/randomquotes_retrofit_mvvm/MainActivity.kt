package com.example.randomquotes_retrofit_mvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.randomquotes_retrofit_mvvm.Adapter.QuoteAdapter
import com.example.randomquotes_retrofit_mvvm.ViewModels.MainViewModel
import com.example.randomquotes_retrofit_mvvm.ViewModels.MainViewModelFactory
import com.example.randomquotes_retrofit_mvvm.databinding.ActivityMainBinding
import com.example.randomquotes_retrofit_mvvm.models.QuotesList
import com.example.randomquotes_retrofit_mvvm.models.Result

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    lateinit var mainViewModel: MainViewModel
  //  private lateinit var result : MutableList<Result>
    private var quoteResult = ArrayList<Result>()
    private var quoteList = ArrayList<QuotesList>()
    lateinit var adapter : QuoteAdapter

    private var i = 0
    private var v = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        //val repository = QuotesRepository(quoteService)
        val adapter = QuoteAdapter(this,quoteResult)
        val repository = (application as QuoteApplication).quotesRepository
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {

            setQuote(it)
/*
            adapter?.list = it
            val manager = StackLayoutManager()
            manager.canScrollHorizontally()
            binding.recyclerQuotes.setHasFixedSize(true)

            binding.recyclerQuotes.adapter = adapter
            binding.recyclerQuotes.layoutManager = manager
            adapter?.notifyDataSetChanged()

 */


            Log.d("Results", it.toString())
        })
    }

    private fun setQuote(list: List<Result>) {

        quoteText.text = list.get(i)?.content
        quoteAuthor.text = result?.get(p0)?.author

    }

    fun onShare(view: View) {

        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT, result?.get(i)?.content)
        startActivity(intent)

    }

    fun onNext(view: View) {
        if (i == v - 1) {
            i = 0
        } else {
            i += 1
            setQuote(i)
        }


    }

    fun onPrevious(view: View) {
        if (i >= 1) {
            i -= 1
            setQuote(i)
        } else {
            i = 0
        }
    }
}