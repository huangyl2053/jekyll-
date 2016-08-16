/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2000021;

import jp.co.ndensan.reams.db.dbc.business.core.riyoshafutanwariaihanteimanager.RiyoshaFutanWariaiHanteiManagerResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000021.DBC2000021TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000021.DBC2000021PanelAllDiv;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000021.DBC2000021TransitionEventName.判定実行;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000021.PanelAllHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000021.PanelAllValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMNK2001_利用者負担割合即時更正_新規。
 *
 * @reamsid_L DBC-5010-010 lihang
 */
public class DBC2000021PanelAll {

    /**
     * 画面初期化のメソッドます。
     *
     * @param div DBC2000021PanelAllDiv
     * @return ResponseData DBC2000021PanelAllDiv
     */
    public ResponseData<DBC2000021PanelAllDiv> onLoad(DBC2000021PanelAllDiv div) {
        TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = 引継ぎデータ.get識別コード();
        HihokenshaNo 被保険者番号 = 引継ぎデータ.get被保険者番号();
        div.getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getCcdKaigoShikakuKihon().initialize(識別コード);
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        getHandler(div).initialize(被保険者番号, 識別コード);
        return ResponseData.of(div).respond();
    }

    private PanelAllHandler getHandler(DBC2000021PanelAllDiv div) {
        return new PanelAllHandler(div);
    }

    private PanelAllValidationHandler getValidationHandler(DBC2000021PanelAllDiv div) {
        return new PanelAllValidationHandler(div);
    }

    /**
     * 基準日を設定します
     *
     * @param div DBC2000021PanelAllDiv
     * @return ResponseData DBC2000021PanelAllDiv
     */
    public ResponseData<DBC2000021PanelAllDiv> onChange_ddlNendo(DBC2000021PanelAllDiv div) {
        getHandler(div).set基準日();
        return ResponseData.of(div).respond();
    }

    /**
     * 新規判定を実行します
     *
     * @param div DBC2000021PanelAllDiv
     * @return ResponseData DBC2000021PanelAllDiv
     */
    public ResponseData<DBC2000021PanelAllDiv> onClick_btnJikko(DBC2000021PanelAllDiv div) {

        ValidationMessageControlPairs validPairs = getValidationHandler(div).validate();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getCcdKaigoShikakuKihon().get被保険者番号());
        FlexibleYear 年度 = new FlexibleYear(div.getDdlNendo().getSelectedValue());
        FlexibleDate 基準日 = new FlexibleDate(div.getTxtKijunbi().getValue().toDateString());
        RiyoshaFutanWariaiHanteiManagerResult 判定結果 = getHandler(div).hannTei(被保険者番号, 年度, 基準日);
        ViewStateHolder.put(ViewStateKeys.判定結果, 判定結果);
        return ResponseData.of(div).forwardWithEventName(判定実行).respond();
//        RString 判定区分 = RString.EMPTY;
//        RString three = new RString("3");
//        RString four = new RString("4");
//        RString five = new RString("5");
//        //TODO
//        if (判定区分 == four) {
//
//            throw new ApplicationException(DbcErrorMessages.基準日被保険者データなし.toString());
//        } else if (判定区分 == five) {
//            throw new ApplicationException(DbcErrorMessages.基準日受給者_事業対象者データなし.toString());
//        } else if (判定区分 == three) {
//            throw new ApplicationException(DbcErrorMessages.基準日負担割合変更なし.toString());
//
//        }
//
//        getValidationHandler(div).validate();
//
//        return ResponseData.of(div).respond();
    }

    /**
     * 再検索をします
     *
     * @param div DBC2000021PanelAllDiv
     * @return ResponseData DBC2000021PanelAllDiv
     */
    public ResponseData<DBC2000021PanelAllDiv> onClick_btnReSearch(DBC2000021PanelAllDiv div) {
//        if (!ResponseHolder.isReRequest()) {
//            return ResponseData.of(div).addMessage(UrQuestionMessages.画面遷移の確認.getMessage()).respond();
//        }
//        if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode()).equals(
//                ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
        return ResponseData.of(div).forwardWithEventName(DBC2000021TransitionEventName.再検索).respond();
//        }
//        return ResponseData.of(div).respond();
    }

    /**
     * 検索結果一覧に遷移します
     *
     *
     * @param div DBC2000021PanelAllDiv
     * @return ResponseData DBC2000021PanelAllDiv
     */
    public ResponseData<DBC2000021PanelAllDiv> onClick_btnSearchResult(DBC2000021PanelAllDiv div) {
//        if (!ResponseHolder.isReRequest()) {
//            return ResponseData.of(div).addMessage(UrQuestionMessages.検索画面遷移の確認.getMessage()).respond();
//        }
//        if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode()).equals(
//                ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
        return ResponseData.of(div).forwardWithEventName(DBC2000021TransitionEventName.検索結果一覧).respond();
//        }
//        return ResponseData.of(div).respond();
    }

}
