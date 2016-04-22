/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA2040011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.tajushochitokureisya.TaJushochiTokureisyaKanriParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TaJushochiTokureishaKanri.TaJushochiTokureishaKanri.dgJushochiTokureiRireki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2040011.DBA2040011StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2040011.DBA2040011TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2040011.HokaShichosonJyusyochiTokureisyaKanriDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2040011.HokaShichosonJyusyochiTokureisyaKanriHandler;
import jp.co.ndensan.reams.db.dba.service.core.tajushochitokureisyakanri.TaJushochiTokureisyaKanriManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 他市町村住所地特例者管理のクラスです。
 *
 * @reamsid_L DBA-0400-100 yaodongsheng
 */
public class HokaShichosonJyusyochiTokureisyaKanri {

    private static final RString メニューID_転入転出保留対象者管理 = new RString("DBAMN61002");
    private static final RString メニューID_施設入所により適用 = new RString("DBAMN31001");
    private static final RString メニューID_施設退所により解除 = new RString("DBAMN31002");
    private static final RString メニューID_施設変更により変更 = new RString("DBAMN31003");
    private static final RString 遷移モード_施設入所により適用 = new RString("Tekiyo");
    private static final RString 遷移モード_施設退所により解除 = new RString("Kaijyo");
    private static final RString 遷移モード_施設変更により変更 = new RString("ShisetuHenko");
    private static final RString PARAMETER = new RString("対象者検索");
    private static final RString SHINKI = new RString("新規");
    private static final RString SYUSEI = new RString("修正");
    private static final LockingKey LOCKINGKEY = new LockingKey(new RString("TatokuIdoKanri"));
    private static final QuestionMessage SYORIMESSAGE = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
            UrQuestionMessages.処理実行の確認.getMessage().evaluate());
    private static RString menuId;
    private static List<dgJushochiTokureiRireki_Row> koshinzen = new ArrayList<>();

    /**
     * 他市町村住所地特例者管理の初期化です。
     *
     * @param div HokaShichosonJyusyochiTokureisyaKanriDiv
     * @return HokaShichosonJyusyochiTokureisyaKanriDiv
     */
    public ResponseData<HokaShichosonJyusyochiTokureisyaKanriDiv> onLoad(HokaShichosonJyusyochiTokureisyaKanriDiv div) {
        menuId = ResponseHolder.getMenuID();
        menuId = メニューID_施設変更により変更;
        TaishoshaKey key = new TaishoshaKey(HihokenshaNo.EMPTY, new ShikibetsuCode("000000000000010"), SetaiCode.EMPTY);
        ViewStateHolder.put(ViewStateKey.資格対象者, key);
        div.getShikakuKihonJoho().getCddTaJushochiTokureishaKanri().set状態(getMode().get(menuId));
        getHandler(div).onLoad(ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get識別コード());
        RealInitialLocker.tryGetLock(LOCKINGKEY);
        koshinzen = div.getCddTaJushochiTokureishaKanri().get適用情報一覧();
        if (メニューID_施設入所により適用.equals(menuId) || メニューID_転入転出保留対象者管理.equals(menuId)) {
            return ResponseData.of(div).setState(DBA2040011StateName.追加適用);
        } else if (メニューID_施設退所により解除.equals(menuId)) {
            return ResponseData.of(div).setState(DBA2040011StateName.追加解除);
        } else if (メニューID_施設変更により変更.equals(menuId)) {
            div.getCddShisetsuNyutaishoRirekiKanri().initialize(ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get識別コード());
            return ResponseData.of(div).setState(DBA2040011StateName.追加変更);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 他市町村住所地特例者管理の「該当者一覧へ戻る」ボタンを押下しです。
     *
     * @param div HokaShichosonJyusyochiTokureisyaKanriDiv
     * @return HokaShichosonJyusyochiTokureisyaKanriDiv
     */
    public ResponseData<HokaShichosonJyusyochiTokureisyaKanriDiv> onClick_Return(HokaShichosonJyusyochiTokureisyaKanriDiv div) {
        RealInitialLocker.release(LOCKINGKEY);
        return ResponseData.of(div).forwardWithEventName(DBA2040011TransitionEventName.再検索).respond();
    }

    /**
     * 他市町村住所地特例者管理の「完了する」ボタンを押下しです。
     *
     * @param div HokaShichosonJyusyochiTokureisyaKanriDiv
     * @return HokaShichosonJyusyochiTokureisyaKanriDiv
     */
    public ResponseData<HokaShichosonJyusyochiTokureisyaKanriDiv> onClick_Kanryo(HokaShichosonJyusyochiTokureisyaKanriDiv div) {
        RealInitialLocker.release(LOCKINGKEY);
        return ResponseData.of(div).respond();
    }

    /**
     * 他市町村住所地特例者管理の保存ボタンをです。
     *
     * @param div HokaShichosonJyusyochiTokureisyaKanriDiv
     * @return HokaShichosonJyusyochiTokureisyaKanriDiv
     */
    public ResponseData<HokaShichosonJyusyochiTokureisyaKanriDiv> onClick_Hozon(HokaShichosonJyusyochiTokureisyaKanriDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(SYORIMESSAGE).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            set処理実行(div);
            RealInitialLocker.release(LOCKINGKEY);
            return ResponseData.of(div).setState(DBA2040011StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 他市町村住所地特例者管理の再検索ボタンをです。
     *
     * @param div HokaShichosonJyusyochiTokureisyaKanriDiv
     * @return HokaShichosonJyusyochiTokureisyaKanriDiv
     */
    public ResponseData<HokaShichosonJyusyochiTokureisyaKanriDiv> onClick_btnReSearch(HokaShichosonJyusyochiTokureisyaKanriDiv div) {
        RealInitialLocker.release(LOCKINGKEY);
        return ResponseData.of(div).forwardWithEventName(DBA2040011TransitionEventName.再検索).parameter(PARAMETER);
    }

    private Map<RString, RString> getMode() {
        Map<RString, RString> mode = new HashMap<>();
        mode.put(メニューID_転入転出保留対象者管理, 遷移モード_施設入所により適用);
        mode.put(メニューID_施設入所により適用, 遷移モード_施設入所により適用);
        mode.put(メニューID_施設退所により解除, 遷移モード_施設退所により解除);
        mode.put(メニューID_施設変更により変更, 遷移モード_施設変更により変更);
        return mode;
    }

    private HokaShichosonJyusyochiTokureisyaKanriHandler getHandler(HokaShichosonJyusyochiTokureisyaKanriDiv requestDiv) {
        return new HokaShichosonJyusyochiTokureisyaKanriHandler(requestDiv);
    }

    private void set処理実行(HokaShichosonJyusyochiTokureisyaKanriDiv div) {
        TaJushochiTokureisyaKanriManager manager = TaJushochiTokureisyaKanriManager.createInstance();
        List<TaJushochiTokureisyaKanriParameter> paramaterList = new ArrayList<>();
        for (dgJushochiTokureiRireki_Row row : div.getShikakuKihonJoho().getCddTaJushochiTokureishaKanri().get適用情報一覧()) {
            TaJushochiTokureisyaKanriParameter parameter = TaJushochiTokureisyaKanriParameter.createParamBy他市町村住所地特例者管理(
                    row.getNyushoYMD().getValue() == null ? FlexibleDate.EMPTY
                    : new FlexibleDate(row.getNyushoYMD().getValue().toDateString()),
                    row.getTaishoYMD().getValue() == null ? FlexibleDate.EMPTY
                    : new FlexibleDate(row.getTaishoYMD().getValue().toDateString()),
                    row.getKaijoYMD().getValue() == null ? FlexibleDate.EMPTY
                    : new FlexibleDate(row.getKaijoYMD().getValue().toDateString()),
                    row.getTekiyoYMD().getValue() == null ? FlexibleDate.EMPTY
                    : new FlexibleDate(row.getTekiyoYMD().getValue().toDateString()),
                    new RString(row.getRowState().toString()));
            paramaterList.add(parameter);
        }
        if (メニューID_施設入所により適用.equals(menuId)) {
            set適用(paramaterList);
            manager.checkTekiyouJotai(paramaterList);
        } else if (メニューID_施設退所により解除.equals(menuId)) {
            set解除(paramaterList);
            manager.checkKaijoJotai(paramaterList);
        } else if (メニューID_施設変更により変更.equals(menuId)) {
            manager.checkHenkoJotai(paramaterList);
        }
        div.getShikakuKihonJoho().getCddTaJushochiTokureishaKanri().saveTaJushochiTokurei(
                ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get識別コード());
        if (メニューID_施設変更により変更.equals(ResponseHolder.getMenuID())) {
            div.getCddShisetsuNyutaishoRirekiKanri().saveShisetsuNyutaisho();
        }
    }

    private void set適用(List<TaJushochiTokureisyaKanriParameter> paramaterList) {
        if (paramaterList.size() > koshinzen.size()) {
            TaJushochiTokureisyaKanriParameter parameter1 = paramaterList.get(0);
            TaJushochiTokureisyaKanriParameter parameter = TaJushochiTokureisyaKanriParameter.createParamBy他市町村住所地特例者管理(
                    parameter1.getNyuusyoYMD(), parameter1.getTayishoYMD(), parameter1.getKaijoYMD(), parameter1.getTekiyoYMD(), SHINKI
            );
            paramaterList.set(0, parameter);
        }
    }

    private void set解除(List<TaJushochiTokureisyaKanriParameter> paramaterList) {
        if (koshinzen.get(0).getKaijoYMD().getValue() == null
                && paramaterList.get(0).getKaijoYMD() != null && !paramaterList.get(0).getKaijoYMD().isEmpty()) {
            TaJushochiTokureisyaKanriParameter parameter1 = paramaterList.get(0);
            TaJushochiTokureisyaKanriParameter parameter = TaJushochiTokureisyaKanriParameter.createParamBy他市町村住所地特例者管理(
                    parameter1.getNyuusyoYMD(), parameter1.getTayishoYMD(), parameter1.getKaijoYMD(), parameter1.getTekiyoYMD(), SYUSEI
            );
            paramaterList.set(0, parameter);
        }
    }
}
