/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3066ShichosonTokubetuKyufuServiceEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShichosonTokubetuKyufuServiceModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class ShichosonTokubetuKyufuServiceModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShichosonTokubetuKyufuServiceModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShichosonTokubetuKyufuServiceModel();
        }

        @Test
        public void 戻り値の市町村特別給付用サービスコードは_設定した値と同じ市町村特別給付用サービスコードを返す() {
            sut.set市町村特別給付用サービスコード(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービスコード);
            assertThat(sut.get市町村特別給付用サービスコード(), is(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービスコード));
        }

        @Test
        public void 戻り値の市町村特別給付用サービス有効期間開始年月日は_設定した値と同じ市町村特別給付用サービス有効期間開始年月日を返す() {
            sut.set市町村特別給付用サービス有効期間開始年月日(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービス有効期間開始年月日);
            assertThat(sut.get市町村特別給付用サービス有効期間開始年月日(), is(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービス有効期間開始年月日));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の市町村特別給付用サービス名_正式名称は_設定した値と同じ市町村特別給付用サービス名_正式名称を返す() {
            sut.set市町村特別給付用サービス名_正式名称(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービス名_正式名称);
            assertThat(sut.get市町村特別給付用サービス名_正式名称(), is(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービス名_正式名称));
        }

        @Test
        public void 戻り値の市町村特別給付用サービス名_略称は_設定した値と同じ市町村特別給付用サービス名_略称を返す() {
            sut.set市町村特別給付用サービス名_略称(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービス名_略称);
            assertThat(sut.get市町村特別給付用サービス名_略称(), is(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービス名_略称));
        }

        @Test
        public void 戻り値の市町村特別給付用サービス有効期間終了年月日は_設定した値と同じ市町村特別給付用サービス有効期間終了年月日を返す() {
            sut.set市町村特別給付用サービス有効期間終了年月日(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービス有効期間終了年月日);
            assertThat(sut.get市町村特別給付用サービス有効期間終了年月日(), is(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービス有効期間終了年月日));
        }

        @Test
        public void 戻り値の市町村特別給付用サービス区分は_設定した値と同じ市町村特別給付用サービス区分を返す() {
            sut.set市町村特別給付用サービス区分(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービス区分);
            assertThat(sut.get市町村特別給付用サービス区分(), is(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービス区分));
        }

        @Test
        public void 戻り値の市町村特別給付用単位_日数は_設定した値と同じ市町村特別給付用単位_日数を返す() {
            sut.set市町村特別給付用単位_日数(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用単位_日数);
            assertThat(sut.get市町村特別給付用単位_日数(), is(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用単位_日数));
        }

        @Test
        public void 戻り値の市町村特別給付用支給限度基準額は_設定した値と同じ市町村特別給付用支給限度基準額を返す() {
            sut.set市町村特別給付用支給限度基準額(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用支給限度基準額);
            assertThat(sut.get市町村特別給付用支給限度基準額(), is(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用支給限度基準額));
        }

        @Test
        public void 戻り値の市町村特別給付用給付率引下有フラグは_設定した値と同じ市町村特別給付用給付率引下有フラグを返す() {
            sut.set市町村特別給付用給付率引下有フラグ(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用給付率引下有フラグ);
            assertThat(sut.get市町村特別給付用給付率引下有フラグ(), is(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用給付率引下有フラグ));
        }

        @Test
        public void 戻り値の登録年月日は_設定した値と同じ登録年月日を返す() {
            sut.set登録年月日(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_登録年月日);
            assertThat(sut.get登録年月日(), is(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_登録年月日));
        }

        @Test
        public void 戻り値の変更年月日は_設定した値と同じ変更年月日を返す() {
            sut.set変更年月日(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_変更年月日);
            assertThat(sut.get変更年月日(), is(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_変更年月日));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShichosonTokubetuKyufuServiceModel sut = new ShichosonTokubetuKyufuServiceModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ShichosonTokubetuKyufuServiceModel sut = new ShichosonTokubetuKyufuServiceModel();
        //sut.setEntity(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.createDbT3066ShichosonTokubetuKyufuServiceEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ShichosonTokubetuKyufuServiceModel sut = new ShichosonTokubetuKyufuServiceModel();
            sut.setEntity(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.createDbT3066ShichosonTokubetuKyufuServiceEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShichosonTokubetuKyufuServiceModel sut = new ShichosonTokubetuKyufuServiceModel();
            sut.setEntity(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.createDbT3066ShichosonTokubetuKyufuServiceEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
