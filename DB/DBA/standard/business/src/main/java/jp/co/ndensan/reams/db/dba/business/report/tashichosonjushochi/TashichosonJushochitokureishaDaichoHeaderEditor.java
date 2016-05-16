/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochi;

import jp.co.ndensan.reams.db.dba.entity.report.tashichosonjushochi.TashichosonJushochitokureishaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 他市町村住所地特例者台帳ヘッダEditorです。
 *
 * @reamsid_L DBA-0402-030 xuyannan
 */
public class TashichosonJushochitokureishaDaichoHeaderEditor implements ITashichosonJushochitokureishaDaichoEditor {

    private static final RString タイトル = new RString("他市町村住所地特例者台帳");
    private final TashichosonJushochitokureishaDaichoHeadItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link TashichosonJushochitokureishaDaichoHeadItem}
     */
    protected TashichosonJushochitokureishaDaichoHeaderEditor(TashichosonJushochitokureishaDaichoHeadItem item) {
        this.item = item;
    }

    /**
     * 帳票データの編集です。
     *
     * @param source 帳票用データ
     * @return TashichosonJushochitokureishaDaichoReportSource
     */
    @Override
    public TashichosonJushochitokureishaDaichoReportSource edit(TashichosonJushochitokureishaDaichoReportSource source) {
        return editHeader(source);
    }

    private TashichosonJushochitokureishaDaichoReportSource editHeader(TashichosonJushochitokureishaDaichoReportSource source) {
        source.printTimeStamp = item.getPrintTimeStamp();
        source.title = タイトル;
        source.shichosonCode = item.getShichosonCode();
        source.shichosonName = item.getShichosonName();
        source.birthYMD = item.getBirthYMD() == null
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(item.getBirthYMD()));
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
        source.telNo1 = item.getTelNo1();
        source.jusho1Title = item.getJusho1Title();
        source.telNo2 = item.getTelNo2();
        source.chiku3CodeTitle = item.getChiku3CodeTitle();
        source.chiku3Code = item.getChiku3Code();
        source.gyoseikuTitle = item.getGyoseikuTitle();
        source.jusho1Code = item.getJusho1Code();
        source.gyoseikuCode = item.getGyoseikuCode();
        source.maeJushoCode = item.getMaeJushoCode();
        source.jusho2 = item.getJusho2();
        source.tennyuYMD = item.getTennyuYMD() == null
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(item.getTennyuYMD()));
        source.jusho2Title = item.getJusho2Title();
        source.tenshutsuYMD = item.getTenshutsuYMD() == null
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(item.getTenshutsuYMD()));
        return source;
    }

    private RString 和暦年月日Fomart(FlexibleDate date) {
        return (date.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
    }
}
