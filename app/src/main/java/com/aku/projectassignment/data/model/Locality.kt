package com.aku.projectassignment.data.model

data class Locality(
        var province:  Int = 0,
        var district: Int = 0,
        var tehsil: Int = 0,
        val provinceList: ArrayList<Province> = ArrayList<Province>(),
        val districtListSindh: ArrayList<District> = ArrayList<District>(),
        val districtListPunjab: ArrayList<District> = ArrayList<District>(),
        val tehsilListKarachi: ArrayList<Tehsil> =  ArrayList<Tehsil>(),
        val tehsilListLahore: ArrayList<Tehsil> =  ArrayList<Tehsil>()



){
    init {

        val t0 = Tehsil(0,"Select Tehsil")
        tehsilListKarachi.add(t0)

        val haidri = Tehsil(11,"haidri")
        tehsilListKarachi.add(haidri)

        val SakhiHassan = Tehsil(12,"Sakhi Hassan")
        tehsilListKarachi.add(SakhiHassan)

        val BufferZone = Tehsil(13,"Buffer Zone")
        tehsilListKarachi.add(BufferZone)

        val AyeshaManzil = Tehsil(14,"Ayesha Manzil")
        tehsilListKarachi.add(AyeshaManzil)

        val Azizabad = Tehsil(15,"Azizabad")
        tehsilListKarachi.add(Azizabad)

        val Karimabad = Tehsil(16,"Karimabad")
        tehsilListKarachi.add(Karimabad)

        val LiaqatAbad = Tehsil(17,"Liaqat Abad")
        tehsilListKarachi.add(LiaqatAbad)

        val PaposhNagar = Tehsil(18,"Paposh Nagar")
        tehsilListKarachi.add(PaposhNagar)

        val Nazimabad = Tehsil(19,"Nazimabad")
        tehsilListKarachi.add(Nazimabad)



        val d0 = District(0,"Select District", ArrayList())
        val karachi = District(1,"Karachi", tehsilListKarachi)
        districtListSindh.add(d0)

        districtListSindh.add(karachi)

        val s0 = Province(0,"Select Province", ArrayList())
        provinceList.add(s0)

        val sindh = Province(1,"Sindh", districtListSindh)
        provinceList.add(sindh)


        val ravi = Tehsil(21,"Ravi")
        tehsilListLahore.add(ravi)

        val shalamar = Tehsil(22,"Shalamar")
        tehsilListLahore.add(shalamar)

        val Wahga = Tehsil(23,"Wahga")
        tehsilListLahore.add(Wahga)

        val AzizBhatti = Tehsil(24,"Aziz Bhatti")
        tehsilListLahore.add(AzizBhatti)

        val DataGunjBuksh = Tehsil(25,"Data Gunj Buksh")
        tehsilListLahore.add(DataGunjBuksh)

        val Gulberg = Tehsil(26,"Gulberg")
        tehsilListLahore.add(Gulberg)


        val Samanabad = Tehsil(27,"Samanabad")
        tehsilListLahore.add(Samanabad)

        val Iqbal = Tehsil(28,"Iqbal")
        tehsilListLahore.add(Iqbal)

        val Nishtar = Tehsil(29,"Nishtar")
        tehsilListLahore.add(Nishtar)


        val lahore = District(2,"Lahore", tehsilListLahore)
        districtListPunjab.add(d0)
        districtListPunjab.add(lahore)

        val punjab = Province(2,"Punjab", districtListPunjab)
        provinceList.add(punjab)


        provinceList.add(Province(3,"Khyber Pakhtunkhwa", ArrayList()))
        provinceList.add(Province(4,"Baluchistan", ArrayList()))














    }
}

data class Province(val code : Int,
                    val name: String,
                    val district : ArrayList<District>)

data class District(val code : Int,
                    val name: String,
                    val tehsil: ArrayList<Tehsil>)

data class Tehsil(val code : Int,
                  val name: String)



