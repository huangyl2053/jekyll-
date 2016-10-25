/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0340011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC010020.DBC010020_KogakuServicehiJuryoininKeiyakuShoninKakuninshoParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0340011.PanSyuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0340011.PanSyuPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0340011.PanSyuPanelHandlerValidationHandler;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 高額サービス費受領委任契約承認（不承認）確認書作成のクラスです。
 *
 * @reamsid_L DBC-1970-010 wangxingpeng
 */
public class PanSyuPanel {

    private static final ReportId 帳票ID = ReportIdDBC.DBC100031.getReportId();
    private static final RString 発行する = new RString("Execute");

    /**
     * onloadのメソッドです。
     *
     * @param div PanSyuPanelDiv
     * @return ResponseData PanSyuPanelDiv
     */
    public ResponseData<PanSyuPanelDiv> onload(PanSyuPanelDiv div) {
        boolean gotLock = getHandler(div).前排他キーのセット();
        if (!gotLock) {
            throw new PessimisticLockingException();
        }
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, 帳票ID);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(発行する, true);
        div.getPanJyoken().getTxtTuutibi().setValue(RDate.getNowDate());
        return ResponseData.of(div).respond();
    }

    /**
     * onChange_KeyakuSinseibiのメソッドです。
     *
     * @param div PanSyuPanelDiv
     * @return ResponseData PanSyuPanelDiv
     */
    public ResponseData<PanSyuPanelDiv> onChange_KeyakuSinseibi(PanSyuPanelDiv div) {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(発行する, getHandler(div).is表示制御を変更());
        return ResponseData.of(div).respond();
    }

    /**
     * onChange_KeiyakuKeteibiのメソッドです。
     *
     * @param div PanSyuPanelDiv
     * @return ResponseData PanSyuPanelDiv
     */
    public ResponseData<PanSyuPanelDiv> onChange_KeiyakuKeteibi(PanSyuPanelDiv div) {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(発行する, getHandler(div).is表示制御を変更());
        return ResponseData.of(div).respond();
    }

    /**
     * onBeforeOpenDialogのメソッドです。
     *
     * @param div PanSyuPanelDiv
     * @return ResponseData PanSyuPanelDiv
     */
    public ResponseData<PanSyuPanelDiv> onBeforeOpenDialog(PanSyuPanelDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validate();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).前排他を解除する();
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_Executeのメソッドです。
     *
     * @param div PanSyuPanelDiv
     * @return ResponseData PanSyuPanelDiv
     */
    public ResponseData<DBC010020_KogakuServicehiJuryoininKeiyakuShoninKakuninshoParameter> onClick_Execute(PanSyuPanelDiv div) {
        DBC010020_KogakuServicehiJuryoininKeiyakuShoninKakuninshoParameter param = getHandler(div).setバッチ();
        return ResponseData.of(param).respond();
    }

    private PanSyuPanelHandler getHandler(PanSyuPanelDiv div) {
        return PanSyuPanelHandler.of(div);
    }

    private PanSyuPanelHandlerValidationHandler getValidationHandler(PanSyuPanelDiv div) {
        return new PanSyuPanelHandlerValidationHandler(div);
    }
}
