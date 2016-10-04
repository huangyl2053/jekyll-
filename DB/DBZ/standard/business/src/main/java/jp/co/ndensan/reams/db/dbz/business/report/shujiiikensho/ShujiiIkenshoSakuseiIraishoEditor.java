/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.shujiiikensho;

import jp.co.ndensan.reams.db.dbz.entity.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoReportSource;

/**
 * 主治医意見書作成依頼書Editorです。
 *
 * @reamsid_L DBE-0050-020 sunhaidi
 */
public class ShujiiIkenshoSakuseiIraishoEditor implements IShujiiIkenshoSakuseiIraishoEditor {

    private final ShujiiIkenshoSakuseiIraishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShujiiIkenshoSakuseiIraishoItem}
     */
    protected ShujiiIkenshoSakuseiIraishoEditor(ShujiiIkenshoSakuseiIraishoItem item) {
        this.item = item;
    }

    /**
     * 主治医意見書作成依頼書編集処理です。
     *
     * @param source 主治医意見書作成依頼書Sourceクラス
     * @return ShujiiIkenshoSakuseiIraishoReportSource 主治医意見書作成依頼書Sourceクラス
     */
    @Override
    public ShujiiIkenshoSakuseiIraishoReportSource edit(ShujiiIkenshoSakuseiIraishoReportSource source) {
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
        source.atenaRenban = item.getAtenaRenban();
        source.title = item.getTitle();
        source.tsuchibun1 = item.getTsuchibun1();
        source.shinseiKubun = item.getShinseiKubun();
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
        source.hokenshaNo1 = item.getHokenshaNo1();
        source.hokenshaNo2 = item.getHokenshaNo2();
        source.hokenshaNo3 = item.getHokenshaNo3();
        source.hokenshaNo4 = item.getHokenshaNo4();
        source.hokenshaNo5 = item.getHokenshaNo5();
        source.hokenshaNo6 = item.getHokenshaNo6();
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
        source.shinseiYMD = item.getShinseiYMD();
        source.teishutsuKigen = item.getTeishutsuKigen();
        source.tsuchibun2 = item.getTsuchibun2();
        source.remban = item.getRemban();
        source.shoriName = item.getShoriName();
        return source;
    }
}
