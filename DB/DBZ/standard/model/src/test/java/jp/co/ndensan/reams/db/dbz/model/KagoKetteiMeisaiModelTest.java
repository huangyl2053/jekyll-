/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3061KagoKetteiMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KagoKetteiMeisaiModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class KagoKetteiMeisaiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KagoKetteiMeisaiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KagoKetteiMeisaiModel();
        }

        @Test
        public void 戻り値の取扱年月は_設定した値と同じ取扱年月を返す() {
            sut.set取扱年月(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_取扱年月);
            assertThat(sut.get取扱年月(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_取扱年月));
        }

        @Test
        public void 戻り値の保険者区分は_設定した値と同じ保険者区分を返す() {
            sut.set保険者区分(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_保険者区分);
            assertThat(sut.get保険者区分(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_保険者区分));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            sut.set事業所番号(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_事業所番号);
            assertThat(sut.get事業所番号(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の事業所名は_設定した値と同じ事業所名を返す() {
            sut.set事業所名(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_事業所名);
            assertThat(sut.get事業所名(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_事業所名));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の公費受給者番号は_設定した値と同じ公費受給者番号を返す() {
            sut.set公費受給者番号(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_公費受給者番号);
            assertThat(sut.get公費受給者番号(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_公費受給者番号));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            sut.setサービス種類コード(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_サービス種類コード);
            assertThat(sut.getサービス種類コード(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス種類名は_設定した値と同じサービス種類名を返す() {
            sut.setサービス種類名(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_サービス種類名);
            assertThat(sut.getサービス種類名(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_サービス種類名));
        }

        @Test
        public void 戻り値の過誤申立事由コードは_設定した値と同じ過誤申立事由コードを返す() {
            sut.set過誤申立事由コード(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_過誤申立事由コード);
            assertThat(sut.get過誤申立事由コード(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_過誤申立事由コード));
        }

        @Test
        public void 戻り値の過誤申立事由は_設定した値と同じ過誤申立事由を返す() {
            sut.set過誤申立事由(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_過誤申立事由);
            assertThat(sut.get過誤申立事由(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_過誤申立事由));
        }

        @Test
        public void 戻り値の単位数_特定入所者介護費等は_設定した値と同じ単位数_特定入所者介護費等を返す() {
            sut.set単位数_特定入所者介護費等(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_単位数_特定入所者介護費等);
            assertThat(sut.get単位数_特定入所者介護費等(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_単位数_特定入所者介護費等));
        }

        @Test
        public void 戻り値の保険者負担額は_設定した値と同じ保険者負担額を返す() {
            sut.set保険者負担額(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_保険者負担額);
            assertThat(sut.get保険者負担額(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_保険者負担額));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KagoKetteiMeisaiModel sut = new KagoKetteiMeisaiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // KagoKetteiMeisaiModel sut = new KagoKetteiMeisaiModel();
        //sut.setEntity(DbT3061KagoKetteiMeisaiEntityGenerator.createDbT3061KagoKetteiMeisaiEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KagoKetteiMeisaiModel sut = new KagoKetteiMeisaiModel();
            sut.setEntity(DbT3061KagoKetteiMeisaiEntityGenerator.createDbT3061KagoKetteiMeisaiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KagoKetteiMeisaiModel sut = new KagoKetteiMeisaiModel();
            sut.setEntity(DbT3061KagoKetteiMeisaiEntityGenerator.createDbT3061KagoKetteiMeisaiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
