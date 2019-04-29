<template>
  <div>
    <h1>Register</h1>

    <input type="text" v-model="user.username" placeholder="Username">
    <input type="password" v-model="user.password" placeholder="Password">

    <button @click="register()">Register</button>

  </div>
</template>

<script>
// import axios from 'axios'
import {AXIOS} from './http-common'

export default {
  name: 'register',
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
    register () {
      var params = new URLSearchParams();
      params.append('username', this.user.username);
      params.append('password', this.user.password);

      AXIOS.post(`/register`, params)
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
