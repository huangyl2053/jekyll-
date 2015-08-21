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
 * 高額介護サービス費を検索するクラスのファクトリーのテストクラスです。
 *
 * @author LDNS 孫海迪
 */
@RunWith(Enclosed.class)
public class KogakuKaigoServiceHiFinderFactoryTest extends DbxTestBase {

    public static class getInstanceのテスト extends DbxTestBase {

        @Test
        public void LDNS_高額介護サービス費Finderが呼び出される場合_getInstanceは_IKogakuKaigoServiceHiFinderのインスタンスを返す() {
            assertThat(KogakuKaigoServiceHiFinderFactory.getInstance(), instanceOf(IKogakuKaigoServiceHiFinder.class));
        }
    }
    
     public static class コンストラクタのテスト extends DbxTestBase {

        @Test
        public void LDNS_メソッドKogakuKaigoServiceHiFinderFactoryが呼び出される場合_KogakuKaigoServiceHiFinderFactoryは_インスタンス化成功() throws Exception {
            Constructor<KogakuKaigoServiceHiFinderFactory> constructor = KogakuKaigoServiceHiFinderFactory.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        }
    }
}
