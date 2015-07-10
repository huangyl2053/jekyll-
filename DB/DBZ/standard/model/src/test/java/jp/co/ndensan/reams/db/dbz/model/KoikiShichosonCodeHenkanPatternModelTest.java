/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KoikiShichosonCodeHenkanPatternModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class KoikiShichosonCodeHenkanPatternModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KoikiShichosonCodeHenkanPatternModel sut;

        @BeforeClass
        public static void test() {
            sut = new KoikiShichosonCodeHenkanPatternModel();
        }

        @Test
        public void 戻り値の広域内市町村番号は_設定した値と同じ広域内市町村番号を返す() {
            sut.set広域内市町村番号(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域内市町村番号);
            assertThat(sut.get広域内市町村番号(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域内市町村番号));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値のコード区分は_設定した値と同じコード区分を返す() {
            sut.setコード区分(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_コード区分);
            assertThat(sut.getコード区分(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_コード区分));
        }

        @Test
        public void 戻り値のコード変換テーブル使用区分は_設定した値と同じコード変換テーブル使用区分を返す() {
            sut.setコード変換テーブル使用区分(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_コード変換テーブル使用区分);
            assertThat(sut.getコード変換テーブル使用区分(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_コード変換テーブル使用区分));
        }

        @Test
        public void 戻り値の自動採番区分は_設定した値と同じ自動採番区分を返す() {
            sut.set自動採番区分(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_自動採番区分);
            assertThat(sut.get自動採番区分(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_自動採番区分));
        }

        @Test
        public void 戻り値の市町村用コード桁数は_設定した値と同じ市町村用コード桁数を返す() {
            sut.set市町村用コード桁数(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村用コード桁数);
            assertThat(sut.get市町村用コード桁数(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村用コード桁数));
        }

        @Test
        public void 戻り値の市町村用コード開始位置は_設定した値と同じ市町村用コード開始位置を返す() {
            sut.set市町村用コード開始位置(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村用コード開始位置);
            assertThat(sut.get市町村用コード開始位置(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村用コード開始位置));
        }

        @Test
        public void 戻り値の市町村用コード使用桁数は_設定した値と同じ市町村用コード使用桁数を返す() {
            sut.set市町村用コード使用桁数(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村用コード使用桁数);
            assertThat(sut.get市町村用コード使用桁数(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村用コード使用桁数));
        }

        @Test
        public void 戻り値の市町村用チェックディジット有無区分は_設定した値と同じ市町村用チェックディジット有無区分を返す() {
            sut.set市町村用チェックディジット有無区分(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村用チェックディジット有無区分);
            assertThat(sut.get市町村用チェックディジット有無区分(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村用チェックディジット有無区分));
        }

        @Test
        public void 戻り値の広域用コード桁数は_設定した値と同じ広域用コード桁数を返す() {
            sut.set広域用コード桁数(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域用コード桁数);
            assertThat(sut.get広域用コード桁数(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域用コード桁数));
        }

        @Test
        public void 戻り値の広域用コード開始位置は_設定した値と同じ広域用コード開始位置を返す() {
            sut.set広域用コード開始位置(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域用コード開始位置);
            assertThat(sut.get広域用コード開始位置(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域用コード開始位置));
        }

        @Test
        public void 戻り値の広域用コード使用桁数は_設定した値と同じ広域用コード使用桁数を返す() {
            sut.set広域用コード使用桁数(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域用コード使用桁数);
            assertThat(sut.get広域用コード使用桁数(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域用コード使用桁数));
        }

        @Test
        public void 戻り値の広域用チェックディジット有無区分は_設定した値と同じ広域用チェックディジット有無区分を返す() {
            sut.set広域用チェックディジット有無区分(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域用チェックディジット有無区分);
            assertThat(sut.get広域用チェックディジット有無区分(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域用チェックディジット有無区分));
        }

        @Test
        public void 戻り値の広域内市町村番号付加区分は_設定した値と同じ広域内市町村番号付加区分を返す() {
            sut.set広域内市町村番号付加区分(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域内市町村番号付加区分);
            assertThat(sut.get広域内市町村番号付加区分(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域内市町村番号付加区分));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KoikiShichosonCodeHenkanPatternModel sut = new KoikiShichosonCodeHenkanPatternModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KoikiShichosonCodeHenkanPatternModel sut = new KoikiShichosonCodeHenkanPatternModel();
            sut.setEntity(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.createDbT7024KoikiShichosonCodeHenkanPatternEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KoikiShichosonCodeHenkanPatternModel sut = new KoikiShichosonCodeHenkanPatternModel();
            sut.setEntity(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.createDbT7024KoikiShichosonCodeHenkanPatternEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KoikiShichosonCodeHenkanPatternModel sut = new KoikiShichosonCodeHenkanPatternModel();
            sut.setEntity(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.createDbT7024KoikiShichosonCodeHenkanPatternEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
