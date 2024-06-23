import { serviceInstance } from './service.js'

export default {
  postHitResult(json) {
    return serviceInstance.post('/postHitResult' + json)
  }
}
