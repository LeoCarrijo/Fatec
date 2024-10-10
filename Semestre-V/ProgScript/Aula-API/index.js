const { createApp } = Vue;

createApp({
    data() {
        return {
            pokemons: [],
            loading: true,
            searchText: '',
            nextPage: 1,
        }
    },
    created() {
        this.callAPI()
        window.addEventListener('scroll', this.handleScroll)
    },
    destroyed() {
        window.removeEventListener('scroll', this.handleScroll)
    },
    methods: {
        async callAPI() {
            try {
                const response = await fetch(`https://pokeapi.co/api/v2/pokemon/?offset=${(this.nextPage - 1) * 151}&limit=${151}`)
                const data = await response.json();
                const pokemonDetailsPromises = data.results.map(async pokemon => this.fetchPokemonData(pokemon.url));
                console.log(pokemonDetailsPromises)
                const pokemonDetails = await Promise.all(pokemonDetailsPromises);
                console.log(pokemonDetails)
                this.pokemons = [...this.pokemons, ...pokemonDetails]
                this.nextPage++
                console.log(this.pokemons)
                this.loading = false
            } catch (error) {
                console.error(error);
            }
        },
        async fetchPokemonData(url) {
            try {
                const response = await fetch(url);
                const data = await response.json();
                return {
                    id: data.id,
                    name: data.name,
                    weight: data.weight,
                    types: data.types,
                    sprites: data.sprites,
                    showDetails: false
                }
            } catch (e){
                console.error(e);
            }
        },
        searchPokemon() {
            const pokemonInput = document.getElementById("pokemonInput").value
            console.log(pokemonInput)
        },
        handleScroll() {
            const bottomOfWindow = document.documentElement.scrollTop + window.innerHeight === document.documentElement.offsetHeight
            if(bottomOfWindow && !this.loading) {
                this.loading = true
                this.callAPI()
            }
        },
        getTypeClass(type) {
            const classTypeMap = {
                fire: 'fire',
                grass: 'grass',
                dragon: 'dragon',
                ice: 'ice',
                fighting: 'fighting',
                ground: 'ground',
                bug: 'bug',
                normal: 'normal',
                poison: 'poison',
                electric: 'electric',
                rock: 'rock',
                steel: 'steel',
                psychic: 'psychic',
                fairy: 'fairy',
                dark: 'dark',
                water: 'water',
                flying: 'flying',
                ghost: 'ghost'
            }
        }
    }
}).mount("#app");