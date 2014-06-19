/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1810000.KashitsukeHenkanKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ur.ura.divcontroller.controller.AtenaShokaiSimple;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付費貸付金返還徴収登録 基本情報のコントローラークラスです。
 *
 * @author N8156 宮本 康
 */
public class KashitsukeHenkanKihon {

    private static final RString YML_KAIGO_KIHON = new RString("dbc1810000/KashitsukeHenkanKaigoKihon.yml");

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KashitsukeHenkanKihonDiv> onLoad(KashitsukeHenkanKihonDiv panel) {
        ResponseData<KashitsukeHenkanKihonDiv> response = new ResponseData<>();

        setKihonInfo(panel);

        response.data = panel;
        return response;
    }

    // Yamlデータを取得する
    private List<HashMap> getYamlData(RString yamlName) {
        return YamlLoader.DBC.loadAsList(yamlName);
    }

    // 基本情報を設定する
    private void setKihonInfo(KashitsukeHenkanKihonDiv panel) {
        ControlGenerator cg = new ControlGenerator(getYamlData(YML_KAIGO_KIHON).get(0));
        AtenaShokaiSimple.setData(panel.getKashitsukeHenkanKihonInfo().getAtenaInfo(), new ShikibetsuCode(cg.getAsRString("識別コード")));
        KaigoShikakuKihonDiv kaigoKihonDiv = panel.getKashitsukeHenkanKaigoKihonInfo();
        kaigoKihonDiv.getTxtHihokenshaNo().setValue(cg.getAsRString("被保番号"));
        kaigoKihonDiv.getTxtShikakuJotai().setValue(cg.getAsRString("資格状態"));
        kaigoKihonDiv.getTxtShutokuYmd().setValue(cg.getAsRDate("取得日"));
        kaigoKihonDiv.getTxtSoshitsuYmd().setValue(cg.getAsRDate("喪失日"));
        kaigoKihonDiv.getTxtShutokuJiyu().setValue(cg.getAsRString("取得事由"));
        kaigoKihonDiv.getTxtSoshitsuJiyu().setValue(cg.getAsRString("喪失事由"));
        kaigoKihonDiv.getTxtJutokuTekiyo().setValue(cg.getAsRDate("住特開始"));
        kaigoKihonDiv.getTxtJutokuKaijo().setValue(cg.getAsRDate("住特終了"));
        kaigoKihonDiv.getTxtYokaigoJotaiKubun().setValue(cg.getAsRString("要介護度"));
        kaigoKihonDiv.getTxtKyuSochiNyusho().setValue(cg.getAsRString("旧措置入所"));
        kaigoKihonDiv.getTxtNinteiKikan().setFromValue(cg.getAsRDate("認定開始日"));
        kaigoKihonDiv.getTxtNinteiKikan().setToValue(cg.getAsRDate("認定終了日"));
    }
}
