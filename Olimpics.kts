package hu.localip.hf1


fun main() {
    println ("ok")
}

enum class Continent {
    AFRIKA, EUROPA , ESZAKAMERIKA, DELAMERIKA, AZSIA
}

data class Country(val name: String, val continent: Continent){

}
enum class HostCountry(val country: Country, val years: List<Int>){
    Usa(
        Country("Usa", Continent.ESZAKAMERIKA),
        listOf(1904, 1932)
    ),
    Gorogorszag(
        Country("Görögország",Continent.EUROPA),
        listOf(1896, 1906, 2006)
    ),
    Franciaorszag(
    Country("Franciaorszag",Continent.EUROPA),
    listOf(1924)
    ),
    Nagybritannia(
        Country("Nagybritannia",Continent.EUROPA),
        listOf(1908)
    ),
    Nemetorszag(
        Country("Nemetorszag",Continent.EUROPA),
        listOf(1916)
    ),
    Belgium(
        Country("Belgium",Continent.EUROPA),
        listOf(1924)
    ),
    Hollandia(
        Country("Hollandia",Continent.EUROPA),
        listOf(1928)
    ),
}
//TODO Host country

val games = mapOf<Int, String>(
    1896 to "Athén",
    1900 to "Párizs",
    1904 to "St Louis",
    1906 to "Athén",
    1908 to "London",
    1912 to "Stockholm",
    1916 to "Berlin",
    1920 to "Antwerpen",
    1924 to "Párizs",
    1932 to "Los Angeles"
)

fun test1(): Int {
    var v = mutableMapOf<String, Int>()
    games.forEach {
        if (v.get(it.value)===null) v.put(it.value, 0)
        v.set(it.value,v.get(it.value)!!+1)
    }
    return v.size;
}


fun test2(): Int {
    return HostCountry.values().size
}

fun test3(): Map<Continent, Int>{
     var v = mutableMapOf<Continent, Int>()
     val ar = enumValues<HostCountry>()
      ar.forEach {
          if (v.get(it.country.continent)===null) v.put(it.country.continent, 0)
          v.set(it.country.continent,v.get(it.country.continent)!!+1)
      }
    return v.toMap();
}

fun test4(): List<Continent> {
    val ar = enumValues<HostCountry>()
    var nvl = enumValues<Continent>().toMutableList()
    ar.forEach{
        nvl.remove(it.country.continent)
    }
    return nvl.toList()
}

fun test5() : Pair<String, Int>{
    var count = 0
    var country = ""
    enumValues<HostCountry>().forEach {
        if  (it.years.count() > count) {
            count = it.years.count()
            country = it.name

        }
    }
    return Pair<String, Int>(country, count)
}

fun gameInfo(year: Int): String{
    val varos = games.get(year)
    var orszag = ""
    var kontinens = ""
    enumValues<HostCountry>().forEach {
        if (it.years.indexOf(year) >-1) {
            orszag = it.name
            kontinens = it.country.continent.toString()
        }
    }

    return "Az ${year}-es olimpiát ${varos}-ban tartották, a rendező ország ${orszag}, amely ezen a kontinensen található: ${kontinens}"
}
println(test1())
println(test2())
println(test3())
println(test4())
println(test5())
println(gameInfo(1906))

