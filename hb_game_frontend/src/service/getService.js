import { serviceInstance } from './service.js'

export const getService = {
  getMovie() {
    return serviceInstance.get('/movie', {
      params: {
        title: 'Back to the Future'
      }
    })
  }
}
