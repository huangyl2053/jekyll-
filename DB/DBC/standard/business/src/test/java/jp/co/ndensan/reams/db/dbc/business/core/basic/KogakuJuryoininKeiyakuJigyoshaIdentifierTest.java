/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KogakuJuryoininKeiyakuJigyoshaIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuJuryoininKeiyakuJigyoshaIdentifierTest extends DbcTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static int 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class シリアライズテスト extends DbcTestBase {

        @Test
        public void シリアライズできる() {
            KogakuJuryoininKeiyakuJigyoshaIdentifier sut = new KogakuJuryoininKeiyakuJigyoshaIdentifier(主キー名1, 主キー名2);
            assertThat(sut, is(serializable()));
        }
    }
}
