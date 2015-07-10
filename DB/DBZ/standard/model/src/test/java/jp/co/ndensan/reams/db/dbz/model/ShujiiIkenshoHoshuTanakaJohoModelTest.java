/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShujiiIkenshoHoshuTanakaJohoModel}のテストクラスです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoHoshuTanakaJohoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShujiiIkenshoHoshuTanakaJohoModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShujiiIkenshoHoshuTanakaJohoModel();
        }

        @Test
        public void 戻り値の報酬単価適用開始年月日は_設定した値と同じ報酬単価適用開始年月日を返す() {
            sut.set報酬単価適用開始年月日(DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.DEFAULT_報酬単価適用開始年月日);
            assertThat(sut.get報酬単価適用開始年月日(), is(DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.DEFAULT_報酬単価適用開始年月日));
        }

        @Test
        public void 戻り値の報酬単価適用終了年月日は_設定した値と同じ報酬単価適用終了年月日を返す() {
            sut.set報酬単価適用終了年月日(DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.DEFAULT_報酬単価適用終了年月日);
            assertThat(sut.get報酬単価適用終了年月日(), is(DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.DEFAULT_報酬単価適用終了年月日));
        }

        @Test
        public void 戻り値の医師区分は_設定した値と同じ医師区分を返す() {
            sut.set医師区分(DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.DEFAULT_医師区分);
            assertThat(sut.get医師区分(), is(DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.DEFAULT_医師区分));
        }

        @Test
        public void 戻り値の意見書作成回数は_設定した値と同じ意見書作成回数を返す() {
            sut.set意見書作成回数(DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.DEFAULT_意見書作成回数);
            assertThat(sut.get意見書作成回数(), is(DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.DEFAULT_意見書作成回数));
        }

        @Test
        public void 戻り値の意見書作成料種別は_設定した値と同じ意見書作成料種別を返す() {
            sut.set意見書作成料種別(DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.DEFAULT_意見書作成料種別);
            assertThat(sut.get意見書作成料種別(), is(DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.DEFAULT_意見書作成料種別));
        }

        @Test
        public void 戻り値の主治医意見書作成料単価は_設定した値と同じ主治医意見書作成料単価を返す() {
            sut.set主治医意見書作成料単価(DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.DEFAULT_主治医意見書作成料単価);
            assertThat(sut.get主治医意見書作成料単価(), is(DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.DEFAULT_主治医意見書作成料単価));
        }

        @Test
        public void 戻り値の課税非課税区分は_設定した値と同じ課税非課税区分を返す() {
            sut.set課税非課税区分(DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.DEFAULT_課税非課税区分);
            assertThat(sut.get課税非課税区分(), is(DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.DEFAULT_課税非課税区分));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShujiiIkenshoHoshuTanakaJohoModel sut = new ShujiiIkenshoHoshuTanakaJohoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ShujiiIkenshoHoshuTanakaJohoModel sut = new ShujiiIkenshoHoshuTanakaJohoModel();
        //sut.setEntity(DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.createDbT7108ShujiiIkenshoHoshuTanakaJohoEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ShujiiIkenshoHoshuTanakaJohoModel sut = new ShujiiIkenshoHoshuTanakaJohoModel();
            sut.setEntity(DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.createDbT7108ShujiiIkenshoHoshuTanakaJohoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShujiiIkenshoHoshuTanakaJohoModel sut = new ShujiiIkenshoHoshuTanakaJohoModel();
            sut.setEntity(DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.createDbT7108ShujiiIkenshoHoshuTanakaJohoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
