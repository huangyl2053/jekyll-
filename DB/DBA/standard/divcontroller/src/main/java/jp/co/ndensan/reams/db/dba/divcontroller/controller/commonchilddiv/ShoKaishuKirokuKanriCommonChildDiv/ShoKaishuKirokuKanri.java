/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.commonchilddiv.ShoKaishuKirokuKanriCommonChildDiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri.ShoKaishuKirokuKanriDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri.ShoKaishuKirokuKanriHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri.ValidationHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri.dgKoufuKaishu_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 証回収記録管理のクラス。
 *
 * @reamsid_L DBA-1070-010 lizhuoxuan
 */
public class ShoKaishuKirokuKanri {

    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 被保険者証 = new RString("被保険者証");
    private static final RString CODESHUBETSU_0002 = new RString("0002");
    private static final RString CODESHUBETSU_0003 = new RString("0003");
    private static final RString CODESHUBETSU_0004 = new RString("0004");
    private static final RString CODESHUBETSU_0005 = new RString("0005");

    /**
     * 選択ボタン。<br/>
     *
     * @param requestDiv 証回収記録管理一覧Div
     * @return ResponseData<ShoKaishuKirokuKanriDiv>
     */
    public ResponseData<ShoKaishuKirokuKanriDiv> onClick_BtnSenTaKu(ShoKaishuKirokuKanriDiv requestDiv) {
        requestDiv.getPanelInput().setVisible(true);
        requestDiv.setMode_DisplayMode(ShoKaishuKirokuKanriDiv.DisplayMode.shokai_selected);
        dgKoufuKaishu_Row dgKoufuKaishuRow = requestDiv.getDgKoufuKaishu().getSelectedItems().get(0);
        requestDiv.getPanelInput().getTxtKoufuType().setValue(dgKoufuKaishuRow.getKoufuType());
        if (dgKoufuKaishuRow.getKoufuDate().getValue() != null) {
            requestDiv.getPanelInput().getTxtKoufuDate().setValue(dgKoufuKaishuRow.getKoufuDate().getValue());
        }
        if (dgKoufuKaishuRow.getYukoKigen().getValue() != null) {
            requestDiv.getPanelInput().getTxtYukouKigen().setValue(dgKoufuKaishuRow.getYukoKigen().getValue());
        }
        if (被保険者証.equals(dgKoufuKaishuRow.getKoufuType())) {
            requestDiv.getPanelInput().getDdlKoufuJiyu().setDataSource(getCode(new CodeShubetsu(CODESHUBETSU_0002)));
        } else {
            requestDiv.getPanelInput().getDdlKoufuJiyu().setDataSource(getCode(new CodeShubetsu(CODESHUBETSU_0004)));
        }
        requestDiv.getPanelInput().getDdlKoufuJiyu().setSelectedValue(dgKoufuKaishuRow.getKoufuJiyu());
        requestDiv.getPanelInput().getTxaKoufuRiyu().setValue(dgKoufuKaishuRow.getKofuRiyu());
        if (dgKoufuKaishuRow.getKaishuDate().getValue() != null) {
            requestDiv.getPanelInput().getTxtKaisyuDate().setValue(dgKoufuKaishuRow.getKaishuDate().getValue());
        }
        if (被保険者証.equals(dgKoufuKaishuRow.getKoufuType())) {
            requestDiv.getPanelInput().getDdlKaisyuJiyu().setDataSource(getCode(new CodeShubetsu(CODESHUBETSU_0003)));
        } else {
            requestDiv.getPanelInput().getDdlKaisyuJiyu().setDataSource(getCode(new CodeShubetsu(CODESHUBETSU_0005)));
        }
        requestDiv.getPanelInput().getDdlKaisyuJiyu().setSelectedValue(dgKoufuKaishuRow.getKaishuJiyu());
        requestDiv.getPanelInput().getTxaKaishuRiyu().setValue(dgKoufuKaishuRow.getKaishuRiyu());
        return createResponseData(requestDiv);
    }

    private List<KeyValueDataSource> getCode(CodeShubetsu codeShubetsu) {
        List<UzT0007CodeEntity> codeValueList = CodeMaster.getCode(codeShubetsu);
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (UzT0007CodeEntity codeValueObject : codeValueList) {
            dataSourceList.add(new KeyValueDataSource(codeValueObject.getコード().getKey(), codeValueObject.getコード略称()));
        }
        return dataSourceList;
    }

    /**
     * 修正ボタン。<br/>
     *
     * @param requestDiv 証回収記録管理一覧Div
     * @return ResponseData<ShoKaishuKirokuKanriDiv>
     */
    public ResponseData<ShoKaishuKirokuKanriDiv> onClick_ModifyButton(ShoKaishuKirokuKanriDiv requestDiv) {
        ViewStateHolder.put(ViewStateKeys.状態, 状態_修正);
        createHandlerOf(requestDiv).状態の修正(状態_修正);
        return createResponseData(requestDiv);
    }

    /**
     * 削除ボタン。<br/>
     *
     * @param requestDiv 証回収記録管理一覧Div
     * @return ResponseData<ShoKaishuKirokuKanriDiv>
     */
    public ResponseData<ShoKaishuKirokuKanriDiv> onClick_DeleteButton(ShoKaishuKirokuKanriDiv requestDiv) {
        ViewStateHolder.put(ViewStateKeys.状態, 状態_削除);
        createHandlerOf(requestDiv).状態の修正(状態_削除);
        return createResponseData(requestDiv);
    }

    /**
     * 確定ボタンを押下の処理に実行されます。<br/>
     * 入力した情報について、バリデーションチェックを行います。
     *
     * @param shoKaishuDiv {@link ShoKaishuKirokuKanriDiv 証回収記録管理Div}
     * @return ResponseData<ShoKaishuKirokuKanriDiv>
     */
    public ResponseData<ShoKaishuKirokuKanriDiv> onClick_btnShoKaishuKakutei(ShoKaishuKirokuKanriDiv shoKaishuDiv) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs controlPairs = check_btnKakuninn(shoKaishuDiv);
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(shoKaishuDiv).addValidationMessages(controlPairs).respond();
            }
        }

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        getValidationHandler(shoKaishuDiv).交付日と有効期限の整合性チェック(validationMessages);
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(shoKaishuDiv).addValidationMessages(validationMessages).respond();
        }

        if (状態_修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            shoKaishuDiv.getDgKoufuKaishu().getClickedItem().setStatus(状態_修正);
            List<dgKoufuKaishu_Row> list = shoKaishuDiv.getDgKoufuKaishu().getDataSource();
            int rowcount = shoKaishuDiv.getDgKoufuKaishu().getClickedItem().getId();
            dgKoufuKaishu_Row row = list.get(rowcount);
            row.setKoufuType(shoKaishuDiv.getPanelInput().getTxtKoufuType().getValue());
            row.getKoufuDate().setValue(shoKaishuDiv.getPanelInput().getTxtKoufuDate().getValue());
            row.getYukoKigen().setValue(shoKaishuDiv.getPanelInput().getTxtYukouKigen().getValue());
            row.setKoufuJiyu(shoKaishuDiv.getPanelInput().getDdlKoufuJiyu().getSelectedValue());
            row.setKoufuJiyuNo(shoKaishuDiv.getPanelInput().getDdlKoufuJiyu().getSelectedKey());
            row.setKofuRiyu(shoKaishuDiv.getPanelInput().getTxaKoufuRiyu().getValue());
            row.getKaishuDate().setValue(shoKaishuDiv.getPanelInput().getTxtKaisyuDate().getValue());
            row.setKaishuJiyu(shoKaishuDiv.getPanelInput().getDdlKaisyuJiyu().getSelectedValue());
            row.setKaishuJiyuNo(shoKaishuDiv.getPanelInput().getDdlKaisyuJiyu().getSelectedKey());
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

        ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
        return createResponseData(shoKaishuDiv);

    }

    /**
     * 取消ボタンを押下の処理に実行されます。<br/>
     * 明細エリアに入力した情報を破棄し、別処理が可能となる状態に戻します。
     *
     * @param shoKaishuDiv {@link ShoKaishuKirokuKanriDiv 証回収記録管理Div}
     * @return ResponseData<ShoKaishuKirokuKanriDiv>
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

    private ValidationMessageControlPairs check_btnKakuninn(ShoKaishuKirokuKanriDiv requestDiv) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();

        getValidationHandler(requestDiv).交付事由の必須チェック(validationMessages);
        getValidationHandler(requestDiv).交付理由の最大桁数(validationMessages);
        getValidationHandler(requestDiv).回収理由のの最大桁数(validationMessages);
        getValidationHandler(requestDiv).交付日と回収日の順番の整合性チェック(validationMessages);
        getValidationHandler(requestDiv).交付日がセットになっているかの入力チェック(validationMessages);
        getValidationHandler(requestDiv).交付事由がセットになっているかの入力チェック(validationMessages);
        getValidationHandler(requestDiv).回収日がセットになっているかの入力チェック(validationMessages);
        getValidationHandler(requestDiv).回収事由がセットになっているかの入力チェック(validationMessages);
        return validationMessages;
    }

    private ResponseData<ShoKaishuKirokuKanriDiv> createResponseData(ShoKaishuKirokuKanriDiv requestDiv) {
        ResponseData<ShoKaishuKirokuKanriDiv> response = new ResponseData();
        response.data = requestDiv;
        return response;
    }

    private ValidationHandler getValidationHandler(ShoKaishuKirokuKanriDiv requestDiv) {
        return new ValidationHandler(requestDiv);
    }

    private ShoKaishuKirokuKanriHandler createHandlerOf(ShoKaishuKirokuKanriDiv requestDiv) {
        return new ShoKaishuKirokuKanriHandler(requestDiv);
    }
}
