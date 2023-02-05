package com.example.kosthub.data.locale.raw

import com.example.kosthub.R

object ListCheckableItem {

    val peraturanKost = listOf(
        CheckableItem(
            id = 0,
            image = R.drawable.ic_kost_rules_0,
            label = "Lebih dari 5 orang/kamar"
        ),
        CheckableItem(
            id = 1,
            image = R.drawable.ic_kost_rules_1,
            label = "Ada jam malan"
        ),
        CheckableItem(
            id = 2,
            image = R.drawable.ic_kost_rules_2,
            label = "Ada jam malam untuk tamu"
        ),
        CheckableItem(
            id = 3,
            image = R.drawable.ic_kost_rules_3,
            label = "Akses 24 jam"
        ),
        CheckableItem(
            id = 4,
            image = R.drawable.ic_kost_rules_4,
            label = "Bawa hasil tes antigen saat check-in (sewa harian)"
        ),
    )

    val fasilitasKost = listOf(
        CheckableItem(
            id = 0,
            image = R.drawable.ic_kost_facility_0,
            label = "Balkon"
        ),
        CheckableItem(
            id = 1,
            image = R.drawable.ic_kost_facility_1,
            label = "CCTV"
        ),
        CheckableItem(
            id = 2,
            image = R.drawable.ic_kost_facility_2,
            label = "Dispenser"
        ),
        CheckableItem(
            id = 3,
            image = R.drawable.ic_kost_facility_3,
            label = "Dapur"
        ),
        CheckableItem(
            id = 4,
            image = R.drawable.ic_kost_facility_4,
            label = "Duplikat gerbang kost"
        ),

    )

    val skemaPembayaran = listOf(
        CheckableItem(
            id = 0,
            label = "Harian"
        ),
        CheckableItem(
            id = 3,
            label = "Per 3 bulan"
        ),
        CheckableItem(
            id = 1,
            label = "Mingguan"
        ),
        CheckableItem(
            id = 4,
            label = "Per 6 bulan"
        ),
        CheckableItem(
            id = 2,
            label = "Bulanan"
        ),
        CheckableItem(
            id = 5,
            label = "Per 12 bulan"
        ),
    )

    val fasilitasKamarMandi = listOf(
        CheckableItem(
            id = 0,
            image = 0,
            label = "",
            isChecked = false
        )
    )

    val fasilitasKamar = listOf(
        CheckableItem(
            id = 0,
            image = 0,
            label = "",
            isChecked = false
        )
    )
}