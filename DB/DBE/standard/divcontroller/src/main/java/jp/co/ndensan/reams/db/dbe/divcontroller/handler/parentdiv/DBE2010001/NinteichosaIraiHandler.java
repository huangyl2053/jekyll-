/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2010001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.NinteichosaIraiDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 完了処理・認定調査依頼のHandlerクラスです。
 *
 * @reamsid_L DBE-0300-010 dingyi
 */
public class NinteichosaIraiHandler {

    private final NinteichosaIraiDiv div;
    private static final RString 調査依頼モード = new RString("調査依頼モード");

    /**
     * コンストラクタです。
     *
     * @param div 完了処理・認定調査依頼Div
     */
    public NinteichosaIraiHandler(NinteichosaIraiDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・認定調査依頼に初期化を設定します。
     */
    public void onLoad() {
        div.getCcdTaskList().initialize(調査依頼モード);
    }

}
