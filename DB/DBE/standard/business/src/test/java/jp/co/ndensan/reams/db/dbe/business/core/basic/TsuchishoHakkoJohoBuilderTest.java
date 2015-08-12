/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5122TsuchishoHakkoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5122TsuchishoHakkoJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link TsuchishoHakkoJohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TsuchishoHakkoJohoBuilderTest extends DbeTestBase {

    private static DbT5122TsuchishoHakkoJohoEntity TsuchishoHakkoJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static TsuchishoHakkoJohoBuilder sut;
        private static TsuchishoHakkoJoho business;

        @Before
        public void setUp() {
            TsuchishoHakkoJohoEntity = new DbT5122TsuchishoHakkoJohoEntity();

            business = new TsuchishoHakkoJoho(TsuchishoHakkoJohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            business = sut.set申請書管理番号(DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_申請書管理番号).build();
            assertThat(business.get申請書管理番号(), is(DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の通知区分は_設定した値と同じ通知区分を返す() {
            business = sut.set通知区分(DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_通知区分).build();
            assertThat(business.get通知区分(), is(DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_通知区分));
        }

        @Test
        public void 戻り値の通知理由は_設定した値と同じ通知理由を返す() {
            business = sut.set通知理由(DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_通知理由).build();
            assertThat(business.get通知理由(), is(DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_通知理由));
        }

        @Test
        public void 戻り値の通知年月日は_設定した値と同じ通知年月日を返す() {
            business = sut.set通知年月日(DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_通知年月日).build();
            assertThat(business.get通知年月日(), is(DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_通知年月日));
        }

        @Test
        public void 戻り値の通知開始年月日は_設定した値と同じ通知開始年月日を返す() {
            business = sut.set通知開始年月日(DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_通知開始年月日).build();
            assertThat(business.get通知開始年月日(), is(DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_通知開始年月日));
        }

        @Test
        public void 戻り値の通知終了年月日は_設定した値と同じ通知終了年月日を返す() {
            business = sut.set通知終了年月日(DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_通知終了年月日).build();
            assertThat(business.get通知終了年月日(), is(DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_通知終了年月日));
        }

        @Test
        public void 戻り値の通知区分期限は_設定した値と同じ通知区分期限を返す() {
            business = sut.set通知区分期限(DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_通知区分期限).build();
            assertThat(business.get通知区分期限(), is(DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_通知区分期限));
        }

        @Test
        public void 戻り値の通知完了年月日は_設定した値と同じ通知完了年月日を返す() {
            business = sut.set通知完了年月日(DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_通知完了年月日).build();
            assertThat(business.get通知完了年月日(), is(DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_通知完了年月日));
        }

    }
}
