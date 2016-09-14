/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1050021;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD206010.DBD206010_JigyoshoMukeShakaFukushiHojinKeigenTaishoshaIchiranHakkoParameter;
import jp.co.ndensan.reams.db.dbd.definition.core.shafugemmentaisyousyalist.JigyoshaSentaku;
import jp.co.ndensan.reams.db.dbd.definition.core.shafugemmentaisyousyalist.ShikakuSoshitsushaSentaku;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1050021.SFKTishoshaIchiranPanelBatchParameterDiv;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業所向け社会福祉法人軽減対象者一覧発行画面のHandlerです.
 *
 * @reamsid_L DBD-3810-010 xuejm
 */
public class SFKTishoshaIchiranPanelBatchParameterHandler {

    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private final SFKTishoshaIchiranPanelBatchParameterDiv div;

    /**
     * 事業所向け社会福祉法人軽減対象者一覧発行
     *
     * @param div SFKTishoshaIchiranPanelBatchParameterDiv
     */
    public SFKTishoshaIchiranPanelBatchParameterHandler(SFKTishoshaIchiranPanelBatchParameterDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * onLoad
     */
    public void onLoad() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString メニューID = controlData.getMenuID();
        RealInitialLocker.lock(new LockingKey(メニューID));
        div.getChutsutsuJoken().getRadShikakuSoshitsuChushutsu().setSelectedKey(KEY1);
        div.getChutsutsuJoken().getTxtKijunYMD().setValue(RDate.getNowDate());
        div.getChushutsuSetsumei().getCcdChohyoShutsuryokuJun().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200017.getReportId());
    }

    /**
     * バッチパラメータを設定します。
     *
     * @param div SFKTishoshaIchiranPanelBatchParameterDiv
     * @param parameter DBD206010_JigyoshoMukeShakaFukushiHojinKeigenTaishoshaIchiranHakkoParameter
     */
    public void onCilck_btnBatchRegister(SFKTishoshaIchiranPanelBatchParameterDiv div,
            DBD206010_JigyoshoMukeShakaFukushiHojinKeigenTaishoshaIchiranHakkoParameter parameter) {
        parameter.set基準日(new FlexibleDate(div.getChutsutsuJoken().getTxtKijunYMD().getValue().toDateString()));
        if (div.getChutsutsuJoken().getRadShikakuSoshitsuChushutsu().getSelectedKey().equals(KEY0)) {
            parameter.set資格喪失者選択(ShikakuSoshitsushaSentaku.出力する.getコード());
        } else {
            parameter.set資格喪失者選択(ShikakuSoshitsushaSentaku.出力しない.getコード());
        }
        if (div.getChutsutsuJoken().getRadJigyoshaSentaku().getSelectedKey().equals(KEY0)) {
            parameter.set事業者選択(JigyoshaSentaku.計画事業者とサービス事業者.getコード());
        } else if (div.getChutsutsuJoken().getRadJigyoshaSentaku().getSelectedKey().equals(KEY1)) {
            parameter.set事業者選択(JigyoshaSentaku.計画事業者.getコード());
        } else {
            parameter.set事業者選択(JigyoshaSentaku.サービス事業者.getコード());
        }
        parameter.set事業者番号(div.getChutsutsuJoken().getCcdShisetsuJohoCommonChildDiv().getNyuryokuShisetsuKodo());
        parameter.set事業者名(div.getChutsutsuJoken().getCcdShisetsuJohoCommonChildDiv().getNyuryokuShisetsuMeisho());
        parameter.set出力順ID(div.getChushutsuSetsumei().getCcdChohyoShutsuryokuJun().get出力順ID());
        parameter.set処理日時(YMDHMS.now());
    }
}
