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
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
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

        List<HashMap> hihokenshaSearchList = YamlLoader.DBE.loadAsList(
                new RString("dbe8020001/HihokenshaSearchList.yml"));

        List arraydata = createRowHihokenshaSearchResultIchiran(hihokenshaSearchList);
        DataGrid grid = panel.getDgKensakuKekka();
        grid.setDataSource(arraydata);

    }

    /*
     *被保険者検索結果一覧情報を取得します。
     */
    private List createRowHihokenshaSearchResultIchiran(List<HashMap> hihokenshaSearchListData) {

        List arrayDataList = new ArrayList();

        for (int i = 0; i < hihokenshaSearchListData.size(); i++) {
//            HashMap hashMap = hihokenshaSearchListData.get(i);
            ControlGenerator cg = new ControlGenerator(hihokenshaSearchListData.get(i));
            RString strHokensha = cg.getAsRString("hokensha");
            RString strHihokenNo = cg.getAsRString("hihokenNo");
            RString strShinseibi = cg.getAsRString("shinseibi");
            RString strShinseiKbn = cg.getAsRString("shinseiKbn");
            RString strHihokenshaKbn = cg.getAsRString("hihokenshaKbn");
            RString strShimei = cg.getAsRString("shimei");
            RString strUmareYmd = cg.getAsRString("umareYmd");
            RString strSeibetsu = cg.getAsRString("seibetsu");
            RString strYubinNo = cg.getAsRString("yubinNo");
            RString strJusho = cg.getAsRString("jusho");
            RString strTel = cg.getAsRString("tel");

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
            RString hokensha,
            RString hihokenNo,
            RString shinseibi,
            RString shinseiKbn,
            RString hihokenshaKbn,
            RString shimei,
            RString umareYmd,
            RString seibetsu,
            RString yubinNo,
            RString jusho,
            RString tel
    ) {
        dgKensakuKekka_Row rowHihokenshaSearchResultIchiranData = new dgKensakuKekka_Row(
                new Button(), hokensha, hihokenNo, shinseibi, shinseiKbn, hihokenshaKbn,
                shimei, umareYmd, seibetsu, yubinNo, jusho, tel);
        return rowHihokenshaSearchResultIchiranData;
    }

}
