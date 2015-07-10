/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3037ShokanJuryoininMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanJuryoininMeisaiModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class ShokanJuryoininMeisaiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShokanJuryoininMeisaiModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShokanJuryoininMeisaiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の契約番号は_設定した値と同じ契約番号を返す() {
            sut.set契約番号(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_契約番号);
            assertThat(sut.get契約番号(), is(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_契約番号));
        }

        @Test
        public void 戻り値の支払金額は_設定した値と同じ支払金額を返す() {
            sut.set支払金額(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_支払金額);
            assertThat(sut.get支払金額(), is(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_支払金額));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShokanJuryoininMeisaiModel sut = new ShokanJuryoininMeisaiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ShokanJuryoininMeisaiModel sut = new ShokanJuryoininMeisaiModel();
        //sut.setEntity(DbT3037ShokanJuryoininMeisaiEntityGenerator.createDbT3037ShokanJuryoininMeisaiEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ShokanJuryoininMeisaiModel sut = new ShokanJuryoininMeisaiModel();
            sut.setEntity(DbT3037ShokanJuryoininMeisaiEntityGenerator.createDbT3037ShokanJuryoininMeisaiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShokanJuryoininMeisaiModel sut = new ShokanJuryoininMeisaiModel();
            sut.setEntity(DbT3037ShokanJuryoininMeisaiEntityGenerator.createDbT3037ShokanJuryoininMeisaiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
