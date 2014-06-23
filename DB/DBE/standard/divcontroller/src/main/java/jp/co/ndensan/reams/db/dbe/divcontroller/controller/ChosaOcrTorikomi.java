/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005.ChosaOcrTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005.dgChosahyoTorikomiKekka_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;

/**
 * 調査票OCR取込み対象者一覧Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class ChosaOcrTorikomi {

    /**
     * OCR取込みボタン押下時の処理を表します。
     *
     * @param panel ChosaOcrTorikomiDiv
     * @return ResponseData
     */
    public ResponseData<ChosaOcrTorikomiDiv> onClick_btnOcrTorikomi(ChosaOcrTorikomiDiv panel) {
        ResponseData<ChosaOcrTorikomiDiv> response = new ResponseData<>();

        List<HashMap> torikomiKekkaData = YamlLoader.DBE.loadAsList(new RString("dbe2060005/NinteichosaOcrTorikomiIchiran.yml"));
        ControlGenerator cg = new ControlGenerator(torikomiKekkaData.get(0));
        panel.getTxtErrKensu().setValue(cg.getAsDecimal("errkensu"));

        panel.getDgChosahyoTorikomiKekka().setDataSource(createRowTorikomiKekkaData());

        response.data = panel;
        return response;

    }


    /*
     *調査票取込み結果一覧情報を取得します。
     */
    private List createRowTorikomiKekkaData() {

        List arrayDataList = new ArrayList();
        List<HashMap> torikomiKekkaData = YamlLoader.DBE.loadAsList(new RString("dbe2060005/NinteichosaOcrTorikomiIchiran.yml"));

        for (int i = 1; i < torikomiKekkaData.size(); i++) {
            ControlGenerator cg = new ControlGenerator(torikomiKekkaData.get(i));
            RString strNo = cg.getAsRString("bango");
            RString strOkng = cg.getAsRString("okng");
            RString strHokensha = cg.getAsRString("hokensha");
            RString strHihokenNo = cg.getAsRString("hihokenNo");
            RString strShinseibi = cg.getAsRString("shinseibi");
            RString strShinseiKbn = cg.getAsRString("shinseiKbn");
            RString strChosaJissibi = cg.getAsRString("chosaJissibi");
            RString strChosahyoJuryobi = cg.getAsRString("chosahyoJuryobi");

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
            RString no,
            RString okng,
            RString hokensha,
            RString hihokenNo,
            RString shinseibi,
            RString shinseiKbn,
            RString chosaJissibi,
            RString chosahyoJuryobi
    ) {

        dgChosahyoTorikomiKekka_Row rowTorikomiKekkaData = new dgChosahyoTorikomiKekka_Row(new Button(),
                no, okng, hokensha, hihokenNo, shinseibi, shinseiKbn, chosaJissibi, chosahyoJuryobi);
        return rowTorikomiKekkaData;
    }
}
