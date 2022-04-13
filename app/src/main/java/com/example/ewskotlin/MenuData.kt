package com.example.ewskotlin

import com.example.ewskotlin.Model.Bridge

object MenuData {
    private val menuName =
        arrayOf("Jembatan Gembong", "Jembatan Welang", "Jembatan Bakalan", "Jembatan Ngrame")

    private val logo =
        intArrayOf(R.drawable.river, R.drawable.river, R.drawable.river, R.drawable.river)

    private val url = arrayOf("", "", "", "")

    val listData: ArrayList<Bridge>
        get() {
            val list = arrayListOf<Bridge>()
            for (position in logo.indices) {
                val bridge = Bridge()
                bridge.menuName = menuName[position]
                bridge.logo = logo[position]
                bridge.url = url[position]
                list.add(bridge)
            }
            return list
        }
}