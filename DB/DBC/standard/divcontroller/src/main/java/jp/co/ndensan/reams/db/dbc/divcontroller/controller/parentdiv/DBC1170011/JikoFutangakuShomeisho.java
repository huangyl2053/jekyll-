/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1170011;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShinseisho;
import jp.co.ndensan.reams.db.dbc.business.core.jikofutangakushomeisho.KogakuGassanShinSeisho;
import jp.co.ndensan.reams.db.dbc.business.kogakugassan.KogakuGassanKey;
import jp.co.ndensan.reams.db.dbc.business.kogakugassan.KogakuGassanNendoKey;
import jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeisho.JikoFutangakushomeishoData;
import jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeishofrom2009.JikoFutangakushomeishoFromData;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jikofutangakushomeisho.JikoFutangakushomeishoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1170011.DBC1170011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1170011.JikoFutangakuShomeishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1170011.JikoFutangakushomeishoHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.jikofutangakushomeisho.JikoFutangakushomeishoManager;
import jp.co.ndensan.reams.db.dbc.service.report.ijikofutangakushomeishoservice.IJikoFutangakushomeisho2009Service;
import jp.co.ndensan.reams.db.dbc.service.report.ijikofutangakushomeishoservice.IJikoFutangakushomeishoService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 自己負担額証明書作成のdivcontrollerクラスです。
 *
 * @reamsid_L DBC-4810-010 yaoyahui
 */
public class JikoFutangakuShomeisho {

    private static final int 年_2008 = 2008;
    private static final int 年_2009 = 2009;
    private static final RString 再計算区分_1 = new RString("1");
    private static final RString メニューID_DBCMN63001 = new RString("DBCMN63001");
    private static final RString 発行 = new RString("btnPublish");
    private static final RString 検索結果一覧に戻る = new RString("btnBack");
    private final RString メニューID = ResponseHolder.getMenuID();

    /**
     * 自己負担額証明書作成画面 初期化を処理します。
     *
     * @param div ShomeishoSakuseiParameterDiv
     * @return 画面
     */
    public ResponseData<JikoFutangakuShomeishoDiv> onLoad(JikoFutangakuShomeishoDiv div) {
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        List<KogakuGassanShinSeisho> 対象者データ = null;
        HihokenshaNo 被保険者番号 = getKey().get被保険者番号();
        if (null == 被保険者番号 || 被保険者番号.isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                InformationMessage informationMessage = new InformationMessage(
                        DbcInformationMessages.被保険者でないデータ.getMessage().getCode(),
                        DbcInformationMessages.被保険者でないデータ.getMessage().evaluate());
                setButtonDisabled(div);
                return ResponseData.of(div).addMessage(informationMessage).respond();
            }
        } else {
            対象者データ = getHandler(div).get対象者データ(メニューID, 被保険者番号);
        }
        InformationMessage message = new InformationMessage(
                DbcInformationMessages.自己負担額データなし.getMessage().getCode(),
                DbcInformationMessages.自己負担額データなし.getMessage().evaluate());
        if (対象者データ == null || 対象者データ.isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                getHandler(div).onLoadhas対象者データ(getKey().get被保険者番号(), getKey().get識別コード());
                setButtonDisabled(div);
                return ResponseData.of(div).addMessage(message).respond();
            }
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(発行, false);
            Map<FlexibleYear, List<KogakuGassanNendoKey>> 年度毎キー = getHandler(div).get高額合算キークラス(対象者データ);
            KogakuGassanKey kogakuGassanKey = new KogakuGassanKey();
            kogakuGassanKey.set年度毎キー(年度毎キー);
            setKey高額合算キークラス(kogakuGassanKey);
            getHandler(div).onLoad(メニューID, システム日付, getKey高額合算キークラス().get年度毎キー(), getKey().get被保険者番号(), getKey().get識別コード());
            FlexibleYear 択された年度 = new FlexibleYear(div.getJikoFutanShomeishoSakuseiPrint().getDdlTaishoNendo().getSelectedKey());
            if (択された年度.getYearValue() <= 年_2008) {
                return ResponseData.of(div).setState(DBC1170011StateName.帳票発行);
            } else if (年_2009 <= 択された年度.getYearValue()) {
                return ResponseData.of(div).setState(DBC1170011StateName.帳票発行2009);
            }
        }
        return ResponseData.of(div).respond();
    }

    private void setButtonDisabled(JikoFutangakuShomeishoDiv div) {
        div.getJikoFutanShomeishoSakuseiPrint().getDdlTaishoNendo().setDisabled(true);
        div.getJikoFutanShomeishoSakuseiPrint().getDdlShikyuShinseishoSeiriNo().setDisabled(true);
        div.getJikoFutanShomeishoSakuseiPrint().getTxtHakkoDate().setDisabled(true);
        div.getJikoFutanShomeishoSakuseiPrint().getCcdBunshoNo().setDisabled(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(発行, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(検索結果一覧に戻る, false);
    }

    /**
     * 対象年度DDL
     *
     * @param div JikoFutangakuShomeishoDiv
     * @return ResponseData<JikoFutangakuShomeishoDiv>
     */
    public ResponseData<JikoFutangakuShomeishoDiv> onChange_taishoNendoDDL(JikoFutangakuShomeishoDiv div) {
        getHandler(div).onChange_taishoNendoDDLSelect(メニューID, getKey高額合算キークラス().get年度毎キー());
        FlexibleYear 択された年度 = new FlexibleYear(div.getJikoFutanShomeishoSakuseiPrint().getDdlTaishoNendo().getSelectedKey());
        if (択された年度.getYearValue() <= 年_2008) {
            return ResponseData.of(div).setState(DBC1170011StateName.帳票発行);
        } else if (年_2009 <= 択された年度.getYearValue()) {
            return ResponseData.of(div).setState(DBC1170011StateName.帳票発行2009);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 支給申請書整理番号DDL
     *
     * @param div JikoFutangakuShomeishoDiv
     * @return ResponseData<JikoFutangakuShomeishoDiv>
     */
    public ResponseData<JikoFutangakuShomeishoDiv> onChange_shikyuShinseishoSeiriNoDDL(JikoFutangakuShomeishoDiv div) {
        getHandler(div).onChange_shikyuShinseishoSeiriNoDDLSelect(getKey高額合算キークラス().get年度毎キー());
        return ResponseData.of(div).respond();
    }

    /**
     * onClickBeforeCheck
     *
     * @param div JikoFutangakuShomeishoDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuShomeishoDiv> onClickBeforeCheck(JikoFutangakuShomeishoDiv div) {
        if (メニューID_DBCMN63001.equals(メニューID)) {
            KogakuGassanShinseisho 再計算区分 = getHandler(div).get再計算区分(getKey().get被保険者番号());
            if (再計算区分 != null && 再計算区分_1.equals(再計算区分.get再計算区分())
                    && !new RString(DbcWarningMessages.高額合算申請書情報の再計算前.getMessage().getCode()).equals(
                            ResponseHolder.getMessageCode())) {
                WarningMessage message = new WarningMessage(
                        DbcWarningMessages.高額合算申請書情報の再計算前.getMessage().getCode(),
                        DbcWarningMessages.高額合算申請書情報の再計算前.getMessage().evaluate(),
                        ButtonSelectPattern.OKCancel);
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        FlexibleDate 前回発行日 = div.getJikoFutanShomeishoSakuseiPrint().getTxtZenkaiHakkoDate().getValue();
        if (!前回発行日.isEmpty()
                && !new RString(DbcWarningMessages.発行済み負担額証明書.getMessage().getCode()).equals(
                        ResponseHolder.getMessageCode())) {
            WarningMessage message = new WarningMessage(
                    DbcWarningMessages.発行済み負担額証明書.getMessage().getCode(),
                    DbcWarningMessages.発行済み負担額証明書.getMessage().evaluate(),
                    ButtonSelectPattern.OKCancel);
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (!ResponseHolder.isReRequest()
                && !new RString(UrQuestionMessages.確認_汎用.getMessage().
                        getCode()).equals(ResponseHolder.getMessageCode())) {
            QuestionMessage message = new QuestionMessage(
                    UrQuestionMessages.確認_汎用.getMessage().getCode(),
                    UrQuestionMessages.確認_汎用.getMessage().replace("自己負担額証明書を発行して").evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「自己負担額証明書を発行する」ボタンを押下します。
     *
     * @param div TajutokuShokaiDiv
     * @return ResponseData<TajutokuShokaiDiv>
     */
    public ResponseData<SourceDataCollection> onClick_HakkouBtn(JikoFutangakuShomeishoDiv div) {
        ResponseData<SourceDataCollection> response = new ResponseData<>();
        try (ReportManager reportManager = new ReportManager()) {
            JikoFutangakushomeishoData data = getHandler(div).get高額合算データ(getKey().get識別コード(), getKey高額合算キークラス().get年度毎キー(), getKey().get被保険者番号(), メニューID);
            AccessLogger.log(AccessLogType.照会, toPersonalData(getKey().get被保険者番号().getColumnValue()));
            printData(data, reportManager);
            JikoFutangakushomeishoManager.createInstance().upDate高額合算情報更新(getParameter(div),
                    div.getJikoFutanShomeishoSakuseiPrint().getTxtHakkoDate().getValue());
            response.data = reportManager.publish();
        }
        return response;
    }

    private JikoFutangakushomeishoParameter getParameter(JikoFutangakuShomeishoDiv div) {
        JikoFutangakushomeishoParameter parameter = new JikoFutangakushomeishoParameter();
        parameter.set被保険者番号(getKey().get被保険者番号().value());
        FlexibleYear 対象年度 = new FlexibleYear(div.getJikoFutanShomeishoSakuseiPrint().getDdlTaishoNendo().getSelectedKey());
        RString 支給申請書整理番号 = div.getJikoFutanShomeishoSakuseiPrint().getDdlShikyuShinseishoSeiriNo().getSelectedKey();
        List<KogakuGassanNendoKey> 高額合算年度キーList = getKey高額合算キークラス().get年度毎キー().get(対象年度);
        for (KogakuGassanNendoKey kogakuGassanNendoKey : 高額合算年度キーList) {
            if (支給申請書整理番号.equals(kogakuGassanNendoKey.get支給申請書整理番号())) {
                parameter.set保険者番号(kogakuGassanNendoKey.get保険者番号().value());
                parameter.set履歴番号(kogakuGassanNendoKey.get履歴番号());
            }
        }
        parameter.set対象年度(対象年度);
        parameter.set支給申請書整理番号(支給申請書整理番号);
        parameter.setメニューID(メニューID);
        parameter.set識別コード(getKey().get識別コード());
        return parameter;
    }

    /**
     * 「自己負担額証明書を発行する(2009)BTN」ボタンを押下します。
     *
     * @param div TajutokuShokaiDiv
     * @return ResponseData<TajutokuShokaiDiv>
     */
    public ResponseData<SourceDataCollection> onClick_youHakkouBtn(JikoFutangakuShomeishoDiv div) {
        ResponseData<SourceDataCollection> response = new ResponseData<>();
        try (ReportManager reportManager = new ReportManager()) {
            JikoFutangakushomeishoData data = getHandler(div).get高額合算データ(getKey().get識別コード(), getKey高額合算キークラス().get年度毎キー(), getKey().get被保険者番号(), メニューID);
            AccessLogger.log(AccessLogType.照会, toPersonalData(getKey().get被保険者番号().getColumnValue()));
            printyouData(data, div, reportManager);
            JikoFutangakushomeishoManager.createInstance().upDate高額合算情報更新(getParameter(div),
                    div.getJikoFutanShomeishoSakuseiPrint().getTxtHakkoDate().getValue());
            response.data = reportManager.publish();
        }
        return response;
    }

    private void printData(JikoFutangakushomeishoData data, ReportManager reportManager) {
        IJikoFutangakushomeishoService printService = new IJikoFutangakushomeishoService(reportManager);
        List<JikoFutangakushomeishoData> dataList = new ArrayList<>();
        dataList.add(data);
        printService.print(dataList);

    }

    private void printyouData(JikoFutangakushomeishoData data, JikoFutangakuShomeishoDiv div, ReportManager reportManager) {
        IJikoFutangakushomeisho2009Service printService = new IJikoFutangakushomeisho2009Service(reportManager);
        List<JikoFutangakushomeishoFromData> dataList = new ArrayList<>();
        dataList.add(getHandler(div).get高額合算データ2009(data));
        printService.print(dataList);

    }

    private JikoFutangakushomeishoHandler getHandler(JikoFutangakuShomeishoDiv div) {
        return new JikoFutangakushomeishoHandler(div);
    }

    private TaishoshaKey getKey() {
        return ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
    }

    private void setKey高額合算キークラス(KogakuGassanKey kogakuGassanKey) {
        ViewStateHolder.put(ViewStateKeys.高額合算キークラス, kogakuGassanKey);
    }

    private KogakuGassanKey getKey高額合算キークラス() {
        return ViewStateHolder.get(ViewStateKeys.高額合算キークラス, KogakuGassanKey.class);
    }

    private PersonalData toPersonalData(RString 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                被保険者番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

}
