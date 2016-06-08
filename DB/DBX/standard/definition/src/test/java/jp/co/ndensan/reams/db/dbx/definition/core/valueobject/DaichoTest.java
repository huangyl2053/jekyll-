/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.valueobject;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.Daicho;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 台帳種別を表すドメインクラスのテストです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class DaichoTest {

    private static Daicho sut;

    public static class getColumnValueTest extends DbxTestBase {

        @Test
        public void コンストラクタにコード1を指定した場合_getColumnValueは_1_を返す() {
            sut = new Daicho(new RString("1"));
            assertThat(sut.getColumnValue(), is(new RString("1")));
        }
    }

    public static class valueTest extends DbxTestBase {

        @Test
        public void コンストラクタにコード1を指定した場合_valueは_被保険者_を返す() {
            sut = new Daicho(new RString("1"));
            assertThat(sut.value(), is(DaichoType.被保険者));
        }
    }

    public static class toStringTest extends DbxTestBase {

        @Test
        public void LDNS_typeが被保険者の場合_toStringは_1を返す() {
            Daicho sut = new Daicho(DaichoType.被保険者.code());
            assertThat(sut.toString(), is("1"));
        }
    }
}
