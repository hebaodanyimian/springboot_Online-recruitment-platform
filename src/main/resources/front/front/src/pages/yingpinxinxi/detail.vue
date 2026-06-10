<template>
	<div>
	<!--  -->
		<div class="breadcrumb-preview">
			<el-breadcrumb :separator="''">
				<el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
				<el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index" :to="'/index/yingpinxinxi?centerType=' + (centerType?'1':'0')"><a>{{item.name}}</a></el-breadcrumb-item>
				<el-breadcrumb-item class="item3"><a href="javascript:void(0);">详情</a></el-breadcrumb-item>
			</el-breadcrumb>
		</div>
		<div class="back_box">
			<el-button class="backBtn" size="mini" @click="backClick">
				<span class="icon iconfont icon-jiantou33"></span>
				<span class="text">返回</span>
			</el-button>
		</div>
		<div class="detail-preview">
			<div class="attr">
				<div class="info">
					<div class="title-item">
						<div class="detail-title">
							{{detail.qiyemingcheng}}
						</div>
					</div>
					<div class="item">
						<div class="lable">工号</div>
						<div class="text "  >{{detail.gonghao}}</div>
					</div>
					<div class="item">
						<div class="lable">职位类型</div>
						<div class="text "  >{{detail.zhiweileixing}}</div>
					</div>
					<div class="item">
						<div class="lable">应聘日期</div>
						<div class="text "  >{{detail.yingpinriqi}}</div>
					</div>
					<div class="item">
						<div class="lable">账号</div>
						<div class="text "  >{{detail.zhanghao}}</div>
					</div>
					<div class="item">
						<div class="lable">姓名</div>
						<div class="text "  >{{detail.xingming}}</div>
					</div>
					<div class="item">
						<div class="lable">评分</div>
						<div class="text "  >{{detail.totalscore}}</div>
					</div>
					<div class="item">
						<div class="lable">简历</div>
						<el-button class="uploadBtn" @click="download(detail.jianli )">点击下载</el-button>
					</div>
					<div class="item" v-if="centerType">
						<div class="lable">审核状态</div>
						<div class="text">{{detail.sfsh=='是'?'通过':(detail.sfsh=='否'?'不通过':'待审核')}}</div>
					</div>
					<div class="item" v-if="centerType">
						<div class="lable">审核回复</div>
						<div class="text">{{detail.shhf}}</div>
					</div>
					<div class="btn_box">
						<el-button class="editBtn" v-if="btnAuth('yingpinxinxi','修改')&&detail.sfsh!='是'&&detail.sfsh!='否' " @click="editClick">修改</el-button>
						<el-button class="delBtn" v-if="btnAuth('yingpinxinxi','删除')" @click="delClick">删除</el-button>
						<el-button class="reserveBtn" 
							v-if="btnAuth('yingpinxinxi','通知')" 
							@click="onAcross('mianshitongzhi','是','','[1]','已通知')" type="warning">
							通知
						</el-button>
						<el-button class="auditBtn" v-if="btnAuth('yingpinxinxi','审核') && (detail.sfsh=='待审核'||!detail.sfsh)" @click="onSH" type="warning">审核</el-button>
					</div>
				</div>
			</div>
		
			<div class="detail-swpier2" v-if="detailBanner.length">
				<div class="swiper21">
					<div class="swiper-container mySwiper21">
						<div class="swiper-wrapper">
							<div class="swiper-slide" v-for="item in detailBanner" :key="item.id">
								<div class="swiper-item">
									<img v-if="item.substr(0,4)=='http'" :src="item" class="image">
									<img v-else :src="baseUrl + item" class="image">
								</div>
							</div>
						</div>
						<div class="swiper-button-prev">
							<span class="icon iconfont icon-jiantou39"></span>
						</div>
						<div class="swiper-button-next">
							<span class="icon iconfont icon-jiantou18"></span>
						</div>
					</div>
				</div>
				<div class="swiper22">
					<div class="swiper-container mySwiper22">
						<div class="swiper-wrapper">
							<div class="swiper-slide" v-for="item in detailBanner" :key="item.id">
								<div class="swiper-item">
									<img v-if="item.substr(0,4)=='http'" :src="item" class="image">
									<img v-else :src="baseUrl + item" class="image">
								</div>
							</div>
						</div>
						<div class="swiper-button-prev">
							<span class="icon iconfont icon-jiantou39"></span>
						</div>
						<div class="swiper-button-next">
							<span class="icon iconfont icon-jiantou18"></span>
						</div>
					</div>
				</div>
			</div>


		

			<el-tabs class="detail-tabs" v-model="activeName" type="border-card" v-if="tabsNum>0" >
				<el-tab-pane label="评论" name="second">
					<el-form class="add commentForm" :model="form" :rules="rules" ref="form">
						<el-form-item class="item" label="评论" prop="content">
							<editor
								myQuillEditor="content"
								v-model="form.content" 
								class="editor" 
								action="file/upload">
							</editor>
						</el-form-item>
						<el-form-item class="item" label="评分" prop="score">
							<el-rate
								v-model="form.score"
								:max='Number(5)'
								:allow-half='false'
								:low-threshold='Number(2)'
								:high-threshold='Number(4)'
								:show-text='false'
								:texts='["极差", "失望", "一般", "满意", "惊喜"]'
								text-color='#1F2D3D'
								:colors='["#F7BA2A", "#F7BA2A", "#F7BA2A"]'
								void-color='#C6D1DE'
								disabled-void-color='#EFF2F7'
								:icon-classes='["el-icon-star-on", "el-icon-star-on","el-icon-star-on"]'
								void-icon-class='el-icon-star-off'
								disabled-void-icon-class='el-icon-star-on'
								:show-score='false'
							>
							</el-rate>
						</el-form-item>
						<el-form-item class="commentBtn">
							<el-button class="submitBtn" type="primary" @click="submitForm('form')">立即提交</el-button>
							<el-button class="resetBtn" @click="resetForm('form')">重置</el-button>
						</el-form-item>
					</el-form>
				
					<div v-if="infoList.length" class="comment-list">
						<div class="comment-item" v-for="item in infoList" :key="item.id" @mouseenter="discussEnter(item.id)"
							@mouseleave="discussLeave">
							<div class="istop" v-if="item.istop">
								<span class="icon iconfont icon-jiantou24"></span>
							</div>
							<div class="user">
								<el-image v-if="item.avatarurl" :size="50" :src="baseUrl + item.avatarurl"></el-image>
								<el-image v-if="!item.avatarurl" :size="50" :src="require('@/assets/touxiang.png')"></el-image>
								<div class="name">{{item.nickname}}</div>
							</div>
							<div class="comment-content-box">
								<div class="ql-snow ql-editor" v-html="item.content"></div>
								<el-rate
									v-model="item.score"
									disabled
									:max='Number(5)'
									:allow-half='false'
									:low-threshold='Number(2)'
									:high-threshold='Number(4)'
									:show-text='false'
									:texts='["极差", "失望", "一般", "满意", "惊喜"]'
									text-color='#1F2D3D'
									:colors='["#F7BA2A", "#F7BA2A", "#F7BA2A"]'
									void-color='#C6D1DE'
									disabled-void-color='#EFF2F7'
									:icon-classes='["el-icon-star-on", "el-icon-star-on","el-icon-star-on"]'
									void-icon-class='el-icon-star-off'
									disabled-void-icon-class='el-icon-star-on'
									:show-score='false'
								>
								</el-rate>
								<div class="comment-time">{{item.addtime}}</div>
								<div class="zancai-box">
									<div v-if="!comcaiChange(item)" class="zan-item" :class="comzanChange(item)?'active':''" @click="comzanClick(item)">
										<span class="icon iconfont" :class="comzanChange(item)?'icon-zan11':'icon-zan07'"></span>
										<span class="label">{{comzanChange(item)?'已赞':'赞'}}</span>
										<span class="num">({{item.thumbsupnum}})</span>
									</div>
									<div v-if="!comzanChange(item)" class="cai-item" :class="comcaiChange(item)?'active':''" @click="comcaiClick(item)">
										<span class="icon iconfont" :class="comcaiChange(item)?'icon-cai16':'icon-cai01'"></span>
										<span class="label">{{comcaiChange(item)?'已踩':'踩'}}</span>
										<span class="num">({{item.crazilynum}})</span>
									</div>
								</div>
								<div class="comment-btn">
									<!-- <el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 10px","color":"#fff","borderRadius":"0px","background":"#6a11c7","width":"auto","lineHeight":"32px","fontSize":"14px","minWidth":"80px","height":"32px"}'>回复</el-button> -->
									<el-button class="delBtn" v-if="showIndex==item.id&&userid==item.userid" @click="discussDel(item.id)">删除</el-button>
								</div>
							</div>
							<div class="comment-content-box" v-if="item.reply">
								回复：<span class="ql-snow ql-editor" v-html="item.reply"></span>
							</div>
						</div>
					</div>
				
					<el-pagination
						background
						id="pagination" class="pagination"
						:page-size="pageSize"
						prev-text="上一页"
						next-text="下一页"
						:hide-on-single-page="false"
						:layout='["total","prev","pager","next","sizes","jumper"].join()'
						:total="total"
						@current-change="curChange"
						@prev-click="prevClick"
						@next-click="nextClick"
						@size-change="sizeChange"
						></el-pagination>
				</el-tab-pane>
			</el-tabs>
			<el-dialog title="审核" :visible.sync="sfshVisiable" width="50%">
				<el-form ref="shForm" :model="shForm" label-width="80px">
					<el-form-item label="审核状态">
						<el-select v-model="shForm.sfsh" placeholder="审核状态">
							<el-option label="通过" value="是"></el-option>
							<el-option label="不通过" value="否"></el-option>
							<el-option label="待审核" value="待审核"></el-option>
						</el-select>
					</el-form-item>
					<el-form-item label="内容">
						<el-input type="textarea" :rows="8" v-model="shForm.shhf"></el-input>
					</el-form-item>
				</el-form>
				<div slot="footer" class="dialog-footer">
					<el-button @click="sfshVisiable = false">取 消</el-button>
					<el-button type="primary" @click="shHandler">确 定</el-button>
				</div>
			</el-dialog>

			<div class="idea1"></div>
			<div class="idea2"></div>
		</div>
		<div class="share_view">
		</div>
	</div>
</template>

<script>
	import axios from 'axios'
	import Swiper from "swiper";
	export default {
		//数据集合
		data() {
			return {
				tablename: 'yingpinxinxi',
				baseUrl: '',
				breadcrumbItem: [
					{
						name: '应聘信息'
					}
				],
				title: '',
				detailBanner: [],
				userid: Number(localStorage.getItem('frontUserid')),
				id: 0,
				detail: {},
				tabsNum: 1,
				activeName: 'second',
				form: {
					content: '',
					userid: Number(localStorage.getItem('frontUserid')),
					nickname: localStorage.getItem('username'),
					avatarurl: '',
					score: 0,
				},
				showIndex: -1,
				infoList: [],
				colors: ['#99A9BF', '#F7BA2A', '#FF9900'],
				rules: {
					content: [
						{ required: true, message: '请输入内容', trigger: 'blur' }
					],
					score: [
						{ required: true, message: '请选择评分', trigger: 'blur' }
					],
				},
				total: 1,
				pageSize: 10,
				totalPage: 1,
				buynumber: 1,
				sfshVisiable: false,
				shForm: {
					sfsh: '是',
					shhf: ''
				},
				centerType: false,
				storeupType: false,
				shareUrl: location.href,
			}
		},
		created() {
			if(this.$route.query.centerType&&this.$route.query.centerType!=0) {
				this.centerType = true
			}
			if(this.$route.query.storeupType&&this.$route.query.storeupType!=0) {
				this.storeupType = true
			}
			
			this.init();
		},
		mounted() {
			setTimeout(()=>{
				let mySwiper22 = new Swiper(".mySwiper22", {"navigation":{"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},"freeMode":true,"watchSlidesVisibility":true,"watchSlidesProgress":true,"loopedSlides":5,"slidesPerView":3,"spaceBetween":10})
				let option21 = {...{"navigation":{"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},"loopedSlides":5,"spaceBetween":10}}
				option21.thumbs = {
					swiper: mySwiper22
				}
				new Swiper(".mySwiper21", option21)
			},100)
		},
		//方法集合
		methods: {
			init() {
				this.id = this.$route.query.id
				this.baseUrl = this.$config.baseUrl;
				this.$http.get(this.tablename + '/detail/'  + this.id, {}).then(res => {
					if (res.data.code == 0) {
						this.detail = res.data.data;
						this.title = this.detail.qiyemingcheng;
						if(this.detail.zhaopinfengmian) {
							this.detailBanner = this.detail.zhaopinfengmian.split(",w").length>1?[this.detail.zhaopinfengmian]:this.detail.zhaopinfengmian.split(',');
						}
						this.$forceUpdate();
						this.getDiscussList(1);
						if(localStorage.getItem('frontToken')){
						}

					}
				});
			},
			async onAcross(acrossTable,crossOptAudit,crossOptPay,statusColumnName,tips,statusColumnValue,type=1){
				if(crossOptAudit=='是'&&this.detail.sfsh!='是') {
					this.$message({
						message: "请审核通过后再操作",
						type: "error",
						duration: 1500,
						onClose: () => {
						}
					});
					return
				}
				localStorage.setItem('crossTable',`yingpinxinxi`);
				localStorage.setItem('crossObj', JSON.stringify(this.detail));
				localStorage.setItem('statusColumnName',statusColumnName);
				localStorage.setItem('statusColumnValue',statusColumnValue);
				localStorage.setItem('tips',tips);
				if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
					var obj = JSON.parse(localStorage.getItem('crossObj'));
					for (var o in obj){
						if(o==statusColumnName && obj[o]==statusColumnValue){
							this.$message({
								type: 'error',
								message: tips,
								duration: 1500
							});
							return
						}
					}
				}
				this.$router.push({path: '/index/' + acrossTable + 'Add', query: {type: 'cross'}});
			},
			onSH() {
				this.sfshVisiable = true;
			},
			shHandler(){
				this.$confirm(`确定操作?`, "提示", {
					confirmButtonText: "确定",
					cancelButtonText: "取消",
					type: "warning"
				}).then(() => {
					this.detail.sfsh = this.shForm.sfsh;
					this.detail.shhf = this.shForm.shhf;
					this.$http.post(`${this.tablename}/update`, this.detail).then(res => {
						if (res.data.code == 0) {
							this.sfshVisiable = false;
							this.$message({
								message: "操作成功",
								type: "success",
								duration: 1500,
							});
						}
					});
				});
			},
			curChange(page) {
				this.getDiscussList(page);
			},
			prevClick(page) {
				this.getDiscussList(page);
			},
			nextClick(page) {
				this.getDiscussList(page);
			},
			sizeChange(size){
				this.pageSize = size
				this.getDiscussList(1);
			},
			// 返回按钮
			backClick(){
				if(this.storeupType){
					history.back()
				}else{
					let params = {}
					if(this.centerType){
						params.centerType = 1
					}
					this.$router.push({path: '/index/yingpinxinxi', query: params});
				}
			},
			// 下载
			download(file ){
				if(!file) {
					this.$message({
						type: 'error',
						message: '文件不存在',
						duration: 1500,
					});
					return;
				}
				let arr = file.replace(new RegExp('upload/', "g"), "")
				axios.get(this.baseUrl + '/file/download?fileName=' + arr, {
					headers: {
						token: localStorage.getItem("frontToken")
					},
					responseType: "blob"
				}).then(({
					data
				}) => {
					const binaryData = [];
					binaryData.push(data);
					const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
						type: 'application/pdf;chartset=UTF-8'
					}))
					const a = document.createElement('a')
					a.href = objectUrl
					a.download = arr
					// a.click()
					// 下面这个写法兼容火狐
					a.dispatchEvent(new MouseEvent('click', {
						bubbles: true,
						cancelable: true,
						view: window
					}))
					window.URL.revokeObjectURL(data)
				},err=>{
					axios.get((location.href.split(this.$config.name).length>1 ? location.href.split(this.$config.name)[0] :'') + this.$config.name + '/file/download?fileName=' + arr, {
						headers: {
							token: localStorage.getItem("frontToken")
						},
						responseType: "blob"
					}).then(({
						data
					}) => {
						const binaryData = [];
						binaryData.push(data);
						const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
							type: 'application/pdf;chartset=UTF-8'
						}))
						const a = document.createElement('a')
						a.href = objectUrl
						a.download = arr
						// a.click()
						// 下面这个写法兼容火狐
						a.dispatchEvent(new MouseEvent('click', {
							bubbles: true,
							cancelable: true,
							view: window
						}))
						window.URL.revokeObjectURL(data)
					})
				})
			},
			getDiscussList(page) {
				this.$http.get('discussyingpinxinxi/list', {params: {page, limit: this.pageSize, refid: this.detail.id,sort: 'istop',order: 'desc'}}).then(res => {
					if (res.data.code == 0) {
						this.infoList = res.data.data.list;
						this.total = res.data.data.total;
						this.pageSize = Number(res.data.data.pageSize);
						this.totalPage = res.data.data.totalPage;
					}
				});
			},
			comzanChange(row){
				if(row.tuserids){
					let arr = row.tuserids.split(',')
					for(let x in arr){
						if(arr[x] == this.userid){
							return true
						}
					}
				}
				return false
			},
			comzanClick(row){
				if(!this.userid){
					return false
				}
				if(!this.comzanChange(row)){
					row.thumbsupnum++
					if(row.tuserids){
						row.tuserids = row.tuserids + ',' + this.userid
					}else {
						row.tuserids = String(this.userid)
					}
					this.$http.post('discussyingpinxinxi/update',row).then(rs=>{
						this.$message.success('点赞成功')
					})
				}else {
					row.thumbsupnum--
					let arr = row.tuserids.split(',')
					for(let x in arr){
						if(arr[x] == this.userid){
							arr.splice(x,1)
						}
					}
					row.tuserids = arr.join(',')
					this.$http.post('discussyingpinxinxi/update',row).then(rs=>{
						this.$message.success('取消成功')
					})
				}
			},
			comcaiChange(row){
				if(row.cuserids){
					let arr = row.cuserids.split(',')
					for(let x in arr){
						if(arr[x] == this.userid){
							return true
						}
					}
				}
				return false
			},
			comcaiClick(row){
				if(!this.userid){
					return false
				}
				if(!this.comcaiChange(row)){
					row.crazilynum++
					if(row.cuserids){
						row.cuserids = row.cuserids + ',' + this.userid
					}else {
						row.cuserids = String(this.userid)
					}
					this.$http.post('discussyingpinxinxi/update',row).then(rs=>{
						this.$message.success('点踩成功')
					})
				}else {
					row.crazilynum--
					let arr = row.cuserids.split(',')
					for(let x in arr){
						if(arr[x] == this.userid){
							arr.splice(x,1)
						}
					}
					row.cuserids = arr.join(',')
					this.$http.post('discussyingpinxinxi/update',row).then(rs=>{
						this.$message.success('取消成功')
					})
				}
			},
			discussEnter(index){
				this.showIndex = index
			},
			discussLeave(){
				this.showIndex = -1
			},
			discussDel(id){
				this.$confirm('是否删除此评论？').then(_ => {
					this.$http.post('discussyingpinxinxi/delete',[id]).then(res=>{
						if(res.data&&res.data.code==0){
							this.addDiscussNum(1)
							this.$message({
								type: 'success',
								message: '删除成功!',
								duration: 1500,
								onClose: () => {
									this.getDiscussList(1);
								}
							});
						}
					})
				}).catch(_ => {});
			},
			submitForm(formName) {
				this.$refs[formName].validate((valid) => {
					if (valid) {
						this.$http.get('discussyingpinxinxi/page',{params: {
							page: 1,
							limit: 1,
							refid: this.detail.id,
							userid: Number(localStorage.getItem('frontUserid'))
						}}).then(rs=>{
							if(rs.data.data.list.length){
								this.$message({
									type: 'error',
									message: '每个用户只能评论一次!',
									duration: 1500
								});
								return false
							}
							this.form.refid = this.detail.id;
							this.form.avatarurl = localStorage.getItem('frontHeadportrait')?localStorage.getItem('frontHeadportrait'):'';
							this.$http.post('discussyingpinxinxi/add', this.form).then(rs2 => {
								if (rs2.data.code == 0) {
									this.addDiscussNum(2)
									this.form.content = '';
									this.form.score = 0
									this.getDiscussList(1);
									this.$message({
										type: 'success',
										message: '评论成功!',
										duration: 1500,
									});
								}
							});
						})
					} else {
						return false;
					}
				});
			},
			resetForm(formName) {
				this.$refs[formName].resetFields();
			},
			addDiscussNum(type){
				if(type==2){
					this.detail.discussnum++
				}else if(type==1){
					if(this.detail.discussnum!=0){
						this.detail.discussnum--
					}else{
						this.detail.discussnum = 0
					}
				}
				this.$http.get('discussyingpinxinxi/list',{params: {
					page: 1,
					limit: 10000,
					refid: this.detail.id
				}}).then(rs=>{
					let score = 0
					for(let x in rs.data.data.list){
						score += Number(rs.data.data.list[x].score)
					}
					this.detail.totalscore = Number((score / Number(rs.data.data.list.length)).toFixed(2))
					this.$http.post('yingpinxinxi/update',this.detail).then(res=>{})
				})
			},


			// 权限判断
			btnAuth(tableName,key){
				if(this.centerType){
					return this.isBackAuth(tableName,key)
				}else{
					return this.isAuth(tableName,key)
				}
			},
			// 修改
			editClick(){
				this.$router.push(`/index/yingpinxinxiAdd?type=edit&&id=${this.detail.id}`);
			},
			// 删除
			async delClick(){
				await this.$confirm('是否删除此应聘信息？') .then(_ => {
					this.$http.post('yingpinxinxi/delete', [this.detail.id]).then(async res => {
						if (res.data.code == 0) {
							this.$message({
								type: 'success',
								message: '删除成功!',
								duration: 1500,
								onClose: () => {
									history.back()
								}
							});
						}
					});
				}).catch(_ => {});
			},
		},
		components: {
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.detail-preview {
		padding: 20px 0;
		margin: 0px auto;
		color: #666;
		display: flex;
		width: 1200px;
		font-size: 16px;
		justify-content: space-between;
		align-items: flex-start;
		position: relative;
		flex-wrap: wrap;
		.attr {
			padding: 0;
			background: none;
			flex: 1;
			display: block;
			width: calc(100% - 500px);
			position: relative;
			order: 2;
			.info {
				padding: 0;
				margin: 0;
				background: none;
				width: 100%;
				min-height: 700px;
				.title-item {
					padding: 0;
					margin: 0 auto 15px;
					background: none;
					display: flex;
					line-height: 1.8;
					justify-content: space-between;
					align-items: center;
					.detail-title {
						color: #000;
						font-weight: 500;
						font-size: 20px;
					}
				}
				.item {
					border-radius: 10px 0 10px;
					padding: 3px 0 !important;
					margin: 0 0 15px 0;
					outline: 4px solid #fff;
					background: #fff !important;
					display: flex;
					border-color: #6a11c7 !important;
					border-width: 1px !important;
					justify-content: spaceBetween;
					border-style: solid !important;
					.lable {
						padding: 0 10px;
						color: #333;
						white-space: nowrap;
						font-weight: 500;
						width: auto;
						font-size: inherit;
						line-height: 24px;
						text-align: right;
						height: auto;
					}
					.text {
						padding: 0px 10px 0;
						color: inherit;
						word-break: break-all;
						flex: 1;
						font-size: inherit;
						line-height: 24px;
						height: auto;
					}
					.price {
						color: #f00;
					}
					.bold {
						font-weight: bold;
					}
					.link {
						cursor: pointer;
						text-decoration: underline;
					}
					.uploadBtn {
						border: 1px solid #03abe930;
						border-radius: 4px;
						padding: 0px 10px;
						margin: 5px 0 0;
						color: #03abe9;
						background: none;
						text-decoration: none;
						width: auto;
						font-size: 15px;
						line-height: 28px;
						text-align: center;
						height: 28px;
					}
					.uploadBtn:hover {
					}
				}
				.btn_box {
					padding: 10px 0;
					display: flex;
					font-size: 14px;
					flex-wrap: wrap;
				}
				.editBtn {
					border: 0px solid rgba(64, 158, 255, .3);
					cursor: pointer;
					border-radius: 4px;
					padding: 0 10px;
					margin: 0 5px 0 0;
					color: #fff;
					background: #8020e3;
					width: auto;
					font-size: inherit;
					line-height: 40px;
					height: 40px;
				}
				.editBtn:hover {
				}
				.delBtn {
					border: 0px solid rgba(209, 6, 2, .3);
					cursor: pointer;
					border-radius: 4px;
					padding: 0 10px;
					margin: 0 5px 0 0;
					outline: none;
					color: #fff;
					background: rgba(209, 6, 2, 1);
					width: auto;
					font-size: inherit;
					line-height: 40px;
					height: 40px;
				}
				.delBtn:hover {
				}
				.auditBtn {
					border: 0px solid rgba(209, 6, 2, .3);
					cursor: pointer;
					border-radius: 4px;
					padding: 0 10px;
					margin: 0 5px 0 0;
					outline: none;
					color: #fff;
					background: #da5e32;
					width: auto;
					font-size: inherit;
					line-height: 40px;
					height: 40px;
				}
				.auditBtn:hover {
				}
			}
		}
		.detail-swpier2 {
			margin: 0 40px 20px 0;
			display: block;
			width: 48%;
			text-align: center;
			height: 480px;
			order: 1;
			.swiper21 {
				width: 100%;
				height: auto;
				.swiper-button-prev:after {
					display:none;
				}
				.swiper-button-next:after {
					display:none;
				}
				.swiper-item {
					width: 100%;
					height: auto;
					img {
						object-fit: cover;
						width: 100%;
						height: 600px;
					}
				}
				.swiper-button-prev {
					margin: -12px 0 0;
					top: 50%;
					width: 24px;
					height: 24px;
					.icon {
						color: #fff;
						width: 24px;
						font-size: 24px;
						height: 24px;
					}
				}
				.swiper-button-next {
					margin: -12px 0 0;
					top: 50%;
					width: 24px;
					height: 24px;
					.icon {
						color: #fff;
						width: 24px;
						font-size: 24px;
						height: 24px;
					}
				}
			}
			.swiper22 {
				width: 100%;
				height: auto;
				
				.swiper-button-prev:after {
					display:none;
				}
				.swiper-button-next:after {
					display:none;
				}
				
				.swiper-item {
					width: 100%;
					opacity: 0.4;
					height: auto;
					img {
						object-fit: cover;
						width: 100%;
						height: 100px;
					}
				}
				.swiper-slide.swiper-slide-thumb-active div {
					opacity: 1;
				}
				.swiper-button-prev {
					margin: -7px 0 0;
					top: 50%;
					width: 14px;
					height: 14px;
					.icon {
						color: #fff;
						width: 14px;
						font-size: 14px;
						height: 14px;
					}
				}
				.swiper-button-next {
					margin: -7px 0 0;
					top: 50%;
					width: 14px;
					height: 14px;
					.icon {
						color: #fff;
						width: 14px;
						font-size: 14px;
						height: 14px;
					}
				}
			}
		}
		.detail-tabs {
			border: 1px solid #6a11c7;
			border-radius: 60px 0px 60px 0px;
			box-shadow: 0px 10px 20px 0px rgba(0, 0, 0, 0.25),0px -10px 20px 0px rgba(0, 0, 0, 0.25);
			padding: 30px;
			margin: 30px auto;
			outline: 10px solid #fff;
			background: #fff;
			width: calc(100% - 20px);
			order: 21;
			& /deep/ .el-tabs__header .el-tabs__nav-wrap {
				margin-bottom: 0;
			}
			/deep/ .el-tabs__header {
				border-radius: 56px 0px 0px 0px;
				padding: 20px 20px 20px 40px;
				margin: 0;
				background: #6a11c7;
				border-color: #d1060230;
				border-width: 0 0 0px 0;
				border-style: solid;
			}
			
			/deep/ .el-tabs__header .el-tabs__item {
				border: 0;
				padding: 0 20px;
				margin: 0 5px;
				color: #888;
				font-weight: 500;
				display: inline-block;
				font-size: inherit;
				line-height: 34px;
				transition: all 0s;
				background: #eee;
				position: relative;
				list-style: none;
				height: 34px;
			}
			
			/deep/ .el-tabs__header .el-tabs__item:hover {
				border: 0;
				color: #6a11c7;
				background: #fff;
			}
			
			/deep/ .el-tabs__header .el-tabs__item.is-active {
				border: 0;
				margin: 0 5px;
				color: #6a11c7;
				background: #fff;
				font-size: inherit;
				line-height: 34px;
				height: 34px;
			}
			
			/deep/ .el-tabs__content {
				padding: 15px;
			}
			.commentForm {
				box-shadow: none;
				padding: 0px;
				margin: 20px 0;
				.item {
					padding: 0;
					display: flex;
					width: 100%;
					height: auto;
					/deep/ .el-form-item__label {
						padding: 0 10px 0 0;
						color: #666;
						white-space: nowrap;
						font-weight: 500;
						width: auto;
						font-size: inherit;
						line-height: 40px;
						text-align: right;
					}
					.editor {
						border: 1px solid #ccc;
						border-radius: 4px;
						box-shadow: 0 0 0px rgba(80, 80, 80, .2);
						color: #333;
						background: #fff;
						width: 100%;
						font-size: 14px;
						min-height: 350px;
						line-height: 32px;
						/deep/ .avatar-uploader {
							height: 0;
							line-height: 0;
						}
					}
				}
				.commentBtn {
					padding: 0 0 0 40px;
					margin: 10px 0 0;
					width: 100%;
					text-align: center;
					height: auto;
					.submitBtn {
						border: 0;
						cursor: pointer;
						border-radius: 2px;
						padding: 0 20px 0 25px;
						margin: 0 20px 0 0;
						color: #eee;
						background: #6a11c7;
						width: auto;
						font-size: 15px;
						line-height: 34px;
						min-width: 100px;
						height: 34px;
					}
					.submitBtn:hover {
						opacity: 0.8;
					}
					.resetBtn {
						border: 0;
						cursor: pointer;
						border-radius: 2px;
						padding: 0 20px 0 25px;
						margin: 0 20px 0 0;
						color: #666;
						background: rgb(232, 232, 232);
						width: auto;
						font-size: 15px;
						line-height: 34px;
						min-width: 100px;
						height: 34px;
					}
					.resetBtn:hover {
						opacity: 0.8;
					}
				}
			}
			.comment-list {
				box-shadow: none;
				padding: 0px;
				margin: 40px 0 0;
				display: flex;
				justify-content: space-between;
				flex-wrap: wrap;
				.comment-item {
					padding: 10px;
					margin: 0 0 20px;
					width: 100%;
					border-color: #6a11c750;
					border-width: 1px;
					align-items: center;
					border-style: solid;
					height: auto;
					.istop {
						box-shadow: 0 4px 8px rgba(0,0,0,.1);
						top: 0;
						background: #fff;
						position: absolute;
						right: 10px;
						.icon {
							color: #000;
						}
					}
					.user {
						padding: 5px;
						background: none】;
						display: flex;
						width: 100%;
						align-items: center;
						height: auto;
						.el-image {
							border-radius: 100%;
							margin: 0 10px 0 0;
							object-fit: cover;
							width: 40px;
							height: 40px;
						}
						.name {
							color: #333;
							font-size: 16px;
						}
					}
					.comment-time {
						color: #666;
					}
					.comment-content-box {
						border-radius: 4px;
						padding: 8px;
						margin: 10px 0px 0px;
						word-wrap: break-word;
						color: #666;
						background: none;
						font-size: 14px;
						line-height: 1.5;
						.zancai-box {
							margin: 8px 0 0 0;
							display: flex;
							width: 100%;
							justify-content: flex-end;
							align-items: center;
							height: 30px;
							.zan-item {
								display: flex;
								align-items: center;
								.icon {
								font-size: 14px;
								}
								.label {
								display: none;
								font-size: 14px;
								}
								.num {
								font-size: 14px;
								}
							}
							.zan-item.active {
								background: none;
								.icon {
								color: #ff0000;
								font-size: 14px;
								}
								.label {
								color: #ff0000;
								display: none;
								font-size: 14px;
								}
								.num {
								color: #ff0000;
								font-size: 14px;
								}
							}
							.zan-item:hover {
								opacity: 0.8;
								.icon {
								color: #ff000030;
								}
								.label {
								color: #ff000030;
								}
								.num {
								color: #ff000030;
								}
							}
							.cai-item {
								display: flex;
								align-items: center;
								.icon {
								font-size: 14px;
								}
								.label {
								display: none;
								font-size: 14px;
								}
								.num {
								font-size: 14px;
								}
							}
							.cai-item.active {
								background: none;
								.icon {
								color: #ff0000;
								font-size: 14px;
								}
								.label {
								color: #ff0000;
								display: none;
								font-size: 14px;
								}
								.num {
								color: #ff0000;
								font-size: 14px;
								}
							}
							.cai-item:hover {
								opacity: 0.8;
								.icon {
								color: #ff000030;
								}
								.label {
								color: #ff000030;
								}
								.num {
								color: #ff000030;
								}
							}
						}
						.comment-btn {
							margin: 8px 0 0 0;
							display: flex;
							width: 100%;
							justify-content: flex-end;
							align-items: center;
							height: 40px;
							.delBtn {
								border: 0;
								cursor: pointer;
								padding: 0 20px;
								margin: 0 10px;
								color: #fff;
								font-size: 14px;
								line-height: 32px;
								border-radius: 0px;
								outline: none;
								background: #eea189;
								width: auto;
								min-width: 80px;
								height: 32px;
							}
						}
					}
				}
			}
			.el-rate {
				border-radius: 4px;
				padding: 0 10px;
				background: none;
				width: 100%;
				line-height: 40px;
				height: 40px;
				/deep/ .el-rate__item {
					cursor: pointer;
					display: inline-block;
					vertical-align: middle;
					font-size: 0;
					position: relative;
				}
				
				/deep/ .el-rate__item .el-rate__icon {
					margin: 0 3px;
					display: block;
					font-size: 18px;
					position: relative;
					transition: .3s;
				}
			}
		}
	}
	.share_view{
		box-shadow: 0 1px 6px rgba(0,0,0,.3);
		z-index: 11;
		bottom: 20%;
		background: #fff;
		position: fixed;
		right: 0;
		.share:last-of-type{
			border:none;
		}
	}
	.idea1 {
		background: none;
		width: 100%;
		height: 1px;
		order: 4;
	}
	.idea2 {
		background: none;
		width: 100%;
		height: 1px;
		order: 6;
	}
</style>
