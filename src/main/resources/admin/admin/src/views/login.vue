<template>
	<div>
		<div class="login-container">
			<el-form class="login_form animate__animated animate__backInDown">
				<div class="login_form2">
					<div class="title-container">基于Web的在线招聘平台设计与实现</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							账号：
						</div>
						<input placeholder="请输入账号：" name="username" type="text" v-model="rulesForm.username">
					</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							密码：
						</div>
						<div class="password-box">
							<input placeholder="请输入密码：" name="password" :type="showPassword?'text':'password'" v-model="rulesForm.password">
							<span class="icon iconfont" :class="showPassword?'icon-liulan13':'icon-liulan17'" @click="showPassword=!showPassword"></span>
						</div>
					</div>

					<div class="list-item select" v-if="roles.length>1">
						<div class="lable">
							角色：
						</div>
						<el-select v-model="rulesForm.role" placeholder="请选择角色：">
							<el-option v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" :key="item.roleName" :label="item.roleName" :value="item.roleName" />
						</el-select>
					</div>

		
					<div class="login-btn">
						<div class="login-btn1">
							<el-button v-if="loginType==1" type="primary" @click="login()" class="loginInBt">登录</el-button>
						</div>
						<div class="login-btn2">
							<el-button type="primary" @click="register('qiyeyonghu')" class="register">
								注册企业用户							</el-button>
						</div>
						<div class="login-btn3">
						</div>
					</div>
				</div>
			</el-form>
		</div>
	</div>
</template>
<script>
	import 'animate.css'
	import menu from "@/utils/menu";
	export default {
		data() {
			return {
				verifyCheck2: false,
				flag: false,
				baseUrl:this.$base.url,
				loginType: 1,
				rulesForm: {
					username: "",
					password: "",
					role: "",
				},
				menus: [],
				roles: [],
				tableName: "",
				showPassword: false,
			};
		},
		mounted() {
			let menus = menu.list();
			this.menus = menus;

			for (let i = 0; i < this.menus.length; i++) {
				if (this.menus[i].hasBackLogin=='是') {
					this.roles.push(this.menus[i])
				}
			}

		},
		created() {

		},
		destroyed() {
		},
		components: {
		},
		methods: {

			//注册
			register(tableName){
				this.$storage.set("loginTable", tableName);
				this.$router.push({path:'/register',query:{pageFlag:'register'}})
			},
			// 登陆
			login() {

				if (!this.rulesForm.username) {
					this.$message.error("请输入用户名");
					return;
				}
				if (!this.rulesForm.password) {
					this.$message.error("请输入密码");
					return;
				}
				if(this.roles.length>1) {
					if (!this.rulesForm.role) {
						this.$message.error("请选择角色");
						return;
					}

					let menus = this.menus;
					for (let i = 0; i < menus.length; i++) {
						if (menus[i].roleName == this.rulesForm.role) {
							this.tableName = menus[i].tableName;
						}
					}
				} else {
					this.tableName = this.roles[0].tableName;
					this.rulesForm.role = this.roles[0].roleName;
				}
		
				this.loginPost()
			},
			loginPost() {
				this.$http({
					url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
					method: "post"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.$storage.set("Token", data.token);
						this.$storage.set("role", this.rulesForm.role);
						this.$storage.set("sessionTable", this.tableName);
						this.$storage.set("adminName", this.rulesForm.username);
						this.$nextTick(()=>{
							this.$http({
								url: this.tableName + '/session',
								method: "get"
							}).then(({
								data
							}) => {
								if (data && data.code === 0) {
									if(this.tableName == 'qiuzhizhe') {
										this.$storage.set('headportrait',data.data.touxiang)
									}
									if(this.tableName == 'qiyeyonghu') {
										this.$storage.set('headportrait',data.data.touxiang)
									}
									if(this.tableName == 'users') {
										this.$storage.set('headportrait',data.data.image)
									}
									this.$storage.set('userForm',JSON.stringify(data.data))
									this.$storage.set('userid',data.data.id);
								} else {
									let message = this.$message
									message.error(data.msg);
								}
								this.$router.replace({ path: "/" });
							});
						})
					} else {
						this.$message.error(data.msg);
					}
				});
			},
		}
	}
</script>

<style lang="scss" scoped>
.login-container {
	min-height: 100vh;
	position: relative;
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	background: url(http://codegen.caihongy.cn/20250214/671fc212caf64a4ea1500127de390bed.jpg) no-repeat center top / cover;
	background: url(http://codegen.caihongy.cn/20250214/671fc212caf64a4ea1500127de390bed.jpg) no-repeat center top / cover;
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;
	align-items: center;

	.login_form {
		padding: 0;
		margin: 0;
		z-index: 1000;
		display: flex;
		border-radius: 30px;
		box-shadow: 0px 4px 30px 0px rgba(255,255,255,0.3);
		flex-direction: column;
		overflow: hidden;
		background: rgba(255,255,255,0.5);
		width: 1193px;
		align-items: flex-end;
		position: relative;
		height: 720px;
		.login_form2 {
			background-color: #fff;
			padding: 0 100px;
			width: 714px;
			height: 100%;
		}
		.title-container {
			padding: 0;
			margin: 100px 0 40px 0;
			color: #333333;
			background: none;
			font-weight: 600;
			width: 100%;
			font-size: 24px;
			line-height: 40px;
			text-align: center;
		}
		.list-item {
			border: none;
			border-radius: 5px;
			padding: 0;
			box-shadow: inset 0px -2px 6px 0px rgba(10,37,64,0.35), 0px 30px 60px -30px rgba(0,0,0,0.3), 0px 50px 100px -20px rgba(50,50,93,0.25);
			margin: 0 0 40px 0;
			background: #F5F6F6;
			display: flex;
			width: 100%;
			align-items: center;
			position: relative;
			flex-wrap: wrap;
			.lable {
				color: #333333;
				flex: 0 0 auto;
				width: 80px;
				font-size: 14px;
				line-height: 50px;
				text-align: center;
			}
			input {
				border: 0px solid #efeff7;
				border-radius: 4px;
				padding: 0 10px;
				color: #333333;
				flex: 1 1 auto;
				background: transparent;
				width: auto;
				font-size: 14px;
				height: 50px;
			}
			input:focus {
				border: 0px solid #efeff7;
				border-radius: 4px;
				padding: 0 10px;
				color: #333333;
				flex: 1 1 auto;
				background: transparent;
				width: auto;
				font-size: 14px;
				height: 50px;
			}
			.password-box {
				border: 0px solid #efeff7;
				border-radius: 4px;
				padding: 0 10px;
				color: #333333;
				flex: 1 1 auto;
				width: auto;
				font-size: 14px;
				height: 40px;
				input {
					border: 0px solid #efeff7;
					border-radius: 0;
					padding: 0 10px;
					color: #333333;
					flex: 1 1 auto;
					background: transparent;
					width: auto;
					font-size: 14px;
					height: 40px;
				}
				input:focus {
					border: 0px solid #efeff7;
					border-radius: 0;
					padding: 0 10px;
					color: #333333;
					flex: 1 1 auto;
					background: transparent;
					width: auto;
					font-size: 14px;
					height: 40px;
				}
				.iconfont {
					cursor: pointer;
					z-index: 1;
					color: #000;
					top: 0;
					font-size: 16px;
					line-height: 44px;
					position: absolute;
					right: 5px;
				}
			}
			input::placeholder {
				color: #999;
				font-size: 14px;
			}
			/deep/ .el-select {
				flex: 1 1 auto;
				width: auto;
			}
			/deep/ .el-select .el-input__inner {
				border: 0px solid rgba(64, 158, 255, 1);
				padding: 0 10px;
				color: #333333;
				background: transparent;
				width: 100%;
				font-size: 14px;
				height: 50px;
			}
			/deep/ .el-select .is-focus .el-input__inner {
				border: 0px solid rgba(64, 158, 255, 1);
				padding: 0 10px;
				color: #333333;
				background: transparent;
				width: 100%;
				font-size: 14px;
				height: 50px;
			}
			/deep/ .el-select .el-input__inner::placeholder{
				color: #999;
				font-size: 14px;
			}
		}
		.login-btn {
			margin: 20px auto;
			display: flex;
			width: 100%;
			justify-content: center;
			align-items: center;
			flex-wrap: wrap;
			.login-btn1 {
				width: 100%;
			}
			.login-btn2 {
				top: 360px;
				left: 0;
				display: flex;
				gap: 30px;
				width: 480px;
				justify-content: center;
				align-items: center;
				position: absolute;
				flex-wrap: wrap;
			}
			.login-btn3 {
				width: 100%;
				order: -1;
			}
			.loginInBt {
				border: 0px solid rgba(0, 0, 0, 1);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 10px;
				margin: 0 0 10px;
				color: #fff;
				background: #A869FB;
				font-weight: 600;
				width: 100%;
				font-size: 28px;
				min-width: 68px;
				height: 44px;
			}
			.loginInBt:hover {
				opacity: 0.8;
			}
			.register {
				border: 0px solid rgba(0, 0, 0, 1);
				cursor: pointer;
				border-radius: 5px;
				padding: 0 20px;
				box-shadow: inset 0px -2px 6px 0px rgba(10,37,64,0.35), 0px 30px 60px -30px rgba(0,0,0,0.3), 0px 50px 100px -20px rgba(50,50,93,0.25);
				margin: 0 0 10px;
				color: #000;
				background: #fff;
				width: auto;
				font-size: 18px;
				height: 44px;
			}
			.register:hover {
				opacity: 0.8;
			}
			.forget {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0;
				margin: 0 10px 10px 0;
				color: #000;
				background: none;
				width: 100%;
				font-size: 15px;
				text-align: center;
				height: 34px;
			}
			.forget:hover {
				color: #0d6efd;
				opacity: 1;
			}
		}
	}
}

</style>
