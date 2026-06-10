<template>
	<div>
		<div class="register-container">
			<el-form v-if="pageFlag=='register'" ref="ruleForm" class="rgs-form animate__animated animate__backInDown" :model="ruleForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">基于Web的在线招聘平台设计与实现</div>
					<el-form-item class="list-item" v-if="tableName=='qiuzhizhe'">
						<div class="lable" :class="changeRules('zhanghao')?'required':''">账号：</div>
						<el-input  v-model="ruleForm.zhanghao"  autocomplete="off" placeholder="账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiuzhizhe'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiuzhizhe'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiuzhizhe'">
						<div class="lable" :class="changeRules('xingming')?'required':''">姓名：</div>
						<el-input  v-model="ruleForm.xingming"  autocomplete="off" placeholder="姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiuzhizhe'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in qiuzhizhexingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiuzhizhe'">
						<div class="lable" :class="changeRules('nianling')?'required':''">年龄：</div>
						<el-input  v-model.number="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiuzhizhe'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="qiuzhizhetouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiuzhizhe'">
						<div class="lable" :class="changeRules('shouji')?'required':''">手机：</div>
						<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiuzhizhe'">
						<div class="lable" :class="changeRules('youxiang')?'required':''">邮箱：</div>
						<el-input  v-model="ruleForm.youxiang"  autocomplete="off" placeholder="邮箱"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiuzhizhe'">
						<div class="lable" :class="changeRules('jianli')?'required':''">简历：</div>
						<file-upload
							tip="点击上传简历"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.jianli?ruleForm.jianli:''"
							@change="qiuzhizhejianliUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiyeyonghu'">
						<div class="lable" :class="changeRules('gonghao')?'required':''">工号：</div>
						<el-input  v-model="ruleForm.gonghao"  autocomplete="off" placeholder="工号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiyeyonghu'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiyeyonghu'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiyeyonghu'">
						<div class="lable" :class="changeRules('qiyemingcheng')?'required':''">企业名称：</div>
						<el-input  v-model="ruleForm.qiyemingcheng"  autocomplete="off" placeholder="企业名称"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiyeyonghu'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in qiyeyonghuxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiyeyonghu'">
						<div class="lable" :class="changeRules('shouji')?'required':''">手机：</div>
						<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiyeyonghu'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="qiyeyonghutouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="login()">注册</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">已有账号，直接登录</div>
						</div>
					</div>
				</div>
			</el-form>
		</div>
	</div>
</template>

<script>
	import 'animate.css'
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            qiuzhizhexingbieOptions: [],
            qiyeyonghuxingbieOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='qiuzhizhe'){
				this.ruleForm = {
					zhanghao: '',
					mima: '',
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
				this.ruleForm = {
					gonghao: '',
					mima: '',
					qiyemingcheng: '',
					xingbie: '',
					shouji: '',
					touxiang: '',
				}
			}
			if ('qiuzhizhe' == this.tableName) {
				this.rules.zhanghao = [{ required: true, message: '请输入账号', trigger: 'blur' }]
			}
			if ('qiuzhizhe' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('qiuzhizhe' == this.tableName) {
				this.rules.xingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }]
			}
			if ('qiyeyonghu' == this.tableName) {
				this.rules.gonghao = [{ required: true, message: '请输入工号', trigger: 'blur' }]
			}
			if ('qiyeyonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('qiyeyonghu' == this.tableName) {
				this.rules.qiyemingcheng = [{ required: true, message: '请输入企业名称', trigger: 'blur' }]
			}
			if ('qiyeyonghu' == this.tableName) {
				this.rules.shouji = [{ required: true, message: '请输入手机', trigger: 'blur' }]
			}
			this.qiuzhizhexingbieOptions = "男,女".split(',')
			this.qiyeyonghuxingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        qiuzhizhetouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        qiuzhizhejianliUploadChange(fileUrls) {
            this.ruleForm.jianli = fileUrls;
        },
        qiyeyonghutouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
			  if(this.tableName=='qiuzhizhe'){
				  this.ruleForm.sfsh = '待审核'
			  }
			if((!this.ruleForm.zhanghao) && `qiuzhizhe` == this.tableName){
				this.$message.error(`账号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `qiuzhizhe` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `qiuzhizhe` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.xingming) && `qiuzhizhe` == this.tableName){
				this.$message.error(`姓名不能为空`);
				return
			}
			if(`qiuzhizhe` == this.tableName && this.ruleForm.nianling &&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
				this.$message.error(`年龄应输入整数`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if(`qiuzhizhe` == this.tableName && this.ruleForm.shouji &&(!this.$validate.isMobile(this.ruleForm.shouji))){
				this.$message.error(`手机应输入手机格式`);
				return
			}
			if(`qiuzhizhe` == this.tableName && this.ruleForm.youxiang &&(!this.$validate.isEmail(this.ruleForm.youxiang))){
				this.$message.error(`邮箱应输入邮件格式`);
				return
			}
            if(this.ruleForm.jianli!=null) {
                this.ruleForm.jianli = this.ruleForm.jianli.replace(new RegExp(this.$base.url,"g"),"");
            }
			if((!this.ruleForm.gonghao) && `qiyeyonghu` == this.tableName){
				this.$message.error(`工号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `qiyeyonghu` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `qiyeyonghu` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.qiyemingcheng) && `qiyeyonghu` == this.tableName){
				this.$message.error(`企业名称不能为空`);
				return
			}
			if((!this.ruleForm.shouji) && `qiyeyonghu` == this.tableName){
				this.$message.error(`手机不能为空`);
				return
			}
			if(`qiyeyonghu` == this.tableName && this.ruleForm.shouji &&(!this.$validate.isMobile(this.ruleForm.shouji))){
				this.$message.error(`手机应输入手机格式`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
.register-container {
	position: relative;
	background: url(http://codegen.caihongy.cn/20250214/671fc212caf64a4ea1500127de390bed.jpg) no-repeat center top / cover;
	background: url(http://codegen.caihongy.cn/20250214/671fc212caf64a4ea1500127de390bed.jpg) no-repeat center top / cover;
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;
	align-items: center;
	.rgs-form {
		.rgs-form2 {
		scrollbar-width: thin;
		background-color: #fff;
		padding: 0 100px;
		overflow: auto;
		width: 714px;
		height: 100%;
		}
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
		.title {
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
			background: rgb(245, 246, 246);
			display: flex;
			width: 100%;
			align-items: center;
			position: relative;
			flex-wrap: wrap;
			/deep/ .el-form-item__content {
				display: flex;
				width: 100%;
			}
			.lable {
				color: #333333;
				flex: 0 0 auto;
				width: 120px;
				font-size: 14px;
				line-height: 60px;
				text-align: center;
			}
			.el-input {
				flex: 1 1 auto;
				width: 100%;
			}
			.el-input /deep/ .el-input__inner {
				border: 0px solid #efeff7;
				background-color: transparent;
				border-radius: 4px;
				padding: 0 10px;
				outline: none;
				color: #333;
				width: 100%;
				font-size: 14px;
				height: 60px;
			}
			.el-input /deep/ .el-input__inner:focus {
				border: 0px solid #efeff7;
				background-color: transparent;
				border-radius: 4px;
				padding: 0 10px;
				color: #333;
				width: 100%;
				font-size: 14px;
				height: 60px;
			}
			.el-input-number {
				flex: 1 1 auto;
				width: 100%;
			}
			.el-input-number /deep/ .el-input__inner {
				text-align: center;
				border: 0px solid #efeff7;
				background-color: transparent;
				border-radius: 4px;
				padding: 0 10px;
				outline: none;
				color: #333;
				width: 100%;
				font-size: 14px;
				height: 60px;
			}
			.el-input-number /deep/ .el-input__inner:focus {
				border: 0px solid #efeff7;
				background-color: transparent;
				border-radius: 4px;
				padding: 0 10px;
				color: #333;
				width: 100%;
				font-size: 14px;
				height: 60px;
			}
			.el-input-number /deep/ .el-input-number__decrease {
				display: none;
			}
			.el-input-number /deep/ .el-input-number__increase {
				display: none;
			}
			.el-select {
				width: 100%;
			}
			.el-select /deep/ .el-input__inner {
				border: 0px solid #efeff7;
				border-radius: 0;
				padding: 0 10px;
				color: #333;
				background: transparent;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.el-select /deep/ .el-input__inner:focus {
				border: 0px solid #efeff7;
				border-radius: 0;
				padding: 0 10px;
				color: #333;
				background: transparent;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.el-date-editor {
				width: 100%;
			}
			.el-date-editor /deep/ .el-input__inner {
				border: 0px solid #efeff7;
				border-radius: 4px;
				padding: 0 10px 0 30px;
				color: #333;
				background: transparent;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.el-date-editor /deep/ .el-input__inner:focus {
				border: 0px solid #efeff7;
				border-radius: 0;
				padding: 0 10px 0 30px;
				color: #333;
				background: transparent;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.el-date-editor.el-input {
				width: 100%;
			}
			/deep/ .el-upload--picture-card {
				background: transparent;
				border: 0;
				border-radius: 0;
				width: auto;
				height: auto;
				line-height: initial;
				vertical-align: middle;
			}
			/deep/ .upload .upload-img {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 0px;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload-list .el-upload-list__item {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 0px;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload .el-icon-plus {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 0px;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload__tip {
				color: #666;
				font-size: 15px;
			}
			/deep/ .el-input__inner::placeholder {
				color: #999;
				font-size: 14px;
			}
			.required {
				position: relative;
			}
			.required::after{
				color: red;
				left: 0;
				position: inherit;
				content: "*";
				order: -1;
			}
			.editor {
				background: #fff;
				width: 100%;
				height: auto;
			}
			.editor>.avatar-uploader {
				line-height: 0;
				height: 0;
			}
		}
		.list-item.email {
			input {
				border: 0px solid #efeff7;
				border-radius: 0;
				padding: 0 10px;
				margin: 0;
				color: #333;
				background: transparent;
				flex: 1;
				width: 100%;
				font-size: 14px;
				height: 60px;
			}
			input:focus {
				border: 0px solid #efeff7;
				border-radius: 0;
				padding: 0 10px;
				color: #333;
				background: transparent;
				width: 100%;
				font-size: 14px;
				height: 60px;
			}
			input::placeholder {
				color: #999;
				font-size: 14px;
			}
			button {
				border: 0px solid #efeff7;
				cursor: pointer;
				border-radius: 0 4px 4px 0;
				padding: 0;
				margin: 1px 0 0;
				color: #333;
				background: #0d6efd20;
				width: 150px;
				font-size: 15px;
				height: 60px;
			}
			button:hover {
				opacity: 0.8;
			}
		}
		.register-btn {
			width: 100%;
		}
		.register-btn1 {
			width: 100%;
		}
		.register-btn2 {
			left: 0;
			bottom: 360px;
			display: flex;
			width: 480px;
			justify-content: center;
			position: absolute;
		}
		.r-btn {
			border: 0px solid rgba(0, 0, 0, 1);
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			box-shadow: inset 0px -2px 6px 0px rgba(10,37,64,0.35), 0px 30px 60px -30px rgba(0,0,0,0.3), 0px 50px 100px -20px rgba(50,50,93,0.25);
			margin: 20px auto 5px;
			color: #fff;
			background: #924EFF;
			display: block;
			width: 100%;
			font-size: 24px;
			height: 60px;
		}
		.r-btn:hover {
			border: 0px solid rgba(0, 0, 0, 1);
			opacity: 0.8;
		}
		.r-login {
			cursor: pointer;
			border-radius: 5px;
			padding: 0 10px;
			box-shadow: inset 0px -2px 6px 0px rgba(10,37,64,0.35), 0px 30px 60px -30px rgba(0,0,0,0.3), 0px 50px 100px -20px rgba(50,50,93,0.25);
			color: #fff;
			background: #924EFF;
			display: inline-block;
			width: 330px;
			font-size: 15px;
			line-height: 60px;
			text-align: center;
		}
		.r-login:hover {
			opacity: 0.8;
		}
	}
}
	
	::-webkit-scrollbar {
	  display: none;
	}
</style>
