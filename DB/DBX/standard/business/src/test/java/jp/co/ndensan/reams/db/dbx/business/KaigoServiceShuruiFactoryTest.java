/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import java.lang.reflect.Constructor;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoServiceBunruiCode;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 介護サービス種類のファクトリークラスのテストクラスです。
 *
 * @author LDNS 郭旗
 */
@RunWith(Enclosed.class)
public class KaigoServiceShuruiFactoryTest extends DbxTestBase {

    private static final KaigoServiceShuruiCode サービス種類コード = new KaigoServiceShuruiCode(new RString("22"));
    private static final Range<FlexibleYearMonth> 提供年月 = new Range(FlexibleYearMonth.MIN, FlexibleYearMonth.MAX);
    private static final RString サービス種類名称 = new RString("123456");
    private static final RString サービス種類名称略称 = new RString("213234");
    private static final KaigoServiceBunruiCode サービス分類 = new KaigoServiceBunruiCode(new RString("113366"));

    public static class getInstanceのテスト extends DbxTestBase {

        @Test
        public void LDNS_メソッドgetInstanceが呼び出される場合_getInstanceは_123456を返す() {
            IKaigoServiceShurui result = KaigoServiceShuruiFactory.getInstance(サービス種類コード, 提供年月, サービス種類名称, サービス種類名称略称, サービス分類);
            assertThat(result.getサービス種類名称(), is(new RString("123456")));
        }

    }

    public static class コンストラクタのテスト extends DbxTestBase {

        @Test
        public void LDNS_メソッドKaigoServiceShuruiFactoryが呼び出される場合_KaigoServiceShuruiFactoryは_インスタンス化成功() throws Exception {
            Constructor<KaigoServiceShuruiFactory> constructor = KaigoServiceShuruiFactory.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        }
    }

}
