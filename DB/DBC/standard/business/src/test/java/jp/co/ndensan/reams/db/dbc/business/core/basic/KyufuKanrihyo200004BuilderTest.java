 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3014KyufuKanrihyo200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3014KyufuKanrihyo200004EntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link KyufuKanrihyo200004Builder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuKanrihyo200004BuilderTest extends DbcTestBase {

    private static DbT3014KyufuKanrihyo200004Entity KyufuKanrihyo200004Entity;
    //TODO 変数名称の頭文字を小文字に変更して下さい。
    //TODO 主キー型と変数名を置換してください
    //TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYearMonth 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static HokenshaNo 主キー名3;
    private static JigyoshaNo 主キー名4;
    private static RString 主キー名5;
    private static FlexibleDate 主キー名6;
    private static RString 主キー名7;
    private static RString 主キー名8;

    @BeforeClass
    public static void setUpClass() {
        //TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_審査年月;
        主キー名2 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_証記載保険者番号;
        主キー名4 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_居宅支援事業所番号;
        主キー名5 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票情報作成区分コード;
        主キー名6 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票作成年月日;
        主キー名7 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票種別区分コード;
        主キー名8 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票明細行番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KyufuKanrihyo200004Builder sut;
        private static KyufuKanrihyo200004 business;

        @Before
        public void setUp() {
            KyufuKanrihyo200004Entity = new DbT3014KyufuKanrihyo200004Entity();
            KyufuKanrihyo200004Entity.setShinsaYM(主キー名1);
            KyufuKanrihyo200004Entity.setServiceTeikyoYM(主キー名2);

            business = new KyufuKanrihyo200004(KyufuKanrihyo200004Entity);

            sut = business.createBuilderForEdit();
        }

        //TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            business = sut.set審査年月(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_審査年月).build();
            assertThat(business.get審査年月(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の居宅支援事業所番号は_設定した値と同じ居宅支援事業所番号を返す() {
            business = sut.set居宅支援事業所番号(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_居宅支援事業所番号).build();
            assertThat(business.get居宅支援事業所番号(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_居宅支援事業所番号));
        }

        @Test
        public void 戻り値の給付管理票情報作成区分コードは_設定した値と同じ給付管理票情報作成区分コードを返す() {
            business = sut.set給付管理票情報作成区分コード(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票情報作成区分コード).build();
            assertThat(business.get給付管理票情報作成区分コード(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票情報作成区分コード));
        }

        @Test
        public void 戻り値の給付管理票作成年月日は_設定した値と同じ給付管理票作成年月日を返す() {
            business = sut.set給付管理票作成年月日(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票作成年月日).build();
            assertThat(business.get給付管理票作成年月日(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票作成年月日));
        }

        @Test
        public void 戻り値の給付管理票種別区分コードは_設定した値と同じ給付管理票種別区分コードを返す() {
            business = sut.set給付管理票種別区分コード(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票種別区分コード).build();
            assertThat(business.get給付管理票種別区分コード(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票種別区分コード));
        }

        @Test
        public void 戻り値の給付管理票明細行番号は_設定した値と同じ給付管理票明細行番号を返す() {
            business = sut.set給付管理票明細行番号(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票明細行番号).build();
            assertThat(business.get給付管理票明細行番号(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票明細行番号));
        }

        @Test
        public void 戻り値の保険者番号は_設定した値と同じ保険者番号を返す() {
            business = sut.set保険者番号(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_保険者番号).build();
            assertThat(business.get保険者番号(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の被保険者生年月日は_設定した値と同じ被保険者生年月日を返す() {
            business = sut.set被保険者生年月日(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_被保険者生年月日).build();
            assertThat(business.get被保険者生年月日(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_被保険者生年月日));
        }

        @Test
        public void 戻り値の性別コードは_設定した値と同じ性別コードを返す() {
            business = sut.set性別コード(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_性別コード).build();
            assertThat(business.get性別コード(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_性別コード));
        }

        @Test
        public void 戻り値の要介護状態区分コードは_設定した値と同じ要介護状態区分コードを返す() {
            business = sut.set要介護状態区分コード(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_要介護状態区分コード).build();
            assertThat(business.get要介護状態区分コード(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_要介護状態区分コード));
        }

        @Test
        public void 戻り値の限度額適用期間_開始は_設定した値と同じ限度額適用期間_開始を返す() {
            business = sut.set限度額適用期間_開始(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_限度額適用期間).build();
            assertThat(business.get限度額適用期間_開始(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_限度額適用期間));
        }

        @Test
        public void 戻り値の限度額適用期間は_設定した値と同じ限度額適用期間を返す() {
            business = sut.set限度額適用期間_終了(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_限度額適用期間).build();
            assertThat(business.get限度額適用期間_終了(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_限度額適用期間));
        }

        @Test
        public void 戻り値の居宅_介護予防支給限度額は_設定した値と同じ居宅_介護予防支給限度額を返す() {
            business = sut.set居宅_介護予防支給限度額(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_居宅_介護予防支給限度額).build();
            assertThat(business.get居宅_介護予防支給限度額(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_居宅_介護予防支給限度額));
        }

        @Test
        public void 戻り値の居宅サービス計画作成区分コードは_設定した値と同じ居宅サービス計画作成区分コードを返す() {
            business = sut.set居宅サービス計画作成区分コード(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_居宅サービス計画作成区分コード).build();
            assertThat(business.get居宅サービス計画作成区分コード(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_居宅サービス計画作成区分コード));
        }

        @Test
        public void 戻り値のサービス事業所番号は_設定した値と同じサービス事業所番号を返す() {
            business = sut.setサービス事業所番号(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_サービス事業所番号).build();
            assertThat(business.getサービス事業所番号(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_サービス事業所番号));
        }

        @Test
        public void 戻り値の指定_基準該当_地域密着型サービス識別コードは_設定した値と同じ指定_基準該当_地域密着型サービス識別コードを返す() {
            business = sut.set指定_基準該当_地域密着型サービス識別コード(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_指定_基準該当_地域密着型サービス識別コード).build();
            assertThat(business.get指定_基準該当_地域密着型サービス識別コード(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_指定_基準該当_地域密着型サービス識別コード));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の給付計画単位数_日数は_設定した値と同じ給付計画単位数_日数を返す() {
            business = sut.set給付計画単位数_日数(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付計画単位数_日数).build();
            assertThat(business.get給付計画単位数_日数(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付計画単位数_日数));
        }

        @Test
        public void 戻り値の限度額管理期間における前月までの給付計画日数は_設定した値と同じ限度額管理期間における前月までの給付計画日数を返す() {
            business = sut.set限度額管理期間における前月までの給付計画日数(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_限度額管理期間における前月までの給付計画日数).build();
            assertThat(business.get限度額管理期間における前月までの給付計画日数(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_限度額管理期間における前月までの給付計画日数));
        }

        @Test
        public void 戻り値の指定サービス分小計は_設定した値と同じ指定サービス分小計を返す() {
            business = sut.set指定サービス分小計(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_指定サービス分小計).build();
            assertThat(business.get指定サービス分小計(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_指定サービス分小計));
        }

        @Test
        public void 戻り値の基準該当サービス分小計は_設定した値と同じ基準該当サービス分小計を返す() {
            business = sut.set基準該当サービス分小計(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_基準該当サービス分小計).build();
            assertThat(business.get基準該当サービス分小計(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_基準該当サービス分小計));
        }

        @Test
        public void 戻り値の給付計画合計単位数_日数は_設定した値と同じ給付計画合計単位数_日数を返す() {
            business = sut.set給付計画合計単位数_日数(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付計画合計単位数_日数).build();
            assertThat(business.get給付計画合計単位数_日数(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付計画合計単位数_日数));
        }

        @Test
        public void 戻り値の当初登録年月日は_設定した値と同じ当初登録年月日を返す() {
            business = sut.set当初登録年月日(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_当初登録年月日).build();
            assertThat(business.get当初登録年月日(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_当初登録年月日));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            business = sut.set取込年月(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_取込年月).build();
            assertThat(business.get取込年月(), is(DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_取込年月));
        }

    }
}
