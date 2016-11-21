/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC8010001;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC050010.DBC050010_FurikomimeisaiFurikomiDataParameter;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8010001.DBC8010001MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8010001.DBC8010001MainHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8010001.DBC8010001MainValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunManagerFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 振込明細・振込みデータ作成のDivControllerです。
 *
 * @reamsid_L DBC-2180-010 x_liuwei
 */
public class DBC8010001Main {

    private final RString 今回対象日開始日未入力value = new RString("今回対象日開始日未入力flag");
    private final RString 決定者受取年月開始年月未入力value = new RString("決定者受取年月開始年月未入力value");

    /**
     * 画面初期化です。
     *
     * @param div DBC8010001MainDiv
     * @return ResponseData<DBC8010001MainDiv>
     */
    public ResponseData<DBC8010001MainDiv> onLoad(DBC8010001MainDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getHandler(div).initialize(pairs);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 処理選択ラジオボタンonChange。
     *
     * @param div DBC8010001MainDiv
     * @return ResponseData<DBC8010001MainDiv>
     */
    public ResponseData<DBC8010001MainDiv> onChange_RadShoriSentaku(DBC8010001MainDiv div) {
        getHandler(div).onChange_RadShoriSentaku();
        return ResponseData.of(div).respond();
    }

    /**
     * 再作成するチェックボックスonClick。
     *
     * @param div DBC8010001MainDiv
     * @return ResponseData<DBC8010001MainDiv>
     */
    public ResponseData<DBC8010001MainDiv> onClick_ChkSaisakusei(DBC8010001MainDiv div) {
        getHandler(div).onClick_ChkSaisakusei();
        return ResponseData.of(div).respond();
    }

    /**
     * 支払方法ラジオボタンonChange。
     *
     * @param div DBC8010001MainDiv
     * @return ResponseData<DBC8010001MainDiv>
     */
    public ResponseData<DBC8010001MainDiv> onChange_RadSiharaihohou(DBC8010001MainDiv div) {
        getHandler(div).onChange_RadSiharaihohou();
        return ResponseData.of(div).respond();
    }

    /**
     * 抽出対象ラジオボタンonChange。
     *
     * @param div DBC8010001MainDiv
     * @return ResponseData<DBC8010001MainDiv>
     */
    public ResponseData<DBC8010001MainDiv> onChange_RadChushutsuTaisho(DBC8010001MainDiv div) {
        getHandler(div).onChange_RadChushutsuTaisho();
        return ResponseData.of(div).respond();
    }

    /**
     * 入力チェック。
     *
     * @param div DBC8010001MainDiv
     * @return ResponseData<DBC8010001MainDiv>
     */
    public ResponseData<DBC8010001MainDiv> onClickCheck_btnBatchRegister(DBC8010001MainDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        boolean flag1 = new RString("1").equals(div.getRadShoriSentakuFurikomiDataSakusei().getSelectedKey());
        boolean flag2 = new RString("2").equals(div.getRadShoriSentakuFurikomiDataModify().getSelectedKey());
        boolean flag3 = false;
        List<RString> list = div.getChkSaisakusei().getSelectedKeys();
        if (!list.isEmpty() && list.get(0).equals(new RString("1"))) {
            flag3 = true;
        }
        if (flag1) {
            getValidationHandler(div).validateFor振込指定日休日(pairs);
            getValidationHandler(div).validateFor振込指定日過去日(pairs);
        }
        if (flag2) {
            getValidationHandler(div).validateFor正振込指定日休日(pairs);
            getValidationHandler(div).validateFor正振込指定日過去日(pairs);
            getValidationHandler(div).validateFor修正対象データ存在(pairs);
        }
        if (flag1 && flag3) {
            getValidationHandler(div).validateFor再処理対象データ存在(pairs);
        }
        getValidationHandler(div).validateFor出力順(pairs);

        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        if (!(決定者受取年月開始年月未入力value.equals(ViewStateHolder.get(ViewStateKeys.決定者受取年月開始年月未入力flag, RString.class) == null ? RString.EMPTY : ViewStateHolder.get(ViewStateKeys.決定者受取年月開始年月未入力flag, RString.class)))) {
            if (!ResponseHolder.isReRequest() && !div.getTxtKonkaiTaishoYmdRange().isDisabled() && getValidationHandler(div).validateFor今回対象日開始日未入力()) {
                ViewStateHolder.put(ViewStateKeys.今回対象日開始日未入力flag, 今回対象日開始日未入力value);
                return ResponseData.of(div).addMessage(DbcQuestionMessages.開始年月日未入力_データ全部発行.getMessage()).respond();
            } else if (null != ViewStateHolder.get(ViewStateKeys.今回対象日開始日未入力flag, RString.class) && 今回対象日開始日未入力value.equals(ViewStateHolder.get(ViewStateKeys.今回対象日開始日未入力flag, RString.class)) && ResponseHolder.getButtonType() != MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).respond();
            }
        }
        ResponseData<DBC8010001MainDiv> returnResponseData = onClickCheck_btnBatchRegister_2(div);
        if (returnResponseData != null) {
            return returnResponseData;
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<DBC8010001MainDiv> onClickCheck_btnBatchRegister_2(DBC8010001MainDiv div) {
        RString ym = ViewStateHolder.get(ViewStateKeys.決定者受取年月開始年月未入力flag, RString.class) == null
                ? RString.EMPTY : ViewStateHolder.get(ViewStateKeys.決定者受取年月開始年月未入力flag, RString.class);
        boolean flag5 = (null == ViewStateHolder.get(ViewStateKeys.決定者受取年月開始年月未入力flag, RString.class)
                || !決定者受取年月開始年月未入力value.equals(ym));
        if (flag5 && !div.getTxtKetteishaUketoriYmRange().isDisabled()
                && div.getTxtKetteishaUketoriYmRange().isVisible()
                && getValidationHandler(div).validateFor決定者受取年月開始年月未入力()) {
            ViewStateHolder.put(ViewStateKeys.決定者受取年月開始年月未入力flag, 決定者受取年月開始年月未入力value);
            return ResponseData.of(div).addMessage(DbcQuestionMessages.開始年月日未入力_データ全部発行.getMessage()).respond();
        } else {
            if (!ResponseHolder.isReRequest() && !div.getTxtKetteishaUketoriYmRange().isDisabled()
                    && div.getTxtKetteishaUketoriYmRange().isVisible()
                    && getValidationHandler(div).validateFor決定者受取年月開始年月未入力()) {
                return ResponseData.of(div).addMessage(DbcQuestionMessages.開始年月日未入力_データ全部発行.getMessage()).respond();
            } else if (null != ViewStateHolder.get(ViewStateKeys.決定者受取年月開始年月未入力flag, RString.class)
                    && 決定者受取年月開始年月未入力value.equals(ViewStateHolder.get(ViewStateKeys.決定者受取年月開始年月未入力flag, RString.class))
                    && ResponseHolder.getButtonType() != MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).respond();
            }
        }
        return null;
    }

    /**
     * バッチを呼び出す。
     *
     * @param div DBC8010001MainDiv
     * @return ResponseData<DBC050010_FurikomimeisaiFurikomiDataParameter>
     */
    public ResponseData<DBC050010_FurikomimeisaiFurikomiDataParameter> onClick_btnBatchRegister(DBC8010001MainDiv div) {
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBC介護給付, div.getCcdChohyoShutsuryokujun().get帳票ID(),
                div.getCcdChohyoShutsuryokujun().get出力順ID());
        ChohyoShutsuryokujunManagerFactory.createInstance().save前回出力順(outputOrder);

        DBC050010_FurikomimeisaiFurikomiDataParameter parameter = getHandler(div).setBatchParameter();
        return ResponseData.of(parameter).respond();
    }

    private DBC8010001MainHandler getHandler(DBC8010001MainDiv div) {
        return new DBC8010001MainHandler(div);
    }

    private DBC8010001MainValidationHandler getValidationHandler(DBC8010001MainDiv div) {
        return new DBC8010001MainValidationHandler(div);
    }
}
