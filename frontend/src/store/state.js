import Cookies from 'js-cookie';

export const state = {
    isAuthenticated: Cookies.get('AUTH'),
    user: null,
    error: null,
    loading: false,
}