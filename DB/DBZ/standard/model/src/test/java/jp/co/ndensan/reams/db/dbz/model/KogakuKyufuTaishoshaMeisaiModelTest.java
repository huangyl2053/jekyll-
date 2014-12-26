/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KogakuKyufuTaishoshaMeisaiModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class KogakuKyufuTaishoshaMeisaiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KogakuKyufuTaishoshaMeisaiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KogakuKyufuTaishoshaMeisaiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            sut.set事業者番号(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_事業者番号);
            assertThat(sut.get事業者番号(), is(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            sut.setサービス種類コード(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス種類コード);
            assertThat(sut.getサービス種類コード(), is(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値のサービス費用合計額は_設定した値と同じサービス費用合計額を返す() {
            sut.setサービス費用合計額(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス費用合計額);
            assertThat(sut.getサービス費用合計額(), is(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス費用合計額));
        }

        @Test
        public void 戻り値の利用者負担額は_設定した値と同じ利用者負担額を返す() {
            sut.set利用者負担額(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_利用者負担額);
            assertThat(sut.get利用者負担額(), is(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_利用者負担額));
        }

        @Test
        public void 戻り値の高額給付根拠は_設定した値と同じ高額給付根拠を返す() {
            sut.set高額給付根拠(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_高額給付根拠);
            assertThat(sut.get高額給付根拠(), is(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_高額給付根拠));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KogakuKyufuTaishoshaMeisaiModel sut = new KogakuKyufuTaishoshaMeisaiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // KogakuKyufuTaishoshaMeisaiModel sut = new KogakuKyufuTaishoshaMeisaiModel();
        //sut.setEntity(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.createDbT3054KogakuKyufuTaishoshaMeisaiEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KogakuKyufuTaishoshaMeisaiModel sut = new KogakuKyufuTaishoshaMeisaiModel();
            sut.setEntity(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.createDbT3054KogakuKyufuTaishoshaMeisaiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KogakuKyufuTaishoshaMeisaiModel sut = new KogakuKyufuTaishoshaMeisaiModel();
            sut.setEntity(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.createDbT3054KogakuKyufuTaishoshaMeisaiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
