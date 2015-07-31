/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1800000.KashitsukekinKihonDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 給付費貸付金申請登録 基本情報のコントローラークラスです。
 *
 * @author N8156 宮本 康
 */
public class KashitsukekinKihon {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KashitsukekinKihonDiv> onLoad(KashitsukekinKihonDiv panel) {
        setKihonInfo(panel);

        return ResponseData.of(panel).respond();
    }

    // 基本情報を設定する
    private void setKihonInfo(KashitsukekinKihonDiv panel) {
//        ControlGenerator cg = new ControlGenerator(getYamlData(YML_KAIGO_KIHON).get(0));
////        AtenaShokaiSimple.setData(panel.getKashitsukekinKihonInfo().getAtenaInfo(), new ShikibetsuCode(cg.getAsRString("識別コード")));
//        KaigoShikakuKihonDiv kaigoKihonDiv = panel.getKashitsukekinKaigoKihonInfo();
//        kaigoKihonDiv.getTxtHihokenshaNo().setValue(cg.getAsRString("被保番号"));
//        kaigoKihonDiv.getTxtShutokuYmd().setValue(cg.getAsFlexibleDate("取得日"));
//        kaigoKihonDiv.getTxtSoshitsuYmd().setValue(cg.getAsFlexibleDate("喪失日"));
//        kaigoKihonDiv.getTxtShutokuJiyu().setValue(cg.getAsRString("取得事由"));
//        kaigoKihonDiv.getTxtSoshitsuJiyu().setValue(cg.getAsRString("喪失事由"));
//        kaigoKihonDiv.getTxtJutokuKubun().setValue(cg.getAsRString("住特区分"));
//        kaigoKihonDiv.getTxtYokaigoJotaiKubun().setValue(cg.getAsRString("要介護度"));
//        kaigoKihonDiv.getTxtNinteiKaishiYmd().setValue(cg.getAsRDate("認定開始日"));
//        kaigoKihonDiv.getTxtNinteiShuryoYmd().setValue(cg.getAsRDate("認定終了日"));
    }
}
