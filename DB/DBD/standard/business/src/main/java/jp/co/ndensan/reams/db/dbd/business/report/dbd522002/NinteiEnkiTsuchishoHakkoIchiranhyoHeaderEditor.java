/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd522002;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.enkitsuchisho.EnkiTsuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd522002.NinteiEnkiTsuchishoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 要介護認定延期通知書発行一覧表HeaderEditorです。
 *
 * @reamsid_L DBD-1410-040 chenxin
 */
class NinteiEnkiTsuchishoHakkoIchiranhyoHeaderEditor implements INinteiEnkiTsuchishoHakkoIchiranhyoEditor {

    private final EnkiTsuchishoEntity entity;
    private static final RString タイトル = new RString("介護保険　認定延期通知書発行一覧表");
    private static final int INDEX_0 = 0;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_8 = 8;

    protected NinteiEnkiTsuchishoHakkoIchiranhyoHeaderEditor(EnkiTsuchishoEntity entity) {
        this.entity = entity;
    }

    /**
     * 要介護認定延期通知書発行一覧表のHeaderEditorです。
     *
     * @param source NinteiEnkiTsuchishoHakkoIchiranhyoReportSource
     * @return source NinteiEnkiTsuchishoHakkoIchiranhyoReportSource
     */
    @Override
    public NinteiEnkiTsuchishoHakkoIchiranhyoReportSource edit(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        editタイトル(source);
        edit作成日付(source);
        edit処理見込期間(source);
        edit通知書発行日(source);
        edit市町村コード(source);
        edit市町村名(source);
        return source;
    }

    private void editタイトル(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.title = タイトル;
    }

    private void edit作成日付(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        RTime time = RDate.getNowTime();
        RString hour = new RString(time.toString()).substring(INDEX_0, INDEX_2);
        RString min = new RString(time.toString()).substring(INDEX_3, INDEX_5);
        RString sec = new RString(time.toString()).substring(INDEX_6, INDEX_8);
        RString timeFormat = hour.concat("時").concat(min).concat("分").concat(sec).concat("秒");

        source.printTimeStamp = new RString(RDate.getNowDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString().toString() + RString.HALF_SPACE + timeFormat);
    }

    private void edit処理見込期間(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.shoriMikomiKigen = entity.get処理見込み日From() == null ? RString.EMPTY : entity.get処理見込み日From()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString()
                + " ～ "
                + entity.get処理見込み日To() == null ? RString.EMPTY : entity.get処理見込み日To()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

    }

    private void edit通知書発行日(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.tsuchishoHakkoYMD = entity.get通知書発行日() == null ? RString.EMPTY : entity.get通知書発行日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private void edit市町村コード(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.cityCode = entity.get市町村コード().code市町村RString();
    }

    private void edit市町村名(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.cityName = entity.get市町村名称();
    }
}
