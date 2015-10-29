/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060000.KyufuKanrihyoKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票情報照会の介護宛名情報のコントロールクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyufuKanrihyoKihon {

    private List<HashMap> getYaml() {
        return YamlLoader.DBC.loadAsList(new RString("dbc0060000/KyufuKanrihyoKihon.yml"));
    }

    /**
     * 画面ロード時の処理。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onLoad(KyufuKanrihyoKihonDiv panel) {
        ResponseData<KyufuKanrihyoKihonDiv> response = new ResponseData<>();
        setAtenaData(panel);
        setKihonData(panel);

        response.data = panel;
        return response;
    }

    private void setAtenaData(KyufuKanrihyoKihonDiv panel) {
//        ControlGenerator cg = new ControlGenerator(getYaml().get(0));
//        AtenaShokaiSimple.setData(panel.getKyufuKanrihyoKaigoAtena().getAtenaInfo(), new ShikibetsuCode(cg.getAsRString("識別コード")));
    }

    private void setKihonData(KyufuKanrihyoKihonDiv panel) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(1));
        KaigoShikakuKihonDiv kihon = panel.getKyufuKanrihyoKaigoKihon();
        kihon.getTxtHihokenshaNo().setValue(cg.getAsRString("被保番号"));
        kihon.getTxtShutokuYmd().setValue(cg.getAsFlexibleDate("取得日"));
        kihon.getTxtSoshitsuYmd().setValue(cg.getAsFlexibleDate("喪失日"));
        kihon.getTxtShutokuJiyu().setValue(cg.getAsRString("取得事由"));
        kihon.getTxtSoshitsuJiyu().setValue(cg.getAsRString("喪失事由"));
        kihon.getTxtJutokuKubun().setValue(cg.getAsRString("住特区分"));
        kihon.getTxtYokaigoJotaiKubun().setValue(cg.getAsRString("要介護度"));
        kihon.getTxtNinteiKaishiYmd().setValue(cg.getAsRDate("認定開始日"));
        kihon.getTxtNinteiShuryoYmd().setValue(cg.getAsRDate("認定終了日"));
    }
}
