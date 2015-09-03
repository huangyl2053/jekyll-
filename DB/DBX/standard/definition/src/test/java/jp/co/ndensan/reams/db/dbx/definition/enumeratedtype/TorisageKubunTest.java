/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 取下げ区分を表す列挙型のテストクラスです。
 *
 * @author LDNS 代聡
 */
@RunWith(Enclosed.class)
public class TorisageKubunTest extends DbxTestBase {

    public static class valueOfTest extends DbxTestBase {

        @Test
        public void LDNS_引数が区分変更却下を指定した場合_valueOfは_区分変更却下を返す() {
            assertThat(TorisageKubun.valueOf("区分変更却下"), is(TorisageKubun.区分変更却下));
        }
    }
}
