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
 * 介護保険受給者Finderのファクトリークラスのテストクラスです。
 *
 * @author LDNS 郭旗
 */
@RunWith(Enclosed.class)
public class KaigoHokenJukyushaFactoryTest extends DbxTestBase {

    public static class createInstanceのテスト extends DbxTestBase {

        @Test
        public void LDNS_メソッドcreateInstanceが呼び出される場合_createInstanceは_IKaigoHokenJukyushaFinderのインスタンスを返す() {
            assertThat(KaigoHokenJukyushaFactory.createInstance(), instanceOf(IKaigoHokenJukyushaFinder.class));
        }
    }

    public static class コンストラクタのテスト extends DbxTestBase {

        @Test
        public void LDNS_メソッドKaigoHokenJukyushaFactoryが呼び出される場合_KaigoHokenJukyushaFactoryは_インスタンス化成功() throws Exception {
            Constructor<KaigoHokenJukyushaFactory> constructor = KaigoHokenJukyushaFactory.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        }
    }
}
