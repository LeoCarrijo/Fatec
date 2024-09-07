const { createApp } = Vue;

createApp({
    data() {
        return {
            round: 1,
            gameover: false,
            endingMsg: '',
            endingTitle: '',
            hero: {
                life: 100,
                maxLife: 100,
                rage: 0,
                maxRage: 100,
                berserkMode: false,
                berserkDmgMult: 3,
                minBerkserkDmg: 3,
                name: 'Guts',
                maxDmg: 20,
                defended: false,
                defenseArmor: 2,
                elfPowder: 3
            },
            villan: {
                life: 200,
                maxLife: 200,
                femto: false,
                femtoDmgMult: 6,
                name: 'Griffith',
                maxDmg: 15,
                defended: false,
                defenseArmor: 2,
                elfPowder: 3
            }
        }
    },
    methods: {
        handlerClick(opt) {
            switch(opt) {
                case 'attack':
                    this.attack(true)
                    break
                case 'defend':
                    this.defend(true)
                    break
                case 'stopDefending':
                    this.stopDefending(true)
                    break
                case 'use':
                    this.use(true)
                    break
                case 'flee':
                    this.flee()
                    break
            }
            if(!this.gameover) {
                this.passRound()
            }
        },
        attack(isHero) {
            let character = isHero ? this.hero : this.villan
            let foe = !isHero ? this.hero : this.villan
            let dmg = this.generateRng(character.maxDmg)
            if(isHero && this.hero.berserkMode) {
                dmg = dmg < this.hero.minBerkserkDmg ? this.hero.minBerkserkDmg : dmg
                dmg *= this.hero.berserkDmgMult
            }
            if(!isHero && this.villan.femto) {
                dmg *= this.villan.femtoDmgMult
            }
            this.causeDamage(dmg, isHero)
            console.log(`${dmg} de dano causado`)
            console.log(`Vida de ${foe.name}: ${foe.life}`)
        },
        defend(isHero) {
            let character = isHero ? this.hero : this.villan
            character.defend = true
            character.defenseArmor = 2
            console.log(`${character.name} está defendendo com ${character.defenseArmor} de armadura`)
        },
        stopDefending(isHero) {
            let character = isHero ? this.hero : this.villan
            character.defend = false
            character.defenseArmor = 2
            console.log(`${character.name} parou de defender!`)
        },
        use(isHero) {
            let character = isHero ? this.hero : this.villan
            if(character.elfPowder > 0) {
                this.heal(isHero)
            } else {
                console.log(`${character.name} não possui mais pó élfico!`)
            }
        },
        flee() {
            if(this.generateRng(11) > 8) {
                console.log(`${this.hero.name} Fugiu!`)
                this.endGame(false)
            } else {
                console.log(`${this.hero.name} tentou fugir mas não conseguiu...`)
                this.causeDamage(this.villan.maxDmg * 1.5, false)
            }
        },
        stand(isHero) {
            let character = isHero ? this.hero : this.villan
            console.log(`${character.name} manteve posição`)
        },
        generateRng(max) {
            let value = (Math.floor(Math.random() * max))
            if(value == 0) {
                return 1
            } else {
                return value
            }
        },
        causeDamage(dmg, isHero) {
            let foe = !isHero ? this.hero : this.villan
            if(!foe.defend) {
                foe.life -= dmg
                if(!isHero && !this.hero.berserkMode) {
                    this.increaseRage(dmg)
                }
                if(foe.life < 0) {
                    foe.life = 0
                }
            } else {
                foe.defenseArmor -= 1
                console.log(`${foe.defenseArmor} de armadura restante`)
                if(foe.defenseArmor == 0) {
                    foe.defend = false
                }
            }
        },
        increaseRage(rageAmmount) {
            this.hero.rage += (this.hero.rage + rageAmmount > this.hero.maxRage) ? (this.hero.maxRage - this.hero.rage) : rageAmmount
            if(this.hero.rage == this.hero.maxRage) {
                this.turnIntoBerserk()
            }
        },
        giveElfPowder(toHero) {
            if(toHero) {
                if(this.hero.elfPowder < 5) {
                    this.hero.elfPowder++
                } 
            } else {
                if(this.villan.elfPowder < 5) {
                    this.villan.elfPowder++
                } 
            }
        },
        turnIntoBerserk() {
            this.hero.berserkMode = true
            let healAmmount = this.hero.maxLife / 2
            this.hero.life += (this.hero.life + healAmmount > this.hero.maxLife) ? (this.hero.maxLife - this.hero.life) : healAmmount 
            console.log(`${this.hero.name} está enfurecido!`)
        },
        turnIntoFemto() {
            this.villan.name = 'Femto'
            this.villan.femto = true
            this.villan.maxLife = 1000
            this.villan.life = this.villan.maxLife
        },
        heal(isHero) {
            let character = isHero ? this.hero : this.villan
            let healAmmount = 30
            character.life += (character.life + healAmmount > character.maxLife) ? (character.maxLife - character.life) : healAmmount 
            character.elfPowder--
            console.log(`${character.name} curado em ${healAmmount} de HP!`)
        },
        endGame(isHero) {
            isHero ? this.victory() : this.defeat()
        },
        defeat() {
            this.endingTitle = `Derrota`
            this.endingMsg = `${this.hero.name} Perdeu...${this.villan.name} Venceu...`
            this.gameover = true
        },
        victory() {
            this.endingTitle = `Vitória`
            this.endingMsg = `${this.villan.name} Perdeu! ${this.hero.name} Venceu!`
            this.gameover = true
        },
        passRound() {
            this.round++
            this.villanAct()
            if(this.villan.life == 0) {
                if(!this.villan.femto) {
                    this.turnIntoFemto()
                } else {
                    this.endGame(true)
                }
            }
            if(this.round % 10 == 0) {
                this.giveElfPowder(true)
                this.giveElfPowder(false)
            }
        },
        villanAct() {
            let actions = ['attack', 'defend', 'use', 'stand']
            if(this.villan.life == this.villan.maxLife || this.villan.elfPowder == 0) {
                actions.splice(actions.indexOf('use'), 1)
            }
            if(this.villan.defend) {
                actions.splice(actions.indexOf('defend'), 1)
                actions.splice(actions.indexOf('attack'), 1)
                actions.push('stopDefending')
            }
            const randomAction = actions[Math.floor(Math.random() * actions.length)]
            this[randomAction](false)
        },
        reset() {
            window.location.reload(true)
        }
    }
}).mount('#app')