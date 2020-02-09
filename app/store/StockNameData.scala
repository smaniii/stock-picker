package store

import `do`.CommandDO

import scala.collection.mutable

class StockNameData(private val stockNames: mutable.Set[String] = new mutable.HashSet[String]()) {


  def followCommand(commandDO: CommandDO): Unit = {
    def command = commandDO.getCommand

    def stockName = commandDO.getStockName.toUpperCase

    if (Command.add.toString.equals(command)) {
      println("Add stock : " + stockName)
      addStockName(stockName)
    }
    else if (Command.remove.toString.equals(command)) {
      println("Remove stock : " + stockName)
      removeStockName(stockName)
    }
    else {
      println("Invalid stock command : " + command + " valid stock commands are " + Command.add.toString + " and " + Command.remove)
    }
    println("Current state of the stock names : " + stockNames)
  }

  private def addStockName(stockName: String): Unit = {
    stockNames += stockName
  }

  private def removeStockName(stockName: String): Unit = {
    stockNames -= stockName
  }

  def getNames: Array[String] = {
    stockNames.toArray
  }

  override def toString = s"StockNameData($stockNames)"
}
