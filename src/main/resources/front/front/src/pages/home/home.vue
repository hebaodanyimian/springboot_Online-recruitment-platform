<template>
	<div class="home-preview">




		<!-- 新闻资讯 -->
		<div id="animate_newsnews" class="news animate__animated">
			<div class="news_title_box">
				<span class="news_title">公告信息</span>
				<span class="news_subhead">{{'news'.toUpperCase()}}</span>
			</div>
			<div v-if="newsList.length" class="list list17 index-pv1">
				<div class="swiper">
					<div class="swiper-container newsSwiper17 new-list-17news">
						<div class="swiper-wrapper">
							<template v-for="(item,index) in newsList">
								<div v-if="index < 3" class="swiper-slide">
									<div class="list-item" @click="toDetail('newsDetail', item)">
										<img :src="baseUrl + item.picture">
										<div class="infoBox">
											<div class="name">{{item.title}}</div>
											<div class="time">
												<span class="icon iconfont icon-shijian21"></span>
												<span class="label">发布时间：</span>
												<span class="text">{{item.addtime.split(' ')[0]}}</span>
											</div>
										</div>
									</div>
								</div>
							</template>
						</div>
						<!-- Add Pagination -->
						<div class="swiper-pagination"></div>
					</div>
				</div>
				<div class="right">
					<div class="top-list-item" v-if="newsList.length > 3" @click="toDetail('newsDetail', newsList[3])">
						<div class="name">{{newsList[3].title}}</div>
						<div class="desc">{{newsList[3].introduction}}</div>
						<div class="time_item">
							<span class="icon iconfont icon-shijian21"></span>
							<span class="label">发布时间：</span>
							<span class="text">{{newsList[3].addtime.split(' ')[0]}}</span>
						</div>
						<div class="publisher_item">
							<span class="icon iconfont icon-geren16"></span>
							<span class="label">发布人：</span>
							<span class="text">{{newsList[3].name}}</span>
						</div>
						<div class="like_item">
							<span class="icon iconfont icon-zan10"></span>
							<span class="label">点赞：</span>
							<span class="text">{{newsList[3].thumbsupnum}}</span>
						</div>
						<div class="collect_item">
							<span class="icon iconfont icon-shoucang10"></span>
							<span class="label">收藏：</span>
							<span class="text">{{newsList[3].storeupnum}}</span>
						</div>
						<div class="view_item">
							<span class="icon iconfont icon-chakan2"></span>
							<span class="label">浏览次数：</span>
							<span class="text">{{newsList[3].clicknum}}</span>
						</div>
					</div>
					<div class="list-body">
						<template v-for="(item,index) in newsList">
							<div class="list-item" v-if="index > 3" @click="toDetail('newsDetail', item)">
								<div class="dian"></div>
								<div class="name">{{item.title}}</div>
								<div class="time">
									<span class="icon iconfont icon-shijian21"></span>
									<span class="label">发布时间：</span>
									<span class="text">{{item.addtime.split(' ')[0]}}</span>
								</div>
							</div>
						</template>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('news')">
				<span class="text">MORE+</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 新闻资讯 -->
		<!-- 商品推荐 -->
		<div id="animate_recommendzhaopinxinxi" class="recommend animate__animated">
			<div class="recommend_title_box">
				<span class="recommend_title">招聘信息推荐</span>
				<span class="recommend_subhead">{{'zhaopinxinxi'.toUpperCase()}} RECOMMEND</span>
			</div>
			<!-- 样式四 -->
			<div class="list list4 index-pv1">
				<div v-if="zhaopinxinxiRecommend.length>0" class="list-item animation-box" @click="toDetail('zhaopinxinxiDetail', zhaopinxinxiRecommend[0])">
					<img v-if="preHttp(zhaopinxinxiRecommend[0].zhaopinfengmian)" :src="zhaopinxinxiRecommend[0].zhaopinfengmian.split(',')[0]" alt="" />
					<img v-else :src="baseUrl + (zhaopinxinxiRecommend[0].zhaopinfengmian?zhaopinxinxiRecommend[0].zhaopinfengmian.split(',')[0]:'')" alt="" />
					<div class="infoBox">
						<div class="name">{{zhaopinxinxiRecommend[0].qiyemingcheng}}</div>
						<div class="name">{{zhaopinxinxiRecommend[0].zhiweileixing}}</div>
						<div class="name">{{zhaopinxinxiRecommend[0].xinzifanwei}}</div>
						<div class="name">{{zhaopinxinxiRecommend[0].suoshuxingye}}</div>
						<div class="name">{{zhaopinxinxiRecommend[0].fulidaiyu}}</div>
						<div class="name">{{zhaopinxinxiRecommend[0].gongsidizhi}}</div>
						<div class="name">{{zhaopinxinxiRecommend[0].faburiqi}}</div>
						<div class="time_item">
							<span class="icon iconfont icon-shijian21"></span>
							<span class="label">发布时间：</span>
							<span class="text">{{zhaopinxinxiRecommend[0].addtime.split(' ')[0]}}</span>
						</div>
						<div class="publisher_item">
							<span class="icon iconfont icon-touxiang18"></span>
							<span class="label">发布人：</span>
							<span class="text">{{zhaopinxinxiRecommend[0].gonghao}}</span>
						</div>
						<div class="collect_item">
							<span class="icon iconfont icon-shoucang10"></span>
							<span class="label">收藏：</span>
							<span class="text">{{zhaopinxinxiRecommend[0].storeupnum}}</span>
						</div>
					</div>
				</div>
				<div class="list-body1">
					<div v-if="zhaopinxinxiRecommend.length>1" @click="toDetail('zhaopinxinxiDetail', zhaopinxinxiRecommend[1])" class="list-item1 animation-box">
						<img v-if="preHttp(zhaopinxinxiRecommend[1].zhaopinfengmian)" :src="zhaopinxinxiRecommend[1].zhaopinfengmian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (zhaopinxinxiRecommend[1].zhaopinfengmian?zhaopinxinxiRecommend[1].zhaopinfengmian.split(',')[0]:'')" alt="" />
						<div class="infoBox">
							<div class="name">{{zhaopinxinxiRecommend[1].qiyemingcheng}}</div>
							<div class="name">{{zhaopinxinxiRecommend[1].zhiweileixing}}</div>
							<div class="name">{{zhaopinxinxiRecommend[1].xinzifanwei}}</div>
							<div class="name">{{zhaopinxinxiRecommend[1].suoshuxingye}}</div>
							<div class="name">{{zhaopinxinxiRecommend[1].fulidaiyu}}</div>
							<div class="name">{{zhaopinxinxiRecommend[1].gongsidizhi}}</div>
							<div class="name">{{zhaopinxinxiRecommend[1].faburiqi}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{zhaopinxinxiRecommend[1].addtime.split(' ')[0]}}</span>
							</div>
							<div class="publisher_item">
								<span class="icon iconfont icon-touxiang18"></span>
								<span class="label">发布人：</span>
								<span class="text">{{zhaopinxinxiRecommend[1].gonghao}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏：</span>
								<span class="text">{{zhaopinxinxiRecommend[1].storeupnum}}</span>
							</div>
						</div>
					</div>
					<div v-if="zhaopinxinxiRecommend.length>2" @click="toDetail('zhaopinxinxiDetail', zhaopinxinxiRecommend[2])" class="list-item2 animation-box">
						<img v-if="preHttp(zhaopinxinxiRecommend[2].zhaopinfengmian)" :src="zhaopinxinxiRecommend[2].zhaopinfengmian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (zhaopinxinxiRecommend[2].zhaopinfengmian?zhaopinxinxiRecommend[2].zhaopinfengmian.split(',')[0]:'')" alt="" />
						<div class="infoBox">
							<div class="name">{{zhaopinxinxiRecommend[2].qiyemingcheng}}</div>
							<div class="name">{{zhaopinxinxiRecommend[2].zhiweileixing}}</div>
							<div class="name">{{zhaopinxinxiRecommend[2].xinzifanwei}}</div>
							<div class="name">{{zhaopinxinxiRecommend[2].suoshuxingye}}</div>
							<div class="name">{{zhaopinxinxiRecommend[2].fulidaiyu}}</div>
							<div class="name">{{zhaopinxinxiRecommend[2].gongsidizhi}}</div>
							<div class="name">{{zhaopinxinxiRecommend[2].faburiqi}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{zhaopinxinxiRecommend[2].addtime.split(' ')[0]}}</span>
							</div>
							<div class="publisher_item">
								<span class="icon iconfont icon-touxiang18"></span>
								<span class="label">发布人：</span>
								<span class="text">{{zhaopinxinxiRecommend[2].gonghao}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏：</span>
								<span class="text">{{zhaopinxinxiRecommend[2].storeupnum}}</span>
							</div>
						</div>
					</div>
				</div>
				<div class="list-body2">
					<div v-if="zhaopinxinxiRecommend.length>3" @click="toDetail('zhaopinxinxiDetail', zhaopinxinxiRecommend[3])" class="list-item1 animation-box">
						<img v-if="preHttp(zhaopinxinxiRecommend[3].zhaopinfengmian)" :src="zhaopinxinxiRecommend[3].zhaopinfengmian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (zhaopinxinxiRecommend[3].zhaopinfengmian?zhaopinxinxiRecommend[3].zhaopinfengmian.split(',')[0]:'')" alt="" />
						<div class="infoBox">
							<div class="name">{{zhaopinxinxiRecommend[3].qiyemingcheng}}</div>
							<div class="name">{{zhaopinxinxiRecommend[3].zhiweileixing}}</div>
							<div class="name">{{zhaopinxinxiRecommend[3].xinzifanwei}}</div>
							<div class="name">{{zhaopinxinxiRecommend[3].suoshuxingye}}</div>
							<div class="name">{{zhaopinxinxiRecommend[3].fulidaiyu}}</div>
							<div class="name">{{zhaopinxinxiRecommend[3].gongsidizhi}}</div>
							<div class="name">{{zhaopinxinxiRecommend[3].faburiqi}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{zhaopinxinxiRecommend[3].addtime.split(' ')[0]}}</span>
							</div>
							<div class="publisher_item">
								<span class="icon iconfont icon-geren16"></span>
								<span class="label">发布人：</span>
								<span class="text">{{zhaopinxinxiRecommend[3].gonghao}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏：</span>
								<span class="text">{{zhaopinxinxiRecommend[3].storeupnum}}</span>
							</div>
						</div>
					</div>
					<div v-if="zhaopinxinxiRecommend.length>4" @click="toDetail('zhaopinxinxiDetail', zhaopinxinxiRecommend[4])" class="list-item2 animation-box">
						<img v-if="preHttp(zhaopinxinxiRecommend[4].zhaopinfengmian)" :src="zhaopinxinxiRecommend[4].zhaopinfengmian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (zhaopinxinxiRecommend[4].zhaopinfengmian?zhaopinxinxiRecommend[4].zhaopinfengmian.split(',')[0]:'')" alt="" />
						<div class="infoBox">
							<div class="name">{{zhaopinxinxiRecommend[4].qiyemingcheng}}</div>
							<div class="name">{{zhaopinxinxiRecommend[4].zhiweileixing}}</div>
							<div class="name">{{zhaopinxinxiRecommend[4].xinzifanwei}}</div>
							<div class="name">{{zhaopinxinxiRecommend[4].suoshuxingye}}</div>
							<div class="name">{{zhaopinxinxiRecommend[4].fulidaiyu}}</div>
							<div class="name">{{zhaopinxinxiRecommend[4].gongsidizhi}}</div>
							<div class="name">{{zhaopinxinxiRecommend[4].faburiqi}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{zhaopinxinxiRecommend[4].addtime.split(' ')[0]}}</span>
							</div>
							<div class="publisher_item">
								<span class="icon iconfont icon-geren16"></span>
								<span class="label">发布人：</span>
								<span class="text">{{zhaopinxinxiRecommend[4].gonghao}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏：</span>
								<span class="text">{{zhaopinxinxiRecommend[4].storeupnum}}</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('zhaopinxinxi')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 商品推荐 -->
	</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

	export default {
		//数据集合
		data() {
			return {
				baseUrl: '',
				newsList: [],
				zhaopinxinxiRecommend: [],


				newListSwiper17news: null,



			}
		},
		created() {
			this.baseUrl = this.$config.baseUrl;
			this.getNewsList();
			this.getList();
		},
		mounted() {
			window.addEventListener('scroll', this.handleScroll)
			setTimeout(()=>{
				this.handleScroll()
			},100)
			
			this.swiperChanges()
		},
		beforeDestroy() {
			window.removeEventListener('scroll', this.handleScroll)
		},
		//方法集合
		methods: {
			swiperChanges() {
				if (this['newListSwiper17news']) this['newListSwiper17news'].destroy()
				setTimeout(()=>{
					this['newListSwiper17news'] = new Swiper(".new-list-17news", {"pagination":{"el":".swiper-pagination","clickable":true}})
				},750)
			},


			handleScroll() {
				let arr = [
					{id:'about',css:'animate__'},
					{id:'system',css:'animate__'},
					{id:'animate_recommendzhaopinxinxi',css:'animate__'},
					{id:'animate_newsnews',css:'animate__'},
				]
			
				for (let i in arr) {
					let doc = document.getElementById(arr[i].id)
					if (doc) {
						let top = doc.offsetTop
						let win_top = window.innerHeight + window.pageYOffset
						// console.log(top,win_top)
						if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
							// console.log(doc)
							doc.classList.add(arr[i].css)
						}
					}
				}
			},
			preHttp(str) {
				return str && str.substr(0,4)=='http';
			},
			preHttp2(str) {
				return str && str.split(',w').length>1;
			},
			getNewsList() {
				let data = {
					page: 1,
					limit: 8,
					sort: 'addtime',
					order: 'desc'
				}
				this.$http.get('news/list', {params: data}).then(res => {
					if (res.data.code == 0) {
						this.newsList = res.data.data.list;
					
					}
				});
			},
			getList() {
				let autoSortUrl = "";
				let data = {}
				autoSortUrl = "zhaopinxinxi/autoSort";
				if(localStorage.getItem('frontToken')) {
					autoSortUrl = "zhaopinxinxi/autoSort2";
				}
				data = {
					page: 1,
					limit: 5,
				}
				data['sfsh'] = '是'
				this.$http.get(autoSortUrl, {params: data}).then(res => {
					if (res.data.code == 0) {
						this.zhaopinxinxiRecommend = res.data.data.list;
					}
				});
			
			},
			toDetail(path, item) {
				this.$router.push({path: '/index/' + path, query: {id: item.id}});
			},
			moreBtn(path) {
				this.$router.push({path: '/index/' + path});
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		margin: 0px auto;
		flex-direction: column;
		background: #fff;
		display: flex;
		width: 100%;
		.news {
			padding: 40px 0;
			margin: 20px auto;
			background: #f4f5fc;
			width: 100%;
			position: relative;
			order: 4;
			.news_title_box {
				padding: 0 0 0 60px;
				margin: 0 auto 10px;
				background: url(http://codegen.caihongy.cn/20250210/8fb3155213d34ce2bbcef9c9b572508f.png) no-repeat left center / 100% 100%;
				width: 1200px;
				position: relative;
				text-align: left;
				height: 40px;
				.news_title {
					margin: 0;
					color: #5d62de;
					background: none;
					font-weight: 600;
					width: auto;
					font-size: 26px;
					line-height: 30px;
					text-align: left;
				}
				.news_subhead {
					margin: 0;
					color: #999;
					display: none;
					width: auto;
					font-size: 18px;
					line-height: 40px;
					text-align: center;
				}
			}
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list17 {
				padding: 0;
				margin: 30px auto 0;
				color: #888;
				background: none;
				display: flex;
				width: 1200px;
				font-size: 14px;
				justify-content: space-between;
				height: auto;
				.swiper {
					background: none;
					width: 45%;
					height: auto;
					.swiper-slide {
						.list-item {
							cursor: pointer;
							width: 100%;
							position: relative;
							height: auto;
							img {
								object-fit: cover;
								display: block;
								width: 100%;
								height: 460px;
							}
							.infoBox {
								left: 0;
								bottom: 0;
								background: rgba(0,0,0,.3);
								display: flex;
								width: 100%;
								justify-content: space-between;
								align-items: center;
								position: absolute;
								.name {
									padding: 0 10px;
									overflow: hidden;
									color: #fff;
									white-space: nowrap;
									background: none;
									flex: 1;
									width: calc(100% - 130px);
									font-size: 16px;
									line-height: 44px;
									text-overflow: ellipsis;
								}
								.time {
									padding: 0 0px 0 0px;
									margin: 0 0 0 10px;
									background: none;
									width: 120px;
									.icon {
										margin: 0 2px 0 0;
										display: none;
										line-height: 1.5;
									}
									.label {
										display: none;
										line-height: 1.5;
									}
									.text {
										color: #fff;
										font-size: 14px;
										line-height: 1.5;
									}
								}
							}
						}
					}
					/deep/.swiper-pagination {
						left: 0;
						bottom: 10px;
						width: 100%;
						text-align: right;
						/deep/ span.swiper-pagination-bullet {
							border-radius: 100%;
							margin: 0 4px;
							background: #fff;
							display: inline-block;
							width: 10px;
							opacity: 0.5;
							height: 10px;
						}
						
						/deep/ span.swiper-pagination-bullet:hover {
							background: red;
							opacity: 1;
						}
						
						/deep/ span.swiper-pagination-bullet.swiper-pagination-bullet-active {
							background: red;
							opacity: 1;
						}
					}
				}
				.right {
					width: 53%;
					height: auto;
					.top-list-item {
						cursor: pointer;
						padding: 24px 10px 0;
						margin: 0 0 10px;
						background: url(http://codegen.caihongy.cn/20250210/99bf6e26bbb144c49225b7f24cd00a2a.png) no-repeat center top / 100% 100%;
						display: flex;
						width: 100%;
						align-items: center;
						position: relative;
						height: auto;
						.name {
							padding: 0 10px;
							overflow: hidden;
							color: #333;
							white-space: nowrap;
							font-weight: 500;
							width: 100%;
							font-size: 16px;
							line-height: 60px;
							text-overflow: ellipsis;
						}
						.desc {
							overflow: hidden;
							color: #666;
							display: none;
							font-size: 14px;
							line-height: 24px;
							height: 48px;
						}
						.time_item {
							padding: 0;
							top: 0;
							color: #fff;
							left: 30px;
							display: inline-block;
							width: auto;
							font-size: 13px;
							position: absolute;
							text-align: left;
							.icon {
								margin: 0 2px 0 0;
								line-height: 30px;
							}
							.label {
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 30px;
							}
						}
						.publisher_item {
							padding: 0;
							display: none;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
						.like_item {
							padding: 0;
							display: none;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
						.collect_item {
							padding: 0;
							display: none;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
						.view_item {
							padding: 0;
							display: none;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
					}
					.list-body {
						padding: 0;
						background: none;
						width: 100%;
						height: auto;
						.list-item {
							cursor: pointer;
							padding: 24px 10px 0;
							margin: 0 0 10px;
							background: url(http://codegen.caihongy.cn/20250210/99bf6e26bbb144c49225b7f24cd00a2a.png) no-repeat center top / 100% 100%;
							display: flex;
							width: 100%;
							align-items: center;
							position: relative;
							height: auto;
							.dian {
								border-radius: 100%;
								margin: 0 6px;
								background: red;
								display: none;
								width: 4px;
								height: 4px;
							}
							.name {
								padding: 0 10px;
								overflow: hidden;
								color: #333;
								white-space: nowrap;
								background: none;
								width: calc(100% - 10px);
								font-size: 16px;
								line-height: 60px;
								text-overflow: ellipsis;
								transition: 0.3s;
							}
							.time {
								padding: 0px;
								top: 0;
								color: #fff;
								left: 30px;
								background: none;
								width: quto;
								font-size: 13px;
								position: absolute;
								text-align: left;
								.icon {
									line-height: 30px;
								}
								.label {
									display: none;
									line-height: 30px;
								}
								.text {
									line-height: 30px;
								}
							}
						}
						.list-item {
							.name {
								transform: translate3d(10px, 0px, 0px);
							}
						}
					}
				}
			}
			.moreBtn {
				border: 0px solid #999;
				cursor: pointer;
				padding: 0;
				margin: 0;
				display: inline-block;
				line-height: 40px;
				right: calc((100% - 1200px)/2);
				float: right;
				top: 40px;
				background: url(http://codegen.caihongy.cn/20250210/1ca24bd8c8544b5a9d3d3b45cbb7649a.png) no-repeat center top / 100% 100%;
				width: 113px;
				position: absolute;
				text-align: center;
				.text {
					color: #e7e1f8;
					font-size: 14px;
				}
				.icon {
					color: #333;
					display: none;
					font-size: 15px;
				}
			}
		}
		.recommend {
			padding: 20px 0;
			margin: 0;
			background: #fff;
			width: 100%;
			position: relative;
			order: 1;
			.recommend_title_box {
				padding: 0 0 0 60px;
				margin: 0 auto 10px;
				background: url(http://codegen.caihongy.cn/20250210/8fb3155213d34ce2bbcef9c9b572508f.png) no-repeat left center / 100% 100%;
				width: 1200px;
				position: relative;
				text-align: left;
				height: 40px;
				.recommend_title {
					margin: 0;
					color: #5d62de;
					background: none;
					font-weight: 600;
					width: auto;
					font-size: 26px;
					line-height: 30px;
					text-align: left;
				}
				.recommend_subhead {
					margin: 0;
					color: #999;
					display: none;
					width: auto;
					font-size: 18px;
					line-height: 40px;
					text-align: center;
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
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list4 {
				padding: 0;
				margin: 30px auto 10px;
				color: #fff;
				background: #fff;
				width: 1200px;
				font-size: 14px;
				height: auto;
				.list-item {
					cursor: pointer;
					margin: 0 20px 0 0;
					width: calc(50% - 20px);
					position: relative;
					float: left;
					height: 570px;
					img {
						object-fit: cover;
						width: 100%;
						float: left;
						height: 100%;
					}
					.infoBox {
						padding: 10px 0;
						left: 0;
						bottom: 0;
						background: rgba(0,0,0,.3);
						width: 100%;
						position: absolute;
						.name {
							padding: 0 10px;
							overflow: hidden;
							color: #fff;
							white-space: nowrap;
							width: 100%;
							font-size: 16px;
							line-height: 30px;
							text-overflow: ellipsis;
						}
						.price {
							padding: 0 10px;
							color: #f00;
							font-size: 16px;
							line-height: 30px;
						}
						.time_item {
							padding: 0 10px;
							width: 100%;
							.icon {
								margin: 0 2px 0 0;
								color: inherit;
								display: none;
								font-size: inherit;
								line-height: 1.5;
							}
							.label {
								color: inherit;
								font-size: inherit;
								line-height: 2;
							}
							.text {
								color: inherit;
								font-size: inherit;
								line-height: 1.5;
							}
						}
						.publisher_item {
							padding: 0 10px;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								color: inherit;
								display: none;
								font-size: inherit;
								line-height: 1.5;
							}
							.label {
								color: inherit;
								font-size: inherit;
								line-height: 1.5;
							}
							.text {
								color: inherit;
								font-size: inherit;
								line-height: 1.5;
							}
						}
						.like_item {
							padding: 0 10px;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								color: inherit;
								display: none;
								font-size: inherit;
								line-height: 1.5;
							}
							.label {
								color: inherit;
								font-size: inherit;
								line-height: 1.5;
							}
							.text {
								color: inherit;
								font-size: inherit;
								line-height: 1.5;
							}
						}
						.collect_item {
							padding: 0 10px;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								color: inherit;
								display: none;
								font-size: inherit;
								line-height: 1.5;
							}
							.label {
								color: inherit;
								font-size: inherit;
								line-height: 1.5;
							}
							.text {
								color: inherit;
								font-size: inherit;
								line-height: 1.5;
							}
						}
						.view_item {
							padding: 0 10px;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								color: inherit;
								display: none;
								font-size: inherit;
								line-height: 1.5;
							}
							.label {
								color: inherit;
								font-size: inherit;
								line-height: 1.5;
							}
							.text {
								color: inherit;
								font-size: inherit;
								line-height: 1.5;
							}
						}
					}
				}
				.list-body1 {
					margin: 0 0 15px;
					display: inline-block;
					width: calc(50% - 0px);
					height: 275px;
					.list-item1 {
						cursor: pointer;
						margin: 0 10px 0 0;
						display: inline-block;
						width: calc(50% - 10px);
						position: relative;
						float: left;
						height: 275px;
						img {
							object-fit: cover;
							width: 100%;
							float: left;
							height: 100%;
						}
						.infoBox {
							padding: 10px 0;
							left: 0;
							bottom: 0;
							background: rgba(0,0,0,.3);
							width: 100%;
							position: absolute;
							.name {
								padding: 0 10px;
								overflow: hidden;
								color: #fff;
								white-space: nowrap;
								width: 100%;
								font-size: 16px;
								line-height: 30px;
								text-overflow: ellipsis;
							}
							.price {
								padding: 0 10px;
								color: #f00;
								font-size: 16px;
								line-height: 30px;
							}
							.time_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.publisher_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
						}
					}
					.list-item2 {
						cursor: pointer;
						margin: 0 0 0 10px;
						display: inline-block;
						width: calc(50% - 10px);
						position: relative;
						float: left;
						height: 275px;
						img {
							object-fit: cover;
							width: 100%;
							float: left;
							height: 100%;
						}
						.infoBox {
							padding: 10px 0;
							left: 0;
							bottom: 0;
							background: rgba(0,0,0,.3);
							width: 100%;
							position: absolute;
							.name {
								padding: 0 10px;
								overflow: hidden;
								color: #fff;
								white-space: nowrap;
								width: 100%;
								font-size: 16px;
								line-height: 30px;
								text-overflow: ellipsis;
							}
							.price {
								padding: 0 10px;
								color: #f00;
								font-size: 16px;
								line-height: 30px;
							}
							.time_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.publisher_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
						}
					}
				}
				.list-body2 {
					margin: 0px 0 0;
					display: inline-block;
					width: calc(50% - 0px);
					height: 275px;
					.list-item1 {
						cursor: pointer;
						margin: 0 10px 0 0;
						display: inline-block;
						width: calc(50% - 10px);
						position: relative;
						float: left;
						height: 275px;
						img {
							object-fit: cover;
							width: 100%;
							float: left;
							height: 100%;
						}
						.infoBox {
							padding: 10px 0;
							left: 0;
							bottom: 0;
							background: rgba(0,0,0,.3);
							width: 100%;
							position: absolute;
							.name {
								padding: 0 10px;
								overflow: hidden;
								color: #fff;
								white-space: nowrap;
								width: 100%;
								font-size: 16px;
								line-height: 30px;
								text-overflow: ellipsis;
							}
							.price {
								padding:  0 10px;
								color: #f00;
								font-size: 16px;
								line-height: 30px;
							}
							.time_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.publisher_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
						}
					}
					.list-item2 {
						cursor: pointer;
						margin: 0 0 0 10px;
						display: inline-block;
						width: calc(50% - 10px);
						position: relative;
						float: left;
						height: 275px;
						img {
							object-fit: cover;
							width: 100%;
							float: left;
							height: 100%;
						}
						.infoBox {
							padding: 10px 0;
							left: 0;
							bottom: 0;
							background: rgba(0,0,0,.3);
							width: 100%;
							position: absolute;
							.name {
								padding: 0 10px;
								overflow: hidden;
								color: #fff;
								white-space: nowrap;
								width: 100%;
								font-size: 16px;
								line-height: 30px;
								text-overflow: ellipsis;
							}
							.price {
								padding: 0 10px;
								color: #f00;
								font-size: 16px;
								line-height: 30px;
							}
							.time_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.publisher_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
						}
					}
				}
			}
			.moreBtn {
				border: 0px solid #999;
				cursor: pointer;
				padding: 0;
				margin: 0;
				display: inline-block;
				line-height: 40px;
				right: calc((100% - 1200px)/2);
				float: right;
				top: 20px;
				background: url(http://codegen.caihongy.cn/20250210/1ca24bd8c8544b5a9d3d3b45cbb7649a.png) no-repeat center top / 100% 100%;
				width: 113px;
				position: absolute;
				text-align: center;
				.text {
					color: #e7e1f8;
					font-size: 14px;
				}
				.icon {
					color: #333;
					display: none;
					font-size: 15px;
				}
			}
		}
	}
</style>
