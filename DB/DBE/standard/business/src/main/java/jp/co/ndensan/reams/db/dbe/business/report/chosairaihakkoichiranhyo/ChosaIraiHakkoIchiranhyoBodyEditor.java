/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaihakkoichiranhyo.ChosaIraiHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 認定調査依頼発行一覧表ディEditorです。
 */
class ChosaIraiHakkoIchiranhyoBodyEditor implements ChosaIraiHakkoIchiranhyoEditor {

    private static final RString IRAINICHI = new RString("依頼日");
    private final ChosaIraiHakkoIchiranhyoBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosaIraiHakkoIchiranhyoItem}
     */
    protected ChosaIraiHakkoIchiranhyoBodyEditor(ChosaIraiHakkoIchiranhyoBodyItem item) {
        this.item = item;
    }

    @Override
    public ChosaIraiHakkoIchiranhyoReportSource edit(ChosaIraiHakkoIchiranhyoReportSource source) {
        return editBody(source);
    }

    private ChosaIraiHakkoIchiranhyoReportSource editBody(ChosaIraiHakkoIchiranhyoReportSource source) {
        source.joken4 = item.get依頼書作成日() == null ? RString.EMPTY : new FlexibleDate(item.get依頼書作成日()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
        source.joken5 = item.get依頼書提出期限() == null ? RString.EMPTY : new FlexibleDate(item.get依頼書提出期限()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
        source.cityCode = item.get市町村コード();
        source.cityName = item.get市町村名称();
        source.headerHizukeKosho = IRAINICHI;
        source.listHakkoIchiranhyo_1 = new RString(String.valueOf(item.getRenban()));
        source.listHakkoIchiranhyo_2 = item.get被保険者番号();
        source.listHakkoIchiranhyo_3 = item.get被保険者氏名();
        source.listHakkoIchiranhyo_4 = item.get依頼日() == null ? RString.EMPTY : new FlexibleDate(item.get依頼日()).wareki().toDateString();
        source.listHakkoIchiranhyo_5 = item.get委託先名();
        source.listHakkoIchiranhyo_6 = item.get代表者名();
        source.listHakkoIchiranhyo_7 = item.get連絡先();
        source.listHakkoIchiranhyo_8 = item.get調査員名();
        source.listHakkoIchiranhyo_9 = RString.EMPTY;
        source.listHakkoIchiranhyo_10 = RString.EMPTY;
        return source;
    }
}
