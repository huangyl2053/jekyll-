/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD2020003;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD209011.DBD209011_KyufuGakuGengakuTainoshaHaakuListParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020003.ChishutsuJokenParameterDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2020003.DBD2020003ValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 給付額減額滞納者把握リストDivControllerです。
 *
 * @reamsid_L DBD-3610-010 x_lilh
 */
public class ChishutsuJokenParameter {

    private static final RString CHECKED = new RString("key0");

    /**
     * 給付額減額滞納者把握リストDivの初期化を表します。
     *
     * @param div ChishutsuJokenParameterDiv
     * @return ResponseData<ChishutsuJokenParameterDiv>
     */
    public ResponseData<ChishutsuJokenParameterDiv> onLoad(ChishutsuJokenParameterDiv div) {
        div.getRadHihokenshaZenin().setSelectedKey(CHECKED);
        div.getRadHihokenshaZenin().setDisabled(false);
        div.getRadHihokenshaIgai().setDisabled(false);
        div.getChkJukyushaZenin().setDisabled(true);
        div.getChkJukyuNinteiShinseityusha().setDisabled(true);
        div.getChkJukyuNinteibiChushutsu().setDisabled(true);
        div.getChkNinteiYukoShuryobiChushutsu().setDisabled(true);
        div.getTxtJukyuNinteibiKaishi().setDisabled(true);
        div.getTxtJukyuNinteibiShuryo().setDisabled(true);
        div.getTxtNinteiYukoShuryobiKaishi().setDisabled(true);
        div.getTxtNinteiYukoShuryobiShuryo().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 時効起算日登録者のみ入力押下処理
     *
     * @param div ChishutsuJokenParameterDiv
     * @return ResponseData<ChishutsuJokenParameterDiv>
     */
    public ResponseData<ChishutsuJokenParameterDiv> onClick_radJikoKisanbiTorokushaNomi(ChishutsuJokenParameterDiv div) {
        div.getRadJikoKisanbiTorokushaIgai().clearSelectedItem();
        div.getRadHihokenshaZenin().setSelectedKey(CHECKED);
        return ResponseData.of(div).respond();
    }

    /**
     * 時効起算日登録者以外入力押下処理
     *
     * @param div ChishutsuJokenParameterDiv
     * @return ResponseData<ChishutsuJokenParameterDiv>
     */
    public ResponseData<ChishutsuJokenParameterDiv> onClick_radJikoKisanbiTorokushaIgai(ChishutsuJokenParameterDiv div) {
        div.getRadJikoKisanbiTorokushaNomi().clearSelectedItem();
        div.getRadHihokenshaZenin().setSelectedKey(CHECKED);
        div.getRadHihokenshaZenin().setDisabled(false);
        div.getRadHihokenshaIgai().setDisabled(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者全員入力押下処理
     *
     * @param div ChishutsuJokenParameterDiv
     * @return ResponseData<ChishutsuJokenParameterDiv>
     */
    public ResponseData<ChishutsuJokenParameterDiv> onClick_radHihokenshaZenin(ChishutsuJokenParameterDiv div) {
        div.getRadHihokenshaIgai().clearSelectedItem();
        div.getChkJukyushaZenin().setDisabled(true);
        div.getChkJukyuNinteiShinseityusha().setDisabled(true);
        div.getChkJukyuNinteibiChushutsu().setDisabled(true);
        div.getChkNinteiYukoShuryobiChushutsu().setDisabled(true);
        div.getTxtJukyuNinteibiKaishi().setDisabled(true);
        div.getTxtJukyuNinteibiShuryo().setDisabled(true);
        div.getTxtNinteiYukoShuryobiKaishi().setDisabled(true);
        div.getTxtNinteiYukoShuryobiShuryo().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者全員以外入力押下処理
     *
     * @param div ChishutsuJokenParameterDiv
     * @return ResponseData<ChishutsuJokenParameterDiv>
     */
    public ResponseData<ChishutsuJokenParameterDiv> onClick_radHihokenshaIgai(ChishutsuJokenParameterDiv div) {
        div.getRadHihokenshaZenin().clearSelectedItem();
        div.getChkJukyushaZenin().setDisabled(false);
        div.getChkJukyuNinteiShinseityusha().setDisabled(false);
        div.getChkJukyuNinteibiChushutsu().setDisabled(false);
        div.getChkNinteiYukoShuryobiChushutsu().setDisabled(false);
        div.getTxtJukyuNinteibiKaishi().setDisabled(false);
        div.getTxtJukyuNinteibiShuryo().setDisabled(false);
        div.getTxtNinteiYukoShuryobiKaishi().setDisabled(false);
        div.getTxtNinteiYukoShuryobiShuryo().setDisabled(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 受給認定日抽出を選択の処理
     *
     * @param div ChishutsuJokenParameterDiv
     * @return ResponseData<ChishutsuJokenParameterDiv>
     */
    public ResponseData<ChishutsuJokenParameterDiv> onClick_chkJukyuNinteibiChushutsu(ChishutsuJokenParameterDiv div) {

        if (div.getChkJukyuNinteibiChushutsu().getSelectedKeys() != null && !div.getChkJukyuNinteibiChushutsu().getSelectedKeys().isEmpty()) {
            div.getTxtJukyuNinteibiKaishi().setDisabled(false);
            div.getTxtJukyuNinteibiShuryo().setDisabled(false);
        } else {
            div.getTxtJukyuNinteibiKaishi().setDisabled(true);
            div.getTxtJukyuNinteibiShuryo().setDisabled(true);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 認定有効終了日抽出の処理
     *
     * @param div ChishutsuJokenParameterDiv
     * @return ResponseData<ChishutsuJokenParameterDiv>
     */
    public ResponseData<ChishutsuJokenParameterDiv> onClick_chkNinteiYukoShuryobiChushutsu(ChishutsuJokenParameterDiv div) {

        if (div.getChkNinteiYukoShuryobiChushutsu().getSelectedKeys() != null && !div.getChkNinteiYukoShuryobiChushutsu().getSelectedKeys().isEmpty()) {
            div.getTxtNinteiYukoShuryobiKaishi().setDisabled(false);
            div.getTxtNinteiYukoShuryobiShuryo().setDisabled(false);
        } else {
            div.getTxtNinteiYukoShuryobiKaishi().setDisabled(true);
            div.getTxtNinteiYukoShuryobiShuryo().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行するボタンを押下のチェック処理します。
     *
     * @param div ChishutsuJokenParameterDiv
     * @return ResponseData<ChishutsuJokenParameterDiv>
     */
    public ResponseData<ChishutsuJokenParameterDiv> onClick_btnCheck(ChishutsuJokenParameterDiv div) {
        ValidationMessageControlPairs pairs = getHandler(div).バッチ実行前チェック();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        return createResponse(div);
    }

    /**
     * 実行ボタン押下、チェックとバッチパラメターを設定
     *
     * @param div ShiharaiHohoHenkoHakuListMainDiv
     * @return ResponseData<ShiharaiHohoHenkoHakuListMainDiv>
     */
    public ResponseData<DBD209011_KyufuGakuGengakuTainoshaHaakuListParameter> onClick_btnBatchExecute(ChishutsuJokenParameterDiv div) {
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }

    private ResponseData<ChishutsuJokenParameterDiv> createResponse(ChishutsuJokenParameterDiv div) {
        ResponseData<ChishutsuJokenParameterDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    private DBD2020003ValidationHandler getHandler(ChishutsuJokenParameterDiv div) {
        return new DBD2020003ValidationHandler(div);
    }
}
