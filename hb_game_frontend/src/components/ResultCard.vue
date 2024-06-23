<script setup>
import { getService } from '@/service/getService.js'
defineProps({
  result: {
    type: String,
    required: false
  }
})

function getHitResult() {
  getService.getHitResult().then((response) => console.log(response.data))
}
</script>

<template>
  <div class="result-card">
    <div class="container">
      <p id="icon" class="flex-container">🤡</p>
      <p class="name">ジャンチェン</p>
    </div>
    <p id="num-card" class="flex-container" @click="getHitResult">
      {{ result }}
    </p>
  </div>
</template>

<style scoped>
p {
  margin: 0;
}

#icon {
  width: 30px;
  height: 30px;
  border-radius: 50%;
  text-align: center;
  background-color: var(--vt-c-white);
}
.name {
  font-size: 12px;
  font-weight: bold;
  color: var(--vt-c-brown-dark);
  padding-left: 0.5rem;
}
.result-card {
  width: 48%;
  margin-bottom: 10px;
}
#num-card {
  font-size: 18px;
  font-weight: bold;
  text-align: center;
  padding-left: 10px;
  letter-spacing: 10px;
  color: var(--vt-c-brown-dark);
  width: 130px;
  height: 40px;
  border-radius: 8px;
  background-color: var(--vt-c-white);
}
</style>
