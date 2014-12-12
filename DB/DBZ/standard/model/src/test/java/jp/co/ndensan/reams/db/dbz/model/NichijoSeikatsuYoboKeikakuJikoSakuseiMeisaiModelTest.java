/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiModel sut;

        @BeforeClass
        public static void test() {
            sut = new NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の対象年月は_設定した値と同じ対象年月を返す() {
            sut.set対象年月(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_対象年月);
            assertThat(sut.get対象年月(), is(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_対象年月));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の居宅サービス区分は_設定した値と同じ居宅サービス区分を返す() {
            sut.set居宅サービス区分(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_居宅サービス区分);
            assertThat(sut.get居宅サービス区分(), is(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_居宅サービス区分));
        }

        @Test
        public void 戻り値のサービス提供事業者番号は_設定した値と同じサービス提供事業者番号を返す() {
            sut.setサービス提供事業者番号(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号);
            assertThat(sut.getサービス提供事業者番号(), is(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            sut.setサービス種類コード(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス種類コード);
            assertThat(sut.getサービス種類コード(), is(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス項目コードは_設定した値と同じサービス項目コードを返す() {
            sut.setサービス項目コード(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス項目コード);
            assertThat(sut.getサービス項目コード(), is(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス項目コード));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            sut.set単位数(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_単位数);
            assertThat(sut.get単位数(), is(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_単位数));
        }

        @Test
        public void 戻り値の回数_日数は_設定した値と同じ回数_日数を返す() {
            sut.set回数_日数(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_回数_日数);
            assertThat(sut.get回数_日数(), is(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_回数_日数));
        }

        @Test
        public void 戻り値の種類限度内単位数_日数は_設定した値と同じ種類限度内単位数_日数を返す() {
            sut.set種類限度内単位数_日数(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_種類限度内単位数_日数);
            assertThat(sut.get種類限度内単位数_日数(), is(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_種類限度内単位数_日数));
        }

        @Test
        public void 戻り値の種類限度超過単位数_日数は_設定した値と同じ種類限度超過単位数_日数を返す() {
            sut.set種類限度超過単位数_日数(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_種類限度超過単位数_日数);
            assertThat(sut.get種類限度超過単位数_日数(), is(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_種類限度超過単位数_日数));
        }

        @Test
        public void 戻り値の区分限度内単位数_日数は_設定した値と同じ区分限度内単位数_日数を返す() {
            sut.set区分限度内単位数_日数(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_区分限度内単位数_日数);
            assertThat(sut.get区分限度内単位数_日数(), is(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_区分限度内単位数_日数));
        }

        @Test
        public void 戻り値の区分限度超過単位数_日数は_設定した値と同じ区分限度超過単位数_日数を返す() {
            sut.set区分限度超過単位数_日数(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_区分限度超過単位数_日数);
            assertThat(sut.get区分限度超過単位数_日数(), is(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_区分限度超過単位数_日数));
        }

        @Test
        public void 戻り値の単位数単価は_設定した値と同じ単位数単価を返す() {
            sut.set単位数単価(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_単位数単価);
            assertThat(sut.get単位数単価(), is(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_単位数単価));
        }

        @Test
        public void 戻り値の給付率は_設定した値と同じ給付率を返す() {
            sut.set給付率(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_給付率);
            assertThat(sut.get給付率(), is(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_給付率));
        }

        @Test
        public void 戻り値の割引後適用率は_設定した値と同じ割引後適用率を返す() {
            sut.set割引後適用率(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_割引後適用率);
            assertThat(sut.get割引後適用率(), is(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_割引後適用率));
        }

        @Test
        public void 戻り値の割引後適用単位数は_設定した値と同じ割引後適用単位数を返す() {
            sut.set割引後適用単位数(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_割引後適用単位数);
            assertThat(sut.get割引後適用単位数(), is(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_割引後適用単位数));
        }

        @Test
        public void 戻り値の定額利用者負担単価金額は_設定した値と同じ定額利用者負担単価金額を返す() {
            sut.set定額利用者負担単価金額(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_定額利用者負担単価金額);
            assertThat(sut.get定額利用者負担単価金額(), is(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_定額利用者負担単価金額));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiModel sut = new NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiModel sut = new NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiModel();
            sut.setEntity(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.createDbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiModel sut = new NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiModel();
            sut.setEntity(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.createDbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiModel sut = new NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiModel();
            sut.setEntity(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.createDbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
