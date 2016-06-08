/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3099TandokuJoseiShuruiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable;
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
 * {@link TandokuJoseiShuruiIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TandokuJoseiShuruiIdentifierTest extends DbcTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 主キー名1;
    private static ServiceShuruiCode 主キー名2;
    private static FlexibleYearMonth 主キー名3;
    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成種類;
        主キー名2 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_助成サービス種類コード;
    }

    public static class シリアライズテスト extends DbcTestBase {

        @Test
        public void シリアライズできる() {
            TandokuJoseiShuruiIdentifier sut = new TandokuJoseiShuruiIdentifier(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }
}
