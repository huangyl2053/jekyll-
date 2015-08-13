/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7056GappeiShichosonEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link GappeiShichosonIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class GappeiShichosonIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleDate 合併年月日;
    private static RString 地域番号;
    private static LasdecCode 旧市町村コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        合併年月日 = DbT7056GappeiShichosonEntityGenerator.DEFAULT_合併年月日;
        地域番号 = DbT7056GappeiShichosonEntityGenerator.DEFAULT_地域番号;
        旧市町村コード = DbT7056GappeiShichosonEntityGenerator.DEFAULT_旧市町村コード;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            GappeiShichosonIdentifier sut = new GappeiShichosonIdentifier(合併年月日, 地域番号, 旧市町村コード);
            assertThat(sut, is(serializable()));
        }
    }
}
