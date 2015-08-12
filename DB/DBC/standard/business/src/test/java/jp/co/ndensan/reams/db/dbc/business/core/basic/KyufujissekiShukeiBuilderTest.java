/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufujissekiShukeiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiShukeiBuilderTest extends DbcTestBase {

    private static DbT3033KyufujissekiShukeiEntity KyufujissekiShukeiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KyufujissekiShukeiBuilder sut;
        private static KyufujissekiShukei business;

        @Before
        public void setUp() {
            KyufujissekiShukeiEntity = new DbT3033KyufujissekiShukeiEntity();
            KyufujissekiShukeiEntity.setXXX(主キー名1);
            KyufujissekiShukeiEntity.setXXX(主キー名2);

            business = new KyufujissekiShukei(KyufujissekiShukeiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            business = sut.set交換情報識別番号(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_交換情報識別番号).build();
            assertThat(business.get交換情報識別番号(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            business = sut.set入力識別番号(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_入力識別番号).build();
            assertThat(business.get入力識別番号(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            business = sut.setレコード種別コード(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_レコード種別コード).build();
            assertThat(business.getレコード種別コード(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            business = sut.set事業所番号(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_事業所番号).build();
            assertThat(business.get事業所番号(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            business = sut.set通し番号(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_通し番号).build();
            assertThat(business.get通し番号(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス実日数は_設定した値と同じサービス実日数を返す() {
            business = sut.setサービス実日数(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_サービス実日数).build();
            assertThat(business.getサービス実日数(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_サービス実日数));
        }

        @Test
        public void 戻り値の計画単位数は_設定した値と同じ計画単位数を返す() {
            business = sut.set計画単位数(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_計画単位数).build();
            assertThat(business.get計画単位数(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_計画単位数));
        }

        @Test
        public void 戻り値の限度額管理対象単位数は_設定した値と同じ限度額管理対象単位数を返す() {
            business = sut.set限度額管理対象単位数(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_限度額管理対象単位数).build();
            assertThat(business.get限度額管理対象単位数(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_限度額管理対象単位数));
        }

        @Test
        public void 戻り値の限度額管理対象外単位数は_設定した値と同じ限度額管理対象外単位数を返す() {
            business = sut.set限度額管理対象外単位数(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_限度額管理対象外単位数).build();
            assertThat(business.get限度額管理対象外単位数(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_限度額管理対象外単位数));
        }

        @Test
        public void 戻り値の短期入所計画日数は_設定した値と同じ短期入所計画日数を返す() {
            business = sut.set短期入所計画日数(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_短期入所計画日数).build();
            assertThat(business.get短期入所計画日数(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_短期入所計画日数));
        }

        @Test
        public void 戻り値の短期入所実日数は_設定した値と同じ短期入所実日数を返す() {
            business = sut.set短期入所実日数(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_短期入所実日数).build();
            assertThat(business.get短期入所実日数(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_短期入所実日数));
        }

        @Test
        public void 戻り値の保険・単位数合計は_設定した値と同じ保険・単位数合計を返す() {
            business = sut.set保険・単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険・単位数合計).build();
            assertThat(business.get保険・単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険・単位数合計));
        }

        @Test
        public void 戻り値の保険・単位数単価は_設定した値と同じ保険・単位数単価を返す() {
            business = sut.set保険・単位数単価(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険・単位数単価).build();
            assertThat(business.get保険・単位数単価(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険・単位数単価));
        }

        @Test
        public void 戻り値の保険・請求額は_設定した値と同じ保険・請求額を返す() {
            business = sut.set保険・請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険・請求額).build();
            assertThat(business.get保険・請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険・請求額));
        }

        @Test
        public void 戻り値の保険・利用者負担額は_設定した値と同じ保険・利用者負担額を返す() {
            business = sut.set保険・利用者負担額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険・利用者負担額).build();
            assertThat(business.get保険・利用者負担額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険・利用者負担額));
        }

        @Test
        public void 戻り値の公費１・単位数合計は_設定した値と同じ公費１・単位数合計を返す() {
            business = sut.set公費１・単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１・単位数合計).build();
            assertThat(business.get公費１・単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１・単位数合計));
        }

        @Test
        public void 戻り値の公費１・請求額は_設定した値と同じ公費１・請求額を返す() {
            business = sut.set公費１・請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１・請求額).build();
            assertThat(business.get公費１・請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１・請求額));
        }

        @Test
        public void 戻り値の公費１・本人負担額は_設定した値と同じ公費１・本人負担額を返す() {
            business = sut.set公費１・本人負担額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１・本人負担額).build();
            assertThat(business.get公費１・本人負担額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１・本人負担額));
        }

        @Test
        public void 戻り値の公費２・単位数合計は_設定した値と同じ公費２・単位数合計を返す() {
            business = sut.set公費２・単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２・単位数合計).build();
            assertThat(business.get公費２・単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２・単位数合計));
        }

        @Test
        public void 戻り値の公費２・請求額は_設定した値と同じ公費２・請求額を返す() {
            business = sut.set公費２・請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２・請求額).build();
            assertThat(business.get公費２・請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２・請求額));
        }

        @Test
        public void 戻り値の公費２・本人負担額は_設定した値と同じ公費２・本人負担額を返す() {
            business = sut.set公費２・本人負担額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２・本人負担額).build();
            assertThat(business.get公費２・本人負担額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２・本人負担額));
        }

        @Test
        public void 戻り値の公費３・単位数合計は_設定した値と同じ公費３・単位数合計を返す() {
            business = sut.set公費３・単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３・単位数合計).build();
            assertThat(business.get公費３・単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３・単位数合計));
        }

        @Test
        public void 戻り値の公費３・請求額は_設定した値と同じ公費３・請求額を返す() {
            business = sut.set公費３・請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３・請求額).build();
            assertThat(business.get公費３・請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３・請求額));
        }

        @Test
        public void 戻り値の公費３・本人負担額は_設定した値と同じ公費３・本人負担額を返す() {
            business = sut.set公費３・本人負担額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３・本人負担額).build();
            assertThat(business.get公費３・本人負担額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３・本人負担額));
        }

        @Test
        public void 戻り値の保険・出来高単位数合計は_設定した値と同じ保険・出来高単位数合計を返す() {
            business = sut.set保険・出来高単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険・出来高単位数合計).build();
            assertThat(business.get保険・出来高単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険・出来高単位数合計));
        }

        @Test
        public void 戻り値の保険・出来高請求額は_設定した値と同じ保険・出来高請求額を返す() {
            business = sut.set保険・出来高請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険・出来高請求額).build();
            assertThat(business.get保険・出来高請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険・出来高請求額));
        }

        @Test
        public void 戻り値の保険・出来高医療費利用者負担額は_設定した値と同じ保険・出来高医療費利用者負担額を返す() {
            business = sut.set保険・出来高医療費利用者負担額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険・出来高医療費利用者負担額).build();
            assertThat(business.get保険・出来高医療費利用者負担額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_保険・出来高医療費利用者負担額));
        }

        @Test
        public void 戻り値の公費１・出来高単位数合計は_設定した値と同じ公費１・出来高単位数合計を返す() {
            business = sut.set公費１・出来高単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１・出来高単位数合計).build();
            assertThat(business.get公費１・出来高単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１・出来高単位数合計));
        }

        @Test
        public void 戻り値の公費１・出来高請求額は_設定した値と同じ公費１・出来高請求額を返す() {
            business = sut.set公費１・出来高請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１・出来高請求額).build();
            assertThat(business.get公費１・出来高請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１・出来高請求額));
        }

        @Test
        public void 戻り値の公費１・出来高医療費利用者負担額は_設定した値と同じ公費１・出来高医療費利用者負担額を返す() {
            business = sut.set公費１・出来高医療費利用者負担額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１・出来高医療費利用者負担額).build();
            assertThat(business.get公費１・出来高医療費利用者負担額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費１・出来高医療費利用者負担額));
        }

        @Test
        public void 戻り値の公費２・出来高単位数合計は_設定した値と同じ公費２・出来高単位数合計を返す() {
            business = sut.set公費２・出来高単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２・出来高単位数合計).build();
            assertThat(business.get公費２・出来高単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２・出来高単位数合計));
        }

        @Test
        public void 戻り値の公費２・出来高請求額は_設定した値と同じ公費２・出来高請求額を返す() {
            business = sut.set公費２・出来高請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２・出来高請求額).build();
            assertThat(business.get公費２・出来高請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２・出来高請求額));
        }

        @Test
        public void 戻り値の公費２・出来高医療費本人負担額は_設定した値と同じ公費２・出来高医療費本人負担額を返す() {
            business = sut.set公費２・出来高医療費本人負担額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２・出来高医療費本人負担額).build();
            assertThat(business.get公費２・出来高医療費本人負担額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費２・出来高医療費本人負担額));
        }

        @Test
        public void 戻り値の公費３・出来高単位数合計は_設定した値と同じ公費３・出来高単位数合計を返す() {
            business = sut.set公費３・出来高単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３・出来高単位数合計).build();
            assertThat(business.get公費３・出来高単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３・出来高単位数合計));
        }

        @Test
        public void 戻り値の公費３・出来高請求額は_設定した値と同じ公費３・出来高請求額を返す() {
            business = sut.set公費３・出来高請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３・出来高請求額).build();
            assertThat(business.get公費３・出来高請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３・出来高請求額));
        }

        @Test
        public void 戻り値の公費３・出来高医療費本人負担額は_設定した値と同じ公費３・出来高医療費本人負担額を返す() {
            business = sut.set公費３・出来高医療費本人負担額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３・出来高医療費本人負担額).build();
            assertThat(business.get公費３・出来高医療費本人負担額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_公費３・出来高医療費本人負担額));
        }

        @Test
        public void 戻り値の後・短期入所実日数は_設定した値と同じ後・短期入所実日数を返す() {
            business = sut.set後・短期入所実日数(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・短期入所実日数).build();
            assertThat(business.get後・短期入所実日数(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・短期入所実日数));
        }

        @Test
        public void 戻り値の後・単位数合計は_設定した値と同じ後・単位数合計を返す() {
            business = sut.set後・単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・単位数合計).build();
            assertThat(business.get後・単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・単位数合計));
        }

        @Test
        public void 戻り値の後・保険請求分請求額は_設定した値と同じ後・保険請求分請求額を返す() {
            business = sut.set後・保険請求分請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・保険請求分請求額).build();
            assertThat(business.get後・保険請求分請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・保険請求分請求額));
        }

        @Test
        public void 戻り値の後・公費１・単位数合計は_設定した値と同じ後・公費１・単位数合計を返す() {
            business = sut.set後・公費１・単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費１・単位数合計).build();
            assertThat(business.get後・公費１・単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費１・単位数合計));
        }

        @Test
        public void 戻り値の後・公費１・請求額は_設定した値と同じ後・公費１・請求額を返す() {
            business = sut.set後・公費１・請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費１・請求額).build();
            assertThat(business.get後・公費１・請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費１・請求額));
        }

        @Test
        public void 戻り値の後・公費２・単位数合計は_設定した値と同じ後・公費２・単位数合計を返す() {
            business = sut.set後・公費２・単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費２・単位数合計).build();
            assertThat(business.get後・公費２・単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費２・単位数合計));
        }

        @Test
        public void 戻り値の後・公費２・請求額は_設定した値と同じ後・公費２・請求額を返す() {
            business = sut.set後・公費２・請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費２・請求額).build();
            assertThat(business.get後・公費２・請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費２・請求額));
        }

        @Test
        public void 戻り値の後・公費３・単位数合計は_設定した値と同じ後・公費３・単位数合計を返す() {
            business = sut.set後・公費３・単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費３・単位数合計).build();
            assertThat(business.get後・公費３・単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費３・単位数合計));
        }

        @Test
        public void 戻り値の後・公費３・請求額は_設定した値と同じ後・公費３・請求額を返す() {
            business = sut.set後・公費３・請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費３・請求額).build();
            assertThat(business.get後・公費３・請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費３・請求額));
        }

        @Test
        public void 戻り値の後・保険・出来高単位数合計は_設定した値と同じ後・保険・出来高単位数合計を返す() {
            business = sut.set後・保険・出来高単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・保険・出来高単位数合計).build();
            assertThat(business.get後・保険・出来高単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・保険・出来高単位数合計));
        }

        @Test
        public void 戻り値の後・保険・出来高請求額は_設定した値と同じ後・保険・出来高請求額を返す() {
            business = sut.set後・保険・出来高請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・保険・出来高請求額).build();
            assertThat(business.get後・保険・出来高請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・保険・出来高請求額));
        }

        @Test
        public void 戻り値の後・公費１・出来高単位数合計は_設定した値と同じ後・公費１・出来高単位数合計を返す() {
            business = sut.set後・公費１・出来高単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費１・出来高単位数合計).build();
            assertThat(business.get後・公費１・出来高単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費１・出来高単位数合計));
        }

        @Test
        public void 戻り値の後・公費１・出来高請求額は_設定した値と同じ後・公費１・出来高請求額を返す() {
            business = sut.set後・公費１・出来高請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費１・出来高請求額).build();
            assertThat(business.get後・公費１・出来高請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費１・出来高請求額));
        }

        @Test
        public void 戻り値の後・公費２・出来高単位数合計は_設定した値と同じ後・公費２・出来高単位数合計を返す() {
            business = sut.set後・公費２・出来高単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費２・出来高単位数合計).build();
            assertThat(business.get後・公費２・出来高単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費２・出来高単位数合計));
        }

        @Test
        public void 戻り値の後・公費２・出来高請求額は_設定した値と同じ後・公費２・出来高請求額を返す() {
            business = sut.set後・公費２・出来高請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費２・出来高請求額).build();
            assertThat(business.get後・公費２・出来高請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費２・出来高請求額));
        }

        @Test
        public void 戻り値の後・公費３・出来高単位数合計は_設定した値と同じ後・公費３・出来高単位数合計を返す() {
            business = sut.set後・公費３・出来高単位数合計(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費３・出来高単位数合計).build();
            assertThat(business.get後・公費３・出来高単位数合計(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費３・出来高単位数合計));
        }

        @Test
        public void 戻り値の後・公費３・出来高請求額は_設定した値と同じ後・公費３・出来高請求額を返す() {
            business = sut.set後・公費３・出来高請求額(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費３・出来高請求額).build();
            assertThat(business.get後・公費３・出来高請求額(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_後・公費３・出来高請求額));
        }

        @Test
        public void 戻り値の再審査回数は_設定した値と同じ再審査回数を返す() {
            business = sut.set再審査回数(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_再審査回数).build();
            assertThat(business.get再審査回数(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_再審査回数));
        }

        @Test
        public void 戻り値の過誤回数は_設定した値と同じ過誤回数を返す() {
            business = sut.set過誤回数(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_過誤回数).build();
            assertThat(business.get過誤回数(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_過誤回数));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            business = sut.set審査年月(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_審査年月).build();
            assertThat(business.get審査年月(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            business = sut.set取込年月(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_取込年月).build();
            assertThat(business.get取込年月(), is(DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_取込年月));
        }

    }
}
