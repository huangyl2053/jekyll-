/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC7160001;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710160.DBC710160_HanyoListKogakuGassanKeisanKekkaRenrakuHyoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7160001.HanyoListkougakugasSannKeiSuukekkaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7160001.HanyoListkougakugasSannKeiSuukekkaHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7160001.HanyoListkougakugasSannKeiSuukekkaValidationHandler;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 汎用リスト出力(高額合算計算結果連絡票情報)のクラスです。
 *
 * @reamsid_L DBC-3100-010 zhengshenlei
 */
public class HanyoListkougakugasSannKeiSuukekka {

    /**
     * 画面初期化のメソッドです。s
     *
     * @param div HanyoListkougakugasSannKeiSuukekkaDiv
     * @return ResponseData
     */
    public ResponseData<HanyoListkougakugasSannKeiSuukekkaDiv> onload(HanyoListkougakugasSannKeiSuukekkaDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 条件を保存するボタンのメソッドです。
     *
     * @param div HanyoListkougakugasSannKeiSuukekkaDiv
     * @return ResponseData
     */
    public ResponseData<BatchParameterMap> onClick_btnBatchParameterSave(HanyoListkougakugasSannKeiSuukekkaDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).createBatchParameter());
        return responseData;
    }

    /**
     * 条件を復元するボタンのメソッドです。
     *
     * @param div HanyoListkougakugasSannKeiSuukekkaDiv
     * @return ResponseData
     */
    public ResponseData<HanyoListkougakugasSannKeiSuukekkaDiv> onClick_btnBatchParameterRestore(HanyoListkougakugasSannKeiSuukekkaDiv div) {
        getHandler(div).条件を復元();
        return ResponseData.of(div).respond();
    }

    /**
     * 抽出条件画面項目の制御のメソッドです。
     *
     * @param div HanyoListkougakugasSannKeiSuukekkaDiv
     * @return ResponseData
     */
    public ResponseData<HanyoListkougakugasSannKeiSuukekkaDiv> onChange(HanyoListkougakugasSannKeiSuukekkaDiv div) {
        getHandler(div).setChange();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンを押した後、入力チェックを行う。
     *
     * @param div HanyoListkougakugasSannKeiSuukekkaDiv
     * @return ResponseData
     */
    public ResponseData<HanyoListkougakugasSannKeiSuukekkaDiv> onClick_check(HanyoListkougakugasSannKeiSuukekkaDiv div) {
        ValidationMessageControlPairs pairsCheck = getValidationHandler(div).validateCheck();
        if (pairsCheck.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairsCheck).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンのメソッドです。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData
     */
    public ResponseData<DBC710160_HanyoListKogakuGassanKeisanKekkaRenrakuHyoParameter> onclick_btBatch(HanyoListkougakugasSannKeiSuukekkaDiv div) {
        DBC710160_HanyoListKogakuGassanKeisanKekkaRenrakuHyoParameter parameter = getHandler(div).createBatchParameter();
        return ResponseData.of(parameter).respond();
    }

    private HanyoListkougakugasSannKeiSuukekkaHandler getHandler(HanyoListkougakugasSannKeiSuukekkaDiv div) {
        return new HanyoListkougakugasSannKeiSuukekkaHandler(div);
    }

    private HanyoListkougakugasSannKeiSuukekkaValidationHandler getValidationHandler(HanyoListkougakugasSannKeiSuukekkaDiv div) {
        return new HanyoListkougakugasSannKeiSuukekkaValidationHandler(div);
    }
}
