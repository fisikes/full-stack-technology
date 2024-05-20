<script setup>
</script>

<template>
  <svg viewBox="0 0 300 100">
    <!-- Arrow shape -->
    <polygon
      points="300,50 100,50 100,30 0,70 100,110 100,90 300,90"
      fill="black"
    />
    <!-- Text inside arrow -->
    <text x="150" y="70">to be continued</text>
  </svg>
</template>

<style scoped>
  body {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
    background-color: #f0f0f0;
  }
  svg {
    width: 300px;
    height: 100px;
  }
  text {
    font-size: 16px;
    fill: white;
    text-anchor: middle;
    alignment-baseline: middle;
  }
</style>