/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.commonchilddiv.ShoKaishuKirokuKanriCommonChildDiv;

import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri.ShoKaishuKirokuKanriDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri.ShoKaishuKirokuKanriHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri.ValidationHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri.dgKoufuKaishu_Row;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 証回収記録管理のクラス。
 */
public class ShoKaishuKirokuKanri {

    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");

    /**
     * 証回収記録管理一覧。<br/>
     *
     * @param requestDiv 証回収記録管理一覧Div
     * @return レスポンス
     */
    public ResponseData<ShoKaishuKirokuKanriDiv> onLoad(ShoKaishuKirokuKanriDiv requestDiv) {
        ResponseData<ShoKaishuKirokuKanriDiv> responseData = new ResponseData<>();
        ShoKaishuKirokuKanriHandler handler = createHandlerOf(requestDiv);
        handler.initialize();
        responseData.data = requestDiv;
        return responseData;
    }

    /**
     * 選択ボタン。<br/>
     *
     * @param requestDiv 証回収記録管理一覧Div
     * @return レスポンス
     */
    public ResponseData<ShoKaishuKirokuKanriDiv> onClick_BtnSenTaKu(ShoKaishuKirokuKanriDiv requestDiv) {
        requestDiv.getPanelInput().setVisible(true);
        dgKoufuKaishu_Row dgKoufuKaishuRow = requestDiv.getDgKoufuKaishu().getSelectedItems().get(0);
        requestDiv.getPanelInput().getTxtKoufuType().setValue(dgKoufuKaishuRow.getKoufuType());
        requestDiv.getPanelInput().getTxtKoufuDate().setValue(new RDate(dgKoufuKaishuRow.getKoufuDate().toString()));
        requestDiv.getPanelInput().getTxtKoufuDate().setReadOnly(true);
        requestDiv.getPanelInput().getTxtYukouKigen().setValue(new RDate(dgKoufuKaishuRow.getYukoKigen().toString()));
        requestDiv.getPanelInput().getTxtYukouKigen().setReadOnly(true);
        requestDiv.getPanelInput().getDdlKoufuJiyu().setSelectedValue(dgKoufuKaishuRow.getKoufuJiyu());
        requestDiv.getPanelInput().getDdlKoufuJiyu().setReadOnly(true);
        requestDiv.getPanelInput().getTxaKoufuRiyu().setValue(dgKoufuKaishuRow.getKofuRiyu());
        requestDiv.getPanelInput().getTxaKoufuRiyu().setReadOnly(true);
        requestDiv.getPanelInput().getTxtKaisyuDate().setValue(new RDate(dgKoufuKaishuRow.getKaishuDate().toString()));
        requestDiv.getPanelInput().getTxtKaisyuDate().setReadOnly(true);
        requestDiv.getPanelInput().getDdlKaisyuJiyu().setSelectedValue(dgKoufuKaishuRow.getKaishuJiyu());
        requestDiv.getPanelInput().getDdlKaisyuJiyu().setReadOnly(true);
        requestDiv.getPanelInput().getTxaKaishuRiyu().setValue(dgKoufuKaishuRow.getKaishuRiyu());
        requestDiv.getPanelInput().getTxaKaishuRiyu().setReadOnly(true);
        requestDiv.getBtnCancel().setVisible(false);
        requestDiv.getBtnConfirm().setVisible(false);
        return createResponseData(requestDiv);
    }

    /**
     * 修正ボタン。<br/>
     *
     * @param requestDiv 証回収記録管理一覧Div
     * @return レスポンス
     */
    public ResponseData<ShoKaishuKirokuKanriDiv> onClick_ModifyButton(ShoKaishuKirokuKanriDiv requestDiv) {
        ViewStateHolder.put(ViewStateKeys.状態, 状態_修正);
        return createResponseData(状態の修正(requestDiv, 状態_修正));
    }

    /**
     * 削除ボタン。<br/>
     *
     * @param requestDiv 証回収記録管理一覧Div
     * @return レスポンス
     */
    public ResponseData<ShoKaishuKirokuKanriDiv> onClick_DeleteButton(ShoKaishuKirokuKanriDiv requestDiv) {

        ViewStateHolder.put(ViewStateKeys.状態, 状態_削除);
        return createResponseData(状態の修正(requestDiv, 状態_削除));
    }

    private ShoKaishuKirokuKanriDiv 状態の修正(ShoKaishuKirokuKanriDiv requestDiv, RString 状態) {
        dgKoufuKaishu_Row dgKoufuKaishuRow = requestDiv.getDgKoufuKaishu().getSelectedItems().get(0);

        requestDiv.getPanelInput().getTxtKoufuType().setValue(dgKoufuKaishuRow.getKoufuType());
        requestDiv.getPanelInput().getTxtKoufuDate().setValue(new RDate(dgKoufuKaishuRow.getKoufuDate().toString()));
        requestDiv.getPanelInput().getTxtYukouKigen().setValue(new RDate(dgKoufuKaishuRow.getYukoKigen().toString()));
        requestDiv.getPanelInput().getDdlKoufuJiyu().setSelectedValue(dgKoufuKaishuRow.getKoufuJiyu());
        requestDiv.getPanelInput().getTxaKoufuRiyu().setValue(dgKoufuKaishuRow.getKofuRiyu());
        requestDiv.getPanelInput().getTxtKaisyuDate().setValue(new RDate(dgKoufuKaishuRow.getKaishuDate().toString()));
        requestDiv.getPanelInput().getDdlKaisyuJiyu().setSelectedValue(dgKoufuKaishuRow.getKaishuJiyu());
        requestDiv.getPanelInput().getTxaKaishuRiyu().setValue(dgKoufuKaishuRow.getKaishuRiyu());
        requestDiv.getBtnCancel().setDisabled(false);
        requestDiv.getBtnConfirm().setDisabled(false);

        if (状態_削除.equals(状態)) {

            requestDiv.getPanelInput().getTxtKoufuDate().setReadOnly(true);
            requestDiv.getPanelInput().getTxtYukouKigen().setReadOnly(true);
            requestDiv.getPanelInput().getDdlKoufuJiyu().setReadOnly(true);
            requestDiv.getPanelInput().getTxaKoufuRiyu().setReadOnly(true);
            requestDiv.getPanelInput().getTxtKaisyuDate().setReadOnly(true);
            requestDiv.getPanelInput().getDdlKaisyuJiyu().setReadOnly(true);
            requestDiv.getPanelInput().getTxaKaishuRiyu().setReadOnly(true);
        } else {
            requestDiv.getPanelInput().getTxtKoufuDate().setReadOnly(false);
            requestDiv.getPanelInput().getTxtYukouKigen().setReadOnly(false);
            requestDiv.getPanelInput().getDdlKoufuJiyu().setReadOnly(false);
            requestDiv.getPanelInput().getTxaKoufuRiyu().setReadOnly(false);
            requestDiv.getPanelInput().getTxtKaisyuDate().setReadOnly(false);
            requestDiv.getPanelInput().getDdlKaisyuJiyu().setReadOnly(false);
            requestDiv.getPanelInput().getTxaKaishuRiyu().setReadOnly(false);
        }
        return requestDiv;
    }

    /**
     * 確定ボタンを押下の処理に実行されます。<br/>
     * 入力した情報について、バリデーションチェックを行います。
     *
     * @param shoKaishuDiv {@link ShoKaishuKirokuKanriDiv 証回収記録管理Div}
     * @return 証回収記録管理Divを持つResponseData
     */
    public ResponseData<ShoKaishuKirokuKanriDiv> onClick_btnShoKaishuKakutei(ShoKaishuKirokuKanriDiv shoKaishuDiv) {
        if (!check_btnKakuninn(shoKaishuDiv).iterator().hasNext()) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(shoKaishuDiv).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
            } else {
                if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
                    if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                        if (状態_修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
                            shoKaishuDiv.getDgKoufuKaishu().getClickedItem().setStatus(状態_修正);
                            List<dgKoufuKaishu_Row> list = shoKaishuDiv.getDgKoufuKaishu().getDataSource();
                            int rowcount = shoKaishuDiv.getDgKoufuKaishu().getGridSetting().selectedRowCount();
                            dgKoufuKaishu_Row row = list.get(rowcount);

                            row.setKoufuType(shoKaishuDiv.getPanelInput().getTxtKoufuType().getValue());
                            row.setKoufuDate(shoKaishuDiv.getPanelInput().getTxtKoufuDate().getValue().toDateString());
                            row.setKaishuDate(shoKaishuDiv.getPanelInput().getTxtKaisyuDate().getValue().toDateString());
                            row.setKofuRiyu(shoKaishuDiv.getPanelInput().getTxaKoufuRiyu().getValue());
                            row.setKaishuRiyu(shoKaishuDiv.getPanelInput().getTxaKaishuRiyu().getValue());
                            list.set(rowcount, row);

                            shoKaishuDiv.getDgKoufuKaishu().setDataSource(list);
                            createResponseData(shoKaishuDiv).data = shoKaishuDiv;
                        }
                        if (状態_削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
                            shoKaishuDiv.getDgKoufuKaishu().getClickedItem().setStatus(状態_削除);
                        }
                        shoKaishuDiv.getPanelInput().getTxtKoufuType().clearValue();
                        shoKaishuDiv.getPanelInput().getTxtKoufuDate().clearValue();
                        shoKaishuDiv.getPanelInput().getTxtYukouKigen().clearValue();
                        shoKaishuDiv.getPanelInput().getDdlKoufuJiyu().setSelectedValue(RString.EMPTY);
                        shoKaishuDiv.getPanelInput().getTxaKoufuRiyu().clearValue();
                        shoKaishuDiv.getPanelInput().getTxtKaisyuDate().clearValue();
                        shoKaishuDiv.getPanelInput().getDdlKaisyuJiyu().setSelectedValue(RString.EMPTY);
                        shoKaishuDiv.getPanelInput().getTxaKaishuRiyu().clearValue();
                        shoKaishuDiv.getPanelInput().getBtnConfirm().setDisabled(true);
                        shoKaishuDiv.getPanelInput().getBtnCancel().setDisabled(true);
                    }
                }
                ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
                return createResponseData(shoKaishuDiv);
            }
        } else {
            return ResponseData.of(shoKaishuDiv).addValidationMessages(check_btnKakuninn(shoKaishuDiv)).respond();
        }
    }

    /**
     * 取消ボタンを押下の処理に実行されます。<br/>
     * 明細エリアに入力した情報を破棄し、別処理が可能となる状態に戻します。
     *
     * @param shoKaishuDiv {@link ShoKaishuKirokuKanriDiv 証回収記録管理Div}
     * @return 証回収記録管理Divを持つResponseData
     */
    public ResponseData<ShoKaishuKirokuKanriDiv> onClick_btnShoKaishuTorikeshi(ShoKaishuKirokuKanriDiv shoKaishuDiv) {
        ResponseData<ShoKaishuKirokuKanriDiv> response = new ResponseData<>();
        shoKaishuDiv.getPanelInput().getTxtKoufuType().clearValue();
        shoKaishuDiv.getPanelInput().getTxtKoufuDate().clearValue();
        shoKaishuDiv.getPanelInput().getTxtYukouKigen().clearValue();
        shoKaishuDiv.getPanelInput().getDdlKoufuJiyu().setSelectedValue(RString.EMPTY);
        shoKaishuDiv.getPanelInput().getTxaKoufuRiyu().clearValue();
        shoKaishuDiv.getPanelInput().getTxtKaisyuDate().clearValue();
        shoKaishuDiv.getPanelInput().getDdlKaisyuJiyu().setSelectedValue(RString.EMPTY);
        shoKaishuDiv.getPanelInput().getTxaKaishuRiyu().clearValue();
        shoKaishuDiv.getPanelInput().getBtnConfirm().setDisabled(true);
        shoKaishuDiv.getPanelInput().getBtnCancel().setDisabled(true);
        response.data = shoKaishuDiv;
        return response;
    }

    private ShoKaishuKirokuKanriHandler createHandlerOf(ShoKaishuKirokuKanriDiv requestDiv) {
        return new ShoKaishuKirokuKanriHandler(requestDiv);
    }

    private ValidationMessageControlPairs check_btnKakuninn(ShoKaishuKirokuKanriDiv requestDiv) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (requestDiv.getPanelInput().getTxtKoufuType().getValue() != null
                && new RString("資格者証").equals(requestDiv.getPanelInput().getTxtKoufuType().getValue())) {
            if (requestDiv.getPanelInput().getTxtKoufuDate().getValue() != null
                    && requestDiv.getPanelInput().getTxtYukouKigen().getValue() != null) {
                if (!requestDiv.getPanelInput().getTxtKoufuDate().getValue().
                        isBefore(requestDiv.getPanelInput().getTxtYukouKigen().getValue())) {
                    validationMessages.add(ValidationHandler.交付日と有効期限の整合性チェック());
                    return validationMessages;
                }
            }
        }
        if (requestDiv.getPanelInput().getDdlKoufuJiyu().getSelectedValue() != null) {
            if (RString.EMPTY.equals(requestDiv.getPanelInput().getDdlKoufuJiyu().getSelectedValue())) {
                validationMessages.add(ValidationHandler.交付事由の必須チェック());
                return validationMessages;
            }
        }
        if (requestDiv.getPanelInput().getTxaKoufuRiyu().getValue() != null) {
            if (256 < requestDiv.getPanelInput().getTxaKoufuRiyu().getValue().length()) {
                validationMessages.add(ValidationHandler.交付理由の最大桁数());
                return validationMessages;
            }
        }
        if (requestDiv.getPanelInput().getTxaKaishuRiyu().getValue() != null) {
            if (256 < requestDiv.getPanelInput().getTxaKaishuRiyu().getValue().length()) {
                validationMessages.add(ValidationHandler.回収理由のの最大桁数());
                return validationMessages;
            }
        }
        if (requestDiv.getPanelInput().getTxtKoufuDate().getValue() != null
                && requestDiv.getPanelInput().getTxtKaisyuDate().getValue() != null) {
            if (requestDiv.getPanelInput().getTxtKaisyuDate().getValue().
                    isBefore(requestDiv.getPanelInput().getTxtKoufuDate().getValue())) {
                validationMessages.add(ValidationHandler.交付日と回収日の順番の整合性チェック());
                return validationMessages;
            }
        }
        if (requestDiv.getPanelInput().getTxtKoufuDate().getValue() == null
                && requestDiv.getPanelInput().getTxaKoufuRiyu().getValue() != null) {
            validationMessages.add(ValidationHandler.交付日がセットになっているかの入力チェック());
            return validationMessages;
        }
        if (RString.EMPTY.equals(requestDiv.getPanelInput().getTxaKoufuRiyu().getValue())
                && requestDiv.getPanelInput().getTxtKoufuDate().getValue() != null) {
            validationMessages.add(ValidationHandler.交付事由がセットになっているかの入力チェック());
            return validationMessages;
        }
        if (requestDiv.getPanelInput().getTxtKaisyuDate().getValue() == null
                && requestDiv.getPanelInput().getTxaKaishuRiyu().getValue() != null) {
            validationMessages.add(ValidationHandler.回収日がセットになっているかの入力チェック());
            return validationMessages;
        }
        if (RString.EMPTY.equals(requestDiv.getPanelInput().getTxaKaishuRiyu().getValue())
                && requestDiv.getPanelInput().getTxtKaisyuDate().getValue() != null) {
            validationMessages.add(ValidationHandler.回収事由がセットになっているかの入力チェック());
            return validationMessages;
        }
        return validationMessages;
    }

    private ResponseData<ShoKaishuKirokuKanriDiv> createResponseData(ShoKaishuKirokuKanriDiv requestDiv) {
        ResponseData<ShoKaishuKirokuKanriDiv> response = new ResponseData();
        response.data = requestDiv;
        return response;
    }

}
