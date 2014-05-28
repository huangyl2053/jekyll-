/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.IchijiHanteiShoriTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgIchijiHanteiTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 *
 * @author n9606
 */
public class IchijiHanteiShoriTaishoshaIchiran {

    public ResponseData<IchijiHanteiShoriTaishoshaIchiranDiv> onLoad(IchijiHanteiShoriTaishoshaIchiranDiv panel) {
        ResponseData<IchijiHanteiShoriTaishoshaIchiranDiv> response = new ResponseData<>();

        setIchijiHanteiShoriTaishoshaData(panel);
        response.data = panel;

        return response;

    }

    private void setIchijiHanteiShoriTaishoshaData(IchijiHanteiShoriTaishoshaIchiranDiv panel) {

        List<dgIchijiHanteiTaishoshaIchiran_Row> IchijiHanteiTaishoshaSelectData = panel.getDgIchijiHanteiTaishoshaIchiran().getSelectedItems();
        panel.getDgIchijiHanteiTaishoshaIchiran().getClickedRowId();
        List arraydata = createRowIchijiHanteiTaishosha();
        DataGrid grid = panel.getDgIchijiHanteiTaishoshaIchiran();
        grid.setDataSource(arraydata);
    }

    /*
     *一次判定処理対象者一覧情報の初期値をセットします。
     */
    private List createRowIchijiHanteiTaishosha() {

        List arrayDataList = new ArrayList();
        List<HashMap> IchijiHanteiTaishoshaData = YamlLoader.FOR_DBE.loadAsList(new RString("IchijiHanteiShoriTaishoshaIchiran.yml"));

        for (int i = 0; i < IchijiHanteiTaishoshaData.size(); i++) {
            HashMap hashMap = IchijiHanteiTaishoshaData.get(i);
            String strHokensha = (String) hashMap.get("hokensha");
            String strHihokenNo = (String) hashMap.get("hihokenNo");
            String strHihokenshaName = (String) hashMap.get("hihokenshaName");
            String strHihokenshaKana = (String) hashMap.get("hihokenshaKana");
            String strShinseibi = (String) hashMap.get("shinseibi");
            String strShinseiKbnShin = (String) hashMap.get("shinseiKbnShin");
            String strIchijiHanteiKanryobi = "今日日付";
            String strIchijiHanteibi = (String) hashMap.get("ichijiHanteibi");
            String strIchijiHanteiKekka = (String) hashMap.get("ichijiHanteiKekka");
            String strKeikokuCode = (String) hashMap.get("keikokuCode");
            String strChosaJissibi = (String) hashMap.get("chosaJissibi");
            String strIkenshoJuryobi = (String) hashMap.get("ikenshoJuryobi");

            arrayDataList.add(createRowIchijiHanteiTaishosha(
                    strHokensha,
                    strHihokenNo,
                    strHihokenshaName,
                    strHihokenshaKana,
                    strShinseibi,
                    strShinseiKbnShin,
                    strIchijiHanteibi,
                    strIchijiHanteiKanryobi,
                    strIchijiHanteiKekka,
                    strKeikokuCode,
                    strChosaJissibi,
                    strIkenshoJuryobi,
                    String.valueOf(i)
            ));
        }
        return arrayDataList;
    }

    /*
     *引数を元にデータグリッド内に挿入する一次判定処理対象者一覧データを作成します。
     */
    private dgIchijiHanteiTaishoshaIchiran_Row createRowIchijiHanteiTaishosha(
            String hokensha,
            String hihokenNo,
            String hihokenshaName,
            String hihokenshaKana,
            String shinseibi,
            String shinseiKbnShin,
            String ichijiHanteiKanryobi,
            String ichijiHanteibi,
            String ichijiHanteiKekka,
            String keikokuCode,
            String chosaJissibi,
            String ikenshoJuryobi,
            String index
    ) {

        dgIchijiHanteiTaishoshaIchiran_Row rowIchijiHanteiTaishoshaData = new dgIchijiHanteiTaishoshaIchiran_Row(
                new RString(hokensha),
                new RString(hihokenNo),
                new RString(hihokenshaName),
                new RString(hihokenshaKana),
                new RString(shinseibi),
                new RString(shinseiKbnShin),
                new RString(ichijiHanteibi),
                new RString(ichijiHanteiKanryobi),
                new RString(ichijiHanteiKekka),
                new RString(keikokuCode),
                new RString(chosaJissibi),
                new RString(ikenshoJuryobi),
                new RString(index)
        );
        return rowIchijiHanteiTaishoshaData;
    }

}
