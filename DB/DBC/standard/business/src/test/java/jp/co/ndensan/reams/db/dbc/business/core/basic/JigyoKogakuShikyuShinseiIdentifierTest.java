/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.testhelper.DbcTestBase;
import static jp.co.ndensan.reams.db.dbc.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JigyoKogakuShikyuShinseiIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JigyoKogakuShikyuShinseiIdentifierTest extends DbcTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3110JigyoKogakuShikyuShinseiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3110JigyoKogakuShikyuShinseiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class シリアライズテスト extends DbcTestBase {

        @Test
        public void シリアライズできる() {
            JigyoKogakuShikyuShinseiIdentifier sut = new JigyoKogakuShikyuShinseiIdentifier(主キー名1, 主キー名2);
            assertThat(sut, is(serializable()));
        }
    }
}
