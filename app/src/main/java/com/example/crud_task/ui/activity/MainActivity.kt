package com.example.crud_task.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_task.adapter.VechileAdapter
import com.example.crud_task.databinding.ActivityMainBinding
import com.example.crud_task.databinding.DailogAddVechileBinding
import com.example.crud_task.model.VechileModel
import com.example.crud_task.repository.vechileRepositoryImpl
import com.example.crud_task.viewmodel.VechileViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var vechileAdapter: VechileAdapter
    private lateinit var vechileViewModel: VechileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)



        mainBinding.ivAdd.setOnClickListener {
            val dialogBinding = DailogAddVechileBinding.inflate(LayoutInflater.from(this))
            val builder = AlertDialog.Builder(this)
                .setView(dialogBinding.root)
                .setTitle("Add Vehicle")
            val alertDialog = builder.show()

            val launchBrandActivity = {
                alertDialog.dismiss() // Dismiss the dialog before starting the new activity
                val intent = Intent(this, BrandActivity::class.java)
                startActivity(intent)
            }

            dialogBinding.buttonAddBike.setOnClickListener {
                launchBrandActivity()
            }

            dialogBinding.buttonAddScooter.setOnClickListener {
                launchBrandActivity()
            }
        }

        val repo = vechileRepositoryImpl()
        vechileViewModel = VechileViewModel(repo)
        val emptyList = emptyList<VechileModel>()
        vechileViewModel.fetchAllVechile()

        vechileAdapter = VechileAdapter(this, emptyList())

        mainBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = vechileAdapter
        }

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val id = vechileAdapter.getVechileId(viewHolder.adapterPosition)
                val vechileName = vechileAdapter.getVechileName(viewHolder.adapterPosition)

                vechileViewModel.deleteVechile(id) { success, message ->
                    if (success) {
                        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }).attachToRecyclerView(mainBinding.recyclerView)

        // Load data and update the adapter
        loadVehicles()
    }

    private fun loadVehicles() {
//         Assuming you have a method in ViewModel to fetch vehicles
//        vechileViewModel.fetchAllVechile()
//              vehicles->
//            vechileAdapter.updateData(vehicles)
//        }
//        }
//        vechileViewModel.fetchAllVechile { id ->
//            vechileAdapter.updateData(id)
    }
}
