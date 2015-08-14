/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShinKyuTaTokureiShisetsuNoHenkanIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShinKyuTaTokureiShisetsuNoHenkanIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 市町村コード;
    private static RString 旧他特例施設番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        市町村コード = DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_市町村コード;
        旧他特例施設番号 = DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_旧他特例施設番号;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            ShinKyuTaTokureiShisetsuNoHenkanIdentifier sut = new ShinKyuTaTokureiShisetsuNoHenkanIdentifier(市町村コード, 旧他特例施設番号);
            assertThat(sut, is(serializable()));
        }
    }
}
