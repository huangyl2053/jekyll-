/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA2030011;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaicho.HihokenshaShutokuJyoho;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2030011.DBA2030011StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2030011.DBA2030011TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2030011.JushotiTokureiIdouDiv;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dba.service.core.jushotitokureiidou.JushotiTokureiIdouFinder;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
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
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 被保険者台帳管理（住所地特例異動）クラスです。
 *
 * @reamsid_L DBA-1380-010 lijia
 */
public class JushotiTokureiIdou {

    private static final RString 住所地特例モード = new RString("teiseitoroku_jyusyoti");
    private static final RString 適用モード = new RString("tekiyo");
    private static final RString 解除モード = new RString("kaijo");
    private static final RString 照会モード = new RString("shokai");
    private static final RString 表示モード = new RString("資格異動");
    private static final RString 表示幅モード = new RString("モード1");
    private static final RString 明細表示モード = new RString("追加_修正");
    private static final RString 利用モード = new RString("被保険者対象機能");
    private static final RString DBAMN25001_届出により適用 = new RString("DBAMN25001");
    private static final RString DBAMN25002_届出により解除 = new RString("DBAMN25002");
    private static final LockingKey 前排他ロックキー = new LockingKey("ShikakuJutokuTekiyo、HihokenshaNo");
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
        }
        if (DBAMN25002_届出により解除.equals(UrControlDataFactory.createInstance().getMenuID())) {
            div.getCcdHihosyosai().住所地特例表示タイプ(解除モード);
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
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getCcdHihosyosai().施設入退所保存処理();
            if (DBAMN25001_届出により適用.equals(UrControlDataFactory.createInstance().getMenuID())) {
                適用情報の保存(div);
                div.getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                        .replace("資格適用処理").evaluate()), RString.EMPTY, RString.EMPTY, true);
            }
            if (DBAMN25002_届出により解除.equals(UrControlDataFactory.createInstance().getMenuID())) {
                解除情報の保存(div);
                div.getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                        .replace("資格解除処理").evaluate()), RString.EMPTY, RString.EMPTY, true);
            }
        }

        return ResponseData.of(div).setState(DBA2030011StateName.完了状態);
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
}
