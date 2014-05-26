/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.SogoJigyohiRiyohyoTaishoshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業費サービス利用票登録の対象者のコントロールクラスです。
 *
 * @author N8187 久保田 英男
 */
public class SogoJigyohiRiyohyoTaishosha {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onLoad(SogoJigyohiRiyohyoTaishoshaDiv panel) {
        ResponseData<SogoJigyohiRiyohyoTaishoshaDiv> response = new ResponseData<>();
        List<HashMap> sourceList = YamlLoader.FOR_DBC.loadAsList(new RString("SogoJigyohiRiyohyoTaishosha.yml"));
        panel.getTxtNijiYoboYukoKikan().setFromValue(new RDate(sourceList.get(0).get("二次予防有効期間開始日").toString()));
        panel.getTxtNijiYoboYukoKikan().setToValue(new RDate(sourceList.get(0).get("二次予防有効期間終了日").toString()));
        panel.getTxtNijiYoboHanteiYMD().setValue(new RDate(sourceList.get(0).get("二次予防判定日").toString()));
        response.data = panel;
        return response;
    }
}
