/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7052KoseiShichosonShishoMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KoseiShichosonShishoMasterModel}のテストクラスです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class KoseiShichosonShishoMasterModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KoseiShichosonShishoMasterModel sut;

        @BeforeClass
        public static void test() {
            sut = new KoseiShichosonShishoMasterModel();
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の支所コードは_設定した値と同じ支所コードを返す() {
            sut.set支所コード(DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード);
            assertThat(sut.get支所コード(), is(DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード));
        }

        @Test
        public void 戻り値の支所名は_設定した値と同じ支所名を返す() {
            sut.set支所名(DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所名);
            assertThat(sut.get支所名(), is(DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所名));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KoseiShichosonShishoMasterModel sut = new KoseiShichosonShishoMasterModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // KoseiShichosonShishoMasterModel sut = new KoseiShichosonShishoMasterModel();
        //sut.setEntity(DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KoseiShichosonShishoMasterModel sut = new KoseiShichosonShishoMasterModel();
            sut.setEntity(DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KoseiShichosonShishoMasterModel sut = new KoseiShichosonShishoMasterModel();
            sut.setEntity(DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
