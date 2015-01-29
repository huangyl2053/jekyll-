/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3025KyufujissekiKyotakuServiceEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufujissekiKyotakuServiceModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class KyufujissekiKyotakuServiceModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyufujissekiKyotakuServiceModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyufujissekiKyotakuServiceModel();
        }

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            sut.set交換情報識別番号(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_交換情報識別番号);
            assertThat(sut.get交換情報識別番号(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            sut.set入力識別番号(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_入力識別番号);
            assertThat(sut.get入力識別番号(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            sut.setレコード種別コード(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_レコード種別コード);
            assertThat(sut.getレコード種別コード(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            sut.set事業所番号(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_事業所番号);
            assertThat(sut.get事業所番号(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            sut.set通し番号(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_通し番号);
            assertThat(sut.get通し番号(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値のサービス計画費明細行番号は_設定した値と同じサービス計画費明細行番号を返す() {
            sut.setサービス計画費明細行番号(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_サービス計画費明細行番号);
            assertThat(sut.getサービス計画費明細行番号(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_サービス計画費明細行番号));
        }

        @Test
        public void 戻り値の指定基準該当等事業所区分コードは_設定した値と同じ指定基準該当等事業所区分コードを返す() {
            sut.set指定基準該当等事業所区分コード(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_指定基準該当等事業所区分コード);
            assertThat(sut.get指定基準該当等事業所区分コード(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_指定基準該当等事業所区分コード));
        }

        @Test
        public void 戻り値の単位数単価は_設定した値と同じ単位数単価を返す() {
            sut.set単位数単価(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_単位数単価);
            assertThat(sut.get単位数単価(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_単位数単価));
        }

        @Test
        public void 戻り値の居宅サービス計画作成依頼届出年月日は_設定した値と同じ居宅サービス計画作成依頼届出年月日を返す() {
            sut.set居宅サービス計画作成依頼届出年月日(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日);
            assertThat(sut.get居宅サービス計画作成依頼届出年月日(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日));
        }

        @Test
        public void 戻り値のサービスコードは_設定した値と同じサービスコードを返す() {
            sut.setサービスコード(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_サービスコード);
            assertThat(sut.getサービスコード(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_サービスコード));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            sut.set単位数(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_単位数);
            assertThat(sut.get単位数(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_単位数));
        }

        @Test
        public void 戻り値の回数は_設定した値と同じ回数を返す() {
            sut.set回数(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_回数);
            assertThat(sut.get回数(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_回数));
        }

        @Test
        public void 戻り値のサービス単位数は_設定した値と同じサービス単位数を返す() {
            sut.setサービス単位数(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_サービス単位数);
            assertThat(sut.getサービス単位数(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_サービス単位数));
        }

        @Test
        public void 戻り値のサービス単位数合計は_設定した値と同じサービス単位数合計を返す() {
            sut.setサービス単位数合計(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_サービス単位数合計);
            assertThat(sut.getサービス単位数合計(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_サービス単位数合計));
        }

        @Test
        public void 戻り値の請求金額は_設定した値と同じ請求金額を返す() {
            sut.set請求金額(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_請求金額);
            assertThat(sut.get請求金額(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_請求金額));
        }

        @Test
        public void 戻り値の担当介護支援専門員番号は_設定した値と同じ担当介護支援専門員番号を返す() {
            sut.set担当介護支援専門員番号(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_担当介護支援専門員番号);
            assertThat(sut.get担当介護支援専門員番号(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_担当介護支援専門員番号));
        }

        @Test
        public void 戻り値の摘要は_設定した値と同じ摘要を返す() {
            sut.set摘要(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_摘要);
            assertThat(sut.get摘要(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_摘要));
        }

        @Test
        public void 戻り値の後_単位数は_設定した値と同じ後_単位数を返す() {
            sut.set後_単位数(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_後_単位数);
            assertThat(sut.get後_単位数(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_後_単位数));
        }

        @Test
        public void 戻り値の後_回数は_設定した値と同じ後_回数を返す() {
            sut.set後_回数(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_後_回数);
            assertThat(sut.get後_回数(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_後_回数));
        }

        @Test
        public void 戻り値の後_サービス単位数は_設定した値と同じ後_サービス単位数を返す() {
            sut.set後_サービス単位数(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_後_サービス単位数);
            assertThat(sut.get後_サービス単位数(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_後_サービス単位数));
        }

        @Test
        public void 戻り値の後_サービス単位数合計は_設定した値と同じ後_サービス単位数合計を返す() {
            sut.set後_サービス単位数合計(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_後_サービス単位数合計);
            assertThat(sut.get後_サービス単位数合計(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_後_サービス単位数合計));
        }

        @Test
        public void 戻り値の後_請求金額は_設定した値と同じ後_請求金額を返す() {
            sut.set後_請求金額(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_後_請求金額);
            assertThat(sut.get後_請求金額(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_後_請求金額));
        }

        @Test
        public void 戻り値の再審査回数は_設定した値と同じ再審査回数を返す() {
            sut.set再審査回数(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_再審査回数);
            assertThat(sut.get再審査回数(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_再審査回数));
        }

        @Test
        public void 戻り値の過誤回数は_設定した値と同じ過誤回数を返す() {
            sut.set過誤回数(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_過誤回数);
            assertThat(sut.get過誤回数(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_過誤回数));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            sut.set審査年月(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_審査年月);
            assertThat(sut.get審査年月(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            sut.set取込年月(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_取込年月);
            assertThat(sut.get取込年月(), is(DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_取込年月));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyufujissekiKyotakuServiceModel sut = new KyufujissekiKyotakuServiceModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyufujissekiKyotakuServiceModel sut = new KyufujissekiKyotakuServiceModel();
            sut.setEntity(DbT3025KyufujissekiKyotakuServiceEntityGenerator.createDbT3025KyufujissekiKyotakuServiceEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyufujissekiKyotakuServiceModel sut = new KyufujissekiKyotakuServiceModel();
            sut.setEntity(DbT3025KyufujissekiKyotakuServiceEntityGenerator.createDbT3025KyufujissekiKyotakuServiceEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyufujissekiKyotakuServiceModel sut = new KyufujissekiKyotakuServiceModel();
            sut.setEntity(DbT3025KyufujissekiKyotakuServiceEntityGenerator.createDbT3025KyufujissekiKyotakuServiceEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
