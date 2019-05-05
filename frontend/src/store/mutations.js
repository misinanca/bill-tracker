import Cookies from "js-cookie";

export const mutations = {
  setUser(state, payload) {
    state.user = payload;
  },
  setAuth(payload) {
    Cookies.set('AUTH', payload);
  },
  clearAuth() {
    Cookies.remove('AUTH');
  },
  setError(state, payload) {
    state.error = payload;
  },
  setLoading(state, payload) {
    state.loading = payload;
  },
}