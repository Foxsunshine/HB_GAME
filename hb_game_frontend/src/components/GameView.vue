<script setup>
import ResultCardA from '@/components/ResultCard.vue'
import ResultCardB from '@/components/ResultCard.vue'
import ReasoningBoardA from './ReasoningBoard.vue'
import ReasoningBoardB from './ReasoningBoard.vue'
import InputPanel from './InputPanel.vue'
import { postService } from '@/service/postService.js'
import { ref, reactive, onMounted } from 'vue'

const resultA = ref('👻👻👻👻')
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
    const digit = Math.floor(Math.random() * 10)
    if (!digits.includes(digit)) {
      digits.push(digit)
    }
  }
  return digits.join('')
}

async function decideInputNumbers(inputNumbers) {
  console.log(resultB.value)
  if (resultB.value === '') {
    resultB.value = inputNumbers.join('')
    const data = {
      createdBy: 'user1',
      hitResultNum: inputNumbers.join('')
    }
    postService
      .postHitResult(data)
      .then((response) => console.log(response.data))
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
    <div id="body" class="flex-container">
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
#footer {
  display: flex;
}
#title {
  color: var(--vt-c-brown-medium);
  font-size: 25px;
  font-weight: bold;
}
#nav {
  margin: 10px;
}
</style>
