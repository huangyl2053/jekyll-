/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import java.lang.reflect.Constructor;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 施設入退所ファインダークラスのファクトリークラスのテストです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class ShisetsuNyutaishoFinderFactoryTest extends DbxTestBase {

    public static class createInstance extends DbxTestBase {

        @Test
        public void 実態が_ShisetsuNyutaishoFinderのインスタンスを返す() {
            IShisetsuNyutaishoFinder result = ShisetsuNyutaishoFinderFactory.createInstance();
            assertThat(result, instanceOf(_ShisetsuNyutaishoFinder.class));
        }
    }

    public static class コンストラクタTEST extends DbxTestBase {

        @Test
        public void LDNS_privateConstructor() throws Exception {
            Constructor<ShisetsuNyutaishoFinderFactory> constructor = ShisetsuNyutaishoFinderFactory.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        }

    }
}
