package com.example.fruitbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.example.fruitbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterFruit: FruitAdapter
    private lateinit var fruitList: List<Fruit>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fruitList = generateFruitData()
        adapterFruit = FruitAdapter(fruitList) { fruit ->
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("FRUIT_NAME", fruit.name)
            intent.putExtra("FRUIT_IMAGE", fruit.gambar)
            intent.putExtra("FRUIT_DETAIL", fruit.detail)
            intent.putExtra("FRUIT_PRICE", fruit.harga.toString())
            startActivity(intent)
            Toast.makeText(this@MainActivity, "Anda Memilih ${fruit.name}", Toast.LENGTH_SHORT).show()
        }

        with(binding) {
            rvMain.apply {
                adapter = adapterFruit
                layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this@MainActivity)
            }


        }
    }



    private fun generateFruitData(): List<Fruit> {
        return listOf(
            Fruit("Mangga", "manis",10000, "https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2022/08/01071338/5-Fakta-tentang-Buah-Mangga-yang-Wajib-Diketahui.jpg.webp", "Mangga harum manis merupakan mangga yang paling populer dan di gemaridi masyarakat Indonesia,mangga ini mempunyai Ciri dengan daging buah nya yang tebal, berwarna kuning mulus,lunak,tidak berserat dan tidak terlalu mengandung banyak air dan mempunyai bau yang khas \n" +
                    " Berikut beberapa manfaat dari mengonsumsi mangga :\n" +
                    "1.meningkatkan sistem imun\n" +
                    "2.memiliki kandungan vitamin C yang tinggi\n" +
                    "3.melancarkan proses pencernaan\n" +
                    "4.baik untuk diet\n" +
                    "5.membuat tekanan darah menjadi lebih stabil \n" +
                    "HARGA UNTUK 1 KG ISI 2-6 BUAH\n" +
                    "\n" +
                    "Produk yang kami kirimkan merupakan produk terbaik dan pilihan yang berkualitas untuk menjaga kepuasan dan kepercayaan costumer \n" +
                    "\n" +
                    "YUK KAMI MENGAJAK UNTUK MEMULAI POLA HIDUP SEHAT DENGAN LANGKAH AWAL MENGKONSUMSI MAKANAN DAN MINUMAN YANG SEHAT YANG BERMANFAAT UNTUK TUBUH, PADA INTINYA MENGKONSUMSI BUAH\"N SENDIRI SEBAGAI INVESTASI SEHAT UNTUK TUBUH KITA , jadi jadikan toko kami sebagai pilihan Membeli produk\" buah yang berkualitas \uD83E\uDD17\uD83D\uDE4F\n" +
                    "\n" +
                    "Kami juga siap melayani pemesanan untuk Parcel buah dan untuk acara\" yang membutuhkan produk kami dengan harga yang bersahabat tentunya dan kualitas produk yang tidak murahan\n" +
                    "\n" +
                    "TERIMA KASIH TELAH MEMBELI PRODUK KAMI KEPUASAN COSTUMER ADALAH KEBAHAGIAAN KAMI"),

            Fruit("Strawberry", "asam",20000, "https://yubissayur.com/wp-content/uploads/2020/08/strawberry.jpg", "Fresh Strawberry / Buah Stroberi Segar [200 gr] Khusus GOSEND\n" +
                    "\n" +
                    "Kemasan 200 gr\n" +
                    "\n" +
                    "Buah strawberry segar yang dipetik langsung dari kebun. \n" +
                    "\n" +
                    "#strawberry #stroberi #freshstrawberry #buahsegar"),
            Fruit("Anggur","asam", 30000, "https://tribratanews.polri.go.id/web/image/blog.post/57032/image", "\uD83C\uDF47 Anggur Red Globe Merah China\n" +
                    "------------------------------------------------------------\n" +
                    "* Kemasan per 250 gr. \n" +
                    "* Kami kemas per kotak agar praktis dan ekonomis. Bisa dikonsumsi per kotak dan kotak lainnya bisa disimpan di kulkas / freezer utk dikonsumsi nanti.\n" +
                    "* Kondisi Segar, BERBIJI dan MANIS\n" +
                    "* Cocok untuk Diet, Detoksifikasi Racun dalam Tubuh dan Kaya Akan Manfaat Kesehatan (Jantung, Kesehatan Kulit, Menurunkan dan Mengurangi Resiko Diabetes dan Kanker, Nutrisi Baik utk Otak dll).\n" +
                    "\n" +
                    "\n" +
                    "✔ \n" +
                    "✔ Kami Packing Seaman mungkin Sesuai Pengalaman. Rusak karena Handling Kurir Pengiriman, mohon maaf diluar kendali kami.\n" +
                    "\n" +
                    "--------------------------------------------------------------------------------------------------------------------\n" +
                    "\n" +
                    "\uD83D\uDCA1"),

            Fruit("Pisang","manis", 15000, "https://www.yesdok.com/visual/slideshow/article_ecea057e09bc76b8ddd79e2b4e2b2adf055f354f.jpg?w=1200","Buah pisang cavendis 1/2kg\n" +
                    "\n" +
                    "\n" +
                    "Toko buah dan sayuran Jogja\n" +
                    "\n" +
                    "Buah yang kami siapkan kondisi fresh dan manis. \n" +
                    "Pengiriman cepat.\n" +
                    "\n" +
                    "Untuk dalam kota Yogyakarta silahkan memilih pengiriman melalui grab express instan atau gojek instan akan sampai lebih cepat.\n" +
                    "\n" +
                    "Jam buka toko buah dan sayuran yogyakarta\n" +
                    "Senin-Jumat : 06.00-22.00\n" +
                    "Sabtu : 06.00-12.00\n" +
                    "Minggu atau libur nasional tutup\n" +
                    "\n" +
                    "\n" +
                    "#tokobuahjogja\n" +
                    "#tokosayuranjogja\n" +
                    "#tokobuahdansayuranjogja\n" +
                    "#buahpisang\n" +
                    "#pisang\n" +
                    "#banana\n" +
                    "#pisangcavendis"),


        )
    }
}
