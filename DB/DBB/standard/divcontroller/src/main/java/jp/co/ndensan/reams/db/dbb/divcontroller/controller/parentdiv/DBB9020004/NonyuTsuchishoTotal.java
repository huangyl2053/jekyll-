/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB9020004;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020004.DBB9020004StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020004.NonyuTsuchishoTotalDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9020004.NonyuTsuchishoTotalHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * システム管理情報（納入通知書）
 *
 * @reamsid_L DBB-1770-060 yebangqiang
 */
public class NonyuTsuchishoTotal {

    /**
     * システム管理情報（納入通知書）を画面初期化処理しました。
     *
     * @param div {@link NotsuInfoDiv システム管理情報（納入通知書）Div}
     * @return システム管理情報（納入通知書）Divを持つResponseData
     */
    public ResponseData<NonyuTsuchishoTotalDiv> onLoad(NonyuTsuchishoTotalDiv div) {
        getHandler(div).set調定年度();
        List<ChohyoSeigyoHanyo> 帳票制御汎用リスト = new ArrayList<>();
        getHandler(div).initialize(帳票制御汎用リスト);
        ViewStateHolder.put(ViewStateKeys.帳票制御汎用リスト, (Serializable) 帳票制御汎用リスト);
        return ResponseData.of(div).respond();
    }

    /**
     * システム管理情報（納入通知書）を画面保存処理しました。
     *
     * @param div {@link NotsuInfoDiv システム管理情報（納入通知書）Div}
     * @return システム管理情報（納入通知書）Divを持つResponseData
     */
    public ResponseData<NonyuTsuchishoTotalDiv> onClick_btnUpdate(NonyuTsuchishoTotalDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            List<ChohyoSeigyoHanyo> 帳票制御汎用リスト = ViewStateHolder.get(ViewStateKeys.帳票制御汎用リスト, List.class);
            getHandler(div).set完了メッセージ表示();
            getHandler(div).save(帳票制御汎用リスト);
            return ResponseData.of(div).setState(DBB9020004StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 調定年度変更時、画面再初期化処理しました。
     *
     * @param div {@link NotsuInfoDiv システム管理情報（納入通知書）Div}
     * @return システム管理情報（納入通知書）Divを持つResponseData
     */
    public ResponseData<NonyuTsuchishoTotalDiv> onChange_ChoteiNendo(NonyuTsuchishoTotalDiv div) {
        List<ChohyoSeigyoHanyo> 帳票制御汎用リスト = new ArrayList<>();
        getHandler(div).initialize(帳票制御汎用リスト);
        ViewStateHolder.put(ViewStateKeys.帳票制御汎用リスト, (Serializable) 帳票制御汎用リスト);
        return ResponseData.of(div).respond();
    }

    private NonyuTsuchishoTotalHandler getHandler(NonyuTsuchishoTotalDiv div) {
        return NonyuTsuchishoTotalHandler.of(div);
    }
}
