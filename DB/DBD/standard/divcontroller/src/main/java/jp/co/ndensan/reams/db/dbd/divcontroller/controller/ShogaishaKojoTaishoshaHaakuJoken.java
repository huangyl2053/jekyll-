/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4010011.ShogaishaKojoTaishoshaHaakuJokenDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 障害者控除対象者把握バッチ起動画面です。
 *
 * @author N3317 塚田 萌
 */
public class ShogaishaKojoTaishoshaHaakuJoken {

    /**
     * ロード時の処理です。
     *
     * @param panel ShogaishaKojoTaishoshaHaakuJokenDiv
     * @return response
     */
    public ResponseData<ShogaishaKojoTaishoshaHaakuJokenDiv> onLoad(ShogaishaKojoTaishoshaHaakuJokenDiv panel) {
        ResponseData<ShogaishaKojoTaishoshaHaakuJokenDiv> response = new ResponseData<>();

        panel.getTxtKijunYMD().setValue(new RDate("20141231"));

        response.data = panel;
        return response;
    }
}
