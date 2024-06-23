import { serviceInstance } from './service.js'

export const postService = {
  postHitResult(data) {
    return serviceInstance.post('/postHitResult', data)
  }
}
