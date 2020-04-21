import request from "@/utils/request"

export function login(username, password) {
    let formData = new FormData()
    formData.append('username', username)
    formData.append('password', password)
    return request({
        method: 'post',
        url: '/user/login',
        data: formData
    })
}

export function register(username, password, email, qq, tel) {
    let formData = new FormData()
    formData.append('username', username)
    formData.append('password', password)
    formData.append('email', email)
    formData.append('qq', qq)
    formData.append('tel', tel)
    console.log(formData)
    return request({
        method: 'post',
        url: '/user/register',
        data: formData
    })
}