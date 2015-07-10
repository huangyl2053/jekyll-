/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3080DaisanshaKoiJidanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DaisanshaKoiJidanModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class DaisanshaKoiJidanModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static DaisanshaKoiJidanModel sut;

        @BeforeClass
        public static void test() {
            sut = new DaisanshaKoiJidanModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の第三者行為届出管理番号は_設定した値と同じ第三者行為届出管理番号を返す() {
            sut.set第三者行為届出管理番号(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_第三者行為届出管理番号);
            assertThat(sut.get第三者行為届出管理番号(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_第三者行為届出管理番号));
        }

        @Test
        public void 戻り値の示談報告書受付年月日は_設定した値と同じ示談報告書受付年月日を返す() {
            sut.set示談報告書受付年月日(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_示談報告書受付年月日);
            assertThat(sut.get示談報告書受付年月日(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_示談報告書受付年月日));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の第三者行為求償協議区分は_設定した値と同じ第三者行為求償協議区分を返す() {
            sut.set第三者行為求償協議区分(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_第三者行為求償協議区分);
            assertThat(sut.get第三者行為求償協議区分(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_第三者行為求償協議区分));
        }

        @Test
        public void 戻り値の示談報告書提出年月日は_設定した値と同じ示談報告書提出年月日を返す() {
            sut.set示談報告書提出年月日(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_示談報告書提出年月日);
            assertThat(sut.get示談報告書提出年月日(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_示談報告書提出年月日));
        }

        @Test
        public void 戻り値の示談成立年月日は_設定した値と同じ示談成立年月日を返す() {
            sut.set示談成立年月日(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_示談成立年月日);
            assertThat(sut.get示談成立年月日(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_示談成立年月日));
        }

        @Test
        public void 戻り値の給付期間開始年月は_設定した値と同じ給付期間開始年月を返す() {
            sut.set給付期間開始年月(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_給付期間開始年月);
            assertThat(sut.get給付期間開始年月(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_給付期間開始年月));
        }

        @Test
        public void 戻り値の給付期間終了年月は_設定した値と同じ給付期間終了年月を返す() {
            sut.set給付期間終了年月(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_給付期間終了年月);
            assertThat(sut.get給付期間終了年月(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_給付期間終了年月));
        }

        @Test
        public void 戻り値の過失割合_加害者は_設定した値と同じ過失割合_加害者を返す() {
            sut.set過失割合_加害者(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_過失割合_加害者);
            assertThat(sut.get過失割合_加害者(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_過失割合_加害者));
        }

        @Test
        public void 戻り値の過失割合_被害者は_設定した値と同じ過失割合_被害者を返す() {
            sut.set過失割合_被害者(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_過失割合_被害者);
            assertThat(sut.get過失割合_被害者(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_過失割合_被害者));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            DaisanshaKoiJidanModel sut = new DaisanshaKoiJidanModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            DaisanshaKoiJidanModel sut = new DaisanshaKoiJidanModel();
            sut.setEntity(DbT3080DaisanshaKoiJidanEntityGenerator.createDbT3080DaisanshaKoiJidanEntity());

            sut.getEntity().initializeMd5();

            //TODO  主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            DaisanshaKoiJidanModel sut = new DaisanshaKoiJidanModel();
            sut.setEntity(DbT3080DaisanshaKoiJidanEntityGenerator.createDbT3080DaisanshaKoiJidanEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            DaisanshaKoiJidanModel sut = new DaisanshaKoiJidanModel();
            sut.setEntity(DbT3080DaisanshaKoiJidanEntityGenerator.createDbT3080DaisanshaKoiJidanEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
