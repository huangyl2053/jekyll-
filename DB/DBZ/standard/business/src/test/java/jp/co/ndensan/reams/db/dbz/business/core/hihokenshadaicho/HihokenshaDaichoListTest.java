/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.hihokenshadaicho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 * {@link HihokenshaDaichoList}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoListTest extends DbzTestBase {

    public static class constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数がnullのとき_NullPointerExceptionをスローする() {
            HihokenshaDaichoList hihokenshaDaichoList = new HihokenshaDaichoList(null);
        }

    }

    public static class toOneSeasonList extends DbzTestBase {
        //TODO #52997
        //テスト用の被保険者台帳Listを用意し、toOneSeasonListを実行します。
        //実行した結果の戻り値が、想定した結果になっているかをテストしてください。
        //
        //例：5件のテストデータを用意してtoOneSeasonListを実行 →　2件のデータが抽出できる場合
        //1, to資格得喪Listのsizeは2となるか。
        //2, 戻り値のListの1番目の要素が持つ資格取得日は、引数から受け取った資格取得日と一致するか。
        //2, 戻り値のListの2番目の要素が持つ資格取得日は、引数から受け取った資格取得日と一致するか。

        private List<HihokenshaDaicho> hihoDaichoList;
        private FlexibleDate matchDate;
        private FlexibleDate noMatchDate;

        @Before
        public void setUp() {
            hihoDaichoList = new ArrayList<>();
            matchDate = new FlexibleDate("20150101");
            noMatchDate = new FlexibleDate("20150201");

            DbT1001HihokenshaDaichoEntity entity1 = createEntity();
            entity1.setShikakuShutokuYMD(matchDate);
            HihokenshaDaicho hihokenshaDaichoModel1 = new HihokenshaDaicho(entity1);
            hihoDaichoList.add(hihokenshaDaichoModel1);

            DbT1001HihokenshaDaichoEntity entity2 = createEntity();
            entity2.setShikakuShutokuYMD(noMatchDate);
            HihokenshaDaicho hihokenshaDaichoModel2 = new HihokenshaDaicho(entity2);
            hihoDaichoList.add(hihokenshaDaichoModel2);

            DbT1001HihokenshaDaichoEntity entity3 = createEntity();
            entity3.setShikakuShutokuYMD(matchDate);
            HihokenshaDaicho hihokenshaDaichoModel3 = new HihokenshaDaicho(entity3);
            hihoDaichoList.add(hihokenshaDaichoModel3);

            DbT1001HihokenshaDaichoEntity entity4 = createEntity();
            entity4.setShikakuShutokuYMD(noMatchDate);
            HihokenshaDaicho hihokenshaDaichoModel4 = new HihokenshaDaicho(entity4);
            hihoDaichoList.add(hihokenshaDaichoModel4);

            DbT1001HihokenshaDaichoEntity entity5 = createEntity();
            entity5.setShikakuShutokuYMD(noMatchDate);
            HihokenshaDaicho hihokenshaDaichoModel5 = new HihokenshaDaicho(entity5);
            hihoDaichoList.add(hihokenshaDaichoModel5);
        }

        @Test
        public void toOneSeasonListで_2件のデータが取得できる() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).toOneSeasonList(matchDate);
            assertThat(result.size(), is(2));
        }

        @Test
        public void toOneSeasonListで取得したデータの1件目は_指定した日付と同一の日付を持つ() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).toOneSeasonList(matchDate);
            assertThat(result.toList().get(0).get資格取得年月日(), is(matchDate));
        }

        @Test
        public void toOneSeasonListで取得したデータの2件目は_指定した日付と同一の日付を持つ() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).toOneSeasonList(matchDate);
            assertThat(result.toList().get(1).get資格取得年月日(), is(matchDate));
        }
    }

    public static class to降順List extends DbzTestBase {

        private List<HihokenshaDaicho> hihoDaichoList;
        private FlexibleDate idoDate1;
        private FlexibleDate idoDate2;
        private RString edaNo1;
        private RString edaNo2;

        @Before
        public void setUp() {
            hihoDaichoList = new ArrayList<>();
            idoDate1 = new FlexibleDate("20150101");
            idoDate2 = new FlexibleDate("20160101");
            edaNo1 = new RString("0001");
            edaNo2 = new RString("0002");

            DbT1001HihokenshaDaichoEntity entity1 = createEntity();
            entity1.setIdoYMD(idoDate1);
            entity1.setShikakuShutokuYMD(idoDate1);
            entity1.setEdaNo(edaNo1);
            HihokenshaDaicho hihokenshaDaichoModel1 = new HihokenshaDaicho(entity1);

            DbT1001HihokenshaDaichoEntity entity2 = createEntity();
            entity2.setIdoYMD(idoDate1);
            entity2.setShikakuShutokuYMD(idoDate1);
            entity2.setEdaNo(edaNo2);
            HihokenshaDaicho hihokenshaDaichoModel2 = new HihokenshaDaicho(entity2);

            DbT1001HihokenshaDaichoEntity entity3 = createEntity();
            entity3.setIdoYMD(idoDate2);
            entity3.setShikakuShutokuYMD(idoDate2);
            entity3.setEdaNo(edaNo1);
            HihokenshaDaicho hihokenshaDaichoModel3 = new HihokenshaDaicho(entity3);

            hihoDaichoList.add(hihokenshaDaichoModel1);
            hihoDaichoList.add(hihokenshaDaichoModel3);
            hihoDaichoList.add(hihokenshaDaichoModel2);
        }

        @Test
        public void to降順Listで3件のデータが取得出来る() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to降順List();
            assertThat(result.size(), is(3));
        }

        @Test
        public void to降順Listで取得したデータの1件目は_元データの2件目のデータとキーが一致する() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to降順List();
            HihokenshaDaicho testData = result.toList().get(0);
            HihokenshaDaicho motoData = hihoDaichoList.get(1);
            boolean isEqualKeys = testData.get被保険者番号().equals(motoData.get被保険者番号())
                    && testData.get異動日().equals(motoData.get異動日())
                    && testData.get枝番().equals(motoData.get枝番());
            assertThat(isEqualKeys, is(true));
        }

        @Test
        public void to降順Listで取得したデータの2件目は_元Listの3件のデータとキーが一致する() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to降順List();
            HihokenshaDaicho testData = result.toList().get(1);
            HihokenshaDaicho motoData = hihoDaichoList.get(2);
            boolean isEqualKeys = testData.get被保険者番号().equals(motoData.get被保険者番号())
                    && testData.get異動日().equals(motoData.get異動日())
                    && testData.get枝番().equals(motoData.get枝番());
            assertThat(isEqualKeys, is(true));
        }

        @Test
        public void to降順Listで取得したデータの3件目は_元Listの1件のデータとキーが一致する() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to降順List();
            HihokenshaDaicho testData = result.toList().get(2);
            HihokenshaDaicho motoData = hihoDaichoList.get(0);
            boolean isEqualKeys = testData.get被保険者番号().equals(motoData.get被保険者番号())
                    && testData.get異動日().equals(motoData.get異動日())
                    && testData.get枝番().equals(motoData.get枝番());
            assertThat(isEqualKeys, is(true));
        }
    }

    public static class to昇順List extends DbzTestBase {

        private List<HihokenshaDaicho> hihoDaichoList;
        private FlexibleDate idoDate1;
        private FlexibleDate idoDate2;
        private RString edaNo1;
        private RString edaNo2;

        @Before
        public void setUp() {
            hihoDaichoList = new ArrayList<>();
            idoDate1 = new FlexibleDate("20150101");
            idoDate2 = new FlexibleDate("20160101");
            edaNo1 = new RString("0001");
            edaNo2 = new RString("0002");

            DbT1001HihokenshaDaichoEntity entity1 = createEntity();
            entity1.setIdoYMD(idoDate1);
            entity1.setShikakuShutokuYMD(idoDate1);
            entity1.setEdaNo(edaNo1);
            HihokenshaDaicho hihokenshaDaichoModel1 = new HihokenshaDaicho(entity1);

            DbT1001HihokenshaDaichoEntity entity2 = createEntity();
            entity2.setIdoYMD(idoDate1);
            entity2.setShikakuShutokuYMD(idoDate1);
            entity2.setEdaNo(edaNo2);
            HihokenshaDaicho hihokenshaDaichoModel2 = new HihokenshaDaicho(entity2);

            DbT1001HihokenshaDaichoEntity entity3 = createEntity();
            entity3.setIdoYMD(idoDate2);
            entity3.setShikakuShutokuYMD(idoDate2);
            entity3.setEdaNo(edaNo1);
            HihokenshaDaicho hihokenshaDaichoModel3 = new HihokenshaDaicho(entity3);

            hihoDaichoList.add(hihokenshaDaichoModel3);
            hihoDaichoList.add(hihokenshaDaichoModel1);
            hihoDaichoList.add(hihokenshaDaichoModel2);
        }

        @Test
        public void to昇順Listで3件のデータが取得出来る() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to昇順List();
            assertThat(result.size(), is(3));
        }

        @Test
        public void to昇順Listで取得したデータの1件目は_元データの2件目のデータとキーが一致する() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to昇順List();
            HihokenshaDaicho testData = result.toList().get(0);
            HihokenshaDaicho motoData = hihoDaichoList.get(1);
            boolean isEqualKeys = testData.get被保険者番号().equals(motoData.get被保険者番号())
                    && testData.get異動日().equals(motoData.get異動日())
                    && testData.get枝番().equals(motoData.get枝番());
            assertThat(isEqualKeys, is(true));
        }

        @Test
        public void to昇順Listで取得したデータの2件目は_元Listの3件のデータとキーが一致する() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to昇順List();
            HihokenshaDaicho testData = result.toList().get(1);
            HihokenshaDaicho motoData = hihoDaichoList.get(2);
            boolean isEqualKeys = testData.get被保険者番号().equals(motoData.get被保険者番号())
                    && testData.get異動日().equals(motoData.get異動日())
                    && testData.get枝番().equals(motoData.get枝番());
            assertThat(isEqualKeys, is(true));
        }

        @Test
        public void to昇順Listで取得したデータの3件目は_元Listの1件のデータとキーが一致する() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to昇順List();
            HihokenshaDaicho testData = result.toList().get(2);
            HihokenshaDaicho motoData = hihoDaichoList.get(0);
            boolean isEqualKeys = testData.get被保険者番号().equals(motoData.get被保険者番号())
                    && testData.get異動日().equals(motoData.get異動日())
                    && testData.get枝番().equals(motoData.get枝番());
            assertThat(isEqualKeys, is(true));
        }
    }

    public static class to資格得喪List extends DbzTestBase {

        //TODO #52997
        //テスト用の被保険者台帳Listを用意し、to資格得喪Listを実行します。
        //実行した結果の戻り値が、想定した結果になっているかをテストしてください。
        //
        //例：5件のテストデータを用意してto資格得喪Listを実行 →　5件のテストデータの2番目と4番目と5番目を持つListが戻り値となる場合
        //1, to資格得喪Listのsizeは3となるか。
        //2, テスト用の被保険者台帳Listの2番目の要素が持つキー項目と、戻り値のListの3番目の要素が持つキー項目は一致するか。
        //3, テスト用の被保険者台帳Listの4番目の要素が持つキー項目と、戻り値のListの2番目の要素が持つキー項目は一致するか。
        //4, テスト用の被保険者台帳Listの5番目の要素が持つキー項目と、戻り値のListの1番目の要素が持つキー項目は一致するか。
        private List<HihokenshaDaicho> hihoDaichoList;
        private FlexibleDate tekiyoDate1;
        private FlexibleDate kaijoDate1;
        private FlexibleDate tekiyoDate2;
        private FlexibleDate kaijoDate2;
        private FlexibleDate tekiyoDate3;

        @Before
        public void setUp() {
            hihoDaichoList = new ArrayList<>();
            tekiyoDate1 = new FlexibleDate("20150101");
            kaijoDate1 = new FlexibleDate("20150701");
            tekiyoDate2 = new FlexibleDate("20160101");
            kaijoDate2 = new FlexibleDate("20160801");
            tekiyoDate3 = new FlexibleDate("20170101");

            DbT1001HihokenshaDaichoEntity entity1 = createEntity();
            entity1.setIdoYMD(tekiyoDate1);
            entity1.setShikakuShutokuYMD(tekiyoDate1);
            entity1.setShikakuSoshitsuYMD(FlexibleDate.EMPTY);
            HihokenshaDaicho hihokenshaDaichoModel1 = new HihokenshaDaicho(entity1);
            hihoDaichoList.add(hihokenshaDaichoModel1);

            DbT1001HihokenshaDaichoEntity entity2 = createEntity();
            entity2.setIdoYMD(kaijoDate1);
            entity2.setShikakuShutokuYMD(tekiyoDate1);
            entity2.setShikakuSoshitsuYMD(kaijoDate1);
            HihokenshaDaicho hihokenshaDaichoModel2 = new HihokenshaDaicho(entity2);
            hihoDaichoList.add(hihokenshaDaichoModel2);

            DbT1001HihokenshaDaichoEntity entity3 = createEntity();
            entity3.setIdoYMD(tekiyoDate2);
            entity3.setShikakuShutokuYMD(tekiyoDate2);
            entity3.setShikakuSoshitsuYMD(FlexibleDate.EMPTY);
            HihokenshaDaicho hihokenshaDaichoModel3 = new HihokenshaDaicho(entity3);
            hihoDaichoList.add(hihokenshaDaichoModel3);

            DbT1001HihokenshaDaichoEntity entity4 = createEntity();
            entity4.setIdoYMD(kaijoDate2);
            entity4.setShikakuShutokuYMD(tekiyoDate2);
            entity4.setShikakuSoshitsuYMD(kaijoDate2);
            HihokenshaDaicho hihokenshaDaichoModel4 = new HihokenshaDaicho(entity4);
            hihoDaichoList.add(hihokenshaDaichoModel4);

            DbT1001HihokenshaDaichoEntity entity5 = createEntity();
            entity5.setIdoYMD(tekiyoDate3);
            entity5.setShikakuShutokuYMD(tekiyoDate3);
            entity5.setShikakuSoshitsuYMD(FlexibleDate.EMPTY);
            HihokenshaDaicho hihokenshaDaichoModel5 = new HihokenshaDaicho(entity5);
            hihoDaichoList.add(hihokenshaDaichoModel5);
        }

        @Test
        public void to資格得喪Listで3件のデータが取得出来る() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to資格得喪List();
            assertThat(result.size(), is(3));
        }

        @Test
        public void to資格得喪Listで取得したデータの1件目は_元Listの5件のデータとキーが一致する() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to資格得喪List();
            HihokenshaDaicho testData = result.toList().get(0);
            HihokenshaDaicho motoData = hihoDaichoList.get(4);
            boolean isEqualKeys = testData.get被保険者番号().equals(motoData.get被保険者番号())
                    && testData.get異動日().equals(motoData.get異動日())
                    && testData.get枝番().equals(motoData.get枝番());
            assertThat(isEqualKeys, is(true));
        }

        @Test
        public void to資格得喪Listで取得したデータの2件目は_元Listの4件のデータとキーが一致する() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to資格得喪List();
            HihokenshaDaicho testData = result.toList().get(1);
            HihokenshaDaicho motoData = hihoDaichoList.get(3);
            boolean isEqualKeys = testData.get被保険者番号().equals(motoData.get被保険者番号())
                    && testData.get異動日().equals(motoData.get異動日())
                    && testData.get枝番().equals(motoData.get枝番());
            assertThat(isEqualKeys, is(true));
        }

        @Test
        public void to資格得喪Listで取得したデータの3件目は_元Listの2件のデータとキーが一致する() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to資格得喪List();
            HihokenshaDaicho testData = result.toList().get(2);
            HihokenshaDaicho motoData = hihoDaichoList.get(1);
            boolean isEqualKeys = testData.get被保険者番号().equals(motoData.get被保険者番号())
                    && testData.get異動日().equals(motoData.get異動日())
                    && testData.get枝番().equals(motoData.get枝番());
            assertThat(isEqualKeys, is(true));
        }
    }

    public static class to住所地特例List extends DbzTestBase {

        //TODO #52997
        //テスト用の被保険者台帳Listを用意し、to資格得喪Listを実行します。
        //実行した結果の戻り値が、想定した結果になっているかをテストしてください。
        private List<HihokenshaDaicho> hihoDaichoList;
        private FlexibleDate tekiyoDate1;
        private FlexibleDate kaijoDate1;
        private FlexibleDate tekiyoDate2;

        @Before
        public void setUp() {
            hihoDaichoList = new ArrayList<>();
            tekiyoDate1 = new FlexibleDate("20150101");
            kaijoDate1 = new FlexibleDate("20150701");
            tekiyoDate2 = new FlexibleDate("20160101");

            DbT1001HihokenshaDaichoEntity entity1 = createEntity();
            entity1.setIdoYMD(tekiyoDate1);
            entity1.setJushochitokureiTekiyoYMD(tekiyoDate1);
            entity1.setJushochitokureiKaijoYMD(FlexibleDate.EMPTY);
            HihokenshaDaicho hihokenshaDaichoModel1 = new HihokenshaDaicho(entity1);
            hihoDaichoList.add(hihokenshaDaichoModel1);

            DbT1001HihokenshaDaichoEntity entity2 = createEntity();
            entity2.setIdoYMD(tekiyoDate1);
            entity2.setJushochitokureiTekiyoYMD(tekiyoDate1);
            entity2.setJushochitokureiKaijoYMD(FlexibleDate.EMPTY);
            HihokenshaDaicho hihokenshaDaichoModel2 = new HihokenshaDaicho(entity2);
            hihoDaichoList.add(hihokenshaDaichoModel2);

            DbT1001HihokenshaDaichoEntity entity3 = createEntity();
            entity3.setIdoYMD(kaijoDate1);
            entity3.setJushochitokureiTekiyoYMD(tekiyoDate1);
            entity3.setJushochitokureiKaijoYMD(kaijoDate1);
            HihokenshaDaicho hihokenshaDaichoModel3 = new HihokenshaDaicho(entity3);
            hihoDaichoList.add(hihokenshaDaichoModel3);

            DbT1001HihokenshaDaichoEntity entity4 = createEntity();
            entity4.setIdoYMD(tekiyoDate2);
            entity4.setJushochitokureiTekiyoYMD(tekiyoDate2);
            entity4.setJushochitokureiKaijoYMD(FlexibleDate.EMPTY);
            HihokenshaDaicho hihokenshaDaichoModel4 = new HihokenshaDaicho(entity4);
            hihoDaichoList.add(hihokenshaDaichoModel4);

            DbT1001HihokenshaDaichoEntity entity5 = createEntity();
            entity5.setIdoYMD(tekiyoDate2);
            entity5.setJushochitokureiTekiyoYMD(tekiyoDate2);
            entity5.setJushochitokureiKaijoYMD(FlexibleDate.EMPTY);
            HihokenshaDaicho hihokenshaDaichoModel5 = new HihokenshaDaicho(entity5);
            hihoDaichoList.add(hihokenshaDaichoModel5);

        }

        @Test
        public void to住所地特例Listで_3件のデータが取得できる() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to住所地特例List();
            assertThat(result.size(), is(3));
        }

        @Test
        public void to住所地特例Listで取得したデータの1件目は_適用日にtekiyoDate3を持つ() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to住所地特例List();
            assertThat(result.toList().get(0).get適用年月日(), is(tekiyoDate2));
        }

        @Test
        public void to住所地特例Listで取得したデータの1件目は_解除日にEMPTYを持つ() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to住所地特例List();
            assertThat(result.toList().get(0).get解除年月日(), is(FlexibleDate.EMPTY));
        }

        @Test
        public void to住所地特例Listで取得したデータの2件目は_適用日にtekiyoDate1を持つ() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to住所地特例List();
            assertThat(result.toList().get(1).get適用年月日(), is(tekiyoDate1));
        }

        @Test
        public void to住所地特例Listで取得したデータの2件目は_解除日にkaijoDate1を持つ() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to住所地特例List();
            assertThat(result.toList().get(1).get解除年月日(), is(kaijoDate1));
        }

        @Test
        public void to住所地特例Listで取得したデータの3件目は_適用日にtekiyoDate2を持つ() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to住所地特例List();
            assertThat(result.toList().get(2).get適用年月日(), is(tekiyoDate1));
        }

        @Test
        public void to住所地特例Listで取得したデータの3件目は_解除日にEMPTYを持つ() {
            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to住所地特例List();
            assertThat(result.toList().get(2).get解除年月日(), is(FlexibleDate.EMPTY));
        }

    }

    public static class to資格関連異動List extends DbzTestBase {

        @Test
        public void to資格関連異動Listは_資格変更年月日がnullの場合_空のリストを返す() {
            ArrayList<HihokenshaDaicho> arrayList = new ArrayList<>();
            HihokenshaDaicho hihokenshaDaichoModel = new HihokenshaDaicho(createEntity());
            arrayList.add(hihokenshaDaichoModel);

            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(arrayList)).to資格関連異動List();
            assertThat(result.size(), is(0));
        }

        @Test
        public void to資格関連異動Listは_資格変更年月日がある情報を_１件取得する() {
            ArrayList<HihokenshaDaicho> arrayList = new ArrayList<>();
            DbT1001HihokenshaDaichoEntity entity1 = createEntity();
            entity1.setIdoYMD(new FlexibleDate("20150101"));
            entity1.setShikakuHenkoYMD(new FlexibleDate("20150101"));
            HihokenshaDaicho hihokenshaDaichoModel = new HihokenshaDaicho(entity1);
            arrayList.add(hihokenshaDaichoModel);

            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(arrayList)).to資格関連異動List();
            assertThat(result.size(), is(1));
        }

        @Test
        public void to資格関連異動Listは_異なる資格変更年月日がある情報を_Listのサイズ取得する() {
            ArrayList<HihokenshaDaicho> arrayList = new ArrayList<>();

            DbT1001HihokenshaDaichoEntity entity1 = createEntity();
            entity1.setIdoYMD(new FlexibleDate("20150101"));
            entity1.setShikakuHenkoYMD(new FlexibleDate("20150101"));
            HihokenshaDaicho hihokenshaDaichoModel1 = new HihokenshaDaicho(entity1);
            arrayList.add(hihokenshaDaichoModel1);

            DbT1001HihokenshaDaichoEntity entity2 = createEntity();
            entity2.setIdoYMD(new FlexibleDate("20150102"));
            entity2.setShikakuHenkoYMD(new FlexibleDate("20150102"));
            HihokenshaDaicho hihokenshaDaichoModel2 = new HihokenshaDaicho(entity2);
            arrayList.add(hihokenshaDaichoModel2);

            DbT1001HihokenshaDaichoEntity entity3 = createEntity();
            entity3.setIdoYMD(new FlexibleDate("20150103"));
            entity3.setShikakuHenkoYMD(new FlexibleDate("20150103"));
            HihokenshaDaicho hihokenshaDaichoModel3 = new HihokenshaDaicho(entity3);
            arrayList.add(hihokenshaDaichoModel3);

            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(arrayList)).to資格関連異動List();
            assertThat(result.size(), is(arrayList.size()));
        }

        @Test
        public void to資格関連異動Listは_同じ資格変更年月日を持つ項目があるListの場合_同じ変更日を除いたサイズのItemListを取得する() {
            ArrayList<HihokenshaDaicho> arrayList = new ArrayList<>();

            DbT1001HihokenshaDaichoEntity entity1 = createEntity();
            entity1.setIdoYMD(new FlexibleDate("20150101"));
            entity1.setShikakuHenkoYMD(new FlexibleDate("20150101"));
            HihokenshaDaicho hihokenshaDaichoModel1 = new HihokenshaDaicho(entity1);
            arrayList.add(hihokenshaDaichoModel1);

            DbT1001HihokenshaDaichoEntity entity2 = createEntity();
            entity2.setIdoYMD(new FlexibleDate("20150102"));
            entity2.setShikakuHenkoYMD(new FlexibleDate("20150102"));
            HihokenshaDaicho hihokenshaDaichoModel2 = new HihokenshaDaicho(entity2);
            arrayList.add(hihokenshaDaichoModel2);
            arrayList.add(hihokenshaDaichoModel2);

            DbT1001HihokenshaDaichoEntity entity3 = createEntity();
            entity3.setIdoYMD(new FlexibleDate("20150103"));
            entity3.setShikakuHenkoYMD(new FlexibleDate("20150103"));
            HihokenshaDaicho hihokenshaDaichoModel3 = new HihokenshaDaicho(entity3);
            arrayList.add(hihokenshaDaichoModel3);

            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(arrayList)).to資格関連異動List();
            assertThat(result.size(), is(arrayList.size() - 1));
        }

        @Test
        public void to資格関連異動Listは_資格変更年月日がemptyの項目があるListの場合_emptyの変更日を除いたサイズのItemListを取得する() {
            ArrayList<HihokenshaDaicho> arrayList = new ArrayList<>();

            DbT1001HihokenshaDaichoEntity entity1 = createEntity();
            entity1.setIdoYMD(new FlexibleDate("20150101"));
            entity1.setShikakuHenkoYMD(new FlexibleDate("20150101"));
            HihokenshaDaicho hihokenshaDaicho1 = new HihokenshaDaicho(entity1);
            arrayList.add(hihokenshaDaicho1);

            DbT1001HihokenshaDaichoEntity entity2 = createEntity();
            entity2.setIdoYMD(new FlexibleDate("20150101"));
            entity2.setShikakuHenkoYMD(FlexibleDate.EMPTY);
            HihokenshaDaicho hihokenshaDaichoModel2 = new HihokenshaDaicho(entity2);
            arrayList.add(hihokenshaDaichoModel2);

            DbT1001HihokenshaDaichoEntity entity3 = createEntity();
            entity3.setIdoYMD(new FlexibleDate("20150103"));
            entity3.setShikakuHenkoYMD(new FlexibleDate("20150103"));
            HihokenshaDaicho hihokenshaDaichoModel3 = new HihokenshaDaicho(entity3);
            arrayList.add(hihokenshaDaichoModel3);

            IItemList<HihokenshaDaicho> result = new HihokenshaDaichoList(ItemList.of(arrayList)).to資格関連異動List();
            assertThat(result.size(), is(arrayList.size() - 1));
        }
    }

    public static DbT1001HihokenshaDaichoEntity createEntity() {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();

        entity.setHihokenshaNo(new HihokenshaNo("0000000001"));
        entity.setIdoYMD(new FlexibleDate("20140328"));
        entity.setEdaNo(new RString("1"));

        entity.setIchigoShikakuShutokuYMD(new FlexibleDate("20140328"));

        entity.setShikakuShutokuJiyuCode(RString.EMPTY);
        entity.setShikakuShutokuTodokedeYMD(new FlexibleDate("20130327"));
        entity.setShikakuShutokuYMD(new FlexibleDate("20130327"));
        entity.setShikakuHenkoJiyuCode(RString.EMPTY);
        entity.setShikakuHenkoTodokedeYMD(FlexibleDate.EMPTY);
        entity.setShikakuHenkoYMD(FlexibleDate.EMPTY);
        return entity;
    }
}
