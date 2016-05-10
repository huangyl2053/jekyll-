/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE0110001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110001.DBE0110001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110001.ShujiiikensyoKanrenTyouhyouDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110001.ShujiiikensyoKanrenTyouhyouHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請・依頼業務照会画面クラスです。
 *
 * @reamsid_L DBE-1390-010 dongyabin
 */
public class ShujiiikensyoKanrenTyouhyou {

    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString SELECT_KEY1 = new RString("key1");

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShujiiikensyoKanrenTyouhyou>
     */
    public ResponseData<ShujiiikensyoKanrenTyouhyouDiv> onLoad(ShujiiikensyoKanrenTyouhyouDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 申請に関する帳票を選択します。
     *
     * @param div 画面情報
     * @return ResponseData<ShujiiikensyoKanrenTyouhyouDiv>
     */
    public ResponseData<ShujiiikensyoKanrenTyouhyouDiv> onClick_RadChohyoHakko(ShujiiikensyoKanrenTyouhyouDiv div) {
        getHandler(div).onClick_RadChohyoHakko();
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行画面に遷移する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<ShujiiikensyoKanrenTyouhyouDiv>
     */
    public ResponseData<ShujiiikensyoKanrenTyouhyouDiv> onClick_btnMove(ShujiiikensyoKanrenTyouhyouDiv div) {
        getHandler(div).onClick_btnMove();
        if (SELECT_KEY0.equals(div.getRadChohyoHakkoType().getSelectedKey())) {
            return ResponseData.of(div).forwardWithEventName(DBE0110001TransitionEventName.申請に関する帳票発行).respond();
        } else if (SELECT_KEY1.equals(div.getRadChohyoHakkoType().getSelectedKey())) {
            return ResponseData.of(div).forwardWithEventName(DBE0110001TransitionEventName.認定調査に関する帳票発行).respond();
        } else {
            return ResponseData.of(div).forwardWithEventName(DBE0110001TransitionEventName.主治医意見書に関する帳票発行).respond();
        }
    }

    private ShujiiikensyoKanrenTyouhyouHandler getHandler(ShujiiikensyoKanrenTyouhyouDiv div) {
        return new ShujiiikensyoKanrenTyouhyouHandler(div);
    }
}
