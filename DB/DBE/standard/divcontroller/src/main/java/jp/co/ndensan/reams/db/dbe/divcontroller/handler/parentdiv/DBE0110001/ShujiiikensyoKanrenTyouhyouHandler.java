/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110001.ShujiiikensyoKanrenTyouhyouDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 要介護認定申請・依頼業務照会画面クラスです。
 *
 * @reamsid_L DBE-1390-010 dongyabin
 */
public class ShujiiikensyoKanrenTyouhyouHandler {

    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString SELECT_KEY1 = new RString("key1");
    private static final RString SELECT_KEY2 = new RString("key1");
    private static final RString SELECT_KEY3 = new RString("key1");
    private static final RString SELECT_KEY4 = new RString("key1");
    private static final RString SELECT_KEY5 = new RString("key1");

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
    }

    /**
     * 申請に関する帳票を選択します。
     */
    public void onClick_RadChohyoHakko() {
        if (SELECT_KEY0.equals(div.getRadChohyoHakkoType().getSelectedKey())) {
            div.getShinseiHakko().setIsOpen(true);
            div.getNinteiChosaHakko().setIsOpen(false);
            div.getShujiiIkenshoHakko().setIsOpen(false);
        } else if (SELECT_KEY1.equals(div.getRadChohyoHakkoType().getSelectedKey())) {
            div.getShinseiHakko().setIsOpen(false);
            div.getNinteiChosaHakko().setIsOpen(true);
            div.getShujiiIkenshoHakko().setIsOpen(false);
        } else {
            div.getShinseiHakko().setIsOpen(false);
            div.getNinteiChosaHakko().setIsOpen(false);
            div.getShujiiIkenshoHakko().setIsOpen(true);
        }
    }

    /**
     * 「発行画面に遷移する」ボタンを押します。
     */
    public void onClick_btnMove() {
        set画面フラグ();
    }

    private void set画面フラグ() {
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
                要介護認定申請モニタリストフラグ = false;
            }
            if (div.getChkShinsei().getSelectedKeys().contains(SELECT_KEY1)) {
                要介護認定_要支援認定等申請者一覧フラグ = false;
            }
            ViewStateHolder.put(ViewStateKeys.要介護認定申請_依頼業務照会_要介護認定申請モニタリストフラグ, 要介護認定申請モニタリストフラグ);
            ViewStateHolder.put(ViewStateKeys.要介護認定申請_依頼業務照会_要介護認定_要支援認定等申請者一覧フラグ, 要介護認定_要支援認定等申請者一覧フラグ);
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
            ViewStateHolder.put(ViewStateKeys.要介護認定申請_依頼業務照会_認定調査予定未定者一覧フラグ, 認定調査予定未定者一覧フラグ);
            ViewStateHolder.put(ViewStateKeys.要介護認定申請_依頼業務照会_認定調査依頼先変更者一覧表フラグ, 認定調査依頼先変更者一覧表フラグ);
            ViewStateHolder.put(ViewStateKeys.要介護認定申請_依頼業務照会_認定調査結果と主治医意見書のチェックリストフラグ, 認定調査結果と主治医意見書のチェックリストフラグ);
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
            ViewStateHolder.put(ViewStateKeys.要介護認定申請_依頼業務照会_主治医意見書未提出者一覧フラグ, 主治医意見書未提出者一覧フラグ);
            ViewStateHolder.put(ViewStateKeys.要介護認定申請_依頼業務照会_主治医意見書５項目確認一覧表フラグ, 主治医意見書５項目確認一覧表フラグ);
            ViewStateHolder.put(ViewStateKeys.要介護認定申請_依頼業務照会_主治医意見書依頼未処理者一覧表フラグ, 主治医意見書依頼未処理者一覧表フラグ);
            ViewStateHolder.put(ViewStateKeys.要介護認定申請_依頼業務照会_主治医意見書作成依頼変更者一覧表フラグ, 主治医意見書作成依頼変更者一覧表フラグ);
            ViewStateHolder.put(ViewStateKeys.要介護認定申請_依頼業務照会_主治医意見書依頼済み一覧表フラグ, 主治医意見書依頼済み一覧表フラグ);
            ViewStateHolder.put(ViewStateKeys.要介護認定申請_依頼業務照会_主治医意見書作成料請求一覧表フラグ, 主治医意見書作成料請求一覧表フラグ);
        }
    }
}
