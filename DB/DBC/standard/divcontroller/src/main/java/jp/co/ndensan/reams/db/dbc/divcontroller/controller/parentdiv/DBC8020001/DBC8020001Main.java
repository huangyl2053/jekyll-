/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC8020001;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC050021.DBC050021_FurikomimeisaiFurikomiDataKogakuGassanParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC050022.DBC050022_FurikomimeisaiFurikomiDataJigyoKogakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC050023.DBC050023_FurikomimeisaiFurikomiDataJigyoKogakuGassanParameter;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8020001.DBC8020001MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8020001.DBC8020001StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8020001.DBC8020001MainHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8020001.DBC8020001MainValidationHandler;
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
 * 事業合算・事業分振込明細書作成（一括）のDivControllerです。
 *
 * @reamsid_L DBC-4870-010 zhouchuanlin
 */
public class DBC8020001Main {

    private final RString 今回対象日開始日未入力value = new RString("今回対象日開始日未入力flag");
    private final RString 決定者受取年月開始年月未入力value = new RString("決定者受取年月開始年月未入力value");
    private static final RString INDEX_1 = new RString("1");
    private static final RString INDEX_2 = new RString("2");
    private static final RString メニューID_DBCMN63005 = new RString("DBCMN63005");
    private static final RString メニューID_DBCMNL3003 = new RString("DBCMNL3003");
    private static final RString メニューID_DBCMNN2004 = new RString("DBCMNN2004");
    private static final RString TITLE_高額合算 = new RString("高額合算振込明細・振込データ作成");
    private static final RString TITLE_事業高額 = new RString("総合事業振込明細・振込データ作成");
    private static final RString TITLE_事業高額合算 = new RString("事業分振込明細・振込データ作成");

    /**
     * 画面初期化です。
     *
     * @param div DBC8020001MainDiv
     * @return ResponseData<DBC8020001MainDiv>
     */
    public ResponseData<DBC8020001MainDiv> onLoad(DBC8020001MainDiv div) {
        RString メニューID = ResponseHolder.getMenuID();
        if (メニューID_DBCMN63005.equals(メニューID)) {
            return ResponseData.of(div).setState(DBC8020001StateName.高額合算);
        } else if (メニューID_DBCMNL3003.equals(メニューID)) {
            return ResponseData.of(div).setState(DBC8020001StateName.事業高額);
        } else if (メニューID_DBCMNN2004.equals(メニューID)) {
            return ResponseData.of(div).setState(DBC8020001StateName.事業高額合算);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * メニューIDより画面タイトルを設定するのメソッドです。
     *
     * @param div DBC8020001MainDiv
     * @return ResponseData<DBC8020001MainDiv>
     */
    public ResponseData<DBC8020001MainDiv> onStateTransition(DBC8020001MainDiv div) {
        RString メニューID = ResponseHolder.getMenuID();
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getHandler(div).initialize(pairs);
        if (pairs.iterator().hasNext()) {
            if (メニューID_DBCMN63005.equals(メニューID)) {
                return ResponseData.of(div).rootTitle(TITLE_高額合算).addValidationMessages(pairs).respond();
            } else if (メニューID_DBCMNL3003.equals(メニューID)) {
                return ResponseData.of(div).rootTitle(TITLE_事業高額).addValidationMessages(pairs).respond();
            } else if (メニューID_DBCMNN2004.equals(メニューID)) {
                return ResponseData.of(div).rootTitle(TITLE_事業高額合算).addValidationMessages(pairs).respond();
            }
        } else {
            if (メニューID_DBCMN63005.equals(メニューID)) {
                return ResponseData.of(div).rootTitle(TITLE_高額合算).respond();
            } else if (メニューID_DBCMNL3003.equals(メニューID)) {
                return ResponseData.of(div).rootTitle(TITLE_事業高額).respond();
            } else if (メニューID_DBCMNN2004.equals(メニューID)) {
                return ResponseData.of(div).rootTitle(TITLE_事業高額合算).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 処理選択ラジオボタンonChange。
     *
     * @param div DBC8020001MainDiv
     * @return ResponseData<DBC8020001MainDiv>
     */
    public ResponseData<DBC8020001MainDiv> onChange_RadShoriSentaku(DBC8020001MainDiv div) {
        getHandler(div).onChange_RadShoriSentaku();
        return ResponseData.of(div).respond();
    }

    /**
     * 再作成するチェックボックスonClick。
     *
     * @param div DBC8020001MainDiv
     * @return ResponseData<DBC8020001MainDiv>
     */
    public ResponseData<DBC8020001MainDiv> onClick_ChkSaisakusei(DBC8020001MainDiv div) {
        getHandler(div).onClick_ChkSaisakusei();
        return ResponseData.of(div).respond();
    }

    /**
     * 支払方法ラジオボタンonChange。
     *
     * @param div DBC8020001MainDiv
     * @return ResponseData<DBC8020001MainDiv>
     */
    public ResponseData<DBC8020001MainDiv> onChange_RadSiharaihohou(DBC8020001MainDiv div) {
        getHandler(div).onChange_RadSiharaihohou();
        return ResponseData.of(div).respond();
    }

    /**
     * 抽出対象ラジオボタンonChange。
     *
     * @param div DBC8020001MainDiv
     * @return ResponseData<DBC8020001MainDiv>
     */
    public ResponseData<DBC8020001MainDiv> onChange_RadChushutsuTaisho(DBC8020001MainDiv div) {
        getHandler(div).onChange_RadChushutsuTaisho();
        return ResponseData.of(div).respond();
    }

    /**
     * 入力チェック。
     *
     * @param div DBC8020001MainDiv
     * @return ResponseData<DBC8020001MainDiv>
     */
    public ResponseData<DBC8020001MainDiv> onClickCheck_btnBatchRegister(DBC8020001MainDiv div) {
        ValidationMessageControlPairs pairs = validate作成(div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        if (getValidationHandler(div).validateFor今回対象日開始日未入力() && getValidationHandler(div).validateFor決定者受取年月開始年月未入力()) {
            RString 今回対象日開始日未入力flag = ViewStateHolder.get(ViewStateKeys.今回対象日開始日未入力flag, RString.class);
            RString 決定者受取年月開始年月未入力flag = ViewStateHolder.get(ViewStateKeys.決定者受取年月開始年月未入力flag, RString.class);
            if (!RString.isNullOrEmpty(今回対象日開始日未入力flag)
                    && !RString.isNullOrEmpty(決定者受取年月開始年月未入力flag)) {
                return ResponseData.of(div).respond();
            }
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbcQuestionMessages.開始年月日未入力_データ全部発行.getMessage()).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                ViewStateHolder.put(ViewStateKeys.今回対象日開始日未入力flag, 今回対象日開始日未入力value);
                ViewStateHolder.put(ViewStateKeys.決定者受取年月開始年月未入力flag, 今回対象日開始日未入力value);
            }

        } else if (getValidationHandler(div).validateFor今回対象日開始日未入力()) {
            RString flag = ViewStateHolder.get(ViewStateKeys.今回対象日開始日未入力flag, RString.class);
            if (!RString.isNullOrEmpty(flag)) {
                return ResponseData.of(div).respond();
            }
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbcQuestionMessages.開始年月日未入力_データ全部発行.getMessage()).respond();
            }

            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                ViewStateHolder.put(ViewStateKeys.今回対象日開始日未入力flag, 今回対象日開始日未入力value);
            }
            return ResponseData.of(div).respond();
        } else if (getValidationHandler(div).validateFor決定者受取年月開始年月未入力()) {
            ResponseData<DBC8020001MainDiv> returnResponseData = checkInput(div);
            if (returnResponseData != null) {
                return returnResponseData;
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * バッチを呼び出す。
     *
     * @param div DBC8020001MainDiv
     * @return ResponseData<DBC050010_FurikomimeisaiFurikomiDataParameter>
     */
    public ResponseData<DBC050021_FurikomimeisaiFurikomiDataKogakuGassanParameter>
            onClick_btnBatchRegisterKogakuGassan(DBC8020001MainDiv div) {
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBC介護給付, div.getCcdChohyoShutsuryokujun().get帳票ID(),
                div.getCcdChohyoShutsuryokujun().get出力順ID());
        ChohyoShutsuryokujunManagerFactory.createInstance().save前回出力順(outputOrder);

        DBC050021_FurikomimeisaiFurikomiDataKogakuGassanParameter parameter = getHandler(div).set高額合算BatchParameter();
        return ResponseData.of(parameter).respond();
    }

    /**
     * バッチを呼び出す。
     *
     * @param div DBC8020001MainDiv
     * @return ResponseData<DBC050010_FurikomimeisaiFurikomiDataParameter>
     */
    public ResponseData<DBC050022_FurikomimeisaiFurikomiDataJigyoKogakuParameter>
            onClick_btnBatchRegisterJigyoKogaku(DBC8020001MainDiv div) {
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBC介護給付, div.getCcdChohyoShutsuryokujun().get帳票ID(),
                div.getCcdChohyoShutsuryokujun().get出力順ID());
        ChohyoShutsuryokujunManagerFactory.createInstance().save前回出力順(outputOrder);

        DBC050022_FurikomimeisaiFurikomiDataJigyoKogakuParameter parameter = getHandler(div).set事業高額BatchParameter();
        return ResponseData.of(parameter).respond();
    }

    /**
     * バッチを呼び出す。
     *
     * @param div DBC8020001MainDiv
     * @return ResponseData<DBC050010_FurikomimeisaiFurikomiDataParameter>
     */
    public ResponseData<DBC050023_FurikomimeisaiFurikomiDataJigyoKogakuGassanParameter>
            onClick_btnBatchRegisterJigyoKogakuGassan(DBC8020001MainDiv div) {
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBC介護給付, div.getCcdChohyoShutsuryokujun().get帳票ID(),
                div.getCcdChohyoShutsuryokujun().get出力順ID());
        ChohyoShutsuryokujunManagerFactory.createInstance().save前回出力順(outputOrder);

        DBC050023_FurikomimeisaiFurikomiDataJigyoKogakuGassanParameter parameter = getHandler(div).set事業高額合算BatchParameter();
        return ResponseData.of(parameter).respond();
    }

    private DBC8020001MainHandler getHandler(DBC8020001MainDiv div) {
        return new DBC8020001MainHandler(div);
    }

    private DBC8020001MainValidationHandler getValidationHandler(DBC8020001MainDiv div) {
        return new DBC8020001MainValidationHandler(div);
    }

    private ResponseData<DBC8020001MainDiv> checkInput(DBC8020001MainDiv div) {
        if (!div.getTxtKetteishaUketoriYmRange().isDisabled() && div.getTxtKetteishaUketoriYmRange().isVisible()) {
            RString flag = ViewStateHolder.get(ViewStateKeys.決定者受取年月開始年月未入力flag, RString.class);
            if (!RString.isNullOrEmpty(flag)) {
                return ResponseData.of(div).respond();
            }
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbcQuestionMessages.開始年月日未入力_データ全部発行.getMessage()).respond();
            }

            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                ViewStateHolder.put(ViewStateKeys.決定者受取年月開始年月未入力flag, 決定者受取年月開始年月未入力value);
            }
        }
        return null;
    }

    private ValidationMessageControlPairs validate作成(DBC8020001MainDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        boolean flag1 = INDEX_1.equals(div.getRadShoriSentakuFurikomiDataSakusei().getSelectedKey());
        boolean flag2 = INDEX_2.equals(div.getRadShoriSentakuFurikomiDataModify().getSelectedKey());
        boolean flag3 = false;
        List<RString> list = div.getChkSaisakusei().getSelectedKeys();
        if (!list.isEmpty() && list.get(0).equals(INDEX_1)) {
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
        return pairs;
    }

}
