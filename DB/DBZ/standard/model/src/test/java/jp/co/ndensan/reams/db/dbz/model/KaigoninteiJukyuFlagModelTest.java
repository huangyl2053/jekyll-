/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7105KaigoninteiJukyuFlagEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoninteiJukyuFlagModel}のテストクラスです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class KaigoninteiJukyuFlagModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KaigoninteiJukyuFlagModel sut;

        @BeforeClass
        public static void test() {
            sut = new KaigoninteiJukyuFlagModel();
        }

        @Test
        public void 戻り値の基本情報状況フラグは_設定した値と同じ基本情報状況フラグを返す() {
            sut.set基本情報状況フラグ(DbT7105KaigoninteiJukyuFlagEntityGenerator.DEFAULT_基本情報状況フラグ);
            assertThat(sut.get基本情報状況フラグ(), is(DbT7105KaigoninteiJukyuFlagEntityGenerator.DEFAULT_基本情報状況フラグ));
        }

        @Test
        public void 戻り値のモバイルデータ出力フラグは_設定した値と同じモバイルデータ出力フラグを返す() {
            sut.setモバイルデータ出力フラグ(DbT7105KaigoninteiJukyuFlagEntityGenerator.DEFAULT_モバイルデータ出力フラグ);
            assertThat(sut.getモバイルデータ出力フラグ(), is(DbT7105KaigoninteiJukyuFlagEntityGenerator.DEFAULT_モバイルデータ出力フラグ));
        }

        @Test
        public void 戻り値の認定情報提供希望有フラグは_設定した値と同じ認定情報提供希望有フラグを返す() {
            sut.set認定情報提供希望有フラグ(DbT7105KaigoninteiJukyuFlagEntityGenerator.DEFAULT_認定情報提供希望有フラグ);
            assertThat(sut.get認定情報提供希望有フラグ(), is(DbT7105KaigoninteiJukyuFlagEntityGenerator.DEFAULT_認定情報提供希望有フラグ));
        }

        @Test
        public void 戻り値の介護認定審査会審査順確定フラグは_設定した値と同じ介護認定審査会審査順確定フラグを返す() {
            sut.set介護認定審査会審査順確定フラグ(DbT7105KaigoninteiJukyuFlagEntityGenerator.DEFAULT_介護認定審査会審査順確定フラグ);
            assertThat(sut.get介護認定審査会審査順確定フラグ(), is(DbT7105KaigoninteiJukyuFlagEntityGenerator.DEFAULT_介護認定審査会審査順確定フラグ));
        }

        @Test
        public void 戻り値の合議体ダミーフラグは_設定した値と同じ合議体ダミーフラグを返す() {
            sut.set合議体ダミーフラグ(DbT7105KaigoninteiJukyuFlagEntityGenerator.DEFAULT_合議体ダミーフラグ);
            assertThat(sut.get合議体ダミーフラグ(), is(DbT7105KaigoninteiJukyuFlagEntityGenerator.DEFAULT_合議体ダミーフラグ));
        }

        @Test
        public void 戻り値の合議体精神科医存在フラグは_設定した値と同じ合議体精神科医存在フラグを返す() {
            sut.set合議体精神科医存在フラグ(DbT7105KaigoninteiJukyuFlagEntityGenerator.DEFAULT_合議体精神科医存在フラグ);
            assertThat(sut.get合議体精神科医存在フラグ(), is(DbT7105KaigoninteiJukyuFlagEntityGenerator.DEFAULT_合議体精神科医存在フラグ));
        }

        @Test
        public void 戻り値の介護認定審査会休会フラグは_設定した値と同じ介護認定審査会休会フラグを返す() {
            sut.set介護認定審査会休会フラグ(DbT7105KaigoninteiJukyuFlagEntityGenerator.DEFAULT_介護認定審査会休会フラグ);
            assertThat(sut.get介護認定審査会休会フラグ(), is(DbT7105KaigoninteiJukyuFlagEntityGenerator.DEFAULT_介護認定審査会休会フラグ));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KaigoninteiJukyuFlagModel sut = new KaigoninteiJukyuFlagModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // KaigoninteiJukyuFlagModel sut = new KaigoninteiJukyuFlagModel();
        //sut.setEntity(DbT7105KaigoninteiJukyuFlagEntityGenerator.createDbT7105KaigoninteiJukyuFlagEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KaigoninteiJukyuFlagModel sut = new KaigoninteiJukyuFlagModel();
            sut.setEntity(DbT7105KaigoninteiJukyuFlagEntityGenerator.createDbT7105KaigoninteiJukyuFlagEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KaigoninteiJukyuFlagModel sut = new KaigoninteiJukyuFlagModel();
            sut.setEntity(DbT7105KaigoninteiJukyuFlagEntityGenerator.createDbT7105KaigoninteiJukyuFlagEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
