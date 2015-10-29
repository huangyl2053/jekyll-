/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.SearchHihokenshaPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.searchResultOfHihokensha.dgSearchResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * 住宅改修費事申請登録 被保険者検索条件パネルです。
 *
 * @author n8223 朴義一
 */
public class SearchHihokenshaPanel {

    /**
     * 住宅改修費事申請登録 被保険者検索条件情報の初期値をセットします。（初期画面）
     *
     * @param panel HihokenshaSearchPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<SearchHihokenshaPanelDiv> onLoad(SearchHihokenshaPanelDiv panel) {
        ResponseData<SearchHihokenshaPanelDiv> response = new ResponseData<>();

        //TO DO　被保険者の検索の内容を閉じる
//        panel.getHihokenshaFinder().getSearchCriteriaOfHihokensha().setIsOpen(false);
        /////////////////////////////////////////////////////////////////////////////////////////
        //TO DO  JutakuData1.xml ①
        List<HashMap> ymlData = ymlData();

        //TO DO  JutakuData1.xml Read　②
//        RString hihokenshaNo = new RString(ymlData.get(0).get("hihokenshaNo").toString());
       /////////////////////////////////////////////////////////////////////////////////////////

        //TO DO  JutakuData.xml Write　③
//        panel.getHihokenshaFinder().getSearchCriteriaOfHihokensha().getTxtHihokenshaNo().setValue(new RString(hihokenshaNo));
        response.data = panel;
        return response;
    }

    /**
     * 住宅改修費事申請登録 被保険者検索条件情報の初期値をセットします。(被保険者検索に戻る時）
     *
     *
     * @param panel HihokenshaSearchPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<SearchHihokenshaPanelDiv> onClick_btnReturnHihokensha(SearchHihokenshaPanelDiv panel) {
        ResponseData<SearchHihokenshaPanelDiv> response = new ResponseData<>();

//        //TO DO　被保険者の検索の内容を閉じる
//        panel.getHihokenshaFinder().getSearchCriteriaOfHihokensha().setIsOpen(false);
        /////////////////////////////////////////////////////////////////////////////////////////
        //TO DO  JutakuData1.xml ①
        List<HashMap> ymlData = ymlData();

        //TO DO  JutakuData1.xml Read　②
//        RString hihokenshaNo = new RString(ymlData.get(0).get("hihokenshaNo").toString());
       /////////////////////////////////////////////////////////////////////////////////////////

        //TO DO  JutakuData.xml Write　③
//        panel.getHihokenshaFinder().getSearchCriteriaOfHihokensha().getTxtHihokenshaNo().setValue(new RString(hihokenshaNo));
        response.data = panel;
        return response;
    }

    /**
     * 住宅改修費事申請登録 検索結一覧情報をセットします。
     *
     * @param panel HihokenshaSearchPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<SearchHihokenshaPanelDiv> onClick_btnSearch(SearchHihokenshaPanelDiv panel) {
        ResponseData<SearchHihokenshaPanelDiv> response = new ResponseData<>();

        List<dgSearchResult_Row> arraydata = createRowShikyuShinseiTestData();
        DataGrid<dgSearchResult_Row> grid = panel.getHihokenshaSearchResult().getDgSearchResult();
        grid.setDataSource(arraydata);

        response.data = panel;
        return response;

    }

    /*
     * 住宅改修費事申請登録 検索結果の情報を設定する。
     */
    private List<dgSearchResult_Row> createRowShikyuShinseiTestData() {

        List<dgSearchResult_Row> arrayData = new ArrayList<>();

/////////////////////////////////////////////////////////////////////////////////////////
        //TO DO  JutakuData1.xml ①
        List<HashMap> ymlData = ymlData();

        //TO DO データを増える場合。
        //  for (int i = 1; i < ymlData.size(); i++) {
        HashMap hashMap = ymlData.get(1);

        RString hihokenshaNo = new RString(hashMap.get("hihokenshaNo").toString()); //被保番号
        RString shikibetsuCode = new RString(hashMap.get("shikibetsuCode").toString()); //識別コード
        RString hihokenshaKubun = new RString(hashMap.get("hihokenshaKubun").toString()); //被保険者区分
        RString shimeiAndKanaShimsei = new RString(hashMap.get("shimeiAndKanaShimsei").toString()); //氏名
        RString gender = new RString(hashMap.get("gender").toString()); //性別
        RString birthDay = new RString(hashMap.get("birthDay").toString()); //生年月日
        RString yubinNo = new RString(hashMap.get("yubinNo").toString()); //郵便番号
        RString jusho = new RString(hashMap.get("jusho").toString()); // 住所
        RString juminShubetsu = new RString(hashMap.get("yubinNo").toString()); //住民種別
        RString setaiCode = new RString(hashMap.get("setaiCode").toString()); //世帯コード
/////////////////////////////////////////////////////////////////////////////////////////

        dgSearchResult_Row item;

        item = createRowSearchHihokenshaiListData(
                hihokenshaNo,
                shikibetsuCode,
                hihokenshaKubun,
                shimeiAndKanaShimsei,
                gender,
                birthDay,
                yubinNo,
                jusho,
                juminShubetsu,
                setaiCode
        );
        arrayData.add(item);
        // }
        return arrayData;

    }

    /*
     * 引数を元にデータグリッド内に挿入する個人データを作成します。
     */
    private dgSearchResult_Row createRowSearchHihokenshaiListData(RString 被保番号,
            RString 識別コード,
            RString 被保険者区分,
            RString 氏名,
            RString 性別,
            RString 生年月日,
            RString 郵便番号,
            RString 住所,
            RString 住民種別,
            RString 世帯コード) {

        dgSearchResult_Row rowHihokenshaiListData;
        rowHihokenshaiListData = new dgSearchResult_Row(
                new Button(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                new TextBoxDate(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY
        );

        rowHihokenshaiListData.setHihokenshaNo(被保番号);
        rowHihokenshaiListData.setShikibetsuCode(識別コード);
        rowHihokenshaiListData.setHihokenshaKubun(被保険者区分);
        rowHihokenshaiListData.setShimeiAndKanaShimsei(氏名);
        rowHihokenshaiListData.setGender(性別);
        rowHihokenshaiListData.getBirthDay().setValue(new RDate(生年月日.toString()));
        rowHihokenshaiListData.setYubinNo(郵便番号);
        rowHihokenshaiListData.setJusho(住所);
        rowHihokenshaiListData.setKojinNo(住民種別);
        rowHihokenshaiListData.setSetaiCode(世帯コード);

        return rowHihokenshaiListData;

    }

    // TO DO  JutakuData１.xml ①
    private List<HashMap> ymlData() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("JutakuData_1.yml"));
    }

}
