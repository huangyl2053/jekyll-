/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011.SearchHihokenshashoHakkoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.dgSearchResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * 被保険者証発行該当者一覧Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class HihokenshashoHakkoTaishoGaitosha {

    /**
     * 被保険者証発行対象者検索条件画面-「以上の条件で検索する」ボタン押下時の処理を表します。
     *
     * @param panel SearchHihokenshashoHakkoDiv
     * @return ResponseData
     */
    public ResponseData<SearchHihokenshashoHakkoDiv> onClick_BtnSearchHihokenshashoHakkoTaishosha(
            SearchHihokenshashoHakkoDiv panel) {
        ResponseData<SearchHihokenshashoHakkoDiv> response = new ResponseData<>();

        setHihokenshashoHakkoTaishoshaData(panel);

        //該当者一覧パネルをオープン
        panel.getCcdHihokenshashoHakkoTaishoGaitosha().setIsOpen(true);

        //「再検索する」ボタンを非活性
        panel.getCcdHihokenshashoHakkoTaishoGaitosha().getButtonsForSearchResultOfHihokensha().setDisplayNone(true);

        List<dgSearchResult_Row> arrayList = panel.getCcdHihokenshashoHakkoTaishoGaitosha().getDgSearchResult().getDataSource();
        for (int i = 0; i < arrayList.size(); i++) {
            dgSearchResult_Row searchResult_Row = arrayList.get(i);

            searchResult_Row.getBirthDay().setReadOnly(true);
        }

        response.data = panel;
        return response;

    }

    /*
     *被保険者証発行対象者情報を設定します。
     */
    private void setHihokenshashoHakkoTaishoshaData(SearchHihokenshashoHakkoDiv panel) {

        List<HashMap> hihokenshashoHakkoTaishoshaList = YamlLoader.DBU.loadAsList(
                new RString("dbu0410011/HihokenshashoHakkoTaishoshaList.yml"));

        List arraydata = createRowHihokenshashoHakkoTaishoshaList(hihokenshashoHakkoTaishoshaList);
        DataGrid grid = panel.getCcdHihokenshashoHakkoTaishoGaitosha().getDgSearchResult();
        grid.setDataSource(arraydata);

    }

    /*
     *被保険者証発行対象者情報の初期値をセットします。
     */
    private List createRowHihokenshashoHakkoTaishoshaList(
            List<HashMap> hihokenshashoHakkoTaishoshaList) {

        List arrayDataList = new ArrayList();

        for (int i = 1; i < hihokenshashoHakkoTaishoshaList.size(); i++) {
            HashMap hashMap = hihokenshashoHakkoTaishoshaList.get(i);
            ControlGenerator ymlData = new ControlGenerator(hashMap);

            RString rsHihoNo = ymlData.getAsRString("hihoNo");
            RString rsShikibetsuCode = ymlData.getAsRString("shikibetsuCode");
            RString rsHihokenshaKbn = ymlData.getAsRString("hihokenshaKbn");
            RString rsShimei = ymlData.getAsRString("shimei");
            RString rsKanashimei = ymlData.getAsRString("kanashimei");
            RString rsShimeiAndKanaShimei = ymlData.getAsRString("shimeiAndKanaShimei");
            RString rsSeibetsu = ymlData.getAsRString("seibetsu");
            TextBoxDate tdBirthday = ymlData.getAsTextBoxDate("birthday");
            RString rsYubinNo = ymlData.getAsRString("yubinNo");
            RString rsJusho = ymlData.getAsRString("jusho");
            RString rsKojinNo = ymlData.getAsRString("kojinNo");
            RString rsJuminShubetsu = ymlData.getAsRString("juminShubetsu");
            RString rsSetaiCode = ymlData.getAsRString("setaiCode");

            arrayDataList.add(createRowHihokenshashoHakkoTaishoshaList(
                    rsHihoNo,
                    rsShikibetsuCode,
                    rsHihokenshaKbn,
                    rsShimei,
                    rsKanashimei,
                    rsShimeiAndKanaShimei,
                    rsSeibetsu,
                    tdBirthday,
                    rsYubinNo,
                    rsJusho,
                    rsKojinNo,
                    rsJuminShubetsu,
                    rsSetaiCode
            ));

        }
        return arrayDataList;
    }

    /*
     *引数を元にデータグリッド内に挿入する被保険者証発行対象者情報データを作成します。
     */
    private dgSearchResult_Row createRowHihokenshashoHakkoTaishoshaList(
            RString hihoNo,
            RString shikibetsuCode,
            RString hihokenshaKbn,
            RString shimei,
            RString kanashimei,
            RString shimeiAndKanaShimei,
            RString seibetsu,
            TextBoxDate birthday,
            RString yubinNo,
            RString jusho,
            RString kojinNo,
            RString juminShubetsu,
            RString setaiCode
    ) {
        dgSearchResult_Row rowHihokenshashoHakkoTaishoshaList
                = new dgSearchResult_Row(
                        new Button(),
                        hihoNo,
                        shikibetsuCode,
                        hihokenshaKbn,
                        shimei,
                        kanashimei,
                        shimeiAndKanaShimei,
                        seibetsu,
                        birthday,
                        yubinNo,
                        jusho,
                        kojinNo,
                        juminShubetsu,
                        setaiCode
                );
        return rowHihokenshashoHakkoTaishoshaList;
    }
}
