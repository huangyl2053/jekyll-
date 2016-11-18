/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0490011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC020030.DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC020060.DBC020060_KogakuJigyoServicehiShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0490011.ShikyuketteituchishoSakuseiJyokenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0490011.ShikyuketteituchishoSakuseiJyokenHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0490011.ShikyuketteituchishoSakuseiJyokenValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMN43002_高額サービス費支給決定通知書作成のクラスです。
 *
 * @reamsid_L DBC-2000-010 chenhui
 */
public class ShikyuketteituchishoSakuseiJyoken {

    /**
     * 画面初期化のメソッドです。
     *
     * @param div 高額サービス費支給決定通知書作成DIV
     * @return ResponseData
     */
    public ResponseData<ShikyuketteituchishoSakuseiJyokenDiv> onLoad(ShikyuketteituchishoSakuseiJyokenDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「受付日」「決定日」「決定者受付年月」を選択のメソッドです。
     *
     * @param div 高額サービス費支給決定通知書作成DIV
     * @return ResponseData
     */
    public ResponseData<ShikyuketteituchishoSakuseiJyokenDiv>
            onClick_radHizukeSentaku(ShikyuketteituchishoSakuseiJyokenDiv div) {
        getHandler(div).onClick_radHizukeSentaku();
        return ResponseData.of(div).respond();
    }

    /**
     * 決定日一括更新区分を選択のメソッドです。
     *
     * @param div 高額サービス費支給決定通知書作成DIV
     * @return ResponseData
     */
    public ResponseData<ShikyuketteituchishoSakuseiJyokenDiv>
            onClick_radKetteibiIkkatsuKoshinKubun(ShikyuketteituchishoSakuseiJyokenDiv div) {
        getHandler(div).onClick_radKetteibiIkkatsuKoshinKubun();
        return ResponseData.of(div).respond();
    }

    /**
     * 操作実施確認　と　入力チェック
     *
     * @param div 高額サービス費支給決定通知書作成DIV
     * @return ResponseData
     */
    public ResponseData<ShikyuketteituchishoSakuseiJyokenDiv> onBefore_batchRegister(ShikyuketteituchishoSakuseiJyokenDiv div) {
        ValidationMessageControlPairs errorMessage = getValidationHandler(div).get入力チェック();
        if (errorMessage.existsError()) {
            return ResponseData.of(div).addValidationMessages(errorMessage).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン１を押下のメソッドです。
     *
     * @param div 高額サービス費支給決定通知書作成DIV
     * @return ResponseData<DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter>
     */
    public ResponseData<DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter>
            onClick_batch1(ShikyuketteituchishoSakuseiJyokenDiv div) {
        DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter parameter = getHandler(div).creatBatchParameter1();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 「実行する」ボタン2を押下のメソッドです。
     *
     * @param div 高額サービス費支給決定通知書作成DIV
     * @return ResponseData<DBC020060_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter>
     */
    public ResponseData<DBC020060_KogakuJigyoServicehiShikyuKetteiTsuchishoParameter>
            onClick_batch2(ShikyuketteituchishoSakuseiJyokenDiv div) {
        DBC020060_KogakuJigyoServicehiShikyuKetteiTsuchishoParameter parameter = getHandler(div).creatBatchParameter2();
        return ResponseData.of(parameter).respond();
    }

    /**
     * テスト出力制御
     *
     * @param div 高額サービス費支給決定通知書作成DIV
     * @return ResponseData
     */
    public ResponseData<ShikyuketteituchishoSakuseiJyokenDiv> onclick_chkTesutoShuturyoku(ShikyuketteituchishoSakuseiJyokenDiv div) {
        getHandler(div).テスト出力制御();
        return ResponseData.of(div).respond();
    }

    private ShikyuketteituchishoSakuseiJyokenHandler getHandler(ShikyuketteituchishoSakuseiJyokenDiv div) {
        return new ShikyuketteituchishoSakuseiJyokenHandler(div);
    }

    private ShikyuketteituchishoSakuseiJyokenValidationHandler getValidationHandler(ShikyuketteituchishoSakuseiJyokenDiv div) {
        return new ShikyuketteituchishoSakuseiJyokenValidationHandler(div);
    }
}
