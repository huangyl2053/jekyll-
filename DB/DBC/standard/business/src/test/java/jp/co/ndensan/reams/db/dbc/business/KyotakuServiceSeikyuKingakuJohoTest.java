/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 給付実績居宅サービスの請求金額などの情報についてのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class KyotakuServiceSeikyuKingakuJohoTest {

    public static class constructorのテスト extends DbcTestBase {

        private KyotakuServiceSeikyuKingakuJoho sut;
        private int 単位数;
        private int 回数;
        private int サービス単位数;
        private int サービス単位数合計;
        private int 請求金額;

        @Before
        public void setUp() {
            単位数 = 4;
            回数 = 3;
            サービス単位数 = 2;
            サービス単位数合計 = 6;
            請求金額 = 123456;
        }

        @Test(expected = IllegalArgumentException.class)
        public void 単位数に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new KyotakuServiceSeikyuKingakuJoho(-1, 回数, サービス単位数, サービス単位数合計, 請求金額);
            fail();
        }

        @Test(expected = IllegalArgumentException.class)
        public void 回数に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new KyotakuServiceSeikyuKingakuJoho(単位数, -1, サービス単位数, サービス単位数合計, 請求金額);
            fail();
        }

        @Test(expected = IllegalArgumentException.class)
        public void サービス単位数に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new KyotakuServiceSeikyuKingakuJoho(単位数, 回数, -1, サービス単位数合計, 請求金額);
            fail();
        }

        @Test(expected = IllegalArgumentException.class)
        public void サービス単位数合計に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new KyotakuServiceSeikyuKingakuJoho(単位数, 回数, サービス単位数, -1, 請求金額);
            fail();
        }

        @Test(expected = IllegalArgumentException.class)
        public void 請求金額に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new KyotakuServiceSeikyuKingakuJoho(単位数, 回数, サービス単位数, サービス単位数合計, -1);
            fail();
        }

        @Test
        public void 全ての引数が0以上の値であるとき_インスタンスが生成される() {
            sut = new KyotakuServiceSeikyuKingakuJoho(単位数, 回数, サービス単位数, サービス単位数合計, 請求金額);
            assertThat(sut, is(instanceOf(KyotakuServiceSeikyuKingakuJoho.class)));
        }
    }

}
