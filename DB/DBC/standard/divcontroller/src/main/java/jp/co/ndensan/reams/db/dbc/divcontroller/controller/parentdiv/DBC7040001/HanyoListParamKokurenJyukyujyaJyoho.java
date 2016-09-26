/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC7040001;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710040.DBC710040_HanyoListKokuhorenJukyushaParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710050.DBC710050_HanyoListKyodoJukyushaKihonParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710060.DBC710060_HanyoListKyodoJukyushaKogakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710070.DBC710070_HanyoListKyodoJukyushaShokanParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7040001.DBC7040001StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7040001.HanyoListParamKokurenJyukyujyaJyohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7040001.HanyoListParamKokurenJyukyujyaJyohoHandler;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.basic.KaigoDonyuKeitaiManager;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 汎用リスト 国保連受給者情報のパネルです。
 *
 * @reamsid_L DBC-3104-010 yaodongsheng
 */
public class HanyoListParamKokurenJyukyujyaJyoho {

    private static final RString モード1 = new RString("DBCUC70501");
    private static final RString モード2 = new RString("DBCUC70701");
    private static final RString モード3 = new RString("DBCUC70601");
    private static final RString モード4 = new RString("DBCUC70401");

    /**
     * 汎用リスト（資格）を初期化します。
     *
     * @param div HanyoListParamKokurenJyukyujyaJyohoDiv
     * @return ResponseData<HanyoListParamKokurenJyukyujyaJyohoDiv>
     */
    public ResponseData<HanyoListParamKokurenJyukyujyaJyohoDiv> onLoad(HanyoListParamKokurenJyukyujyaJyohoDiv div) {
        RString モード = ResponseHolder.getUIContainerId();
        List<KaigoDonyuKeitai> list = KaigoDonyuKeitaiManager.createInstance().get介護導入形態By業務分類(GyomuBunrui.介護事務);
        getHandler(div).onLoad(list);
        if (モード1.equals(モード)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701005.getReportId());
            div.getCcdShutsuryokuKoumoku().load(ReportIdDBC.DBC701005.getReportId().value(), SubGyomuCode.DBC介護給付);
            return ResponseData.of(div).setState(DBC7040001StateName.共同処理用受給者情報_基本);
        } else if (モード2.equals(モード)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701007.getReportId());
            div.getCcdShutsuryokuKoumoku().load(ReportIdDBC.DBC701007.getReportId().value(), SubGyomuCode.DBC介護給付);
            return ResponseData.of(div).setState(DBC7040001StateName.共同処理用受給者情報_償還);
        } else if (モード3.equals(モード)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701006.getReportId());
            div.getCcdShutsuryokuKoumoku().load(ReportIdDBC.DBC701006.getReportId().value(), SubGyomuCode.DBC介護給付);
            return ResponseData.of(div).setState(DBC7040001StateName.共同処理用受給者情報_高額);
        } else if (モード4.equals(モード)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701004.getReportId());
            div.getCcdShutsuryokuKoumoku().load(ReportIdDBC.DBC701004.getReportId().value(), SubGyomuCode.DBC介護給付);
            ViewStateHolder.put(ViewStateKeys.事業者入力モード, new RString("事業者入力モード"));
            ViewStateHolder.put(ViewStateKeys.台帳種別表示, new RString("台帳種別表示無し"));
            div.getCcdkyotakuSienJigyoshaBango().initialize();
            return ResponseData.of(div).setState(DBC7040001StateName.国保連受給者情報);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 日付抽出区分のonChange事件です。
     *
     * @param div HanyoListParamKokurenJyukyujyaJyohoDiv
     * @return ResponseData<HanyoListParamKokurenJyukyujyaJyohoDiv>
     */
    public ResponseData<HanyoListParamKokurenJyukyujyaJyohoDiv> onChange_HaniSentaku(HanyoListParamKokurenJyukyujyaJyohoDiv div) {
        getHandler(div).onChange_HaniSentaku();
        return ResponseData.of(div).respond();
    }

    /**
     * 共同処理用受給者情報（基本）のBatchParameterSave。
     *
     * @param div HanyoListParamKokurenJyukyujyaJyohoDiv
     * @return parameter DBC710050_HanyoListKyodoJukyushaKihonParameter
     */
    public ResponseData<BatchParameterMap> onClick_btnKyodoJukyushaKihonParameterSave(HanyoListParamKokurenJyukyujyaJyohoDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).onClick_btnKyodoJukyushaKihonParameterSave());
        return responseData;
    }

    /**
     * 共同処理用受給者情報（基本）の条件復元するボタンを押下します。
     *
     * @param div HanyoListParamKokurenJyukyujyaJyohoDiv
     * @return ResponseData<HanyoListParamKokurenJyukyujyaJyohoDiv>
     */
    public ResponseData<HanyoListParamKokurenJyukyujyaJyohoDiv> onClick_btnKyodoJukyushaKihonParameterResotre(
            HanyoListParamKokurenJyukyujyaJyohoDiv div) {
        getHandler(div).onClick_btnKyodoJukyushaKihonParameterRestore();
        return ResponseData.of(div).respond();
    }

    /**
     * 共同処理用受給者情報（償還）のBatchParameterSave。
     *
     * @param div HanyoListParamKokurenJyukyujyaJyohoDiv
     * @return parameter DBC710070_HanyoListKyodoJukyushaShokanParameter
     */
    public ResponseData<BatchParameterMap> onClick_btnKyodoJukyushaShokanParameterSave(HanyoListParamKokurenJyukyujyaJyohoDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).onClick_btnKyodoJukyushaShokanParameterSave());
        return responseData;
    }

    /**
     * 共同処理用受給者情報（償還）の条件復元するボタンを押下します。
     *
     * @param div HanyoListParamKokurenJyukyujyaJyohoDiv
     * @return ResponseData<HanyoListParamKokurenJyukyujyaJyohoDiv>
     */
    public ResponseData<HanyoListParamKokurenJyukyujyaJyohoDiv> onClick_btnKyodoJukyushaShokanParameterRestore(
            HanyoListParamKokurenJyukyujyaJyohoDiv div) {
        getHandler(div).onClick_btnKyodoJukyushaKihonParameterRestore();
        return ResponseData.of(div).respond();
    }

    /**
     * 共同処理用受給者情報（高額）のBatchParameterSave。
     *
     * @param div HanyoListParamKokurenJyukyujyaJyohoDiv
     * @return parameter DBC710060_HanyoListKyodoJukyushaKogakuParameter
     */
    public ResponseData<BatchParameterMap> onClick_btnKyodoJukyushaKogakuParameterSave(HanyoListParamKokurenJyukyujyaJyohoDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).onClick_btnKyodoJukyushaKogakuParameterSave());
        return responseData;
    }

    /**
     * 共同処理用受給者情報（高額）の条件復元するボタンを押下します。
     *
     * @param div HanyoListParamKokurenJyukyujyaJyohoDiv
     * @return ResponseData<HanyoListParamKokurenJyukyujyaJyohoDiv>
     */
    public ResponseData<HanyoListParamKokurenJyukyujyaJyohoDiv> onClick_btnKyodoJukyushaKogakuParameterRestore(
            HanyoListParamKokurenJyukyujyaJyohoDiv div) {
        getHandler(div).onClick_btnKyodoJukyushaKogakuParameterRestore();
        return ResponseData.of(div).respond();
    }

    /**
     * 国保連受給者情報 のBatchParameterSave。
     *
     * @param div HanyoListParamKokurenJyukyujyaJyohoDiv
     * @return parameter DBC710040_HanyoListKokuhorenJukyushaParameter
     */
    public ResponseData<BatchParameterMap> onClick_btnKokuhorenJukyushaParameterSave(HanyoListParamKokurenJyukyujyaJyohoDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).onClick_btnKokuhorenJukyushaParameterSave());
        return responseData;
    }

    /**
     * 国保連受給者情報の条件復元するボタンを押下します。
     *
     * @param div HanyoListParamKokurenJyukyujyaJyohoDiv
     * @return ResponseData<HanyoListParamKokurenJyukyujyaJyohoDiv>
     */
    public ResponseData<HanyoListParamKokurenJyukyujyaJyohoDiv> onClick_btnKokuhorenJukyushaParameterRestore(
            HanyoListParamKokurenJyukyujyaJyohoDiv div) {
        getHandler(div).onClick_btnKokuhorenJukyushaParameterRestore();
        return ResponseData.of(div).respond();
    }

    /**
     * 実行するボタンを押下する場合、バッチ起動する。
     *
     * @param div HanyoListParamKokurenJyukyujyaJyohoDiv
     * @return ResponseData<DBC710050_HanyoListKyodoJukyushaKihonParameter>
     */
    public ResponseData<DBC710050_HanyoListKyodoJukyushaKihonParameter> onClick_btnKyodoJukyushaKihonRegister(
            HanyoListParamKokurenJyukyujyaJyohoDiv div) {
        return ResponseData.of(getHandler(div).onClick_btnKyodoJukyushaKihonParameterSave()).respond();
    }

    /**
     * 実行するボタンを押下する場合、バッチ起動する。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<DBC710070_HanyoListKyodoJukyushaShokanParameter> onClick_btnKyodoJukyushaShokanRegister(
            HanyoListParamKokurenJyukyujyaJyohoDiv div) {
        return ResponseData.of(getHandler(div).onClick_btnKyodoJukyushaShokanParameterSave()).respond();
    }

    /**
     * 実行するボタンを押下する場合、バッチ起動する。
     *
     * @param div HanyoListParamKokurenJyukyujyaJyohoDiv
     * @return ResponseData<DBC710060_HanyoListKyodoJukyushaKogakuParameter>
     */
    public ResponseData<DBC710060_HanyoListKyodoJukyushaKogakuParameter> onClick_btnKyodoJukyushaKogakuRegister(
            HanyoListParamKokurenJyukyujyaJyohoDiv div) {
        return ResponseData.of(getHandler(div).onClick_btnKyodoJukyushaKogakuParameterSave()).respond();
    }

    /**
     * 実行するボタンを押下する場合、バッチ起動する。
     *
     * @param div HanyoListParamKokurenJyukyujyaJyohoDiv
     * @return ResponseData<DBC710040_HanyoListKokuhorenJukyushaParameter>
     */
    public ResponseData<DBC710040_HanyoListKokuhorenJukyushaParameter> onClick_btnKokuhorenJukyushaRegister(
            HanyoListParamKokurenJyukyujyaJyohoDiv div) {
        return ResponseData.of(getHandler(div).onClick_btnKokuhorenJukyushaParameterSave()).respond();
    }

    private HanyoListParamKokurenJyukyujyaJyohoHandler getHandler(HanyoListParamKokurenJyukyujyaJyohoDiv div) {
        return new HanyoListParamKokurenJyukyujyaJyohoHandler(div);
    }
}
