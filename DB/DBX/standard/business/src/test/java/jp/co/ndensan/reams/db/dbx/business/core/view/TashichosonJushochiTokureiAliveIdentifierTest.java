/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.view;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbV1003TashichosonJushochiTokureiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
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
 * {@link TashichosonJushochiTokureiAliveIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TashichosonJushochiTokureiAliveIdentifierTest extends DbxTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 主キー名1;
    private static FlexibleDate 主キー名2;
    private static RString edaNo;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbV1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_識別コード;
        主キー名2 = DbV1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_異動日;
    }

    public static class シリアライズテスト extends DbxTestBase {
        
        @Test
        public void シリアライズできる() {
            TashichosonJushochiTokureiAliveIdentifier sut = new TashichosonJushochiTokureiAliveIdentifier(主キー名1, 主キー名2, edaNo);
            assertThat(sut, is(serializable()));
        }
    }
}
