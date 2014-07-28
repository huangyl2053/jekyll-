/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.KyotakuServiceSeikyuKingakuJoho;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKyotakuService;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKyotakuServiceList;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3025KyufujissekiKyotakuServiceEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 給付実績resultMapperのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class KyufuJissekiKyotakuServiceMapperTest {

    private static KokanShikibetsuNo 交換情報識別コード;
    private static NyuryokuShikibetsuNo 入力識別コード;
    private static RString レコード種別コード;
    private static ShoKisaiHokenshaNo 証記載保険者番号;
    private static KaigoHihokenshaNo 被保険者番号;
    private static FlexibleYearMonth サービス適用年月;
    private static JigyoshaNo 事業者番号;
    private static RString 通し番号;
    private static RString 指定基準該当等事業者区分コード;
    private static FlexibleDate 居宅サービス作成依頼年月日;
    private static RString サービス計画費明細行番号;
    private static Decimal 単位数単価;
    private static ServiceCode サービスコード;
    private static int 単位数;
    private static int 回数;
    private static int サービス単位数;
    private static int サービス単位数合計;
    private static int 請求金額;
    private static KyotakuServiceSeikyuKingakuJoho 請求金額情報;
    private static RString 担当介護支援専門員番号;
    private static RString 摘要;
    private static int 後単位数;
    private static int 後回数;
    private static int 後サービス単位数;
    private static int 後サービス単位数合計;
    private static int 後請求金額;
    private static KyotakuServiceSeikyuKingakuJoho 後請求金額情報;
    private static int 再審査回数;
    private static int 過誤回数;
    private static FlexibleYearMonth 審査年月;
    private static RString 整理番号;
    private static FlexibleYearMonth 取込年月;

    @BeforeClass
    public static void setUpBeforeClass() {

        交換情報識別コード = new KokanShikibetsuNo(new RString("0001"));
        入力識別コード = new NyuryokuShikibetsuNo(new RString("0101"));
        レコード種別コード = new RString("01");
        証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("001023"));
        被保険者番号 = new KaigoHihokenshaNo(new RString("2010100001"));
        サービス適用年月 = new FlexibleYearMonth("201204");
        事業者番号 = new JigyoshaNo(new RString("01230001"));
        通し番号 = new RString("1000054001");
        指定基準該当等事業者区分コード = new RString("1");
        居宅サービス作成依頼年月日 = new FlexibleDate("20120101");
        サービス計画費明細行番号 = new RString("45");
        単位数単価 = new Decimal("2340");
        サービスコード = new ServiceCode(new RString("2"));
        単位数 = 3;
        回数 = 2;
        サービス単位数 = 3;
        サービス単位数合計 = 6;
        請求金額 = 34000;
        請求金額情報 = new KyotakuServiceSeikyuKingakuJoho(単位数, 回数, サービス単位数, サービス単位数合計, 請求金額);
        担当介護支援専門員番号 = new RString("87654321");
        摘要 = new RString("てきようじょうほうてきすと");
        後単位数 = 2;
        後回数 = 3;
        後サービス単位数 = 5;
        後サービス単位数合計 = 7;
        後請求金額 = 42000;
        後請求金額情報 = new KyotakuServiceSeikyuKingakuJoho(後単位数, 後回数, 後サービス単位数, 後サービス単位数合計, 後請求金額);
        再審査回数 = 10;
        過誤回数 = 9;
        審査年月 = new FlexibleYearMonth("201202");
        整理番号 = new RString("0000000001");
        取込年月 = new FlexibleYearMonth("201203");
    }

    public static class to給付実績居宅サービスEntityのテスト extends DbcTestBase {

        private DbT3025KyufujissekiKyotakuServiceEntity result;
        private KyufuJissekiKyotakuService 居宅サービス;

        @Before
        public void setUp() {
            居宅サービス = create給付実績居宅サービス();
            result = KyufuJissekiKyotakuServiceMapper.to給付実績居宅サービスEntity(居宅サービス);
        }

        @Test
        public void 引数にnullを渡した場合_nullを返す() {
            result = KyufuJissekiKyotakuServiceMapper.to給付実績居宅サービスEntity(null);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 給付実績居宅サービスの交換情報識別コードと_変換後のentityが持つKokanJohoShikibetsuNoが一致する() {
            assertThat(result.getKokanJohoShikibetsuNo(), is(居宅サービス.get交換情報識別コード()));
        }

        @Test
        public void 給付実績居宅サービスの入力識別コードと_変換後のentityが持つInputShikibetsuNoが一致する() {
            assertThat(result.getInputShikibetsuNo(), is(居宅サービス.get入力識別コード()));
        }

        @Test
        public void 給付実績居宅サービスのレコード種別コードと_変換後のentityが持つRecodeShubetsuCodeが一致する() {
            assertThat(result.getRecodeShubetsuCode(), is(居宅サービス.getレコード種別コード()));
        }

        @Test
        public void 給付実績居宅サービスの証記載保険者番号と_変換後のentityが持つShokisaiHokenshaNoが一致する() {
            assertThat(result.getShokisaiHokenshaNo(), is(居宅サービス.get証記載保険者番号()));
        }

        @Test
        public void 給付実績居宅サービスの被保険者番号と_変換後のentityが持つHiHokenshaNoが一致する() {
            assertThat(result.getHiHokenshaNo(), is(居宅サービス.get被保険者番号()));
        }

        @Test
        public void 給付実績居宅サービスのサービス適用年月と_変換後のentityが持つServiceTeikyoYMが一致する() {
            assertThat(result.getServiceTeikyoYM(), is(居宅サービス.getサービス適用年月()));
        }

        @Test
        public void 給付実績居宅サービスの事業者番号と_変換後のentityが持つJigyoshoNoが一致する() {
            assertThat(result.getJigyoshoNo(), is(居宅サービス.get事業者番号()));
        }

        @Test
        public void 給付実績居宅サービスの通し番号と_変換後のentityが持つToshiNoが一致する() {
            assertThat(result.getToshiNo(), is(居宅サービス.get通し番号()));
        }

        @Test
        public void 給付実績居宅サービスの指定基準該当等事業者区分コードと_変換後のentityが持つShiteiKijunGaitoJigyoshaKubunCodeが一致する() {
            assertThat(result.getShiteiKijunGaitoJigyoshaKubunCode(), is(居宅サービス.get指定基準該当等事業者区分コード()));
        }

        @Test
        public void 給付実績居宅サービスの単位数単価と_変換後のentityが持つTanisuTankaが一致する() {
            assertThat(result.getTanisuTanka(), is(居宅サービス.get単位数単価()));
        }

        @Test
        public void 給付実績居宅サービスの居宅サービス作成依頼年月日と_変換後のentityが持つKyotakuServiceSakuseiIraiYMDが一致する() {
            assertThat(result.getKyotakuServiceSakuseiIraiYMD(), is(居宅サービス.get居宅サービス作成依頼年月日()));
        }

        @Test
        public void 給付実績居宅サービスのサービス計画費明細行番号と_変換後のentityが持つServicePlanhiMeisaiLineNoが一致する() {
            assertThat(result.getServicePlanhiMeisaiLineNo(), is(居宅サービス.getサービス計画費明細行番号()));
        }

        @Test
        public void 給付実績居宅サービスのサービスコードと_変換後のentityが持つServiceCodeが一致する() {
            assertThat(result.getServiceCode(), is(居宅サービス.getサービスコード()));
        }

        @Test
        public void 給付実績居宅サービスの単位数と_変換後のentityが持つTanisuが一致する() {
            assertThat(result.getTanisu(), is(居宅サービス.get請求金額情報().get単位数()));
        }

        @Test
        public void 給付実績居宅サービスの回数と_変換後のentityが持つKaisuが一致する() {
            assertThat(result.getKaisu(), is(居宅サービス.get請求金額情報().get回数()));
        }

        @Test
        public void 給付実績居宅サービスのサービス単位数と_変換後のentityが持つServiceTanisuが一致する() {
            assertThat(result.getServiceTanisu(), is(居宅サービス.get請求金額情報().getサービス単位数()));
        }

        @Test
        public void 給付実績居宅サービスのサービス単位数合計と_変換後のentityが持つServiceTanisuTotalが一致する() {
            assertThat(result.getServiceTanisuTotal(), is(居宅サービス.get請求金額情報().getサービス単位数合計()));
        }

        @Test
        public void 給付実績居宅サービスの請求金額と_変換後のentityが持つSeikyuKingakuが一致する() {
            assertThat(result.getSeikyuKingaku(), is(居宅サービス.get請求金額情報().get請求金額()));
        }

        @Test
        public void 給付実績居宅サービスの担当介護支援専門員番号と_変換後のentityが持つTantouKaigoShienSemmoninNoが一致する() {
            assertThat(result.getTantouKaigoShienSemmoninNo(), is(居宅サービス.get担当介護支援専門員番号()));
        }

        @Test
        public void 給付実績居宅サービスの摘要と_変換後のentityが持つTekiyoが一致する() {
            assertThat(result.getTekiyo(), is(居宅サービス.get摘要()));
        }

        @Test
        public void 給付実績居宅サービスの後単位数と_変換後のentityが持つAtoTanisuが一致する() {
            assertThat(result.getAtoTanisu(), is(居宅サービス.get後請求金額情報().get単位数()));
        }

        @Test
        public void 給付実績居宅サービスの後回数と_変換後のentityが持つAtoKaisuが一致する() {
            assertThat(result.getAtoKaisu(), is(居宅サービス.get後請求金額情報().get回数()));
        }

        @Test
        public void 給付実績居宅サービスの後サービス単位数と_変換後のentityが持つAtoServiceTanisuが一致する() {
            assertThat(result.getAtoServiceTanisu(), is(居宅サービス.get後請求金額情報().getサービス単位数()));
        }

        @Test
        public void 給付実績居宅サービスの後サービス単位数合計と_変換後のentityが持つAtoServiceTanisuTotalが一致する() {
            assertThat(result.getAtoServiceTanisuTotal(), is(居宅サービス.get後請求金額情報().getサービス単位数合計()));
        }

        @Test
        public void 給付実績居宅サービスの後請求金額と_変換後のentityが持つAtoSeikyuKingakuが一致する() {
            assertThat(result.getAtoSeikyuKingaku(), is(居宅サービス.get後請求金額情報().get請求金額()));
        }

        @Test
        public void 給付実績居宅サービスの再審査回数と_変換後のentityが持つSaishinsaKaisuが一致する() {
            assertThat(result.getSaishinsaKaisu(), is(居宅サービス.get再審査回数()));
        }

        @Test
        public void 給付実績居宅サービスの過誤回数と_変換後のentityが持つKagoKaisuが一致する() {
            assertThat(result.getKagoKaisu(), is(居宅サービス.get過誤回数()));
        }

        @Test
        public void 給付実績居宅サービスの審査年月と_変換後のentityが持つShinsaYMが一致する() {
            assertThat(result.getShinsaYM(), is(居宅サービス.get審査年月()));
        }

        @Test
        public void 給付実績居宅サービスの整理番号と_変換後のentityが持つSeiriNoが一致する() {
            assertThat(result.getSeiriNo(), is(居宅サービス.get整理番号()));
        }

        @Test
        public void 給付実績居宅サービスの取込年月と_変換後のentityが持つTorikomiYMが一致する() {
            assertThat(result.getTorikomiYM(), is(居宅サービス.get取込年月()));
        }
    }

    public static class to給付実績居宅サービスEntityListのテスト extends DbcTestBase {

        private List<DbT3025KyufujissekiKyotakuServiceEntity> result;

        @Test
        public void 引数にnullが渡されたとき_空のListが返る() {
            result = KyufuJissekiKyotakuServiceMapper.to給付実績居宅サービスEntityList(null);
            assertThat(result.size(), is(0));
        }

        @Test
        public void 引数に3件の要素を持つ給付実績居宅サービスListが渡されたとき_変換後のEntityListは3件の要素を持つ() {
            result = KyufuJissekiKyotakuServiceMapper.to給付実績居宅サービスEntityList(create給付実績居宅サービスList(3));
            assertThat(result.size(), is(3));
        }

    }

    public static class to給付実績居宅サービスのテスト extends DbcTestBase {

        private DbT3025KyufujissekiKyotakuServiceEntity 居宅サービスEntity;
        private KyufuJissekiKyotakuService result;

        @Before
        public void setUp() {
            居宅サービスEntity = create給付実績居宅サービスEntity();
            result = KyufuJissekiKyotakuServiceMapper.to給付実績居宅サービス(居宅サービスEntity);
        }

        @Test
        public void 引数にnullを渡した場合_nullを返す() {
            result = KyufuJissekiKyotakuServiceMapper.to給付実績居宅サービス(null);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void entityのKokanJohoShikibetsuNoと_変換後の給付実績居宅サービスが持つ交換情報識別コードが一致する() {
            assertThat(result.get交換情報識別コード(), is(居宅サービスEntity.getKokanJohoShikibetsuNo()));
        }

        @Test
        public void entityのInputShikibetsuNoと_変換後の給付実績居宅サービスが持つ入力識別コードが一致する() {
            assertThat(result.get入力識別コード(), is(居宅サービスEntity.getInputShikibetsuNo()));
        }

        @Test
        public void entityのRecodeShubetsuCodeと_変換後の給付実績居宅サービスが持つレコード種別コードが一致する() {
            assertThat(result.getレコード種別コード(), is(居宅サービスEntity.getRecodeShubetsuCode()));
        }

        @Test
        public void entityのShokisaiHokenshaNoと_変換後の給付実績居宅サービスが持つ証記載保険者番号が一致する() {
            assertThat(result.get証記載保険者番号(), is(居宅サービスEntity.getShokisaiHokenshaNo()));
        }

        @Test
        public void entityのHiHokenshaNoと_変換後の給付実績居宅サービスが持つ被保険者番号が一致する() {
            assertThat(result.get被保険者番号(), is(居宅サービスEntity.getHiHokenshaNo()));
        }

        @Test
        public void entityのServiceTeikyoYMと_変換後の給付実績居宅サービスが持つサービス適用年月が一致する() {
            assertThat(result.getサービス適用年月(), is(居宅サービスEntity.getServiceTeikyoYM()));
        }

        @Test
        public void entityのJigyoshoNoと_変換後の給付実績居宅サービスが持つ事業者番号が一致する() {
            assertThat(result.get事業者番号(), is(居宅サービスEntity.getJigyoshoNo()));
        }

        @Test
        public void entityのToshiNoと_変換後の給付実績居宅サービスが持つ通し番号が一致する() {
            assertThat(result.get通し番号(), is(居宅サービスEntity.getToshiNo()));
        }

        @Test
        public void entityのShiteiKijunGaitoJigyoshaKubunCodeと_変換後の給付実績居宅サービスが持つ指定基準該当等事業者区分コードが一致する() {
            assertThat(result.get指定基準該当等事業者区分コード(), is(居宅サービスEntity.getShiteiKijunGaitoJigyoshaKubunCode()));
        }

        @Test
        public void entityのTanisuTankaと_変換後の給付実績居宅サービスが持つ単位数単価が一致する() {
            assertThat(result.get単位数単価(), is(居宅サービスEntity.getTanisuTanka()));
        }

        @Test
        public void entityのKyotakuServiceSakuseiIraiYMDと_変換後の給付実績居宅サービスが持つ居宅サービス作成依頼年月日が一致する() {
            assertThat(result.get居宅サービス作成依頼年月日(), is(居宅サービスEntity.getKyotakuServiceSakuseiIraiYMD()));
        }

        @Test
        public void entityのServicePlanhiMeisaiLineNoが一致すると_変換後の給付実績居宅サービスが持つサービス計画費明細行番号が一致する() {
            assertThat(result.getサービス計画費明細行番号(), is(居宅サービスEntity.getServicePlanhiMeisaiLineNo()));
        }

        @Test
        public void entityのServiceCodeと_変換後の給付実績居宅サービスが持つサービスコードが一致する() {
            assertThat(result.getサービスコード(), is(居宅サービスEntity.getServiceCode()));
        }

        @Test
        public void entityのTanisuと_変換後の給付実績居宅サービスが持つ単位数が一致する() {
            assertThat(result.get請求金額情報().get単位数(), is(居宅サービスEntity.getTanisu()));
        }

        @Test
        public void entityのKaisuと_変換後の給付実績居宅サービスが持つ回数が一致する() {
            assertThat(result.get請求金額情報().get回数(), is(居宅サービスEntity.getKaisu()));
        }

        @Test
        public void entityのServiceTanisuと_変換後の給付実績居宅サービスが持つサービス単位数が一致する() {
            assertThat(result.get請求金額情報().getサービス単位数(), is(居宅サービスEntity.getServiceTanisu()));
        }

        @Test
        public void entityのServiceTanisuTotalと_変換後の給付実績居宅サービスが持つサービス単位数合計が一致する() {
            assertThat(result.get請求金額情報().getサービス単位数合計(), is(居宅サービスEntity.getServiceTanisuTotal()));
        }

        @Test
        public void entityのSeikyuKingakuと_変換後の給付実績居宅サービスが持つ請求金額が一致する() {
            assertThat(result.get請求金額情報().get請求金額(), is(居宅サービスEntity.getSeikyuKingaku()));
        }

        @Test
        public void entityのTantouKaigoShienSemmoninNoと_変換後の給付実績居宅サービスが持つ担当介護支援専門員番号が一致する() {
            assertThat(result.get担当介護支援専門員番号(), is(居宅サービスEntity.getTantouKaigoShienSemmoninNo()));
        }

        @Test
        public void entityのTekiyoと_変換後の給付実績居宅サービスが持つ摘要が一致する() {
            assertThat(result.get摘要(), is(居宅サービスEntity.getTekiyo()));
        }

        @Test
        public void entityのAtoTanisuと_変換後の給付実績居宅サービスが持つ後単位数が一致する() {
            assertThat(result.get後請求金額情報().get単位数(), is(居宅サービスEntity.getAtoTanisu()));
        }

        @Test
        public void entityのAtoKaisuと_変換後の給付実績居宅サービスが持つ後回数が一致する() {
            assertThat(result.get後請求金額情報().get回数(), is(居宅サービスEntity.getAtoKaisu()));
        }

        @Test
        public void entityのAtoServiceTanisuと_変換後の給付実績居宅サービスが持つ後サービス単位数が一致する() {
            assertThat(result.get後請求金額情報().getサービス単位数(), is(居宅サービスEntity.getAtoServiceTanisu()));
        }

        @Test
        public void entityのAtoServiceTanisuTotalと_変換後の給付実績居宅サービスが持つ後サービス単位数合計が一致する() {
            assertThat(result.get後請求金額情報().getサービス単位数合計(), is(居宅サービスEntity.getAtoServiceTanisuTotal()));
        }

        @Test
        public void entityのAtoSeikyuKingakuと_変換後の給付実績居宅サービスが持つ後請求金額が一致する() {
            assertThat(result.get後請求金額情報().get請求金額(), is(居宅サービスEntity.getAtoSeikyuKingaku()));
        }

        @Test
        public void entityのSaishinsaKaisuと_変換後の給付実績居宅サービスが持つ再審査回数が一致する() {
            assertThat(result.get再審査回数(), is(居宅サービスEntity.getSaishinsaKaisu()));
        }

        @Test
        public void entityのKagoKaisuと_変換後の給付実績居宅サービスが持つ過誤回数が一致する() {
            assertThat(result.get過誤回数(), is(居宅サービスEntity.getKagoKaisu()));
        }

        @Test
        public void entityのShinsaYMと_変換後の給付実績居宅サービスが持つ審査年月が一致する() {
            assertThat(result.get審査年月(), is(居宅サービスEntity.getShinsaYM()));
        }

        @Test
        public void entityのSeiriNoと_変換後の給付実績居宅サービスが持つ整理番号が一致する() {
            assertThat(result.get整理番号(), is(居宅サービスEntity.getSeiriNo()));
        }

        @Test
        public void entityのTorikomiYMと_変換後の給付実績居宅サービスが持つ取込年月が一致する() {
            assertThat(result.get取込年月(), is(居宅サービスEntity.getTorikomiYM()));
        }
    }

    public static class to給付実績居宅サービスListのテスト extends DbcTestBase {

        private KyufuJissekiKyotakuServiceList result;

        @Test
        public void 引数にnullが渡されたとき_空のListが返る() {
            result = KyufuJissekiKyotakuServiceMapper.to給付実績居宅サービスList(null);
            assertThat(result.size(), is(0));
        }

        @Test
        public void 引数に3件の要素を持つEntityのListが渡されたとき_給付実績居宅サービスListは3件の要素を持つ() {
            result = KyufuJissekiKyotakuServiceMapper.to給付実績居宅サービスList(create給付実績居宅サービスEntityList(3));
            assertThat(result.size(), is(3));
        }

    }

    private static KyufuJissekiKyotakuService create給付実績居宅サービス() {
        return new KyufuJissekiKyotakuService(交換情報識別コード, 入力識別コード, レコード種別コード, 証記載保険者番号,
                被保険者番号, サービス適用年月, 事業者番号, 通し番号, 指定基準該当等事業者区分コード, 居宅サービス作成依頼年月日,
                サービス計画費明細行番号, 単位数単価, サービスコード, 請求金額情報, 担当介護支援専門員番号, 摘要, 後請求金額情報,
                再審査回数, 過誤回数, 審査年月, 整理番号, 取込年月);
    }

    private static KyufuJissekiKyotakuServiceList create給付実績居宅サービスList(int 件数) {
        List<KyufuJissekiKyotakuService> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(create給付実績居宅サービス());
        }
        return new KyufuJissekiKyotakuServiceList(list);
    }

    private static DbT3025KyufujissekiKyotakuServiceEntity create給付実績居宅サービスEntity() {
        DbT3025KyufujissekiKyotakuServiceEntity entity = new DbT3025KyufujissekiKyotakuServiceEntity();
        entity.setKokanJohoShikibetsuNo(交換情報識別コード);
        entity.setInputShikibetsuNo(入力識別コード);
        entity.setRecodeShubetsuCode(レコード種別コード);
        entity.setShokisaiHokenshaNo(証記載保険者番号);
        entity.setHiHokenshaNo(被保険者番号);
        entity.setServiceTeikyoYM(サービス適用年月);
        entity.setJigyoshoNo(事業者番号);
        entity.setToshiNo(通し番号);
        entity.setShiteiKijunGaitoJigyoshaKubunCode(指定基準該当等事業者区分コード);
        entity.setTanisuTanka(単位数単価);
        entity.setKyotakuServiceSakuseiIraiYMD(居宅サービス作成依頼年月日);
        entity.setServicePlanhiMeisaiLineNo(サービス計画費明細行番号);
        entity.setServiceCode(サービスコード);
        entity.setTanisu(単位数);
        entity.setKaisu(回数);
        entity.setServiceTanisu(サービス単位数);
        entity.setServiceTanisuTotal(サービス単位数合計);
        entity.setSeikyuKingaku(請求金額);
        entity.setTantouKaigoShienSemmoninNo(担当介護支援専門員番号);
        entity.setTekiyo(摘要);
        entity.setAtoTanisu(後単位数);
        entity.setAtoKaisu(後回数);
        entity.setAtoServiceTanisu(後サービス単位数);
        entity.setAtoServiceTanisuTotal(後サービス単位数合計);
        entity.setAtoSeikyuKingaku(後請求金額);
        entity.setSaishinsaKaisu(再審査回数);
        entity.setKagoKaisu(過誤回数);
        entity.setShinsaYM(審査年月);
        entity.setSeiriNo(整理番号);
        entity.setTorikomiYM(取込年月);
        return entity;
    }

    private static List<DbT3025KyufujissekiKyotakuServiceEntity> create給付実績居宅サービスEntityList(int 件数) {
        List<DbT3025KyufujissekiKyotakuServiceEntity> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(create給付実績居宅サービスEntity());
        }
        return list;
    }
}
