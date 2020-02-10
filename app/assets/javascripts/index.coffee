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

    new Chart(document.getElementById("line-chart"), {
      type: 'line',
      data: {
        labels: [],
        datasets: [{
            data: [{x: 1500, y: 86}, {x: 1600, y: 115}, {x: 1700, y: 225}, {x: 1830, y: 114}, {x: 1900, y: 90}, {x: 2001, y: 90}],
            label: "test",
            borderColor: "#3e95cd",
            fill: false
          }
        ]
      },
      options: {
        maintainAspectRatio: false
      }
    })
