/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBAM010011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBAM010011.DBAM010011StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBAM010011.FubanHohoMainDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBAM010011.FubanHohoMainHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBAM010011.FubanHohoMainValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBA;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 被保険者番号付番方法のクラスです。
 *
 * @reamsid_L DBA-1200-010 suguangjun
 */
public class FubanHohoMain {

    private static final RString カスタマイズ付番 = new RString("4");
    private static final RString 自動連番付番 = new RString("2");
    private static final RString 住民コード = new RString("1");
    private static final RString ROOTTITLE = new RString("システム管理登録_被保険者番号付番方法は正常に行われました。");
    private static final RString COMMON_BUTTON_UPDATE = new RString("btnUpdate");
    
    /**
     * 画面初期化処理です。
     *
     * @param div FubanHohoMainDiv
     * @return ResponseData<FubanHohoMainDiv>
     */
    public ResponseData<FubanHohoMainDiv> onLoad(FubanHohoMainDiv div) {

        RString 変更可否区分 = DbBusinessConfig.get(ConfigNameDBA.被保険者番号付番方法_付番方法_変更可否区分, RDate.getNowDate(),
                SubGyomuCode.DBA介護資格);
        if (new RString("0").equals(変更可否区分)) {
            getHandler(div).setFubanHoho();
            div.setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_UPDATE, true);
            ValidationMessageControlPairs validPairs = getValidationHandle(div).validateForHenkouKakiKubun();
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        } else if (new RString("1").equals(変更可否区分)) {
            getHandler(div).setFubanHoho();
            onChangeDdlFubanHoho(div);
            getHandler(div).setDisableToFubanHoho();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者番号付番方法をonChangeします。
     *
     * @param div FubanHohoMainDiv
     * @return ResponseData<FubanHohoMainDiv>
     */
    public ResponseData<FubanHohoMainDiv> onChangeDdlFubanHoho(FubanHohoMainDiv div) {
        RString 被保険者番号付番方法 = div.getFubanHoho().getDdlHihokenshaBangoFubanHoho().getSelectedKey();
        if (カスタマイズ付番.equals(被保険者番号付番方法)) {
            div.getFubanHoho().getFubanMotoJoho().getDdlFubanmotoJoho().setDisabled(false);
        } else {
            div.getFubanHoho().getFubanMotoJoho().getDdlFubanmotoJoho().setDisabled(true);
        }
        getHandler(div).setJidoFubanKaishiNo();
        getHandler(div).setDisableToFubanHoho();
        return ResponseData.of(div).respond();
    }

    /**
     * 付番元情報をonChangeします。
     *
     * @param div FubanHohoMainDiv
     * @return ResponseData<FubanHohoMainDiv>
     */
    public ResponseData<FubanHohoMainDiv> onChangeDdlFubanmotoJoho(FubanHohoMainDiv div) {
        getHandler(div).setJidoFubanKaishiNo();
        getHandler(div).setDisableToFubanHoho();
        return ResponseData.of(div).respond();
    }

    /**
     * 保存するボタン押下、データがDBに更新します。
     *
     * @param div FubanHohoMainDiv
     * @return ResponseData<FubanHohoMainDiv>
     */
    public ResponseData<FubanHohoMainDiv> onClick_btnUpdate(FubanHohoMainDiv div) {
        RString 被保険者番号付番方法 = div.getFubanHoho().getDdlHihokenshaBangoFubanHoho().getSelectedKey();
        RString 付番元情報 = div.getFubanHoho().getFubanMotoJoho().getDdlFubanmotoJoho().getSelectedKey();
        if (カスタマイズ付番.equals(被保険者番号付番方法) && 住民コード.equals(付番元情報)
                || カスタマイズ付番.equals(被保険者番号付番方法) && 自動連番付番.equals(付番元情報)) {
            ValidationMessageControlPairs validPairs = getValidationHandle(div).validateForMaeFukaCode();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        getHandler(div).editFubanHoho();
        div.getKanryoMessage().getCcdKaigoKanryoMessage().setMessage(ROOTTITLE, RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
        return ResponseData.of(div).setState(DBAM010011StateName.完了);

    }

    private FubanHohoMainHandler getHandler(FubanHohoMainDiv div) {
        return new FubanHohoMainHandler(div);
    }

    private FubanHohoMainValidationHandler getValidationHandle(FubanHohoMainDiv div) {
        return new FubanHohoMainValidationHandler(div);
    }
}
