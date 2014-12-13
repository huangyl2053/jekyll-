/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KogakuGassanShikyuFushikyuKetteiModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class KogakuGassanShikyuFushikyuKetteiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KogakuGassanShikyuFushikyuKetteiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KogakuGassanShikyuFushikyuKetteiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の対象年度は_設定した値と同じ対象年度を返す() {
            sut.set対象年度(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_対象年度);
            assertThat(sut.get対象年度(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_対象年度));
        }

        @Test
        public void 戻り値の保険者番号は_設定した値と同じ保険者番号を返す() {
            sut.set保険者番号(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_保険者番号);
            assertThat(sut.get保険者番号(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_保険者番号));
        }

        @Test
        public void 戻り値の支給申請書整理番号は_設定した値と同じ支給申請書整理番号を返す() {
            sut.set支給申請書整理番号(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支給申請書整理番号);
            assertThat(sut.get支給申請書整理番号(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支給申請書整理番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の自己負担額証明書整理番号は_設定した値と同じ自己負担額証明書整理番号を返す() {
            sut.set自己負担額証明書整理番号(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_自己負担額証明書整理番号);
            assertThat(sut.get自己負担額証明書整理番号(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_自己負担額証明書整理番号));
        }

        @Test
        public void 戻り値の保険制度コードは_設定した値と同じ保険制度コードを返す() {
            sut.set保険制度コード(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_保険制度コード);
            assertThat(sut.get保険制度コード(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_保険制度コード));
        }

        @Test
        public void 戻り値の国保_被保険者証記号は_設定した値と同じ国保_被保険者証記号を返す() {
            sut.set国保_被保険者証記号(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_国保_被保険者証記号);
            assertThat(sut.get国保_被保険者証記号(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_国保_被保険者証記号));
        }

        @Test
        public void 戻り値の対象計算期間開始年月日は_設定した値と同じ対象計算期間開始年月日を返す() {
            sut.set対象計算期間開始年月日(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_対象計算期間開始年月日);
            assertThat(sut.get対象計算期間開始年月日(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_対象計算期間開始年月日));
        }

        @Test
        public void 戻り値の対象計算期間終了年月日は_設定した値と同じ対象計算期間終了年月日を返す() {
            sut.set対象計算期間終了年月日(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_対象計算期間終了年月日);
            assertThat(sut.get対象計算期間終了年月日(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_対象計算期間終了年月日));
        }

        @Test
        public void 戻り値の申請年月日は_設定した値と同じ申請年月日を返す() {
            sut.set申請年月日(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_申請年月日);
            assertThat(sut.get申請年月日(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_申請年月日));
        }

        @Test
        public void 戻り値の決定年月日は_設定した値と同じ決定年月日を返す() {
            sut.set決定年月日(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_決定年月日);
            assertThat(sut.get決定年月日(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_決定年月日));
        }

        @Test
        public void 戻り値の自己負担総額は_設定した値と同じ自己負担総額を返す() {
            sut.set自己負担総額(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_自己負担総額);
            assertThat(sut.get自己負担総額(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_自己負担総額));
        }

        @Test
        public void 戻り値の支給区分コードは_設定した値と同じ支給区分コードを返す() {
            sut.set支給区分コード(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支給区分コード);
            assertThat(sut.get支給区分コード(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支給区分コード));
        }

        @Test
        public void 戻り値の支給額は_設定した値と同じ支給額を返す() {
            sut.set支給額(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支給額);
            assertThat(sut.get支給額(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支給額));
        }

        @Test
        public void 戻り値の給付の種類は_設定した値と同じ給付の種類を返す() {
            sut.set給付の種類(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_給付の種類);
            assertThat(sut.get給付の種類(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_給付の種類));
        }

        @Test
        public void 戻り値の不支給理由は_設定した値と同じ不支給理由を返す() {
            sut.set不支給理由(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_不支給理由);
            assertThat(sut.get不支給理由(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_不支給理由));
        }

        @Test
        public void 戻り値の備考は_設定した値と同じ備考を返す() {
            sut.set備考(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_備考);
            assertThat(sut.get備考(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_備考));
        }

        @Test
        public void 戻り値の支払方法区分は_設定した値と同じ支払方法区分を返す() {
            sut.set支払方法区分(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払方法区分);
            assertThat(sut.get支払方法区分(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払方法区分));
        }

        @Test
        public void 戻り値の支払場所は_設定した値と同じ支払場所を返す() {
            sut.set支払場所(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払場所);
            assertThat(sut.get支払場所(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払場所));
        }

        @Test
        public void 戻り値の支払期間開始年月日は_設定した値と同じ支払期間開始年月日を返す() {
            sut.set支払期間開始年月日(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払期間開始年月日);
            assertThat(sut.get支払期間開始年月日(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払期間開始年月日));
        }

        @Test
        public void 戻り値の支払期間終了年月日は_設定した値と同じ支払期間終了年月日を返す() {
            sut.set支払期間終了年月日(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払期間終了年月日);
            assertThat(sut.get支払期間終了年月日(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払期間終了年月日));
        }

        @Test
        public void 戻り値の閉庁内容は_設定した値と同じ閉庁内容を返す() {
            sut.set閉庁内容(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_閉庁内容);
            assertThat(sut.get閉庁内容(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_閉庁内容));
        }

        @Test
        public void 戻り値の支払期間開始時間は_設定した値と同じ支払期間開始時間を返す() {
            sut.set支払期間開始時間(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払期間開始時間);
            assertThat(sut.get支払期間開始時間(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払期間開始時間));
        }

        @Test
        public void 戻り値の支払期間終了時間は_設定した値と同じ支払期間終了時間を返す() {
            sut.set支払期間終了時間(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払期間終了時間);
            assertThat(sut.get支払期間終了時間(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払期間終了時間));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の決定通知書作成年月日は_設定した値と同じ決定通知書作成年月日を返す() {
            sut.set決定通知書作成年月日(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_決定通知書作成年月日);
            assertThat(sut.get決定通知書作成年月日(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_決定通知書作成年月日));
        }

        @Test
        public void 戻り値の振込通知書作成年月日は_設定した値と同じ振込通知書作成年月日を返す() {
            sut.set振込通知書作成年月日(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_振込通知書作成年月日);
            assertThat(sut.get振込通知書作成年月日(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_振込通知書作成年月日));
        }

        @Test
        public void 戻り値の受取年月は_設定した値と同じ受取年月を返す() {
            sut.set受取年月(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_受取年月);
            assertThat(sut.get受取年月(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_受取年月));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KogakuGassanShikyuFushikyuKetteiModel sut = new KogakuGassanShikyuFushikyuKetteiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // KogakuGassanShikyuFushikyuKetteiModel sut = new KogakuGassanShikyuFushikyuKetteiModel();
        //sut.setEntity(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.createDbT3074KogakuGassanShikyuFushikyuKetteiEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KogakuGassanShikyuFushikyuKetteiModel sut = new KogakuGassanShikyuFushikyuKetteiModel();
            sut.setEntity(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.createDbT3074KogakuGassanShikyuFushikyuKetteiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KogakuGassanShikyuFushikyuKetteiModel sut = new KogakuGassanShikyuFushikyuKetteiModel();
            sut.setEntity(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.createDbT3074KogakuGassanShikyuFushikyuKetteiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
