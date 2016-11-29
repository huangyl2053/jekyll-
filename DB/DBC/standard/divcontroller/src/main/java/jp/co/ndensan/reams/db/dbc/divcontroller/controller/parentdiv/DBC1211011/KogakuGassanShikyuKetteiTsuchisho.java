/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1211011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC040050.DBC040050_KogakugassanShikyuKetteitsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1211011.KogakuGassanShikyuKetteiTsuchishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1211011.KogakuGassanShikyuKetteiTsuchishoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1211011.KogakuGassanShikyuKetteiTsuchishoHandlerValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMN63004_高額合算支給決定通知書（一括）のクラスです。
 *
 * @reamsid_L DBC-2300-010 wangxingpeng
 */
public class KogakuGassanShikyuKetteiTsuchisho {

    private static final RString KEY_0 = new RString("key0");
    private static final RString KEY_1 = new RString("key1");
    private static final RString NUM_1 = new RString("1");
    private static final RString 予定日 = new RString("支払予定日");
    private static final RString 出力順を = new RString("出力順を");

    /**
     * onloadのメソッドです。
     *
     * @param div KogakuGassanShikyuKetteiTsuchishoDiv
     * @return ResponseData KogakuGassanShikyuKetteiTsuchishoDiv
     */
    public ResponseData<KogakuGassanShikyuKetteiTsuchishoDiv> onload(KogakuGassanShikyuKetteiTsuchishoDiv div) {
        boolean gotLock = getHandler(div).前排他キーのセット();
        if (!gotLock) {
            throw new PessimisticLockingException();
        }
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_BtnradUketoriYMのメソッドです。
     *
     * @param div KogakuGassanShikyuKetteiTsuchishoDiv
     * @return ResponseData KogakuGassanShikyuKetteiTsuchishoDiv
     */
    public ResponseData<KogakuGassanShikyuKetteiTsuchishoDiv> onClick_BtnradUketoriYM(KogakuGassanShikyuKetteiTsuchishoDiv div) {
        getHandler(div).作成条件受取年月();
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_BtnradKetteiYMDのメソッドです。
     *
     * @param div KogakuGassanShikyuKetteiTsuchishoDiv
     * @return ResponseData KogakuGassanShikyuKetteiTsuchishoDiv
     */
    public ResponseData<KogakuGassanShikyuKetteiTsuchishoDiv> onClick_BtnradKetteiYMD(KogakuGassanShikyuKetteiTsuchishoDiv div) {
        getHandler(div).作成条件決定年月日();
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_BtnradShinseiYMDのメソッドです。
     *
     * @param div KogakuGassanShikyuKetteiTsuchishoDiv
     * @return ResponseData KogakuGassanShikyuKetteiTsuchishoDiv
     */
    public ResponseData<KogakuGassanShikyuKetteiTsuchishoDiv> onClick_BtnradShinseiYMD(KogakuGassanShikyuKetteiTsuchishoDiv div) {
        getHandler(div).作成条件申請年月日();
        return ResponseData.of(div).respond();
    }

    /**
     * onChangeのメソッドです。
     *
     * @param div KogakuGassanShikyuKetteiTsuchishoDiv
     * @return ResponseData KogakuGassanShikyuKetteiTsuchishoDiv
     */
    public ResponseData<KogakuGassanShikyuKetteiTsuchishoDiv> onChange(KogakuGassanShikyuKetteiTsuchishoDiv div) {
        getHandler(div).決定日一括更新区分();
        return ResponseData.of(div).respond();
    }

    /**
     * onBeforeOpenDialogのメソッドです。
     *
     * @param div KogakuGassanShikyuKetteiTsuchishoDiv
     * @return ResponseData KogakuGassanShikyuKetteiTsuchishoDiv
     */
    public ResponseData<KogakuGassanShikyuKetteiTsuchishoDiv> onBeforeOpenDialog(KogakuGassanShikyuKetteiTsuchishoDiv div) {
        KogakuGassanShikyuKetteiTsuchishoHandlerValidationHandler validation = new KogakuGassanShikyuKetteiTsuchishoHandlerValidationHandler(div);
        RDate 申請開始年月日 = div.getTxtShinseiYMD().getFromValue();
        RDate 支払予定日 = div.getTxtShiharaiYoteiYMD().getValue();
        RDate 作成開始年月日 = div.getTxtKetteiYMD().getFromValue();
        if (div.getRadKetteibiIkkatsuKoshinKBN().getSelectedKey().equals(KEY_1)) {
            ValidationMessageControlPairs pairs = validation.決定予定日validate();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        if (div.getRadUketoriYM().getSelectedKey().equals(KEY_0)) {
            ValidationMessageControlPairs pairs = validation.受取年月validate();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        if (div.getRadKetteiYMD().getSelectedKey().equals(KEY_0)) {
            ValidationMessageControlPairs pairs = validation.作成年月validate();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            if (作成開始年月日 == null && !ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbcWarningMessages.高額合算支給決定通知書全件処理確認.getMessage()).respond();
            }
        }
        if (div.getRadShinseiYMD().getSelectedKey().equals(KEY_0)) {
            ValidationMessageControlPairs pairs = validation.申請年月validate();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            if (申請開始年月日 == null && !ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbcWarningMessages.高額合算支給決定通知書全件処理確認.getMessage()).respond();
            }
        }

        if ((getHandler(div).get支払予定日印字有無().equals(NUM_1)) && 支払予定日 == null && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrWarningMessages.未入力.getMessage().replace(予定日.toString())).respond();
        }
        if (div.getCcdChohyoShutsuryokujun().get出力順ID() == null) {
            throw new ApplicationException(UrErrorMessages.未指定.getMessage().replace(出力順を.toString()));
        }
        getHandler(div).前排他を解除する();
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_BtnPrintのメソッドです。
     *
     * @param div KogakuGassanShikyuKetteiTsuchishoDiv
     * @return ResponseData KogakuGassanShikyuKetteiTsuchishoDiv
     */
    public ResponseData<DBC040050_KogakugassanShikyuKetteitsuchishoParameter> onClick_BtnPrint(KogakuGassanShikyuKetteiTsuchishoDiv div) {
        DBC040050_KogakugassanShikyuKetteitsuchishoParameter param = getHandler(div).setバッチ();
        return ResponseData.of(param).respond();
    }

    private KogakuGassanShikyuKetteiTsuchishoHandler getHandler(KogakuGassanShikyuKetteiTsuchishoDiv div) {
        return KogakuGassanShikyuKetteiTsuchishoHandler.of(div);
    }
}
