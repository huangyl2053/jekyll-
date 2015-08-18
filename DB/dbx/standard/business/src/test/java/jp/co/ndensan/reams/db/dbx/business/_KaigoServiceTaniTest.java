/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.TanisuSanteiTani;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.TanisuShikibetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.experimental.runners.Enclosed;

/**
 * 介護サービス単位クラスのテストクラスです
 *
 * @author n9935 知念 広宰
 */
@RunWith(Enclosed.class)
public class _KaigoServiceTaniTest extends DbxTestBase {

    private static _KaigoServiceTani sut;
    private static int 単位数;
    private static TanisuSanteiTani 単位数算定単位;
    private static TanisuShikibetsu 単位数識別;

    @BeforeClass
    public static void setUpClass() {
        単位数 = 3;
        単位数算定単位 = new TanisuSanteiTani(new RString("3000"));
        単位数識別 = new TanisuShikibetsu(new RString("66"));
    }

    public static class コンストラクタ extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタの単位数識別にnullを指定した時_NullPointerExceptionを返す() {
            sut = new _KaigoServiceTani(単位数, null, 単位数算定単位);
        }
    }

    public static class getTest extends DbxTestBase {

        @Before
        public void setUp() {
            sut = new _KaigoServiceTani(単位数, 単位数識別, 単位数算定単位);
        }

        @Test
        public void LDNS_単位数が3の場合_get単位数は_3を返す() {
            assertThat(sut.get単位数(), is(3));
        }

        @Test
        public void LDNS_単位数識別が66の場合_get単位数識別は_66を返す() {
            assertThat(sut.get単位数識別(), is(new TanisuShikibetsu(new RString("66"))));
        }

        @Test
        public void LDNS_単位数算定単位が3000の場合_get単位数算定単位は_3000を返す() {
            assertThat(sut.get単位数算定単位(), is(new TanisuSanteiTani(new RString("3000"))));
        }
    }
}
