/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5910NinteichosaItakusakiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteichosaItakusakiJohoIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosaItakusakiJohoIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 市町村コード;
    private static ChosaItakusakiCode 認定調査委託先コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        市町村コード = DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_市町村コード;
        認定調査委託先コード = DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_認定調査委託先コード;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            NinteichosaItakusakiJohoIdentifier sut = new NinteichosaItakusakiJohoIdentifier(市町村コード, 認定調査委託先コード);
            assertThat(sut, is(serializable()));
        }
    }
}
