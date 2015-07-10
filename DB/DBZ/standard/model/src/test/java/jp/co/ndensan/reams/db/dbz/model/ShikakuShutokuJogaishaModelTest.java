/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1009ShikakuShutokuJogaishaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShikakuShutokuJogaishaModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class ShikakuShutokuJogaishaModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShikakuShutokuJogaishaModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShikakuShutokuJogaishaModel();
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の資格取得除外理由は_設定した値と同じ資格取得除外理由を返す() {
            sut.set資格取得除外理由(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_資格取得除外理由);
            assertThat(sut.get資格取得除外理由(), is(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_資格取得除外理由));
        }

        @Test
        public void 戻り値の資格取得除外年月日は_設定した値と同じ資格取得除外年月日を返す() {
            sut.set資格取得除外年月日(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_資格取得除外年月日);
            assertThat(sut.get資格取得除外年月日(), is(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_資格取得除外年月日));
        }

        @Test
        public void 戻り値の資格取得除外解除年月日は_設定した値と同じ資格取得除外解除年月日を返す() {
            sut.set資格取得除外解除年月日(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_資格取得除外解除年月日);
            assertThat(sut.get資格取得除外解除年月日(), is(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_資格取得除外解除年月日));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShikakuShutokuJogaishaModel sut = new ShikakuShutokuJogaishaModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            ShikakuShutokuJogaishaModel sut = new ShikakuShutokuJogaishaModel();
            sut.setEntity(DbT1009ShikakuShutokuJogaishaEntityGenerator.createDbT1009ShikakuShutokuJogaishaEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            ShikakuShutokuJogaishaModel sut = new ShikakuShutokuJogaishaModel();
            sut.setEntity(DbT1009ShikakuShutokuJogaishaEntityGenerator.createDbT1009ShikakuShutokuJogaishaEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShikakuShutokuJogaishaModel sut = new ShikakuShutokuJogaishaModel();
            sut.setEntity(DbT1009ShikakuShutokuJogaishaEntityGenerator.createDbT1009ShikakuShutokuJogaishaEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
