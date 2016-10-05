/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1720011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.core.sogojigyotaishoshatoroku.SogoJigyoTaishoshaToJotai;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1720011.DBC1720011StateName.Default;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1720011.DBC1720011StateName.alter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1720011.SogoJigyoTaishoshaTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1720011.dgKihonInfo_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1720011.SogoJigyoTaishoshaTorokuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1720011.SogoJigyoTaishoshaTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbd.business.core.basic.SogoJigyoTaishoshaIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 新総合事業・事業対象者登録のDivControllerです。
 *
 * @reamsid_L DBC-4900-010 wangjie2
 */
public class SogoJigyoTaishoshaToroku {

    private final RString 状態_追加 = new RString("追加");
    private final RString 状態_修正 = new RString("修正");
    private final RString 状態_削除 = new RString("削除");
    private final RString 保存する = new RString("btnHozonn");

    /**
     * 画面初期化します。
     *
     * @param div 画面情報div
     * @return ResponseData<SogoJigyoTaishoshaTorokuDiv>
     */
    public ResponseData<SogoJigyoTaishoshaTorokuDiv> onLoad(SogoJigyoTaishoshaTorokuDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        SogoJigyoTaishoshaTorokuHandler handler = getHandler(div);
        List<SogoJigyoTaishosha> 総合事業対象者一覧 = handler.get総合事業対象者一覧(被保険者番号);
        ArrayList<SogoJigyoTaishosha> 総合事業対象者一覧ArrayList = new ArrayList<>(総合事業対象者一覧);
        ViewStateHolder
                .put(DBC1720011ViewStateKey.申請一覧情報, 総合事業対象者一覧ArrayList);
        ViewStateHolder
                .put(DBC1720011ViewStateKey.申請一覧情報と状態, handler.onLoad(識別コード, 被保険者番号, 総合事業対象者一覧));
        return ResponseData.of(div).respond();
    }

    /**
     * 「追加する」ボタンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<SogoJigyoTaishoshaTorokuDiv>
     */
    public ResponseData<SogoJigyoTaishoshaTorokuDiv> onClick_btnAdd(SogoJigyoTaishoshaTorokuDiv div) {
        getHandler(div).総合事業対象詳細表示(状態_追加, null);
        ViewStateHolder.put(DBC1720011ViewStateKey.編集総合事業対象者の情報, null);
        return ResponseData.of(div).setState(alter);
    }

    /**
     * データグリッド上の修正アイコンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<SogoJigyoTaishoshaTorokuDiv>
     */
    public ResponseData<SogoJigyoTaishoshaTorokuDiv> onClick_dgMeisai_modify(SogoJigyoTaishoshaTorokuDiv div) {
        SogoJigyoTaishoshaToJotai 編集情報と状態 = get総合事業対象者(div);
        getHandler(div).総合事業対象詳細表示(状態_修正, 編集情報と状態);
        ViewStateHolder.put(DBC1720011ViewStateKey.編集総合事業対象者の情報, 編集情報と状態);
        return ResponseData.of(div).setState(alter);
    }

    /**
     * データグリッド上の削除アイコンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<SogoJigyoTaishoshaTorokuDiv>
     */
    public ResponseData<SogoJigyoTaishoshaTorokuDiv> onClick_dgMeisai_delete(SogoJigyoTaishoshaTorokuDiv div) {
        SogoJigyoTaishoshaToJotai 編集情報と状態 = get総合事業対象者(div);
        getHandler(div).総合事業対象詳細表示(状態_削除, 編集情報と状態);
        ViewStateHolder.put(DBC1720011ViewStateKey.編集総合事業対象者の情報, 編集情報と状態);
        return ResponseData.of(div).setState(alter);
    }

    private SogoJigyoTaishoshaToJotai get総合事業対象者(SogoJigyoTaishoshaTorokuDiv div) {
        dgKihonInfo_Row row = div.getSougouZigyouTaishouItiran().getDgKihonInfo().getActiveRow();
        SogoJigyoTaishoshaIdentifier id
                = DataPassingConverter.deserialize(row.getDataId(), SogoJigyoTaishoshaIdentifier.class);
        ArrayList<SogoJigyoTaishoshaToJotai> 一覧情報と状態
                = ViewStateHolder.get(DBC1720011ViewStateKey.申請一覧情報と状態, ArrayList.class);
        for (SogoJigyoTaishoshaToJotai 情報と状態 : 一覧情報と状態) {
            if (id.equals(情報と状態.get総合事業対象().identifier())) {
                return 情報と状態;
            }
        }
        return null;
    }

    /**
     * 「取消する」ボタンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<SogoJigyoTaishoshaTorokuDiv>
     */
    public ResponseData<SogoJigyoTaishoshaTorokuDiv> onClick_btnCancel(SogoJigyoTaishoshaTorokuDiv div) {
        return ResponseData.of(div).setState(Default);
    }

    /**
     * 「確定する」ボタンを押下して「保存する」ボタン活性/非活性を設定します。
     *
     * @param div 画面情報div
     * @return ResponseData<SogoJigyoTaishoshaTorokuDiv>
     */
    public ResponseData<SogoJigyoTaishoshaTorokuDiv> onChange_state(SogoJigyoTaishoshaTorokuDiv div) {
        if (Default.getName().equals(ResponseHolder.getState())) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, !getHandler(div).is保存可());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「確定する」ボタンを制御します。
     *
     * @param div 画面情報div
     * @return ResponseData<SogoJigyoTaishoshaTorokuDiv>
     */
    public ResponseData<SogoJigyoTaishoshaTorokuDiv> onBlur_txtymfromto(SogoJigyoTaishoshaTorokuDiv div) {
        SogoJigyoTaishoshaToJotai 編集総合事業対象者の情報
                = ViewStateHolder.get(DBC1720011ViewStateKey.編集総合事業対象者の情報, SogoJigyoTaishoshaToJotai.class);
        getHandler(div).確定する制御(編集総合事業対象者の情報);
        return ResponseData.of(div).respond();
    }

    /**
     * 「確定する」ボタンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<SogoJigyoTaishoshaTorokuDiv>
     */
    public ResponseData<SogoJigyoTaishoshaTorokuDiv> onClick_btnConfirm(SogoJigyoTaishoshaTorokuDiv div) {
        if (!状態_削除.equals(div.getSougouZigyouTaishouShousai().getHiddenModel())) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            SogoJigyoTaishoshaTorokuValidationHandler validationHanlder = getValidationHandler();
            validationHanlder.開始日と終了日の前後順チェック(pairs, div);
            validationHanlder.適用期間重複チェック(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        SogoJigyoTaishoshaToJotai 編集総合事業対象者の情報
                = ViewStateHolder.get(DBC1720011ViewStateKey.編集総合事業対象者の情報, SogoJigyoTaishoshaToJotai.class);
        ArrayList<SogoJigyoTaishoshaToJotai> 一覧情報と状態
                = ViewStateHolder.get(DBC1720011ViewStateKey.申請一覧情報と状態, ArrayList.class);
        getHandler(div).onClick_btnConfirm(get最初総合事業対象者(編集総合事業対象者の情報), 被保険者番号, 編集総合事業対象者の情報, 一覧情報と状態);
        ViewStateHolder.put(DBC1720011ViewStateKey.申請一覧情報と状態, 一覧情報と状態);
        return ResponseData.of(div).setState(Default);
    }

    /**
     * 「保存する」ボタンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<SogoJigyoTaishoshaTorokuDiv>
     */
    public ResponseData<SogoJigyoTaishoshaTorokuDiv> onClick_btnHozonn(SogoJigyoTaishoshaTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
            ArrayList<SogoJigyoTaishoshaToJotai> 一覧情報と状態
                    = ViewStateHolder.get(DBC1720011ViewStateKey.申請一覧情報と状態, ArrayList.class);
            getHandler(div).保存処理(一覧情報と状態, 被保険者番号);
            return onLoad(div);
        }
        return ResponseData.of(div).respond();
    }

    private SogoJigyoTaishoshaTorokuHandler getHandler(SogoJigyoTaishoshaTorokuDiv div) {
        return new SogoJigyoTaishoshaTorokuHandler(div);
    }

    private SogoJigyoTaishoshaTorokuValidationHandler getValidationHandler() {
        return new SogoJigyoTaishoshaTorokuValidationHandler();
    }

    private SogoJigyoTaishosha get最初総合事業対象者(SogoJigyoTaishoshaToJotai 編集総合事業対象者の情報) {
        if (null == 編集総合事業対象者の情報) {
            return null;
        }
        SogoJigyoTaishoshaIdentifier id
                = 編集総合事業対象者の情報.get総合事業対象().identifier();
        ArrayList<SogoJigyoTaishosha> 一覧情報
                = ViewStateHolder.get(DBC1720011ViewStateKey.申請一覧情報, ArrayList.class);
        for (SogoJigyoTaishosha 情報 : 一覧情報) {
            if (id.equals(情報.identifier())) {
                return 情報;
            }
        }
        return null;
    }

    /**
     * 引数定義<br/>
     *
     */
    private enum DBC1720011ViewStateKey {

        /**
         * 申請一覧情報です。
         */
        申請一覧情報,
        /**
         * 申請一覧情報と状態です。
         */
        申請一覧情報と状態,
        /**
         * 編集総合事業対象者の情報です。
         */
        編集総合事業対象者の情報;
    }

}
