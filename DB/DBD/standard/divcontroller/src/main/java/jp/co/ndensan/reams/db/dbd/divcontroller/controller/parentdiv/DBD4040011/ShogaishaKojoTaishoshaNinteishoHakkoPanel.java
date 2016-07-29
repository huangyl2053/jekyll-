/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD4040011;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4040011.ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4040011.ShogaishaKojoTaishoshaNinteishoHakkoHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 障がい者控除対象者認定画面のDivControllerです
 *
 * @reamsid_L DBD-3870-010 tianyh
 */
public class ShogaishaKojoTaishoshaNinteishoHakkoPanel {

    /**
     * 画面初期化
     *
     * @param div ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv
     * @return ResponseData<ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv>
     */
    public ResponseData<ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv> onLoad(ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv div) {
        ShikibetsuCode 識別コード = new ShikibetsuCode(new RString("000000090077777"));
        HihokenshaNo 被保険者番号 = new HihokenshaNo(new RString("10001"));
        getHandler(div).initialize(識別コード, 被保険者番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 「連絡先」発行するボタンボタンを押した後のバリデーションする。
     *
     * @param div ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv
     * @return ResponseData
     */
    public ResponseData<ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv> onClick_btnHakko(ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ShogaishaKojoTaishoshaNinteishoHakkoHandler getHandler(ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv div) {
        return new ShogaishaKojoTaishoshaNinteishoHakkoHandler(div);
    }
}
