/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysShikakuShogohyo;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.IConfigKeysKokuhorenTorikomi;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * TODO 不要
 *
 * @author N2810 久保 里史
 */
@RunWith(Enclosed.class)
public class KokuhorenTorikomiConfigKeysFactoryTest extends DbcTestBase {

    @Before
    public void setUp() {

    }

    public static class ConstructorTest extends DbcTestBase {

        @Test
        public void getInstanceのテスト() {
            Integer i = 0;
            IConfigKeysKokuhorenTorikomi[] a = KokuhorenTorikomiConfigKeysFactory.getEnumValues(new RString(("121")));
            for (IConfigKeysKokuhorenTorikomi b : a) {
                i = i + 1;

            }

            i = i + 1;
        }

    }
}
