import router from '@/router';
import { AXIOS } from '../http-common'
// import { EventBus } from '../event-bus.js';

export const actions = {
    userSignIn ({commit}, payload) {
        const data = {
            username: payload.username,
            password: payload.password,
        };

        AXIOS.post('/public/users/login', data)
            .then(res => {
                commit ('setLoading', false);
                commit ('setError', null);

                commit ('setAuth', true);
                EventBus.$emit('authenticated', 'User authenticated');
                router.push('/home');
            })
            .catch(error => {
                commit('setError', error.message);
                commit('setLoading', false);
            });
    },
    userSignOut ({commit}) {
        AXIOS.post('/public/users/logout')
            .then(res => {
                commit ('setLoading', false);
                commit ('setError', null);

                commit ('clearAuth');
                // EventBus.$emit('authenticated', 'User not authenticated');
                router.push('/');
            })
            .catch(error => {
                commit('setError', error.message);
                commit('setLoading', false);
            });
    },
}