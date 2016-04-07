/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.dbe5920001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.itakusakichosainichiran.ItakusakiChosainIchiranBatchParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5920001.ItakusakiChosainIchiranDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;

/**
 *
 * 認定調査委託先・認定調査員一覧表のクラスです。
 * @reamsid_L DBE-0290-010 dongyabin
 */
public class ItakusakiChosainIchiran {

    /**
     * 画面初期化処理実行します。
     *
     * @param div 画面情報DIV
     * @return ResponseData<ItakusakiChosainIchiranDiv>
     */
    public ResponseData<ItakusakiChosainIchiranDiv> onload(ItakusakiChosainIchiranDiv div) {
        div.getHokensha().loadHokenshaList();
        return ResponseData.of(div).respond();

    }

    /**
     * 委託先コードと調査員コードの大小関係を比較です。
     *
     * @param div 画面情報DIV
     * @return ResponseData<ItakusakiChosainIchiranDiv>
     */
    public ResponseData<ItakusakiChosainIchiranDiv> onclick_Check(ItakusakiChosainIchiranDiv div) {
        if (div.getTxtIryoKikanCodeFrom().getValue().compareTo(
                div.getTxtIryoKikanCodeTo().getValue()) > 0) {
            throw new ApplicationException(UrErrorMessages.大小関係が不正.getMessage().replace("委託先コード"));
        }
        if (div.getTxtShujiiCodeFrom().getValue().compareTo(
                div.getTxtShujiiCodeTo().getValue()) > 0) {
            throw new ApplicationException(UrErrorMessages.大小関係が不正.getMessage().replace("調査員コード"));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧表を発行するボタン押下処理です。
     *
     * @param div ItakusakiChosainIchiranDiv
     * @return ResponseData<ItakusakiChosainIchiranBatchParamter>
     */
    public ResponseData<ItakusakiChosainIchiranBatchParamter> onclick_Publis(ItakusakiChosainIchiranDiv div) {
        return ResponseData.of(getHandler(div).onclick_Publis()).respond();
    }

    private ItakusakiChosainIchiranHandler getHandler(ItakusakiChosainIchiranDiv div) {
        return new ItakusakiChosainIchiranHandler(div);
    }

}
