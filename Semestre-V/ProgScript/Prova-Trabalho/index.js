const { createApp } = Vue;

createApp({
    data() {
        return {
            hero: {
                life: 100,
                maxLife: 100,
                rage: 100,
                maxRage: 100,
                berserkMode: true,
                berserkDmgMult: 3,
                minBerkserkDmg: 3,
                name: 'Guts',
                maxDmg: 10,
                defended: false,
                defenseArmor: 2,
                elfPowder: 3
            },
            villan: {
                life: 200,
                maxLife: 200,
                name: 'Griffith',
                maxDmg: 10,
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
        },
        attack(isHero) {
            let character = isHero ? this.hero : this.villan
            let foe = !isHero ? this.hero : this.villan
            let dmg = this.generateRng(character.maxDmg)
            if(isHero && this.hero.berserkMode) {
                dmg = dmg < this.hero.minBerkserkDmg ? this.hero.minBerkserkDmg : dmg
                dmg *= this.hero.berserkDmgMult
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
                this.hero.berserkMode = true

                console.log(`${this.hero.name} está enfurecido!`)
            }
        },
        turnIntoBerserk() {
            this.hero.berserkMode = true
            let healAmmount = this.hero.maxLife / 2
            this.hero.life += (this.hero.life + healAmmount > this.hero.maxLife) ? (this.hero.maxLife - this.hero.life) : healAmmount 
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
            console.log(`${this.hero.name} Perdeu...\n${this.villan.name} Venceu...`)
        },
        victory() {
            console.log(`${this.villan.name} Perdeu!\n${this.hero.name} Venceu!`)
        }
        // villanAction() {
        //     const actions = ['attack', 'defend', 'usePotion', 'flee']
        //     const randomAction = actions[Math.floor(Math.random() * actions.length)]
        //     this[randomAction](false)
        // }
    }
}).mount('#app')