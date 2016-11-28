/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110001.ShujiiikensyoKanrenTyouhyouDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請・依頼業務照会画面クラスです。
 *
 * @reamsid_L DBE-1390-010 dongyabin
 */
public class ShujiiikensyoKanrenTyouhyouHandler {

    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString SELECT_KEY1 = new RString("key1");

    private static final List<RString> DATA_CLARE = new ArrayList<>();

    private final ShujiiikensyoKanrenTyouhyouDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public ShujiiikensyoKanrenTyouhyouHandler(ShujiiikensyoKanrenTyouhyouDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void onLoad() {
        div.getRadChohyoHakkoType().setSelectedKey(SELECT_KEY0);
        div.getChkShinsei().setSelectedItemsByKey(DATA_CLARE);
        div.getChkNinteiChosa().setSelectedItemsByKey(DATA_CLARE);
        div.getChkShujiiIkensho().setSelectedItemsByKey(DATA_CLARE);
        onClick_RadChohyoHakko();
    }

    /**
     * 申請に関する帳票を選択します。
     */
    public void onClick_RadChohyoHakko() {
        div.getChkShinsei().setReadOnly(true);
        div.getChkNinteiChosa().setReadOnly(true);
        div.getChkShujiiIkensho().setReadOnly(true);
        if (SELECT_KEY0.equals(div.getRadChohyoHakkoType().getSelectedKey())) {
            div.getShinseiHakko().setIsOpen(true);
            div.getNinteiChosaHakko().setIsOpen(false);
            div.getShujiiIkenshoHakko().setIsOpen(false);
            div.getChkShinsei().setReadOnly(false);
        } else if (SELECT_KEY1.equals(div.getRadChohyoHakkoType().getSelectedKey())) {
            div.getShinseiHakko().setIsOpen(false);
            div.getNinteiChosaHakko().setIsOpen(true);
            div.getShujiiIkenshoHakko().setIsOpen(false);
            div.getChkNinteiChosa().setReadOnly(false);
        } else {
            div.getShinseiHakko().setIsOpen(false);
            div.getNinteiChosaHakko().setIsOpen(false);
            div.getShujiiIkenshoHakko().setIsOpen(true);
            div.getChkShujiiIkensho().setReadOnly(false);
        }
    }
}
