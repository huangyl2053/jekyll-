/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0400011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.core.config.ConfigKeysHihokenshashoIndicationMethod;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.service.core.nenreitoutatuyoteishachecklist.NenreiToutatuYoteishaCheckListManager;
import jp.co.ndensan.reams.db.dbu.business.core.hihokenshashoikkatsuhakko.HihokenshashoIkkatsuHakkoModel;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.hihokenshasho.IkkatsuHakkoBatchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0400011.HihokenshaShoBatchPrmDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0400011.HihokenshaShoBatchPrmHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0400011.ValidationHandler;
import jp.co.ndensan.reams.db.dbu.service.core.hihokenshashoikkatsuhakko.HihokenshaShoBatchPrmFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 被保険者証一括作成の発行指示画面です。
 *
 * @reamsid_L DBU-0420-010 duanzhanli
 *
 */
public class HihokenshaShoBatchPrm {

    private final HihokenshaShoBatchPrmFinder service;
    private static final RString JYUKYUMONO_RADIO_SENTAKU = new RString("2");
    private static final RString GAITOMONO_RADIO_SENTAKU = new RString("3");
    private static final RString JNENNREI_RADIO_SENTAKU = new RString("4");
    private static final RString タイプ_A4横 = new RString("01");
    private static final RString タイプ_B4横1 = new RString("21");
    private static final RString タイプ_B4横2 = new RString("22");
    private static final RString KOMOKUNAME = new RString("出力条件");

    /**
     * コンストラクタです。
     *
     */
    public HihokenshaShoBatchPrm() {
        service = HihokenshaShoBatchPrmFinder.createInstance();
    }

    /**
     * 被保険者証一括発行画面のonLoadイベントを処理します。
     *
     * @param div 介護保険被保険者証一括作成Div
     * @return ResponseData<ShichosonSelectorDiv>
     */
    public ResponseData<HihokenshaShoBatchPrmDiv> onLoad(HihokenshaShoBatchPrmDiv div) {
        ResponseData<HihokenshaShoBatchPrmDiv> response = new ResponseData<>();
        if (!setSyutsuryoku(div)) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(new ValidationMessageControlPair(RRVMessage.ValidateA, div.getRadShutsuryokuJoken()));
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        ViewStateHolder.put(ViewStateKeys.出力条件, div.getRadShutsuryokuJoken().getSelectedKey());
        SearchResult<HihokenshashoIkkatsuHakkoModel> resultList = service.getChushutsuKikan(div.getRadShutsuryokuJoken().getSelectedKey());
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnHakko"), false);
        getHandler(div).onLoad(resultList.records());
        NenreiToutatuYoteishaCheckListManager nenreiToutatuYoteishaManager
                = InstanceProvider.create(NenreiToutatuYoteishaCheckListManager.class);
        RString type = DbBusinessConfig.get(ConfigKeysHihokenshashoIndicationMethod.被保険者証表示方法_証表示タイプ, RDate.getNowDate(), SubGyomuCode.DBA介護資格);
        ReportId chohyoID = null;
        if (タイプ_A4横.equals(type)) {
            chohyoID = ReportIdDBA.DBA100002.getReportId();
        } else if (タイプ_B4横1.equals(type) || タイプ_B4横2.equals(type)) {
            chohyoID = ReportIdDBA.DBA100001.getReportId();
        }
        div.getHihokenshaShoShutsuryokuJun().load(SubGyomuCode.DBA介護資格,
                nenreiToutatuYoteishaManager.get帳票分類ID(SubGyomuCode.DBA介護資格, chohyoID).get帳票分類ID());
        response.data = div;
        return response;
    }

    /**
     * 「再発行する」のselectイベントを処理します。
     *
     * @param div 介護保険被保険者証一括作成Div
     * @return ResponseData<HihokenshaShoBatchPrmDiv>
     */
    public ResponseData<HihokenshaShoBatchPrmDiv> onChange_RadShutsuryokuJoken(HihokenshaShoBatchPrmDiv div) {
        ResponseData<HihokenshaShoBatchPrmDiv> response = new ResponseData<>();
        if (ViewStateHolder.get(ViewStateKeys.出力条件, RString.class).equals(div.getRadShutsuryokuJoken().getSelectedKey())) {
            div.getChkSaiHakko().setDisabled(true);
        } else {
            div.getChkSaiHakko().setDisabled(false);
        }
        response.data = div;
        return response;
    }

    /**
     * 「再発行する」のselectイベントを処理します。
     *
     * @param div 介護保険被保険者証一括作成Div
     * @return ResponseData<HihokenshaShoBatchPrmDiv>
     */
    public ResponseData<HihokenshaShoBatchPrmDiv> onClick_CheckBoxSelect(HihokenshaShoBatchPrmDiv div) {
        ResponseData<HihokenshaShoBatchPrmDiv> response = new ResponseData<>();
        List<RString> 処理枝番 = new ArrayList<>();
        処理枝番.add(JYUKYUMONO_RADIO_SENTAKU);
        処理枝番.add(GAITOMONO_RADIO_SENTAKU);
        処理枝番.add(JNENNREI_RADIO_SENTAKU);
        SearchResult<HihokenshashoIkkatsuHakkoModel> resultList = service.getAgainHakko(処理枝番);
        getHandler(div).saihakkoSelect(resultList.records());
        response.data = div;
        return response;
    }

    /**
     * 「実行する」ボタンをクリックした後、実施したチェックです。
     *
     * @param div 介護保険被保険者証一括作成Div
     * @return ResponseData<HihokenshaShoBatchPrmDiv>
     */
    public ResponseData<IkkatsuHakkoBatchParameter> onClick_btnJikkou(HihokenshaShoBatchPrmDiv div) {
        IkkatsuHakkoBatchParameter param = new IkkatsuHakkoBatchParameter(
                div.getRadShutsuryokuJoken().getSelectedKey(),
                getFlexibleDate(div.getTxtKonkaiChushutsuFromYMD().getValue()),
                div.getTxtKonkaiChushutsuFromTime().getValue(),
                getFlexibleDate(div.getTxtKonkaiChushutsuToYMD().getValue()),
                div.getTxtKonkaiChushutsuToTime().getValue(),
                getFlexibleDate(div.getTxtKonkaiShoriKijunYMD().getValue()),
                div.getTxtKonkaiShoriKijunTime().getValue(),
                getFlexibleDate(div.getTxtKofuYMD().getValue()),
                div.getChkTest().isAllSelected(),
                div.getChkSaiHakko().isAllSelected(),
                getFlexibleDate(div.getTxtHakkoYMD().getValue()),
                div.getTxtHakkoTime().getValue(),
                div.getHihokenshaShoShutsuryokuJun().get出力順ID(),
                DbBusinessConfig.get(ConfigKeysHihokenshashoIndicationMethod.被保険者証表示方法_証表示タイプ, RDate.getNowDate(), SubGyomuCode.DBA介護資格));
        return ResponseData.of(param).respond();
    }

    /**
     * 「実行する」ボタンをクリックした後のチェックを処理します。
     *
     * @param div 介護保険被保険者証一括作成Div
     * @return ResponseData<HihokenshaShoBatchPrmDiv>
     */
    public ResponseData<HihokenshaShoBatchPrmDiv> onClick_btnCheck(HihokenshaShoBatchPrmDiv div) {
        RDate zenkaiShoriKijunYMD = div.getTxtZenkaiShoriKijunYMD().getValue();
        RTime zenkaiShoriKijunTime = div.getTxtZenkaiShoriKijunTime().getValue();
        RDate konkaiShoriKijunYMD = div.getTxtKonkaiShoriKijunYMD().getValue();
        RTime konkaiShoriKijunTime = div.getTxtKonkaiShoriKijunTime().getValue();
        RDate konkaiChushutsuFromYMD = div.getTxtKonkaiChushutsuFromYMD().getValue();
        RTime konkaiChushutsuFromTime = div.getTxtKonkaiChushutsuFromTime().getValue();
        RDate konkaiChushutsuToYMD = div.getTxtKonkaiChushutsuToYMD().getValue();
        RTime konkaiChushutsuToTime = div.getTxtKonkaiChushutsuToTime().getValue();
        if ((JYUKYUMONO_RADIO_SENTAKU).equals(div.getRadShutsuryokuJoken().getSelectedKey())
            && has開始日Changed(konkaiChushutsuFromYMD, konkaiChushutsuFromTime, zenkaiShoriKijunYMD, zenkaiShoriKijunTime)) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(getHandlerValidation(div).開始日変更のチェック());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if ((GAITOMONO_RADIO_SENTAKU).equals(div.getRadShutsuryokuJoken().getSelectedKey())) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            if (has開始日Changed(konkaiChushutsuFromYMD, konkaiChushutsuFromTime, zenkaiShoriKijunYMD, zenkaiShoriKijunTime)) {
                validationMessages.add(getHandlerValidation(div).開始日変更のチェック());
            }
            if (isNoneAbsent(konkaiChushutsuToYMD, konkaiChushutsuToTime, konkaiShoriKijunYMD, konkaiShoriKijunTime)
                && (konkaiChushutsuToYMD.isBefore(konkaiShoriKijunYMD)
                    || (konkaiChushutsuToYMD.equals(konkaiShoriKijunYMD) && konkaiChushutsuToTime.isBefore(konkaiShoriKijunTime)))) {
                validationMessages.add(getHandlerValidation(div).終了日変更のチェック());
            }
            if (validationMessages.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
        }
        if ((JNENNREI_RADIO_SENTAKU).equals(div.getRadShutsuryokuJoken().getSelectedKey())
            && isNoneAbsent(konkaiChushutsuFromYMD, konkaiChushutsuFromTime, konkaiChushutsuToYMD, konkaiChushutsuToTime)
            && (konkaiChushutsuToYMD.isBefore(konkaiChushutsuFromYMD)
                || (konkaiChushutsuToYMD.equals(konkaiChushutsuFromYMD) && konkaiChushutsuToTime.isBefore(konkaiChushutsuFromTime)))) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(getHandlerValidation(div).開始日と終了日の比較チェック());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    private boolean has開始日Changed(RDate konkaiChushutsuFromYMD, RTime konkaiChushutsuFromTime, RDate zenkaiShoriKijunYMD, RTime zenkaiShoriKijunTime) {
        return isNoneAbsent(konkaiChushutsuFromYMD, konkaiChushutsuFromTime, zenkaiShoriKijunYMD, zenkaiShoriKijunTime)
               && (zenkaiShoriKijunYMD.isBefore(konkaiChushutsuFromYMD)
                   || (konkaiChushutsuFromYMD.equals(zenkaiShoriKijunYMD) && zenkaiShoriKijunTime.isBefore(konkaiChushutsuFromTime)));
    }

    private boolean isNoneAbsent(Object... values) {
        for (Object o : values) {
            if (o == null) {
                return false;
            }
        }
        return true;
    }

    private FlexibleDate getFlexibleDate(RDate date) {
        FlexibleDate 戻り値 = FlexibleDate.EMPTY;
        if (date != null) {
            戻り値 = new FlexibleDate(date.toDateString());
        }
        return 戻り値;
    }

    private HihokenshaShoBatchPrmHandler getHandler(HihokenshaShoBatchPrmDiv div) {
        return new HihokenshaShoBatchPrmHandler(div);
    }

    private ValidationHandler getHandlerValidation(HihokenshaShoBatchPrmDiv div) {
        return new ValidationHandler(div);
    }

    private boolean setSyutsuryoku(HihokenshaShoBatchPrmDiv div) {
        RString 出力条件 = service.getKomokuValue(KOMOKUNAME).getkomokuValue();
        if (RString.isNullOrEmpty(出力条件)) {
            return false;
        }
        if (JYUKYUMONO_RADIO_SENTAKU.equals(出力条件)) {
            div.getRadShutsuryokuJoken().setSelectedKey(JYUKYUMONO_RADIO_SENTAKU);
        } else if (GAITOMONO_RADIO_SENTAKU.equals(出力条件)) {
            div.getRadShutsuryokuJoken().setSelectedKey(GAITOMONO_RADIO_SENTAKU);
        } else if (JNENNREI_RADIO_SENTAKU.equals(出力条件)) {
            div.getRadShutsuryokuJoken().setSelectedKey(JNENNREI_RADIO_SENTAKU);
        }
        return true;
    }

    private static enum RRVMessage implements IValidationMessage {

        ValidateA(UrErrorMessages.選択されていない, KOMOKUNAME.toString());
        private final Message message;

        private RRVMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
