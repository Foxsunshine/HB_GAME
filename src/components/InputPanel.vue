<script setup>
import { ref } from 'vue'
const time = 90
// const inputNums = ref(['0', '0', '2', '3'])
const selectedNum = ref('----')
const isNumDecided = ref(false)
const isDecideButtonShow = ref(false)
const nums = ref(['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'])

function changeSelectedNum(num) {
  let index = selectedNum.value.indexOf('-')
  console.log(index)
  if (index !== -1) selectedNum.value = selectedNum.value.replace('-', num)
  if (index === 3) isDecideButtonShow.value = true
  console.log(selectedNum.value)
}
function decideSelectedNum() {
  isNumDecided.value = true
}
</script>

<template>
  <div class="input-panel">
    <div class="time">{{ time }}</div>
    <div class="intput-num">
      <p>"あなたの数字を決めてください"</p>
      <h1 v-if="isNumDecided" class="m-1">{{ selectedNum }}</h1>
      <h1 v-else class="m-1">{{ selectedNum }}</h1>
    </div>
    <div class="select-num flex-box">
      <h1 v-for="num in nums" :key="num" class="m-1" @click="changeSelectedNum(num)">{{ num }}</h1>
    </div>
    <button v-show="isDecideButtonShow" @click="decideSelectedNum">決定</button>
    <button @click="decideSelectedNum">delete</button>
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
