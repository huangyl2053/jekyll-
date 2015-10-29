/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5914SonotaKikanJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link SonotaKikanJohoIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class SonotaKikanJohoIdentifierTest extends DbeTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShoKisaiHokenshaNo 証記載保険者番号;
    private static RString その他機関コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        証記載保険者番号 = DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_証記載保険者番号;
        その他機関コード = DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_その他機関コード;
    }

    public static class シリアライズテスト extends DbeTestBase {

        @Test
        public void シリアライズできる() {
            SonotaKikanJohoIdentifier sut = new SonotaKikanJohoIdentifier(証記載保険者番号, その他機関コード);
            assertThat(sut, is(serializable()));
        }
    }
}
