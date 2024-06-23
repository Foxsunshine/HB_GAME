<script setup>
import { useRouter } from 'vue-router'
const router = useRouter()
const goToSinglePlay = () => {
  router.push('/GameView')
}
</script>

<template>
  <div class="flex-container">
    <button @click="goToSinglePlay">Single Play</button>
    <button>Double Play</button>
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
