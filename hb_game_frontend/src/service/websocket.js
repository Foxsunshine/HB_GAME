import { Stomp } from '@stomp/stompjs'
import SockJS from 'sockjs-client'

let stompClient = null
let isConnected = false

function connect() {
  const socket = new SockJS('http://localhost:8081/game-websocket')
  stompClient = Stomp.over(socket)

  stompClient.connect({}, (frame) => {
    console.log('Connected: ' + frame)
    isConnected = true

    stompClient.subscribe('/topic/guesses', (message) => {
      const guessResponse = JSON.parse(message.body)
      // 处理收到的猜测信息
      console.log('Received guess:', guessResponse)
    })
  })
}

function sendGuess(guess) {
  if (isConnected && stompClient) {
    stompClient.send('/app/guess', {}, JSON.stringify(guess))
  } else {
    console.error('STOMP connection is not established.')
  }
}

export { connect, sendGuess }
