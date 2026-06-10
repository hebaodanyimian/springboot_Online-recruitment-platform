export default {
	baseUrl: 'http://localhost:8080/springbootcjtr0kiv/',
	name: '/springbootcjtr0kiv',
	indexNav: [
		{
			name: '招聘信息',
			url: '/index/zhaopinxinxi',
		},
		{
			name: '公告信息',
			url: '/index/news'
		},
		{
			name: '留言投诉',
			url: '/index/messages'
		},
	],
	cateList: [
		{
			name: '公告信息',
			refTable: 'newstype',
			refColumn: 'typename',
		},
	]
}
