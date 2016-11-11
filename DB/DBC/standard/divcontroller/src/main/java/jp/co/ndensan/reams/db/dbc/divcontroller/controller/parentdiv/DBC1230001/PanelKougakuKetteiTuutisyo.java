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
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
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
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 新総合事業・事業高額決定通知書（単）クラスです。
 *
 * @reamsid_L DBC-4760-010 yebangqiang
 */
public class PanelKougakuKetteiTuutisyo {

    private static final RString 支払予定日 = new RString("支払予定日");
    private static final RString 排他キー = new RString("DBCHihokenshaNo");
    private static final RString 発行ボタン = new RString("btnHakkou");

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
        CommonButtonHolder.setDisabledByCommonButtonFieldName(発行ボタン, false);
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        LasdecCode 市町村コード = null;
        if (shichosonSecurityJoho != null && shichosonSecurityJoho.get市町村情報() != null) {
            市町村コード = shichosonSecurityJoho.get市町村情報().get市町村コード();
        }
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
        FlexibleYearMonth サービス提供年月 = div.getDdlServiceYearMonth().getSelectedValue().isEmpty()
                ? FlexibleYearMonth.EMPTY
                : new FlexibleYearMonth(new RDate(div.getDdlServiceYearMonth().getSelectedValue().toString()).getYearMonth().toString());
        getHandler(div).管理番号と前回発行日の設定(キー.get被保険者番号(), サービス提供年月);
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
        FlexibleYearMonth サービス提供年月 = div.getDdlServiceYearMonth().getSelectedValue().isEmpty()
                ? FlexibleYearMonth.EMPTY
                : new FlexibleYearMonth(new RDate(div.getDdlServiceYearMonth().getSelectedValue().toString()).getYearMonth().toString());
        Decimal 管理番号 = div.getDdlKanliBanngou().getSelectedValue().isEmpty() ? Decimal.ZERO
                : new Decimal(div.getDdlKanliBanngou().getSelectedValue().toString());
        getHandler(div).前回発行日の設定(キー.get被保険者番号(), サービス提供年月, 管理番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 発行可否をチェックするメソッドです。
     *
     * @param div 画面div
     * @return 画面初期化
     */
    public ResponseData<PanelKougakuKetteiTuutisyoDiv> onClick_btnHakkouValidate(PanelKougakuKetteiTuutisyoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            if (div.getTxtSiharaiYoteibi().isVisible()
                    && div.getTxtSiharaiYoteibi().getValue() == null) {
                WarningMessage message = new WarningMessage(
                        UrWarningMessages.未入力.getMessage().getCode(),
                        UrWarningMessages.未入力.getMessage().replace(支払予定日.toString()).evaluate(),
                        ButtonSelectPattern.OKCancel);
                return ResponseData.of(div).addMessage(message).respond();
            } else if (div.getTxtZennkaiHakkoubi().getValue() != null) {
                WarningMessage message = new WarningMessage(
                        DbcWarningMessages.発行済み負担額証明書.getMessage().getCode(),
                        DbcWarningMessages.発行済み負担額証明書.getMessage().evaluate(),
                        ButtonSelectPattern.OKCancel);
                return ResponseData.of(div).addMessage(message).respond();
            } else if (div.getTxtZennkaiHakkoubi().getValue() == null) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                        UrQuestionMessages.処理実行の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (new RString(UrWarningMessages.未入力.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && div.getTxtZennkaiHakkoubi().getValue() != null) {
            WarningMessage message = new WarningMessage(
                    DbcWarningMessages.発行済み負担額証明書.getMessage().getCode(),
                    DbcWarningMessages.発行済み負担額証明書.getMessage().evaluate(),
                    ButtonSelectPattern.OKCancel);
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(UrWarningMessages.未入力.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && div.getTxtZennkaiHakkoubi().getValue() == null) {
            QuestionMessage message = new QuestionMessage(
                    UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate(),
                    ButtonSelectPattern.OKCancel);
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(DbcWarningMessages.発行済み負担額証明書.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).cancelPublish().respond();
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
        TaishoshaKey キー = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        List<FlexibleYearMonth> サービス提供年月リスト = getHandler(div).getサービス提供年月リスト(キー.get被保険者番号());
        boolean isデータの変更 = getHandler(div).isデータの変更(キー.get被保険者番号(), サービス提供年月リスト);
        if (!ResponseHolder.isReRequest() && isデータの変更) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if ((new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)
                || !isデータの変更) {
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
        TaishoshaKey キー = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        List<FlexibleYearMonth> サービス提供年月リスト = getHandler(div).getサービス提供年月リスト(キー.get被保険者番号());
        boolean isデータの変更 = getHandler(div).isデータの変更(キー.get被保険者番号(), サービス提供年月リスト);
        if (!ResponseHolder.isReRequest() && isデータの変更) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if ((new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)
                || !isデータの変更) {
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
