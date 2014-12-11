/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7116JukyushaGendoGakuKanriEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JukyushaGendoGakuKanriModel}のテストクラスです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class JukyushaGendoGakuKanriModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static JukyushaGendoGakuKanriModel sut;

        @BeforeClass
        public static void test() {
            sut = new JukyushaGendoGakuKanriModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の識別区分は_設定した値と同じ識別区分を返す() {
            sut.set識別区分(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_識別区分);
            assertThat(sut.get識別区分(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_識別区分));
        }

        @Test
        public void 戻り値の有効開始年月は_設定した値と同じ有効開始年月を返す() {
            sut.set有効開始年月(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_有効開始年月);
            assertThat(sut.get有効開始年月(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_有効開始年月));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の有効終了年月は_設定した値と同じ有効終了年月を返す() {
            sut.set有効終了年月(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_有効終了年月);
            assertThat(sut.get有効終了年月(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_有効終了年月));
        }

        @Test
        public void 戻り値の要介護状態区分は_設定した値と同じ要介護状態区分を返す() {
            sut.set要介護状態区分(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_要介護状態区分);
            assertThat(sut.get要介護状態区分(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_要介護状態区分));
        }

        @Test
        public void 戻り値の拡大倍数は_設定した値と同じ拡大倍数を返す() {
            sut.set拡大倍数(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_拡大倍数);
            assertThat(sut.get拡大倍数(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_拡大倍数));
        }

        @Test
        public void 戻り値の切り分け単位数は_設定した値と同じ切り分け単位数を返す() {
            sut.set切り分け単位数(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_切り分け単位数);
            assertThat(sut.get切り分け単位数(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_切り分け単位数));
        }

        @Test
        public void 戻り値の登録年月日は_設定した値と同じ登録年月日を返す() {
            sut.set登録年月日(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_登録年月日);
            assertThat(sut.get登録年月日(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_登録年月日));
        }

        @Test
        public void 戻り値の変更年月日は_設定した値と同じ変更年月日を返す() {
            sut.set変更年月日(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_変更年月日);
            assertThat(sut.get変更年月日(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_変更年月日));
        }

        @Test
        public void 戻り値の限度額管理期間数は_設定した値と同じ限度額管理期間数を返す() {
            sut.set限度額管理期間数(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_限度額管理期間数);
            assertThat(sut.get限度額管理期間数(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_限度額管理期間数));
        }

        @Test
        public void 戻り値の新体系管理区分は_設定した値と同じ新体系管理区分を返す() {
            sut.set新体系管理区分(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_新体系管理区分);
            assertThat(sut.get新体系管理区分(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_新体系管理区分));
        }

        @Test
        public void 戻り値の新体系拡大適用有無は_設定した値と同じ新体系拡大適用有無を返す() {
            sut.set新体系拡大適用有無(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_新体系拡大適用有無);
            assertThat(sut.get新体系拡大適用有無(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_新体系拡大適用有無));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            JukyushaGendoGakuKanriModel sut = new JukyushaGendoGakuKanriModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // JukyushaGendoGakuKanriModel sut = new JukyushaGendoGakuKanriModel();
        //sut.setEntity(DbT7116JukyushaGendoGakuKanriEntityGenerator.createDbT7116JukyushaGendoGakuKanriEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            JukyushaGendoGakuKanriModel sut = new JukyushaGendoGakuKanriModel();
            sut.setEntity(DbT7116JukyushaGendoGakuKanriEntityGenerator.createDbT7116JukyushaGendoGakuKanriEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            JukyushaGendoGakuKanriModel sut = new JukyushaGendoGakuKanriModel();
            sut.setEntity(DbT7116JukyushaGendoGakuKanriEntityGenerator.createDbT7116JukyushaGendoGakuKanriEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
