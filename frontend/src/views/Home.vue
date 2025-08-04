<script setup>
import {getItems} from "@/services/itemService.js";
import {reactive} from "vue";
import Card from "@/components/Card.vue";

//반응형 상태
const state = reactive({
  items: []
});

//커스텀 생성 훅
(async function onCreated() {
  const res = await getItems();

  if(res.status === 200){
    console.log(res.data);
    state.items = res.data;
  }
})();
</script>

<template>
  <div class="home">
    <div class="album py-5 bg-light">
      <div class="container">
        <div class="row row-cols-1 row-cols-lg-2 row-cols-xl-3 g-3">
          <div class="col" v-for="item in state.items"> <!--v-for 디렉티브를 이용해 상품 데이터의 개수만큼 반복해서 출력 -->
            <Card :item="item"/>
            <!-- 스크립트 블록에서 임포ㅌ한 카드 컴포넌트 요소를 입력, item 속성에 각 상품 데이터 (state.items) 를 입력해 전달-->
          </div>
        </div>
      </div>
    </div>
  </div>
</template>