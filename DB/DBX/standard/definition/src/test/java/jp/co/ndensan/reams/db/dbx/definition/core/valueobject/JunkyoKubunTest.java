/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.valueobject;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.JunkyoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.JunkyoKubunType;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 準拠区分を表すドメインクラスのテストです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class JunkyoKubunTest {

    private static JunkyoKubun sut;

    public static class getColumnValueTest extends DbxTestBase {

        @Test
        public void コンストラクタにコード1を指定した場合_getColumnValueは_1_を返す() {
            sut = new JunkyoKubun(new RString("1"));
            assertThat(sut.getColumnValue(), is(new RString("1")));
        }
    }

    public static class valueTest extends DbxTestBase {

        @Test
        public void コンストラクタにコード1を指定した場合_valueは_準拠する_を返す() {
            sut = new JunkyoKubun(new RString("1"));
            assertThat(sut.value(), is(JunkyoKubunType.準拠する));
        }
    }

    public static class toStringTest extends DbxTestBase {

        @Test
        public void LDNS_準拠区分コードが準拠しないを設定される場合_toStringは_0を返す() {
            JunkyoKubun sut1 = new JunkyoKubun(JunkyoKubunType.準拠しない.code());
            assertThat(sut1.toString(), is("0"));
        }
    }
}
