/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3062SaishinsaMoshitateEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link SaishinsaMoshitateModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class SaishinsaMoshitateModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static SaishinsaMoshitateModel sut;

        @BeforeClass
        public static void test() {
            sut = new SaishinsaMoshitateModel();
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            sut.set事業所番号(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_事業所番号);
            assertThat(sut.get事業所番号(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            sut.setサービス種類コード(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス種類コード);
            assertThat(sut.getサービス種類コード(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス項目コードは_設定した値と同じサービス項目コードを返す() {
            sut.setサービス項目コード(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス項目コード);
            assertThat(sut.getサービス項目コード(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス項目コード));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の申立年月日は_設定した値と同じ申立年月日を返す() {
            sut.set申立年月日(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_申立年月日);
            assertThat(sut.get申立年月日(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_申立年月日));
        }

        @Test
        public void 戻り値の申立者区分コードは_設定した値と同じ申立者区分コードを返す() {
            sut.set申立者区分コード(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_申立者区分コード);
            assertThat(sut.get申立者区分コード(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_申立者区分コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の申立単位数は_設定した値と同じ申立単位数を返す() {
            sut.set申立単位数(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_申立単位数);
            assertThat(sut.get申立単位数(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_申立単位数));
        }

        @Test
        public void 戻り値の申立事由コードは_設定した値と同じ申立事由コードを返す() {
            sut.set申立事由コード(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_申立事由コード);
            assertThat(sut.get申立事由コード(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_申立事由コード));
        }

        @Test
        public void 戻り値の国保連送付年月は_設定した値と同じ国保連送付年月を返す() {
            sut.set国保連送付年月(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_国保連送付年月);
            assertThat(sut.get国保連送付年月(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_国保連送付年月));
        }

        @Test
        public void 戻り値の国保連再送付有フラグは_設定した値と同じ国保連再送付有フラグを返す() {
            sut.set国保連再送付有フラグ(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_国保連再送付有フラグ);
            assertThat(sut.get国保連再送付有フラグ(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_国保連再送付有フラグ));
        }

        @Test
        public void 戻り値の備考は_設定した値と同じ備考を返す() {
            sut.set備考(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_備考);
            assertThat(sut.get備考(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_備考));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            SaishinsaMoshitateModel sut = new SaishinsaMoshitateModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // SaishinsaMoshitateModel sut = new SaishinsaMoshitateModel();
        //sut.setEntity(DbT3062SaishinsaMoshitateEntityGenerator.createDbT3062SaishinsaMoshitateEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            SaishinsaMoshitateModel sut = new SaishinsaMoshitateModel();
            sut.setEntity(DbT3062SaishinsaMoshitateEntityGenerator.createDbT3062SaishinsaMoshitateEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            SaishinsaMoshitateModel sut = new SaishinsaMoshitateModel();
            sut.setEntity(DbT3062SaishinsaMoshitateEntityGenerator.createDbT3062SaishinsaMoshitateEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
