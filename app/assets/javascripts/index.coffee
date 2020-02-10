$ ->
  ws = new WebSocket $("body").data("ws-url")
  ws.onmessage = (event) ->
    messages = JSON.parse event.data
    console.log(messages)
    chart(messages)

  $("#addsymbolform").submit (event) ->
    event.preventDefault()
    # send the message to watch the stock
    stockName = $("#addsymboltext").val()
    ws.send(JSON.stringify({stockName: stockName,command: "add"}))
    # reset the form
    $("#addsymboltext").val("")

  $("#removesymbolform").submit (event) ->
      event.preventDefault()
      # send the message to watch the stock
      stockName = $("#removesymboltext").val()
      $("#" + stockName).remove()
      ws.send(JSON.stringify({stockName: stockName,command: "remove"}))
      # reset the form
      $("#removesymboltext").val("")

  chart = (messages) ->
    for own key, message of messages
      console.log(message)
      $("#" + message.stockName).remove()
      $("#div").after('<table id="' + message.stockName + '">
        <tr>
          <th>Stock Name</th>
          <th>Last Sold Stock Price</th>
          <th>Time</th>
          <th>Time Zone</th>
       </tr>
        <tr>
        <td>"' + message.stockName + '"</td>
        <td>"' + message.stockPrice.bigDecimal + '"</td>
        <td>"' + message.time + '"</td>
        <td>"' + message.timeZone + '"</td>
       </tr>
      </table>')
