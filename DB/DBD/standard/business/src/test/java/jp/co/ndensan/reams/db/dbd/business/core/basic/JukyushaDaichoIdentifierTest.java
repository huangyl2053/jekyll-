/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT4001JukyushaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
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
 * {@link JukyushaDaichoIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JukyushaDaichoIdentifierTest extends DbdTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 主キー名1;
    private static HihokenshaNo 主キー名2;
    private static RString 主キー名3;
    private static RString 主キー名4;
    private static Code 主キー名5;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_市町村コード;
        主キー名2 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_被保険者番号;
        主キー名3 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_履歴番号;
        主キー名4 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_枝番;
        主キー名5 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_受給申請事由;

    }

    public static class シリアライズテスト extends DbdTestBase {

//        @Test
//        public void シリアライズできる() {
//            JukyushaDaichoIdentifier sut = new JukyushaDaichoIdentifier(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
//            assertThat(sut, is(serializable()));
//        }
    }
}
