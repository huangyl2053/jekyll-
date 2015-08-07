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
 * {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilderTest extends DbcTestBase {

    private static DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder sut;
        private static KyufujissekiTokuteiNyushosyaKaigoServiceHiyo business;

        @Before
        public void setUp() {
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity = new DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity();
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.setXXX(主キー名1);
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.setXXX(主キー名2);

            business = new KyufujissekiTokuteiNyushosyaKaigoServiceHiyo(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            business = sut.set交換情報識別番号(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_交換情報識別番号).build();
            assertThat(business.get交換情報識別番号(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            business = sut.set入力識別番号(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_入力識別番号).build();
            assertThat(business.get入力識別番号(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            business = sut.setレコード種別コード(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_レコード種別コード).build();
            assertThat(business.getレコード種別コード(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            business = sut.set事業所番号(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_事業所番号).build();
            assertThat(business.get事業所番号(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            business = sut.set通し番号(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_通し番号).build();
            assertThat(business.get通し番号(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値の特定入所者介護サービス費用情報レコード順次番号は_設定した値と同じ特定入所者介護サービス費用情報レコード順次番号を返す() {
            business = sut.set特定入所者介護サービス費用情報レコード順次番号(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_特定入所者介護サービス費用情報レコード順次番号).build();
            assertThat(business.get特定入所者介護サービス費用情報レコード順次番号(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_特定入所者介護サービス費用情報レコード順次番号));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス項目コードは_設定した値と同じサービス項目コードを返す() {
            business = sut.setサービス項目コード(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス項目コード).build();
            assertThat(business.getサービス項目コード(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス項目コード));
        }

        @Test
        public void 戻り値の費用単価は_設定した値と同じ費用単価を返す() {
            business = sut.set費用単価(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_費用単価).build();
            assertThat(business.get費用単価(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_費用単価));
        }

        @Test
        public void 戻り値の負担限度額は_設定した値と同じ負担限度額を返す() {
            business = sut.set負担限度額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_負担限度額).build();
            assertThat(business.get負担限度額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_負担限度額));
        }

        @Test
        public void 戻り値の日数は_設定した値と同じ日数を返す() {
            business = sut.set日数(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_日数).build();
            assertThat(business.get日数(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_日数));
        }

        @Test
        public void 戻り値の公費１日数は_設定した値と同じ公費１日数を返す() {
            business = sut.set公費１日数(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費１日数).build();
            assertThat(business.get公費１日数(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費１日数));
        }

        @Test
        public void 戻り値の公費２日数は_設定した値と同じ公費２日数を返す() {
            business = sut.set公費２日数(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費２日数).build();
            assertThat(business.get公費２日数(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費２日数));
        }

        @Test
        public void 戻り値の公費３日数は_設定した値と同じ公費３日数を返す() {
            business = sut.set公費３日数(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費３日数).build();
            assertThat(business.get公費３日数(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費３日数));
        }

        @Test
        public void 戻り値の費用額は_設定した値と同じ費用額を返す() {
            business = sut.set費用額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_費用額).build();
            assertThat(business.get費用額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_費用額));
        }

        @Test
        public void 戻り値の保険分請求額は_設定した値と同じ保険分請求額を返す() {
            business = sut.set保険分請求額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_保険分請求額).build();
            assertThat(business.get保険分請求額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_保険分請求額));
        }

        @Test
        public void 戻り値の公費１負担額（明細）は_設定した値と同じ公費１負担額（明細）を返す() {
            business = sut.set公費１負担額（明細）(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費１負担額（明細）).build();
            assertThat(business.get公費１負担額（明細）(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費１負担額（明細）));
        }

        @Test
        public void 戻り値の公費２負担額（明細）は_設定した値と同じ公費２負担額（明細）を返す() {
            business = sut.set公費２負担額（明細）(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費２負担額（明細）).build();
            assertThat(business.get公費２負担額（明細）(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費２負担額（明細）));
        }

        @Test
        public void 戻り値の公費３負担額（明細）は_設定した値と同じ公費３負担額（明細）を返す() {
            business = sut.set公費３負担額（明細）(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費３負担額（明細）).build();
            assertThat(business.get公費３負担額（明細）(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費３負担額（明細）));
        }

        @Test
        public void 戻り値の利用者負担額は_設定した値と同じ利用者負担額を返す() {
            business = sut.set利用者負担額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_利用者負担額).build();
            assertThat(business.get利用者負担額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_利用者負担額));
        }

        @Test
        public void 戻り値の費用額合計は_設定した値と同じ費用額合計を返す() {
            business = sut.set費用額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_費用額合計).build();
            assertThat(business.get費用額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_費用額合計));
        }

        @Test
        public void 戻り値の保険分請求額合計は_設定した値と同じ保険分請求額合計を返す() {
            business = sut.set保険分請求額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_保険分請求額合計).build();
            assertThat(business.get保険分請求額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_保険分請求額合計));
        }

        @Test
        public void 戻り値の利用者負担額合計は_設定した値と同じ利用者負担額合計を返す() {
            business = sut.set利用者負担額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_利用者負担額合計).build();
            assertThat(business.get利用者負担額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_利用者負担額合計));
        }

        @Test
        public void 戻り値の公費１・負担額合計は_設定した値と同じ公費１・負担額合計を返す() {
            business = sut.set公費１・負担額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費１・負担額合計).build();
            assertThat(business.get公費１・負担額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費１・負担額合計));
        }

        @Test
        public void 戻り値の公費１・請求額は_設定した値と同じ公費１・請求額を返す() {
            business = sut.set公費１・請求額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費１・請求額).build();
            assertThat(business.get公費１・請求額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費１・請求額));
        }

        @Test
        public void 戻り値の公費１・本人負担月額は_設定した値と同じ公費１・本人負担月額を返す() {
            business = sut.set公費１・本人負担月額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費１・本人負担月額).build();
            assertThat(business.get公費１・本人負担月額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費１・本人負担月額));
        }

        @Test
        public void 戻り値の公費２・負担額合計は_設定した値と同じ公費２・負担額合計を返す() {
            business = sut.set公費２・負担額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費２・負担額合計).build();
            assertThat(business.get公費２・負担額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費２・負担額合計));
        }

        @Test
        public void 戻り値の公費２・請求額は_設定した値と同じ公費２・請求額を返す() {
            business = sut.set公費２・請求額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費２・請求額).build();
            assertThat(business.get公費２・請求額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費２・請求額));
        }

        @Test
        public void 戻り値の公費２・本人負担月額は_設定した値と同じ公費２・本人負担月額を返す() {
            business = sut.set公費２・本人負担月額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費２・本人負担月額).build();
            assertThat(business.get公費２・本人負担月額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費２・本人負担月額));
        }

        @Test
        public void 戻り値の公費３・負担額合計は_設定した値と同じ公費３・負担額合計を返す() {
            business = sut.set公費３・負担額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費３・負担額合計).build();
            assertThat(business.get公費３・負担額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費３・負担額合計));
        }

        @Test
        public void 戻り値の公費３・請求額は_設定した値と同じ公費３・請求額を返す() {
            business = sut.set公費３・請求額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費３・請求額).build();
            assertThat(business.get公費３・請求額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費３・請求額));
        }

        @Test
        public void 戻り値の公費３・本人負担月額は_設定した値と同じ公費３・本人負担月額を返す() {
            business = sut.set公費３・本人負担月額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費３・本人負担月額).build();
            assertThat(business.get公費３・本人負担月額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費３・本人負担月額));
        }

        @Test
        public void 戻り値の後・費用単価は_設定した値と同じ後・費用単価を返す() {
            business = sut.set後・費用単価(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・費用単価).build();
            assertThat(business.get後・費用単価(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・費用単価));
        }

        @Test
        public void 戻り値の後・日数は_設定した値と同じ後・日数を返す() {
            business = sut.set後・日数(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・日数).build();
            assertThat(business.get後・日数(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・日数));
        }

        @Test
        public void 戻り値の後・公費１日数は_設定した値と同じ後・公費１日数を返す() {
            business = sut.set後・公費１日数(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費１日数).build();
            assertThat(business.get後・公費１日数(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費１日数));
        }

        @Test
        public void 戻り値の後・公費２日数は_設定した値と同じ後・公費２日数を返す() {
            business = sut.set後・公費２日数(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費２日数).build();
            assertThat(business.get後・公費２日数(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費２日数));
        }

        @Test
        public void 戻り値の後・公費３日数は_設定した値と同じ後・公費３日数を返す() {
            business = sut.set後・公費３日数(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費３日数).build();
            assertThat(business.get後・公費３日数(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費３日数));
        }

        @Test
        public void 戻り値の後・費用額は_設定した値と同じ後・費用額を返す() {
            business = sut.set後・費用額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・費用額).build();
            assertThat(business.get後・費用額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・費用額));
        }

        @Test
        public void 戻り値の後・保険分請求額は_設定した値と同じ後・保険分請求額を返す() {
            business = sut.set後・保険分請求額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・保険分請求額).build();
            assertThat(business.get後・保険分請求額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・保険分請求額));
        }

        @Test
        public void 戻り値の後・公費１負担額（明細）は_設定した値と同じ後・公費１負担額（明細）を返す() {
            business = sut.set後・公費１負担額（明細）(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費１負担額（明細）).build();
            assertThat(business.get後・公費１負担額（明細）(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費１負担額（明細）));
        }

        @Test
        public void 戻り値の後・公費２負担額（明細）は_設定した値と同じ後・公費２負担額（明細）を返す() {
            business = sut.set後・公費２負担額（明細）(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費２負担額（明細）).build();
            assertThat(business.get後・公費２負担額（明細）(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費２負担額（明細）));
        }

        @Test
        public void 戻り値の後・公費３負担額（明細）は_設定した値と同じ後・公費３負担額（明細）を返す() {
            business = sut.set後・公費３負担額（明細）(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費３負担額（明細）).build();
            assertThat(business.get後・公費３負担額（明細）(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費３負担額（明細）));
        }

        @Test
        public void 戻り値の後・利用者負担額は_設定した値と同じ後・利用者負担額を返す() {
            business = sut.set後・利用者負担額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・利用者負担額).build();
            assertThat(business.get後・利用者負担額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・利用者負担額));
        }

        @Test
        public void 戻り値の後・費用額合計は_設定した値と同じ後・費用額合計を返す() {
            business = sut.set後・費用額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・費用額合計).build();
            assertThat(business.get後・費用額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・費用額合計));
        }

        @Test
        public void 戻り値の後・保険分請求額合計は_設定した値と同じ後・保険分請求額合計を返す() {
            business = sut.set後・保険分請求額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・保険分請求額合計).build();
            assertThat(business.get後・保険分請求額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・保険分請求額合計));
        }

        @Test
        public void 戻り値の後・利用者負担額合計は_設定した値と同じ後・利用者負担額合計を返す() {
            business = sut.set後・利用者負担額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・利用者負担額合計).build();
            assertThat(business.get後・利用者負担額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・利用者負担額合計));
        }

        @Test
        public void 戻り値の後・公費１・負担額合計は_設定した値と同じ後・公費１・負担額合計を返す() {
            business = sut.set後・公費１・負担額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費１・負担額合計).build();
            assertThat(business.get後・公費１・負担額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費１・負担額合計));
        }

        @Test
        public void 戻り値の後・公費１・請求額は_設定した値と同じ後・公費１・請求額を返す() {
            business = sut.set後・公費１・請求額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費１・請求額).build();
            assertThat(business.get後・公費１・請求額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費１・請求額));
        }

        @Test
        public void 戻り値の後・公費１・本人負担月額は_設定した値と同じ後・公費１・本人負担月額を返す() {
            business = sut.set後・公費１・本人負担月額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費１・本人負担月額).build();
            assertThat(business.get後・公費１・本人負担月額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費１・本人負担月額));
        }

        @Test
        public void 戻り値の後・公費２・負担額合計は_設定した値と同じ後・公費２・負担額合計を返す() {
            business = sut.set後・公費２・負担額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費２・負担額合計).build();
            assertThat(business.get後・公費２・負担額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費２・負担額合計));
        }

        @Test
        public void 戻り値の後・公費２・請求額は_設定した値と同じ後・公費２・請求額を返す() {
            business = sut.set後・公費２・請求額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費２・請求額).build();
            assertThat(business.get後・公費２・請求額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費２・請求額));
        }

        @Test
        public void 戻り値の後・公費２・本人負担月額は_設定した値と同じ後・公費２・本人負担月額を返す() {
            business = sut.set後・公費２・本人負担月額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費２・本人負担月額).build();
            assertThat(business.get後・公費２・本人負担月額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費２・本人負担月額));
        }

        @Test
        public void 戻り値の後・公費３・負担額合計は_設定した値と同じ後・公費３・負担額合計を返す() {
            business = sut.set後・公費３・負担額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費３・負担額合計).build();
            assertThat(business.get後・公費３・負担額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費３・負担額合計));
        }

        @Test
        public void 戻り値の後・公費３・請求額は_設定した値と同じ後・公費３・請求額を返す() {
            business = sut.set後・公費３・請求額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費３・請求額).build();
            assertThat(business.get後・公費３・請求額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費３・請求額));
        }

        @Test
        public void 戻り値の後・公費３・本人負担月額は_設定した値と同じ後・公費３・本人負担月額を返す() {
            business = sut.set後・公費３・本人負担月額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費３・本人負担月額).build();
            assertThat(business.get後・公費３・本人負担月額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後・公費３・本人負担月額));
        }

        @Test
        public void 戻り値の再審査回数は_設定した値と同じ再審査回数を返す() {
            business = sut.set再審査回数(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_再審査回数).build();
            assertThat(business.get再審査回数(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_再審査回数));
        }

        @Test
        public void 戻り値の過誤回数は_設定した値と同じ過誤回数を返す() {
            business = sut.set過誤回数(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_過誤回数).build();
            assertThat(business.get過誤回数(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_過誤回数));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            business = sut.set審査年月(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_審査年月).build();
            assertThat(business.get審査年月(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            business = sut.set取込年月(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_取込年月).build();
            assertThat(business.get取込年月(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_取込年月));
        }

    }
}
