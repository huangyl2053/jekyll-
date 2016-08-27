/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifierTest extends DbcTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static int 主キー名3;
    private static FlexibleYearMonth 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityGenerator.DEFAULT_対象年月;
    }

    public static class シリアライズテスト extends DbcTestBase {

        @Test
        public void シリアライズできる() {
            YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier sut = new YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }
}
