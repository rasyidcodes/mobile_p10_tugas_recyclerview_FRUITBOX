package com.example.fruitbox

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.fruitbox.databinding.ItemFruitboxBinding


typealias OnClickFruit = (Fruit) -> Unit

class FruitAdapter(private val listFruit : List<Fruit>,
                   private val onClickFruit: OnClickFruit):
    RecyclerView.Adapter<FruitAdapter.ItemFruitViewHolder>() {

    inner class ItemFruitViewHolder(private val binding: ItemFruitboxBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Fruit) {
            with(binding){
                /*weightTxt.text = data.weight
                imgIcon.setImageResource(data.gambar)*/
                tvBuah.text = data.name
                tvHarga.text = "Rp " + data.harga.toString()
                btrasa.text =  data.rasa

                if (data.rasa == "manis"){
                    btrasa.setBackgroundResource(R.drawable.round_button_green)
                }else{
                    btrasa.setBackgroundResource(R.drawable.round_button_red)
                }
                Glide.with(itemView)
                    .load(data.gambar) // Assuming data.gambar is the image URL
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .apply(RequestOptions().circleCrop())
                    .into(imgBuah)

                itemView.setOnClickListener {
                    onClickFruit(data)
                }

                itemView.setOnClickListener(){
                    onClickFruit(data)
                }
            }
        }
    }

    fun updateData(newFruitList: List<Fruit>) {
        var fruitList = newFruitList
        notifyDataSetChanged() // Memperbarui tampilan RecyclerView setelah data berubah
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFruitViewHolder {
        val binding = ItemFruitboxBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ItemFruitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemFruitViewHolder, position: Int) {
        holder.bind(listFruit[position])
    }

    override fun getItemCount(): Int {
        return listFruit.size
    }


}