/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3046ShokanServicePlan200604EntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanServicePlan200604Model}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class ShokanServicePlan200604ModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShokanServicePlan200604Model sut;

        @BeforeClass
        public static void test() {
            sut = new ShokanServicePlan200604Model();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            sut.set事業者番号(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_事業者番号);
            assertThat(sut.get事業者番号(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            sut.set様式番号(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_様式番号);
            assertThat(sut.get様式番号(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の指定基準該当事業者区分コードは_設定した値と同じ指定基準該当事業者区分コードを返す() {
            sut.set指定基準該当事業者区分コード(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_指定基準該当事業者区分コード);
            assertThat(sut.get指定基準該当事業者区分コード(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_指定基準該当事業者区分コード));
        }

        @Test
        public void 戻り値の居宅サービス計画作成依頼届出年月日は_設定した値と同じ居宅サービス計画作成依頼届出年月日を返す() {
            sut.set居宅サービス計画作成依頼届出年月日(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日);
            assertThat(sut.get居宅サービス計画作成依頼届出年月日(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日));
        }

        @Test
        public void 戻り値のサービスコードは_設定した値と同じサービスコードを返す() {
            sut.setサービスコード(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_サービスコード);
            assertThat(sut.getサービスコード(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_サービスコード));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            sut.set単位数(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_単位数);
            assertThat(sut.get単位数(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_単位数));
        }

        @Test
        public void 戻り値の単位数単価は_設定した値と同じ単位数単価を返す() {
            sut.set単位数単価(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_単位数単価);
            assertThat(sut.get単位数単価(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_単位数単価));
        }

        @Test
        public void 戻り値の請求金額は_設定した値と同じ請求金額を返す() {
            sut.set請求金額(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_請求金額);
            assertThat(sut.get請求金額(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_請求金額));
        }

        @Test
        public void 戻り値の担当介護支援専門員番号は_設定した値と同じ担当介護支援専門員番号を返す() {
            sut.set担当介護支援専門員番号(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_担当介護支援専門員番号);
            assertThat(sut.get担当介護支援専門員番号(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_担当介護支援専門員番号));
        }

        @Test
        public void 戻り値の摘要は_設定した値と同じ摘要を返す() {
            sut.set摘要(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_摘要);
            assertThat(sut.get摘要(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_摘要));
        }

        @Test
        public void 戻り値の審査方法区分コードは_設定した値と同じ審査方法区分コードを返す() {
            sut.set審査方法区分コード(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_審査方法区分コード);
            assertThat(sut.get審査方法区分コード(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_審査方法区分コード));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            sut.set審査年月(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_審査年月);
            assertThat(sut.get審査年月(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の支給区分コードは_設定した値と同じ支給区分コードを返す() {
            sut.set支給区分コード(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_支給区分コード);
            assertThat(sut.get支給区分コード(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_支給区分コード));
        }

        @Test
        public void 戻り値の点数金額は_設定した値と同じ点数金額を返す() {
            sut.set点数金額(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_点数金額);
            assertThat(sut.get点数金額(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_点数金額
            )
            );
        }

        @Test
        public void 戻り値の支給金額は_設定した値と同じ支給金額を返す() {
            sut.set支給金額(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_支給金額);
            assertThat(sut.get支給金額(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_支給金額));
        }

        @Test
        public void 戻り値の増減点は_設定した値と同じ増減点を返す() {
            sut.set増減点(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_増減点);
            assertThat(sut.get増減点(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_増減点));
        }

        @Test
        public void 戻り値の差額金額は_設定した値と同じ差額金額を返す() {
            sut.set差額金額(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_差額金額);
            assertThat(sut.get差額金額(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_差額金額));
        }

        @Test
        public void 戻り値の増減理由等は_設定した値と同じ増減理由等を返す() {
            sut.set増減理由等(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_増減理由等);
            assertThat(sut.get増減理由等(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_増減理由等));
        }

        @Test
        public void 戻り値の不支給理由等は_設定した値と同じ不支給理由等を返す() {
            sut.set不支給理由等(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_不支給理由等);
            assertThat(sut.get不支給理由等(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_不支給理由等));
        }

        @Test
        public void 戻り値の購入_改修履歴等は_設定した値と同じ購入_改修履歴等を返す() {
            sut.set購入_改修履歴等(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_購入_改修履歴等);
            assertThat(sut.get購入_改修履歴等(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_購入_改修履歴等));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShokanServicePlan200604Model sut = new ShokanServicePlan200604Model();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        // @Test
        // public void 状態Modifinedの取得確認() {
        // ShokanServicePlan200604Model sut = new ShokanServicePlan200604Model();
        //sut.setEntity(DbT3046ShokanServicePlan200604EntityGenerator.createDbT3046ShokanServicePlan200604Entity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ShokanServicePlan200604Model sut = new ShokanServicePlan200604Model();
            sut.setEntity(DbT3046ShokanServicePlan200604EntityGenerator.createDbT3046ShokanServicePlan200604Entity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShokanServicePlan200604Model sut = new ShokanServicePlan200604Model();
            sut.setEntity(DbT3046ShokanServicePlan200604EntityGenerator.createDbT3046ShokanServicePlan200604Entity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
