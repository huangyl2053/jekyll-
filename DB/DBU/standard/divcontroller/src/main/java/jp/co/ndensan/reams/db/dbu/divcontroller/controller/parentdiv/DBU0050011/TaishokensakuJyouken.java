/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0050011;

import jp.co.ndensan.reams.db.dbu.business.core.kaigohokentokubetukaikeikeirijyokyoregist.InsuranceInformation;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050011.DBU0050011TransitionEventName;
import static jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050011.DBU0050011TransitionEventName.削除;
import static jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050011.DBU0050011TransitionEventName.追加;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050011.TaishokensakuJyoukenDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0050011.TaishokensakuJyoukenHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 介護保険特別会計経理状況登録_検索情報Divを制御します。
 *
 * @reamsid_L DBU-1130-010 wangjie2
 */
public class TaishokensakuJyouken {

    private static final RString 入力済 = new RString("入力済");
    private static final RString ADD = new RString("add");
    private static final RString 様式４ = new RString("様式４");
    private static final RString 様式４の２ = new RString("様式４の２");
    private static final RString 様式４の３ = new RString("様式４の３");

    /**
     * 介護保険特別会計経理状況登録_検索を画面初期化処理しました。
     *
     * @param div {@link TaishokensakuJyoukenDiv 介護保険特別会計経理状況登録_検索情報Div}
     * @return 介護保険特別会計経理状況登録_検索情報Divを持つResponseData
     */
    public ResponseData<TaishokensakuJyoukenDiv> onload(TaishokensakuJyoukenDiv div) {
        Boolean is詳細画面から = ViewStateHolder.get(ViewStateKeys.is詳細画面から, Boolean.class);
        RString 市町村名称 = ViewStateHolder.get(ViewStateKeys.選択市町村名称, RString.class);
        getHandler(div).onload(is詳細画面から, 市町村名称);
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
        InsuranceInformation isuranceInfEntity = new InsuranceInformation(ADD,
                getHandler(div).get市町村コード(div.getDdlShichoson().getSelectedKey()),
                div.getDdlShichoson().getSelectedValue());
        ViewStateHolder.put(ViewStateKeys.様式４, isuranceInfEntity);
        ViewStateHolder.put(ViewStateKeys.選択市町村名称, div.getDdlShichoson().getSelectedValue());
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
        ViewStateHolder.put(ViewStateKeys.様式４, insuranceInformation);
        ViewStateHolder.put(ViewStateKeys.選択市町村名称, div.getDdlShichoson().getSelectedValue());
        return ResponseData.of(div).forwardWithEventName(DBU0050011TransitionEventName.修正).respond();
    }

    /**
     * 介護保険特別会計経理状況登録_検索を「削除」を押下する。<br/>
     *
     * @param div {@link TaishokensakuJyoukenDiv 介護保険特別会計経理状況登録_検索情報Div}
     * @return 介護保険特別会計経理状況登録_検索情報Divを持つResponseData
     */
    public ResponseData<TaishokensakuJyoukenDiv> onClick_btnDelete(TaishokensakuJyoukenDiv div) {
        InsuranceInformation insuranceInformation = getHandler(div).onClick_btnDelete();
        ViewStateHolder.put(ViewStateKeys.様式４, insuranceInformation);
        ViewStateHolder.put(ViewStateKeys.選択市町村名称, div.getDdlShichoson().getSelectedValue());
        if (入力済.equals(insuranceInformation.get様式４入力状況())) {
            return ResponseData.of(div).forwardWithEventName(削除).parameter(様式４);
        } else if (入力済.equals(insuranceInformation.get様式４の２入力状況())) {
            return ResponseData.of(div).forwardWithEventName(削除).parameter(様式４の２);
        } else {
            return ResponseData.of(div).forwardWithEventName(削除).parameter(様式４の３);
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

}
