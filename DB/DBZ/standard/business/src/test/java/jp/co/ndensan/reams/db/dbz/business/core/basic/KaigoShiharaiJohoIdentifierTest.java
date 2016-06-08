/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7004KaigoShiharaiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoShiharaiJohoIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoShiharaiJohoIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 識別コード;
    private static KamokuCode 科目コード;
    private static FlexibleDate 決定年月日;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        識別コード = DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_識別コード;
        科目コード = DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_科目コード;
        決定年月日 = DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_決定年月日;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            KaigoShiharaiJohoIdentifier sut = new KaigoShiharaiJohoIdentifier(識別コード, 科目コード, 決定年月日);
            assertThat(sut, is(serializable()));
        }
    }
}
