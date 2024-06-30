<script setup>
import { onMounted } from 'vue'
import { useRouter } from 'vue-router'
import { sendGuess, connect } from '@/service/websocket.js'

onMounted(() => {
  connect()
})
const router = useRouter()
const goToSinglePlay = () => {
  router.push('/GameView')
}
const goToMultiPlay = () => {
  const guess = {
    playerId: 'user1',
    guessedNumbers: [1, 2, 3, 4],
    timestamp: new Date().toISOString()
  }
  sendGuess(guess)
  router.push('/CharacterChoose')
}
</script>

<template>
  <div class="flex-container">
    <button @click="goToSinglePlay">Single Play</button>
    <button @click="goToMultiPlay">Multi Play</button>
  </div>
</template>

<style scoped>
button {
  text-align: center;
  width: 200px;
  font-size: 34px;
  color: var(--vt-c-white);
  border-radius: 12px;
  background-color: var(--vt-c-brown-medium);
  padding: 10px;
  margin: 20px;
}
.flex-container {
  flex-direction: column;
}
</style>
