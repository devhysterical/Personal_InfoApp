package com.example.personal_infoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserInfoAdapter(private val userInfoList: List<UserInfo>) : RecyclerView.Adapter<UserInfoAdapter.UserInfoViewHolder>() {

    inner class UserInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewInfo: TextView = itemView.findViewById(R.id.textViewInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserInfoViewHolder, position: Int) {
        val userInfo = userInfoList[position]
        holder.textViewInfo.text = "${userInfo.name}, ${userInfo.email}, ${userInfo.phone}, ${userInfo.gender}"
    }

    override fun getItemCount() = userInfoList.size
}