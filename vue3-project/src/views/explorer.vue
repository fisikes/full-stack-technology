<script setup>
</script>

<!-- 将搜索框定义为一个组件, 将检索结果定义为一个组件 -->
<template>
  <el-row>
    <el-col :span="6"> <el-input></el-input></el-col>
    <el-col :span="3"> <el-button>search</el-button></el-col>
  </el-row>
</template>

<style scoped>
  .demo-tabs > .el-tabs__content {
    padding: 32px;
    color: #6b778c;
    font-size: 32px;
    font-weight: 600;
  }
</style>