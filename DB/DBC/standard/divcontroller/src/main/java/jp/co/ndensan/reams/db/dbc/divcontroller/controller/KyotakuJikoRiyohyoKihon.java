/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0120000.KyotakuJikoRiyohyoKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ur.ura.divcontroller.controller.AtenaShokaiSimple;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅サービス計画作成依頼届出情報登録の基本情報のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class KyotakuJikoRiyohyoKihon {

    private List<HashMap> getYaml() {
        return YamlLoader.DBC.loadAsList(new RString("dbc0100000/KyotakuKeikakuTodokedeDetail.yml"));
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onLoad(KyotakuJikoRiyohyoKihonDiv panel) {
        ResponseData<KyotakuJikoRiyohyoKihonDiv> response = new ResponseData<>();
        setAtenaData(panel);
        setKihonData(panel);
        response.data = panel;
        return response;
    }

    private void setAtenaData(KyotakuJikoRiyohyoKihonDiv panel) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(0));
        AtenaShokaiSimple.setData(panel.getKyotakuJikoRiyohyoKihonAtena().getAtenaInfo(),
                new ShikibetsuCode(cg.getAsRString("識別コード")));
    }

    private void setKihonData(KyotakuJikoRiyohyoKihonDiv panel) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(1));
        KaigoShikakuKihonDiv kihon = panel.getKyotakuJikoRiyohyoKaigoKihon();
        kihon.getTxtHihokenshaNo().setValue(cg.getAsRString("被保番号"));
        kihon.getTxtShutokuYmd().setValue(cg.getAsRDate("取得日"));
        kihon.getTxtSoshitsuYmd().setValue(cg.getAsRDate("喪失日"));
        kihon.getTxtShutokuJiyu().setValue(cg.getAsRString("取得事由"));
        kihon.getTxtSoshitsuJiyu().setValue(cg.getAsRString("喪失事由"));
        kihon.getTxtJutokuKubun().setValue(cg.getAsRString("住特区分"));
        kihon.getTxtYokaigoJotaiKubun().setValue(cg.getAsRString("要介護度"));
        kihon.getTxtNinteiKaishiYmd().setValue(cg.getAsRDate("認定開始日"));
        kihon.getTxtNinteiShuryoYmd().setValue(cg.getAsRDate("認定終了日"));
    }
}
