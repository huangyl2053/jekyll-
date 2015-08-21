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
 * 介護事業者関連情報ファインダーファクトリのテストクラスです。
 *
 * @author LDNS 郭旗
 */
@RunWith(Enclosed.class)
public class KaigoJigyoshaRelateFinderFactoryTest extends DbxTestBase {

    public static class getInstanceTest extends DbxTestBase {

        @Test
        public void LDNS_生成したインスタンスの場合_createInstanceは_IKaigoJigyoshaRelateFinderのインスタンスを返る() {
            assertThat(KaigoJigyoshaRelateFinderFactory.createInstance(), instanceOf(IKaigoJigyoshaRelateFinder.class));
        }
    }

    public static class コンストラクタTEST extends DbxTestBase {

        @Test
        public void LDNS_privateConstructor() throws Exception {
            Constructor<KaigoJigyoshaRelateFinderFactory> constructor = KaigoJigyoshaRelateFinderFactory.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        }

    }
}
