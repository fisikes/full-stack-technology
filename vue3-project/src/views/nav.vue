<script setup>
  import router from "@/router";

  const handleTabClick = (tab) => {
    router.push(tab.props.name);
  };
</script>

<template>
  <!-- 刷新页面时如何根据当前url, 将对应的tab高亮 -->
  <el-tabs @tab-click="handleTabClick" class="nav_table">
    <el-tab-pane label="资产浏览器" name="explorer" />

    <el-tab-pane label="elplus组件" name="content"> </el-tab-pane>
    <el-tab-pane label="open git flow" name="open-git-flow"> </el-tab-pane>
    <el-tab-pane label="open task" name="open-task"> </el-tab-pane>
    <el-tab-pane label="es索引修改" name="to-be-continued"> </el-tab-pane>
    <el-tab-pane label="analyse" name="analyse"> </el-tab-pane>
  </el-tabs>

  <main class="content">
    <router-view />
  </main>
</template>

<style scoped>
  .nav_table {
    margin: auto;
    width: 50%;
  }
  .content {
    margin: auto;
    width: 50%;
  }
</style>