/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410000.KyufuJissekiTorikomiKekkaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報取込の給付実績情報取込結果一覧表のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class KyufuJissekiTorikomiKekkaList {

    private List<HashMap> getYaml() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc0410000/KyufuJissekiTorikomiKekkaList.yml"));
    }

    /**
     * 保険者情報送付一覧でリストを選択したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KyufuJissekiTorikomiKekkaListDiv> onSelectKokuhorenTorikomiList(KyufuJissekiTorikomiKekkaListDiv panel) {
        ResponseData<KyufuJissekiTorikomiKekkaListDiv> response = new ResponseData<>();

        setKyufuJissekiTorikomiKekkaList(panel);
        response.data = panel;
        return response;
    }

    private void setKyufuJissekiTorikomiKekkaList(KyufuJissekiTorikomiKekkaListDiv panel) {
        HashMap source = getYaml().get(0);

        panel.getKyufuJissekiTorikomiKekkaListPrintSetting().getTxtIssueDate().setValue(new RDate(source.get("発効日").toString()));
        panel.getKyufuJissekiTorikomiKekkaListOutputOrder().getTxtSortName().setValue(new RString(source.get("出力順名称").toString()));
        panel.getKyufuJissekiTorikomiKekkaListOutputOrder().getTxtKaiPage().setValue(new RString(source.get("改頁").toString()));
        panel.getKyufuJissekiTorikomiKekkaListOutputOrder().getTxtSort().setValue(new RString(source.get("出力順").toString()));
    }

}
