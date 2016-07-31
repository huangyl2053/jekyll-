/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE6090001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiChosaHoshuJissekiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiChosaHoshuJissekiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahoshujissekijoho.NinteiChosaHoshuJissekiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahoshujissekijoho.NinteichosahyoGaikyoChosaBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6090001.DBE6090001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6090001.HomonChosaItakuNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6090001.dgShinsakaiIin_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6090001.HomonChosaItakuNyuryokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6090001.HomonChosaItakuNyuryokuValidatisonHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahoshujissekijoho.INinteiChosaHoshuJissekiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 *
 * 認定調査委託料入力クラスです。
 *
 * @reamsid_L DBE-1970-010 wanghui
 */
public class HomonChosaItakuNyuryoku {

    private final INinteiChosaHoshuJissekiJohoManager manager;
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_更新 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");

    /**
     * コンストラクタです。
     */
    public HomonChosaItakuNyuryoku() {
        manager = INinteiChosaHoshuJissekiJohoManager.createInstance();
    }

    /**
     * 画面初期化処理です。
     *
     * @param div 認定調査委託料入力div
     * @return ResponseData<HomonChosaItakuNyuryokuDiv>
     */
    public ResponseData<HomonChosaItakuNyuryokuDiv> onLoad(HomonChosaItakuNyuryokuDiv div) {
        getHandler(div).intialize();
        return ResponseData.of(div).setState(DBE6090001StateName.初期表示);
    }

    /**
     * 画面入力項目をクリアする。
     *
     * @param div 認定調査委託料入力div
     * @return ResponseData<HomonChosaItakuNyuryokuDiv>
     */
    public ResponseData<HomonChosaItakuNyuryokuDiv> onClick_searchClear(HomonChosaItakuNyuryokuDiv div) {
        getHandler(div).btnKyufuJissekiSearchClear();
        return ResponseData.of(div).respond();
    }

    /**
     * 調査実績検索処理です。
     *
     * @param div 認定調査委託料入力div
     * @return ResponseData<HomonChosaItakuNyuryokuDiv>
     */
    public ResponseData<HomonChosaItakuNyuryokuDiv> onClick_btnKensaku(HomonChosaItakuNyuryokuDiv div) {
        ValidationMessageControlPairs validPairs = getValidatisonHandlerr(div).必須入力チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        List<NinteiChosaHoshuJissekiJohoBusiness> 調査員情報List = manager.get初期化調査員情報検索(getHandler(div).createParam_初期(div)).records();
        getHandler(div).setDgChosain(調査員情報List);
        ValidationMessageControlPairs validationMessages = getValidatisonHandlerr(div).データ空のチェック();
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).setState(DBE6090001StateName.調査員一覧);
    }

    /**
     * 画面初期化処理です。
     *
     * @param div 認定調査委託料入力div
     * @return ResponseData<HomonChosaItakuNyuryokuDiv>
     */
    public ResponseData<HomonChosaItakuNyuryokuDiv> onClick_btnSentaku(HomonChosaItakuNyuryokuDiv div) {
        div.setHdt認定調査委託先コード(div.getChosain().getDgChosain().getClickedItem().getNintechosaItakusakiCode() == null
                ? RString.EMPTY : div.getChosain().getDgChosain().getClickedItem().getNintechosaItakusakiCode());
        div.setHdt認定調査委託先名称(div.getChosain().getDgChosain().getClickedItem().getJigyoshaMeisho() == null
                ? RString.EMPTY : div.getChosain().getDgChosain().getClickedItem().getJigyoshaMeisho());
        div.getTxtItakusakiCode().setValue(div.getHdt認定調査委託先コード());
        div.getTxtItakusakiName().setValue(div.getHdt認定調査委託先名称());
        div.getTxtChousaInCode().setValue(div.getChosain().getDgChosain().getClickedItem().getNinteiChosainCode());
        div.getTxtChousainName().setValue(div.getChosain().getDgChosain().getClickedItem().getChosainShimei());
        List<NinteichosahyoGaikyoChosaBusiness> 報酬情報List = manager.get調査員実績検索(getHandler(div).createParam_実績(div)).records();
        getHandler(div).setDgShinsakaiIin(報酬情報List);
        List<NinteiChosaHoshuJissekiJoho> 報酬実績情報 = manager.get報酬実績情報(div.getDgChosain().getClickedItem().getNintechosaItakusakiCode(),
                div.getDgChosain().getClickedItem().getNinteiChosainCode()).records();
        Models<NinteiChosaHoshuJissekiJohoIdentifier, NinteiChosaHoshuJissekiJoho> joho = Models.create(報酬実績情報);
        ViewStateHolder.put(ViewStateKeys.主治医意見書作成報酬実績情報, joho);
        div.setHdt認定調査委託先コード(div.getDgChosain().getClickedItem().getNintechosaItakusakiCode());
        if (!div.getDgShinsakaiIin().getDataSource().isEmpty()) {

            return ResponseData.of(div).setState(DBE6090001StateName.調査実績一覧状態);
        }
        return ResponseData.of(div).setState(DBE6090001StateName.調査実績一覧);
    }

    /**
     * 「入力を取りやめる」ボタン処理です。
     *
     * @param div 認定調査委託料入力div
     * @return ResponseData<HomonChosaItakuNyuryokuDiv> 認定調査委託料入力div
     */
    public ResponseData<HomonChosaItakuNyuryokuDiv> onClick_btnNyuryokuToriyameru(HomonChosaItakuNyuryokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).kuria();
            return ResponseData.of(div).setState(DBE6090001StateName.調査実績一覧);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「登録する　ボタン」ボタン処理です。
     *
     * @param div 認定調査委託料入力div
     * @return ResponseData<HomonChosaItakuNyuryokuDiv> 認定調査委託料入力div
     */
    public ResponseData<HomonChosaItakuNyuryokuDiv> onClick_btnToroku(HomonChosaItakuNyuryokuDiv div) {
        getHandler(div).setbtnToroku();
        return ResponseData.of(div).setState(DBE6090001StateName.調査実績一覧状態);
    }

    /**
     * 「修正」ボタン処理です。
     *
     * @param div 認定調査委託料入力div
     * @return ResponseData<HomonChosaItakuNyuryokuDiv> 認定調査委託料入力div
     */
    public ResponseData<HomonChosaItakuNyuryokuDiv> onChange_btnUpdate(HomonChosaItakuNyuryokuDiv div) {
        getHandler(div).set状態_更新();
        List<NinteichosahyoGaikyoChosaBusiness> 単価List = manager.get単価検索(getHandler(div).createParam_単価(div)).records();
        getHandler(div).単価(単価List);
        return ResponseData.of(div).setState(DBE6090001StateName.調査実績明細状態);
    }

    /**
     * 「削除」ボタン処理です。
     *
     * @param div 認定調査委託料入力div
     * @return ResponseData<HomonChosaItakuNyuryokuDiv> 認定調査委託料入力div
     */
    public ResponseData<HomonChosaItakuNyuryokuDiv> onClick_DeleteButton(HomonChosaItakuNyuryokuDiv div) {
        getHandler(div).set状態_削除();
        List<NinteichosahyoGaikyoChosaBusiness> 単価List = manager.get単価検索(getHandler(div).createParam_単価(div)).records();
        getHandler(div).単価(単価List);
        return ResponseData.of(div).setState(DBE6090001StateName.調査実績明細状態);
    }

    /**
     * 「戻る」ボタン処理です。
     *
     * @param div 認定調査委託料入力div
     * @return ResponseData<HomonChosaItakuNyuryokuDiv> 認定調査委託料入力div
     */
    public ResponseData<HomonChosaItakuNyuryokuDiv> onClick_btnModoru(HomonChosaItakuNyuryokuDiv div) {

        return ResponseData.of(div).setState(DBE6090001StateName.調査員一覧);
    }

    /**
     * 「保存する」ボタン処理です。
     *
     * @param div 認定調査委託料入力div
     * @return ResponseData<HomonChosaItakuNyuryokuDiv> 認定調査委託料入力div
     */
    public ResponseData<HomonChosaItakuNyuryokuDiv> onClick_btnHozonsuru(HomonChosaItakuNyuryokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            Models<NinteiChosaHoshuJissekiJohoIdentifier, NinteiChosaHoshuJissekiJoho> models
                    = ViewStateHolder.get(ViewStateKeys.主治医意見書作成報酬実績情報, Models.class);
            List<dgShinsakaiIin_Row> dgChosainList = div.getDgShinsakaiIin().getDataSource();
            for (dgShinsakaiIin_Row row : dgChosainList) {
                if (状態_追加.equals(row.getColumnState())) {
                    manager.insertJigyoshaJoho(getHandler(div).onClick_Add(row).build());
                } else if (状態_更新.equals(row.getColumnState())) {
                    manager.upuaretJigyoshaJoho(getHandler(div).onClick_Update(models, row).build());
                } else if (状態_削除.equals(row.getColumnState())) {
                    NinteiChosaHoshuJissekiJohoIdentifier key = new NinteiChosaHoshuJissekiJohoIdentifier(
                            div.getTxtItakusakiCode().getValue(),
                            div.getTxtChousaInCode().getValue(),
                            new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                            Integer.parseInt(row.getNinteichosaIraiRirekiNo().toString().replace(",", "")));
                    manager.saveOrDelete(models, key);
                }
            }
            div.getShinsakaiMessage().getCcdKaigoKanryoMessage().setSuccessMessage(new RString("認定調査委託料入力の保存処理が完了しました。"),
                    RString.EMPTY, RString.EMPTY);
            return ResponseData.of(div).setState(DBE6090001StateName.完了状態);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「完了する」ボタンを押下する。
     *
     * @param div ShisetsutourukuPanelDiv
     * @return ResponseData
     */
    public ResponseData<HomonChosaItakuNyuryokuDiv> btnComplete(HomonChosaItakuNyuryokuDiv div) {
        return ResponseData.of(div).respond();
    }

    private HomonChosaItakuNyuryokuHandler getHandler(HomonChosaItakuNyuryokuDiv div) {
        return new HomonChosaItakuNyuryokuHandler(div);
    }

    private HomonChosaItakuNyuryokuValidatisonHandler getValidatisonHandlerr(HomonChosaItakuNyuryokuDiv div) {
        return new HomonChosaItakuNyuryokuValidatisonHandler(div);
    }
}
