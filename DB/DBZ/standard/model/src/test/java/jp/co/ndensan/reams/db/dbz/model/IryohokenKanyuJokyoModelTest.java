/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1008IryohokenKanyuJokyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IryohokenKanyuJokyoModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class IryohokenKanyuJokyoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static IryohokenKanyuJokyoModel sut;

        @BeforeClass
        public static void test() {
            sut = new IryohokenKanyuJokyoModel();
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の医療保険種別コードは_設定した値と同じ医療保険種別コードを返す() {
            sut.set医療保険種別コード(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険種別コード);
            assertThat(sut.get医療保険種別コード(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険種別コード));
        }

        @Test
        public void 戻り値の医療保険者番号は_設定した値と同じ医療保険者番号を返す() {
            sut.set医療保険者番号(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険者番号);
            assertThat(sut.get医療保険者番号(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険者番号));
        }

        @Test
        public void 戻り値の医療保険者名称は_設定した値と同じ医療保険者名称を返す() {
            sut.set医療保険者名称(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険者名称);
            assertThat(sut.get医療保険者名称(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険者名称));
        }

        @Test
        public void 戻り値の医療保険記号番号は_設定した値と同じ医療保険記号番号を返す() {
            sut.set医療保険記号番号(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険記号番号);
            assertThat(sut.get医療保険記号番号(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険記号番号));
        }

        @Test
        public void 戻り値の医療保険加入年月日は_設定した値と同じ医療保険加入年月日を返す() {
            sut.set医療保険加入年月日(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険加入年月日);
            assertThat(sut.get医療保険加入年月日(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険加入年月日));
        }

        @Test
        public void 戻り値の医療保険脱退年月日は_設定した値と同じ医療保険脱退年月日を返す() {
            sut.set医療保険脱退年月日(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険脱退年月日);
            assertThat(sut.get医療保険脱退年月日(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険脱退年月日));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            IryohokenKanyuJokyoModel sut = new IryohokenKanyuJokyoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            IryohokenKanyuJokyoModel sut = new IryohokenKanyuJokyoModel();
            sut.setEntity(DbT1008IryohokenKanyuJokyoEntityGenerator.createDbT1008IryohokenKanyuJokyoEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            IryohokenKanyuJokyoModel sut = new IryohokenKanyuJokyoModel();
            sut.setEntity(DbT1008IryohokenKanyuJokyoEntityGenerator.createDbT1008IryohokenKanyuJokyoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            IryohokenKanyuJokyoModel sut = new IryohokenKanyuJokyoModel();
            sut.setEntity(DbT1008IryohokenKanyuJokyoEntityGenerator.createDbT1008IryohokenKanyuJokyoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
