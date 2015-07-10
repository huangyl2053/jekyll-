/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7006RoreiFukushiNenkinJukyushaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link RoreiFukushiNenkinJukyushaModel}のテストクラスです。
 *
 * @author LDNS 賈楽楽
 */
@RunWith(Enclosed.class)
public class RoreiFukushiNenkinJukyushaModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static RoreiFukushiNenkinJukyushaModel sut;

        @BeforeClass
        public static void test() {
            sut = new RoreiFukushiNenkinJukyushaModel();
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の受給開始日は_設定した値と同じ受給開始日を返す() {
            sut.set受給開始日(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_受給開始日);
            assertThat(sut.get受給開始日(), is(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_受給開始日));
        }

        @Test
        public void 戻り値の受給廃止日は_設定した値と同じ受給廃止日を返す() {
            sut.set受給廃止日(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_受給廃止日);
            assertThat(sut.get受給廃止日(), is(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_受給廃止日));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_被保険者番号));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            RoreiFukushiNenkinJukyushaModel sut = new RoreiFukushiNenkinJukyushaModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            RoreiFukushiNenkinJukyushaModel sut = new RoreiFukushiNenkinJukyushaModel();
            sut.setEntity(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.createDbT7006RoreiFukushiNenkinJukyushaEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            RoreiFukushiNenkinJukyushaModel sut = new RoreiFukushiNenkinJukyushaModel();
            sut.setEntity(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.createDbT7006RoreiFukushiNenkinJukyushaEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            RoreiFukushiNenkinJukyushaModel sut = new RoreiFukushiNenkinJukyushaModel();
            sut.setEntity(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.createDbT7006RoreiFukushiNenkinJukyushaEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
