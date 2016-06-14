/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE0110003;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110003.HakkoJokenDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110003.HakkoJokenHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査に関する帳票発行画面クラスです
 *
 * @reamsid_L DBE-1390-060 xuyongchao
 */
public class HakkoJoken {

    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString SELECT_KEY1 = new RString("key1");
    private static final RString SELECT_KEY2 = new RString("key2");

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenDiv>
     */
    public ResponseData<HakkoJokenDiv> onLoad(HakkoJokenDiv div) {

        getHandler(div).onLoad();

        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査予定未定者一覧パネルイベント処理です。
     *
     * @param div HakkoJokenDiv
     * @return ResponseData<HakkoJokenDiv>
     */
    public ResponseData<HakkoJokenDiv> onClick_ChkYoteiMiteisha(HakkoJokenDiv div) {
        if (div.getChkNinteiChosaYoteiMiteishaIchiran().getSelectedKeys().contains(SELECT_KEY0)) {
            div.getNinteiChosaYoteiMiteishaIchiranJoken().getRadJoken1().setDisabled(false);
            onClick_ChkRadJoken1(div);
        } else {
            div.getNinteiChosaYoteiMiteishaIchiranJoken().getRadJoken1().setDisabled(true);
            div.getNinteiChosaYoteiMiteishaIchiranJoken().getTxtYoteiMiteishaShinseiYMD().clearFromValue();
            div.getNinteiChosaYoteiMiteishaIchiranJoken().getTxtYoteiMiteishaShinseiYMD().clearToValue();
            div.getNinteiChosaYoteiMiteishaIchiranJoken().getTxtYoteiMiteishaShinseiYMD().setDisabled(true);
            div.getNinteiChosaYoteiMiteishaIchiranJoken().setIsOpen(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査依頼先変更者一覧表パネルイベント処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenDiv>
     */
    public ResponseData<HakkoJokenDiv> onClick_ChkIraisakiHenkosha(HakkoJokenDiv div) {
        if (div.getChkNinteiChosaIraisakiHenkoshaIchiranhyoJoken().getSelectedKeys().contains(SELECT_KEY0)) {
            div.getNinteiChosaIraisakiHenkoshaIchiranhyoJoken().getTxtIraisakiHenkoshaIchiranShinseiYMD().setDisabled(false);
        } else {
            div.getNinteiChosaIraisakiHenkoshaIchiranhyoJoken().getTxtIraisakiHenkoshaIchiranShinseiYMD().clearFromValue();
            div.getNinteiChosaIraisakiHenkoshaIchiranhyoJoken().getTxtIraisakiHenkoshaIchiranShinseiYMD().clearToValue();
            div.getNinteiChosaIraisakiHenkoshaIchiranhyoJoken().getTxtIraisakiHenkoshaIchiranShinseiYMD().setDisabled(true);
            div.getNinteiChosaIraisakiHenkoshaIchiranhyoJoken().setIsOpen(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査結果と主治医意見書のチェックリストパネルイベント処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenDiv>
     */
    public ResponseData<HakkoJokenDiv> onClick_ChkKekkaShujiiIkensho(HakkoJokenDiv div) {
        if (div.getChkNinteiChosaKekkaShujiiIkenshoCheckListJoken().getSelectedKeys().contains(SELECT_KEY0)) {
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getRadJoken3().setDisabled(false);
            onClick_ChkRadJoken3(div);
        } else {
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getRadJoken3().setDisabled(true);
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().clearFromValue();
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().clearToValue();
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsaYMD().clearValue();
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsakai().clearValue();
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD().setDisabled(true);
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsaYMD().setDisabled(true);
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsakai().setDisabled(true);
            div.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().setIsOpen(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査予定未定者一覧パネルのラジオボタンイベント処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenDiv>
     */
    public ResponseData<HakkoJokenDiv> onClick_ChkRadJoken1(HakkoJokenDiv div) {
        if (div.getRadJoken1().getSelectedKey().contains(SELECT_KEY0)) {
            div.getNinteiChosaYoteiMiteishaIchiranJoken().getTxtYoteiMiteishaShinseiYMD().clearFromValue();
            div.getNinteiChosaYoteiMiteishaIchiranJoken().getTxtYoteiMiteishaShinseiYMD().clearToValue();
            div.getNinteiChosaYoteiMiteishaIchiranJoken().getTxtYoteiMiteishaShinseiYMD().setDisabled(true);
        } else {
            div.getNinteiChosaYoteiMiteishaIchiranJoken().getTxtYoteiMiteishaShinseiYMD().setDisabled(false);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査結果と主治医意見書のチェックリストパネルのラジオボタンイベント処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenDiv>
     */
    public ResponseData<HakkoJokenDiv> onClick_ChkRadJoken3(HakkoJokenDiv div) {
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

        return ResponseData.of(div).respond();
    }

    private HakkoJokenHandler getHandler(HakkoJokenDiv div) {
        return new HakkoJokenHandler(div);
    }

}
