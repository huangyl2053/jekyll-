/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.InputShikibetsuNo;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiDetailKeyInfo;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiJutakuKaishuhi;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKeyInfo;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKyotakuService;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiMeisai;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiShafukuKeigen;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiShukei;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiTokuteiNyushohi;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiYoguHanbaihi;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KeikokuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KyufuSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3018KyufujissekiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3025KyufujissekiKyotakuServiceEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3026KyufujissekiFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3027KyufujissekiJutakuKaishuhiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3016KyufujissekiShuruiDetailEntity;
import jp.co.ndensan.reams.db.dbc.entity.helper.DbT3017KyufujissekiKihonEntityMock;
import jp.co.ndensan.reams.db.dbc.entity.helper.DbT3018KyufujissekiMeisaiEntityMock;
import jp.co.ndensan.reams.db.dbc.entity.helper.DbT3025KyufujissekiKyotakuServiceEntityMock;
import jp.co.ndensan.reams.db.dbc.entity.helper.DbT3026KyufujissekiFukushiYoguHanbaihiEntityMock;
import jp.co.ndensan.reams.db.dbc.entity.helper.DbT3027KyufujissekiJutakuKaishuhiEntityMock;
import jp.co.ndensan.reams.db.dbc.entity.helper.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityMock;
import jp.co.ndensan.reams.db.dbc.entity.helper.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityMock;
import jp.co.ndensan.reams.db.dbc.entity.helper.DbT3033KyufujissekiShukeiEntityMock;
import jp.co.ndensan.reams.db.dbc.entity.helper.KyufujissekiShuruiDetailEntityGenerator;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ToshiNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 給付実績エンティティを給付実績情報に変換するMapperクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KyufuJissekiMapperTest extends DbcTestBase {

    public static class to給付実績詳細キー extends DbcTestBase {

        private KyufuJissekiDetailKeyInfo result;

        private static final KokanShikibetsuNo 交換情報識別番号 = new KokanShikibetsuNo(new RString("1137"));
        private static final InputShikibetsuNo 入力識別番号
                = new InputShikibetsuNo(new Code(new RString("7131")), new RString("居宅介護サービス"), new RString("居宅介護サービス"));
        private static final ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("00135985"));
        private static final KaigoHihokenshaNo 被保番号 = new KaigoHihokenshaNo(new RString("0000000019"));
        private static final ServiceTeikyoYM サービス提供年月 = new ServiceTeikyoYM(new FlexibleYearMonth("201407"));
        private static final JigyoshaNo 事業所番号 = new JigyoshaNo(new RString("1258743695"));
        private static final ToshiNo 通番 = new ToshiNo(new RString("568"));

        @Before
        public void setUp() {
            result = KyufuJissekiMapper.to給付実績詳細キー(createDbV3016KyufujissekiShuruiDetailEntityList(), create給付実績キー情報());
        }

        @Test
        public void 交換識別番号の設定がある時_to給付実績詳細キー_get交換識別番号は_設定値を返す() {
            assertThat(result.get交換情報識別番号(), is(交換情報識別番号));
        }

        @Test
        public void 入力識別番号の設定がある時_to給付実績詳細キー_get入力識別番号は_設定値を返す() {
            assertThat(result.get入力識別番号().getInputShikibetsuNoCode(), is(入力識別番号.getInputShikibetsuNoCode()));
        }

        @Test
        public void 証記載保険者番号の設定がある時_to給付実績詳細キー_get証記載保険者番号は_設定値を返す() {
            assertThat(result.get証記載保険者番号(), is(証記載保険者番号));
        }

        @Test
        public void 被保険者番号の設定がある時_to給付実績詳細キー_get被保険者番号は_設定値を返す() {
            assertThat(result.get被保番号(), is(被保番号));
        }

        @Test
        public void サービス提供年月の設定がある時_to給付実績詳細キー_getサービス提供年月は_設定値を返す() {
            assertThat(result.getサービス提供年月(), is(サービス提供年月));
        }

        @Test
        public void 事業者番号の設定がある時_to給付実績詳細キー_get事業者番号は_設定値を返す() {
            assertThat(result.get事業所番号(), is(事業所番号));
        }

        @Test
        public void 通番の設定がある時_to給付実績詳細キー_get通番は_設定値を返す() {
            assertThat(result.get通番(), is(通番));
        }
    }

    public static class to給付実績基本 extends DbcTestBase {

        private KyufuJissekiKihon result;

        private final Gender 性別 = Gender.FEMALE;
        private final FlexibleDate 生年月日 = new FlexibleDate("20010101");
        private final RString 整理番号 = new RString("0000000007");

        private final KyufuSakuseiKubun 作成区分 = KyufuSakuseiKubun.新規;
        private final RString 要介護度 = new RString("01");
        private final Range<FlexibleDate> 認定有効期間 = new Range<>(new FlexibleDate("20130701"), new FlexibleDate("20140630"));
        private final FlexibleYearMonth 審査年月 = new FlexibleYearMonth("201401");
        private final KeikokuKubun 警告区分 = KeikokuKubun.警告なし;

        private final RString 旧措置入所者特例 = new RString("1");
        private final RString 老人保健市町村番号 = new RString("00000001");
        private final RString 老人保健受給者番号 = new RString("0000001");
        private final RString 後期高齢保険者番号 = new RString("39000002");
        private final RString 後期高齢被保番号 = new RString("00000002");
        private final RString 国保保険者番号 = new RString("000003");
        private final RString 被保険者証番号 = new RString("00000004");
        private final RString 個人番号 = new RString("0000000005");

        private final RString 居宅サービス計画作成区分 = new RString("1");
        private final JigyoshaNo 事業所番号 = new JigyoshaNo(new RString("0000000001"));

        private final FlexibleDate 開始日 = new FlexibleDate("20140101");
        private final FlexibleDate 中止日 = new FlexibleDate("20140303");
        private final RString 中止理由 = new RString("2");

        private final FlexibleDate 入所日 = new FlexibleDate("20140101");
        private final FlexibleDate 退所日 = new FlexibleDate("20140202");
        private final int 入所実日数 = 10;
        private final int 外泊日数 = 30;
        private final RString 入所前の状況 = new RString("2");
        private final RString 退所後の状況 = new RString("3");

        private final HokenKyufuRitsu 保険 = new HokenKyufuRitsu(new Decimal(90));
        private final HokenKyufuRitsu 公費１ = new HokenKyufuRitsu(new Decimal(1));
        private final HokenKyufuRitsu 公費２ = new HokenKyufuRitsu(new Decimal(2));
        private final HokenKyufuRitsu 公費３ = new HokenKyufuRitsu(new Decimal(3));

        private final RString 公費１負担者番号 = new RString("00000001");
        private final RString 公費１受給者番号 = new RString("1000001");
        private final RString 公費２負担者番号 = new RString("00000002");
        private final RString 公費２受給者番号 = new RString("1000002");
        private final RString 公費３負担者番号 = new RString("00000003");
        private final RString 公費３受給者番号 = new RString("1000003");

        private final Decimal サービス単位 = new Decimal(100);
        private final Decimal 保険料請求額 = new Decimal(200);
        private final Decimal 利用者負担額 = new Decimal(300);
        private final Decimal 緊急時施設療養費保険請求分合計 = new Decimal(400);
        private final Decimal 特定診療費公費請求分合計 = new Decimal(500);
        private final Decimal 特定入所者介護等請求額 = new Decimal(600);

        @Before
        public void setUp() {
            result = KyufuJissekiMapper.to給付実績基本(DbT3017KyufujissekiKihonEntityMock.getSpiedInstance());
        }

        @Test
        public void 性別の設定がある時_to給付実績基本_get性別は_設定値を返す() {
            assertThat(result.get性別(), is(性別));
        }

        @Test
        public void 生年月日の設定がある時_to給付実績基本_get生年月日は_設定値を返す() {
            assertThat(result.get生年月日(), is(生年月日));
        }

        @Test
        public void 整理番号の設定がある時_to給付実績基本_get整理番号は_設定値を返す() {
            assertThat(result.get整理番号(), is(整理番号));
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

        @Test
        public void サービス単位の設定がある時_to給付実績基本_get合計_getサービス単位は_設定値を返す() {
            assertThat(result.get合計().iterator().next().getサービス単位(), is(サービス単位));
        }

        @Test
        public void 保険料請求額の設定がある時_to給付実績基本_get合計_get保険料請求額は_設定値を返す() {
            assertThat(result.get合計().iterator().next().get保険料請求額(), is(保険料請求額));
        }

        @Test
        public void 利用者負担額の設定がある時_to給付実績基本_get合計_get利用者負担額は_設定値を返す() {
            assertThat(result.get合計().iterator().next().get利用者負担額(), is(利用者負担額));
        }

        @Test
        public void 緊急時施設療養費保険請求分合計の設定がある時_to給付実績基本_get合計_get緊急時施設療養費保険請求分合計は_設定値を返す() {
            assertThat(result.get合計().iterator().next().get緊急時施設療養費保険請求分合計(), is(緊急時施設療養費保険請求分合計));
        }

        @Test
        public void 特定診療費公費請求分合計の設定がある時_to給付実績基本_get合計_get特定診療費公費請求分合計は_設定値を返す() {
            assertThat(result.get合計().iterator().next().get特定診療費公費請求分合計(), is(特定診療費公費請求分合計));
        }

        @Test
        public void 特定入所者介護等請求額の設定がある時_to給付実績基本_get合計_get特定入所者介護等請求額は_設定値を返す() {
            assertThat(result.get合計().iterator().next().get特定入所者介護等請求額(), is(特定入所者介護等請求額));
        }
    }

    public static class to給付実績明細List extends DbcTestBase {

        private KyufuJissekiMeisai result;

        private final RString サービス = new RString("11");
        private final RString 適要 = new RString("概要");
        private final int 単位 = 1000;
        private final int 回数日数 = 4;
        private final int 公費1日数 = 1;
        private final int 公費2日数 = 2;
        private final int 公費3日数 = 3;
        private final int サービス単位 = 1500;
        private final int 公費1単位 = 1;
        private final int 公費2単位 = 2;
        private final int 公費3単位 = 3;
        private final int 再審査回数 = 1500;
        private final int 過誤回数 = 2;
        private final FlexibleYearMonth 審査年月 = new FlexibleYearMonth("201402");

        @Before
        public void setUp() {
            List<DbT3018KyufujissekiMeisaiEntity> entities = new ArrayList<>();
            entities.add(DbT3018KyufujissekiMeisaiEntityMock.getSpiedInstance());
            result = KyufuJissekiMapper.to給付実績明細List(entities).iterator().next();
        }

        @Test
        public void サービスの設定がある時_to給付実績明細List_getサービスは_設定値を返す() {
            assertThat(result.getサービス(), is(サービス));
        }

        @Test
        public void 単位の設定がある時_to給付実績明細List_get単位は_設定値を返す() {
            assertThat(result.get単位(), is(new Decimal(単位)));
        }

        @Test
        public void 適要の設定がある時_to給付実績明細List_get適要は_設定値を返す() {
            assertThat(result.get適要(), is(適要));
        }

        @Test
        public void 回数日数の設定がある時_to給付実績明細List_get回数日数は_設定値を返す() {
            assertThat(result.get回数日数(), is(回数日数));
        }

        @Test
        public void 公費1日数の設定がある時_to給付実績明細List_get公費1日数は_設定値を返す() {
            assertThat(result.get公費1日数(), is(公費1日数));
        }

        @Test
        public void 公費2日数の設定がある時_to給付実績明細List_get公費2日数は_設定値を返す() {
            assertThat(result.get公費2日数(), is(公費2日数));
        }

        @Test
        public void 公費3日数の設定がある時_to給付実績明細List_get公費3日数は_設定値を返す() {
            assertThat(result.get公費3日数(), is(公費3日数));
        }

        @Test
        public void サービス単位の設定がある時_to給付実績明細List_getサービス単位は_設定値を返す() {
            assertThat(result.getサービス単位(), is(new Decimal(サービス単位)));
        }

        @Test
        public void 公費1単位の設定がある時_to給付実績明細List_get公費1単位は_設定値を返す() {
            assertThat(result.get公費1単位(), is(公費1単位));
        }

        @Test
        public void 公費2単位の設定がある時_to給付実績明細List_get公費2単位は_設定値を返す() {
            assertThat(result.get公費2単位(), is(公費2単位));
        }

        @Test
        public void 公費3単位の設定がある時_to給付実績明細List_get公費3単位は_設定値を返す() {
            assertThat(result.get公費3単位(), is(公費3単位));
        }

        @Test
        public void 再審査回数の設定がある時_to給付実績明細List_get再審査回数は_設定値を返す() {
            assertThat(result.get再審査回数(), is(再審査回数));
        }

        @Test
        public void 過誤回数の設定がある時_to給付実績明細List_get過誤回数は_設定値を返す() {
            assertThat(result.get過誤回数(), is(過誤回数));
        }

        @Test
        public void 審査年月の設定がある時_to給付実績明細List_get審査年月は_設定値を返す() {
            assertThat(result.get審査年月(), is(審査年月));
        }
    }

    public static class to給付実績集計List extends DbcTestBase {

        private KyufuJissekiShukei result;

        private static final RString 種類 = new RString("11");
        private static final int 実日数 = 1;
        private static final Decimal 計画単位 = new Decimal(200);
        private static final Decimal 対象単位 = new Decimal(300);
        private static final Decimal 対象外単位 = new Decimal(400);
        private static final int 短計画日数 = 5;
        private static final int 短実日数 = 6;
        private static final Decimal 単位合計 = new Decimal(100);
        private static final Decimal 請求額 = new Decimal(102);
        private static final Decimal 出来高単位合計 = new Decimal(104);
        private static final Decimal 出来高請求 = new Decimal(105);
        private static final Decimal 出来高本人負担額 = new Decimal(106);
        private static final int 再審査回数 = 12;
        private static final int 過誤回数 = 13;
        private static final FlexibleYearMonth 審査年月 = new FlexibleYearMonth("201402");

        @Before
        public void setUp() {
            List<DbT3033KyufujissekiShukeiEntity> entities = new ArrayList<>();
            entities.add(DbT3033KyufujissekiShukeiEntityMock.getSpiedInstance());
            result = KyufuJissekiMapper.to給付実績集計List(entities).iterator().next();
        }

        @Test
        public void 種類の設定がある時_to給付実績集計List_get種類は_設定値を返す() {
            assertThat(result.get種類(), is(種類));
        }

        @Test
        public void 実日数の設定がある時_to給付実績集計List_get実日数は_設定値を返す() {
            assertThat(result.get実日数(), is(実日数));
        }

        @Test
        public void 計画単位の設定がある時_to給付実績集計List_get計画単位は_設定値を返す() {
            assertThat(result.get計画単位(), is(計画単位));
        }

        @Test
        public void 対象単位の設定がある時_to給付実績集計List_get対象単位は_設定値を返す() {
            assertThat(result.get対象単位(), is(対象単位));
        }

        @Test
        public void 対象外単位の設定がある時_to給付実績集計List_get対象外単位は_設定値を返す() {
            assertThat(result.get対象外単位(), is(対象外単位));
        }

        @Test
        public void 短計画日数の設定がある時_to給付実績集計List_get短計画日数は_設定値を返す() {
            assertThat(result.get短計画日数(), is(短計画日数));
        }

        @Test
        public void 短実日数の設定がある時_to給付実績集計List_get短実日数は_設定値を返す() {
            assertThat(result.get短実日数(), is(短実日数));
        }

        @Test
        public void 単位合計の設定がある時_to給付実績集計List_get単位合計は_設定値を返す() {
            assertThat(result.get単位合計(), is(単位合計));
        }

        @Test
        public void 請求額の設定がある時_to給付実績集計List_get請求額は_設定値を返す() {
            assertThat(result.get請求額(), is(請求額));
        }

        @Test
        public void 出来高単位合計の設定がある時_to給付実績集計List_get出来高単位合計は_設定値を返す() {
            assertThat(result.get出来高単位合計(), is(出来高単位合計));
        }

        @Test
        public void 出来高請求の設定がある時_to給付実績集計List_get出来高請求は_設定値を返す() {
            assertThat(result.get出来高請求(), is(出来高請求));
        }

        @Test
        public void 出来高本人負担額の設定がある時_to給付実績集計List_get出来高本人負担額は_設定値を返す() {
            assertThat(result.get出来高本人負担額(), is(出来高本人負担額));
        }

        @Test
        public void 再審査回数の設定がある時_to給付実績集計List_get再審査回数は_設定値を返す() {
            assertThat(result.get再審査回数(), is(再審査回数));
        }

        @Test
        public void 過誤回数の設定がある時_to給付実績集計List_get過誤回数は_設定値を返す() {
            assertThat(result.get過誤回数(), is(過誤回数));
        }

        @Test
        public void 審査年月の設定がある時_to給付実績集計List_get審査年月は_設定値を返す() {
            assertThat(result.get審査年月(), is(審査年月));
        }
    }

    public static class to給付実績社会福祉法人軽減額List extends DbcTestBase {

        private KyufuJissekiShafukuKeigen result;

        private static final RString 軽減率 = new RString("10");
        private static final RString 種類 = new RString("01");
        private static final Decimal 受領すべき利用者負担の総額 = new Decimal(200);
        private static final Decimal 軽減額 = new Decimal(300);
        private static final Decimal 軽減後利用者負担額 = new Decimal(400);
        private static final RString 備考 = new RString("備考");
        private static final int 再審査回数 = 5;
        private static final int 過誤回数 = 6;
        private static final FlexibleYearMonth 審査年月 = new FlexibleYearMonth("201402");

        @Before
        public void setUp() {
            List<DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity> entities = new ArrayList<>();
            entities.add(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityMock.getSpiedInstance());
            result = KyufuJissekiMapper.to給付実績社会福祉法人軽減額List(entities).iterator().next();
        }

        @Test
        public void 軽減率の設定がある時_to給付実績社会福祉法人軽減額List_get軽減率は_設定値を返す() {
            assertThat(result.get軽減率(), is(軽減率));
        }

        @Test
        public void 種類の設定がある時_to給付実績社会福祉法人軽減額List_get種類は_設定値を返す() {
            assertThat(result.get種類(), is(種類));
        }

        @Test
        public void 受領すべき利用者負担の総額の設定がある時_to給付実績社会福祉法人軽減額List_get受領すべき利用者負担の総額は_設定値を返す() {
            assertThat(result.get受領すべき利用者負担の総額(), is(受領すべき利用者負担の総額));
        }

        @Test
        public void 軽減額の設定がある時_to給付実績社会福祉法人軽減額List_get軽減額は_設定値を返す() {
            assertThat(result.get軽減額(), is(軽減額));
        }

        @Test
        public void 軽減後利用者負担額の設定がある時_to給付実績社会福祉法人軽減額List_get軽減後利用者負担額は_設定値を返す() {
            assertThat(result.get軽減後利用者負担額(), is(軽減後利用者負担額));
        }

        @Test
        public void 備考の設定がある時_to給付実績社会福祉法人軽減額List_get備考は_設定値を返す() {
            assertThat(result.get備考(), is(備考));
        }

        @Test
        public void 再審査回数の設定がある時_to給付実績社会福祉法人軽減額List_get再審査回数は_設定値を返す() {
            assertThat(result.get再審査回数(), is(再審査回数));
        }

        @Test
        public void 過誤回数の設定がある時_to給付実績社会福祉法人軽減額List_get過誤回数は_設定値を返す() {
            assertThat(result.get過誤回数(), is(過誤回数));
        }

        @Test
        public void 審査年月の設定がある時_to給付実績社会福祉法人軽減額List_get審査年月は_設定値を返す() {
            assertThat(result.get審査年月(), is(審査年月));
        }
    }

    public static class to給付実績サービス計画費List extends DbcTestBase {

        private KyufuJissekiKyotakuService result;

        private static final RString 指定基準区分 = new RString("1");
        private static final FlexibleDate 届出日 = new FlexibleDate("20120101");
        private static final RString サービス = new RString("2");
        private static final Decimal 単位数単価 = new Decimal("2340");
        private static final Decimal 単位数 = new Decimal(3);
        private static final Integer 回数 = new Integer(2);
        private static final Decimal サービス単位数 = new Decimal(3);
        private static final Decimal 請求金額 = null;
        private static final RString 専門員番号 = new RString("87654321");
        private static final Integer 再審査回数 = new Integer(10);
        private static final Integer 過誤回数 = new Integer(9);
        private static final FlexibleYearMonth 審査年月 = new FlexibleYearMonth("201202");
        private static final RString 摘要 = new RString("てきようじょうほうてきすと");

        @Before
        public void setUp() {
            List<DbT3025KyufujissekiKyotakuServiceEntity> entities = new ArrayList<>();
            entities.add(DbT3025KyufujissekiKyotakuServiceEntityMock.getSpiedInstance());
            result = KyufuJissekiMapper.to給付実績サービス計画費List(entities).iterator().next();
        }

        @Test
        public void 指定基準区分の設定がある時_to給付実績サービス計画費List_get指定基準区分は_設定値を返す() {
            assertThat(result.get指定基準区分(), is(指定基準区分));
        }

        @Test
        public void 届出日の設定がある時_to給付実績サービス計画費List_get届出日は_設定値を返す() {
            assertThat(result.get届出日(), is(届出日));
        }

        @Test
        public void サービスの設定がある時_to給付実績サービス計画費List_getサービスは_設定値を返す() {
            assertThat(result.getサービス(), is(サービス));
        }

        @Test
        public void 単位数単価の設定がある時_to給付実績サービス計画費List_get単位数単価は_設定値を返す() {
            assertThat(result.get単位数単価(), is(単位数単価));
        }

        @Test
        public void 単位数の設定がある時_to給付実績サービス計画費List_get単位数は_設定値を返す() {
            assertThat(result.get単位数(), is(単位数));
        }

        @Test
        public void 回数の設定がある時_to給付実績サービス計画費List_get回数は_設定値を返す() {
            assertThat(result.get回数(), is(回数));
        }

        @Test
        public void サービス単位数の設定がある時_to給付実績サービス計画費List_getサービス単位数は_設定値を返す() {
            assertThat(result.getサービス単位数(), is(サービス単位数));
        }

        @Test
        public void 請求金額の設定がある時_to給付実績サービス計画費List_get請求金額は_設定値を返す() {
            assertThat(result.get請求金額(), is(請求金額));
        }

        @Test
        public void 専門員番号の設定がある時_to給付実績サービス計画費List_get専門員番号は_設定値を返す() {
            assertThat(result.get専門員番号(), is(専門員番号));
        }

        @Test
        public void 再審査回数の設定がある時_to給付実績サービス計画費List_get再審査回数は_設定値を返す() {
            assertThat(result.get再審査回数(), is(再審査回数));
        }

        @Test
        public void 過誤回数の設定がある時_to給付実績サービス計画費List_get過誤回数は_設定値を返す() {
            assertThat(result.get過誤回数(), is(過誤回数));
        }

        @Test
        public void 審査年月の設定がある時_to給付実績サービス計画費List_get審査年月は_設定値を返す() {
            assertThat(result.get審査年月(), is(審査年月));
        }

        @Test
        public void 摘要の設定がある時_to給付実績サービス計画費List_get摘要は_設定値を返す() {
            assertThat(result.get摘要(), is(摘要));
        }
    }

    public static class to給付実績福祉用具購入費List extends DbcTestBase {

        private KyufuJissekiYoguHanbaihi result;

        private static final RString サービス = new RString("000007");
        private static final FlexibleDate 購入日 = new FlexibleDate("20140201");
        private static final RString 商品名 = new RString("福祉用具商品名");
        private static final RString 種目 = new RString("08");
        private static final RString 製造事業者名 = new RString("福祉用具製造事業者名");
        private static final RString 販売事業者名 = new RString("福祉用具販売事業者名");
        private static final Decimal 購入金額 = new Decimal(1234);
        private static final FlexibleYearMonth 審査年月 = new FlexibleYearMonth("201403");
        private static final RString 摘要 = new RString("適用１２３４５６７８９０");

        @Before
        public void setUp() {
            List<DbT3026KyufujissekiFukushiYoguHanbaihiEntity> entities = new ArrayList<>();
            entities.add(DbT3026KyufujissekiFukushiYoguHanbaihiEntityMock.getSpiedInstance());
            result = KyufuJissekiMapper.to給付実績福祉用具購入費List(entities).iterator().next();
        }

        @Test
        public void サービスの設定がある時_to給付実績福祉用具購入費List_getサービスは_設定値を返す() {
            assertThat(result.getサービス(), is(サービス));
        }

        @Test
        public void 購入日の設定がある時_to給付実績福祉用具購入費List_get購入日は_設定値を返す() {
            assertThat(result.get購入日(), is(購入日));
        }

        @Test
        public void 商品名の設定がある時_to給付実績福祉用具購入費List_get商品名は_設定値を返す() {
            assertThat(result.get商品名(), is(商品名));
        }

        @Test
        public void 種目の設定がある時_to給付実績福祉用具購入費List_get種目は_設定値を返す() {
            assertThat(result.get種目(), is(種目));
        }

        @Test
        public void 製造事業者名の設定がある時_to給付実績福祉用具購入費List_get製造事業者名は_設定値を返す() {
            assertThat(result.get製造事業者名(), is(製造事業者名));
        }

        @Test
        public void 販売事業者名の設定がある時_to給付実績福祉用具購入費List_get販売事業者名は_設定値を返す() {
            assertThat(result.get販売事業者名(), is(販売事業者名));
        }

        @Test
        public void 購入金額の設定がある時_to給付実績福祉用具購入費List_get購入金額は_設定値を返す() {
            assertThat(result.get購入金額(), is(購入金額));
        }

        @Test
        public void 審査年月の設定がある時_to給付実績福祉用具購入費List_get審査年月は_設定値を返す() {
            assertThat(result.get審査年月(), is(審査年月));
        }

        @Test
        public void 摘要の設定がある時_to給付実績福祉用具購入費List_get摘要は_設定値を返す() {
            assertThat(result.get摘要(), is(摘要));
        }
    }

    public static class to給付実績住宅改修費List extends DbcTestBase {

        private KyufuJissekiJutakuKaishuhi result;

        private static final RString サービス = new RString("000007");
        private static final FlexibleDate 着工日 = new FlexibleDate("20140201");
        private static final RString 事業者名 = new RString("住宅改修事業者名");
        private static final RString 改修先住所 = new RString("住宅改修住宅住所");
        private static final Decimal 改修費用 = new Decimal(1234);
        private static final FlexibleYearMonth 審査年月 = new FlexibleYearMonth("201403");

        @Before
        public void setUp() {
            List<DbT3027KyufujissekiJutakuKaishuhiEntity> entities = new ArrayList<>();
            entities.add(DbT3027KyufujissekiJutakuKaishuhiEntityMock.getSpiedInstance());
            result = KyufuJissekiMapper.to給付実績住宅改修費List(entities).iterator().next();
        }

        @Test
        public void サービスの設定がある時_to給付実績住宅改修費List_getサービスは_設定値を返す() {
            assertThat(result.getサービス(), is(サービス));
        }

        @Test
        public void 着工日の設定がある時_to給付実績住宅改修費List_get着工日は_設定値を返す() {
            assertThat(result.get着工日(), is(着工日));
        }

        @Test
        public void 事業者名の設定がある時_to給付実績住宅改修費List_get事業者名は_設定値を返す() {
            assertThat(result.get事業者名(), is(事業者名));
        }

        @Test
        public void 改修先住所の設定がある時_to給付実績住宅改修費List_get改修先住所は_設定値を返す() {
            assertThat(result.get改修先住所(), is(改修先住所));
        }

        @Test
        public void 改修費用の設定がある時_to給付実績住宅改修費List_get改修費用は_設定値を返す() {
            assertThat(result.get改修費用(), is(改修費用));
        }

        @Test
        public void 審査年月の設定がある時_to給付実績住宅改修費List_get審査年月は_設定値を返す() {
            assertThat(result.get審査年月(), is(審査年月));
        }
    }

    public static class to給付実績特定入所者費用List extends DbcTestBase {

        private KyufuJissekiTokuteiNyushohi result;

        private static final RString サービス = new RString("123456");
        private static final Decimal 負担限度額 = new Decimal(100);
        private static final Decimal 費用単価 = new Decimal(110);
        private static final Integer 日数 = new Integer(10);
        private static final Decimal 費用額 = new Decimal(120);
        private static final Decimal 請求額 = new Decimal(130);
        private static final Decimal 利用者負担額 = new Decimal(140);
        private static final Integer 公費1日数 = new Integer(11);
        private static final Decimal 公費1負担額 = new Decimal(150);
        private static final Decimal 公費1請求額 = null;
        private static final Decimal 公費1本人負担額 = null;
        private static final Integer 公費2日数 = new Integer(12);
        private static final Decimal 公費2負担額 = new Decimal(180);
        private static final Decimal 公費2請求額 = null;
        private static final Decimal 公費2本人負担額 = null;
        private static final Integer 公費3日数 = new Integer(13);
        private static final Decimal 公費3負担額 = new Decimal(210);
        private static final Decimal 公費3請求額 = null;
        private static final Decimal 公費3本人負担額 = null;
        private static final Integer 再審査回数 = new Integer(14);
        private static final Integer 過誤回数 = new Integer(15);
        private static final FlexibleYearMonth 審査年月 = new FlexibleYearMonth("201401");

        @Before
        public void setUp() {
            List<DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity> entities = new ArrayList<>();
            entities.add(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityMock.getSpiedInstance());
            result = KyufuJissekiMapper.to給付実績特定入所者費用List(entities).iterator().next();
        }

        @Test
        public void サービスの設定がある時_to給付実績特定入所者費用List_getサービスは_設定値を返す() {
            assertThat(result.getサービス(), is(サービス));
        }

        @Test
        public void 負担限度額の設定がある時_to給付実績特定入所者費用List_get負担限度額は_設定値を返す() {
            assertThat(result.get負担限度額(), is(負担限度額));
        }

        @Test
        public void 費用単価の設定がある時_to給付実績特定入所者費用List_get費用単価は_設定値を返す() {
            assertThat(result.get費用単価(), is(費用単価));
        }

        @Test
        public void 日数の設定がある時_to給付実績特定入所者費用List_get日数は_設定値を返す() {
            assertThat(result.get日数(), is(日数));
        }

        @Test
        public void 費用額の設定がある時_to給付実績特定入所者費用List_get費用額は_設定値を返す() {
            assertThat(result.get費用額(), is(費用額));
        }

        @Test
        public void 請求額の設定がある時_to給付実績特定入所者費用List_get請求額は_設定値を返す() {
            assertThat(result.get請求額(), is(請求額));
        }

        @Test
        public void 利用者負担額の設定がある時_to給付実績特定入所者費用List_get利用者負担額は_設定値を返す() {
            assertThat(result.get利用者負担額(), is(利用者負担額));
        }

        @Test
        public void 公費1日数の設定がある時_to給付実績特定入所者費用List_get公費1日数は_設定値を返す() {
            assertThat(result.get公費1日数(), is(公費1日数));
        }

        @Test
        public void 公費1負担額の設定がある時_to給付実績特定入所者費用List_get公費1負担額は_設定値を返す() {
            assertThat(result.get公費1負担額(), is(公費1負担額));
        }

        @Test
        public void 公費1請求額の設定がある時_to給付実績特定入所者費用List_get公費1請求額は_設定値を返す() {
            assertThat(result.get公費1請求額(), is(公費1請求額));
        }

        @Test
        public void 公費1本人負担額の設定がある時_to給付実績特定入所者費用List_get公費1本人負担額は_設定値を返す() {
            assertThat(result.get公費1本人負担額(), is(公費1本人負担額));
        }

        @Test
        public void 公費2日数の設定がある時_to給付実績特定入所者費用List_get公費2日数は_設定値を返す() {
            assertThat(result.get公費2日数(), is(公費2日数));
        }

        @Test
        public void 公費2負担額の設定がある時_to給付実績特定入所者費用List_get公費2負担額は_設定値を返す() {
            assertThat(result.get公費2負担額(), is(公費2負担額));
        }

        @Test
        public void 公費2請求額の設定がある時_to給付実績特定入所者費用List_get公費2請求額は_設定値を返す() {
            assertThat(result.get公費2請求額(), is(公費2請求額));
        }

        @Test
        public void 公費2本人負担額の設定がある時_to給付実績特定入所者費用List_get公費2本人負担額は_設定値を返す() {
            assertThat(result.get公費2本人負担額(), is(公費2本人負担額));
        }

        @Test
        public void 公費3日数の設定がある時_to給付実績特定入所者費用List_get公費3日数は_設定値を返す() {
            assertThat(result.get公費3日数(), is(公費3日数));
        }

        @Test
        public void 公費3負担額の設定がある時_to給付実績特定入所者費用List_get公費3負担額は_設定値を返す() {
            assertThat(result.get公費3負担額(), is(公費3負担額));
        }

        @Test
        public void 公費3請求額の設定がある時_to給付実績特定入所者費用List_get公費3請求額は_設定値を返す() {
            assertThat(result.get公費3請求額(), is(公費3請求額));
        }

        @Test
        public void 公費3本人負担額の設定がある時_to給付実績特定入所者費用List_get公費3本人負担額は_設定値を返す() {
            assertThat(result.get公費3本人負担額(), is(公費3本人負担額));
        }

        @Test
        public void 再審査回数の設定がある時_to給付実績特定入所者費用List_get再審査回数は_設定値を返す() {
            assertThat(result.get再審査回数(), is(再審査回数));
        }

        @Test
        public void 過誤回数の設定がある時_to給付実績特定入所者費用List_get過誤回数は_設定値を返す() {
            assertThat(result.get過誤回数(), is(過誤回数));
        }

        @Test
        public void 審査年月の設定がある時_to給付実績特定入所者費用List_get審査年月は_設定値を返す() {
            assertThat(result.get審査年月(), is(審査年月));
        }
    }

    private static List<DbV3016KyufujissekiShuruiDetailEntity> createDbV3016KyufujissekiShuruiDetailEntityList() {
        DbV3016KyufujissekiShuruiDetailEntity entity = KyufujissekiShuruiDetailEntityGenerator.createDbV3016KyufujissekiShuruiDetailEntity();
        List<DbV3016KyufujissekiShuruiDetailEntity> list = new ArrayList<>();
        list.add(entity);
        return list;
    }

    private static KyufuJissekiKeyInfo create給付実績キー情報() {
        return new KyufuJissekiKeyInfo(
                new KaigoHihokenshaNo(new RString("0000000019")),
                new Range<>(new ServiceTeikyoYM(new FlexibleYearMonth("201401")), new ServiceTeikyoYM(new FlexibleYearMonth("201412"))),
                new InputShikibetsuNo(new Code(new RString("7131")), new RString("居宅介護サービス"), new RString("居宅介護サービス")),
                new ServiceShuruiCode(new RString("11")),
                new ServiceTeikyoYM(new FlexibleYearMonth("201407")));
    }
}
