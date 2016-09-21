/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0530011;

import jp.co.ndensan.reams.db.dbc.business.core.basic.KokiKoreishaInfo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0530011.DBC0530011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0530011.DBC0530011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0530011.KokiKoreishaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0530011.KokiKoreishaHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0530011.KokiKoreishaValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KokiKoreishaInfoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計後期資格情報登録のクラスです。
 *
 * @reamsid_L DBD-5740-010 liuyl
 */
public class KokiKoreisha {

    /**
     * 画面初期化です。
     *
     * @param div MainPanelDiv
     * @return ResponseData<MainPanelDiv>
     */
    public ResponseData<KokiKoreishaDiv> onLoad(KokiKoreishaDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (資格対象者 == null || 資格対象者.get被保険者番号() == null || 資格対象者.get被保険者番号().isEmpty()) {
            throw new ApplicationException(DbzErrorMessages.理由付き登録不可.getMessage().replace("被保険者番号なし"));
        }
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ShikibetsuCode 識別コード = 資格対象者.get識別コード();
        KokiKoreishaInfoManager manager = new KokiKoreishaInfoManager();
        KokiKoreishaInfo 後期高齢者情報 = manager.get後期高齢者情報(識別コード);
        ViewStateHolder.put(ViewStateKeys.イメージ情報, 後期高齢者情報);
        getHandler(div).onLoad(識別コード, 被保険者番号, 後期高齢者情報);
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        RString 履歴番号;
        if (後期高齢者情報 != null) {
            履歴番号 = 後期高齢者情報.get履歴番号();
        } else {
            履歴番号 = RString.EMPTY;
        }
        ViewStateHolder.put(ViewStateKeys.履歴番号, 履歴番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 「一覧へ戻る」ボタンのメソッドです。
     *
     * @param div MainPanelDiv
     * @return ResponseData<MainPanelDiv>
     */
    public ResponseData<KokiKoreishaDiv> onClick_back(KokiKoreishaDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            getHandler(div).前排他キーの解除(被保険者番号);
        }
        return ResponseData.of(div).forwardWithEventName(DBC0530011TransitionEventName.対象者検索へ戻る).respond();
    }

    /**
     * 「保存する」ボタンのメソッドです。
     *
     * @param div MainPanelDiv
     * @return ResponseData<MainPanelDiv>
     */
    public ResponseData<KokiKoreishaDiv> onClick_Save(KokiKoreishaDiv div) {
        KokiKoreishaValidationHandler validation = new KokiKoreishaValidationHandler();
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        validation.保険者適用期間大小関係チェック(pairs, div);
        validation.資格期間大小関係チェック(pairs, div);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        KokiKoreishaInfoManager manager = new KokiKoreishaInfoManager();
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        KokiKoreishaInfo 後期高齢者情報 = ViewStateHolder.get(ViewStateKeys.イメージ情報, KokiKoreishaInfo.class);
        if (後期高齢者情報 == null) {
            KokiKoreishaInfo kokiKoreishaInfo = new KokiKoreishaInfo(識別コード, new RString("0001"));
            if (div.getMeisaiPanel().getTxtHokenshaShuryoYMD().getValue() != null) {
                kokiKoreishaInfo.createBuilderForEdit().set保険者適用終了日(div.getMeisaiPanel().getTxtHokenshaShuryoYMD().
                        getValue().toDateString());
            }
            if (!div.getTxtHihokenshaNo().getValue().isNullOrEmpty()) {
                kokiKoreishaInfo.createBuilderForEdit().set後期高齢被保険者番号(div.getTxtHihokenshaNo().getValue());
            }
            if (div.getTxtHokenshaKaishiYMD().getValue() != null) {
                kokiKoreishaInfo.createBuilderForEdit().set保険者適用開始日(div.getTxtHokenshaKaishiYMD().getValue().toDateString());
            }
            if (div.getMeisaiPanel().getTxtShikakuShutokuYMD().getValue() != null) {
                kokiKoreishaInfo.createBuilderForEdit().set資格取得日(div.getMeisaiPanel().getTxtShikakuShutokuYMD().
                        getValue().toDateString());
            }
            if (div.getMeisaiPanel().getTxtShikakuSoshitsuYMD().getValue() != null) {
                kokiKoreishaInfo.createBuilderForEdit().set資格喪失日(div.getMeisaiPanel().getTxtShikakuSoshitsuYMD().
                        getValue().toDateString());
            }
            kokiKoreishaInfo.createBuilderForEdit().set個人区分コード(div.getMeisaiPanel().getDdlKojinKubunCode().getSelectedKey())
                    .set資格取得事由コード(div.getMeisaiPanel().getDdlShikakuShutokuJiyu().getSelectedKey())
                    .set資格喪失事由コード(div.getMeisaiPanel().getDdlShikakuSoshitsuJiyu().getSelectedKey())
                    .set後期高齢保険者番号_市町村(div.getMeisaiPanel().getDdlHokenshaNo().getSelectedValue());
            if (div.getMeisaiPanel().getChkTorokuKubun().isAllSelected()) {
                kokiKoreishaInfo.createBuilderForEdit().set登録区分(new RString("1"));
            } else {
                kokiKoreishaInfo.createBuilderForEdit().set登録区分(new RString("0"));
            }
            kokiKoreishaInfo.createBuilderForEdit().set後期高齢保険者番号_広域(null);
            manager.save後期高齢者情報(kokiKoreishaInfo);
        } else {
            if (div.getMeisaiPanel().getTxtHokenshaShuryoYMD().getValue() != null) {
                後期高齢者情報.createBuilderForEdit().set保険者適用終了日(div.getMeisaiPanel().getTxtHokenshaShuryoYMD().
                        getValue().toDateString());
            } else {
                後期高齢者情報.createBuilderForEdit().set保険者適用終了日(RString.EMPTY);
            }
            if (div.getTxtHihokenshaNo().getValue() != null) {
                後期高齢者情報.createBuilderForEdit().set後期高齢被保険者番号(div.getMeisaiPanel().getTxtHihokenshaNo().getValue());
            } else {
                後期高齢者情報.createBuilderForEdit().set後期高齢被保険者番号(RString.EMPTY);
            }
            if (div.getTxtHokenshaKaishiYMD().getValue() != null) {
                後期高齢者情報.createBuilderForEdit().set保険者適用開始日(div.getTxtHokenshaKaishiYMD().getValue().toDateString());
            } else {
                後期高齢者情報.createBuilderForEdit().set保険者適用開始日(RString.EMPTY);
            }
            if (div.getMeisaiPanel().getTxtShikakuShutokuYMD().getValue() != null) {
                後期高齢者情報.createBuilderForEdit().set資格取得日(div.getMeisaiPanel().getTxtShikakuShutokuYMD().
                        getValue().toDateString());
            } else {
                後期高齢者情報.createBuilderForEdit().set資格取得日(RString.EMPTY);
            }
            if (div.getMeisaiPanel().getTxtShikakuSoshitsuYMD().getValue() != null) {
                後期高齢者情報.createBuilderForEdit().set資格喪失日(div.getMeisaiPanel().getTxtShikakuSoshitsuYMD().
                        getValue().toDateString());
            } else {
                後期高齢者情報.createBuilderForEdit().set資格喪失日(RString.EMPTY);
            }
            後期高齢者情報.createBuilderForEdit().set個人区分コード(div.getMeisaiPanel().getDdlKojinKubunCode().getSelectedKey())
                    .set資格取得事由コード(div.getMeisaiPanel().getDdlShikakuShutokuJiyu().getSelectedKey())
                    .set資格喪失事由コード(div.getMeisaiPanel().getDdlShikakuSoshitsuJiyu().getSelectedKey())
                    .set後期高齢保険者番号_市町村(div.getMeisaiPanel().getDdlHokenshaNo().getSelectedValue());
            if (div.getMeisaiPanel().getChkTorokuKubun().isAllSelected()) {
                後期高齢者情報.createBuilderForEdit().set登録区分(new RString("1"));
            } else {
                後期高齢者情報.createBuilderForEdit().set登録区分(new RString("0"));
            }
            manager.save後期高齢者情報(後期高齢者情報);
        }
        getHandler(div).前排他キーの解除(被保険者番号);
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value());
        AccessLogger.log(AccessLogType.更新, PersonalData.of(識別コード, expandedInfo));
        div.getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                RString.EMPTY, RString.EMPTY, true);
        return ResponseData.of(div).setState(DBC0530011StateName.完了);
    }

    private KokiKoreishaHandler getHandler(KokiKoreishaDiv div) {
        return new KokiKoreishaHandler(div);
    }
}
