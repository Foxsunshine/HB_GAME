<!-- <script setup>
import { ref } from 'vue'
import { postService } from '@/service/postService.js'

const username = ref('')
const password = ref('')

async function login() {
  postService
    .login(username.value, password.value)
    .then((response) => localStorage.setItem('token', response.data.token))
    .catch((error) => alert('登录失败：' + error.response.data.message))
}
</script>

<template>
  <div>
    <form @submit.prevent="login">
      <input v-model="username" placeholder="用户名" />
      <input v-model="password" type="password" placeholder="密码" />
      <button type="submit">登录</button>
    </form>
  </div>
</template> -->
