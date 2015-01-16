/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3064SaishinsaKetteiMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link SaishinsaKetteiMeisaiModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class SaishinsaKetteiMeisaiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static SaishinsaKetteiMeisaiModel sut;

        @BeforeClass
        public static void test() {
            sut = new SaishinsaKetteiMeisaiModel();
        }

        @Test
        public void 戻り値の取扱年月は_設定した値と同じ取扱年月を返す() {
            sut.set取扱年月(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_取扱年月);
            assertThat(sut.get取扱年月(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_取扱年月));
        }

        @Test
        public void 戻り値の保険者区分は_設定した値と同じ保険者区分を返す() {
            sut.set保険者区分(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_保険者区分);
            assertThat(sut.get保険者区分(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_保険者区分));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            sut.set事業所番号(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_事業所番号);
            assertThat(sut.get事業所番号(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の事業所名は_設定した値と同じ事業所名を返す() {
            sut.set事業所名(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_事業所名);
            assertThat(sut.get事業所名(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_事業所名));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の公費受給者番号は_設定した値と同じ公費受給者番号を返す() {
            sut.set公費受給者番号(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_公費受給者番号);
            assertThat(sut.get公費受給者番号(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_公費受給者番号));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            sut.setサービス種類コード(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_サービス種類コード);
            assertThat(sut.getサービス種類コード(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス種類名は_設定した値と同じサービス種類名を返す() {
            sut.setサービス種類名(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_サービス種類名);
            assertThat(sut.getサービス種類名(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_サービス種類名));
        }

        @Test
        public void 戻り値の申立事由コードは_設定した値と同じ申立事由コードを返す() {
            sut.set申立事由コード(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_申立事由コード);
            assertThat(sut.get申立事由コード(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_申立事由コード));
        }

        @Test
        public void 戻り値の申立事由は_設定した値と同じ申立事由を返す() {
            sut.set申立事由(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_申立事由);
            assertThat(sut.get申立事由(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_申立事由));
        }

        @Test
        public void 戻り値の再審査結果コードは_設定した値と同じ再審査結果コードを返す() {
            sut.set再審査結果コード(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_再審査結果コード);
            assertThat(sut.get再審査結果コード(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_再審査結果コード));
        }

        @Test
        public void 戻り値の当初請求単位数は_設定した値と同じ当初請求単位数を返す() {
            sut.set当初請求単位数(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_当初請求単位数);
            assertThat(sut.get当初請求単位数(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_当初請求単位数));
        }

        @Test
        public void 戻り値の原審単位数は_設定した値と同じ原審単位数を返す() {
            sut.set原審単位数(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_原審単位数);
            assertThat(sut.get原審単位数(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_原審単位数));
        }

        @Test
        public void 戻り値の申立単位数は_設定した値と同じ申立単位数を返す() {
            sut.set申立単位数(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_申立単位数);
            assertThat(sut.get申立単位数(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_申立単位数));
        }

        @Test
        public void 戻り値の決定単位数は_設定した値と同じ決定単位数を返す() {
            sut.set決定単位数(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_決定単位数);
            assertThat(sut.get決定単位数(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_決定単位数));
        }

        @Test
        public void 戻り値の調整単位数は_設定した値と同じ調整単位数を返す() {
            sut.set調整単位数(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_調整単位数);
            assertThat(sut.get調整単位数(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_調整単位数));
        }

        @Test
        public void 戻り値の保険者負担額は_設定した値と同じ保険者負担額を返す() {
            sut.set保険者負担額(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_保険者負担額);
            assertThat(sut.get保険者負担額(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_保険者負担額));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            sut.set取込年月(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_取込年月);
            assertThat(sut.get取込年月(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_取込年月));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            SaishinsaKetteiMeisaiModel sut = new SaishinsaKetteiMeisaiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // SaishinsaKetteiMeisaiModel sut = new SaishinsaKetteiMeisaiModel();
        //sut.setEntity(DbT3064SaishinsaKetteiMeisaiEntityGenerator.createDbT3064SaishinsaKetteiMeisaiEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            SaishinsaKetteiMeisaiModel sut = new SaishinsaKetteiMeisaiModel();
            sut.setEntity(DbT3064SaishinsaKetteiMeisaiEntityGenerator.createDbT3064SaishinsaKetteiMeisaiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            SaishinsaKetteiMeisaiModel sut = new SaishinsaKetteiMeisaiModel();
            sut.setEntity(DbT3064SaishinsaKetteiMeisaiEntityGenerator.createDbT3064SaishinsaKetteiMeisaiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
