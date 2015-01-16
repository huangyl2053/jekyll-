/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3097TandokuJoseikinKyufuKetteiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link TandokuJoseikinKyufuKetteiModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class TandokuJoseikinKyufuKetteiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static TandokuJoseikinKyufuKetteiModel sut;

        @BeforeClass
        public static void test() {
            sut = new TandokuJoseikinKyufuKetteiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            sut.set受付年月日(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_受付年月日);
            assertThat(sut.get受付年月日(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の決定年月日は_設定した値と同じ決定年月日を返す() {
            sut.set決定年月日(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_決定年月日);
            assertThat(sut.get決定年月日(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_決定年月日));
        }

        @Test
        public void 戻り値の適用開始年月日は_設定した値と同じ適用開始年月日を返す() {
            sut.set適用開始年月日(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_適用開始年月日);
            assertThat(sut.get適用開始年月日(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_適用開始年月日));
        }

        @Test
        public void 戻り値の有効期限は_設定した値と同じ有効期限を返す() {
            sut.set有効期限(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_有効期限);
            assertThat(sut.get有効期限(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_有効期限));
        }

        @Test
        public void 戻り値の利用者負担_決定区分は_設定した値と同じ利用者負担_決定区分を返す() {
            sut.set利用者負担_決定区分(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_利用者負担_決定区分);
            assertThat(sut.get利用者負担_決定区分(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_利用者負担_決定区分));
        }

        @Test
        public void 戻り値の利用者負担_不承認理由は_設定した値と同じ利用者負担_不承認理由を返す() {
            sut.set利用者負担_不承認理由(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_利用者負担_不承認理由);
            assertThat(sut.get利用者負担_不承認理由(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_利用者負担_不承認理由));
        }

        @Test
        public void 戻り値の公費受給者番号は_設定した値と同じ公費受給者番号を返す() {
            sut.set公費受給者番号(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_公費受給者番号);
            assertThat(sut.get公費受給者番号(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_公費受給者番号));
        }

        @Test
        public void 戻り値の公費負担者番号は_設定した値と同じ公費負担者番号を返す() {
            sut.set公費負担者番号(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_公費負担者番号);
            assertThat(sut.get公費負担者番号(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_公費負担者番号));
        }

        @Test
        public void 戻り値の給付率は_設定した値と同じ給付率を返す() {
            sut.set給付率(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_給付率);
            assertThat(sut.get給付率(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_給付率));
        }

        @Test
        public void 戻り値の受給者番号は_設定した値と同じ受給者番号を返す() {
            sut.set受給者番号(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_受給者番号);
            assertThat(sut.get受給者番号(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_受給者番号));
        }

        @Test
        public void 戻り値の経過措置は_設定した値と同じ経過措置を返す() {
            sut.set経過措置(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_経過措置);
            assertThat(sut.get経過措置(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_経過措置));
        }

        @Test
        public void 戻り値の国軽減は_設定した値と同じ国軽減を返す() {
            sut.set国軽減(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_国軽減);
            assertThat(sut.get国軽減(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_国軽減));
        }

        @Test
        public void 戻り値の社会福祉法人軽減は_設定した値と同じ社会福祉法人軽減を返す() {
            sut.set社会福祉法人軽減(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_社会福祉法人軽減);
            assertThat(sut.get社会福祉法人軽減(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_社会福祉法人軽減));
        }

        @Test
        public void 戻り値の特別地域加算は_設定した値と同じ特別地域加算を返す() {
            sut.set特別地域加算(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_特別地域加算);
            assertThat(sut.get特別地域加算(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_特別地域加算));
        }

        @Test
        public void 戻り値の保留区分_滞納は_設定した値と同じ保留区分_滞納を返す() {
            sut.set保留区分_滞納(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_保留区分_滞納);
            assertThat(sut.get保留区分_滞納(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_保留区分_滞納));
        }

        @Test
        public void 戻り値の保留区分_認定申請中は_設定した値と同じ保留区分_認定申請中を返す() {
            sut.set保留区分_認定申請中(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_保留区分_認定申請中);
            assertThat(sut.get保留区分_認定申請中(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_保留区分_認定申請中));
        }

        @Test
        public void 戻り値の保留区分_認定有効期限切れは_設定した値と同じ保留区分_認定有効期限切れを返す() {
            sut.set保留区分_認定有効期限切れ(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_保留区分_認定有効期限切れ);
            assertThat(sut.get保留区分_認定有効期限切れ(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_保留区分_認定有効期限切れ));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            TandokuJoseikinKyufuKetteiModel sut = new TandokuJoseikinKyufuKetteiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            TandokuJoseikinKyufuKetteiModel sut = new TandokuJoseikinKyufuKetteiModel();
            sut.setEntity(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.createDbT3097TandokuJoseikinKyufuKetteiEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            TandokuJoseikinKyufuKetteiModel sut = new TandokuJoseikinKyufuKetteiModel();
            sut.setEntity(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.createDbT3097TandokuJoseikinKyufuKetteiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            TandokuJoseikinKyufuKetteiModel sut = new TandokuJoseikinKyufuKetteiModel();
            sut.setEntity(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.createDbT3097TandokuJoseikinKyufuKetteiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
