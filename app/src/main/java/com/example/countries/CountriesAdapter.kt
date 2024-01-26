package com.example.countries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.network.model.Country


class CountriesAdapter(private val countries: List<Country>) :
    RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvCountry: TextView
        val tvCode: TextView

        init {
            tvCountry = view.findViewById(R.id.tv_country)
            tvCode = view.findViewById(R.id.tv_code)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.viewholder_country, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val country = countries[position]
        viewHolder.run {
            tvCountry.text = country.run {
                "$name, $region" +
                        "\n$capital"
            }
            tvCode.text = country.code
        }
    }

    override fun getItemCount() = countries.size

}
