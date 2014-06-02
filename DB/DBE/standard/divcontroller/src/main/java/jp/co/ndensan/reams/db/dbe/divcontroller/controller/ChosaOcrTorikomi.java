/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ChosaOcrTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgChosahyoTorikomiKekka_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;

/**
 *
 * @author n9606
 */
public class ChosaOcrTorikomi {

    String strErrKensuu;

    public ResponseData<ChosaOcrTorikomiDiv> onClick_btnOcrTorikomi(ChosaOcrTorikomiDiv panel) {
        ResponseData<ChosaOcrTorikomiDiv> response = new ResponseData<>();

        setTorikomiKekkaData(panel);

        response.data = panel;
        return response;

    }

    private void setTorikomiKekkaData(ChosaOcrTorikomiDiv panel) {

        List arraydata = createRowTorikomiKekkaData();
        DataGrid grid = panel.getDgChosahyoTorikomiKekka();
        grid.setDataSource(arraydata);
        panel.getTxtErrKensu().setValue(new Decimal(strErrKensuu));
    }

    /*
     *取込み結果一覧情報の初期値をセットします。
     */
    private List createRowTorikomiKekkaData() {

        List arrayDataList = new ArrayList();
        List<HashMap> TorikomiKekkaData = YamlLoader.FOR_DBE.loadAsList(new RString("NinteichosaOcrTorikomiIchiran.yml"));

        strErrKensuu = (String) TorikomiKekkaData.get(0).get("errkensu");
        for (int i = 1; i < TorikomiKekkaData.size(); i++) {
            HashMap hashMap = TorikomiKekkaData.get(i);
            String strNo = (String) hashMap.get("bango");
            String strOkng = (String) hashMap.get("okng");
            String strHokensha = (String) hashMap.get("hokensha");
            String strHihokenNo = (String) hashMap.get("hihokenNo");
            String strShinseibi = (String) hashMap.get("shinseibi");
            String strShinseiKbn = (String) hashMap.get("shinseiKbn");
            String strChosaJissibi = (String) hashMap.get("chosaJissibi");
            String strChosahyoJuryobi = (String) hashMap.get("chosahyoJuryobi");

            arrayDataList.add(createRowTorikomiKekkaData(
                    strNo,
                    strOkng,
                    strHokensha,
                    strHihokenNo,
                    strShinseibi,
                    strShinseiKbn,
                    strChosaJissibi,
                    strChosahyoJuryobi
            )
            );
        }
        return arrayDataList;
    }

    /*
     *引数を元にデータグリッド内に挿入する調査票取込み結果データを作成します。
     */
    private dgChosahyoTorikomiKekka_Row createRowTorikomiKekkaData(
            String no,
            String okng,
            String hokensha,
            String hihokenNo,
            String shinseibi,
            String shinseiKbn,
            String chosaJissibi,
            String chosahyoJuryobi
    ) {

        dgChosahyoTorikomiKekka_Row rowTorikomiKekkaData = new dgChosahyoTorikomiKekka_Row(new Button(),
                new RString(no),
                new RString(okng),
                new RString(hokensha),
                new RString(hihokenNo),
                new RString(shinseibi),
                new RString(shinseiKbn),
                new RString(chosaJissibi),
                new RString(chosahyoJuryobi)
        );
        return rowTorikomiKekkaData;
    }
}
