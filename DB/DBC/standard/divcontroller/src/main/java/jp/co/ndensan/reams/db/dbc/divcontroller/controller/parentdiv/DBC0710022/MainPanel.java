/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJohoDiv;
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0710022;

import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraikettejoho.KetteJoho;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJoho.ShokanbaraiketteiJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710022.DBC0710022StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710022.DBC0710022TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710022.MainPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0710022.MainPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710021.ShokanharaKeteiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710022.ShoukanFutsuKetteiJouhouTourokuParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMN52002_住宅改修費支給申請_償還払決定情報登録
 *
 * @reamsid_L DBC-0992-110 yangchenbing
 */
public class MainPanel {

    private static final RString 修正 = new RString("修正モード");
    private static final RString 照会 = new RString("照会モード");
    private static final RString モード_修正 = new RString("修正");
    private static final RString モード_照会 = new RString("照会");
    private static final RString 画面モード_登録 = new RString("登録モード");
    private static final RString 業務区分 = new RString("01");
    private static final RString MSG_決定日 = new RString("決定日");
    private static final RString MSG_理由 = new RString("不支給理由等");
    private static final RString 被保険者番号KEY = new RString("DBCHihokenshaNo");

    /**
     * 住宅改修費支給申請_償還払決定情報登録のonLoad
     *
     * @param div 画面DIV
     * @return 住宅改修費支給申請_償還払決定情報登録
     */
    public ResponseData<MainPanelDiv> onLoad(MainPanelDiv div) {

        ShokanharaKeteiJyohoParameter parameter = ViewStateHolder.get(ViewStateKeys.検索キー,
                ShokanharaKeteiJyohoParameter.class);
        ShikibetsuCode 識別コード = parameter.get識別コード();
        FlexibleYearMonth サービス年月 = parameter.getサービス提供年月();
        HihokenshaNo 被保険者番号 = parameter.get被保険者番号();
        RString 整理番号 = parameter.get整理番号();
        Decimal 給付率 = parameter.get給付率();
        RString 証明書 = parameter.get証明書();
        RString 画面モード = parameter.get画面モード();
        div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoAtenaInfo().initialize(識別コード);
        div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoShikakuKihon().initialize(被保険者番号);

        getHandler(div).set初期化(証明書, 整理番号, サービス年月, 給付率);
        RString 元画面モード = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);
        if (!照会.equals(元画面モード)) {
            LockingKey 排他キー = new LockingKey(被保険者番号KEY.concat(被保険者番号.getColumnValue()));
            if (!RealInitialLocker.tryGetLock(排他キー)) {
                throw new PessimisticLockingException();
            }
        }
        if (修正.equals(画面モード)) {
            if (画面モード_登録.equals(元画面モード)) {
                div.getBtnShinseiJyoho().setDisabled(true);
            }
            div.getJutakuKaishuShinseiInfoPanel().getShokanbaraiKetteiJyohoPanel().getCcdShokanbaraiketteiJoho().
                    loadInitialize(被保険者番号, サービス年月, 整理番号, 業務区分, モード_修正);
        } else {
            if (!照会.equals(元画面モード)) {
                div.getBtnShinseiJyoho().setDisabled(true);
            } else {
                div.getBtnShinseiJyoho().setDisabled(false);
            }
            div.getJutakuKaishuShinseiInfoPanel().getShokanbaraiKetteiJyohoPanel().getCcdShokanbaraiketteiJoho().
                    loadInitialize(被保険者番号, サービス年月, 整理番号, 業務区分, モード_照会);
        }

        ShoukanFutsuKetteiJouhouTourokuParameter 画面データ = getHandler(div).set画面データ();
        ViewStateHolder.put(ViewStateKeys.画面データ, 画面データ);
        return ResponseData.of(div).respond();
    }

    /**
     * 住宅改修費支給申請_償還払決定情報登録の申請情報
     *
     * @param div 画面DIV
     * @return 住宅改修費支給申請_申請情報登録画面へ遷移
     */
    public ResponseData<MainPanelDiv> onClick_btnShinseiJyoho(MainPanelDiv div) {
        ShokanharaKeteiJyohoParameter parameter = ViewStateHolder.get(ViewStateKeys.検索キー,
                ShokanharaKeteiJyohoParameter.class);
        if (修正.equals(parameter.get画面モード())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                ViewStateHolder.put(ViewStateKeys.識別コード, parameter.get識別コード());
                ViewStateHolder.put(ViewStateKeys.サービス提供年月, new FlexibleYearMonth(parameter.getサービス提供年月().toDateString()));
                ViewStateHolder.put(ViewStateKeys.被保険者番号, parameter.get被保険者番号());
                ViewStateHolder.put(ViewStateKeys.整理番号, parameter.get整理番号());
                ViewStateHolder.put(ViewStateKeys.画面モード, parameter.get画面モード());
                排他キーRelease(parameter.get被保険者番号().getColumnValue());
                return ResponseData.of(div).forwardWithEventName(DBC0710022TransitionEventName.申請情報).parameter(画面モード_登録);
            }
        } else {
            ViewStateHolder.put(ViewStateKeys.識別コード, parameter.get識別コード());
            ViewStateHolder.put(ViewStateKeys.サービス提供年月, new FlexibleYearMonth(parameter.getサービス提供年月().toDateString()));
            ViewStateHolder.put(ViewStateKeys.被保険者番号, parameter.get被保険者番号());
            ViewStateHolder.put(ViewStateKeys.整理番号, parameter.get整理番号());
            ViewStateHolder.put(ViewStateKeys.画面モード, parameter.get画面モード());
            排他キーRelease(parameter.get被保険者番号().getColumnValue());
            return ResponseData.of(div).forwardWithEventName(DBC0710022TransitionEventName.申請情報).respond();
        }
        return ResponseData.of(div).respond();
    }

    private void 排他キーRelease(RString 被保険者番号) {
        RString 元画面モード = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);
        if (!照会.equals(元画面モード)) {
            LockingKey 排他キー = new LockingKey(被保険者番号KEY.concat(被保険者番号));
            RealInitialLocker.release(排他キー);
        }
    }

    private MainPanelHandler getHandler(MainPanelDiv div) {
        return MainPanelHandler.of(div);
    }

    /**
     * 住宅改修費支給申請_償還払決定情報登録の申請を保存する
     *
     * @param div 画面DIV
     * @return 完了
     */
    public ResponseData<MainPanelDiv> onClick_btnAddShikyuShinsei(MainPanelDiv div) {
        ShokanbaraiketteiJohoDiv shokanbaraiketteiJohoDiv = (ShokanbaraiketteiJohoDiv) div.getJutakuKaishuShinseiInfoPanel()
                .getShokanbaraiKetteiJyohoPanel().getCcdShokanbaraiketteiJoho();
        if (shokanbaraiketteiJohoDiv.getTxtKetebi().getValue() == null) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(MSG_決定日.toString()));
        }
        if (ShikyuFushikyuKubun.不支給.getコード().equals(shokanbaraiketteiJohoDiv.getRdoShikyukubun().getSelectedKey())
                && RString.isNullOrEmpty(shokanbaraiketteiJohoDiv.getTxtFuSyikyuriyu1().getValue())) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(MSG_理由.toString()));
        }
        ShoukanFutsuKetteiJouhouTourokuParameter parameter = ViewStateHolder.get(
                ViewStateKeys.画面データ, ShoukanFutsuKetteiJouhouTourokuParameter.class);
        boolean flag = getHandler(div).is内容変更状態(parameter);

        KetteJoho 決定情報 = ViewStateHolder.get(ViewStateKeys.決定情報, KetteJoho.class);

        if (flag || 決定情報 == null) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                RString 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class).value();
                RString 氏名漢字 = div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoAtenaInfo().get氏名漢字();
                ShokanharaKeteiJyohoParameter 検索情報キー = ViewStateHolder.get(ViewStateKeys.検索キー,
                        ShokanharaKeteiJyohoParameter.class);
                getHandler(div).保存処理(検索情報キー);
                排他キーRelease(被保険者番号);
                div.getJutakuShikyuShinseiKanryoPanel().getKanryoMessage().setMessage(UrInformationMessages.保存終了,
                        被保険者番号, 氏名漢字, true);
                return ResponseData.of(div).setState(DBC0710022StateName.KanryoMessage);
            }
        } else {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
            }
            if (new RString(DbzInformationMessages.内容変更なしで保存不可.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「戻る」ボタンのメソッドです。
     *
     * @param div 画面DIV
     * @return 住宅改修費支給申請_償還払決定情報登録
     */
    public ResponseData<MainPanelDiv> onClick_btnBack(MainPanelDiv div) {
        ShokanharaKeteiJyohoParameter parameter = ViewStateHolder.get(ViewStateKeys.検索キー,
                ShokanharaKeteiJyohoParameter.class);
        排他キーRelease(parameter.get被保険者番号().getColumnValue());
        return ResponseData.of(div).forwardWithEventName(DBC0710022TransitionEventName.戻る).respond();
    }
}
