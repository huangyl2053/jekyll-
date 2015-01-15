/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7022ShoriDateKanriEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShoriDateModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class ShoriDateModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShoriDateModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShoriDateModel();
        }

        @Test
        public void 戻り値のサブ業務コードは_設定した値と同じサブ業務コードを返す() {
            sut.setサブ業務コード(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_サブ業務コード);
            assertThat(sut.getサブ業務コード(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_サブ業務コード));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の処理名は_設定した値と同じ処理名を返す() {
            sut.set処理名(ShoriName.valueOf(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_処理名.toString()));
            assertThat(sut.get処理名().toRString(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_処理名));
        }

        @Test
        public void 戻り値の処理枝番は_設定した値と同じ処理枝番を返す() {
            sut.set処理枝番(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_処理枝番);
            assertThat(sut.get処理枝番(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_処理枝番));
        }

        @Test
        public void 戻り値の年度は_設定した値と同じ年度を返す() {
            sut.set年度(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_年度);
            assertThat(sut.get年度(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_年度));
        }

        @Test
        public void 戻り値の年度内連番は_設定した値と同じ年度内連番を返す() {
            sut.set年度内連番(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_年度内連番);
            assertThat(sut.get年度内連番(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_年度内連番));
        }

        @Test
        public void 戻り値の基準年月日は_設定した値と同じ基準年月日を返す() {
            sut.set基準年月日(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_基準年月日);
            assertThat(sut.get基準年月日(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_基準年月日));
        }

        @Test
        public void 戻り値の対象開始年月日は_設定した値と同じ対象開始年月日を返す() {
            sut.set対象開始年月日(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_対象開始年月日);
            assertThat(sut.get対象開始年月日(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_対象開始年月日));
        }

        @Test
        public void 戻り値の対象終了年月日は_設定した値と同じ対象終了年月日を返す() {
            sut.set対象終了年月日(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_対象終了年月日);
            assertThat(sut.get対象終了年月日(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_対象終了年月日));
        }

        @Test
        public void 戻り値の対象開始日時は_設定した値と同じ対象開始日時を返す() {
            sut.set対象開始日時(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_対象開始日時);
            assertThat(sut.get対象開始日時(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_対象開始日時));
        }

        @Test
        public void 戻り値の対象終了日時は_設定した値と同じ対象終了日時を返す() {
            sut.set対象終了日時(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_対象終了日時);
            assertThat(sut.get対象終了日時(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_対象終了日時));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShoriDateModel sut = new ShoriDateModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            ShoriDateModel sut = new ShoriDateModel();
            sut.setEntity(DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            ShoriDateModel sut = new ShoriDateModel();
            sut.setEntity(DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShoriDateModel sut = new ShoriDateModel();
            sut.setEntity(DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
