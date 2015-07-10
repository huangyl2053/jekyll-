/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufujissekiKogakuKaigoServicehiModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class KyufujissekiKogakuKaigoServicehiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyufujissekiKogakuKaigoServicehiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyufujissekiKogakuKaigoServicehiModel();
        }

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            sut.set交換情報識別番号(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_交換情報識別番号);
            assertThat(sut.get交換情報識別番号(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            sut.set入力識別番号(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_入力識別番号);
            assertThat(sut.get入力識別番号(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            sut.setレコード種別コード(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_レコード種別コード);
            assertThat(sut.getレコード種別コード(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            sut.set通し番号(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_通し番号);
            assertThat(sut.get通し番号(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値の給付実績情報作成区分コードは_設定した値と同じ給付実績情報作成区分コードを返す() {
            sut.set給付実績情報作成区分コード(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績情報作成区分コード);
            assertThat(sut.get給付実績情報作成区分コード(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績情報作成区分コード));
        }

        @Test
        public void 戻り値の給付実績区分コードは_設定した値と同じ給付実績区分コードを返す() {
            sut.set給付実績区分コード(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績区分コード);
            assertThat(sut.get給付実績区分コード(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績区分コード));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            sut.set受付年月日(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_受付年月日);
            assertThat(sut.get受付年月日(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の決定年月日は_設定した値と同じ決定年月日を返す() {
            sut.set決定年月日(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_決定年月日);
            assertThat(sut.get決定年月日(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_決定年月日));
        }

        @Test
        public void 戻り値の公費１負担番号は_設定した値と同じ公費１負担番号を返す() {
            sut.set公費１負担番号(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費１負担番号);
            assertThat(sut.get公費１負担番号(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費１負担番号));
        }

        @Test
        public void 戻り値の公費２負担番号は_設定した値と同じ公費２負担番号を返す() {
            sut.set公費２負担番号(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費２負担番号);
            assertThat(sut.get公費２負担番号(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費２負担番号));
        }

        @Test
        public void 戻り値の公費３負担番号は_設定した値と同じ公費３負担番号を返す() {
            sut.set公費３負担番号(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費３負担番号);
            assertThat(sut.get公費３負担番号(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費３負担番号));
        }

        @Test
        public void 戻り値の利用者負担額は_設定した値と同じ利用者負担額を返す() {
            sut.set利用者負担額(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_利用者負担額);
            assertThat(sut.get利用者負担額(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_利用者負担額));
        }

        @Test
        public void 戻り値の公費１負担額は_設定した値と同じ公費１負担額を返す() {
            sut.set公費１負担額(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費１負担額);
            assertThat(sut.get公費１負担額(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費１負担額));
        }

        @Test
        public void 戻り値の公費２負担額は_設定した値と同じ公費２負担額を返す() {
            sut.set公費２負担額(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費２負担額);
            assertThat(sut.get公費２負担額(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費２負担額));
        }

        @Test
        public void 戻り値の公費３負担額は_設定した値と同じ公費３負担額を返す() {
            sut.set公費３負担額(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費３負担額);
            assertThat(sut.get公費３負担額(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費３負担額));
        }

        @Test
        public void 戻り値の支給額は_設定した値と同じ支給額を返す() {
            sut.set支給額(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_支給額);
            assertThat(sut.get支給額(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_支給額));
        }

        @Test
        public void 戻り値の公費１支給額は_設定した値と同じ公費１支給額を返す() {
            sut.set公費１支給額(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費１支給額);
            assertThat(sut.get公費１支給額(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費１支給額));
        }

        @Test
        public void 戻り値の公費２支給額は_設定した値と同じ公費２支給額を返す() {
            sut.set公費２支給額(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費２支給額);
            assertThat(sut.get公費２支給額(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費２支給額));
        }

        @Test
        public void 戻り値の公費３支給額は_設定した値と同じ公費３支給額を返す() {
            sut.set公費３支給額(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費３支給額);
            assertThat(sut.get公費３支給額(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費３支給額));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            sut.set審査年月(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_審査年月);
            assertThat(sut.get審査年月(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の送付年月は_設定した値と同じ送付年月を返す() {
            sut.set送付年月(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_送付年月);
            assertThat(sut.get送付年月(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_送付年月));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            sut.set取込年月(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_取込年月);
            assertThat(sut.get取込年月(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_取込年月));
        }

        @Test
        public void 戻り値の作成区分は_設定した値と同じ作成区分を返す() {
            sut.set作成区分(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_作成区分);
            assertThat(sut.get作成区分(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_作成区分));
        }

        @Test
        public void 戻り値の管理番号は_設定した値と同じ管理番号を返す() {
            sut.set管理番号(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_管理番号);
            assertThat(sut.get管理番号(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_管理番号));
        }

        @Test
        public void 戻り値の保険者保有給付実績情報削除済フラグは_設定した値と同じ保険者保有給付実績情報削除済フラグを返す() {
            sut.set保険者保有給付実績情報削除済フラグ(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_保険者保有給付実績情報削除済フラグ);
            assertThat(sut.get保険者保有給付実績情報削除済フラグ(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_保険者保有給付実績情報削除済フラグ));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyufujissekiKogakuKaigoServicehiModel sut = new KyufujissekiKogakuKaigoServicehiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyufujissekiKogakuKaigoServicehiModel sut = new KyufujissekiKogakuKaigoServicehiModel();
            sut.setEntity(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.createDbT3028KyufujissekiKogakuKaigoServicehiEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyufujissekiKogakuKaigoServicehiModel sut = new KyufujissekiKogakuKaigoServicehiModel();
            sut.setEntity(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.createDbT3028KyufujissekiKogakuKaigoServicehiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyufujissekiKogakuKaigoServicehiModel sut = new KyufujissekiKogakuKaigoServicehiModel();
            sut.setEntity(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.createDbT3028KyufujissekiKogakuKaigoServicehiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
