<script setup>
  import axios from "axios";
  import { ref } from "vue";
	import { ElMessage } from 'element-plus'


	const tag = ref("");
  const loading = ref(true);

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

      loading.value = false;
			tag.value = response.data.data[0];
			ElMessage({
				message: response.data,
				type: "success",
				duration: 10 * 1000
			})

    })
    .catch((error) => {
      // 请求失败时的处理
      console.error("Error:", error);
    });
</script>

<template>
  <el-tag type="primary" v-loading="loading">{{ tag }}</el-tag>
</template>

<style scoped>
  .el-row {
    margin-bottom: 20px;
  }
  .el-row:last-child {
    margin-bottom: 0;
  }
  .el-col {
    border-radius: 4px;
    background-color: cadetblue;
  }

  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
</style>