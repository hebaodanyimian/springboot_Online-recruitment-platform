const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootcjtr0kiv/",
            name: "springbootcjtr0kiv",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootcjtr0kiv/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于Web的在线招聘平台设计与实现"
        } 
    }
}
export default base
