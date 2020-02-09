package services.api

import `do`.StockDO
import com.google.inject.ImplementedBy
import services.impl.YahooStockService

import scala.collection.immutable

@ImplementedBy(classOf[YahooStockService])
trait StockService {
  def getStocks(stockNames: Array[String]): immutable.Map[String, StockDO]
}
