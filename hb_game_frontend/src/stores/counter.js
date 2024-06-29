// import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

// export const useCounterStore = defineStore('counter', () => {
//   const count = ref(0)
//   const doubleCount = computed(() => count.value * 2)
//   function increment() {
//     count.value++
//   }

//   return { count, doubleCount, increment }
// })

export const useUserStore = defineStore('user', {
  state: () => ({
    user: null,
    age: 30
  }),
  getters: {
    doubleAge: (state) => state.age * 2
  },
  actions: {
    updateUser(newUser) {
      this.user = newUser
    }
  }
})
