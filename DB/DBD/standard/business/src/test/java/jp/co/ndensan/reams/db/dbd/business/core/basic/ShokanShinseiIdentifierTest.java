/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.helper.DbT3034ShokanShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanShinseiIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanShinseiIdentifierTest extends DbcTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static RString 主キー名3;
    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3034ShokanShinseiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3034ShokanShinseiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3034ShokanShinseiEntityGenerator.DEFAULT_整理番号;
//        主キー名4 = DbT3034ShokanShinseiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class シリアライズテスト extends DbcTestBase {

        @Test
        public void シリアライズできる() {
//            ShokanShinseiIdentifier sut = new ShokanShinseiIdentifier(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            ShokanShinseiIdentifier sut = new ShokanShinseiIdentifier(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut, is(serializable()));
        }
    }
}
