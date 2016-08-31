/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0530011;

import jp.co.ndensan.reams.db.dbc.business.core.basic.KokiKoreishaInfo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0530011.DBC0530011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0530011.DBC0530011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0530011.MainPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0530011.MainPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0530011.MainPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KokiKoreishaInfoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計後期資格情報登録のクラスです。
 *
 * @reamsid_L DBD-5740-010 liuyl
 */
public class MainPanel {

    /**
     * 画面初期化のメソッドです。
     *
     * @param div MainPanelDiv
     * @return ResponseData<MainPanelDiv>
     */
    public ResponseData<MainPanelDiv> onLoad(MainPanelDiv div) {
//        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = new HihokenshaNo(new RString("0000000001"));
        ShikibetsuCode 識別コード = new ShikibetsuCode(new RString("000000000000010"));
        KokiKoreishaInfoManager manager = new KokiKoreishaInfoManager();
        KokiKoreishaInfo 後期高齢者情報 = manager.get後期高齢者情報(識別コード);
        getHandler(div).onLoad(識別コード, 被保険者番号, 後期高齢者情報);
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        return ResponseData.of(div).respond();
    }

    /**
     * 「一覧へ戻る」ボタンのメソッドです。
     *
     * @param div MainPanelDiv
     * @return ResponseData<MainPanelDiv>
     */
    public ResponseData<MainPanelDiv> onClick_back(MainPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0530011TransitionEventName.対象者検索へ戻る).respond();
    }

    /**
     * 「保存する」ボタンのメソッドです。
     *
     * @param div MainPanelDiv
     * @return ResponseData<MainPanelDiv>
     */
    public ResponseData<MainPanelDiv> onClick_Save(MainPanelDiv div) {
        MainPanelValidationHandler validation = new MainPanelValidationHandler();
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        validation.保険者適用期間大小関係チェック(pairs, div);
        validation.資格期間大小関係チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage("URZQ00010", "保存します。よろしいですか？");
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        KokiKoreishaInfoManager manager = new KokiKoreishaInfoManager();
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        KokiKoreishaInfo 後期高齢者情報 = manager.get後期高齢者情報(識別コード);
        if (後期高齢者情報 == null) {
            KokiKoreishaInfo kokiKoreishaInfo = new KokiKoreishaInfo(識別コード, new RString("0001"));
            if (div.getMeisaiPanel().getTxtHokenshaShuryoYMD().getValue() != null) {
                kokiKoreishaInfo.createBuilderForEdit().set保険者適用終了日(div.getMeisaiPanel().getTxtHokenshaShuryoYMD().
                        getValue().toDateString());
            } else {
                kokiKoreishaInfo.createBuilderForEdit().set保険者適用終了日(RString.EMPTY);
            }
            if (!div.getTxtHihokenshaNo().getValue().isNullOrEmpty()) {
                kokiKoreishaInfo.createBuilderForEdit().set後期高齢被保険者番号(div.getTxtHihokenshaNo().getValue());
            } else {
                kokiKoreishaInfo.createBuilderForEdit().set後期高齢被保険者番号(RString.EMPTY);
            }
            if (div.getTxtHokenshaKaishiYMD().getValue() != null) {
                kokiKoreishaInfo.createBuilderForEdit().set保険者適用開始日(div.getTxtHokenshaKaishiYMD().getValue().toDateString());
            } else {
                kokiKoreishaInfo.createBuilderForEdit().set保険者適用開始日(RString.EMPTY);
            }
            if (div.getMeisaiPanel().getTxtShikakuShutokuYMD().getValue() != null) {
                kokiKoreishaInfo.createBuilderForEdit().set資格取得日(div.getMeisaiPanel().getTxtShikakuShutokuYMD().
                        getValue().toDateString());
            } else {
                kokiKoreishaInfo.createBuilderForEdit().set資格取得日(RString.EMPTY);
            }
            if (div.getMeisaiPanel().getTxtShikakuSoshitsuYMD().getValue() != null) {
                kokiKoreishaInfo.createBuilderForEdit().set資格喪失日(div.getMeisaiPanel().getTxtShikakuSoshitsuYMD().
                        getValue().toDateString());
            } else {
                kokiKoreishaInfo.createBuilderForEdit().set資格喪失日(RString.EMPTY);
            }
            kokiKoreishaInfo.createBuilderForEdit().set個人区分コード(div.getMeisaiPanel().getDdlKojinKubunCode().getSelectedKey())
                    .set資格取得事由コード(div.getMeisaiPanel().getDdlShikakuShutokuJiyu().getSelectedKey())
                    .set資格喪失事由コード(div.getMeisaiPanel().getDdlShikakuSoshitsuJiyu().getSelectedKey());
            if (div.getMeisaiPanel().getChkTorokuKubun().isAllSelected()) {
                kokiKoreishaInfo.createBuilderForEdit().set登録区分(new RString("1"));
            } else {
                kokiKoreishaInfo.createBuilderForEdit().set登録区分(new RString("0"));
            }
            kokiKoreishaInfo.createBuilderForEdit().set後期高齢保険者番号_広域(null);
            manager.save後期高齢者情報(kokiKoreishaInfo);
            getHandler(div).前排他キーの解除(識別コード, RString.EMPTY);
            div.getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                    RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBC0530011StateName.完了);
        } else {
            if (div.getMeisaiPanel().getTxtHokenshaShuryoYMD().getValue() != null) {
                後期高齢者情報.createBuilderForEdit().set保険者適用終了日(div.getMeisaiPanel().getTxtHokenshaShuryoYMD().
                        getValue().toDateString());
            } else {
                後期高齢者情報.createBuilderForEdit().set保険者適用終了日(RString.EMPTY);
            }
            if (!div.getTxtHihokenshaNo().getValue().isNullOrEmpty()) {
                後期高齢者情報.createBuilderForEdit().set後期高齢被保険者番号(div.getTxtHihokenshaNo().getValue());
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
                    .set資格喪失事由コード(div.getMeisaiPanel().getDdlShikakuSoshitsuJiyu().getSelectedKey());
            if (div.getMeisaiPanel().getChkTorokuKubun().isAllSelected()) {
                後期高齢者情報.createBuilderForEdit().set登録区分(new RString("1"));
            } else {
                後期高齢者情報.createBuilderForEdit().set登録区分(new RString("0"));
            }
            manager.save後期高齢者情報(後期高齢者情報);
            getHandler(div).前排他キーの解除(識別コード, div.getMeisaiPanel().getTxtRirekiNo().getValue());
            div.getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                    RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBC0530011StateName.完了);
        }
    }

    private MainPanelHandler getHandler(MainPanelDiv div) {
        return new MainPanelHandler(div);
    }
}
