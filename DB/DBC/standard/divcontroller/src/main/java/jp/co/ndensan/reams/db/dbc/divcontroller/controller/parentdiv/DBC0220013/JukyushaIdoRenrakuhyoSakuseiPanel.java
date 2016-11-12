/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0220013;

import jp.co.ndensan.reams.db.dbc.business.core.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoTorokuEntity;
import jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushataishosha.KyodoJukyushaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220013.DBC0220013TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220013.JukyushaIdoRenrakuhyoSakuseiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0220013.JukyushaIdoRenrakuhyoSakuseiPanelHandler;
import jp.co.ndensan.reams.db.dbc.service.report.jukyushaidorenrakuhyo.JukyushaIdoRenrakuhyoPrintSevice;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
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

    private static final RString 処理モード = new RString("再発行モード");
    private static final RString 被保険者番号_なし = new RString("被保険者番号なし");
    private static final RString DBCHIHOKENSHANO = new RString("DBCHihokenshaNo");
    private static final RString ONE = new RString("1");
    private static final RString ZERO = new RString("0");
    private static final RString 選択モード = new RString("選択");

    /**
     * onLoadです
     *
     * @param div JukyushaIdoRenrakuhyoSakuseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoSakuseiPanelDiv> onLoad(JukyushaIdoRenrakuhyoSakuseiPanelDiv div) {
        KyodoJukyushaTaishoshaEntity entity = ViewStateHolder.get(
                ViewStateKeys.一覧検索キー, KyodoJukyushaTaishoshaEntity.class);
        int 履歴番号 = entity.get履歴番号();
        boolean 論理削除フラグ = entity.is論理削除フラグ();
        FlexibleDate 異動日 = entity.get異動日();
        HihokenshaNo 被保険者番号 = entity.get被保番号();
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            throw new ApplicationException(DbzErrorMessages.理由付き登録不可.getMessage().replace(
                    被保険者番号_なし.toString()));
        }
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        div.getTxtHakkoDate().setValue(RDate.getNowDate());
        ViewStateHolder.put(ViewStateKeys.履歴番号, 履歴番号);
        div.getCcdJukyushaIdoRenrakuhyo().initialize(
                処理モード, ShikibetsuCode.EMPTY, 被保険者番号, 履歴番号, 論理削除フラグ, 異動日);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        AccessLogger.log(AccessLogType.照会,
                getHandler(div).toPersonalData(識別コード,
                        被保険者番号.getColumnValue()));
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
                    DbcQuestionMessages.連絡票を発行.getMessage().getCode(),
                    DbcQuestionMessages.連絡票を発行.getMessage().evaluate(),
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
        FlexibleDate 作成年月日 = new FlexibleDate(div.getJukyushaIdoRenrakuhyoHenkoPrint().
                getTxtHakkoDate().getValue().toDateString());
        RString 氏名性別生年月日を印字する = ZERO;
        if (div.getJukyushaIdoRenrakuhyoHenkoPrint().getChkJukyushaIdoRenrakuhyo().isAllSelected()) {
            氏名性別生年月日を印字する = ONE;
        }
        JukyushaIdoRenrakuhyoTorokuEntity 受給者異動連絡票Entity = getHandler(div).
                get受給者異動連絡票Entity(作成年月日, 氏名性別生年月日を印字する);
        JukyushaIdoRenrakuhyoPrintSevice 異動連絡票service = new JukyushaIdoRenrakuhyoPrintSevice();
        return ResponseData.of(異動連絡票service.printSingle(受給者異動連絡票Entity)).respond();
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
            HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
            前排他キーの解除(被保険者番号.getColumnValue());
            ViewStateHolder.put(ViewStateKeys.処理モード, RString.EMPTY);
            return ResponseData.of(div).forwardWithEventName(DBC0220013TransitionEventName.再検索).respond();
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

    /**
     * 「検索結果一覧へ」ボタンのメソッドです。
     *
     * @param div KyodoIdoRenrakuhyoTorokuMainDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoSakuseiPanelDiv> onClick_btnSearchResult(
            JukyushaIdoRenrakuhyoSakuseiPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
            前排他キーの解除(被保険者番号.getColumnValue());
            ViewStateHolder.put(ViewStateKeys.処理モード, 選択モード);
            return ResponseData.of(div).forwardWithEventName(DBC0220013TransitionEventName.検索結果一覧).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    private JukyushaIdoRenrakuhyoSakuseiPanelHandler getHandler(JukyushaIdoRenrakuhyoSakuseiPanelDiv div) {
        return new JukyushaIdoRenrakuhyoSakuseiPanelHandler(div);
    }

}
