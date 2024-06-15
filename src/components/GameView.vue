<script setup>
import ResultCard from '@/components/ResultCard.vue'
import ReasoningBoard from './ReasoningBoard.vue'
import InputPanel from './InputPanel.vue'
import { ref } from 'vue'

const result = ref('')

function decideInputNumbers(inputNumbers) {
  result.value = inputNumbers.join('')
}
</script>

<template>
  <div class="gameBox">
    <div id="header">
      <ResultCard :result="result"></ResultCard>
      <ResultCard></ResultCard>
    </div>
    <div id="body">
      <ReasoningBoard></ReasoningBoard>
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
