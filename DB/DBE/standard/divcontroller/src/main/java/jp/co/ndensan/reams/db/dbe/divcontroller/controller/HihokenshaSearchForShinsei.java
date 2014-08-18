/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.Minashi2GoshaList;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiTaishoshaList;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001.HihokenshaSearchForShinseiDiv;
import jp.co.ndensan.reams.db.dbe.realservice.Minashi2GoshaFinder;
import jp.co.ndensan.reams.db.dbe.realservice.search.Minashi2GoshaDaichoSearchItem;
import jp.co.ndensan.reams.db.dbz.business.HihokenshaList;
import jp.co.ndensan.reams.db.dbz.business.INinteiShinseiTaishosha;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.HihokenshaFinder;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.HihokenshaForSearchResult;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.IHihokenshaForSearchResult;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.SearchResultOfHihokensha;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfHihokenshaDiv;
import jp.co.ndensan.reams.db.dbz.realservice.search.HihokenshaSearchItem;
import jp.co.ndensan.reams.ur.urz.realservice.search.INewSearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.SearchConditionFactory;
import jp.co.ndensan.reams.ur.urz.realservice.search.StringOperator;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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

        List yokaigoNinteiShinseishaList = get要介護認定申請者List(panel.getSearchCriteriaForShinsei().getSearchCriteriaOfHihokensha());

//        SearchResultOfHihokensha.setSearchResult(panel.getSearchResultForShinsei(),
//                new YokaigoninteiShinseishaData().get要介護認定申請者List().asConvertedType());
        SearchResultOfHihokensha.setSearchResult(panel.getSearchResultForShinsei(), yokaigoNinteiShinseishaList);
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
     * @param div SearchCriteriaOfHihokenshaDiv
     * @return 要介護認定申請者の検索結果
     */
    public List<IHihokenshaForSearchResult> get要介護認定申請者List(SearchCriteriaOfHihokenshaDiv div) {

        HihokenshaList hihokenshaList = new jp.co.ndensan.reams.db.dbz.realservice.HihokenshaFinder()
                .get被保険者List(createHihokenshaSearchCondition(div));

//        if (div.getSearchCriteriaDetail().getRadMinashiNigo().getSelectedIndex() == 1) {
        Minashi2GoshaList minashi2GoshaList = new Minashi2GoshaFinder()
                .getみなし2号者List(createMinashi2GoSearchCondition(div));
//        }

        NinteiShinseiTaishoshaList taishoshaList = new NinteiShinseiTaishoshaList(hihokenshaList, minashi2GoshaList);
        return toHihokneshaForSearchResult(taishoshaList);
    }

    private ISearchCondition createHihokenshaSearchCondition(SearchCriteriaOfHihokenshaDiv div) {

        LasdecCode 市町村コード = new LasdecCode("123456");
//        LasdecCode 市町村コード = new LasdecCode(div.getDdlHokensha().getSelectedItem());
        KaigoHihokenshaNo 被保険者番号 = new KaigoHihokenshaNo(div.getTxtHihokenshaNo().getValue());

        INewSearchCondition 市町村コード検索条件 = SearchConditionFactory.condition(HihokenshaSearchItem.市町村コード,
                StringOperator.完全一致, new RString(市町村コード.toString()));
        INewSearchCondition 被保番号検索条件 = SearchConditionFactory.condition(HihokenshaSearchItem.被保険者番号,
                StringOperator.完全一致, 被保険者番号.getColumnValue());
        return createSearchCondition(市町村コード検索条件, 被保番号検索条件);
    }

    private ISearchCondition createMinashi2GoSearchCondition(SearchCriteriaOfHihokenshaDiv div) {

        LasdecCode 市町村コード = new LasdecCode("123456");
//        LasdecCode 市町村コード = new LasdecCode(div.getDdlHokensha().getSelectedItem());
        KaigoHihokenshaNo 被保険者番号 = new KaigoHihokenshaNo(div.getTxtHihokenshaNo().getValue());

        INewSearchCondition 市町村コード検索条件 = SearchConditionFactory.condition(Minashi2GoshaDaichoSearchItem.市町村コード,
                StringOperator.完全一致, new RString(市町村コード.toString()));
        INewSearchCondition 被保番号検索条件 = SearchConditionFactory.condition(Minashi2GoshaDaichoSearchItem.被保険者番号,
                StringOperator.完全一致, 被保険者番号.getColumnValue());
        return createSearchCondition(市町村コード検索条件, 被保番号検索条件);
    }

    private ISearchCondition createSearchCondition(INewSearchCondition 市町村コード, INewSearchCondition 被保番号) {
        ISearchCondition result = 市町村コード.and(被保番号);
        return result;
    }

    private List<IHihokenshaForSearchResult> toHihokneshaForSearchResult(NinteiShinseiTaishoshaList taishoshaList) {
        List<IHihokenshaForSearchResult> resultList = new ArrayList<>();
        for (INinteiShinseiTaishosha taishosha : taishoshaList) {
            resultList.add(
                    new HihokenshaForSearchResult(taishosha.get被保険者番号(),
                            taishosha.get識別コード(),
                            taishosha.get被保険者区分().getMeisho(),
                            taishosha.get氏名().getName().getColumnValue(),
                            taishosha.get氏名().getKana().getColumnValue(),
                            taishosha.get性別(),
                            taishosha.get生年月日().toDate(),
                            taishosha.get住所().get郵便番号(),
                            new AtenaJusho(taishosha.get住所().getValue()),
                            taishosha.get個人番号(),
                            taishosha.get住民種別(),
                            taishosha.get世帯コード())
            );

        }
        return resultList;
    }
}
