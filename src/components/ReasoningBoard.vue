<script setup>
defineProps({
  resultA: {
    type: String
  },
  reasoningArr: {
    type: Array
  },
  count: {
    type: Number
  }
})
</script>

<template>
  <table class="reasoning-board">
    <thead>
      <tr class="title-box">
        <th id="board-title" class="board-text" scope="col">give it a shot!</th>
        <th id="board-title-H" class="board-text" scope="col">H</th>
        <th id="board-title-B" class="board-text" scope="col">B</th>
      </tr>
    </thead>
    <tbody>
      <tr
        v-for="reasoning in reasoningArr"
        :key="reasoning.index"
        :class="reasoning.index !== reasoningArr.length - 1 ? 'has-border' : ''"
      >
        <td
          v-if="reasoning.index <= count"
          id="reasoning-text"
          class="board-text-num"
        >
          {{ reasoning.reasoning }}
        </td>
        <td v-else></td>
        <td v-if="reasoning.index <= count" class="board-text-num">
          {{ reasoning.hit }}
        </td>
        <td v-else></td>
        <td v-if="reasoning.index <= count" class="board-text-num">
          {{ reasoning.blow }}
        </td>
        <td v-else></td>
      </tr>
    </tbody>
  </table>
</template>

<style scoped>
.reasoning-board {
  background-color: white;
  width: 48%;
  color: var(--vt-c-brown-dark);
  height: 450px;
  border-radius: 8px;
  background-color: var(--vt-c-white);
  margin: 0 10px;
  border-collapse: collapse; /* 合并边框，使表格更紧凑 */
}

.title-box {
  background-color: transparent;
}

th,
td {
  padding: 8px 15px;
  text-align: left;
}

#board-title {
  text-align: left;
}

#board-title-H {
  color: var(--vt-c-orange-decoration);
  text-align: center; /* 居中对齐 */
}

#board-title-B {
  color: var(--vt-c-green-decoration);
  text-align: center; /* 居中对齐 */
}

#reasoning-text {
  letter-spacing: 10px;
}

.board-text {
  text-align: center;
}
.board-text-num {
  font-size: 14px;
  font-weight: bold;
  text-align: center;
  color: var(--vt-c-grey-medium);
}

.num-card {
  display: flex;
}

.num {
  margin: 1rem;
}

.has-border {
  position: relative;
}

.has-border::after {
  content: '';
  position: absolute;
  width: 80%;
  left: 10%;
  bottom: -1px;
  height: 1px;
  background-color: var(--vt-c-grey-soft); /* 不明显的线条颜色 */
}
</style>
