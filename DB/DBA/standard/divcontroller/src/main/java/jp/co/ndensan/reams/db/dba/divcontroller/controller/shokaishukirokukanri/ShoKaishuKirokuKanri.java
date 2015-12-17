/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.shokaishukirokukanri;

import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri.ShoKaishuKirokuKanriDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri.ShoKaishuKirokuKanriHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri.dgKoufuKaishu_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 共有子Div「証回収記録管理」のイベントを定義した共有子Divです。
 *
 */
public class ShoKaishuKirokuKanri {

    /**
     * 証回収記録管理一覧。<br/>
     *
     * @param requestDiv 証回収記録管理一覧Div
     * @return レスポンス
     */
    public ResponseData<ShoKaishuKirokuKanriDiv> onLoad(ShoKaishuKirokuKanriDiv requestDiv) {

        ResponseData<ShoKaishuKirokuKanriDiv> responseData = new ResponseData<>();

        ShoKaishuKirokuKanriHandler handler = createHandlerOf(requestDiv);
        
        RString 状態 = DataPassingConverter.deserialize(requestDiv.getモード(), RString.class);
        RString 被保険者番号 = DataPassingConverter.deserialize(requestDiv.get被保険者番号(), RString.class);
        handler.initialize(状態,被保険者番号);
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
        //requestDiv.setMode_ModeB(ShoKaishuKirokuKanriDiv.ModeB.Update);
        requestDiv.getDgKoufuKaishu().getGridSetting().selectedRowCount();
        dgKoufuKaishu_Row dgKoufuKaishuRow = requestDiv.getDgKoufuKaishu().getSelectedItems().get(0);
        //requestDiv.getPanelInput().getTxtKoufuType().setValue(dgKoufuKaishuRow.getKoufuType());
        requestDiv.getPanelInput().getTxtKoufuDate().setValue(new RDate(dgKoufuKaishuRow.getKoufuDate().toString()));
        requestDiv.getPanelInput().getTxtKoufuDate().setReadOnly(true);
        // TODO QA:96
        //requestDiv.getPanelInput().getTxtKoufuType().setValue(dgKoufuKaishuRow.getYukoKigen());
        //requestDiv.getPanelInput().getDdlKoufuJiyu().setSelectedValue(RString.EMPTY);
        requestDiv.getPanelInput().getTxaKoufuRiyu().setValue(dgKoufuKaishuRow.getKofuRiyu());
        requestDiv.getPanelInput().getTxaKoufuRiyu().setReadOnly(true);
        requestDiv.getPanelInput().getTxtKaisyuDate().setValue(new RDate(dgKoufuKaishuRow.getKaishuDate().toString()));
        requestDiv.getPanelInput().getTxtKaisyuDate().setReadOnly(true);
        //requestDiv.getPanelInput().getDdlKaisyuJiyu().setSelectedValue(RString.EMPTY);
        requestDiv.getPanelInput().getTxaKaishuRiyu().setValue(dgKoufuKaishuRow.getKaishuRiyu());
        requestDiv.getPanelInput().getTxaKaishuRiyu().setReadOnly(true);
        return createResponseData(requestDiv);
    }
    
     /**
     * 修正ボタン。<br/>
     *
     * @param requestDiv 証回収記録管理一覧Div
     * @return レスポンス
     */
    public ResponseData<ShoKaishuKirokuKanriDiv> onClick_ModifyButton(ShoKaishuKirokuKanriDiv requestDiv) {
        requestDiv.getPanelInput().setVisible(true);
        dgKoufuKaishu_Row dgKoufuKaishuRow = requestDiv.getDgKoufuKaishu().getSelectedItems().get(0);
        //requestDiv.getPanelInput().getTxtKoufuType().setValue(dgKoufuKaishuRow.getKoufuType());
        requestDiv.getPanelInput().getTxtKoufuDate().setValue(new RDate(dgKoufuKaishuRow.getKoufuDate().toString()));
        // TODO QA:96
        //requestDiv.getPanelInput().getTxtKoufuType().setValue(dgKoufuKaishuRow.getYukoKigen());
        //requestDiv.getPanelInput().getDdlKoufuJiyu().setSelectedValue(RString.EMPTY);
        requestDiv.getPanelInput().getTxaKoufuRiyu().setValue(dgKoufuKaishuRow.getKofuRiyu());
        requestDiv.getPanelInput().getTxtKaisyuDate().setValue(new RDate(dgKoufuKaishuRow.getKaishuDate().toString()));
        //requestDiv.getPanelInput().getDdlKaisyuJiyu().setSelectedValue(RString.EMPTY);
        requestDiv.getPanelInput().getTxaKaishuRiyu().setValue(dgKoufuKaishuRow.getKaishuRiyu());
        return createResponseData(requestDiv);
    }
    
                /**
     * 削除ボタン。<br/>
     *
     * @param requestDiv 証回収記録管理一覧Div
     * @return レスポンス
     */
    public ResponseData<ShoKaishuKirokuKanriDiv> onClick_DeleteButton(ShoKaishuKirokuKanriDiv requestDiv) {
        requestDiv.getPanelInput().setVisible(true);
        dgKoufuKaishu_Row dgKoufuKaishuRow = requestDiv.getDgKoufuKaishu().getSelectedItems().get(0);
        //requestDiv.getPanelInput().getTxtKoufuType().setValue(dgKoufuKaishuRow.getKoufuType());
        requestDiv.getPanelInput().getTxtKoufuDate().setValue(new RDate(dgKoufuKaishuRow.getKoufuDate().toString()));
        requestDiv.getPanelInput().getTxtKoufuDate().setReadOnly(true);
        // TODO QA:96
        //requestDiv.getPanelInput().getTxtKoufuType().setValue(dgKoufuKaishuRow.getYukoKigen());
        //requestDiv.getPanelInput().getDdlKoufuJiyu().setSelectedValue(RString.EMPTY);
        requestDiv.getPanelInput().getTxaKoufuRiyu().setValue(dgKoufuKaishuRow.getKofuRiyu());
        requestDiv.getPanelInput().getTxaKoufuRiyu().setReadOnly(true);
        requestDiv.getPanelInput().getTxtKaisyuDate().setValue(new RDate(dgKoufuKaishuRow.getKaishuDate().toString()));
        requestDiv.getPanelInput().getTxtKaisyuDate().setReadOnly(true);
        //requestDiv.getPanelInput().getDdlKaisyuJiyu().setSelectedValue(RString.EMPTY);
        requestDiv.getPanelInput().getTxaKaishuRiyu().setValue(dgKoufuKaishuRow.getKaishuRiyu());
        requestDiv.getPanelInput().getTxaKaishuRiyu().setReadOnly(true);
        return createResponseData(requestDiv);
    }

    /**
     * 確定ボタンを押下の処理に実行されます。<br/>
     * 入力した情報について、バリデーションチェックを行います。
     *
     * @param shoKaishuDiv {@link ShoKaishuKirokuKanriDiv 証回収記録管理Div}
     * @return 証回収記録管理Divを持つResponseData
     */
    public ResponseData<ShoKaishuKirokuKanriDiv> onClick_btnShoKaishuKakutei(ShoKaishuKirokuKanriDiv shoKaishuDiv) {
        ResponseData<ShoKaishuKirokuKanriDiv> response = new ResponseData<>();
        List<dgKoufuKaishu_Row> list =  shoKaishuDiv.getDgKoufuKaishu().getDataSource();
        int count = shoKaishuDiv.getDgKoufuKaishu().getGridSetting().selectedRowCount();
        dgKoufuKaishu_Row row = list.get(count);
        
        //row.setKoufuType(shoKaishuDiv.getPanelInput().getTxtKoufuType().getValue());
        row.setKoufuDate(shoKaishuDiv.getPanelInput().getTxtKoufuDate().getValue().toDateString());
        row.setKaishuDate(shoKaishuDiv.getPanelInput().getTxtKaisyuDate().getValue().toDateString());
        row.setKofuRiyu(shoKaishuDiv.getPanelInput().getTxaKoufuRiyu().getValue());
        row.setKaishuRiyu(shoKaishuDiv.getPanelInput().getTxaKaishuRiyu().getValue());
        list.set(count, row);
        
        shoKaishuDiv.getDgKoufuKaishu().setDataSource(list);
        response.data = shoKaishuDiv;
        shoKaishuDiv.getPanelInput().getTxtKoufuDate().clearValue();
        shoKaishuDiv.getPanelInput().getTxtKaisyuDate().clearValue();
        shoKaishuDiv.getPanelInput().getTxaKoufuRiyu().clearValue();
        shoKaishuDiv.getPanelInput().getTxaKaishuRiyu().clearValue();
        shoKaishuDiv.getPanelInput().getBtnConfirm().setDisabled(true);
        shoKaishuDiv.getPanelInput().getBtnCancel().setDisabled(true);
        return response;
    }
    
//        private void setMsg(){
//        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
//        ValidationMessageControlPair message = new ValidationMessageControlPair(
//                        DbzErrorMessages.期間が不正_追加メッセージあり２);
//        message.getValidationMessage().getMessage().replace("有効期限","交付日");
//                validationMessages.add(message);
//    }
    
    /**
     * 取消ボタンを押下の処理に実行されます。<br/>
     * 明細エリアに入力した情報を破棄し、別処理が可能となる状態に戻します。
     *
     * @param shoKaishuDiv {@link ShoKaishuKirokuKanriDiv 証回収記録管理Div}
     * @return 証回収記録管理Divを持つResponseData
     */
    public ResponseData<ShoKaishuKirokuKanriDiv> onClick_btnShoKaishuTorikeshi(ShoKaishuKirokuKanriDiv shoKaishuDiv) {
        ResponseData<ShoKaishuKirokuKanriDiv> response = new ResponseData<>();
        response.data = shoKaishuDiv;
        shoKaishuDiv.getPanelInput().getTxtKoufuDate().clearValue();
        shoKaishuDiv.getPanelInput().getTxtKaisyuDate().clearValue();
        shoKaishuDiv.getPanelInput().getTxaKoufuRiyu().clearValue();
        shoKaishuDiv.getPanelInput().getTxaKaishuRiyu().clearValue();
        shoKaishuDiv.getPanelInput().getBtnConfirm().setDisabled(true);
        shoKaishuDiv.getPanelInput().getBtnCancel().setDisabled(true);
        return response;
    }

    private <T> ResponseData<T> createSettingData(T settingData) {
        ResponseData<T> response = new ResponseData<>();
        response.data = settingData;
        return response;
    }

    private ShoKaishuKirokuKanriHandler createHandlerOf(ShoKaishuKirokuKanriDiv requestDiv) {
        return new ShoKaishuKirokuKanriHandler(requestDiv);
    }

    private ResponseData<ShoKaishuKirokuKanriDiv> createResponseData(ShoKaishuKirokuKanriDiv requestDiv) {
        ResponseData<ShoKaishuKirokuKanriDiv> response = new ResponseData();
        response.data = requestDiv;
        return response;
    }

}
