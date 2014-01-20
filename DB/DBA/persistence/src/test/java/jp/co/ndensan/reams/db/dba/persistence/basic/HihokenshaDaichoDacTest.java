/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.ShikakuIdoKubun;
import jp.co.ndensan.reams.db.dba.entity.basic.T1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dba.persistence.basic.helper.ShikibetsuCodeMock;
import jp.co.ndensan.reams.db.dba.persistence.basic.helper.T1001HihokenshaDaichoEntityMock;
import jp.co.ndensan.reams.db.dbz.business.KaigoHihokenshaNumber;
import jp.co.ndensan.reams.db.dbz.business.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.BeforeClass;
import static org.mockito.Mockito.*;

/**
 * HihokenshaDaichoDacのテストクラスです。
 *
 * @author N3327 三浦 凌
 */
//@RunWith(Enclosed.class)
public class HihokenshaDaichoDacTest {//extends TestDacBase {

    @Test
    public void 現在実行可能なテストはありません() {
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
//    public static class Select extends TestDacBase {
//
//        private RString 市町村コード = new RString("a");
//        private RString 被保険者番号 = new RString("001");
//
//        @Override
//        protected void setUp() {
//            sut.insert(T1001HihokenshaDaichoEntityMock.createInstance(市町村コード, 被保険者番号, new RString("1")));
//            sut.insert(T1001HihokenshaDaichoEntityMock.createInstance(市町村コード, new RString("002"), new RString("2")));
//        }
//
//        @Test
//        public void 市町村コードと被保険者番号から取得できる() {
//            T1001HihokenshaDaichoEntity selected = sut.select(
//                    new ShichosonCode(市町村コード), new KaigoHihokenshaNo(被保険者番号));
//
//            assertThat(selected.getShichosonCd(), is(市町村コード));
//            assertThat(selected.getHihokenshaNo(), is(被保険者番号));
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
//            sut.insert(T1001HihokenshaDaichoEntityMock.createInstance(かぶった市町村コード, かぶった被保険者番号, かぶった識別コード));
//            sut.insert(T1001HihokenshaDaichoEntityMock.createInstance(new RString("bbbb"), かぶった被保険者番号, new RString("22")));
//            sut.insert(T1001HihokenshaDaichoEntityMock.createInstance(かぶった市町村コード, new RString("0003"), かぶった識別コード));
//        }
//
//        @Test
//        public void 被保険者番号から取得したとき_結果は2件() {
//            List<T1001HihokenshaDaichoEntity> result = sut.select(
//                    new KaigoHihokenshaNo(かぶった被保険者番号));
//
//            assertThat(result.size(), is(2));
//        }
//
//        @Test
//        public void 市町村コードと識別コードから取得したとき_結果は2件() {
//            List<T1001HihokenshaDaichoEntity> result = sut.select(
//                    new ShichosonCode(かぶった市町村コード), create識別コード(かぶった識別コード));
//
//            assertThat(result.size(), is(2));
//        }
//
//        @Test
//        public void 識別コードから取得したとき_結果は2件() {
//            List<T1001HihokenshaDaichoEntity> result = sut.select(
//                    create識別コード(かぶった識別コード));
//
//            assertThat(result.size(), is(2));
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
//            sut.insert(T1001HihokenshaDaichoEntityMock.createInstance(市町村コード, 被保険者番号, new RString("1")));
//            sut.insert(T1001HihokenshaDaichoEntityMock.createInstance(市町村コード, new RString("002"), new RString("2")));
//        }
//
//        @Test
//        public void 資格喪失年月日を変更できる() {
//            T1001HihokenshaDaichoEntity before = sut.select(
//                    new ShichosonCode(市町村コード), new KaigoHihokenshaNo(被保険者番号));
//
//            RDate 資格喪失年月日 = new RDate("20140117");
//            before.setShikakuIdouKubunCode(ShikakuIdoKubun.資格喪失.getCode());
//            before.setShikakuSoshitsuDate(資格喪失年月日);
//
//            sut.update(before);
//
//            T1001HihokenshaDaichoEntity updated = sut.select(
//                    new ShichosonCode(市町村コード), new KaigoHihokenshaNo(被保険者番号));
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
//            sut.insert(T1001HihokenshaDaichoEntityMock.createInstance(市町村コード, 被保険者番号, new RString("1")));
//        }
//
//        @Test
//        public void deleteを実行すると_1件データが削除され_検索結果がnullになる() {
//            T1001HihokenshaDaichoEntity entity = sut.select(
//                    new ShichosonCode(市町村コード), new KaigoHihokenshaNo(被保険者番号));
//
//            int count = sut.delete(entity);
//
//            T1001HihokenshaDaichoEntity deleted = sut.select(
//                    new ShichosonCode(市町村コード), new KaigoHihokenshaNo(被保険者番号));
//            assertThat(count, is(1));
//            assertThat(deleted, nullValue());
//        }
//
//        @Test
//        public void deleteに存在しないデータを渡したときは_削除されない() {
//            T1001HihokenshaDaichoEntity entity =
//                    T1001HihokenshaDaichoEntityMock.createInstance(new RString("市町村コード"), new RString("被保険者番号"), new RString("識別コード"));
//            int count = sut.delete(entity);
//            assertThat(count, is(0));
//        }
//    }
//
//    private static IShikibetsuCode create識別コード(RString code) {
//        return ShikibetsuCodeMock.createInstance(code);
//    }
}
