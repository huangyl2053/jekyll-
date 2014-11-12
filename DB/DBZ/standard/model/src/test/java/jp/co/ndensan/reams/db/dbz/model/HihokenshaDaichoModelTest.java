/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link HihokenshaDaichoModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static HihokenshaDaichoModel sut;

        @BeforeClass
        public static void test() {
            sut = new HihokenshaDaichoModel();
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の資格取得事由コードは_設定した値と同じ資格取得事由コードを返す() {
            sut.set資格取得事由コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格取得事由コード);
            assertThat(sut.get資格取得事由コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格取得事由コード));
        }

        @Test
        public void 戻り値の資格取得年月日は_設定した値と同じ資格取得年月日を返す() {
            sut.set資格取得年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格取得年月日);
            assertThat(sut.get資格取得年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格取得年月日));
        }

        @Test
        public void 戻り値の資格取得届出年月日は_設定した値と同じ資格取得届出年月日を返す() {
            sut.set資格取得届出年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格取得届出年月日);
            assertThat(sut.get資格取得届出年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格取得届出年月日));
        }

        @Test
        public void 戻り値の第1号被保険者年齢到達年月日は_設定した値と同じ第1号被保険者年齢到達年月日を返す() {
            sut.set第1号被保険者年齢到達年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_第1号被保険者年齢到達年月日);
            assertThat(sut.get第1号被保険者年齢到達年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_第1号被保険者年齢到達年月日));
        }

        @Test
        public void 戻り値の被保険者区分コードは_設定した値と同じ被保険者区分コードを返す() {
            sut.set被保険者区分コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者区分コード);
            assertThat(sut.get被保険者区分コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者区分コード));
        }

        @Test
        public void 戻り値の資格喪失事由コードは_設定した値と同じ資格喪失事由コードを返す() {
            sut.set資格喪失事由コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格喪失事由コード);
            assertThat(sut.get資格喪失事由コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格喪失事由コード));
        }

        @Test
        public void 戻り値の資格喪失年月日は_設定した値と同じ資格喪失年月日を返す() {
            sut.set資格喪失年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格喪失年月日);
            assertThat(sut.get資格喪失年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格喪失年月日));
        }

        @Test
        public void 戻り値の資格喪失届出年月日は_設定した値と同じ資格喪失届出年月日を返す() {
            sut.set資格喪失届出年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格喪失届出年月日);
            assertThat(sut.get資格喪失届出年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格喪失届出年月日));
        }

        @Test
        public void 戻り値の住所地特例フラグは_設定した値と同じ住所地特例フラグを返す() {
            sut.set住所地特例フラグ(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_住所地特例フラグ);
            assertThat(sut.get住所地特例フラグ(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_住所地特例フラグ));
        }

        @Test
        public void 戻り値の資格変更事由コードは_設定した値と同じ資格変更事由コードを返す() {
            sut.set資格変更事由コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格変更事由コード);
            assertThat(sut.get資格変更事由コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格変更事由コード));
        }

        @Test
        public void 戻り値の資格変更年月日は_設定した値と同じ資格変更年月日を返す() {
            sut.set資格変更年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格変更年月日);
            assertThat(sut.get資格変更年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格変更年月日));
        }

        @Test
        public void 戻り値の資格変更届出年月日は_設定した値と同じ資格変更届出年月日を返す() {
            sut.set資格変更届出年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格変更届出年月日);
            assertThat(sut.get資格変更届出年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格変更届出年月日));
        }

        @Test
        public void 戻り値の住所地特例適用事由コードは_設定した値と同じ住所地特例適用事由コードを返す() {
            sut.set住所地特例適用事由コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_住所地特例適用事由コード);
            assertThat(sut.get住所地特例適用事由コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_住所地特例適用事由コード));
        }

        @Test
        public void 戻り値の適用年月日は_設定した値と同じ適用年月日を返す() {
            sut.set適用年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_適用年月日);
            assertThat(sut.get適用年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_適用年月日));
        }

        @Test
        public void 戻り値の適用届出年月日は_設定した値と同じ適用届出年月日を返す() {
            sut.set適用届出年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_適用届出年月日);
            assertThat(sut.get適用届出年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_適用届出年月日));
        }

        @Test
        public void 戻り値の住所地特例解除事由コードは_設定した値と同じ住所地特例解除事由コードを返す() {
            sut.set住所地特例解除事由コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_住所地特例解除事由コード);
            assertThat(sut.get住所地特例解除事由コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_住所地特例解除事由コード));
        }

        @Test
        public void 戻り値の解除年月日は_設定した値と同じ解除年月日を返す() {
            sut.set解除年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_解除年月日);
            assertThat(sut.get解除年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_解除年月日));
        }

        @Test
        public void 戻り値の解除届出年月日は_設定した値と同じ解除届出年月日を返す() {
            sut.set解除届出年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_解除届出年月日);
            assertThat(sut.get解除届出年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_解除届出年月日));
        }

        @Test
        public void 戻り値の広域内住所地特例フラグは_設定した値と同じ広域内住所地特例フラグを返す() {
            sut.set広域内住所地特例フラグ(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_広域内住所地特例フラグ);
            assertThat(sut.get広域内住所地特例フラグ(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_広域内住所地特例フラグ));
        }

        @Test
        public void 戻り値の広住特措置元市町村コードは_設定した値と同じ広住特措置元市町村コードを返す() {
            sut.set広住特措置元市町村コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_広住特措置元市町村コード);
            assertThat(sut.get広住特措置元市町村コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_広住特措置元市町村コード));
        }

        @Test
        public void 戻り値の旧市町村コードは_設定した値と同じ旧市町村コードを返す() {
            sut.set旧市町村コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_旧市町村コード);
            assertThat(sut.get旧市町村コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_旧市町村コード));
        }

        @Test
        public void 戻り値の再交付区分は_設定した値と同じ再交付区分を返す() {
            sut.set再交付区分(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_再交付区分);
            assertThat(sut.get再交付区分(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_再交付区分));
        }

        @Test
        public void 戻り値の再交付事由コードは_設定した値と同じ再交付事由コードを返す() {
            sut.set再交付事由コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_再交付事由コード);
            assertThat(sut.get再交付事由コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_再交付事由コード));
        }

        @Test
        public void 戻り値の帳票交付履歴IDは_設定した値と同じ帳票交付履歴IDを返す() {
            sut.set帳票交付履歴ID(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_帳票交付履歴ID);
            assertThat(sut.get帳票交付履歴ID(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_帳票交付履歴ID));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            HihokenshaDaichoModel sut = new HihokenshaDaichoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            HihokenshaDaichoModel sut = new HihokenshaDaichoModel();
            sut.setEntity(DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            HihokenshaDaichoModel sut = new HihokenshaDaichoModel();
            sut.setEntity(DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            HihokenshaDaichoModel sut = new HihokenshaDaichoModel();
            sut.setEntity(DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
