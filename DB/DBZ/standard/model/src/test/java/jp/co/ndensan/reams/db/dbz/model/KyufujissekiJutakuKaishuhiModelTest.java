/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3027KyufujissekiJutakuKaishuhiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufujissekiJutakuKaishuhiModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class KyufujissekiJutakuKaishuhiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyufujissekiJutakuKaishuhiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyufujissekiJutakuKaishuhiModel();
        }

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            sut.set交換情報識別番号(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_交換情報識別番号);
            assertThat(sut.get交換情報識別番号(), is(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            sut.set入力識別番号(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_入力識別番号);
            assertThat(sut.get入力識別番号(), is(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            sut.setレコード種別コード(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_レコード種別コード);
            assertThat(sut.getレコード種別コード(), is(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            sut.set事業所番号(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_事業所番号);
            assertThat(sut.get事業所番号(), is(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            sut.set通し番号(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_通し番号);
            assertThat(sut.get通し番号(), is(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値の明細番号は_設定した値と同じ明細番号を返す() {
            sut.set明細番号(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_明細番号);
            assertThat(sut.get明細番号(), is(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_明細番号));
        }

        @Test
        public void 戻り値のサービスコードは_設定した値と同じサービスコードを返す() {
            sut.setサービスコード(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_サービスコード);
            assertThat(sut.getサービスコード(), is(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_サービスコード));
        }

        @Test
        public void 戻り値の住宅改修着工年月日は_設定した値と同じ住宅改修着工年月日を返す() {
            sut.set住宅改修着工年月日(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_住宅改修着工年月日);
            assertThat(sut.get住宅改修着工年月日(), is(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_住宅改修着工年月日));
        }

        @Test
        public void 戻り値の住宅改修事業者名は_設定した値と同じ住宅改修事業者名を返す() {
            sut.set住宅改修事業者名(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_住宅改修事業者名);
            assertThat(sut.get住宅改修事業者名(), is(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_住宅改修事業者名));
        }

        @Test
        public void 戻り値の住宅改修住宅住所は_設定した値と同じ住宅改修住宅住所を返す() {
            sut.set住宅改修住宅住所(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_住宅改修住宅住所);
            assertThat(sut.get住宅改修住宅住所(), is(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_住宅改修住宅住所));
        }

        @Test
        public void 戻り値の改修金額は_設定した値と同じ改修金額を返す() {
            sut.set改修金額(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_改修金額);
            assertThat(sut.get改修金額(), is(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_改修金額));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            sut.set審査年月(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_審査年月);
            assertThat(sut.get審査年月(), is(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            sut.set取込年月(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_取込年月);
            assertThat(sut.get取込年月(), is(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_取込年月));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyufujissekiJutakuKaishuhiModel sut = new KyufujissekiJutakuKaishuhiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyufujissekiJutakuKaishuhiModel sut = new KyufujissekiJutakuKaishuhiModel();
            sut.setEntity(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.createDbT3027KyufujissekiJutakuKaishuhiEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyufujissekiJutakuKaishuhiModel sut = new KyufujissekiJutakuKaishuhiModel();
            sut.setEntity(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.createDbT3027KyufujissekiJutakuKaishuhiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyufujissekiJutakuKaishuhiModel sut = new KyufujissekiJutakuKaishuhiModel();
            sut.setEntity(DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.createDbT3027KyufujissekiJutakuKaishuhiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
