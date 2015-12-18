/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.dbe5920001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.itakusakichosainichiran.ItakusakiChosainIchiranBatchParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5920001.ItakusakiChosainIchiranDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * 認定調査委託先・認定調査員一覧表のクラスです。
 */
public class ItakusakiChosainIchiran {

    /**
     * 画面初期化処理実行します。
     *
     * @param div ItakusakiChosainIchiranDiv
     * @return ResponseData<ItakusakiChosainIchiranDiv>
     */
    public ResponseData<ItakusakiChosainIchiranDiv> onload(ItakusakiChosainIchiranDiv div) {
        // TODO 董亜彬 業務Config取得方針不明、QA提出中

        return ResponseData.of(div).respond();

    }

    /**
     * 一覧表を発行するボタン押下処理です。
     *
     * @param div ItakusakiChosainIchiranDiv
     * @return ResponseData<ItakusakiChosainIchiranBatchParamter>
     */
    public ResponseData<ItakusakiChosainIchiranBatchParamter> onclick_一覧表を発行(ItakusakiChosainIchiranDiv div) {

        ItakusakiChosainIchiranBatchParamter param = getHandler(div).onclick_一覧表を発行する();
        return ResponseData.of(param).respond();
    }

    private ItakusakiChosainIchiranHandler getHandler(ItakusakiChosainIchiranDiv div) {
        return new ItakusakiChosainIchiranHandler(div);
    }

}
