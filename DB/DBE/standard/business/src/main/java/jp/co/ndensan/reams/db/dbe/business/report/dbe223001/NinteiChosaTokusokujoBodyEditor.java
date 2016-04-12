/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.dbe223001;

import jp.co.ndensan.reams.db.dbe.entity.report.dbe223001.NinteiChosaTokusokujoReportSource;

/**
 * 要介護認定調査督促状のEditorです。
 *
 * @reamsid_L DBE-0030-020 xuyue
 */
public class NinteiChosaTokusokujoBodyEditor implements INinteiChosaTokusokujoEditor {

    private final NinteiChosaTokusokujoBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link NinteiChosaTokusokujoBodyEditor}
     */
    protected NinteiChosaTokusokujoBodyEditor(NinteiChosaTokusokujoBodyItem item) {
        this.item = item;
    }

    @Override
    public NinteiChosaTokusokujoReportSource edit(NinteiChosaTokusokujoReportSource source) {
        return editBody(source);
    }

    private NinteiChosaTokusokujoReportSource editBody(NinteiChosaTokusokujoReportSource source) {

        source.hakkoYMD1 = item.getHakkoYMD();
        source.denshiKoin = item.getDenshiKoin();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.koinShoryaku = item.getKoinShoryaku();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.ninshoshaYakushokuMei1 = item.getNinshoshaYakushokuMei1();
        source.ninshoshaYakushokuMei2 = item.getNinshoshaYakushokuMei2();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.bunshoNo = item.getBunshoNo();
        source.tsuchibun1 = item.getTsuchibun1();
        source.shinseiKubun = item.getShinseiKubun();
        source.hokenshaNo1 = item.getHokenshaNo1();
        source.hokenshaNo2 = item.getHokenshaNo2();
        source.hokenshaNo3 = item.getHokenshaNo3();
        source.hokenshaNo4 = item.getHokenshaNo4();
        source.hokenshaNo5 = item.getHokenshaNo5();
        source.hokenshaNo6 = item.getHokenshaNo6();
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
        source.shinseiYMD = item.getShinseiYMD();
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
        source.yubinNo1 = item.getYubinNo1();
        source.jushoText = item.getJushoText();
        source.kikanNameText = item.getKikanNameText();
        source.shimeiText = item.getShimeiText();
        source.meishoFuyo = item.getMeishoFuyo();
        source.customerBarCode = item.getCustomerBarCode();
        source.sonota = item.getSonota();
        source.title = item.getTitle();
        return source;
    }

}
