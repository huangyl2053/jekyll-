/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE6010001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranMybitisParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6010001.ShisakaiIinJissekiShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6010001.ShisakaiIinJissekiShokaiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6010001.ShisakaiIinJissekiShokaiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranFindler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 審査会委員実績照会の画面処理クラスです
 *
 * @reamsid_L DBE-1700-010 wanghuafeng
 */
public class ShisakaiIinJissekiShokai {

    private static final RString CSVを出力する = new RString("1");
    private static final RString 集計表を発行する = new RString("2");

    /**
     * 画面の初期化です。
     *
     * @param div 画面情報
     * @return ResponseData<ShisakaiIinJissekiShokaiDiv>
     */
    public ResponseData<ShisakaiIinJissekiShokaiDiv> onLoad(ShisakaiIinJissekiShokaiDiv div) {
        getHandler(div).set初期状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件をクリアする」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<ShisakaiIinJissekiShokaiDiv>
     */
    public ResponseData<ShisakaiIinJissekiShokaiDiv> onClick_BtnKensakuClear(ShisakaiIinJissekiShokaiDiv div) {
        getHandler(div).onClick_BtnKensakuClear();
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<ShisakaiIinJissekiShokaiDiv>
     */
    public ResponseData<ShisakaiIinJissekiShokaiDiv> onClick_BtnKensaku(ShisakaiIinJissekiShokaiDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForNyuryuku(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        FlexibleDate 審査会開催日FROM = FlexibleDate.EMPTY;
        FlexibleDate 審査会開催日TO = FlexibleDate.EMPTY;
        getHandler(div).set審査会開催日(審査会開催日FROM, 審査会開催日TO);
        ShinsaiinJissekiIchiranMybitisParamter paramter = ShinsaiinJissekiIchiranMybitisParamter.createParamter(false,
                審査会開催日FROM, 審査会開催日TO, new RString(div.getTxtMaxKensu().getValue().toString()));
        getHandler(div).onClick_BtnKensaku(ShinsaiinJissekiIchiranFindler.createInstance().get介護認定審査会委員報酬集計表(paramter).records());
        getHandler(div).set一覧状態();
        getHandler(div).setCommonButton();
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件に戻る」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<ShisakaiIinJissekiShokaiDiv>
     */
    public ResponseData<ShisakaiIinJissekiShokaiDiv> onClick_btnBackToKensaku(ShisakaiIinJissekiShokaiDiv div) {
        this.onLoad(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「CSVを出力する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsaiinJissekiIchiranBatchParameter>
     */
    public ResponseData<ShinsaiinJissekiIchiranBatchParameter> onClick_BtnShutsutyoku(ShisakaiIinJissekiShokaiDiv div) {
        ShinsaiinJissekiIchiranBatchParameter paramter = getHandler(div).createBatchParam(CSVを出力する);
        return ResponseData.of(paramter).respond();
    }

    /**
     * 「集計表を発行する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsaiinJissekiIchiranBatchParameter>
     */
    public ResponseData<ShinsaiinJissekiIchiranBatchParameter> onClick_BtnPulish(ShisakaiIinJissekiShokaiDiv div) {
        ShinsaiinJissekiIchiranBatchParameter paramter = getHandler(div).createBatchParam(集計表を発行する);
        return ResponseData.of(paramter).respond();
    }

    /**
     * ボタンを押下チェック処理。。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShisakaiIinJissekiShokaiDiv> onBefore_Dataoutput(ShisakaiIinJissekiShokaiDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).審査会委員実績一覧データの行選択チェック処理(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ShisakaiIinJissekiShokaiHandler getHandler(ShisakaiIinJissekiShokaiDiv div) {
        return new ShisakaiIinJissekiShokaiHandler(div);
    }

    private ShisakaiIinJissekiShokaiValidationHandler getValidationHandler(ShisakaiIinJissekiShokaiDiv div) {
        return new ShisakaiIinJissekiShokaiValidationHandler(div);
    }
}
