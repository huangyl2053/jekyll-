package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.SearchHihokenshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.dgSearchResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author n8223
 */
public class SearchHihokensha {

    /**
     * 受給者異動連絡票新規登録 被保険者検索条件情報の初期値をセットします。（初期画面）
     *
     * @param panel HihokenshaSearchPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<SearchHihokenshaDiv> onLoad(SearchHihokenshaDiv panel) {
        ResponseData<SearchHihokenshaDiv> response = new ResponseData<>();

        panel.getSearchConditionOfHihokensha().getSearchCriteriaOfHokensha().setIsOpen(false);
        List<HashMap> ymlData = ymlData();

        String hihokenshaNo = ymlData.get(0).get("hihokenshaNo").toString();
        panel.getSearchConditionOfHihokensha().getSearchCriteriaOfHihokensha().getTxtHihokenshaNo().setValue(new RString(hihokenshaNo));

        response.data = panel;
        return response;
    }

    /**
     * 受給者異動連絡票新規登録 検索結一覧情報をセットします。
     *
     * @param panel HihokenshaSearchPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<SearchHihokenshaDiv> onClick_BtnToSearch(SearchHihokenshaDiv panel) {
        ResponseData<SearchHihokenshaDiv> response = new ResponseData<>();

        List<dgSearchResult_Row> arraydata = createRowShikyuShinseiTestData();
        DataGrid<dgSearchResult_Row> grid = panel.getSearchResultOfHihokensha().getDgSearchResult();
        grid.setDataSource(arraydata);

        response.data = panel;
        return response;

    }

    /*
     * 受給者異動連絡票新規登録 検索結果の情報を設定する。
     */
    private List<dgSearchResult_Row> createRowShikyuShinseiTestData() {

        List<dgSearchResult_Row> arrayData = new ArrayList<>();

        List<HashMap> ymlData = ymlData();
        HashMap hashMap = ymlData.get(1);

        String hihokenshaNo = hashMap.get("hihokenshaNo").toString(); //被保番号
        String shikibetsuCode = hashMap.get("shikibetsuCode").toString(); //識別コード
        String hihokenshaKubun = hashMap.get("hihokenshaKubun").toString(); //被保険者区分
        String shimeiAndKanaShimsei = hashMap.get("shimeiAndKanaShimsei").toString(); //氏名
        String gender = hashMap.get("gender").toString(); //性別
        String birthDay = hashMap.get("birthDay").toString();//生年月日
        String yubinNo = hashMap.get("yubinNo").toString(); //郵便番号
        String jusho = hashMap.get("jusho").toString(); // 住所
        String juminShubetsu = hashMap.get("yubinNo").toString(); //住民種別
        String setaiCode = hashMap.get("setaiCode").toString(); //世帯コード

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
    private dgSearchResult_Row createRowSearchHihokenshaiListData(String 被保番号,
            String 識別コード,
            String 被保険者区分,
            String 氏名,
            String 性別,
            String 生年月日,
            String 郵便番号,
            String 住所,
            String 住民種別,
            String 世帯コード) {

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

        rowHihokenshaiListData.setHihokenshaNo(new RString(被保番号));
        rowHihokenshaiListData.setShikibetsuCode(new RString(識別コード));
        rowHihokenshaiListData.setHihokenshaKubun(new RString(被保険者区分));
        rowHihokenshaiListData.setShimeiAndKanaShimsei(new RString(氏名));
        rowHihokenshaiListData.setGender(new RString(性別));
        rowHihokenshaiListData.getBirthDay().setValue(new RDate(生年月日));
        rowHihokenshaiListData.setYubinNo(new RString(郵便番号));
        rowHihokenshaiListData.setJusho(new RString(住所));
        rowHihokenshaiListData.setKojinNo(new RString(住民種別));
        rowHihokenshaiListData.setSetaiCode(new RString(世帯コード));

        return rowHihokenshaiListData;

    }

    private List<HashMap> ymlData() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("JukyushaIdoRenrakuhyoSearchConditionOfHihokensha.yml"));
    }
}
