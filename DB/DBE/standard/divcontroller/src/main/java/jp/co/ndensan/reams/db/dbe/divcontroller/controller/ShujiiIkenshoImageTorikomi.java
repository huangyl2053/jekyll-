/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2070001.ShujiiIkenshoImageTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2070001.dgIkenshoTorikomiKekka_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 意見書OCR取込み対象者一覧Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class ShujiiIkenshoImageTorikomi {

    private RString strErrKensuu;

    /**
     * OCR取込みボタン押下時の処理を表します。
     *
     * @param panel ShujiiIkenshoImageTorikomiDiv
     * @return ResponseData
     */
    public ResponseData<ShujiiIkenshoImageTorikomiDiv> onClick_btnOcrTorikomi(ShujiiIkenshoImageTorikomiDiv panel) {
        ResponseData<ShujiiIkenshoImageTorikomiDiv> response = new ResponseData<>();

        setTorikomiKekkaData(panel);

        response.data = panel;
        return response;

    }

    /*
     *意見書取込み結果一覧情報をセットします。
     */
    private void setTorikomiKekkaData(ShujiiIkenshoImageTorikomiDiv panel) {

        List arraydata = createRowTorikomiKekkaData();
        DataGrid grid = panel.getDgIkenshoTorikomiKekka();
        grid.setDataSource(arraydata);
        panel.getTxtErrKensu().setValue(new Decimal(strErrKensuu.toString()));
    }

    /*
     *意見書取込み結果一覧情報を取得します。
     */
    private List createRowTorikomiKekkaData() {

        List arrayDataList = new ArrayList();
        List<HashMap> torikomiKekkaData = YamlLoader.DBE.loadAsList(new RString("dbe2070001/IkenshoOcrTorikomiIchiran.yml"));
        ControlGenerator cg = new ControlGenerator(torikomiKekkaData.get(0));
        strErrKensuu = cg.getAsRString("errkensu");
        for (int i = 1; i < torikomiKekkaData.size(); i++) {
            ControlGenerator cg1 = new ControlGenerator(torikomiKekkaData.get(i));
//            HashMap hashMap = torikomiKekkaData.get(i);
            RString strNo = cg1.getAsRString("bango");
            RString strOkng = cg1.getAsRString("okng");
            RString strHokensha = cg1.getAsRString("hokensha");
            RString strHihokenNo = cg1.getAsRString("hihokenNo");
            RString strShinseibi = cg1.getAsRString("shinseibi");
            RString strShinseiKbn = cg1.getAsRString("shinseiKbn");
            RString strChosaJissibi = cg1.getAsRString("ikenshoKinyubi");
            RString strChosahyoJuryobi = cg1.getAsRString("ikenshoJuryobi");
            RString strNetakirido = cg1.getAsRString("netakirido");
            RString strNinchi = cg1.getAsRString("ninchi");
            RString strTankiKioku = cg1.getAsRString("tankiKioku");
            RString strNinchiNoryoku = cg1.getAsRString("ninchiNoryoku");
            RString strDentatsuNoryoku = cg1.getAsRString("dentatsuNoryoku");
            RString strShokujiKoi = cg1.getAsRString("shokujiKoi");

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
            RString no,
            RString okng,
            RString hokensha,
            RString hihokenNo,
            RString shinseibi,
            RString shinseiKbn,
            RString ikenshoKinyubi,
            RString ikenshoJuryobi,
            RString netakirido,
            RString ninchi,
            RString tankiKioku,
            RString ninchiNoryoku,
            RString dentatsuNoryoku,
            RString shokujiKoi
    ) {

        dgIkenshoTorikomiKekka_Row rowTorikomiKekkaData = new dgIkenshoTorikomiKekka_Row(
                new Button(), no, okng, hokensha, hihokenNo, shinseibi, shinseiKbn, ikenshoKinyubi,
                ikenshoJuryobi, netakirido, ninchi, tankiKioku, ninchiNoryoku, dentatsuNoryoku, shokujiKoi);
        return rowTorikomiKekkaData;
    }

}
