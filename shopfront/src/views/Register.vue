<template>
    <div class="register-wrapper">
        <el-form
            :rules="rules"
            ref="registerForm"
            :model="registerForm"
            class="registerContainer">
            <h3 class="registerTitle">账号注册</h3>

            <el-form-item prop="username" label="用户名">
                <el-input size="normal" type="text" v-model="registerForm.username" auto-complete="off" aria-placeholder="请输入用户名" />
            </el-form-item>

            <el-form-item prop="password" label="密码">
                <el-input size="normal" type="password" v-model="registerForm.password" auto-complete="off" aria-placeholder="请输入密码" />
            </el-form-item>

            <el-form-item prop="password" label="二次确认密码">
                <el-input size="normal" type="password" v-model="registerForm.password1" auto-complete="off" aria-placeholder="请再次输入密码" />
            </el-form-item>

            <el-form-item prop="qq" label="qq">
                <el-input size="normal" type="text" v-model="registerForm.qq" auto-complete="off" aria-placeholder="请输入qq" />
            </el-form-item>

            <el-form-item prop="email" label="email">
                <el-input size="normal" type="text" v-model="registerForm.email" auto-complete="off" aria-placeholder="请输入邮箱" />
            </el-form-item>

            <el-form-item prop="tel" label="tel">
                <el-input size="normal" type="text" v-model="registerForm.tel" auto-complete="off" aria-placeholder="请输入电话" />
            </el-form-item>

            <el-button size="normal" type="primary" style="width: 100%;" @click="submitRegister">注册</el-button>

            <el-link class="loginRegister" type="primary" @click="toLogin">前往登陆</el-link>

        </el-form>
    </div>
</template>

<script>
    import { register } from "@/api/user";
    export default {
        data() {
            return{
                registerForm: {
                    username: "",
                    password: "",
                    password1: "",
                    email: "",
                    qq: "",
                    tel: ""
                },
                rules: {
                    username: [{required: true, message: '2-10个字符', trigger: 'blur'}],
                    password: [{required: true, message: '6-16位密码', trigger: 'blur'}],
                    email: [{required: true, message: '请输入邮箱', trigger: 'blur'}],
                    qq: [{required: true, message: '请输入qq', trigger: 'blur'}],
                    tel: [{required: true, message: '请输入电话号码', trigger: 'blur'}]
                }
            }
        },
        methods: {
            submitRegister() {
                this.$refs.registerForm.validate((valid) => {
                    if(valid){
                        register(this.registerForm.username, this.registerForm.password, this.registerForm.email, this.registerForm.qq, this.registerForm.tel).then(res => {
                            console.log("注册成功");
                            console.log(res)
                            this.$router.push({
                                path: "/login"
                            })
                        })
                    }else{
                        this.$message.error("请输入所有字段");
                        return false;
                    }
                })
            },
            toLogin() {
                this.$router.push({
                    path: "/login"
                });
            }
        }
    }
</script>

<style>
    .registerContainer {
        border-radius: 15px;
        background-clip: padding-box;
        margin: 180px auto;
        width: 350px;
        padding: 15px 35px 15px 35px;
        background: #fff;
        border: 1px solid #eaeaea;
        box-shadow: 0 0 25px #cac6c6;
    }

    .registerTitle {
        margin: 15px auto 20px auto;
        text-align: center;
        color: #505458;
    }

    .loginRegister {
        margin: 15px auto 20px auto;
    }
</style>