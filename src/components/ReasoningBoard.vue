<script setup>
import { ref } from 'vue'
let index = 0
const reasoningArr = ref([
  { index: index++, reasoning: '5432', hit: '2', blow: '2' },
  { index: index++, reasoning: '5432', hit: '2', blow: '2' },
  { index: index++, reasoning: '5432', hit: '2', blow: '2' },
  { index: index++, reasoning: '5432', hit: '2', blow: '2' },
  { index: index++, reasoning: '5432', hit: '2', blow: '2' },
  { index: index++, reasoning: '5432', hit: '2', blow: '2' },
  { index: index++, reasoning: '5432', hit: '2', blow: '2' },
  { index: index++, reasoning: '5432', hit: '2', blow: '2' },
  { index: index++, reasoning: '5432', hit: '2', blow: '2' },
  { index: index++, reasoning: '5432', hit: '2', blow: '2' }
])
</script>

<template>
  <div class="reasoning-board">
    <table>
      <thead>
        <tr>
          <th scope="col">"あなたの推理"</th>
          <th scope="col">"H"</th>
          <th scope="col">"B"</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="reasoning in reasoningArr" :key="reasoning.index">
          <td>{{ reasoning.reasoning }}</td>
          <td>{{ reasoning.hit }}</td>
          <td>{{ reasoning.blow }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped>
.reasoning-board {
  background-color: white;
  color: black;
  width: 48%;
  margin: 0.5rem;
}
.num-card {
  display: flex;
}
.num {
  margin: 1rem;
}
</style>
