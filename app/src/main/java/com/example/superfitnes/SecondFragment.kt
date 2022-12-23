package com.example.superfitnes

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.superfitnes.databinding.FragmentSecondBinding
import com.google.android.gms.fitness.data.DataPoint
import com.google.android.gms.fitness.data.DataSource
import com.google.android.gms.fitness.data.DataType
import com.google.android.gms.fitness.data.Field
import java.util.concurrent.TimeUnit

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater!!.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.steps -> {
                findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToFirstFragment())
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

//        val nutritionSource = DataSource.Builder()
//            .setDataType(DataType.TYPE_NUTRITION)
//            .build()
//
//        val nutrients = mapOf(
//            Field.NUTRIENT_PROTEIN to 0.4f,
//            Field.NUTRIENT_TOTAL_FAT to 1f,
//            Field.NUTRIENT_TOTAL_CARBS to 0.1f,
//            Field.NUTRIENT_PROTEIN to 1.3f
//        )
//        val banana = DataPoint.builder(nutritionSource)
//            .setTimestamp(timestamp, TimeUnit.MILLISECONDS)
//            .setField(Field.FIELD_FOOD_ITEM, "banana")
//            .setField(Field.FIELD_NUTRIENTS, nutrients)
//            .build()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}