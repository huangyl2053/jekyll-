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
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1170011.DBC1170011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1170011.JikoFutangakuShomeishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1170011.JikoFutangakushomeishoHandler;
import jp.co.ndensan.reams.db.dbc.service.report.ijikofutangakushomeishoservice.IJikoFutangakushomeisho2009Service;
import jp.co.ndensan.reams.db.dbc.service.report.ijikofutangakushomeishoservice.IJikoFutangakushomeishoService;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
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
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
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
    private final RString メニューID = ResponseHolder.getMenuID();
    private boolean is帳票設計DBC100051 = false;
    private boolean is帳票設計DBC100050 = false;

    /**
     * 自己負担額証明書作成画面 初期化を処理します。
     *
     * @param div ShomeishoSakuseiParameterDiv
     * @return 画面
     */
    public ResponseData<JikoFutangakuShomeishoDiv> onLoad(JikoFutangakuShomeishoDiv div) {
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        List<KogakuGassanShinSeisho> 対象者データ = getHandler(div).get対象者データ(メニューID, getKey().get被保険者番号());
        InformationMessage message = new InformationMessage(
                DbcInformationMessages.自己負担額データなし.getMessage().getCode(),
                DbcInformationMessages.自己負担額データなし.getMessage().evaluate());
        if (対象者データ.isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                getHandler(div).onLoadhas対象者データ(getKey().get被保険者番号(), getKey().get識別コード());
                div.getJikoFutanShomeishoSakuseiPrint().getDdlTaishoNendo().setDisabled(true);
                div.getJikoFutanShomeishoSakuseiPrint().getDdlShikyuShinseishoSeiriNo().setDisabled(true);
                div.getJikoFutanShomeishoSakuseiPrint().getTxtHakkoDate().setDisabled(true);
                div.getJikoFutanShomeishoSakuseiPrint().getCcdBunshoNo().setDisabled(true);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(発行, true);
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
            if (再計算区分 != null && 再計算区分_1.equals(再計算区分.get再計算区分()) && !ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbcWarningMessages.高額合算申請書情報の再計算前.getMessage()).respond();
            }
        }
        FlexibleDate 前回発行日 = div.getJikoFutanShomeishoSakuseiPrint().getTxtZenkaiHakkoDate().getValue();
        if (前回発行日.isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbcWarningMessages.発行済み負担額証明書.getMessage()).respond();
            }
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
            is帳票設計DBC100050 = true;
            JikoFutangakushomeishoData data = getHandler(div).get高額合算データ(is帳票設計DBC100050, is帳票設計DBC100051, getKey().get識別コード(), getKey高額合算キークラス().get年度毎キー(), getKey().get被保険者番号(), メニューID);
            AccessLogger.log(AccessLogType.照会, toPersonalData(data));
            printData(data, reportManager);
            response.data = reportManager.publish();
        }
        return response;
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
            is帳票設計DBC100051 = true;
            JikoFutangakushomeishoData data = getHandler(div).get高額合算データ(is帳票設計DBC100050, is帳票設計DBC100051, getKey().get識別コード(), getKey高額合算キークラス().get年度毎キー(), getKey().get被保険者番号(), メニューID);
            AccessLogger.log(AccessLogType.照会, toPersonalData(data));
            printyouData(data, div, reportManager);
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

    private PersonalData toPersonalData(JikoFutangakushomeishoData data) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                data.get高額合算データ().get被保険者番号().value());
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

}
