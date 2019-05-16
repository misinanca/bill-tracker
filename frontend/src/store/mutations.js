export const mutations = {
  setIsAuth(state, payload) {
    state.isAuth = payload;
  },
  setUser(state, payload) {
    state.user = payload;
  },
  setError(state, payload) {
    state.error = payload;
  },
  setLoading(state, payload) {
    state.loading = payload;
  },
}