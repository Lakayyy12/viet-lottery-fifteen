
package com.application.vietlotteryfifteen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_item_viewer_page.view.*
import kotlinx.android.synthetic.main.activity_item_viewer_page.view.*
import kotlin.coroutines.coroutineContext

class ViewPagerAdapter(
    val context: Context,
    val images: List<Int>,
    val detail: List<Int>,
    val interfaces: AdapterInterface

) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>(){
    inner class ViewPagerHolder(itemView : View) :RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_viewer_page, parent, false)
        return ViewPagerHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val curImage = images[position]
        val content: Int = detail[position]

        holder.itemView.contents.text = context.resources.getString(content)
        holder.itemView.back.setOnClickListener {
            interfaces.onBackPressed()
        }
    }

    override fun getItemCount(): Int {
        return images.size
    }

    interface AdapterInterface {
        fun onBackPressed()
    }
}
class MyAdapter(var wayList : ArrayList<Detail>?) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_way,
            parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = wayList?.get(position)
//        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.title.text = currentItem?.titles
        holder.meaning.text = currentItem?.description

        val isVisible : Boolean = currentItem?.visbility == true
        holder.constraintLayout.visibility = if (isVisible) View.VISIBLE else View.GONE

        holder.title.setOnClickListener{
            currentItem?.visbility = !currentItem?.visbility!!
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int = wayList?.size ?: 0

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //        val titleImage: ShapeableImageView = itemView.findViewById(R.id.title_image)
        val title: TextView = itemView.findViewById(R.id.title)
        val meaning: TextView = itemView.findViewById(R.id.description)
        val constraintLayout: ConstraintLayout = itemView.findViewById(R.id.expendedlayout)
    }
}