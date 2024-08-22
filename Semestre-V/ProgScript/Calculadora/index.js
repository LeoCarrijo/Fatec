const { createApp } = Vue

createApp({
    data() {
        return {
            display: '0',
            numeroAtual: '',
            numeroAnterior: '',
            operador: null
        }
    },
    methods: {
        lidarBotao(botao) {
            switch(botao) {
                case "*":
                    this.lidarOperador(botao)
                    break
                case "/":
                    this.lidarOperador(botao)
                    break
                case "+":
                    this.lidarOperador(botao)
                    break
                case "-":
                    this.lidarOperador(botao)
                    break
                case "x2":
                    this.lidarPotencia(botao)
                    break
                case "%":
                    this.lidarPorcentagem()
                    break
                case ".":
                    this.lidarDecimal()
                    break
                case "=":
                    this.lidarIgual()
                    break
                case "AC":
                    this.lidarClear()
                    break
                default:
                    this.lidarNumero(botao)
            }
        },
        lidarOperador(botao) {
            switch(botao) {
                case "*":
                    this.inserirMultiplicacao()
                    break
                case "/":
                    this.inserirDivisao()
                    break
                case "+":
                    this.inserirAdicao()
                    break
                case "-":
                    this.inserirSubtracao()
                    break
            }
        },
        inserirMultiplicacao() {
            this.numeroAnterior = this.display
            this.operador = "*"
            this.display = '0'
        },
        inserirDivisao() {
            this.numeroAnterior = this.display
            this.operador = "/"
            this.display = '0'
        },
        inserirAdicao() {
            this.numeroAnterior = this.display
            this.operador = "+"
            this.display = '0'
        },
        inserirSubtracao() {
            this.numeroAnterior = this.display
            this.operador = "-"
            this.display = '0'
        },
        lidarDecimal() {
            let jaDecimal = true ? this.display.indexOf(".") == -1 : false
            if (jaDecimal) {
                this.inserirDecimal()
            }
        },
        lidarPotencia() {
            this.display = Number(this.display) * Number(this.display)
        },
        lidarPorcentagem() {
            if(this.operador != null) {
                this.display = Number(this.numeroAnterior) * (Number(this.display) / 100)
            }
        },
        inserirDecimal() {
            this.display += '.'
        },
        lidarIgual() {
            switch(this.operador) {
                case "*":
                    this.multiplicar()
                    break
                case "/":
                    this.dividir()
                    break
                case "+":
                    this.somar()
                    break
                case "-":
                    this.subtrair()
                    break
                default:
                    this.retornarIgual()
            }
            this.numeroAnterior = ''
        },
        multiplicar() {
            this.numeroAtual = this.display
            this.display = Number(this.numeroAnterior) * Number(this.numeroAtual)
        },
        dividir() {
            this.numeroAtual = this.display
            this.display = Number(this.numeroAnterior) / Number(this.numeroAtual)
        },
        somar() {
            this.numeroAtual = this.display
            this.display = Number(this.numeroAnterior) + Number(this.numeroAtual)
        },
        subtrair() {
            this.numeroAtual = this.display
            this.display = Number(this.numeroAnterior) - Number(this.numeroAtual)
        },
        retornarIgual() {
            this.display = this.display
        },
        lidarClear() {
            this.display = '0'
            this.numeroAnterior = '',
            this.numeroAtual = '',
            this.operador = null
        },
        lidarNumero(botao) {
            if(this.display == '0') {
                this.display = ''
            }
            switch(botao) {
                case '1':
                    this.inserirUm()
                    break
                case '2':
                    this.inserirDois()
                    break
                case '3':
                    this.inserirTres()
                    break
                case '4':
                    this.inserirQuatro()
                    break
                case '5':
                    this.inserirCinco()
                    break
                case '6':
                    this.inserirSeis()
                    break
                case '7':
                    this.inserirSete()
                    break
                case '8':
                    this.inserirOito()
                    break
                case '9':
                    this.inserirNove()
                    break
                case '0':
                    this.inserirZero()
                    break
            }
        },
        inserirUm() {
            this.display += '1'
        },
        inserirDois() {
            this.display += '2'
        },
        inserirTres() {
            this.display += '3'
        },
        inserirQuatro() {
            this.display += '4'
        },
        inserirCinco() {
            this.display += '5'
        },
        inserirSeis() {
            this.display += '6'
        },
        inserirSete() {
            this.display += '7'
        },
        inserirOito() {
            this.display += '8'
        },
        inserirNove() {
            this.display += '9'
        },
        inserirZero() {
            this.display += '0'
        }
        // Consertar dízimas periódicas
        // Ao escrever um númmero depois de um resultado ele apagar o resultado
        // Tecla de apagar
        // Fazer modo científico
        // Melhorar aparencia do numeroAnterior
    }
}).mount('#app')