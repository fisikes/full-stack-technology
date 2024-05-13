<script setup>
  import axios from "axios";

  const url = "/api/get-project";
  const postData = {
    key1: "value1",
    key2: "value2",
  };
	
  axios
    .post(url, postData)
    .then((response) => {
      // 请求成功时的处理
      console.log("Response:", response.data);
    })
    .catch((error) => {
      // 请求失败时的处理
      console.error("Error:", error);
    });
</script>

<template>index页</template>

<style scoped>
</style>