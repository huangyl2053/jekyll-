/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyogaikyochosa;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosahyogaikyochosa.ChosahyoGaikyochosaReportSource;

/**
 * 要介護認定調査票（概況調査）のEditorです。
 */
public class ChosahyoGaikyochosaEditorImpl implements IChosahyoGaikyochosaEditor {

    private final ChosahyoGaikyochosaItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosahyoGaikyochosaItem}
     */
    protected ChosahyoGaikyochosaEditorImpl(ChosahyoGaikyochosaItem item) {
        this.item = item;
    }

    /**
     * 要介護認定調査票（概況調査）を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public ChosahyoGaikyochosaReportSource edit(ChosahyoGaikyochosaReportSource source) {
        return editSource(source);
    }

    private ChosahyoGaikyochosaReportSource editSource(ChosahyoGaikyochosaReportSource source) {
        // TODO 内部QA:834 Redmine#78247 (複数のフォームを組み合わせて印刷することがわからません。)
        source.hokenshaNo1 = item.getHokenshaNo1();
        source.hokenshaNo2 = item.getHokenshaNo2();
        source.hokenshaNo3 = item.getHokenshaNo3();
        source.hokenshaNo4 = item.getHokenshaNo4();
        source.hokenshaNo5 = item.getHokenshaNo5();
        source.hokenshaNo6 = item.getHokenshaNo6();
        source.shinseiYY1 = item.getShinseiYY1();
        source.shinseiYY2 = item.getShinseiYY2();
        source.shinseiMM1 = item.getShinseiMM1();
        source.shinseiMM2 = item.getShinseiMM2();
        source.shinseiDD1 = item.getShinseiDD1();
        source.shinseiDD2 = item.getShinseiDD2();
        source.hishokenshaNo1 = item.getHishokenshaNo1();
        source.hishokenshaNo2 = item.getHishokenshaNo2();
        source.hishokenshaNo3 = item.getHishokenshaNo3();
        source.hishokenshaNo4 = item.getHishokenshaNo4();
        source.hishokenshaNo5 = item.getHishokenshaNo5();
        source.hishokenshaNo6 = item.getHishokenshaNo6();
        source.hishokenshaNo7 = item.getHishokenshaNo7();
        source.hishokenshaNo8 = item.getHishokenshaNo8();
        source.hishokenshaNo9 = item.getHishokenshaNo9();
        source.hishokenshaNo10 = item.getHishokenshaNo10();
        source.homonChosainNo1 = item.getHomonChosainNo1();
        source.homonChosainNo2 = item.getHomonChosainNo2();
        source.homonChosainNo3 = item.getHomonChosainNo3();
        source.homonChosainNo4 = item.getHomonChosainNo4();
        source.homonChosainNo5 = item.getHomonChosainNo5();
        source.homonChosainNo6 = item.getHomonChosainNo6();
        source.homonChosainNo7 = item.getHomonChosainNo7();
        source.homonChosainNo8 = item.getHomonChosainNo8();
        source.homonChosainName = item.getHomonChosainName();
        source.homonChosasakiNo1 = item.getHomonChosasakiNo1();
        source.homonChosasakiNo2 = item.getHomonChosasakiNo2();
        source.homonChosasakiNo3 = item.getHomonChosasakiNo3();
        source.homonChosasakiNo4 = item.getHomonChosasakiNo4();
        source.homonChosasakiNo5 = item.getHomonChosasakiNo5();
        source.homonChosasakiNo6 = item.getHomonChosasakiNo6();
        source.homonChosasakiNo7 = item.getHomonChosasakiNo7();
        source.homonChosasakiNo8 = item.getHomonChosasakiNo8();
        source.homonChosasakiNo9 = item.getHomonChosasakiNo9();
        source.homonChosasakiNo10 = item.getHomonChosasakiNo10();
        source.homonChosasakiNo11 = item.getHomonChosasakiNo11();
        source.homonChosasakiNo12 = item.getHomonChosasakiNo12();
        source.homonChosasakiName = item.getJigyoshaMeisho();
        source.shinseishaNameKana = item.getShinseishaNameKana();
        source.shinseishaName = item.getShinseishaName();
        source.seibetsuMan = item.getSeibetsuMan();
        source.seibetsuWoman = item.getSeibetsuWoman();
        source.shinseishaJusho = item.getShinseishaJusho();
        source.shinseishaYubinNo = item.getShinseishaYubinNo();
        source.shinseishTelNo = item.getShinseishTelNo();
        source.meiji = item.getMeiji();
        source.taisho = item.getTaisho();
        source.showa = item.getShowa();
        source.birthYY = item.getBirthYY();
        source.birthMM = item.getBirthMM();
        source.birthDD = item.getBirthDD();
        source.age = item.getAge();
        source.kazokuRenrakusakiJusho = item.getKazokuRenrakusakiJusho();
        source.kazokuRenrakusakiYubinNo = item.getKazokuRenrakusakiYubinNo();
        source.kazokuRenrakusakiTel1 = item.getKazokuRenrakusakiTel1();
        source.kazokuRenrakusakiTel2 = item.getKazokuRenrakusakiTel2();
        source.kazokuRenrakusakiName = item.getKazokuRenrakusakiName();
        source.shinseishatonoKankei = item.getShinseishatonoKankei();
        source.shokai = item.getShokai();
        source.nikaime = item.getNikaime();
        source.zenkaiNinteiYYYY = item.getZenkaiNinteiYYYY();
        source.zenkaiNinteiMM = item.getZenkaiNinteiMM();
        source.zenkaiNinteiDD = item.getZenkaiNinteiDD();
        source.higaito = item.getHigaito();
        source.yoshien = item.getYoshien();
        source.yoshiendo = item.getYoshiendo();
        source.yokaigo = item.getYokaigo();
        source.yokaigodo = item.getYokaigodo();
        return source;
    }
}
