/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinseishaInfo.ShinseishaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N3317 塚田 萌
 */
public final class ShinseishaInfo {

    private ShinseishaInfo() {
    }

    /**
     * 共有子Div ShinseishaInfo にYamlデータをセットします。
     *
     * @param shinseishaDiv ShinseishaInfoDiv
     * @param rowId YamlデータのId
     */
    public static void setData(ShinseishaInfoDiv shinseishaDiv, int rowId) {

        List<HashMap> targetSource = YamlLoader.DBZ.loadAsList(new RString("ShinseishaInfo.yml"));
        ControlGenerator cg = new ControlGenerator(targetSource.get(rowId));

        shinseishaDiv.getTxtShinseiDate().setValue(cg.getAsRDate("shinseiYMD"));
        shinseishaDiv.getTxtUketsukeDate().setValue(cg.getAsRDate("uketsukeYMD"));
        shinseishaDiv.getTxtShinseishaNameKana().setValue(cg.getAsRString("shinseishaNameKana"));
        shinseishaDiv.getTxtShinseishaName().setValue(cg.getAsRString("shinseishaName"));
        shinseishaDiv.getTxtYubinNo().setValue(new YubinNo(cg.getAsRString("yubinNo")));
        shinseishaDiv.getTxtAddress().setValue(cg.getAsRString("address"));
        shinseishaDiv.getTxtTelNo().setValue(cg.getAsRString("telNo"));
    }
}
