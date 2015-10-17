/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 台帳種別列挙体のテストです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class DaichoTypeTest {

    public static class toValueTest extends DbxTestBase {

        @Test
        public void 引数にコード1を指定すると被保険者となる() {
            assertThat(DaichoType.toValue(new RString("1")).toRString(),
                    is(DaichoType.被保険者.toRString()));
        }

        @Test
        public void 引数にコード2を指定すると他市町村住所地特例者となる() {
            assertThat(DaichoType.toValue(new RString("2")).toRString(),
                    is(DaichoType.他市町村住所地特例者.toRString()));
        }

        @Test
        public void 引数にコード3を指定すると適用除外者となる() {
            assertThat(DaichoType.toValue(new RString("3")).toRString(),
                    is(DaichoType.適用除外者.toRString()));
        }

        @Test
        public void 引数にコード空白を指定すると未定義となる() {
            assertThat(DaichoType.toValue(new RString("")).toRString(),
                    is(DaichoType.未定義.toRString()));
        }

        @Test
        public void 引数にコードnullを指定すると未定義となる() {
            assertThat(DaichoType.toValue(null).toRString(),
                    is(DaichoType.未定義.toRString()));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に不正な値を指定するとIllegalArgumentException_を返す() {
            DaichoType.toValue(new RString("88"));
        }
    }

    public static class codeTest extends DbxTestBase {

        @Test
        public void 台帳種別が被保険者の場合_codeは_1となる() {
            assertThat(DaichoType.被保険者.code(), is(new RString("1")));
        }

        @Test
        public void 台帳種別が未定義の場合_codeは_空白となる() {
            assertThat(DaichoType.未定義.code(), is(new RString("")));
        }
    }

    public static class toRStringTest extends DbxTestBase {

        @Test
        public void 台帳種別が被保険者の場合_toRStringは_被保険者となる() {
            assertThat(DaichoType.被保険者.toRString(), is(new RString("被保険者")));
        }

        @Test
        public void 台帳種別が未定義の場合_toRStringは_未定義となる() {
            assertThat(DaichoType.未定義.toRString(), is(new RString("未定義")));
        }
    }

    public static class valueOfTest extends DbxTestBase {

        @Test
        public void LDNS_台帳種別が被保険者の場合_valueOfは_被保険者を返す() {
            assertThat(DaichoType.valueOf("被保険者"), is(DaichoType.被保険者));
        }
    }
}
