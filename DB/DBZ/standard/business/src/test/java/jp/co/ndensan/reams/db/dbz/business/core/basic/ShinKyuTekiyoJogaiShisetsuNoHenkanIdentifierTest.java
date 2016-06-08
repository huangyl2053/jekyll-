/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator;
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
 * {@link ShinKyuTekiyoJogaiShisetsuNoHenkanIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShinKyuTekiyoJogaiShisetsuNoHenkanIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 市町村コード;
    private static RString 旧適用除外施設番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        市町村コード = DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_市町村コード;
        旧適用除外施設番号 = DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_旧適用除外施設番号;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            ShinKyuTekiyoJogaiShisetsuNoHenkanIdentifier sut = new ShinKyuTekiyoJogaiShisetsuNoHenkanIdentifier(市町村コード, 旧適用除外施設番号);
            assertThat(sut, is(serializable()));
        }
    }
}
