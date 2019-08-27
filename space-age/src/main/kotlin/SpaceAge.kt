import kotlin.math.round

private const val EARTH_PERIOD_SECOND = 31557600f

class SpaceAge(private val second: Long) {

    private fun Double.roundTo2nd() = round(this * 100) / 100f

    fun onEarth() = (second / EARTH_PERIOD_SECOND).toDouble().roundTo2nd()
    fun onMercury() = (second / (EARTH_PERIOD_SECOND * 0.2408467)).roundTo2nd()
    fun onVenus() = (second / (EARTH_PERIOD_SECOND * 0.61519726)).roundTo2nd()
    fun onMars() = (second / (EARTH_PERIOD_SECOND * 1.8808158)).roundTo2nd()
    fun onJupiter() = (second / (EARTH_PERIOD_SECOND * 11.862615)).roundTo2nd()
    fun onSaturn() = (second / (EARTH_PERIOD_SECOND * 29.447498)).roundTo2nd()
    fun onUranus() = (second / (EARTH_PERIOD_SECOND * 84.016846)).roundTo2nd()
    fun onNeptune() = (second / (EARTH_PERIOD_SECOND * 164.79132)).roundTo2nd()
}