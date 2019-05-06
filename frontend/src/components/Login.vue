<template>
  <div class="page">
    <h2 class="text-white mb-5">Login</h2>
    <b-alert 
      variant="danger"
      dismissible
      fade
      :show="showAlert"
      @dismissed="showAlert=false"
    >
      {{ error }}
    </b-alert>
      <form @submit.prevent="login">
        <div class="form-col">
          <div class="form-group mx-auto col-md-6">
            <input
              v-validate="'required|min:6'"
              v-model="user.username"
              type="text"
              class="form-control"
              id="inputUsername"
              name="username"
              placeholder="Username"
            />
            <span class="error-message">{{ errors.first('username') }}</span>
          </div>
          <div class="form-group mx-auto col-md-6">
            <input
              v-validate="'required|min:6'"          
              v-model="user.password"
              type="password"
              class="form-control"
              id="inputPass"
              name="password"
              placeholder="Password"
            />
            <span class="error-message">{{ errors.first('password') }}</span>          
          </div>
        </div>
        <button class="btn btn-primary mx-auto mt-5">Login</button>
      </form>
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
      showAlert: false
    };
  },
  computed: {
      error () {
        return this.$store.getters.getError;
    },
  },
  methods: {
    // Fetches posts when the component is created.
    login () {
      // var params = new URLSearchParams();
      // params.append('username', this.user.username);
      // params.append('password', this.user.password);
      this.$validator.validate()
        .then((valid) => {
          if (valid) {
            return this.callApi();
          }
        }).catch(() => {
          this.showAlert = true;
          this.$store.commit('setError', 'Something went wrong. Please try again.');
        }); 
    },
    callApi(){
      AXIOS.post(`/auth`,this.user)
        .then(response => {
          this.$store.commit('setError', null);
          this.$store.commit('setUser', {id:response.data.id , username: response.data.username});
          this.$store.commit('setAuth', response.data.accessToken);
          this.showAlert = false;

          this.$router.push({ name: 'Bootstrap' });
          console.log(response.data);
        })
        .catch(error => {
          this.showAlert = true;
          this.$store.commit('setError', 'Something went wrong. Please try again.');
        })
      },
  },
}
</script>
