import Vue from 'vue';
import Router from 'vue-router';
import Home from '@/components/Home';
import Bootstrap from '@/components/Bootstrap';
import Login from '@/components/Login';
import Register from '@/components/Register';
import BillsList from '@/components/bills/BillsList';

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home,
    },
    {
      path: '/bootstrap',
      name: 'Bootstrap',
      component: Bootstrap,
    },
    {
      path: '/login',
      name: 'Login',
      component: Login,
    },
    {
      path: '/register',
      name: 'Register',
      component: Register,
    },
    {
      path: '/bills',
      name: 'BillsList',
      component: BillsList,
    },
  ]
})
