<template>
	<div class="navbar">
		<div class="title">
			<span class="title-name">{{this.$project.projectName}}</span>
		</div>
		<!-- 系统通知-2 -->
		<div id="div1">
			<div>公告</div>
			<ul>
				<li class="ql-snow ql-editor" v-html="noticeDetail.content"></li>
			</ul>
		</div>
		<el-dropdown class="dropdown-box" @command="handleCommand" trigger="click">
			<div class="el-dropdown-link">
				<el-image v-if="avatar" :src="avatar?this.$base.url + avatar : require('@/assets/img/avator.png')" fit="cover"></el-image>
				<span class="label">欢迎您，</span>
				<span class="nickname">{{this.$storage.get('adminName')}}</span>
				<span class="icon iconfont icon-xiala"></span>
			</div>
			<el-dropdown-menu class="top-el-dropdown-menu" slot="dropdown">
				<el-dropdown-item class="item1" :command="''">
					<span class="icon iconfont icon-home19"></span>
					首页
				</el-dropdown-item>
				<el-dropdown-item class="item2" :command="'center'">
					<span class="icon iconfont icon-touxiang03"></span>
					个人中心
				</el-dropdown-item>
				<el-dropdown-item v-if="this.$storage.get('role')!='管理员'" class="item3" :command="'front'">
					<span class="icon iconfont icon-fanhui12"></span>
					退出到前台
				</el-dropdown-item>
				<el-dropdown-item class="item4" :command="'logout'">
					<span class="icon iconfont icon-fanhui13"></span>
					退出登录
				</el-dropdown-item>
			</el-dropdown-menu>
		</el-dropdown>
	</div>
</template>

<script>
	import {
		Loading
	} from 'element-ui';
	import axios from 'axios';
	export default {
		data() {
			return {
				dialogVisible: false,
				ruleForm: {},
				user: null,
				// 系统公告
				noticeDetail: {},
			};
		},
		created() {
			// 系统公告
			this.getNotice()
		},
		computed: {
			avatar(){
				return this.$storage.get('headportrait')?this.$storage.get('headportrait'):''
			},
		},
		mounted() {
		},
		methods: {
			// 获取系统公告
			getNotice() {
				this.$http({
					url: '/systemnotice/detail/1',
					method: "get"
				}).then(({data})=>{
					if ( data && data.code==0 ) {
						this.noticeDetail = data.data
						this.$nextTick(() => {
							this.notice()
						})
					}
				})
			},
			notice() {
				var oDiv = document.getElementById('div1');
				var oUl = oDiv.getElementsByTagName('ul')[0];
				var aLi = oUl.getElementsByTagName('li');
				var speed = 5;
				oUl.innerHTML = oUl.innerHTML + oUl.innerHTML;
				oUl.style.width = aLi[0].offsetWidth * aLi.length + 'px';
				
				function move() {
					if (oUl.offsetLeft < -oUl.offsetWidth / 2) { //因为第一个offsetLeft可能是负数，所以要加一个负号
						oUl.style.left = '0';
					}
					if (oUl.offsetLeft > 0) {
						oUl.style.left = -oUl.offsetWidth / 2 + 'px';
					}
					oUl.style.left = oUl.offsetLeft - speed + 'px';
				}
				this.timer = setInterval(move, 100);
			
				oDiv.addEventListener('mouseenter', e => {
					e.stopPropagation()
					clearInterval(this.timer);
				})
				oDiv.addEventListener('mouseleave', e => {
					e.stopPropagation()
					this.timer = setInterval(move, 100);
				})
			},
			handleCommand(name) {
				if (name == 'logout') {
					this.onLogout()
				} 
				else if (name == 'front') {
					this.onIndexTap()
				}
				else {
					let router = this.$router
					name = '/'+name
					router.push(name)
				}
			},
			onLogout() {
				let storage = this.$storage
				let router = this.$router
				storage.clear()
				this.$store.dispatch('tagsView/delAllViews')
				router.replace({
					name: "login"
				});
			},
			onIndexTap(){
				localStorage.setItem("frontToken", localStorage.getItem("Token"));
				localStorage.setItem("frontRole", localStorage.getItem("role"));
				localStorage.setItem("frontSessionTable", localStorage.getItem("sessionTable"));
				localStorage.setItem("frontHeadportrait", localStorage.getItem("headportrait"));
				localStorage.setItem("UserTableName", localStorage.getItem("sessionTable"));
				localStorage.setItem("frontUserid", localStorage.getItem("userid"));
				localStorage.setItem("username", localStorage.getItem("adminName"));
				window.location.href = `${this.$base.indexUrl}`
			},
		}
	};
</script>


<style lang="scss" scoped>
	.navbar {
		.title {
			flex: 1 1 auto;
			display: flex;
			justify-content: flex-start;
			order: 1;
			.title-name {
				padding: 0;
				color: #fff;
				font-weight: 700;
				font-size: 24px;
				line-height: 44px;
				float: left;
			}
		}
		#div1 {
			margin: 0;
			overflow: hidden;
			background: none;
			flex: 0 0 auto;
			width: 250px;
			position: relative;
			order: 4;
			div {
				padding:  0 10px 0 30px;
				z-index: 1;
				color: #fff;
				background: url(http://codegen.caihongy.cn/20241012/dd206481ed8242d8ba4d4ebc5797eef7.webp) no-repeat 0,#62A0DC;
				display: inline-block;
				font-size: 16px;
				line-height: 40px;
				position: relative;
			}
			ul {
				top: 0;
				left: 0;
				position: absolute;
				
				li {
					padding: 0;
					color: #fff;
					width: 250px;
					font-size: 16px;
					line-height: 40px;
					float: left;
					list-style: none;
				}
			}
		}
		.dropdown-box {
			color: #fff;
			flex: 0 0 auto;
			display: flex;
			font-size: inherit;
			right: 20px;
			order: 5;
			.el-dropdown-link {
				display: flex;
				align-items: center;
				.el-image {
					border-radius: 100%;
					margin: 0 10px;
					object-fit: cover;
					display: inline-block;
					width: 42px;
					height: 42px;
				}
				.label {
					color: inherit;
					font-size: 15px;
					line-height: 32px;
				}
				.nickname {
					color: inherit;
					font-size: inherit;
					line-height: 32px;
				}
				.iconfont {
					margin: 0 0 0 5px;
					color: rgba(255,255,255,.6);
					font-size: 14px;
				}
			}
			.top-el-dropdown-menu {
				border: 1px solid #EBEEF5;
				border-radius: 4px;
				padding: 10px 0;
				box-shadow: 0 2px 12px 0 rgba(0,0,0,.1);
				margin: 18px 0;
				background: #FFF;
				li.el-dropdown-menu__item.item1 {
					cursor: pointer;
					padding: 0 20px;
					margin: 0;
					outline: 0;
					color: #606266;
					background: #fff;
					font-size: 14px;
					line-height: 36px;
					list-style: none;
					.iconfont {
						margin: 0 4px 0 0;
							color: #000;
							font-size: 14px;
						}
				}
				li.el-dropdown-menu__item.item1:hover {
					background: #ecf5ff;
				}
				li.el-dropdown-menu__item.item2 {
					cursor: pointer;
					padding: 0 20px;
					margin: 0;
					outline: 0;
					color: #606266;
					background: #fff;
					font-size: 14px;
					line-height: 36px;
					list-style: none;
					.iconfont {
						margin: 0 4px 0 0;
							color: #000;
							font-size: 14px;
						}
				}
				li.el-dropdown-menu__item.item2:hover {
					background: #ecf5ff;
				}
				li.el-dropdown-menu__item.item3 {
					cursor: pointer;
					padding: 0 20px;
					margin: 0;
					outline: 0;
					color: #606266;
					background: #fff;
					font-size: 14px;
					line-height: 36px;
					list-style: none;
					.iconfont {
						margin: 0 4px 0 0;
						color: #000;
						font-size: 14px;
					}
				}
				li.el-dropdown-menu__item.item3:hover {
					background: #ecf5ff;
				}
				li.el-dropdown-menu__item.item4 {
					cursor: pointer;
					padding: 0 20px;
					margin: 0;
					color: #606266;
					background: #fff;
					font-size: 14px;
					line-height: 36px;
					list-style: none;
					.iconfont {
						margin: 0 4px 0 0;
						color: #000;
						font-size: 14px;
					}
				}
				li.el-dropdown-menu__item.item4:hover {
					background: #ecf5ff;
				}
			}
		}
	}
</style>
