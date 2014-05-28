/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShujiiIkenshoImageTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgIkenshoTorikomiKekka_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 *
 * @author n9606
 */
public class ShujiiIkenshoImageTorikomi {

    String strErrKensuu;

    public ResponseData<ShujiiIkenshoImageTorikomiDiv> onClick_btnOcrTorikomi(ShujiiIkenshoImageTorikomiDiv panel) {
        ResponseData<ShujiiIkenshoImageTorikomiDiv> response = new ResponseData<>();

        setTorikomiKekkaData(panel);

        response.data = panel;
        return response;

    }

    private void setTorikomiKekkaData(ShujiiIkenshoImageTorikomiDiv panel) {

        List arraydata = createRowTorikomiKekkaData();
        DataGrid grid = panel.getDgIkenshoTorikomiKekka();
        grid.setDataSource(arraydata);
        panel.getTxtErrKensu().setValue(new Decimal(strErrKensuu));
    }

    /*
     *取込み結果一覧情報の初期値をセットします。
     */
    private List createRowTorikomiKekkaData() {

        List arrayDataList = new ArrayList();
        List<HashMap> TorikomiKekkaData = YamlLoader.FOR_DBE.loadAsList(new RString("IkenshoOcrTorikomiIchiran.yml"));

        strErrKensuu = (String) TorikomiKekkaData.get(0).get("errkensu");
        for (int i = 1; i < TorikomiKekkaData.size(); i++) {
            HashMap hashMap = TorikomiKekkaData.get(i);
            String strNo = (String) hashMap.get("bango");
            String strOkng = (String) hashMap.get("okng");
            String strHokensha = (String) hashMap.get("hokensha");
            String strHihokenNo = (String) hashMap.get("hihokenNo");
            String strShinseibi = (String) hashMap.get("shinseibi");
            String strShinseiKbn = (String) hashMap.get("shinseiKbn");
            String strChosaJissibi = (String) hashMap.get("ikenshoKinyubi");
            String strChosahyoJuryobi = (String) hashMap.get("ikenshoJuryobi");
            String strNetakirido = (String) hashMap.get("netakirido");
            String strNinchi = (String) hashMap.get("ninchi");
            String strTankiKioku = (String) hashMap.get("tankiKioku");
            String strNinchiNoryoku = (String) hashMap.get("ninchiNoryoku");
            String strDentatsuNoryoku = (String) hashMap.get("dentatsuNoryoku");
            String strShokujiKoi = (String) hashMap.get("shokujiKoi");

            arrayDataList.add(createRowTorikomiKekkaData(
                    strNo,
                    strOkng,
                    strHokensha,
                    strHihokenNo,
                    strShinseibi,
                    strShinseiKbn,
                    strChosaJissibi,
                    strChosahyoJuryobi,
                    strNetakirido,
                    strNinchi,
                    strTankiKioku,
                    strNinchiNoryoku,
                    strDentatsuNoryoku,
                    strShokujiKoi
            )
            );
        }
        return arrayDataList;
    }

    /*
     *引数を元にデータグリッド内に挿入する意見書取込み結果データを作成します。
     */
    private dgIkenshoTorikomiKekka_Row createRowTorikomiKekkaData(
            String no,
            String okng,
            String hokensha,
            String hihokenNo,
            String shinseibi,
            String shinseiKbn,
            String ikenshoKinyubi,
            String ikenshoJuryobi,
            String netakirido,
            String ninchi,
            String tankiKioku,
            String ninchiNoryoku,
            String dentatsuNoryoku,
            String shokujiKoi
    ) {

        dgIkenshoTorikomiKekka_Row rowTorikomiKekkaData = new dgIkenshoTorikomiKekka_Row(
                new Button(),
                new RString(no),
                new RString(okng),
                new RString(hokensha),
                new RString(hihokenNo),
                new RString(shinseibi),
                new RString(shinseiKbn),
                new RString(ikenshoKinyubi),
                new RString(ikenshoJuryobi),
                new RString(netakirido),
                new RString(ninchi),
                new RString(tankiKioku),
                new RString(ninchiNoryoku),
                new RString(dentatsuNoryoku),
                new RString(shokujiKoi)
        );
        return rowTorikomiKekkaData;
    }

}
