enum class Signal {
  WINK, DOUBLE_BLINK, CLOSE_YOUR_EYES, JUMP
}

object HandshakeCalculator {
  fun calculateHandshake(num: Int): List<Signal> {
    val handshake = arrayListOf<Signal>()
    for (digit in 0..4) {
      if ((num shr digit) and 0b00000001 == 0) continue
      when (digit) {
        0 -> handshake.add(Signal.WINK)
        1 -> handshake.add(Signal.DOUBLE_BLINK)
        2 -> handshake.add(Signal.CLOSE_YOUR_EYES)
        3 -> handshake.add(Signal.JUMP)
        4 -> handshake.reverse()
      }
    }
    return handshake
  }
}


