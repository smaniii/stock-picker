# stock-picker
How to use stock picker

1. run the sbt application
    1. sbt run
2. connect to web socket 
    1. ws://localhost:9000/socket
3. input 
    1. Stock name is the ticker symbol. This is case insensitive
    2. {
        "command": {add or remove},
        "stockName": {Stock Symbol Name}
       }
    3. add
        1. {
             "command": "add",
             "stockName": "manh"
           }
    3. remove
        1. {
             "command": "remove",
             "stockName": "manh"
           }
4. output
    1. { 
         {Stock name} : {
            "stockName": {Stock name}
            "stockPrice": {Big Boolean of stock price},
            "time": {Last time traded}
            "timeZone": {Time zone of the last traded time}
         }
       }
    2. {
         "MANH": {
           "stockName": "MANH",
           "stockPrice": {
             "bigDecimal": 76.67,
             "mc": {
               "precision": 34,
               "roundingMode": "HALF_EVEN"
             },
             "computedHashCode": 1565550863
           },
           "time": 1581109201000,
           "timeZone": "America/New_York"
         },
         "AMZN": {
           "stockName": "AMZN",
           "stockPrice": {
             "bigDecimal": 2079.28,
             "mc": {
               "precision": 34,
               "roundingMode": "HALF_EVEN"
             },
             "computedHashCode": 1565550863
           },
           "time": 1581109201000,
           "timeZone": "America/New_York"
         }
       }
5. Configuration
    1. delay is the variable used to determine how often information is sent to the client in seconds

       