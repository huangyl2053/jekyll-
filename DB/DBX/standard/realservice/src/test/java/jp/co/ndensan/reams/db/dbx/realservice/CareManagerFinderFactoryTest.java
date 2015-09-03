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
 * ケアマネージャマネージャーファクトリーのテストクラスです。
 *
 * @author LDNS 郭旗
 */
@RunWith(Enclosed.class)
public class CareManagerFinderFactoryTest extends DbxTestBase {

    public static class getInstanceTest extends DbxTestBase {

        @Test
        public void LDNS_生成したインスタンスの場合_getInstanceは_CareManagerFinderのインスタンスを返る() {
            assertThat(CareManagerFinderFactory.getInstance(), instanceOf(ICareManagerFinder.class));
        }
    }

    public static class コンストラクタのテスト extends DbxTestBase {

        @Test
        public void LDNS_メソッドCareManagerFinderFactoryが呼び出される場合_CareManagerFinderFactoryは_インスタンス化成功() throws Exception {
            Constructor<CareManagerFinderFactory> constructor = CareManagerFinderFactory.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        }
    }
}
