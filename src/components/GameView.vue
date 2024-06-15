<script setup>
import ResultCard from '@/components/ResultCard.vue'
import ReasoningBoard from './ReasoningBoard.vue'
import InputPanel from './InputPanel.vue'
import { ref, reactive, nextTick } from 'vue'

const result = ref('')
let index = ref(-1)
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
async function decideInputNumbers(inputNumbers) {
  if (result.value === '') {
    result.value = inputNumbers.join('')
  } else {
    index.value++
    reasoningArr[index.value].reasoning = inputNumbers.join('')
    await nextTick()
  }
}
</script>

<template>
  <div class="gameBox">
    <div id="header">
      <ResultCard :result="result"></ResultCard>
      <ResultCard></ResultCard>
    </div>
    <div id="body">
      <ReasoningBoard
        :result="result"
        :index="index"
        :reasoningArr="reasoningArr"
      ></ReasoningBoard>
      <ReasoningBoard></ReasoningBoard>
    </div>
    <div id="footer">
      <InputPanel @decideInputNumbers="decideInputNumbers"></InputPanel>
    </div>
  </div>
</template>

<style scoped>
#header,
#body,
#footer {
  display: flex;
}
h1 {
  font-weight: 500;
  font-size: 2.6rem;
  position: relative;
  top: -10px;
}

h3 {
  font-size: 1.2rem;
}

.gameBox h1,
.gameBox h3 {
  text-align: center;
}

@media (min-width: 1024px) {
  .gameBox h1,
  .gameBox h3 {
    text-align: left;
  }
}
</style>
