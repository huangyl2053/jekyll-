/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA7020001;

import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolistseikatsuhogojukyusha.HanyoListBatchParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7020001.DBA7020001StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7020001.HanyoListParamDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA7020001.HanyoListParamHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 汎用リスト（資格）のクラスです。
 *
 * @reamsid_L DBA-1600-010 yaodongsheng
 */
public class HanyoListParam {

    private static final RString モード2 = new RString("適用除外者");
    private static final RString モード3 = new RString("他市町村住所地特例者");
    private static final RString モード4 = new RString("老齢福祉年金受給者");
    private static final RString モード5 = new RString("生活保護受給者");

    /**
     * 汎用リスト（資格）を初期化します。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onLoad(HanyoListParamDiv div) {
        RString モード = ResponseHolder.getState();
        ViewStateHolder.put(ViewStateKeys.モード, モード);
        getHandler(div).onLoad(モード);
        if (モード2.equals(モード)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA701003.getReportId());
            div.getCcdShutsuryokuKomoku().load(ReportIdDBA.DBA701003.getReportId().value(), SubGyomuCode.DBA介護資格);
            return ResponseData.of(div).setState(DBA7020001StateName.適用除外者);
        } else if (モード3.equals(モード)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA701002.getReportId());
            div.getCcdShutsuryokuKomoku().load(ReportIdDBA.DBA701002.getReportId().value(), SubGyomuCode.DBA介護資格);
            return ResponseData.of(div).setState(DBA7020001StateName.他市町村住所地特例者);
        } else if (モード4.equals(モード)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA701004.getReportId());
            div.getCcdShutsuryokuKomoku().load(ReportIdDBA.DBA701004.getReportId().value(), SubGyomuCode.DBA介護資格);
            return ResponseData.of(div).setState(DBA7020001StateName.老齢福祉年金受給者);
        } else if (モード5.equals(モード)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA701006.getReportId());
            div.getCcdShutsuryokuKomoku().load(ReportIdDBA.DBA701006.getReportId().value(), SubGyomuCode.DBA介護資格);
            return ResponseData.of(div).setState(DBA7020001StateName.生活保護受給者);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 日付抽出区分RBTのonChangeです。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onChange_hitsukeKubun(HanyoListParamDiv div) {
        getHandler(div).onChange_日付抽出区分(ViewStateHolder.get(ViewStateKeys.モード, RString.class));
        return ResponseData.of(div).respond();
    }
    /**
     * 適用除外者の事由抽出区分RBTのonChangeです。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onChange_shiyoJiyuKubun(HanyoListParamDiv div) {
        getHandler(div).onChange_適用除外者事由抽出区分();
        return ResponseData.of(div).respond();
    }

    /**
     * 他市町村住所地特例者の事由抽出区分RBTのonChangeです。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onChange_shichosonKubun(HanyoListParamDiv div) {
        getHandler(div).onChange_他市町村住所地特例者事由抽出区分();
        return ResponseData.of(div).respond();
    }

    /**
     * 条件を保存するボタン押下です。
     *
     * @param div 汎用リスト被保険者台帳Div
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<BatchParameterMap> onClick_btnKogakuParamSave(HanyoListParamDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).onClick_btnKogakuParamSave(
                ViewStateHolder.get(ViewStateKeys.モード, RString.class)));
        return responseData;
    }

    /**
     * 条件を復元するボタン押下です。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onClick_jyokenFukugen(HanyoListParamDiv div) {
        getHandler(div).onClick_btnKogakuParamRestore(ViewStateHolder.get(ViewStateKeys.モード, RString.class));
        return ResponseData.of(div).respond();
    }

    /**
     * 実行するボタンを押下する場合、バッチ起動する。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListBatchParameter> onClick_btnBatchRegister(HanyoListParamDiv div) {
        return ResponseData.of(getHandler(div).onClick_btnKogakuParamSave(ViewStateHolder.get(ViewStateKeys.モード, RString.class))).respond();
    }
    private HanyoListParamHandler getHandler(HanyoListParamDiv div) {
        return new HanyoListParamHandler(div);
    }
}
