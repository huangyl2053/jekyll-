/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbe.business.IMinashi2GoshaDaicho;
import jp.co.ndensan.reams.db.dbe.business.IShujii;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.YokaigoninteiShinseishaData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001.HihokenshaSearchForShinseiDiv;
import jp.co.ndensan.reams.db.dbe.realservice.IMinashi2GoshaDaichoFinder;
import jp.co.ndensan.reams.db.dbe.realservice.Minashi2GoshaDaichoFinderFactory;
import jp.co.ndensan.reams.db.dbe.realservice.search.Minashi2GoshaDaichoSearchItem;
import jp.co.ndensan.reams.db.dbz.business.Hihokensha;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.HihokenshaFinder;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.HihokenshaForSearchResult;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.IHihokenshaForSearchResult;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.SearchResultOfHihokensha;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfHihokenshaDiv;
import jp.co.ndensan.reams.db.dbz.realservice.IHihokenshaFinder;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.realservice.search.INewSearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.SearchConditionFactory;
import jp.co.ndensan.reams.ur.urz.realservice.search.StringOperator;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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

        List test = new YokaigoninteiShinseishaData().get要介護認定申請者List().asConvertedType();
        List yokaigoNinteiShinseishaList = get要介護認定申請者List(panel.getSearchCriteriaForShinsei().getSearchCriteriaOfHihokensha());

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
    public List<IHihokenshaForSearchResult> get要介護認定申請者List(SearchCriteriaOfHihokenshaDiv div) {

        List<IHihokenshaForSearchResult> results = new ArrayList<>();

        //TODO 田辺 紘一 市町村コードを持ってこれない。
        LasdecCode 市町村コード条件値 = new LasdecCode("123456");
        KaigoHihokenshaNo 被保番号条件値 = new KaigoHihokenshaNo(div.getTxtHihokenshaNo().getValue());
        Hihokensha hihokensha = new jp.co.ndensan.reams.db.dbz.realservice.HihokenshaFinder().get被保険者(市町村コード条件値, 被保番号条件値);

        if (hihokensha == null) {
            List<INewSearchCondition> 検索条件リスト = new ArrayList<INewSearchCondition>();
            INewSearchCondition 市町村コード = SearchConditionFactory.condition(Minashi2GoshaDaichoSearchItem.市町村コード, StringOperator.完全一致, new RString(市町村コード条件値.toString()));
            INewSearchCondition 被保番号 = SearchConditionFactory.condition(Minashi2GoshaDaichoSearchItem.被保番号, StringOperator.完全一致, 被保番号条件値.getColumnValue());
            検索条件リスト = addSearchValueList(検索条件リスト, 市町村コード);
            検索条件リスト = addSearchValueList(検索条件リスト, 被保番号);

            ISearchCondition result = createSearchCondition(市町村コード, 被保番号);

            List<IMinashi2GoshaDaicho> minashi2GoshaDaicho = Minashi2GoshaDaichoFinderFactory.createInstance().getみなし2号者台帳(result);

            for (IMinashi2GoshaDaicho minashi2Go : minashi2GoshaDaicho) {
//                results.add(toIHihokneshaForSearchResult(minashi2Go));
            }
        }

        return results;
    }

    private ISearchCondition createSearchCondition(INewSearchCondition 市町村コード, INewSearchCondition 被保番号) {
        ISearchCondition result = 市町村コード.and(被保番号);
        return result;
    }

//    private IHihokenshaForSearchResult toIHihokneshaForSearchResult(IMinashi2GoshaDaicho minashi2Go) {
//
//        return new HihokenshaForSearchResult(
//                new KaigoHihokenshaNo(minashi2Go.get被保険者番号().value()),
//                new ShikibetsuCode(minashi2Go.get識別コード().value()),
//                minashi2Go.get被保険者区分コード(),
//                minashi2Go.get履歴番号(),
//                RString.EMPTY, Gender.MALE, RDate.MAX, null, null, RString.EMPTY, JuminShubetsu.日本人住民, null);
//
//    }
    private List<INewSearchCondition> addSearchValueList(List<INewSearchCondition> 検索条件リスト, INewSearchCondition 検索条件) {
        if (検索条件 != null) {
            検索条件リスト.add(検索条件);
        }
        return 検索条件リスト;
    }
}
