/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5223ChikuNinteiChosainEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChikuNinteiChosainIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChikuNinteiChosainIdentifierTest extends DbzTestBase {

    private static Code 調査地区コード;
    private static RString 認定調査委託先コード;
    private static RString 認定調査員コード;
    private static LasdecCode 市町村コード;

    @BeforeClass
    public static void setUpClass() {
        調査地区コード = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_調査地区コード;
        認定調査委託先コード = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査委託先コード;
        認定調査員コード = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査員コード;
        市町村コード = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_市町村コード;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            ChikuNinteiChosainIdentifier sut = new ChikuNinteiChosainIdentifier(調査地区コード, 認定調査委託先コード, 認定調査員コード, 市町村コード);
            assertThat(sut, is(serializable()));
        }
    }
}
