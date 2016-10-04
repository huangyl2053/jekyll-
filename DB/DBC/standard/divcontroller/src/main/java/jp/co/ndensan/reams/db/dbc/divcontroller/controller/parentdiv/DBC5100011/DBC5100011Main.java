/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC5100011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5100011.DBC5100011MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5100011.DBC5100011MainHandler;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5100011.DBC5100011StateName.標準;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * [利用状況統計表（明細リスト）作成]の処理詳細です。
 *
 * @reamsid_L DBC-3500-010 jinjue
 */
public class DBC5100011Main {

    /**
     * 画面初期化処理です。
     *
     * @param div DBC5100011MainDiv
     * @return ResponseData<DBC5100011MainDiv>
     */
    public ResponseData<DBC5100011MainDiv> onLoad(DBC5100011MainDiv div) {
        this.getHandler(div).onLoad();
        return ResponseData.of(div).setState(標準);
    }

    /**
     * 条件を保存するボタンを押す、処理を実施します。
     *
     * @param div DBC5100011MainDiv
     * @return ResponseData<DBC5100011MainDiv>
     */
    public ResponseData<BatchParameterMap> onClick_btnBatchParameterSave(DBC5100011MainDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).getTempData());
        return responseData;
    }

    /**
     * 条件を復元するボタンを押す、処理を実施します。
     *
     * @param div DBC5100011MainDiv
     * @return ResponseData<DBC5100011MainDiv>
     */
    public ResponseData<DBC5100011MainDiv> onClick_btnBatchParameterRestore(DBC5100011MainDiv div) {
        this.getHandler(div).onClick_btnBatchParameterRestore();
        return ResponseData.of(div).respond();
    }

    /**
     * 対象年月入力項目制御です。
     *
     * @param div DBC5100011MainDiv
     * @return ResponseData<DBC5100011MainDiv>
     */
    public ResponseData<DBC5100011MainDiv> onChange_radTaishoYM(DBC5100011MainDiv div) {
        this.getHandler(div).onChange_radTaishoYM();
        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者番号入力項目制御です。
     *
     * @param div DBC5100011MainDiv
     * @return ResponseData<DBC5100011MainDiv>
     */
    public ResponseData<DBC5100011MainDiv> onBlur_txtHihokenshaNo(DBC5100011MainDiv div) {
        this.getHandler(div).onBlur_txtHihokenshaNo();
        return ResponseData.of(div).respond();
    }

    /**
     * 居宅利用率入力項目制御です。
     *
     * @param div DBC5100011MainDiv
     * @return ResponseData<DBC5100011MainDiv>
     */
    public ResponseData<DBC5100011MainDiv> onChange_txtKyotakuRiyoritsuRange(DBC5100011MainDiv div) {
        this.getHandler(div).onChange_txtKyotakuRiyoritsuRange();
        return ResponseData.of(div).respond();
    }

    /**
     * 訪問利用率入力項目制御です。
     *
     * @param div DBC5100011MainDiv
     * @return ResponseData<DBC5100011MainDiv>
     */
    public ResponseData<DBC5100011MainDiv> onChange_txtHomonRiyoritsuRange(DBC5100011MainDiv div) {
        this.getHandler(div).onChange_txtHomonRiyoritsuRange();
        return ResponseData.of(div).respond();
    }

    private DBC5100011MainHandler getHandler(DBC5100011MainDiv div) {
        return new DBC5100011MainHandler(div);
    }
}
