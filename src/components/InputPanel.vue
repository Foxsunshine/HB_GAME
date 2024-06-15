<script setup>
import { ref } from 'vue'
const time = 90
const isSelectedDone = ref(false)
const inputNumbers = ref([-1, -1, -1, -1])
const Numbers = ref(['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'])
const emit = defineEmits(['decideInputNumbers'])

function changeInputNumbers(num) {
  if (!this.isSelectedDone) {
    let index = inputNumbers.value.indexOf(-1)
    inputNumbers.value[index] = num
    if (index === 3) isSelectedDone.value = true
  }
}
function deleteInputNumbers() {
  isSelectedDone.value = false
  let index = inputNumbers.value.indexOf(-1)
  if (index === -1) inputNumbers.value[3] = -1
  else inputNumbers.value[index - 1] = -1
}
function decideInputNumbers() {
  emit('decideInputNumbers', inputNumbers.value)
}
function isNumPicked(num) {
  return inputNumbers.value.indexOf(num) !== -1
}
</script>

<template>
  <div class="input-panel">
    <div class="time">{{ time }}</div>
    <div class="input-num">
      <p>"あなたの数字を決めてください"</p>
      <ul class="flex-container">
        <li v-for="num in inputNumbers" :key="num">
          <p v-if="num !== -1">{{ num }}</p>
          <p v-else>?</p>
        </li>
      </ul>
    </div>
    <div class="select-num flex-box">
      <button
        v-for="num in Numbers"
        :disabled="isNumPicked(num)"
        :key="num"
        class="m-1"
        @click="changeInputNumbers(num)"
      >
        {{ num }}
      </button>
    </div>
    <button :disabled="!isSelectedDone" @click="decideInputNumbers">
      決定
    </button>
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
