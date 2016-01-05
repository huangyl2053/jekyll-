/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3026KyufujissekiFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufujissekiFukushiYoguHanbaihiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiFukushiYoguHanbaihiBuilderTest extends DbcTestBase {

    private static DbT3026KyufujissekiFukushiYoguHanbaihiEntity KyufujissekiFukushiYoguHanbaihiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KokanShikibetsuNo 交換情報識別番号;
    private static NyuryokuShikibetsuNo 入力識別番号;
    private static RString レコード種別コード;
    private static HokenshaNo 証記載保険者番号;
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth サービス提供年月;
    private static JigyoshaNo 事業所番号;
    private static RString 通し番号;
    private static RString 明細番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        交換情報識別番号 = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_交換情報識別番号;
        入力識別番号 = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_入力識別番号;
        レコード種別コード = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_レコード種別コード;
        証記載保険者番号 = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_証記載保険者番号;
        被保険者番号 = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号;
        サービス提供年月 = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービス提供年月;
        事業所番号 = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_事業所番号;
        通し番号 = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_通し番号;
        明細番号 = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_明細番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KyufujissekiFukushiYoguHanbaihiBuilder sut;
        private static KyufujissekiFukushiYoguHanbaihi business;

        @Before
        public void setUp() {
            KyufujissekiFukushiYoguHanbaihiEntity = new DbT3026KyufujissekiFukushiYoguHanbaihiEntity();
            KyufujissekiFukushiYoguHanbaihiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiFukushiYoguHanbaihiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiFukushiYoguHanbaihiEntity.setJigyoshoNo(事業所番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setToshiNo(通し番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setMeisaiNo(明細番号);

            business = new KyufujissekiFukushiYoguHanbaihi(KyufujissekiFukushiYoguHanbaihiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            business = sut.set交換情報識別番号(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_交換情報識別番号).build();
            assertThat(business.get交換情報識別番号(), is(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            business = sut.set入力識別番号(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_入力識別番号).build();
            assertThat(business.get入力識別番号(), is(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            business = sut.setレコード種別コード(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_レコード種別コード).build();
            assertThat(business.getレコード種別コード(), is(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            business = sut.set事業所番号(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_事業所番号).build();
            assertThat(business.get事業所番号(), is(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            business = sut.set通し番号(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_通し番号).build();
            assertThat(business.get通し番号(), is(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値の明細番号は_設定した値と同じ明細番号を返す() {
            business = sut.set明細番号(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_明細番号).build();
            assertThat(business.get明細番号(), is(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_明細番号));
        }

        @Test
        public void 戻り値のサービスコードは_設定した値と同じサービスコードを返す() {
            business = sut.setサービスコード(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービスコード).build();
            assertThat(business.getサービスコード(), is(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービスコード));
        }

        @Test
        public void 戻り値の福祉用具販売年月日は_設定した値と同じ福祉用具販売年月日を返す() {
            business = sut.set福祉用具販売年月日(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具販売年月日).build();
            assertThat(business.get福祉用具販売年月日(), is(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具販売年月日));
        }

        @Test
        public void 戻り値の福祉用具商品名は_設定した値と同じ福祉用具商品名を返す() {
            business = sut.set福祉用具商品名(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具商品名).build();
            assertThat(business.get福祉用具商品名(), is(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具商品名));
        }

        @Test
        public void 戻り値の福祉用具種目コードは_設定した値と同じ福祉用具種目コードを返す() {
            business = sut.set福祉用具種目コード(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具種目コード).build();
            assertThat(business.get福祉用具種目コード(), is(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具種目コード));
        }

        @Test
        public void 戻り値の福祉用具製造事業者名は_設定した値と同じ福祉用具製造事業者名を返す() {
            business = sut.set福祉用具製造事業者名(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具製造事業者名).build();
            assertThat(business.get福祉用具製造事業者名(), is(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具製造事業者名));
        }

        @Test
        public void 戻り値の福祉用具販売事業者名は_設定した値と同じ福祉用具販売事業者名を返す() {
            business = sut.set福祉用具販売事業者名(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具販売事業者名).build();
            assertThat(business.get福祉用具販売事業者名(), is(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具販売事業者名));
        }

        @Test
        public void 戻り値の販売金額は_設定した値と同じ販売金額を返す() {
            business = sut.set販売金額(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_販売金額).build();
            assertThat(business.get販売金額(), is(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_販売金額));
        }

        @Test
        public void 戻り値の摘要_品目コード_は_設定した値と同じ摘要_品目コード_を返す() {
            business = sut.set摘要_品目コード(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_摘要_品目コード).build();
            assertThat(business.get摘要_品目コード(), is(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_摘要_品目コード));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            business = sut.set審査年月(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_審査年月).build();
            assertThat(business.get審査年月(), is(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            business = sut.set取込年月(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_取込年月).build();
            assertThat(business.get取込年月(), is(DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_取込年月));
        }

    }
}
