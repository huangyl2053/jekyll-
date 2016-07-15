/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC4540011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4540011.DBC4540011Panel1Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4540011.DBC4540011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4540011.DBC4540011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4540011.DBC4540011Panel1Handler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 国保連送付媒体管理Divを制御します。
 *
 * @reamsid_L DBC-3362-010 xuxin
 */
public class DBC4540011Panel1 {

    private DBC4540011Panel1Handler getHandler(DBC4540011Panel1Div div) {
        return new DBC4540011Panel1Handler(div);
    }

    /**
     * 国保連送付媒体管理作成画面初期化を処理します。
     *
     * @param div DBC4540011Panel1Div
     * @return ResponseData<DBC4540011Panel1Div>
     */
    public ResponseData<DBC4540011Panel1Div> onLoad(DBC4540011Panel1Div div) {

        getHandler(div).初期登録状態();
        getHandler(div).initialize();
        return ResponseData.of(div).setState(DBC4540011StateName.初期登録状態);
    }

    /**
     * 「保存する」ボタン押下時のイベントメソッドです。
     *
     * @param div DBC4540011Panel1Div
     * @return ResponseData<DBC4540011Panel1Div>
     */
    public ResponseData<DBC4540011Panel1Div> onClick_btnSave(DBC4540011Panel1Div div) {

        getHandler(div).config保存();
        return ResponseData.of(div).setState(DBC4540011StateName.完了状態);
    }

    /**
     * 「戻る」ボタン押下時のイベントメソッドです。
     *
     * @param div DBC4540011Panel1Div
     * @return ResponseData<DBC4540011Panel1Div>
     */
    public ResponseData<DBC4540011Panel1Div> onClick_btnBack(DBC4540011Panel1Div div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 「選択」ボタン押下時のイベントメソッドです。
     *
     * @param div DBC4540011Panel1Div
     * @return ResponseData<DBC4540011Panel1Div>
     */
    public ResponseData<DBC4540011Panel1Div> onClick_btnSelect(DBC4540011Panel1Div div) {

        getHandler(div).選択状態();
        getHandler(div).選択ボタン押下時();
        return ResponseData.of(div).setState(DBC4540011StateName.初期登録状態);
    }

    /**
     * 「完了する」ボタン押下時のイベントメソッドです。
     *
     * @param div DBC4540011Panel1Div
     * @return ResponseData<DBC4540011Panel1Div>
     */
    public ResponseData<DBC4540011Panel1Div> onClick_btnComplete(DBC4540011Panel1Div div) {

        return ResponseData.of(div).forwardWithEventName(DBC4540011TransitionEventName.処理完了).respond();
    }

    /**
     * 「実行」ボタン押下時のイベントメソッドです。
     *
     * @param div DBC4540011Panel1Div
     * @return ResponseData<DBC4540011Panel1Div>
     */
    public ResponseData<DBC4540011Panel1Div> onClick_btnSetting(DBC4540011Panel1Div div) {

        getHandler(div).初期登録状態();
        return ResponseData.of(div).setState(DBC4540011StateName.初期登録状態);
    }

    /**
     * 「取消」ボタン押下時のイベントメソッドです。
     *
     * @param div DBC4540011Panel1Div
     * @return ResponseData<DBC4540011Panel1Div>
     */
    public ResponseData<DBC4540011Panel1Div> onClick_btnCancle(DBC4540011Panel1Div div) {

        getHandler(div).初期登録状態();
        getHandler(div).set入力値破棄();
        return ResponseData.of(div).setState(DBC4540011StateName.初期登録状態);
    }

}
