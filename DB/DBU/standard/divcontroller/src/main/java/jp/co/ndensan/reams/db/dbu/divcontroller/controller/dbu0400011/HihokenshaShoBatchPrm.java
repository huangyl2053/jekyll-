/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.dbu0400011;

import jp.co.ndensan.reams.db.dbu.business.core.hihokenshashoikkatsuhakko.HihokenshashoIkkatsuHakkoModel;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0400011.HihokenshaShoBatchPrmDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.dbu0400011.HihokenshaShoBatchPrmHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.dbu0400011.ValidationHandler;
import jp.co.ndensan.reams.db.dbu.service.core.hihokenshashoikkatsuhakko.HihokenshaShoBatchPrmFinder;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 被保険者証一括作成の発行指示画面です。
 *
 */
public class HihokenshaShoBatchPrm {

    private final HihokenshaShoBatchPrmFinder service;
    private static final RString JYUKYUMONO_RADIO_SENTAKU = new RString("2");
    private static final RString GAITOMONO_RADIO_SENTAKU = new RString("3");
    private static final RString JNENNREI_RADIO_SENTAKU = new RString("4");

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
        //TODO QA295  未対応
        div.getRadShutsuryokuJoken().setSelectedKey(JYUKYUMONO_RADIO_SENTAKU);
        SearchResult<HihokenshashoIkkatsuHakkoModel> resultList = service.getChushutsuKikan(JYUKYUMONO_RADIO_SENTAKU);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnHakko"), false);
        getHandler(div).onLoad(resultList.records());
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
        if ((JYUKYUMONO_RADIO_SENTAKU).equals(div.getRadShutsuryokuJoken().getSelectedKey())) {
            if (div.getTxtZenkaiShoriKijunYMD().getValue().isBefore(div.getTxtKonkaiChushutsuFromYMD().getValue())) {
                ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
                validationMessages.add(getHandlerValidation(div).開始日変更のチェック());
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
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
        if ((JNENNREI_RADIO_SENTAKU).equals(div.getRadShutsuryokuJoken().getSelectedKey())) {
            if (div.getTxtKonkaiChushutsuToYMD().getValue().isBefore(div.getTxtKonkaiChushutsuFromYMD().getValue())) {
                ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
                validationMessages.add(getHandlerValidation(div).開始日と終了日の比較チェック());
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    private HihokenshaShoBatchPrmHandler getHandler(HihokenshaShoBatchPrmDiv div) {
        return new HihokenshaShoBatchPrmHandler(div);
    }

    private ValidationHandler getHandlerValidation(HihokenshaShoBatchPrmDiv div) {
        return new ValidationHandler(div);
    }
}
