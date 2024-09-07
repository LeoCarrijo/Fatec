const { createApp } = Vue;

createApp({
    data() {
        return {
            hero: {
                life: 100,
                name: 'Guts',
                maxDmg: 10
            },
            villan: {
                life: 100,
                name: 'Griffith',
                maxDmg: 10
            }
        }
    },
    methods: {
        handlerClick(opt) {
            switch(opt) {
                case 'attack':
                    this.attack(true)
                case 'defend':
                    this.defend()
                case 'use':
                    this.use()
                case 'flee':
                    this.flee()
            }
        },
        attack(isHero) {
            if(isHero) {
                let dmg = this.generateRng(this.hero.maxDmg)
                this.causeDamage(this.villan.life, dmg, isHero)
                console.log(`${dmg} de dano causado`)
                console.log(`Vida de ${this.villan.name}: ${this.villan.life}`)
            } else {
                let dmg = this.generateRng(this.villan.maxDmg)
                this.causeDamage(this.villan.life, dmg, isHero)
                console.log(`${dmg} de dano causado`)
                console.log(`Vida de ${this.hero.name}: ${this.hero.life}`)
            }
        },
        defend() {

        },
        use() {

        },
        flee() {

        },
        generateRng(max) {
            return (Math.floor(Math.random() * max))
        },
        causeDamage(life, dmg, isHero) {
            if(isHero) {
                this.villan.life -= dmg
                if(this.villan.life < 0) {
                    this.villan.life = 0
                }
            } else {
                this.hero.ife -= dmg
                if(this.hero.life < 0) {
                    this.hero.life = 0
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