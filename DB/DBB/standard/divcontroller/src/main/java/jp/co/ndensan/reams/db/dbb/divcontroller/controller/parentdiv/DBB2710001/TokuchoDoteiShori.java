/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB2710001;

import java.util.Map.Entry;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoteishitaisyosyadoutei.TokuchoTeishiTaisyosyaDouteiBatchParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710001.DBB2710001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710001.TokuchoDoteiShoriDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2710001.TokuchoDoteiShoriHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBBGM81002_1_特徴対象者同定（一括）
 *
 * @reamsid_L DBB-1850-010 zhangrui
 */
public class TokuchoDoteiShori {

    private static final RString モード_単一保険者 = new RString("1");

    /**
     * 画面のonLoadイベント
     *
     * @param div ShotokuJohoTorokuTotalTotalDiv
     * @return div
     */
    public ResponseData<TokuchoDoteiShoriDiv> onLoad(TokuchoDoteiShoriDiv div) {
        Entry<RString, Boolean> result = getHandler(div).onload();
        ViewStateHolder.put(ViewStateKeys.特徴対象者同定実行FLAG, result.getValue());
        ViewStateHolder.put(ViewStateKeys.特徴対象者同定STATE, result.getKey());
        if (モード_単一保険者.equals(result.getKey())) {
            return ResponseData.of(div).setState(DBB2710001StateName.単一市町村);
        }
        return ResponseData.of(div).setState(DBB2710001StateName.広域保険者);
    }

    /**
     * 「実行」ボタンを押下する。<br/>
     *
     * @param div {@link TokuchoDoteiShoriDiv 特徴対象者同定Div}
     * @return TokuchoTeishiTaisyosyaDouteiBatchParameterを持つResponseData
     */
    public ResponseData<TokuchoTeishiTaisyosyaDouteiBatchParameter> onClick_btnJikkou(TokuchoDoteiShoriDiv div) {
        TokuchoTeishiTaisyosyaDouteiBatchParameter parameter = getHandler(div).doバッチパラメータの設定();
        return ResponseData.of(parameter).respond();
    }

    /**
     * StateTransition<br/>
     *
     * @param div {@link TokuchoDoteiShoriDiv 特徴対象者同定Div}
     * @return 特徴対象者同定Divを持つResponseData
     */
    public ResponseData<TokuchoDoteiShoriDiv> onStateTransition(TokuchoDoteiShoriDiv div) {
        Boolean can実行 = ViewStateHolder.get(ViewStateKeys.特徴対象者同定実行FLAG, Boolean.class);
        RString state = ViewStateHolder.get(ViewStateKeys.特徴対象者同定STATE, RString.class);
        getHandler(div).set実行ボタン(state, can実行);
        return ResponseData.of(div).respond();
    }

    private TokuchoDoteiShoriHandler getHandler(TokuchoDoteiShoriDiv div) {
        return TokuchoDoteiShoriHandler.of(div);
    }

}
