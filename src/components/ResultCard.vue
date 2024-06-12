<script setup>
defineProps({
  msg: {
    type: String,
    required: true
  }
})
</script>

<template>
  <div class="result-card">
    <div>
      <p class="name">"JiangCheng"</p>
      <p class="score">1500</p>
      <div class="num-card">
        <h1 class="num">1</h1>
        <h1 class="num">2</h1>
        <h1 class="num">3</h1>
        <h1 class="num">4</h1>
      </div>
    </div>
  </div>
</template>

<style scoped>
.result-card {
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
