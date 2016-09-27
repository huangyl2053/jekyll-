/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC7180001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.sougoujigyohijouhou.SougouJigyoHiJouhouBusiness;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710180.DBC710180_HanyoListSogoJigyoHiParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.sougoujigyohijouhou.SougouJigyoHiJouhouParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7180001.SougouJigyoHiJouhouDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7180001.SougouJigyoHiJouhouHandler;
import jp.co.ndensan.reams.db.dbc.service.core.sougoujigyohijouhou.SougouJigyoHiJouhouFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(総合事業費情報)のクラスです。
 *
 * @reamsid_L DBC-3107-010 wanghuafeng
 */
public class SougouJigyoHiJouhou {

    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString KEY2 = new RString("key2");
    private static final RString KEY3 = new RString("key3");
    private static final RString 基本ケアマネジメント情報 = new RString("基本情報＋ケアマネジメント費情報");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div 汎用リスト出力(総合事業費情報)のdiv
     * @return 初期化画面
     */
    public ResponseData<SougouJigyoHiJouhouDiv> onLoad(SougouJigyoHiJouhouDiv div) {
        ShichosonSecurityJoho shichosonsecurityjoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        getHandler(div).onLoad(shichosonsecurityjoho);
        List<SougouJigyoHiJouhouBusiness> sougoujigyohijouhous = SougouJigyoHiJouhouFinder.createInstance().getサービス種類(
                SougouJigyoHiJouhouParameter.creatParameter(ServiceBunrui.総合事業_経過措置.getコード(),
                        ServiceBunrui.総合事業.getコード())).records();
        getHandler(div).setサービス種類DDL(KEY0, sougoujigyohijouhous);
        return ResponseData.of(div).respond();
    }

    /**
     * 作成区分のonChangeです。
     *
     * @param div SougouJigyoHiJouhouDiv
     * @return ResponseData<SougouJigyoHiJouhouDiv>
     */
    public ResponseData<SougouJigyoHiJouhouDiv> onChange_SakuseiKubun(SougouJigyoHiJouhouDiv div) {
        getHandler(div).setサービス種類DDL(div.getRadSakuseiKubun().getSelectedKey(), set作成区分(div));
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件を保存する」ボタンを押下します。
     *
     * @param div SougouJigyoHiJouhouDiv
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<BatchParameterMap> onClick_btnBatchParameterSave(SougouJigyoHiJouhouDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).onClick_btnBatchParameterSave());
        return responseData;
    }

    /**
     * 「条件を復元する」ボタンを押下します。
     *
     * @param div SougouJigyoHiJouhouDiv
     * @return ResponseData<SougouJigyoHiJouhouDiv>
     */
    public ResponseData<SougouJigyoHiJouhouDiv> onClick_btnBatchParameterRestore(SougouJigyoHiJouhouDiv div) {
        BatchParameterMap restoreBatchParameterMap = div.getJokenFukugenHozonl().getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        RString 抽出方法 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("抽出方法"));
        if (基本ケアマネジメント情報.equals(抽出方法)) {
            List<SougouJigyoHiJouhouBusiness> sougoujigyohijouhous = SougouJigyoHiJouhouFinder.createInstance().getサービス種類(SougouJigyoHiJouhouParameter.
                    creatParameter(ServiceBunrui.ケアマネジメント_経過措置.getコード(), ServiceBunrui.ケアマネジメント.getコード())).records();
            getHandler(div).onClick_btnBatchParameterRestore(sougoujigyohijouhous);
        } else {
            List<SougouJigyoHiJouhouBusiness> sougoujigyohijouhous = SougouJigyoHiJouhouFinder.createInstance().getサービス種類(SougouJigyoHiJouhouParameter.
                    creatParameter(ServiceBunrui.総合事業_経過措置.getコード(), ServiceBunrui.総合事業.getコード())).records();
            getHandler(div).onClick_btnBatchParameterRestore(sougoujigyohijouhous);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 実行するボタンを押下する場合、バッチ起動する。
     *
     * @param div SougouJigyoHiJouhouDiv
     * @return ResponseData<DBC710180_HanyoListSogoJigyoHiParameter>
     */
    public ResponseData<DBC710180_HanyoListSogoJigyoHiParameter> onClick_btnBatchRegister(SougouJigyoHiJouhouDiv div) {
        return ResponseData.of(getHandler(div).onClick_btnBatchParameterSave()).respond();
    }

    private SougouJigyoHiJouhouHandler getHandler(SougouJigyoHiJouhouDiv div) {
        return new SougouJigyoHiJouhouHandler(div);
    }

    private List<SougouJigyoHiJouhouBusiness> set作成区分(SougouJigyoHiJouhouDiv div) {
        List<SougouJigyoHiJouhouBusiness> sougoujigyohijouhous = new ArrayList<>();
        if (KEY1.equals(div.getRadSakuseiKubun().getSelectedKey())
                || KEY2.equals(div.getRadSakuseiKubun().getSelectedKey())
                || KEY0.equals(div.getRadSakuseiKubun().getSelectedKey())) {
            sougoujigyohijouhous = SougouJigyoHiJouhouFinder.createInstance().getサービス種類(SougouJigyoHiJouhouParameter.
                    creatParameter(ServiceBunrui.総合事業_経過措置.getコード(), ServiceBunrui.総合事業.getコード())).records();
        } else if (KEY3.equals(div.getRadSakuseiKubun().getSelectedKey())) {
            sougoujigyohijouhous = SougouJigyoHiJouhouFinder.createInstance().getサービス種類(SougouJigyoHiJouhouParameter.
                    creatParameter(ServiceBunrui.ケアマネジメント_経過措置.getコード(), ServiceBunrui.ケアマネジメント.getコード())).records();
        }
        return sougoujigyohijouhous;
    }
}
