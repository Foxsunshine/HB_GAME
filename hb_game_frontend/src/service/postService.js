import { serviceInstance } from './service.js'

export const postService = {
  // login(username, password) {
  //   return serviceInstance.post('/api/login', {
  //     username: username,
  //     password: password
  //   })
  // },ß
  postHitResult(data) {
    return serviceInstance.post('/postHitResult', data)
  }
}
