/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.dbe4070001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001.dgShinsakaiList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001.ShinsakaiSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 審査会資料作成時の審査会選択Divの処理を表します。
 *
 * @author N1013 松本直樹
 */
public class ShinsakaiSearch {

    /**
     * 審査会選択Divをロード時の処理を表します。
     *
     * @param div 審査会選択Div
     * @return ResponseData
     */
    public ResponseData onLoadData(ShinsakaiSearchDiv div) {
        ResponseData<ShinsakaiSearchDiv> response = new ResponseData<>();

        div.getSearchCriteriaForShinsakai().getTxtKaisaiDateRange().setFromValue(RDate.getNowDate());
//        div.getSearchCriteriaForShinsakai().getTxtKaisaiDateRange().setToValue(RDate.getNowDate().plusDay(7));

        response.data = div;
        return response;
    }

    /**
     * 審査会選択Divの「検索する」ボタン押下時の処理を表します。
     *
     * @param div 審査会選択Div
     * @return ResponseData
     */
    public ResponseData onClick_btnToSearchShinsakai(ShinsakaiSearchDiv div) {
        ResponseData<ShinsakaiSearchDiv> response = new ResponseData<>();

        RString ymlData = new RString("dbe4070001/ShinsakaiList.yml");
        div.getShinsakaiList().getDgShinsakaiList().setDataSource(createRowSearchResultTestData(ymlData));

        response.data = div;
        return response;
    }

    private List<dgShinsakaiList_Row> createRowSearchResultTestData(RString ymlData) {
        List<dgShinsakaiList_Row> arrayData = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(ymlData);
        for (Map info : targetSource) {
            arrayData.add(toDgShinsakaiList_Row(info));
        }

        return arrayData;
    }

    private dgShinsakaiList_Row toDgShinsakaiList_Row(Map map) {
        TextBoxFlexibleDate kaisaiDate = toTextBoxFlexibleDate(new FlexibleDate(map.get("開催予定日").toString()));
        RString kaisaiNo = _toRString(map.get("開催番号"));
        RString gogitaiNo = _toRString(map.get("合議体番号"));
        RString gogitaiMeisho = _toRString(map.get("合議体名称"));
        RString yoteiTeiin = _toRString(map.get("予定定員"));
        RString wariateNinzu = _toRString(map.get("割当人数"));
        RString shinsakaiKaijo = _toRString(map.get("審査会会場"));
        RString startTime = _toRString(map.get("開始予定時刻"));
        RString sakuseiKubun = _toRString(map.get("資料作成"));

        Button btn = new Button();
        dgShinsakaiList_Row row = new dgShinsakaiList_Row(btn, kaisaiDate, kaisaiNo, gogitaiNo,
                gogitaiMeisho, yoteiTeiin, wariateNinzu, shinsakaiKaijo, startTime, sakuseiKubun);
        return row;
    }

    private RString _toRString(Object obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return new RString(obj.toString());
    }

    private TextBoxFlexibleDate toTextBoxFlexibleDate(FlexibleDate date) {
        TextBoxFlexibleDate txtBox = new TextBoxFlexibleDate();
        txtBox.setValue(date);
        return txtBox;
    }

}
