/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.NinteiShinsakaiIchiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.dgNinteiShinsakaiIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 認定審査会一覧Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class NinteiShinsakaiIchiran {

    /**
     * 認定審査会一覧の初期処理を表します。
     *
     * @param panel NinteiShinsakaiIchiranDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiIchiranDiv> onLoad(NinteiShinsakaiIchiranDiv panel) {
        ResponseData<NinteiShinsakaiIchiranDiv> response = new ResponseData<>();

        setNinteiShinsakaiIchiranData(panel);
        response.data = panel;

        return response;

    }

    /**
     * 審査会個別割当画面-登録ボタン押下時の処理を表します。
     *
     * @param panel NinteiShinsakaiIchiranDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiIchiranDiv> onClick_BtnToroku(NinteiShinsakaiIchiranDiv panel) {
        ResponseData<NinteiShinsakaiIchiranDiv> response = new ResponseData<>();

        RString wariateNinzu = (RString) ViewStateHolder.get("割当人数", RString.class);
        panel.getDgNinteiShinsakaiIchiran().getClickedItem().setWariateNinzu(wariateNinzu);

        response.data = panel;
        return response;

    }

    /*
     *認定審査会一覧情報を設定します。
     */
    private void setNinteiShinsakaiIchiranData(NinteiShinsakaiIchiranDiv panel) {

        List<HashMap> ninteiShinsakaiIchiranData = YamlLoader.DBE.loadAsList(
                new RString("dbe4060001/NinteiShinsakaiIchiran.yml"));

        List arraydata = createRowNinteiShinsakaiIchiran(ninteiShinsakaiIchiranData);
        DataGrid grid = panel.getDgNinteiShinsakaiIchiran();
        grid.setDataSource(arraydata);

    }

    /*
     *認定審査会一覧情報の初期値をセットします。
     */
    private List createRowNinteiShinsakaiIchiran(List<HashMap> ninteiShinsakaiIchiranData) {

        List arrayDataList = new ArrayList();

        for (int i = 0; i < ninteiShinsakaiIchiranData.size(); i++) {
            HashMap hashMap = ninteiShinsakaiIchiranData.get(i);
            ControlGenerator cg = new ControlGenerator(hashMap);
            RString strKaisaiNo = cg.getAsRString("kaisaiNo");
            RString strYoteibi = cg.getAsRString("yoteibi");
            RString strKaishiJikan = cg.getAsRString("kaishiJikan");
            RString strShuryoJikan = cg.getAsRString("shuryoJikan");
            RString strGogitaiNo = cg.getAsRString("gogitaiNo");
            RString strGogitaiMeisho = cg.getAsRString("gogitaiMeisho");
            RString strYoteiTeiin = cg.getAsRString("yoteiTeiin");
            RString strWariateNinzu = cg.getAsRString("wariateNinzu");

            arrayDataList.add(createRowNinteiShinsakaiIchiran(
                    strKaisaiNo,
                    strYoteibi,
                    strKaishiJikan,
                    strShuryoJikan,
                    strGogitaiNo,
                    strGogitaiMeisho,
                    strYoteiTeiin,
                    strWariateNinzu
            ));
        }
        return arrayDataList;
    }

    /*
     *引数を元にデータグリッド内に挿入する認定審査会一覧データを作成します。
     */
    private dgNinteiShinsakaiIchiran_Row createRowNinteiShinsakaiIchiran(
            RString kaisaiNo,
            RString yoteibi,
            RString kaishiJikan,
            RString shuryoJikan,
            RString gogitaiNo,
            RString gogitaiMeisho,
            RString yoteiTeiin,
            RString wariateNinzu
    ) {
        dgNinteiShinsakaiIchiran_Row rowNinteiShinsakaiIchiranData = new dgNinteiShinsakaiIchiran_Row(
                new Button(), kaisaiNo, yoteibi, kaishiJikan, shuryoJikan, gogitaiNo, gogitaiMeisho, yoteiTeiin, wariateNinzu);
        return rowNinteiShinsakaiIchiranData;
    }

}
