/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0260013;

import jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushataishosha.KyodoJukyushaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyodoshoriyoJukyushaIdoRenrakuhyoParam;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0260013.DBC0260013StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0260013.DBC0260013TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0260013.KyodoJukyusyaIdoRenrakuhyoDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0260013.KyodoJukyusyaIdoRenrakuhyoDetailHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * KyodoJukyusyaIdoRenrakuhyoDetail_共同処理用受給者異動連絡票作成のクラスです。
 *
 * @reamsid_L DBC-1952-010 liuxiaoyu
 */
public class KyodoJukyusyaIdoRenrakuhyoDetail {

    private static final RString 引数 = new RString("被保険者番号なし");
    private static final RString 照会モード = new RString("照会");
    private static final QuestionMessage SYORIMESSAGE = new QuestionMessage(
            UrQuestionMessages.処理実行の確認.getMessage().getCode(),
            UrQuestionMessages.処理実行の確認.getMessage().evaluate());

    /**
     * 画面初期化のメソッドです。
     *
     * @param div 画面Div
     *
     * @return ResponseData<KyodoJukyusyaIdoRenrakuhyoDetailDiv>
     */
    public ResponseData<KyodoJukyusyaIdoRenrakuhyoDetailDiv> onLoad(KyodoJukyusyaIdoRenrakuhyoDetailDiv div) {

        KyodoJukyushaTaishoshaEntity 引き継ぎ情報
                = ViewStateHolder.get(ViewStateKeys.一覧検索キー, KyodoJukyushaTaishoshaEntity.class);
        if (引き継ぎ情報 != null) {
            HihokenshaNo 被保険者番号 = 引き継ぎ情報.get被保番号();
            if (null == 被保険者番号 || 被保険者番号.isEmpty()) {
                throw new ApplicationException(
                        DbzErrorMessages.理由付き登録不可.getMessage().replace(引数.toString()));
            }
            KyodoshoriyoJukyushaIdoRenrakuhyoParam param = getHandler(div).onLoad(照会モード, 引き継ぎ情報);

            ViewStateHolder.put(ViewStateKeys.共同処理用受給者異動情報, param);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「対象者検索に戻る」ボタンを押下すると、対象者検索画面に遷移する。
     *
     * @param div 画面Div
     *
     * @return ResponseData
     */
    public ResponseData<KyodoJukyusyaIdoRenrakuhyoDetailDiv> onClick_btnReturnSearch(KyodoJukyusyaIdoRenrakuhyoDetailDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0260013TransitionEventName.検索に戻る).respond();
    }

    /**
     * 「連絡票を発行する」ボタンを押下すると、帳票発行処理のメソッドです。
     *
     * @param div 画面Div
     *
     * @return ResponseData
     */
    public ResponseData<KyodoJukyusyaIdoRenrakuhyoDetailDiv> onClick_btnReportPublish_CheckMessage(KyodoJukyusyaIdoRenrakuhyoDetailDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(SYORIMESSAGE).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).setState(DBC0260013StateName.初期化状態);
        }
        return ResponseData.of(div).respond();

    }

    /**
     * 「処理実行の確認」.「はい」ボタンのメソッドです。
     *
     * @param div 画面Div
     *
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(KyodoJukyusyaIdoRenrakuhyoDetailDiv div) {
        return ResponseData.of(getHandler(div).to帳票発行(div.getCcdKyodoJukyusyaIdoRenrakuhyo()))
                .setState(DBC0260013StateName.初期化状態);
    }

    private KyodoJukyusyaIdoRenrakuhyoDetailHandler getHandler(KyodoJukyusyaIdoRenrakuhyoDetailDiv div) {
        return new KyodoJukyusyaIdoRenrakuhyoDetailHandler(div);
    }
}
