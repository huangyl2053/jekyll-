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
        //TODO QA284張紅麗　まで12/29 出力条件で選択する項目の確認
        //証表示タイプ = BusinessConfig.get(ConfigKeysHihokenshashoIndicationMethod.被保険者証表示方法_証表示タイプ);
        //if (証表示タイプ == 2) {
        div.getRadShutsuryokuJoken().setSelectedKey(JYUKYUMONO_RADIO_SENTAKU);
        //}
        //TODO QA345張紅麗　まで12/29 処理枝番 画面で選択された入力条件の確認 1.2　抽出期間の取得値
        SearchResult<HihokenshashoIkkatsuHakkoModel> resultList = service.getChushutsuKikan(JYUKYUMONO_RADIO_SENTAKU);
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
        // TODO QA345張紅麗　まで12/29 処理枝番 画面で選択された入力条件の確認
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
        ResponseData<HihokenshaShoBatchPrmDiv> response = new ResponseData<>();
        if ((JYUKYUMONO_RADIO_SENTAKU).equals(div.getRadShutsuryokuJoken().getSelectedKey())) {
            if (div.getTxtKonkaiChushutsuFromYMD().getValue().isBefore(div.getTxtZenkaiShoriKijunYMD().getValue())) {
                ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
                validationMessages.add(getHandlerValidation(div).開始日変更のチェック());
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
        }
        if ((GAITOMONO_RADIO_SENTAKU).equals(div.getRadShutsuryokuJoken().getSelectedKey())) {
            if (div.getTxtKonkaiShoriKijunYMD().getValue().isBefore(div.getTxtKonkaiChushutsuToYMD().getValue())) {
                ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
                validationMessages.add(getHandlerValidation(div).終了日変更のチェック());
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
        }
        if ((JNENNREI_RADIO_SENTAKU).equals(div.getRadShutsuryokuJoken().getSelectedKey())) {
            if (div.getTxtKonkaiChushutsuFromYMD().getValue().isBefore(div.getTxtKonkaiChushutsuToYMD().getValue())) {
                ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
                validationMessages.add(getHandlerValidation(div).開始日と終了日の比較チェック());
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
        }
        response.data = div;
        return response;
    }

    private HihokenshaShoBatchPrmHandler getHandler(HihokenshaShoBatchPrmDiv div) {
        return new HihokenshaShoBatchPrmHandler(div);
    }

    private ValidationHandler getHandlerValidation(HihokenshaShoBatchPrmDiv div) {
        return new ValidationHandler(div);
    }
}
