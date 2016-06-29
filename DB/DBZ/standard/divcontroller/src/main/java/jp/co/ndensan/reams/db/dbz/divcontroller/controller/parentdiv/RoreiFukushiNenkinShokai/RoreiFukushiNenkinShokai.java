/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv.RoreiFukushiNenkinShokai;

import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaIdentifier;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.RoreiFukushiNenkinShokaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.RoreiFukushiNenkinShokaiHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 老齢福祉年金受給情報共有子Div処理のクラスです。
 *
 * @reamsid_L DBA-0220-010 dongyabin
 */
public class RoreiFukushiNenkinShokai {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_更新 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");

    /**
     * 「情報を追加する」ボタン処理です。
     *
     * @param div 老齢福祉年金Div
     * @return ResponseData<RoreiFukushiNenkinShokaiDiv> 老齢福祉年金情報Div
     */
    public ResponseData<RoreiFukushiNenkinShokaiDiv> onClick_btnAdd(RoreiFukushiNenkinShokaiDiv div) {
        div.getPanelInput().setState(状態_追加);
        getHandler(div).set老齢福祉年金追加ボタン画面表示();
        return ResponseData.of(div).respond();
    }

    /**
     * 「修正」ボタン処理です。
     *
     * @param div 老齢福祉年金情報Div
     * @return ResponseData<RoreiFukushiNenkinShokaiDiv> 老齢福祉年金情報Div
     */
    public ResponseData<RoreiFukushiNenkinShokaiDiv> onChange_btnUpdate(RoreiFukushiNenkinShokaiDiv div) {
        div.getPanelInput().setState(状態_更新);
        getHandler(div).set老齢福祉年金修正ボタン画面表示();
        return ResponseData.of(div).respond();
    }

    /**
     * 「削除」ボタン処理です。
     *
     * @param div 老齢福祉年金情報Div
     * @return ResponseData<RoreiFukushiNenkinShokaiDiv> 老齢福祉年金情報Div
     */
    public ResponseData<RoreiFukushiNenkinShokaiDiv> onClick_DeleteButton(RoreiFukushiNenkinShokaiDiv div) {
        div.getPanelInput().setState(状態_削除);
        getHandler(div).set老齢福祉年金削除ボタン画面表示();
        return ResponseData.of(div).respond();
    }

    /**
     * 「入力を取消」ボタンです。
     *
     * @param div 老齢福祉年金情報Div
     * @return ResponseData<RoreiFukushiNenkinShokaiDiv> 老齢福祉年金情報Div
     */
    public ResponseData<RoreiFukushiNenkinShokaiDiv> onClick_btnCancel(RoreiFukushiNenkinShokaiDiv div) {
        getHandler(div).set老齢福祉年金取消ボタン画面表示();
        return ResponseData.of(div).respond();
    }

    /**
     * 確定するボタンが押下された場合、入力明細エリアの入力内容を老齢福祉年金情報一覧に反映させます。
     *
     * @param div 老齢福祉年金情報Div
     * @return ResponseData<RoreiFukushiNenkinShokaiDiv> 老齢福祉年金情報Div
     */
    public ResponseData<RoreiFukushiNenkinShokaiDiv> onClick_btnSave(RoreiFukushiNenkinShokaiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (div.getPanelInput().getTxtStartDate().getValue() != null
                    && div.getPanelInput().getTxtEndDate().getValue() != null
                    && !div.getPanelInput().getTxtStartDate().getValue().isBeforeOrEquals(div.getPanelInput().getTxtEndDate().getValue())) {
                ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
                return ResponseData.of(div).addValidationMessages(getHandler(div).addMessage(validPairs,
                        div.getPanelInput().getTxtStartDate().getValue().toString(),
                        div.getPanelInput().getTxtEndDate().getValue().toString())).
                        respond();
            }
            RString イベント状態 = div.getPanelInput().getState();
            ValidationMessageControlPairs 受給開始日重複チェック = getHandler(div).set受給開始日の重複チェック();
            if (状態_追加.equals(イベント状態) && 受給開始日重複チェック.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(受給開始日重複チェック).respond();
            }
            ValidationMessageControlPairs validPairs = getHandler(div).set受給期間の重複チェック(イベント状態);
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
            this.onClick_はい(div);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<RoreiFukushiNenkinShokaiDiv> onClick_はい(RoreiFukushiNenkinShokaiDiv div) {
        RString イベント状態 = div.getPanelInput().getState();
        Models<RoreiFukushiNenkinJukyushaIdentifier, RoreiFukushiNenkinJukyusha> models
                = ViewStateHolder.get(ViewStateKeys.老齢福祉年金情報検索結果一覧, Models.class);
        if (状態_追加.equals(イベント状態)) {
            RoreiFukushiNenkinJukyusha busiRoreiFukushiNenkin = new RoreiFukushiNenkinJukyusha(
                    new ShikibetsuCode(div.getShikibetsuCode()),
                    new FlexibleDate(div.getPanelInput().getTxtStartDate().getValue().toDateString()));
            busiRoreiFukushiNenkin = getHandler(div).set年金確定ボタン押下の追加(busiRoreiFukushiNenkin);
            models.add(busiRoreiFukushiNenkin);
        }
        if (状態_更新.equals(イベント状態)) {
            RoreiFukushiNenkinJukyushaIdentifier key = new RoreiFukushiNenkinJukyushaIdentifier(
                    new ShikibetsuCode(div.getShikibetsuCode()),
                    new FlexibleDate(div.getPanelInput().getTxtStartDate().getValue().toString()));
            RoreiFukushiNenkinJukyusha busiRoreiFukushiNenkin
                    = getHandler(div).set老齢福祉年金確定ボタン押下の更新処理(models.get(key).modifiedModel());
            models.deleteOrRemove(key);
            models.add(busiRoreiFukushiNenkin);
        }
        if (状態_削除.equals(イベント状態)
                && !状態_追加.equals(div.getDatagridRireki().getActiveRow().getJotai())) {
            RoreiFukushiNenkinJukyushaIdentifier key = new RoreiFukushiNenkinJukyushaIdentifier(
                    new ShikibetsuCode(div.getShikibetsuCode()),
                    new FlexibleDate(div.getPanelInput().getTxtStartDate().getValue().toString()));
            RoreiFukushiNenkinJukyusha roreifukushinenkinjukyusha
                    = getHandler(div).set老齢福祉年金確定ボタン押下の削除処理(models.get(key).deleted());
            models.deleteOrRemove(key);
            models.add(roreifukushinenkinjukyusha);
        } else if (状態_削除.equals(イベント状態)
                && 状態_追加.equals(div.getDatagridRireki().getActiveRow().getJotai())) {
            RoreiFukushiNenkinJukyushaIdentifier key = new RoreiFukushiNenkinJukyushaIdentifier(
                    new ShikibetsuCode(div.getShikibetsuCode()),
                    new FlexibleDate(div.getPanelInput().getTxtStartDate().getValue().toString()));
            models.deleteOrRemove(key);
        }
        ViewStateHolder.put(ViewStateKeys.老齢福祉年金情報検索結果一覧, models);
        getHandler(div).setDatagridRirekichiran(イベント状態);
        getHandler(div).set確定ボタン画面表示();
        return ResponseData.of(div).respond();
    }

    private RoreiFukushiNenkinShokaiHandler getHandler(RoreiFukushiNenkinShokaiDiv div) {
        return new RoreiFukushiNenkinShokaiHandler(div);
    }

}
