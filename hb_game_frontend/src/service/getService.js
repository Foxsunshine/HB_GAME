import { serviceInstance } from './service.js'

export const getService = {
  getHitResult() {
    return serviceInstance.get('/getHitResult', {
      params: {
        createdBy: 'user1'
      }
    })
  }
}
