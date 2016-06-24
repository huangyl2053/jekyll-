/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB2110001;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchosofu.TokuChoSoufuJohoSakuseiBatchParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2110001.TokuchoSofuJohoSakuseiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2110001.TokuchoSofuJohoSakuseiHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2110001.TokuchoSofuJohoSakuseiValidationHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBBGM82001_1_特徴送付情報作成
 *
 * @reamsid_L DBB-1840-010 zhangrui
 */
public class TokuchoSofuJohoSakusei {

    /**
     * 画面のonLoadイベント
     *
     * @param div ShotokuJohoTorokuTotalTotalDiv
     * @return div
     */
    public ResponseData<TokuchoSofuJohoSakuseiDiv> onLoad(TokuchoSofuJohoSakuseiDiv div) {
        getHandler(div).onload();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行」ボタンを押下する。<br/>
     *
     * @param div {@link TokuchoDoteiShoriDiv 特徴対象者同定Div}
     * @return 特徴対象者同定Divを持つResponseData
     */
    public ResponseData<TokuchoSofuJohoSakuseiDiv> onClick_btnJikkou(TokuchoSofuJohoSakuseiDiv div) {
        ValidationMessageControlPairs messages = getValidationHandler(div).validate();
        if (messages.existsError()) {
            return ResponseData.of(div).addValidationMessages(messages).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 「実行」ボタンを押下する。<br/>
     *
     * @param div {@link TokuchoDoteiShoriDiv 特徴対象者同定Div}
     * @return 特徴対象者同定Divを持つResponseData
     */
    public ResponseData<TokuChoSoufuJohoSakuseiBatchParameter> doExecuteBatch(TokuchoSofuJohoSakuseiDiv div) {
        TokuChoSoufuJohoSakuseiBatchParameter batchParameter = getHandler(div).getバッチパラメータ();
        return ResponseData.of(batchParameter).respond();
    }

    /**
     * 排他選択<br/>
     *
     * @param div {@link TokuchoDoteiShoriDiv 特徴対象者同定Div}
     * @return 特徴対象者同定Divを持つResponseData
     */
    public ResponseData<TokuchoSofuJohoSakuseiDiv> doExclusiveChk(TokuchoSofuJohoSakuseiDiv div) {
        RString 特徴送付情報作成FLAG = ViewStateHolder.get(ViewStateKeys.特徴送付情報作成FLAG, RString.class);
        ViewStateHolder.put(ViewStateKeys.特徴送付情報作成FLAG, getHandler(div).doExclusiveChk(特徴送付情報作成FLAG));
        return ResponseData.of(div).respond();
    }

    private TokuchoSofuJohoSakuseiHandler getHandler(TokuchoSofuJohoSakuseiDiv div) {
        return TokuchoSofuJohoSakuseiHandler.of(div);
    }

    private TokuchoSofuJohoSakuseiValidationHandler getValidationHandler(TokuchoSofuJohoSakuseiDiv div) {
        return new TokuchoSofuJohoSakuseiValidationHandler(div);
    }
}
