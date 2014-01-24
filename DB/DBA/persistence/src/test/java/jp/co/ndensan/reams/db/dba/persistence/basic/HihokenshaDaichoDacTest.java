/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.basic;

//import java.util.Collections;
//import java.util.List;
//import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.ShikakuIdoKubun;
//import jp.co.ndensan.reams.db.dba.entity.basic.T1001HihokenshaDaichoEntity;
//import jp.co.ndensan.reams.db.dba.persistence.basic.helper.ShikibetsuCodeMock;
//import jp.co.ndensan.reams.db.dba.persistence.basic.helper.T1001HihokenshaDaichoEntityMock;
//import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNumber;
//import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
//import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
//import jp.co.ndensan.reams.uz.uza.lang.RDate;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase;
//import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;
import org.junit.Test;
//import org.junit.experimental.runners.Enclosed;
//import org.junit.runner.RunWith;
//import static org.junit.Assert.assertThat;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.nullValue;
//import static org.hamcrest.CoreMatchers.notNullValue;
//import org.junit.BeforeClass;

/**
 * HihokenshaDaichoDacのテストクラスです。
 *
 * @author N3327 三浦 凌
 */
//@RunWith(Enclosed.class)
public class HihokenshaDaichoDacTest {// extends TestDacBase {

    @Test
    public void 現在実行可能なテストはありません() {
        //TODO n3327 三浦凌　DACのテストが可能になったらアンコメントして実行する。
    }
//    private static IHihokenshaDaichoDac sut;
//
//    static {
//        setDummyControlData("DB");
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//        sut = InstanceCreator.create(IHihokenshaDaichoDac.class);
//    }
//
//    public static class Insert extends TestDacBase {
//
//        @Test
//        public void データをinsertしたとき_返り値は1() {
//            int count = sut.insert(T1001HihokenshaDaichoEntityMock.getSpiedInstance(new RString("1"), new RString("1"), new RString("1")));
//            assertThat(count, is(1));
//        }
//    }
//
//    public static class Select extends TestDacBase {
//
//        private RString 市町村コード = new RString("a");
//        private RString 被保険者番号 = new RString("001");
//        private RString 識別コード = new RString("1");
//
//        @Override
//        protected void setUp() {
//            sut.insert(T1001HihokenshaDaichoEntityMock.getSpiedInstance(市町村コード, 被保険者番号, 識別コード));
//            sut.insert(T1001HihokenshaDaichoEntityMock.getSpiedInstance(市町村コード, new RString("002"), new RString("2")));
//        }
//
//        @Test
//        public void 市町村コードと被保険者番号から検索したとき_同じ値の市町村コードと被保険者番号をもったデータが取得できる() {
//            T1001HihokenshaDaichoEntity selected = sut.select(
//                    new ShichosonCode(市町村コード),
//                    new KaigoHihokenshaNumber(被保険者番号));
//
//            assertThat(selected.getShikibetsuCode().getValue(), is(識別コード));
//        }
//
//        @Test
//        public void 市町村コードが一致していても_被保険者番号が異なれば_検索結果はnull() {
//            T1001HihokenshaDaichoEntity selected = sut.select(
//                    new ShichosonCode(市町村コード),
//                    new KaigoHihokenshaNumber(new RString("まちがった被保険者番号")));
//
//            assertThat(selected, nullValue());
//        }
//
//        @Test
//        public void 被保険者番号が一致していても_市町村コードが異なれば_検索結果はnull() {
//            T1001HihokenshaDaichoEntity selected = sut.select(
//                    new ShichosonCode(new RString("まちがえちゃった市町村コード")),
//                    new KaigoHihokenshaNumber(被保険者番号));
//
//            assertThat(selected, nullValue());
//        }
//
//        @Test
//        public void 市町村コードと被保険者番号のどちらも一致していないとき_検索結果はnull() {
//            T1001HihokenshaDaichoEntity selected = sut.select(
//                    new ShichosonCode(new RString("まちがえちゃった市町村コード")),
//                    new KaigoHihokenshaNumber(new RString("まちがった被保険者番号")));
//
//            assertThat(selected, nullValue());
//        }
//    }
//
//    public static class SelectList extends TestDacBase {
//
//        private RString かぶった市町村コード = new RString("aaaa");
//        private RString かぶった被保険者番号 = new RString("0001");
//        private RString かぶった識別コード = new RString("11");
//
//        @Override
//        protected void setUp() {
//            sut.insert(T1001HihokenshaDaichoEntityMock.getSpiedInstance(かぶった市町村コード, かぶった被保険者番号, かぶった識別コード));
//            sut.insert(T1001HihokenshaDaichoEntityMock.getSpiedInstance(new RString("bbbb"), かぶった被保険者番号, new RString("22")));
//            sut.insert(T1001HihokenshaDaichoEntityMock.getSpiedInstance(かぶった市町村コード, new RString("0003"), かぶった識別コード));
//        }
//
//        @Test
//        public void 複数件該当する被保険者番号で検索したとき_結果は2件() {
//            List<T1001HihokenshaDaichoEntity> result = sut.select(
//                    new KaigoHihokenshaNumber(かぶった被保険者番号));
//
//            assertThat(result.size(), is(2));
//        }
//
//        @Test
//        public void 該当者がいない被保険者番号で検索したとき_結果はEMPTY_LIST() {
//            List<T1001HihokenshaDaichoEntity> result = sut.select(
//                    new KaigoHihokenshaNumber(new RString("絶対にヒットしない")));
//
//            assertThat(result, is(Collections.EMPTY_LIST));
//        }
//
//        @Test
//        public void 複数件該当する市町村コードと識別コードの組み合わせで検索したとき_結果は2件() {
//            List<T1001HihokenshaDaichoEntity> result = sut.select(
//                    new ShichosonCode(かぶった市町村コード), create識別コード(かぶった識別コード));
//
//            assertThat(result.size(), is(2));
//        }
//
//        @Test
//        public void 該当者がいない市町村コードと識別コードの組み合わせで検索したとき_結果はEMPTY_LIST() {
//            List<T1001HihokenshaDaichoEntity> result = sut.select(
//                    new ShichosonCode(new RString("ヒットしない")), create識別コード(new RString("ヒットしない")));
//
//            assertThat(result, is(Collections.EMPTY_LIST));
//        }
//
//        @Test
//        public void 複数件該当する識別コードから検索したとき_結果は2件() {
//            List<T1001HihokenshaDaichoEntity> result = sut.select(
//                    create識別コード(かぶった識別コード));
//
//            assertThat(result.size(), is(2));
//        }
//
//        @Test
//        public void 該当者がいない識別コードから検索したとき_結果はEMPTY_LIST() {
//            List<T1001HihokenshaDaichoEntity> result = sut.select(
//                    create識別コード(new RString("金輪際ヒットしない")));
//
//            assertThat(result, is(Collections.EMPTY_LIST));
//        }
//    }
//
//    public static class Update extends TestDacBase {
//
//        private RString 市町村コード = new RString("a");
//        private RString 被保険者番号 = new RString("001");
//
//        @Override
//        protected void setUp() {
//            sut.insert(T1001HihokenshaDaichoEntityMock.getSpiedInstance(市町村コード, 被保険者番号, new RString("1")));
//            sut.insert(T1001HihokenshaDaichoEntityMock.getSpiedInstance(市町村コード, new RString("002"), new RString("2")));
//        }
//
//        @Test
//        public void 取得したデータの資格喪失年月日を変更してupdateしたとき_資格喪失年月日が変更される() {
//            T1001HihokenshaDaichoEntity before = sut.select(
//                    new ShichosonCode(市町村コード), new KaigoHihokenshaNumber(被保険者番号));
//
//            RDate 資格喪失年月日 = new RDate("20140117");
//            before.setShikakuIdouKubunCode(ShikakuIdoKubun.資格喪失.getCode());
//            before.setShikakuSoshitsuDate(資格喪失年月日);
//
//            sut.update(before);
//
//            T1001HihokenshaDaichoEntity updated = sut.select(
//                    new ShichosonCode(市町村コード), new KaigoHihokenshaNumber(被保険者番号));
//            assertThat(updated.getShikakuSoshitsuDate(), is(資格喪失年月日));
//        }
//    }
//
//    public static class Delete extends TestDacBase {
//
//        private RString 市町村コード = new RString("a");
//        private RString 被保険者番号 = new RString("001");
//
//        @Override
//        protected void setUp() {
//            sut.insert(T1001HihokenshaDaichoEntityMock.getSpiedInstance(市町村コード, 被保険者番号, new RString("1")));
//        }
//
//        @Test
//        public void あるデータに対してdeleteを実行したとき_返り値は1件() {
//            T1001HihokenshaDaichoEntity entity = sut.select(
//                    new ShichosonCode(市町村コード), new KaigoHihokenshaNumber(被保険者番号));
//
//            int count = sut.delete(entity);
//
//            assertThat(count, is(1));
//        }
//
//        @Test
//        public void 取得してきたデータに対してdeleteを実行すると_同じ条件の検索結果がnullになる() {
//            T1001HihokenshaDaichoEntity entity = sut.select(
//                    new ShichosonCode(市町村コード), new KaigoHihokenshaNumber(被保険者番号));
//
//            sut.delete(entity);
//
//            T1001HihokenshaDaichoEntity deleted = sut.select(
//                    new ShichosonCode(市町村コード), new KaigoHihokenshaNumber(被保険者番号));
//            assertThat(deleted, nullValue());
//        }
//
//        @Test
//        public void 存在しないデータをdeleteしたときは_削除されない() {
//            T1001HihokenshaDaichoEntity entity =
//                    T1001HihokenshaDaichoEntityMock.getSpiedInstance(new RString("市町村コード"), new RString("被保険者番号"), new RString("識別コード"));
//            int count = sut.delete(entity);
//            assertThat(count, is(0));
//        }
//    }
//
//    public static class InsertOrUpdate extends TestDacBase {
//
//        private RString 市町村コード = new RString("a");
//        private RString 被保険者番号 = new RString("001");
//        private RString 識別コード = new RString("1");
//
//        @Override
//        protected void setUp() {
//            sut.insert(T1001HihokenshaDaichoEntityMock.getSpiedInstance(市町村コード, 被保険者番号, 識別コード));
//            sut.insert(T1001HihokenshaDaichoEntityMock.getSpiedInstance(市町村コード, new RString("002"), new RString("2")));
//        }
//
//        @Test
//        public void 市町村コードと被保険者番号をキーに_すでに存在するデータは_updateする() {
//            T1001HihokenshaDaichoEntity entity =
//                    T1001HihokenshaDaichoEntityMock.getSpiedInstance(new RString("市町村コード"), new RString("被保険者番号"), new RString("識別コード"));
//
//            RDate 資格取得日 = new RDate("2013/12/21");
//            entity.setShikakuShutokuDate(資格取得日);
//
//            sut.insertOrUpdate(entity);
//
//            T1001HihokenshaDaichoEntity updated = sut.select(
//                    new ShichosonCode(市町村コード), new KaigoHihokenshaNumber(被保険者番号));
//            assertThat(updated.getShikakuShutokuDate(), is(資格取得日));
//        }
//
//        @Test
//        public void 市町村コードと被保険者番号をキーに_まだ存在していないデータは_insertする() {
//            RString 新しい被保険者番号 = new RString("新しい被保険者番号");
//            T1001HihokenshaDaichoEntity entity =
//                    T1001HihokenshaDaichoEntityMock.getSpiedInstance(市町村コード, 新しい被保険者番号, new RString("新識別コード"));
//
//            sut.insertOrUpdate(entity);
//
//            T1001HihokenshaDaichoEntity selected = sut.select(
//                    new ShichosonCode(市町村コード), new KaigoHihokenshaNumber(新しい被保険者番号));
//            assertThat(selected, notNullValue());
//        }
//    }
//
//    private static IShikibetsuCode create識別コード(RString code) {
//        return ShikibetsuCodeMock.createInstance(code);
//    }
}
