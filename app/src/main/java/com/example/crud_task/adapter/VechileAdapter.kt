package com.example.crud_task.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_task.R
import com.google.android.libraries.mapsplatform.transportation.consumer.model.Vehicle


    class VechileAdapter(val context: Context, val vehicles: List<Vehicle>) : RecyclerView.Adapter<VechileAdapter.VehicleViewHolder>() {

        class VehicleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val nameTextView: TextView = view.findViewById(R.id.tvVehicleName)
            val licensePlateTextView: TextView = view.findViewById(R.id.tvVehicleInfo)
            // Add more views as needed
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.sample_recycleview, parent, false)
            return VehicleViewHolder(view) ;
        }

        override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
//            TODO("Not yet implemented")
            holder.licensePlateTextView.text = vehicles[position].toString()
            holder.nameTextView.text = vehicles[position].toString()
        }

        override fun getItemCount(): Int {
            return vehicles.size
        }




    }
