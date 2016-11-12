/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1020021;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020021.RiyoshaFutanGenmenListDiv;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用者負担額減免認定者リスト画面のHandlerです。
 *
 * @reamsid_L DBD-3980-010 xuejm
 */
public class RiyoshaFutanGenmenListHandler {

    private final RiyoshaFutanGenmenListDiv div;
    private static final RString 該当者リスト = new RString("gaitosha");

    /**
     * 利用者負担額減免認定者リストコンストラクタです。
     *
     * @param div RiyoshaFutanGenmenListDiv
     */
    public RiyoshaFutanGenmenListHandler(RiyoshaFutanGenmenListDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     */
    public void onLoad() {
        div.getCcdChohyoShuturyokujun().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200002.getReportId());
        div.getTxtKijunYMD().setValue(RDate.getNowDate());
        div.getTxtShotokuNendo().setValue(RDate.getNowDate());
        if (div.getRadTaishoList().getSelectedKey().equals(該当者リスト)) {
            div.getRadJukyushaKubun().setDisplayNone(false);
            div.getChkShoriTaisho().setDisplayNone(false);
        }
    }

    /**
     * 「該当者リスト」と「認定者リスト」ラジオを操作です。
     *
     */
    public void radTaishoList_onChange() {
        if (div.getRadTaishoList().getSelectedKey().equals(該当者リスト)) {
            div.getRadJukyushaKubun().setDisplayNone(false);
            div.getChkShoriTaisho().setDisplayNone(false);
        } else {
            div.getRadJukyushaKubun().setDisplayNone(true);
            div.getChkShoriTaisho().setDisplayNone(true);
        }
    }
}
