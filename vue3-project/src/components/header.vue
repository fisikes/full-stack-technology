<script setup>
  const emits = defineEmits(["getWeb"]);
	emits("getWeb", {
		name: "xxxx",
		url: "xxxx.com"
	})
</script>

<template>
  <h3>header</h3>
  <hr />
</template>

<style scoped>
</style>