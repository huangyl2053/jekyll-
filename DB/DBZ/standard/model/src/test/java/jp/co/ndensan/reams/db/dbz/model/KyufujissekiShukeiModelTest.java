/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3033KyufujissekiShukeiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufujissekiShukeiModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class KyufujissekiShukeiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyufujissekiShukeiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyufujissekiShukeiModel();
        }

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            sut.set交換情報識別番号(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_交換情報識別番号);
            assertThat(sut.get交換情報識別番号(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            sut.set入力識別番号(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_入力識別番号);
            assertThat(sut.get入力識別番号(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            sut.setレコード種別コード(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_レコード種別コード);
            assertThat(sut.getレコード種別コード(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            sut.set事業所番号(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_事業所番号);
            assertThat(sut.get事業所番号(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            sut.set通し番号(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_通し番号);
            assertThat(sut.get通し番号(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            sut.setサービス種類コード(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_サービス種類コード);
            assertThat(sut.getサービス種類コード(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス実日数は_設定した値と同じサービス実日数を返す() {
            sut.setサービス実日数(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_サービス実日数);
            assertThat(sut.getサービス実日数(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_サービス実日数));
        }

        @Test
        public void 戻り値の計画単位数は_設定した値と同じ計画単位数を返す() {
            sut.set計画単位数(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_計画単位数);
            assertThat(sut.get計画単位数(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_計画単位数));
        }

        @Test
        public void 戻り値の限度額管理対象単位数は_設定した値と同じ限度額管理対象単位数を返す() {
            sut.set限度額管理対象単位数(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_限度額管理対象単位数);
            assertThat(sut.get限度額管理対象単位数(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_限度額管理対象単位数));
        }

        @Test
        public void 戻り値の限度額管理対象外単位数は_設定した値と同じ限度額管理対象外単位数を返す() {
            sut.set限度額管理対象外単位数(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_限度額管理対象外単位数);
            assertThat(sut.get限度額管理対象外単位数(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_限度額管理対象外単位数));
        }

        @Test
        public void 戻り値の短期入所計画日数は_設定した値と同じ短期入所計画日数を返す() {
            sut.set短期入所計画日数(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_短期入所計画日数);
            assertThat(sut.get短期入所計画日数(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_短期入所計画日数));
        }

        @Test
        public void 戻り値の短期入所実日数は_設定した値と同じ短期入所実日数を返す() {
            sut.set短期入所実日数(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_短期入所実日数);
            assertThat(sut.get短期入所実日数(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_短期入所実日数));
        }

        @Test
        public void 戻り値の保険_単位数合計は_設定した値と同じ保険_単位数合計を返す() {
            sut.set保険_単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険_単位数合計);
            assertThat(sut.get保険_単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険_単位数合計));
        }

        @Test
        public void 戻り値の保険_単位数単価は_設定した値と同じ保険_単位数単価を返す() {
            sut.set保険_単位数単価(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険_単位数単価);
            assertThat(sut.get保険_単位数単価(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険_単位数単価));
        }

        @Test
        public void 戻り値の保険_請求額は_設定した値と同じ保険_請求額を返す() {
            sut.set保険_請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険_請求額);
            assertThat(sut.get保険_請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険_請求額));
        }

        @Test
        public void 戻り値の保険_利用者負担額は_設定した値と同じ保険_利用者負担額を返す() {
            sut.set保険_利用者負担額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険_利用者負担額);
            assertThat(sut.get保険_利用者負担額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険_利用者負担額));
        }

        @Test
        public void 戻り値の公費１_単位数合計は_設定した値と同じ公費１_単位数合計を返す() {
            sut.set公費１_単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１_単位数合計);
            assertThat(sut.get公費１_単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１_単位数合計));
        }

        @Test
        public void 戻り値の公費１_請求額は_設定した値と同じ公費１_請求額を返す() {
            sut.set公費１_請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１_請求額);
            assertThat(sut.get公費１_請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１_請求額));
        }

        @Test
        public void 戻り値の公費１_本人負担額は_設定した値と同じ公費１_本人負担額を返す() {
            sut.set公費１_本人負担額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１_本人負担額);
            assertThat(sut.get公費１_本人負担額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１_本人負担額));
        }

        @Test
        public void 戻り値の公費２_単位数合計は_設定した値と同じ公費２_単位数合計を返す() {
            sut.set公費２_単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２_単位数合計);
            assertThat(sut.get公費２_単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２_単位数合計));
        }

        @Test
        public void 戻り値の公費２_請求額は_設定した値と同じ公費２_請求額を返す() {
            sut.set公費２_請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２_請求額);
            assertThat(sut.get公費２_請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２_請求額));
        }

        @Test
        public void 戻り値の公費２_本人負担額は_設定した値と同じ公費２_本人負担額を返す() {
            sut.set公費２_本人負担額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２_本人負担額);
            assertThat(sut.get公費２_本人負担額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２_本人負担額));
        }

        @Test
        public void 戻り値の公費３_単位数合計は_設定した値と同じ公費３_単位数合計を返す() {
            sut.set公費３_単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３_単位数合計);
            assertThat(sut.get公費３_単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３_単位数合計));
        }

        @Test
        public void 戻り値の公費３_請求額は_設定した値と同じ公費３_請求額を返す() {
            sut.set公費３_請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３_請求額);
            assertThat(sut.get公費３_請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３_請求額));
        }

        @Test
        public void 戻り値の公費３_本人負担額は_設定した値と同じ公費３_本人負担額を返す() {
            sut.set公費３_本人負担額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３_本人負担額);
            assertThat(sut.get公費３_本人負担額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３_本人負担額));
        }

        @Test
        public void 戻り値の保険_出来高単位数合計は_設定した値と同じ保険_出来高単位数合計を返す() {
            sut.set保険_出来高単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険_出来高単位数合計);
            assertThat(sut.get保険_出来高単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険_出来高単位数合計));
        }

        @Test
        public void 戻り値の保険_出来高請求額は_設定した値と同じ保険_出来高請求額を返す() {
            sut.set保険_出来高請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険_出来高請求額);
            assertThat(sut.get保険_出来高請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険_出来高請求額));
        }

        @Test
        public void 戻り値の保険_出来高医療費利用者負担額は_設定した値と同じ保険_出来高医療費利用者負担額を返す() {
            sut.set保険_出来高医療費利用者負担額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険_出来高医療費利用者負担額);
            assertThat(sut.get保険_出来高医療費利用者負担額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険_出来高医療費利用者負担額));
        }

        @Test
        public void 戻り値の公費１_出来高単位数合計は_設定した値と同じ公費１_出来高単位数合計を返す() {
            sut.set公費１_出来高単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１_出来高単位数合計);
            assertThat(sut.get公費１_出来高単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１_出来高単位数合計));
        }

        @Test
        public void 戻り値の公費１_出来高請求額は_設定した値と同じ公費１_出来高請求額を返す() {
            sut.set公費１_出来高請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１_出来高請求額);
            assertThat(sut.get公費１_出来高請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１_出来高請求額));
        }

        @Test
        public void 戻り値の公費１_出来高医療費利用者負担額は_設定した値と同じ公費１_出来高医療費利用者負担額を返す() {
            sut.set公費１_出来高医療費利用者負担額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１_出来高医療費利用者負担額);
            assertThat(sut.get公費１_出来高医療費利用者負担額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１_出来高医療費利用者負担額));
        }

        @Test
        public void 戻り値の公費２_出来高単位数合計は_設定した値と同じ公費２_出来高単位数合計を返す() {
            sut.set公費２_出来高単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２_出来高単位数合計);
            assertThat(sut.get公費２_出来高単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２_出来高単位数合計));
        }

        @Test
        public void 戻り値の公費２_出来高請求額は_設定した値と同じ公費２_出来高請求額を返す() {
            sut.set公費２_出来高請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２_出来高請求額);
            assertThat(sut.get公費２_出来高請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２_出来高請求額));
        }

        @Test
        public void 戻り値の公費２_出来高医療費本人負担額は_設定した値と同じ公費２_出来高医療費本人負担額を返す() {
            sut.set公費２_出来高医療費本人負担額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２_出来高医療費本人負担額);
            assertThat(sut.get公費２_出来高医療費本人負担額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２_出来高医療費本人負担額));
        }

        @Test
        public void 戻り値の公費３_出来高単位数合計は_設定した値と同じ公費３_出来高単位数合計を返す() {
            sut.set公費３_出来高単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３_出来高単位数合計);
            assertThat(sut.get公費３_出来高単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３_出来高単位数合計));
        }

        @Test
        public void 戻り値の公費３_出来高請求額は_設定した値と同じ公費３_出来高請求額を返す() {
            sut.set公費３_出来高請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３_出来高請求額);
            assertThat(sut.get公費３_出来高請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３_出来高請求額));
        }

        @Test
        public void 戻り値の公費３_出来高医療費本人負担額は_設定した値と同じ公費３_出来高医療費本人負担額を返す() {
            sut.set公費３_出来高医療費本人負担額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３_出来高医療費本人負担額);
            assertThat(sut.get公費３_出来高医療費本人負担額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３_出来高医療費本人負担額));
        }

        @Test
        public void 戻り値の後_短期入所実日数は_設定した値と同じ後_短期入所実日数を返す() {
            sut.set後_短期入所実日数(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_短期入所実日数);
            assertThat(sut.get後_短期入所実日数(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_短期入所実日数));
        }

        @Test
        public void 戻り値の後_単位数合計は_設定した値と同じ後_単位数合計を返す() {
            sut.set後_単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_単位数合計);
            assertThat(sut.get後_単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_単位数合計));
        }

        @Test
        public void 戻り値の後_保険請求分請求額は_設定した値と同じ後_保険請求分請求額を返す() {
            sut.set後_保険請求分請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_保険請求分請求額);
            assertThat(sut.get後_保険請求分請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_保険請求分請求額));
        }

        @Test
        public void 戻り値の後_公費１_単位数合計は_設定した値と同じ後_公費１_単位数合計を返す() {
            sut.set後_公費１_単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費１_単位数合計);
            assertThat(sut.get後_公費１_単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費１_単位数合計));
        }

        @Test
        public void 戻り値の後_公費１_請求額は_設定した値と同じ後_公費１_請求額を返す() {
            sut.set後_公費１_請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費１_請求額);
            assertThat(sut.get後_公費１_請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費１_請求額));
        }

        @Test
        public void 戻り値の後_公費２_単位数合計は_設定した値と同じ後_公費２_単位数合計を返す() {
            sut.set後_公費２_単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費２_単位数合計);
            assertThat(sut.get後_公費２_単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費２_単位数合計));
        }

        @Test
        public void 戻り値の後_公費２_請求額は_設定した値と同じ後_公費２_請求額を返す() {
            sut.set後_公費２_請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費２_請求額);
            assertThat(sut.get後_公費２_請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費２_請求額));
        }

        @Test
        public void 戻り値の後_公費３_単位数合計は_設定した値と同じ後_公費３_単位数合計を返す() {
            sut.set後_公費３_単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費３_単位数合計);
            assertThat(sut.get後_公費３_単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費３_単位数合計));
        }

        @Test
        public void 戻り値の後_公費３_請求額は_設定した値と同じ後_公費３_請求額を返す() {
            sut.set後_公費３_請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費３_請求額);
            assertThat(sut.get後_公費３_請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費３_請求額));
        }

        @Test
        public void 戻り値の後_保険_出来高単位数合計は_設定した値と同じ後_保険_出来高単位数合計を返す() {
            sut.set後_保険_出来高単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_保険_出来高単位数合計);
            assertThat(sut.get後_保険_出来高単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_保険_出来高単位数合計));
        }

        @Test
        public void 戻り値の後_保険_出来高請求額は_設定した値と同じ後_保険_出来高請求額を返す() {
            sut.set後_保険_出来高請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_保険_出来高請求額);
            assertThat(sut.get後_保険_出来高請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_保険_出来高請求額));
        }

        @Test
        public void 戻り値の後_公費１_出来高単位数合計は_設定した値と同じ後_公費１_出来高単位数合計を返す() {
            sut.set後_公費１_出来高単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費１_出来高単位数合計);
            assertThat(sut.get後_公費１_出来高単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費１_出来高単位数合計));
        }

        @Test
        public void 戻り値の後_公費１_出来高請求額は_設定した値と同じ後_公費１_出来高請求額を返す() {
            sut.set後_公費１_出来高請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費１_出来高請求額);
            assertThat(sut.get後_公費１_出来高請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費１_出来高請求額));
        }

        @Test
        public void 戻り値の後_公費２_出来高単位数合計は_設定した値と同じ後_公費２_出来高単位数合計を返す() {
            sut.set後_公費２_出来高単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費２_出来高単位数合計);
            assertThat(sut.get後_公費２_出来高単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費２_出来高単位数合計));
        }

        @Test
        public void 戻り値の後_公費２_出来高請求額は_設定した値と同じ後_公費２_出来高請求額を返す() {
            sut.set後_公費２_出来高請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費２_出来高請求額);
            assertThat(sut.get後_公費２_出来高請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費２_出来高請求額));
        }

        @Test
        public void 戻り値の後_公費３_出来高単位数合計は_設定した値と同じ後_公費３_出来高単位数合計を返す() {
            sut.set後_公費３_出来高単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費３_出来高単位数合計);
            assertThat(sut.get後_公費３_出来高単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費３_出来高単位数合計));
        }

        @Test
        public void 戻り値の後_公費３_出来高請求額は_設定した値と同じ後_公費３_出来高請求額を返す() {
            sut.set後_公費３_出来高請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費３_出来高請求額);
            assertThat(sut.get後_公費３_出来高請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後_公費３_出来高請求額));
        }

        @Test
        public void 戻り値の再審査回数は_設定した値と同じ再審査回数を返す() {
            sut.set再審査回数(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_再審査回数);
            assertThat(sut.get再審査回数(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_再審査回数));
        }

        @Test
        public void 戻り値の過誤回数は_設定した値と同じ過誤回数を返す() {
            sut.set過誤回数(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_過誤回数);
            assertThat(sut.get過誤回数(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_過誤回数));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            sut.set審査年月(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_審査年月);
            assertThat(sut.get審査年月(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            sut.set取込年月(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_取込年月);
            assertThat(sut.get取込年月(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_取込年月));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyufujissekiShukeiModel sut = new KyufujissekiShukeiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // KyufujissekiShukeiModel sut = new KyufujissekiShukeiModel();
        //sut.setEntity(DbT3033KyufujissekiShukeiEntityGenerator.createDbT3033KyufujissekiShukeiEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KyufujissekiShukeiModel sut = new KyufujissekiShukeiModel();
            sut.setEntity(DbT3033KyufujissekiShukeiEntityGenerator.createDbT3033KyufujissekiShukeiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyufujissekiShukeiModel sut = new KyufujissekiShukeiModel();
            sut.setEntity(DbT3033KyufujissekiShukeiEntityGenerator.createDbT3033KyufujissekiShukeiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
