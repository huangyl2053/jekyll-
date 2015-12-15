/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeijoho;

import jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeishichoson.GappeiShichoson;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.gappei.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.helper.DbT7055GappeiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.helper.DbT7056GappeiShichosonEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.gappeijoho.GappeiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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

    private static DbT7055GappeiJohoEntity gappeiJohoEntity;
    private static FlexibleDate 合併年月日;
    private static RString 地域番号;

    @BeforeClass
    public static void setUpClass() {
        合併年月日 = DbT7055GappeiJohoEntityGenerator.DEFAULT_合併年月日;
        地域番号 = DbT7055GappeiJohoEntityGenerator.DEFAULT_地域番号;
    }

    public static class GappeiShichosonテスト extends DbzTestBase {

        private static GappeiJohoBuilder sut;
        private static GappeiJoho business;
        private static GappeiShichoson seishinTechoNini;

        @Before
        public void setUp() {
            gappeiJohoEntity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            gappeiJohoEntity.setGappeiYMD(合併年月日);
            gappeiJohoEntity.setChiikiNo(地域番号);
            GappeiJohoRelateEntity entity = new GappeiJohoRelateEntity();
            entity.set合併情報Entity(gappeiJohoEntity);
            business = new GappeiJoho(entity);
            seishinTechoNini = new GappeiShichoson(合併年月日, 地域番号, DbT7056GappeiShichosonEntityGenerator.DEFAULT_旧市町村コード);
            sut = business.createBuilderForEdit();
        }

        @Test
        public void 償却資産概調品目に紐づくことが可能な子テーブル情報をsetGappeiShichosonで設定した場合_設定済みの子テーブル情報が返る() {
            business = sut.setGappeiShichoson(seishinTechoNini).build();
            assertThat(business.getGappeiShichosonList().size(), is(1));
        }
    }

    public static class getterSetterTest extends DbzTestBase {

        private static GappeiJohoBuilder sut;
        private static GappeiJoho business;

        @Before
        public void setUp() {
            gappeiJohoEntity = new DbT7055GappeiJohoEntity();
            gappeiJohoEntity.setGappeiYMD(合併年月日);
            gappeiJohoEntity.setChiikiNo(地域番号);

            GappeiJohoRelateEntity entity = new GappeiJohoRelateEntity();
            entity.set合併情報Entity(gappeiJohoEntity);
            business = new GappeiJoho(entity);

            sut = business.createBuilderForEdit();
        }

//        @Test
//        public void 戻り値の合併年月日は_設定した値と同じ合併年月日を返す() {
//            business = sut.set合併年月日(DbT7055GappeiJohoEntityGenerator.DEFAULT_合併年月日).build();
//            assertThat(business.get合併年月日(), is(DbT7055GappeiJohoEntityGenerator.DEFAULT_合併年月日));
//        }
//
//        @Test
//        public void 戻り値の地域番号は_設定した値と同じ地域番号を返す() {
//            business = sut.set地域番号(DbT7055GappeiJohoEntityGenerator.DEFAULT_地域番号).build();
//            assertThat(business.get地域番号(), is(DbT7055GappeiJohoEntityGenerator.DEFAULT_地域番号));
//        }

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
