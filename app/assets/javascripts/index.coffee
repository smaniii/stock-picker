$ ->
  ws = new WebSocket $("body").data("ws-url")
  ws.onmessage = (event) ->
    messages = JSON.parse event.data
    console.log(messages)
    chart(messages)

  $("#addsymbolform").submit (event) ->
    event.preventDefault()
    # send the message to watch the stock
    ws.send(JSON.stringify({stockName: $("#addsymboltext").val(),command: "add"}))
    # reset the form
    $("#addsymboltext").val("")

  $("#removesymbolform").submit (event) ->
      event.preventDefault()
      # send the message to watch the stock
      ws.send(JSON.stringify({stockName: $("#removesymboltext").val(),command: "remove"}))
      # reset the form
      $("#removesymboltext").val("")

  chart = (messages) ->
    ctx = document.getElementById('myChart');
    myLineChart = new Chart(ctx, {
        type: 'line',
        labels: [1500,1600,1700,1750,1800,1850,1900,1950,1999,2050],
        data: [
          datasets: [{
                data: [86,114,106,106,107,111,133,221,783,2478],
                label: "Africa",
                borderColor: "#3e95cd",
                fill: true
          }]
        ]
    })

