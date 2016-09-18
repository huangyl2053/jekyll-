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
    private final RString 基本 = new RString("基本");
    private final RString 特別 = new RString("特別");
    private static final int INT_ZERO = 0;
    private static final int INT_SEX = 6;
    private static final RString ZERO = new RString("0");
    private static final RString NI = new RString("2");
    private static final FlexibleYearMonth 平成24年4月 = new FlexibleYearMonth("201204");
    private static final RString 前事業者 = new RString("前事業者");
    private static final int INT_1 = 1;
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
     */
    public void set給付実績食事費用15041(List<KyufujissekiShokujiHiyo> 給付実績食事費用1504等) {
        List<dgShokujiHiyoGokeiFromH1504_Row> dataSources = new ArrayList<>();
        for (KyufujissekiShokujiHiyo 給付実績食事費用1504 : 給付実績食事費用1504等) {
            if (div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toString()
                    .equals(給付実績食事費用1504.getサービス提供年月().toString())
                    && div.getCcdKyufuJissekiHeader().get事業者番号().toString()
                    .equals(給付実績食事費用1504.get事業所番号().toString())) {
                dgShokujiHiyoGokeiFromH1504_Row row_前 = new dgShokujiHiyoGokeiFromH1504_Row();
                row_前.setTxtShokujiTeikyohiGokei(get金額(給付実績食事費用1504.get基本_提供金額()));
                row_前.setTxtHyojunFutangakuTsuki(get金額(給付実績食事費用1504.get標準負担額_月額()));
                row_前.setTxtHyojunFutangakuHi(get金額(給付実績食事費用1504.get標準負担額_日額()));
                row_前.setTxtKohi(RString.EMPTY);
                row_前.setTxtShokujiTeikyoNobeNissu(new RString(給付実績食事費用1504.get食事提供延べ日数()));
                row_前.setTxtSeikyugakuZengo(前);
                row_前.setTxtKohiSeikyu(RString.EMPTY);
                row_前.setTxtShokujiTeikyohiSeikyugaku(get金額(給付実績食事費用1504.get食事提供費請求額()));
                row_前.setTxtSaishinsaKaisu(new RString(給付実績食事費用1504.get再審査回数()));
                row_前.setTxtKagoKaisu(new RString(給付実績食事費用1504.get過誤回数()));
                row_前.setTxtShinsaYM(to日期(給付実績食事費用1504.get審査年月()));
                dgShokujiHiyoGokeiFromH1504_Row row_後 = new dgShokujiHiyoGokeiFromH1504_Row();
                row_後.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_後.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_後.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_後.setTxtKohi(RString.EMPTY);
                row_後.setTxtShokujiTeikyoNobeNissu(RString.EMPTY);
                row_後.setTxtSeikyugakuZengo(後);
                row_後.setTxtKohiSeikyu(RString.EMPTY);
                row_後.setTxtShokujiTeikyohiSeikyugaku(get金額(給付実績食事費用1504.get後_食事提供費請求額()));
                row_後.setTxtSaishinsaKaisu(RString.EMPTY);
                row_後.setTxtKagoKaisu(RString.EMPTY);
                row_後.setTxtShinsaYM(RString.EMPTY);
                dgShokujiHiyoGokeiFromH1504_Row row = new dgShokujiHiyoGokeiFromH1504_Row();
                row.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row.setTxtHyojunFutangakuHi(RString.EMPTY);
                row.setTxtKohi(RString.EMPTY);
                row.setTxtShokujiTeikyoNobeNissu(RString.EMPTY);
                row.setTxtSeikyugakuZengo(RString.EMPTY);
                row.setTxtKohiSeikyu(RString.EMPTY);
                row.setTxtShokujiTeikyohiSeikyugaku(RString.EMPTY);
                row.setTxtSaishinsaKaisu(RString.EMPTY);
                row.setTxtKagoKaisu(RString.EMPTY);
                row.setTxtShinsaYM(RString.EMPTY);
                dgShokujiHiyoGokeiFromH1504_Row row_前_公費１ = new dgShokujiHiyoGokeiFromH1504_Row();
                row_前_公費１.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_前_公費１.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_前_公費１.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_前_公費１.setTxtKohi(公費１);
                row_前_公費１.setTxtShokujiTeikyoNobeNissu(RString.EMPTY);
                row_前_公費１.setTxtSeikyugakuZengo(前);
                row_前_公費１.setTxtKohiSeikyu(RString.EMPTY);
                row_前_公費１.setTxtShokujiTeikyohiSeikyugaku(RString.EMPTY);
                row_前_公費１.setTxtSaishinsaKaisu(RString.EMPTY);
                row_前_公費１.setTxtKagoKaisu(RString.EMPTY);
                row_前_公費１.setTxtShinsaYM(RString.EMPTY);
                dgShokujiHiyoGokeiFromH1504_Row row_後_公費１ = new dgShokujiHiyoGokeiFromH1504_Row();
                row_後_公費１.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_後_公費１.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_後_公費１.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_後_公費１.setTxtKohi(公費１);
                row_後_公費１.setTxtShokujiTeikyoNobeNissu(RString.EMPTY);
                row_後_公費１.setTxtSeikyugakuZengo(後);
                row_後_公費１.setTxtKohiSeikyu(RString.EMPTY);
                row_後_公費１.setTxtShokujiTeikyohiSeikyugaku(RString.EMPTY);
                row_後_公費１.setTxtSaishinsaKaisu(RString.EMPTY);
                row_後_公費１.setTxtKagoKaisu(RString.EMPTY);
                row_後_公費１.setTxtShinsaYM(RString.EMPTY);
                dgShokujiHiyoGokeiFromH1504_Row row_公費１ = new dgShokujiHiyoGokeiFromH1504_Row();
                row_公費１.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_公費１.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_公費１.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_公費１.setTxtKohi(公費１);
                row_公費１.setTxtShokujiTeikyoNobeNissu(new RString(給付実績食事費用1504.get公費１対象食事提供延べ日数()));
                row_公費１.setTxtSeikyugakuZengo(RString.EMPTY);
                row_公費１.setTxtKohiSeikyu(new RString(給付実績食事費用1504.get公費１食事提供費請求額()));
                row_公費１.setTxtShokujiTeikyohiSeikyugaku(RString.EMPTY);
                row_公費１.setTxtSaishinsaKaisu(RString.EMPTY);
                row_公費１.setTxtKagoKaisu(RString.EMPTY);
                row_公費１.setTxtShinsaYM(RString.EMPTY);
                dataSources.add(row_前);
                dataSources.add(row_後);
                dataSources.add(row);
                dataSources.add(row_前_公費１);
                dataSources.add(row_後_公費１);
                dataSources.add(row_公費１);
            }
        }
        div.getDgShokujiHiyoGokeiFromH1504().setDataSource(dataSources);
        this.set給付実績食事費用15042(給付実績食事費用1504等);
    }

    private void set給付実績食事費用15042(List<KyufujissekiShokujiHiyo> 給付実績食事費用1504等) {
        List<dgShokujiHiyoGokeiFromH1504_Row> dataSources = new ArrayList<>();
        for (KyufujissekiShokujiHiyo 給付実績食事費用1504 : 給付実績食事費用1504等) {
            if (div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toString()
                    .equals(給付実績食事費用1504.getサービス提供年月().toString())
                    && div.getCcdKyufuJissekiHeader().get事業者番号().toString()
                    .equals(給付実績食事費用1504.get事業所番号().toString())) {
                dgShokujiHiyoGokeiFromH1504_Row row_前_公費２ = new dgShokujiHiyoGokeiFromH1504_Row();
                row_前_公費２.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_前_公費２.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_前_公費２.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_前_公費２.setTxtKohi(公費２);
                row_前_公費２.setTxtShokujiTeikyoNobeNissu(RString.EMPTY);
                row_前_公費２.setTxtSeikyugakuZengo(前);
                row_前_公費２.setTxtKohiSeikyu(RString.EMPTY);
                row_前_公費２.setTxtShokujiTeikyohiSeikyugaku(RString.EMPTY);
                row_前_公費２.setTxtSaishinsaKaisu(RString.EMPTY);
                row_前_公費２.setTxtKagoKaisu(RString.EMPTY);
                row_前_公費２.setTxtShinsaYM(RString.EMPTY);
                dgShokujiHiyoGokeiFromH1504_Row row_後_公費２ = new dgShokujiHiyoGokeiFromH1504_Row();
                row_後_公費２.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_後_公費２.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_後_公費２.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_後_公費２.setTxtKohi(公費２);
                row_後_公費２.setTxtShokujiTeikyoNobeNissu(RString.EMPTY);
                row_後_公費２.setTxtSeikyugakuZengo(後);
                row_後_公費２.setTxtKohiSeikyu(RString.EMPTY);
                row_後_公費２.setTxtShokujiTeikyohiSeikyugaku(RString.EMPTY);
                row_後_公費２.setTxtSaishinsaKaisu(RString.EMPTY);
                row_後_公費２.setTxtKagoKaisu(RString.EMPTY);
                row_後_公費２.setTxtShinsaYM(RString.EMPTY);
                dgShokujiHiyoGokeiFromH1504_Row row_公費２ = new dgShokujiHiyoGokeiFromH1504_Row();
                row_公費２.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_公費２.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_公費２.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_公費２.setTxtKohi(公費２);
                row_公費２.setTxtShokujiTeikyoNobeNissu(new RString(給付実績食事費用1504.get公費２対象食事提供延べ日数()));
                row_公費２.setTxtSeikyugakuZengo(RString.EMPTY);
                row_公費２.setTxtKohiSeikyu(get金額(給付実績食事費用1504.get公費２食事提供費請求額()));
                row_公費２.setTxtShokujiTeikyohiSeikyugaku(RString.EMPTY);
                row_公費２.setTxtSaishinsaKaisu(RString.EMPTY);
                row_公費２.setTxtKagoKaisu(RString.EMPTY);
                row_公費２.setTxtShinsaYM(RString.EMPTY);
                dgShokujiHiyoGokeiFromH1504_Row row_前_公費３ = new dgShokujiHiyoGokeiFromH1504_Row();
                row_前_公費３.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_前_公費３.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_前_公費３.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_前_公費３.setTxtKohi(公費３);
                row_前_公費３.setTxtShokujiTeikyoNobeNissu(RString.EMPTY);
                row_前_公費３.setTxtSeikyugakuZengo(前);
                row_前_公費３.setTxtKohiSeikyu(RString.EMPTY);
                row_前_公費３.setTxtShokujiTeikyohiSeikyugaku(RString.EMPTY);
                row_前_公費３.setTxtSaishinsaKaisu(RString.EMPTY);
                row_前_公費３.setTxtKagoKaisu(RString.EMPTY);
                row_前_公費３.setTxtShinsaYM(RString.EMPTY);
                dgShokujiHiyoGokeiFromH1504_Row row_後_公費３ = new dgShokujiHiyoGokeiFromH1504_Row();
                row_後_公費３.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_後_公費３.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_後_公費３.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_後_公費３.setTxtKohi(公費３);
                row_後_公費３.setTxtShokujiTeikyoNobeNissu(RString.EMPTY);
                row_後_公費３.setTxtSeikyugakuZengo(後);
                row_後_公費３.setTxtKohiSeikyu(RString.EMPTY);
                row_後_公費３.setTxtShokujiTeikyohiSeikyugaku(RString.EMPTY);
                row_後_公費３.setTxtSaishinsaKaisu(RString.EMPTY);
                row_後_公費３.setTxtKagoKaisu(RString.EMPTY);
                row_後_公費３.setTxtShinsaYM(RString.EMPTY);
                dgShokujiHiyoGokeiFromH1504_Row row_公費３ = new dgShokujiHiyoGokeiFromH1504_Row();
                row_公費３.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_公費３.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_公費３.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_公費３.setTxtKohi(公費３);
                row_公費３.setTxtShokujiTeikyoNobeNissu(new RString(給付実績食事費用1504.get公費３対象食事提供延べ日数()));
                row_公費３.setTxtSeikyugakuZengo(RString.EMPTY);
                row_公費３.setTxtKohiSeikyu(get金額(給付実績食事費用1504.get公費３食事提供費請求額()));
                row_公費３.setTxtShokujiTeikyohiSeikyugaku(RString.EMPTY);
                row_公費３.setTxtSaishinsaKaisu(RString.EMPTY);
                row_公費３.setTxtKagoKaisu(RString.EMPTY);
                row_公費３.setTxtShinsaYM(RString.EMPTY);
                dataSources.add(row_前_公費２);
                dataSources.add(row_後_公費２);
                dataSources.add(row_公費２);
                dataSources.add(row_前_公費３);
                dataSources.add(row_後_公費３);
                dataSources.add(row_公費３);
            }
        }
        div.getDgShokujiHiyoGokeiFromH1504().setDataSource(dataSources);
    }

    /**
     * 給付実績明細等
     *
     * @param 給付実績明細等 List<KyufujissekiMeisaiBusiness>
     */
    public void set給付実績明細(List<KyufujissekiMeisaiBusiness> 給付実績明細等) {
        List<dgShokujiHiyoMeisaiFromH1504_Row> dataSources = new ArrayList<>();
        for (KyufujissekiMeisaiBusiness 給付実績明細 : 給付実績明細等) {
            if (div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toString()
                    .equals(給付実績明細.get給付実績明細().getサービス提供年月().toString())
                    && div.getCcdKyufuJissekiHeader().get事業者番号().toString()
                    .equals(給付実績明細.get給付実績明細().get事業所番号().toString())) {
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
     */
    public void set給付実績食事費用15031(List<KyufujissekiShokujiHiyo> 給付実績食事費用1503等) {
        List<dgShokujiHiyoToH1503_Row> dataSources = new ArrayList<>();
        for (KyufujissekiShokujiHiyo 給付実績食事費用1503 : 給付実績食事費用1503等) {
            if (div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toString()
                    .equals(給付実績食事費用1503.getサービス提供年月().toString())
                    && div.getCcdKyufuJissekiHeader().get事業者番号().toString()
                    .equals(給付実績食事費用1503.get事業所番号().toString())) {
                dgShokujiHiyoToH1503_Row row = new dgShokujiHiyoToH1503_Row();
                row.setTxtZengo(RString.EMPTY);
                row.setTxtTeikyoNissu(new RString(給付実績食事費用1503.get基本_提供日数()));
                row.setTxtTokubetsuTeikyoNissu(new RString(給付実績食事費用1503.get特別_提供日数()));
                row.setTxtTeikyoTanka(new RString(給付実績食事費用1503.get基本_提供単価()));
                row.setTxtTokubetsuTeikyoTanka(new RString(給付実績食事費用1503.get特別_提供単価()));
                row.setTxtTeikyoKingaku(new RString(給付実績食事費用1503.get基本_提供金額()));
                row.setTxtTokubetsuTeikyoKingaku(new RString(給付実績食事費用1503.get特別_提供金額()));
                row.setTxtShokujiTeikyohiGokei(get金額(給付実績食事費用1503.get食事提供費合計()));
                row.setTxtHyojunFutangakuTsuki(get金額(給付実績食事費用1503.get標準負担額_月額()));
                row.setTxtHyojunFutangakuHi(get金額(給付実績食事費用1503.get標準負担額_日額()));
                row.setTxtKohi(RString.EMPTY);
                row.setTxtShokujiTeikyoNobeNissu(new RString(給付実績食事費用1503.get食事提供延べ日数()));
                row.setTxtSeikyugakuZengo(new RString(給付実績食事費用1503.get食事提供費請求額()));
                row.setTxtKohiSeikyu(RString.EMPTY);
                row.setTxtSaishinsaKaisu(new RString(給付実績食事費用1503.get再審査回数()));
                row.setTxtKagoKaisu(new RString(給付実績食事費用1503.get過誤回数()));
                row.setTxtShinsaYM(to日期(給付実績食事費用1503.get審査年月()));
                dgShokujiHiyoToH1503_Row row_公費１ = new dgShokujiHiyoToH1503_Row();
                row_公費１.setTxtZengo(RString.EMPTY);
                row_公費１.setTxtTeikyoNissu(RString.EMPTY);
                row_公費１.setTxtTokubetsuTeikyoNissu(RString.EMPTY);
                row_公費１.setTxtTeikyoTanka(RString.EMPTY);
                row_公費１.setTxtTokubetsuTeikyoTanka(RString.EMPTY);
                row_公費１.setTxtTeikyoKingaku(RString.EMPTY);
                row_公費１.setTxtTokubetsuTeikyoKingaku(RString.EMPTY);
                row_公費１.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_公費１.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_公費１.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_公費１.setTxtKohi(公費１);
                row_公費１.setTxtShokujiTeikyoNobeNissu(new RString(給付実績食事費用1503.get公費１対象食事提供延べ日数()));
                row_公費１.setTxtSeikyugakuZengo(RString.EMPTY);
                row_公費１.setTxtKohiSeikyu(new RString(給付実績食事費用1503.get公費１食事提供費請求額()));
                row_公費１.setTxtSaishinsaKaisu(RString.EMPTY);
                row_公費１.setTxtKagoKaisu(RString.EMPTY);
                row_公費１.setTxtShinsaYM(RString.EMPTY);
                dgShokujiHiyoToH1503_Row row_公費２ = new dgShokujiHiyoToH1503_Row();
                row_公費２.setTxtZengo(RString.EMPTY);
                row_公費２.setTxtTeikyoNissu(RString.EMPTY);
                row_公費２.setTxtTokubetsuTeikyoNissu(RString.EMPTY);
                row_公費２.setTxtTeikyoTanka(RString.EMPTY);
                row_公費２.setTxtTokubetsuTeikyoTanka(RString.EMPTY);
                row_公費２.setTxtTeikyoKingaku(RString.EMPTY);
                row_公費２.setTxtTokubetsuTeikyoKingaku(RString.EMPTY);
                row_公費２.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_公費２.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_公費２.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_公費２.setTxtKohi(公費２);
                row_公費２.setTxtShokujiTeikyoNobeNissu(new RString(給付実績食事費用1503.get公費２対象食事提供延べ日数()));
                row_公費２.setTxtSeikyugakuZengo(RString.EMPTY);
                row_公費２.setTxtKohiSeikyu(new RString(給付実績食事費用1503.get公費２食事提供費請求額()));
                row_公費２.setTxtSaishinsaKaisu(RString.EMPTY);
                row_公費２.setTxtKagoKaisu(RString.EMPTY);
                row_公費２.setTxtShinsaYM(RString.EMPTY);
                dgShokujiHiyoToH1503_Row row_公費３ = new dgShokujiHiyoToH1503_Row();
                row_公費３.setTxtZengo(RString.EMPTY);
                row_公費３.setTxtTeikyoNissu(RString.EMPTY);
                row_公費３.setTxtTokubetsuTeikyoNissu(RString.EMPTY);
                row_公費３.setTxtTeikyoTanka(RString.EMPTY);
                row_公費３.setTxtTokubetsuTeikyoTanka(RString.EMPTY);
                row_公費３.setTxtTeikyoKingaku(RString.EMPTY);
                row_公費３.setTxtTokubetsuTeikyoKingaku(RString.EMPTY);
                row_公費３.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_公費３.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_公費３.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_公費３.setTxtKohi(公費３);
                row_公費３.setTxtShokujiTeikyoNobeNissu(new RString(給付実績食事費用1503.get公費３対象食事提供延べ日数()));
                row_公費３.setTxtSeikyugakuZengo(RString.EMPTY);
                row_公費３.setTxtKohiSeikyu(new RString(給付実績食事費用1503.get公費３食事提供費請求額()));
                row_公費３.setTxtSaishinsaKaisu(RString.EMPTY);
                row_公費３.setTxtKagoKaisu(RString.EMPTY);
                row_公費３.setTxtShinsaYM(RString.EMPTY);
                dataSources.add(row);
                dataSources.add(row_公費１);
                dataSources.add(row_公費２);
                dataSources.add(row_公費３);
            }
        }
        div.getDgShokujiHiyoToH1503().setDataSource(dataSources);
        this.set給付実績食事費用15032(給付実績食事費用1503等);
    }

    /**
     * 給付実績食事費用15032
     *
     * @param 給付実績食事費用1503等 List<KyufujissekiShokujiHiyo>
     */
    public void set給付実績食事費用15032(List<KyufujissekiShokujiHiyo> 給付実績食事費用1503等) {
        List<dgShokujiHiyoToH1503_Row> dataSources = new ArrayList<>();
        for (KyufujissekiShokujiHiyo 給付実績食事費用1503 : 給付実績食事費用1503等) {
            if (div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toString()
                    .equals(給付実績食事費用1503.getサービス提供年月().toString())
                    && div.getCcdKyufuJissekiHeader().get事業者番号().toString()
                    .equals(給付実績食事費用1503.get事業所番号().toString())) {
                dgShokujiHiyoToH1503_Row row_後 = new dgShokujiHiyoToH1503_Row();
                row_後.setTxtZengo(後);
                row_後.setTxtTeikyoNissu(RString.EMPTY);
                row_後.setTxtTokubetsuTeikyoNissu(RString.EMPTY);
                row_後.setTxtTeikyoTanka(new RString(給付実績食事費用1503.get後_基本食提供費用提供単価()));
                row_後.setTxtTokubetsuTeikyoTanka(new RString(給付実績食事費用1503.get後_特別食提供費用提供単価()));
                row_後.setTxtTeikyoKingaku(RString.EMPTY);
                row_後.setTxtTokubetsuTeikyoKingaku(RString.EMPTY);
                row_後.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_後.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_後.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_後.setTxtKohi(RString.EMPTY);
                row_後.setTxtShokujiTeikyoNobeNissu(RString.EMPTY);
                row_後.setTxtSeikyugakuZengo(new RString(給付実績食事費用1503.get後_食事提供費請求額()));
                row_後.setTxtKohiSeikyu(RString.EMPTY);
                row_後.setTxtSaishinsaKaisu(RString.EMPTY);
                row_後.setTxtKagoKaisu(RString.EMPTY);
                row_後.setTxtShinsaYM(RString.EMPTY);
                dgShokujiHiyoToH1503_Row row_後_公費１ = new dgShokujiHiyoToH1503_Row();
                row_後_公費１.setTxtZengo(後);
                row_後_公費１.setTxtTeikyoNissu(RString.EMPTY);
                row_後_公費１.setTxtTokubetsuTeikyoNissu(RString.EMPTY);
                row_後_公費１.setTxtTeikyoTanka(RString.EMPTY);
                row_後_公費１.setTxtTokubetsuTeikyoTanka(RString.EMPTY);
                row_後_公費１.setTxtTeikyoKingaku(RString.EMPTY);
                row_後_公費１.setTxtTokubetsuTeikyoKingaku(RString.EMPTY);
                row_後_公費１.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_後_公費１.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_後_公費１.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_後_公費１.setTxtKohi(公費１);
                row_後_公費１.setTxtShokujiTeikyoNobeNissu(RString.EMPTY);
                row_後_公費１.setTxtSeikyugakuZengo(RString.EMPTY);
                row_後_公費１.setTxtKohiSeikyu(RString.EMPTY);
                row_後_公費１.setTxtSaishinsaKaisu(RString.EMPTY);
                row_後_公費１.setTxtKagoKaisu(RString.EMPTY);
                row_後_公費１.setTxtShinsaYM(RString.EMPTY);
                dgShokujiHiyoToH1503_Row row_後_公費２ = new dgShokujiHiyoToH1503_Row();
                row_後_公費２.setTxtZengo(後);
                row_後_公費２.setTxtTeikyoNissu(RString.EMPTY);
                row_後_公費２.setTxtTokubetsuTeikyoNissu(RString.EMPTY);
                row_後_公費２.setTxtTeikyoTanka(RString.EMPTY);
                row_後_公費２.setTxtTokubetsuTeikyoTanka(RString.EMPTY);
                row_後_公費２.setTxtTeikyoKingaku(RString.EMPTY);
                row_後_公費２.setTxtTokubetsuTeikyoKingaku(RString.EMPTY);
                row_後_公費２.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_後_公費２.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_後_公費２.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_後_公費２.setTxtKohi(公費２);
                row_後_公費２.setTxtShokujiTeikyoNobeNissu(RString.EMPTY);
                row_後_公費２.setTxtSeikyugakuZengo(RString.EMPTY);
                row_後_公費２.setTxtKohiSeikyu(RString.EMPTY);
                row_後_公費２.setTxtSaishinsaKaisu(RString.EMPTY);
                row_後_公費２.setTxtKagoKaisu(RString.EMPTY);
                row_後_公費２.setTxtShinsaYM(RString.EMPTY);
                dgShokujiHiyoToH1503_Row row_後_公費３ = new dgShokujiHiyoToH1503_Row();
                row_後_公費３.setTxtZengo(後);
                row_後_公費３.setTxtTeikyoNissu(RString.EMPTY);
                row_後_公費３.setTxtTeikyoTanka(RString.EMPTY);
                row_後_公費３.setTxtTeikyoKingaku(RString.EMPTY);
                row_後_公費３.setTxtShokujiTeikyohiGokei(RString.EMPTY);
                row_後_公費３.setTxtHyojunFutangakuTsuki(RString.EMPTY);
                row_後_公費３.setTxtHyojunFutangakuHi(RString.EMPTY);
                row_後_公費３.setTxtKohi(公費３);
                row_後_公費３.setTxtShokujiTeikyoNobeNissu(RString.EMPTY);
                row_後_公費３.setTxtSeikyugakuZengo(RString.EMPTY);
                row_後_公費３.setTxtKohiSeikyu(RString.EMPTY);
                row_後_公費３.setTxtSaishinsaKaisu(RString.EMPTY);
                row_後_公費３.setTxtKagoKaisu(RString.EMPTY);
                row_後_公費３.setTxtShinsaYM(RString.EMPTY);
                dataSources.add(row_後);
                dataSources.add(row_後_公費１);
                dataSources.add(row_後_公費２);
                dataSources.add(row_後_公費３);
            }
        }
        div.getDgShokujiHiyoToH1503().setDataSource(dataSources);
    }

    /**
     * ボタン状態の設定です。
     *
     * @param 識別番号管理 識別番号管理
     * @param サービス提供年月 サービス提供年月
     */
    public void setButton(ShikibetsuNoKanri 識別番号管理, FlexibleYearMonth サービス提供年月) {
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
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(false);
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
        if (!事業者番号リスト.isEmpty()) {
            div.getBtnMaeJigyosha().setDisabled(true);
            div.getBtnAtoJigyosha().setDisabled(true);
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
    public void setGetsuBtn(List<FlexibleYearMonth> サービス提供年月リスト, FlexibleYearMonth サービス提供年月) {
        Collections.sort(サービス提供年月リスト, new DateComparatorServiceTeikyoYM());

        if (サービス提供年月.isBeforeOrEquals(サービス提供年月リスト.get(サービス提供年月リスト.size() - 1))) {
            div.getBtnZengetsu().setDisabled(true);
        } else {
            div.getBtnZengetsu().setDisabled(false);
        }
        if (サービス提供年月リスト.get(INT_ZERO).isBeforeOrEquals(サービス提供年月)) {
            div.getBtnJigetsu().setDisabled(true);
        } else {
            div.getBtnJigetsu().setDisabled(false);
        }
    }

    /**
     * change事業者です
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
            setDataGrid(事業者番号リスト.get(index + i).getサービス提供年月(), 給付実績食事費用1504, 給付実績明細, 給付実績食事費用1503);
            div.getBtnMaeJigyosha().setDisabled(true);
            div.getBtnAtoJigyosha().setDisabled(true);
            if (index + i - 1 > 0) {
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

    private void setDataGrid(FlexibleYearMonth サービス提供年月,
            List<KyufujissekiShokujiHiyo> 給付実績食事費用1504,
            List<KyufujissekiMeisaiBusiness> 給付実績明細,
            List<KyufujissekiShokujiHiyo> 給付実績食事費用1503) {
        if (提供年月.isBeforeOrEquals(サービス提供年月)) {
            for (KyufujissekiShokujiHiyo 給付実績食事費用15041 : 給付実績食事費用1504) {
                div.getBtnZengetsu().setDisabled(サービス提供年月.minusMonth(INT_1).equals(給付実績食事費用15041.getサービス提供年月()));
                div.getBtnJigetsu().setDisabled(サービス提供年月.plusMonth(INT_1).equals(給付実績食事費用15041.getサービス提供年月()));
            }
            set給付実績食事費用15041(給付実績食事費用1504);
            for (KyufujissekiMeisaiBusiness 給付実績明細1 : 給付実績明細) {
                div.getBtnZengetsu().setDisabled(サービス提供年月.minusMonth(INT_1).equals(給付実績明細1.get給付実績明細().getサービス提供年月()));
                div.getBtnJigetsu().setDisabled(サービス提供年月.plusMonth(INT_1).equals(給付実績明細1.get給付実績明細().getサービス提供年月()));
            }
            set給付実績明細(給付実績明細);
        } else {
            for (KyufujissekiShokujiHiyo 給付実績食事費用15031 : 給付実績食事費用1503) {
                div.getBtnZengetsu().setDisabled(サービス提供年月.minusMonth(INT_1).equals(給付実績食事費用15031.getサービス提供年月()));
                div.getBtnJigetsu().setDisabled(サービス提供年月.plusMonth(INT_1).equals(給付実績食事費用15031.getサービス提供年月()));
            }
            set給付実績食事費用15031(給付実績食事費用1503);
        }
    }

    /**
     * change食費1504年月です。
     *
     * @param data RString
     * @param 給付実績食事費用1504 List<KyufujissekiShokujiHiyo>
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 被保険者番号 HihokenshaNo
     * @param 識別番号 NyuryokuShikibetsuNo
     */
    public void change食費1504年月(RString data, List<KyufujissekiShokujiHiyo> 給付実績食事費用1504,
            FlexibleYearMonth サービス提供年月, RString 整理番号, HihokenshaNo 被保険者番号, NyuryokuShikibetsuNo 識別番号) {
        int index = INT_ZERO;
        List<FlexibleYearMonth> サービス提供年月リスト = get食費1504サービス提供年月リスト(給付実績食事費用1504);
        Collections.sort(サービス提供年月リスト, new DateComparatorServiceTeikyoYM());
        for (int i = 0; i < サービス提供年月リスト.size(); i++) {
            if (サービス提供年月.equals(サービス提供年月リスト.get(i))) {
                index = i;
                break;
            }
        }
        FlexibleYearMonth 今提供年月 = FlexibleYearMonth.EMPTY;
        if (INT_ZERO < index && index < サービス提供年月リスト.size() - 1) {
            if (前月.equals(data)) {
                今提供年月 = サービス提供年月リスト.get(index + 1);
            } else {
                今提供年月 = サービス提供年月リスト.get(index - 1);
            }
        }
        this.set給付実績食事費用15041(get給付実績食事費用1504等(給付実績食事費用1504, div.getCcdKyufuJissekiHeader().get整理番号(),
                div.getCcdKyufuJissekiHeader().get事業者番号(),
                div.getCcdKyufuJissekiHeader().get様式番号(),
                今提供年月.toDateString()));
        div.getCcdKyufuJissekiHeader().initialize(被保険者番号, 今提供年月, 整理番号, 識別番号);
        setGetsuBtn(サービス提供年月リスト, 今提供年月);
    }

    /**
     * change明細年月です。
     *
     * @param data RString
     * @param 給付実績明細 List<KyufujissekiMeisaiBusiness>
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 被保険者番号 HihokenshaNo
     * @param 識別番号 NyuryokuShikibetsuNo
     */
    public void change明細年月(RString data, List<KyufujissekiMeisaiBusiness> 給付実績明細,
            FlexibleYearMonth サービス提供年月, RString 整理番号, HihokenshaNo 被保険者番号, NyuryokuShikibetsuNo 識別番号) {
        int index = INT_ZERO;
        List<FlexibleYearMonth> サービス提供年月リスト = get明細サービス提供年月リスト(給付実績明細);
        Collections.sort(サービス提供年月リスト, new DateComparatorServiceTeikyoYM());
        for (int i = 0; i < サービス提供年月リスト.size(); i++) {
            if (サービス提供年月.equals(サービス提供年月リスト.get(i))) {
                index = i;
                break;
            }
        }
        FlexibleYearMonth 今提供年月 = FlexibleYearMonth.EMPTY;
        if (INT_ZERO < index && index < サービス提供年月リスト.size() - 1) {
            if (前月.equals(data)) {
                今提供年月 = サービス提供年月リスト.get(index + 1);
            } else {
                今提供年月 = サービス提供年月リスト.get(index - 1);
            }
        }
        this.set給付実績明細(get給付実績明細等(給付実績明細, div.getCcdKyufuJissekiHeader().get整理番号(),
                div.getCcdKyufuJissekiHeader().get事業者番号(),
                div.getCcdKyufuJissekiHeader().get様式番号(),
                今提供年月.toDateString()));
        div.getCcdKyufuJissekiHeader().initialize(被保険者番号, 今提供年月, 整理番号, 識別番号);
        setGetsuBtn(サービス提供年月リスト, 今提供年月);
    }

    /**
     * change食費1503年月です。
     *
     * @param data RString
     * @param 給付実績食事費用1503 List<KyufujissekiShokujiHiyo>
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 被保険者番号 HihokenshaNo
     * @param 識別番号 NyuryokuShikibetsuNo
     */
    public void change食費1503年月(RString data, List<KyufujissekiShokujiHiyo> 給付実績食事費用1503,
            FlexibleYearMonth サービス提供年月, RString 整理番号, HihokenshaNo 被保険者番号, NyuryokuShikibetsuNo 識別番号) {
        int index = INT_ZERO;
        List<FlexibleYearMonth> サービス提供年月リスト = get食費1503サービス提供年月リスト(給付実績食事費用1503);
        Collections.sort(サービス提供年月リスト, new DateComparatorServiceTeikyoYM());
        for (int i = 0; i < サービス提供年月リスト.size(); i++) {
            if (サービス提供年月.equals(サービス提供年月リスト.get(i))) {
                index = i;
                break;
            }
        }
        FlexibleYearMonth 今提供年月 = FlexibleYearMonth.EMPTY;
        if (INT_ZERO < index && index < サービス提供年月リスト.size() - 1) {
            if (前月.equals(data)) {
                今提供年月 = サービス提供年月リスト.get(index + 1);
            } else {
                今提供年月 = サービス提供年月リスト.get(index - 1);
            }
        }
        this.set給付実績食事費用15031(get給付実績食事費用1503等(給付実績食事費用1503, div.getCcdKyufuJissekiHeader().get整理番号(),
                div.getCcdKyufuJissekiHeader().get事業者番号(),
                div.getCcdKyufuJissekiHeader().get様式番号(),
                今提供年月.toDateString()));
        div.getCcdKyufuJissekiHeader().initialize(被保険者番号, 今提供年月, 整理番号, 識別番号);
        setGetsuBtn(サービス提供年月リスト, 今提供年月);
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

    private List<FlexibleYearMonth> get食費1504サービス提供年月リスト(List<KyufujissekiShokujiHiyo> 給付実績食事費用1504) {
        List<FlexibleYearMonth> 食費1504提供年月リスト = new ArrayList<>();
        for (int i = 0; i < 給付実績食事費用1504.size(); i++) {
            FlexibleYearMonth 提供年月1 = 給付実績食事費用1504.get(i).getサービス提供年月();
            if (!食費1504提供年月リスト.contains(提供年月1)) {
                食費1504提供年月リスト.add(提供年月1);
            }
        }
        return 食費1504提供年月リスト;
    }

    private List<FlexibleYearMonth> get明細サービス提供年月リスト(List<KyufujissekiMeisaiBusiness> 給付実績明細) {
        List<FlexibleYearMonth> 明細提供年月リスト = new ArrayList<>();
        for (int i = 0; i < 給付実績明細.size(); i++) {
            FlexibleYearMonth 提供年月1 = 給付実績明細.get(i).get給付実績明細().getサービス提供年月();
            if (!明細提供年月リスト.contains(提供年月1)) {
                明細提供年月リスト.add(提供年月1);
            }
        }
        return 明細提供年月リスト;
    }

    private List<FlexibleYearMonth> get食費1503サービス提供年月リスト(List<KyufujissekiShokujiHiyo> 給付実績食事費用1503) {
        List<FlexibleYearMonth> 食費1503提供年月リスト = new ArrayList<>();
        for (int i = 0; i < 給付実績食事費用1503.size(); i++) {
            FlexibleYearMonth 提供年月1 = 給付実績食事費用1503.get(i).getサービス提供年月();
            if (!食費1503提供年月リスト.contains(提供年月1)) {
                食費1503提供年月リスト.add(提供年月1);
            }
        }
        return 食費1503提供年月リスト;
    }

    private static class DateComparatorServiceTeikyoYM implements Comparator<FlexibleYearMonth>, Serializable {

        @Override
        public int compare(FlexibleYearMonth o1, FlexibleYearMonth o2) {
            return o2.compareTo(o1);
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
}
