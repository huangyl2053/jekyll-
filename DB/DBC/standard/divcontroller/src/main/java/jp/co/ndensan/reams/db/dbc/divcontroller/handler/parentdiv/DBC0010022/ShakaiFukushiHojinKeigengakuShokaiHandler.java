/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010022;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiShakaiFukushiHojinKeigengakuBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010022.ShakaiFukushiHojinKeigengakuShokaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010022.dgShakaiFukushiHojinKeigengaku_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 給付実績の社会福祉法人軽減額を照会の画面処理Handlerクラスです。
 *
 * @reamsid_L DBC-2970-140 zhaoyao
 */
public class ShakaiFukushiHojinKeigengakuShokaiHandler {

    private final ShakaiFukushiHojinKeigengakuShokaiDiv div;
    private static final RString 後 = new RString("後");
    private static final int INT_ZERO = 0;
    private static final RString ZERO = new RString("0");
    private static final RString 前事業者 = new RString("前事業者");
    private static final RString 前月 = new RString("前月");
    private static final RString 次月 = new RString("次月");

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public ShakaiFukushiHojinKeigengakuShokaiHandler(ShakaiFukushiHojinKeigengakuShokaiDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期化です。
     *
     * @param 給付実績社会福祉法人軽減額リスト List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness>
     * @param 整理番号 RString
     * @param 事業者番号 RString
     * @param 様式番号 RString
     * @param サービス提供年月 RString
     */
    public void onLoad(List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness> 給付実績社会福祉法人軽減額リスト,
            RString 整理番号, RString 事業者番号, RString 様式番号, RString サービス提供年月) {
        List<dgShakaiFukushiHojinKeigengaku_Row> rowList = new ArrayList<>();
        List<dgShakaiFukushiHojinKeigengaku_Row> rowListKo = new ArrayList<>();
        List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness> 給付実績社会福祉法人軽減額データ
                = get給付実績のデータ(給付実績社会福祉法人軽減額リスト, 整理番号, 事業者番号, 様式番号, サービス提供年月);
        for (KyufuJissekiShakaiFukushiHojinKeigengakuBusiness 給付実績社会福祉法人軽減額 : 給付実績社会福祉法人軽減額データ) {
            rowList.add(setEmptyRowData(給付実績社会福祉法人軽減額));
        }
        for (KyufuJissekiShakaiFukushiHojinKeigengakuBusiness 給付実績社会福祉法人軽減額 : 給付実績社会福祉法人軽減額データ) {
            rowListKo.add(setKoRowData(給付実績社会福祉法人軽減額));
        }
        rowList.addAll(rowListKo);
        div.getDgShakaiFukushiHojinKeigengaku().setDataSource(rowList);
        setGetsuBtn(getサービス提供年月リスト(給付実績社会福祉法人軽減額リスト), new FlexibleYearMonth(サービス提供年月));
    }

    private dgShakaiFukushiHojinKeigengaku_Row setEmptyRowData(
            KyufuJissekiShakaiFukushiHojinKeigengakuBusiness 給付実績社会福祉法人軽減額) {
        RString 審査年月 = RString.EMPTY;
        if (給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get審査年月() != null) {
            審査年月 = 給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get審査年月().wareki().toDateString();
        }
        dgShakaiFukushiHojinKeigengaku_Row row = new dgShakaiFukushiHojinKeigengaku_Row();
        row.setTxtKeigenritsu(new RString(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get軽減率().intValue()));
        row.setTxtShurui(給付実績社会福祉法人軽減額.getサービス種類略称());
        row.setTxtZengo(RString.EMPTY);
        row.setTxtJuryoSubekiRiyoshaFutanSogaku(kinngakuFormat(
                給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get受領すべき利用者負担の総額()));
        row.setTxtKeigengaku(kinngakuFormat(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get軽減額()));
        row.setTxtKeigengoRiyoshaFutangaku(kinngakuFormat(
                給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get軽減後利用者負担額()));
        row.setTxtBiko(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get備考());
        row.setTxtSaishinsaKaisu(new RString(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get再審査回数()));
        row.setTxtKagoKaisu(new RString(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get過誤回数()));
        row.setTxtShinsaYM(審査年月);
        return row;
    }

    private dgShakaiFukushiHojinKeigengaku_Row setKoRowData(
            KyufuJissekiShakaiFukushiHojinKeigengakuBusiness 給付実績社会福祉法人軽減額) {
        RString 審査年月 = RString.EMPTY;
        if (給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get審査年月() != null) {
            審査年月 = 給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get審査年月().wareki().toDateString();
        }
        dgShakaiFukushiHojinKeigengaku_Row row = new dgShakaiFukushiHojinKeigengaku_Row();
        row.setTxtKeigenritsu(new RString(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get軽減率().intValue()));
        row.setTxtShurui(給付実績社会福祉法人軽減額.getサービス種類略称());
        row.setTxtZengo(後);
        row.setTxtJuryoSubekiRiyoshaFutanSogaku(kinngakuFormat(
                給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get後_受領すべき利用者負担の総額()));
        row.setTxtKeigengaku(kinngakuFormat(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get後_軽減額()));
        row.setTxtKeigengoRiyoshaFutangaku(kinngakuFormat(
                給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get後_軽減後利用者負担額()));
        row.setTxtBiko(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get備考());
        row.setTxtSaishinsaKaisu(new RString(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get再審査回数()));
        row.setTxtKagoKaisu(new RString(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get過誤回数()));
        row.setTxtShinsaYM(審査年月);
        return row;
    }

    /**
     * 給付実績社会福祉法人軽減額DataGrid設定。
     *
     * @param 給付実績社会福祉法人軽減額リスト List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness>
     * @param 整理番号 RString
     * @param 事業者番号 RString
     * @param 様式番号 RString
     * @param サービス提供年月 RString
     * @return 給付実績社会福祉法人軽減額データ
     */
    public List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness> get給付実績のデータ(
            List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness> 給付実績社会福祉法人軽減額リスト,
            RString 整理番号, RString 事業者番号, RString 様式番号, RString サービス提供年月) {
        List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness> 給付実績社会福祉法人軽減額データ = new ArrayList<>();
        for (KyufuJissekiShakaiFukushiHojinKeigengakuBusiness 給付実績社会福祉法人軽減額 : 給付実績社会福祉法人軽減額リスト) {
            if (事業者番号.equals(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get事業所番号().value())
                    && 整理番号.equals(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get整理番号())
                    && 様式番号.equals(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get入力識別番号().value())
                    && サービス提供年月.equals(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().getサービス提供年月().toDateString())) {
                給付実績社会福祉法人軽減額データ.add(給付実績社会福祉法人軽減額);
            }
        }
        return 給付実績社会福祉法人軽減額データ;
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
     * 事業者番号の設定です。
     *
     * @param 事業者番号リスト List<KyufuJissekiHedajyoho2>
     * @param 整理番号 RString
     * @param 事業者番号 RString
     * @param 様式番号 RString
     * @param サービス提供年月 RString
     * @param 実績区分コード RString
     * @return index index
     */
    public int get事業者番号index(List<KyufuJissekiHedajyoho2> 事業者番号リスト, RString 整理番号, RString 事業者番号,
            RString 様式番号, RString サービス提供年月, RString 実績区分コード) {
        for (int index = 0; index < 事業者番号リスト.size(); index++) {
            if (事業者番号.equals(事業者番号リスト.get(index).get事業所番号().value())
                    && 整理番号.equals(事業者番号リスト.get(index).get整理番号())
                    && 様式番号.equals(事業者番号リスト.get(index).get識別番号())
                    && サービス提供年月.equals(事業者番号リスト.get(index).getサービス提供年月().toDateString())
                    && 実績区分コード.equals(事業者番号リスト.get(index).get給付実績区分コード())) {
                return index;
            }
        }
        return INT_ZERO;
    }

    /**
     * 前次月ボタン状態設定。
     *
     * @param サービス提供年月リスト サービス提供年月リスト
     * @param サービス提供年月 サービス提供年月
     */
    public void setGetsuBtn(List<FlexibleYearMonth> サービス提供年月リスト,
            FlexibleYearMonth サービス提供年月) {
        Collections.sort(サービス提供年月リスト, new DateComparatorServiceTeikyoYM());
        div.getBtnZengetsu().setDisabled(true);
        div.getBtnJigetsu().setDisabled(true);
        if (サービス提供年月リスト != null && !サービス提供年月リスト.isEmpty()) {
            if (!サービス提供年月.isBeforeOrEquals(サービス提供年月リスト.get(サービス提供年月リスト.size() - 1))) {
                div.getBtnZengetsu().setDisabled(false);
            }
            if (!サービス提供年月リスト.get(INT_ZERO).isBeforeOrEquals(サービス提供年月)) {
                div.getBtnJigetsu().setDisabled(false);
            }
        }
    }

    /**
     * change事業者です。
     *
     * @param date 事業者フラグ
     * @param 事業者番号リスト 事業者番号リスト
     * @param 給付実績社会福祉法人軽減額リスト 給付実績社会福祉法人軽減額リスト
     */
    public void change事業者(RString date, List<KyufuJissekiHedajyoho2> 事業者番号リスト,
            List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness> 給付実績社会福祉法人軽減額リスト) {
        List<dgShakaiFukushiHojinKeigengaku_Row> rowList = new ArrayList<>();
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 整理番号 = div.getCcdKyufuJissekiHeader().get整理番号();
        RString サービス提供年月 = div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        div.getBtnAtoJigyosha().setDisabled(true);
        div.getBtnMaeJigyosha().setDisabled(true);
        事業者番号リスト = get事業者番号リスト(事業者番号リスト, new FlexibleYearMonth(サービス提供年月));
        int index = get事業者番号index(事業者番号リスト, 整理番号, 事業者番号, 様式番号, サービス提供年月, 実績区分コード);
        int i;
        if (前事業者.equals(date)) {
            i = -1;
        } else {
            i = 1;
        }
        if (index + i < 事業者番号リスト.size() && -1 < index + i) {
            div.getCcdKyufuJissekiHeader().set事業者名称(事業者番号リスト.get(index + i).get事業者名称());
            div.getCcdKyufuJissekiHeader().set実績区分(事業者番号リスト.get(index + i).get給付実績区分コード());
            div.getCcdKyufuJissekiHeader().set整理番号(事業者番号リスト.get(index + i).get整理番号());
            div.getCcdKyufuJissekiHeader().set識別番号名称(事業者番号リスト.get(index + i).get識別番号名称());
            div.getCcdKyufuJissekiHeader().set事業者番号(事業者番号リスト.get(index + i).get事業所番号().value());
            div.getCcdKyufuJissekiHeader().set様式番号(事業者番号リスト.get(index + i).get識別番号());
            List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness> 給付実績福祉用具販売データ取得リスト
                    = new ArrayList<>();
            for (KyufuJissekiShakaiFukushiHojinKeigengakuBusiness 給付実績社会福祉法人軽減額 : 給付実績社会福祉法人軽減額リスト) {
                if (div.getCcdKyufuJissekiHeader().get事業者番号()
                        .equals(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get事業所番号().value())) {
                    給付実績福祉用具販売データ取得リスト.add(給付実績社会福祉法人軽減額);
                }
            }
            List<FlexibleYearMonth> サービス提供年月リスト = getサービス提供年月リスト(給付実績福祉用具販売データ取得リスト);
            setGetsuBtn(サービス提供年月リスト, new FlexibleYearMonth(サービス提供年月));
            List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness> 給付実績社会福祉法人軽減額データ取得リスト
                    = get給付実績のデータ(給付実績社会福祉法人軽減額リスト, 事業者番号リスト.get(index + i).get整理番号(),
                            事業者番号リスト.get(index + i).get事業所番号().value(),
                            事業者番号リスト.get(index + i).get識別番号(),
                            事業者番号リスト.get(index + i).getサービス提供年月().toDateString());
            for (KyufuJissekiShakaiFukushiHojinKeigengakuBusiness 給付実績社会福祉法人軽減額データ取得 : 給付実績社会福祉法人軽減額データ取得リスト) {
                rowList.add(setEmptyRowData(給付実績社会福祉法人軽減額データ取得));
                rowList.add(setKoRowData(給付実績社会福祉法人軽減額データ取得));
            }
        }
        div.getDgShakaiFukushiHojinKeigengaku().setDataSource(rowList);
        if (0 < index + i) {
            div.getBtnMaeJigyosha().setDisabled(false);
        }
        if (index + i + 1 < 事業者番号リスト.size()) {
            div.getBtnAtoJigyosha().setDisabled(false);
        }
    }

    private List<KyufuJissekiHedajyoho2> get事業者番号リスト(List<KyufuJissekiHedajyoho2> 事業者番号リスト, FlexibleYearMonth サービス提供年月) {
        List<KyufuJissekiHedajyoho2> 今事業者番号リスト = new ArrayList<>();
        for (KyufuJissekiHedajyoho2 事業者番号 : 事業者番号リスト) {
            if (事業者番号.getサービス提供年月().equals(サービス提供年月)) {
                今事業者番号リスト.add(事業者番号);
            }
        }
        return 今事業者番号リスト;
    }

    /**
     * change年月です。
     *
     * @param data RString
     * @param 給付実績社会福祉法人軽減額リスト List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness>
     * @param 事業者番号リスト List<KyufuJissekiHedajyoho2>
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 被保険者番号 HihokenshaNo
     * @param 識別番号 NyuryokuShikibetsuNo
     */
    public void change年月(RString data, List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness> 給付実績社会福祉法人軽減額リスト,
            List<KyufuJissekiHedajyoho2> 事業者番号リスト, FlexibleYearMonth サービス提供年月, RString 整理番号,
            HihokenshaNo 被保険者番号, NyuryokuShikibetsuNo 識別番号) {
        List<dgShakaiFukushiHojinKeigengaku_Row> rowList = new ArrayList<>();
        int index = INT_ZERO;
        List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness> 給付実績福祉用具販売データ取得リスト
                = new ArrayList<>();
        for (KyufuJissekiShakaiFukushiHojinKeigengakuBusiness 給付実績社会福祉法人軽減額 : 給付実績社会福祉法人軽減額リスト) {
            if (div.getCcdKyufuJissekiHeader().get事業者番号()
                    .equals(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get事業所番号().value())) {
                給付実績福祉用具販売データ取得リスト.add(給付実績社会福祉法人軽減額);
            }
        }
        List<FlexibleYearMonth> サービス提供年月リスト = getサービス提供年月リスト(給付実績福祉用具販売データ取得リスト);
        Collections.sort(サービス提供年月リスト, new DateComparatorServiceTeikyoYM());
        for (int i = 0; i < サービス提供年月リスト.size(); i++) {
            if (サービス提供年月.equals(サービス提供年月リスト.get(i))) {
                index = i;
                break;
            }
        }
        FlexibleYearMonth 今提供年月 = サービス提供年月;
        if (INT_ZERO <= index && index <= サービス提供年月リスト.size() - 1) {
            if (前月.equals(data) && index != サービス提供年月リスト.size() - 1) {
                今提供年月 = サービス提供年月リスト.get(index + 1);
            } else if (次月.equals(data) && INT_ZERO != index) {
                今提供年月 = サービス提供年月リスト.get(index - 1);
            }
        }
        List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness> 給付実績福祉用具販売費等データ取得リスト
                = get給付実績のデータ(給付実績社会福祉法人軽減額リスト, div.getCcdKyufuJissekiHeader().get整理番号(),
                        div.getCcdKyufuJissekiHeader().get事業者番号(),
                        div.getCcdKyufuJissekiHeader().get様式番号(),
                        今提供年月.toDateString());
        div.getCcdKyufuJissekiHeader().initialize(被保険者番号, 今提供年月, 整理番号, 識別番号);
        for (KyufuJissekiShakaiFukushiHojinKeigengakuBusiness 給付実績福祉用具販売費等データ取得 : 給付実績福祉用具販売費等データ取得リスト) {
            rowList.add(setEmptyRowData(給付実績福祉用具販売費等データ取得));
            rowList.add(setKoRowData(給付実績福祉用具販売費等データ取得));
        }
        div.getDgShakaiFukushiHojinKeigengaku().setDataSource(rowList);
        setGetsuBtn(サービス提供年月リスト, 今提供年月);
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        事業者番号リスト = get事業者番号リスト(事業者番号リスト, 今提供年月);
        setJigyoshaBtn(事業者番号リスト, div.getCcdKyufuJissekiHeader().get整理番号(),
                事業者番号, 様式番号, 今提供年月.toDateString(), 実績区分コード);
    }

    private List<FlexibleYearMonth> getサービス提供年月リスト(List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness> 給付実績社会福祉法人軽減額リスト) {
        List<FlexibleYearMonth> 提供年月リスト = new ArrayList<>();
        for (KyufuJissekiShakaiFukushiHojinKeigengakuBusiness 給付実績社会福祉法人軽減額 : 給付実績社会福祉法人軽減額リスト) {
            FlexibleYearMonth 提供年月 = 給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().getサービス提供年月();
            if (!提供年月リスト.contains(提供年月)) {
                提供年月リスト.add(提供年月);
            }
        }
        return 提供年月リスト;
    }

    /**
     * ボタン状態の設定です。
     *
     * @param 識別番号管理 識別番号管理
     */
    public void setButton(ShikibetsuNoKanri 識別番号管理) {
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
        if (ZERO.equals(識別番号管理.get所定疾患施設療養設定区分())) {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get緊急時施設療養設定区分())) {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get食事費用設定区分())) {
            div.getBtnShokuji().setDisabled(true);
        } else {
            div.getBtnShokuji().setDisabled(false);
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
        div.getBtnShafukuKeigen().setDisabled(true);
    }

    private RString kinngakuFormat(Decimal date) {
        if (date == null || date == Decimal.ZERO) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(date, INT_ZERO);
    }

    private static class DateComparatorServiceTeikyoYM implements Comparator<FlexibleYearMonth>, Serializable {

        private static final long serialVersionUID = -358607129021022956L;

        @Override
        public int compare(FlexibleYearMonth o1, FlexibleYearMonth o2) {
            return o2.compareTo(o1);
        }
    }
}
