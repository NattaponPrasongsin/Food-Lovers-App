package th.ac.su.nattapon.foodlovers.Data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.list_item_food.view.*
import th.ac.su.nattapon.foodlovers.R

class FoodAdapter(private val  context: Context, private val dataSource: ArrayList<Food>) : BaseAdapter(){


    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.list_item_food,null)

        rowView.tvNameRestaurant.text = dataSource[position].restaurantName
        rowView.tvFoodName.text = dataSource[position].foodName
        rowView.tvPrice.text = dataSource[position].price

        val res = context.resources
        val drawableId:Int = res.getIdentifier(dataSource[position].imageFile,"drawable",context.packageName)

        rowView.imgThumbnail.setImageResource(drawableId)


        return rowView
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }
}