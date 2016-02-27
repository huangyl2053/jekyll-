/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyufuhikashitsukekinshokankigen;

import jp.co.ndensan.reams.db.dba.entity.report.kyufuhikashitsukekinshokankigen.KyufuKashitsukekinShokanKigenEnchoShinseishoReportSource;

/**
 * 護保険給付費貸付金償還期限延長申請書エディターです。
 *
 */
public class KyufuhiKashitsukekinShokankigenEnchoShinseishoEditorImpl implements IKyufuhiKashitsukekinShokankigenEnchoShinseishoEditor {

    private final KyufuhiKashitsukekinShokankigenEnchoShinseishoItem item;

    /**
     * コンストラクタです。
     *
     * @param item KyufuhiKashitsukekinShokankigenEnchoShinseishoItem
     */
    public KyufuhiKashitsukekinShokankigenEnchoShinseishoEditorImpl(KyufuhiKashitsukekinShokankigenEnchoShinseishoItem item) {
        this.item = item;
    }

    /**
     * 介護保険給付費貸付金償還期限延長申請書エディターです。
     *
     * @param source 介護保険給付費貸付金償還期限延長申請書
     * @return KyufuKashitsukekinShokanKigenEnchoShinseishoReportSource
     */
    @Override
    public KyufuKashitsukekinShokanKigenEnchoShinseishoReportSource edit(KyufuKashitsukekinShokanKigenEnchoShinseishoReportSource source) {
        return editBody(source);
    }

    private KyufuKashitsukekinShokanKigenEnchoShinseishoReportSource editBody(KyufuKashitsukekinShokanKigenEnchoShinseishoReportSource source) {
        source.tsuchiBun = item.getTsuchiBun();
        source.kashitsukeNo = item.getKashitsukeNo();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.hihokenshaName = item.getHihokenshaName();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        return source;
    }
}
