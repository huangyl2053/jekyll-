/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2000014;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.futanwariaishohakko.FutanwariaishoHakkoBatchParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000014.FutanWariaiShoHakkoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000014.FutanWariaiShoHakkoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000014.FutanWariaiShoHakkoValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.futanwariaishoikkatsu.FutanwariaishoHakkoIkkatsu;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMNK3001_負担割合証発行（一括）のクラスです。
 *
 * @reamsid_L DBC-4990-010 pengxingyi
 */
public class FutanWariaiShoHakkoPanel {

    private static final RString ZERO = new RString("0");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<FutanWariaiShoHakkoPanelDiv> onLoad(FutanWariaiShoHakkoPanelDiv div) {
        FutanWariaiShoHakkoHandler handle = getHandle(div);
        handle.initControl();
        return ResponseData.of(div).respond();
    }

    private FutanWariaiShoHakkoHandler getHandle(FutanWariaiShoHakkoPanelDiv div) {
        return new FutanWariaiShoHakkoHandler(div);
    }

    /**
     * 年度変更のメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<FutanWariaiShoHakkoPanelDiv> onChangeNendo(FutanWariaiShoHakkoPanelDiv div) {
        FutanWariaiShoHakkoHandler handle = getHandle(div);
        handle.onChangeNendo();
        return ResponseData.of(div).respond();
    }

    /**
     * 年度変更のメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<FutanWariaiShoHakkoPanelDiv> onChangeKubun(FutanWariaiShoHakkoPanelDiv div) {
        FutanWariaiShoHakkoHandler handle = getHandle(div);
        handle.onChangeKubun();
        return ResponseData.of(div).respond();
    }

    /**
     * 処理が実行される前に、自動実行されるイベントです。
     *
     * @param div FutanWariaiShoHakkoPanelDiv
     * @return ResponseData<FutanWariaiShoHakkoPanelDiv>
     */
    public ResponseData<FutanWariaiShoHakkoPanelDiv> onBeforeonClick_btnBatchRegister(FutanWariaiShoHakkoPanelDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validateBatchStart();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 実行ボタンクリック時のイベントです。
     *
     * @param div FCZ2020010ReceiptTorikomiDiv
     * @return ResponseData {@link FCZ111010_ReceptTorikomiBatchParameter}
     */
    public ResponseData<FutanwariaishoHakkoBatchParameter> onClick_btnBatchRegister(FutanWariaiShoHakkoPanelDiv div) {

        FutanwariaishoHakkoBatchParameter parameter = setBatchParameter(div);
        return ResponseData.of(parameter).respond();
    }

    private FutanwariaishoHakkoBatchParameter setBatchParameter(FutanWariaiShoHakkoPanelDiv div) {
        FutanwariaishoHakkoIkkatsu futanwariaishoHakkoIkkatsu = new FutanwariaishoHakkoIkkatsu();
        RDateTime 抽出期間開始日時 = RDateTime.of(div.getPanelKikan().getTxtKonkaiKaishiDate().getValue().toDateString(),
                div.getPanelKikan().getTxtKonkaiKaishiTime().getValue().toFormattedTimeString(DisplayTimeFormat.HH_mm));
        RDateTime 抽出期間終了日時 = RDateTime.of(div.getPanelKikan().getTxtKonkaiShuryoDate().getValue().toDateString(),
                div.getPanelKikan().getTxtKonkaiShuryoTime().getValue().toFormattedTimeString(DisplayTimeFormat.HH_mm));
        RString 出力順 = div.getCcdShutsuryokuJun().get出力順ID() == null ? RString.EMPTY
                : new RString(div.getCcdShutsuryokuJun().get出力順ID());
        return futanwariaishoHakkoIkkatsu.getBatchiParameter(
                new FlexibleYear(div.getPanelJoken().getDdlNendo().getSelectedKey()),
                div.getPanelJoken().getTxtKofubi().getValue(),
                div.getPanelJoken().getRadHakkoKubun().getSelectedKey(),
                div.getPanelJoken().getRadKubun().getSelectedKey(),
                抽出期間開始日時,
                抽出期間終了日時,
                出力順
        );
    }

    private FutanWariaiShoHakkoValidationHandler getValidationHandler(FutanWariaiShoHakkoPanelDiv div) {
        return FutanWariaiShoHakkoValidationHandler.of(div);
    }

}
