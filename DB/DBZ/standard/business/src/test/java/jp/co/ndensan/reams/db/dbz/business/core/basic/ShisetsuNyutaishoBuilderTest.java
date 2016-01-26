/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaishoBuilder;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1004ShisetsuNyutaishoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShisetsuNyutaishoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShisetsuNyutaishoBuilderTest extends DbzTestBase {

    private static DbT1004ShisetsuNyutaishoEntity ShisetsuNyutaishoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 識別コード;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        識別コード = DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_識別コード;
        履歴番号 = DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static ShisetsuNyutaishoBuilder sut;
        private static ShisetsuNyutaisho business;

        @Before
        public void setUp() {
            ShisetsuNyutaishoEntity = new DbT1004ShisetsuNyutaishoEntity();
            ShisetsuNyutaishoEntity.setShikibetsuCode(識別コード);
            ShisetsuNyutaishoEntity.setRirekiNo(履歴番号);

            business = new ShisetsuNyutaisho(ShisetsuNyutaishoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の台帳種別は_設定した値と同じ台帳種別を返す() {
            business = sut.set台帳種別(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_台帳種別).build();
            assertThat(business.get台帳種別(), is(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_台帳種別));
        }

        @Test
        public void 戻り値の入所施設種類は_設定した値と同じ入所施設種類を返す() {
            business = sut.set入所施設種類(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_入所施設種類).build();
            assertThat(business.get入所施設種類(), is(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_入所施設種類));
        }

        @Test
        public void 戻り値の入所施設コードは_設定した値と同じ入所施設コードを返す() {
            business = sut.set入所施設コード(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_入所施設コード).build();
            assertThat(business.get入所施設コード(), is(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_入所施設コード));
        }

        @Test
        public void 戻り値の入所処理年月日は_設定した値と同じ入所処理年月日を返す() {
            business = sut.set入所処理年月日(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_入所処理年月日).build();
            assertThat(business.get入所処理年月日(), is(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_入所処理年月日));
        }

        @Test
        public void 戻り値の入所年月日は_設定した値と同じ入所年月日を返す() {
            business = sut.set入所年月日(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_入所年月日).build();
            assertThat(business.get入所年月日(), is(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_入所年月日));
        }

        @Test
        public void 戻り値の退所処理年月日は_設定した値と同じ退所処理年月日を返す() {
            business = sut.set退所処理年月日(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_退所処理年月日).build();
            assertThat(business.get退所処理年月日(), is(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_退所処理年月日));
        }

        @Test
        public void 戻り値の退所年月日は_設定した値と同じ退所年月日を返す() {
            business = sut.set退所年月日(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_退所年月日).build();
            assertThat(business.get退所年月日(), is(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_退所年月日));
        }

        @Test
        public void 戻り値の部屋記号番号は_設定した値と同じ部屋記号番号を返す() {
            business = sut.set部屋記号番号(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_部屋記号番号).build();
            assertThat(business.get部屋記号番号(), is(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_部屋記号番号));
        }

    }
}
