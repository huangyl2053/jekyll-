/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE4910001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.youkaigoninteishinchokujouhou.YouKaigoNinteiShinchokuJohouBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE491001.DBE491001_NichijiShinchokuParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4910001.DBE4910001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4910001.DBE4910001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4910001.ShinchokuDataOutputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4910001.ShinchokuDataOutputHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4910001.ShinchokuDataOutputValidatisonHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.youkaigoninteishinchokujouhou.YouKaigoNinteiShinchokuJohouFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 要介護認定進捗情報データ出力の処理です。
 *
 * @reamsid_L DBE-1500-010 wanghui
 */
public class ShinchokuDataOutput {

    private final YouKaigoNinteiShinchokuJohouFinder finder;
    private List<YouKaigoNinteiShinchokuJohouBusiness> 調査員情報Lis;
    private static final RString 結果情報 = new RString("1");
    private static final RString 進捗情報 = new RString("0");

    /**
     * コンストラクタです。
     */
    public ShinchokuDataOutput() {
        finder = YouKaigoNinteiShinchokuJohouFinder.createInstance();
    }

    /**
     * 画面初期化処理です。
     *
     * @param div 要介護認定進捗情報データ出力div
     * @return ResponseData<HomonChosaItakuNyuryokuDiv>
     */
    public ResponseData<ShinchokuDataOutputDiv> onLoad(ShinchokuDataOutputDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).setState(DBE4910001StateName.初期表示);
    }

    /**
     * 画面アクティブ時処理です。
     *
     * @param div 要介護認定進捗情報データ出力div
     * @return ResponseData<HomonChosaItakuNyuryokuDiv>
     */
    public ResponseData<ShinchokuDataOutputDiv> onActive(ShinchokuDataOutputDiv div) {
        RString hihokenshaNo = ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class);
        if (hihokenshaNo != null && !hihokenshaNo.isEmpty()) {
            div.getTxtHihokenshaCode().setValue(hihokenshaNo);
            getHandler(div).onChange_txtHihokenshaCode();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 対象者検索画面（DBZ0200001）の遷移を処理です。
     *
     * @param div 要介護認定進捗情報データ出力div
     * @return ResponseData<HomonChosaItakuNyuryokuDiv>
     */
    public ResponseData<ShinchokuDataOutputDiv> onClick_btnHihokensha(ShinchokuDataOutputDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBE4910001TransitionEventName.被保険者検索).respond();
    }

    /**
     * 画面入力項目をクリアする。
     *
     * @param div 要介護認定進捗情報データ出力div
     * @return ResponseData<ShinchokuDataOutputDiv>
     */
    public ResponseData<ShinchokuDataOutputDiv> onClick_btnJokenClear(ShinchokuDataOutputDiv div) {
        getHandler(div).btnJokenClear();
        return ResponseData.of(div).setState(DBE4910001StateName.初期表示);
    }

    /**
     * 「検索」ボタン押下
     *
     * @param div 要介護認定進捗情報データ出力div
     * @return ResponseData<ShinchokuDataOutputDiv>
     */
    public ResponseData<ShinchokuDataOutputDiv> onClick_btnKensaku(ShinchokuDataOutputDiv div) {
        if (結果情報.equals(div.getRadKubun().getSelectedKey())) {
            調査員情報Lis = finder.get結果情報検索(getHandler(div).createParam(div)).records();
        } else if (進捗情報.equals(div.getRadKubun().getSelectedKey())) {
            調査員情報Lis = finder.get進捗情報検索(getHandler(div).createParam(div)).records();
        }
        getHandler(div).setdgShinchokuIchiran(調査員情報Lis);
        ValidationMessageControlPairs validation = getValidatisonHandler(div).データ空のチェック();
        if (validation.iterator().hasNext()) {

            return ResponseData.of(div).addValidationMessages(validation).respond();
        }
        return ResponseData.of(div).setState(DBE4910001StateName.一覧照会);
    }

    /**
     * 「再検索する」ボタン目を押下する。
     *
     * @param div 要介護認定進捗情報データ出力div
     * @return ResponseData<ShinchokuDataOutputDiv>
     */
    public ResponseData<ShinchokuDataOutputDiv> onClick_btnResearchr(ShinchokuDataOutputDiv div) {
        div.getTxtHihokenshaCode().clearValue();
        return onLoad(div);
    }

    /**
     * 「データを出力する」ボタンを押下する。
     *
     * @param div 要介護認定進捗情報データ出力div
     * @return ResponseData<ShinchokuDataOutputDiv>
     */
    public ResponseData<DBE491001_NichijiShinchokuParameter> onClick_btnShinchokuDataOutput(ShinchokuDataOutputDiv div) {
        return ResponseData.of(getHandler(div).setBatchParamter(div)).respond();
    }

    /**
     * 対象者一覧データの選択チェック。
     *
     * @param div IchijiHanteiDiv
     * @return ResponseData
     */
    public ResponseData<ShinchokuDataOutputDiv> btn_check(ShinchokuDataOutputDiv div) {

        ValidationMessageControlPairs validation = getValidatisonHandler(div).対象者一覧データの行選択チェック();
        if (validation.iterator().hasNext()) {

            return ResponseData.of(div).addValidationMessages(validation).respond();
        }
        return ResponseData.of(div).respond();
    }
    
    /**
     * 市町村DDL変更時の動作
     * @param div
     * @return ResponseData
     */
    public ResponseData<ShinchokuDataOutputDiv> onChange_ddlSichoson(ShinchokuDataOutputDiv div) {
        getHandler(div).onChange_ddlSichoson();
        return ResponseData.of(div).setState(DBE4910001StateName.初期表示);
    }
    
    /**
     * 被保険者番号変更時の動作
     * @param div
     * @return ResponseData
     */
    public ResponseData<ShinchokuDataOutputDiv> onChange_txtHihokenshaCode(ShinchokuDataOutputDiv div) {
        div.getTxtShimei().clearValue();
        getHandler(div).onChange_txtHihokenshaCode();
        return ResponseData.of(div).setState(DBE4910001StateName.初期表示);
    }

    private ShinchokuDataOutputHandler getHandler(ShinchokuDataOutputDiv div) {
        return new ShinchokuDataOutputHandler(div);
    }

    private ShinchokuDataOutputValidatisonHandler getValidatisonHandler(ShinchokuDataOutputDiv div) {
        return new ShinchokuDataOutputValidatisonHandler(div);
    }
}
