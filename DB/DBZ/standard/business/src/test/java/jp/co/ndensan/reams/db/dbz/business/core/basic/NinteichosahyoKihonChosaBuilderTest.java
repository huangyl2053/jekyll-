/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5203NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5202NinteichosahyoGaikyoChosaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5203NinteichosahyoKihonChosaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteichosahyoKihonChosaBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosahyoKihonChosaBuilderTest extends DbzTestBase {

    private static DbT5203NinteichosahyoKihonChosaEntity NinteichosahyoKihonChosaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 認定調査依頼履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_申請書管理番号;
        認定調査依頼履歴番号 = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査依頼履歴番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static NinteichosahyoKihonChosaBuilder sut;
        private static NinteichosahyoKihonChosa business;

        @Before
        public void setUp() {
            NinteichosahyoKihonChosaEntity = new DbT5203NinteichosahyoKihonChosaEntity();

            business = new NinteichosahyoKihonChosa(NinteichosahyoKihonChosaEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            business = sut.set申請書管理番号(DbT5203NinteichosahyoKihonChosaEntityGenerator.DEFAULT_申請書管理番号).build();
            assertThat(business.get申請書管理番号(), is(DbT5203NinteichosahyoKihonChosaEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の要介護認定調査履歴番号は_設定した値と同じ要介護認定調査履歴番号を返す() {
            business = sut.set要介護認定調査履歴番号(DbT5203NinteichosahyoKihonChosaEntityGenerator.DEFAULT_要介護認定調査履歴番号).build();
            assertThat(business.get要介護認定調査履歴番号(), is(DbT5203NinteichosahyoKihonChosaEntityGenerator.DEFAULT_要介護認定調査履歴番号));
        }

        @Test
        public void 戻り値の厚労省IF識別コードは_設定した値と同じ厚労省IF識別コードを返す() {
            business = sut.set厚労省IF識別コード(DbT5203NinteichosahyoKihonChosaEntityGenerator.DEFAULT_厚労省IF識別コード).build();
            assertThat(business.get厚労省IF識別コード(), is(DbT5203NinteichosahyoKihonChosaEntityGenerator.DEFAULT_厚労省IF識別コード));
        }

        @Test
        public void 戻り値の認定調査_認知症高齢者の日常生活自立度コードは_設定した値と同じ認定調査_認知症高齢者の日常生活自立度コードを返す() {
            business = sut.set認定調査_認知症高齢者の日常生活自立度コード(DbT5203NinteichosahyoKihonChosaEntityGenerator.DEFAULT_認定調査_認知症高齢者の日常生活自立度コード).build();
            assertThat(business.get認定調査_認知症高齢者の日常生活自立度コード(), is(DbT5203NinteichosahyoKihonChosaEntityGenerator.DEFAULT_認定調査_認知症高齢者の日常生活自立度コード));
        }

        @Test
        public void 戻り値の認定調査_障害高齢者の日常生活自立度コードは_設定した値と同じ認定調査_障害高齢者の日常生活自立度コードを返す() {
            business = sut.set認定調査_障害高齢者の日常生活自立度コード(DbT5203NinteichosahyoKihonChosaEntityGenerator.DEFAULT_認定調査_障害高齢者の日常生活自立度コード).build();
            assertThat(business.get認定調査_障害高齢者の日常生活自立度コード(), is(DbT5203NinteichosahyoKihonChosaEntityGenerator.DEFAULT_認定調査_障害高齢者の日常生活自立度コード));
        }

    }
}
