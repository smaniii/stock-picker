package `do`

class CommandDO(private val command: String, private val stockName: String) {
  def getCommand: String = {
    command
  }

  def getStockName: String = {
    stockName
  }

  override def toString = s"CommandDO($command, $stockName)"
}
