package com.dessy.catatsuhu;

public class Konfigurasi {
    //Dibawah ini adalah Pengalamatan tempat tersisanya lokasi Skrip HPH
    //Alamatnya tertuju ke file tersebut disimpan
    //JANGAN LUPA gunakan IP SESUAI DENGAN IP SERVER atau nama domain nya
    public static final String URL_GET_SUHU="http://192.168.165.187/android_suhusiswa/data/suhulihatdata.php";
    public static final String URL_ADD="http://192.168.165.187/android_suhusiswa/data/suhutambah.php";

    //Data ini merupakan script atau perintah untuk mengirim permintaan ke dalam Skrip PHP
    public static final String KEY_NIS = "nis";
    public static final String KEY_SUHU = "suhu";

    //JSON Tags
    public static final String TAG_JSON_ARRAY= "result";
    public static final String TAG_ID= "nis";
    public static final String TAG_SUHU = "suhu";

    //ID SISWA
    public static final String ID_SISWA = "nis";
}

