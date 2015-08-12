/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5204NinteichosahyoKihonChosaScoreEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5204NinteichosahyoKihonChosaScoreEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteichosahyoKihonChosaScoreBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosahyoKihonChosaScoreBuilderTest extends DbzTestBase {

    private static DbT5204NinteichosahyoKihonChosaScoreEntity NinteichosahyoKihonChosaScoreEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
//    private static 主キー型1 主キー名1;
//    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
//        主キー名1 = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_主キー名1;
//        主キー名2 = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static NinteichosahyoKihonChosaScoreBuilder sut;
        private static NinteichosahyoKihonChosaScore business;

        @Before
        public void setUp() {
            NinteichosahyoKihonChosaScoreEntity = new DbT5204NinteichosahyoKihonChosaScoreEntity();

            business = new NinteichosahyoKihonChosaScore(NinteichosahyoKihonChosaScoreEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            business = sut.set申請書管理番号(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_申請書管理番号).build();
            assertThat(business.get申請書管理番号(), is(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の要介護認定調査履歴番号は_設定した値と同じ要介護認定調査履歴番号を返す() {
            business = sut.set要介護認定調査履歴番号(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_要介護認定調査履歴番号).build();
            assertThat(business.get要介護認定調査履歴番号(), is(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_要介護認定調査履歴番号));
        }

        @Test
        public void 戻り値の厚労省IF識別コードは_設定した値と同じ厚労省IF識別コードを返す() {
            business = sut.set厚労省IF識別コード(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_厚労省IF識別コード).build();
            assertThat(business.get厚労省IF識別コード(), is(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_厚労省IF識別コード));
        }

        @Test
        public void 戻り値の素点合計_第１郡は_設定した値と同じ素点合計_第１郡を返す() {
            business = sut.set素点合計_第１郡(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_素点合計_第１郡).build();
            assertThat(business.get素点合計_第１郡(), is(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_素点合計_第１郡));
        }

        @Test
        public void 戻り値の素点合計_第２郡は_設定した値と同じ素点合計_第２郡を返す() {
            business = sut.set素点合計_第２郡(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_素点合計_第２郡).build();
            assertThat(business.get素点合計_第２郡(), is(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_素点合計_第２郡));
        }

        @Test
        public void 戻り値の素点合計_第３郡は_設定した値と同じ素点合計_第３郡を返す() {
            business = sut.set素点合計_第３郡(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_素点合計_第３郡).build();
            assertThat(business.get素点合計_第３郡(), is(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_素点合計_第３郡));
        }

        @Test
        public void 戻り値の素点合計_第４郡は_設定した値と同じ素点合計_第４郡を返す() {
            business = sut.set素点合計_第４郡(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_素点合計_第４郡).build();
            assertThat(business.get素点合計_第４郡(), is(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_素点合計_第４郡));
        }

        @Test
        public void 戻り値の素点合計_第５郡は_設定した値と同じ素点合計_第５郡を返す() {
            business = sut.set素点合計_第５郡(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_素点合計_第５郡).build();
            assertThat(business.get素点合計_第５郡(), is(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_素点合計_第５郡));
        }

        @Test
        public void 戻り値の素点合計_第６郡は_設定した値と同じ素点合計_第６郡を返す() {
            business = sut.set素点合計_第６郡(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_素点合計_第６郡).build();
            assertThat(business.get素点合計_第６郡(), is(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_素点合計_第６郡));
        }

        @Test
        public void 戻り値の素点合計_第７郡は_設定した値と同じ素点合計_第７郡を返す() {
            business = sut.set素点合計_第７郡(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_素点合計_第７郡).build();
            assertThat(business.get素点合計_第７郡(), is(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_素点合計_第７郡));
        }

    }
}
