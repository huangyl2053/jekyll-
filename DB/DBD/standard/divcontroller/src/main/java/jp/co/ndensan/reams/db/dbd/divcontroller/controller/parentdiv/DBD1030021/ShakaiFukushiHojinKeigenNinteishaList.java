/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1030021;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBDBT00004.DBD200004_ShakaiFukushiHojinKeigenNinteishaBatchParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030021.ShakaiFukushiHojinKeigenNinteishaListDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1030021.ShakaiFukushiHojinKeigenNinteishaListHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 社会福祉法人軽減認定者リストのDivControllerです。
 *
 * @reamsid_L DBD-3830-010 tianyh
 */
public class ShakaiFukushiHojinKeigenNinteishaList {

    private static final int NO_1 = 1;
    private static final int NO_4 = 4;
    private static final int NO_5 = 5;
    private static final int NO_6 = 6;
    private static final int NO_7 = 7;
    private static final int NO_9 = 9;
    private static final int NO_10 = 10;
    private static final int NO_30 = 30;
    private static final int NO_31 = 31;

    /**
     * 画面初期化
     *
     * @param div ShakaiFukushiHojinKeigenNinteishaListDiv
     * @return ResponseData<ShakaiFukushiHojinKeigenNinteishaListDiv>
     */
    public ResponseData<ShakaiFukushiHojinKeigenNinteishaListDiv> onLoad(ShakaiFukushiHojinKeigenNinteishaListDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 「「認定者リスト」ラジオと「該当者リスト」ラジオの変更」の処理です。
     *
     * @param div ShakaiFukushiHojinKeigenNinteishaListDiv
     * @return ResponseData<ShakaiFukushiHojinKeigenNinteishaListDiv>
     */
    public ResponseData<ShakaiFukushiHojinKeigenNinteishaListDiv> radTaishoList_onchange(ShakaiFukushiHojinKeigenNinteishaListDiv div) {
        getHandler(div).radTaishoList_onchange();
        return ResponseData.of(div).respond();
    }

    /**
     * 「対象年度」ラジオと「基準日」ラジオの変更」の処理です。
     *
     * @param div ShakaiFukushiHojinKeigenNinteishaListDiv
     * @return ResponseData<ShakaiFukushiHojinKeigenNinteishaListDiv>
     */
    public ResponseData<ShakaiFukushiHojinKeigenNinteishaListDiv> radTaishoKikanShitei_onchange(ShakaiFukushiHojinKeigenNinteishaListDiv div) {
        getHandler(div).radTaishoKikanShitei_onchange();
        return ResponseData.of(div).respond();
    }

    /**
     * 「対象年度」の変更」の処理です。
     *
     * @param div ShakaiFukushiHojinKeigenNinteishaListDiv
     * @return ResponseData<ShakaiFukushiHojinKeigenNinteishaListDiv>
     */
    public ResponseData<ShakaiFukushiHojinKeigenNinteishaListDiv> taishoYM_onchange(ShakaiFukushiHojinKeigenNinteishaListDiv div) {
        getHandler(div).taishoYM_onchange();
        return ResponseData.of(div).respond();
    }

    /**
     * 実行するボタンを押下のチェック処理します。
     *
     * @param div ShakaiFukushiHojinKeigenNinteishaListDiv
     * @return ResponseData<ShakaiFukushiHojinKeigenNinteishaListDiv>
     */
    public ResponseData<ShakaiFukushiHojinKeigenNinteishaListDiv> onClick_btnCheck(ShakaiFukushiHojinKeigenNinteishaListDiv div) {
        ValidationMessageControlPairs pairs = getHandler(div).バッチ実行前チェック();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return createResponse(div);
    }

    private ResponseData<ShakaiFukushiHojinKeigenNinteishaListDiv> createResponse(ShakaiFukushiHojinKeigenNinteishaListDiv div) {
        ResponseData<ShakaiFukushiHojinKeigenNinteishaListDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * リスト作成を実行する押下、バッチパラメターを設定
     *
     * @param div ShiharaiHohoHenkoHakuListMainDiv
     * @return ResponseData<ShiharaiHohoHenkoHakuListMainDiv>
     */
    public ResponseData<DBD200004_ShakaiFukushiHojinKeigenNinteishaBatchParameter> onClick_btnBatchExecute(ShakaiFukushiHojinKeigenNinteishaListDiv div) {
        DBD200004_ShakaiFukushiHojinKeigenNinteishaBatchParameter parameter = getHandler(div).createParameter();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 社会福祉法人軽減認定者リスト作成バッチ用パラメータを作成する
     *
     * @param 年度 FlexibleYear
     * @param is認定者リスト Boolean
     * @param is軽減 Boolean
     * @return Range<FlexibleDate>
     */
    public Range<FlexibleDate> estimate対象期間(FlexibleYear 年度, Boolean is認定者リスト, Boolean is軽減) {
        FlexibleDate 開始年 = new FlexibleDate(RString.EMPTY);
        FlexibleDate 終了年 = new FlexibleDate(RString.EMPTY);
        if (年度.isBeforeOrEquals(new FlexibleYear("平11"))) {
            開始年 = FlexibleDate.EMPTY;
            終了年 = FlexibleDate.EMPTY;
        } else if (年度.isBeforeOrEquals(new FlexibleYear("平12"))) {
            開始年 = new FlexibleDate(年度.getYearValue(), NO_4, NO_1);
            終了年 = new FlexibleDate(年度.getYearValue() + NO_1, NO_5, NO_31);
        } else if (年度.isBeforeOrEquals(new FlexibleYear("平16"))) {
            開始年 = new FlexibleDate(年度.getYearValue(), NO_6, NO_1);
            終了年 = new FlexibleDate(年度.getYearValue() + NO_1, NO_5, NO_31);
        } else if (年度.isBeforeOrEquals(new FlexibleYear("平17"))) {
            if (is認定者リスト && (!is軽減)) {
                開始年 = new FlexibleDate(年度.getYearValue(), NO_6, NO_1);
                終了年 = new FlexibleDate(年度.getYearValue() + NO_1, NO_9, NO_30);
            } else {
                開始年 = new FlexibleDate(年度.getYearValue(), NO_10, NO_1);
                終了年 = new FlexibleDate(年度.getYearValue() + NO_1, NO_6, NO_30);
            }
        }
        if (!年度.isBeforeOrEquals(new FlexibleYear("平17"))) {
            開始年 = new FlexibleDate(年度.getYearValue(), NO_7, NO_1);
            終了年 = new FlexibleDate(年度.getYearValue() + NO_1, NO_6, NO_30);
        }
        return new Range<>(開始年, 終了年);
    }

    private ShakaiFukushiHojinKeigenNinteishaListHandler getHandler(ShakaiFukushiHojinKeigenNinteishaListDiv div) {
        return new ShakaiFukushiHojinKeigenNinteishaListHandler(div);
    }
}
