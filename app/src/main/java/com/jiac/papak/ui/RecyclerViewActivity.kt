package com.jiac.papak.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jiac.papak.R
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.android.synthetic.main.item_rv.view.*

class RecyclerViewActivity : AppCompatActivity() {
    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN - 23/12",
            "Sat 6/28 - TRAPPED IN - 23/13",
            "Sat 6/28 - TRAPPED IN - 23/14",
            "Sat 6/28 - TRAPPED IN - 23/15",
            "Sun 6/29 - Sunny - 20/7"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)


        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = TestAapter(items)
    }


    class TestAapter(val datas: List<String>?) : RecyclerView.Adapter<TestAapter.ViewHolder>() {
        /**
         * 安全调用操作符（写做?）
         * **/
        override fun onBindViewHolder(holder: TestAapter.ViewHolder, position: Int) {
            if (datas != null) {
                holder.view.tv_rv.text = datas[position]
            }
        }

        override fun getItemCount(): Int {
            if (datas == null)
                return 0
            return datas.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val inflate = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
            return ViewHolder(inflate)
        }

        class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        }
    }
}
