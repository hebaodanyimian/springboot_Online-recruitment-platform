<template>
	<div>

		<div class="container">
			<el-form class='rgs-form animate__animated animate__' v-if="pageFlag=='register'" ref="registerForm" :model="registerForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">基于Web的在线招聘平台设计与实现</p></div>
					<el-form-item class="list-item" v-if="tableName=='qiuzhizhe'" prop="zhanghao">
						<div class="label" :class="changeRules('zhanghao')?'required':''">账号：</div>
						<el-input v-model="registerForm.zhanghao"  placeholder="请输入账号" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiuzhizhe'" prop="mima">
						<div class="label" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiuzhizhe'" prop="mima2">
						<div class="label" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiuzhizhe'" prop="xingming">
						<div class="label" :class="changeRules('xingming')?'required':''">姓名：</div>
						<el-input v-model="registerForm.xingming"  placeholder="请输入姓名" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiuzhizhe'" prop="xingbie">
						<div class="label" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in qiuzhizhexingbieOptions"
								:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiuzhizhe'" prop="nianling">
						<div class="label" :class="changeRules('nianling')?'required':''">年龄：</div>
						<el-input v-model.number="registerForm.nianling"  placeholder="请输入年龄" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiuzhizhe'" prop="touxiang">
						<div class="label" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
							@change="qiuzhizhetouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiuzhizhe'" prop="shouji">
						<div class="label" :class="changeRules('shouji')?'required':''">手机：</div>
						<el-input v-model="registerForm.shouji"  placeholder="请输入手机" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiuzhizhe'" prop="youxiang">
						<div class="label" :class="changeRules('youxiang')?'required':''">邮箱：</div>
						<el-input v-model="registerForm.youxiang"  placeholder="请输入邮箱" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiuzhizhe'" prop="jianli">
						<div class="label" :class="changeRules('jianli')?'required':''">简历：</div>
						<file-upload
							tip="点击上传简历"
							action="file/upload"
							:limit="1"
							:type="3"
							:multiple="true"
							:fileUrls="registerForm.jianli?registerForm.jianli:''"
							@change="qiuzhizhejianliUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiyeyonghu'" prop="gonghao">
						<div class="label" :class="changeRules('gonghao')?'required':''">工号：</div>
						<el-input v-model="registerForm.gonghao"  placeholder="请输入工号" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiyeyonghu'" prop="mima">
						<div class="label" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiyeyonghu'" prop="mima2">
						<div class="label" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiyeyonghu'" prop="qiyemingcheng">
						<div class="label" :class="changeRules('qiyemingcheng')?'required':''">企业名称：</div>
						<el-input v-model="registerForm.qiyemingcheng"  placeholder="请输入企业名称" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiyeyonghu'" prop="xingbie">
						<div class="label" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in qiyeyonghuxingbieOptions"
								:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiyeyonghu'" prop="shouji">
						<div class="label" :class="changeRules('shouji')?'required':''">手机：</div>
						<el-input v-model="registerForm.shouji"  placeholder="请输入手机" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiyeyonghu'" prop="touxiang">
						<div class="label" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
							@change="qiyeyonghutouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<el-button class="register_btn" type="primary" @click="submitForm('registerForm')">注册</el-button>
						</div>
						<div class="register-btn2">
							<router-link class="has_btn" to="/login">已有账号，直接登录</router-link>
						</div>
					</div>
				</div>
				<div class="idea1"></div>
				<div class="idea2"></div>
			</el-form>
		</div>
	</div>
</div>
</template>

<script>
	import 'animate.css';

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {},
			forgetForm: {},
			rules: {},
			requiredRules: {},
            qiuzhizhexingbieOptions: [],
            qiyeyonghuxingbieOptions: [],
		}
    },
	mounted() {
		if(this.$route.query.pageFlag=='register'){
			this.tableName = this.$route.query.role;
			if(this.tableName=='qiuzhizhe'){
				this.registerForm = {
					zhanghao: '',
					mima: '',
					mima2: '',
					xingming: '',
					xingbie: '',
					nianling: '',
					touxiang: '',
					shouji: '',
					youxiang: '',
					jianli: '',
					sfsh: '',
					shhf: '',
				}
			}
			if(this.tableName=='qiyeyonghu'){
				this.registerForm = {
					gonghao: '',
					mima: '',
					mima2: '',
					qiyemingcheng: '',
					xingbie: '',
					shouji: '',
					touxiang: '',
				}
			}
			if ('qiuzhizhe' == this.tableName) {
				this.rules.zhanghao = [{ required: true, message: '请输入账号', trigger: 'blur' }];
				this.requiredRules.zhanghao = [{ required: true, message: '请输入账号', trigger: 'blur' }]
			}
			if ('qiuzhizhe' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('qiuzhizhe' == this.tableName) {
				this.rules.xingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }];
				this.requiredRules.xingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }]
			}
			this.qiuzhizhexingbieOptions = "男,女".split(',');
			if ('qiuzhizhe' == this.tableName) {
				this.rules.nianling = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
			}
			if ('qiuzhizhe' == this.tableName) {
				this.rules.shouji = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
			}
			if ('qiuzhizhe' == this.tableName) {
				this.rules.youxiang = [{ required: true, validator: this.$validate.isEmail, trigger: 'blur' }];
			}
			if ('qiyeyonghu' == this.tableName) {
				this.rules.gonghao = [{ required: true, message: '请输入工号', trigger: 'blur' }];
				this.requiredRules.gonghao = [{ required: true, message: '请输入工号', trigger: 'blur' }]
			}
			if ('qiyeyonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('qiyeyonghu' == this.tableName) {
				this.rules.qiyemingcheng = [{ required: true, message: '请输入企业名称', trigger: 'blur' }];
				this.requiredRules.qiyemingcheng = [{ required: true, message: '请输入企业名称', trigger: 'blur' }]
			}
			this.qiyeyonghuxingbieOptions = "男,女".split(',');
			if ('qiyeyonghu' == this.tableName) {
				this.rules.shouji = [{ required: true, validator: this.$validate.isMobileNotNull, trigger: 'blur' }];
				this.requiredRules.shouji = [{ required: true, message: '请输入手机', trigger: 'blur' }]
			}
		}
	},
    created() {
		this.pageFlag = this.$route.query.pageFlag;
    },
    //方法集合
    methods: {
		changeRules(name){
			if(this.requiredRules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
        // 下二随
		qiuzhizhetouxiangUploadChange(fileUrls) {
			this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},
		qiuzhizhejianliUploadChange(fileUrls) {
			this.registerForm.jianli = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},
		qiyeyonghutouxiangUploadChange(fileUrls) {
			this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},

		// 多级联动参数


		submitForm(formName) {
			this.$refs[formName].validate((valid) => {
				if (valid) {
					var url=this.tableName+"/register";
					if(this.tableName=='qiuzhizhe'){
						this.registerForm.sfsh = '待审核'
					}
					if(`qiuzhizhe` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if(`qiyeyonghu` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
						this.$message.error(`两次密码输入不一致`);
						return
					}
					this.$http.post(url, this.registerForm).then(res => {
						if (res.data.code === 0) {
							this.$message({
								message: '注册成功',
								type: 'success',
								duration: 1500,
								onClose: () => {
									this.$router.push('/login');
								}
							});
						} else {
							this.$message.error(res.data.msg);
						}
					});
				} else {
					return false;
				}
			});
		},
		resetForm(formName) {
			this.$refs[formName].resetFields();
		}
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		background-repeat: no-repeat;
		background-size: 100% 100% !important;
		background: url(http://codegen.caihongy.cn/20250209/c983cf170fc94c0280ecf9b207c2bf4d.jpg);
		display: flex;
		width: 100%;
		min-height: 100vh;
		justify-content: center;
		align-items: center;
		background-position: center center;
		position: relative;
		background: url(http://codegen.caihongy.cn/20250209/c983cf170fc94c0280ecf9b207c2bf4d.jpg);
		.rgs-form {
			border-radius: 0px;
			padding: 20px 80px 10px 40px;
			margin: 20px 30% 20px 0;
			background: #ffffff;
			width: 600px;
			height: auto;
			.rgs-form2 {
				width: 100%;
				.title {
					border-radius: 0 0 24px 24px;
					margin: 0 0 30px -20px;
					color: #fff;
					background: linear-gradient(290deg, rgba(93,95,221,1) 0%, rgba(106,19,200,1) 100%);
					font-weight: 600;
					width: calc(100% + 80px);
					font-size: 20px;
					line-height: 64px;
					text-align: center;
				}
				.subtitle {
					margin: 0 0 10px 0;
					text-shadow: 4px 4px 2px rgba(64, 158, 255, .5);
					color: rgba(64, 158, 255, 1);
					width: 100%;
					font-size: 20px;
					line-height: 44px;
					text-align: center;
				}
				.list-item {
					margin: 0 auto 20px;
					width: 100%;
					position: relative;
					/deep/.el-form-item__content {
						padding: 0 0 0 120px;
						display: block;
						width: calc(100% - 0px);
						.label {
							padding: 0 5px 0 0;
							z-index: 9;
							color: #333;
							left: 0;
							width: 120px;
							font-size: 16px;
							line-height: 40px;
							position: absolute !important;
							text-align: right;
						}
						
						.required {
							position: relative;
						}
						.required::after{
							margin: 0 10px 0 0;
							color: red;
							left: 110px;
							position: inherit;
							content: "*";
						}
						.el-input {
							flex: 1;
							width: 100%;
						}
						.el-input .el-input__inner {
							border: 1px solid #5d62de;
							border-radius: 0;
							padding: 0 10px;
							box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
							color: #666;
							flex: 1;
							width: calc(100% - 0px);
							font-size: 15px;
							border-width: 0 1px;
							height: 40px;
						}
						.el-input .el-input__inner:focus {
							border: 1px solid #5d62de;
							border-radius: 0;
							padding: 0 10px;
							box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
							outline: none;
							color: #666;
							width: calc(100% - 0px);
							font-size: 15px;
							border-width: 0 1px;
							height: 40px;
						}
						.el-input-number {
							flex: 1;
							width: 100%;
						}
						.el-input-number .el-input__inner {
							text-align: left;
							border: 1px solid #5d62de;
							border-radius: 0;
							padding: 0 10px;
							box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
							color: #666;
							flex: 1;
							width: calc(100% - 0px);
							font-size: 15px;
							border-width: 0 1px;
							height: 40px;
						}
						.el-input-number .el-input-number__decrease {
							display: none;
						}
						.el-input-number .el-input-number__increase {
							display: none;
						}
						.el-select {
							flex: 1;
							width: calc(100% - 0px);
						}
						.el-select .el-input__inner {
							border: 1px solid #5d62de;
							border-radius: 0;
							padding: 0 10px;
							box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
							color: #666;
							width: 100%;
							font-size: 15px;
							border-width: 0 1px;
							height: 40px;
						}
						.el-select .el-input__inner:focus {
							border: 1px solid #5d62de;
							border-radius: 0;
							padding: 0 10px;
							box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
							outline: none;
							color: #666;
							width: 100%;
							font-size: 15px;
							border-width: 0 1px;
							height: 40px;
						}
						.el-date-editor {
							flex: 1;
							width: calc(100% - 0px);
						}
						.el-date-editor .el-input__inner {
							border: 1px solid #5d62de;
							border-radius: 0;
							padding: 0 10px 0 30px;
							box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
							color: #666;
							width: 100%;
							font-size: 15px;
							border-width: 0 1px;
							height: 40px;
						}
						.el-date-editor .el-input__inner:focus {
							border: 1px solid #5d62de;
							border-radius: 0;
							padding: 0 10px 0 30px;
							box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
							outline: none;
							color: #666;
							width: 100%;
							font-size: 15px;
							border-width: 0 1px;
							height: 40px;
						}
						.el-upload--picture-card {
							background: transparent;
							border: 0;
							border-radius: 0;
							width: auto;
							height: auto;
							line-height: initial;
							vertical-align: middle;
						}
						.upload .upload-img {
							border: 1px solid #5d62de60;
							cursor: pointer;
							border-radius: 0px;
							color: #5d62de;
							background: #fff;
							width: 80px;
							font-size: 24px;
							line-height: 50px;
							text-align: center;
							height: 50px;
						}
						.el-upload-list .el-upload-list__item {
							border: 1px solid #5d62de60;
							cursor: pointer;
							border-radius: 0px;
							color: #5d62de;
							background: #fff;
							width: 80px;
							font-size: 24px;
							line-height: 50px;
							text-align: center;
							height: 50px;
							font-size: 14px;
							line-height: 1.8;
						}
						.el-upload .el-icon-plus {
							border: 1px solid #5d62de60;
							cursor: pointer;
							border-radius: 0px;
							color: #5d62de;
							background: #fff;
							width: 80px;
							font-size: 24px;
							line-height: 50px;
							text-align: center;
							height: 50px;
						}
						.el-upload__tip {
							color: #666;
							font-size: 15px;
						}
						.emailInput {
							border: 1px solid #5d62de;
							border-radius: 0px 0 0 0px;
							padding: 0 10px;
							box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
							margin: 0;
							color: #606266;
							background: #fff;
							flex: 1;
							width: calc(100% - 0px);
							font-size: 15px;
							border-width: 0 1px;
							height: 40px;
						}
						.emailInput:focus {
							border: 1px solid #5d62de;
							border-radius: 0px 0 0 0px;
							padding: 0 10px;
							box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
							outline: none;
							color: #606266;
							width: calc(100% - 0px);
							font-size: 15px;
							border-width: 0 1px;
							height: 40px;
						}
						.el-btn {
							border: 1px solid #96a7c9;
							cursor: pointer;
							border-radius: 0 0px 0px 0;
							padding: 0 10px;
							margin: 0;
							color: #fff;
							background: #5d62de;
							width: 110px;
							font-size: 15px;
							border-width: 1px 1px 1px 0;
							float: right;
							height: 40px;
						}
						.el-btn:hover {
							opacity: 0.9;
						}
						
						.el-input__inner::placeholder {
							color: #999;
							font-size: 15px;
						}
						input::placeholder {
							color: #999;
							font-size: 15px;
						}
						.editor {
							margin: 0 0 0 0px;
							background: #fff;
							width: calc(100% - 0px);
							height: auto;
						}
					}
				}
				.register-btn {
					margin: 20px auto;
					width: 100%;
				}
				.register-btn1 {
					padding: 0 0 0 120px;
					width: 100%;
				}
				.register-btn2 {
					padding: 0 0 0 120px;
					margin: 10px auto;
					width: 100%;
					text-align: left;
				}
				.register_btn {
					border: 0;
					cursor: pointer;
					border-radius: 0px;
					padding: 0 30px;
					margin: 0 0px;
					color: #fff;
					background: #5d62de;
					width: 100%;
					font-size: 18px;
					height: 44px;
				}
				.register_btn:hover {
				}
				.has_btn {
					cursor: pointer;
					padding: 0;
					color: #555;
					display: inline-block;
					text-decoration: none;
					font-size: 15px;
					line-height: 40px;
				}
				.has_btn:hover {
					opacity: 0.8;
				}
			}
			.idea1 {
				background: red;
				display: none;
				width: 100%;
				height: 40px;
			}
			.idea2 {
				background: blue;
				display: none;
				width: 100%;
				height: 40px;
			}
		}
	}
	
	::-webkit-scrollbar {
		display: none;
	}
</style>
