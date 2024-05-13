import { createRouter, createWebHistory } from "vue-router";


const routes = [
	{
		path: "/",
		component: () => import('@/views/index.vue')
	},
	{
		path: "/content",
		component: () => import("@/views/content.vue")
	},
	{
		path: "/project-detail",
		component: () => import("@/views/projectDetail.vue")
	}
]

const router = createRouter({
	history: createWebHistory(),
	routes
})

export default router