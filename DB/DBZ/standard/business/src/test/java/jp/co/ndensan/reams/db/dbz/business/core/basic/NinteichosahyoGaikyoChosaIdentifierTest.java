/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5202NinteichosahyoGaikyoChosaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteichosahyoGaikyoChosaIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosahyoGaikyoChosaIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 認定調査依頼履歴番号;
    private static RString 概況調査テキストイメージ区分;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_申請書管理番号;
        認定調査依頼履歴番号 = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査依頼履歴番号;
        概況調査テキストイメージ区分 = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_概況調査テキストイメージ区分;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            NinteichosahyoGaikyoChosaIdentifier sut = new NinteichosahyoGaikyoChosaIdentifier(申請書管理番号, 認定調査依頼履歴番号, 概況調査テキストイメージ区分);
            assertThat(sut, is(serializable()));
        }
    }
}
