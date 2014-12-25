/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanKinkyuShisetsuRyoyoModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class ShokanKinkyuShisetsuRyoyoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShokanKinkyuShisetsuRyoyoModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShokanKinkyuShisetsuRyoyoModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            sut.set事業者番号(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_事業者番号);
            assertThat(sut.get事業者番号(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            sut.set様式番号(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_様式番号);
            assertThat(sut.get様式番号(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の順次番号は_設定した値と同じ順次番号を返す() {
            sut.set順次番号(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_順次番号);
            assertThat(sut.get順次番号(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_順次番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の緊急時傷病名１は_設定した値と同じ緊急時傷病名１を返す() {
            sut.set緊急時傷病名１(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時傷病名１);
            assertThat(sut.get緊急時傷病名１(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時傷病名１));
        }

        @Test
        public void 戻り値の緊急時傷病名２は_設定した値と同じ緊急時傷病名２を返す() {
            sut.set緊急時傷病名２(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時傷病名２);
            assertThat(sut.get緊急時傷病名２(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時傷病名２));
        }

        @Test
        public void 戻り値の緊急時傷病名３は_設定した値と同じ緊急時傷病名３を返す() {
            sut.set緊急時傷病名３(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時傷病名３);
            assertThat(sut.get緊急時傷病名３(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時傷病名３));
        }

        @Test
        public void 戻り値の緊急時治療開始年月日１は_設定した値と同じ緊急時治療開始年月日１を返す() {
            sut.set緊急時治療開始年月日１(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療開始年月日１);
            assertThat(sut.get緊急時治療開始年月日１(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療開始年月日１));
        }

        @Test
        public void 戻り値の緊急時治療開始年月日２は_設定した値と同じ緊急時治療開始年月日２を返す() {
            sut.set緊急時治療開始年月日２(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療開始年月日２);
            assertThat(sut.get緊急時治療開始年月日２(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療開始年月日２));
        }

        @Test
        public void 戻り値の緊急時治療開始年月日３は_設定した値と同じ緊急時治療開始年月日３を返す() {
            sut.set緊急時治療開始年月日３(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療開始年月日３);
            assertThat(sut.get緊急時治療開始年月日３(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療開始年月日３));
        }

        @Test
        public void 戻り値の往診日数は_設定した値と同じ往診日数を返す() {
            sut.set往診日数(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_往診日数);
            assertThat(sut.get往診日数(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_往診日数));
        }

        @Test
        public void 戻り値の往診医療機関名は_設定した値と同じ往診医療機関名を返す() {
            sut.set往診医療機関名(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_往診医療機関名);
            assertThat(sut.get往診医療機関名(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_往診医療機関名));
        }

        @Test
        public void 戻り値の通院日数は_設定した値と同じ通院日数を返す() {
            sut.set通院日数(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_通院日数);
            assertThat(sut.get通院日数(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_通院日数));
        }

        @Test
        public void 戻り値の通院医療機関名は_設定した値と同じ通院医療機関名を返す() {
            sut.set通院医療機関名(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_通院医療機関名);
            assertThat(sut.get通院医療機関名(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_通院医療機関名));
        }

        @Test
        public void 戻り値の緊急時治療管理単位数は_設定した値と同じ緊急時治療管理単位数を返す() {
            sut.set緊急時治療管理単位数(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療管理単位数);
            assertThat(sut.get緊急時治療管理単位数(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療管理単位数));
        }

        @Test
        public void 戻り値の緊急時治療管理日数は_設定した値と同じ緊急時治療管理日数を返す() {
            sut.set緊急時治療管理日数(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療管理日数);
            assertThat(sut.get緊急時治療管理日数(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療管理日数));
        }

        @Test
        public void 戻り値の緊急時治療管理小計は_設定した値と同じ緊急時治療管理小計を返す() {
            sut.set緊急時治療管理小計(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療管理小計);
            assertThat(sut.get緊急時治療管理小計(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療管理小計));
        }

        @Test
        public void 戻り値のリハビリテーション単位数は_設定した値と同じリハビリテーション単位数を返す() {
            sut.setリハビリテーション単位数(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_リハビリテーション単位数);
            assertThat(sut.getリハビリテーション単位数(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_リハビリテーション単位数));
        }

        @Test
        public void 戻り値の処置単位数は_設定した値と同じ処置単位数を返す() {
            sut.set処置単位数(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_処置単位数);
            assertThat(sut.get処置単位数(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_処置単位数));
        }

        @Test
        public void 戻り値の手術単位数は_設定した値と同じ手術単位数を返す() {
            sut.set手術単位数(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_手術単位数);
            assertThat(sut.get手術単位数(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_手術単位数));
        }

        @Test
        public void 戻り値の麻酔単位数は_設定した値と同じ麻酔単位数を返す() {
            sut.set麻酔単位数(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_麻酔単位数);
            assertThat(sut.get麻酔単位数(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_麻酔単位数));
        }

        @Test
        public void 戻り値の放射線治療単位数は_設定した値と同じ放射線治療単位数を返す() {
            sut.set放射線治療単位数(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_放射線治療単位数);
            assertThat(sut.get放射線治療単位数(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_放射線治療単位数));
        }

        @Test
        public void 戻り値の摘要１は_設定した値と同じ摘要１を返す() {
            sut.set摘要１(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１);
            assertThat(sut.get摘要１(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１));
        }

        @Test
        public void 戻り値の摘要２は_設定した値と同じ摘要２を返す() {
            sut.set摘要２(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要２);
            assertThat(sut.get摘要２(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要２));
        }

        @Test
        public void 戻り値の摘要３は_設定した値と同じ摘要３を返す() {
            sut.set摘要３(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要３);
            assertThat(sut.get摘要３(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要３));
        }

        @Test
        public void 戻り値の摘要４は_設定した値と同じ摘要４を返す() {
            sut.set摘要４(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要４);
            assertThat(sut.get摘要４(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要４));
        }

        @Test
        public void 戻り値の摘要５は_設定した値と同じ摘要５を返す() {
            sut.set摘要５(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要５);
            assertThat(sut.get摘要５(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要５));
        }

        @Test
        public void 戻り値の摘要６は_設定した値と同じ摘要６を返す() {
            sut.set摘要６(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要６);
            assertThat(sut.get摘要６(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要６));
        }

        @Test
        public void 戻り値の摘要７は_設定した値と同じ摘要７を返す() {
            sut.set摘要７(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要７);
            assertThat(sut.get摘要７(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要７));
        }

        @Test
        public void 戻り値の摘要８は_設定した値と同じ摘要８を返す() {
            sut.set摘要８(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要８);
            assertThat(sut.get摘要８(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要８));
        }

        @Test
        public void 戻り値の摘要９は_設定した値と同じ摘要９を返す() {
            sut.set摘要９(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要９);
            assertThat(sut.get摘要９(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要９));
        }

        @Test
        public void 戻り値の摘要１０は_設定した値と同じ摘要１０を返す() {
            sut.set摘要１０(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１０);
            assertThat(sut.get摘要１０(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１０));
        }

        @Test
        public void 戻り値の摘要１１は_設定した値と同じ摘要１１を返す() {
            sut.set摘要１１(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１１);
            assertThat(sut.get摘要１１(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１１));
        }

        @Test
        public void 戻り値の摘要１２は_設定した値と同じ摘要１２を返す() {
            sut.set摘要１２(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１２);
            assertThat(sut.get摘要１２(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１２));
        }

        @Test
        public void 戻り値の摘要１３は_設定した値と同じ摘要１３を返す() {
            sut.set摘要１３(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１３);
            assertThat(sut.get摘要１３(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１３));
        }

        @Test
        public void 戻り値の摘要１４は_設定した値と同じ摘要１４を返す() {
            sut.set摘要１４(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１４);
            assertThat(sut.get摘要１４(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１４));
        }

        @Test
        public void 戻り値の摘要１５は_設定した値と同じ摘要１５を返す() {
            sut.set摘要１５(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１５);
            assertThat(sut.get摘要１５(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１５));
        }

        @Test
        public void 戻り値の摘要１６は_設定した値と同じ摘要１６を返す() {
            sut.set摘要１６(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１６);
            assertThat(sut.get摘要１６(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１６));
        }

        @Test
        public void 戻り値の摘要１７は_設定した値と同じ摘要１７を返す() {
            sut.set摘要１７(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１７);
            assertThat(sut.get摘要１７(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１７));
        }

        @Test
        public void 戻り値の摘要１８は_設定した値と同じ摘要１８を返す() {
            sut.set摘要１８(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１８);
            assertThat(sut.get摘要１８(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１８));
        }

        @Test
        public void 戻り値の摘要１９は_設定した値と同じ摘要１９を返す() {
            sut.set摘要１９(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１９);
            assertThat(sut.get摘要１９(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１９));
        }

        @Test
        public void 戻り値の摘要２０は_設定した値と同じ摘要２０を返す() {
            sut.set摘要２０(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要２０);
            assertThat(sut.get摘要２０(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要２０));
        }

        @Test
        public void 戻り値の緊急時施設療養費合計単位数は_設定した値と同じ緊急時施設療養費合計単位数を返す() {
            sut.set緊急時施設療養費合計単位数(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時施設療養費合計単位数);
            assertThat(sut.get緊急時施設療養費合計単位数(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時施設療養費合計単位数));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShokanKinkyuShisetsuRyoyoModel sut = new ShokanKinkyuShisetsuRyoyoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ShokanKinkyuShisetsuRyoyoModel sut = new ShokanKinkyuShisetsuRyoyoModel();
        //sut.setEntity(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.createDbT3040ShokanKinkyuShisetsuRyoyoEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ShokanKinkyuShisetsuRyoyoModel sut = new ShokanKinkyuShisetsuRyoyoModel();
            sut.setEntity(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.createDbT3040ShokanKinkyuShisetsuRyoyoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShokanKinkyuShisetsuRyoyoModel sut = new ShokanKinkyuShisetsuRyoyoModel();
            sut.setEntity(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.createDbT3040ShokanKinkyuShisetsuRyoyoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
