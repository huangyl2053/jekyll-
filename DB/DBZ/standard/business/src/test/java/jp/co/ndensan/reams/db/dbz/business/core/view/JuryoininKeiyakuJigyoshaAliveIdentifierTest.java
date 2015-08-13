/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3077JuryoininKeiyakuJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JuryoininKeiyakuJigyoshaAliveIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JuryoininKeiyakuJigyoshaAliveIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 事業者契約番号;
    private static FlexibleDate 開始年月日;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        事業者契約番号 = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_事業者契約番号;
        開始年月日 = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_開始年月日;
        履歴番号 = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            JuryoininKeiyakuJigyoshaAliveIdentifier sut = new JuryoininKeiyakuJigyoshaAliveIdentifier(事業者契約番号, 開始年月日, 履歴番号);
            assertThat(sut, is(serializable()));
        }
    }
}
