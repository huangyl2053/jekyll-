/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110003.HakkoJokenDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査に関する帳票発行画面クラスです
 *
 * @reamsid_L DBE-1390-060 xuyongchao
 */
public class HakkoJokenHandler {

    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString SELECT_KEY1 = new RString("key1");
    private static final RString SELECT_KEY2 = new RString("key2");
    private static final List<RString> SELECT_LIST = new ArrayList<>();
    private final HakkoJokenDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public HakkoJokenHandler(HakkoJokenDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 認定調査予定未定者一覧フラグ 遷移元画面から受け取った引数
     * @param 認定調査依頼先変更者一覧表フラグ 遷移元画面から受け取った引数
     * @param 認定調査結果と主治医意見書のチェックリストフラグ 遷移元画面から受け取った引数
     */
    public void onLoad(boolean 認定調査予定未定者一覧フラグ, boolean 認定調査依頼先変更者一覧表フラグ,
            boolean 認定調査結果と主治医意見書のチェックリストフラグ) {
        SELECT_LIST.clear();
        checkPanel(認定調査予定未定者一覧フラグ, 認定調査依頼先変更者一覧表フラグ, 認定調査結果と主治医意見書のチェックリストフラグ);
        if (認定調査予定未定者一覧フラグ) {
            div.getNinteiChosaYoteiMiteishaIchiranJoken().setIsOpen(true);
            SELECT_LIST.add(SELECT_KEY0);
            div.getChkNinteiChosaYoteiMiteishaIchiran().setSelectedItemsByKey(SELECT_LIST);
            SELECT_LIST.clear();
        }
        if (認定調査依頼先変更者一覧表フラグ) {
            div.getNinteiChosaIraisakiHenkoshaIchiranhyoJoken().setIsOpen(true);
            SELECT_LIST.add(SELECT_KEY0);
            div.getChkNinteiChosaIraisakiHenkoshaIchiranhyoJoken().setSelectedItemsByKey(SELECT_LIST);
            SELECT_LIST.clear();
        }
        if (認定調査結果と主治医意見書のチェックリストフラグ) {
            SELECT_LIST.add(SELECT_KEY0);
            div.getChkNinteiChosaKekkaShujiiIkenshoCheckListJoken().setSelectedItemsByKey(SELECT_LIST);
            SELECT_LIST.clear();
        }
    }

    /**
     * PanelのON or OFF処理です。
     *
     * @param 認定調査予定未定者一覧フラグ 遷移元画面から受け取った引数
     * @param 認定調査依頼先変更者一覧表フラグ 遷移元画面から受け取った引数
     * @param 認定調査結果と主治医意見書のチェックリストフラグ 遷移元画面から受け取った引数
     */
    public void checkPanel(boolean 認定調査予定未定者一覧フラグ, boolean 認定調査依頼先変更者一覧表フラグ,
            boolean 認定調査結果と主治医意見書のチェックリストフラグ) {
        if (!認定調査予定未定者一覧フラグ) {
            div.getNinteiChosaYoteiMiteishaIchiranJoken().setIsOpen(false);
            div.getNinteiChosaYoteiMiteishaIchiranJoken().getRadJoken1().setDisabled(true);
            div.getNinteiChosaYoteiMiteishaIchiranJoken().getTxtYoteiMiteishaShinseiYMD().setDisabled(true);
        } else {
            if (div.getRadJoken1().getSelectedKey().contains(SELECT_KEY0)) {
                div.getNinteiChosaYoteiMiteishaIchiranJoken().getTxtYoteiMiteishaShinseiYMD().clearFromValue();
                div.getNinteiChosaYoteiMiteishaIchiranJoken().getTxtYoteiMiteishaShinseiYMD().clearToValue();
                div.getNinteiChosaYoteiMiteishaIchiranJoken().getTxtYoteiMiteishaShinseiYMD().setDisabled(true);
            }
        }
        if (!認定調査依頼先変更者一覧表フラグ) {
            div.getNinteiChosaIraisakiHenkoshaIchiranhyoJoken().setIsOpen(false);
            div.getNinteiChosaIraisakiHenkoshaIchiranhyoJoken().getTxtIraisakiHenkoshaIchiranShinseiYMD().setDisabled(true);
        }
        if (!認定調査結果と主治医意見書のチェックリストフラグ) {
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().setIsOpen(false);
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getRadJoken3().setDisabled(true);
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().setDisabled(true);
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsaYMD().setDisabled(true);
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsakai().setDisabled(true);
        } else {
            if (div.getRadJoken3().getSelectedKey().contains(SELECT_KEY0)) {
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().clearFromValue();
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().clearToValue();
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsaYMD().clearValue();
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsakai().clearValue();
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().setDisabled(true);
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsaYMD().setDisabled(true);
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsakai().setDisabled(true);
            } else if (div.getRadJoken3().getSelectedKey().contains(SELECT_KEY1)) {
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().setDisabled(false);
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsaYMD().clearValue();
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsakai().clearValue();
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsaYMD().setDisabled(true);
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsakai().setDisabled(true);
            } else if (div.getRadJoken3().getSelectedKey().contains(SELECT_KEY2)) {
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsaYMD().setDisabled(false);
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().clearFromValue();
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().clearToValue();
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsakai().clearValue();
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().setDisabled(true);
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsakai().setDisabled(true);
            } else {
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsakai().setDisabled(false);
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().clearFromValue();
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().clearToValue();
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsaYMD().clearValue();
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().setDisabled(true);
                div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsaYMD().setDisabled(true);
            }
        }
    }
}
