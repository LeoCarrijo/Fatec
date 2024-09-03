const { createApp } = Vue;

createApp({
    data() {
        return {
            nomes: [{
              nome: 'Leonardo',
              idade: 21,
              email: 'leonardo.carrijo@whysoulers.com.br',
              expanded: false
            }, {
                nome: 'Leonardo',
                idade: 21,
                email: 'leonardo.carrijo@whysoulers.com.br',
                expanded: false
            }, {
                nome: 'Leonardo',
                idade: 21,
                email: 'leonardo.carrijo@whysoulers.com.br',
                expanded: false
             },]
        }
    },
    methods: {
        expandedItem(item) {
            item.expanded = !item.expanded
        }
    }
}).mount('#app')