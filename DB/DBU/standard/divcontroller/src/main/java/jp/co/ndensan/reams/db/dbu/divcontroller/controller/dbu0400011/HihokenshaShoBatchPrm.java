/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.dbu0400011;

import jp.co.ndensan.reams.db.dba.definition.core.enumeratedtype.config.ConfigKeysHihokenshashoIndicationMethod;
import jp.co.ndensan.reams.db.dba.service.core.nenreitoutatuyoteishachecklist.NenreiToutatuYoteishaCheckListManager;
import jp.co.ndensan.reams.db.dbu.business.core.hihokenshashoikkatsuhakko.HihokenshashoIkkatsuHakkoModel;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0400011.HihokenshaShoBatchPrmDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.dbu0400011.HihokenshaShoBatchPrmHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.dbu0400011.ValidationHandler;
import jp.co.ndensan.reams.db.dbu.service.core.hihokenshashoikkatsuhakko.HihokenshaShoBatchPrmFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
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
    private static final ReportId REPORTID_A4 = new ReportId("DBA100001_HihokenshashoA4");
    private static final ReportId REPORTID_B4 = new ReportId("DBA100002_HihokenshashoB4");

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
        ViewStateHolder.put(ViewStateKeys.介護保険被保険者証一括作成_出力条件, div.getRadShutsuryokuJoken().getSelectedKey());
        SearchResult<HihokenshashoIkkatsuHakkoModel> resultList = service.getChushutsuKikan(div.getRadShutsuryokuJoken().getSelectedKey());
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnHakko"), false);
        getHandler(div).onLoad(resultList.records());
        NenreiToutatuYoteishaCheckListManager nenreiToutatuYoteishaManager
                = InstanceProvider.create(NenreiToutatuYoteishaCheckListManager.class);
        RString type = BusinessConfig.get(ConfigKeysHihokenshashoIndicationMethod.被保険者証表示方法_証表示タイプ, SubGyomuCode.DBA介護資格);
        ReportId chohyoID = null;
        if (タイプ_A4横.equals(type)) {
            chohyoID = REPORTID_A4;
        } else if (タイプ_B4横1.equals(type) || タイプ_B4横2.equals(type)) {
            chohyoID = REPORTID_B4;
        }
        // TODO  Redmine：#73393(帳票出力順の取得)
        nenreiToutatuYoteishaManager.get帳票分類ID(SubGyomuCode.DBU介護統計報告, chohyoID).get帳票分類ID();
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
        if (ViewStateHolder.get(ViewStateKeys.住宅改修内容一覧_被保険者番号, RString.class).equals(div.getRadShutsuryokuJoken().getSelectedKey())) {
            div.getChkSaiHakko().setDisabled(true);
        } else {
            div.getChkSaiHakko().setDisabled(false);
            ViewStateHolder.put(ViewStateKeys.介護保険被保険者証一括作成_出力条件, div.getRadShutsuryokuJoken().getSelectedKey());
        }
        SearchResult<HihokenshashoIkkatsuHakkoModel> resultList = service.getAgainHakko(JYUKYUMONO_RADIO_SENTAKU);
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
    public ResponseData<HihokenshaShoBatchPrmDiv> onClick_btnJikkou(HihokenshaShoBatchPrmDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンをクリックした後のチェックを処理します。
     *
     * @param div 介護保険被保険者証一括作成Div
     * @return ResponseData<HihokenshaShoBatchPrmDiv>
     */
    public ResponseData<HihokenshaShoBatchPrmDiv> onClick_btnCheck(HihokenshaShoBatchPrmDiv div) {
        if ((JYUKYUMONO_RADIO_SENTAKU).equals(div.getRadShutsuryokuJoken().getSelectedKey())
                && div.getTxtZenkaiShoriKijunYMD().getValue().isBefore(div.getTxtKonkaiChushutsuFromYMD().getValue())) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(getHandlerValidation(div).開始日変更のチェック());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if ((GAITOMONO_RADIO_SENTAKU).equals(div.getRadShutsuryokuJoken().getSelectedKey())) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            if (div.getTxtZenkaiShoriKijunYMD().getValue().isBefore(div.getTxtKonkaiChushutsuFromYMD().getValue())) {
                validationMessages.add(getHandlerValidation(div).開始日変更のチェック());
            }
            if (div.getTxtKonkaiChushutsuToYMD().getValue().isBefore(div.getTxtKonkaiShoriKijunYMD().getValue())) {
                validationMessages.add(getHandlerValidation(div).終了日変更のチェック());
            }
            if (validationMessages.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
        }
        if ((JNENNREI_RADIO_SENTAKU).equals(div.getRadShutsuryokuJoken().getSelectedKey())
                && div.getTxtKonkaiChushutsuToYMD().getValue().isBefore(div.getTxtKonkaiChushutsuFromYMD().getValue())) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(getHandlerValidation(div).開始日と終了日の比較チェック());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
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
