package ru.smartlab.demo.marketmap.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.smartlab.demo.core.enum.ExInstrument.Direction
import ru.smartlab.demo.marketmap.R
import ru.smartlab.demo.marketmap.fakeRepo.MoscowExchangeRepository
import ru.smartlab.demo.marketmap.fragments.adapter.TableAdapter

// Demo Variant - not optimized (BAD VARIANT)
class TableMarket : Fragment() {

    // Tmp
    private val listData = MoscowExchangeRepository().getListStocks()

    private val gazAndOilList = listData.filter { it.group == Direction.GAZ_AND_OIL }
    private val financeList = listData.filter { it.group == Direction.FINANCE }
    private val metallurgyList = listData.filter { it.group == Direction.METALLURGY }
    private val itList = listData.filter { it.group == Direction.IT }
    private val consumerSectorList = listData.filter { it.group == Direction.CONSUMER_SECTOR }
    private val energyList = listData.filter { it.group == Direction.ENERGY }
    private val transportList = listData.filter { it.group == Direction.TRANSPORT }
    private val chemistryList = listData.filter { it.group == Direction.CHEMISTRY }
    private val agroList = listData.filter { it.group == Direction.AGRO }
    private val mechanicalEngineeringList = listData.filter { it.group == Direction.MECHANICAL_ENGINEERING }
    private val constructionList = listData.filter { it.group == Direction.CONSTRUCTION }

    private val otherList = listData.filter { it.group == Direction.OTHER }

    private lateinit var gazAndOilRecycler: RecyclerView
    private lateinit var financeRecycler: RecyclerView
    private lateinit var metallurgyRecycler: RecyclerView
    private lateinit var itRecycler: RecyclerView
    private lateinit var consumerSectorRecycler: RecyclerView
    private lateinit var energyRecycler: RecyclerView
    private lateinit var transportRecycler: RecyclerView
    private lateinit var chemistryRecycler: RecyclerView
    private lateinit var agroRecycler: RecyclerView
    private lateinit var mechanicalEngineeringRecycler: RecyclerView
    private lateinit var constructionRecycler: RecyclerView
    private lateinit var otherRecycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val v = inflater.inflate(R.layout.table_fragment, container, false)

        gazAndOilRecycler = v.findViewById(R.id.recyclerGaz)
        financeRecycler = v.findViewById(R.id.recyclerFinance)
        metallurgyRecycler = v.findViewById(R.id.recyclerMetallurgy)
        itRecycler = v.findViewById(R.id.recyclerIT)
        consumerSectorRecycler = v.findViewById(R.id.recyclerConsumer)
        energyRecycler = v.findViewById(R.id.recyclerEnergy)
        transportRecycler = v.findViewById(R.id.recyclerTransport)
        chemistryRecycler = v.findViewById(R.id.recyclerChemistry)
        agroRecycler = v.findViewById(R.id.recyclerAgro)
        mechanicalEngineeringRecycler = v.findViewById(R.id.recyclerMechanical)
        constructionRecycler = v.findViewById(R.id.recyclerConstruction)
        otherRecycler = v.findViewById(R.id.recyclerOther)


        val groupRecycler = listOf(
            gazAndOilRecycler,
            financeRecycler,
            metallurgyRecycler,
            itRecycler,
            consumerSectorRecycler,
            energyRecycler,
            transportRecycler,
            chemistryRecycler,
            agroRecycler,
            mechanicalEngineeringRecycler,
            constructionRecycler,
            otherRecycler
        )

        val groupList = listOf(
            gazAndOilList,
            financeList,
            metallurgyList,
            itList,
            consumerSectorList,
            energyList,
            transportList,
            chemistryList,
            agroList,
            mechanicalEngineeringList,
            constructionList,
            otherList
        )

        groupRecycler.forEachIndexed { index, view ->
            val adapter = TableAdapter()
            view.layoutManager = GridLayoutManager(context, 3)
            view.adapter = adapter
            adapter.addAllAndNotify(groupList[index])
        }

        return v
    }

}