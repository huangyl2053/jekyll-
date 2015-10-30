/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou;

import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyouIdentifier;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7131KaigoServiceNaiyouEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static jp.co.ndensan.reams.uz.uza.testhelper.ByteArraySerializations.canBeCopiedBySerialization;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoServiceNaiyouIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoServiceNaiyouIdentifierTest extends DbxTestBase {

    private static KaigoServiceShuruiCode サービス種類コード;
    private static RString サービス項目コード;
    private static FlexibleYearMonth 提供開始年月;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
        サービス種類コード = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス種類コード;
        サービス項目コード = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス項目コード;
        提供開始年月 = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_提供開始年月;
        履歴番号 = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_履歴番号;
    }

    public static class シリアライズテスト extends DbxTestBase {

        @Test
        public void シリアライズできる() {
            KaigoServiceNaiyouIdentifier sut = new KaigoServiceNaiyouIdentifier(サービス種類コード, サービス項目コード, 提供開始年月, 履歴番号);
            assertThat(sut, is(canBeCopiedBySerialization()));
        }
    }
}
