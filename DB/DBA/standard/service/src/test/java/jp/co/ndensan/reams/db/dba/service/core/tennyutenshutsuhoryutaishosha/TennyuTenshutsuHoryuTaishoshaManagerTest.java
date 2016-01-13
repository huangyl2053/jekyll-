/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tennyutenshutsuhoryutaishosha;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author soft863
 */
@RunWith(Enclosed.class)
public class TennyuTenshutsuHoryuTaishoshaManagerTest extends DbaTestDacBase {

    private static TennyuTenshutsuHoryuTaishoshaManager sut;
    private static final ShikibetsuCode 識別コード = new ShikibetsuCode("4102221994");
    private static final Decimal 履歴番号 = new Decimal(10);
    private static final RString 対象種類 = new RString("転入保留者");

    @BeforeClass
    public static void setUpClass() {
        sut = TennyuTenshutsuHoryuTaishoshaManager.createInstance();

    }

    public static class TennyuTenshutsuHoryuTaishoshaManagerテスト extends DbaTestDacBase {

        @Test
        public void 資格取得除外者登録のテスト() {

            boolean result = sut.delHoryuTaishosha(識別コード, 履歴番号, 対象種類);
            sqlSession.commit();
            assertThat(result, is(true));
        }
    }
}
