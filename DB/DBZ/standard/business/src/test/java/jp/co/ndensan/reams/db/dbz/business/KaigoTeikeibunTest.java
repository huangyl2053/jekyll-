/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 介護定型文情報を表すクラスのテストクラスです。
 *
 * @author N9606 漢那 憲作
 */
@RunWith(Enclosed.class)
public class KaigoTeikeibunTest extends DbzTestBase {

    private static KaigoTeikeibun sut;
    private static RString 区分;
    private static RString 種別;
    private static RString コード;
    private static RString 内容;

    @BeforeClass
    public static void setUp() {
        区分 = new RString("1");
        種別 = new RString("001");
        コード = new RString("0001");
        内容 = new RString("定型文内容テスト");
    }

    public static class Constructor extends DbzTestBase {

        @Test
        public void 引数に必要な値が渡された時_インスタンスが生成される() {
            sut = new KaigoTeikeibun(区分, 種別, コード, 内容);
            assertThat(sut, is(instanceOf(KaigoTeikeibun.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 区分がnullの時_NullPointerExceptionが発生する() {
            sut = new KaigoTeikeibun(null, 種別, コード, 内容);
        }

        @Test(expected = NullPointerException.class)
        public void 種別がnullの時_NullPointerExceptionが発生する() {
            sut = new KaigoTeikeibun(区分, null, コード, 内容);
        }

        @Test(expected = NullPointerException.class)
        public void コードがnullの時_NullPointerExceptionが発生する() {
            sut = new KaigoTeikeibun(区分, 種別, null, 内容);
        }
    }
}
