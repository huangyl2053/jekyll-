/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tekiyojogaishadaicho;

import jp.co.ndensan.reams.db.dba.entity.report.tekiyojogaishadaicho.TekiyojogaishaDaichoReportSource;

/**
 * 適用除外者台帳Editorです。
 *
 * @reamsid_L DBA-0412-040 lishengli
 */
class TekiyojogaishaDaichoEditor implements ITekiyojogaishaDaichoEditor {

    private final TekiyojogaishaDaichoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link TekiyojogaishaDaichoItem}
     */
    protected TekiyojogaishaDaichoEditor(TekiyojogaishaDaichoItem item) {
        this.item = item;
    }

    /**
     * 適用除外者台帳ボディEditorです。
     *
     * @param source 適用除外者台帳Source
     * @return 適用除外者台帳Source
     */
    @Override
    public TekiyojogaishaDaichoReportSource edit(TekiyojogaishaDaichoReportSource source) {
        return editBody(source);
    }

    private TekiyojogaishaDaichoReportSource editBody(TekiyojogaishaDaichoReportSource source) {
        source.printTimeStamp = item.getPrintTimeStamp();
        source.title = item.getTitle();
        source.shichosonCode = item.getShichosonCode();
        source.shichosonName = item.getShichosonName();
        source.birthYMD = item.getBirthYMD();
        source.seibetsu = item.getSeibetsu();
        source.setaiCode = item.getSetaiCode();
        source.shikibetsuCode = item.getShikibetsuCode();
        source.shimeiKana = item.getShimeiKana();
        source.chiku1CodeTitle = item.getChiku1CodeTitle();
        source.chiku1Code = item.getChiku1Code();
        source.shimei = item.getShimei();
        source.jotai = item.getJotai();
        source.telNoTitle = item.getTelNoTitle();
        source.chiku2CodeTitle = item.getChiku2CodeTitle();
        source.chiku2Code = item.getChiku2Code();
        source.jusho1 = item.getJusho1();
        source.jusho1Title = item.getJusho1Title();
        source.telNo1 = item.getTelNo1();
        source.telNo2 = item.getTelNo2();
        source.chiku3CodeTitle = item.getChiku3CodeTitle();
        source.chiku3Code = item.getChiku3Code();
        source.jusho1Code = item.getJusho1Code();
        source.gyoseikuTitle = item.getGyoseikuTitle();
        source.gyoseikuCode = item.getGyoseikuCode();
        source.jusho2 = item.getJusho2();
        source.jusho2Title = item.getJusho2Title();
        source.jusho2Code = item.getJusho2Code();
        source.listNo_1 = item.getListNo_1();
        source.listUpper_1 = item.getListUpper_1();
        source.listUpper_2 = item.getListUpper_2();
        source.listUpper_3 = item.getListUpper_3();
        source.listUpper_4 = item.getListUpper_4();
        source.listUpper_5 = item.getListUpper_5();
        source.listUpper_6 = item.getListUpper_6();
        source.listUpper_7 = item.getListUpper_7();
        source.listLower_1 = item.getListLower_1();
        source.listLower_2 = item.getListLower_2();
        source.listLower_3 = item.getListLower_3();
        source.listLower_4 = item.getListLower_4();
        source.listLower_5 = item.getListLower_5();
        source.listLower_6 = item.getListLower_6();
        source.listLower_7 = item.getListLower_7();
        return source;
    }
}
