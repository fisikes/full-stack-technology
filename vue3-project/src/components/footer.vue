<script setup>
  const props = defineProps({
    user: Number,
    ip: String,
  });

  console.log(props);
</script>

<template>
	<hr>
  <h3>footer</h3>
  user: {{ props.user }}
</template>

<style scoped>
</style>