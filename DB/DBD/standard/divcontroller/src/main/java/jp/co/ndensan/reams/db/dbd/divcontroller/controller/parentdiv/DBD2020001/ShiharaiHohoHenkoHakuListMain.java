/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD2020001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD2020001.ShiharaiHohoHenkoHaakuIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020001.ShiharaiHohoHenkoHakuListMainDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2020001.DBD2020001ValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 支払方法変更滞納者把握リストクラスです．
 *
 * @reamsid_L DBD-3650-010 x_lilh
 */
public class ShiharaiHohoHenkoHakuListMain {

    /**
     * 画面初期化
     *
     * @param div　画面Div
     * @return ResponseData<ShiharaiHohoHenkoHakuListMainDiv>
     */
    public ResponseData<ShiharaiHohoHenkoHakuListMainDiv> onLoad(ShiharaiHohoHenkoHakuListMainDiv div) {
        div.getTxtTainoKikanHihokenshaAll().setValue(Decimal.valueOf(get支払方法変更_支払方法変更期限()));
        div.getTxtTainoKikanJukyushaAll().setValue(Decimal.valueOf(get支払方法変更_支払方法変更期限()));
        div.getTxtTainoKikanNinteiShinseisha().setValue(Decimal.valueOf(get支払方法変更_支払方法変更期限()));
        div.getTxtTainoKikanNinteiYMD().setValue(Decimal.valueOf(get支払方法変更_支払方法変更期限()));
        div.getTxtTainoKikanShokanShinseisha().setValue(Decimal.valueOf(get支払方法変更_支払方法変更期限()));
        div.getTxtTainoKikanShokanKettei().setValue(Decimal.valueOf(get支払方法変更_支払方法変更期限()));
        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者選択を選択押下処理
     *
     * @param div　画面Div
     * @return ResponseData<ShiharaiHohoHenkoHakuListMainDiv>
     */
    public ResponseData<ShiharaiHohoHenkoHakuListMainDiv> onClick_radHihokenshaAll(ShiharaiHohoHenkoHakuListMainDiv div) {
        div.getRadHihokenshaIgaiAll().clearSelectedItem();
        div.getTxtTainoKikanHihokenshaAll().setDisabled(false);
        div.getHihokenshaIgai().setDisabled(true);
        div.getChkJukyushaAll().getSelectedItems().clear();
        div.getTxtTainoKikanJukyushaAll().clearValue();
        div.getTxtTainoNengetsuJukyushaAll().clearValue();
        div.getChkNinteiShinseisha().getSelectedItems().clear();
        div.getTxtTainoKikanNinteiShinseisha().clearValue();
        div.getTxtTainoNengetsuNinteiShinseisha().clearValue();
        div.getChkNinteiYMD().getSelectedItems().clear();
        div.getTxtNinteiDateFrom().clearValue();
        div.getTxtNinteiYMDTo().clearValue();
        div.getTxtTainoKikanNinteiYMD().clearValue();
        div.getTxtTainoNengetsuNinteiYMD().clearValue();
        div.getChkShokanShinseisha().getSelectedItems().clear();
        div.getTxtTainoKikanShokanShinseisha().clearValue();
        div.getTxtTainoNengetsuShokanShinseisha().clearValue();
        div.getChkShokanKetteiYMD().getSelectedItems().clear();
        div.getTxtShokanKetteiYMDFrom().clearValue();
        div.getTxtShokanKetteiYMDTo().clearValue();
        div.getTxtTainoKikanShokanKettei().clearValue();
        div.getTxtTainoNengetsuShokanKettei().clearValue();

        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者全員と被保険者全員以外変更処理
     *
     * @param div 画面Div
     * @return ResponseData<ShiharaiHohoHenkoHakuListMainDiv>
     */
    public ResponseData<ShiharaiHohoHenkoHakuListMainDiv> onClick_radHihokenshaIgaiAll(ShiharaiHohoHenkoHakuListMainDiv div) {
        div.getRadHihokenshaAll().clearSelectedItem();
        div.getHihokenshaIgai().setDisabled(false);
        div.getChkJukyushaAll().setDisabled(false);
        div.getChkNinteiShinseisha().setDisabled(false);
        div.getChkNinteiYMD().setDisabled(false);
        div.getChkShokanShinseisha().setDisabled(false);
        div.getChkShokanKetteiYMD().setDisabled(false);
        div.getTxtTainoKikanHihokenshaAll().clearValue();
        div.getTxtTainoNengetsuHihokenshaAll().clearValue();

        div.getTxtTainoKikanHihokenshaAll().setDisabled(true);
        div.getTxtTainoKikanJukyushaAll().setDisabled(true);
        div.getTxtTainoKikanNinteiShinseisha().setDisabled(true);
        div.getTxtNinteiDateFrom().setDisabled(true);
        div.getTxtNinteiYMDTo().setDisabled(true);
        div.getTxtTainoKikanNinteiYMD().setDisabled(true);
        div.getTxtTainoKikanShokanShinseisha().setDisabled(true);
        div.getTxtShokanKetteiYMDFrom().setDisabled(true);
        div.getTxtShokanKetteiYMDTo().setDisabled(true);
        div.getTxtTainoKikanShokanKettei().setDisabled(true);

        return ResponseData.of(div).respond();
    }

    /**
     * 受給者全員を選択の処理
     *
     * @param div　画面Div
     * @return　ResponseData<ShiharaiHohoHenkoHakuListMainDiv>
     */
    public ResponseData<ShiharaiHohoHenkoHakuListMainDiv> onClick_chkJukyushaAll(ShiharaiHohoHenkoHakuListMainDiv div) {

        if (div.getChkJukyushaAll().getSelectedKeys() != null && !div.getChkJukyushaAll().getSelectedKeys().isEmpty()) {
            div.getTxtTainoKikanJukyushaAll().setDisabled(false);
        } else {
            div.getTxtTainoKikanJukyushaAll().clearValue();
            div.getTxtTainoNengetsuHihokenshaAll().clearValue();
            div.getTxtTainoKikanJukyushaAll().setDisabled(true);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 受給認定申請中者を選択の処理
     *
     * @param div　画面Div
     * @return　ResponseData<ShiharaiHohoHenkoHakuListMainDiv>
     */
    public ResponseData<ShiharaiHohoHenkoHakuListMainDiv> onClick_chkNinteiShinseisha(ShiharaiHohoHenkoHakuListMainDiv div) {

        if (div.getChkNinteiShinseisha().getSelectedKeys() != null && !div.getChkNinteiShinseisha().getSelectedKeys().isEmpty()) {
            div.getTxtTainoKikanNinteiShinseisha().setDisabled(false);
        } else {
            div.getTxtTainoKikanNinteiShinseisha().clearValue();
            div.getTxtTainoNengetsuNinteiShinseisha().clearValue();
            div.getTxtTainoKikanNinteiShinseisha().setDisabled(true);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 受給認定日抽出を選択の処理
     *
     * @param div　画面Div
     * @return　ResponseData<ShiharaiHohoHenkoHakuListMainDiv>
     */
    public ResponseData<ShiharaiHohoHenkoHakuListMainDiv> onClick_chkNinteiYMD(ShiharaiHohoHenkoHakuListMainDiv div) {

        if (div.getChkNinteiYMD().getSelectedKeys() != null && !div.getChkNinteiYMD().getSelectedKeys().isEmpty()) {
            div.getTxtTainoKikanNinteiYMD().setDisabled(false);
            div.getTxtNinteiDateFrom().setDisabled(false);
            div.getTxtNinteiYMDTo().setDisabled(false);
        } else {
            div.getTxtTainoKikanNinteiYMD().clearValue();
            div.getTxtNinteiDateFrom().clearValue();
            div.getTxtNinteiYMDTo().clearValue();
            div.getTxtTainoNengetsuNinteiYMD().clearValue();
            div.getTxtTainoKikanNinteiYMD().setDisabled(true);
            div.getTxtNinteiDateFrom().setDisabled(true);
            div.getTxtNinteiYMDTo().setDisabled(true);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 受給申請中者を選択の処理
     *
     * @param div　画面Div
     * @return　ResponseData<ShiharaiHohoHenkoHakuListMainDiv>
     */
    public ResponseData<ShiharaiHohoHenkoHakuListMainDiv> onClick_chkShokanShinseisha(ShiharaiHohoHenkoHakuListMainDiv div) {

        if (div.getChkShokanShinseisha().getSelectedKeys() != null && !div.getChkShokanShinseisha().getSelectedKeys().isEmpty()) {
            div.getTxtTainoKikanShokanShinseisha().setDisabled(false);
        } else {
            div.getTxtTainoKikanShokanShinseisha().clearValue();
            div.getTxtTainoNengetsuShokanShinseisha().clearValue();
            div.getTxtTainoKikanShokanShinseisha().setDisabled(true);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 受給支給決定日抽出を選択の処理
     *
     * @param div　画面Div
     * @return　ResponseData<ShiharaiHohoHenkoHakuListMainDiv>
     */
    public ResponseData<ShiharaiHohoHenkoHakuListMainDiv> onClick_chkShokanKetteiYMD(ShiharaiHohoHenkoHakuListMainDiv div) {

        if (div.getChkShokanKetteiYMD().getSelectedKeys() != null && !div.getChkShokanKetteiYMD().getSelectedKeys().isEmpty()) {
            div.getTxtTainoKikanShokanKettei().setDisabled(false);
            div.getTxtShokanKetteiYMDFrom().setDisabled(false);
            div.getTxtShokanKetteiYMDTo().setDisabled(false);
        } else {
            div.getTxtTainoKikanShokanKettei().clearValue();
            div.getTxtShokanKetteiYMDFrom().clearValue();
            div.getTxtShokanKetteiYMDTo().clearValue();
            div.getTxtTainoNengetsuShokanKettei().clearValue();
            div.getTxtTainoKikanShokanKettei().setDisabled(true);
            div.getTxtShokanKetteiYMDFrom().setDisabled(true);
            div.getTxtShokanKetteiYMDTo().setDisabled(true);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者全員の滞納期間からフォーカスアウト
     *
     * @param div 画面Div
     * @return ResponseData<ShiharaiHohoHenkoHakuListMainDiv>
     */
    public ResponseData<ShiharaiHohoHenkoHakuListMainDiv> focusout_txtTainoKikanHihokenshaAll(ShiharaiHohoHenkoHakuListMainDiv div) {
        div.getTxtTainoKikanHihokenshaAll().setValue(Decimal.valueOf(get支払方法変更_支払方法変更期限()));
        div.getTxtTainoNengetsuHihokenshaAll().setValue(getHandler(div).get支払方法変更期限に対する年月(div.getTxtTainoKikanHihokenshaAll().getValue()));
        return ResponseData.of(div).respond();
    }

    /**
     * 受給者全員の滞納期間からフォーカスアウト
     *
     * @param div 画面Div
     * @return ResponseData<ShiharaiHohoHenkoHakuListMainDiv>
     */
    public ResponseData<ShiharaiHohoHenkoHakuListMainDiv> focusout_txtTainoKikanJukyushaAll(ShiharaiHohoHenkoHakuListMainDiv div) {
        div.getTxtTainoKikanJukyushaAll().setValue(Decimal.valueOf(get支払方法変更_支払方法変更期限()));
        div.getTxtTainoNengetsuJukyushaAll().setValue(getHandler(div).get支払方法変更期限に対する年月(div.getTxtTainoKikanJukyushaAll().getValue()));
        return ResponseData.of(div).respond();
    }

    /**
     * 受給認定申請中者の滞納期間からフォーカスアウト
     *
     * @param div 画面Div
     * @return ResponseData<ShiharaiHohoHenkoHakuListMainDiv>
     */
    public ResponseData<ShiharaiHohoHenkoHakuListMainDiv> focusout_txtTainoKikanNinteiShinseisha(ShiharaiHohoHenkoHakuListMainDiv div) {
        div.getTxtTainoKikanNinteiShinseisha().setValue(Decimal.valueOf(get支払方法変更_支払方法変更期限()));
        div.getTxtTainoNengetsuNinteiShinseisha().setValue(getHandler(div).get支払方法変更期限に対する年月(div.getTxtTainoKikanNinteiShinseisha().getValue()));
        return ResponseData.of(div).respond();
    }

    /**
     * 受給認定日抽出の滞納期間からフォーカスアウト
     *
     * @param div 画面Div
     * @return ResponseData<ShiharaiHohoHenkoHakuListMainDiv>
     */
    public ResponseData<ShiharaiHohoHenkoHakuListMainDiv> focusout_txtTainoKikanNinteiYMD(ShiharaiHohoHenkoHakuListMainDiv div) {
        div.getTxtTainoKikanNinteiYMD().setValue(Decimal.valueOf(get支払方法変更_支払方法変更期限()));
        div.getTxtTainoNengetsuNinteiYMD().setValue(getHandler(div).get支払方法変更期限に対する年月(div.getTxtTainoKikanNinteiYMD().getValue()));
        return ResponseData.of(div).respond();
    }

    /**
     * 受給申請中者の滞納期間からフォーカスアウト
     *
     * @param div 画面Div
     * @return ResponseData<ShiharaiHohoHenkoHakuListMainDiv>
     */
    public ResponseData<ShiharaiHohoHenkoHakuListMainDiv> focusout_txtTainoKikanShokanShinseisha(ShiharaiHohoHenkoHakuListMainDiv div) {
        div.getTxtTainoKikanShokanShinseisha().setValue(Decimal.valueOf(get支払方法変更_支払方法変更期限()));
        div.getTxtTainoNengetsuShokanShinseisha().setValue(getHandler(div).get支払方法変更期限に対する年月(div.getTxtTainoKikanShokanShinseisha().getValue()));
        return ResponseData.of(div).respond();
    }

    /**
     * 受給支給決定日抽出の滞納期間からフォーカスアウト
     *
     * @param div 画面Div
     * @return ResponseData<ShiharaiHohoHenkoHakuListMainDiv>
     */
    public ResponseData<ShiharaiHohoHenkoHakuListMainDiv> focusout_txtTainoKikanShokanKettei(ShiharaiHohoHenkoHakuListMainDiv div) {
        div.getTxtTainoKikanShokanKettei().setValue(Decimal.valueOf(get支払方法変更_支払方法変更期限()));
        div.getTxtTainoNengetsuShokanKettei().setValue(getHandler(div).get支払方法変更期限に対する年月(div.getTxtTainoKikanShokanKettei().getValue()));
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタン押下、チェックとバッチパラメターを設定
     *
     * @param div　画面Div
     * @return　ResponseData<ShiharaiHohoHenkoHakuListMainDiv>
     */
    public ResponseData<ShiharaiHohoHenkoHaakuIchiranBatchParameter> onClick_btnBatchExecute(ShiharaiHohoHenkoHakuListMainDiv div) {
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }

    /**
     * 実行するボタンを押下のチェック処理します。
     *
     * @param div ShiharaiHohoHenkoHakuListMainDiv のクラスファイル
     * @return ResponseData
     */
    public ResponseData<ShiharaiHohoHenkoHakuListMainDiv> onClick_btnCheck(ShiharaiHohoHenkoHakuListMainDiv div) {
        ValidationMessageControlPairs validPairs = getHandler(div).バッチ実行前チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }

        return createResponse(div);
    }

    private ResponseData<ShiharaiHohoHenkoHakuListMainDiv> createResponse(ShiharaiHohoHenkoHakuListMainDiv div) {
        ResponseData<ShiharaiHohoHenkoHakuListMainDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    private int get支払方法変更_支払方法変更期限() {
        RString value = DbBusinessConfig.get(ConfigNameDBD.支払方法変更_支払方法変更期限, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
        return Integer.parseInt(value.toString());
    }

    private DBD2020001ValidationHandler getHandler(ShiharaiHohoHenkoHakuListMainDiv div) {
        return new DBD2020001ValidationHandler(div);
    }
}
