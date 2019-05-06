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
import {AXIOS} from '../http-common';

export default {
  name: 'login',
  data () {
    return {
      response: [],
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
