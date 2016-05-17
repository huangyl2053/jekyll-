/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020081;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020081.YoshikiNinogoHoseiNinorokuHoseiDiv;

/**
 * 整合性チェックハンドラークラスです。
 *
 * @reamsid_L DBU-1100-070 yebangqiang
 */
public final class YoshikiNinogoHoseiNinorokuHoseiSeigoSeiHandler {

    private final YoshikiNinogoHoseiNinorokuHoseiDiv div;

    private YoshikiNinogoHoseiNinorokuHoseiSeigoSeiHandler(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        this.div = div;
    }

    /**
     * ハンドラー生成するメソッドです。
     *
     * @param div 画面DIV
     * @return 整合性チェックハンドラークラス
     */
    public static YoshikiNinogoHoseiNinorokuHoseiSeigoSeiHandler of(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return new YoshikiNinogoHoseiNinorokuHoseiSeigoSeiHandler(div);
    }

    /**
     * 整合性チェックするメッソドです。
     *
     * @return 整合性チェック結果(true:結果が不整合 ;false:結果が整合)
     */
    public boolean is予防要支援結果チェック_NG() {
        if (is件数_予防要支援整合NG(div)
                || is給付費_介護老人福祉施設_予防要支援整合NG(div) || is給付費_介護老人保健施設_予防要支援整合NG(div)
                || is給付費_介護療養型医療施設_予防要支援整合NG(div) || is給付費_短期入所生活介護_予防要支援整合NG(div)
                || is給付費_短期入所療養介護老人保健施設_予防要支援整合NG(div)
                || is給付費_短期入所療養介護療養型医療施設等_予防要支援整合NG(div)
                || is給付費_居住費滞在費_予防要支援整合NG(div) || is給付費_居住費介護老人福祉施設_予防要支援整合NG(div)
                || is給付費_居住費介護老人保健施設_予防要支援整合NG(div)
                || is給付費_居住費介護療養型医療施設_予防要支援整合NG(div)
                || is給付費_居住費短期入所生活介護_予防要支援整合NG(div)
                || is給付費_居住費短期入所療養介護老人保健施設_予防要支援整合NG(div)
                || is給付費_居住費療養型医療施設等_予防要支援整合NG(div) || is給付費_総計_予防要支援整合NG(div)) {
            return true;
        }
        return false;
    }

    private boolean is件数_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is件数_食費_予防要支援整合NG(div) || is件数_介護老人福祉施設_予防要支援整合NG(div)
                || is件数_介護老人福祉施設_予防要支援整合NG(div) || is件数_介護老人保健施設_予防要支援整合NG(div)
                || is件数_介護療養型医療施設_予防要支援整合NG(div) || is件数_短期入所生活介護_予防要支援整合NG(div)
                || is件数_短期入所療養介護老人保健施設_予防要支援整合NG(div)
                || is件数_短期入所療養介護療養型医療施設等_予防要支援整合NG(div) || is件数_居住費滞在費_予防要支援整合NG(div)
                || is件数_居住費介護老人福祉施設_予防要支援整合NG(div) || is件数_居住費介護老人保健施設_予防要支援整合NG(div)
                || is件数_居住費介護療養型医療施設_予防要支援整合NG(div)
                || is件数_居住費短期入所生活介護_予防要支援整合NG(div)
                || is件数_居住費短期入所療養介護老人保健施設_予防要支援整合NG(div)
                || is件数_居住費療養型医療施設等_予防要支援整合NG(div)
                || is件数_総計_予防要支援整合NG(div) || is給付費_食費_予防要支援整合NG(div);
    }

    /**
     * 整合性チェックするメッソドです。
     *
     * @return 整合性チェック結果(true:結果が不整合 ;false:結果が整合)
     */
    public boolean is介護要支援結果チェック_NG() {
        if (is件数_介護要支援整合NG(div)
                || is給付費_食費_介護要支援整合NG(div) || is給付費_介護老人福祉施設_介護要支援整合NG(div)
                || is給付費_介護老人保健施設_介護要支援整合NG(div) || is給付費_介護療養型医療施設_介護要支援整合NG(div)
                || is給付費_地域密着型介護老人福祉施設入所者生活介護_介護要支援整合NG(div)
                || is給付費_短期入所生活介護_介護要支援整合NG(div)
                || is給付費_短期入所療養介護老人保健施設_介護要支援整合NG(div)
                || is給付費_短期入所療養介護療養型医療施設等_介護要支援整合NG(div)
                || is給付費_居住費滞在費_介護要支援整合NG(div) || is給付費_居住費介護老人福祉施設_介護要支援整合NG(div)
                || is給付費_居住費介護老人保健施設_介護要支援整合NG(div)
                || is給付費_居住費介護療養型医療施設_介護要支援整合NG(div)
                || is給付費_居住費地域密着型介護老人福祉施設入所者生活介護_介護要支援整合NG(div)
                || is給付費_居住費短期入所生活介護_介護要支援整合NG(div)
                || is給付費_居住費短期入所療養介護老人保健施設_介護要支援整合NG(div)
                || is給付費_居住費療養型医療施設等_介護要支援整合NG(div)
                || is給付費_総計_介護要支援整合NG(div)) {
            return true;
        }
        return false;
    }

    private boolean is件数_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is件数_食費_介護要支援整合NG(div) || is件数_介護老人福祉施設_介護要支援整合NG(div)
                || is件数_介護老人保健施設_介護要支援整合NG(div) || is件数_介護療養型医療施設_介護要支援整合NG(div)
                || is件数_地域密着型介護老人福祉施設入所者生活介護_介護要支援整合NG(div)
                || is件数_短期入所生活介護_介護要支援整合NG(div) || is件数_短期入所療養介護老人保健施設_介護要支援整合NG(div)
                || is件数_短期入所療養介護療養型医療施設等_介護要支援整合NG(div) || is件数_居住費滞在費_介護要支援整合NG(div)
                || is件数_居住費介護老人福祉施設_介護要支援整合NG(div) || is件数_居住費介護老人保健施設_介護要支援整合NG(div)
                || is件数_居住費介護療養型医療施設_介護要支援整合NG(div)
                || is件数_居住費地域密着型介護老人福祉施設入所者生活介護_介護要支援整合NG(div)
                || is件数_居住費短期入所生活介護_介護要支援整合NG(div)
                || is件数_居住費短期入所療養介護老人保健施設_介護要支援整合NG(div)
                || is件数_居住費療養型医療施設等_介護要支援整合NG(div) || is件数_総計_介護要支援整合NG(div);
    }

    /**
     * 整合性チェックするメッソドです。
     *
     * @return 整合性チェック結果(true:結果が不整合 ;false:結果が整合)
     */
    public boolean is合計要支援結果チェック_NG() {
        if (is件数_合計要支援整合NG(div) || is給付費_食費_合計要支援整合NG(div)
                || is給付費_介護老人福祉施設_合計要支援整合NG(div) || is給付費_介護老人保健施設_合計要支援整合NG(div)
                || is給付費_介護療養型医療施設_合計要支援整合NG(div)
                || is給付費_地域密着型介護老人福祉施設入所者生活介護_合計要支援整合NG(div)
                || is給付費_短期入所生活介護_合計要支援整合NG(div)
                || is給付費_短期入所療養介護老人保健施設_合計要支援整合NG(div)
                || is給付費_短期入所療養介護療養型医療施設等_合計要支援整合NG(div)
                || is給付費_居住費滞在費_合計要支援整合NG(div) || is給付費_居住費介護老人福祉施設_合計要支援整合NG(div)
                || is給付費_居住費介護老人保健施設_合計要支援整合NG(div)
                || is給付費_居住費介護療養型医療施設_合計要支援整合NG(div)
                || is給付費_居住費地域密着型介護老人福祉施設入所者生活介護_合計要支援整合NG(div)
                || is給付費_居住費短期入所生活介護_合計要支援整合NG(div)
                || is給付費_居住費短期入所療養介護老人保健施設_合計要支援整合NG(div)
                || is給付費_居住費療養型医療施設等_合計要支援整合NG(div) || is給付費_総計_合計要支援整合NG(div)) {
            return true;
        }
        return false;
    }

    private boolean is件数_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is件数_食費_合計要支援整合NG(div) || is件数_介護老人福祉施設_合計要支援整合NG(div)
                || is件数_介護老人保健施設_合計要支援整合NG(div) || is件数_介護療養型医療施設_合計要支援整合NG(div)
                || is件数_地域密着型介護老人福祉施設入所者生活介護_合計要支援整合NG(div)
                || is件数_短期入所生活介護_合計要支援整合NG(div) || is件数_短期入所療養介護老人保健施設_合計要支援整合NG(div)
                || is件数_短期入所療養介護療養型医療施設等_合計要支援整合NG(div) || is件数_居住費滞在費_合計要支援整合NG(div)
                || is件数_居住費介護老人福祉施設_合計要支援整合NG(div) || is件数_居住費介護老人保健施設_合計要支援整合NG(div)
                || is件数_居住費介護療養型医療施設_合計要支援整合NG(div)
                || is件数_居住費地域密着型介護老人福祉施設入所者生活介護_合計要支援整合NG(div)
                || is件数_居住費短期入所生活介護_合計要支援整合NG(div)
                || is件数_居住費短期入所療養介護老人保健施設_合計要支援整合NG(div)
                || is件数_居住費療養型医療施設等_合計要支援整合NG(div) || is件数_総計_合計要支援整合NG(div);
    }

    private boolean is件数_食費_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiYoboYoshienKei().getValue());
    }

    private boolean is件数_食費_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigoKei().getValue());
    }

    private boolean is件数_食費_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiGokei().getValue());
    }

    private boolean is件数_介護老人福祉施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiFukushiYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiFukushiYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiFukushiYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiFukushiYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiFukushiYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiFukushiYoboYoshienKei().getValue());
    }

    private boolean is件数_介護老人福祉施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigoKei().getValue());
    }

    private boolean is件数_介護老人福祉施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiFukushiYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiFukushiGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiFukushiYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiFukushiGokei().getValue());
    }

    private boolean is件数_介護老人保健施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiHokenYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiHokenYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiHokenYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiHokenYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiHokenYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiHokenYoboYoshienKei().getValue());
    }

    private boolean is件数_介護老人保健施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigoKei().getValue());
    }

    private boolean is件数_介護老人保健施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiHokenYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiHokenGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiHokenYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiHokenGokei().getValue());
    }

    private boolean is件数_介護療養型医療施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoYoboYoshienKei().getValue());
    }

    private boolean is件数_介護療養型医療施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigoKei().getValue());
    }

    private boolean is件数_介護療養型医療施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoGokei().getValue());
    }

    private boolean is件数_地域密着型介護老人福祉施設入所者生活介護_介護要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigoKei().getValue());
    }

    private boolean is件数_地域密着型介護老人福祉施設入所者生活介護_合計要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigoKei().getValue().equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuGokei().getValue());
    }

    private boolean is件数_短期入所生活介護_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiTankiYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiTankiYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiYoboYoshienKei().getValue());
    }

    private boolean is件数_短期入所生活介護_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigoKei().getValue());
    }

    private boolean is件数_短期入所生活介護_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiTankiYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiTankiYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiGokei().getValue());
    }

    private boolean is件数_短期入所療養介護老人保健施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenYoboYoshienKei().getValue());
    }

    private boolean is件数_短期入所療養介護老人保健施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigoKei().getValue());
    }

    private boolean is件数_短期入所療養介護老人保健施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenGokei().getValue());
    }

    private boolean is件数_短期入所療養介護療養型医療施設等_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoYoboYoshienKei().getValue());
    }

    private boolean is件数_短期入所療養介護療養型医療施設等_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigoKei().getValue());
    }

    private boolean is件数_短期入所療養介護療養型医療施設等_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoGokei().getValue());
    }

    private boolean is件数_居住費滞在費_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiYoboYoshienKei().getValue());
    }

    private boolean is件数_居住費滞在費_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigoKei().getValue());
    }

    private boolean is件数_居住費滞在費_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiGokei().getValue());
    }

    private boolean is件数_居住費介護老人福祉施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiFukushiYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiFukushiYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiFukushiYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiFukushiYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiFukushiYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiFukushiYoboYoshienKei().getValue());
    }

    private boolean is件数_居住費介護老人福祉施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigoKei().getValue());
    }

    private boolean is件数_居住費介護老人福祉施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiFukushiYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiFukushiGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiFukushiYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiFukushiGokei().getValue());
    }

    private boolean is件数_居住費介護老人保健施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiHokenYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiHokenYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiHokenYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiHokenYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiHokenYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiHokenYoboYoshienKei().getValue());
    }

    private boolean is件数_居住費介護老人保健施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigoKei().getValue());
    }

    private boolean is件数_居住費介護老人保健施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiHokenYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiHokenGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiHokenYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiHokenGokei().getValue());
    }

    private boolean is件数_居住費介護療養型医療施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoYoboYoshienKei().getValue());
    }

    private boolean is件数_居住費介護療養型医療施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigoKei().getValue());
    }

    private boolean is件数_居住費介護療養型医療施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoGokei().getValue());
    }

    private boolean is件数_居住費地域密着型介護老人福祉施設入所者生活介護_介護要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigoKei().getValue());
    }

    private boolean is件数_居住費地域密着型介護老人福祉施設入所者生活介護_合計要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigoKei().getValue().equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuGokei().getValue());
    }

    private boolean is件数_居住費短期入所生活介護_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiTankiYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiTankiYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiYoboYoshienKei().getValue());
    }

    private boolean is件数_居住費短期入所生活介護_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigoKei().getValue());
    }

    private boolean is件数_居住費短期入所生活介護_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiTankiYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiTankiYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiGokei().getValue());
    }

    private boolean is件数_居住費短期入所療養介護老人保健施設_予防要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenYoboYoshienKei().getValue());
    }

    private boolean is件数_居住費短期入所療養介護老人保健施設_介護要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigoKei().getValue());
    }

    private boolean is件数_居住費短期入所療養介護老人保健施設_合計要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenGokei().getValue());
    }

    private boolean is件数_居住費療養型医療施設等_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoYoboYoshienKei().getValue());
    }

    private boolean is件数_居住費療養型医療施設等_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigoKei().getValue());
    }

    private boolean is件数_居住費療養型医療施設等_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoGokei().getValue());
    }

    private boolean is件数_総計_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SokeiYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SokeiYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SokeiYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SokeiYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SokeiYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SokeiYoboYoshienKei().getValue());
    }

    private boolean is件数_総計_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigoKei().getValue());
    }

    private boolean is件数_総計_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt1SokeiYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt1SokeiGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt1SokeiYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt1SokeiGokei().getValue());
    }

    private boolean is給付費_食費_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiYoboYoshienKei().getValue());
    }

    private boolean is給付費_食費_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_食費_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiGokei().getValue());
    }

    private boolean is給付費_介護老人福祉施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiFukushiYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiFukushiYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiFukushiYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiFukushiYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiFukushiYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiFukushiYoboYoshienKei().getValue());
    }

    private boolean is給付費_介護老人福祉施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_介護老人福祉施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiFukushiYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiFukushiGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiFukushiYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiFukushiGokei().getValue());
    }

    private boolean is給付費_介護老人保健施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiHokenYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiHokenYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiHokenYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiHokenYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiHokenYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiHokenYoboYoshienKei().getValue());
    }

    private boolean is給付費_介護老人保健施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_介護老人保健施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiHokenYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiHokenGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiHokenYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiHokenGokei().getValue());
    }

    private boolean is給付費_介護療養型医療施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoYoboYoshienKei().getValue());
    }

    private boolean is給付費_介護療養型医療施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_介護療養型医療施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoGokei().getValue());
    }

    private boolean is給付費_地域密着型介護老人福祉施設入所者生活介護_介護要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_地域密着型介護老人福祉施設入所者生活介護_合計要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigoKei().getValue().equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuGokei().getValue());
    }

    private boolean is給付費_短期入所生活介護_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiTankiYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiTankiYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiYoboYoshienKei().getValue());
    }

    private boolean is給付費_短期入所生活介護_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_短期入所生活介護_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiTankiYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiTankiYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiGokei().getValue());
    }

    private boolean is給付費_短期入所療養介護老人保健施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenYoboYoshienKei().getValue());
    }

    private boolean is給付費_短期入所療養介護老人保健施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_短期入所療養介護老人保健施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenGokei().getValue());
    }

    private boolean is給付費_短期入所療養介護療養型医療施設等_予防要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoYoboYoshienKei().getValue());
    }

    private boolean is給付費_短期入所療養介護療養型医療施設等_介護要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_短期入所療養介護療養型医療施設等_合計要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoGokei().getValue());
    }

    private boolean is給付費_居住費滞在費_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiYoboYoshienKei().getValue());
    }

    private boolean is給付費_居住費滞在費_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_居住費滞在費_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiGokei().getValue());
    }

    private boolean is給付費_居住費介護老人福祉施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiFukushiYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiFukushiYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiFukushiYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiFukushiYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiFukushiYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiFukushiYoboYoshienKei().getValue());
    }

    private boolean is給付費_居住費介護老人福祉施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_居住費介護老人福祉施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiFukushiYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiFukushiGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiFukushiYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiFukushiGokei().getValue());
    }

    private boolean is給付費_居住費介護老人保健施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiHokenYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiHokenYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiHokenYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiHokenYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiHokenYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiHokenYoboYoshienKei().getValue());
    }

    private boolean is給付費_居住費介護老人保健施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_居住費介護老人保健施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiHokenYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiHokenGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiHokenYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiHokenGokei().getValue());
    }

    private boolean is給付費_居住費介護療養型医療施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoYoboYoshienKei().getValue());
    }

    private boolean is給付費_居住費介護療養型医療施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_居住費介護療養型医療施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoGokei().getValue());
    }

    private boolean is給付費_居住費地域密着型介護老人福祉施設入所者生活介護_介護要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_居住費地域密着型介護老人福祉施設入所者生活介護_合計要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigoKei().getValue().equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuGokei().getValue());
    }

    private boolean is給付費_居住費短期入所生活介護_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiTankiYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiTankiYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiYoboYoshienKei().getValue());
    }

    private boolean is給付費_居住費短期入所生活介護_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_居住費短期入所生活介護_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiTankiYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiTankiYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiGokei().getValue());
    }

    private boolean is給付費_居住費短期入所療養介護老人保健施設_予防要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenYoboYoshienKei().getValue());
    }

    private boolean is給付費_居住費短期入所療養介護老人保健施設_介護要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_居住費短期入所療養介護老人保健施設_合計要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenGokei().getValue());
    }

    private boolean is給付費_居住費療養型医療施設等_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoYoboYoshienKei().getValue());
    }

    private boolean is給付費_居住費療養型医療施設等_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_居住費療養型医療施設等_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoGokei().getValue());
    }

    private boolean is給付費_総計_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SokeiYoboYoshien1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SokeiYoboYoshien2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SokeiYoboYoshienKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SokeiYoboYoshien1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SokeiYoboYoshien2().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SokeiYoboYoshienKei().getValue());
    }

    private boolean is給付費_総計_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo1().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo2().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo3().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo4().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo5().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigoKei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo1().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo2().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo3().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo4().getValue()).add(
                        div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo5().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_総計_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return div.getPnl2().getPnl1().getTxt2SokeiYoboYoshienKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigoKei().getValue() == null
                || div.getPnl2().getPnl1().getTxt2SokeiGokei().getValue() == null
                || !div.getPnl2().getPnl1().getTxt2SokeiYoboYoshienKei().getValue().add(
                        div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigoKei().getValue()).equals(
                        div.getPnl2().getPnl1().getTxt2SokeiGokei().getValue());
    }
}
