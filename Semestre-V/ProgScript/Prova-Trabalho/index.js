const { createApp } = Vue;

createApp({
    data() {
        return {
            hero: {
                life: 100,
                maxLife: 100,
                name: 'Guts',
                maxDmg: 10,
                defended: false,
                defenseArmor: 2,
                elfPowder: 3
            },
            villan: {
                life: 100,
                maxLife: 100,
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
        use(isHero) {
            this.heal(isHero)
        },
        flee() {

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
        heal(isHero) {
            let character = isHero ? this.hero : this.villan
            let healAmmount = 30
            character.life += (character.life + healAmmount > character.maxLife) ? (character.maxLife - character.life) : healAmmount 
            console.log(`${character.name} curado em ${healAmmount} de HP!`)
        }
        // villanAction() {
        //     const actions = ['attack', 'defend', 'usePotion', 'flee']
        //     const randomAction = actions[Math.floor(Math.random() * actions.length)]
        //     this[randomAction](false)
        // }
    }
}).mount('#app')