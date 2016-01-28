/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5913ChosainJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChosainJohoIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChosainJohoIdentifierTest extends DbzTestBase {

    private static LasdecCode 市町村コード;
    private static ChosaItakusakiCode 認定調査委託先コード;
    private static ChosainCode 認定調査員コード;

    @BeforeClass
    public static void setUpClass() {
        市町村コード = DbT5913ChosainJohoEntityGenerator.DEFAULT_市町村コード;
        認定調査委託先コード = new ChosaItakusakiCode(DbT5913ChosainJohoEntityGenerator.DEFAULT_認定調査委託先コード);
        認定調査員コード = new ChosainCode(DbT5913ChosainJohoEntityGenerator.DEFAULT_認定調査員コード);
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            ChosainJohoIdentifier sut = new ChosainJohoIdentifier(市町村コード, 認定調査委託先コード, 認定調査員コード);
            assertThat(sut, is(serializable()));
        }
    }
}
