/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype;

import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 施設種類の列挙体のテストです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class ShisetsuTypeTest {

    public static class toValueTest extends DbxTestBase {

        @Test
        public void 引数にコード11を指定すると介護保険施設となる() {
            assertThat(ShisetsuType.toValue(new RString("11")).toRString(),
                    is(ShisetsuType.介護保険施設.toRString()));
        }

        @Test
        public void 引数にコード12を指定すると住所地特例対象施設となる() {
            assertThat(ShisetsuType.toValue(new RString("12")).toRString(),
                    is(ShisetsuType.住所地特例対象施設.toRString()));
        }

        @Test
        public void 引数にコード21を指定すると適用除外施設となる() {
            assertThat(ShisetsuType.toValue(new RString("21")).toRString(),
                    is(ShisetsuType.適用除外施設.toRString()));
        }

        @Test
        public void 引数にコード空白を指定すると未定義となる() {
            assertThat(ShisetsuType.toValue(new RString("")).toRString(),
                    is(ShisetsuType.未定義.toRString()));
        }

        @Test
        public void 引数にコードnullを指定すると未定義となる() {
            assertThat(ShisetsuType.toValue(null).toRString(),
                    is(ShisetsuType.未定義.toRString()));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に不正な値を指定するとIllegalArgumentException_を返す() {
            ShisetsuType.toValue(new RString("88"));
        }
    }

    public static class codeTest extends DbxTestBase {

        @Test
        public void 施設種類が介護保険施設の場合_codeは_11となる() {
            assertThat(ShisetsuType.介護保険施設.code(), is(new RString("11")));
        }

        @Test
        public void 施設種類が未定義の場合_codeは_空白となる() {
            assertThat(ShisetsuType.未定義.code(), is(new RString("")));
        }
    }

    public static class toRStringTest extends DbxTestBase {

        @Test
        public void 施設種類が介護保険施設の場合_toRStringは_介護保険施設となる() {
            assertThat(ShisetsuType.介護保険施設.toRString(), is(new RString("介護保険施設")));
        }

        @Test
        public void 施設種類が未定義の場合_toRStringは_未定義となる() {
            assertThat(ShisetsuType.未定義.toRString(), is(new RString("未定義")));
        }
    }

    public static class valueOfTest extends DbxTestBase {

        @Test
        public void LDNS_施設種類が介護保険施設の場合_valueOfは_介護保険施設を返す() {
            assertThat(ShisetsuType.valueOf("介護保険施設"), is(ShisetsuType.介護保険施設));
        }
    }
}
