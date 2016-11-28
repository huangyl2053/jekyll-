/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0500011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0500011.DBC0500011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0500011.KougakuKetteiTuutisyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0500011.KougakuKetteiTuutisyoHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.SogoJigyoTaishoshaManager;
import jp.co.ndensan.reams.db.dbc.service.core.kogakuservicehiketteitsuchishotan.KogakuServicehiKetteiTsuchishoTan;
import jp.co.ndensan.reams.db.dbc.service.core.kougakuketteituutisyo.KougakuKetteiTuutisyoManager;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.core.basic.JukyushaDaichoManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMN43005_高額サービス費支給決定通知書（単）のクラスです。
 *
 * @reamsid_L DBC-5160-010 chenxin
 */
public class KougakuKetteiTuutisyo {

    private TaishoshaKey key;
    private static final RString BUTTON_NAME = new RString("btnHakkou");

    /**
     * 画面初期化のメソッドです。
     *
     * @param div KougakuKetteiTuutisyoDiv
     * @return ResponseData<KougakuKetteiTuutisyoDiv>
     */
    public ResponseData<KougakuKetteiTuutisyoDiv> onLoad(KougakuKetteiTuutisyoDiv div) {
        key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (!ResponseHolder.isReRequest()
                && (key.get被保険者番号() == null || key.get被保険者番号().isEmpty())) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(BUTTON_NAME, true);
            return ResponseData.of(div).addMessage(UrErrorMessages.該当データなし.getMessage()).respond();
        }
        HihokenshaNo 被保険者番号 = key.get被保険者番号();
        List<JukyushaDaicho> 受給者台帳 = new JukyushaDaichoManager().get受給者台帳情報(被保険者番号);
        List<SogoJigyoTaishosha> 総合事業対象者 = new SogoJigyoTaishoshaManager().get総合事業対象者(被保険者番号);
        if (受給者台帳.isEmpty() || 総合事業対象者.isEmpty()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(BUTTON_NAME, true);
            return ResponseData.of(div).addMessage(DbdErrorMessages.受給共通_受給者_事業対象者登録なし.getMessage()).respond();
        }
        KougakuKetteiTuutisyoManager manager = KougakuKetteiTuutisyoManager.createInstance();
        List<FlexibleYearMonth> サービス提供年月リスト = manager.getサービス提供年月(key.get被保険者番号());
        if (サービス提供年月リスト.isEmpty()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(BUTTON_NAME, true);
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        } else {
            div.getKyoTuuKaigoAtena().initialize(key.get識別コード());
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            LasdecCode 市町村コード = 地方公共団体.getLasdecCode_();
            div.getKyoTuuKaigoNinnteiSikaku().initialize(市町村コード.value(), key.get被保険者番号().value());
            div.getKougakuKetteiTuutisyoBunsho().initialize(ReportIdDBC.DBC100007.getReportId(), FlexibleDate.getNowDate());
            div.getDdlServiceYearMonth().setDataSource(getHandler().onLoad_ddlServiceYearMonth(サービス提供年月リスト));
            div.getDdlServiceYearMonth().setSelectedIndex(0);
            div.getDdlKanliBanngou().setDataSource(getHandler().onLoad_ddlKanliBanngou(div, key.get被保険者番号()));
            div.getDdlKanliBanngou().setSelectedIndex(0);
            getHandler().onLoad_txtZennkaiHakkoubi(div, key.get被保険者番号());
        }
        div.getTxtHakkoubi().setValue(RDate.getNowDate());
        KogakuServicehiKetteiTsuchishoTan manager2 = KogakuServicehiKetteiTsuchishoTan.createInstance();
        ReportId 帳票分類ID = new ReportId("DBC100007_KogakuKetteiTsuchiSho");
        ChohyoSeigyoHanyo 支払予定日印字有無 = manager2.load帳票制御汎用(帳票分類ID, new RString("支払予定日印字有無"));
        if (支払予定日印字有無.get設定値().equals(new RString("1"))) {
            div.getTxtSiharaiYoteibi().setVisible(true);
        }
        PersonalData personalData = PersonalData.of(key.get識別コード(),
                new ExpandedInformation(new Code("003"),
                        new RString("被保険者番号"),
                        key.get被保険者番号().value()));
        AccessLogger.log(AccessLogType.照会, personalData);
        return ResponseData.of(div).respond();
    }

    /**
     * サービス提供年月ドロップダウンリストの選択値より、管理番号リストの内容を変更する。
     *
     * @param div KougakuKetteiTuutisyoDiv
     * @return ResponseData<KougakuKetteiTuutisyoDiv>
     */
    public ResponseData<KougakuKetteiTuutisyoDiv> onChange_ddlServiceYearMonth(KougakuKetteiTuutisyoDiv div) {
        key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        div.getDdlKanliBanngou().setDataSource(getHandler().onLoad_ddlKanliBanngou(div, key.get被保険者番号()));
        div.getDdlKanliBanngou().setSelectedIndex(0);
        getHandler().onLoad_txtZennkaiHakkoubi(div, key.get被保険者番号());
        return ResponseData.of(div).respond();
    }

    /**
     * 管理番号ドロップダウンリストの表示データによって前回作成日も変更する。
     *
     * @param div KougakuKetteiTuutisyoDiv
     * @return ResponseData<KougakuKetteiTuutisyoDiv>
     */
    public ResponseData<KougakuKetteiTuutisyoDiv> onChange_ddlKanliBanngou(KougakuKetteiTuutisyoDiv div) {
        key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        getHandler().onLoad_txtZennkaiHakkoubi(div, key.get被保険者番号());
        return ResponseData.of(div).respond();
    }

    /**
     * 前回作成日に日付が設定されている状態で発行ボタン押下した時、確認メッセージを表示する。
     *
     * @param div KougakuKetteiTuutisyoDiv
     * @return ResponseData<KougakuKetteiTuutisyoDiv>
     */
    public ResponseData<KougakuKetteiTuutisyoDiv> onClick_btnHakkouBefore(KougakuKetteiTuutisyoDiv div) {
        if (!ResponseHolder.isReRequest() && null != div.getTxtZennkaiHakkoubi().getValue()) {
            WarningMessage message = new WarningMessage(
                    DbcWarningMessages.発行済み負担額証明書.getMessage().getCode(),
                    DbcWarningMessages.発行済み負担額証明書.getMessage().evaluate(),
                    ButtonSelectPattern.OKCancel);
            return ResponseData.of(div).addMessage(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 帳票を発行する。
     *
     * @param div KougakuKetteiTuutisyoDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<SourceDataCollection> onClick_btnHakkou(KougakuKetteiTuutisyoDiv div) {
        key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        SourceDataCollection collection = getHandler().帳票印刷(key.get被保険者番号(), key.get識別コード(), div);
        PersonalData personalData = PersonalData.of(key.get識別コード(),
                new ExpandedInformation(new Code("003"),
                        new RString("被保険者番号"),
                        key.get被保険者番号().value()));
        AccessLogger.log(AccessLogType.照会, personalData);
        return ResponseData.of(collection).respond();
    }

    /**
     * DB更新を行う。
     *
     * @param div KougakuKetteiTuutisyoDiv
     * @return ResponseData<KougakuKetteiTuutisyoDiv>
     */
    public ResponseData<KougakuKetteiTuutisyoDiv> onClick_btnHakkouAfter(KougakuKetteiTuutisyoDiv div) {
        key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        getHandler().ＤＢ更新(div, key.get被保険者番号());
        PersonalData personalData = PersonalData.of(key.get識別コード(),
                new ExpandedInformation(new Code("003"),
                        new RString("被保険者番号"),
                        key.get被保険者番号().value()));
        AccessLogger.log(AccessLogType.更新, personalData);
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索結果一覧へ」ボタン押下。
     *
     * @param div KougakuKetteiTuutisyoDiv
     * @return ResponseData<KougakuKetteiTuutisyoDiv>
     */
    public ResponseData<KougakuKetteiTuutisyoDiv> onClick_btnResearchResult(KougakuKetteiTuutisyoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).forwardWithEventName(DBC0500011TransitionEventName.対象者検索へ戻る).respond();
    }

    /**
     * 「再検索する」ボタン押下。
     *
     * @param div KougakuKetteiTuutisyoDiv
     * @return ResponseData<KougakuKetteiTuutisyoDiv>
     */
    public ResponseData<KougakuKetteiTuutisyoDiv> onClick_btnReSearch(KougakuKetteiTuutisyoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).forwardWithEventName(DBC0500011TransitionEventName.再検索).respond();
    }

    private KougakuKetteiTuutisyoHandler getHandler() {
        return new KougakuKetteiTuutisyoHandler();
    }

}
