/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0200000.JukyushaIdoRenrakuhyoSakuseiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者情報送付の受給者異動連絡票情報作成のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class JukyushaIdoRenrakuhyoSakusei {

    private List<HashMap> getYaml() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc0200000/JukyushaIdoRenrakuhyoSakusei.yml"));
    }

    /**
     * 保険者情報送付一覧でリストを選択したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoSakuseiDiv> onSelectHokenshaSofuList(JukyushaIdoRenrakuhyoSakuseiDiv panel) {
        ResponseData<JukyushaIdoRenrakuhyoSakuseiDiv> response = new ResponseData<>();

        setJukyushaIdoRenrakuhyoSakusei(panel);
        response.data = panel;
        return response;
    }

    private void setJukyushaIdoRenrakuhyoSakusei(JukyushaIdoRenrakuhyoSakuseiDiv panel) {
        HashMap source = getYaml().get(0);

        panel.getTxtShoriTaishoYM().setValue(new RDate(source.get("処理対象年月").toString()));
        panel.getTxtSaiShoriKubun().setValue(new RString(source.get("再処理区分").toString()));
        panel.getTxtFileName().setValue(new RString(source.get("ファイル名").toString()));
    }

}
