package com.example.crud_task.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_task.R
import com.example.crud_task.model.VechileModel
import com.example.crud_task.ui.activity.UpdateActivity

class VechileAdapter(
    private val context: Context,
    private var vehicles: List<VechileModel>
) : RecyclerView.Adapter<VechileAdapter.VehicleViewHolder>() {

    class VehicleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.tvVehicleName)
        val licensePlateTextView: TextView = view.findViewById(R.id.tvVehicleInfo)
        val colorTextView: TextView = view.findViewById(R.id.textView_color) // Assuming you have added this in your layout
        var editButton: View = view.findViewById(R.id.tvEdit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sample_recycleview, parent, false)
        return VehicleViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val vehicle = vehicles[position]
        holder.nameTextView.text = vehicle.name
        holder.licensePlateTextView.text = vehicle.licensePlate
        holder.colorTextView.text = vehicle.color // Bind color to the colorTextView
        holder.editButton.setOnClickListener {
            var intent = Intent(context, UpdateActivity::class.java)
            intent.putExtra("id", vehicle.id)
            intent.putExtra("name", vehicle.name)
            intent.putExtra("licensePlate", vehicle.licensePlate)
            intent.putExtra("color", vehicle.color)
            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return vehicles.size
    }

    fun getVechileName(adapterPosition: Int): String {
        return vehicles[adapterPosition].name.toString()
    }

    fun getVechileId(adapterPosition: Int): String {
        return vehicles[adapterPosition].id.toString()
    }

    fun updateData(newVehicles: List<VechileModel>) {
        vehicles = newVehicles
        notifyDataSetChanged()
    }
}
