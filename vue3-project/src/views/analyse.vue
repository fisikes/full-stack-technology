<script setup>
  import axios from "axios";
  import { ElMessage } from "element-plus";
  import { onMounted, reactive } from "vue";

  const data = reactive([
    { key: "query-exposure-risk", value: [] },
    { key: "query-exposure-level", value: [] },
    { key: "query-exposure-vulnerability", value: [] },
  ]);

  const req = reactive({
    // businessType: "web", id: "945ca3618553153d8953ee38736824fa",
    //businessType: "ip", id: "a9478f5bd293637352fd1c2a30844aa6",
    businessType: "domain",
    id: "6a251909a6305084430d42c12aa1fd8f",
  });

  const clickGetAll = () => {
    data.forEach((x) => {
      getAnalyseResult(x.key);
    });
  };

  onMounted(() => clickGetAll());

  const getAnalyseResult = (type) => {
    axios
      .get(`/h-api/exposed/asset-analysis/${type}`, { params: req })
      .then((response) => {
        // 请求成功时的处理
        console.log("Response:", response.data);

        data.forEach((d) => {
          if (d.key === type) {
            d.value = response.data.data.items;
          }
        });
      })
      .catch((error) => {
        // 请求失败时的处理
        console.error("Error:", error);
        ElMessage({
          message: e,
        });
      });
  };
</script>

<template>
  <div style="margin: auto; width: 100%">
    <input v-model="req.businessType" placeholder="type" />
    <input v-model="req.id" placeholder="id" />
    <button @click="clickGetAll">确认</button>
  </div>

  <div v-for="(v, i) in data" :key="i">
    {{ v.key }}
    <el-table :data="v.value" border style="width: 100%; margin: auto">
      <el-table-column prop="code" label="编码(tags.contains)" min-width="22%" />
      <el-table-column prop="name" label="指标" min-width="40%" />
      <el-table-column label="结果" min-width="18%">
        <template #default="scope">
          {{ scope.row.existBln ? "✔" : "✘" }}
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<style scoped>
  .el-table {
    --el-table-border-color: #1a6e78;
    --el-table-text-color: black;
    --el-table-header-text-color: rgb(60, 20, 237);
  }
</style>