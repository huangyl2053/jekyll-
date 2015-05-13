/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShisetsuCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 施設入退所情報を表すクラスのテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class NyushoShisetsuTest extends DbzTestBase {

    private static NyushoShisetsu sut;
    private static ShisetsuType 施設種類;
    private static ShisetsuCode 施設コード;
    private static RString 施設名称;
    private static RString 施設カナ名称;
    private static RString 施設所在地住所;

    @BeforeClass
    public static void setUp() {
        施設種類 = ShisetsuType.介護保険施設;
//        施設コード = mock(ShisetsuCode.class);
        施設コード = new ShisetsuCode(RString.EMPTY);
        施設名称 = new RString("たいよう");
        施設カナ名称 = new RString("タイヨウ");
        施設所在地住所 = new RString("山ノ内町");
    }

    public static class constructor extends DbzTestBase {

        @Test
        public void 引数に必要な値が渡された時_インスタンスが生成される() {
            sut = new NyushoShisetsu(施設種類, 施設コード, 施設名称, 施設カナ名称, 施設所在地住所);
            assertThat(sut, is(instanceOf(NyushoShisetsu.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 施設種類がnullの時_NullPointerExceptionが発生する() {
            sut = new NyushoShisetsu(null, 施設コード, 施設名称, 施設カナ名称, 施設所在地住所);
        }

        @Test(expected = NullPointerException.class)
        public void 施設コードがnullの時_NullPointerExceptionが発生する() {
            sut = new NyushoShisetsu(施設種類, null, 施設名称, 施設カナ名称, 施設所在地住所);
        }
    }
}
