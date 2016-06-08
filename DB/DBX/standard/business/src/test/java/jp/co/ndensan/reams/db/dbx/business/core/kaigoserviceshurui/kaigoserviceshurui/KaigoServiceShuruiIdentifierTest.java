/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui;

import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShuruiIdentifier;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7130KaigoServiceShuruiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import static jp.co.ndensan.reams.uz.uza.testhelper.ByteArraySerializations.canBeCopiedBySerialization;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoServiceShuruiIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoServiceShuruiIdentifierTest extends DbxTestBase {

    private static ServiceShuruiCode サービス種類コード;
    private static FlexibleYearMonth 提供開始年月;

    @BeforeClass
    public static void setUpClass() {
        サービス種類コード = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
        提供開始年月 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月;
    }

    public static class シリアライズテスト extends DbxTestBase {

        @Test
        public void シリアライズできる() {
            KaigoServiceShuruiIdentifier sut = new KaigoServiceShuruiIdentifier(サービス種類コード, 提供開始年月);
            assertThat(sut, is(canBeCopiedBySerialization()));
        }
    }
}
