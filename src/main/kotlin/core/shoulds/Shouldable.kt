interface Shouldable {
  fun check(): Boolean
}

abstract class Should constructor(val boolAction: Unit -> Boolean) : Shouldable {
  override fun check(): Boolean {
    return this.boolAction();
  }
}