/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3060KagoKetteiShukeiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KagoKetteiShukeiModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class KagoKetteiShukeiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KagoKetteiShukeiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KagoKetteiShukeiModel();
        }

        @Test
        public void 戻り値の取扱年月は_設定した値と同じ取扱年月を返す() {
            sut.set取扱年月(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_取扱年月);
            assertThat(sut.get取扱年月(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_取扱年月));
        }

        @Test
        public void 戻り値の保険者区分は_設定した値と同じ保険者区分を返す() {
            sut.set保険者区分(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_保険者区分);
            assertThat(sut.get保険者区分(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_保険者区分));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の介護給付費件数は_設定した値と同じ介護給付費件数を返す() {
            sut.set介護給付費件数(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_介護給付費件数);
            assertThat(sut.get介護給付費件数(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_介護給付費件数));
        }

        @Test
        public void 戻り値の介護給付費単位数は_設定した値と同じ介護給付費単位数を返す() {
            sut.set介護給付費単位数(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_介護給付費単位数);
            assertThat(sut.get介護給付費単位数(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_介護給付費単位数));
        }

        @Test
        public void 戻り値の介護給付費保険者負担額は_設定した値と同じ介護給付費保険者負担額を返す() {
            sut.set介護給付費保険者負担額(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_介護給付費保険者負担額);
            assertThat(sut.get介護給付費保険者負担額(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_介護給付費保険者負担額));
        }

        @Test
        public void 戻り値の高額介護サービス費件数は_設定した値と同じ高額介護サービス費件数を返す() {
            sut.set高額介護サービス費件数(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費件数);
            assertThat(sut.get高額介護サービス費件数(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費件数));
        }

        @Test
        public void 戻り値の高額介護サービス費単位数は_設定した値と同じ高額介護サービス費単位数を返す() {
            sut.set高額介護サービス費単位数(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費単位数);
            assertThat(sut.get高額介護サービス費単位数(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費単位数));
        }

        @Test
        public void 戻り値の高額介護サービス費保険者負担額は_設定した値と同じ高額介護サービス費保険者負担額を返す() {
            sut.set高額介護サービス費保険者負担額(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費保険者負担額);
            assertThat(sut.get高額介護サービス費保険者負担額(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費保険者負担額));
        }

        @Test
        public void 戻り値の特定入所者介護サービス費等件数は_設定した値と同じ特定入所者介護サービス費等件数を返す() {
            sut.set特定入所者介護サービス費等件数(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_特定入所者介護サービス費等件数);
            assertThat(sut.get特定入所者介護サービス費等件数(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_特定入所者介護サービス費等件数));
        }

        @Test
        public void 戻り値の特定入所者介護サービス費等費用額は_設定した値と同じ特定入所者介護サービス費等費用額を返す() {
            sut.set特定入所者介護サービス費等費用額(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_特定入所者介護サービス費等費用額);
            assertThat(sut.get特定入所者介護サービス費等費用額(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_特定入所者介護サービス費等費用額));
        }

        @Test
        public void 戻り値の特定入所者介護サービス費等保険者負担額は_設定した値と同じ特定入所者介護サービス費等保険者負担額を返す() {
            sut.set特定入所者介護サービス費等保険者負担額(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_特定入所者介護サービス費等保険者負担額);
            assertThat(sut.get特定入所者介護サービス費等保険者負担額(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_特定入所者介護サービス費等保険者負担額));
        }

        @Test
        public void 戻り値の公費負担者番号は_設定した値と同じ公費負担者番号を返す() {
            sut.set公費負担者番号(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_公費負担者番号);
            assertThat(sut.get公費負担者番号(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_公費負担者番号));
        }

        @Test
        public void 戻り値の作成年月日は_設定した値と同じ作成年月日を返す() {
            sut.set作成年月日(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_作成年月日);
            assertThat(sut.get作成年月日(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_作成年月日));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            sut.set取込年月(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_取込年月);
            assertThat(sut.get取込年月(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_取込年月));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KagoKetteiShukeiModel sut = new KagoKetteiShukeiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // KagoKetteiShukeiModel sut = new KagoKetteiShukeiModel();
        //sut.setEntity(DbT3060KagoKetteiShukeiEntityGenerator.createDbT3060KagoKetteiShukeiEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KagoKetteiShukeiModel sut = new KagoKetteiShukeiModel();
            sut.setEntity(DbT3060KagoKetteiShukeiEntityGenerator.createDbT3060KagoKetteiShukeiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KagoKetteiShukeiModel sut = new KagoKetteiShukeiModel();
            sut.setEntity(DbT3060KagoKetteiShukeiEntityGenerator.createDbT3060KagoKetteiShukeiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
