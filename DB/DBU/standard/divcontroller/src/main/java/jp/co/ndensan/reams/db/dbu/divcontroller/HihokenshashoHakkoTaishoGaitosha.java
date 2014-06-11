/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011.HihokenshashoHakkoTaishoGaitoshaDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011.SearchHihokenshashoHakkoTaishoshaDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011.dgHihokenshashoHakkoTaishoGaitosha_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 被保険者証発行該当者一覧Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class HihokenshashoHakkoTaishoGaitosha {

    /**
     * 被保険者証発行対象者検索条件画面-「以上の条件で検索する」ボタン押下時の処理を表します。
     *
     * @param panel HihokenshashoHakkoTaishoGaitoshaDiv
     * @param panel2 SearchHihokenshashoHakkoTaishoshaDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshashoHakkoTaishoGaitoshaDiv> onClick_BtnSearchHihokenshashoHakkoTaishosha(
            HihokenshashoHakkoTaishoGaitoshaDiv panel, SearchHihokenshashoHakkoTaishoshaDiv panel2) {
        ResponseData<HihokenshashoHakkoTaishoGaitoshaDiv> response = new ResponseData<>();

        setHihokenshashoHakkoTaishoshaData(panel, panel2);
        panel.setIsOpen(true);

        response.data = panel;
        return response;
        
    }

    /*
     *被保険者証発行対象者情報を設定します。
     */
    private void setHihokenshashoHakkoTaishoshaData(HihokenshashoHakkoTaishoGaitoshaDiv panel,
            SearchHihokenshashoHakkoTaishoshaDiv panel2) {

        List<HashMap> hihokenshashoHakkoTaishoshaList = YamlLoader.FOR_DBU.loadAsList(
                new RString("dbu0410011/HihokenshashoHakkoTaishoshaList.yml"));

        RString selectedItemData = panel2.getSearchHihokenshashoHakkoTaishoshaMaeShorisha().
                getDdlMaeShirishaRireki().getSelectedItem();

        List arraydata = createRowHihokenshashoHakkoTaishoshaList(hihokenshashoHakkoTaishoshaList, selectedItemData);
        DataGrid grid = panel.getDgHihokenshashoHakkoTaishoGaitosha();
        grid.setDataSource(arraydata);

    }

    /*
     *被保険者証発行対象者情報の初期値をセットします。
     */
    private List createRowHihokenshashoHakkoTaishoshaList(
            List<HashMap> hihokenshashoHakkoTaishoshaList, RString selectedData) {

        List arrayDataList = new ArrayList();

        for (int i = 1; i < hihokenshashoHakkoTaishoshaList.size(); i++) {
            HashMap hashMap = hihokenshashoHakkoTaishoshaList.get(i);
            ControlGenerator ymlData = new ControlGenerator(hashMap);

            RString rsHihoNo = ymlData.getAsRString("hihoNo");
            RString rsShimei = ymlData.getAsRString("shimei");
            RString rsBirthday = ymlData.getAsRString("birthday");
            RString rsAge = ymlData.getAsRString("age");
            RString rsSeibetsu = ymlData.getAsRString("seibetsu");
            RString rsJusho = ymlData.getAsRString("jusho");

            if ("0".equals(selectedData.toString())
                    || String.valueOf(i).equals(selectedData.toString())) {
                arrayDataList.add(createRowHihokenshashoHakkoTaishoshaList(
                        rsHihoNo,
                        rsShimei,
                        rsBirthday,
                        rsAge,
                        rsSeibetsu,
                        rsJusho
                ));
            }
        }
        return arrayDataList;
    }

    /*
     *引数を元にデータグリッド内に挿入する被保険者証発行対象者情報データを作成します。
     */
    private dgHihokenshashoHakkoTaishoGaitosha_Row createRowHihokenshashoHakkoTaishoshaList(
            RString hihoNo,
            RString shimei,
            RString birthday,
            RString age,
            RString seibetsu,
            RString jusho
    ) {
        dgHihokenshashoHakkoTaishoGaitosha_Row rowHihokenshashoHakkoTaishoshaList
                = new dgHihokenshashoHakkoTaishoGaitosha_Row(
                        new Button(),
                        hihoNo,
                        shimei,
                        birthday,
                        age,
                        seibetsu,
                        jusho
                );
        return rowHihokenshashoHakkoTaishoshaList;
    }
}
