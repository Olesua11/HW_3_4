package com.example.hw_3_4.ui.home.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.navigation.fragment.findNavController
import com.example.hw_3_4.App
import com.example.hw_3_4.R
import com.example.hw_3_4.databinding.FragmentAddProjectBinding
import com.example.hw_3_4.models.Project
import com.example.hw_3_4.models.Task
import studio.clapp.wheelpicker.WheelPicker
import java.util.Calendar

class AddProjectFragment : Fragment() {
    private lateinit var binding: FragmentAddProjectBinding
    private var typeText = ""
    private var categoryText = ""
    private var deadlineDay = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddProjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentDate = Calendar.getInstance()
        val currentDay = currentDate.get(Calendar.DATE)
        val currentMonth = currentDate.get(Calendar.MONTH) + 1

        with(binding) {
            btnChooseCategory.setOnClickListener {
                val alertDialogCategory = setAlertDialog(R.layout.alert_dialog_category)
                val radioGroup = alertDialogCategory.findViewById<RadioGroup>(R.id.rb_group)
                radioGroup?.setOnCheckedChangeListener { group, checkedId ->
                    val selectedRadioButton = group.findViewById<AppCompatRadioButton>(checkedId)
                    categoryText = selectedRadioButton?.text?.toString() ?: ""
                    alertDialogCategory.dismiss()
                }
            }

            btnChooseDeadline.setOnClickListener {
                val alertDialog = setAlertDialog(R.layout.time_picker)

                val dayPicker = alertDialog.findViewById<WheelPicker>(R.id.day)
                val okButton = alertDialog.findViewById<Button>(R.id.btn_ok)
                okButton.setOnClickListener {
                    val selectedDay = dayPicker.getCurrentItem() + 1
                    deadlineDay = selectedDay.toInt()
                    alertDialog.dismiss()
                }
            }

            btnSave.setOnClickListener {
                val project = Project(
                    id = 0,
                    name = etNameProject.text.toString(),
                    category = categoryText,
                    status = typeText,
                    deadlineDay = deadlineDay,
                )
                App.db.taskDao().insertProject(project)
                findNavController().navigateUp()
            }
        }
    }

    private fun setAlertDialog(view: Int): AlertDialog {
        val layoutInflater: LayoutInflater = layoutInflater
        val dialogLayout = layoutInflater.inflate(view, null)
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setView(dialogLayout)
        val alertDialog = builder.create()
        alertDialog.show()
        return alertDialog
    }
}
