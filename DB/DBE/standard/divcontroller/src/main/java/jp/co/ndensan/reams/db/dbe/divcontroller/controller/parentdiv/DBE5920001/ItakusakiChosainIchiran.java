/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5920001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE592001.DBE592001_ItakusakiChosainParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5920001.ItakusakiChosainIchiranDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査委託先・認定調査員一覧表のクラスです。
 *
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
        div.getHokensha().loadHokenshaList(GyomuBunrui.介護認定);
        return ResponseData.of(div).respond();

    }

    /**
     * 委託先コードと調査員コードの大小関係を比較です。
     *
     * @param div 画面情報DIV
     * @return ResponseData<ItakusakiChosainIchiranDiv>
     */
    public ResponseData<ItakusakiChosainIchiranDiv> onclick_Check(ItakusakiChosainIchiranDiv div) {
        RString 委託先コードFrom = div.getTxtIryoKikanCodeFrom().getValue();
        RString 委託先コードTo = div.getTxtIryoKikanCodeTo().getValue();
        RString 調査員コードFrom = div.getTxtShujiiCodeFrom().getValue();
        RString 調査員コードTo = div.getTxtShujiiCodeTo().getValue();

        if (!RString.isNullOrEmpty(委託先コードFrom) && !RString.isNullOrEmpty(委託先コードTo)) {
            if (委託先コードFrom.compareTo(委託先コードTo) > 0) {
                throw new ApplicationException(UrErrorMessages.大小関係が不正.getMessage().replace("委託先コード"));
            }
        }
        if (!RString.isNullOrEmpty(調査員コードFrom) && !RString.isNullOrEmpty(調査員コードTo)) {
            if (調査員コードFrom.compareTo(調査員コードTo) > 0) {
                throw new ApplicationException(UrErrorMessages.大小関係が不正.getMessage().replace("調査員コード"));
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧表を発行するボタン押下処理です。
     *
     * @param div ItakusakiChosainIchiranDiv
     * @return ResponseData<ItakusakiChosainIchiranBatchParamter>
     */
    public ResponseData<DBE592001_ItakusakiChosainParameter> onclick_Publis(ItakusakiChosainIchiranDiv div) {
        return ResponseData.of(getHandler(div).onclick_Publis()).respond();
    }

    private ItakusakiChosainIchiranHandler getHandler(ItakusakiChosainIchiranDiv div) {
        return new ItakusakiChosainIchiranHandler(div);
    }

}
