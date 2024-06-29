<script setup>
import { useRouter } from 'vue-router'
import { useUserStore } from '@/stores/counter.js'
const router = useRouter()
const updateUser = (name) => {
  useUserStore.updateUser(name)
  router.push('/GameView')
}
</script>

<template>
  <div class="flex-container">
    <button @click="updateUser(1)">User 1</button>
    <button @click="updateUser(2)">User 2</button>
    <button @click="updateUser(3)">User 3</button>
    <button @click="updateUser(4)">User 4</button>
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
