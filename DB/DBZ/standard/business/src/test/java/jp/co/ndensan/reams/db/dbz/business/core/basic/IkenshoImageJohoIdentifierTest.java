/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5305IkenshoImageJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IkenshoImageJohoIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IkenshoImageJohoIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 主治医意見書作成依頼履歴番号;
    private static Code 帳票ID;
    private static RString マスキングデータ区分;
    private static int 取込みページ番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_申請書管理番号;
        主治医意見書作成依頼履歴番号 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号;
        帳票ID = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_帳票ID;
        マスキングデータ区分 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_マスキングデータ区分;
        取込みページ番号 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_取込みページ番号;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            IkenshoImageJohoIdentifier sut = new IkenshoImageJohoIdentifier(申請書管理番号, 主治医意見書作成依頼履歴番号, 帳票ID, マスキングデータ区分);
            assertThat(sut, is(serializable()));
        }
    }
}
