/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3041ShokanTokuteiShinryohiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanTokuteiShinryohiModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class ShokanTokuteiShinryohiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShokanTokuteiShinryohiModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShokanTokuteiShinryohiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            sut.set事業者番号(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_事業者番号);
            assertThat(sut.get事業者番号(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            sut.set様式番号(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_様式番号);
            assertThat(sut.get様式番号(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の順次番号は_設定した値と同じ順次番号を返す() {
            sut.set順次番号(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_順次番号);
            assertThat(sut.get順次番号(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_順次番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の傷病名は_設定した値と同じ傷病名を返す() {
            sut.set傷病名(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_傷病名);
            assertThat(sut.get傷病名(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_傷病名));
        }

        @Test
        public void 戻り値の指導管理料等単位数は_設定した値と同じ指導管理料等単位数を返す() {
            sut.set指導管理料等単位数(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_指導管理料等単位数);
            assertThat(sut.get指導管理料等単位数(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_指導管理料等単位数));
        }

        @Test
        public void 戻り値の単純エックス線単位数は_設定した値と同じ単純エックス線単位数を返す() {
            sut.set単純エックス線単位数(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_単純エックス線単位数);
            assertThat(sut.get単純エックス線単位数(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_単純エックス線単位数));
        }

        @Test
        public void 戻り値のリハビリテーション単位数は_設定した値と同じリハビリテーション単位数を返す() {
            sut.setリハビリテーション単位数(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_リハビリテーション単位数);
            assertThat(sut.getリハビリテーション単位数(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_リハビリテーション単位数));
        }

        @Test
        public void 戻り値の精神科専門療法単位数は_設定した値と同じ精神科専門療法単位数を返す() {
            sut.set精神科専門療法単位数(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_精神科専門療法単位数);
            assertThat(sut.get精神科専門療法単位数(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_精神科専門療法単位数));
        }

        @Test
        public void 戻り値の合計単位数は_設定した値と同じ合計単位数を返す() {
            sut.set合計単位数(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_合計単位数);
            assertThat(sut.get合計単位数(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_合計単位数));
        }

        @Test
        public void 戻り値の摘要１は_設定した値と同じ摘要１を返す() {
            sut.set摘要１(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１);
            assertThat(sut.get摘要１(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１));
        }

        @Test
        public void 戻り値の摘要２は_設定した値と同じ摘要２を返す() {
            sut.set摘要２(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要２);
            assertThat(sut.get摘要２(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要２));
        }

        @Test
        public void 戻り値の摘要３は_設定した値と同じ摘要３を返す() {
            sut.set摘要３(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要３);
            assertThat(sut.get摘要３(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要３));
        }

        @Test
        public void 戻り値の摘要４は_設定した値と同じ摘要４を返す() {
            sut.set摘要４(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要４);
            assertThat(sut.get摘要４(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要４));
        }

        @Test
        public void 戻り値の摘要５は_設定した値と同じ摘要５を返す() {
            sut.set摘要５(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要５);
            assertThat(sut.get摘要５(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要５));
        }

        @Test
        public void 戻り値の摘要６は_設定した値と同じ摘要６を返す() {
            sut.set摘要６(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要６);
            assertThat(sut.get摘要６(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要６));
        }

        @Test
        public void 戻り値の摘要７は_設定した値と同じ摘要７を返す() {
            sut.set摘要７(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要７);
            assertThat(sut.get摘要７(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要７));
        }

        @Test
        public void 戻り値の摘要８は_設定した値と同じ摘要８を返す() {
            sut.set摘要８(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要８);
            assertThat(sut.get摘要８(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要８));
        }

        @Test
        public void 戻り値の摘要９は_設定した値と同じ摘要９を返す() {
            sut.set摘要９(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要９);
            assertThat(sut.get摘要９(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要９));
        }

        @Test
        public void 戻り値の摘要１０は_設定した値と同じ摘要１０を返す() {
            sut.set摘要１０(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１０);
            assertThat(sut.get摘要１０(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１０));
        }

        @Test
        public void 戻り値の摘要１１は_設定した値と同じ摘要１１を返す() {
            sut.set摘要１１(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１１);
            assertThat(sut.get摘要１１(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１１));
        }

        @Test
        public void 戻り値の摘要１２は_設定した値と同じ摘要１２を返す() {
            sut.set摘要１２(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１２);
            assertThat(sut.get摘要１２(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１２));
        }

        @Test
        public void 戻り値の摘要１３は_設定した値と同じ摘要１３を返す() {
            sut.set摘要１３(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１３);
            assertThat(sut.get摘要１３(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１３));
        }

        @Test
        public void 戻り値の摘要１４は_設定した値と同じ摘要１４を返す() {
            sut.set摘要１４(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１４);
            assertThat(sut.get摘要１４(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１４));
        }

        @Test
        public void 戻り値の摘要１５は_設定した値と同じ摘要１５を返す() {
            sut.set摘要１５(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１５);
            assertThat(sut.get摘要１５(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１５));
        }

        @Test
        public void 戻り値の摘要１６は_設定した値と同じ摘要１６を返す() {
            sut.set摘要１６(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１６);
            assertThat(sut.get摘要１６(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１６));
        }

        @Test
        public void 戻り値の摘要１７は_設定した値と同じ摘要１７を返す() {
            sut.set摘要１７(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１７);
            assertThat(sut.get摘要１７(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１７));
        }

        @Test
        public void 戻り値の摘要１８は_設定した値と同じ摘要１８を返す() {
            sut.set摘要１８(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１８);
            assertThat(sut.get摘要１８(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１８));
        }

        @Test
        public void 戻り値の摘要１９は_設定した値と同じ摘要１９を返す() {
            sut.set摘要１９(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１９);
            assertThat(sut.get摘要１９(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１９));
        }

        @Test
        public void 戻り値の摘要２０は_設定した値と同じ摘要２０を返す() {
            sut.set摘要２０(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要２０);
            assertThat(sut.get摘要２０(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要２０));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShokanTokuteiShinryohiModel sut = new ShokanTokuteiShinryohiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ShokanTokuteiShinryohiModel sut = new ShokanTokuteiShinryohiModel();
        //sut.setEntity(DbT3041ShokanTokuteiShinryohiEntityGenerator.createDbT3041ShokanTokuteiShinryohiEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ShokanTokuteiShinryohiModel sut = new ShokanTokuteiShinryohiModel();
            sut.setEntity(DbT3041ShokanTokuteiShinryohiEntityGenerator.createDbT3041ShokanTokuteiShinryohiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShokanTokuteiShinryohiModel sut = new ShokanTokuteiShinryohiModel();
            sut.setEntity(DbT3041ShokanTokuteiShinryohiEntityGenerator.createDbT3041ShokanTokuteiShinryohiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
