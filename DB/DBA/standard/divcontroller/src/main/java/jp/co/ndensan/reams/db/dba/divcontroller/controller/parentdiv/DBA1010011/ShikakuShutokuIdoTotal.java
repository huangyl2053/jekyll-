/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1010011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011.ShikakuShutokuIdoTotalDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1010011.ShiKaKuSyuToKuIdouTotalHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 資格取得異動の対象者情報を表示するためのDivControllerです。
 *
 */
public class ShikakuShutokuIdoTotal {

    private static final RString DEFAULT = new RString("資格取得情報");
    private static final RString IRYOU = new RString("医療保険");
    private static final RString RONEN = new RString("老福年金");
    private static final RString SHISETSU = new RString("施設入退所");

    /**
     * 資格取得異動の初期化します。
     *
     * @param div ShikakuShutokuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuShutokuIdoTotalDiv> onLoad(ShikakuShutokuIdoTotalDiv div) {
        ResponseData<ShikakuShutokuIdoTotalDiv> response = new ResponseData<>();
        createHandler(div).load();
        response.data = div;
        return response;
    }

    /**
     * 資格取得異動タブの切替処理します。
     *
     * @param div ShikakuShutokuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuShutokuIdoTotalDiv> onChange_tabInputs(ShikakuShutokuIdoTotalDiv div) {
        ResponseData<ShikakuShutokuIdoTotalDiv> response = new ResponseData<>();
        RString title = div.getShikakuShutokuJoho().getTabInputs().getSelectedItem().getTitle();
        if (DEFAULT.equals(title)) {
            createHandler(div).onOpenTplDefault();
        } else if (IRYOU.equals(title)) {
            createHandler(div).onOpenTplIryou();
        } else if (RONEN.equals(title)) {
            createHandler(div).onOpenTplRoNen();
        } else if (SHISETSU.equals(title)) {
            createHandler(div).onOpenTplShisetsu();
        }
        response.data = div;
        return response;
    }

    /**
     * 「資格情報を保存する」ボタン処理します。
     *
     * @param div ShikakuShutokuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuShutokuIdoTotalDiv> onClick_btnUpdate(ShikakuShutokuIdoTotalDiv div) {
        ResponseData<ShikakuShutokuIdoTotalDiv> response = new ResponseData<>();
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            createHandler(div).save();
        }
        response.data = div;
        return response;
    }

    private ShiKaKuSyuToKuIdouTotalHandler createHandler(ShikakuShutokuIdoTotalDiv div) {
        return new ShiKaKuSyuToKuIdouTotalHandler(div);
    }
}
