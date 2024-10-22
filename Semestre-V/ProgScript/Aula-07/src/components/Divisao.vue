<script setup>
    defineProps(
        {
            x: {
                type: String,
                default: "0",
                required: true
            },
            y: {
                type: String,
                default: "1",
                required: true
            }
        }
    )
</script>

<template>
    <p>{{ Number(x) }} / {{ Number(y) }} = {{ Number(x) / Number(y) }}</p>
</template>

<style scoped>

</style>