/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinteiShinseiYukoKubun;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 認定申請有効区分を表す列挙型のテストクラスです。
 *
 * @author LDNS 代聡
 */
@RunWith(Enclosed.class)
public class NinteiShinseiYukoKubunTest extends DbxTestBase {

    public static class valueOfTest extends DbxTestBase {

        @Test
        public void LDNS_引数が申請中を指定した場合_valueOfは_申請中を返す() {
            assertThat(NinteiShinseiYukoKubun.valueOf("申請中"), is(NinteiShinseiYukoKubun.申請中));
        }
    }
}
