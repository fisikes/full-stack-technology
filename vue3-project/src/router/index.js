import { createRouter, createWebHistory } from "vue-router";


const routes = [
	{
		path: "/",
		component: () => import('@/views/nav.vue'),
		children: [
			{
				path: "/explorer",
				component: () => import("@/views/explorer.vue")
			},
			{
				path: "/content",
				component: () => import("@/views/content.vue")
			},
			{
				path: "/project-detail",
				component: () => import("@/views/projectDetail.vue")
			},
			{
				path: "/to-be-continued",
				component: () => import("@/views/to_be_continued.vue")
			},
			{
				path: "/open-git-flow",
				component: () => import("@/views/to_be_continued.vue")
			},
			{
				path: "/open-task",
				component: () => import("@/views/to_be_continued.vue")
			},
			{
				path: "/analyse",
				component: () => import("@/views/analyse.vue")
			},
		]
	},
	
]

const router = createRouter({
	history: createWebHistory(),
	routes
})

export default router