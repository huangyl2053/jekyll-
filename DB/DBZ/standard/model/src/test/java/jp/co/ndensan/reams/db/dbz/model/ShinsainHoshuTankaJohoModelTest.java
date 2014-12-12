/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7107ShinsainHoshuTankaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShinsainHoshuTankaJohoModel}のテストクラスです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class ShinsainHoshuTankaJohoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShinsainHoshuTankaJohoModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShinsainHoshuTankaJohoModel();
        }

        @Test
        public void 戻り値の報酬単価適用開始年月日は_設定した値と同じ報酬単価適用開始年月日を返す() {
            sut.set報酬単価適用開始年月日(DbT7107ShinsainHoshuTankaJohoEntityGenerator.DEFAULT_報酬単価適用開始年月日);
            assertThat(sut.get報酬単価適用開始年月日(), is(DbT7107ShinsainHoshuTankaJohoEntityGenerator.DEFAULT_報酬単価適用開始年月日));
        }

        @Test
        public void 戻り値の報酬単価適用終了年月日は_設定した値と同じ報酬単価適用終了年月日を返す() {
            sut.set報酬単価適用終了年月日(DbT7107ShinsainHoshuTankaJohoEntityGenerator.DEFAULT_報酬単価適用終了年月日);
            assertThat(sut.get報酬単価適用終了年月日(), is(DbT7107ShinsainHoshuTankaJohoEntityGenerator.DEFAULT_報酬単価適用終了年月日));
        }

        @Test
        public void 戻り値の合議体長区分は_設定した値と同じ合議体長区分を返す() {
            sut.set合議体長区分(DbT7107ShinsainHoshuTankaJohoEntityGenerator.DEFAULT_合議体長区分);
            assertThat(sut.get合議体長区分(), is(DbT7107ShinsainHoshuTankaJohoEntityGenerator.DEFAULT_合議体長区分));
        }

        @Test
        public void 戻り値の介護認定審査報酬単価は_設定した値と同じ介護認定審査報酬単価を返す() {
            sut.set介護認定審査報酬単価(DbT7107ShinsainHoshuTankaJohoEntityGenerator.DEFAULT_介護認定審査報酬単価);
            assertThat(sut.get介護認定審査報酬単価(), is(DbT7107ShinsainHoshuTankaJohoEntityGenerator.DEFAULT_介護認定審査報酬単価));
        }

        @Test
        public void 戻り値の課税非課税区分は_設定した値と同じ課税非課税区分を返す() {
            sut.set課税非課税区分(DbT7107ShinsainHoshuTankaJohoEntityGenerator.DEFAULT_課税非課税区分);
            assertThat(sut.get課税非課税区分(), is(DbT7107ShinsainHoshuTankaJohoEntityGenerator.DEFAULT_課税非課税区分));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShinsainHoshuTankaJohoModel sut = new ShinsainHoshuTankaJohoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ShinsainHoshuTankaJohoModel sut = new ShinsainHoshuTankaJohoModel();
        //sut.setEntity(DbT7107ShinsainHoshuTankaJohoEntityGenerator.createDbT7107ShinsainHoshuTankaJohoEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ShinsainHoshuTankaJohoModel sut = new ShinsainHoshuTankaJohoModel();
            sut.setEntity(DbT7107ShinsainHoshuTankaJohoEntityGenerator.createDbT7107ShinsainHoshuTankaJohoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShinsainHoshuTankaJohoModel sut = new ShinsainHoshuTankaJohoModel();
            sut.setEntity(DbT7107ShinsainHoshuTankaJohoEntityGenerator.createDbT7107ShinsainHoshuTankaJohoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
