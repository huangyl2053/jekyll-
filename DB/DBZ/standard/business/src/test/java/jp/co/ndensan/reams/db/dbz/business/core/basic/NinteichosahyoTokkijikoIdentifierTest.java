/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5205NinteichosahyoTokkijikoEntityGenerator;
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
 * {@link NinteichosahyoTokkijikoIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosahyoTokkijikoIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 認定調査依頼履歴番号;
    private static RString 認定調査特記事項番号;
    private static RString 認定調査特記事項連番;
    private static RString 特記事項テキスト_イメージ区分;
    private static Code 原本マスク区分;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_申請書管理番号;
        認定調査依頼履歴番号 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_認定調査依頼履歴番号;
        認定調査特記事項番号 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_認定調査特記事項番号;
        認定調査特記事項連番 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_認定調査特記事項連番;
        特記事項テキスト_イメージ区分 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_特記事項テキスト_イメージ区分;
        原本マスク区分 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_原本マスク区分;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            NinteichosahyoTokkijikoIdentifier sut = new NinteichosahyoTokkijikoIdentifier(申請書管理番号, 認定調査依頼履歴番号, 認定調査特記事項番号, 認定調査特記事項連番, 特記事項テキスト_イメージ区分, 原本マスク区分);
            assertThat(sut, is(serializable()));
        }
    }
}
