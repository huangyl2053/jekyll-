/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1230001;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230001.DBC1230001TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230001.PanelKougakuKetteiTuutisyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1230001.PanelKougakuKetteiTuutisyoHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 新総合事業・事業高額決定通知書（単）クラスです。
 *
 * @reamsid_L DBC-4760-010 yebangqiang
 */
public class PanelKougakuKetteiTuutisyo {

    private static final RString 支払予定日印字有無_有 = new RString("1");
    private static final RString 支払予定日 = new RString("支払予定日");
    private static final RString 排他キー = new RString("DBCHihokenshaNo");

    /**
     * 画面ロードメソッドです。
     *
     * @param div 画面div
     * @return 画面初期化
     */
    public ResponseData<PanelKougakuKetteiTuutisyoDiv> onLoad(PanelKougakuKetteiTuutisyoDiv div) {
        TaishoshaKey キー = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (キー == null || キー.get被保険者番号() == null) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        List<FlexibleYearMonth> サービス提供年月リスト = getHandler(div).getサービス提供年月リスト(キー.get被保険者番号());
        if (サービス提供年月リスト.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        // QAのNo.1437
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        LasdecCode 市町村コード = 地方公共団体.getLasdecCode_();
        getHandler(div).画面初期化(キー.get識別コード(), 市町村コード, キー.get被保険者番号(), サービス提供年月リスト);
        return ResponseData.of(div).respond();
    }

    /**
     * サービス提供年月ドロップダウンリストの選択値より、管理番号リストの内容を変更するメソッドです。
     *
     * @param div 画面div
     * @return 画面初期化
     */
    public ResponseData<PanelKougakuKetteiTuutisyoDiv> onChange_ddlServiceYearMonth(PanelKougakuKetteiTuutisyoDiv div) {
        TaishoshaKey キー = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        getHandler(div).管理番号と前回発行日の設定(キー.get被保険者番号(),
                new FlexibleYearMonth(new RDate(div.getDdlServiceYearMonth().getSelectedValue().toString()).getYearMonth().toString()));
        return ResponseData.of(div).respond();
    }

    /**
     * 管理番号ドロップダウンリストの選択値より、前回発行日の内容を変更するメソッドです。
     *
     * @param div 画面div
     * @return 画面初期化
     */
    public ResponseData<PanelKougakuKetteiTuutisyoDiv> onChange_ddlKanliBanngou(PanelKougakuKetteiTuutisyoDiv div) {
        TaishoshaKey キー = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        getHandler(div).前回発行日の設定(キー.get被保険者番号(),
                new FlexibleYearMonth(new RDate(div.getDdlServiceYearMonth().getSelectedValue().toString()).getYearMonth().toString()),
                new Decimal(div.getDdlKanliBanngou().getSelectedValue().toString()));
        return ResponseData.of(div).respond();
    }

    /**
     * 発行可否をチェックするメソッドです。
     *
     * @param div 画面div
     * @return 画面初期化
     */
    public ResponseData<PanelKougakuKetteiTuutisyoDiv> onClick_btnHakkouValidate(PanelKougakuKetteiTuutisyoDiv div) {
        RString 支払予定日印字有無 = DbBusinessConfig.get(ConfigNameDBC.事業高額決定通知書_支払予定日印字有無,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (!ResponseHolder.isReRequest() && 支払予定日印字有無_有.equals(支払予定日印字有無)
                && div.getTxtSiharaiYoteibi().getValue() == null) {
            QuestionMessage message = new QuestionMessage(
                    UrWarningMessages.未入力.getMessage().getCode(),
                    UrWarningMessages.未入力.getMessage().evaluate()).replace(支払予定日.toString());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrWarningMessages.未入力.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes && div.getTxtZennkaiHakkoubi().getValue() != null) {
            QuestionMessage message = new QuestionMessage(
                    DbcWarningMessages.発行済み負担額証明書.getMessage().getCode(),
                    DbcWarningMessages.発行済み負担額証明書.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(DbcWarningMessages.発行済み負担額証明書.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 帳票発行するメソッドです。
     *
     * @param div 画面div
     * @return 画面初期化
     */
    public ResponseData<SourceDataCollection> onClick_btnHakkou(PanelKougakuKetteiTuutisyoDiv div) {
        RString 支払予定日印字有無 = DbBusinessConfig.get(ConfigNameDBC.事業高額決定通知書_支払予定日印字有無,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        TaishoshaKey キー = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        return ResponseData.of(getHandler(div).帳票印刷(キー.get被保険者番号(), キー.get識別コード(), 支払予定日印字有無)).respond();
    }

    /**
     * 発行可否をチェックするメソッドです。
     *
     * @param div 画面div
     * @return 画面初期化
     */
    public ResponseData<PanelKougakuKetteiTuutisyoDiv> onClick_btnHakkouAfter(PanelKougakuKetteiTuutisyoDiv div) {
        TaishoshaKey キー = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        getHandler(div).after帳票印刷(キー.get被保険者番号(), キー.get識別コード());
        return ResponseData.of(div).respond();
    }

    /**
     * 再検索するメソッドです。
     *
     * @param div 画面div
     * @return 画面初期化
     */
    public ResponseData<PanelKougakuKetteiTuutisyoDiv> onClick_btnReSearch(PanelKougakuKetteiTuutisyoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            LockingKey key = new LockingKey(排他キー);
            RealInitialLocker.release(key);
            return ResponseData.of(div).forwardWithEventName(DBC1230001TransitionEventName.再検索).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 対象者検索へ戻るメソッドです。
     *
     * @param div 画面div
     * @return 画面初期化
     */
    public ResponseData<PanelKougakuKetteiTuutisyoDiv> onClick_btnResearchResult(PanelKougakuKetteiTuutisyoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            LockingKey key = new LockingKey(排他キー);
            RealInitialLocker.release(key);
            return ResponseData.of(div).forwardWithEventName(DBC1230001TransitionEventName.対象者検索へ戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    private PanelKougakuKetteiTuutisyoHandler getHandler(PanelKougakuKetteiTuutisyoDiv div) {
        return PanelKougakuKetteiTuutisyoHandler.of(div);
    }

}
