/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype;

import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.HokenShubetsu;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 保険種別を表す列挙型のテストクラスです。
 *
 * @author LDNS 代聡
 */
@RunWith(Enclosed.class)
public class HokenShubetsuTest extends DbxTestBase {

    public static class valueOfTest extends DbxTestBase {

        @Test
        public void LDNS_引数が国民健康保険の場合_valueOfは_国民健康保険を返す() {
            assertThat(HokenShubetsu.valueOf("国民健康保険"), is(HokenShubetsu.国民健康保険));
        }
    }
}
