/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA2030011;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tennyutenshutsuhoryu.TennyuHoryuTaisho;
import jp.co.ndensan.reams.db.dba.business.core.tennyutenshutsuhoryu.TenshutsuHoryuTaisho;
import jp.co.ndensan.reams.db.dba.definition.message.DbaQuestionMessages;
import jp.co.ndensan.reams.db.dbz.business.core.hihokenshadaicho.HihokenshaShutokuJyoho;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2030011.DBA2030011StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2030011.DBA2030011TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2030011.JushotiTokureiIdouDiv;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dba.service.core.jushotitokureiidou.JushotiTokureiIdouFinder;
import jp.co.ndensan.reams.db.dba.service.core.tennyutenshutsuhoryutaishosha.TennyuTenshutsuHoryuTaishoshaManager;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.TennyushutsuHoryuTaishosha;
import jp.co.ndensan.reams.db.dbz.business.core.TenshutsuHoryuTaishosha;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 被保険者台帳管理（住所地特例異動）クラスです。
 *
 * @reamsid_L DBA-1380-010 lijia
 */
public class JushotiTokureiIdou {

    private static final RString 住所地特例モード = new RString("teiseitoroku_jyusyoti");
    private static final RString 適用モード = new RString("tekiyo");
    private static final RString 解除モード = new RString("kaijo");
    private static final RString 資格異動モード = new RString("teiseitoroku");
    private static final RString 照会モード = new RString("shokai");
    private static final RString 表示モード = new RString("資格異動");
    private static final RString 表示幅モード = new RString("モード1");
    private static final RString 明細表示モード = new RString("追加_修正");
    private static final RString 利用モード = new RString("被保険者対象機能");
    private static final RString DBAMN25001_届出により適用 = new RString("DBAMN25001");
    private static final RString DBAMN25002_届出により解除 = new RString("DBAMN25002");
    private static final RString DBAMN25003_届出により施設変更 = new RString("DBAMN25003");
    private static final RString DBAMN61002_転入転出保留対象者管理 = new RString("DBAMN61002");
    private LockingKey 前排他ロックキー;
    private final HihokenshaShikakuShutokuManager hihokenshaShikakuShutoku = HihokenshaShikakuShutokuManager.createInstance();
    private final JushotiTokureiIdouFinder jushotiTokureiIdouFinder = JushotiTokureiIdouFinder.createInstance();

    /**
     * 画面初期化処理します。
     *
     * @param div JushotiTokureiIdouDiv
     * @return ResponseData<JushotiTokureiIdouDiv>
     */
    public ResponseData<JushotiTokureiIdouDiv> onLoad(JushotiTokureiIdouDiv div) {
        ShikibetsuCode 識別コード = getKey().get識別コード();
        div.getKihonJoho().getCcdKaigoAtenaInfo().initialize(識別コード);
        HihokenshaNo 被保険者番号 = getKey().get被保険者番号();
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            div.getKihonJoho().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        }
        div.getCcdHihosyosai().被保詳細モード(住所地特例モード);
        if (DBAMN25001_届出により適用.equals(UrControlDataFactory.createInstance().getMenuID())) {
            div.getCcdHihosyosai().住所地特例表示タイプ(適用モード);
            前排他ロックキー = new LockingKey("ShikakuJutokuTekiyo、HihokenshaNo");
        }
        if (DBAMN25002_届出により解除.equals(UrControlDataFactory.createInstance().getMenuID())) {
            div.getCcdHihosyosai().住所地特例表示タイプ(解除モード);
            前排他ロックキー = new LockingKey("ShikakuJutokuKaijo、HihokenshaNo");
        }
        if (DBAMN25003_届出により施設変更.equals(UrControlDataFactory.createInstance().getMenuID())) {
            div.getCcdHihosyosai().住所地特例表示タイプ(資格異動モード);
            前排他ロックキー = new LockingKey("ShikakuJutokuShikakuIdo、HihokenshaNo");
        }
        if (DBAMN61002_転入転出保留対象者管理.equals(UrControlDataFactory.createInstance().getMenuID())) {
//            Todo:広域ユーザー導入時に実装。転出保留対象か、転入保留対象か状態にて区別する。
            if (DBA2030011StateName.転出転入保留対象者管理_初期状態.getName().equals(ResponseHolder.getState())) {
                div.getCcdHihosyosai().住所地特例表示タイプ(適用モード);
            } else {
                div.getCcdHihosyosai().住所地特例表示タイプ(解除モード);
            }
            前排他ロックキー = new LockingKey("ShikakuJutokuTekiyo、HihokenshaNo");
        }
        div.getCcdHihosyosai().資格関連異動表示モード(照会モード);
        div.getCcdHihosyosai().施設入退所表示モード(表示モード);
        div.getCcdHihosyosai().施設入退所表示widthサイズ(表示幅モード);
        div.getCcdHihosyosai().施設入退所明細表示モード(明細表示モード);
        div.getCcdHihosyosai().施設入退所利用モード(利用モード);
        HihokenshaShutokuJyoho hihokenshaShutokuJyoho = hihokenshaShikakuShutoku.getSaishinDeta(識別コード, 被保険者番号);
        ShichosonSecurityJoho 介護導入形態 = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 導入形態コード = RString.EMPTY;
        if (介護導入形態 != null) {
            導入形態コード = 介護導入形態.get導入形態コード().getCode();
        }
        div.getCcdHihosyosai().initialize(hihokenshaShutokuJyoho.get市町村コード(),
                導入形態コード,
                hihokenshaShutokuJyoho.get広住特措置元市町村コード(),
                被保険者番号,
                hihokenshaShutokuJyoho.get異動日(),
                hihokenshaShutokuJyoho.get枝番(),
                識別コード,
                hihokenshaShutokuJyoho.get資格取得年月日(),
                RString.EMPTY);
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            div.setReadOnly(true);
            throw new ApplicationException(UrErrorMessages.排他_他のユーザが使用中.getMessage());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「資格情報を保存する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SikakuIdouTeiseiDiv>
     */
    public ResponseData<JushotiTokureiIdouDiv> onClick_save(JushotiTokureiIdouDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }

        if (new RString(UrInformationMessages.保存終了.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBA2030011TransitionEventName.完了).respond();
        }

        TennyuTenshutsuHoryuTaishoshaManager 転入出保留対象者Manager = InstanceProvider.create(TennyuTenshutsuHoryuTaishoshaManager.class);
        if (new RString(DbaQuestionMessages.保留対象取消確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            TenshutsuHoryuTaisho 転出保留対象者情報 = ViewStateHolder.get(ViewStateKeys.転出保留対象者, TenshutsuHoryuTaisho.class);
            TennyuHoryuTaisho 転入保留対象者情報 = ViewStateHolder.get(ViewStateKeys.転入保留対象者, TennyuHoryuTaisho.class);
            TenshutsuHoryuTaishosha 転出保留対象者 = null;
            TennyushutsuHoryuTaishosha 転入保留対象者 = null;
            if (転出保留対象者情報 != null) {
                転出保留対象者 = 転出保留対象者情報.get転出保留対象者();
            }
            if (転入保留対象者情報 != null) {
                転入保留対象者 = 転入保留対象者情報.get転入保留対象者();
            }
            if (転出保留対象者 != null) {
                転入出保留対象者Manager.delete転出保留対象者(転出保留対象者);
            }
            if (転入保留対象者 != null) {
                転入出保留対象者Manager.delete転入保留対象者(転入保留対象者);
            }
            RealInitialLocker.release(前排他ロックキー);
            if (DBAMN61002_転入転出保留対象者管理.equals(UrControlDataFactory.createInstance().getMenuID())) {
                return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
            } else {
                return ResponseData.of(div).setState(DBA2030011StateName.完了状態);
            }
        }

        if (new RString(DbaQuestionMessages.保留対象取消確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            RealInitialLocker.release(前排他ロックキー);
            if (DBAMN61002_転入転出保留対象者管理.equals(UrControlDataFactory.createInstance().getMenuID())) {
                return ResponseData.of(div).forwardWithEventName(DBA2030011TransitionEventName.完了).respond();
            } else {
                return ResponseData.of(div).setState(DBA2030011StateName.完了状態);
            }
        }

        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getCcdHihosyosai().施設入退所保存処理();
            TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            ShikibetsuCode 識別コード = key.get識別コード();
            Message message = null;
            RString completeMessage = RString.EMPTY;
            if (DBAMN25001_届出により適用.equals(UrControlDataFactory.createInstance().getMenuID())) {
                適用情報の保存(div);
                message = 転入出保留対象者Manager.check転出保留対象者(識別コード);
                completeMessage = new RString("資格適用処理");
            }
            if (DBAMN25002_届出により解除.equals(UrControlDataFactory.createInstance().getMenuID())) {
                解除情報の保存(div);
                message = 転入出保留対象者Manager.check転入保留対象者(識別コード);
                completeMessage = new RString("資格解除処理");
            }
            if (DBAMN25003_届出により施設変更.equals(UrControlDataFactory.createInstance().getMenuID())) {
                変更情報の保存(div);
                RealInitialLocker.release(前排他ロックキー);
                div.getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                        .replace("資格変更処理").evaluate()), RString.EMPTY, RString.EMPTY, true);
                return ResponseData.of(div).setState(DBA2030011StateName.完了状態);
            }
            if (DBAMN61002_転入転出保留対象者管理.equals(UrControlDataFactory.createInstance().getMenuID())) {
//                Todo:広域ユーザー導入時に実装。転出保留対象か、転入保留対象か状態にて区別する。
                if (DBA2030011StateName.転出転入保留対象者管理_初期状態.getName().equals(ResponseHolder.getMenuID())) {
                    適用情報の保存(div);
                    message = 転入出保留対象者Manager.check転出保留対象者(識別コード);
                } else {
                    解除情報の保存(div);
                    message = 転入出保留対象者Manager.check転入保留対象者(識別コード);
                }
            }
            if (message != null) {
                return ResponseData.of(div).addMessage(message).respond();
            } else {
                RealInitialLocker.release(前排他ロックキー);
                if (RString.isNullOrEmpty(completeMessage)) {
                    return ResponseData.of(div).forwardWithEventName(DBA2030011TransitionEventName.完了).respond();
                }
                setCompleteMessage(div, completeMessage);
                return ResponseData.of(div).setState(DBA2030011StateName.完了状態);
            }
        }
        return ResponseData.of(div).respond();
    }

    private void setCompleteMessage(JushotiTokureiIdouDiv div, RString message) {
        div.getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                .replace(message.toString()).evaluate()), RString.EMPTY, RString.EMPTY, true);
    }

    /**
     * 「対象者検索に戻る」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SikakuIdouTeiseiDiv>
     */
    public ResponseData<JushotiTokureiIdouDiv> onClick_modaru(JushotiTokureiIdouDiv div) {
        RealInitialLocker.release(前排他ロックキー);
        return ResponseData.of(div).forwardWithEventName(DBA2030011TransitionEventName.再検索).respond();
    }

    private TaishoshaKey getKey() {
        return ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
    }

    private void 適用情報の保存(JushotiTokureiIdouDiv div) {
        List<HihokenshaDaicho> hihokenshaDaichoList = div.getCcdHihosyosai().住所地特例履歴情報取得().records();
        for (HihokenshaDaicho hihokenshaDaicho : hihokenshaDaichoList) {
            jushotiTokureiIdouFinder.shikakuJutokuCheck(
                    getKey().get識別コード(), getKey().get被保険者番号(), hihokenshaDaicho.get適用年月日(), FlexibleDate.EMPTY);
            jushotiTokureiIdouFinder.saveShikakuJutoku(
                    getKey().get識別コード(), getKey().get被保険者番号(),
                    hihokenshaDaicho.get適用年月日(), hihokenshaDaicho.get適用届出年月日(), hihokenshaDaicho.get住所地特例適用事由コード(),
                    FlexibleDate.EMPTY, FlexibleDate.EMPTY, RString.EMPTY);
        }
    }

    private void 解除情報の保存(JushotiTokureiIdouDiv div) {
        List<HihokenshaDaicho> hihokenshaDaichoList = div.getCcdHihosyosai().住所地特例履歴情報取得().records();
        for (HihokenshaDaicho hihokenshaDaicho : hihokenshaDaichoList) {
            jushotiTokureiIdouFinder.shikakuJutokuCheck(
                    getKey().get識別コード(), getKey().get被保険者番号(), hihokenshaDaicho.get適用年月日(), hihokenshaDaicho.get解除年月日());
            jushotiTokureiIdouFinder.saveShikakuJutoku(
                    getKey().get識別コード(), getKey().get被保険者番号(),
                    hihokenshaDaicho.get適用年月日(), hihokenshaDaicho.get適用届出年月日(), hihokenshaDaicho.get住所地特例適用事由コード(),
                    hihokenshaDaicho.get解除年月日(), hihokenshaDaicho.get解除届出年月日(), hihokenshaDaicho.get住所地特例解除事由コード());
        }
    }

    private void 変更情報の保存(JushotiTokureiIdouDiv div) {
        List<HihokenshaDaicho> hihokenshaDaichoList = div.getCcdHihosyosai().住所地特例履歴情報取得().records();
        for (HihokenshaDaicho hihokenshaDaicho : hihokenshaDaichoList) {
            jushotiTokureiIdouFinder.saveShikakuJutoku(
                    getKey().get識別コード(), getKey().get被保険者番号(),
                    hihokenshaDaicho.get適用年月日(), hihokenshaDaicho.get適用届出年月日(), hihokenshaDaicho.get住所地特例適用事由コード(),
                    hihokenshaDaicho.get解除年月日(), hihokenshaDaicho.get解除届出年月日(), hihokenshaDaicho.get住所地特例解除事由コード());
        }
    }
}
