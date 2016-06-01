/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0150001;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.karisanteiidofuka.KarisanteiIdoFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001.DBB0150001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001.KarisanteiIdoFukaPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0150001.KarisanteiIdoFukaHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBBGM36001_仮算定異動賦課のクラスです。
 *
 * @reamsid_L DBB-0890-010 wangkanglei
 */
public class KarisanteiIdoFukaPanel {

    private final RString 仮算定異動賦課_MENU = new RString("DBBMN36001");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div KarisanteiIdoFukaPanelDiv
     * @return ResponseData
     */
    public ResponseData<KarisanteiIdoFukaPanelDiv> onLoad(KarisanteiIdoFukaPanelDiv div) {

        if (getHandler(div).is基準日時(div)) {
            throw new ApplicationException(DbbErrorMessages.異動賦課の確定処理が未処理.getMessage());
        }
        getHandler(div).initialize();
        if (仮算定異動賦課_MENU.equals(ResponseHolder.getMenuID())) {
            return ResponseData.of(div).setState(DBB0150001StateName.仮算定異動賦課);
        } else {
            return ResponseData.of(div).setState(DBB0150001StateName.通知書一括発行);
        }
    }

    /**
     * 「実行する」ボタンの必須チェックのメソッドます。
     *
     * @param div KarisanteiIdoFukaPanelDiv
     * @return ResponseData
     */
    public ResponseData<KarisanteiIdoFukaPanelDiv> onClick_onBeforeCheck(KarisanteiIdoFukaPanelDiv div) {
        ValidationMessageControlPairs pairs = getHandler(div).getCheckMessage();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンのメソッドます。
     *
     * @param div KarisanteiIdoFukaPanelDiv
     * @return ResponseData
     */
    public ResponseData<KarisanteiIdoFukaParameter> onClick_btnSantei(KarisanteiIdoFukaPanelDiv div) {
        KarisanteiIdoFukaParameter paramter = getHandler(div).getバッチパラメータ();
        return ResponseData.of(paramter).respond();
    }

    /**
     * 「処理対象」コンボボックスのメソッドます。
     *
     * @param div KarisanteiIdoFukaPanelDiv
     * @return ResponseData
     */
    public ResponseData<KarisanteiIdoFukaPanelDiv> onChange_ddlShorigetsu(KarisanteiIdoFukaPanelDiv div) {
        RDate date = RDate.getNowDate();
        getHandler(div).set帳票グループ(date);
        return ResponseData.of(div).respond();
    }

    private KarisanteiIdoFukaHandler getHandler(KarisanteiIdoFukaPanelDiv div) {
        return new KarisanteiIdoFukaHandler(div);
    }
}
