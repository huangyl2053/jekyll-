/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3098TandokuJoseikinKyufuShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link TandokuJoseikinKyufuShinseiIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TandokuJoseikinKyufuShinseiIdentifierTest extends DbcTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleDate 主キー名2;
    private static Decimal 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_受付年月日;
    }

    public static class シリアライズテスト extends DbcTestBase {

        @Test
        public void シリアライズできる() {
            TandokuJoseikinKyufuShinseiIdentifier sut = new TandokuJoseikinKyufuShinseiIdentifier(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }
}
