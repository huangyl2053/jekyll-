/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * NinteiShinseiRiyuのTestです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class NinteiShinseiRiyuTest extends DbzTestBase {

    public static class asRString extends DbzTestBase {

        @Test
        public void asRStringは_コンストラクタ引数がnullのとき_RString$EMPTYを返す() {
            NinteiShinseiRiyu sut = new NinteiShinseiRiyu(null);
            assertThat(sut.asRString(), is(RString.EMPTY));
        }

        @Test
        public void asRStringは_コンストラクタ引数のRStringと_同じ値を返す() {
            NinteiShinseiRiyu sut = new NinteiShinseiRiyu(new RString("test"));
            assertThat(sut.asRString(), is(new RString("test")));
        }
    }

}
