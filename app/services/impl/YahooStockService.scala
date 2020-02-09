package services.impl

import `do`.StockDO
import com.google.inject.Inject
import javax.inject.Singleton
import services.api.StockService
import transformers.StockTransformer
import yahoofinance.YahooFinance

import scala.collection.immutable

@Singleton
class YahooStockService @Inject()() extends StockService {

  def getStocks(stockNames: Array[String]): immutable.Map[String, StockDO] = {
    if (stockNames.isEmpty) return new immutable.HashMap[String, StockDO]()
    val yahooStockMap = YahooFinance.get(stockNames)
    println("Stocks information : " + yahooStockMap)
    StockTransformer.convertToStockDOMap(yahooStockMap)
  }
}
