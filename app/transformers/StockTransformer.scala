package transformers

import java.util

import `do`.StockDO
import yahoofinance.Stock

import scala.collection.{immutable, mutable}

object StockTransformer {

  def convertToStockDOMap(originalStockMap: util.Map[String, Stock]): immutable.Map[String, StockDO] = {
    val mapConvertedMap = new mutable.HashMap[String, StockDO]()
    originalStockMap.keySet().forEach(key => {
      def stock = originalStockMap.get(key);
      def stockDO = new StockDO(key, stock.getQuote.getPrice, stock.getQuote.getLastTradeTime.getTimeInMillis, stock.getQuote.getTimeZone.getID)

      mapConvertedMap.put(key, stockDO)
    })
    println("Converted Map : " + mapConvertedMap)
    mapConvertedMap.toMap
  }
}
