<script setup>
import { ref } from 'vue'
const numbers = [...Array(10).keys()]
const isSelectedDone = ref(false)
const inputNumbers = ref([-1, -1, -1, -1])
const emit = defineEmits(['decideInputNumbers'])

function changeInputNumbers(num) {
  if (!this.isSelectedDone.value) {
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
  inputNumbers.value = [-1, -1, -1, -1]
  isSelectedDone.value = false
}
function isNumPicked(num) {
  return inputNumbers.value.indexOf(num) !== -1
}
</script>

<template>
  <div class="input-panel">
    <div class="container">
      <div>
        <p id="input-num-head" class="board-text">数字を決めてください</p>
        <ul id="input-container" class="container">
          <li v-for="(num, index) in inputNumbers" :key="index">
            <p v-if="num !== -1" class="input-num">{{ num }}</p>
            <p v-else class="input-num">9</p>
          </li>
        </ul>
      </div>
      <div id="time-container">
        <p id="countdown-head" class="board-text">カウントダウン</p>
        <p id="countdown-text">00:30</p>
      </div>
    </div>
    <div class="select-num">
      <button
        v-for="num in numbers"
        :disabled="isNumPicked(num)"
        :key="num"
        class="num-button"
        @click="changeInputNumbers(num)"
      >
        {{ num }}
      </button>
    </div>
    <div class="action-buttons">
      <button
        :disabled="!isSelectedDone"
        @click="decideInputNumbers"
        class="num-button"
      >
        決定
      </button>
      <button @click="deleteInputNumbers" class="num-button">delete</button>
    </div>
  </div>
</template>
<style scoped>
.input-panel {
  width: 100%;
  height: 320px;
  margin: 10px !important;
  color: var(--vt-c-brown-dark);
  border-radius: 8px;
  background-color: var(--vt-c-white);
}
#input-num-head {
  position: relative;
  padding: 5px 0px 0px 30px; /* 给文本添加一些左边距，以便圆点不会覆盖文本 */
}
#countdown-head {
  position: relative;
  padding: 5px 10px 0px 30px;
}
#countdown-head::before {
  content: '';
  display: inline-block;
  width: 10px;
  height: 10px;
  border-radius: 50%;
  background-color: var(--vt-c-orange-decoration);
  position: absolute;
  left: 15px; /* 圆点的位置 */
  top: 8px;
}
#input-num-head::before {
  content: '';
  display: inline-block;
  width: 10px;
  height: 10px;
  border-radius: 50%;
  background-color: var(--vt-c-green-decoration);
  position: absolute;
  left: 15px; /* 圆点的位置 */
  top: 8px;
}
#input-container {
  margin: 10px 20px;
  border-radius: 8px;
  padding: 5px 10px;
  width: 220px;
  height: 80px;
  text-align: center;
  background-color: var(--vt-c-brown-medium);
  box-shadow: 0 0 0 8px var(--vt-c-grey-soft);
}
#countdown-text {
  font-size: 35px;
}
#time-container {
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
}
#countdown-text {
  text-align: right;
  font-weight: bold;
  margin-right: 10px;
}
.select-num {
  display: grid;
  grid-template-columns: repeat(5, 1fr);
  gap: 10px;
  margin: 0 10px;
}
.action-buttons {
  display: flex;
  justify-content: space-between;
  margin: 10px;
}
.num-button {
  font-size: 18px;
  font-weight: bold;
  text-align: center;
  width: 70px;
  height: 54px;
  color: var(--vt-c-brown-dark);
  border-radius: 8px;
  background-color: var(--vt-c-brown-soft);
}
.num-button:disabled {
  color: var(--vt-c-grey-medium);
  background-color: var(--vt-c-grey-soft); /* 禁用按钮的背景色 */
  cursor: not-allowed;
}
.input-num {
  font-size: 60px;
  font-weight: bold;
  text-align: center;
  margin: 0 5px;
  color: var(--vt-c-white);
}
.container {
  align-items: flex-start;
  justify-content: space-between;
}
</style>
