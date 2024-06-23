import axios from 'axios'

const serviceInstance = axios.create({
  baseURL: 'http://localhost:8080/', // 你的API的基础URL
  timeout: 10000, // 请求超时设置
  headers: {
    'Content-Type': 'application/json'
  },
  withCredentials: true // 如果需要发送凭证信息，如Cookies
})

// 请求拦截器
serviceInstance.interceptors.request.use(
  (config) => {
    // 这里可以添加token等自定义请求头
    const token = localStorage.getItem('token')
    if (token) {
      config.headers.Authorization = `Bearer ${token}`
    }
    return config
  },
  (error) => {
    return Promise.reject(error)
  }
)

// 响应拦截器
serviceInstance.interceptors.response.use(
  (response) => {
    return response
  },
  (error) => {
    // 这里可以处理响应错误
    if (error.response.status === 401) {
      // 处理401未授权错误
      // 例如，重定向到登录页面
    }
    return Promise.reject(error)
  }
)

export { serviceInstance }
