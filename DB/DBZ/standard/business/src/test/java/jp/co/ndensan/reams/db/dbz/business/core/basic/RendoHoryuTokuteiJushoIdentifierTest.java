/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7023RendoHoryuTokuteiJushoEntityGenerator;
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
 * {@link RendoHoryuTokuteiJushoIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RendoHoryuTokuteiJushoIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 管理番号;
    private static LasdecCode 市町村コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        管理番号 = DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_管理番号;
        市町村コード = DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_市町村コード;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            RendoHoryuTokuteiJushoIdentifier sut = new RendoHoryuTokuteiJushoIdentifier(管理番号, 市町村コード);
            assertThat(sut, is(serializable()));
        }
    }
}
