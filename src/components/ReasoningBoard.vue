<script setup>
defineProps({
  result: {
    type: String
  },
  reasoningArr: {
    type: Array
  },
  index: {
    type: Number
  }
})
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
          <div v-if="reasoning.index <= index" class="flex-container">
            <th>{{ reasoning.reasoning }}</th>
            <th>{{ reasoning.hit }}</th>
            <th>{{ reasoning.blow }}</th>
          </div>
          <div v-else>
            <th></th>
            <th></th>
            <th></th>
          </div>
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
