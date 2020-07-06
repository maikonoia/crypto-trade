package br.com.tecdev.btctrade.feature.coins

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.tecdev.btctrade.R
import br.com.tecdev.btctrade.model.AllCoinsResponse
import br.com.tecdev.btctrade.util.formatNumber
import kotlinx.android.synthetic.main.item_all_coin.view.*
import java.util.*

class AllCoinsAdapter : RecyclerView.Adapter<AllCoinsAdapter.AllCoinsViewHolder>() {

    var list: MutableList<AllCoinsResponse>? = null
    var listSelected: Array<Boolean?>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AllCoinsViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_all_coin, parent, false)
    )

    override fun getItemCount() = list?.size ?: 0

    override fun onBindViewHolder(holder: AllCoinsViewHolder, position: Int) {
        list?.get(position)?.run {
            listSelected?.get(position)?.let {
                holder.bind(this, it)
            }
        }
    }

    fun setData(list: MutableList<AllCoinsResponse>) {
        listSelected = arrayOfNulls(list.size)
        Arrays.fill(listSelected, false)
        this.list = list
    }

    fun getPositionFromCoin(coin: String): Int? {
        list?.run {
            for ((index, value) in this.withIndex()) {
                if (value.coin == coin) {
                    return index
                }
            }
            return -1
        } ?: return -1
    }

    inner class AllCoinsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(coin: AllCoinsResponse, isSelected: Boolean) {
            itemView.apply {
                coinName.text = coin.coin
                buyPriceText.text = resources.getString(R.string.currency, formatNumber(coin.buy))
                sellPriceText.text = resources.getString(R.string.currency, formatNumber(coin.sell))
                highPriceText.text = resources.getString(R.string.currency, formatNumber(coin.high))
                contentItemView.setBackgroundColor(
                    if (isSelected) ContextCompat.getColor(
                        context,
                        R.color.purpleAccentOpacity10
                    ) else Color.WHITE
                )
            }
        }
    }
}