/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokureiIdentifier;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1003TashichosonJushochiTokureiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link TashichosonJushochiTokureiIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TashichosonJushochiTokureiIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 識別コード;
    private static FlexibleDate 異動日;
    private static RString 枝番;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        識別コード = DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_識別コード;
        異動日 = DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_異動日;
        枝番 = DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_枝番;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            TashichosonJushochiTokureiIdentifier sut = new TashichosonJushochiTokureiIdentifier(識別コード, 異動日, 枝番);
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }
}
