/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3038ShokanKihonEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanKihonModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class ShokanKihonModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShokanKihonModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShokanKihonModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3038ShokanKihonEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3038ShokanKihonEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3038ShokanKihonEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            sut.set事業者番号(DbT3038ShokanKihonEntityGenerator.DEFAULT_事業者番号);
            assertThat(sut.get事業者番号(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            sut.set様式番号(DbT3038ShokanKihonEntityGenerator.DEFAULT_様式番号);
            assertThat(sut.get様式番号(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3038ShokanKihonEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の旧措置入所者特例コードは_設定した値と同じ旧措置入所者特例コードを返す() {
            sut.set旧措置入所者特例コード(DbT3038ShokanKihonEntityGenerator.DEFAULT_旧措置入所者特例コード);
            assertThat(sut.get旧措置入所者特例コード(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_旧措置入所者特例コード));
        }

        @Test
        public void 戻り値の居宅サービス計画作成区分コードは_設定した値と同じ居宅サービス計画作成区分コードを返す() {
            sut.set居宅サービス計画作成区分コード(DbT3038ShokanKihonEntityGenerator.DEFAULT_居宅サービス計画作成区分コード);
            assertThat(sut.get居宅サービス計画作成区分コード(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_居宅サービス計画作成区分コード));
        }

        @Test
        public void 戻り値の居宅サービス計画事業者番号は_設定した値と同じ居宅サービス計画事業者番号を返す() {
            sut.set居宅サービス計画事業者番号(DbT3038ShokanKihonEntityGenerator.DEFAULT_居宅サービス計画事業者番号);
            assertThat(sut.get居宅サービス計画事業者番号(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_居宅サービス計画事業者番号));
        }

        @Test
        public void 戻り値の開始年月日は_設定した値と同じ開始年月日を返す() {
            sut.set開始年月日(DbT3038ShokanKihonEntityGenerator.DEFAULT_開始年月日);
            assertThat(sut.get開始年月日(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_開始年月日));
        }

        @Test
        public void 戻り値の中止年月日は_設定した値と同じ中止年月日を返す() {
            sut.set中止年月日(DbT3038ShokanKihonEntityGenerator.DEFAULT_中止年月日);
            assertThat(sut.get中止年月日(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_中止年月日));
        }

        @Test
        public void 戻り値の中止理由_入所_院前の状況コードは_設定した値と同じ中止理由_入所_院前の状況コードを返す() {
            sut.set中止理由_入所_院前の状況コード(DbT3038ShokanKihonEntityGenerator.DEFAULT_中止理由_入所_院前の状況コード);
            assertThat(sut.get中止理由_入所_院前の状況コード(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_中止理由_入所_院前の状況コード));
        }

        @Test
        public void 戻り値の入所_院年月日は_設定した値と同じ入所_院年月日を返す() {
            sut.set入所_院年月日(DbT3038ShokanKihonEntityGenerator.DEFAULT_入所_院年月日);
            assertThat(sut.get入所_院年月日(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_入所_院年月日));
        }

        @Test
        public void 戻り値の退所_院年月日は_設定した値と同じ退所_院年月日を返す() {
            sut.set退所_院年月日(DbT3038ShokanKihonEntityGenerator.DEFAULT_退所_院年月日);
            assertThat(sut.get退所_院年月日(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_退所_院年月日));
        }

        @Test
        public void 戻り値の入所_院実日数は_設定した値と同じ入所_院実日数を返す() {
            sut.set入所_院実日数(DbT3038ShokanKihonEntityGenerator.DEFAULT_入所_院実日数);
            assertThat(sut.get入所_院実日数(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_入所_院実日数));
        }

        @Test
        public void 戻り値の外泊日数は_設定した値と同じ外泊日数を返す() {
            sut.set外泊日数(DbT3038ShokanKihonEntityGenerator.DEFAULT_外泊日数);
            assertThat(sut.get外泊日数(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_外泊日数));
        }

        @Test
        public void 戻り値の退所_院後の状態コードは_設定した値と同じ退所_院後の状態コードを返す() {
            sut.set退所_院後の状態コード(DbT3038ShokanKihonEntityGenerator.DEFAULT_退所_院後の状態コード);
            assertThat(sut.get退所_院後の状態コード(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_退所_院後の状態コード));
        }

        @Test
        public void 戻り値の保険給付率は_設定した値と同じ保険給付率を返す() {
            sut.set保険給付率(DbT3038ShokanKihonEntityGenerator.DEFAULT_保険給付率);
            assertThat(sut.get保険給付率(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_保険給付率));
        }

        @Test
        public void 戻り値のサービス単位数は_設定した値と同じサービス単位数を返す() {
            sut.setサービス単位数(DbT3038ShokanKihonEntityGenerator.DEFAULT_サービス単位数);
            assertThat(sut.getサービス単位数(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_サービス単位数));
        }

        @Test
        public void 戻り値の保険請求額は_設定した値と同じ保険請求額を返す() {
            sut.set保険請求額(DbT3038ShokanKihonEntityGenerator.DEFAULT_保険請求額);
            assertThat(sut.get保険請求額(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_保険請求額));
        }

        @Test
        public void 戻り値の利用者負担額は_設定した値と同じ利用者負担額を返す() {
            sut.set利用者負担額(DbT3038ShokanKihonEntityGenerator.DEFAULT_利用者負担額);
            assertThat(sut.get利用者負担額(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_利用者負担額));
        }

        @Test
        public void 戻り値の緊急時施設療養費請求額は_設定した値と同じ緊急時施設療養費請求額を返す() {
            sut.set緊急時施設療養費請求額(DbT3038ShokanKihonEntityGenerator.DEFAULT_緊急時施設療養費請求額);
            assertThat(sut.get緊急時施設療養費請求額(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_緊急時施設療養費請求額));
        }

        @Test
        public void 戻り値の特定診療費請求額は_設定した値と同じ特定診療費請求額を返す() {
            sut.set特定診療費請求額(DbT3038ShokanKihonEntityGenerator.DEFAULT_特定診療費請求額);
            assertThat(sut.get特定診療費請求額(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_特定診療費請求額));
        }

        @Test
        public void 戻り値の特定入所者介護サービス費等請求額は_設定した値と同じ特定入所者介護サービス費等請求額を返す() {
            sut.set特定入所者介護サービス費等請求額(DbT3038ShokanKihonEntityGenerator.DEFAULT_特定入所者介護サービス費等請求額);
            assertThat(sut.get特定入所者介護サービス費等請求額(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_特定入所者介護サービス費等請求額));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShokanKihonModel sut = new ShokanKihonModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ShokanKihonModel sut = new ShokanKihonModel();
        //sut.setEntity(DbT3038ShokanKihonEntityGenerator.createDbT3038ShokanKihonEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ShokanKihonModel sut = new ShokanKihonModel();
            sut.setEntity(DbT3038ShokanKihonEntityGenerator.createDbT3038ShokanKihonEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShokanKihonModel sut = new ShokanKihonModel();
            sut.setEntity(DbT3038ShokanKihonEntityGenerator.createDbT3038ShokanKihonEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
