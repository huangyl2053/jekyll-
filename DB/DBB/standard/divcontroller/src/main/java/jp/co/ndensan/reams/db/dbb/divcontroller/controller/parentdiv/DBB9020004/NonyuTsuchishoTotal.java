/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB9020004;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020004.DBB9020004StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020004.KonkaiShoriNaiyoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020004.NonyuTsuchishoTotalDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9020004.KonkaiShoriNaiyoHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9020004.NonyuTsuchishoTotalHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * システム管理情報（納入通知書）
 *
 * @reamsid_L DBB-1770-060 yebangqiang
 */
public class NonyuTsuchishoTotal {

    /**
     * システム管理情報（納入通知書）を画面初期化処理しました。
     *
     * @param div {@link NotsuInfoDiv システム管理情報（納入通知書）Div}
     * @return システム管理情報（納入通知書）Divを持つResponseData
     */
    public ResponseData<NonyuTsuchishoTotalDiv> onLoad(NonyuTsuchishoTotalDiv div) {
        getHandler(div.getKonkaiShoriNaiyo()).set調定年度();
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * システム管理情報（納入通知書）を画面保存処理しました。
     *
     * @param div {@link NotsuInfoDiv システム管理情報（納入通知書）Div}
     * @return システム管理情報（納入通知書）Divを持つResponseData
     */
    public ResponseData<NonyuTsuchishoTotalDiv> onClick_btnUpdate(NonyuTsuchishoTotalDiv div) {
        getHandler(div).save();
        getHandler(div).set完了メッセージ表示();
        return ResponseData.of(div).setState(DBB9020004StateName.完了);
    }

    /**
     * 調定年度変更時、画面再初期化処理しました。
     *
     * @param div {@link NotsuInfoDiv システム管理情報（納入通知書）Div}
     * @return システム管理情報（納入通知書）Divを持つResponseData
     */
    public ResponseData<NonyuTsuchishoTotalDiv> onChange_ChoteiNendo(NonyuTsuchishoTotalDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    private NonyuTsuchishoTotalHandler getHandler(NonyuTsuchishoTotalDiv div) {
        return NonyuTsuchishoTotalHandler.of(div);
    }

    private KonkaiShoriNaiyoHandler getHandler(KonkaiShoriNaiyoDiv div) {
        return KonkaiShoriNaiyoHandler.of(div);
    }
}
