/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020081;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020081.YoshikiNinogoHoseiNinorokuHoseiDiv;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

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
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiYoboYoshienKei().getValue());
    }

    private boolean is件数_食費_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigoKei().getValue());
    }

    private boolean is件数_食費_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiGokei().getValue());
    }

    private boolean is地域密着型整合性チェックNG(Decimal 要支援計, Decimal 合計) {
        Decimal value1 = 要支援計 == null ? Decimal.ZERO : 要支援計;
        Decimal value2 = 合計 == null ? Decimal.ZERO : 合計;
        return !value1.equals(value2);
    }

    private boolean is要支援整合性チェックNG(Decimal 要支援１, Decimal 要支援２, Decimal 要支援計) {
        Decimal value1 = 要支援１ == null ? Decimal.ZERO : 要支援１;
        Decimal value2 = 要支援２ == null ? Decimal.ZERO : 要支援２;
        Decimal value3 = 要支援計 == null ? Decimal.ZERO : 要支援計;
        return !value1.add(value2).equals(value3);
    }

    private boolean is要介護整合性チェックNG(Decimal 要介護１, Decimal 要介護２, Decimal 要介護３, Decimal 要介護４,
            Decimal 要介護５, Decimal 要介護計) {
        Decimal value1 = 要介護１ == null ? Decimal.ZERO : 要介護１;
        Decimal value2 = 要介護２ == null ? Decimal.ZERO : 要介護２;
        Decimal value3 = 要介護３ == null ? Decimal.ZERO : 要介護３;
        Decimal value4 = 要介護４ == null ? Decimal.ZERO : 要介護４;
        Decimal value5 = 要介護５ == null ? Decimal.ZERO : 要介護５;
        Decimal value6 = 要介護計 == null ? Decimal.ZERO : 要介護計;
        return !value1.add(value2).add(value3).add(value4).add(value5).equals(value6);
    }

    private boolean is件数_介護老人福祉施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiFukushiYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiFukushiYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiFukushiYoboYoshienKei().getValue());
    }

    private boolean is件数_介護老人福祉施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigoKei().getValue());
    }

    private boolean is件数_介護老人福祉施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiFukushiYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiFukushiKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiFukushiGokei().getValue());
    }

    private boolean is件数_介護老人保健施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiHokenYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiHokenYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiHokenYoboYoshienKei().getValue());
    }

    private boolean is件数_介護老人保健施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigoKei().getValue());
    }

    private boolean is件数_介護老人保健施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiHokenYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiHokenKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiHokenGokei().getValue());
    }

    private boolean is件数_介護療養型医療施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoYoboYoshienKei().getValue());
    }

    private boolean is件数_介護療養型医療施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigoKei().getValue());
    }

    private boolean is件数_介護療養型医療施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiRyoyoGokei().getValue());
    }

    private boolean is件数_地域密着型介護老人福祉施設入所者生活介護_介護要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigoKei().getValue());
    }

    private boolean is件数_地域密着型介護老人福祉施設入所者生活介護_合計要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is地域密着型整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiMitchakuGokei().getValue());
    }

    private boolean is件数_短期入所生活介護_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiTankiYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiYoboYoshienKei().getValue());
    }

    private boolean is件数_短期入所生活介護_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigoKei().getValue());
    }

    private boolean is件数_短期入所生活介護_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiTankiYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiGokei().getValue());
    }

    private boolean is件数_短期入所療養介護老人保健施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenYoboYoshienKei().getValue());
    }

    private boolean is件数_短期入所療養介護老人保健施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigoKei().getValue());
    }

    private boolean is件数_短期入所療養介護老人保健施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiHokenGokei().getValue());
    }

    private boolean is件数_短期入所療養介護療養型医療施設等_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoYoboYoshienKei().getValue());
    }

    private boolean is件数_短期入所療養介護療養型医療施設等_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigoKei().getValue());
    }

    private boolean is件数_短期入所療養介護療養型医療施設等_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt1SyokuhiTankiRyoyoGokei().getValue());
    }

    private boolean is件数_居住費滞在費_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiYoboYoshienKei().getValue());
    }

    private boolean is件数_居住費滞在費_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigoKei().getValue());
    }

    private boolean is件数_居住費滞在費_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiGokei().getValue());
    }

    private boolean is件数_居住費介護老人福祉施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiFukushiYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiFukushiYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiFukushiYoboYoshienKei().getValue());
    }

    private boolean is件数_居住費介護老人福祉施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigoKei().getValue());
    }

    private boolean is件数_居住費介護老人福祉施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiFukushiYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiFukushiKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiFukushiGokei().getValue());
    }

    private boolean is件数_居住費介護老人保健施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiHokenYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiHokenYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiHokenYoboYoshienKei().getValue());
    }

    private boolean is件数_居住費介護老人保健施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigoKei().getValue());
    }

    private boolean is件数_居住費介護老人保健施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiHokenYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiHokenKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiHokenGokei().getValue());
    }

    private boolean is件数_居住費介護療養型医療施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoYoboYoshienKei().getValue());
    }

    private boolean is件数_居住費介護療養型医療施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigoKei().getValue());
    }

    private boolean is件数_居住費介護療養型医療施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiRyoyoGokei().getValue());
    }

    private boolean is件数_居住費地域密着型介護老人福祉施設入所者生活介護_介護要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigoKei().getValue());
    }

    private boolean is件数_居住費地域密着型介護老人福祉施設入所者生活介護_合計要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is地域密着型整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiMitchakuGokei().getValue());
    }

    private boolean is件数_居住費短期入所生活介護_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiTankiYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiYoboYoshienKei().getValue());
    }

    private boolean is件数_居住費短期入所生活介護_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigoKei().getValue());
    }

    private boolean is件数_居住費短期入所生活介護_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiTankiYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiGokei().getValue());
    }

    private boolean is件数_居住費短期入所療養介護老人保健施設_予防要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenYoboYoshienKei().getValue());
    }

    private boolean is件数_居住費短期入所療養介護老人保健施設_介護要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigoKei().getValue());
    }

    private boolean is件数_居住費短期入所療養介護老人保健施設_合計要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiHokenGokei().getValue());
    }

    private boolean is件数_居住費療養型医療施設等_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoYoboYoshienKei().getValue());
    }

    private boolean is件数_居住費療養型医療施設等_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigoKei().getValue());
    }

    private boolean is件数_居住費療養型医療施設等_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt1KyojuhiTankiRyoyoGokei().getValue());
    }

    private boolean is件数_総計_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1SokeiYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt1SokeiYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt1SokeiYoboYoshienKei().getValue());
    }

    private boolean is件数_総計_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigoKei().getValue());
    }

    private boolean is件数_総計_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt1SokeiYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt1SokeiKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt1SokeiGokei().getValue());
    }

    private boolean is給付費_食費_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiYoboYoshienKei().getValue());
    }

    private boolean is給付費_食費_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_食費_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiGokei().getValue());
    }

    private boolean is給付費_介護老人福祉施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiFukushiYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiFukushiYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiFukushiYoboYoshienKei().getValue());
    }

    private boolean is給付費_介護老人福祉施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_介護老人福祉施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiFukushiYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiFukushiKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiFukushiGokei().getValue());
    }

    private boolean is給付費_介護老人保健施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiHokenYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiHokenYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiHokenYoboYoshienKei().getValue());
    }

    private boolean is給付費_介護老人保健施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_介護老人保健施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiHokenYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiHokenKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiHokenGokei().getValue());
    }

    private boolean is給付費_介護療養型医療施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoYoboYoshienKei().getValue());
    }

    private boolean is給付費_介護療養型医療施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_介護療養型医療施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiRyoyoGokei().getValue());
    }

    private boolean is給付費_地域密着型介護老人福祉施設入所者生活介護_介護要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_地域密着型介護老人福祉施設入所者生活介護_合計要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is地域密着型整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiMitchakuGokei().getValue());
    }

    private boolean is給付費_短期入所生活介護_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiTankiYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiYoboYoshienKei().getValue());
    }

    private boolean is給付費_短期入所生活介護_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_短期入所生活介護_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiTankiYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiGokei().getValue());
    }

    private boolean is給付費_短期入所療養介護老人保健施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenYoboYoshienKei().getValue());
    }

    private boolean is給付費_短期入所療養介護老人保健施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_短期入所療養介護老人保健施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiHokenGokei().getValue());
    }

    private boolean is給付費_短期入所療養介護療養型医療施設等_予防要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoYoboYoshienKei().getValue());
    }

    private boolean is給付費_短期入所療養介護療養型医療施設等_介護要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_短期入所療養介護療養型医療施設等_合計要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt2SyokuhiTankiRyoyoGokei().getValue());
    }

    private boolean is給付費_居住費滞在費_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiYoboYoshienKei().getValue());
    }

    private boolean is給付費_居住費滞在費_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_居住費滞在費_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiGokei().getValue());
    }

    private boolean is給付費_居住費介護老人福祉施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiFukushiYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiFukushiYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiFukushiYoboYoshienKei().getValue());
    }

    private boolean is給付費_居住費介護老人福祉施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_居住費介護老人福祉施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiFukushiYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiFukushiKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiFukushiGokei().getValue());
    }

    private boolean is給付費_居住費介護老人保健施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiHokenYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiHokenYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiHokenYoboYoshienKei().getValue());
    }

    private boolean is給付費_居住費介護老人保健施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_居住費介護老人保健施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiHokenYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiHokenKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiHokenGokei().getValue());
    }

    private boolean is給付費_居住費介護療養型医療施設_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoYoboYoshienKei().getValue());
    }

    private boolean is給付費_居住費介護療養型医療施設_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_居住費介護療養型医療施設_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiRyoyoGokei().getValue());
    }

    private boolean is給付費_居住費地域密着型介護老人福祉施設入所者生活介護_介護要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_居住費地域密着型介護老人福祉施設入所者生活介護_合計要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is地域密着型整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiMitchakuGokei().getValue());
    }

    private boolean is給付費_居住費短期入所生活介護_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiTankiYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiYoboYoshienKei().getValue());
    }

    private boolean is給付費_居住費短期入所生活介護_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_居住費短期入所生活介護_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiTankiYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiGokei().getValue());
    }

    private boolean is給付費_居住費短期入所療養介護老人保健施設_予防要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenYoboYoshienKei().getValue());
    }

    private boolean is給付費_居住費短期入所療養介護老人保健施設_介護要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_居住費短期入所療養介護老人保健施設_合計要支援整合NG(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiHokenGokei().getValue());
    }

    private boolean is給付費_居住費療養型医療施設等_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoYoboYoshienKei().getValue());
    }

    private boolean is給付費_居住費療養型医療施設等_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_居住費療養型医療施設等_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoYoboYoshienKei().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt2KyojuhiTankiRyoyoGokei().getValue());
    }

    private boolean is給付費_総計_予防要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2SokeiYoboYoshien1().getValue(),
                div.getPnl2().getPnl1().getTxt2SokeiYoboYoshien2().getValue(),
                div.getPnl2().getPnl1().getTxt2SokeiYoboYoshienKei().getValue());
    }

    private boolean is給付費_総計_介護要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要介護整合性チェックNG(div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo1().getValue(),
                div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo2().getValue(),
                div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo3().getValue(),
                div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo4().getValue(),
                div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigo5().getValue(),
                div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigoKei().getValue());
    }

    private boolean is給付費_総計_合計要支援整合NG(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return is要支援整合性チェックNG(div.getPnl2().getPnl1().getTxt2SokeiKaigoYokaigoKei().getValue(),
                div.getPnl2().getPnl1().getTxt2SokeiGokei().getValue(),
                div.getPnl2().getPnl1().getTxt2SokeiYoboYoshienKei().getValue());
    }
}
