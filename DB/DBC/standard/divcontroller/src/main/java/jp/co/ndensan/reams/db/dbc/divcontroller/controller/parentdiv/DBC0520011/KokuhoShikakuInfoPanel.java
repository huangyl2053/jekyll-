/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0520011;

import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhoShikakuInfo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0520011.DBC0520011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0520011.DBC0520011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0520011.KokuhoShikakuInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0520011.KokuhoShikakuInfoPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0520011.MainPanelValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 国保資格情報登録
 *
 * @reamsid_L DBD-5730-010 tianyh
 */
public class KokuhoShikakuInfoPanel {

    /**
     * 画面初期化
     *
     * @param mainPanelDiv mainPanelDiv
     * @return ResponseData<mainPanelDiv>
     */
    public ResponseData<KokuhoShikakuInfoPanelDiv> onMainLoad(KokuhoShikakuInfoPanelDiv mainPanelDiv) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (taishoshaKey == null || taishoshaKey.get被保険者番号() == null || taishoshaKey.get被保険者番号().isEmpty()) {
            throw new ApplicationException(DbzErrorMessages.理由付き登録不可.getMessage().replace("被保険者番号なし"));
        }
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
//        HihokenshaNo 被保険者番号 = new HihokenshaNo(new RString("6000000010"));
//        ShikibetsuCode 識別コード = new ShikibetsuCode(new RString("000000000000010"));
        KokuhoShikakuInfo 国保資格詳細情報 = getHandler(mainPanelDiv).initialize(識別コード, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.国保資格詳細情報, 国保資格詳細情報);
        return ResponseData.of(mainPanelDiv).respond();
    }

    /**
     * 「保存する」ボタン押下
     *
     * @param mainPanelDiv mainPanelDiv
     * @return ResponseData
     */
    public ResponseData<KokuhoShikakuInfoPanelDiv> onClick_btnSave(KokuhoShikakuInfoPanelDiv mainPanelDiv) {
        KokuhoShikakuInfo 国保資格詳細情報 = ViewStateHolder.get(ViewStateKeys.国保資格詳細情報, KokuhoShikakuInfo.class);
        MainPanelValidationHandler validation = new MainPanelValidationHandler();
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        validation.資格期間大小関係チェック(pairs, mainPanelDiv);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(mainPanelDiv).addValidationMessages(pairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(mainPanelDiv).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(mainPanelDiv).respond();
        }
        if (getHandler(mainPanelDiv).updateorinsert(
                new ShikibetsuCode(mainPanelDiv.getHeaderPanel().getCcdAtenaInfo().get識別コード()), 国保資格詳細情報)) {
            mainPanelDiv.getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                    RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(mainPanelDiv).setState(DBC0520011StateName.完了);
        }
        return ResponseData.of(mainPanelDiv).respond();
    }

    /**
     * 「一覧へ戻る」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<KokuhoShikakuInfoPanelDiv> onClick_btnBack(KokuhoShikakuInfoPanelDiv div) {
        KokuhoShikakuInfo 国保資格詳細情報 = ViewStateHolder.get(ViewStateKeys.国保資格詳細情報, KokuhoShikakuInfo.class);
        getHandler(div).onClick_btnBack(new ShikibetsuCode(div.getHeaderPanel().getCcdAtenaInfo().get識別コード()), div, 国保資格詳細情報);
        return ResponseData.of(div).forwardWithEventName(DBC0520011TransitionEventName.対象者検索へ戻る).respond();
    }

    private KokuhoShikakuInfoPanelHandler getHandler(KokuhoShikakuInfoPanelDiv div) {
        return new KokuhoShikakuInfoPanelHandler(div);
    }

}
