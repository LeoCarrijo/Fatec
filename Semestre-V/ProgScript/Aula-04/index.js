const { createApp } = Vue;

createApp({
    data() {
        return {
            nome: "",
            sobrenome: "",
            aceso: false,
            apagadoInput: ""
        }
    },
    methods: {
        onOff() {
            this.aceso = !this.aceso
        }
    }
}).mount("#app")