/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator;
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
 * {@link KoikiShichosonCodeHenkanPatternIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoikiShichosonCodeHenkanPatternIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 広域内市町村番号;
    private static LasdecCode 市町村コード;
    private static RString コード区分;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        広域内市町村番号 = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域内市町村番号;
        市町村コード = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村コード;
        コード区分 = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_コード区分;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            KoikiShichosonCodeHenkanPatternIdentifier sut = new KoikiShichosonCodeHenkanPatternIdentifier(広域内市町村番号, 市町村コード, コード区分);
            assertThat(sut, is(serializable()));
        }
    }
}
