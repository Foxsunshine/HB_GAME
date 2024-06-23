import { createRouter, createWebHistory } from 'vue-router'
import GameStart from '../views/GameStart.vue'
import GameView from '../components/GameView.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/GameStart',
      name: 'GameStart',
      component: GameStart
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/GameView',
      name: 'GameView',
      component: GameView
    }
  ]
})

export default router
