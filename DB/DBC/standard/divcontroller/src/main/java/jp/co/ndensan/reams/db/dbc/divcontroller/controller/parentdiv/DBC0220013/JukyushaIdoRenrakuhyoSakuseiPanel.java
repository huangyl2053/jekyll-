/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0220013;

import jp.co.ndensan.reams.db.dbc.business.core.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoTorokuEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220013.JukyushaIdoRenrakuhyoSakuseiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0250011.DBC0250011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0220013.JukyushaIdoRenrakuhyoSakuseiPanelHandler;
import jp.co.ndensan.reams.db.dbc.service.report.jukyushaidorenrakuhyo.JukyushaIdoRenrakuhyoPrintSevice;
import jp.co.ndensan.reams.db.dbc.service.report.jukyushateiseirenrakuhyo.JukyushaTeiseiRenrakuhyoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMN83001_受給者異動連絡票作成です
 *
 * @reamsid_L DBC-2102-010 lihang
 */
public class JukyushaIdoRenrakuhyoSakuseiPanel {

    private static final RString CODE_ミ = new RString("0003");
    private static final RString 被保番号 = new RString("被保険者番号");
    private static final RString 処理モード = new RString("再発行モード");
    private static final RString 被保険者番号_なし = new RString("被保険者番号なし");
    private static final RString DBCHIHOKENSHANO = new RString("DBCHihokenshaNo");
    private static final RString ONE = new RString("1");
    private static final RString ZERO = new RString("0");

    private PersonalData toPersonalData(ShikibetsuCode 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo3 = new ExpandedInformation(new Code(CODE_ミ), 被保番号, 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo3);
    }

    /**
     * onLoadです
     *
     * @param div JukyushaIdoRenrakuhyoSakuseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoSakuseiPanelDiv> onLoad(JukyushaIdoRenrakuhyoSakuseiPanelDiv div) {
//        KyodoJukyushaTaishoshaEntity entity = ViewStateHolder.get(ViewStateKeys.一覧検索キー, KyodoJukyushaTaishoshaEntity.class);
//        int 履歴番号 = entity.get履歴番号();
//        boolean 論理削除フラグ = entity.is論理削除フラグ();
//         FlexibleDate 異動日 = entity.get異動日();
//        HihokenshaNo 被保険者番号 = entity.get被保番号();
//         ShikibetsuCode 識別コード =
        div.getTxtHakkoDate().setValue(RDate.getNowDate());
        FlexibleDate 作成年月日 = new FlexibleDate(div.getJukyushaIdoRenrakuhyoHenkoPrint().getTxtHakkoDate().getValue().toDateString());
        ViewStateHolder.put(ViewStateKeys.作成年月日, 作成年月日);
        RString 氏名性別生年月日を印字する = ZERO;
        if (div.getJukyushaIdoRenrakuhyoHenkoPrint().getChkJukyushaIdoRenrakuhyo().isAllSelected()) {
            氏名性別生年月日を印字する = ONE;
        }
        ViewStateHolder.put(ViewStateKeys.氏名性別生年月日を印字する, 氏名性別生年月日を印字する);
        ShikibetsuCode 識別コード = new ShikibetsuCode("1");
        HihokenshaNo 被保険者番号 = new HihokenshaNo("0000150053");
        int 履歴番号 = 1;
        boolean 論理削除フラグ = false;
        FlexibleDate 異動日 = new FlexibleDate("20080808");
        if ((被保険者番号.isEmpty()) && !ResponseHolder.isReRequest()) {
            throw new ApplicationException(DbzErrorMessages.理由付き登録不可.getMessage().replace(
                    被保険者番号_なし.toString()));
        }
        ViewStateHolder.put(ViewStateKeys.履歴番号, 履歴番号);
        div.getCcdJukyushaIdoRenrakuhyo().initialize(処理モード, ShikibetsuCode.EMPTY, 被保険者番号, 履歴番号, 論理削除フラグ, 異動日);
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード, 被保険者番号.getColumnValue()));
        return ResponseData.of(div).respond();

    }

    /**
     * 「連絡票を発行する」ボタンのメソッドです。
     *
     * @param div JukyushaIdoRenrakuhyoSakuseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoSakuseiPanelDiv> onClick_beforPublish(
            JukyushaIdoRenrakuhyoSakuseiPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(
                    UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate(),
                    ButtonSelectPattern.OKCancel);
            return ResponseData.of(div).addMessage(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「連絡票を発行する」ボタンのメソッドです。
     *
     * @param div JukyushaIdoRenrakuhyoSakuseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_reportPublish(
            JukyushaIdoRenrakuhyoSakuseiPanelDiv div) {
        int 履歴番号 = ViewStateHolder.get(ViewStateKeys.履歴番号, Integer.class);
        FlexibleDate 作成年月日 = ViewStateHolder.get(ViewStateKeys.作成年月日, FlexibleDate.class);
        RString 氏名性別生年月日を印字する = ViewStateHolder.get(ViewStateKeys.氏名性別生年月日を印字する, RString.class);
        if (履歴番号 == 1) {
            JukyushaIdoRenrakuhyoTorokuEntity 受給者異動連絡票Entity = getHandler(div).
                    get受給者異動連絡票Entity(作成年月日, 氏名性別生年月日を印字する);
            JukyushaIdoRenrakuhyoPrintSevice 異動連絡票service = new JukyushaIdoRenrakuhyoPrintSevice();
            return ResponseData.of(異動連絡票service.printSingle(受給者異動連絡票Entity)).respond();
        } else {
            JukyushaIdoRenrakuhyoTorokuEntity 受給者訂正連絡票Entity = getHandler(div).get受給者訂正連絡票Entity(
                    作成年月日, 氏名性別生年月日を印字する);
            JukyushaTeiseiRenrakuhyoPrintService 訂正連絡票service = new JukyushaTeiseiRenrakuhyoPrintService();
            return ResponseData.of(訂正連絡票service.printSingle(受給者訂正連絡票Entity)).respond();
        }
    }

    /**
     * 「再検索する」ボタンのメソッドです。
     *
     * @param div KyodoIdoRenrakuhyoTorokuMainDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoSakuseiPanelDiv> onClick_btnResearch(
            JukyushaIdoRenrakuhyoSakuseiPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return getCheckMessage(div, DBC0250011TransitionEventName.再検索);
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 前排他キーの解除のンメソッドです。
     *
     * @param 被保険者番号 RString
     */
    public void 前排他キーの解除(RString 被保険者番号) {
        LockingKey 排他キー = new LockingKey(DBCHIHOKENSHANO.concat(被保険者番号));
        RealInitialLocker.release(排他キー);
    }

    private ResponseData<JukyushaIdoRenrakuhyoSakuseiPanelDiv> getCheckMessage(
            JukyushaIdoRenrakuhyoSakuseiPanelDiv div,
            DBC0250011TransitionEventName eventName) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                前排他キーの解除(被保険者番号.getColumnValue());
                return ResponseData.of(div).forwardWithEventName(eventName).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        } else {
            return ResponseData.of(div).forwardWithEventName(eventName).respond();
        }
    }

    /**
     * 「検索結果一覧へ」ボタンのメソッドです。
     *
     * @param div KyodoIdoRenrakuhyoTorokuMainDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoSakuseiPanelDiv> onClick_btnSearchResult(
            JukyushaIdoRenrakuhyoSakuseiPanelDiv div) {
        return getCheckMessage(div, DBC0250011TransitionEventName.検索結果一覧);

    }

    /**
     * 「完了する」ボタンのメソッドです。
     *
     * @param div KyodoIdoRenrakuhyoTorokuMainDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoSakuseiPanelDiv> onClick_btnComplete(JukyushaIdoRenrakuhyoSakuseiPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0250011TransitionEventName.完了).respond();
    }

    private JukyushaIdoRenrakuhyoSakuseiPanelHandler getHandler(JukyushaIdoRenrakuhyoSakuseiPanelDiv div) {
        return new JukyushaIdoRenrakuhyoSakuseiPanelHandler(div);
    }

}
