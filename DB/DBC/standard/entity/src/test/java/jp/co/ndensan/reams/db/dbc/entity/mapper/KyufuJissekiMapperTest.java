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
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKeyInfo;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiMeisai;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiShafukuKeigen;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiShukei;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KeikokuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KyufuSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3018KyufujissekiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3016KyufujissekiShuruiDetailEntity;
import jp.co.ndensan.reams.db.dbc.entity.helper.DbT3017KyufujissekiKihonEntityMock;
import jp.co.ndensan.reams.db.dbc.entity.helper.DbT3018KyufujissekiMeisaiEntityMock;
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
        private static final RString レコード種別コード = new RString("01");
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
            assertThat(result.get入力識別番号(), is(入力識別番号));
        }

        @Test
        public void レコード種別コードの設定がある時_to給付実績詳細キー_getレコード種別コードは_設定値を返す() {
            assertThat(result.getレコード種別コード(), is(レコード種別コード));
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

        @Before
        public void setUp() {
            result = KyufuJissekiMapper.to給付実績基本(DbT3017KyufujissekiKihonEntityMock.getSpiedInstance());
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
