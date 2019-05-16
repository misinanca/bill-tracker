<template>
    <form>
     <div class="form-row">
        <div class="form-group col-md-6">
          <input
            v-model="bill.name"
            type="text"
            class="form-control"
            name="billName"
            placeholder="Name"
          />
        </div>
        <div class="form-group col-md-6">
          <input
            v-model="bill.date"
            type="text"
            class="form-control"
            name="billDate"
            placeholder="Date"
          />
        </div>
     </div>
    </form>
</template>
<script>
export default {
    name: 'save',
    data () {
        return {
        bill: {}
    };
  }
}
</script>