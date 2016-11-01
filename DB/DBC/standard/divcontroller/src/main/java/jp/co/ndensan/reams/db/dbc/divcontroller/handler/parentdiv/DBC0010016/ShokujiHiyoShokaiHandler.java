/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010016;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiMeisaiBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010016.ShokujiHiyoShokaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010016.dgShokujiHiyoGokeiFromH1504_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010016.dgShokujiHiyoMeisaiFromH1504_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010016.dgShokujiHiyoToH1503_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 給付実績照会_(DBC0010016)食事費用のHandlerです
 *
 * @reamsid_L DBC-2970-080 zhaoran
 */
public class ShokujiHiyoShokaiHandler {

    private final ShokujiHiyoShokaiDiv div;
    private final FlexibleYearMonth 提供年月;
    private final RString 前 = new RString("前");
    private final RString 後 = new RString("後");
    private final RString 公費１ = new RString("公費１");
    private final RString 公費２ = new RString("公費２");
    private final RString 公費３ = new RString("公費３");
    private static final int INT_ZERO = 0;
    private static final int INT_SEX = 6;
    private static final RString ZERO = new RString("0");
    private static final RString 前事業者 = new RString("前事業者");
    private static final RString 前月 = new RString("前月");

    /**
     * コンストラクタです。
     *
     * @param div ShokujiHiyoShokaiDiv
     */
    public ShokujiHiyoShokaiHandler(ShokujiHiyoShokaiDiv div) {
        RString 年月 = DbBusinessConfig.get(ConfigNameDBU.制度改正施行日_介護給付費見直し,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).substringEmptyOnError(INT_ZERO, INT_SEX);
        this.提供年月 = new FlexibleYearMonth(年月);
        this.div = div;
    }

    /**
     * 給付実績食事費用1504等
     *
     * @param 給付実績食事費用1504等 List<KyufujissekiShokujiHiyo>
     * @param サービス提供年月 サービス提供年月
     */
    public void set給付実績食事費用15041(List<KyufujissekiShokujiHiyo> 給付実績食事費用1504等, FlexibleYearMonth サービス提供年月) {
        RString 整理番号 = div.getCcdKyufuJissekiHeader().get整理番号();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        List<dgShokujiHiyoGokeiFromH1504_Row> dataSources = new ArrayList<>();
        if (!提供年月.isBeforeOrEquals(サービス提供年月)) {
            div.getDgShokujiHiyoGokeiFromH1504().setDataSource(dataSources);
            return;
        }
        for (KyufujissekiShokujiHiyo 給付実績食事費用1504 : 給付実績食事費用1504等) {
            if (事業者番号.equals(給付実績食事費用1504.get事業所番号().getColumnValue())
                    && 整理番号.equals(給付実績食事費用1504.get整理番号())
                    && 様式番号.equals(給付実績食事費用1504.get入力識別番号().getColumnValue())
                    && サービス提供年月.toDateString().equals(給付実績食事費用1504.getサービス提供年月().toDateString())) {
                dgShokujiHiyoGokeiFromH1504_Row row_1 = new dgShokujiHiyoGokeiFromH1504_Row();
                row_1.setTxtShokujiTeikyohiGokei(get金額(給付実績食事費用1504.get基本_提供金額()));
                row_1.setTxtHyojunFutangakuTsuki(get金額(給付実績食事費用1504.get標準負担額_月額()));
                row_1.setTxtHyojunFutangakuHi(get金額(給付実績食事費用1504.get標準負担額_日額()));
                row_1.setTxtKohi(RString.EMPTY);
                row_1.setTxtShokujiTeikyoNobeNissu(new RString(給付実績食事費用1504.get食事提供延べ日数()));
                row_1.setTxtSeikyugakuZengo(前);
                row_1.setTxtKohiSeikyu(RString.EMPTY);
                row_1.setTxtShokujiTeikyohiSeikyugaku(get金額(給付実績食事費用1504.get食事提供費請求額()));
                row_1.setTxtSaishinsaKaisu(new RString(給付実績食事費用1504.get再審査回数()));
                row_1.setTxtKagoKaisu(new RString(給付実績食事費用1504.get過誤回数()));
                row_1.setTxtShinsaYM(to日期(給付実績食事費用1504.get審査年月()));
                dgShokujiHiyoGokeiFromH1504_Row row_2 = new dgShokujiHiyoGokeiFromH1504_Row();
                row_2.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_2.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_2.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_2.setTxtKohi(RString.EMPTY);
                row_2.setTxtShokujiTeikyoNobeNissu(RString.EMPTY);
                row_2.setTxtSeikyugakuZengo(後);
                row_2.setTxtKohiSeikyu(RString.EMPTY);
                row_2.setTxtShokujiTeikyohiSeikyugaku(get金額(給付実績食事費用1504.get後_食事提供費請求額()));
                row_2.setTxtSaishinsaKaisu(RString.EMPTY);
                row_2.setTxtKagoKaisu(RString.EMPTY);
                row_2.setTxtShinsaYM(RString.EMPTY);
                dgShokujiHiyoGokeiFromH1504_Row row_3 = new dgShokujiHiyoGokeiFromH1504_Row();
                row_3.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_3.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_3.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_3.setTxtKohi(公費１);
                row_3.setTxtShokujiTeikyoNobeNissu(new RString(給付実績食事費用1504.get公費１対象食事提供延べ日数()));
                row_3.setTxtSeikyugakuZengo(RString.EMPTY);
                row_3.setTxtKohiSeikyu(new RString(給付実績食事費用1504.get公費１食事提供費請求額()));
                row_3.setTxtShokujiTeikyohiSeikyugaku(RString.EMPTY);
                row_3.setTxtSaishinsaKaisu(RString.EMPTY);
                row_3.setTxtKagoKaisu(RString.EMPTY);
                row_3.setTxtShinsaYM(RString.EMPTY);
                dgShokujiHiyoGokeiFromH1504_Row row_4 = new dgShokujiHiyoGokeiFromH1504_Row();
                row_4.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_4.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_4.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_4.setTxtKohi(公費２);
                row_4.setTxtShokujiTeikyoNobeNissu(new RString(給付実績食事費用1504.get公費２対象食事提供延べ日数()));
                row_4.setTxtSeikyugakuZengo(RString.EMPTY);
                row_4.setTxtKohiSeikyu(get金額(給付実績食事費用1504.get公費２食事提供費請求額()));
                row_4.setTxtShokujiTeikyohiSeikyugaku(RString.EMPTY);
                row_4.setTxtSaishinsaKaisu(RString.EMPTY);
                row_4.setTxtKagoKaisu(RString.EMPTY);
                row_4.setTxtShinsaYM(RString.EMPTY);
                dgShokujiHiyoGokeiFromH1504_Row row_5 = new dgShokujiHiyoGokeiFromH1504_Row();
                row_5.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_5.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_5.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_5.setTxtKohi(公費３);
                row_5.setTxtShokujiTeikyoNobeNissu(new RString(給付実績食事費用1504.get公費３対象食事提供延べ日数()));
                row_5.setTxtSeikyugakuZengo(RString.EMPTY);
                row_5.setTxtKohiSeikyu(get金額(給付実績食事費用1504.get公費３食事提供費請求額()));
                row_5.setTxtShokujiTeikyohiSeikyugaku(RString.EMPTY);
                row_5.setTxtSaishinsaKaisu(RString.EMPTY);
                row_5.setTxtKagoKaisu(RString.EMPTY);
                row_5.setTxtShinsaYM(RString.EMPTY);
                dataSources.add(row_1);
                dataSources.add(row_2);
                dataSources.add(row_3);
                dataSources.add(row_4);
                dataSources.add(row_5);
            }
        }
        div.getDgShokujiHiyoGokeiFromH1504().setDataSource(dataSources);
        List<KyufujissekiShokujiHiyo> dataToRepeat = get食費1504サービス提供年月リスト(給付実績食事費用1504等);
        setGetsuBtn(dataToRepeat, サービス提供年月);
    }

    /**
     * 給付実績明細等
     *
     * @param 給付実績明細等 List<KyufujissekiMeisaiBusiness>
     * @param サービス提供年月 サービス提供年月
     */
    public void set給付実績明細(List<KyufujissekiMeisaiBusiness> 給付実績明細等, FlexibleYearMonth サービス提供年月) {
        List<dgShokujiHiyoMeisaiFromH1504_Row> dataSources = new ArrayList<>();
        RString 整理番号 = div.getCcdKyufuJissekiHeader().get整理番号();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        if (!提供年月.isBeforeOrEquals(サービス提供年月)) {
            div.getDgShokujiHiyoMeisaiFromH1504().setDataSource(dataSources);
            return;
        }
        for (KyufujissekiMeisaiBusiness 給付実績明細 : 給付実績明細等) {
            if (事業者番号.equals(給付実績明細.get給付実績明細().get事業所番号().getColumnValue())
                    && 整理番号.equals(給付実績明細.get給付実績明細().get整理番号())
                    && 様式番号.equals(給付実績明細.get給付実績明細().get入力識別番号().getColumnValue())
                    && サービス提供年月.toDateString().equals(給付実績明細.get給付実績明細().getサービス提供年月().toDateString())) {
                dgShokujiHiyoMeisaiFromH1504_Row row = new dgShokujiHiyoMeisaiFromH1504_Row();
                row.setTxtServiceName(給付実績明細.getサービス種類略称());
                row.setTxtKettei(RString.EMPTY);
                row.setTxtTanka(get金額(単価変換(給付実績明細.get給付実績明細().get単位数())));
                row.setTxtKaisuNissu(new RString(給付実績明細.get給付実績明細().get日数_回数()));
                row.setTxtKohi1Nissu(new RString(給付実績明細.get給付実績明細().get公費１対象日数_回数()));
                row.setTxtKohi2Nissu(new RString(給付実績明細.get給付実績明細().get公費２対象日数_回数()));
                row.setTxtKohi3Nissu(new RString(給付実績明細.get給付実績明細().get公費３対象日数_回数()));
                row.setTxtServiceTani(単位数変換(給付実績明細.get給付実績明細().getサービス単位数()));
                row.setTxtKohi1Tani(単位数変換(給付実績明細.get給付実績明細().get公費１対象サービス単位数()));
                row.setTxtKohi2Tani(単位数変換(給付実績明細.get給付実績明細().get公費２対象サービス単位数()));
                row.setTxtKohi3Tani(単位数変換(給付実績明細.get給付実績明細().get公費３対象サービス単位数()));
                dgShokujiHiyoMeisaiFromH1504_Row row_後 = new dgShokujiHiyoMeisaiFromH1504_Row();
                row_後.setTxtServiceName(RString.EMPTY);
                row_後.setTxtKettei(後);
                row_後.setTxtTanka(get金額(単価変換(給付実績明細.get給付実績明細().get後_単位数())));
                row_後.setTxtKaisuNissu(new RString(給付実績明細.get給付実績明細().get後_日数_回数()));
                row_後.setTxtKohi1Nissu(new RString(給付実績明細.get給付実績明細().get後_公費１対象日数_回数()));
                row_後.setTxtKohi2Nissu(new RString(給付実績明細.get給付実績明細().get後_公費２対象日数_回数()));
                row_後.setTxtKohi3Nissu(new RString(給付実績明細.get給付実績明細().get後_公費３対象日数_回数()));
                row_後.setTxtServiceTani(単位数変換(給付実績明細.get給付実績明細().get後_サービス単位数()));
                row_後.setTxtKohi1Tani(単位数変換(給付実績明細.get給付実績明細().get後_公費１対象サービス単位数()));
                row_後.setTxtKohi2Tani(単位数変換(給付実績明細.get給付実績明細().get後_公費２対象サービス単位数()));
                row_後.setTxtKohi3Tani(単位数変換(給付実績明細.get給付実績明細().get後_公費３対象サービス単位数()));
                dataSources.add(row);
                dataSources.add(row_後);
            }
        }
        div.getDgShokujiHiyoMeisaiFromH1504().setDataSource(dataSources);
    }

    /**
     * 給付実績食事費用1503等
     *
     * @param 給付実績食事費用1503等 List<KyufujissekiShokujiHiyo>
     * @param サービス提供年月 サービス提供年月
     */
    public void set給付実績食事費用15031(List<KyufujissekiShokujiHiyo> 給付実績食事費用1503等, FlexibleYearMonth サービス提供年月) {
        List<dgShokujiHiyoToH1503_Row> dataSources = new ArrayList<>();
        RString 整理番号 = div.getCcdKyufuJissekiHeader().get整理番号();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        if (提供年月.isBeforeOrEquals(サービス提供年月)) {
            div.getDgShokujiHiyoToH1503().setDataSource(dataSources);
            return;
        }
        for (KyufujissekiShokujiHiyo 給付実績食事費用1503 : 給付実績食事費用1503等) {
            if (事業者番号.equals(給付実績食事費用1503.get事業所番号().getColumnValue())
                    && 整理番号.equals(給付実績食事費用1503.get整理番号())
                    && 様式番号.equals(給付実績食事費用1503.get入力識別番号().getColumnValue())
                    && サービス提供年月.toDateString().equals(給付実績食事費用1503.getサービス提供年月().toDateString())) {
                dgShokujiHiyoToH1503_Row row_1 = new dgShokujiHiyoToH1503_Row();
                row_1.setTxtZengo(RString.EMPTY);
                row_1.setTxtTeikyoNissu(new RString(給付実績食事費用1503.get基本_提供日数()));
                row_1.setTxtTokubetsuTeikyoNissu(new RString(給付実績食事費用1503.get特別_提供日数()));
                row_1.setTxtTeikyoTanka(new RString(給付実績食事費用1503.get基本_提供単価()));
                row_1.setTxtTokubetsuTeikyoTanka(new RString(給付実績食事費用1503.get特別_提供単価()));
                row_1.setTxtTeikyoKingaku(new RString(給付実績食事費用1503.get基本_提供金額()));
                row_1.setTxtTokubetsuTeikyoKingaku(new RString(給付実績食事費用1503.get特別_提供金額()));
                row_1.setTxtShokujiTeikyohiGokei(get金額(給付実績食事費用1503.get食事提供費合計()));
                row_1.setTxtHyojunFutangakuTsuki(get金額(給付実績食事費用1503.get標準負担額_月額()));
                row_1.setTxtHyojunFutangakuHi(get金額(給付実績食事費用1503.get標準負担額_日額()));
                row_1.setTxtKohi(RString.EMPTY);
                row_1.setTxtShokujiTeikyoNobeNissu(new RString(給付実績食事費用1503.get食事提供延べ日数()));
                row_1.setTxtSeikyugakuZengo(new RString(給付実績食事費用1503.get食事提供費請求額()));
                row_1.setTxtKohiSeikyu(RString.EMPTY);
                row_1.setTxtSaishinsaKaisu(new RString(給付実績食事費用1503.get再審査回数()));
                row_1.setTxtKagoKaisu(new RString(給付実績食事費用1503.get過誤回数()));
                row_1.setTxtShinsaYM(to日期(給付実績食事費用1503.get審査年月()));
                dgShokujiHiyoToH1503_Row row_2 = new dgShokujiHiyoToH1503_Row();
                row_2.setTxtZengo(後);
                row_2.setTxtTeikyoNissu(RString.EMPTY);
                row_2.setTxtTokubetsuTeikyoNissu(RString.EMPTY);
                row_2.setTxtTeikyoTanka(new RString(給付実績食事費用1503.get後_基本食提供費用提供単価()));
                row_2.setTxtTokubetsuTeikyoTanka(new RString(給付実績食事費用1503.get後_特別食提供費用提供単価()));
                row_2.setTxtTeikyoKingaku(RString.EMPTY);
                row_2.setTxtTokubetsuTeikyoKingaku(RString.EMPTY);
                row_2.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_2.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_2.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_2.setTxtKohi(RString.EMPTY);
                row_2.setTxtShokujiTeikyoNobeNissu(RString.EMPTY);
                row_2.setTxtSeikyugakuZengo(new RString(給付実績食事費用1503.get後_食事提供費請求額()));
                row_2.setTxtKohiSeikyu(RString.EMPTY);
                row_2.setTxtSaishinsaKaisu(RString.EMPTY);
                row_2.setTxtKagoKaisu(RString.EMPTY);
                row_2.setTxtShinsaYM(RString.EMPTY);
                dgShokujiHiyoToH1503_Row row_3 = new dgShokujiHiyoToH1503_Row();
                row_3.setTxtZengo(RString.EMPTY);
                row_3.setTxtTeikyoNissu(RString.EMPTY);
                row_3.setTxtTokubetsuTeikyoNissu(RString.EMPTY);
                row_3.setTxtTeikyoTanka(RString.EMPTY);
                row_3.setTxtTokubetsuTeikyoTanka(RString.EMPTY);
                row_3.setTxtTeikyoKingaku(RString.EMPTY);
                row_3.setTxtTokubetsuTeikyoKingaku(RString.EMPTY);
                row_3.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_3.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_3.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_3.setTxtKohi(公費１);
                row_3.setTxtShokujiTeikyoNobeNissu(new RString(給付実績食事費用1503.get公費１対象食事提供延べ日数()));
                row_3.setTxtSeikyugakuZengo(RString.EMPTY);
                row_3.setTxtKohiSeikyu(new RString(給付実績食事費用1503.get公費１食事提供費請求額()));
                row_3.setTxtSaishinsaKaisu(RString.EMPTY);
                row_3.setTxtKagoKaisu(RString.EMPTY);
                row_3.setTxtShinsaYM(RString.EMPTY);
                dgShokujiHiyoToH1503_Row row_4 = new dgShokujiHiyoToH1503_Row();
                row_4.setTxtZengo(RString.EMPTY);
                row_4.setTxtTeikyoNissu(RString.EMPTY);
                row_4.setTxtTokubetsuTeikyoNissu(RString.EMPTY);
                row_4.setTxtTeikyoTanka(RString.EMPTY);
                row_4.setTxtTokubetsuTeikyoTanka(RString.EMPTY);
                row_4.setTxtTeikyoKingaku(RString.EMPTY);
                row_4.setTxtTokubetsuTeikyoKingaku(RString.EMPTY);
                row_4.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_4.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_4.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_4.setTxtKohi(公費２);
                row_4.setTxtShokujiTeikyoNobeNissu(new RString(給付実績食事費用1503.get公費２対象食事提供延べ日数()));
                row_4.setTxtSeikyugakuZengo(RString.EMPTY);
                row_4.setTxtKohiSeikyu(new RString(給付実績食事費用1503.get公費２食事提供費請求額()));
                row_4.setTxtSaishinsaKaisu(RString.EMPTY);
                row_4.setTxtKagoKaisu(RString.EMPTY);
                row_4.setTxtShinsaYM(RString.EMPTY);
                dgShokujiHiyoToH1503_Row row_5 = new dgShokujiHiyoToH1503_Row();
                row_5.setTxtZengo(RString.EMPTY);
                row_5.setTxtTeikyoNissu(RString.EMPTY);
                row_5.setTxtTokubetsuTeikyoNissu(RString.EMPTY);
                row_5.setTxtTeikyoTanka(RString.EMPTY);
                row_5.setTxtTokubetsuTeikyoTanka(RString.EMPTY);
                row_5.setTxtTeikyoKingaku(RString.EMPTY);
                row_5.setTxtTokubetsuTeikyoKingaku(RString.EMPTY);
                row_5.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_5.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_5.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_5.setTxtKohi(公費３);
                row_5.setTxtShokujiTeikyoNobeNissu(new RString(給付実績食事費用1503.get公費３対象食事提供延べ日数()));
                row_5.setTxtSeikyugakuZengo(RString.EMPTY);
                row_5.setTxtKohiSeikyu(new RString(給付実績食事費用1503.get公費３食事提供費請求額()));
                row_5.setTxtSaishinsaKaisu(RString.EMPTY);
                row_5.setTxtKagoKaisu(RString.EMPTY);
                row_5.setTxtShinsaYM(RString.EMPTY);
                dataSources.add(row_1);
                dataSources.add(row_2);
                dataSources.add(row_3);
                dataSources.add(row_4);
                dataSources.add(row_5);
            }
        }
        div.getDgShokujiHiyoToH1503().setDataSource(dataSources);
        List<KyufujissekiShokujiHiyo> dataToRepeat = get食費1504サービス提供年月リスト(給付実績食事費用1503等);
        setGetsuBtn(dataToRepeat, サービス提供年月);
    }

    /**
     * ボタン状態の設定です。
     *
     * @param 識別番号管理 識別番号管理
     */
    public void setButton(ShikibetsuNoKanri 識別番号管理) {
        div.getBtnShokuji().setDisabled(true);
        if (ZERO.equals(識別番号管理.get基本設定区分())) {
            div.getBtnKihon().setDisabled(true);
        } else {
            div.getBtnKihon().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get明細設定区分())) {
            div.getBtnMeisaiShukei().setDisabled(true);
        } else {
            div.getBtnMeisaiShukei().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get緊急時施設療養設定区分())) {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get所定疾患施設療養設定区分())) {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get福祉用具購入費設定区分())) {
            div.getBtnFukushiYoguKonyu().setDisabled(true);
        } else {
            div.getBtnFukushiYoguKonyu().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get特定入所者設定区分())) {
            div.getBtnTokuteiNyushosha().setDisabled(true);
        } else {
            div.getBtnTokuteiNyushosha().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get高額介護サービス費設定区分())) {
            div.getBtnKogakuKaigoService().setDisabled(true);
        } else {
            div.getBtnKogakuKaigoService().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get特定診療費設定区分())) {
            div.getBtnTokuteiShinryo().setDisabled(true);
        } else {
            div.getBtnTokuteiShinryo().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get居宅計画費設定区分())) {
            div.getBtnKyotakuServiceKeikaku().setDisabled(true);
        } else {
            div.getBtnKyotakuServiceKeikaku().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get住宅改修費設定区分())) {
            div.getBtnJutakuKaishu().setDisabled(true);
        } else {
            div.getBtnJutakuKaishu().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.getケアマネジメント設定区分())) {
            div.getBtnCareManagement().setDisabled(true);
        } else {
            div.getBtnCareManagement().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get社会福祉法人軽減設定区分())) {
            div.getBtnShafukuKeigen().setDisabled(true);
        } else {
            div.getBtnShafukuKeigen().setDisabled(false);
        }
    }

    /**
     * 事業者ボタン状態設定。
     *
     * @param 事業者番号リスト List<KyufuJissekiHedajyoho2>
     * @param 整理番号 RString
     * @param 事業者番号 RString
     * @param 様式番号 RString
     * @param サービス提供年月 RString
     * @param 実績区分コード RString
     */
    public void setJigyoshaBtn(List<KyufuJissekiHedajyoho2> 事業者番号リスト, RString 整理番号, RString 事業者番号,
            RString 様式番号, RString サービス提供年月, RString 実績区分コード) {
        div.getBtnMaeJigyosha().setDisabled(true);
        div.getBtnAtoJigyosha().setDisabled(true);
        if (!事業者番号リスト.isEmpty()) {
            int index = get事業者番号index(事業者番号リスト, 整理番号, 事業者番号, 様式番号, サービス提供年月, 実績区分コード);
            if (0 < index) {
                div.getBtnMaeJigyosha().setDisabled(false);
            }
            if (index + 1 < 事業者番号リスト.size()) {
                div.getBtnAtoJigyosha().setDisabled(false);
            }
        }
    }

    /**
     * 前次月ボタン状態設定。
     *
     * @param サービス提供年月リスト サービス提供年月リスト
     * @param サービス提供年月 サービス提供年月
     */
    public void setGetsuBtn(List<KyufujissekiShokujiHiyo> サービス提供年月リスト, FlexibleYearMonth サービス提供年月) {
        Collections.sort(サービス提供年月リスト, new DateComparatorServiceTeikyoYM());
        div.getBtnZengetsu().setDisabled(true);
        div.getBtnJigetsu().setDisabled(true);
        if (サービス提供年月リスト != null && !サービス提供年月リスト.isEmpty()) {
            if (!サービス提供年月.isBeforeOrEquals(サービス提供年月リスト.get(サービス提供年月リスト.size() - 1).getサービス提供年月())) {
                div.getBtnZengetsu().setDisabled(false);
            }
            if (!サービス提供年月リスト.get(INT_ZERO).getサービス提供年月().isBeforeOrEquals(サービス提供年月)) {
                div.getBtnJigetsu().setDisabled(false);
            }
        }
    }

    /**
     * change事業者です。
     *
     * @param 事業者 事業者
     * @param 事業者番号リスト 事業者番号リスト
     * @param 給付実績食事費用1504 給付実績食事費用1504
     * @param 給付実績明細 給付実績明細
     * @param 給付実績食事費用1503 給付実績食事費用1503
     */
    public void change事業者(RString 事業者, List<KyufuJissekiHedajyoho2> 事業者番号リスト,
            List<KyufujissekiShokujiHiyo> 給付実績食事費用1504,
            List<KyufujissekiMeisaiBusiness> 給付実績明細,
            List<KyufujissekiShokujiHiyo> 給付実績食事費用1503) {
        RString 整理番号 = div.getCcdKyufuJissekiHeader().get整理番号();
        RString サービス提供年月 = div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString();
        RString 識別番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 実績区分 = div.getCcdKyufuJissekiHeader().get実績区分コード();
        int index = get事業者番号index(事業者番号リスト, 整理番号, 事業者番号, 識別番号, サービス提供年月, 実績区分);
        int i;
        if (前事業者.equals(事業者)) {
            i = -1;
        } else {
            i = 1;
        }
        if (!(index == 0 && i == -1)) {
            div.getCcdKyufuJissekiHeader().set事業者名称(事業者番号リスト.get(index + i).get事業者名称());
            div.getCcdKyufuJissekiHeader().set実績区分(事業者番号リスト.get(index + i).get給付実績区分コード());
            div.getCcdKyufuJissekiHeader().set整理番号(事業者番号リスト.get(index + i).get整理番号());
            div.getCcdKyufuJissekiHeader().set識別番号名称(new RString(事業者番号リスト.get(index + i).get識別番号名称().toString()));
            div.getCcdKyufuJissekiHeader().set様式番号(事業者番号リスト.get(index + i).get識別番号());
            if (事業者番号リスト.get(index + i).get事業所番号() != null
                    && !RString.isNullOrEmpty(事業者番号リスト.get(index + i).get事業所番号().value())) {
                div.getCcdKyufuJissekiHeader().set事業者番号(事業者番号リスト.get(index + i).get事業所番号().value());
            }
            setDataGrid(給付実績食事費用1504, 給付実績明細, 給付実績食事費用1503, new FlexibleYearMonth(サービス提供年月));
            div.getBtnMaeJigyosha().setDisabled(true);
            div.getBtnAtoJigyosha().setDisabled(true);
            if (0 < index + i) {
                div.getBtnMaeJigyosha().setDisabled(false);
            }
            if (index + i + 1 < 事業者番号リスト.size()) {
                div.getBtnAtoJigyosha().setDisabled(false);
            }
        }
    }

    private int get事業者番号index(List<KyufuJissekiHedajyoho2> 事業者番号リスト, RString 整理番号,
            RString 事業者番号, RString 様式番号, RString サービス提供年月, RString 実績区分コード) {
        for (int index = 0; index < 事業者番号リスト.size(); index++) {
            KyufuJissekiHedajyoho2 給付実績ヘッダ情報2 = 事業者番号リスト.get(index);
            if (事業者番号.equals(給付実績ヘッダ情報2.get事業所番号().value())
                    && 整理番号.equals(給付実績ヘッダ情報2.get整理番号())
                    && 様式番号.equals(給付実績ヘッダ情報2.get識別番号())
                    && サービス提供年月.equals(給付実績ヘッダ情報2.getサービス提供年月().toDateString())
                    && 実績区分コード.equals(給付実績ヘッダ情報2.get給付実績区分コード())) {
                return index;
            }
        }
        return 0;
    }

    /**
     * setDataGridです。
     *
     * @param 給付実績食事費用1504 List<KyufujissekiShokujiHiyo>
     * @param 給付実績明細 List<KyufujissekiMeisaiBusiness>
     * @param 給付実績食事費用1503 List<KyufujissekiShokujiHiyo>
     * @param サービス提供年月 サービス提供年月
     */
    public void setDataGrid(List<KyufujissekiShokujiHiyo> 給付実績食事費用1504,
            List<KyufujissekiMeisaiBusiness> 給付実績明細,
            List<KyufujissekiShokujiHiyo> 給付実績食事費用1503,
            FlexibleYearMonth サービス提供年月) {
        set給付実績食事費用15041(給付実績食事費用1504, サービス提供年月);
        set給付実績明細(給付実績明細, サービス提供年月);
        set給付実績食事費用15031(給付実績食事費用1503, サービス提供年月);
    }

    /**
     * change年月です。
     *
     * @param date RString
     * @param 給付実績情報照会情報 KyufuJissekiPrmBusiness
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 被保険者番号 HihokenshaNo
     * @param 識別番号 NyuryokuShikibetsuNo
     * @param 給付実績食事費用1504 給付実績食事費用1504
     * @param 給付実績明細 給付実績明細
     * @param 給付実績食事費用1503 給付実績食事費用1503
     */
    public void change年月(RString date, KyufuJissekiPrmBusiness 給付実績情報照会情報,
            FlexibleYearMonth サービス提供年月, RString 整理番号, HihokenshaNo 被保険者番号,
            NyuryokuShikibetsuNo 識別番号, List<KyufujissekiShokujiHiyo> 給付実績食事費用1504,
            List<KyufujissekiMeisaiBusiness> 給付実績明細,
            List<KyufujissekiShokujiHiyo> 給付実績食事費用1503) {
        List<KyufujissekiShokujiHiyo> サービス提供年月リスト = get食費1504サービス提供年月リスト(給付実績食事費用1504);
        FlexibleYearMonth 今提供年月;
        if (前月.equals(date)) {
            今提供年月 = get前月サービス提供年月(サービス提供年月リスト, サービス提供年月);
        } else {
            今提供年月 = get次月サービス提供年月(サービス提供年月リスト, サービス提供年月);
        }
        if (!今提供年月.isEmpty()) {
            div.getCcdKyufuJissekiHeader().initialize(被保険者番号, 今提供年月, 整理番号, 識別番号);
            setDataGrid(給付実績食事費用1504, 給付実績明細, 給付実績食事費用1503, 今提供年月);
            check前次月Btn(給付実績食事費用1504, 今提供年月);
        }
    }

    private void check前次月Btn(List<KyufujissekiShokujiHiyo> サービス提供年月リスト, FlexibleYearMonth サービス提供年月) {
        if (サービス提供年月リスト != null && !サービス提供年月リスト.isEmpty()) {
            Collections.sort(サービス提供年月リスト, new DateComparatorServiceTeikyoYM());
            if (サービス提供年月.isBeforeOrEquals(サービス提供年月リスト.get(サービス提供年月リスト.size() - 1).getサービス提供年月())) {
                div.getBtnZengetsu().setDisabled(true);
            } else {
                div.getBtnZengetsu().setDisabled(false);
            }
            if (サービス提供年月リスト.get(INT_ZERO).getサービス提供年月().isBeforeOrEquals(サービス提供年月)) {
                div.getBtnJigetsu().setDisabled(true);
            } else {
                div.getBtnJigetsu().setDisabled(false);
            }
        }
    }

    /**
     * 給付実績食事費用1504DataGrid設定。
     *
     * @param 給付実績食事費用1504 List<KyufujissekiShokujiHiyo>
     * @param 整理番号 RString
     * @param 事業者番号 RString
     * @param 様式番号 RString
     * @param サービス提供年月 RString
     * @return 給付実績食事費用1504等
     */
    public List<KyufujissekiShokujiHiyo> get給付実績食事費用1504等(
            List<KyufujissekiShokujiHiyo> 給付実績食事費用1504,
            RString 整理番号, RString 事業者番号, RString 様式番号, RString サービス提供年月) {
        List<KyufujissekiShokujiHiyo> 給付実績食事費用1504等 = new ArrayList<>();
        for (KyufujissekiShokujiHiyo 給付実績食事費用15041 : 給付実績食事費用1504) {
            if (事業者番号.equals(給付実績食事費用15041.get事業所番号().value())
                    && 整理番号.equals(給付実績食事費用15041.get整理番号())
                    && 様式番号.equals(給付実績食事費用15041.get入力識別番号().value())
                    && サービス提供年月.equals(給付実績食事費用15041.getサービス提供年月().toDateString())) {
                給付実績食事費用1504等.add(給付実績食事費用15041);
            }
        }
        return 給付実績食事費用1504等;
    }

    /**
     * 給付実績明細DataGrid設定。
     *
     * @param 給付実績明細 List<KyufujissekiMeisaiBusiness>
     * @param 整理番号 RString
     * @param 事業者番号 RString
     * @param 様式番号 RString
     * @param サービス提供年月 RString
     * @return 給付実績明細等
     */
    public List<KyufujissekiMeisaiBusiness> get給付実績明細等(
            List<KyufujissekiMeisaiBusiness> 給付実績明細,
            RString 整理番号, RString 事業者番号, RString 様式番号, RString サービス提供年月) {
        List<KyufujissekiMeisaiBusiness> 給付実績明細等 = new ArrayList<>();
        for (KyufujissekiMeisaiBusiness 給付実績明細1 : 給付実績明細) {
            if (事業者番号.equals(給付実績明細1.get給付実績明細().get事業所番号().value())
                    && 整理番号.equals(給付実績明細1.get給付実績明細().get整理番号())
                    && 様式番号.equals(給付実績明細1.get給付実績明細().get入力識別番号().value())
                    && サービス提供年月.equals(給付実績明細1.get給付実績明細().getサービス提供年月().toDateString())) {
                給付実績明細等.add(給付実績明細1);
            }
        }
        return 給付実績明細等;
    }

    /**
     * 給付実績食事費用1503DataGrid設定。
     *
     * @param 給付実績食事費用1503 List<KyufujissekiShokujiHiyo>
     * @param 整理番号 RString
     * @param 事業者番号 RString
     * @param 様式番号 RString
     * @param サービス提供年月 RString
     * @return 給付実績食事費用1503等
     */
    public List<KyufujissekiShokujiHiyo> get給付実績食事費用1503等(
            List<KyufujissekiShokujiHiyo> 給付実績食事費用1503,
            RString 整理番号, RString 事業者番号, RString 様式番号, RString サービス提供年月) {
        List<KyufujissekiShokujiHiyo> 給付実績食事費用1503等 = new ArrayList<>();
        for (KyufujissekiShokujiHiyo 給付実績食事費用15031 : 給付実績食事費用1503) {
            if (事業者番号.equals(給付実績食事費用15031.get事業所番号().value())
                    && 整理番号.equals(給付実績食事費用15031.get整理番号())
                    && 様式番号.equals(給付実績食事費用15031.get入力識別番号().value())
                    && サービス提供年月.equals(給付実績食事費用15031.getサービス提供年月().toDateString())) {
                給付実績食事費用1503等.add(給付実績食事費用15031);
            }
        }
        return 給付実績食事費用1503等;
    }

    private List<KyufujissekiShokujiHiyo> get食費1504サービス提供年月リスト(List<KyufujissekiShokujiHiyo> 給付実績食事費用1504) {
        List<FlexibleYearMonth> 食費1504提供年月リスト = new ArrayList<>();
        List<KyufujissekiShokujiHiyo> 給付実績食事費用 = new ArrayList<>();
        for (int i = 0; i < 給付実績食事費用1504.size(); i++) {
            FlexibleYearMonth 提供年月1 = 給付実績食事費用1504.get(i).getサービス提供年月();
            if (!食費1504提供年月リスト.contains(提供年月1)) {
                食費1504提供年月リスト.add(提供年月1);
                給付実績食事費用.add(給付実績食事費用1504.get(i));
            }
        }
        return 給付実績食事費用;
    }

    private static class DateComparatorServiceTeikyoYM implements Comparator<KyufujissekiShokujiHiyo>, Serializable {

        @Override
        public int compare(KyufujissekiShokujiHiyo o1, KyufujissekiShokujiHiyo o2) {
            return o2.getサービス提供年月().compareTo(o1.getサービス提供年月());
        }
    }

    private RString get金額(int 金額) {
        Decimal 金額変換 = new Decimal(金額);
        return DecimalFormatter.toコンマ区切りRString(金額変換, 0);
    }

    private RString to日期(FlexibleYearMonth 審査年月) {
        if (審査年月 != null && !審査年月.isEmpty()) {
            return 審査年月.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private RString 単位数変換(Decimal 単位数変換) {
        if (単位数変換 != null) {
            RString 単位数 = new RString(単位数変換.toString());
            return 単位数;
        }
        return RString.EMPTY;
    }

    private int 単価変換(Decimal 単価変換) {
        if (単価変換 != null) {
            int 単価 = 単価変換.intValue();
            return 単価;
        }
        return 0;
    }

    private static class DateComparatorServiceYM implements Comparator<KyufujissekiShokujiHiyo>, Serializable {

        @Override
        public int compare(KyufujissekiShokujiHiyo o1, KyufujissekiShokujiHiyo o2) {
            return o1.getサービス提供年月().compareTo(o2.getサービス提供年月());
        }
    }

    /**
     * サービス提供年月の前月を取得します。
     *
     * @param サービス提供年月リスト サービス提供年月リスト
     * @param サービス提供年月 サービス提供年月
     * @return FlexibleYearMonth 前月サービス提供年月
     */
    public FlexibleYearMonth get前月サービス提供年月(List<KyufujissekiShokujiHiyo> サービス提供年月リスト,
            FlexibleYearMonth サービス提供年月) {
        Collections.sort(サービス提供年月リスト, new DateComparatorServiceTeikyoYM());
        for (KyufujissekiShokujiHiyo サービス年月 : サービス提供年月リスト) {
            if (サービス年月.getサービス提供年月().isBefore(サービス提供年月)) {
                return サービス年月.getサービス提供年月();
            }
        }
        return FlexibleYearMonth.EMPTY;
    }

    /**
     * サービス提供年月の前月を取得します。
     *
     * @param サービス提供年月リスト サービス提供年月リスト
     * @param サービス提供年月 サービス提供年月
     * @return FlexibleYearMonth 次月サービス提供年月
     */
    public FlexibleYearMonth get次月サービス提供年月(List<KyufujissekiShokujiHiyo> サービス提供年月リスト, FlexibleYearMonth サービス提供年月) {
        Collections.sort(サービス提供年月リスト, new DateComparatorServiceYM());
        for (KyufujissekiShokujiHiyo サービス年月 : サービス提供年月リスト) {
            if (サービス提供年月.isBefore(サービス年月.getサービス提供年月())) {
                return サービス年月.getサービス提供年月();
            }
        }
        return FlexibleYearMonth.EMPTY;
    }
}
