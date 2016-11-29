/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010020;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKogakuKaigoServicehi;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKogakuKaigoServicehiRelate;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010020.KogakuKaigoServiceMainDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 給付実績照会の高額介護サービス費のHandlerです
 *
 * @reamsid_L DBC-2970-120 guoqilin
 */
public class KogakuKaigoServiceHandler {

    private final KogakuKaigoServiceMainDiv div;
    private static final int INT_ZERO = 0;
    private static final RString 前月 = new RString("前月");

    /**
     * コンストラクタです。
     *
     * @param div KogakuKaigoServiceMainDiv
     */
    public KogakuKaigoServiceHandler(KogakuKaigoServiceMainDiv div) {
        this.div = div;
    }

    /**
     * 高額介護サービス費等選別
     *
     * @param 給付実績高額介護サービス費データ 給付実績高額介護サービス費データ
     */
    public void set給付実績高額介護サービス費データ(KyufujissekiKogakuKaigoServicehiRelate 給付実績高額介護サービス費データ) {
        div.getCcdKyufuJissekiHeader().set被保情報2_1(給付実績高額介護サービス費データ);
        KyufujissekiKogakuKaigoServicehi 高額介護サービス費 = 給付実績高額介護サービス費データ.get給付実績高額介護サービス費();
        div.getTxtKogakuKaigoServicehiKetteiYMD().setValue(to日期変換(高額介護サービス費.get決定年月日()));
        div.getTxtKogakuKaigoServicehiUketsukeYMD().setValue(to日期変換(高額介護サービス費.get受付年月日()));
        div.getTxtKogakuKaigoServicehiShinsaYM().setValue(to日期変換(高額介護サービス費.get審査年月()));
        div.getTxtKogakuKaigoServicehiSofuYM().setValue(to日期変換(高額介護サービス費.get送付年月()));
        div.getTxtKogakuKaigoServicehiRiyoshaFutangaku().setValue(get金額(高額介護サービス費.get利用者負担額()));
        div.getTxtKogakuKaigoServicehiShikyugaku().setValue(get金額(高額介護サービス費.get支給額()));
        div.getTxtKogakuKaigoServicehiKohi1FutanshaNo().setValue(get負担番号(高額介護サービス費.get公費１負担番号()));
        div.getTxtKogakuKaigoServicehiKohi2FutanshaNo().setValue(get負担番号(高額介護サービス費.get公費２負担番号()));
        div.getTxtKogakuKaigoServicehiKohi3FutanshaNo().setValue(get負担番号(高額介護サービス費.get公費３負担番号()));
        div.getTxtKogakuKaigoServicehiKohi1Futangaku().setValue(get金額(高額介護サービス費.get公費１負担額()));
        div.getTxtKogakuKaigoServicehiKohi2Futangaku().setValue(get金額(高額介護サービス費.get公費２負担額()));
        div.getTxtKogakuKaigoServicehiKohi3Futangaku().setValue(get金額(高額介護サービス費.get公費３負担額()));
        div.getTxtKogakuKaigoServicehiKohi1Shikyugaku().setValue(get金額(高額介護サービス費.get公費１支給額()));
        div.getTxtKogakuKaigoServicehiKohi2Shikyugaku().setValue(get金額(高額介護サービス費.get公費２支給額()));
        div.getTxtKogakuKaigoServicehiKohi3Shikyugaku().setValue(get金額(高額介護サービス費.get公費３支給額()));
        clear制御性();
    }

    /**
     *
     * 制御性設定です。
     *
     */
    public void clear制御性() {
        div.getBtnKogakuKaigoService().setDisabled(true);
        div.getBtnKihon().setDisabled(true);
        div.getBtnMeisaiShukei().setDisabled(true);
        div.getBtnShokuji().setDisabled(true);
        div.getBtnFukushiYoguKonyu().setDisabled(true);
        div.getBtnTokuteiNyushosha().setDisabled(true);
        div.getBtnTokuteiShinryo().setDisabled(true);
        div.getBtnKyotakuServiceKeikaku().setDisabled(true);
        div.getBtnJutakuKaishu().setDisabled(true);
        div.getBtnCareManagement().setDisabled(true);
        div.getBtnShafukuKeigen().setDisabled(true);
        div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(true);
        div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
    }

    /**
     * change年月です。
     *
     * @param data RString
     * @param 高額介護サービス費リスト List<KyufujissekiKogakuKaigoServicehi>
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 被保険者番号 HihokenshaNo
     * @param 識別番号 NyuryokuShikibetsuNo
     */
    public void change年月(RString data, List<KyufujissekiKogakuKaigoServicehi> 高額介護サービス費リスト,
            FlexibleYearMonth サービス提供年月, RString 整理番号, HihokenshaNo 被保険者番号, NyuryokuShikibetsuNo 識別番号) {
        FlexibleYearMonth 今提供年月 = get今提供年月(data, 高額介護サービス費リスト, サービス提供年月);
        if (!今提供年月.isEmpty()) {
            div.getCcdKyufuJissekiHeader().initialize(被保険者番号, 今提供年月, 整理番号, 識別番号);
            //set給付実績高額介護サービス費データ(高額介護サービス費リスト, 今提供年月);
            setGetsuBtn(高額介護サービス費リスト, 今提供年月);
        }
    }

    /**
     * 今提供年月を取得。
     *
     * @param data RString
     * @param 高額介護サービス費リスト List<KyufujissekiKogakuKaigoServicehi>
     * @param サービス提供年月 FlexibleYearMonth
     * @return 今提供年月
     */
    public FlexibleYearMonth get今提供年月(RString data,
            List<KyufujissekiKogakuKaigoServicehi> 高額介護サービス費リスト,
            FlexibleYearMonth サービス提供年月) {
        List<FlexibleYearMonth> サービス提供年月リスト = getサービス提供年月リスト(高額介護サービス費リスト);
        FlexibleYearMonth 今提供年月 = FlexibleYearMonth.EMPTY;
        if (サービス提供年月リスト != null && !サービス提供年月リスト.isEmpty()) {
            if (前月.equals(data)) {
                今提供年月 = get前月サービス提供年月(サービス提供年月リスト, サービス提供年月);
            } else {
                今提供年月 = get次月サービス提供年月(サービス提供年月リスト, サービス提供年月);
            }
        }
        return 今提供年月;
    }

    private List<FlexibleYearMonth> getサービス提供年月リスト(List<KyufujissekiKogakuKaigoServicehi> 高額介護サービス費リスト) {
        List<FlexibleYearMonth> サービス提供年月リスト = new ArrayList<>();
        for (KyufujissekiKogakuKaigoServicehi 高額介護サービス費 : 高額介護サービス費リスト) {
            FlexibleYearMonth 提供年月 = 高額介護サービス費.getサービス提供年月();
            if (!サービス提供年月リスト.contains(提供年月)) {
                サービス提供年月リスト.add(提供年月);
            }
        }
        return サービス提供年月リスト;
    }

    private void setGetsuBtn(List<KyufujissekiKogakuKaigoServicehi> 高額介護サービス費リスト, FlexibleYearMonth サービス提供年月) {
        List<FlexibleYearMonth> サービス提供年月リスト = getサービス提供年月リスト(高額介護サービス費リスト);
        div.getBtnZengetsu().setDisabled(true);
        div.getBtnJigetsu().setDisabled(true);
        if (サービス提供年月リスト != null && !サービス提供年月リスト.isEmpty()) {
            Collections.sort(サービス提供年月リスト, new DateComparatorServiceTeikyoYM());
            if (!サービス提供年月.isBeforeOrEquals(サービス提供年月リスト.get(サービス提供年月リスト.size() - 1))) {
                div.getBtnZengetsu().setDisabled(false);
            }
            if (!サービス提供年月リスト.get(INT_ZERO).isBeforeOrEquals(サービス提供年月)) {
                div.getBtnJigetsu().setDisabled(false);
            }
        }
    }

    private RString to日期変換(FlexibleDate 日期) {
        if (日期 != null && !日期.isEmpty()) {
            return 日期.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private RString to日期変換(FlexibleYearMonth 日期) {
        if (日期 != null && !日期.isEmpty()) {
            return 日期.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private RString get金額(int 金額) {
        if (金額 == 0) {
            return RString.EMPTY;
        } else {
            Decimal 金額変換 = new Decimal(金額);
            return DecimalFormatter.toコンマ区切りRString(金額変換, 0);
        }
    }

    private RString get負担番号(RString 負担番号) {
        if (負担番号 != null && !負担番号.isEmpty()) {
            return 負担番号;
        }
        return RString.EMPTY;
    }

    private static class DateComparatorServiceTeikyoYM implements Comparator<FlexibleYearMonth>, Serializable {

        private static final long serialVersionUID = -300796001015547240L;

        @Override
        public int compare(FlexibleYearMonth o1, FlexibleYearMonth o2) {
            return o2.compareTo(o1);
        }
    }

    private static class DateComparatorServiceYM implements Comparator<FlexibleYearMonth>, Serializable {

        @Override
        public int compare(FlexibleYearMonth o1, FlexibleYearMonth o2) {
            return o1.compareTo(o2);
        }
    }

    private FlexibleYearMonth get前月サービス提供年月(List<FlexibleYearMonth> サービス提供年月リスト,
            FlexibleYearMonth サービス提供年月) {
        Collections.sort(サービス提供年月リスト, new DateComparatorServiceTeikyoYM());
        for (FlexibleYearMonth サービス年月 : サービス提供年月リスト) {
            if (サービス年月.isBefore(サービス提供年月)) {
                return サービス年月;
            }
        }
        return FlexibleYearMonth.EMPTY;
    }

    private FlexibleYearMonth get次月サービス提供年月(List<FlexibleYearMonth> サービス提供年月リスト, FlexibleYearMonth サービス提供年月) {
        Collections.sort(サービス提供年月リスト, new DateComparatorServiceYM());
        for (FlexibleYearMonth サービス年月 : サービス提供年月リスト) {
            if (サービス提供年月.isBefore(サービス年月)) {
                return サービス年月;
            }
        }
        return FlexibleYearMonth.EMPTY;
    }
}
