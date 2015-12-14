/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2230001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2230001.NinteiChosaTokusokujoHakkoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2230001.NinteiChosaTokusokujoHakkoHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 認定調査督促状発行のコントローラです。
 *
 */
public class NinteiChosaTokusokujoHakko {

    /**
     * サービスコード検索一覧初期化の設定します。
     *
     * @param div NinteiChosaTokusokujoHakkoDiv
     * @return ResponseData<NinteiChosaTokusokujoHakkoDiv>
     */
    public ResponseData<NinteiChosaTokusokujoHakkoDiv> onLoad(NinteiChosaTokusokujoHakkoDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行する」ボタンをクリックの設定します。
     *
     * @param div NinteiChosaTokusokujoHakkoDiv
     * @return ResponseData<NinteiChosaTokusokujoHakkoDiv>
     */
    public ResponseData<NinteiChosaTokusokujoHakkoDiv> hakkou(NinteiChosaTokusokujoHakkoDiv div) {
        int 該当データ件数 = getHandler(div).hakkou();
        if (該当データ件数 > 0) {
            return ResponseData.of(div).respond();
        } else {
            return ResponseData.of(div).addMessage(UrErrorMessages.該当データなし.getMessage()).respond();
        }
    }

    private NinteiChosaTokusokujoHakkoHandler getHandler(NinteiChosaTokusokujoHakkoDiv div) {
        return new NinteiChosaTokusokujoHakkoHandler(div);
    }

}
