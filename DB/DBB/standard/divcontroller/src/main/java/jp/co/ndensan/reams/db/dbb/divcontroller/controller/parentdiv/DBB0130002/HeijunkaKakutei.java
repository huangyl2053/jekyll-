/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0130002;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB012002.DBB012002_TokuchoHeinjunkaKakuteiParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0130002.DBB0130002StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0130002.DBB0130002TransitionEventName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0130002.HeijunkaKakuteiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0130002.HeijunkaKakuteiHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 画面設計_DBBGM35004_特徴平準化確定のクラスです。
 *
 * @reamsid_L DBB-0830-010 wangkanglei
 */
public class HeijunkaKakutei {

    private final RString 特徴平準化_平準化 = new RString("特徴平準化（6・8月分）確定");
    private final RString バッチ処理するキー = new RString("branchBatchExecute");
    private final RString バッチ処理しない = new RString("バッチ処理しない");
    private final RString バッチ処理する = new RString("バッチ処理する");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div HeijunkaKakuteiDiv
     * @return ResponseData
     */
    public ResponseData<HeijunkaKakuteiDiv> onLoad(HeijunkaKakuteiDiv div) {
        getHandler(div).check基準日時();
        ResponseData<HeijunkaKakuteiDiv> responseData;
        ShoriDateKanri 処理日付管理 = getHandler(div).initialize();
        ViewStateHolder.put(ViewStateKeys.処理日付管理, 処理日付管理);
        responseData = ResponseData.of(div).setState(DBB0130002StateName.平準化確定リアル);
        responseData.setRootTitle(特徴平準化_平準化);
        return responseData;
    }

    /**
     * 「設定する」ボタンのメソッドます。
     *
     * @param div HeijunkaKakuteiDiv
     * @return ResponseData
     */
    public ResponseData<HeijunkaKakuteiDiv> onClick_btnSagakuSettei(HeijunkaKakuteiDiv div) {
        getHandler(div).set差額();
        return ResponseData.of(div).respond();
    }

    /**
     * 「差額設定による対象外件数を算出する」ボタンのメソッドます。
     *
     * @param div HeijunkaKakuteiDiv
     * @return ResponseData
     */
    public ResponseData<HeijunkaKakuteiDiv> onClick_btnTaishoGaiKensuSanshutsu(HeijunkaKakuteiDiv div) {
        ShoriDateKanri 処理日付管理 = ViewStateHolder.get(ViewStateKeys.処理日付管理, ShoriDateKanri.class);
        if (getHandler(div).set対象件数と対象外件数(処理日付管理.get基準日時())) {
            return ResponseData.of(div).setState(DBB0130002StateName.平準化確定リアル);
        } else {
            return ResponseData.of(div).setState(DBB0130002StateName.平準化確定バッチ);
        }
    }

    /**
     * 「確定処理を実行する（リアル用）」ボタンのメソッドます。
     *
     * @param div HeijunkaKakuteiDiv
     * @return ResponseData
     */
    public ResponseData<HeijunkaKakuteiDiv> onClick_btnKakuteiReal(HeijunkaKakuteiDiv div) {
        ShoriDateKanri 処理日付管理 = ViewStateHolder.get(ViewStateKeys.処理日付管理, ShoriDateKanri.class);
        getHandler(div).更新賦課処理状況更新(処理日付管理);
        FlowParameters wfバッチ処理しない = FlowParameters.of(バッチ処理するキー, バッチ処理しない);
        FlowParameterAccessor.merge(wfバッチ処理しない);
        return ResponseData.of(div).forwardWithEventName(DBB0130002TransitionEventName.完了).respond();
    }

    /**
     * 「確定処理を実行する（バッチ用）」ボタンのメソッドます。
     *
     * @param div HeijunkaKakuteiDiv
     * @return ResponseData
     */
    public ResponseData<DBB012002_TokuchoHeinjunkaKakuteiParameter> onClick_btnKakuteiBatch(HeijunkaKakuteiDiv div) {
        ShoriDateKanri 処理日付管理 = ViewStateHolder.get(ViewStateKeys.処理日付管理, ShoriDateKanri.class);
        DBB012002_TokuchoHeinjunkaKakuteiParameter parameter = getHandler(div).creatParameter(処理日付管理.get基準日時());
        FlowParameters wfバッチ処理する = FlowParameters.of(バッチ処理するキー, バッチ処理する);
        FlowParameterAccessor.merge(wfバッチ処理する);
        return ResponseData.of(parameter).respond();
    }

    private HeijunkaKakuteiHandler getHandler(HeijunkaKakuteiDiv div) {
        return new HeijunkaKakuteiHandler(div);
    }
}
