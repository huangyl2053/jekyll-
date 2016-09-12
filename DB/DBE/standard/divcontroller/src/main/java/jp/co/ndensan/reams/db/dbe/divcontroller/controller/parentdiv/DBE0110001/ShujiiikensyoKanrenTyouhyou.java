/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE0110001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110001.DBE0110001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110001.ShujiiikensyoKanrenTyouhyouDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110001.ShujiiikensyoKanrenTyouhyouHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 要介護認定申請・依頼業務照会画面クラスです。
 *
 * @reamsid_L DBE-1390-010 dongyabin
 */
public class ShujiiikensyoKanrenTyouhyou {

    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString SELECT_KEY1 = new RString("key1");
    private static final RString SELECT_KEY2 = new RString("key2");
    private static final RString SELECT_KEY3 = new RString("key3");
    private static final RString SELECT_KEY4 = new RString("key4");
    private static final RString SELECT_KEY5 = new RString("key5");

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
        set画面フラグ(div);
        if (SELECT_KEY0.equals(div.getRadChohyoHakkoType().getSelectedKey())) {
            return ResponseData.of(div).forwardWithEventName(DBE0110001TransitionEventName.申請に関する帳票発行).respond();
        } else if (SELECT_KEY1.equals(div.getRadChohyoHakkoType().getSelectedKey())) {
            return ResponseData.of(div).forwardWithEventName(DBE0110001TransitionEventName.認定調査に関する帳票発行).respond();
        } else {
            return ResponseData.of(div).forwardWithEventName(DBE0110001TransitionEventName.主治医意見書に関する帳票発行).respond();
        }
    }

    private void set画面フラグ(ShujiiikensyoKanrenTyouhyouDiv div) {
        boolean 要介護認定申請モニタリストフラグ = false;
        boolean 要介護認定_要支援認定等申請者一覧フラグ = false;
        boolean 認定調査予定未定者一覧フラグ = false;
        boolean 認定調査依頼先変更者一覧表フラグ = false;
        boolean 認定調査結果と主治医意見書のチェックリストフラグ = false;
        boolean 主治医意見書未提出者一覧フラグ = false;
        boolean 主治医意見書５項目確認一覧表フラグ = false;
        boolean 主治医意見書依頼未処理者一覧表フラグ = false;
        boolean 主治医意見書作成依頼変更者一覧表フラグ = false;
        boolean 主治医意見書依頼済み一覧表フラグ = false;
        boolean 主治医意見書作成料請求一覧表フラグ = false;
        if (SELECT_KEY0.equals(div.getRadChohyoHakkoType().getSelectedKey())) {
            if (div.getChkShinsei().getSelectedKeys().contains(SELECT_KEY0)) {
                要介護認定申請モニタリストフラグ = true;
            }
            if (div.getChkShinsei().getSelectedKeys().contains(SELECT_KEY1)) {
                要介護認定_要支援認定等申請者一覧フラグ = true;
            }
            ViewStateHolder.put(ViewStateKeys.要介護認定申請モニタリストフラグ, 要介護認定申請モニタリストフラグ);
            ViewStateHolder.put(ViewStateKeys.要支援認定等申請者一覧フラグ, 要介護認定_要支援認定等申請者一覧フラグ);
        } else if (SELECT_KEY1.equals(div.getRadChohyoHakkoType().getSelectedKey())) {
            if (div.getChkNinteiChosa().getSelectedKeys().contains(SELECT_KEY0)) {
                認定調査予定未定者一覧フラグ = true;
            }
            if (div.getChkNinteiChosa().getSelectedKeys().contains(SELECT_KEY1)) {
                認定調査依頼先変更者一覧表フラグ = true;
            }
            if (div.getChkNinteiChosa().getSelectedKeys().contains(SELECT_KEY2)) {
                認定調査結果と主治医意見書のチェックリストフラグ = true;
            }
            ViewStateHolder.put(ViewStateKeys.認定調査予定未定者一覧フラグ, 認定調査予定未定者一覧フラグ);
            ViewStateHolder.put(ViewStateKeys.認定調査依頼先変更者一覧表フラグ, 認定調査依頼先変更者一覧表フラグ);
            ViewStateHolder.put(ViewStateKeys.認定調査結果と主治医意見書のチェックリストフラグ, 認定調査結果と主治医意見書のチェックリストフラグ);
        } else {
            if (div.getChkShujiiIkensho().getSelectedKeys().contains(SELECT_KEY0)) {
                主治医意見書未提出者一覧フラグ = true;
            }
            if (div.getChkShujiiIkensho().getSelectedKeys().contains(SELECT_KEY1)) {
                主治医意見書５項目確認一覧表フラグ = true;
            }
            if (div.getChkShujiiIkensho().getSelectedKeys().contains(SELECT_KEY2)) {
                主治医意見書依頼未処理者一覧表フラグ = true;
            }
            if (div.getChkShujiiIkensho().getSelectedKeys().contains(SELECT_KEY3)) {
                主治医意見書作成依頼変更者一覧表フラグ = true;
            }
            if (div.getChkShujiiIkensho().getSelectedKeys().contains(SELECT_KEY4)) {
                主治医意見書依頼済み一覧表フラグ = true;
            }
            if (div.getChkShujiiIkensho().getSelectedKeys().contains(SELECT_KEY5)) {
                主治医意見書作成料請求一覧表フラグ = true;
            }
            ViewStateHolder.put(ViewStateKeys.主治医意見書未提出者一覧フラグ, 主治医意見書未提出者一覧フラグ);
            ViewStateHolder.put(ViewStateKeys.主治医意見書５項目確認一覧表フラグ, 主治医意見書５項目確認一覧表フラグ);
            ViewStateHolder.put(ViewStateKeys.主治医意見書依頼未処理者一覧表フラグ, 主治医意見書依頼未処理者一覧表フラグ);
            ViewStateHolder.put(ViewStateKeys.主治医意見書作成依頼変更者一覧表フラグ, 主治医意見書作成依頼変更者一覧表フラグ);
            ViewStateHolder.put(ViewStateKeys.主治医意見書依頼済み一覧表フラグ, 主治医意見書依頼済み一覧表フラグ);
            ViewStateHolder.put(ViewStateKeys.主治医意見書作成料請求一覧表フラグ, 主治医意見書作成料請求一覧表フラグ);
        }
    }

    private ShujiiikensyoKanrenTyouhyouHandler getHandler(ShujiiikensyoKanrenTyouhyouDiv div) {
        return new ShujiiikensyoKanrenTyouhyouHandler(div);
    }
}
