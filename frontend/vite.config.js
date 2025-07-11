import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  //CORS(Cross-Origin Resource Sharing) error 해결
  /*원리
  1. 브라우저: fetch('/v1/api/users')
   ↓ (동일 출처로 인식, CORS 체크 안함)
  2. Vite 개발 서버: 요청 받음
     ↓ (프록시 설정에 따라 대리 요청)
  3. 백엔드 서버: http://localhost:8080/v1/api/users로 요청 전달
      ↓ (서버 간 통신이므로 CORS 제한 없음)
  4. 백엔드 서버: 응답 반환
     ↓
  5. Vite 개발 서버: 응답을 브라우저에 전달
     ↓
  6. 브라우저: 응답 정상 수신
  */
  server: {
    proxy: {
      "/v1/api": {
        target: "http://localhost:8080",
        changeOrigin: true
      }
    }
  },
  plugins: [
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  }
})
