/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200000.JukyushaIdoRenrakuhyoSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 保険者情報送付の受給者異動連絡票情報作成のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class JukyushaIdoRenrakuhyoSakusei {

    /**
     * 保険者情報送付一覧でリストを選択したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoSakuseiDiv> onSelectHokenshaSofuList(JukyushaIdoRenrakuhyoSakuseiDiv panel) {
        setJukyushaIdoRenrakuhyoSakusei(panel);

        return ResponseData.of(panel).respond();
    }

    private void setJukyushaIdoRenrakuhyoSakusei(JukyushaIdoRenrakuhyoSakuseiDiv panel) {
//        HashMap source = getYaml().get(0);
//
//        panel.getTxtShoriTaishoYM().setValue(new RDate(source.get("処理対象年月").toString()));
//        panel.getTxtSaiShoriKubun().setValue(new RString(source.get("再処理区分").toString()));
//        panel.getTxtFileName().setValue(new RString(source.get("ファイル名").toString()));
    }
}
