/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0020081;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020081.YoshikiNinogoHoseiNinorokuHoseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020081.YoshikiNinogoHoseiNinorokuHoseiHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * Mainパーネルクラスです。
 *
 * @reamsid_L DBU-1100-070 yebangqiang
 */
public class YoshikiNinogoHoseiNinorokuHosei {

    /**
     * 画面ロードメソッドです。
     *
     * @param div 画面DIV
     * @return 画面初期化
     */
    public ResponseData<YoshikiNinogoHoseiNinorokuHoseiDiv> onLoad(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        YoshikiNinogoHoseiNinorokuHoseiHandler handler = YoshikiNinogoHoseiNinorokuHoseiHandler.of(div);
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(
                ViewStateKeys.事業報告基本, JigyoHokokuGeppoParameter.class);
        handler.initialize(引き継ぎデータ);
        return ResponseData.of(div).respond();
    }

    public ResponseData<YoshikiNinogoHoseiNinorokuHoseiDiv> onActive_kensu(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        div.getPnl2().getPnl1().getTxt1SyokuhiKaigoKeikateki().setValue(Decimal.ZERO);
        return ResponseData.of(div).respond();
    }

    public ResponseData<YoshikiNinogoHoseiNinorokuHoseiDiv> onActive_kyufuGaku(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        div.getPnl2().getPnl1().getTxt2SyokuhiYoboYoshien2().setValue(Decimal.ZERO);
        return ResponseData.of(div).respond();
    }
}
