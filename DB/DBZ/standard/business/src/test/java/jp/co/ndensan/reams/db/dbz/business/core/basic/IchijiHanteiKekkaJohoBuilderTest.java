/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4116IchijiHanteiKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IchijiHanteiKekkaJohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IchijiHanteiKekkaJohoBuilderTest extends DbzTestBase {

    private static DbT4116IchijiHanteiKekkaJohoEntity IchijiHanteiKekkaJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT4116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static IchijiHanteiKekkaJohoBuilder sut;
        private static IchijiHanteiKekkaJoho business;

        @Before
        public void setUp() {
            IchijiHanteiKekkaJohoEntity = new DbT4116IchijiHanteiKekkaJohoEntity();

            business = new IchijiHanteiKekkaJoho(IchijiHanteiKekkaJohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            business = sut.set申請書管理番号(DbT4116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号).build();
            assertThat(business.get申請書管理番号(), is(DbT4116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の仮一次判定区分は_設定した値と同じ仮一次判定区分を返す() {
            business = sut.set仮一次判定区分(DbT4116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_仮一次判定区分).build();
            assertThat(business.get仮一次判定区分(), is(DbT4116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_仮一次判定区分));
        }

        @Test
        public void 戻り値の要介護認定一次判定年月日は_設定した値と同じ要介護認定一次判定年月日を返す() {
            business = sut.set要介護認定一次判定年月日(DbT4116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定一次判定年月日).build();
            assertThat(business.get要介護認定一次判定年月日(), is(DbT4116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定一次判定年月日));
        }

        @Test
        public void 戻り値の要介護認定一次判定結果コードは_設定した値と同じ要介護認定一次判定結果コードを返す() {
            business = sut.set要介護認定一次判定結果コード(DbT4116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定一次判定結果コード).build();
            assertThat(business.get要介護認定一次判定結果コード(), is(DbT4116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定一次判定結果コード));
        }

        @Test
        public void 戻り値の要介護認定一次判定結果コード_認知症加算は_設定した値と同じ要介護認定一次判定結果コード_認知症加算を返す() {
            business = sut.set要介護認定一次判定結果コード_認知症加算(DbT4116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定一次判定結果コード_認知症加算).build();
            assertThat(business.get要介護認定一次判定結果コード_認知症加算(), is(DbT4116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_要介護認定一次判定結果コード_認知症加算));
        }

    }
}
