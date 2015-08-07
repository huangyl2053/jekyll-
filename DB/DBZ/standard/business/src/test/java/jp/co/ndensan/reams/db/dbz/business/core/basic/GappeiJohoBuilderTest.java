/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7055GappeiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link GappeiJohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class GappeiJohoBuilderTest extends DbzTestBase {

    private static DbT7055GappeiJohoEntity GappeiJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7055GappeiJohoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7055GappeiJohoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static GappeiJohoBuilder sut;
        private static GappeiJoho business;

        @Before
        public void setUp() {
            GappeiJohoEntity = new DbT7055GappeiJohoEntity();
            GappeiJohoEntity.setXXX(主キー名1);
            GappeiJohoEntity.setXXX(主キー名2);

            business = new GappeiJoho(GappeiJohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の合併年月日は_設定した値と同じ合併年月日を返す() {
            business = sut.set合併年月日(DbT7055GappeiJohoEntityGenerator.DEFAULT_合併年月日).build();
            assertThat(business.get合併年月日(), is(DbT7055GappeiJohoEntityGenerator.DEFAULT_合併年月日));
        }

        @Test
        public void 戻り値の地域番号は_設定した値と同じ地域番号を返す() {
            business = sut.set地域番号(DbT7055GappeiJohoEntityGenerator.DEFAULT_地域番号).build();
            assertThat(business.get地域番号(), is(DbT7055GappeiJohoEntityGenerator.DEFAULT_地域番号));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT7055GappeiJohoEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT7055GappeiJohoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の合併種類は_設定した値と同じ合併種類を返す() {
            business = sut.set合併種類(DbT7055GappeiJohoEntityGenerator.DEFAULT_合併種類).build();
            assertThat(business.get合併種類(), is(DbT7055GappeiJohoEntityGenerator.DEFAULT_合併種類));
        }

        @Test
        public void 戻り値の保険者番号は_設定した値と同じ保険者番号を返す() {
            business = sut.set保険者番号(DbT7055GappeiJohoEntityGenerator.DEFAULT_保険者番号).build();
            assertThat(business.get保険者番号(), is(DbT7055GappeiJohoEntityGenerator.DEFAULT_保険者番号));
        }

        @Test
        public void 戻り値の旧市町村情報付与終了年月日は_設定した値と同じ旧市町村情報付与終了年月日を返す() {
            business = sut.set旧市町村情報付与終了年月日(DbT7055GappeiJohoEntityGenerator.DEFAULT_旧市町村情報付与終了年月日).build();
            assertThat(business.get旧市町村情報付与終了年月日(), is(DbT7055GappeiJohoEntityGenerator.DEFAULT_旧市町村情報付与終了年月日));
        }

        @Test
        public void 戻り値の国保連データ連携開始年月日は_設定した値と同じ国保連データ連携開始年月日を返す() {
            business = sut.set国保連データ連携開始年月日(DbT7055GappeiJohoEntityGenerator.DEFAULT_国保連データ連携開始年月日).build();
            assertThat(business.get国保連データ連携開始年月日(), is(DbT7055GappeiJohoEntityGenerator.DEFAULT_国保連データ連携開始年月日));
        }

    }
}
