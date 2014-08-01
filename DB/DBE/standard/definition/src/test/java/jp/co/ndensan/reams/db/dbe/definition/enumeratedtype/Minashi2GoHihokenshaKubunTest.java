/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author N8211 田辺 紘一
 */
@RunWith(Enclosed.class)
public class Minashi2GoHihokenshaKubunTest {

    public static class toValueのテスト extends DbeTestBase {

        @Test
        public void 値に1を渡したとき_みなし2号を返す() {
            assertThat(Minashi2GoHihokenshaKubun.toValue(new RString("1")).toString(), is("みなし2号"));
        }

        @Test
        public void 値に0を渡したとき_その他を返す() {
            assertThat(Minashi2GoHihokenshaKubun.toValue(new RString("0")).toString(), is("その他"));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 値に0と1以外を渡したとき_IllegalArgumentExceptionを返す() {
            Minashi2GoHihokenshaKubun.toValue(new RString("-1"));
            fail();
        }

    }
}
