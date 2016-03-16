/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoReportSource;

/**
 * 主治医意見書作成依頼一覧Editorです。
 */
public class IkenshoSakuseiIraiIchiranhyoHeadEditor implements IkenshoSakuseiIraiIchiranhyoEditor {

    private final IkenshoSakuseiIraiIchiranhyoHeadItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link IkenshoSakuseiIraiIchiranhyoHeadEditor}
     */
    protected IkenshoSakuseiIraiIchiranhyoHeadEditor(IkenshoSakuseiIraiIchiranhyoHeadItem item) {
        this.item = item;
    }

    @Override
    public IkenshoSakuseiIraiIchiranhyoReportSource edit(IkenshoSakuseiIraiIchiranhyoReportSource source) {
        return editSource(source);
    }

    private IkenshoSakuseiIraiIchiranhyoReportSource editSource(IkenshoSakuseiIraiIchiranhyoReportSource source) {
        source.hakkoYMD = item.getHakkoYMD();
        source.denshiKoin = item.getDenshiKoin();
        source.ninshoshaYakushokuMei1 = item.getNinshoshaYakushokuMei1();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.ninshoshaYakushokuMei2 = item.getNinshoshaYakushokuMei2();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.koinShoryaku = item.getKoinShoryaku();
        source.yubinNo1 = item.getYubinNo1();
        source.jushoText = item.getJushoText();
        source.kikanNameText = item.getKikanNameText();
        source.shimeiText = item.getShimeiText();
        source.meishoFuyo = item.getMeishoFuyo();
        source.printTimeStamp = item.getPrintTimeStamp();
        source.tsuchibun1 = item.getTsuchibun1();
        return source;
    }
}
