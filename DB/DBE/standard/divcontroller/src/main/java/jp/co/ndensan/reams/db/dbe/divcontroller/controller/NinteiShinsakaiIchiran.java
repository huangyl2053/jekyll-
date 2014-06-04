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
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

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
     * 対象者一覧に割り付けるボタン押下時の処理を表します。
     *
     * @param panel NinteiShinsakaiIchiranDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinsakaiIchiranDiv> onClick_BtnToroku(NinteiShinsakaiIchiranDiv panel) {
        ResponseData<NinteiShinsakaiIchiranDiv> response = new ResponseData<>();

        panel.getDgNinteiShinsakaiIchiran().getClickedItem().setWariateNinzu(new RString(("7")));

        response.data = panel;
        return response;

    }

    /*
     *認定審査会一覧情報を設定します。
     */
    private void setNinteiShinsakaiIchiranData(NinteiShinsakaiIchiranDiv panel) {

        List<HashMap> NinteiShinsakaiIchiranData = YamlLoader.FOR_DBE.loadAsList(
                new RString("dbe4060001/NinteiShinsakaiIchiran.yml"));

        List arraydata = createRowNinteiShinsakaiIchiran(NinteiShinsakaiIchiranData);
        DataGrid grid = panel.getDgNinteiShinsakaiIchiran();
        grid.setDataSource(arraydata);

    }

    /*
     *認定審査会一覧情報の初期値をセットします。
     */
    private List createRowNinteiShinsakaiIchiran(List<HashMap> NinteiShinsakaiIchiranData) {

        List arrayDataList = new ArrayList();

        for (int i = 0; i < NinteiShinsakaiIchiranData.size(); i++) {
            HashMap hashMap = NinteiShinsakaiIchiranData.get(i);
            String strKaisaiNo = (String) hashMap.get("kaisaiNo");
            String strYoteibi = (String) hashMap.get("yoteibi");
            String strKaishiJikan = (String) hashMap.get("kaishiJikan");
            String strShuryoJikan = (String) hashMap.get("shuryoJikan");
            String strGogitaiNo = (String) hashMap.get("gogitaiNo");
            String strGogitaiMeisho = (String) hashMap.get("gogitaiMeisho");
            String strYoteiTeiin = (String) hashMap.get("yoteiTeiin");
            String strWariateNinzu = (String) hashMap.get("wariateNinzu");

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
            String kaisaiNo,
            String yoteibi,
            String kaishiJikan,
            String shuryoJikan,
            String gogitaiNo,
            String gogitaiMeisho,
            String yoteiTeiin,
            String wariateNinzu
    ) {
        dgNinteiShinsakaiIchiran_Row rowNinteiShinsakaiIchiranData = new dgNinteiShinsakaiIchiran_Row(
                new Button(),
                new RString(kaisaiNo),
                new RString(yoteibi),
                new RString(kaishiJikan),
                new RString(shuryoJikan),
                new RString(gogitaiNo),
                new RString(gogitaiMeisho),
                new RString(yoteiTeiin),
                new RString(wariateNinzu)
        );
        return rowNinteiShinsakaiIchiranData;
    }

}
