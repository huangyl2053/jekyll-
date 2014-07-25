/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.IMinashi2GoshaDaicho;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.YokaigoninteiShinseishaData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001.HihokenshaSearchForShinseiDiv;
import jp.co.ndensan.reams.db.dbe.realservice.IMinashi2GoshaDaichoFinder;
//import jp.co.ndensan.reams.db.dbe.realservice.Minashi2GoshaDaichoFinder;
import jp.co.ndensan.reams.db.dbe.realservice.Minashi2GoshaDaichoFinderFactory;
import jp.co.ndensan.reams.db.dbe.realservice.search.Minashi2GoshaDaichoSearchItem;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.HihokenshaFinder;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.SearchResultOfHihokensha;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfHihokenshaDiv;
import jp.co.ndensan.reams.ur.urz.realservice.search.INewSearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.SearchConditionFactory;
import jp.co.ndensan.reams.ur.urz.realservice.search.StringOperator;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請時に、対象となる被保険者を検索するDivを制御します。
 *
 * @author N3327 三浦 凌
 */
public class HihokenshaSearchForShinsei {

    /**
     * onLoad
     *
     * @param panel HihokenshaSearchForShinseiDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshaSearchForShinseiDiv> onLoad(HihokenshaSearchForShinseiDiv panel) {
        HihokenshaFinder.setMode(HihokenshaFinder.Mode.NORMAL, panel.getSearchCriteriaForShinsei());
        return _createResponseData(panel);
    }

    /**
     * 検索ボタン押下時の処理です。
     *
     * @param panel HihokenshaSearchForShinseiDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshaSearchForShinseiDiv> onClick_btnToSearch(HihokenshaSearchForShinseiDiv panel) {

        // TODO 田辺 紘一 ここに値が入らなくなったので、Yamlで動作する状態のまま
//        List yokaigoNinteiShinseishaList = get要介護認定申請者List(panel.getSearchCriteriaForShinsei().getSearchCriteriaOfHihokensha());
        SearchResultOfHihokensha.setSearchResult(panel.getSearchResultForShinsei(),
                new YokaigoninteiShinseishaData().get要介護認定申請者List().asConvertedType());
        return _createResponseData(panel);
    }

    /**
     *
     * @param panel HihokenshaSearchForShinseiDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshaSearchForShinseiDiv> onClick_btnToDecide(HihokenshaSearchForShinseiDiv panel) {
        YokaigoNinteiShinseisha.getInstance().save(panel.getSearchResultForShinsei().getDgSearchResult().getClickedItem());
        return _createResponseData(panel);
    }

    private ResponseData<HihokenshaSearchForShinseiDiv> _createResponseData(HihokenshaSearchForShinseiDiv panel) {
        ResponseData<HihokenshaSearchForShinseiDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    /**
     * 要介護認定申請者の検索結果を返します。
     *
     * @return 要介護認定申請者の検索結果
     */
    public List<IMinashi2GoshaDaicho> get要介護認定申請者List(SearchCriteriaOfHihokenshaDiv div) {

        // keyに市町村コードが入る事を想定している。
        INewSearchCondition 市町村コード = SearchConditionFactory.condition(Minashi2GoshaDaichoSearchItem.市町村コード, StringOperator.完全一致, div.getDdlHokensha().getSelectedItem());
        INewSearchCondition 被保番号 = SearchConditionFactory.condition(Minashi2GoshaDaichoSearchItem.被保番号, StringOperator.完全一致, div.getTxtHihokenshaNo().getValue());
        INewSearchCondition みなし2号 = SearchConditionFactory.condition(Minashi2GoshaDaichoSearchItem.みなし2号, StringOperator.完全一致, new RString("1"));

        ISearchCondition result = 市町村コード.and(被保番号).and(みなし2号);

        // TODO 田辺 紘一 クラスを読めない状態なので、これ以降エラーが出る
//        IMinashi2GoshaDaichoFinder minashi2GoshaDaichoFinder = Minashi2GoshaDaichoFinderFactory.createInstance();
//
//        List<IMinashi2GoshaDaicho> minashi2GoshaDaicho = minashi2GoshaDaichoFinder.getみなし2号者台帳(result);
//
//        if (minashi2GoshaDaichoFinder.existみなし2号者台帳(result)) {
//            return minashi2GoshaDaicho;
//        }
        return null;
    }
}
