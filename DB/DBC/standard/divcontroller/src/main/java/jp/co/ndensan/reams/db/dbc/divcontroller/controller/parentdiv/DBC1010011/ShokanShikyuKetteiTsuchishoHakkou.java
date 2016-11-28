/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1010011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.core.shokanshikyuketteitsuchishohakkou.ShokanShikyuKetteiTsuchishoHakkouBusiness;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1010011.DBC1010011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1010011.ShokanShikyuKetteiTsuchishoHakkouDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1010011.ShokanShikyuKetteiTsuchishoHakkouHandler;
import jp.co.ndensan.reams.db.dbc.service.core.shokanshikyuketteitsuchishohakkou.ShokanShikyuKetteiTsuchishoHakkouFinder;
import jp.co.ndensan.reams.db.dbc.service.core.shoukanbaraishikyuketteitsuchisho.ShoukanbaraiShikyuKetteiTsuchisho;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekkaBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.sashitome.ShiharaiHohoHenkoSashitome;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.service.core.basic.ShokanHanteiKekkaManager;
import jp.co.ndensan.reams.db.dbd.service.core.basic.ShokanShinseiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * 償還払い支給（不支給）決定通知書作成（単）のDivControllerです。
 *
 * @reamsid_L DBC-5310-010 liuyl
 */
public class ShokanShikyuKetteiTsuchishoHakkou {

    private static final RString 発行する = new RString("btnReportPublish");

    /**
     * 初期化。
     *
     * @param div ShokanShikyuKetteiTsuchishoHakkouDiv
     * @return ResponseData<ShokanShikyuKetteiTsuchishoHakkouDiv>
     */
    public ResponseData<ShokanShikyuKetteiTsuchishoHakkouDiv> onLoad(ShokanShikyuKetteiTsuchishoHakkouDiv div) {
        if (ResponseHolder.isReRequest()
                && new RString(DbcInformationMessages.被保険者でないデータ
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (資格対象者 == null || 資格対象者.get被保険者番号() == null
                || 資格対象者.get被保険者番号().isEmpty() && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbcInformationMessages.被保険者でないデータ.getMessage()).respond();
        }
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ShikibetsuCode shikibetsuCode = 資格対象者.get識別コード();
        ViewStateHolder.put(ViewStateKeys.識別コード, shikibetsuCode);
        ShokanShikyuKetteiTsuchishoHakkouFinder finder = ShokanShikyuKetteiTsuchishoHakkouFinder.createInstance();
        List<ShokanShikyuKetteiTsuchishoHakkouBusiness> 償還払支給判定結果List = finder.get償還払支給判定結果(被保険者番号);
        ArrayList<ShokanShikyuKetteiTsuchishoHakkouBusiness> 判定結果List = new ArrayList<>(償還払支給判定結果List);
        ViewStateHolder.put(ViewStateKeys.償還払支給判定結果, 判定結果List);
        List<JukyushaDaicho> 受給者台帳List = finder.get受給者台帳(被保険者番号);
        List<SogoJigyoTaishosha> 総合事業対象者List = finder.get総合事業対象者(被保険者番号);
        List<ShokanHanteiKekka> 償還払支給判定結果 = finder.select償還払支給判定結果(被保険者番号);
        if (!ResponseHolder.isReRequest() && (受給者台帳List.isEmpty() && 総合事業対象者List.isEmpty())) {
            throw new ApplicationException(DbdErrorMessages.受給共通_受給者_事業対象者登録なし.getMessage());
        }
        if (!ResponseHolder.isReRequest() && 償還払支給判定結果.isEmpty()) {
            throw new ApplicationException(DbcErrorMessages.償還決定データなし.getMessage());
        }
        getHandler(div).onLoad(shikibetsuCode, 被保険者番号, 償還払支給判定結果List, 受給者台帳List, 総合事業対象者List, 償還払支給判定結果);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(発行する, false);
        return ResponseData.of(div).setState(DBC1010011StateName.支給決定通知書発行);
    }

    /**
     * サービス提供年月を変更。
     *
     * @param div ShokanShikyuKetteiTsuchishoHakkouDiv
     * @return ResponseData<ShokanShikyuKetteiTsuchishoHakkouDiv>
     */
    public ResponseData<ShokanShikyuKetteiTsuchishoHakkouDiv> onChange_ServiceTeikyo(ShokanShikyuKetteiTsuchishoHakkouDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        List<ShokanShikyuKetteiTsuchishoHakkouBusiness> 償還払支給判定結果List = ViewStateHolder.get(ViewStateKeys.償還払支給判定結果, List.class);
        getHandler(div).onChange_ServiceTeikyo(被保険者番号, 償還払支給判定結果List);
        return ResponseData.of(div).respond();
    }

    /**
     * 整理番号を変更。
     *
     * @param div ShokanShikyuKetteiTsuchishoHakkouDiv
     * @return ResponseData<ShokanShikyuKetteiTsuchishoHakkouDiv>
     */
    public ResponseData<ShokanShikyuKetteiTsuchishoHakkouDiv> onChange_SeiriNO(ShokanShikyuKetteiTsuchishoHakkouDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        List<ShokanShikyuKetteiTsuchishoHakkouBusiness> 償還払支給判定結果List = ViewStateHolder.get(ViewStateKeys.償還払支給判定結果, List.class);
        getHandler(div).onChange_SeiriNO(被保険者番号, 償還払支給判定結果List);
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行する」の前処理です。
     *
     * @param div ShokanShikyuKetteiTsuchishoHakkouDiv
     * @return ResponseData<ShokanShikyuKetteiTsuchishoHakkouDiv>
     */
    public ResponseData<ShokanShikyuKetteiTsuchishoHakkouDiv> beforePublish(ShokanShikyuKetteiTsuchishoHakkouDiv div) {
        ShikibetsuCode shikibetsuCode = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShokanHanteiKekkaManager shokanHanteiKekkaManager = new ShokanHanteiKekkaManager();
        ChohyoSeigyoHanyoManager manager = ChohyoSeigyoHanyoManager.createInstance();
        List<ShokanShikyuKetteiTsuchishoHakkouBusiness> 償還払支給判定結果List = ViewStateHolder.get(ViewStateKeys.償還払支給判定結果, List.class);
        ShokanHanteiKekka shokanHanteiKekka = getHandler(div).get償還払支給判定結果(償還払支給判定結果List, new FlexibleYearMonth(div.
                getDdlServiceTeikyoYM().getSelectedKey()), div.getDdlSeiriNO().getSelectedValue());
        ShokanHanteiKekkaBuilder buidler = shokanHanteiKekka.createBuilderForEdit();
        ChohyoSeigyoHanyo 帳票制御汎用 = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.
                getReportId(), new RString("支払予定日印字有無"));
        ViewStateHolder.put(ViewStateKeys.帳票制御汎用メンテナンスGrid, 帳票制御汎用);
        if (帳票制御汎用.get設定値().equals(new RString("1")) && div.getShokanShikyuKetteiTsuchishoHakkouPrint().
                getTxtShiharaiYoteiYMD().getValue() == null && !ResponseHolder.isReRequest()) {
            WarningMessage message = new WarningMessage(
                    UrWarningMessages.未入力.getMessage().getCode(),
                    UrWarningMessages.未入力.getMessage().replace("支払予定日").evaluate(),
                    ButtonSelectPattern.OKCancel);
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrWarningMessages.未入力.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        if (div.getShokanShikyuKetteiTsuchishoHakkouPrint().getTxtZenkaiHakkoYMD().getValue() != null && !ResponseHolder.isReRequest()) {
            WarningMessage message = new WarningMessage(
                    DbcWarningMessages.高額合算支給決定通知書発行済.getMessage().getCode(),
                    DbcWarningMessages.高額合算支給決定通知書発行済.getMessage().evaluate(),
                    ButtonSelectPattern.OKCancel);
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(DbcWarningMessages.高額合算支給決定通知書発行済.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        ShoukanbaraiShikyuKetteiTsuchisho shoukanFinder = ShoukanbaraiShikyuKetteiTsuchisho.createInstance();
        HihokenshaDaicho 被保険者情報 = shoukanFinder.getShikaku(被保険者番号);
        if (被保険者情報 != null) {
            if (被保険者情報.get被保険者区分コード().equals(ShikakuKubun._２号.getコード()) && !ResponseHolder.isReRequest()) {
                WarningMessage message = new WarningMessage(
                        DbcWarningMessages.二号滞納状況確認.getMessage().getCode(),
                        DbcWarningMessages.二号滞納状況確認.getMessage().evaluate(),
                        ButtonSelectPattern.OKCancel);
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbcWarningMessages.二号滞納状況確認.getMessage().getCode()).equals(
                    ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        ShiharaiHohoHenkoSashitome 支払方法変更差止 = shoukanFinder.getSashitome(被保険者番号, new FlexibleYearMonth(div.
                getDdlServiceTeikyoYM().getSelectedKey()), div.getDdlSeiriNO().getSelectedValue());
        RString 差額支給対象者区分 = RString.EMPTY;
        差額支給対象者区分 = getHandler(div).check(支払方法変更差止, 差額支給対象者区分, shokanHanteiKekka);
        ViewStateHolder.put(ViewStateKeys.資料作成, 差額支給対象者区分);
        buidler.set決定通知書作成年月日(new FlexibleDate(div.getTxtHakkouYMD().getValue().
                toDateString())).set決定通知リアル発行区分(new RString("1"));
        shokanHanteiKekkaManager.save償還払支給判定結果(buidler.build());
        getHandler(div).前排他キーの解除(被保険者番号);
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                被保険者番号.value());
        AccessLogger.log(AccessLogType.更新, PersonalData.withHojinNo(shikibetsuCode, expandedInfo));
        return ResponseData.of(div).respond();
    }

    /**
     * 帳票を出力する。
     *
     * @param div ShokanShikyuKetteiTsuchishoHakkouDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(ShokanShikyuKetteiTsuchishoHakkouDiv div) {
        ChohyoSeigyoHanyo 帳票制御汎用 = ViewStateHolder.get(ViewStateKeys.帳票制御汎用メンテナンスGrid, ChohyoSeigyoHanyo.class);
        RString 差額支給対象者区分 = ViewStateHolder.get(ViewStateKeys.資料作成, RString.class);
        ShikibetsuCode shikibetsuCode = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShokanShinseiManager shokanShinseiManager = new ShokanShinseiManager();
        ShokanShinsei shokanShinsei = shokanShinseiManager.get償還払支給申請(被保険者番号, new FlexibleYearMonth(div.
                getDdlServiceTeikyoYM().getSelectedKey()), div.getDdlSeiriNO().getSelectedValue());
        ShoukanbaraiShikyuKetteiTsuchisho manage = ShoukanbaraiShikyuKetteiTsuchisho.createInstance();
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                被保険者番号.value());
        AccessLogger.log(AccessLogType.照会, PersonalData.withHojinNo(shikibetsuCode, expandedInfo));
        return ResponseData.of(getHandler(div).to帳票発行処理(shokanShinsei.get口座ID(), manage, shikibetsuCode,
                被保険者番号, 帳票制御汎用, 差額支給対象者区分)).respond();
    }

    /**
     * 「発行する」の後の処理。
     *
     * @param div ShokanShikyuKetteiTsuchishoHakkouDiv
     * @return ResponseData<ShokanShikyuKetteiTsuchishoHakkouDiv>
     */
    public ResponseData<ShokanShikyuKetteiTsuchishoHakkouDiv> afterPublish(ShokanShikyuKetteiTsuchishoHakkouDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        div.getCcdKanryoMessage().setMessage(new RString("償還払支給決定通知書の発行が完了しました。"),
                被保険者番号.value(), div.getShokanShikyuKetteiTsuchishoHakkouKihon().get氏名漢字(), true);
        div.getDdlSeiriNO().setVisible(false);
        div.getDdlServiceTeikyoYM().setVisible(false);
        return ResponseData.of(div).setState(DBC1010011StateName.完了メッセージ);
    }

    private ShokanShikyuKetteiTsuchishoHakkouHandler getHandler(ShokanShikyuKetteiTsuchishoHakkouDiv div) {
        return new ShokanShikyuKetteiTsuchishoHakkouHandler(div);
    }
}
