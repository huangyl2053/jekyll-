/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7034KoikiGaijiHenkanErrorLogEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KoikiGaijiHenkanErrorLogIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoikiGaijiHenkanErrorLogIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 処理番号;
    private static RString 連番;
    private static RString エラー表示連番;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        処理番号 = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_処理番号;
        連番 = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_連番;
        エラー表示連番 = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_エラー表示連番;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            KoikiGaijiHenkanErrorLogIdentifier sut = new KoikiGaijiHenkanErrorLogIdentifier(処理番号, 連番, エラー表示連番);
            assertThat(sut, is(serializable()));
        }
    }
}
