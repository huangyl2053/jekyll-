/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.view;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbV1004ShisetsuNyutaishoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShisetsuNyutaishoAliveIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShisetsuNyutaishoAliveIdentifierTest extends DbxTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 主キー名1;
    private static Decimal 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbV1004ShisetsuNyutaishoEntityGenerator.DEFAULT_識別コード;
        主キー名2 = DbV1004ShisetsuNyutaishoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class シリアライズテスト extends DbxTestBase {

        @Test
        public void シリアライズできる() {
            ShisetsuNyutaishoAliveIdentifier sut = new ShisetsuNyutaishoAliveIdentifier(主キー名1, 主キー名2);
            assertThat(sut, is(serializable()));
        }
    }
}
