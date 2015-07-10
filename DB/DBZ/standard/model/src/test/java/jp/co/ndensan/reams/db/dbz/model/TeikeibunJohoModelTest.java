/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7103TeikeibunJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link TeikeibunJohoModel}のテストクラスです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class TeikeibunJohoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static TeikeibunJohoModel sut;

        @BeforeClass
        public static void test() {
            sut = new TeikeibunJohoModel();
        }

        @Test
        public void 戻り値の定型区分は_設定した値と同じ定型区分を返す() {
            sut.set定型区分(DbT7103TeikeibunJohoEntityGenerator.DEFAULT_定型区分);
            assertThat(sut.get定型区分(), is(DbT7103TeikeibunJohoEntityGenerator.DEFAULT_定型区分));
        }

        @Test
        public void 戻り値の種別は_設定した値と同じ種別を返す() {
            sut.set種別(DbT7103TeikeibunJohoEntityGenerator.DEFAULT_種別);
            assertThat(sut.get種別(), is(DbT7103TeikeibunJohoEntityGenerator.DEFAULT_種別));
        }

        @Test
        public void 戻り値の定型文コードは_設定した値と同じ定型文コードを返す() {
            sut.set定型文コード(DbT7103TeikeibunJohoEntityGenerator.DEFAULT_定型文コード);
            assertThat(sut.get定型文コード(), is(DbT7103TeikeibunJohoEntityGenerator.DEFAULT_定型文コード));
        }

        @Test
        public void 戻り値の定型文内容は_設定した値と同じ定型文内容を返す() {
            sut.set定型文内容(DbT7103TeikeibunJohoEntityGenerator.DEFAULT_定型文内容);
            assertThat(sut.get定型文内容(), is(DbT7103TeikeibunJohoEntityGenerator.DEFAULT_定型文内容));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            TeikeibunJohoModel sut = new TeikeibunJohoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // TeikeibunJohoModel sut = new TeikeibunJohoModel();
        //sut.setEntity(DbT7103TeikeibunJohoEntityGenerator.createDbT7103TeikeibunJohoEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            TeikeibunJohoModel sut = new TeikeibunJohoModel();
            sut.setEntity(DbT7103TeikeibunJohoEntityGenerator.createDbT7103TeikeibunJohoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            TeikeibunJohoModel sut = new TeikeibunJohoModel();
            sut.setEntity(DbT7103TeikeibunJohoEntityGenerator.createDbT7103TeikeibunJohoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
