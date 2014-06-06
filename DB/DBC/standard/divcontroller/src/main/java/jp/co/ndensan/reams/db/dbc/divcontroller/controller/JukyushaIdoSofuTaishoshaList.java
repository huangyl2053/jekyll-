/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0200000.JukyushaIdoSofuTaishoshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者情報送付の受給者異動情報送付対象者リストのコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class JukyushaIdoSofuTaishoshaList {

    private List<HashMap> getYaml() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc0200000/JukyushaIdoSofuTaishoshaList.yml"));
    }

    /**
     * 保険者情報送付一覧でリストを選択したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoSofuTaishoshaListDiv> onSelectHokenshaSofuList(JukyushaIdoSofuTaishoshaListDiv panel) {
        ResponseData<JukyushaIdoSofuTaishoshaListDiv> response = new ResponseData<>();

        setJukyushaIdoRenrakuhyoSakusei(panel);
        response.data = panel;
        return response;
    }

    private void setJukyushaIdoRenrakuhyoSakusei(JukyushaIdoSofuTaishoshaListDiv panel) {
        HashMap source = getYaml().get(0);

        panel.getJukyushaIdoSofuTaishoshaListPrintSetting().getTxtIssueDate().setValue(new RDate(source.get("発効日").toString()));
        panel.getJukyushaIdoSofuTaishoshaListOutputOrder().getTxtSortName().setValue(new RString(source.get("出力順名称").toString()));
        panel.getJukyushaIdoSofuTaishoshaListOutputOrder().getTxtKaiPage().setValue(new RString(source.get("改頁").toString()));
        panel.getJukyushaIdoSofuTaishoshaListOutputOrder().getTxtSort().setValue(new RString(source.get("出力順").toString()));
    }
}
