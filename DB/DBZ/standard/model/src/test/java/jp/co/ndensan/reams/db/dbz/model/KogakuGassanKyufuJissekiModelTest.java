/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3075KogakuGassanKyufuJissekiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KogakuGassanKyufuJissekiModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class KogakuGassanKyufuJissekiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KogakuGassanKyufuJissekiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KogakuGassanKyufuJissekiModel();
        }

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            sut.set交換情報識別番号(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_交換情報識別番号);
            assertThat(sut.get交換情報識別番号(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の支給申請書整理番号は_設定した値と同じ支給申請書整理番号を返す() {
            sut.set支給申請書整理番号(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_支給申請書整理番号);
            assertThat(sut.get支給申請書整理番号(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_支給申請書整理番号));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の自己負担額証明書整理番号は_設定した値と同じ自己負担額証明書整理番号を返す() {
            sut.set自己負担額証明書整理番号(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_自己負担額証明書整理番号);
            assertThat(sut.get自己負担額証明書整理番号(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_自己負担額証明書整理番号));
        }

        @Test
        public void 戻り値の保険制度コードは_設定した値と同じ保険制度コードを返す() {
            sut.set保険制度コード(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_保険制度コード);
            assertThat(sut.get保険制度コード(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_保険制度コード));
        }

        @Test
        public void 戻り値の給付実績作成区分コードは_設定した値と同じ給付実績作成区分コードを返す() {
            sut.set給付実績作成区分コード(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_給付実績作成区分コード);
            assertThat(sut.get給付実績作成区分コード(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_給付実績作成区分コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の国保_被保険者証記号は_設定した値と同じ国保_被保険者証記号を返す() {
            sut.set国保_被保険者証記号(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_国保_被保険者証記号);
            assertThat(sut.get国保_被保険者証記号(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_国保_被保険者証記号));
        }

        @Test
        public void 戻り値の申請年月日は_設定した値と同じ申請年月日を返す() {
            sut.set申請年月日(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_申請年月日);
            assertThat(sut.get申請年月日(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_申請年月日));
        }

        @Test
        public void 戻り値の決定年月日は_設定した値と同じ決定年月日を返す() {
            sut.set決定年月日(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_決定年月日);
            assertThat(sut.get決定年月日(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_決定年月日));
        }

        @Test
        public void 戻り値の自己負担総額は_設定した値と同じ自己負担総額を返す() {
            sut.set自己負担総額(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_自己負担総額);
            assertThat(sut.get自己負担総額(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_自己負担総額));
        }

        @Test
        public void 戻り値の支給額は_設定した値と同じ支給額を返す() {
            sut.set支給額(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_支給額);
            assertThat(sut.get支給額(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_支給額));
        }

        @Test
        public void 戻り値の処理年月は_設定した値と同じ処理年月を返す() {
            sut.set処理年月(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_処理年月);
            assertThat(sut.get処理年月(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_処理年月));
        }

        @Test
        public void 戻り値の受取年月は_設定した値と同じ受取年月を返す() {
            sut.set受取年月(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_受取年月);
            assertThat(sut.get受取年月(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_受取年月));
        }

        @Test
        public void 戻り値の送付年月は_設定した値と同じ送付年月を返す() {
            sut.set送付年月(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_送付年月);
            assertThat(sut.get送付年月(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_送付年月));
        }

        @Test
        public void 戻り値のデータ区分は_設定した値と同じデータ区分を返す() {
            sut.setデータ区分(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_データ区分);
            assertThat(sut.getデータ区分(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_データ区分));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KogakuGassanKyufuJissekiModel sut = new KogakuGassanKyufuJissekiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // KogakuGassanKyufuJissekiModel sut = new KogakuGassanKyufuJissekiModel();
        //sut.setEntity(DbT3075KogakuGassanKyufuJissekiEntityGenerator.createDbT3075KogakuGassanKyufuJissekiEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KogakuGassanKyufuJissekiModel sut = new KogakuGassanKyufuJissekiModel();
            sut.setEntity(DbT3075KogakuGassanKyufuJissekiEntityGenerator.createDbT3075KogakuGassanKyufuJissekiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KogakuGassanKyufuJissekiModel sut = new KogakuGassanKyufuJissekiModel();
            sut.setEntity(DbT3075KogakuGassanKyufuJissekiEntityGenerator.createDbT3075KogakuGassanKyufuJissekiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
