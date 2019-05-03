<template>
  <div class="page">
    <h2 class="text-white mb-5">Register</h2>
    <b-alert 
      variant="danger"
      dismissible
      fade
      :show="showAlert"
      @dismissed="showAlert=false"
    >
      {{ errorMessage }}
    </b-alert>
    <form @submit.prevent="register">
      <div class="form-row">
        <div class="form-group col-md-6">
          <input
            v-model="user.username"
            type="text"
            class="form-control"
            id="inputUsername"
            placeholder="Username"
          />
        </div>
        <div class="form-group col-md-6">
          <input
            v-model="user.password"
            type="password"
            class="form-control"
            id="inputPass"
            placeholder="Password"
          />
        </div>
      </div>
      <div class="form-row">
        <div class="form-group col-md-6">
          <input
            v-model="user.firstName"
            type="text"
            class="form-control"
            id="inputFirstName"
            placeholder="First Name"
          />
        </div>
        <div class="form-group col-md-6">
          <input
            v-model="user.lastName"
            type="text"
            class="form-control"
            id="inputLastName"
            placeholder="Last Name"
          />
        </div>
      </div>
      <div class="form-row">
        <div class="form-group col-md-12">
          <input
            v-model="user.address"
            type="text"
            class="form-control"
            id="inputAddress"
            placeholder="Address"
          />
        </div>
      </div>
      <div class="form-row">
        <div class="form-group col-md-12">
          <input
            v-model="user.email"
            type="email"
            class="form-control"
            id="inputEmail"
            placeholder="Email address"
          />
        </div>
      </div>
      <button class="btn btn-primary mx-auto">Register</button>
    </form>
  </div>
</template>

<script>
// import axios from 'axios'
import {AXIOS} from './http-common'

export default {
  name: 'register',
  data () {
    return {
      user: {},
      errorMessage: '',
      showAlert: false,
    };
  },
  methods: {
    // Fetches posts when the component is created.
    register () {
      AXIOS.post(`/users/register`, this.user)
        .then(response => {
          debugger;

          // make store to store user data and redirect to a welcome page
          this.response = response.data;
          console.log(response.data);
        })
        .catch(e => {
          this.showAlert = true;
          this.errorMessage = 'Something went wrong. Please try again.';
        })
    },
  }
}
</script>
