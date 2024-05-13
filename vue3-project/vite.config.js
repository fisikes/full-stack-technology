import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import path from 'path'

// https://vitejs.dev/config/
export default defineConfig({
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        rewrite: path => path.replace(/^\/api/, '')
      }
    }
  },
 
  plugins: [vue()],
  resolve: {
    alias: {
      // @作为src的别名
      '@': path.resolve(__dirname, 'src')
    }
  }
})
