/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuHenkoJiyuHihokensha;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuShutokuJiyuHihokensha;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    }

    public static class to住所地特例List extends DbaTestBase {
        //TODO #52997
        //テスト用の被保険者台帳Listを用意し、to資格得喪Listを実行します。
        //実行した結果の戻り値が、想定した結果になっているかをテストしてください。
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
        entity.setShikakuShutokuJiyuCode(new KaigoshikakuShutokuJiyuHihokensha(new RString("01")));
        entity.setShikakuShutokuTodokedeYMD(new FlexibleDate("20130327"));
        entity.setShikakuShutokuYMD(new FlexibleDate("20130327"));
        entity.setShikakuHenkoJiyuCode(new KaigoshikakuHenkoJiyuHihokensha(new RString("01")));
        entity.setShikakuHenkoTodokedeYMD(FlexibleDate.EMPTY);
        entity.setShikakuHenkoYMD(FlexibleDate.EMPTY);
        return entity;
    }
}
