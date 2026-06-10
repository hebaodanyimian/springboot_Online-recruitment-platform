import VueRouter from 'vue-router'
//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import qiuzhizheList from '../pages/qiuzhizhe/list'
import qiuzhizheDetail from '../pages/qiuzhizhe/detail'
import qiuzhizheAdd from '../pages/qiuzhizhe/add'
import qiyeyonghuList from '../pages/qiyeyonghu/list'
import qiyeyonghuDetail from '../pages/qiyeyonghu/detail'
import qiyeyonghuAdd from '../pages/qiyeyonghu/add'
import zhaopinxinxiList from '../pages/zhaopinxinxi/list'
import zhaopinxinxiDetail from '../pages/zhaopinxinxi/detail'
import zhaopinxinxiAdd from '../pages/zhaopinxinxi/add'
import zhiweileixingList from '../pages/zhiweileixing/list'
import zhiweileixingDetail from '../pages/zhiweileixing/detail'
import zhiweileixingAdd from '../pages/zhiweileixing/add'
import yingpinxinxiList from '../pages/yingpinxinxi/list'
import yingpinxinxiDetail from '../pages/yingpinxinxi/detail'
import yingpinxinxiAdd from '../pages/yingpinxinxi/add'
import mianshitongzhiList from '../pages/mianshitongzhi/list'
import mianshitongzhiDetail from '../pages/mianshitongzhi/detail'
import mianshitongzhiAdd from '../pages/mianshitongzhi/add'
import huifuxinxiList from '../pages/huifuxinxi/list'
import huifuxinxiDetail from '../pages/huifuxinxi/detail'
import huifuxinxiAdd from '../pages/huifuxinxi/add'
import mianshixinxiList from '../pages/mianshixinxi/list'
import mianshixinxiDetail from '../pages/mianshixinxi/detail'
import mianshixinxiAdd from '../pages/mianshixinxi/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import systemnoticeList from '../pages/systemnotice/list'
import systemnoticeDetail from '../pages/systemnotice/detail'
import systemnoticeAdd from '../pages/systemnotice/add'
import discusszhaopinxinxiList from '../pages/discusszhaopinxinxi/list'
import discusszhaopinxinxiDetail from '../pages/discusszhaopinxinxi/detail'
import discusszhaopinxinxiAdd from '../pages/discusszhaopinxinxi/add'
import discussyingpinxinxiList from '../pages/discussyingpinxinxi/list'
import discussyingpinxinxiDetail from '../pages/discussyingpinxinxi/detail'
import discussyingpinxinxiAdd from '../pages/discussyingpinxinxi/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'messages',
					component: Messages
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'qiuzhizhe',
					component: qiuzhizheList
				},
				{
					path: 'qiuzhizheDetail',
					component: qiuzhizheDetail
				},
				{
					path: 'qiuzhizheAdd',
					component: qiuzhizheAdd
				},
				{
					path: 'qiyeyonghu',
					component: qiyeyonghuList
				},
				{
					path: 'qiyeyonghuDetail',
					component: qiyeyonghuDetail
				},
				{
					path: 'qiyeyonghuAdd',
					component: qiyeyonghuAdd
				},
				{
					path: 'zhaopinxinxi',
					component: zhaopinxinxiList
				},
				{
					path: 'zhaopinxinxiDetail',
					component: zhaopinxinxiDetail
				},
				{
					path: 'zhaopinxinxiAdd',
					component: zhaopinxinxiAdd
				},
				{
					path: 'zhiweileixing',
					component: zhiweileixingList
				},
				{
					path: 'zhiweileixingDetail',
					component: zhiweileixingDetail
				},
				{
					path: 'zhiweileixingAdd',
					component: zhiweileixingAdd
				},
				{
					path: 'yingpinxinxi',
					component: yingpinxinxiList
				},
				{
					path: 'yingpinxinxiDetail',
					component: yingpinxinxiDetail
				},
				{
					path: 'yingpinxinxiAdd',
					component: yingpinxinxiAdd
				},
				{
					path: 'mianshitongzhi',
					component: mianshitongzhiList
				},
				{
					path: 'mianshitongzhiDetail',
					component: mianshitongzhiDetail
				},
				{
					path: 'mianshitongzhiAdd',
					component: mianshitongzhiAdd
				},
				{
					path: 'huifuxinxi',
					component: huifuxinxiList
				},
				{
					path: 'huifuxinxiDetail',
					component: huifuxinxiDetail
				},
				{
					path: 'huifuxinxiAdd',
					component: huifuxinxiAdd
				},
				{
					path: 'mianshixinxi',
					component: mianshixinxiList
				},
				{
					path: 'mianshixinxiDetail',
					component: mianshixinxiDetail
				},
				{
					path: 'mianshixinxiAdd',
					component: mianshixinxiAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'systemnotice',
					component: systemnoticeList
				},
				{
					path: 'systemnoticeDetail',
					component: systemnoticeDetail
				},
				{
					path: 'systemnoticeAdd',
					component: systemnoticeAdd
				},
				{
					path: 'discusszhaopinxinxi',
					component: discusszhaopinxinxiList
				},
				{
					path: 'discusszhaopinxinxiDetail',
					component: discusszhaopinxinxiDetail
				},
				{
					path: 'discusszhaopinxinxiAdd',
					component: discusszhaopinxinxiAdd
				},
				{
					path: 'discussyingpinxinxi',
					component: discussyingpinxinxiList
				},
				{
					path: 'discussyingpinxinxiDetail',
					component: discussyingpinxinxiDetail
				},
				{
					path: 'discussyingpinxinxiAdd',
					component: discussyingpinxinxiAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
