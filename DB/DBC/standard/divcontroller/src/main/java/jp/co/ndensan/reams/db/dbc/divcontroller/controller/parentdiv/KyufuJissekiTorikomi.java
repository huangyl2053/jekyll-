/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410000.KyufuJissekiTorikomiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報取込の給付実績情報取込のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class KyufuJissekiTorikomi {

    private List<HashMap> getYaml() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc0410000/KyufuJissekiTorikomi.yml"));
    }

    /**
     * 国保連情報取込一覧でリストを選択したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KyufuJissekiTorikomiDiv> onSelectKokuhorenTorikomiList(KyufuJissekiTorikomiDiv panel) {
        ResponseData<KyufuJissekiTorikomiDiv> response = new ResponseData<>();

        setKyufuJissekiTorikomi(panel);
        response.data = panel;
        return response;
    }

    private void setKyufuJissekiTorikomi(KyufuJissekiTorikomiDiv panel) {
        HashMap source = getYaml().get(0);

        panel.getTxtShoriTaishoYM().setValue(new RDate(source.get("処理対象年月").toString()));
        panel.getTxtSaiShoriKubun().setValue(new RString(source.get("再処理区分").toString()));
    }
}
