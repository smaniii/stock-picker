package `do`

class StockDO(private val stockName: String, private val stockPrice: BigDecimal, private val time: Long, private val timeZone: String) {
  def getStockName: String = {
    stockName
  }

  def getStockPrice: BigDecimal = {
    stockPrice.bigDecimal
  }

  def getTime: Long = {
    time
  }

  def getTimeZone: String = {
    timeZone
  }

  override def toString = s"StockDO($stockName, $stockPrice, $time, $timeZone)"
}
