<script setup>
  import HelloWorld from "./components/HelloWorld.vue";
  import Mensagem from "./components/Mensagem.vue";
  import Soma from "./components/Soma.vue";
  import Subtracao from "./components/Subtracao.vue";
  import Divisao from "./components/Divisao.vue";
  import Multiplicacao from "./components/Multiplicacao.vue";
</script>

<template>
  <HelloWorld></HelloWorld>
  <Mensagem msg="Sakuna 8==D"></Mensagem>
  <Mensagem msg="Olha a nova loira do tchan"></Mensagem>
  <Soma x="3" y="3"></Soma>
  <Subtracao x="3" y="3"></Subtracao>
  <Divisao x="3" y="3"></Divisao>
  <Multiplicacao x="3" y="3"></Multiplicacao>
</template>

<style scoped>
  p {
    color: greenyellow;
  }
</style>
