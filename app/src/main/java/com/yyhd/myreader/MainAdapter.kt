package com.yyhd.myreader

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.Switch
import androidx.fragment.app.Fragment
import com.yyhd.myreader.bookshelf.BookshelfFragment
import com.yyhd.myreader.search.SearchFragment
import com.yyhd.normal.MainBottomTabView

/**
 * Created by hanli
 * date 2020-05-14.
 * ps:
 */
class MainAdapter(context : Context) : MainBottomTabView.Adapter<View>() {

    var mContext = context


    override fun onTabMenuUnchoosed(position: Int, tabMenu: View?) {
        tabMenu?.isSelected = false
    }

    override fun interceptClick(position: Int): Boolean {
        return false
    }

    override fun getTabCount(): Int {
        return 2
    }

    override fun onTabMenuChoosed(position: Int, tabMenu: View?) {
        tabMenu?.isSelected = true
    }

    override fun createTabContent(position: Int): Fragment {
        var fragment : Fragment
        when(position){
            0 -> {
                fragment = BookshelfFragment()
            }

            1 -> {
                fragment = SearchFragment()
            }
            else -> fragment = Fragment()
        }
        return fragment
    }

    override fun createTabMenu(position: Int, menuContainer: FrameLayout?): View {
        var itemView : View
        when (position) {
            0 -> {
                itemView = LayoutInflater.from(mContext).inflate(R.layout.item_main_menu_bookshelf , menuContainer , false)
            }

            1 -> {
                itemView = LayoutInflater.from(mContext).inflate(R.layout.item_main_menu_search , menuContainer , false)
            }

            else -> itemView = View(menuContainer?.context)
        }
        return itemView
    }
}