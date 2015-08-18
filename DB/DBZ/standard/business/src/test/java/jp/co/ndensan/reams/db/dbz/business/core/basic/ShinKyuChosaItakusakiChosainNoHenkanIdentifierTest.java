/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator;
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
 * {@link ShinKyuChosaItakusakiChosainNoHenkanIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShinKyuChosaItakusakiChosainNoHenkanIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 市町村コード;
    private static RString 旧調査委託先番号;
    private static RString 旧調査員番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        市町村コード = DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_市町村コード;
        旧調査委託先番号 = DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_旧調査委託先番号;
        旧調査員番号 = DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_旧調査員番号;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            ShinKyuChosaItakusakiChosainNoHenkanIdentifier sut = new ShinKyuChosaItakusakiChosainNoHenkanIdentifier(市町村コード, 旧調査委託先番号, 旧調査委託先番号);
            assertThat(sut, is(serializable()));
        }
    }
}
