/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB2310001;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB231001.DBB231001_TokuchoSeidokanIFSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2310001.TokuchoSeidokanIFSakuseiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2310001.TokuchoSeidokanIFSakuseiHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 *
 * 画面設計_DBBGM84001_2_特徴制度間Ｉ／Ｆ（単一他社）
 *
 * @reamsid_L DBB-1830-010 yangchenbing
 */
public class TokuchoSeidokanIFSakusei {

    private static final RString DBBMN84002 = new RString("DBBMN84002");
    private static final RString タイトル_全件 = new RString("特徴制度間Ｉ／Ｆ作成（全件）");

    /**
     * 初期化のンメソッドます。
     *
     * @param div TokuchoSeidokanIFSakuseiDiv
     * @return ResponseData
     */
    public ResponseData<TokuchoSeidokanIFSakuseiDiv> onLoad(TokuchoSeidokanIFSakuseiDiv div) {
        getHandler(div).initialize();
        RString メニューＩＤ = ResponseHolder.getMenuID();
        if (DBBMN84002.equals(メニューＩＤ)) {
            return ResponseData.of(div).rootTitle(タイトル_全件).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 特別徴収開始年月changeのンメソッドます。
     *
     * @param div TokuchoSeidokanIFSakuseiDiv
     * @return ResponseData
     */
    public ResponseData<TokuchoSeidokanIFSakuseiDiv> onChange_DropDownList(TokuchoSeidokanIFSakuseiDiv div) {
        getHandler(div).onChange_特別徴収開始年月(div.getTxtChoteiNendo().getValue().getYear());
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン事件のメソッドます。
     *
     * @param div TokuchoSeidokanIFSakuseiDiv
     * @return ResponseData<TokuchoSeidokanIFSakuseiBatchParameter>
     */
    public ResponseData<DBB231001_TokuchoSeidokanIFSakuseiParameter> onClick_btnBatchRegister(TokuchoSeidokanIFSakuseiDiv div) {
        DBB231001_TokuchoSeidokanIFSakuseiParameter param = getHandler(div).getbatchparam(div);
        return ResponseData.of(param).respond();
    }

    private TokuchoSeidokanIFSakuseiHandler getHandler(TokuchoSeidokanIFSakuseiDiv div) {
        return new TokuchoSeidokanIFSakuseiHandler(div);
    }
}
