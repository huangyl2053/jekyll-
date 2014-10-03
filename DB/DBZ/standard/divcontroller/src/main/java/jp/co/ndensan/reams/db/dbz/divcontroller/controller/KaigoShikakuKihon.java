/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ur.ura.divcontroller.controller.AtenaShokaiSimple;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N3317 塚田 萌
 */
public final class KaigoShikakuKihon {

    private KaigoShikakuKihon() {
    }

    /**
     * 宛名情報、介護資格基本情報のYamlデータをセットします。
     *
     * @param atenaDiv KaigoAtenaInfoDiv
     * @param kaigoDiv KaigoShikakuKihonDiv
     * @param 識別コード ShikibetsuCode
     * @param rowId YamlデータのrowId
     */
    public static void setData(KaigoAtenaInfoDiv atenaDiv, KaigoShikakuKihonDiv kaigoDiv, ShikibetsuCode 識別コード, int rowId) {

//        AtenaShokaiSimple.setData(atenaDiv.getAtenaInfo(), 識別コード);
        List<HashMap> targetSource = YamlLoader.DBZ.loadAsList(new RString("KaigoShikakuKihon.yml"));
        ControlGenerator cg = new ControlGenerator(targetSource.get(rowId));

        kaigoDiv.getTxtHihokenshaNo().setValue(cg.getAsRString("被保番号"));
        kaigoDiv.getTxtShutokuYmd().setValue(cg.getAsRDate("取得日"));
        kaigoDiv.getTxtSoshitsuYmd().setValue(cg.getAsRDate("喪失日"));
        kaigoDiv.getTxtShutokuJiyu().setValue(cg.getAsRString("取得事由"));
        kaigoDiv.getTxtSoshitsuJiyu().setValue(cg.getAsRString("喪失事由"));
        kaigoDiv.getTxtJutokuKubun().setValue(cg.getAsRString("住特区分"));
        kaigoDiv.getTxtYokaigoJotaiKubun().setValue(cg.getAsRString("要介護度"));
        kaigoDiv.getTxtNinteiKaishiYmd().setValue(cg.getAsRDate("認定開始日"));
        kaigoDiv.getTxtNinteiShuryoYmd().setValue(cg.getAsRDate("認定終了日"));

    }
}
