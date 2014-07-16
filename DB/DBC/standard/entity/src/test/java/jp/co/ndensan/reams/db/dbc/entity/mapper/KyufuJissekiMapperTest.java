/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.mapper;

import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihon;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KeikokuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KyufuSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.entity.helper.DbT3017KyufujissekiKihon200804EntityMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 給付実績エンティティを給付実績情報に変換するMapperクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KyufuJissekiMapperTest extends DbcTestBase {

    public static class to給付実績基本 extends DbcTestBase {

        private KyufuJissekiKihon result;

        private final KyufuSakuseiKubun 作成区分 = KyufuSakuseiKubun.新規;
        private final RString 要介護度 = new RString("要介護１");
        private final Range<FlexibleDate> 認定有効期間 = new Range<>(new FlexibleDate("20130701"), new FlexibleDate("20140630"));
        private final FlexibleYearMonth 審査年月 = new FlexibleYearMonth("201401");
        private final KeikokuKubun 警告区分 = KeikokuKubun.警告なし;

        private final RString 旧措置入所者特例 = new RString("特例１");
        private final RString 老人保健市町村番号 = new RString("00000001");
        private final RString 老人保健受給者番号 = new RString("00000001");
        private final RString 後期高齢保険者番号 = new RString("39000002");
        private final RString 後期高齢被保番号 = new RString("00000002");
        private final RString 国保保険者番号 = new RString("000003");
        private final RString 被保険者証番号 = new RString("00000004");
        private final RString 個人番号 = new RString("0000000005");

        private final RString 居宅サービス計画作成区分 = new RString("自己作成");
        private final JigyoshaNo 事業所番号 = new JigyoshaNo(new RString("0000000001"));

        private final FlexibleDate 開始日 = new FlexibleDate("20140101");
        private final FlexibleDate 中止日 = new FlexibleDate("20140303");
        private final RString 中止理由 = new RString("居宅");

        private final FlexibleDate 入所日 = new FlexibleDate("20140101");
        private final FlexibleDate 退所日 = new FlexibleDate("20140202");
        private final int 入所実日数 = 10;
        private final int 外泊日数 = 30;
        private final RString 入所前の状況 = new RString("居宅");
        private final RString 退所後の状況 = new RString("医療機関入院");

        private final HokenKyufuRitsu 保険 = new HokenKyufuRitsu(new Decimal(90));
        private final HokenKyufuRitsu 公費１ = new HokenKyufuRitsu(new Decimal(1));
        private final HokenKyufuRitsu 公費２ = new HokenKyufuRitsu(new Decimal(2));
        private final HokenKyufuRitsu 公費３ = new HokenKyufuRitsu(new Decimal(3));

        private final RString 公費１負担者番号 = new RString("0000000001");
        private final RString 公費１受給者番号 = new RString("1000000001");
        private final RString 公費２負担者番号 = new RString("0000000002");
        private final RString 公費２受給者番号 = new RString("1000000002");
        private final RString 公費３負担者番号 = new RString("0000000003");
        private final RString 公費３受給者番号 = new RString("1000000003");

        @Before
        public void setUp() {
            result = KyufuJissekiMapper.to給付実績基本(DbT3017KyufujissekiKihon200804EntityMock.getSpiedInstance());
        }

        @Test
        public void 作成区分の設定がある時_to給付実績基本_get作成区分は_設定値を返す() {
            assertThat(result.get作成区分(), is(作成区分));
        }

        @Test
        public void 要介護度の設定がある時_to給付実績基本_get要介護度は_設定値を返す() {
            assertThat(result.get要介護度(), is(要介護度));
        }

        @Test
        public void 認定有効期間の設定がある時_to給付実績基本_get認定有効期間は_設定値を返す() {
            assertThat(result.get認定有効期間(), is(認定有効期間));
        }

        @Test
        public void 審査年月の設定がある時_to給付実績基本_get審査年月は_設定値を返す() {
            assertThat(result.get審査年月(), is(審査年月));
        }

        @Test
        public void 警告区分の設定がある時_to給付実績基本_get警告区分は_設定値を返す() {
            assertThat(result.get警告区分(), is(警告区分));
        }

        @Test
        public void 旧措置入所者特例の設定がある時_to給付実績基本_get被保険者情報_get旧措置入所者特例は_設定値を返す() {
            assertThat(result.get被保険者情報().get旧措置入所者特例(), is(旧措置入所者特例));
        }

        @Test
        public void 老人保健市町村番号の設定がある時_to給付実績基本_get被保険者情報_get老人保健市町村番号は_設定値を返す() {
            assertThat(result.get被保険者情報().get老人保健市町村番号(), is(老人保健市町村番号));
        }

        @Test
        public void 老人保健受給者番号の設定がある時_to給付実績基本_get被保険者情報_get老人保健受給者番号は_設定値を返す() {
            assertThat(result.get被保険者情報().get老人保健受給者番号(), is(老人保健受給者番号));
        }

        @Test
        public void 後期高齢保険者番号の設定がある時_to給付実績基本_get被保険者情報_get後期高齢保険者番号は_設定値を返す() {
            assertThat(result.get被保険者情報().get後期高齢保険者番号(), is(後期高齢保険者番号));
        }

        @Test
        public void 後期高齢被保番号の設定がある時_to給付実績基本_get被保険者情報_get後期高齢被保番号は_設定値を返す() {
            assertThat(result.get被保険者情報().get後期高齢被保番号(), is(後期高齢被保番号));
        }

        @Test
        public void 国保保険者番号の設定がある時_to給付実績基本_get被保険者情報_get国保保険者番号は_設定値を返す() {
            assertThat(result.get被保険者情報().get国保保険者番号(), is(国保保険者番号));
        }

        @Test
        public void 被保険者証番号の設定がある時_to給付実績基本_get被保険者情報_get被保険者証番号は_設定値を返す() {
            assertThat(result.get被保険者情報().get被保険者証番号(), is(被保険者証番号));
        }

        @Test
        public void 個人番号の設定がある時_to給付実績基本_get被保険者情報_get個人番号は_設定値を返す() {
            assertThat(result.get被保険者情報().get個人番号(), is(個人番号));
        }

        @Test
        public void 居宅サービス計画作成区分の設定がある時_to給付実績基本_get居宅サービス計画情報_get居宅サービス計画作成区分は_設定値を返す() {
            assertThat(result.get居宅サービス計画情報().get居宅サービス計画作成区分(), is(居宅サービス計画作成区分));
        }

        @Test
        public void 事業所番号の設定がある時_to給付実績基本_get居宅サービス計画情報_get事業所番号は_設定値を返す() {
            assertThat(result.get居宅サービス計画情報().get事業所番号(), is(事業所番号));
        }

        @Test
        public void 開始日の設定がある時_to給付実績基本_getサービス期間情報_get開始日は_設定値を返す() {
            assertThat(result.getサービス期間情報().get開始日(), is(開始日));
        }

        @Test
        public void 中止日の設定がある時_to給付実績基本_getサービス期間情報_get中止日は_設定値を返す() {
            assertThat(result.getサービス期間情報().get中止日(), is(中止日));
        }

        @Test
        public void 中止理由の設定がある時_to給付実績基本_getサービス期間情報_get中止理由は_設定値を返す() {
            assertThat(result.getサービス期間情報().get中止理由(), is(中止理由));
        }

        @Test
        public void 入所日の設定がある時_to給付実績基本_get施設入退所情報_get入所日は_設定値を返す() {
            assertThat(result.get施設入退所情報().get入所日(), is(入所日));
        }

        @Test
        public void 退所日の設定がある時_to給付実績基本_get施設入退所情報_get退所日は_設定値を返す() {
            assertThat(result.get施設入退所情報().get退所日(), is(退所日));
        }

        @Test
        public void 入所実日数の設定がある時_to給付実績基本_get施設入退所情報_get入所実日数は_設定値を返す() {
            assertThat(result.get施設入退所情報().get入所実日数(), is(入所実日数));
        }

        @Test
        public void 外泊日数の設定がある時_to給付実績基本_get施設入退所情報_get外泊日数は_設定値を返す() {
            assertThat(result.get施設入退所情報().get外泊日数(), is(外泊日数));
        }

        @Test
        public void 入所前の状況の設定がある時_to給付実績基本_get施設入退所情報_get入所前の状況は_設定値を返す() {
            assertThat(result.get施設入退所情報().get入所前の状況(), is(入所前の状況));
        }

        @Test
        public void 退所後の状況の設定がある時_to給付実績基本_get施設入退所情報_get退所後の状況は_設定値を返す() {
            assertThat(result.get施設入退所情報().get退所後の状況(), is(退所後の状況));
        }

        @Test
        public void 保険の設定がある時_to給付実績基本_get給付率情報_get保険は_設定値を返す() {
            assertThat(result.get給付率情報().get保険(), is(保険));
        }

        @Test
        public void 公費１の設定がある時_to給付実績基本_get給付率情報_get公費１は_設定値を返す() {
            assertThat(result.get給付率情報().get公費１(), is(公費１));
        }

        @Test
        public void 公費２の設定がある時_to給付実績基本_get給付率情報_get公費２は_設定値を返す() {
            assertThat(result.get給付率情報().get公費２(), is(公費２));
        }

        @Test
        public void 公費３の設定がある時_to給付実績基本_get給付率情報_get公費３は_設定値を返す() {
            assertThat(result.get給付率情報().get公費３(), is(公費３));
        }

        @Test
        public void 公費１負担者番号の設定がある時_to給付実績基本_get公費情報_get公費１負担者番号は_設定値を返す() {
            assertThat(result.get公費情報().get公費１負担者番号(), is(公費１負担者番号));
        }

        @Test
        public void 公費１受給者番号の設定がある時_to給付実績基本_get公費情報_get公費１受給者番号は_設定値を返す() {
            assertThat(result.get公費情報().get公費１受給者番号(), is(公費１受給者番号));
        }

        @Test
        public void 公費２負担者番号の設定がある時_to給付実績基本_get公費情報_get公費２負担者番号は_設定値を返す() {
            assertThat(result.get公費情報().get公費２負担者番号(), is(公費２負担者番号));
        }

        @Test
        public void 公費２受給者番号の設定がある時_to給付実績基本_get公費情報_get公費２受給者番号は_設定値を返す() {
            assertThat(result.get公費情報().get公費２受給者番号(), is(公費２受給者番号));
        }

        @Test
        public void 公費３負担者番号の設定がある時_to給付実績基本_get公費情報_get公費３負担者番号は_設定値を返す() {
            assertThat(result.get公費情報().get公費３負担者番号(), is(公費３負担者番号));
        }

        @Test
        public void 公費３受給者番号の設定がある時_to給付実績基本_get公費情報_get公費３受給者番号は_設定値を返す() {
            assertThat(result.get公費情報().get公費３受給者番号(), is(公費３受給者番号));
        }
    }
}
