/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.kaigohokenshindanmeireisho;

import jp.co.ndensan.reams.db.dbz.entity.report.source.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoReportSource;


/**
 * 介護保険指定医依頼兼主治医意見書提出依頼書Editorです。
 *
 * @reamsid_L DBE-0080-080 duanzhanli
 */
class ShujiiIkenshoTeishutsuIraishoEditor implements IShujiiIkenshoTeishutsuIraishoEditor {

    private final ShujiiIkenshoTeishutsuIraishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShujiiIkenshoTeishutsuIraishoItem}
     */
    protected ShujiiIkenshoTeishutsuIraishoEditor(ShujiiIkenshoTeishutsuIraishoItem item) {
        this.item = item;
    }

    /**
     * @param source 介護保険指定医依頼兼主治医意見書提出依頼書のReportSource
     * @return ShujiiIkenshoTeishutsuIraishoReportSource
     */
    @Override
    public ShujiiIkenshoTeishutsuIraishoReportSource edit(ShujiiIkenshoTeishutsuIraishoReportSource source) {
        source.hakkoYMD1 = item.getHakkoYMD1();
        source.denshiKoin = item.getDenshiKoin();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.ninshoshaYakushokuMei2 = item.getNinshoshaYakushokuMei2();
        source.ninshoshaYakushokuMei1 = item.getNinshoshaYakushokuMei1();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.koinShoryaku = item.getKoinShoryaku();
        source.bunshoNo = item.getBunshoNo();
        source.yubinNo1 = item.getYubinNo1();
        source.jushoText = item.getJushoText();
        source.kikanNameText = item.getKikanNameText();
        source.shimeiText = item.getShimeiText();
        source.meishoFuyo = item.getMeishoFuyo();
        source.customerBarCode = item.getCustomerBarCode();
        source.sonota = item.getSonota();
        source.title = item.getTitle();
        source.tsuchibun1 = item.getTsuchibun1();
        source.hihokenshaNo1 = item.getHihokenshaNo1();
        source.hihokenshaNo2 = item.getHihokenshaNo2();
        source.hihokenshaNo3 = item.getHihokenshaNo3();
        source.hihokenshaNo4 = item.getHihokenshaNo4();
        source.hihokenshaNo5 = item.getHihokenshaNo5();
        source.hihokenshaNo6 = item.getHihokenshaNo6();
        source.hihokenshaNo7 = item.getHihokenshaNo7();
        source.hihokenshaNo8 = item.getHihokenshaNo8();
        source.hihokenshaNo9 = item.getHihokenshaNo9();
        source.hihokenshaNo10 = item.getHihokenshaNo10();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.seibetsuMan = item.getSeibetsuMan();
        source.seibetsuWoman = item.getSeibetsuWoman();
        source.hihokenshaName = item.getHihokenshaName();
        source.birthGengoMeiji = item.getBirthGengoMeiji();
        source.birthGengoTaisho = item.getBirthGengoTaisho();
        source.birthGengoShowa = item.getBirthGengoShowa();
        source.birthYMD = item.getBirthYMD();
        source.yubinNo = item.getYubinNo();
        source.jusho = item.getJusho();
        source.tsuchibun2 = item.getTsuchibun2();

        return source;
    }
}
