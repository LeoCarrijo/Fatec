const { createApp } = Vue;

createApp({
    data() {
        return {
            hero: {
                life: 100,
                name: 'Guts'
            },
            villan: {
                life: 100,
                name: 'Griffith'
            }
        }
    },
    methods: {
        handlerClick(opt) {
            switch(opt) {
                case 'attack':
                    this.attack()
                case 'defend':
                    this.defend()
                case 'use':
                    this.use()
                case 'flee':
                    this.flee()
            }
        },
        attack() {
            
        },
        defend() {

        },
        use() {

        },
        flee() {

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