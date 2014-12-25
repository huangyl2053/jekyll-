/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KogakuGassanShikyugakuKeisanKekkaMeisaiModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class KogakuGassanShikyugakuKeisanKekkaMeisaiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KogakuGassanShikyugakuKeisanKekkaMeisaiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KogakuGassanShikyugakuKeisanKekkaMeisaiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の対象年度は_設定した値と同じ対象年度を返す() {
            sut.set対象年度(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_対象年度);
            assertThat(sut.get対象年度(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_対象年度));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の支給申請書整理番号は_設定した値と同じ支給申請書整理番号を返す() {
            sut.set支給申請書整理番号(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_支給申請書整理番号);
            assertThat(sut.get支給申請書整理番号(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_支給申請書整理番号));
        }

        @Test
        public void 戻り値の明細番号は_設定した値と同じ明細番号を返す() {
            sut.set明細番号(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_明細番号);
            assertThat(sut.get明細番号(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_明細番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の保険制度コードは_設定した値と同じ保険制度コードを返す() {
            sut.set保険制度コード(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_保険制度コード);
            assertThat(sut.get保険制度コード(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_保険制度コード));
        }

        @Test
        public void 戻り値の内訳保険者番号は_設定した値と同じ内訳保険者番号を返す() {
            sut.set内訳保険者番号(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_内訳保険者番号);
            assertThat(sut.get内訳保険者番号(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_内訳保険者番号));
        }

        @Test
        public void 戻り値の国保被保険者証記号は_設定した値と同じ国保被保険者証記号を返す() {
            sut.set国保被保険者証記号(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_国保被保険者証記号);
            assertThat(sut.get国保被保険者証記号(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_国保被保険者証記号));
        }

        @Test
        public void 戻り値の被保険者_証番号は_設定した値と同じ被保険者_証番号を返す() {
            sut.set被保険者_証番号(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_被保険者_証番号);
            assertThat(sut.get被保険者_証番号(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_被保険者_証番号));
        }

        @Test
        public void 戻り値の内訳保険者名は_設定した値と同じ内訳保険者名を返す() {
            sut.set内訳保険者名(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_内訳保険者名);
            assertThat(sut.get内訳保険者名(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_内訳保険者名));
        }

        @Test
        public void 戻り値の自己負担額証明書整理番号は_設定した値と同じ自己負担額証明書整理番号を返す() {
            sut.set自己負担額証明書整理番号(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_自己負担額証明書整理番号);
            assertThat(sut.get自己負担額証明書整理番号(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_自己負担額証明書整理番号));
        }

        @Test
        public void 戻り値の対象者氏名_漢字は_設定した値と同じ対象者氏名_漢字を返す() {
            sut.set対象者氏名_漢字(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_対象者氏名_漢字);
            assertThat(sut.get対象者氏名_漢字(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_対象者氏名_漢字));
        }

        @Test
        public void 戻り値の70歳以上負担額は_設定した値と同じ70歳以上負担額を返す() {
            sut.set70歳以上負担額(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_70歳以上負担額);
            assertThat(sut.get70歳以上負担額(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_70歳以上負担額));
        }

        @Test
        public void 戻り値の70歳以上按分率は_設定した値と同じ70歳以上按分率を返す() {
            sut.set70歳以上按分率(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_70歳以上按分率);
            assertThat(sut.get70歳以上按分率(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_70歳以上按分率));
        }

        @Test
        public void 戻り値の70歳以上支給額は_設定した値と同じ70歳以上支給額を返す() {
            sut.set70歳以上支給額(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_70歳以上支給額);
            assertThat(sut.get70歳以上支給額(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_70歳以上支給額));
        }

        @Test
        public void 戻り値の70歳未満負担額は_設定した値と同じ70歳未満負担額を返す() {
            sut.set70歳未満負担額(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_70歳未満負担額);
            assertThat(sut.get70歳未満負担額(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_70歳未満負担額));
        }

        @Test
        public void 戻り値の負担額は_設定した値と同じ負担額を返す() {
            sut.set負担額(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_負担額);
            assertThat(sut.get負担額(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_負担額));
        }

        @Test
        public void 戻り値の按分率は_設定した値と同じ按分率を返す() {
            sut.set按分率(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_按分率);
            assertThat(sut.get按分率(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_按分率));
        }

        @Test
        public void 戻り値の70歳未満支給額は_設定した値と同じ70歳未満支給額を返す() {
            sut.set70歳未満支給額(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_70歳未満支給額);
            assertThat(sut.get70歳未満支給額(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_70歳未満支給額));
        }

        @Test
        public void 戻り値の支給額は_設定した値と同じ支給額を返す() {
            sut.set支給額(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_支給額);
            assertThat(sut.get支給額(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_支給額));
        }

        @Test
        public void 戻り値の備考欄記載70歳以上負担額は_設定した値と同じ備考欄記載70歳以上負担額を返す() {
            sut.set備考欄記載70歳以上負担額(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_備考欄記載70歳以上負担額);
            assertThat(sut.get備考欄記載70歳以上負担額(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_備考欄記載70歳以上負担額));
        }

        @Test
        public void 戻り値の備考欄記載70歳未満負担額は_設定した値と同じ備考欄記載70歳未満負担額を返す() {
            sut.set備考欄記載70歳未満負担額(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_備考欄記載70歳未満負担額);
            assertThat(sut.get備考欄記載70歳未満負担額(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_備考欄記載70歳未満負担額));
        }

        @Test
        public void 戻り値のデータ区分は_設定した値と同じデータ区分を返す() {
            sut.setデータ区分(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_データ区分);
            assertThat(sut.getデータ区分(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_データ区分));
        }

        @Test
        public void 戻り値の受取年月は_設定した値と同じ受取年月を返す() {
            sut.set受取年月(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_受取年月);
            assertThat(sut.get受取年月(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_受取年月));
        }

        @Test
        public void 戻り値の送付年月は_設定した値と同じ送付年月を返す() {
            sut.set送付年月(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_送付年月);
            assertThat(sut.get送付年月(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_送付年月));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KogakuGassanShikyugakuKeisanKekkaMeisaiModel sut = new KogakuGassanShikyugakuKeisanKekkaMeisaiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // KogakuGassanShikyugakuKeisanKekkaMeisaiModel sut = new KogakuGassanShikyugakuKeisanKekkaMeisaiModel();
        //sut.setEntity(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.createDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KogakuGassanShikyugakuKeisanKekkaMeisaiModel sut = new KogakuGassanShikyugakuKeisanKekkaMeisaiModel();
            sut.setEntity(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.createDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KogakuGassanShikyugakuKeisanKekkaMeisaiModel sut = new KogakuGassanShikyugakuKeisanKekkaMeisaiModel();
            sut.setEntity(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.createDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
