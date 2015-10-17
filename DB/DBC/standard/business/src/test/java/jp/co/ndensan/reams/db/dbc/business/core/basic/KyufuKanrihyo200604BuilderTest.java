/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3015KyufuKanrihyo200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3015KyufuKanrihyo200604EntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
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
 * {@link KyufuKanrihyo200604Builder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuKanrihyo200604BuilderTest extends DbcTestBase {

    private static DbT3015KyufuKanrihyo200604Entity KyufuKanrihyo200604Entity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
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
        主キー名1 = DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_審査年月;
        主キー名2 = DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_証記載保険者番号;
        主キー名4 = DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_居宅支援事業所番号;
        主キー名5 = DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付管理票情報作成区分コード;
        主キー名6 = DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付管理票作成年月日;
        主キー名7 = DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付管理票種別区分コード;
        主キー名8 = DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付管理票明細行番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KyufuKanrihyo200604Builder sut;
        private static KyufuKanrihyo200604 business;

        @Before
        public void setUp() {
            KyufuKanrihyo200604Entity = new DbT3015KyufuKanrihyo200604Entity();
            KyufuKanrihyo200604Entity.setShinsaYM(主キー名1);
            KyufuKanrihyo200604Entity.setServiceTeikyoYM(主キー名2);

            business = new KyufuKanrihyo200604(KyufuKanrihyo200604Entity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            business = sut.set審査年月(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_審査年月).build();
            assertThat(business.get審査年月(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の居宅支援事業所番号は_設定した値と同じ居宅支援事業所番号を返す() {
            business = sut.set居宅支援事業所番号(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_居宅支援事業所番号).build();
            assertThat(business.get居宅支援事業所番号(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_居宅支援事業所番号));
        }

        @Test
        public void 戻り値の給付管理票情報作成区分コードは_設定した値と同じ給付管理票情報作成区分コードを返す() {
            business = sut.set給付管理票情報作成区分コード(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付管理票情報作成区分コード).build();
            assertThat(business.get給付管理票情報作成区分コード(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付管理票情報作成区分コード));
        }

        @Test
        public void 戻り値の給付管理票作成年月日は_設定した値と同じ給付管理票作成年月日を返す() {
            business = sut.set給付管理票作成年月日(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付管理票作成年月日).build();
            assertThat(business.get給付管理票作成年月日(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付管理票作成年月日));
        }

        @Test
        public void 戻り値の給付管理票種別区分コードは_設定した値と同じ給付管理票種別区分コードを返す() {
            business = sut.set給付管理票種別区分コード(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付管理票種別区分コード).build();
            assertThat(business.get給付管理票種別区分コード(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付管理票種別区分コード));
        }

        @Test
        public void 戻り値の給付管理票明細行番号は_設定した値と同じ給付管理票明細行番号を返す() {
            business = sut.set給付管理票明細行番号(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付管理票明細行番号).build();
            assertThat(business.get給付管理票明細行番号(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付管理票明細行番号));
        }

        @Test
        public void 戻り値の保険者番号は_設定した値と同じ保険者番号を返す() {
            business = sut.set保険者番号(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_保険者番号).build();
            assertThat(business.get保険者番号(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の被保険者生年月日は_設定した値と同じ被保険者生年月日を返す() {
            business = sut.set被保険者生年月日(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_被保険者生年月日).build();
            assertThat(business.get被保険者生年月日(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_被保険者生年月日));
        }

        @Test
        public void 戻り値の性別コードは_設定した値と同じ性別コードを返す() {
            business = sut.set性別コード(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_性別コード).build();
            assertThat(business.get性別コード(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_性別コード));
        }

        @Test
        public void 戻り値の要介護状態区分コードは_設定した値と同じ要介護状態区分コードを返す() {
            business = sut.set要介護状態区分コード(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_要介護状態区分コード).build();
            assertThat(business.get要介護状態区分コード(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_要介護状態区分コード));
        }

        @Test
        public void 戻り値の限度額適用開始年月は_設定した値と同じ限度額適用開始年月を返す() {
            business = sut.set限度額適用開始年月(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_限度額適用開始年月).build();
            assertThat(business.get限度額適用開始年月(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_限度額適用開始年月));
        }

        @Test
        public void 戻り値の限度額適用終了年月は_設定した値と同じ限度額適用終了年月を返す() {
            business = sut.set限度額適用終了年月(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_限度額適用終了年月).build();
            assertThat(business.get限度額適用終了年月(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_限度額適用終了年月));
        }

        @Test
        public void 戻り値の居宅_介護予防支給限度額は_設定した値と同じ居宅_介護予防支給限度額を返す() {
            business = sut.set居宅_介護予防支給限度額(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_居宅_介護予防支給限度額).build();
            assertThat(business.get居宅_介護予防支給限度額(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_居宅_介護予防支給限度額));
        }

        @Test
        public void 戻り値の居宅サービス計画作成区分コードは_設定した値と同じ居宅サービス計画作成区分コードを返す() {
            business = sut.set居宅サービス計画作成区分コード(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_居宅サービス計画作成区分コード).build();
            assertThat(business.get居宅サービス計画作成区分コード(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_居宅サービス計画作成区分コード));
        }

        @Test
        public void 戻り値のサービス事業所番号は_設定した値と同じサービス事業所番号を返す() {
            business = sut.setサービス事業所番号(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_サービス事業所番号).build();
            assertThat(business.getサービス事業所番号(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_サービス事業所番号));
        }

        @Test
        public void 戻り値の指定_基準該当_地域密着型サービス識別コードは_設定した値と同じ指定_基準該当_地域密着型サービス識別コードを返す() {
            business = sut.set指定_基準該当_地域密着型サービス識別コード(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_指定_基準該当_地域密着型サービス識別コード).build();
            assertThat(business.get指定_基準該当_地域密着型サービス識別コード(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_指定_基準該当_地域密着型サービス識別コード));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の給付計画単位数_日数は_設定した値と同じ給付計画単位数_日数を返す() {
            business = sut.set給付計画単位数_日数(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付計画単位数_日数).build();
            assertThat(business.get給付計画単位数_日数(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付計画単位数_日数));
        }

        @Test
        public void 戻り値の限度額管理期間における前月までの給付計画日数は_設定した値と同じ限度額管理期間における前月までの給付計画日数を返す() {
            business = sut.set限度額管理期間における前月までの給付計画日数(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_限度額管理期間における前月までの給付計画日数).build();
            assertThat(business.get限度額管理期間における前月までの給付計画日数(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_限度額管理期間における前月までの給付計画日数));
        }

        @Test
        public void 戻り値の指定サービス分小計は_設定した値と同じ指定サービス分小計を返す() {
            business = sut.set指定サービス分小計(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_指定サービス分小計).build();
            assertThat(business.get指定サービス分小計(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_指定サービス分小計));
        }

        @Test
        public void 戻り値の基準該当サービス分小計は_設定した値と同じ基準該当サービス分小計を返す() {
            business = sut.set基準該当サービス分小計(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_基準該当サービス分小計).build();
            assertThat(business.get基準該当サービス分小計(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_基準該当サービス分小計));
        }

        @Test
        public void 戻り値の給付計画合計単位数_日数は_設定した値と同じ給付計画合計単位数_日数を返す() {
            business = sut.set給付計画合計単位数_日数(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付計画合計単位数_日数).build();
            assertThat(business.get給付計画合計単位数_日数(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付計画合計単位数_日数));
        }

        @Test
        public void 戻り値の担当介護支援専門員番号は_設定した値と同じ担当介護支援専門員番号を返す() {
            business = sut.set担当介護支援専門員番号(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_担当介護支援専門員番号).build();
            assertThat(business.get担当介護支援専門員番号(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_担当介護支援専門員番号));
        }

        @Test
        public void 戻り値の委託先の居宅介護支援事業所番号は_設定した値と同じ委託先の居宅介護支援事業所番号を返す() {
            business = sut.set委託先の居宅介護支援事業所番号(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_委託先の居宅介護支援事業所番号).build();
            assertThat(business.get委託先の居宅介護支援事業所番号(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_委託先の居宅介護支援事業所番号));
        }

        @Test
        public void 戻り値の委託先の担当介護支援専門員番号は_設定した値と同じ委託先の担当介護支援専門員番号を返す() {
            business = sut.set委託先の担当介護支援専門員番号(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_委託先の担当介護支援専門員番号).build();
            assertThat(business.get委託先の担当介護支援専門員番号(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_委託先の担当介護支援専門員番号));
        }

        @Test
        public void 戻り値の当初登録年月日は_設定した値と同じ当初登録年月日を返す() {
            business = sut.set当初登録年月日(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_当初登録年月日).build();
            assertThat(business.get当初登録年月日(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_当初登録年月日));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            business = sut.set取込年月(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_取込年月).build();
            assertThat(business.get取込年月(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_取込年月));
        }

    }
}
