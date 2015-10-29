/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200000.JukyushaIdoSofuTaishoshaListDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 保険者情報送付の受給者異動情報送付対象者リストのコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class JukyushaIdoSofuTaishoshaList {

    /**
     * 保険者情報送付一覧でリストを選択したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoSofuTaishoshaListDiv> onSelectHokenshaSofuList(JukyushaIdoSofuTaishoshaListDiv panel) {
        setJukyushaIdoRenrakuhyoSakusei(panel);

        return ResponseData.of(panel).respond();
    }

    private void setJukyushaIdoRenrakuhyoSakusei(JukyushaIdoSofuTaishoshaListDiv panel) {
//        ControlGenerator cg = new ControlGenerator(getYaml().get(0));
//        panel.getJukyushaIdoSofuTaishoshaListPrintSetting().getTxtIssueDate().setValue(RDate.getNowDate());
//        panel.getJukyushaIdoSofuTaishoshaListOutputOrder().getTxtSortName().setValue(cg.getAsRString("出力順名称"));
//        panel.getJukyushaIdoSofuTaishoshaListOutputOrder().getTxtKaiPage().setValue(cg.getAsRString("改頁"));
//        panel.getJukyushaIdoSofuTaishoshaListOutputOrder().getTxtSort().setValue(cg.getAsRString("出力順"));
    }
}
