import axios from 'axios'
import {Message} from "element-ui"

// import qs from 'qs'

// var showLoginMessageBox = false
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.headers['Access-Control-Allow-Origin'] = '*';

const service = axios.create({
    baseURL: "http://localhost:8080",
    timeout: 10000
})

service.interceptors.response.use(
    response => {
        const res = response.data
        if(res.status === 0){
            return res
        }else if(res.status !== 0){
            if (res.msg) {
                Message({
                    message: res.msg,
                    type: 'error'
                })
            }
            return Promise.reject(res)
        }else {
            return res
        }
    },
    error => {
        Message({
            message: '网络请求失败，请稍后再试',
            type: 'error'
        })
        return Promise.reject(error)
    }
)

export default service