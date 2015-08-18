/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV4001JukyushaDaichoEntityGenerator;
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
 * {@link JukyushaDaichoAliveIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JukyushaDaichoAliveIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 市町村コード;
    private static HihokenshaNo 被保険者番号;
    private static RString 履歴番号;
    private static RString 枝番;
    private static Code 受給申請事由;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        市町村コード = DbV4001JukyushaDaichoEntityGenerator.DEFAULT_市町村コード;
        被保険者番号 = DbV4001JukyushaDaichoEntityGenerator.DEFAULT_被保険者番号;
        履歴番号 = DbV4001JukyushaDaichoEntityGenerator.DEFAULT_履歴番号;
        枝番 = DbV4001JukyushaDaichoEntityGenerator.DEFAULT_枝番;
        受給申請事由 = DbV4001JukyushaDaichoEntityGenerator.DEFAULT_受給申請事由;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            JukyushaDaichoAliveIdentifier sut = new JukyushaDaichoAliveIdentifier(市町村コード,
                    被保険者番号,
                    履歴番号,
                    枝番,
                    受給申請事由);
            assertThat(sut, is(serializable()));
        }
    }
}
