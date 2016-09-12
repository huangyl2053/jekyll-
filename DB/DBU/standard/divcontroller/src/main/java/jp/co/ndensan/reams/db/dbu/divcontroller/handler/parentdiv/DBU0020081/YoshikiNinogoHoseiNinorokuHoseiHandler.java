/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020081;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoo.JigyoHokokuGeppoDetalSearchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020081.YoshikiNinogoHoseiNinorokuHoseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.db.dbu.service.core.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHako;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * Mainハンドラークラスです。
 *
 * @reamsid_L DBU-1100-070 yebangqiang
 */
public final class YoshikiNinogoHoseiNinorokuHoseiHandler {

    private final YoshikiNinogoHoseiNinorokuHoseiDiv div;
    private static final RString 集計番号_0105 = new RString("0105");
    private static final RString 集計番号_0205 = new RString("0205");
    private static final RString 集計番号_0106 = new RString("0106");
    private static final RString 集計番号_0206 = new RString("0206");
    private static final int 縦番号_1 = 1;
    private static final int 縦番号_2 = 2;
    private static final int 縦番号_3 = 3;
    private static final int 縦番号_4 = 4;
    private static final int 縦番号_5 = 5;
    private static final int 縦番号_6 = 6;
    private static final int 縦番号_7 = 7;
    private static final int 縦番号_8 = 8;
    private static final int 縦番号_9 = 9;
    private static final int 縦番号_10 = 10;
    private static final int 縦番号_11 = 11;
    private static final int 縦番号_12 = 12;
    private static final int 縦番号_13 = 13;
    private static final int 縦番号_14 = 14;
    private static final int 縦番号_15 = 15;
    private static final int 縦番号_16 = 16;
    private static final int 縦番号_17 = 17;
    private static final int 横番号_2 = 2;
    private static final int 横番号_3 = 3;
    private static final int 横番号_4 = 4;
    private static final int 横番号_5 = 5;
    private static final int 横番号_6 = 6;
    private static final int 横番号_7 = 7;
    private static final int 横番号_8 = 8;
    private static final int 横番号_9 = 9;
    private static final int 横番号_10 = 10;
    private static final int 横番号_11 = 11;
    private static final int 横番号_12 = 12;

    private YoshikiNinogoHoseiNinorokuHoseiHandler(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        this.div = div;
    }

    /**
     * ハンドラー生成するメソッドです。
     *
     * @param div 画面DIV
     * @return Mainハンドラークラス
     */
    public static YoshikiNinogoHoseiNinorokuHoseiHandler of(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return new YoshikiNinogoHoseiNinorokuHoseiHandler(div);
    }

    /**
     * 削除状態、パネルを非活性するメソッドです。
     */
    public void disableMainPanel() {
        div.setDisabled(true);
    }

    /**
     * 基本エリアの初期化するメソッドです。
     *
     * @param 引き継ぎデータ 引き継ぎデータ
     * @return List<JigyoHokokuTokeiData>
     */
    public List<JigyoHokokuTokeiData> initialize(JigyoHokokuGeppoParameter 引き継ぎデータ) {
        initializeKihoneria(引き継ぎデータ);
        int 様式種類コード = Integer.parseInt(引き継ぎデータ.get行様式種類コード().toString());
        JigyoHokokuGeppoDetalSearchParameter param_kensu;
        JigyoHokokuGeppoDetalSearchParameter param_kyufuGaku;
        if (様式種類コード % 2 > 0) {
            param_kensu = JigyoHokokuGeppoDetalSearchParameter.
                    createParameterForJigyoHokokuGeppoDetal(
                            new FlexibleYear(引き継ぎデータ.get行報告年()),
                            引き継ぎデータ.get行報告月(),
                            new FlexibleYear(引き継ぎデータ.get行集計対象年()),
                            引き継ぎデータ.get行集計対象月(),
                            引き継ぎデータ.get行統計対象区分(),
                            new LasdecCode(引き継ぎデータ.get行市町村コード()),
                            new Code(引き継ぎデータ.get行表番号()),
                            new Code(集計番号_0105));
            param_kyufuGaku = JigyoHokokuGeppoDetalSearchParameter.
                    createParameterForJigyoHokokuGeppoDetal(
                            new FlexibleYear(引き継ぎデータ.get行報告年()),
                            引き継ぎデータ.get行報告月(),
                            new FlexibleYear(引き継ぎデータ.get行集計対象年()),
                            引き継ぎデータ.get行集計対象月(),
                            引き継ぎデータ.get行統計対象区分(),
                            new LasdecCode(引き継ぎデータ.get行市町村コード()),
                            new Code(引き継ぎデータ.get行表番号()),
                            new Code(集計番号_0106));
        } else {
            param_kensu = JigyoHokokuGeppoDetalSearchParameter.
                    createParameterForJigyoHokokuGeppoDetal(
                            new FlexibleYear(引き継ぎデータ.get行報告年()),
                            引き継ぎデータ.get行報告月(),
                            new FlexibleYear(引き継ぎデータ.get行集計対象年()),
                            引き継ぎデータ.get行集計対象月(),
                            引き継ぎデータ.get行統計対象区分(),
                            new LasdecCode(引き継ぎデータ.get行市町村コード()),
                            new Code(引き継ぎデータ.get行表番号()),
                            new Code(集計番号_0205));
            param_kyufuGaku = JigyoHokokuGeppoDetalSearchParameter.
                    createParameterForJigyoHokokuGeppoDetal(
                            new FlexibleYear(引き継ぎデータ.get行報告年()),
                            引き継ぎデータ.get行報告月(),
                            new FlexibleYear(引き継ぎデータ.get行集計対象年()),
                            引き継ぎデータ.get行集計対象月(),
                            引き継ぎデータ.get行統計対象区分(),
                            new LasdecCode(引き継ぎデータ.get行市町村コード()),
                            new Code(引き継ぎデータ.get行表番号()),
                            new Code(集計番号_0206));
        }
        List<JigyoHokokuTokeiData> dataList1 = initialize_kensu(param_kensu);
        List<JigyoHokokuTokeiData> dataList2 = initialize_kyufuGaku(param_kyufuGaku);
        dataList1.addAll(dataList2);
        return dataList1;
    }

    private void initializeKihoneria(JigyoHokokuGeppoParameter 引き継ぎデータ) {
        div.getPnl2().getTxtHokokuNengetsu().setValue(new RDate(引き継ぎデータ.get報告年月().toString()));
        div.getPnl2().getTxtShukeiNengetsu().setValue(new RDate(引き継ぎデータ.get集計年月().toString()));
        div.getPnl2().getPnlYosikiHosei().setValue(引き継ぎデータ.get保険者コード());
        div.getPnl2().getTxtHokensyaName().setValue(引き継ぎデータ.get市町村名称());
    }

    private List<JigyoHokokuTokeiData> initialize_kensu(JigyoHokokuGeppoDetalSearchParameter param_kensu) {
        List<JigyoHokokuTokeiData> dataList = JigyoHokokuGeppoHoseiHako.createInstance().
                getJigyoHokokuGeppoDetal(param_kensu);
        for (JigyoHokokuTokeiData 更新前データ : dataList) {
            Decimal 集計結果値 = 更新前データ.get集計結果値();
            switch (更新前データ.get縦番号().intValue()) {
                case 縦番号_1:
                    set件数_食費の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_4:
                    set件数_介護老人福祉施設の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_5:
                    set件数_介護老人保健施設の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_6:
                    set件数_介護療養型医療施設の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_16:
                    set件数_地域密着型介護老人福祉施設入所者生活介護の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_7:
                    set件数_短期入所生活介護の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_8:
                    set件数_短期入所療養介護介護老人保健施設の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_9:
                    set件数_短期入所療養介護介護療養型医療施設等の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_2:
                    set居住費滞在費の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_10:
                    set居住費_介護老人福祉施設の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_11:
                    set居住費_介護老人保健施設の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_12:
                    set居住費_介護療養型医療施設の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_17:
                    set居住費_地域密着型介護老人福祉施設入所者生活介護の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_13:
                    set居住費_短期入所生活介護の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_14:
                    set居住費_短期入所療養介護介護老人保健施設の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_15:
                    set居住費_短期入所療養介護介護療養型医療施設等の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_3:
                    set総計の集計結果値(更新前データ, 集計結果値);
                    break;
                default:
                    break;
            }
        }
        return dataList;
    }

    private List<JigyoHokokuTokeiData> initialize_kyufuGaku(JigyoHokokuGeppoDetalSearchParameter param_kyufuGaku) {
        List<JigyoHokokuTokeiData> dataList = JigyoHokokuGeppoHoseiHako.createInstance().
                getJigyoHokokuGeppoDetal(param_kyufuGaku);
        for (JigyoHokokuTokeiData 更新前データ : dataList) {
            Decimal 集計結果値 = 更新前データ.get集計結果値();
            switch (更新前データ.get縦番号().intValue()) {
                case 縦番号_1:
                    set給付費_食費の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_4:
                    set給付費_介護老人福祉施設の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_5:
                    set給付費_介護老人保健施設の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_6:
                    set給付費_介護療養型医療施設の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_16:
                    set給付費_地域密着型介護老人福祉施設入所者生活介護の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_7:
                    set給付費_短期入所生活介護の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_8:
                    set給付費_短期入所療養介護介護老人保健施設の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_9:
                    set給付費_短期入所療養介護介護療養型医療施設等の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_2:
                    set給付費_居住費滞在費の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_10:
                    set給付費_居住費_介護老人福祉施設の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_11:
                    set給付費_居住費_介護老人保健施設の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_12:
                    set給付費_居住費_介護療養型医療施設の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_17:
                    set給付費_居住費_地域密着型介護老人福祉施設入所者生活介護の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_13:
                    set給付費_居住費_短期入所生活介護の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_14:
                    set給付費_居住費_短期入所療養介護介護老人保健施設の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_15:
                    set給付費_居住費_短期入所療養介護介護療養型医療施設等の集計結果値(更新前データ, 集計結果値);
                    break;
                case 縦番号_3:
                    set給付費_総計の集計結果値(更新前データ, 集計結果値);
                    break;
                default:
                    break;
            }
        }
        return dataList;
    }

    private void set件数_食費の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt1SyokuhiYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt1SyokuhiYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt1SyokuhiYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt1SyokuhiKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt1SyokuhiGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set件数_介護老人福祉施設の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt1SyokuhiFukushiYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt1SyokuhiFukushiYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt1SyokuhiFukushiYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt1SyokuhiFukushiGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set件数_介護老人保健施設の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt1SyokuhiHokenYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt1SyokuhiHokenYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt1SyokuhiHokenYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt1SyokuhiHokenGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set件数_介護療養型医療施設の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set件数_地域密着型介護老人福祉施設入所者生活介護の集計結果値(
            JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set件数_短期入所生活介護の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set件数_短期入所療養介護介護老人保健施設の集計結果値(
            JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set件数_短期入所療養介護介護療養型医療施設等の集計結果値(
            JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set居住費滞在費の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt1KyojuhiYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt1KyojuhiYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt1KyojuhiYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt1KyojuhiKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt1KyojuhiGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set居住費_介護老人福祉施設の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt1KyojuhiFukushiYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt1KyojuhiFukushiYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt1KyojuhiFukushiYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt1KyojuhiFukushiGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set居住費_介護老人保健施設の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt1KyojuhiHokenYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt1KyojuhiHokenYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt1KyojuhiHokenYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt1KyojuhiHokenGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set居住費_介護療養型医療施設の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set居住費_地域密着型介護老人福祉施設入所者生活介護の集計結果値(JigyoHokokuTokeiData 更新前データ,
            Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set居住費_短期入所生活介護の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set居住費_短期入所療養介護介護老人保健施設の集計結果値(JigyoHokokuTokeiData 更新前データ,
            Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set居住費_短期入所療養介護介護療養型医療施設等の集計結果値(JigyoHokokuTokeiData 更新前データ,
            Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set総計の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt1SokeiYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt1SokeiYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt1SokeiYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt1SokeiKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt1SokeiGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set給付費_食費の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt2SyokuhiYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt2SyokuhiYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt2SyokuhiYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt2SyokuhiKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt2SyokuhiGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set給付費_介護老人福祉施設の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt2SyokuhiFukushiYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt2SyokuhiFukushiYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt2SyokuhiFukushiYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt2SyokuhiFukushiGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set給付費_介護老人保健施設の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt2SyokuhiHokenYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt2SyokuhiHokenYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt2SyokuhiHokenYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt2SyokuhiHokenGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set給付費_介護療養型医療施設の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set給付費_地域密着型介護老人福祉施設入所者生活介護の集計結果値(JigyoHokokuTokeiData 更新前データ,
            Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set給付費_短期入所生活介護の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set給付費_短期入所療養介護介護老人保健施設の集計結果値(JigyoHokokuTokeiData 更新前データ,
            Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set給付費_短期入所療養介護介護療養型医療施設等の集計結果値(JigyoHokokuTokeiData 更新前データ,
            Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set給付費_居住費滞在費の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt2KyojuhiYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt2KyojuhiYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt2KyojuhiYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt2KyojuhiKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt2KyojuhiGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set給付費_居住費_介護老人福祉施設の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt2KyojuhiFukushiYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt2KyojuhiFukushiYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt2KyojuhiFukushiYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt2KyojuhiFukushiGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set給付費_居住費_介護老人保健施設の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt2KyojuhiHokenYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt2KyojuhiHokenYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt2KyojuhiHokenYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt2KyojuhiHokenGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set給付費_居住費_介護療養型医療施設の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set給付費_居住費_地域密着型介護老人福祉施設入所者生活介護の集計結果値(
            JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set給付費_居住費_短期入所生活介護の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set給付費_居住費_短期入所療養介護介護老人保健施設の集計結果値(
            JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set給付費_居住費_短期入所療養介護介護療養型医療施設等の集計結果値(
            JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    private void set給付費_総計の集計結果値(JigyoHokokuTokeiData 更新前データ, Decimal 集計結果値) {
        switch (更新前データ.get横番号().intValue()) {
            case 横番号_2:
                div.getPnl2().getPnl1().getTxt2SokeiYoboYoshien1().setValue(集計結果値);
                break;
            case 横番号_3:
                div.getPnl2().getPnl1().getTxt2SokeiYoboYoshien2().setValue(集計結果値);
                break;
            case 横番号_4:
                div.getPnl2().getPnl1().getTxt2SokeiYoboYoshienKei().setValue(集計結果値);
                break;
            case 横番号_5:
                div.getPnl2().getPnl1().getTxt2SokeiKaigoKeikateki().setValue(集計結果値);
                break;
            case 横番号_6:
                div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo1().setValue(集計結果値);
                break;
            case 横番号_7:
                div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo2().setValue(集計結果値);
                break;
            case 横番号_8:
                div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo3().setValue(集計結果値);
                break;
            case 横番号_9:
                div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo4().setValue(集計結果値);
                break;
            case 横番号_10:
                div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo5().setValue(集計結果値);
                break;
            case 横番号_11:
                div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigoKei().setValue(集計結果値);
                break;
            case 横番号_12:
                div.getPnl2().getPnl1().getTxt2SokeiGokei().setValue(集計結果値);
                break;
            default:
                break;
        }
    }

    /**
     * 引き継ぎデータより、データ削除する。
     *
     * @param 引き継ぎデータ JigyoHokokuGeppoParameter
     */
    public void delete(List<JigyoHokokuTokeiData> 引き継ぎデータ) {
        JigyoHokokuGeppoHoseiHako finder = InstanceProvider.create(JigyoHokokuGeppoHoseiHako.class);
        finder.deleteJigyoHokokuGeppoData(引き継ぎデータ);
    }

}
