/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3101NijiYoboKihonCheckListEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NijiYoboKihonCheckListIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NijiYoboKihonCheckListIdentifierTest extends DbcTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 識別コード;
    private static HihokenshaNo 被保険者番号;
    private static FlexibleDate 受付年月日;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        識別コード = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_識別コード;
        被保険者番号 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_被保険者番号;
        受付年月日 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_受付年月日;
        履歴番号 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_履歴番号;
    }

    public static class シリアライズテスト extends DbcTestBase {

        @Test
        public void シリアライズできる() {
            NijiYoboKihonCheckListIdentifier sut = new NijiYoboKihonCheckListIdentifier(識別コード, 被保険者番号, 受付年月日, 履歴番号);
            assertThat(sut, is(serializable()));
        }
    }
}
