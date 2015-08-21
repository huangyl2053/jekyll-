/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import java.lang.reflect.Constructor;
import org.junit.runner.RunWith;
import org.junit.experimental.runners.Enclosed;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 介護サービスマネージャーファクトリークラスのテストクラスです。
 *
 * @author n9935 知念 広宰
 */
@RunWith(Enclosed.class)
public class KaigoServiceManagerFactoryTest extends DbxTestBase {

    public static class createInstance extends DbxTestBase {

        @Test
        public void 取得したインスタンスの実体が_KaigoServiceManagerであること() {
            IKaigoServiceManager sut = KaigoServiceManagerFactory.createInstance();
            assertThat(sut, instanceOf(_KaigoServiceManager.class));
        }
    }
    
    public static class コンストラクタのテスト extends DbxTestBase {

        @Test
        public void LDNS_メソッドKaigoServiceManagerFactoryが呼び出される場合_KaigoServiceManagerFactoryは_インスタンス化成功() throws Exception {
            Constructor<KaigoServiceManagerFactory> constructor = KaigoServiceManagerFactory.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        }
    }
}
