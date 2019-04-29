<template>
  <div class="user">
    <h1>Login</h1>

    <input type="text" v-model="user.username" placeholder="User name">
    <input type="password" v-model="user.password" placeholder="Password">

    <button @click="login()">Login</button>

  </div>
</template>

<script>
// import axios from 'axios'
import {AXIOS} from './http-common'

export default {
  name: 'login',
  data () {
    return {
      response: [],
      errors: [],
      user: {
        username: '',
        password: '',
      },
    };
  },
  methods: {
    // Fetches posts when the component is created.
    login () {
      var params = new URLSearchParams();
      params.append('username', this.user.username);
      params.append('password', this.user.password);

      AXIOS.post(`/login`, params)
        .then(response => {
          // JSON responses are automatically parsed.
          this.response = response.data;
          console.log(response.data);
        })
        .catch(e => {
          this.errors.push(e);
        })
    },
  }
}
</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }
</style>
