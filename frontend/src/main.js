import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import Vue from 'vue';
import App from './App.vue';
import router from './router/index';
import store from './store';
import BootstrapVue from 'bootstrap-vue';
import VeeValidate from 'vee-validate';

Vue.config.productionTip = false

// Bootstrap
Vue.use(BootstrapVue)
Vue.use(VeeValidate);

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app');

