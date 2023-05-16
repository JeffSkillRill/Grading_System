package com.jeff_skillrill.marks.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jeff_skillrill.marks.databinding.MarksItemBinding

class Bakholar_Adapter (var list: MutableList<Marks_List>) : RecyclerView.Adapter<Bakholar_Adapter.ViewHolder>(){
    class ViewHolder(binding: MarksItemBinding): RecyclerView.ViewHolder(binding.root){
        var name = binding.subjectName
        var bsb1 = binding.bsb1
        var bsb2 = binding.bsb2
        var fb = binding.fb
        var chsb = binding.chsb
        var jami  = binding.jami

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MarksItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list.get(position).name
        holder.bsb1.text = list.get(position).bsb1.toString()
        holder.bsb2.text = list.get(position).bsb2.toString()
        holder.fb.text = list.get(position).fb.toString()
        holder.chsb.text = list.get(position).chsb.toString()
        var total = list.get(position).bsb1+list.get(position).bsb2+list.get(position).fb+list.get(position).chsb
        holder.jami.text = total.toString()
    }
}