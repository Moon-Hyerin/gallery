import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

const app = createApp(App)

app.use(createPinia())
app.use(router)

//마운트 시점 변경(라우터의 초기 탐색 후) -> 추후 구현할 라우터 관련 기능이 중복 호출되지 않도록 하기 위함
router.isReady().then(() => {
    app.mount('#app');
    // vue 애플리케이션의 인스턴스 (app)을 아이디가 app인 요소에 마운트(연결)
    //아이디가  app인 요소는 프로젝트 생성  시 기본으로 만들어지는 frontend/index.html에 있음
})
