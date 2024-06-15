<script setup>
import { ref } from 'vue'
const time = 90
const isNumDecided = ref(false)
const inputNumbers = ref([-1, -1, -1, -1])
const Numbers = ref(['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'])
const emit = defineEmits(['decideInputNumbers'])

function changeInputNumbers(num) {
  if (!this.isNumDecided) {
    let index = inputNumbers.value.indexOf(-1)
    inputNumbers.value[index] = num
    if (index === 3) isNumDecided.value = true
  }
}
function deleteInputNumbers() {
  isNumDecided.value = false
  let index = inputNumbers.value.indexOf(-1)
  if (index === -1) inputNumbers.value[3] = -1
  else inputNumbers.value[index - 1] = -1
}
function decideInputNumbers() {
  emit('decideInputNumbers', inputNumbers.value)
}
</script>

<template>
  <div class="input-panel">
    <div class="time">{{ time }}</div>
    <div class="input-num">
      <p>"あなたの数字を決めてください"</p>
      <ul>
        <li v-for="num in inputNumbers" :key="num">
          <p v-if="num !== -1">{{ num }}</p>
          <p v-else>?</p>
        </li>
      </ul>
    </div>
    <div class="select-num flex-box">
      <h1
        v-for="num in Numbers"
        :key="num"
        class="m-1"
        @click="changeInputNumbers(num)"
      >
        {{ num }}
      </h1>
    </div>
    <button v-show="isNumDecided" @click="decideInputNumbers">決定</button>
    <button @click="deleteInputNumbers">delete</button>
  </div>
</template>
<style scoped>
.input-panel {
  text-align: center;
  align-items: center;
  margin: auto;
}
.flex-box {
  display: flex;
}
</style>
