import { createRouter, createWebHistory } from 'vue-router'
import GameStart from '../views/GameStart.vue'
import CharacterChoose from '../views/CharacterChoose.vue'
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
      path: '/GameView',
      name: 'GameView',
      component: GameView
    },
    {
      path: '/CharacterChoose',
      name: 'CharacterChoose',
      component: CharacterChoose
    }
  ]
})

export default router
