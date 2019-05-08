<template>
  <div id="app">
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <router-link class="navbar-brand js-scroll-trigger" to="/">Bill tracker</router-link>
        <div class="collapse navbar-collapse">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <router-link class="nav-link js-scroll-trigger mr-4" to="/">Home</router-link>
            </li>
            <li v-if="!isAuthenticated" class="nav-item">
              <router-link class="nav-link js-scroll-trigger" to="login">Login</router-link>
            </li>
            <li v-else class="nav-item">
              <router-link disabled class="nav-link js-scroll-trigger" to="/">Welcome</router-link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="masthead">
      <div class="container d-flex h-100 align-items-center justify-content-center">
        <router-view />
      </div>
    </div>
  </div>
</template>

<script>
import Cookies from 'js-cookie';

export default {
  name: 'app',
  computed: {
    isAuthenticated() {
      return Cookies.get('AUTH') !== undefined;
    },
  },
}
</script>

<style lang="scss">
@import './assets/css/global.scss';

#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
