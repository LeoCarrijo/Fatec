const { createApp } = Vue;

createApp({
    data() {
        return {
            hero: {
                life: 100,
                name: 'Guts',
                maxDmg: 10,
                defended: false,
                defenseArmor: 2
            },
            villan: {
                life: 100,
                name: 'Griffith',
                maxDmg: 10,
                defended: false,
                defenseArmor: 2
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
                    this.use()
                    break
                case 'flee':
                    this.flee()
                    break
            }
        },
        attack(isHero) {
            if(isHero) {
                let dmg = this.generateRng(this.hero.maxDmg)
                this.causeDamage(dmg, isHero)
                console.log(`${dmg} de dano causado`)
                console.log(`Vida de ${this.villan.name}: ${this.villan.life}`)
            } else {
                let dmg = this.generateRng(this.villan.maxDmg)
                this.causeDamage(dmg, isHero)
                console.log(`${dmg} de dano causado`)
                console.log(`Vida de ${this.hero.name}: ${this.hero.life}`)
            }
        },
        defend(isHero) {
            if(isHero) {
                this.hero.defend = true
                this.hero.defenseArmor = 2
                console.log(`${this.hero.name} está defendendo com ${this.hero.defenseArmor} de armadura`)
            } else {
                this.villan.defend = true
                this.villan.defenseArmor = 2
                console.log(`${this.villan.name} está defendendo com ${this.villan.defenseArmor} de armadura`)
            }
        },
        use() {

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
            if(isHero) {
                if(!this.villan.defend) {
                    this.villan.life -= dmg
                    if(this.villan.life < 0) {
                        this.villan.life = 0
                    }
                } else {
                    this.villan.defenseArmor -= 1
                    console.log(`${this.villan.defenseArmor} de armadura restante`)
                    if(this.villan.defenseArmor == 0) {
                        this.villan.defend = false
                    }
                }
            } else {
                if (!this.hero.defend) {
                    this.hero.life -= dmg
                    if(this.hero.life < 0) {
                        this.hero.life = 0
                    }
                } else {
                    this.hero.defenseArmor -= 1
                    if(this.hero.defenseArmor == 0) {
                        this.hero.defend = false
                    }
                }
            }
        }
        // attack(isHero) {

        // },
        // defend(isHero) {
            
        // },
        // use(isHero) {

        // },
        // flee() {

        // },
        // villanAction() {
        //     const actions = ['attack', 'defend', 'usePotion', 'flee']
        //     const randomAction = actions[Math.floor(Math.random() * actions.length)]
        //     this[randomAction](false)
        // }
    }
}).mount('#app')