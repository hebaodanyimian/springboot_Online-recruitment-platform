<template>
	<div class="add-update-preview">
		<el-form
			class="add-update-form"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
			>
			<el-form-item class="add-item" label="公司名称" prop="gongsimingcheng">
				<el-input v-model="ruleForm.gongsimingcheng" 
					placeholder="公司名称" clearable :disabled=" false  ||ro.gongsimingcheng"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="工号" prop="gonghao">
				<el-input v-model="ruleForm.gonghao" 
					placeholder="工号" clearable :disabled=" false  ||ro.gonghao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="企业名称" prop="qiyemingcheng">
				<el-input v-model="ruleForm.qiyemingcheng" 
					placeholder="企业名称" clearable :disabled=" false  ||ro.qiyemingcheng"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="招聘封面" v-if="type!='cross' || (type=='cross' && !ro.zhaopinfengmian)" prop="zhaopinfengmian">
				<file-upload
					tip="点击上传招聘封面"
					action="file/upload"
					:limit="3"
					:multiple="true"
					:fileUrls="ruleForm.zhaopinfengmian?ruleForm.zhaopinfengmian:''"
					@change="zhaopinfengmianUploadChange"
					></file-upload>
			</el-form-item>
			<el-form-item class="add-item" v-else label="招聘封面" prop="zhaopinfengmian">
				<img v-if="ruleForm.zhaopinfengmian.substring(0,4)=='http'" class="upload-img" v-bind:key="index" :src="ruleForm.zhaopinfengmian.split(',')[0]">
				<img v-else class="upload-img" v-bind:key="index" v-for="(item,index) in ruleForm.zhaopinfengmian.split(',')" :src="baseUrl+item">
			</el-form-item>
			<el-form-item class="add-item" label="职位名称" prop="zhiweimingcheng">
				<el-input v-model="ruleForm.zhiweimingcheng" 
					placeholder="职位名称" clearable :disabled=" false  ||ro.zhiweimingcheng"></el-input>
			</el-form-item>
			<el-form-item class="add-item"  label="职位类型" prop="zhiweileixing">
				<el-select v-model="ruleForm.zhiweileixing" placeholder="请选择职位类型" :disabled=" false  ||ro.zhiweileixing" >
					<el-option
						v-for="(item,index) in zhiweileixingOptions"
						:key="index"
						:label="item"
						:value="item">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item class="add-item" label="薪资范围" prop="xinzifanwei">
				<el-input v-model.number="ruleForm.xinzifanwei" 
					placeholder="薪资范围" clearable :disabled=" false  ||ro.xinzifanwei"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="所属行业" prop="suoshuxingye">
				<el-input v-model="ruleForm.suoshuxingye" 
					placeholder="所属行业" clearable :disabled=" false  ||ro.suoshuxingye"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="福利待遇" prop="fulidaiyu">
				<el-input v-model="ruleForm.fulidaiyu" 
					placeholder="福利待遇" clearable :disabled=" false  ||ro.fulidaiyu"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="公司地址" prop="gongsidizhi">
				<el-input v-model="ruleForm.gongsidizhi" 
					placeholder="公司地址" clearable :disabled=" false  ||ro.gongsidizhi"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="发布日期" prop="faburiqi">
				<el-date-picker
					:disabled=" false  ||ro.faburiqi"
					format="yyyy 年 MM 月 dd 日"
					value-format="yyyy-MM-dd"
					v-model="ruleForm.faburiqi" 
					type="date"
					placeholder="发布日期">
				</el-date-picker> 
			</el-form-item>
			<el-form-item class="add-item" label="公司简介" prop="gongsijianjie">
				<el-input
					type="textarea"
					:rows="8"
					placeholder="公司简介"
					v-model="ruleForm.gongsijianjie">
					</el-input>
			</el-form-item>

			<el-form-item class="add-btn-item">
				<el-button class="submitBtn"  type="primary" @click="onSubmit">
					<span class="icon iconfont "></span>
					<span class="text">提交</span>
				</el-button>
				<el-button class="closeBtn" @click="back()">
					<span class="icon iconfont "></span>
					<span class="text">取消</span>
				</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				id: '',
				baseUrl: '',
				ro:{
					gongsimingcheng : false,
					gonghao : false,
					qiyemingcheng : false,
					zhaopinfengmian : false,
					zhiweimingcheng : false,
					zhiweileixing : false,
					xinzifanwei : false,
					suoshuxingye : false,
					fulidaiyu : false,
					gongsidizhi : false,
					faburiqi : false,
					gongsijianjie : false,
					sfsh : false,
					shhf : false,
					clicktime : false,
					discussnum : false,
					storeupnum : false,
				},
				type: '',
				userTableName: localStorage.getItem('UserTableName'),
				ruleForm: {
					gongsimingcheng: '',
					gonghao: '',
					qiyemingcheng: '',
					zhaopinfengmian: '',
					zhiweimingcheng: '',
					zhiweileixing: '',
					xinzifanwei: '',
					suoshuxingye: '',
					fulidaiyu: '',
					gongsidizhi: '',
					faburiqi: '',
					gongsijianjie: '',
					clicktime: '',
					discussnum: '',
					storeupnum: '',
				},
				zhiweileixingOptions: [],


				rules: {
					gongsimingcheng: [
						{ required: true, message: '公司名称不能为空', trigger: 'blur' },
					],
					gonghao: [
					],
					qiyemingcheng: [
					],
					zhaopinfengmian: [
					],
					zhiweimingcheng: [
					],
					zhiweileixing: [
					],
					xinzifanwei: [
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
					suoshuxingye: [
					],
					fulidaiyu: [
					],
					gongsidizhi: [
					],
					faburiqi: [
					],
					gongsijianjie: [
					],
					sfsh: [
					],
					shhf: [
					],
					clicktime: [
					],
					discussnum: [
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
					storeupnum: [
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
				},
				centerType: false,
			};
		},
		computed: {



		},
		components: {
		},
		created() {
			if(this.$route.query.centerType){
				this.centerType = true
			}
			//this.bg();
			let type = this.$route.query.type ? this.$route.query.type : '';
			this.init(type);
			this.baseUrl = this.$config.baseUrl;
			this.ruleForm.faburiqi = this.getCurDate()
		},
		methods: {
			getMakeZero(s) {
				return s < 10 ? '0' + s : s;
			},
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(type) {
				this.type = type;
				if(type=='cross'){
					var obj = JSON.parse(localStorage.getItem('crossObj'));
					for (var o in obj){
						if(o=='gongsimingcheng'){
							this.ruleForm.gongsimingcheng = obj[o];
							this.ro.gongsimingcheng = true;
							continue;
						}
						if(o=='gonghao'){
							this.ruleForm.gonghao = obj[o];
							this.ro.gonghao = true;
							continue;
						}
						if(o=='qiyemingcheng'){
							this.ruleForm.qiyemingcheng = obj[o];
							this.ro.qiyemingcheng = true;
							continue;
						}
						if(o=='zhaopinfengmian'){
							this.ruleForm.zhaopinfengmian = obj[o]?obj[o].split(",")[0]:'';
							this.ro.zhaopinfengmian = true;
							continue;
						}
						if(o=='zhiweimingcheng'){
							this.ruleForm.zhiweimingcheng = obj[o];
							this.ro.zhiweimingcheng = true;
							continue;
						}
						if(o=='zhiweileixing'){
							this.ruleForm.zhiweileixing = obj[o];
							this.ro.zhiweileixing = true;
							continue;
						}
						if(o=='xinzifanwei'){
							this.ruleForm.xinzifanwei = obj[o];
							this.ro.xinzifanwei = true;
							continue;
						}
						if(o=='suoshuxingye'){
							this.ruleForm.suoshuxingye = obj[o];
							this.ro.suoshuxingye = true;
							continue;
						}
						if(o=='fulidaiyu'){
							this.ruleForm.fulidaiyu = obj[o];
							this.ro.fulidaiyu = true;
							continue;
						}
						if(o=='gongsidizhi'){
							this.ruleForm.gongsidizhi = obj[o];
							this.ro.gongsidizhi = true;
							continue;
						}
						if(o=='faburiqi'){
							this.ruleForm.faburiqi = obj[o];
							this.ro.faburiqi = true;
							continue;
						}
						if(o=='gongsijianjie'){
							this.ruleForm.gongsijianjie = obj[o];
							this.ro.gongsijianjie = true;
							continue;
						}
						if(o=='clicktime'){
							this.ruleForm.clicktime = obj[o];
							this.ro.clicktime = true;
							continue;
						}
						if(o=='discussnum'){
							this.ruleForm.discussnum = obj[o];
							this.ro.discussnum = true;
							continue;
						}
						if(o=='storeupnum'){
							this.ruleForm.storeupnum = obj[o];
							this.ro.storeupnum = true;
							continue;
						}
					}
				}else if(type=='edit'){
					this.info()
				}
				// 获取用户信息
				this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						var json = res.data.data;
						if((json.gonghao!=''&&json.gonghao) || json.gonghao==0){
							this.ruleForm.gonghao = json.gonghao;
							this.ro.gonghao = true;
						}
						if((json.qiyemingcheng!=''&&json.qiyemingcheng) || json.qiyemingcheng==0){
							this.ruleForm.qiyemingcheng = json.qiyemingcheng;
							this.ro.qiyemingcheng = true;
						}
					}
				});
				this.$http.get('option/zhiweileixing/zhiweileixing', {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.zhiweileixingOptions = res.data.data;
					}
				});

				if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
					localStorage.removeItem('raffleType')
					setTimeout(() => {
						this.onSubmit()
					}, 300)
				}
			},

			// 多级联动参数
			// 多级联动参数
			info() {
				this.$http.get(`zhaopinxinxi/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.ruleForm = res.data.data;
					}
				});
			},
			// 提交
			async onSubmit() {
				if(!this.ruleForm.id) {
					delete this.ruleForm.userid
				}
				await this.$refs["ruleForm"].validate(async valid => {
					if(valid) {
						if(this.type=='cross'){
							var statusColumnName = localStorage.getItem('statusColumnName');
							var statusColumnValue = localStorage.getItem('statusColumnValue');
							if(statusColumnName && statusColumnName!='') {
								var obj = JSON.parse(localStorage.getItem('crossObj'));
								if(!statusColumnName.startsWith("[")) {
									for (var o in obj){
										if(o==statusColumnName){
											obj[o] = statusColumnValue;
										}
									}
									var table = localStorage.getItem('crossTable');
									await this.$http.post(table+'/update', obj).then(res => {});
								}
							}
						}


						await this.$http.post(`zhaopinxinxi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(async res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
										
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
							}
						});
					}
				});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.$router.go(-1);
			},
			zhaopinfengmianUploadChange(fileUrls) {
				this.ruleForm.zhaopinfengmian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
			},
		}
	};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.add-update-preview {
		padding: 0 0 20px;
		margin: 0px auto;
		color: #666;
		background: none;
		width: 1200px;
		font-size: 16px;
		position: relative;
		.add-update-form {
			border: 1px solid #6a11c7;
			border-radius: 60px 0px 60px 0px;
			box-shadow: 0 20px 40px rgba(0,0,0,0.5);
			padding: 30px;
			margin: 60px auto;
			outline: 30px solid #fff;
			background: #fff;
			width: calc(100% - 60px);
			position: relative;
			.add-item.el-form-item {
				border-radius: 0px;
				padding: 20px 0 0;
				margin: 0 0 20px 0;
				background: #fff;
				border-color: #475a8310;
				border-width:  0 0 0px;
				border-style: solid;
				/deep/ .el-form-item__label {
					padding: 0 10px 0 0;
					color: #666;
					font-weight: 500;
					width: 180px;
					font-size: inherit;
					line-height: 40px;
					text-align: right;
				}
				/deep/ .el-form-item__content {
					margin-left: 180px;
				}
				.el-input {
					width: auto;
				}
				.el-input /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: rgba(85, 85, 127, 1.0);
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input__inner {
					text-align: left;
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .is-disabled .el-input__inner {
					text-align: left;
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: rgba(85, 85, 127, 1.0);
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input-number__decrease {
					display: none;
				}
				.el-input-number /deep/ .el-input-number__increase {
					display: none;
				}
				.el-select {
					width: auto;
				}
				.el-select /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 10px;
					color: inherit;
					width: 100%;
					font-size: 16px;
					min-width: inherit !important;
					height: 40px;
				}
				.el-select /deep/ .is-disabled .el-input__inner {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 10px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				.el-date-editor {
					width: auto;
				}
				.el-date-editor /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
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
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					background: #fff;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
				}
				/deep/ .el-upload-list .el-upload-list__item {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					background: #fff;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
					font-size: 14px;
					line-height: 1.8;
				}
				/deep/ .el-upload .el-icon-plus {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					background: #fff;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
				}
				/deep/ .el-upload__tip {
					color: #888;
					font-size: 16px;
				}
				.el-textarea /deep/ .el-textarea__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					min-height: 150px;
					min-width: 48%;
					height: auto;
				}
				.el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
					border: 0px solid #ddd;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 12px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: auto;
					font-size: 16px;
					min-height: 150px;
					min-width: 50%;
					height: auto;
				}
				/deep/ .el-input__inner::placeholder {
					color: inherit;
					font-size: inherit;
				}
				/deep/ textarea::placeholder {
					color: inherit;
					font-size: inherit;
				}
				.editor {
					background-color: #fff;
					border-radius: 0;
					padding: 0;
					box-shadow: none;
					margin: 0;
					width: 100%;
					min-height: 350px;
					border-color: #ccc;
					border-width: 1px;
					border-style: solid;
					height: auto;
				}
				.upload-img {
					object-fit: cover;
					width: 100px;
					height: 100px;
				}
				.viewBtn {
					border: 0;
					cursor: pointer;
					border-radius: 4px;
					padding: 0 20px;
					margin: 0;
					color: #333;
					background: #475a8330;
					display: inline-block;
					width: auto;
					font-size: 14px;
					line-height: 34px;
					height: 34px;
				}
				.viewBtn:hover {
				}
				.unviewBtn {
					border: 0;
					cursor: pointer;
					padding: 0 20px;
					margin: 0;
					color: #333;
					display: inline-block;
					font-size: 14px;
					line-height: 34px;
					border-radius: 4px;
					outline: none;
					background: #ddd;
					width: auto;
					height: 34px;
				}
				.unviewBtn:hover {
				}
			}
			.add-btn-item {
				padding: 0;
				margin: 20px 0;
				text-align: right;
				.submitBtn {
					border: 0;
					cursor: pointer;
					padding: 0 24px 0 30px;
					margin: 0 20px 0 0;
					display: inline-block;
					font-size: 16px;
					line-height: 38px;
					border-radius: 0px;
					background: #6a11c7;
					width: auto;
					text-align: center;
					min-width: 120px;
					height: 38px;
					.icon {
						color: #fff;
					}
					.text {
						color: #fff;
					}
				}
				.submitBtn:hover {
					color: #fff;
					.icon {
					}
					.text {
					}
				}
				.closeBtn {
					border: 0px solid #ddd;
					cursor: pointer;
					padding: 0 24px 0 30px;
					margin: 0 20px 0 0;
					color: #666;
					display: inline-block;
					font-size: 16px;
					line-height: 38px;
					border-radius: 0px;
					background: #e8e8e8;
					width: auto;
					text-align: center;
					min-width: 120px;
					height: 38px;
					.icon {
						color: #fff;
					}
					.text {
						color: #666;
						text-align: center;
					}
				}
				.closeBtn:hover {
					color: #fff;
					.icon {
					}
					.text {
					}
				}
			}
		}
	}
	.el-date-editor.el-input {
		width: auto;
	}
</style>
