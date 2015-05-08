/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoShikakuShutokuJiyu;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link HihokenshaDaichoList}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoListTest {

    public static class constructor extends DbaTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数がnullのとき_NullPointerExceptionをスローする() {
            HihokenshaDaichoList hihokenshaDaichoList = new HihokenshaDaichoList(null);
        }
        //TODO #52997
        //コンストラクタのテストを実装します。
        //1, nullCheckについてテストします。

    }

    public static class toOneSeasonList extends DbaTestBase {
        //TODO #52997
        //テスト用の被保険者台帳Listを用意し、toOneSeasonListを実行します。
        //実行した結果の戻り値が、想定した結果になっているかをテストしてください。
        //
        //例：5件のテストデータを用意してtoOneSeasonListを実行 →　2件のデータが抽出できる場合
        //1, to資格得喪Listのsizeは2となるか。
        //2, 戻り値のListの1番目の要素が持つ資格取得日は、引数から受け取った資格取得日と一致するか。
        //2, 戻り値のListの2番目の要素が持つ資格取得日は、引数から受け取った資格取得日と一致するか。

        private List<HihokenshaDaichoModel> hihoDaichoList;
        private FlexibleDate matchDate;

        @Before
        public void setUp() {
            hihoDaichoList = new ArrayList<>();
            matchDate = new FlexibleDate("20150101");

            HihokenshaDaichoModel hihokenshaDaichoModel1 = new HihokenshaDaichoModel(createEntity());
            hihokenshaDaichoModel1.set資格取得年月日(matchDate);
            hihoDaichoList.add(hihokenshaDaichoModel1);

            HihokenshaDaichoModel hihokenshaDaichoModel2 = new HihokenshaDaichoModel(createEntity());
            hihokenshaDaichoModel2.set資格取得年月日(matchDate);
            hihoDaichoList.add(hihokenshaDaichoModel2);

            HihokenshaDaichoModel hihokenshaDaichoModel3 = new HihokenshaDaichoModel(createEntity());
            hihokenshaDaichoModel3.set資格取得年月日(matchDate.plusDay(10));
            hihoDaichoList.add(hihokenshaDaichoModel3);
        }

        @Test
        public void toOneSeasonListで_2件のデータが取得できる() {
            IItemList<HihokenshaDaichoModel> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).toOneSeasonList(matchDate);
            assertThat(result.size(), is(2));
        }

        @Test
        public void toOneSeasonListで取得したデータの1件目は_指定した日付と同一の日付を持つ() {
            IItemList<HihokenshaDaichoModel> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).toOneSeasonList(matchDate);
            assertThat(result.toList().get(0).get資格取得年月日(), is(matchDate));
        }

        @Test
        public void toOneSeasonListで取得したデータの2件目は_指定した日付と同一の日付を持つ() {
            IItemList<HihokenshaDaichoModel> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).toOneSeasonList(matchDate);
            assertThat(result.toList().get(1).get資格取得年月日(), is(matchDate));
        }
    }

    public static class to資格得喪List extends DbaTestBase {

        //TODO #52997
        //テスト用の被保険者台帳Listを用意し、to資格得喪Listを実行します。
        //実行した結果の戻り値が、想定した結果になっているかをテストしてください。
        //
        //例：9件のテストデータを用意してto資格得喪Listを実行 →　9件のテストデータの1番目と3番目と5番目を持つListが戻り値となる場合
        //1, to資格得喪Listのsizeは3となるか。
        //2, テスト用の被保険者台帳Listの1番目の要素が持つキー項目と、戻り値のListの1番目の要素が持つキー項目は一致するか。
        //3, テスト用の被保険者台帳Listの3番目の要素が持つキー項目と、戻り値のListの2番目の要素が持つキー項目は一致するか。
        //4, テスト用の被保険者台帳Listの5番目の要素が持つキー項目と、戻り値のListの3番目の要素が持つキー項目は一致するか。
        @Test
        public void dummy() {

        }
    }

    public static class to住所地特例List extends DbaTestBase {

        //TODO #52997
        //テスト用の被保険者台帳Listを用意し、to資格得喪Listを実行します。
        //実行した結果の戻り値が、想定した結果になっているかをテストしてください。
        private List<HihokenshaDaichoModel> hihoDaichoList;
        private FlexibleDate tekiyoDate1;
        private FlexibleDate kaijoDate1;
        private FlexibleDate tekiyoDate2;

        @Before
        public void setUp() {
            hihoDaichoList = new ArrayList<>();
            tekiyoDate1 = new FlexibleDate("20150101");
            kaijoDate1 = new FlexibleDate("20150701");
            tekiyoDate2 = new FlexibleDate("20160101");

            HihokenshaDaichoModel hihokenshaDaichoModel1 = new HihokenshaDaichoModel(createEntity());
            hihokenshaDaichoModel1.set適用年月日(tekiyoDate1);
            hihokenshaDaichoModel1.set解除年月日(FlexibleDate.EMPTY);
            hihoDaichoList.add(hihokenshaDaichoModel1);

            HihokenshaDaichoModel hihokenshaDaichoModel2 = new HihokenshaDaichoModel(createEntity());
            hihokenshaDaichoModel2.set適用年月日(tekiyoDate1);
            hihokenshaDaichoModel2.set解除年月日(FlexibleDate.EMPTY);
            hihoDaichoList.add(hihokenshaDaichoModel2);

            HihokenshaDaichoModel hihokenshaDaichoModel3 = new HihokenshaDaichoModel(createEntity());
            hihokenshaDaichoModel3.set適用年月日(tekiyoDate1);
            hihokenshaDaichoModel3.set解除年月日(kaijoDate1);
            hihoDaichoList.add(hihokenshaDaichoModel3);

            HihokenshaDaichoModel hihokenshaDaichoModel4 = new HihokenshaDaichoModel(createEntity());
            hihokenshaDaichoModel4.set適用年月日(tekiyoDate2);
            hihokenshaDaichoModel4.set解除年月日(FlexibleDate.EMPTY);
            hihoDaichoList.add(hihokenshaDaichoModel4);

            HihokenshaDaichoModel hihokenshaDaichoModel5 = new HihokenshaDaichoModel(createEntity());
            hihokenshaDaichoModel5.set適用年月日(tekiyoDate2);
            hihokenshaDaichoModel5.set解除年月日(FlexibleDate.EMPTY);
            hihoDaichoList.add(hihokenshaDaichoModel5);

        }

        @Test
        public void to住所地特例Listで_3件のデータが取得できる() {
            IItemList<HihokenshaDaichoModel> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to住所地特例List();
            assertThat(result.size(), is(3));
        }

        @Test
        public void to住所地特例Listで取得したデータの1件目は_適用日にtekiyoDate1を持つ() {
            IItemList<HihokenshaDaichoModel> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to住所地特例List();
            assertThat(result.toList().get(0).get適用年月日(), is(tekiyoDate1));
        }

        @Test
        public void to住所地特例Listで取得したデータの1件目は_解除日にEMPTYを持つ() {
            IItemList<HihokenshaDaichoModel> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to住所地特例List();
            assertThat(result.toList().get(0).get解除年月日(), is(FlexibleDate.EMPTY));
        }

        @Test
        public void to住所地特例Listで取得したデータの2件目は_適用日にtekiyoDate1を持つ() {
            IItemList<HihokenshaDaichoModel> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to住所地特例List();
            assertThat(result.toList().get(1).get適用年月日(), is(tekiyoDate1));
        }

        @Test
        public void to住所地特例Listで取得したデータの2件目は_解除日にkaijoDate1を持つ() {
            IItemList<HihokenshaDaichoModel> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to住所地特例List();
            assertThat(result.toList().get(1).get解除年月日(), is(kaijoDate1));
        }

        @Test
        public void to住所地特例Listで取得したデータの3件目は_適用日にtekiyoDate2を持つ() {
            IItemList<HihokenshaDaichoModel> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to住所地特例List();
            assertThat(result.toList().get(2).get適用年月日(), is(tekiyoDate2));
        }

        @Test
        public void to住所地特例Listで取得したデータの3件目は_解除日にEMPTYを持つ() {
            IItemList<HihokenshaDaichoModel> result = new HihokenshaDaichoList(ItemList.of(hihoDaichoList)).to住所地特例List();
            assertThat(result.toList().get(2).get解除年月日(), is(FlexibleDate.EMPTY));
        }

    }

    public static class to資格関連異動List extends DbaTestBase {

        @Test
        public void to資格関連異動Listは_資格変更年月日がnullの場合_空のリストを返す() {
            ArrayList<HihokenshaDaichoModel> arrayList = new ArrayList<>();
            HihokenshaDaichoModel hihokenshaDaichoModel = new HihokenshaDaichoModel(createEntity());
            arrayList.add(hihokenshaDaichoModel);

            IItemList<HihokenshaDaichoModel> result = new HihokenshaDaichoList(ItemList.of(arrayList)).to資格関連異動List();
            assertThat(result.size(), is(0));
        }

        @Test
        public void to資格関連異動Listは_資格変更年月日がある情報を_１件取得する() {
            ArrayList<HihokenshaDaichoModel> arrayList = new ArrayList<>();
            HihokenshaDaichoModel hihokenshaDaichoModel = new HihokenshaDaichoModel(createEntity());
            hihokenshaDaichoModel.set資格変更年月日(new FlexibleDate("20150101"));
            arrayList.add(hihokenshaDaichoModel);

            IItemList<HihokenshaDaichoModel> result = new HihokenshaDaichoList(ItemList.of(arrayList)).to資格関連異動List();
            assertThat(result.size(), is(1));
        }

        @Test
        public void to資格関連異動Listは_異なる資格変更年月日がある情報を_Listのサイズ取得する() {
            ArrayList<HihokenshaDaichoModel> arrayList = new ArrayList<>();
            HihokenshaDaichoModel hihokenshaDaichoModel1 = new HihokenshaDaichoModel(createEntity());
            hihokenshaDaichoModel1.set資格変更年月日(new FlexibleDate("20150101"));
            arrayList.add(hihokenshaDaichoModel1);

            HihokenshaDaichoModel hihokenshaDaichoModel2 = new HihokenshaDaichoModel(createEntity());
            hihokenshaDaichoModel2.set資格変更年月日(new FlexibleDate("20150102"));
            arrayList.add(hihokenshaDaichoModel2);

            HihokenshaDaichoModel hihokenshaDaichoModel3 = new HihokenshaDaichoModel(createEntity());
            hihokenshaDaichoModel3.set資格変更年月日(new FlexibleDate("20150103"));
            arrayList.add(hihokenshaDaichoModel3);

            IItemList<HihokenshaDaichoModel> result = new HihokenshaDaichoList(ItemList.of(arrayList)).to資格関連異動List();
            assertThat(result.size(), is(arrayList.size()));
        }

        @Test
        public void to資格関連異動Listは_同じ資格変更年月日を持つ項目があるListの場合_同じ変更日を除いたサイズのItemListを取得する() {
            ArrayList<HihokenshaDaichoModel> arrayList = new ArrayList<>();
            HihokenshaDaichoModel hihokenshaDaichoModel1 = new HihokenshaDaichoModel(createEntity());
            hihokenshaDaichoModel1.set資格変更年月日(new FlexibleDate("20150101"));
            arrayList.add(hihokenshaDaichoModel1);

            HihokenshaDaichoModel hihokenshaDaichoModel2 = new HihokenshaDaichoModel(createEntity());
            hihokenshaDaichoModel2.set資格変更年月日(new FlexibleDate("20150102"));
            arrayList.add(hihokenshaDaichoModel2);
            arrayList.add(hihokenshaDaichoModel2);

            HihokenshaDaichoModel hihokenshaDaichoModel3 = new HihokenshaDaichoModel(createEntity());
            hihokenshaDaichoModel3.set資格変更年月日(new FlexibleDate("20150103"));
            arrayList.add(hihokenshaDaichoModel3);

            IItemList<HihokenshaDaichoModel> result = new HihokenshaDaichoList(ItemList.of(arrayList)).to資格関連異動List();
            assertThat(result.size(), is(arrayList.size() - 1));
        }

        @Test
        public void to資格関連異動Listは_資格変更年月日がemptyの項目があるListの場合_emptyの変更日を除いたサイズのItemListを取得する() {
            ArrayList<HihokenshaDaichoModel> arrayList = new ArrayList<>();
            HihokenshaDaichoModel hihokenshaDaichoModel1 = new HihokenshaDaichoModel(createEntity());
            hihokenshaDaichoModel1.set資格変更年月日(new FlexibleDate("20150101"));
            arrayList.add(hihokenshaDaichoModel1);

            HihokenshaDaichoModel hihokenshaDaichoModel2 = new HihokenshaDaichoModel(createEntity());
            hihokenshaDaichoModel2.set資格変更年月日(FlexibleDate.EMPTY);
            arrayList.add(hihokenshaDaichoModel2);

            HihokenshaDaichoModel hihokenshaDaichoModel3 = new HihokenshaDaichoModel(createEntity());
            hihokenshaDaichoModel3.set資格変更年月日(new FlexibleDate("20150103"));
            arrayList.add(hihokenshaDaichoModel3);

            IItemList<HihokenshaDaichoModel> result = new HihokenshaDaichoList(ItemList.of(arrayList)).to資格関連異動List();
            assertThat(result.size(), is(arrayList.size() - 1));
        }
    }

    public static DbT1001HihokenshaDaichoEntity createEntity() {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();

        entity.setIchigoShikakuShutokuYMD(new FlexibleDate("20140328"));

        entity.setShikakuShutokuJiyuCode(new KaigoShikakuShutokuJiyu(Code.EMPTY));
        entity.setShikakuShutokuTodokedeYMD(new FlexibleDate("20130327"));
        entity.setShikakuShutokuYMD(new FlexibleDate("20130327"));
        entity.setShikakuHenkoJiyuCode(new KaigoShikakuHenkoJiyu(Code.EMPTY));
        entity.setShikakuHenkoTodokedeYMD(FlexibleDate.EMPTY);
        entity.setShikakuHenkoYMD(FlexibleDate.EMPTY);
        entity.setShoriTimestamp(ShoriTimestamp.of(RDateTime.MAX));
        return entity;
    }
}
