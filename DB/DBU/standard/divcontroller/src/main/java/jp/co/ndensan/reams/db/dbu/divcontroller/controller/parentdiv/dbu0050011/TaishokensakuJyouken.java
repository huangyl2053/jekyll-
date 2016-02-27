/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.dbu0050011;

import jp.co.ndensan.reams.db.dbu.business.kaigohokentokubetukaikeikeirijyokyoregist.InsuranceInformation;
import static jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050011.DBU0050011TransitionEventName.修正;
import static jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050011.DBU0050011TransitionEventName.削除;
import static jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050011.DBU0050011TransitionEventName.様式4の３;
import static jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050011.DBU0050011TransitionEventName.様式４の2;
import static jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050011.DBU0050011TransitionEventName.追加;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050011.TaishokensakuJyoukenDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.dbu0050011.TaishokensakuJyoukenHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 介護保険特別会計経理状況登録_検索情報Divを制御します。
 */
public class TaishokensakuJyouken {

    private static final RString 入力済 = new RString("入力済");
    private static final RString ADD = new RString("add");

    /**
     * 介護保険特別会計経理状況登録_検索を画面初期化処理しました。
     *
     * @param div {@link TaishokensakuJyoukenDiv 介護保険特別会計経理状況登録_検索情報Div}
     * @return 介護保険特別会計経理状況登録_検索情報Divを持つResponseData
     */
    public ResponseData<TaishokensakuJyoukenDiv> onload(TaishokensakuJyoukenDiv div) {
        getHandler(div).onload();
        return ResponseData.of(div).respond();
    }

    /**
     * 介護保険特別会計経理状況登録_検索を「検索する」を押下する。<br/>
     *
     * @param div {@link TaishokensakuJyoukenDiv 介護保険特別会計経理状況登録_検索情報Div}
     * @return 介護保険特別会計経理状況登録_検索情報Divを持つResponseData
     */
    public ResponseData<TaishokensakuJyoukenDiv> onClick_btnSearch(TaishokensakuJyoukenDiv div) {
        getHandler(div).onClick_btnSearch();
        return ResponseData.of(div).respond();
    }

    /**
     * 介護保険特別会計経理状況登録_検索を「条件をクリアする」を押下する。<br/>
     *
     * @param div {@link TaishokensakuJyoukenDiv 介護保険特別会計経理状況登録_検索情報Div}
     * @return 介護保険特別会計経理状況登録_検索情報Divを持つResponseData
     */
    public ResponseData<TaishokensakuJyoukenDiv> onClick_btnClear(TaishokensakuJyoukenDiv div) {
        getHandler(div).onClick_btnClear();
        return ResponseData.of(div).respond();
    }

    /**
     * 介護保険特別会計経理状況登録_検索を「追加する」を押下する。<br/>
     *
     * @param div {@link TaishokensakuDiv 介護保険特別会計経理状況登録_検索情報Div}
     * @return 介護保険特別会計経理状況登録_検索情報Divを持つResponseData
     */
    public ResponseData<TaishokensakuJyoukenDiv> onClick_btnAdd(TaishokensakuJyoukenDiv div) {
        InsuranceInformation isuranceInfEntity = new InsuranceInformation(ADD);
        ViewStateHolder.put(ViewStateKey.様式４, isuranceInfEntity);
        return ResponseData.of(div).forwardWithEventName(追加).respond();
    }

    /**
     * 介護保険特別会計経理状況登録_検索を「修正」を押下する。<br/>
     *
     * @param div {@link TaishokensakuJyoukenDiv 介護保険特別会計経理状況登録_検索情報Div}
     * @return 介護保険特別会計経理状況登録_検索情報Divを持つResponseData
     */
    public ResponseData<TaishokensakuJyoukenDiv> onClick_btnModify(TaishokensakuJyoukenDiv div) {
        InsuranceInformation insuranceInformation = getHandler(div).onClick_btnModify();
        ViewStateHolder.put(ViewStateKey.様式４, insuranceInformation);
        return ResponseData.of(div).forwardWithEventName(修正).respond();
    }

    /**
     * 介護保険特別会計経理状況登録_検索を「削除」を押下する。<br/>
     *
     * @param div {@link TaishokensakuJyoukenDiv 介護保険特別会計経理状況登録_検索情報Div}
     * @return 介護保険特別会計経理状況登録_検索情報Divを持つResponseData
     */
    public ResponseData<TaishokensakuJyoukenDiv> onClick_btnDelete(TaishokensakuJyoukenDiv div) {
        InsuranceInformation insuranceInformation = getHandler(div).onClick_btnDelete();
        ViewStateHolder.put(ViewStateKey.様式４の３, insuranceInformation);
        if (入力済.equals(insuranceInformation.get様式４入力状況())) {
            return ResponseData.of(div).forwardWithEventName(削除).respond();
        } else if (入力済.equals(insuranceInformation.get様式４の２入力状況())) {
            return ResponseData.of(div).forwardWithEventName(様式４の2).respond();
        } else {
            return ResponseData.of(div).forwardWithEventName(様式4の３).respond();
        }
    }

    /**
     * 「報告年度」フォーカスロスト処理する。<br/>
     *
     * @param div {@link TaishokensakuJyoukenDiv 介護保険特別会計経理状況登録_検索情報Div}
     * @return 介護保険特別会計経理状況登録_検索情報Divを持つResponseData
     */
    public ResponseData<TaishokensakuJyoukenDiv> lostFocus(TaishokensakuJyoukenDiv div) {
        getHandler(div).lostFocus();
        return ResponseData.of(div).respond();
    }

    private TaishokensakuJyoukenHandler getHandler(TaishokensakuJyoukenDiv div) {
        return new TaishokensakuJyoukenHandler(div);
    }

    /**
     * 画面遷移定義<br/>
     *
     */
    public enum ViewStateKey {

        /**
         * 介護保険特別会計経理状況登録_様式４の画面に遷移です。
         */
        様式４,
        /**
         * 介護保険特別会計経理状況登録_様式４の２画面に遷移です。
         */
        様式４の2,
        /**
         * 介護保険特別会計経理状況登録_様式４の３の画面に遷移です。
         */
        様式４の３;
    }

}
