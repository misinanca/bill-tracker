<template>
    <div class="list">
        <div class="list-heading">
            <div>
                <h1 class="text-white mb-5">List of all bills</h1>
            </div>
            <div class="mt-1">
                <button class="btn btn-primary">Add new bill</button>
            </div>
        </div>
        <b-alert 
            variant="danger"
            dismissible
            fade
            :show="showAlert"
            @dismissed="showAlert=false"
        >
            {{ error }}
        </b-alert>
        <div class="container">
            <b-table hover striped dark :items="items" :fields="tableFields" :busy="isBusy" class="list-table">
                <div slot="table-busy" class="text-center text-danger my-2">
                    <b-spinner class="align-middle mr-2"></b-spinner>
                    <strong>Loading...</strong>
                </div>
            </b-table>
        </div>
    </div>
</template>

<script>
import AXIOS from '@/http-common';

export default {
    mounted() {
        this.toggleBusy();
        // TODO: replace api url with bills list 
        AXIOS.get('/getFilteredBills?status=true')
            .then((response) => {
                this.toggleBusy();
                this.$store.commit('setBillsList', response.data);
                this.$store.commit('setError', null);
                this.showAlert = false;

                console.log(response.data);
            })
            .catch((error) => {
                this.showAlert = true;
                this.$store.commit('setError', 'Something went wrong. Please try again.');
            });
    },
    data() {
        return {
            isBusy: false,
            tableFields: {
                name: {
                    label: 'Name',
                    sortable: true,
                },
                due: {
                    label: 'Due date',
                    sortable: true,
                },
                details: {
                    label: 'Details',
                    sortable: false,
                },
                status: {
                    label: 'Status',
                    sortable: true,
                },
                commands: {
                    label: '',
                    sortable: false,
                },
            },
            showAlert: false,
        };
    },
    computed: {
        error() {
            return this.$store.getters.error;
        },
        items() {
            return this.$store.getters.billsList;
        },
    },
    methods: {
        toggleBusy(){
            this.isBusy = !this.isBusy;
        },
    },
}
</script>
