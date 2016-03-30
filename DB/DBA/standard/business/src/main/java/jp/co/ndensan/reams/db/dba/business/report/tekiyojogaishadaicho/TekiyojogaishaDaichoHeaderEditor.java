/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tekiyojogaishadaicho;

import jp.co.ndensan.reams.db.dba.entity.report.source.tekiyojogaishadaicho.TekiyojogaishaDaichoReportSource;

/**
 *
 * 適用除外者台帳ヘッダEditorです。
 */
class TekiyojogaishaDaichoHeaderEditor implements ITekiyojogaishaDaichoEditor {

    private final TekiyojogaishaDaichoHeadItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link TekiyojogaishaDaichoHeadItem}
     */
    protected TekiyojogaishaDaichoHeaderEditor(TekiyojogaishaDaichoHeadItem item) {
        this.item = item;
    }

    @Override
    public TekiyojogaishaDaichoReportSource edit(TekiyojogaishaDaichoReportSource source) {
        return editHeader(source);
    }

    private TekiyojogaishaDaichoReportSource editHeader(TekiyojogaishaDaichoReportSource source) {

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
        return source;
    }
}
