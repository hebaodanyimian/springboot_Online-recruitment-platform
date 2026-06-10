<template>
	<div>
		<div class="breadcrumb-preview">
			<el-breadcrumb :separator="''">
				<el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
				<el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index"><a>{{item.name}}</a></el-breadcrumb-item>
			</el-breadcrumb>
		</div>
	
		<div class="news-preview-pv">
			<el-form :inline="true" :model="formSearch" class="list-form-pv">
				<el-form-item class="search-item">
					<el-input v-model="title" placeholder="标题"></el-input>
				</el-form-item>
				<el-button class="search-btn" type="primary" @click="getNewsList(1)">
					<span class="icon iconfont icon-chakan5"></span>
					搜索
				</el-button>
			</el-form>
			
			<!-- category -->
			<div class="category-list">
				<div class="item" @click="categoryClick(0)" :class="categoryIndex == 0 ? 'active' : ''">全部</div>
				<div v-for="(item,index) in categoryList" @click="categoryClick(index+1)" :key="index" class="item" :class="categoryIndex == index+1 ? 'active' : ''">{{item.typename}}</div>
			</div>
			<div class="list10 index-pv1">
				<div v-for="(item,index) in newsList" :key="index" class="list-item animation-box" @click="toNewsDetail(item)">
					<div class="img">
						<img class="image" :src="baseUrl + item.picture" >
					</div>
					<div class="infoBox">
						<div class="infoLeft">
							<div class="name">{{item.title}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{item.addtime.split(' ')[0]}}</span>
							</div>
							<div class="publisher_item">
								<span class="icon iconfont icon-touxiang18"></span>
								<span class="label">发布人：</span>
								<span class="text">{{item.name}}</span>
							</div>
							<div class="like_item">
								<span class="icon iconfont icon-zan10"></span>
								<span class="label">点赞：</span>
								<span class="text">{{item.thumbsupnum}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏：</span>
								<span class="text">{{item.storeupnum}}</span>
							</div>
							<div class="view_item">
								<span class="icon iconfont icon-chakan2"></span>
								<span class="label">浏览次数：</span>
								<span class="text">{{item.clicknum}}</span>
							</div>
						</div>
						<div class="desc">{{item.introduction}}</div>
					</div>
				</div>
			</div>
		
			<el-pagination
				background
				id="pagination" class="pagination"
				:pager-count="7"
				:page-size="pageSize"
				:page-sizes="pageSizes"
				prev-text="上一页"
				next-text="下一页"
				:hide-on-single-page="false"
				:layout='["total","prev","pager","next","sizes","jumper"].join()'
				:total="total"
				@current-change="curChange"
				@size-change="sizeChange"
				@prev-click="prevClick"
				@next-click="nextClick"
				></el-pagination>

			<!-- 热门信息 -->
			<div class="hot">
				<div class="hot-title">热门信息</div>
				<div class="hot-list">
					<div class="hot-item" v-for="item in hotList" :key="item.id" @click="toNewsDetail(item)">
						<img :src="baseUrl + item.picture" alt="">
						<div class="hot-name">{{ item.title }}</div>
						<div class="hot-time">{{item.addtime}}</div>
					</div>
				</div>
			</div>
			<div class="idea1"></div>
		</div>
	</div>
</template>

<script>
	export default {
		//数据集合
		data() {
			return {
				baseUrl: this.$config.baseUrl,
				breadcrumbItem: [
				  {
					name: '公告信息'
				  }
				],
				newsList: [],
				total: 1,
				pageSize: 10,
				pageSizes: [],
				totalPage: 1,
				layouts: '',
				title: '',
				categoryIndex: 0,
				categoryList: [],
				hotList: [],
			}
		},
		created() {
			this.getCategoryList()
			
			this.getHotList()
		},
		watch:{
			$route(newValue){
				this.getCategoryList()
			}
		},
		//方法集合
		methods: {
			getCategoryList(){
				this.$http.get('newstype/list', {params: {sort: 'typename',order: 'desc'}}).then(res => {
					if (res.data.code == 0) {
						this.categoryList = res.data.data.list;
						if(this.$route.query.homeFenlei){
							for(let i=0;i<this.categoryList.length;i++) {
								if(this.$route.query.homeFenlei == this.categoryList[i].typename) {
									this.categoryIndex = i + 1;
									const currentRoute = this.$route;
									const routeWithoutQuery = { ...currentRoute };
									delete routeWithoutQuery.query;
									this.$router.replace(routeWithoutQuery)
									break;
								}
							}
						}
						this.getNewsList(1);
					}
				});
			},
			categoryClick(index) {
				this.categoryIndex = index
				this.getNewsList()
			},
			getNewsList(page) {
				let params = {page, limit: this.pageSize,sort:'addtime',order:'desc'};
				let searchWhere = {};
				if(this.title != '') searchWhere.title = '%' + this.title + '%';
				if(this.categoryIndex!=0){
					searchWhere.typename = this.categoryList[this.categoryIndex - 1].typename
				}
				this.$http.get('news/list', {params: Object.assign(params, searchWhere)}).then(res => {
					if (res.data.code == 0) {
						this.newsList = res.data.data.list;
						this.total = res.data.data.total;
						this.pageSize = Number(res.data.data.pageSize);
						this.totalPage = res.data.data.totalPage;
						if(this.pageSizes.length==0){
							this.pageSizes = [this.pageSize, this.pageSize*2, this.pageSize*3, this.pageSize*5];
						}
					}
				});
			},
			getHotList(){
				let params = {page:1, limit: 4,sort:'addtime',order:'desc'};
				this.$http.get('news/autoSort', {params: params}).then(res => {
					if (res.data.code == 0) {
						this.hotList = res.data.data.list;
					}
				});
			},
			curChange(page) {
				this.getNewsList(page);
			},
			sizeChange(size){
				this.pageSize = size
				this.getNewsList(1);
			},
			prevClick(page) {
				this.getNewsList(page);
			},
			nextClick(page) {
				this.getNewsList(page);
			},
			toNewsDetail(item) {
				this.$router.push({path: '/index/newsDetail', query: {id: item.id}});
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.news-preview-pv {
				margin: 0px auto;
				color: #333;
				background: none;
				display: flex;
				width: 1200px;
				font-size: 16px;
				justify-content: flex-start;
				align-items: flex-start;
				position: relative;
				flex-wrap: wrap;
				.list-form-pv {
						padding: 10px;
						background: none;
						display: flex;
						width: 100%;
						justify-content: center;
						align-items: center;
						flex-wrap: wrap;
						height: auto;
						.search-item {
								margin: 0 0px;
								.el-input {
										width: 100%;
									}
				.el-input /deep/ .el-input__inner {
										border: 1px solid #6a11c7;
										border-radius: 0px 0 0 0px;
										padding: 0 10px;
										margin: 0;
										color: #333;
										width: auto;
										font-size: 16px;
										border-width: 1px 0 1px 1px;
										line-height: 42px;
										min-width: 350px;
										height: 42px;
									}
			}
			.search-btn {
								cursor: pointer;
								border: 0;
								border-radius: 0 0px 0px 0;
								padding: 0px 15px;
								margin: 0 10px 0 0;
								color: #fff;
								background: #6a11c7;
								width: auto;
								font-size: inherit;
								line-height: 42px;
								height: 42px;
								.icon {
										margin: 0 3px 0 0;
										color: #fff;
										font-size: inherit;
									}
			}
		}
		.category-list {
						padding: 0px;
						margin: 30px 0px 0 0;
						background: none;
						display: flex;
						width: 100%;
						flex-wrap: wrap;
						height: auto;
						order: 3;
						.item {
								cursor: pointer;
								border: 1px solid #6a11c7;
								padding: 10px 20px 10px 26px;
								margin: 0 20px 20px 0;
								color: inherit;
								display: flex;
								font-size: 16px;
								flex-wrap: wrap;
								border-radius: 10px 0 10px;
								outline: 6px solid #fff;
								background: #fff;
								justify-content: center;
								align-items: center;
								min-width: 110px;
							}
			
			.item:hover {
								color: #fff;
								background: #6a11c7;
							}
			
			.item.active {
								color: #fff;
								background: #6a11c7;
								font-size: 16px;
							}
		}
		.list10 {
						padding: 0;
						margin: 20px 0 0;
						color: #666;
						background: none;
						display: flex;
						width: 100%;
						font-size: 14px;
						justify-content: space-between;
						flex-wrap: wrap;
						height: auto;
						order: 8;
						.list-item {
								cursor: pointer;
								border: 1px solid #fff;
								padding: 20px;
								margin: 0 0 20px;
								background: #fff;
								display: flex;
								width: 49%;
								position: relative;
								flex-wrap: wrap;
								height: auto;
								.img {
										padding: 0;
										overflow: hidden;
										width: 100%;
										height: 250px;
										img {
												object-fit: cover;
												display: block;
												width: 100%;
												height: 100%;
											}
				}
				.infoBox {
										padding: 30px 0 0;
										overflow: hidden;
										display: flex;
										width: 100%;
										position: relative;
										flex-wrap: wrap;
										height: auto;
										.infoLeft {
												padding: 20px 0 0;
												width: 100%;
												order: 5;
												.name {
														padding: 0;
														overflow: hidden;
														color: #333;
														top: 5px;
														white-space: nowrap;
														font-weight: 600;
														display: inline-block;
														width: 100%;
														font-size: 16px;
														line-height: 30px;
														text-overflow: ellipsis;
														position: absolute;
													}
						.time_item {
														padding: 0 10px 0 0;
														display: inline-block;
														.icon {
																margin: 0 2px 0 0;
																display: inline-block;
																line-height: 28px;
															}
							.label {
																display: none;
																line-height: 1.5;
															}
							.text {
																line-height: 1.5;
															}
						}
						.publisher_item {
														padding: 0 10px 0 0;
														display: inline-block;
														.icon {
																margin: 0 2px 0 0;
																display: inline-block;
																line-height: 28px;
															}
							.label {
																display: none;
																line-height: 1.5;
															}
							.text {
																line-height: 28px;
															}
						}
						.like_item {
														padding: 0 10px 0 0;
														display: inline-block;
														.icon {
																margin: 0 2px 0 0;
																display: inline-block;
																line-height: 28px;
															}
							.label {
																display: none;
																line-height: 1.5;
															}
							.text {
																line-height: 28px;
															}
						}
						.collect_item {
														padding: 0 10px 0 0;
														display: inline-block;
														.icon {
																margin: 0 2px 0 0;
																display: inline-block;
																line-height: 28px;
															}
							.label {
																display: none;
																line-height: 1.5;
															}
							.text {
																line-height: 28px;
															}
						}
						.view_item {
														padding: 0 10px 0 0;
														display: inline-block;
														.icon {
																margin: 0 2px 0 0;
																display: inline-block;
																line-height: 28px;
															}
							.label {
																display: none;
																line-height: 1.5;
															}
							.text {
																line-height: 28px;
															}
						}
					}
					.desc {
												margin: 10px 0 0;
												overflow: hidden;
												color: #666;
												width: 100%;
												font-size: 14px;
												line-height: 24px;
												height: 48px;
											}
				}
			}
			.list-item:hover {
								border: 1px solid #6a11c7;
								background: none;
								.infoBox {
					.infoLeft {
						.name {
														color: #6a11c7;
													}
						.time_item {
							.icon {
															}
							.label {
															}
							.text {
															}
						}
						.publisher_item {
							.icon {
															}
							.label {
															}
							.text {
															}
						}
						.like_item {
							.icon {
															}
							.label {
															}
							.text {
															}
						}
						.collect_item {
							.icon {
															}
							.label {
															}
							.text {
															}
						}
						.view_item {
							.icon {
															}
							.label {
															}
							.text {
															}
						}
					}
					.desc {
											}
				}
			}
		}
		.hot {
						margin: 20px 0 0;
						background: none;
						width: 100%;
						height: auto;
						order: 80;
						.hot-title {
								padding: 0 0 0 60px;
								margin: 0 auto 10px;
								color: #5d62de;
								background: url(http://codegen.caihongy.cn/20250210/9a0a40c774bc481ca705fcfea9996859.png) no-repeat left center / 100% 100%;
								font-weight: 600;
								width: 100%;
								font-size: 26px;
								line-height: 30px;
								position: relative;
								text-align: left;
								height: 40px;
							}
			.hot-list {
								padding: 0;
								margin: 30px 0 0 -10px;
								background: none;
								display: flex;
								width: 1220px;
								justify-content: space-between;
								flex-wrap: wrap;
								height: auto;
								.hot-item {
										cursor: pointer;
										border: 1px solid #6a11c7;
										border-radius: 10px 0 10px;
										padding: 10px;
										margin: 0 20px 20px;
										outline: 6px solid #fff;
										background: #fff;
										width: calc(25% - 40px);
										height: auto;
										img {
												margin: 0 0 5px;
												object-fit: cover;
												display: block;
												width: 100%;
												height: 160px;
											}
					.hot-name {
												padding: 0px 5px 0;
												overflow: hidden;
												color: #333;
												white-space: nowrap;
												width: calc(100% - 0px);
												font-size: 15px;
												line-height: 24px;
												text-overflow: ellipsis;
											}
					.hot-time {
												padding: 0 5px;
												color: #999;
												display: inline-block;
												width: calc(100% - 0px);
												font-size: 14px;
												line-height: 24px;
												text-align: right;
											}
				}
			}
		}
		.idea1 {
						background: none;
						width: 100%;
						height: 1px;
						order: 10;
					}
	}
	
	.index-pv1 .animation-box {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
		z-index: initial;
	}
	
	.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
	}
	
	.index-pv1 .animation-box img {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
	}
	
	.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(0.99) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
</style>
