import { defineStore } from "pinia";
import { reactive, ref } from "vue";

export const useWebStore = defineStore('web', () => {
	const web = reactive({
		title: 'this is title',
		url: '172.0.0.1'
	})

	const users = ref(1000)

	const userAdd = () => {
		users.value++
	}

	return {
		web,
		users,
		userAdd
	}
}, {
	persist: true
})