/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufuhiKashitsukekinEntaiRisokuKeisanModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class KyufuhiKashitsukekinEntaiRisokuKeisanModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyufuhiKashitsukekinEntaiRisokuKeisanModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyufuhiKashitsukekinEntaiRisokuKeisanModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の貸付管理番号は_設定した値と同じ貸付管理番号を返す() {
            sut.set貸付管理番号(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_貸付管理番号);
            assertThat(sut.get貸付管理番号(), is(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_貸付管理番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の貸付金延滞日数は_設定した値と同じ貸付金延滞日数を返す() {
            sut.set貸付金延滞日数(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_貸付金延滞日数);
            assertThat(sut.get貸付金延滞日数(), is(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_貸付金延滞日数));
        }

        @Test
        public void 戻り値の貸付金延滞利息金額は_設定した値と同じ貸付金延滞利息金額を返す() {
            sut.set貸付金延滞利息金額(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_貸付金延滞利息金額);
            assertThat(sut.get貸付金延滞利息金額(), is(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_貸付金延滞利息金額));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyufuhiKashitsukekinEntaiRisokuKeisanModel sut = new KyufuhiKashitsukekinEntaiRisokuKeisanModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyufuhiKashitsukekinEntaiRisokuKeisanModel sut = new KyufuhiKashitsukekinEntaiRisokuKeisanModel();
            sut.setEntity(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.createDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyufuhiKashitsukekinEntaiRisokuKeisanModel sut = new KyufuhiKashitsukekinEntaiRisokuKeisanModel();
            sut.setEntity(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.createDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyufuhiKashitsukekinEntaiRisokuKeisanModel sut = new KyufuhiKashitsukekinEntaiRisokuKeisanModel();
            sut.setEntity(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.createDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
