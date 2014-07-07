/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0010003.FukaTaishoSearchDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0010003.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.HihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 *
 * @author n8211 田辺 紘一
 */
public class FukaTaishoSearch {

    private static final RString FUKA_SHOKAI_GAITOSHA = new RString("DBZU030001/FukaShokaiGaitoshaData.yml");
    private static final Decimal DEFAULT_MAX_NUMBER = new Decimal(30);

    public ResponseData<FukaTaishoSearchDiv> onLoad_FukaTaishoSearch(FukaTaishoSearchDiv div) {

        div.getTaishoshaSearch().getSearchCriteriaOfOther().getTxtMaxNumber().setValue(DEFAULT_MAX_NUMBER);

        DropDownList ddl = new DropDownList();
        ddl.setDataSource(createFukanendoDDL());
        div.getTaishoshaSearch().getSearchCriteriaOfOther().setDdlFukaNendo(ddl);
        div.getTaishoshaSearch().getSearchCriteriaOfOther().getDdlFukaNendo().setSelectedItem(new RString(("平成26年度")));
        div.getTaishoshaSearch().getSearchCriteriaOfOther().getDdlFukaNendo().setLabelLText(new RString("賦課年度"));
        return createResponseData(div);
    }

    public ResponseData<FukaTaishoSearchDiv> onClick_Search(FukaTaishoSearchDiv div) {

        search(div);

        return createResponseData(div);
    }

    private ResponseData<FukaTaishoSearchDiv> createResponseData(FukaTaishoSearchDiv div) {
        ResponseData<FukaTaishoSearchDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    private void search(FukaTaishoSearchDiv div) {
        Map searchValue = getSearchValue(div.getTaishoshaSearch());

        List yamlSearchResult = getYamlSearchResult(div, searchValue);

        RString selectedValue = div.getTaishoshaSearch().getSearchCriteriaOfOther().getDdlFukaNendo().getSelectedValue();
        if (selectedValue == null || selectedValue.isEmpty()) {
        } else {
            div.getTaishoshaSentaku().getTxtFukanendo().setValue(new RDate(selectedValue.toString()));
        }

        setDataGrid(div, yamlSearchResult);
    }

    private Map getSearchValue(HihokenshaFinderDiv div) {

        Map<String, Object> searchValue = new HashMap<>();

        if (div.getSearchCriteriaOfHihokensha().getTxtHihokenshaNo().getValue().length() > 0) {
            searchValue.put("被保番号", div.getSearchCriteriaOfHihokensha().getTxtHihokenshaNo().getValue());
        }

        if (div.getSearchCriteriaOfHihokensha().getTxtTuchishoNo().getValue().length() > 0) {
            searchValue.put("通知書番号", div.getSearchCriteriaOfHihokensha().getTxtTuchishoNo().getValue());
        }

        if (div.getSearchCriteriaOfKojin().getTxtShikibetsuCode().getValue().length() > 0) {
            searchValue.put("識別コード", div.getSearchCriteriaOfKojin().getTxtShikibetsuCode().getValue());
        }

        if (div.getSearchCriteriaOfKojin().getTxtSetaiCode().getValue().length() > 0) {
            searchValue.put("世帯コード", div.getSearchCriteriaOfKojin().getTxtSetaiCode().getValue());
        }

        if (div.getSearchCriteriaOfKojin().getTxtKojinNo().getValue().length() > 0) {
            searchValue.put("個人番号", div.getSearchCriteriaOfKojin().getTxtKojinNo().getValue());
        }

        if (!div.getSearchCriteriaOfKojin().getDdlJuminShubetsu().getSelectedValue().equals(new RString("指定なし"))) {
            searchValue.put("住民種別", div.getSearchCriteriaOfKojin().getDdlJuminShubetsu().getSelectedValue());
        }

        if (div.getSearchCriteriaOfKojin().getTxtShimei().getValue().length() > 0) {
            searchValue.put("氏名", div.getSearchCriteriaOfKojin().getTxtShimei().getValue());
            searchValue.put("検索条件_氏名", div.getSearchCriteriaOfKojin().getDdlSearchPatternForName().getSelectedValue());
        }

        if (div.getSearchCriteriaOfKojin().getTxtYubinNo().getValue() != null) {
            searchValue.put("郵便番号", div.getSearchCriteriaOfKojin().getTxtYubinNo().getValue());
        }

        if (div.getSearchCriteriaOfKojin().getTxtJusho().getValue().length() > 0) {
            searchValue.put("住所", div.getSearchCriteriaOfKojin().getTxtJusho().getValue());
        }

        if (div.getSearchCriteriaOfKojin().getTxtBirthDay().getValue() != null) {
            searchValue.put("生年月日", div.getSearchCriteriaOfKojin().getTxtBirthDay().getText());
        }

        if (div.getSearchCriteriaOfKojin().getChkGender().getSelectedValues().size() > 0) {
            searchValue.put("性別", div.getSearchCriteriaOfKojin().getChkGender().getSelectedValues().get(0));
        }

        if (div.getSearchCriteriaOfOther().getDdlFukaNendo().getSelectedValue().length() > 0) {
            searchValue.put("賦課年度", div.getSearchCriteriaOfOther().getDdlFukaNendo().getSelectedValue());
        }

        return searchValue;
    }

    private List getYamlSearchResult(FukaTaishoSearchDiv div, Map<String, Object> searchValue) {

        List searchResult = new ArrayList();

        for (String key : searchValue.keySet()) {

            switch (key) {
                case "氏名":
                    if (searchValue.containsKey(key)) {
                        searchResult = getNameSearchResult(searchValue, searchResult, new RString(key), (RString) searchValue.get("検索条件_氏名"));
                    }
                    break;
                default:
                    if (searchValue.containsKey(key)) {
                        if (searchResult.isEmpty()) {
                            searchResult = getSearchResult(searchValue, new RString(key));
                        } else {
                            searchResult = getSearchResultFilter(searchValue, new RString(key), searchResult);
                        }
                    }
            }
        }

        return searchResult;
    }

    /**
     * 完全一致検索
     *
     * @param cgValue
     * @param key
     * @return
     */
    private boolean yamlDataPresenceCheck(RString cgValue, RString key) {
        return cgValue.equals(key);
    }

    /**
     * 部分一致検索
     *
     * @param cgValue
     * @param key
     * @return
     */
    private boolean yamlDataFuzzyPresenceCheck(RString cgValue, RString key) {
        return cgValue.contains(key);
    }

    /**
     * 前方一致検索
     *
     * @param cgValue
     * @param key
     * @return
     */
    private boolean yamlDataForwardMatchCheck(RString cgValue, RString key) {
        return cgValue.startsWith(key);
    }

    /**
     * 後方一致検索
     *
     * @param cgValue
     * @param key
     * @return
     */
    private boolean yamlDataBackwardMatchCheck(RString cgValue, RString key) {
        return cgValue.endsWith(key);
    }

    private List getSearchResult(Map searchValue, RString target) {

        List searchResult = new ArrayList();

        List<HashMap> yamlDataList = YamlLoader.DBZ.loadAsList(FUKA_SHOKAI_GAITOSHA);

        for (HashMap yamlData : yamlDataList) {
            ControlGenerator cg = new ControlGenerator(yamlData);

            if (yamlDataPresenceCheck((RString) cg.getAsRString(target.toString()), (RString) searchValue.get(target.toString()))) {
                searchResult.add(cg);
            }
        }
        return searchResult;
    }

    private List getSearchResultFilter(Map searchValue, RString target, List searchResultFilter) {

        List searchResult = new ArrayList();

        for (int i = 0; i < searchResultFilter.size(); i++) {
            ControlGenerator cg = (ControlGenerator) searchResultFilter.get(i);

            if (yamlDataPresenceCheck((RString) cg.getAsRString(target.toString()), (RString) searchValue.get(target.toString()))) {
                searchResult.add(cg);
            }
        }
        return searchResult;
    }

    private List getNameSearchResult(Map searchValue, List searchResult, RString target, RString key) {

        List<HashMap> yamlDataList = YamlLoader.DBZ.loadAsList(FUKA_SHOKAI_GAITOSHA);

        switch (key.toString()) {
            case "前方一致":
                for (HashMap yamlData : yamlDataList) {
                    ControlGenerator cg = new ControlGenerator(yamlData);
                    if (yamlDataForwardMatchCheck((RString) cg.getAsRString(target.toString()), (RString) searchValue.get(target.toString()))) {
                        searchResult.add(cg);
                    }
                }
                break;
            case "後方一致":
                for (HashMap yamlData : yamlDataList) {
                    ControlGenerator cg = new ControlGenerator(yamlData);
                    if (yamlDataBackwardMatchCheck((RString) cg.getAsRString(target.toString()), (RString) searchValue.get(target.toString()))) {
                        searchResult.add(cg);
                    }
                }
                break;
            case "完全一致":
                for (HashMap yamlData : yamlDataList) {
                    ControlGenerator cg = new ControlGenerator(yamlData);
                    if (yamlDataPresenceCheck((RString) cg.getAsRString(target.toString()), (RString) searchValue.get(target.toString()))) {
                        searchResult.add(cg);
                    }
                }
                break;

            case "部分一致":
                for (HashMap yamlData : yamlDataList) {
                    ControlGenerator cg = new ControlGenerator(yamlData);
                    if (yamlDataFuzzyPresenceCheck((RString) cg.getAsRString(target.toString()), (RString) searchValue.get(target.toString()))) {
                        searchResult.add(cg);
                    }
                }
                break;
        }

        return searchResult;
    }

    private void setDataGrid(FukaTaishoSearchDiv div, List searchResult) {
        List<dgTaishoshaIchiran_Row> arrayRowList = new ArrayList<>();
        for (int i = 0; i < searchResult.size(); i++) {
            dgTaishoshaIchiran_Row row
                    = new dgTaishoshaIchiran_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

            ControlGenerator cg = (ControlGenerator) searchResult.get(i);

            row.setTxtChoteiNendo(cg.getAsRString("調定年度"));
            row.setTxtTsuchiNo(cg.getAsRString("通知書番号"));
            row.setTxtHihoNo(cg.getAsRString("被保番号"));
            row.setTxtName(cg.getAsRString("氏名"));
            row.setTxtUmareYmd(cg.getAsTextBoxFlexibleDate("生年月日"));
            row.setTxtSeibetsu(cg.getAsRString("性別"));
            row.setTxtShubetsu(cg.getAsRString("種別"));
            row.setTxtJusho(cg.getAsRString("住所"));
            row.setTxtShikbetsuCode(cg.getAsRString("識別コード"));

            arrayRowList.add(row);
        }

        DataGrid<dgTaishoshaIchiran_Row> grid = div.getTaishoshaSentaku().getDgTaishoshaIchiran();
        grid.setDataSource(arrayRowList);
        grid.setIsTriggerEventOnOnlyRow(true);
    }

    private List<KeyValueDataSource> createFukanendoDDL() {

        List<KeyValueDataSource> arrayDDLList = new ArrayList<>();

        arrayDDLList.add(new KeyValueDataSource(new RString("全年度"), new RString("全年度")));
        arrayDDLList.add(new KeyValueDataSource(new RString("平成26年度"), new RString("平26")));
        arrayDDLList.add(new KeyValueDataSource(new RString("平成25年度"), new RString("平25")));
        arrayDDLList.add(new KeyValueDataSource(new RString("平成24年度"), new RString("平24")));
        arrayDDLList.add(new KeyValueDataSource(new RString("平成23年度"), new RString("平23")));
        arrayDDLList.add(new KeyValueDataSource(new RString("平成22年度"), new RString("平22")));
        arrayDDLList.add(new KeyValueDataSource(new RString("平成21年度"), new RString("平21")));
        arrayDDLList.add(new KeyValueDataSource(new RString("平成20年度"), new RString("平20")));
        arrayDDLList.add(new KeyValueDataSource(new RString("平成19年度"), new RString("平19")));
        arrayDDLList.add(new KeyValueDataSource(new RString("平成18年度"), new RString("平18")));
        arrayDDLList.add(new KeyValueDataSource(new RString("平成17年度"), new RString("平17")));
        arrayDDLList.add(new KeyValueDataSource(new RString("平成16年度"), new RString("平16")));
        arrayDDLList.add(new KeyValueDataSource(new RString("平成15年度"), new RString("平15")));
        arrayDDLList.add(new KeyValueDataSource(new RString("平成14年度"), new RString("平14")));
        arrayDDLList.add(new KeyValueDataSource(new RString("平成13年度"), new RString("平13")));
        arrayDDLList.add(new KeyValueDataSource(new RString("平成12年度"), new RString("平12")));

        return arrayDDLList;
    }
}
