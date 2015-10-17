/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.valueobject;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.Shisetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 施設種類を表すドメインクラスのテストです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class ShisetsuTest {

    private static Shisetsu sut;

    public static class getColumnValueTest extends DbxTestBase {

        @Test
        public void コンストラクタにコード11を指定した場合_getColumnValueは_11_を返す() {
            sut = new Shisetsu(new RString("11"));
            assertThat(sut.getColumnValue(), is(new RString("11")));
        }
    }

    public static class valueTest extends DbxTestBase {

        @Test
        public void コンストラクタにコード11を指定した場合_valueは_介護保険施設_を返す() {
            sut = new Shisetsu(new RString("11"));
            assertThat(sut.value(), is(ShisetsuType.介護保険施設));
        }
    }

    public static class toStringTest extends DbxTestBase {

        @Test
        public void LDNS_typeが未定義の場合_toStringは_空白を返す() {
            Shisetsu sut1 = new Shisetsu(ShisetsuType.未定義.code());
            assertThat(sut1.toString(), is(""));
        }

    }
}
