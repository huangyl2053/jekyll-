/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1010031;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010031.FutangendogakuShoninMainDiv;
import jp.co.ndensan.reams.db.dbx.business.config.jukyu.gemmenkigen.GemmenNendoResearcher;
import jp.co.ndensan.reams.db.dbx.business.config.jukyu.gemmenkigen.INendo;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.YmdKubun;

/**
 * 負担限度額認定申請承認（一括）のHandlerです
 *
 * @reamsid_L DBD-3710-010 xuejm
 */
public class FutangendogakuShoninMainHandler {

    private final FutangendogakuShoninMainDiv div;
    private static final int NO_0 = 0;
    private static final int NO_4 = 4;

    /**
     * 負担限度額認定申請承認（一括）コンストラクタです。
     *
     * @param div FutangendogakuShoninMainDiv
     */
    public FutangendogakuShoninMainHandler(FutangendogakuShoninMainDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     */
    public void onLoad() {
        div.getTxtSakuseiNendo().setYmdKubunEnum(YmdKubun.年);
        div.getShinseiPrint().getTxtHakkoYMD().setValue(new FlexibleDate(RDate.getNowDate().toDateString()));
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200005.getReportId());
    }

    /**
     * 負担限度額認定申請承認（一括）の「作成年度」が フォーカスアウト。
     *
     */
    public void onChange_futansakuseiNendo() {
        FlexibleYear sakuseinendo = FlexibleYear.EMPTY;
        if (div.getFutangendogakuShonin().getTxtSakuseiNendo().getValue() != null) {
            sakuseinendo = new FlexibleYear(div.getFutangendogakuShonin().getTxtSakuseiNendo().getValue().toString()
                    .substring(NO_0, NO_4));
        }
        if (sakuseinendo != null) {
            INendo getnendo = GemmenNendoResearcher.createInstance(GemmenGengakuShurui.負担限度額認定).find年度(sakuseinendo);
            div.getFutangendogakuShonin().getTxtChoteiKikan().setFromValue(new RDate(getnendo.get開始日().toString()));
            div.getFutangendogakuShonin().getTxtChoteiKikan().setToValue(new RDate(getnendo.get終了日().toString()));
        }
    }
}
