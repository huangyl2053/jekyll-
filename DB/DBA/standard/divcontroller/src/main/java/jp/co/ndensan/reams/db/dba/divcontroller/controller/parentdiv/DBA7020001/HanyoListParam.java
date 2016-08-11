/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA7020001;

import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolistroreifukushinenkinjukyusha.HanyoListRoreiFukushiNenkinJukyushaBatchParameter;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolistseikatsuhogojukyusha.HanyoListSeikatsuhogoJukyushaBatchParameter;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolisttashichosonjushochitokureisha.HanyoListTaShichosonJushochiTokureishaBatchParameter;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolisttekiyojogaisha.HanyoListTekiyoJogaishaBatchParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7020001.DBA7020001StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7020001.HanyoListParamDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA7020001.HanyoListParamHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
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
     * 宛名の地区Checkです。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onClick_btnCheck(HanyoListParamDiv div) {
        if (!div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div().getCcdHokenshaList().isVisible()) {
            RString 地区選択 = div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div().getDdlChikuSelect().getSelectedKey();
            ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
            if (Chiku.地区.getコード().equals(地区選択)) {
                validationMessage = 地区check(div);
            } else if (Chiku.住所.getコード().equals(地区選択)) {
                validationMessage = 住所check(div);
            } else if (Chiku.行政区.getコード().equals(地区選択)) {
                validationMessage = 行政区check(div);
            }
            if (validationMessage.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessage).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    private ValidationMessageControlPairs 地区check(HanyoListParamDiv div) {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
        if (!RString.isNullOrEmpty(div.getCcdHanyoListAtenaSelect().get地区１開始())) {
            validationMessage = div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div().getCcdChiku1From().validate();
        }
        if (!RString.isNullOrEmpty(div.getCcdHanyoListAtenaSelect().get地区１終了())) {
            ValidationMessageControlPairs 地区1終了 = div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div().getCcdChiku1To().validate();
            if (地区1終了.iterator().hasNext()) {
                validationMessage.add(地区1終了);
            }
        }
        if (!RString.isNullOrEmpty(div.getCcdHanyoListAtenaSelect().get地区２開始())) {
            ValidationMessageControlPairs 地区2開始 = div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div().getCcdChiku2From().validate();
            if (地区2開始.iterator().hasNext()) {
                validationMessage.add(地区2開始);
            }
        }
        if (RString.isNullOrEmpty(div.getCcdHanyoListAtenaSelect().get地区２終了())) {
            ValidationMessageControlPairs 地区2終了 = div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div().getCcdChiku2To().validate();
            if (地区2終了.iterator().hasNext()) {
                validationMessage.add(地区2終了);
            }
        }
        if (!RString.isNullOrEmpty(div.getCcdHanyoListAtenaSelect().get地区３開始())) {
            ValidationMessageControlPairs 地区3開始 = div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div().getCcdChiku3From().validate();
            if (地区3開始.iterator().hasNext()) {
                validationMessage.add(地区3開始);
            }
        }
        if (!RString.isNullOrEmpty(div.getCcdHanyoListAtenaSelect().get地区３終了())) {
            ValidationMessageControlPairs 地区3終了 = div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div().getCcdChiku3To().validate();
            if (地区3終了.iterator().hasNext()) {
                validationMessage.add(地区3終了);
            }
        }
        return validationMessage;
    }

    private ValidationMessageControlPairs 住所check(HanyoListParamDiv div) {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
        if (!RString.isNullOrEmpty(div.getCcdHanyoListAtenaSelect().get住所開始())) {
            ValidationMessageControlPairs 住所開始 = div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div().getCcdJushoFrom().validate();
            if (住所開始.iterator().hasNext()) {
                validationMessage.add(住所開始);
            }
        }
        if (!RString.isNullOrEmpty(div.getCcdHanyoListAtenaSelect().get住所終了())) {
            ValidationMessageControlPairs 住所終了 = div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div().getCcdJushoTo().validate();
            if (住所終了.iterator().hasNext()) {
                validationMessage.add(住所終了);
            }
        }
        return validationMessage;
    }

    private ValidationMessageControlPairs 行政区check(HanyoListParamDiv div) {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
        if (!RString.isNullOrEmpty(div.getCcdHanyoListAtenaSelect().get行政区開始())) {
            ValidationMessageControlPairs 行政区開始 = div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div().getCcdGyoseikuFrom().validate();
            if (行政区開始.iterator().hasNext()) {
                validationMessage.add(行政区開始);
            }
        }
        if (!RString.isNullOrEmpty(div.getCcdHanyoListAtenaSelect().get行政区終了())) {
            ValidationMessageControlPairs 行政区終了 = div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div().getCcdGyoseikuTo().validate();
            if (行政区終了.iterator().hasNext()) {
                validationMessage.add(行政区終了);
            }
        }
        return validationMessage;
    }

    /**
     * 適用除外者条件を保存するボタン押下です。
     *
     * @param div 汎用リスト被保険者台帳Div
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<BatchParameterMap> onClick_btnTekiyoKogakuParamSave(HanyoListParamDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).onClick_btnTekiyoKogakuParamSave());
        return responseData;
    }

    /**
     * 他市町村住所地特例者条件を保存するボタン押下です。
     *
     * @param div 汎用リスト被保険者台帳Div
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<BatchParameterMap> onClick_btnTashichoKogakuParamSave(HanyoListParamDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).onClick_btnTashichoKogakuParamSave());
        return responseData;
    }

    /**
     * 老齢福祉年金受給者条件を保存するボタン押下です。
     *
     * @param div 汎用リスト被保険者台帳Div
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<BatchParameterMap> onClick_btnRoreiKogakuParamSave(HanyoListParamDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).onClick_btnRoreiKogakuParamSave());
        return responseData;
    }

    /**
     * 生活保護受給者条件を保存するボタン押下です。
     *
     * @param div 汎用リスト被保険者台帳Div
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<BatchParameterMap> onClick_btnSeikatsuKogakuParamSave(HanyoListParamDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).onClick_btnSeikatsuKogakuParamSave());
        return responseData;
    }

    /**
     * 条件を復元するボタン押下です。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onClick_tekiyoJyokenFukugen(HanyoListParamDiv div) {
        getHandler(div).onClick_btnTekiyoKogakuParamRestore();
        return ResponseData.of(div).respond();
    }

    /**
     * 条件を復元するボタン押下です。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onClick_tashichoJyokenFukugen(HanyoListParamDiv div) {
        getHandler(div).onClick_btnTaShichosonKogakuParamRestore();
        return ResponseData.of(div).respond();
    }

    /**
     * 条件を復元するボタン押下です。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onClick_roreiJyokenFukugen(HanyoListParamDiv div) {
        getHandler(div).onClick_btnRoreiKogakuParamRestore();
        return ResponseData.of(div).respond();
    }

    /**
     * 条件を復元するボタン押下です。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onClick_seikatsuJyokenFukugen(HanyoListParamDiv div) {
        getHandler(div).onClick_btnSeikatsuKogakuParamRestore();
        return ResponseData.of(div).respond();
    }

    /**
     * 実行するボタンを押下する場合、バッチ起動する。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListTekiyoJogaishaBatchParameter> onClick_btnTekiyoBatchRegister(HanyoListParamDiv div) {
        return ResponseData.of(getHandler(div).onClick_btnTekiyoKogakuParamSave()).respond();
    }

    /**
     * 実行するボタンを押下する場合、バッチ起動する。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListTaShichosonJushochiTokureishaBatchParameter> onClick_btnTashichoBatchRegister(HanyoListParamDiv div) {
        return ResponseData.of(getHandler(div).onClick_btnTashichoKogakuParamSave()).respond();
    }

    /**
     * 実行するボタンを押下する場合、バッチ起動する。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListRoreiFukushiNenkinJukyushaBatchParameter> onClick_btnRoreiBatchRegister(HanyoListParamDiv div) {
        return ResponseData.of(getHandler(div).onClick_btnRoreiKogakuParamSave()).respond();
    }

    /**
     * 実行するボタンを押下する場合、バッチ起動する。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListSeikatsuhogoJukyushaBatchParameter> onClick_btnSeikatsuBatchRegister(HanyoListParamDiv div) {
        return ResponseData.of(getHandler(div).onClick_btnSeikatsuKogakuParamSave()).respond();
    }

    private HanyoListParamHandler getHandler(HanyoListParamDiv div) {
        return new HanyoListParamHandler(div);
    }
}
