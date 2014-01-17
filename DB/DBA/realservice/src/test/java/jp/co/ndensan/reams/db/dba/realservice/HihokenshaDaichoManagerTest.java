/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.realservice;

import jp.co.ndensan.reams.db.dba.business.Hihokensha;
import jp.co.ndensan.reams.db.dba.business.HihokenshaList;
import jp.co.ndensan.reams.db.dba.realservice.helper.HihokenshaDaichoDacMock;
import jp.co.ndensan.reams.db.dba.realservice.helper.HihokenshaMock;
import jp.co.ndensan.reams.db.dba.realservice.helper.ShikibetsuCodeMock;
import jp.co.ndensan.reams.db.dbz.business.KaigoHihokenshaNumber;
import jp.co.ndensan.reams.db.dbz.business.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.Mockito.*;

/**
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoManagerTest extends TestBase {

    @RunWith(Enclosed.class)
    public static class Get被保険者台帳 extends TestBase {

        private static HihokenshaDaichoManager sut;

        public static class 引数が_市町村コードと被保険者番号 extends TestBase {

            @Override
            protected void setUp() {
                sut = new HihokenshaDaichoManager(new HihokenshaDaichoDacMock());
            }

            @Test
            public void 指定した市町村コードと被保険者番号から_検索結果が取得できる() {
                ShichosonCode 市町村コード = new ShichosonCode(new RString("市町村コード"));
                KaigoHihokenshaNumber 被保険者番号 = new KaigoHihokenshaNumber(new RString("被保険者番号"));

                Hihokensha selected = sut.get被保険者台帳(市町村コード, 被保険者番号);

                assertThat(selected, notNullValue());
                assertThat(selected.get市町村コード().getValue(), is(市町村コード.getValue()));
                assertThat(selected.get被保険者番号(), is(被保険者番号.getValue()));
            }

            @Test
            public void 指定した市町村コードと被保険者番号から_検索結果が得られないときは_nullを返す() {
                ShichosonCode 市町村コード = new ShichosonCode(new RString("市町村コード"));
                KaigoHihokenshaNumber 被保険者番号 = new KaigoHihokenshaNumber(HihokenshaDaichoDacMock.検索不可な被保険者番号);

                Hihokensha selected = sut.get被保険者台帳(市町村コード, 被保険者番号);
                assertThat(selected, nullValue());
            }
        }

        public static class 引数が_被保険者番号 extends TestBase {

            @Override
            protected void setUp() {
                sut = new HihokenshaDaichoManager(new HihokenshaDaichoDacMock());
            }

            @Test
            public void 指定した被保険者番号から_検索結果が取得できる() {
                KaigoHihokenshaNumber 被保険者番号 = new KaigoHihokenshaNumber(new RString("被保険者番号"));

                HihokenshaList selected = sut.get被保険者台帳(被保険者番号);
                assertThat(selected, notNullValue());
            }

            @Test
            public void 指定した被保険者番号から_検索結果が得られないときは_nullを返す() {
                KaigoHihokenshaNumber 被保険者番号 = new KaigoHihokenshaNumber(HihokenshaDaichoDacMock.検索不可な被保険者番号);

                HihokenshaList selected = sut.get被保険者台帳(被保険者番号);
                assertThat(selected, nullValue());
            }
        }

        public static class 引数が_市町村コードと識別コード extends TestBase {

            @Override
            protected void setUp() {
                sut = new HihokenshaDaichoManager(new HihokenshaDaichoDacMock());
            }

            @Test
            public void 指定した市町村コードと識別コードから_検索結果が取得できる() {
                ShichosonCode 市町村コード = new ShichosonCode(new RString("市町村コード"));
                IShikibetsuCode 識別コード = create識別コード(new RString("識別コード"));

                HihokenshaList selected = sut.get被保険者台帳(市町村コード, 識別コード);
                assertThat(selected, notNullValue());
            }

            @Test
            public void 指定した市町村コードと識別コード_検索結果が得られないときは_nullを返す() {
                ShichosonCode 市町村コード = new ShichosonCode(new RString("市町村コード"));
                IShikibetsuCode 識別コード = create識別コード(HihokenshaDaichoDacMock.検索不可な識別コード);

                HihokenshaList selected = sut.get被保険者台帳(市町村コード, 識別コード);
                assertThat(selected, nullValue());
            }
        }

        public static class 引数が_識別コード extends TestBase {

            @Override
            protected void setUp() {
                sut = new HihokenshaDaichoManager(new HihokenshaDaichoDacMock());
            }

            @Test
            public void 指定した識別コードから_検索結果が取得できる() {
                IShikibetsuCode 識別コード = create識別コード(new RString("識別コード"));

                HihokenshaList selected = sut.get被保険者台帳(識別コード);
                assertThat(selected, notNullValue());
            }

            @Test
            public void 指定した識別コード_検索結果が得られないときは_nullを返す() {
                IShikibetsuCode 識別コード = create識別コード(HihokenshaDaichoDacMock.検索不可な識別コード);

                HihokenshaList selected = sut.get被保険者台帳(識別コード);
                assertThat(selected, nullValue());
            }
        }
    }

    public static class Save extends TestBase {

        private HihokenshaDaichoManager sut;

        @Override
        protected void setUp() {
            sut = new HihokenshaDaichoManager(new HihokenshaDaichoDacMock());
        }

        @Test
        public void saveに成功したとき_trueを返す() {
            Hihokensha 被保険者 = HihokenshaMock.getSpiedInstance();
            boolean result = sut.save(被保険者);
            assertThat(result, is(true));
        }
    }

    public static class Delete extends TestBase {

        private HihokenshaDaichoManager sut;

        @Override
        protected void setUp() {
            sut = new HihokenshaDaichoManager(new HihokenshaDaichoDacMock());
        }

        @Test
        public void deleteできないときは_falseを返す() {
            Hihokensha 被保険者 = HihokenshaMock.getSpiedInstance();
            boolean result = sut.remove(被保険者);
            assertThat(result, is(false));
        }

        @Test
        public void deleteに成功したとき_trueを返す() {
            Hihokensha 被保険者 = HihokenshaMock.getSpiedInstance();
            when(被保険者.get市町村コード()).thenReturn(new ShichosonCode(HihokenshaDaichoDacMock.削除可能な市町村コード));
            when(被保険者.get被保険者番号()).thenReturn(HihokenshaDaichoDacMock.削除可能な被保険者番号);
            boolean result = sut.remove(被保険者);
            assertThat(result, is(true));
        }
    }

    private static IShikibetsuCode create識別コード(RString code) {
        return ShikibetsuCodeMock.createInstance(code);
    }
}
