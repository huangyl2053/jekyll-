/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.dgKensakuKekka_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.ShinseishaKensakuResultIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 個人状況照会検索結果一覧Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class ShinseishaKensakuResultIchiran {

    /**
     * 申請者検索画面-検索ボタン押下時の処理を表します。
     *
     * @param panel ShinseishaKensakuDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishaKensakuResultIchiranDiv> onClick_BtnShinseishaKensaku(
            ShinseishaKensakuResultIchiranDiv panel) {
        ResponseData<ShinseishaKensakuResultIchiranDiv> response = new ResponseData<>();

        setHihokenshaSearchListData(panel);

        response.data = panel;
        return response;
    }

    /*
     *被保険者検索結果一覧を設定します。
     */
    private void setHihokenshaSearchListData(ShinseishaKensakuResultIchiranDiv panel) {

        List<HashMap> HihokenshaSearchList = YamlLoader.FOR_DBE.loadAsList(
                new RString("dbe8020001/HihokenshaSearchList.yml"));

        List arraydata = createRowHihokenshaSearchResultIchiran(HihokenshaSearchList);
        DataGrid grid = panel.getDgKensakuKekka();
        grid.setDataSource(arraydata);

    }

    /*
     *被保険者検索結果一覧情報を取得します。
     */
    private List createRowHihokenshaSearchResultIchiran(List<HashMap> HihokenshaSearchListData) {

        List arrayDataList = new ArrayList();

        for (int i = 0; i < HihokenshaSearchListData.size(); i++) {
            HashMap hashMap = HihokenshaSearchListData.get(i);
            String strHokensha = (String) hashMap.get("hokensha");
            String strHihokenNo = (String) hashMap.get("hihokenNo");
            String strShinseibi = (String) hashMap.get("shinseibi");
            String strShinseiKbn = (String) hashMap.get("shinseiKbn");
            String strHihokenshaKbn = (String) hashMap.get("hihokenshaKbn");
            String strShimei = (String) hashMap.get("shimei");
            String strUmareYmd = (String) hashMap.get("umareYmd");
            String strSeibetsu = (String) hashMap.get("seibetsu");
            String strYubinNo = (String) hashMap.get("yubinNo");
            String strJusho = (String) hashMap.get("jusho");
            String strTel = (String) hashMap.get("tel");

            arrayDataList.add(createRowHihokenshaSearchResultIchiran(
                    strHokensha,
                    strHihokenNo,
                    strShinseibi,
                    strShinseiKbn,
                    strHihokenshaKbn,
                    strShimei,
                    strUmareYmd,
                    strSeibetsu,
                    strYubinNo,
                    strJusho,
                    strTel
            ));
        }
        return arrayDataList;
    }

    /*
     *引数を元にデータグリッド内に挿入する被保険者検索結果一覧データを作成します。
     */
    private dgKensakuKekka_Row createRowHihokenshaSearchResultIchiran(
            String hokensha,
            String hihokenNo,
            String shinseibi,
            String shinseiKbn,
            String hihokenshaKbn,
            String shimei,
            String umareYmd,
            String seibetsu,
            String yubinNo,
            String jusho,
            String tel
    ) {
        dgKensakuKekka_Row rowHihokenshaSearchResultIchiranData = new dgKensakuKekka_Row(
                new Button(),
                new RString(hokensha),
                new RString(hihokenNo),
                new RString(shinseibi),
                new RString(shinseiKbn),
                new RString(hihokenshaKbn),
                new RString(shimei),
                new RString(umareYmd),
                new RString(seibetsu),
                new RString(yubinNo),
                new RString(jusho),
                new RString(tel)
        );
        return rowHihokenshaSearchResultIchiranData;
    }

}
