/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JutakuKaishuRiyushoTesuryoShukeiIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JutakuKaishuRiyushoTesuryoShukeiIdentifierTest extends DbcTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static int 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名2 = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_集計開始年月;
        主キー名3 = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class シリアライズテスト extends DbcTestBase {

        @Test
        public void シリアライズできる() {
            JutakuKaishuRiyushoTesuryoShukeiIdentifier sut = new JutakuKaishuRiyushoTesuryoShukeiIdentifier(主キー名1, 主キー名2, new Decimal(主キー名3));
            assertThat(sut, is(serializable()));
        }
    }
}
