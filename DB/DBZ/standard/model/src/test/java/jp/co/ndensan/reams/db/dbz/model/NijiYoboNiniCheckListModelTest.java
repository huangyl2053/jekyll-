/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3102NijiYoboNiniCheckListEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NijiYoboNiniCheckListModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class NijiYoboNiniCheckListModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static NijiYoboNiniCheckListModel sut;

        @BeforeClass
        public static void test() {
            sut = new NijiYoboNiniCheckListModel();
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            sut.set受付年月日(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_受付年月日);
            assertThat(sut.get受付年月日(), is(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の任意質問番号は_設定した値と同じ任意質問番号を返す() {
            sut.set任意質問番号(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_任意質問番号);
            assertThat(sut.get任意質問番号(), is(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_任意質問番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の任意質問事項は_設定した値と同じ任意質問事項を返す() {
            sut.set任意質問事項(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_任意質問事項);
            assertThat(sut.get任意質問事項(), is(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_任意質問事項));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            NijiYoboNiniCheckListModel sut = new NijiYoboNiniCheckListModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            NijiYoboNiniCheckListModel sut = new NijiYoboNiniCheckListModel();
            sut.setEntity(DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            NijiYoboNiniCheckListModel sut = new NijiYoboNiniCheckListModel();
            sut.setEntity(DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            NijiYoboNiniCheckListModel sut = new NijiYoboNiniCheckListModel();
            sut.setEntity(DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
