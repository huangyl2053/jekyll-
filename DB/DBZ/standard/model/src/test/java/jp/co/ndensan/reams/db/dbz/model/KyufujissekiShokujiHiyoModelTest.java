/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3022KyufujissekiShokujiHiyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufujissekiShokujiHiyoModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class KyufujissekiShokujiHiyoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyufujissekiShokujiHiyoModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyufujissekiShokujiHiyoModel();
        }

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            sut.set交換情報識別番号(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_交換情報識別番号);
            assertThat(sut.get交換情報識別番号(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            sut.set入力識別番号(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_入力識別番号);
            assertThat(sut.get入力識別番号(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            sut.setレコード種別コード(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_レコード種別コード);
            assertThat(sut.getレコード種別コード(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            sut.set事業所番号(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_事業所番号);
            assertThat(sut.get事業所番号(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            sut.set通し番号(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_通し番号);
            assertThat(sut.get通し番号(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値の基本_提供日数は_設定した値と同じ基本_提供日数を返す() {
            sut.set基本_提供日数(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_基本_提供日数);
            assertThat(sut.get基本_提供日数(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_基本_提供日数));
        }

        @Test
        public void 戻り値の基本_提供単価は_設定した値と同じ基本_提供単価を返す() {
            sut.set基本_提供単価(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_基本_提供単価);
            assertThat(sut.get基本_提供単価(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_基本_提供単価));
        }

        @Test
        public void 戻り値の基本_提供金額は_設定した値と同じ基本_提供金額を返す() {
            sut.set基本_提供金額(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_基本_提供金額);
            assertThat(sut.get基本_提供金額(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_基本_提供金額));
        }

        @Test
        public void 戻り値の特別_提供日数は_設定した値と同じ特別_提供日数を返す() {
            sut.set特別_提供日数(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_特別_提供日数);
            assertThat(sut.get特別_提供日数(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_特別_提供日数));
        }

        @Test
        public void 戻り値の特別_提供単価は_設定した値と同じ特別_提供単価を返す() {
            sut.set特別_提供単価(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_特別_提供単価);
            assertThat(sut.get特別_提供単価(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_特別_提供単価));
        }

        @Test
        public void 戻り値の特別_提供金額は_設定した値と同じ特別_提供金額を返す() {
            sut.set特別_提供金額(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_特別_提供金額);
            assertThat(sut.get特別_提供金額(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_特別_提供金額));
        }

        @Test
        public void 戻り値の食事提供延べ日数は_設定した値と同じ食事提供延べ日数を返す() {
            sut.set食事提供延べ日数(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_食事提供延べ日数);
            assertThat(sut.get食事提供延べ日数(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_食事提供延べ日数));
        }

        @Test
        public void 戻り値の公費１対象食事提供延べ日数は_設定した値と同じ公費１対象食事提供延べ日数を返す() {
            sut.set公費１対象食事提供延べ日数(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費１対象食事提供延べ日数);
            assertThat(sut.get公費１対象食事提供延べ日数(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費１対象食事提供延べ日数));
        }

        @Test
        public void 戻り値の公費２対象食事提供延べ日数は_設定した値と同じ公費２対象食事提供延べ日数を返す() {
            sut.set公費２対象食事提供延べ日数(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費２対象食事提供延べ日数);
            assertThat(sut.get公費２対象食事提供延べ日数(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費２対象食事提供延べ日数));
        }

        @Test
        public void 戻り値の公費３対象食事提供延べ日数は_設定した値と同じ公費３対象食事提供延べ日数を返す() {
            sut.set公費３対象食事提供延べ日数(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費３対象食事提供延べ日数);
            assertThat(sut.get公費３対象食事提供延べ日数(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費３対象食事提供延べ日数));
        }

        @Test
        public void 戻り値の食事提供費合計は_設定した値と同じ食事提供費合計を返す() {
            sut.set食事提供費合計(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_食事提供費合計);
            assertThat(sut.get食事提供費合計(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_食事提供費合計));
        }

        @Test
        public void 戻り値の標準負担額_月額は_設定した値と同じ標準負担額_月額を返す() {
            sut.set標準負担額_月額(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_標準負担額_月額);
            assertThat(sut.get標準負担額_月額(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_標準負担額_月額));
        }

        @Test
        public void 戻り値の食事提供費請求額は_設定した値と同じ食事提供費請求額を返す() {
            sut.set食事提供費請求額(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_食事提供費請求額);
            assertThat(sut.get食事提供費請求額(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_食事提供費請求額));
        }

        @Test
        public void 戻り値の公費１食事提供費請求額は_設定した値と同じ公費１食事提供費請求額を返す() {
            sut.set公費１食事提供費請求額(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費１食事提供費請求額);
            assertThat(sut.get公費１食事提供費請求額(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費１食事提供費請求額));
        }

        @Test
        public void 戻り値の公費２食事提供費請求額は_設定した値と同じ公費２食事提供費請求額を返す() {
            sut.set公費２食事提供費請求額(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費２食事提供費請求額);
            assertThat(sut.get公費２食事提供費請求額(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費２食事提供費請求額));
        }

        @Test
        public void 戻り値の公費３食事提供費請求額は_設定した値と同じ公費３食事提供費請求額を返す() {
            sut.set公費３食事提供費請求額(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費３食事提供費請求額);
            assertThat(sut.get公費３食事提供費請求額(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費３食事提供費請求額));
        }

        @Test
        public void 戻り値の標準負担額_日額は_設定した値と同じ標準負担額_日額を返す() {
            sut.set標準負担額_日額(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_標準負担額_日額);
            assertThat(sut.get標準負担額_日額(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_標準負担額_日額));
        }

        @Test
        public void 戻り値の後_基本食提供費用提供単価は_設定した値と同じ後_基本食提供費用提供単価を返す() {
            sut.set後_基本食提供費用提供単価(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_後_基本食提供費用提供単価);
            assertThat(sut.get後_基本食提供費用提供単価(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_後_基本食提供費用提供単価));
        }

        @Test
        public void 戻り値の後_特別食提供費用提供単価は_設定した値と同じ後_特別食提供費用提供単価を返す() {
            sut.set後_特別食提供費用提供単価(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_後_特別食提供費用提供単価);
            assertThat(sut.get後_特別食提供費用提供単価(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_後_特別食提供費用提供単価));
        }

        @Test
        public void 戻り値の後_食事提供費請求額は_設定した値と同じ後_食事提供費請求額を返す() {
            sut.set後_食事提供費請求額(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_後_食事提供費請求額);
            assertThat(sut.get後_食事提供費請求額(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_後_食事提供費請求額));
        }

        @Test
        public void 戻り値の再審査回数は_設定した値と同じ再審査回数を返す() {
            sut.set再審査回数(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_再審査回数);
            assertThat(sut.get再審査回数(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_再審査回数));
        }

        @Test
        public void 戻り値の過誤回数は_設定した値と同じ過誤回数を返す() {
            sut.set過誤回数(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_過誤回数);
            assertThat(sut.get過誤回数(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_過誤回数));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            sut.set審査年月(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_審査年月);
            assertThat(sut.get審査年月(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            sut.set取込年月(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_取込年月);
            assertThat(sut.get取込年月(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_取込年月));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyufujissekiShokujiHiyoModel sut = new KyufujissekiShokujiHiyoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyufujissekiShokujiHiyoModel sut = new KyufujissekiShokujiHiyoModel();
            sut.setEntity(DbT3022KyufujissekiShokujiHiyoEntityGenerator.createDbT3022KyufujissekiShokujiHiyoEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyufujissekiShokujiHiyoModel sut = new KyufujissekiShokujiHiyoModel();
            sut.setEntity(DbT3022KyufujissekiShokujiHiyoEntityGenerator.createDbT3022KyufujissekiShokujiHiyoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyufujissekiShokujiHiyoModel sut = new KyufujissekiShokujiHiyoModel();
            sut.setEntity(DbT3022KyufujissekiShokujiHiyoEntityGenerator.createDbT3022KyufujissekiShokujiHiyoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
