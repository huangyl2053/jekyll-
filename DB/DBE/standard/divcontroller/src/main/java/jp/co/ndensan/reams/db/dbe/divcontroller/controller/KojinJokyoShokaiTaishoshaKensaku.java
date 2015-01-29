/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.KojinJokyoShokaiTaishoshaKensakuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.dgKensakuKekka_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 * 個人状況照会検索Divを制御します。
 *
 * @author N1013 松本直樹
 */
public class KojinJokyoShokaiTaishoshaKensaku {

    /**
     * // * 検索条件指示画面ロード時の処理を表します。
     *
     * @param div 検索条件指示Div
     * @return ResponseData
     */
    public ResponseData onLoad(KojinJokyoShokaiTaishoshaKensakuDiv div) {
        ResponseData<KojinJokyoShokaiTaishoshaKensakuDiv> response = new ResponseData<>();

        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("DemoCity.yml"));
        ControlGenerator cg = new ControlGenerator(targetSource.get(0));

//        div.getHihokenshaFinder().getSearchCriteriaOfHihokensha().getTxtTuchishoNo().setDisplayNone(true);
        response.data = div;
        return response;
    }

    /**
     * 申請者検索画面-検索ボタン押下時の処理を表します。
     *
     * @param div ShinseishaKensakuDiv
     * @return ResponseData
     */
    public ResponseData<KojinJokyoShokaiTaishoshaKensakuDiv> onClick_btnToSearch(
            KojinJokyoShokaiTaishoshaKensakuDiv div) {
        ResponseData<KojinJokyoShokaiTaishoshaKensakuDiv> response = new ResponseData<>();

        div.getShinseishaKensakuResultIchiran().getDgKensakuKekka().setDataSource(createRowHihokenshaSearchResultIchiran());

        response.data = div;
        return response;
    }

    /*
     *被保険者検索結果一覧情報を取得します。
     */
    private List<dgKensakuKekka_Row> createRowHihokenshaSearchResultIchiran() {
        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(
                new RString("dbe8020001/HihokenshaSearchList.yml"));
        List<dgKensakuKekka_Row> arrayData = new ArrayList<>();
        for (Map info : targetSource) {
            arrayData.add(toDgKensakuKekka_Row(info));
        }

        return arrayData;
    }

    private dgKensakuKekka_Row toDgKensakuKekka_Row(Map map) {
        ControlGenerator cg = new ControlGenerator(map);
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

        dgKensakuKekka_Row row = new dgKensakuKekka_Row(new Button(), strHokensha, strHihokenNo,
                strShinseibi, strShinseiKbn, strHihokenshaKbn, strShimei,
                strUmareYmd, strSeibetsu, strYubinNo, strJusho, strTel);

        return row;
    }

}
