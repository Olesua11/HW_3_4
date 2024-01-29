import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw_3_4.App
import com.example.hw_3_4.databinding.FragmentTaskEditBinding

class TaskEditFragment : Fragment() {

    private var _binding: FragmentTaskEditBinding? = null
    private val binding get() = _binding!!

    private var task: Task? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        task = arguments?.getSerializable("key") as Task?

        binding.etTitle.setText(task?.title)
        binding.etDesc.setText(task?.description)

        val radioButtonId = binding.rbGroup.checkedRadioButtonId
        val selectedRadioButton = view.findViewById<AppCompatRadioButton>(radioButtonId)
        val selectedRadioButtonText = selectedRadioButton?.text.toString()



        binding.saveButton.setOnClickListener {
            if (task ==null) {
                val task = Task(
                    title = binding.etTitle.text.toString(),
                    status = selectedRadioButtonText,
                    dueDate = 0,
                    description = binding.etDesc.text.toString()
                )
                App.db.taskDao().insertTask(task)
            } else {
                val updatedTask = task?.copy(
                    title = binding.etTitle.text.toString(),
                    status = selectedRadioButtonText,
                    dueDate = 0,
                    description = binding.etDesc.text.toString()
                )
                App.db.taskDao().updateTask(updatedTask!!)
            }
            // setFragmentResult(KEY1, resultBundle)
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val KEY1 = "KEY"
    }
}
