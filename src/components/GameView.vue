<script setup>
import ResultCardA from '@/components/ResultCard.vue'
import ResultCardB from '@/components/ResultCard.vue'
import ReasoningBoardA from './ReasoningBoard.vue'
import ReasoningBoardB from './ReasoningBoard.vue'
import InputPanel from './InputPanel.vue'
import { ref, reactive, onMounted } from 'vue'

const resultA = ref('1234')
const resultB = ref('')
let count = ref(-1)
const reasoningArr = reactive([
  { index: 0, reasoning: 'watting', hit: 0, blow: 0 },
  { index: 1, reasoning: 'watting', hit: 0, blow: 0 },
  { index: 2, reasoning: 'watting', hit: 0, blow: 0 },
  { index: 3, reasoning: 'watting', hit: 0, blow: 0 },
  { index: 4, reasoning: 'watting', hit: 0, blow: 0 },
  { index: 5, reasoning: 'watting', hit: 0, blow: 0 },
  { index: 6, reasoning: 'watting', hit: 0, blow: 0 },
  { index: 7, reasoning: 'watting', hit: 0, blow: 0 },
  { index: 8, reasoning: 'watting', hit: 0, blow: 0 }
])

onMounted(() => {
  resultB.value = generateUniqueFourDigitString()
})

function generateUniqueFourDigitString() {
  let digits = []
  while (digits.length < 4) {
    const digit = Math.floor(Math.random() * 10) // 生成 0 到 9 之间的随机整数
    if (!digits.includes(digit)) {
      digits.push(digit)
    }
  }
  return digits.join('') // 将数组转换为字符串
}

async function decideInputNumbers(inputNumbers) {
  console.log(resultB.value)
  if (resultB.value === '') {
    resultB.value = inputNumbers.join('')
  } else {
    count.value++
    inputNumbers.forEach((element, index) => {
      if (element === Number(resultB.value[index])) {
        reasoningArr[count.value].hit++
      }
    })
    inputNumbers.forEach((element) => {
      if (resultB.value.indexOf(element) !== -1)
        reasoningArr[count.value].blow++
    })
    reasoningArr[count.value].blow -= reasoningArr[count.value].hit
    reasoningArr[count.value].reasoning = inputNumbers.join('')
  }
}
</script>

<template>
  <div class="gameBox">
    <div id="nav" class="container">
      <h1 id="title">YOUR TURN</h1>
    </div>
    <div id="header" class="flex-container">
      <ResultCardA :result="resultA"></ResultCardA>
      <ResultCardB></ResultCardB>
    </div>
    <div id="body">
      <ReasoningBoardA
        :resultB="resultB"
        :count="count"
        :reasoningArr="reasoningArr"
      ></ReasoningBoardA>
      <ReasoningBoardB></ReasoningBoardB>
    </div>
    <div id="footer">
      <InputPanel @decideInputNumbers="decideInputNumbers"></InputPanel>
    </div>
  </div>
</template>

<style scoped>
/* #header,
#body,
#footer {
  display: flex;
} */
#title {
  color: var(--vt-c-brown-medium);
  font-size: 25px;
  font-weight: bold;
}
/* h1 {
  font-weight: 500;
  font-size: 2.6rem;
  position: relative;
  top: -10px;
}

h3 {
  font-size: 1.2rem;
} */

/* .gameBox h1,
.gameBox h3 {
  text-align: center;
} */

/* @media (min-width: 1024px) {
  .gameBox h1,
  .gameBox h3 {
    text-align: left;
  }
} */
</style>
